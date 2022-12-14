package com.hisun.kont.pg.service.impl;

import com.alibaba.fastjson.JSON;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.DateTimeUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.igw.remote.LongIncomeMsgFetchRspDTO;
import com.hisun.kont.job.remote.JobcancelDTO;
import com.hisun.kont.job.utils.JobSendUtils;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.constants.MtTypeConstants;
import com.hisun.kont.pg.dao.PgMatchDao;
import com.hisun.kont.pg.dao.PgSrcSwitchDao;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.entity.PgSrcSwitchDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.mt.remote.EaiHeaderDTO;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.pg.mt.remote.RmcTrx04;
import com.hisun.kont.bocpays.remote.RspHead;
import com.hisun.kont.pg.service.DismantleMTService;
import com.hisun.kont.pg.service.ListenRmcService;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.service.SendService;
import com.hisun.kont.pg.utils.TeleCh650Util;
import com.hisun.kont.pyrm.client.FeeCollectCommissionServiceClient;
import com.hisun.kont.pyrm.client.InwardInterFaceServiceClient;
import com.hisun.kont.pyrm.client.OutwardRemtCommServiceClient;
import com.hisun.kont.pyrm.client.ReturnMessageServiceClient;
import com.hisun.kont.pyrm.ir.remote.*;
import com.hisun.kont.pyrm.or.remote.CommNobodyRspDTO;
import com.hisun.kont.pyrm.or.remote.UpdateMastBySendReportReReqDTO;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.utils.MTMsgUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yu Ha Ha
 * @ClassName: ListenRmcServiceImpl
 * @Date 2021/6/21 9:54
 * @Description: ?????? rmc
 * @Version 1.0
 **/
@Service
public class ListenRmcServiceImpl implements ListenRmcService {

    @Resource
    private DismantleMTService dismantleMTService;

    @Resource
    private CallRmcServiceImpl callRmcService;

    @Resource
    private PgstsService pgstsService;

    @Resource
    private SendService sendService;

    @Resource
    private ReturnMessageServiceClient returnMessageServiceClient;

    @Resource
    private OutwardRemtCommServiceClient commServiceClient;

    @Resource
    private PgSrcSwitchDao pgSrcSwitchDao;

    @Resource
    private PgstsDao pgstsDao;

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    MTAssemblyServiceImpl mtAssemblyService;

    @Resource
    private PgMatchDao pgMatchDao;

    @Resource
    private InwardInterFaceServiceClient inwardInterFaceServiceClient;

    @Resource
    private FeeCollectCommissionServiceClient feeCollectCommissionServiceClient;

    private static final Logger logger = LoggerFactory.getLogger(ListenRmcServiceImpl.class);

    /**
     * ????????????
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<ReceiveRemitMsgRspDTO> receiveRemitMessage(GenericDTO<ReceiveRemitMsgReqDTO> reqDto) {
        logger.info("##### PG 23390 RECEIVE MT MESSAGE BY RMC #####");
        ReceiveRemitMsgReqDTO receiveRemitMessageReqDTO = reqDto.getBody();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        RspHead rspHead = new RspHead();
        GenericRspDTO<ReceiveRemitMsgRspDTO> rspDTO = new GenericRspDTO();
        // ??????????????????????????????
        String srcBk = String.format("%03d", receiveRemitMessageReqDTO.getSrcBk());
        String srcDt = receiveRemitMessageReqDTO.getSrcDt().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String srcSeq = receiveRemitMessageReqDTO.getSrcSeq().trim();
        logger.info("##### RECEIVE MESSAGE NUMBER:{}",srcBk+srcDt+srcSeq);
        /** ??????????????????????????? */
        ReceiveRemitMsgRspDTO receiveRemitMsgRspDTO = new ReceiveRemitMsgRspDTO();
        BeanUtils.copyProperties(receiveRemitMessageReqDTO, receiveRemitMsgRspDTO);
        receiveRemitMsgRspDTO.setId22(srcBk + srcDt + srcSeq);
        /** ???????????????????????? */
        Integer mtType = receiveRemitMessageReqDTO.getMt();
        String mtMsg = receiveRemitMessageReqDTO.getSwiftInfo();
        /** ????????????????????????????????????????????????????????????????????? rmc info ???????????? */
        // ?????? rmc info
        RmcTrx04 rmcTrx04 = new RmcTrx04();
        BeanUtils.copyProperties(receiveRemitMessageReqDTO, rmcTrx04);
        // ?????? eai header
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        BeanUtils.copyProperties(receiveRemitMessageReqDTO, eaiHeaderDTO);
        //?????????????????????????????????
        PgSrcSwitchDO pgSrcSwitchDO = new PgSrcSwitchDO();
        //??????pgsts??????
        PgstsDO pgstsDO = new PgstsDO();
        //MT103+
        if (mtType == 103) {
            logger.info("##### READ MT103 SWITCH TABLE DATA #####");
            pgSrcSwitchDO.setSrcSwType("MT103 / 103+");
            PgSrcSwitchDO srcSwitchDO = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            //???????????????????????????????????????PAS601  ????????????????????????????????????
            if (JudgeUtils.isNull(srcSwitchDO)) {
                logger.error("##### MT103 SWITCH TABLE DATA IS NULL #####");
                receiveRemitMsgRspDTO.setErrCd(10);
                rspDTO.setMsgCd("RPS601");
                rspHead.setTxnErrCd("RPS601");
                receiveRemitMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            } else {
                if ("C".equals(srcSwitchDO.getSrcSwStatus()) && (!"23993".equals(reqHead.getTxnCode()) && !"23994".equals(reqHead.getTxnCode()))) {
                    logger.error("##### MT103 SWITCH TABLE CLOSES THIS TYPE OF MESSAGE #####");
                    receiveRemitMsgRspDTO.setErrCd(10);
                    rspDTO.setMsgCd("RPS540");
                    rspHead.setTxnErrCd("RPS540");
                    receiveRemitMsgRspDTO.setRspHead(rspHead);
                    rspDTO.setBody(receiveRemitMsgRspDTO);
                    return rspDTO;
                }
            }
        }
        //MT200+
        if (mtType == 200 || mtType == 202) {
            logger.info("##### READ MT202/200 SWITCH TABLE DATA #####");
            pgSrcSwitchDO.setSrcSwType("MT202 / 200");
            PgSrcSwitchDO srcSwitchDO = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            if (JudgeUtils.isNull(srcSwitchDO)) {
                logger.info("##### MT202/200 SWITCH TABLE DATA IS NULL #####");
                receiveRemitMsgRspDTO.setErrCd(10);
                rspDTO.setMsgCd("RPS601");
                rspHead.setTxnErrCd("RPS601");
                receiveRemitMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            } else {
                if ("C".equals(srcSwitchDO.getSrcSwStatus()) && (!"23993".equals(reqHead.getTxnCode()) && !"23994".equals(reqHead.getTxnCode()))) {
                    logger.info("##### MT202/200 SWITCH TABLE CLOSES THIS TYPE OF MESSAGE #####");
                    receiveRemitMsgRspDTO.setErrCd(10);
                    rspDTO.setMsgCd("RPS540");
                    rspHead.setTxnErrCd("RPS540");
                    receiveRemitMsgRspDTO.setRspHead(rspHead);
                    rspDTO.setBody(receiveRemitMsgRspDTO);
                    return rspDTO;
                }
            }
        }
        // ????????????????????????
        if (JudgeUtils.isNull(receiveRemitMessageReqDTO.getMsgLen())) {
            receiveRemitMessageReqDTO.setMsgLen(mtMsg.length());
        }
        if ("L".equals(receiveRemitMessageReqDTO.getMsgFg())) {
            // ???????????????????????????
            logger.info("##### LONG MESSAGE CHECK #####");
            LongIncomeMsgFetchReqPGDTO longIncomeMsgFetchReqPGDTO = new LongIncomeMsgFetchReqPGDTO();
            longIncomeMsgFetchReqPGDTO.setSrcBk(srcBk);
            longIncomeMsgFetchReqPGDTO.setSrcDate(srcDt);
            longIncomeMsgFetchReqPGDTO.setSrcSeq(srcSeq);
            longIncomeMsgFetchReqPGDTO.setSrcAppl("RPS");
            longIncomeMsgFetchReqPGDTO.setResndInd("0");
            longIncomeMsgFetchReqPGDTO.setToSys("RMC");
            longIncomeMsgFetchReqPGDTO.setErrCode("00");
            longIncomeMsgFetchReqPGDTO.setReqHead(receiveRemitMessageReqDTO.getReqHead());
            longIncomeMsgFetchReqPGDTO.getReqHead().setTxnCode("23390");
            longIncomeMsgFetchReqPGDTO.getReqHead().setSrcAppId("RPS");
            longIncomeMsgFetchReqPGDTO.getReqHead().setTarAppId("RMC");
            GenericDTO<LongIncomeMsgFetchReqPGDTO> longReqDTO = new GenericDTO<>();
            longReqDTO.setBody(longIncomeMsgFetchReqPGDTO);
            GenericRspDTO<LongIncomeMsgFetchRspDTO> longRspDTO = new GenericRspDTO<>();
            longRspDTO = callRmcService.longIncomeMsgFetchPG(longReqDTO);
            //????????????????????????????????? ???????????????PAS378
            if (longRspDTO == null || JudgeUtils.isNotSuccess(longRspDTO.getMsgCd())) {
                if (JudgeUtils.isNotNull(longRspDTO)){
                    logger.error("##### EXCEPTION IN CALLING LONG MESSAGE INTERFACE,MSG CODE:{}",longRspDTO.getMsgCd());
                }else {
                    logger.error("##### EXCEPTION IN CALLING LONG MESSAGE INTERFACE,RETURN IS NULL #####");
                }
                receiveRemitMsgRspDTO.setErrCd(30);
                rspDTO.setMsgCd("RPS378");
                rspHead.setTxnErrCd("RPS378");
                receiveRemitMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            }
            LongIncomeMsgFetchRspDTO longIncomeMsgFetchRspDTO = JudgeUtils.isNotNull(longRspDTO) ? longRspDTO.getBody() : null;
            mtMsg = JudgeUtils.isNotNull(longIncomeMsgFetchRspDTO) ? longIncomeMsgFetchRspDTO.getSwiftInfo() : null;
            String sub = mtMsg.substring(mtMsg.indexOf("{3:"), mtMsg.indexOf("{4:"));
            //??????????????????  ???????????????????????????202COV??????499
            if (mtType.equals(499)){
                pgstsDO.setMtStr(mtMsg);
            }else if (mtType.equals(202) && sub.contains("{119:COV}")){
                pgstsDO.setMtStr(mtMsg);
            }else {
                logger.error("##### LONG MESSAGE TYPE ERROR:{}, MSG NO:{}",mtType,srcBk + srcDt + srcSeq);
                receiveRemitMsgRspDTO.setErrCd(20);
                rspDTO.setMsgCd("RPS321");
                rspHead.setTxnErrCd("RPS321");
                receiveRemitMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            }
        }

        //??????GPI????????????????????????????????????(??????????????????)  ???????????????GPI??????
        if ("C".equals(receiveRemitMessageReqDTO.getMsgSrc()) || "D".equals(receiveRemitMessageReqDTO.getMsgSrc())
                || "E".equals(receiveRemitMessageReqDTO.getMsgSrc())) {
            if ("Y".equals(receiveRemitMessageReqDTO.getGpiFg())) {
                pgstsDO.setGpiFlag("N");
                pgstsDO.setMsgSrc(receiveRemitMessageReqDTO.getMsgSrc());
                receiveRemitMessageReqDTO.setGpiFg("N");
            }
        }
        //??????RMC?????????????????????202  ?????????????????????202  ?????????PAS321
        if (mtType.equals(202)) {
            logger.info("##### START MT202 SPECIAL TREATMENT #####");
            mtMsg = receiveRemitMessageReqDTO.getSwiftInfo();
            String sub = mtMsg.substring(mtMsg.indexOf("{2:") + 4, mtMsg.indexOf("{2:") + 7);
            if (!"202".equals(sub)) {
                logger.error("##### MT202 HEADER FORMAT IS ERROR:{} ,MSG NO:{}",sub,srcBk + srcDt + srcSeq);
                receiveRemitMsgRspDTO.setErrCd(20);
                rspDTO.setMsgCd("RPS321");
                rspHead.setTxnErrCd("RPS321");
                receiveRemitMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            } else {
                //???????????????202  ??????????????????MT202Cov????????????  ????????????SEQ B?????????MT202??????
                logger.info("##### START REMOVE 202COV SEQUENCE B #####");
                String substring = mtMsg.substring(mtMsg.indexOf("{4:") + 3);
                String messageBody = substring.substring(0, substring.indexOf("-}"));
                ArrayList<Map.Entry<String, String>> tagList = TeleCh650Util.parserDataToKeyList(messageBody);
                StringBuffer tagStr = new StringBuffer();
                for (int i = 0; i < tagList.size(); i++) {
                    String k = tagList.get(i).getKey();
                    if (k.equals("50A") || k.equals("50K") || k.equals("50F")) {
                        break;
                    }
                    String value = tagList.get(i).getValue();
                    //????????????
                    tagStr.append(":").append(k).append(":").append(value);
                }
                String subSwHeader = mtMsg.substring(0, mtMsg.indexOf("{4:") + 3);
                String tailHeader = substring.substring(substring.indexOf("-}"));
                String tagString = tagStr.toString();
                mtMsg = subSwHeader + "\n" + tagString + tailHeader;
                logger.info("##### REMOVE 202COV SEQUENCE B SUCCESS #####");
            }
        }
        //??????????????????
        String msgNo = srcBk + srcDt + srcSeq;
        pgstsDO.setMsgNo(msgNo.trim());
        String manualFg = srcSeq.trim().substring(0, 1);   // ????????????
        pgstsDO.setManualFg(manualFg);
        //???rmc??????
        if (JudgeUtils.isNull(pgstsDO.getMtStr())){
            pgstsDO.setMtStr(receiveRemitMessageReqDTO.getSwiftInfo());
        }
        pgstsDO.setAhMt(mtType.toString());
        //??????????????????????????????
        LocalDate acDate = mtAssemblyService.getAcDate();
        pgstsDO.setAcDate(acDate);
        //?????????????????????????????????
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        //??????update????????????create???????????????
        pgstsDO.setUpdateLastTime(sysLocalDate);
        pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_RECV);
        //RMC????????????????????????ACK
        pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_ACK);
        // LAST????????????
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgstsDO.setUpdateLastTxnCode(reqHead.getTxnCode());
            pgstsDO.setTxncode(reqHead.getTxnCode());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgstsDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //?????????????????????
        pgstsDO.setUpdateLastAcDate(acDate);
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgstsDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        //?????????
        if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
            pgstsDO.setLogNumber(reqHead.getJournalNo());
        }
        //??????????????????key???????????????
        PgstsDO pgstsDo = pgstsService.getByMsgNo(srcBk+srcDt+srcSeq);
        if (JudgeUtils.isNotNull(pgstsDo)){
            //?????????????????????????????????future ?????????
            if (!("103".equals(pgstsDo.getAhMt()) || "200".equals(pgstsDo.getAhMt()) ||
                    "202".equals(pgstsDo.getAhMt()) || "Y".equals(pgstsDo.getFutureFg()))){
                logger.info("##### WITHOUT ACCOUNT DUPLICATE MESSAGE NUMBER :{}",msgNo);
                return rspDTO;
            }else {
                //???????????? ?????????????????????????????????????????? ????????????
                if ("DTED".equals(pgstsDo.getGwMsgStatus())){
                    logger.info("##### DISTRIBUTION WITH ACCOUNT SUCCEEDED :{}",msgNo);
                    return rspDTO;
                }else {
                    //???????????????future????????????????????? delete???????????????
                    logger.info("##### WITH ACCOUNT DISTRIBUTION FAILED ,REASSIGNMENT MESSAGE :{}",msgNo);
                    pgstsService.insertMtForRecv(pgstsDo.getMsgNo(),pgstsDO);
                }
            }
        }else {
            //??????????????????key ?????????????????????
            logger.info("##### MESSAGE DATA SAVING #####");
            pgstsService.insertMt(pgstsDO);
        }
        //????????????????????????????????????
        String checkMsg = mtMsg.replace("{","");
        checkMsg = checkMsg.replace("}","");
        Boolean charFlag = MTMsgUtils.checkCharset(checkMsg, "x");
        logger.info("##### MT MESSAGE WHETHER IT NOT CONTAIN INVALID CHAR :{}",charFlag);
        if (!charFlag){
            logger.error("##### MT MESSAGE CONTAIN INVALID CHAR,MSG NO:{}",msgNo);
            //???????????????99
            if ("103".equals(pgstsDO.getAhMt()) || "200".equals(pgstsDO.getAhMt()) ||
                    "202".equals(pgstsDO.getAhMt()) || "Y".equals(pgstsDO.getFutureFg())){
                receiveRemitMsgRspDTO.setErrCd(99);
                receiveRemitMsgRspDTO.getRspHead().setErrorMsg("MT MESSAGE CONTAIN INVALID CHAR");
                rspDTO.setMsgCd(MTConstants.MT_CONTAIN_INVALID_CHAR);
                rspDTO.setMsgInfo("MT MESSAGE CONTAIN INVALID CHAR");
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            }
            //??????????????? ?????????30
            receiveRemitMsgRspDTO.setErrCd(30);
            receiveRemitMsgRspDTO.getRspHead().setErrorMsg("MT MESSAGE CONTAIN INVALID CHAR");
            rspDTO.setMsgCd(MTConstants.MT_CONTAIN_INVALID_CHAR);
            rspDTO.setMsgInfo("MT MESSAGE CONTAIN INVALID CHAR");
            rspDTO.setBody(receiveRemitMsgRspDTO);
            return rspDTO;
        }
        // ????????????  ??????????????????DFAIL
        BaseMessage baseMessage = null;
        try {
            baseMessage = commonAssemble.disassemblyMessage(mtMsg, pgstsDO, reqHead);
            //?????????????????????????????????  ????????????
            if (TeleCh650Util.describe.containsKey("MT"+baseMessage.getTxCode())) {
                logger.info("##### START DISASSEMBLY MESSAGE #####");
                baseMessage.parserMessage();
                logger.info("##### END DISASSEMBLY MESSAGE #####");
            }else {
                //????????????????????????????????? ??????????????????RMC
                logger.error("##### MESSAGE TYPE MANUAL RETURN RMC IS NOT SUPPORTED :{}",pgstsDO.getMsgNo());
                return rspDTO;
            }
        } catch (Exception e) {
            logger.error("##### MESSAGE DISASSEMBLY HEADER FAILED,MESSAGE NUMBER :{}",msgNo);
            logger.error("##### ERROR:{}",JSON.toJSONString(e));
            // ?????????????????? ????????????RMC??????????????????
            //???????????????99 ?????????????????????
            if ("103".equals(pgstsDO.getAhMt()) || "200".equals(pgstsDO.getAhMt()) ||
                    "202".equals(pgstsDO.getAhMt()) || "Y".equals(pgstsDO.getFutureFg())){
                logger.error("##### MESSAGE WITH ACCOUNT RETURN 99 #####");
                receiveRemitMsgRspDTO.setErrCd(99);
                receiveRemitMsgRspDTO.getRspHead().setErrorMsg("DISMANTLE FAIL");
                rspDTO.setMsgCd(MTConstants.MT_DISMANTLE_FAIL);
                rspDTO.setMsgInfo("DISMANTLE FAIL");
                rspDTO.setBody(receiveRemitMsgRspDTO);
                return rspDTO;
            }
            //??????????????? ?????????????????????30
            logger.error("##### MESSAGE WITHOUT ACCOUNT RETURN 30 #####");
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DFAIL);
            pgstsService.updateMtStatus(pgstsDO);
            receiveRemitMsgRspDTO.setErrCd(30);
            receiveRemitMsgRspDTO.getRspHead().setErrorMsg("DISMANTLE FAIL");
            rspDTO.setMsgCd(MTConstants.MT_DISMANTLE_FAIL);
            rspDTO.setMsgInfo("DISMANTLE FAIL");
            rspDTO.setBody(receiveRemitMsgRspDTO);
            return rspDTO;
        }

        // ?????????????????????????????????
        String msgCd = sendService.SendToInsts(baseMessage, pgstsDO, rmcTrx04, eaiHeaderDTO, reqHead);
        if (JudgeUtils.isNotSuccess(msgCd)) {
            logger.error("##### MESSAGE DISPATCH AND IMPORT ERROR:{},MSG NO:{}", msgCd,pgstsDO.getMsgNo());
            //???????????????????????????????????? ???????????????RMC
            if (!("103".equals(pgstsDO.getAhMt()) || "202".equals(pgstsDO.getAhMt()) || "200".equals(pgstsDO.getAhMt())
                    ||"Y".equals(pgstsDO.getFutureFg()))){
                return rspDTO;
            }
            //??????????????? ???????????????40
            receiveRemitMsgRspDTO.setErrCd(40);
            receiveRemitMsgRspDTO.getRspHead().setErrorMsg("DISPATCH MESSAGE TO IR ERROR");
            rspDTO.setMsgCd(msgCd);
            rspDTO.setMsgInfo("DISPATCH MESSAGE TO IR ERROR");
            rspDTO.setBody(receiveRemitMsgRspDTO);
            return rspDTO;
        }
        return rspDTO;
    }

    /**
     * ????????????????????????
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<SendRemitMsgACKRspDTO> sendRemitMessageACK(GenericDTO<SendRemitMsgACKReqDTO> reqDto) {
        logger.info("##### START PG 23670 #####");
        // ??????????????????
        SendRemitMsgACKReqDTO ackBody = reqDto.getBody();
        // ???????????? DTO
        GenericRspDTO<SendRemitMsgACKRspDTO> rspDTO = new GenericRspDTO();
        // ??????????????????????????????
        String srcBk = String.format("%03d", ackBody.getSrcBk());
        String srcDt = ackBody.getSrcDt().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String srcSeq = ackBody.getSrcSeq().trim();
        /** ??????????????????????????? */
        SendRemitMsgACKRspDTO sendRemitMsgACKRspDTO = new SendRemitMsgACKRspDTO();
        BeanUtils.copyProperties(ackBody, sendRemitMsgACKRspDTO);
        sendRemitMsgACKRspDTO.setId22(srcBk + srcDt + srcSeq);
        // ??????????????????????????????
        StringBuilder msgKey = new StringBuilder();
        msgKey.append(srcBk);
        msgKey.append(srcDt);
        msgKey.append(srcSeq);
        logger.info("##### START TO QUERY WHETHER PG HAS THIS RECORD #####");
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgKey.toString().trim());
        if(JudgeUtils.isNull(pgstsDO)){
            logger.error("##### RECORE WAS NOT FOUNT:{}", msgKey.toString());
            sendRemitMsgACKRspDTO.setErrCd(40);
            sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("RECORE WAS NOT FOUNT");
            rspDTO.setMsgCd(MTConstants.MT_RECORE_NOT_FOUND);
            rspDTO.setBody(sendRemitMsgACKRspDTO);
            return rspDTO;
        }else {
            //????????????????????????????????? ?????????????????????????????? PG????????????????????????
            if (JudgeUtils.isNotNull(pgstsDO.getMtStatus())){
                logger.info("##### This record has notified the app 23670 ,MSGNO:{}",pgstsDO.getMsgNo());
                RspHead rspHead = new RspHead();
                ReqHead reqHead = reqDto.getBody().getReqHead();
                BeanUtils.copyProperties(reqHead,rspHead);
                rspHead.setTxnCode("23670");
                rspHead.setTxnType("N");
                sendRemitMsgACKRspDTO.setRspHead(rspHead);
                rspDTO.setBody(sendRemitMsgACKRspDTO);
                return rspDTO;
            }
        }
        logger.info("##### END TO QUERY WHETHER PG HAS THIS RECORD #####");
        //??????????????????
        String frModule = pgstsDO.getFrModule();
        //??????????????????= SwiftRSTMsg + Fllr30 ??????
        String inforMation = null;
        StringBuilder sb = new StringBuilder();
        if (JudgeUtils.isNotNull(ackBody.getSwiftRSTMsg())){
            sb.append(ackBody.getSwiftRSTMsg());
        }
        if (JudgeUtils.isNotNull(ackBody.getFllr30())){
            sb.append(ackBody.getFllr30());
        }
        inforMation = sb.toString();
        //????????????????????????????????????????????? ??????ack nak ????????????
        if ("RPS".equals(ackBody.getFrSys())){
            if ("00".equals(ackBody.getSwiftRST())){
                pgstsDO.setGwMsgStatus(MTInStatusConstants.GW_MSG_STATUS_HANDLE_ACK);
            }else {
                pgstsDO.setGwMsgStatus(MTInStatusConstants.GW_MSG_STATUS_HANDLE_NAK);
            }
        }
        //????????????  ????????????
        if ("00".equals(ackBody.getSwiftRST())) {
            pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_ACK);
        } else if ("25".equals(ackBody.getSwiftRST())) {
            if (inforMation.length()>=21){
                String str = inforMation.substring(0, 21);
                if ("HKICL ABORT REASON:B5".equals(str)) {
                    pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_ACK);
                }else {
                    pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_NAK);
                    ackBody.setSwiftRST("10");
                }
            }else {
                pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_NAK);
                ackBody.setSwiftRST("10");
            }
        } else if ("10".equals(ackBody.getSwiftRST()) || "60".equals(ackBody.getSwiftRST()) || "70".equals(ackBody.getSwiftRST())) {
            pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_NAK);
        } else {
            //??????????????????30
            logger.error("##### Other abnormal status of message receipt:{}", ackBody.getSwiftRST());
            sendRemitMsgACKRspDTO.setErrCd(30);
            sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("MESSAGE RECEIPT NOT ACCEPTED");
            rspDTO.setMsgCd(MTConstants.RECEIPT_STATE_ERR);
            rspDTO.setBody(sendRemitMsgACKRspDTO);
            return rspDTO;
        }
        pgstsDO.setRejectedReason(inforMation);
        int result = pgstsService.updateMtStatus(pgstsDO);
        //????????????AK NK??????  ??????????????????
        if (result>0 && JudgeUtils.isNotNull(pgstsDO.getRetransmissionId())){
            logger.info("##### Manually 23670 cancel resending task #####");
            String retransmissionId = pgstsDO.getRetransmissionId();
            JobcancelDTO jobcancelDTO = new JobcancelDTO();
            jobcancelDTO.setJobExecutorId(retransmissionId);
            JobSendUtils.cancel(jobcancelDTO);
        }
        // ???????????????????????????????????????
        switch (JudgeUtils.isNull(frModule) ? "" : frModule) {
            case "ir":
                logger.info("##### PG 23670 notify IR #####");
                GenericDTO<ReturnMessageReqDTO> genericDTO = new GenericDTO<>();
                ReturnMessageReqDTO reqDTO = new ReturnMessageReqDTO();
                reqDTO.setMsgNo(pgstsDO.getMsgNo());
                reqDTO.setOurRef(pgstsDO.getTrn());
                reqDTO.setMessageForm(pgstsDO.getMtStatus());
                reqDTO.setOhGpiRef(pgstsDO.getOhGpiRef());
                reqDTO.setInforMation(inforMation);
                reqDTO.setMtType(pgstsDO.getAhMt());
                reqDTO.setTxCode(pgstsDO.getTxncode());
                reqDTO.setReqHead(ackBody.getReqHead());
                genericDTO.setBody(reqDTO);
                GenericRspDTO<ReturnMessageRspDTO> returnMessageRspDTOGenericRspDTO = returnMessageServiceClient.ReturnMessage(genericDTO);
                if (JudgeUtils.isNotSuccess(returnMessageRspDTOGenericRspDTO.getMsgCd())) {
                    //????????????
                    logger.error("##### IR ERROR ,STATE ROLLBACK ,MSG NO:{}",pgstsDO.getMsgNo());
                    PgstsDO pgDoIr = new PgstsDO();
                    pgDoIr.setMsgNo(pgstsDO.getMsgNo());
                    pgDoIr.setMtStatus(" ");
                    int resultIr = pgstsService.updateMtStatus(pgDoIr);
                    if (resultIr>0){
                        logger.info("##### Status modified successfully , MSG NO:{}",pgstsDO.getMsgNo());
                    }else {
                        logger.error("##### Status modified failed , MSG NO:{}",pgstsDO.getMsgNo());
                    }
                    //??????????????????40
                    logger.error("##### 23670 SEND IR ERROR:{}", returnMessageRspDTOGenericRspDTO.getMsgCd());
                    sendRemitMsgACKRspDTO.setErrCd(40);
                    sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("23670 SEND IR ERROR");
                    rspDTO.setMsgCd(returnMessageRspDTOGenericRspDTO.getMsgCd());
                    rspDTO.setBody(sendRemitMsgACKRspDTO);
                    return rspDTO;
                }
                break;
            case "or":
                logger.info("##### PG 23670 notify OR #####");
                GenericDTO<UpdateMastBySendReportReReqDTO> genericDto = new GenericDTO<>();
                UpdateMastBySendReportReReqDTO updateMastBySendReportReReqDTO = new UpdateMastBySendReportReReqDTO();
                updateMastBySendReportReReqDTO.setMsgNo(pgstsDO.getMsgNo());
                updateMastBySendReportReReqDTO.setMtType(pgstsDO.getAhMt());
                PgMatchDO pgMatchDO = new PgMatchDO();
                pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
                List<PgMatchDO> matchDaoList = pgMatchDao.findList(pgMatchDO);
                if (matchDaoList.size()==1){
                    updateMastBySendReportReReqDTO.setOurRef(matchDaoList.get(0).getPagmchOurRef());
                }else if (matchDaoList.size()>1){
                    //????????????
                    logger.error("##### OR ERROR ,STATE ROLLBACK,MSG NO:{}",pgstsDO.getMsgNo());
                    PgstsDO pgDoOr = new PgstsDO();
                    pgDoOr.setMsgNo(pgstsDO.getMsgNo());
                    pgDoOr.setMtStatus(" ");
                    int resultIr = pgstsService.updateMtStatus(pgDoOr);
                    if (resultIr>0){
                        logger.info("##### Status modified successfully , MSGNO:{}",pgstsDO.getMsgNo());
                    }else {
                        logger.error("##### Status modified failed , MSGNO:{}",pgstsDO.getMsgNo());
                    }
                    //??????????????????40
                    logger.error("##### 23670 SEND OR ERROR,MORE THAN ONE RECORE:{}",matchDaoList.size());
                    sendRemitMsgACKRspDTO.setErrCd(40);
                    sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("23670 SEND OR ERROR,MORE THAN ONE RECORE");
                    rspDTO.setMsgCd("RPSG4004");
                    rspDTO.setBody(sendRemitMsgACKRspDTO);
                    return rspDTO;
                }else {
                    updateMastBySendReportReReqDTO.setOurRef(pgstsDO.getPagmchOurRef());
                }
                updateMastBySendReportReReqDTO.setOhGpiRef(pgstsDO.getOhGpiRef());
                updateMastBySendReportReReqDTO.setInforMation(inforMation);
                updateMastBySendReportReReqDTO.setMtStatus(pgstsDO.getMtStatus());
                updateMastBySendReportReReqDTO.setTxCode(pgstsDO.getTxncode());
                updateMastBySendReportReReqDTO.setFuncCode(ackBody.getFunCd());
                updateMastBySendReportReReqDTO.setErrCode(ackBody.getErrCd().toString());
                updateMastBySendReportReReqDTO.setSrcBk(ackBody.getSrcBk());
                updateMastBySendReportReReqDTO.setSrcDate(ackBody.getSrcDt().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                updateMastBySendReportReReqDTO.setSrcSeq(ackBody.getSrcSeq());
                updateMastBySendReportReReqDTO.setResndInd(ackBody.getResndInd());
                updateMastBySendReportReReqDTO.setSwiftRST(ackBody.getSwiftRST());
                updateMastBySendReportReReqDTO.setSwiftRSTMsg(ackBody.getSwiftRSTMsg());
                updateMastBySendReportReReqDTO.setFllr30(ackBody.getFllr30());
                updateMastBySendReportReReqDTO.setSwiftISN(ackBody.getSwiftISN());
                updateMastBySendReportReReqDTO.setSsnNo(ackBody.getSsnNo());
                updateMastBySendReportReReqDTO.setMsgSource2(ackBody.getMsgSOURCE2());
                updateMastBySendReportReReqDTO.setReqHead(ackBody.getReqHead());
                genericDto.setBody(updateMastBySendReportReReqDTO);
                GenericRspDTO<CommNobodyRspDTO> commNobodyRspDTOGenericRspDTO = commServiceClient.updateMastBySendReportResult(genericDto);
                if (JudgeUtils.isNotSuccess(commNobodyRspDTOGenericRspDTO.getMsgCd())) {
                    //????????????
                    logger.error("##### OR ERROR ,STATE ROLLBACK,MSG NO:{}",pgstsDO.getMsgNo());
                    PgstsDO pgDoOr = new PgstsDO();
                    pgDoOr.setMsgNo(pgstsDO.getMsgNo());
                    pgDoOr.setMtStatus(" ");
                    int resultIr = pgstsService.updateMtStatus(pgDoOr);
                    if (resultIr>0){
                        logger.info("##### Status modified successfully , MSGNO:{}",pgstsDO.getMsgNo());
                    }else {
                        logger.error("##### Status modified failed , MSGNO:{}",pgstsDO.getMsgNo());
                    }
                    //??????????????????40
                    logger.error("##### 23670 SEND OR ERROR:{}", commNobodyRspDTOGenericRspDTO.getMsgCd());
                    sendRemitMsgACKRspDTO.setErrCd(40);
                    sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("23670 SEND OR ERROR");
                    rspDTO.setMsgCd(commNobodyRspDTOGenericRspDTO.getMsgCd());
                    rspDTO.setBody(sendRemitMsgACKRspDTO);
                    return rspDTO;
                }
                break;
            case "bp":
                logger.info("##### PG 23670 notify BP #####");
                GenericDTO<com.hisun.kont.pyrm.py.remote.ReturnMessageReqDTO> returnMessageReqDTOGenericDTO = new GenericDTO<>();
                com.hisun.kont.pyrm.py.remote.ReturnMessageReqDTO messageReqDTO = new com.hisun.kont.pyrm.py.remote.ReturnMessageReqDTO();
                messageReqDTO.setMsgNo(pgstsDO.getMsgNo());
                messageReqDTO.setOurRef(pgstsDO.getTrn());
                messageReqDTO.setOhGpiRef(pgstsDO.getOhGpiRef());
                messageReqDTO.setMtType(pgstsDO.getAhMt());
                messageReqDTO.setInforMation(inforMation);
                messageReqDTO.setTxCode(pgstsDO.getTxncode());
                messageReqDTO.setMessageForm(pgstsDO.getMtStatus());
                messageReqDTO.setReqHead(ackBody.getReqHead());
                returnMessageReqDTOGenericDTO.setBody(messageReqDTO);
                GenericRspDTO<com.hisun.kont.pyrm.py.remote.ReturnMessageRspDTO> rspDTOGenericRspDTO = feeCollectCommissionServiceClient.returnMessage(returnMessageReqDTOGenericDTO);
                if (JudgeUtils.isNotSuccess(rspDTOGenericRspDTO.getMsgCd())){
                    //????????????
                    logger.error("##### BP ERROR ,STATE ROLLBACK,MSG NO:{}",pgstsDO.getMsgNo());
                    PgstsDO pgDoBp = new PgstsDO();
                    pgDoBp.setMsgNo(pgstsDO.getMsgNo());
                    pgDoBp.setMtStatus(" ");
                    int resultIr = pgstsService.updateMtStatus(pgDoBp);
                    if (resultIr>0){
                        logger.info("##### Status modified successfully , MSGNO:{}",pgstsDO.getMsgNo());
                    }else {
                        logger.error("##### Status modified failed , MSGNO:{}",pgstsDO.getMsgNo());
                    }
                    //??????????????????40
                    logger.error("##### 23670 SEND BP ERROR:{}", rspDTOGenericRspDTO.getMsgCd());
                    sendRemitMsgACKRspDTO.setErrCd(40);
                    sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("23670 SEND BP ERROR");
                    rspDTO.setMsgCd(rspDTOGenericRspDTO.getMsgCd());
                    rspDTO.setBody(sendRemitMsgACKRspDTO);
                    return rspDTO;
                }
                break;
            default:
                //??????????????????40
                logger.error("##### PG NO OR FROM MODULE ERROR,MSG NO:{}", pgstsDO.getMsgNo());
                sendRemitMsgACKRspDTO.setErrCd(40);
                sendRemitMsgACKRspDTO.getRspHead().setErrorMsg("NO FROM MODULE ERROR");
                rspDTO.setMsgCd(MTConstants.FROM_MODULE_ERR);
                rspDTO.setBody(sendRemitMsgACKRspDTO);
                return rspDTO;
        }
        //???????????????
        logger.info("##### PG 23670 NOTIFY APP SUCCESS #####");
        RspHead rspHead = new RspHead();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        BeanUtils.copyProperties(reqHead,rspHead);
        rspHead.setTxnCode("23670");
        rspHead.setTxnType("N");
        sendRemitMsgACKRspDTO.setRspHead(rspHead);
        rspDTO.setBody(sendRemitMsgACKRspDTO);
        return rspDTO;
    }


    /**
     * ??????future??????
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<ReceiveFutureMsgRspDTO> receiveFutureMsg(GenericDTO<ReceiveFutureMsgReqDTO> reqDto) {
        logger.info("###{}###{}","Receive future messages sent by RMC","---start---");
        //??????????????????
        ReceiveFutureMsgReqDTO receiveFutureMsgReqDTO = reqDto.getBody();
        //????????????DTO
        GenericRspDTO<ReceiveFutureMsgRspDTO> rspDTO = new GenericRspDTO<>();
        //?????????????????????
        RspHead rspHead = new RspHead();
        //?????????????????????
        String channelId = receiveFutureMsgReqDTO.getFrSys();
        //?????????????????????????????????
        Integer messageType = receiveFutureMsgReqDTO.getMt();
        String mtStr = "";
        // ??????????????????????????????
        String srcBk = String.format("%03d", receiveFutureMsgReqDTO.getSrcBk());
        //String srcDt = receiveFutureMsgReqDTO.getSrcDt().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String srcDt = DateTimeUtils.formatLocalDate(receiveFutureMsgReqDTO.getSrcDt());
        String srcSeq = receiveFutureMsgReqDTO.getSrcSeq().trim();
        //?????????????????????????????????,????????????????????????????????????
        ReqHead reqHead = receiveFutureMsgReqDTO.getReqHead();
        String branchCode = reqHead.getBranchCode().substring(reqHead.getBranchCode().length()-3);
        /** ??????????????????????????? */
        ReceiveFutureMsgRspDTO receiveFutureMsgRspDTO = new ReceiveFutureMsgRspDTO();
        BeanUtils.copyProperties(receiveFutureMsgReqDTO, receiveFutureMsgRspDTO);
        receiveFutureMsgRspDTO.setId22(srcBk + srcDt + srcSeq);
//        ReceiveFutureMsg2RspDTO receiveFutureMsg2RspDTO = new ReceiveFutureMsg2RspDTO();
//        BeanUtils.copyProperties(receiveFutureMsgReqDTO, receiveFutureMsg2RspDTO);
        //??????????????????key???????????????
        PgstsDO pgstsDo = pgstsDao.getByMsgNo(srcBk+srcDt+srcSeq);
        if (JudgeUtils.isNotNull(pgstsDo)){
            logger.info("###{}###","The packet number already exists in the table");
//            receiveFutureMsgRspDTO.setErrCd(00);
//            rspDTO.setBody(receiveFutureMsgRspDTO);
//            rspDTO.setMsgCd(MTConstants.MT_REPETITION);
            return rspDTO;
        }
        //??????rmc
        FutureRmcInfo futureRmcInfo = new FutureRmcInfo();
        BeanUtils.copyProperties(receiveFutureMsgReqDTO, futureRmcInfo);

        //??????eai?????????
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        BeanUtils.copyProperties(receiveFutureMsgReqDTO, eaiHeaderDTO);
        //????????????????????????????????????,????????????????????????????????????????????????,???checkCenterBranchReqDTOGenericDTO????????????????????????????????????
        logger.info("###{}###{}","Checks whether the current trading bank is center","---start---");
        CheckCenterBranchReqDTO checkCenterBranchReqDTO =new CheckCenterBranchReqDTO();
        checkCenterBranchReqDTO.setBankNo(srcBk);
        checkCenterBranchReqDTO.setBranchNo(branchCode);
        GenericRspDTO<CheckCenterBranchRspDTO> checkCenterBranchRspDTOGenericRspDTO= null;
        try {
            checkCenterBranchRspDTOGenericRspDTO = inwardInterFaceServiceClient.checkCenterBranch(GenericDTO.newInstance(checkCenterBranchReqDTO));
            //??????????????????????????????????????????????????????????????????????????????????????????????????????KONT0000???????????????????????????????????????????????????
            if(JudgeUtils.isNotSuccess(checkCenterBranchRspDTOGenericRspDTO.getMsgCd())){
                logger.error("###{}###","Error calling application return code");
                receiveFutureMsgRspDTO.setErrCd(50);
                rspDTO.setMsgCd(checkCenterBranchRspDTOGenericRspDTO.getMsgCd());
                rspDTO.setMsgInfo(checkCenterBranchRspDTOGenericRspDTO.getMsgInfo());
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            }
        } catch (Exception e) {
            logger.error("###{}###","Description Failed to invoke the application interface");
            receiveFutureMsgRspDTO.setErrCd(50);
            rspDTO.setMsgCd(MTConstants.CALL_IR_ERR);
            rspDTO.setBody(receiveFutureMsgRspDTO);
            return rspDTO;
        }
        logger.info("###{}###","Checks whether the current trading bank is central end");
        CheckCenterBranchRspDTO checkCenterBranchRspDTO = checkCenterBranchRspDTOGenericRspDTO.getBody();
        String isCenter = checkCenterBranchRspDTO.getIsCenter();
        //"0"?????????????????????????????????isCenter??????0??????????????????PAS323
        if("0".compareTo(isCenter)==0){
            logger.info("###{}###","The current bank is not a central bank");
            receiveFutureMsgRspDTO.setErrCd(10);
            rspDTO.setMsgCd("RPS323");
            rspHead.setTxnErrCd("RPS323");
            receiveFutureMsgRspDTO.setRspHead(rspHead);
            rspDTO.setBody(receiveFutureMsgRspDTO);
            return rspDTO;
        }
        //?????????????????????????????????????????????????????????????????????
        //???????????????????????????
        PgSrcSwitchDO pgSrcSwitchDO = new PgSrcSwitchDO();
        //????????????????????????????????????????????????????????????
        logger.info("###{}###{}","Check whether the channel corresponding to the transaction bank packet type is normal","---start---");
        if (Integer.valueOf(MtTypeConstants.MESSAGE_TYPE_103).compareTo(messageType) == 0) {
            logger.info("###{}###","Read MT103 switch table data");
            pgSrcSwitchDO.setSrcSwType("MT103 / 103+");
            PgSrcSwitchDO srcSwitchDaoByKey = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            //??????????????????????????????????????????????????????????????????????????????PAS321???
            if (JudgeUtils.isNull(srcSwitchDaoByKey)) {
                logger.error("###{}###","Abnormal switch table information");
                receiveFutureMsgRspDTO.setErrCd(10);
                rspDTO.setMsgCd("RPS601");
                rspHead.setTxnErrCd("RPS601");
                receiveFutureMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            }else{
                //??????????????????????????????????????????????????????????????????
                if("C".compareTo(srcSwitchDaoByKey.getSrcSwStatus())==0){
                    logger.error("###{}###","The switch table closes this type of message:");
                    receiveFutureMsgRspDTO.setErrCd(10);
                    rspDTO.setMsgCd("RPS540");
                    rspHead.setTxnErrCd("RPS540");
                    receiveFutureMsgRspDTO.setRspHead(rspHead);
                    rspDTO.setBody(receiveFutureMsgRspDTO);
                    return rspDTO;
                }
            }
        } else if (Integer.valueOf(MtTypeConstants.MESSAGE_TYPE_200).compareTo(messageType) == 0
                || Integer.valueOf(MtTypeConstants.MESSAGE_TYPE_202).compareTo(messageType) == 0) {
            logger.info("###{}###","Read MT202/200 switch table data");
            pgSrcSwitchDO.setSrcSwType("MT202 / 200");
            PgSrcSwitchDO srcSwitchDaoByKey = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            //??????????????????????????????????????????????????????????????????????????????PAS321???
            if (JudgeUtils.isNull(srcSwitchDaoByKey)) {
                logger.error("###{}###","Abnormal switch table information");
                receiveFutureMsgRspDTO.setErrCd(10);
                rspDTO.setMsgCd("RPS601");
                rspHead.setTxnErrCd("RPS601");
                receiveFutureMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            }else{
                //??????????????????????????????????????????????????????????????????
                if("C".compareTo(srcSwitchDaoByKey.getSrcSwStatus())==0){
                    logger.error("###{}###","The switch table closes this type of message:");
                    receiveFutureMsgRspDTO.setErrCd(10);
                    rspDTO.setMsgCd("RPS540");
                    rspHead.setTxnErrCd("RPS540");
                    receiveFutureMsgRspDTO.setRspHead(rspHead);
                    rspDTO.setBody(receiveFutureMsgRspDTO);
                    return rspDTO;
                }
            }
            //??????????????????????????????????????????103???200???202????????????????????????
        } else {
            logger.error("###{}###","Non-future Value packet type");
            receiveFutureMsgRspDTO.setErrCd(10);
            rspDTO.setMsgCd("RPS601");
            rspHead.setTxnErrCd("RPS601");
            receiveFutureMsgRspDTO.setRspHead(rspHead);
            rspDTO.setBody(receiveFutureMsgRspDTO);
            return rspDTO;
        }
        logger.info("###{}###{}","Check whether the channel corresponding to the transaction bank packet type is normal","---end---");
        //??????FUTURE VALUE ????????????/?????????????????????????????????
        PgstsDO pgstsDO = new PgstsDO();
        String msgNo = srcBk + srcDt + srcSeq;
        PgstsDO byMsgNo = pgstsService.getByMsgNo(msgNo);
        //??????????????????????????????PAS322?????????????????????????????????
        if (JudgeUtils.isNotNull(byMsgNo)) {
            receiveFutureMsgRspDTO.setErrCd(50);
            rspDTO.setMsgCd("RPS322");
            rspHead.setTxnErrCd("RPS322");
            receiveFutureMsgRspDTO.setRspHead(rspHead);
            rspDTO.setBody(receiveFutureMsgRspDTO);
            return rspDTO;
        }

        // ????????????????????????
        logger.info("###{}###{}","Judgment long message","---start---");
        if ("L".compareTo(receiveFutureMsgReqDTO.getMsgFg())==0) {
            // ???????????????????????????
            LongIncomeMsgFetchReqPGDTO longIncomeMsgFetchReqPGDTO = new LongIncomeMsgFetchReqPGDTO();
            longIncomeMsgFetchReqPGDTO.setSrcBk(srcBk);
            longIncomeMsgFetchReqPGDTO.setSrcDate(srcDt);
            longIncomeMsgFetchReqPGDTO.setSrcSeq(srcSeq);
            longIncomeMsgFetchReqPGDTO.setSrcAppl("RPS");
            longIncomeMsgFetchReqPGDTO.setResndInd("0");
            longIncomeMsgFetchReqPGDTO.setToSys("RMC");
            longIncomeMsgFetchReqPGDTO.setErrCode("00");
            longIncomeMsgFetchReqPGDTO.setReqHead(reqHead);
            longIncomeMsgFetchReqPGDTO.getReqHead().setTxnCode("23385");
            longIncomeMsgFetchReqPGDTO.getReqHead().setSrcAppId("RPS");
            longIncomeMsgFetchReqPGDTO.getReqHead().setTarAppId("RMC");
            GenericRspDTO<LongIncomeMsgFetchRspDTO> longMsgRspDTO = new GenericRspDTO<>();
            longMsgRspDTO = callRmcService.longIncomeMsgFetchPG(GenericDTO.newInstance(longIncomeMsgFetchReqPGDTO));
            if (JudgeUtils.isNull(longMsgRspDTO)) {
                logger.error("###{}###","The returned data is null");
                receiveFutureMsgRspDTO.setErrCd(30);
                rspDTO.setMsgCd("RPS378");
                rspHead.setTxnErrCd("RPS378");
                receiveFutureMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            } else {
                LongIncomeMsgFetchRspDTO longMsgRspDTOBody = longMsgRspDTO.getBody();
                if (JudgeUtils.isNotNull(longMsgRspDTOBody)) {
                    mtStr = longMsgRspDTOBody.getSwiftInfo();
                }
            }
        } else {
            mtStr = receiveFutureMsgReqDTO.getSwiftInfo();
        }
        logger.info("###{}###{}","Judgment long message","---end---");
//        MessageEnvelope envelope = new MessageEnvelope(mtStr);
//        envelope.paserStrToBlockMap();
//        BaseMessage baseMessage = envelope.getMessageList().get(0);
//        if (envelope.getInstanceMap().containsKey(baseMessage.getTxCode())) {
//            baseMessage.parserMessage();
//        }
        //??????????????????202??????202cov
        logger.info("###{}###{}","Determine if it's 202 or 202cov","---start---");
        if (Integer.valueOf(MtTypeConstants.MESSAGE_TYPE_202).equals(messageType)) {
            String txnCd = StringUtils.substring(mtStr,mtStr.indexOf("{2:") + 4, mtStr.indexOf("{2:") + 7);
            if("202".equals(txnCd)){
                //???????????????202  ??????????????????MT202Cov????????????  ????????????SEQ B?????????MT202??????
                String substring = mtStr.substring(mtStr.indexOf("{4:") + 3);
                String messageBody = substring.substring(0, substring.indexOf("-}"));
                ArrayList<Map.Entry<String, String>> tagList = TeleCh650Util.parserDataToKeyList(messageBody);
                StringBuffer tagStr = new StringBuffer();
                for (int i = 0; i < tagList.size(); i++) {
                    String k = tagList.get(i).getKey();
                    if (k.equals("50A") || k.equals("50K") || k.equals("50F")) {
                        break;
                    }
                    String value = tagList.get(i).getValue();
                    //????????????
                    tagStr.append(":").append(k).append(":").append(value);
                }
                String subSwHeader = mtStr.substring(0, mtStr.indexOf("{4:") + 3);
                String tailHeader = substring.substring(substring.indexOf("-}"));
                String tagString = tagStr.toString();
                mtStr = subSwHeader + "\n" + tagString + tailHeader;
            }else{
                logger.error("###{}###","Determine if it's 202 or 202cov error");
                receiveFutureMsgRspDTO.setErrCd(20);
                rspDTO.setMsgCd("RPS321");
                rspHead.setTxnErrCd("RPS321");
                receiveFutureMsgRspDTO.setRspHead(rspHead);
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            }
        }
        logger.info("###{}###{}","Determine if it's 202 or 202cov","---end---");
        //???future????????????pgsts??????
        pgstsDO.setMsgNo(msgNo.trim()); //???????????????pgsts????????????????????????
        //????????????
        String manualFg = srcSeq.trim().substring(0, 1);
        pgstsDO.setManualFg(manualFg);
        //??????future value ????????????
        pgstsDO.setFutureFg("Y");
        pgstsDO.setTrn(JudgeUtils.isNotNull(receiveFutureMsgReqDTO.getTrnRef())?receiveFutureMsgReqDTO.getTrnRef(): "");
        pgstsDO.setMtStr(mtStr);
        //?????????sit3??????????????????????????????null
        pgstsDO.setMtStatus(" ");
        //??????future value????????????????????????" "
        pgstsDO.setGwMsgStatus(" ");
        //?????????????????????????????????
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        //?????????????????????????????????????????????????????????
        pgstsDO.setUpdateLastTime(sysLocalDate);
        logger.info("###{}###{}","Insert data into the database","---start---");
        pgstsService.insertMt(pgstsDO);
        logger.info("###{}###{}","Insert data into the database","---end---");

        //?????????????????????650??????
        BaseMessage dismantleBaseMessage = null;
        logger.info("###{}###{}","Disassemble MT packet data","---start---");
        try {
            dismantleBaseMessage = dismantleMTService.dismantleMT(mtStr);
            //????????????????????????
            commonAssemble.futureValueDataPadding(pgstsDO,dismantleBaseMessage,reqHead);
        } catch (Exception e) {
            // ???????????????????????? ??????
            logger.error("###{}###","Description Failed to disassemble packets");
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DFAIL);
            pgstsService.updateMtStatus(pgstsDO);
            receiveFutureMsgRspDTO.setErrCd(50);
            rspDTO.setMsgCd(MTConstants.MT_DISMANTLE_FAIL);
            return rspDTO;
        }
        logger.info("###{}###{}","Disassemble MT packet data","---end---");
        if (JudgeUtils.isNotNull(dismantleBaseMessage)) {
            logger.info("###{}###{}","Call IR 23385 interface","---start---");
            //?????????????????????????????????IR-FUTURE VALUE PAYMENT QUEUE;
            Inward23385ReceiveHandelReqDTO inward23385ReceiveHandelReqDTO = new Inward23385ReceiveHandelReqDTO();
            reqHead.setTarTxnId("23385");
            inward23385ReceiveHandelReqDTO.setReqHead(reqHead);
            inward23385ReceiveHandelReqDTO.setFuncCode(receiveFutureMsgReqDTO.getFunCd()); //?????????
            inward23385ReceiveHandelReqDTO.setChannelId(channelId);//?????????(??????)
            inward23385ReceiveHandelReqDTO.setErrCode(String.valueOf(receiveFutureMsgReqDTO.getErrCd())); //?????????
            inward23385ReceiveHandelReqDTO.setImposeInd(receiveFutureMsgReqDTO.getImpsInd());//????????????
            inward23385ReceiveHandelReqDTO.setMsgFlg(receiveFutureMsgReqDTO.getMsgFg());//??????????????????
            inward23385ReceiveHandelReqDTO.setMsgNo(msgNo); //????????????(?????????????????????)
            inward23385ReceiveHandelReqDTO.setMsgSource(receiveFutureMsgReqDTO.getMsgSrc());//??????
            inward23385ReceiveHandelReqDTO.setRemitAmt(receiveFutureMsgReqDTO.getRmtAmt());//????????????????????????
            inward23385ReceiveHandelReqDTO.setMtType(String.valueOf(messageType));//????????????????????????
            inward23385ReceiveHandelReqDTO.setRemitCur(receiveFutureMsgReqDTO.getRmtCur());//????????????????????????
            inward23385ReceiveHandelReqDTO.setSender(receiveFutureMsgReqDTO.getSndr());//?????????
            //inward23385ReceiveHandelReqDTO.setTheirRef(receiveFutureMsgReqDTO.getRelRef()); //???????????????????????????????????????
            inward23385ReceiveHandelReqDTO.setTheirRef(receiveFutureMsgReqDTO.getTrnRef()); //todo rmc?????????RelRef??????,?????????TrnRef??????
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
            String valueDate = df.format(receiveFutureMsgReqDTO.getValDt());
            inward23385ReceiveHandelReqDTO.setValueDate(Integer.valueOf(valueDate));//?????????
            GenericRspDTO<Inward23385ReceiveHandelRspDTO> inward23385ReceiveHandelRspDTOGenericRspDTO = null;
            try {
                inward23385ReceiveHandelRspDTOGenericRspDTO = inwardInterFaceServiceClient.Inward23385ReceiveHandel(GenericDTO.newInstance(inward23385ReceiveHandelReqDTO));
                //???????????????????????????????????????
                if (JudgeUtils.isNotSuccess(inward23385ReceiveHandelRspDTOGenericRspDTO.getMsgCd())) {
                    logger.error("###{}###","Error code returned from calling IR 23385 interface");
                    pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
                    pgstsService.updateMtStatus(pgstsDO);
                    receiveFutureMsgRspDTO.setErrCd(50);
                    rspDTO.setMsgCd(inward23385ReceiveHandelRspDTOGenericRspDTO.getMsgCd());
                    rspDTO.setMsgInfo(inward23385ReceiveHandelRspDTOGenericRspDTO.getMsgInfo());
                    rspDTO.setBody(receiveFutureMsgRspDTO);
                    return rspDTO;
                }
            } catch (Exception e) {
                //????????????????????????
                logger.error("###{}###","Call IR 23385 interface error");
                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
                pgstsService.updateMtStatus(pgstsDO);
                receiveFutureMsgRspDTO.setErrCd(50);
                rspDTO.setMsgCd(MTConstants.CALL_IR_ERR);
                rspDTO.setBody(receiveFutureMsgRspDTO);
                return rspDTO;
            }
            logger.info("###{}###{}","Call IR 23385 interface","---end---");
        }
//        rspDTO.setBody(receiveFutureMsgRspDTO);
//        rspDTO.setBody(receiveFutureMsgRspDTO);
        logger.info("###{}###{}","Receive future messages sent by RMC","---end---");
        return rspDTO;
    }

    /**
     * ???GTB??????SWIFT???????????????
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<PasPadiSwfRspDTO> pasPadiSwf(GenericDTO<PasPadiSwfReqDTO> reqDto) {
        logger.info("###{}###{}","Provide detailed query message data","---start---");
        //??????????????????
        PasPadiSwfReqDTO pasPadiSwfReqDTO = reqDto.getBody();
        //????????????DTO
        GenericRspDTO<PasPadiSwfRspDTO> rspDTO = new GenericRspDTO<>();
        PasPadiSwfRspDTO pasPadiSwfRspDTO = new PasPadiSwfRspDTO();
        //??????????????????
        String mtKey = pasPadiSwfReqDTO.getMtKey();
        //?????????????????????
        Integer ent = pasPadiSwfReqDTO.getEnt();
        //PAS?????????ent??????0??????1??????????????????1??????
        if(Integer.valueOf(0).compareTo(ent)==0){
            ent=1;
        }
        //???????????????????????????
        MTTxtDO mTTxtDOs =new MTTxtDO();
        List<String> dtlsList = new ArrayList<>();
        //????????????????????????
        int messageLine = 40;
        //??????????????????????????????
        if (JudgeUtils.isNull(mtKey)) {
            logger.error("###{}###","MESSAGE NUMBER NOT ENTERED");
            RspHead rspHead = new RspHead();
            rspHead.setErrorMsg("MESSAGE NUMBER NOT ENTERED");
            pasPadiSwfRspDTO.setRspHead(rspHead);
            pasPadiSwfRspDTO.setRtnCd("319");
            rspDTO.setBody(pasPadiSwfRspDTO);
            return rspDTO;
        }
        logger.info("###{}###{}","Query whether the packet number exists in the database","---start---");
        //????????????????????????pgsts????????????????????????
        PgstsDO pgstsDO = pgstsDao.getByMsgNo(mtKey);
        //?????????????????????????????????????????????
        if (JudgeUtils.isNull(pgstsDO)) {
            logger.error("###{}###","RECORD NOT FOUND");
            RspHead rspHead = new RspHead();
            rspHead.setErrorMsg("RECORD NOT FOUND");
            pasPadiSwfRspDTO.setRspHead(rspHead);
            pasPadiSwfRspDTO.setRtnCd("058");
            rspDTO.setBody(pasPadiSwfRspDTO);
            return rspDTO;
        }
        logger.info("###{}###{}","Query whether the packet number exists in the database","---end---");
        //????????????????????????????????????????????????
        String mtMessage = pgstsDO.getMtMessage();
        //?????????????????????????????????????????????????????????
        if (JudgeUtils.isNull(mtMessage)) {
            logger.error("###{}###","Message details are empty");
            pasPadiSwfRspDTO.setEndFlg("Y");
            rspDTO.setBody(pasPadiSwfRspDTO);
            return rspDTO;
        }

//        //???????????????????????????????????????
//        String[] mtMessagesTmp = mtMessage.split("\r\n");
//        StringBuilder mtMessageStr = new StringBuilder();
//        for (String message : mtMessagesTmp) {
//            mtMessageStr.append(message).append("\n");
//        }
//        String[] mtMessages = mtMessageStr.toString().split("\n");

        //???????????????????????????
        String[] mtMessages = mtMessage.split("(\\r\\n)|(\\n)");
        //??????????????????????????????list?????????
        List<String> list = new ArrayList<>(Arrays.asList(mtMessages));

        logger.info("###{}###{}","Get detailed data based on page number and message number","---start---");
        //??????list?????????????????????????????????????????????
        int messageLength = list.size();
        //?????????????????????????????????????????????
        int index = (ent - 1) * messageLine;
        //??????list????????????????????????
        int amountDivisor = messageLength / messageLine;
        int amountRemainder = messageLength % messageLine;
        int numPage = 0;
        //?????????????????????????????????????????????????????????????????????????????????1
        if (amountRemainder != 0) {
            numPage = amountDivisor + 1;
        } else {
            numPage = amountDivisor;
        }
        //?????????????????????????????????????????????list???????????????????????????????????????????????????null???????????????????????????"Y",??????????????????
        if(ent>numPage){
            logger.error("###{}###","THE PAGE NUMBER EXCEEDS THE MAXIMUM PAGE NUMBER");
            RspHead rspHead = new RspHead();
            rspHead.setErrorMsg("THE PAGE NUMBER EXCEEDS THE MAXIMUM PAGE NUMBER");
            pasPadiSwfRspDTO.setRspHead(rspHead);
            pasPadiSwfRspDTO.setEndFlg("Y");
            rspDTO.setBody(pasPadiSwfRspDTO);
            return rspDTO;
        }
        //?????????????????????????????????????????????????????????????????????????????????Y???
        if (numPage == 1) {
            for (String str : list) {
                dtlsList.add(str);
                mTTxtDOs.setDtlsList(dtlsList);
            }
            pasPadiSwfRspDTO.setmTTxtDOs(mTTxtDOs);
            pasPadiSwfRspDTO.setEndFlg("Y");
            pasPadiSwfRspDTO.setOutEnt(ent);
            rspDTO.setBody(pasPadiSwfRspDTO);
            logger.info("###{}###{}","Get detailed data based on page number and message number","---end---");
            return rspDTO;
        }
        //???????????????%????????????????????????????????????????????????????????????
        if(amountRemainder!=0){
            //????????????????????????????????????0,?????????????????????????????????????????????
            if (ent == numPage) {
                //?????????????????????????????????????????????????????????,list??????????????????%?????????????????????????????????????????????????????????
                for (int j = 0; j < amountRemainder; j++) {
                    String dtlsStr = list.get(index);
                    dtlsList.add(dtlsStr);
                    mTTxtDOs.setDtlsList(dtlsList);
                    index++;
                }
                pasPadiSwfRspDTO.setmTTxtDOs(mTTxtDOs);
                pasPadiSwfRspDTO.setEndFlg("Y");
                pasPadiSwfRspDTO.setOutEnt(ent);
                /*rspDTO.setBody(pasPadiSwfRspDTO);
                return rspDTO;*/
            }else{
                //????????????????????????????????????,???????????????40????????????????????????N?????????PAS????????????????????????????????????
                for (int k = 0; k < messageLine; k++) {
                    String dtlsStr = list.get(index);
                    dtlsList.add(dtlsStr);
                    mTTxtDOs.setDtlsList(dtlsList);
                    index++;
                }
                pasPadiSwfRspDTO.setmTTxtDOs(mTTxtDOs);
                pasPadiSwfRspDTO.setEndFlg("N");
                pasPadiSwfRspDTO.setOutEnt(ent);
               /* rspDTO.setBody(pasPadiSwfRspDTO);
                return rspDTO;*/
            }
        }else {
            //?????????????????????????????????0,?????????????????????????????????
            if (ent == numPage) {
                //??????????????????????????????????????????????????????????????????
                for (int j = 0; j < messageLine; j++) {
                    String dtlsStr = list.get(index);
                    dtlsList.add(dtlsStr);
                    mTTxtDOs.setDtlsList(dtlsList);
                    index++;
                }
                pasPadiSwfRspDTO.setmTTxtDOs(mTTxtDOs);
                pasPadiSwfRspDTO.setEndFlg("Y");
                pasPadiSwfRspDTO.setOutEnt(ent);
                /*rspDTO.setBody(pasPadiSwfRspDTO);
                return rspDTO;*/
            } else {
                //????????????????????????????????????,???????????????40????????????????????????N?????????PAS????????????????????????????????????
                for (int k = 0; k < messageLine; k++) {
                    String dtlsStr = list.get(index);
                    dtlsList.add(dtlsStr);
                    mTTxtDOs.setDtlsList(dtlsList);
                    index++;
                }
                pasPadiSwfRspDTO.setmTTxtDOs(mTTxtDOs);
                pasPadiSwfRspDTO.setEndFlg("N");
                pasPadiSwfRspDTO.setOutEnt(ent);
                /*rspDTO.setBody(pasPadiSwfRspDTO);
                return rspDTO;*/
            }
        }
        logger.info("###{}###{}","Get detailed data based on page number and message number","---end---");
        rspDTO.setBody(pasPadiSwfRspDTO);
        return rspDTO;
    }

    /**
     * ????????????rmc???????????????
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<RedisbuteMsgRspDTO> redisbuteMsg(GenericDTO<RedisbuteMsgReqDTO> reqDto) {
        String msgNo = reqDto.getBody().getMsgNo();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        reqHead.setTxnCode("23635");
        String msgCd = sendService.redistriMsg(msgNo,reqHead);
        RedisbuteMsgRspDTO redisbuteMsgRspDTO = new RedisbuteMsgRspDTO();
        GenericRspDTO rspDTO = new GenericRspDTO();
        if (JudgeUtils.isNotSuccess(msgCd)) {
            logger.error("##### MESSAGE DISPATCH AND IMPORT ERROR:{},MSG NO:{}", msgCd,msgNo);
            if (MTConstants.MT_AUTO_SEND_OR_ERR.equals(msgCd)){
                redisbuteMsgRspDTO.setErrCd(99);
                RspHead rspHead = new RspHead();
                rspHead.setErrorMsg("GPI PUSH INFO TO OR ERROR");
                redisbuteMsgRspDTO.setRspHead(rspHead);
                rspDTO.setMsgCd(MTConstants.MT_AUTO_SEND_OR_ERR);
                rspDTO.setMsgInfo("GPI PUSH INFO TO OR ERROR");
                rspDTO.setBody(redisbuteMsgRspDTO);
                return rspDTO;
            }
            redisbuteMsgRspDTO.setErrCd(99);
            redisbuteMsgRspDTO.getRspHead().setErrorMsg("MT AUTO SEND IR ERROR");
            rspDTO.setMsgCd(MTConstants.MT_AUTO_SEND_ERR);
            rspDTO.setMsgInfo("MT AUTO SEND IR ERROR");
            rspDTO.setBody(redisbuteMsgRspDTO);
            return rspDTO;
        }else {
            //????????????????????????????????????
            RspHead rspHead = new RspHead();
            BeanUtils.copyProperties(reqHead,rspHead);
            rspHead.setTxnCode("23635");
            rspHead.setTxnType("N");
            rspDTO.setMsgCd(msgCd);
            redisbuteMsgRspDTO.setRspHead(rspHead);
            rspDTO.setBody(redisbuteMsgRspDTO);
            return rspDTO;
        }
    }


}
