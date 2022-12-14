package com.hisun.kont.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.KontJsonUtil;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.KontData;
import com.hisun.kont.framework.data.KontHolder;
import com.hisun.kont.igw.igw.remote.SendRemitMessageRspDTO;
import com.hisun.kont.job.remote.JobDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgTagDescribeDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.entity.PgTagDescribeDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.mt.remote.EaiHeaderDTO;
import com.hisun.kont.pg.mt.remote.Fmt103;
import com.hisun.kont.pg.mt.remote.Fmt202;
import com.hisun.kont.pg.mt.remote.SwHeader;
import com.hisun.kont.pg.mt.remote.UserHeaderDO;
import com.hisun.kont.pg.service.PgstpswftoteleService;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.utils.*;
import com.hisun.kont.pyrm.client.BusinessLogServiceClient;
import com.hisun.kont.pyrm.client.ComnMethodServiceClient;
import com.hisun.kont.pyrm.client.InwardInterFaceServiceClient;
import com.hisun.kont.pyrm.ir.remote.InwardCheckVerifyMsgReqDTO;
import com.hisun.kont.pyrm.ir.remote.InwardCheckVerifyMsgRspDTO;
import com.hisun.kont.pyrm.py.remote.*;
import com.hisun.kont.swf.mt.message.*;
import com.hisun.kont.swf.mt.message.header.*;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;
import com.hisun.kont.swf.mt.tag.Tag20;
import com.hisun.kont.swf.mt.tag.Tag21;
import com.hisun.kont.swf.mt.tag.Tag79;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yupeifeng
 * @ClassName: CommonAssembleImpl
 * @Date 2021/12/2 10:23
 * @Description ???????????????????????????(????????????????????????) ???Flag???????????????????????????
 * @Version 1.0
 **/

@Service
@Transactional
public class CommonAssembleImpl {

    private static final Logger logger = LoggerFactory.getLogger(CommonAssembleImpl.class);

    @Resource
    MTAssemblyServiceImpl mtAssemblyService;

    @Resource
    PgTagDescribeDao pgTagDescribeDao;

    @Resource
    private ComnMethodServiceClient comnMethodServiceClient;

    @Resource
    private CallRmcServiceImpl callRmcService;

    @Resource
    private SpecialMTServiceImpl specialMTService;

    @Resource
    private PgstpswftoteleService pgstpswftoteleService;

    @Resource
    private InwardInterFaceServiceClient inwardInterFaceServiceClient;

    @Resource
    private PgstsService pgstsService;

    @Resource
    private PgMatchServiceImpl pgMatchService;

    @Resource
    private BusinessLogServiceClient businessLogServiceClient;


    /**
     * ?????????????????????????????????
     *
     * @param fmt  ??????????????????(??????????????????)
     * @param flag ???????????????????????????
     * @param <T>  ??????
     */
    public <T> MtDto comAssembleMessage(T fmt, BaseMessage baseMessage, String flag, ReqHead reqHead,String recBankName) {
        logger.info("##### START TO ASSEMBLY MESSAGE #####");
        MtDto mto = null;
        //??????fmt????????????????????????
        String cnFlag = null;
        Class fmtClass = fmt.getClass();
        //?????????????????????  ???????????????????????????

        Method getSwHeaderMethod = null;
        SwHeader swHeader = null;
        //????????????????????????????????????swHeader
        try {
            getSwHeaderMethod = fmtClass.getMethod("getSwHeader");
            swHeader = (SwHeader) getSwHeaderMethod.invoke(fmt);
        } catch (Exception e) {
            logger.error("##### REFLECTION GET SWHEADER EXCEPTION #####");
            KontException.throwKontException(MTConstants.FMT_GET_SWHEADER_ERR);
        }
        //??????MT??????
        logger.info("##### START TO MAPPING DTO TO MT OBJECT #####");
        CopyTagUtils.mappingDtoToMt(fmt, baseMessage);
        logger.info("##### END TO MAPPING DTO TO MT OBJECT #####");
        //???????????? O?????????????????? 2?????????sender
        CopyTagUtils.CphaderInfo("O", swHeader, baseMessage);
        //????????????
        logger.info("##### START TO MESSAGE ASSEMBLY #####");
        String mtStr = this.assembleMTMessage(baseMessage);
        logger.info("##### END TO MESSAGE ASSEMBLY #####");
        //?????????????????? ???????????????
        String msgNo = null;
        if (JudgeUtils.isNotNull(swHeader.getMsgNo())) {
            msgNo = swHeader.getMsgNo();
        } else {
            //??????????????????????????? ?????????  ??????????????????
            //?????????Y ??????????????????????????????
            if ("Y".equals(flag)){
                logger.error("##### SEND MESSAGE MSGNO IS NULL #####");
                KontException.throwBusinessException(MTConstants.MT_MSGNO_IS_NULL);
            }
        }
        //??????GPI?????? 001???002???GPI??????
        String ohGpcFlg = null;
        String ohCov = null;
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDO = swHeader.getUserHeaderDO();
            ohGpcFlg = userHeaderDO.getOhGpcFlg();
            ohCov = userHeaderDO.getOhCov();
        }
        //?????????????????? appHeaderMessage 2?????????
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //ohGpiRef gpi??????
        String ohGpiRef = baseMessage.getUserHeaderBlock().getOhGpiRef();
        //?????????BicCode
        String bhSndlt = swHeader.getBasicHeaderDO().getBhSndlt();
        String senderName = null;
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            //?????????BIC
            String ahRcvlt = swHeader.getAppHeaderSenderDO().getAhRcvlt();
            //????????????cor ??????????????????
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////??????????????? ???????????????cor
                senderName = mtAssemblyService.getBankName(bhSndlt, reqHead);
                if (JudgeUtils.isNull(recBankName)){
                    recBankName = mtAssemblyService.getBankName(ahRcvlt, reqHead);
                }else {
                    recBankName = recBankName.trim();
                }
            }
            String ahMt = swHeader.getAppHeaderSenderDO().getAhMt();
            //??????tag??????
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //??????650????????????
            String printContent = TeleCh650Util.orgMessageTo650(mtStr, msgNo, ahMt,
                    bhSndlt, senderName, recBankName, ahRcvlt, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //??????????????????
            mto = mtAssemblyService.generateMtDto(msgNo, mtStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
            //?????????BIC
            String sender = swHeader.getAppHeaderReciverDO().getAhRefNo().substring(6, 14) + swHeader.getAppHeaderReciverDO().getAhRefNo().substring(15, 18);
            String receBic = bhSndlt;
            //????????????cor  ??????????????????
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////??????????????? ???????????????cor
                recBankName= mtAssemblyService.getBankName(receBic, reqHead);
                senderName = mtAssemblyService.getBankName(sender, reqHead);
            }
            String ahMt = swHeader.getAppHeaderReciverDO().getAhMt();
            //??????tag??????
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //??????650????????????
            String printContent = TeleCh650Util.orgMessageTo650(mtStr, msgNo, ahMt,
                    sender, senderName, recBankName, receBic, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //??????????????????
            mto = mtAssemblyService.generateMtDto(msgNo, mtStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else {
            //?????????2?????????
            logger.error("##### APP HEADER IS NULL #####");
            KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY);
        }
        logger.info("##### END TO ASSEMBLY MESSAGE #####");
        return mto;
    }

    /**
     * ?????????????????????????????????
     * @param bankNo ?????????
     * @return
     */
    public String getMsgNo(String flag, String bankNo) {
        logger.info("##### DO YOU GET MESSAGE NUMBER:{}",flag);
        String msgNo = null;
        //???????????? ????????????????????????
        if ("Y".equals(flag)) {
            logger.info("##### START TO CALL PY INTERFACE TO GET MESSAGE NUMBER #####");
            GenericDTO<GetMessageNumReqDTO> getMessageNumReqDTOGenericDTO = new GenericDTO<>();
            GetMessageNumReqDTO getMessageNumReqDTO = new GetMessageNumReqDTO();
            getMessageNumReqDTO.setBankNo(bankNo);
            getMessageNumReqDTO.setMessageFlag("O");
            getMessageNumReqDTOGenericDTO.setBody(getMessageNumReqDTO);
            GenericRspDTO<GetMessageNumRspDTO> messageNum = comnMethodServiceClient.getMessageNum(getMessageNumReqDTOGenericDTO);
            GetMessageNumRspDTO body = messageNum.getBody();
            msgNo = body.getMessageNum();
            logger.info("##### END TO CALL PY INTERFACE TO GET MESSAGE NUMBER:{}",msgNo);
        }
        return msgNo;
    }

    /**
     * ????????????????????????????????????(????????????)
     * @param ahMt ????????????
     * @return
     */
    public Map<String, String> getTagDescribe(String ahMt,String ohCov) {
        logger.info("##### START TO GET MT TAG DESCRIPTION,MT TYPE:{}",ahMt);
        PgTagDescribeDO pgTagDescribeDO = new PgTagDescribeDO();
        pgTagDescribeDO.setAhMt(ahMt);
        Map<String, String> map = new HashMap<>();
        List<PgTagDescribeDO> pgTagDescribeDaoList = pgTagDescribeDao.findList(pgTagDescribeDO);
        for (PgTagDescribeDO tagDescribeDO : pgTagDescribeDaoList) {
            String tagKey = tagDescribeDO.getMtTagKey();
            String tagValue = tagDescribeDO.getTagValue();
            if (tagKey.contains(" ")) {
                tagKey = tagKey.substring(0, 4);
            }
            map.put(tagKey, tagValue);
        }
        //?????????202COV ????????????103?????????tag?????? 33B 50 59 70
        if ("202".equals(ahMt) && JudgeUtils.isNotNull(ohCov)){
            logger.info("##### GET MT103 TAG DESCRIPTION TO MT202COV SEQB #####");
            PgTagDescribeDO tagDescribeDOFor103 = new PgTagDescribeDO();
            tagDescribeDOFor103.setAhMt("103");
            List<PgTagDescribeDO> list = pgTagDescribeDao.findList(tagDescribeDOFor103);
            for (PgTagDescribeDO tagDescribeDO : list) {
                String tagKey = tagDescribeDO.getMtTagKey();
                if (tagKey.contains("33B") || tagKey.contains("50") || tagKey.contains("56C") || tagKey.contains("59") || tagKey.contains("70")){
                    String tagValue = tagDescribeDO.getTagValue();
                    if (tagKey.contains(" ")) {
                        tagKey = tagKey.substring(0, 4);
                    }
                    map.put(tagKey, tagValue);
                }
            }
        }
        logger.info("##### END TO GET MT TAG DESCRIPTION #####");
        return map;
    }

    /**
     * ???????????? ???igw?????????rmc  ?????????????????????????????? ????????????
     *
     * @param rmcTrx01     rmc??????
     * @param mtDto        ??????????????????
     * @param pgstsDO      ????????????
     * @param reqHead      eai???
     * @param eaiHeaderDTO ???EAI???
     */
    public String comSendMessage(RmcTrx01 rmcTrx01, ReqHead reqHead, EaiHeaderDTO eaiHeaderDTO, MtDto mtDto, PgstsDO pgstsDO) {
        logger.info("##### START TO ASSEMBLE RMC DATA AND SEND MT MESSAGE #####");
        //????????????rmc???????????????
        rmcTrx01.setMt(Integer.valueOf(mtDto.getAhMt()));
        rmcTrx01.setSwiftInfo(mtDto.getMtStr());
        rmcTrx01.setMsgLen(mtDto.getMtStr().length());
        rmcTrx01.setSrcBk(mtDto.getMsgNo().substring(0, 3));
        rmcTrx01.setSrcDate(mtDto.getMsgNo().substring(3, 11));
        rmcTrx01.setSrcSeq(mtDto.getMsgNo().substring(11));
        Object rmcJson = JSONObject.toJSON(rmcTrx01);
        pgstsDO.setMtBean(rmcJson.toString());
        GenericDTO<SendRemitMsgReqPGDTO> reqPGDTOGenericDTO = new GenericDTO<>();
        SendRemitMsgReqPGDTO sendRemitMsgReqPGDTO = new SendRemitMsgReqPGDTO();
        sendRemitMsgReqPGDTO.setEaiHeaderDTO(eaiHeaderDTO);
        sendRemitMsgReqPGDTO.setReqHead(reqHead);
        sendRemitMsgReqPGDTO.setRmcTrx01(rmcTrx01);
        reqPGDTOGenericDTO.setBody(sendRemitMsgReqPGDTO);
        GenericRspDTO<SendRemitMessageRspDTO> rspDTO = callRmcService.sendRemitMessagePG(reqPGDTOGenericDTO);
        //??????igw???????????????????????????????????????????????????
        if (JudgeUtils.isSuccess(rspDTO.getMsgCd()) && JudgeUtils.isNotNull(rspDTO.getBody())) {
            if ("00".equals(rspDTO.getBody().getErrCode())) {
                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_SUCCESS);
                pgstsService.updateMtStatus(pgstsDO);
                logger.info("#### CALL IGW AND RMC SEND MT MESSAGE SUCCESS ######");
                return MTConstants.SEND_MESSAGE_SUCCESS;
                //igw??????40 ??? ??????????????? RTN DUPLICATE ????????????????????? ??????????????????
            }else if ("40".equals(rspDTO.getBody().getErrCode()) && (MTInStatusConstants.MT_RTN_DUP.equals(rspDTO.getBody().getRspHead().getErrorMsg())
            || MTInStatusConstants.MT_DUP_MSG.equals(rspDTO.getBody().getRspHead().getErrorMsg()))){
                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_SUCCESS);
                pgstsService.updateMtStatus(pgstsDO);
                logger.info("#### DUPLICATE MESSAGE AND CALL IGW AND RMC SEND MT MESSAGE SUCCESS ######");
                return MTConstants.SEND_MESSAGE_SUCCESS;
            }else {
                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_FAIL);
                pgstsService.updateMtStatus(pgstsDO);
                logger.error("##### SEND MESSAGE RMC RETURN FAIL:{} ,MSG NO:{}",rspDTO.getBody().getErrCode(),pgstsDO.getMsgNo());
                return MTConstants.SEND_MESSAGE_FAIL;
            }
        } else {
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_FAIL);
            pgstsService.updateMtStatus(pgstsDO);
            logger.error("##### CALL IGW AND RMC SEND MT MESSAGE FAIL:{} ,MSG NO:{}",rspDTO.getMsgCd(),pgstsDO.getMsgNo());
            return rspDTO.getMsgCd();
        }
    }

    /**
     * ??????????????????psgts?????????
     *
     * @param remitReqDTO ??????
     * @param pgstsDO     ????????????
     * @param mtDto       ????????????
     * @param swHeader    ??????
     * @param reqHead     eai??????
     * @param <T>
     */
    public <T> void messageForPgsts(T remitReqDTO, PgstsDO pgstsDO, MtDto mtDto, SwHeader swHeader, ReqHead reqHead) {
        logger.info("##### START TO SAVE MT MESSAGE INFO #####");
        String msgNo = mtDto.getMsgNo();
        String mtStr = mtDto.getMtStr();
        pgstsDO.setMtSeq(1);
        pgstsDO.setMsgNo(msgNo);
        //?????????????????????????????????
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        pgstsDO.setMtStr(mtStr);
        //?????????????????????
        pgstsDO.setMtStatus(" ");
        pgstsDO.setMtMessage(mtDto.getMessage());
        pgstsDO.setUpdateLastTime(sysLocalDate);
        //????????????????????????????????????
        LocalDate acDate = mtAssemblyService.getAcDate();
        pgstsDO.setAcDate(acDate);
//        pgstsDO.setUpdateLastAcDate(acDate);
        //???????????? ???eai??????????????????
        if (JudgeUtils.isNull(swHeader.getTxnCode())) {
            if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
                pgstsDO.setTxncode(reqHead.getTxnCode());
            }
        }
        //???????????? ???eai??????????????????
        if (JudgeUtils.isNull(swHeader.getLogNumber())) {
            if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
                pgstsDO.setLogNumber(reqHead.getJournalNo());
            }
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgstsDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgstsDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate updateAcDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgstsDO.setUpdateLastAcDate(updateAcDate);
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgstsDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        pgstsService.insertMtByDalete(pgstsDO);
        logger.info("##### END TO SAVE MT MESSAGE #####");
        //match?????? ???????????????match???????????????????????????
        if (JudgeUtils.isNotNull(pgstsDO.getMsgNo()) && JudgeUtils.isNotNull(pgstsDO.getPagmchOurRef())){
            logger.info("##### START TO SAVE MT MESSAGE MATCH INFO #####");
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
            pgMatchDO.setPagmchOurRef(pgstsDO.getPagmchOurRef());
            //???????????????????????????????????????
            pgMatchDO.setCreatedTime(sysLocalDate);
            pgMatchDO = setLastUpdateParams(reqHead, pgMatchDO);
            int result = pgMatchService.insertPgMatch(pgMatchDO);
            logger.info("##### END TO SAVE MT MESSAGE MATCH INFO,RESULT:{}",result);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO #####");
    }

    /**
     * fmt103????????????????????????????????????
     * ????????????????????????????????????????????????
     * @param fmt103
     * @return
     */
    public Fmt103 cnToTeleFor103(Fmt103 fmt103) {
        //??????103???????????????????????? ???????????????  CN???????????????
        logger.info("##### START TO CHINESE TO TELE CODE FOR FMT103 #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt103.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt103.getSwHeader().getTraditionalFlag();
            fmt103 = pgstpswftoteleService.getTagCnToTeleFor103(fmt103, traditionalFlag);
        }else {
            //?????????????????????????????? ???????????????????????????
            return fmt103;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT103 #####");
        return fmt103;
    }

    /**
     * ??????202COV???seqB???????????????
     * @param fmt103
     * @return
     */
    public Fmt103 cnToTeleForSeqB(Fmt103 fmt103,Fmt202 fmt202) {
        //??????103???????????????????????? ???????????????  CN???????????????
        logger.info("##### START TO CHINESE TO TELE CODE FOR MT202COV SEQB #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt202.getSwHeader().getTraditionalFlag();
            fmt103 = pgstpswftoteleService.getTagCnToTeleFor103(fmt103, traditionalFlag);
        }else {
            //?????????????????????????????? ???????????????????????????
            return fmt103;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR MT202COV SEQB #####");
        return fmt103;
    }

    /**
     * fmt200????????????????????????????????????
     *
     * @param fmt200
     * @return
     */
    public Fmt200 cnToTeleFor200(Fmt200 fmt200) {
        logger.info("##### START TO CHINESE TO TELE CODE FOR FMT200 #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt200.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt200.getSwHeader().getTraditionalFlag();
            fmt200 = pgstpswftoteleService.getTagCnToTeleFor200(fmt200, traditionalFlag);
        }else {
            //?????????????????????????????? ???????????????????????????
            return fmt200;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT200 #####");
        return fmt200;
    }

    /**
     * fmt202????????????????????????????????????
     *
     * @param fmt202
     * @return
     */
    public Fmt202 cnToTeleFor202(Fmt202 fmt202) {
        logger.info("##### START TO CHINESE TO TELE CODE FOR FMT202 #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt202.getSwHeader().getTraditionalFlag();
            fmt202 = pgstpswftoteleService.getTagCnToTeleFor202(fmt202, traditionalFlag);
        }else {
            //?????????????????????????????? ???????????????????????????
            return fmt202;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT202 #####");
        return fmt202;
    }

    /**
     * ???????????????????????????????????? ???????????????  ??????  ????????????
     *
     * @param msgNo
     * @return
     */
    public String getMatchMessage(String msgNo) {
        logger.info("##### START TO GET MATCH MESSAGE FOR 23650 FROM IMPORT ,MSGNO:{}",msgNo);
        StringBuilder str650 = new StringBuilder();
        String lineFeed = "\r\n";
        GenericDTO<InwardCheckVerifyMsgReqDTO> reqDTOGenericDTO = new GenericDTO<>();
        InwardCheckVerifyMsgReqDTO verifyMsgReqDTO = new InwardCheckVerifyMsgReqDTO();
        verifyMsgReqDTO.setMsgNo(msgNo);
        reqDTOGenericDTO.setBody(verifyMsgReqDTO);
        GenericRspDTO<InwardCheckVerifyMsgRspDTO> rspDTO = inwardInterFaceServiceClient.inwardCheckVerifyMsg(reqDTOGenericDTO);
        InwardCheckVerifyMsgRspDTO checkVerifyMsgRspDTO = rspDTO.getBody();
        if ("000".equals(checkVerifyMsgRspDTO.getReturnCode()) && JudgeUtils.isSuccess(rspDTO.getMsgCd())) {
            logger.info("##### HAVE MATCH MESSAGE #####");
            //???????????? N92 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getStopMsgNo())) {
                String stopMsgNo = checkVerifyMsgRspDTO.getStopMsgNo();
                String stopMsgType = checkVerifyMsgRspDTO.getStopMsgType();
                str650.append("**********STOP PAYMNET???S INFORMATION.*************" + lineFeed);
                str650.append("STOP SWIFT KEY : " + stopMsgNo + "   " + "STOP TYPE: " + stopMsgType + "   " + "STOP CHNL: FTM" + lineFeed);

            }
            //???????????? N96 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getReplyMsgNo())) {
                String replyMsgNo = checkVerifyMsgRspDTO.getReplyMsgNo();
                String replyMsgType = checkVerifyMsgRspDTO.getReplyMsgType();
                str650.append("REPLY SWIFT KEY : " + replyMsgNo + "   " + "RPLY TYPE: " + replyMsgType + "   " + "RPLY CHNL: SWF" + lineFeed);
            }
            //????????????1 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo1())) {
                String matchingMsgNo1 = checkVerifyMsgRspDTO.getMatchingMsgNo1();
                String matchingMsgType1 = checkVerifyMsgRspDTO.getMatchingMsgType1();
                str650.append("**********RELATE SWIFT/CHATS INFORMATION**********" + lineFeed);
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo1 + "     " + "MT TYPE:" + matchingMsgType1 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????2 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo2())) {
                String matchingMsgNo2 = checkVerifyMsgRspDTO.getMatchingMsgNo2();
                String matchingMsgType2 = checkVerifyMsgRspDTO.getMatchingMsgType1();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo2 + "     " + "MT TYPE:" + matchingMsgType2 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????3 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo3())) {
                String matchingMsgNo3 = checkVerifyMsgRspDTO.getMatchingMsgNo3();
                String matchingMsgType3 = checkVerifyMsgRspDTO.getMatchingMsgType3();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo3 + "     " + "MT TYPE:" + matchingMsgType3 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????4 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo4())) {
                String matchingMsgNo4 = checkVerifyMsgRspDTO.getMatchingMsgNo4();
                String matchingMsgType4 = checkVerifyMsgRspDTO.getMatchingMsgType4();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo4 + "     " + "MT TYPE:" + matchingMsgType4 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????5 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo5())) {
                String matchingMsgNo5 = checkVerifyMsgRspDTO.getMatchingMsgNo5();
                String matchingMsgType5 = checkVerifyMsgRspDTO.getMatchingMsgType5();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo5 + "     " + "MT TYPE:" + matchingMsgType5 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????6 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo6())) {
                String matchingMsgNo6 = checkVerifyMsgRspDTO.getMatchingMsgNo6();
                String matchingMsgType6 = checkVerifyMsgRspDTO.getMatchingMsgType6();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo6 + "     " + "MT TYPE:" + matchingMsgType6 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????7 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo7())) {
                String matchingMsgNo7 = checkVerifyMsgRspDTO.getMatchingMsgNo7();
                String matchingMsgType7 = checkVerifyMsgRspDTO.getMatchingMsgType7();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo7 + "     " + "MT TYPE:" + matchingMsgType7 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????8 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo8())) {
                String matchingMsgNo8 = checkVerifyMsgRspDTO.getMatchingMsgNo8();
                String matchingMsgType8 = checkVerifyMsgRspDTO.getMatchingMsgType8();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo8 + "     " + "MT TYPE:" + matchingMsgType8 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //????????????9 ???650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo9())) {
                String matchingMsgNo9 = checkVerifyMsgRspDTO.getMatchingMsgNo9();
                String matchingMsgType9 = checkVerifyMsgRspDTO.getMatchingMsgType9();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo9 + "     " + "MT TYPE:" + matchingMsgType9 + "     " + "CHANNEL:SWF" + lineFeed);
            }
        } else {
            logger.info("##### NO MATCH MESSAGE #####");
        }
        logger.info("##### END TO GET MATCH MESSAGE FOR 23650 FROM IMPORT #####");
        return str650.toString();
    }

    /**
     * ???????????? ????????????
     *
     * @param baseMessage
     * @param pgstsDO
     * @param reqHead
     * @return
     */
    public PgstsDO receiveHeaderToPg(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead) {
        //???????????????1 ????????????
        logger.info("##### START TO SAVE RECEIVE MT MESSAGE HEADER #####");
        BasicHeaderBlock basicHeaderBlock = baseMessage.getBasicHeaderBlock();
        String bhSndlt = basicHeaderBlock.getBhSndlt();
        //??????block1 ????????????
        pgstsDO.setAhRcvlt(bhSndlt.substring(0, 8) + bhSndlt.substring(9));
        //???????????????3 ????????????
        if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
            UserHeaderBlock userHeaderBlock = baseMessage.getUserHeaderBlock();
            pgstsDO.setOhHkl(userHeaderBlock.getOhHkl());
            pgstsDO.setOhCov(userHeaderBlock.getOhCov());
            pgstsDO.setOhGpiRef(userHeaderBlock.getOhGpiRef());
            pgstsDO.setOhMuref(userHeaderBlock.getOhMuref());
            pgstsDO.setGpcFlag(userHeaderBlock.getOhGpcFlg());
        }
        //??????5 ????????????
        if (JudgeUtils.isNotNull(baseMessage.getTrailersBlock())) {
            TrailersBlock trailersBlock = baseMessage.getTrailersBlock();
            pgstsDO.setMtRetryFlag(trailersBlock.getMtRetryFlag());
            pgstsDO.setMtPdeNm(trailersBlock.getMtPdeNm());
            pgstsDO.setMtPdmNm(trailersBlock.getMtPdmNm());
        }
        //???????????????2 ?????? ??????
        AppHeaderBlock appHeaderBlock = baseMessage.getAppHeaderBlock();
        if (appHeaderBlock instanceof AppHeaderSenderBlock) {
            //?????????????????????I  ????????????
            AppHeaderSenderBlock appHeaderSenderBlock = (AppHeaderSenderBlock) appHeaderBlock;
            pgstsDO.setAhioFlag(appHeaderSenderBlock.getAhioFlag());
            pgstsDO.setAhMt(appHeaderSenderBlock.getAhMt());
            pgstsDO.setAhMpro(appHeaderSenderBlock.getAhMpro());
            pgstsDO.setAhRcvlt(appHeaderSenderBlock.getAhRcvlt());
            reqHead.setTxnCode("23390");
            String receiveName = mtAssemblyService.getBankName(pgstsDO.getAhRcvlt(), reqHead);
            String senderName = mtAssemblyService.getBankName(pgstsDO.getBhSndlt(), reqHead);
            Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
            String ohGpcFlg = null;
            String ohCov = null;
            if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
                ohGpcFlg = baseMessage.getUserHeaderBlock().getOhGpcFlg();
                ohCov = baseMessage.getUserHeaderBlock().getOhCov();
            }
            String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
            String orgMessage = TeleCh650Util.orgMessageTo650(pgstsDO.getMtStr(), pgstsDO.getMsgNo(), pgstsDO.getAhMt(),
                    pgstsDO.getBhSndlt(), senderName, receiveName, pgstsDO.getAhRcvlt(), map, ohCov,
                    pgstsDO.getOhGpiRef(), ohGpcFlg, appHeaderMessage);
            pgstsDO.setMtMessage(orgMessage);
        } else if (appHeaderBlock instanceof AppHeaderReciverBlock) {
            //???????????????O  ??????????????? ?????????????????????
            AppHeaderReciverBlock appHeaderReciverBlock = (AppHeaderReciverBlock) appHeaderBlock;
            //???????????????
            String ahRcvlt = appHeaderReciverBlock.getAhRefNo().substring(6, 14) + appHeaderReciverBlock.getAhRefNo().substring(15, 18);
            //??????block2 ???????????????
            pgstsDO.setBhSndlt(ahRcvlt);
            pgstsDO.setAhMt(appHeaderReciverBlock.getAhMt());
            pgstsDO.setAhMpro(appHeaderReciverBlock.getAhMpro());
            pgstsDO.setAhioFlag(appHeaderReciverBlock.getAhioFlag());
            //????????????
            pgstsDO.setIncomeDate(appHeaderReciverBlock.getAhRecDate());
            pgstsDO.setIncomeTime(appHeaderReciverBlock.getAhRecTime());
            reqHead.setTxnCode("23390");
            String receiveName = mtAssemblyService.getBankName(pgstsDO.getAhRcvlt(), reqHead);
            String senderName = mtAssemblyService.getBankName(pgstsDO.getBhSndlt(), reqHead);
            Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
            String ohGpcFlg = null;
            String ohCov = null;
            if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
                ohGpcFlg = baseMessage.getUserHeaderBlock().getOhGpcFlg();
                ohCov = baseMessage.getUserHeaderBlock().getOhCov();
            }
            String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
            String orgMessage = TeleCh650Util.orgMessageTo650(pgstsDO.getMtStr(), pgstsDO.getMsgNo(), pgstsDO.getAhMt(),
                    pgstsDO.getBhSndlt(), senderName, receiveName, pgstsDO.getAhRcvlt(), map, ohCov,
                    pgstsDO.getOhGpiRef(), ohGpcFlg, appHeaderMessage);
            pgstsDO.setMtMessage(orgMessage);
        }
        logger.info("##### END TO SAVE RECEIVE MT MESSAGE HEADER #####");
        return pgstsDO;
    }

    /**
     * ???????????????????????? ????????????????????????
     *
     * @param pgstsDO
     * @param baseMessage
     * @return
     */
    public PgstsDO mtMessageToPg(PgstsDO pgstsDO, BaseMessage baseMessage,ReqHead reqHead) {
        String mtType = baseMessage.getTxCode();
        logger.info("##### START TO SAVE MT MESSAGE INFO BY MT TYPE:{}",mtType);
        switch (mtType) {
            case "103":
                MT103 mt103 = (MT103) baseMessage;
                ArrayList<BaseTag> tagDataList103 = mt103.getTagDataList("20");
                Tag20 tag20For103 = (Tag20) tagDataList103.get(0);
                pgstsDO.setTrn(tag20For103.getTrn());
                break;

            case "190":
                MT190 mt190 = (MT190) baseMessage;
                ArrayList<BaseTag> tagDataList190 = mt190.getTagDataList("20");
                Tag20 tag20For190 = (Tag20) tagDataList190.get(0);
                pgstsDO.setTrn(tag20For190.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt190.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList190 = mt190.getTagDataList("21");
                    Tag21 tag21For190 = (Tag21) tag21DataList190.get(0);
                    String rtrn = tag21For190.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "191":
                MT191 mt191 = (MT191) baseMessage;
                ArrayList<BaseTag> tagDataList191 = mt191.getTagDataList("20");
                Tag20 tag20For191 = (Tag20) tagDataList191.get(0);
                pgstsDO.setTrn(tag20For191.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt191.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList191 = mt191.getTagDataList("21");
                    Tag21 tag21For191 = (Tag21) tag21DataList191.get(0);
                    String rtrn = tag21For191.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "192":
                MT192 mt192 = (MT192) baseMessage;
                ArrayList<BaseTag> tagDataList192 = mt192.getTagDataList("20");
                Tag20 tag20For192 = (Tag20) tagDataList192.get(0);
                pgstsDO.setTrn(tag20For192.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt192.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList192 = mt192.getTagDataList("21");
                    Tag21 tag21For192 = (Tag21) tag21DataList192.get(0);
                    String rtrn = tag21For192.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "196":
                MT196 mt196 = (MT196) baseMessage;
                ArrayList<BaseTag> tagDataList196 = mt196.getTagDataList("20");
                Tag20 tag20For196 = (Tag20) tagDataList196.get(0);
                pgstsDO.setTrn(tag20For196.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt196.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList196 = mt196.getTagDataList("21");
                    Tag21 tag21For196 = (Tag21) tag21DataList196.get(0);
                    String rtrn = tag21For196.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "199":
                MT199 mt199 = (MT199) baseMessage;
                ArrayList<BaseTag> tag20DataList199 = mt199.getTagDataList("20");
                Tag20 tag20For199 = (Tag20) tag20DataList199.get(0);
                pgstsDO.setTrn(tag20For199.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt199.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList199 = mt199.getTagDataList("21");
                    Tag21 tag21For199 = (Tag21) tag21DataList199.get(0);
                    String rtrn = tag21For199.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                //gpi 199????????????
                if (JudgeUtils.isNotNull(mt199.getUserHeaderBlock())) {
                    if ("001".equals(mt199.getUserHeaderBlock().getOhGpcFlg()) || "002".equals(mt199.getUserHeaderBlock().getOhGpcFlg())) {
                        logger.info("##### START TO AUTO MATCH AND PUSH F79 TO OR FOR GPIN99 #####");
                        ArrayList<BaseTag> tagDataListFor199 = mt199.getTagDataList("79");
                        Tag79 tag79For199 = (Tag79) tagDataListFor199.get(0);
                        List<String> narratList = tag79For199.getNarratList();
                        GpiF79DTO f79Value = AssembleUtils.getF79Value(narratList);
                        //79???????????????
                        pgstsDO.setGpiDate(f79Value.getGpiDate());
                        pgstsDO.setGpiTime(f79Value.getGpiTime());
                        pgstsDO.setGpiTimezone(f79Value.getGpiZone());
                        pgstsDO.setGpiStatus(f79Value.getGpiStatus());
                        pgstsDO.setGpiReasonCode(f79Value.getGpiReasonCode());
                        pgstsDO.setMtNarrat(narratList.toString());
                        String ohGpiRef = mt199.getUserHeaderBlock().getOhGpiRef();
                        ArrayList<BaseTag> tagDataListFor21 = mt199.getTagDataList("21");
                        Tag21 tag21For199 = (Tag21)tagDataListFor21.get(0);
                        String rtrn = tag21For199.getRtrn();
                        specialMTService.autoMatchGpiN99(pgstsDO,f79Value,ohGpiRef,rtrn,reqHead);
                        logger.info("##### END TO AUTO MATCH AND PUSH F79 TO OR FOR GPIN99 #####");
                    }
                }

                break;
            case "200":
                MT200 mt200 = (MT200) baseMessage;
                ArrayList<BaseTag> tagDataList200 = mt200.getTagDataList("20");
                Tag20 tag20For200 = (Tag20) tagDataList200.get(0);
                pgstsDO.setTrn(tag20For200.getTrn());
                break;

            case "202":
                if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())){
                    String ohCov = baseMessage.getUserHeaderBlock().getOhCov();
                    //???202COV  ??? ??????202??????
                    if ("COV".equals(ohCov)){
                        MT202Cov mt202cov = (MT202Cov) baseMessage;
                        ArrayList<BaseTag> tagDataList202 = mt202cov.getTagDataList("20","A");
                        Tag20 tag20For202 = (Tag20) tagDataList202.get(0);
                        pgstsDO.setTrn(tag20For202.getTrn());
                        //??????????????????
                        if (JudgeUtils.isNotNull(mt202cov.getTagDataList("21","A"))) {
                            ArrayList<BaseTag> tag21DataList202 = mt202cov.getTagDataList("21","A");
                            Tag21 tag21For202 = (Tag21) tag21DataList202.get(0);
                            String rtrn = tag21For202.getRtrn();
                            pgstsDO.setRtrn(rtrn);
                        }
                    }else {
                        MT202 mt202 = (MT202) baseMessage;
                        ArrayList<BaseTag> tagDataList202 = mt202.getTagDataList("20");
                        Tag20 tag20For202 = (Tag20) tagDataList202.get(0);
                        pgstsDO.setTrn(tag20For202.getTrn());
                        //??????????????????
                        if (JudgeUtils.isNotNull(mt202.getTagDataList("21"))) {
                            ArrayList<BaseTag> tag21DataList202 = mt202.getTagDataList("21");
                            Tag21 tag21For202 = (Tag21) tag21DataList202.get(0);
                            String rtrn = tag21For202.getRtrn();
                            pgstsDO.setRtrn(rtrn);
                        }
                    }
                }else {
                    MT202 mt202 = (MT202) baseMessage;
                    ArrayList<BaseTag> tagDataList202 = mt202.getTagDataList("20");
                    Tag20 tag20For202 = (Tag20) tagDataList202.get(0);
                    pgstsDO.setTrn(tag20For202.getTrn());
                    //??????????????????
                    if (JudgeUtils.isNotNull(mt202.getTagDataList("21"))) {
                        ArrayList<BaseTag> tag21DataList202 = mt202.getTagDataList("21");
                        Tag21 tag21For202 = (Tag21) tag21DataList202.get(0);
                        String rtrn = tag21For202.getRtrn();
                        pgstsDO.setRtrn(rtrn);
                    }
                }
                break;

            case "210":
                MT210 mt210 = (MT210) baseMessage;
                ArrayList<BaseTag> tagDataList210 = mt210.getTagDataList("20");
                Tag20 tag20For210 = (Tag20) tagDataList210.get(0);
                pgstsDO.setTrn(tag20For210.getTrn());
                //21???List??????
                break;

            case "290":
                MT290 mt290 = (MT290) baseMessage;
                ArrayList<BaseTag> tagDataList290 = mt290.getTagDataList("20");
                Tag20 tag20For290 = (Tag20) tagDataList290.get(0);
                pgstsDO.setTrn(tag20For290.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt290.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList290 = mt290.getTagDataList("21");
                    Tag21 tag21For290 = (Tag21) tag21DataList290.get(0);
                    String rtrn = tag21For290.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "291":
                MT291 mt291 = (MT291) baseMessage;
                ArrayList<BaseTag> tagDataList291 = mt291.getTagDataList("20");
                Tag20 tag20For291 = (Tag20) tagDataList291.get(0);
                pgstsDO.setTrn(tag20For291.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt291.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList291 = mt291.getTagDataList("21");
                    Tag21 tag21For291 = (Tag21) tag21DataList291.get(0);
                    String rtrn = tag21For291.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "292":
                MT292 mt292 = (MT292) baseMessage;
                ArrayList<BaseTag> tagDataList292 = mt292.getTagDataList("20");
                Tag20 tag20For292 = (Tag20) tagDataList292.get(0);
                pgstsDO.setTrn(tag20For292.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt292.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList292 = mt292.getTagDataList("21");
                    Tag21 tag21For292 = (Tag21) tag21DataList292.get(0);
                    String rtrn = tag21For292.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "296":
                MT296 mt296 = (MT296) baseMessage;
                ArrayList<BaseTag> tagDataList296 = mt296.getTagDataList("20");
                Tag20 tag20For296 = (Tag20) tagDataList296.get(0);
                pgstsDO.setTrn(tag20For296.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt296.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList296 = mt296.getTagDataList("21");
                    Tag21 tag21For296 = (Tag21) tag21DataList296.get(0);
                    String rtrn = tag21For296.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "299":
                MT299 mt299 = (MT299) baseMessage;
                ArrayList<BaseTag> tagDataList299 = mt299.getTagDataList("20");
                Tag20 tag20For299 = (Tag20) tagDataList299.get(0);
                pgstsDO.setTrn(tag20For299.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt299.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList299 = mt299.getTagDataList("21");
                    Tag21 tag21For299 = (Tag21) tag21DataList299.get(0);
                    String rtrn = tag21For299.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                //gpi 299????????????
                if (JudgeUtils.isNotNull(mt299.getUserHeaderBlock())) {
                    if ("001".equals(mt299.getUserHeaderBlock().getOhGpcFlg()) || "002".equals(mt299.getUserHeaderBlock().getOhGpcFlg())) {
                        ArrayList<BaseTag> tagDataListFor299 = mt299.getTagDataList("79");
                        Tag79 tag79For299 = (Tag79) tagDataListFor299.get(0);
                        List<String> narratList = tag79For299.getNarratList();
                        GpiF79DTO f79Value = AssembleUtils.getF79Value(narratList);
                        pgstsDO.setGpiDate(f79Value.getGpiDate());
                        pgstsDO.setGpiTime(f79Value.getGpiTime());
                        pgstsDO.setGpiTimezone(f79Value.getGpiZone());
                        pgstsDO.setGpiStatus(f79Value.getGpiStatus());
                        pgstsDO.setGpiReasonCode(f79Value.getGpiReasonCode());
                        pgstsDO.setMtNarrat(narratList.toString());
                        //GPI????????????
                        String ohGpiRef = mt299.getUserHeaderBlock().getOhGpiRef();
                        ArrayList<BaseTag> tagDataListFor21 = mt299.getTagDataList("21");
                        Tag21 tag21For299 = (Tag21)tagDataListFor21.get(0);
                        String rtrn = tag21For299.getRtrn();
                        specialMTService.autoMatchGpiN99(pgstsDO,f79Value,ohGpiRef,rtrn,reqHead);
                    }
                }
                break;

            case "900":
                MT900 mt900 = (MT900) baseMessage;
                ArrayList<BaseTag> tagDataList900 = mt900.getTagDataList("20");
                Tag20 tag20For900 = (Tag20) tagDataList900.get(0);
                pgstsDO.setTrn(tag20For900.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt900.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList900 = mt900.getTagDataList("21");
                    Tag21 tag21For900 = (Tag21) tag21DataList900.get(0);
                    String rtrn = tag21For900.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "910":
                MT910 mt910 = (MT910) baseMessage;
                ArrayList<BaseTag> tagDataList910 = mt910.getTagDataList("20");
                Tag20 tag20For910 = (Tag20) tagDataList910.get(0);
                pgstsDO.setTrn(tag20For910.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt910.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList910 = mt910.getTagDataList("21");
                    Tag21 tag21For910 = (Tag21) tag21DataList910.get(0);
                    String rtrn = tag21For910.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            case "950":
                MT950 mt950 = (MT950) baseMessage;
                ArrayList<BaseTag> tagDataList950 = mt950.getTagDataList("20");
                Tag20 tag20For950 = (Tag20) tagDataList950.get(0);
                pgstsDO.setTrn(tag20For950.getTrn());
                break;

            case "999":
                MT999 mt999 = (MT999) baseMessage;
                ArrayList<BaseTag> tagDataList999 = mt999.getTagDataList("20");
                Tag20 tag20For999 = (Tag20) tagDataList999.get(0);
                pgstsDO.setTrn(tag20For999.getTrn());
                //??????????????????
                if (JudgeUtils.isNotNull(mt999.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList999 = mt999.getTagDataList("21");
                    Tag21 tag21For999 = (Tag21) tag21DataList999.get(0);
                    String rtrn = tag21For999.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            default:
                //RPS?????? ????????????????????????
                KontException.throwKontException(MTConstants.MT_TYPE_NOT_SUPPORT);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO BY MT TYPE:{}",mtType);
        return pgstsDO;
    }

    /**
     * ?????????????????? ????????????????????????????????????????????? ????????? ??????toRMC
     *
     * @param mtStr
     * @return
     */
    public BaseMessage disassemblyMessage(String mtStr, PgstsDO pgstsDO, ReqHead reqHead) {
        logger.info("##### START TO DISASSEMBLY RECEIVE MT MESSAGE HEADER #####");
        MessageEnvelope envelope = new MessageEnvelope(mtStr);
        envelope.paserStrToBlockMap();
        BaseMessage baseMessage = new BaseMessage();
        //????????????????????????????????? ?????????
        baseMessage = envelope.getMessageList().get(0);
        //??????????????????????????????
        pgstsDO = receiveHeaderToPg(pgstsDO, baseMessage, reqHead);
        pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DFAIL);
        pgstsService.updateMtStatus(pgstsDO);
        logger.info("##### END TO DISASSEMBLY RECEIVE MT MESSAGE HEADER #####");
        return baseMessage;
    }

    /**
     * ??????key??????  ????????????????????????????????????????????????????????? ??????????????????????????????
     * @param msgNo
     * @return
     */
    public GenericRspDTO<MtDto> repeatKeyCheck(String msgNo){
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        logger.info("##### MESSAGE NUMBER:{}",msgNo);
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
        //????????????????????????????????? ????????????
        if (JudgeUtils.isNotNull(pgstsDO) && ("OSC".equals(pgstsDO.getGwMsgStatus()) || "DELE".equals(pgstsDO.getGwMsgStatus()))){
            logger.info("##### DUPLICATE MESSAGE , RETURN SUCCESS #####");
            MtDto mtDto = new MtDto();
            mtDto.setAhMt(pgstsDO.getAhMt());
            mtDto.setMsgNo(msgNo);
            mtDto.setOhGpiRef(pgstsDO.getOhGpiRef());
            mtDto.setMessage(pgstsDO.getMtMessage());
            mtDto.setMtStr(pgstsDO.getMtStr());
            rspDto.setBody(mtDto);
            rspDto.setMsgCd(MTConstants.SEND_MESSAGE_SUCCESS);
            return rspDto;
        }
        return rspDto;
    }

    /**
     * future value?????????????????????????????????
     *
     * @param pgstsDO ???????????????????????????
     * @param baseMessage ??????????????????
     * @param reqHead ???????????????
     */
    public void futureValueDataPadding(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead){
        //??????baseMessage?????????????????????1?????????????????????2?????????????????????3?????????????????????4???????????????5???
        //????????????
        BasicHeaderBlock basicHeaderBlock = baseMessage.getBasicHeaderBlock();
        //????????????
        AppHeaderBlock appHeaderBlock = baseMessage.getAppHeaderBlock();
        //????????????
        UserHeaderBlock userHeaderBlock = baseMessage.getUserHeaderBlock();
        //????????????
        ArrayList<BaseMessage> bolcks = baseMessage.getBolcks();
        //??????
        TrailersBlock trailersBlock = baseMessage.getTrailersBlock();
        //???????????????????????????
        logger.info("###{}###{}","BASIC HEADER BLOCK PADDING","---START---");
        //????????????????????????
        String bhSndlt = basicHeaderBlock.getBhSndlt();
        //???????????????????????????????????????????????????????????????
        String bicCode = bhSndlt.substring(0, 8) + bhSndlt.substring(9);
        pgstsDO.setAhRcvlt(bicCode);
        logger.info("###{}###{}","BASIC HEADER BLOCK PADDING","---END---");
        //???????????????????????????
        logger.info("###{}###{}","USER HEADER BLOCK PADDING","---START---");
        if (JudgeUtils.isNotNull(userHeaderBlock)) {
            pgstsDO.setOhHkl(userHeaderBlock.getOhHkl());
            pgstsDO.setOhCov(userHeaderBlock.getOhCov());
            pgstsDO.setOhGpiRef(userHeaderBlock.getOhGpiRef());
            pgstsDO.setOhMuref(userHeaderBlock.getOhMuref());
        }
        logger.info("###{}###{}","USER HEADER BLOCK PADDING","---END---");
        //??????????????????
        logger.info("###{}###{}","TRAILER BLOCK PADDING","---START---");
        if (JudgeUtils.isNotNull(trailersBlock)) {
            pgstsDO.setMtRetryFlag(trailersBlock.getMtRetryFlag());
            pgstsDO.setMtPdeNm(trailersBlock.getMtPdeNm());
            pgstsDO.setMtPdmNm(trailersBlock.getMtPdmNm());
        }
        logger.info("###{}###{}","TRAILER BLOCK PADDING","---END---");
        //???????????????2 ????????????
        logger.info("###{}###{}","APPLICATION HEADER BLOCK PADDING","---START---");
        //??????instanceof?????????????????????
        if (appHeaderBlock instanceof AppHeaderSenderBlock) {
            //?????????????????????I  ????????????
            AppHeaderSenderBlock appHeaderSenderBlock = (AppHeaderSenderBlock) appHeaderBlock;
            //???????????????????????????
            pgstsDO.setAhioFlag(appHeaderSenderBlock.getAhioFlag());
            //??????????????????
            pgstsDO.setAhMt(appHeaderSenderBlock.getAhMt());
            //?????????????????????
            pgstsDO.setAhMpro(appHeaderSenderBlock.getAhMpro());
            //????????????(ahRcvlt) ?????????BKCHBNB0XXXX??????????????????????????????????????????
            String ahRcvlt = appHeaderSenderBlock.getAhRcvlt();
            pgstsDO.setAhRcvlt(ahRcvlt.substring(0,8)+ahRcvlt.substring(9));
            reqHead.setTxnCode("23385");
            //??????????????????650????????????
            String orgMessage = messageGenerate650(pgstsDO, baseMessage, reqHead);
            pgstsDO.setMtMessage(orgMessage);
        }
        if (appHeaderBlock instanceof AppHeaderReciverBlock) {
            //???????????????O  ??????????????? ?????????????????????
            AppHeaderReciverBlock appHeaderReciverBlock = (AppHeaderReciverBlock) appHeaderBlock;
            //ahRefNo(??????????????????)?????????910103BKCHBNB0XXXX22221234569101031201N??????????????????????????????????????????
            String ahRefNo = appHeaderReciverBlock.getAhRefNo();
            String ahRcvlt = ahRefNo.substring(6, 14) + ahRefNo.substring(15, 18);
            pgstsDO.setBhSndlt(ahRcvlt);
            //??????????????????
            pgstsDO.setAhMt(appHeaderReciverBlock.getAhMt());
            //?????????????????????
            pgstsDO.setAhMpro(appHeaderReciverBlock.getAhMpro());
            //????????????????????????
            pgstsDO.setAhioFlag(appHeaderReciverBlock.getAhioFlag());
            //????????????
            pgstsDO.setIncomeDate(appHeaderReciverBlock.getAhRecDate());
            pgstsDO.setIncomeTime(appHeaderReciverBlock.getAhRecTime());
            reqHead.setTxnCode("23385");
            //??????????????????650????????????
            String orgMessage = messageGenerate650(pgstsDO, baseMessage, reqHead);
            pgstsDO.setMtMessage(orgMessage);
        }
        logger.info("###{}###{}","APPLICATION HEADER BLOCK PADDING","---END---");
        //????????????
        pgstsService.updateMtStatus(pgstsDO);
    }

    /**
     * ????????????650?????????????????????
     *
     * @param pgstsDO ???????????????????????????
     * @param baseMessage ??????????????????
     * @param reqHead ???????????????
     * @return ???????????????????????????
     */
    private String messageGenerate650(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead) {
        //???????????????????????????????????????????????????????????????????????????????????????????????????
        String receiveName = mtAssemblyService.getBankName(pgstsDO.getAhRcvlt(), reqHead);
        String senderName = mtAssemblyService.getBankName(pgstsDO.getBhSndlt(), reqHead);
        //???????????????????????????????????????????????????????????????
        Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
        String ohGpcFlg = null;
        if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
            ohGpcFlg = baseMessage.getUserHeaderBlock().getOhGpcFlg();
        }
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //??????650????????????????????????????????????650??????
        return TeleCh650Util.orgMessageTo650(pgstsDO.getMtStr(), pgstsDO.getMsgNo(), pgstsDO.getAhMt(),
                pgstsDO.getBhSndlt(), senderName, receiveName, pgstsDO.getAhRcvlt(), map, pgstsDO.getMtStatus(),
                pgstsDO.getOhGpiRef(), ohGpcFlg, appHeaderMessage);
    }

    /**
     * match?????????LAST????????????
     * @param reqHead ??????????????? ????????????LAST??????
     * @param pgMatchDO
     * @return
     */
    public PgMatchDO setLastUpdateParams(ReqHead reqHead,PgMatchDO pgMatchDO){
        logger.info("##### START TO SAVE LAST INFO FOR MATCH #####");
        // ??????????????????
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgMatchDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgMatchDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate acDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgMatchDO.setUpdateLastAcDate(acDate);
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgMatchDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        //?????????
        if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
            pgMatchDO.setLogNumber(reqHead.getJournalNo());
        }
        //??????????????????
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgMatchDO.setUpdateLastTime(sysLocalDate);
        logger.info("##### END TO SAVE LAST INFO FOR MATCH #####");
        return pgMatchDO;
    }

    /**
     * ????????????,?????????????????????????????????????????????tips
     * @param baseMessage
     * @return
     */
    private String assembleMTMessage(BaseMessage baseMessage) {
        String mtStr = null;
        try {
            mtStr = baseMessage.toMTMessage();
        } catch (Exception e) {
            //??????????????????
            //?????????????????????KontException,(?????????????????????)
            if(e instanceof KontException){
                KontException kontException =(KontException) e;
                //???????????????,?????????????????????
                logger.info("MsgCode:{}",kontException.getMsgCd());
                String msgCd = kontException.getMsgCd();
                //??????????????????,?????????????????????
                logger.info("MsgInfo:{}",kontException.getMsgInfo());
                String msgInfo = kontException.getMsgInfo();
                //??????msgInfo
                String[] resultArr = msgInfo.split("\\|");
                //???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
                String regex = "^[A-Za-z0-9\\[\\],\\s]+:[A-Za-z0-9]+\\/.+$";
                Pattern pattern = Pattern.compile(regex);
                for (String result : resultArr) {
                    //????????????????????????result??????
                    // ???1????????????????????????MTXXX:?????????/????????????
                    // ???2???Tag?????????????????????:?????????/????????????
                    // ???3?????????????????????????????????????????????1:?????????/????????????
                    //?????????????????????????????????????????????????????????????????????????????????????????????
                    Matcher matcher = pattern.matcher(result);
                    if(matcher.matches()){
                        String[] resultErrCodeTemp = result.split(":");
                        //????????????????????????????????????????????????????????????????????????????????????????????????????????????tips
                        String mtOrTagOrHead = resultErrCodeTemp[0];
                        //??????????????????????????????????????????/????????????
                        String errCode = resultErrCodeTemp[1].split("/")[0];
                        String errInfoDesc = resultErrCodeTemp[1].split("/")[1];
                        //??????????????????????????????tips??????
                        /*??????tips?????????????????????????????????????????????????????????????????????????????????*/
                        KontData kontdata = KontHolder.getKontData();
                        kontdata.addTipMsg(errCode, mtOrTagOrHead + "/" + errInfoDesc, null);
                    }
                /*//tips????????????????????????????????????
                if (mtOrTagOrHead.contains("MT")) {
                    //?????????????????????
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.MT_MESSAGE_CHECK_FAIL, Collections.singletonList(result));
                } else if (mtOrTagOrHead.compareTo("1") == 0 || mtOrTagOrHead.compareTo("2") == 0) {
                    //?????????????????????????????????????????????
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.HEAD_CHECK_FAIL, Collections.singletonList(result));
                } else {
                    //???Tag???????????????
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.TAG_CHECK_FAIL, Collections.singletonList(result));
                }*/
                }
                //????????????????????????
                KontException.throwBusinessException(msgCd, "MT MESSAGE ASSEMBLE FAIL");
            }
            //???????????????KontException????????????????????????????????????
            throw e;
        }
        return mtStr;
    }

    /**
     * ???????????????
     * @param pgstsDO
     * @param genericReqDTO
     */
    public <T> void maskLog(PgstsDO pgstsDO, GenericDTO<T> genericReqDTO){
        logger.info("##### START PG 23918 REMEMBER LOG #####");
        //?????????????????????
        logger.info("##### START TO GET BUSINESSCODE #####");
        String businessCode = null;
        GenericDTO genericDTO = new GenericDTO();
        GenericRspDTO<GetBusinessCodeRspDTO> genericRspDTO = new GenericRspDTO<>();
        try {
            genericRspDTO = businessLogServiceClient.getBusinessCode(genericDTO);
            if (JudgeUtils.isNotNull(genericRspDTO.getBody()) || JudgeUtils.isSuccess(genericRspDTO.getMsgCd())){
                GetBusinessCodeRspDTO body = genericRspDTO.getBody();
                businessCode = body.getBusinessCode();
                logger.info("##### GET BUSINESSCODE SUCCESS:{} #####",businessCode);
            }else {
                logger.error("##### GET BUSINESSCODE FAILED:{} #####",genericRspDTO.getMsgCd());
            }
        }catch (Exception e){
            logger.error("#####  EXCEPTION GET BUSINESSCODE FAILED:{} #####",genericRspDTO.getMsgCd());
            logger.error(e.getMessage());
        }

        //????????????
        GenericDTO<AddBusinessLogReqDTO> reqDTOGenericDTO = new GenericDTO<>();
        AddBusinessLogReqDTO reqDTO = new AddBusinessLogReqDTO();
        //???????????????
        reqDTO.setBusinessCode(businessCode);
        //????????????
        LocalDate localDate = mtAssemblyService.getAcDate();
        String acDate = localDate.toString().replace("-", "");
        reqDTO.setAcDt(Integer.valueOf(acDate));
        //?????????
        reqDTO.setTxnCode("23918");
        //????????????
        if ("103".equals(pgstsDO.getAhMt()) ||"200".equals(pgstsDO.getAhMt()) ||"202".equals(pgstsDO.getAhMt())
                ||"Y".equals(pgstsDO.getFutureFg())){
            reqDTO.setFinancialFlag("F");
        }else {
            reqDTO.setFinancialFlag("N");
        }
        //????????????
        reqDTO.setMtKey(pgstsDO.getMsgNo());
        //????????????
        reqDTO.setBusinessNo(pgstsDO.getPagmchOurRef());
        //????????????????????????
        reqDTO.setRefSub(pgstsDO.getRefSub());
        Object json = JSONObject.toJSON(genericReqDTO);
        if (JudgeUtils.isNotNull(json)){
            //????????????
            reqDTO.setBusinessContent(json.toString());
            //??????????????????
            reqDTO.setReqContent(json.toString());
        }
        reqDTOGenericDTO.setBody(reqDTO);
        GenericRspDTO<CommNobodyDTO> commNobodyDTOGenericRspDTO = new GenericRspDTO<>();
        try {
            commNobodyDTOGenericRspDTO = businessLogServiceClient.addBusinessLog(reqDTOGenericDTO);
            if (JudgeUtils.isSuccess(commNobodyDTOGenericRspDTO.getMsgCd())){
                logger.info("##### REMEMBER LOG SUCCESS #####");
            }else {
                logger.info("##### REMEMBER LOG FAILED:{} #####",commNobodyDTOGenericRspDTO.getMsgCd());
            }
        }catch (Exception e){
            logger.info("##### EXCEPTION REMEMBER LOG FAILED:{} #####",commNobodyDTOGenericRspDTO.getMsgCd());
            logger.info(e.toString());
        }
        logger.info("##### END REMEMBER LOG #####");
    }

    /**
     * ?????????????????????????????????
     * @param pgstsDO ???dto
     * @param swHeader ????????????+????????????
     * @param reqHead  ???????????????
     * @param <T>
     * @return
     */
    public <T>PgstsDO savePgstsMsg(PgstsDO pgstsDO, SwHeader swHeader, ReqHead reqHead){
        logger.info("##### START TO SAVE MT MESSAGE INFO FOR PGSTS #####");
        String msgNo = swHeader.getMsgNo();
        pgstsDO.setMtSeq(1);
        pgstsDO.setMsgNo(msgNo);
        pgstsDO.setMtStr(" ");
        pgstsDO.setMtMessage(" ");
        //?????????????????????????????????
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        //?????????????????????
        pgstsDO.setMtStatus(" ");
        pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_FAIL);
        pgstsDO.setUpdateLastTime(sysLocalDate);
        //????????????????????????????????????
        LocalDate acDate = mtAssemblyService.getAcDate();
        pgstsDO.setAcDate(acDate);
        //???????????? ???eai??????????????????
        if (JudgeUtils.isNull(swHeader.getTxnCode())) {
            if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
                pgstsDO.setTxncode(reqHead.getTxnCode());
            }
        }
        //???????????? ???eai??????????????????
        if (JudgeUtils.isNull(swHeader.getLogNumber())) {
            if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
                pgstsDO.setLogNumber(reqHead.getJournalNo());
            }
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgstsDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgstsDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate updateAcDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgstsDO.setUpdateLastAcDate(updateAcDate);
        }
        //?????????????????????
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgstsDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        pgstsService.insertMtByDalete(pgstsDO);
        logger.info("##### END TO SAVE MT MESSAGE INFO FOR PGSTS #####");
        //match?????? ???????????????match???????????????????????????
        if (JudgeUtils.isNotNull(pgstsDO.getMsgNo()) && JudgeUtils.isNotNull(pgstsDO.getPagmchOurRef())){
            logger.info("##### START TO SAVE MT MATCH INFO FOR PG_MATCH #####");
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
            pgMatchDO.setPagmchOurRef(pgstsDO.getPagmchOurRef());
            //???????????????????????????????????????
            pgMatchDO.setCreatedTime(sysLocalDate);
            pgMatchDO = setLastUpdateParams(reqHead, pgMatchDO);
            int result = pgMatchService.insertPgMatch(pgMatchDO);
            logger.info("##### END TO SAVE MT MATCH INFO FOR PG_MATCH,RESULT:{}",result);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO FOR PGSTS #####");
        return pgstsDO;
    }

    /**
     * ???????????????????????????????????????650??????
     * @param pgstsDO
     * @param mtDto
     */
    public void updateMessageForPgsts(PgstsDO pgstsDO, MtDto mtDto){
        logger.info("##### START TO UPDATE PGSTS FOR SAVING MT STR ADN PRINT MESSAGE #####");
        //???????????????650
        String mtStr = mtDto.getMtStr();
        String message = mtDto.getMessage();
        pgstsDO.setMtStr(mtStr);
        pgstsDO.setMtMessage(message);
        if (JudgeUtils.isNull(pgstsDO.getOhGpiRef())){
            if (JudgeUtils.isNotNull(mtDto.getOhGpiRef())){
                pgstsDO.setOhGpiRef(mtDto.getOhGpiRef());
            }
        }
        pgstsService.updateMtStatus(pgstsDO);
        logger.info("##### END TO UPDATE PGSTS FOR SAVING MT STR ADN PRINT MESSAGE #####");
    }

    /**
     * ??????????????????
     * @param trn  20???
     * @param rtrn 21???
     * @param pgstsDO  ?????????
     * @param swHeader ?????????+????????????
     * @param reqHead  ???????????????
     * @param genericDTO  ???jobId
     */
    public void savePreMessage(String trn,String rtrn,PgstsDO pgstsDO, SwHeader swHeader, ReqHead reqHead, GenericDTO genericDTO){
        //????????????rmc???eai??????
        //20??? ??????????????????
        pgstsDO.setTrn(trn);
        pgstsDO.setRtrn(rtrn);
        //???????????????id
        logger.info("##### START TO GET RETRANSMISSION ID #####");
        JobDTO jobDTO = KontJsonUtil.toBean(genericDTO.getAppExtHeader(), JobDTO.class);
        if (JudgeUtils.isNotNull(jobDTO)){
            pgstsDO.setRetransmissionId(jobDTO.getJobJournalNo());
            logger.info("##### END TO GET RETRANSMISSION ID :{}",jobDTO.getJobJournalNo());
        }
        //??????????????????
        mtAssemblyService.HeaderValueCopy(swHeader, pgstsDO);
        //?????????????????????
        savePgstsMsg(pgstsDO,swHeader,reqHead);
    }

    /**
     * ???23930??????
     * @param autoChannelDto
     */
    public void mask23930Log(AutoChannelReqDto autoChannelDto,GenericDTO<AutoChannelReqDto> reqDtoGenericDTO){
        logger.info("##### START TO REMEMBER 23930 BUSINESS LOG #####");
        //?????????????????????
        String businessCode = null;
        GenericDTO genericDTO = new GenericDTO();
        GenericRspDTO<GetBusinessCodeRspDTO> genericRspDTO = new GenericRspDTO<>();
        try {
            logger.info("##### START TO GET BUSINESS CODE #####");
            genericRspDTO = businessLogServiceClient.getBusinessCode(genericDTO);
            if (JudgeUtils.isNotNull(genericRspDTO.getBody()) || JudgeUtils.isSuccess(genericRspDTO.getMsgCd())){
                GetBusinessCodeRspDTO body = genericRspDTO.getBody();
                businessCode = body.getBusinessCode();
                logger.info("##### GET BUSINESS CODE:{}",businessCode);
            }else {
                logger.error("##### GET BUSINESS CODE ERROR:{}",genericRspDTO.getMsgCd());
            }
        }catch (Exception e){
            logger.error("##### GET BUSINESS CODE ERROR:{}",genericRspDTO.getMsgCd());
            logger.error(e.getMessage());
        }

        //????????????
        GenericDTO<AddBusinessLogReqDTO> reqDTOGenericDTO = new GenericDTO<>();
        AddBusinessLogReqDTO reqDTO = new AddBusinessLogReqDTO();
        //???????????????
        reqDTO.setBusinessCode(businessCode);
        //????????????
        LocalDate localDate = mtAssemblyService.getAcDate();
        String acDate = localDate.toString().replace("-", "");
        reqDTO.setAcDt(Integer.valueOf(acDate));
        ReqHead reqHead = autoChannelDto.getReqHead();
        //?????????
        reqDTO.setTxnCode(reqHead.getTxnCode());
        //????????????
        reqDTO.setFinancialFlag("N");
        //????????????
        reqDTO.setMtKey("");
        //????????????
        reqDTO.setBusinessNo("");
        //????????????????????????
        reqDTO.setRefSub("");
        //????????????
        Map map = new HashMap();
        map.put("action",autoChannelDto.getAction());
        map.put("103",autoChannelDto.getMt103());
        map.put("202",autoChannelDto.getMt202());
        map.put("os",autoChannelDto.getOtherSwiftTel());
        map.put("chats",autoChannelDto.getCharts());
        map.put("all",autoChannelDto.getAllTelMessege());
        Object json1 = JSONObject.toJSON(map);
        reqDTO.setBusinessContent(json1.toString());
        //??????????????????
        Object json2 = JSONObject.toJSON(reqDtoGenericDTO);
        reqDTO.setReqContent(json2.toString());

        reqDTOGenericDTO.setBody(reqDTO);
        GenericRspDTO<CommNobodyDTO> commNobodyDTOGenericRspDTO = new GenericRspDTO<>();
        try {
            commNobodyDTOGenericRspDTO = businessLogServiceClient.addBusinessLog(reqDTOGenericDTO);
            if (JudgeUtils.isSuccess(commNobodyDTOGenericRspDTO.getMsgCd())){
                logger.info("##### CALL REMEMBER BUSINESS LOG INTERFACE SUCCESS #####");
            }else {
                logger.info("##### CALL REMEMBER BUSINESS LOG INTERFACE ERROR:{}",commNobodyDTOGenericRspDTO.getMsgCd());
            }
        }catch (Exception e){
            logger.info("##### CALL REMEMBER BUSINESS LOG INTERFACE ERROR:{}",commNobodyDTOGenericRspDTO.getMsgCd());
            logger.info(e.toString());
        }
        logger.info("##### END TO REMEMBER 23930 BUSINESS LOG #####");
    }

    /**
     * ?????????????????????????????????
     *
     * @param fmt  ??????????????????(??????????????????)
     * @param flag ???????????????????????????
     * @param <T>  ??????
     */
    public <T> MtDto comAssembleMessageForTrans(T fmt, BaseMessage baseMessage, String flag, ReqHead reqHead,String recBankName,String mt103Str) {
        logger.info("##### START TO TRANS FOR ASSEMBLY MESSAGE #####");
        MtDto mto = null;
        //??????fmt????????????????????????
        String cnFlag = null;
        Class fmtClass = fmt.getClass();
        //?????????????????????  ???????????????????????????

        Method getSwHeaderMethod = null;
        SwHeader swHeader = null;
        //????????????????????????????????????swHeader
        try {
            getSwHeaderMethod = fmtClass.getMethod("getSwHeader");
            swHeader = (SwHeader) getSwHeaderMethod.invoke(fmt);
        } catch (Exception e) {
            logger.error("##### REFLECTION TO GET SWHEADER ERROR #####");
            logger.error(JSONObject.toJSONString(e));
            KontException.throwKontException(MTConstants.FMT_GET_SWHEADER_ERR);
        }
        //??????MT??????
        logger.info("##### START TO MAPPING FMT TO BASSMESSAGE #####");
        CopyTagUtils.mappingDtoToMt(fmt, baseMessage);
        logger.info("##### END TO MAPPING FMT TO BASSMESSAGE #####");
        //???????????? O?????????????????? 2?????????sender
        CopyTagUtils.CphaderInfo("O", swHeader, baseMessage);
        //????????????
        logger.info("##### START TO ASSEMBLY MESSAGE #####");
        String mtStr = this.assembleMTMessage(baseMessage);
        logger.info("##### END TO ASSEMBLY MESSAGE #####");

        logger.info("##### START TO GIVE SEQB TO MT202COV #####");
        //???103?????????202????????????202COV
        String messageBody202 = mtStr.substring(0, mtStr.indexOf("-}"));
        String tailHeader = mtStr.substring(mtStr.indexOf("-}"));
        String mt202CovStr = messageBody202+mt103Str+tailHeader;
        logger.info("##### RETURN PARAMETER:{}",mt202CovStr);
        logger.info("##### END TO GIVE SEQB TO MT202COV #####");
        //?????????????????? ???????????????
        String msgNo = null;
        if (JudgeUtils.isNotNull(swHeader.getMsgNo())) {
            msgNo = swHeader.getMsgNo();
        } else {
            //??????????????????????????? ?????????  ??????????????????
            //?????????Y ??????????????????????????????
            if ("Y".equals(flag)){
                KontException.throwBusinessException(MTConstants.MT_MSGNO_IS_NULL);
            }
        }
        //??????GPI?????? 001???002???GPI??????
        String ohGpcFlg = null;
        String ohCov = null;
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDO = swHeader.getUserHeaderDO();
            ohGpcFlg = userHeaderDO.getOhGpcFlg();
            ohCov = userHeaderDO.getOhCov();
        }
        //?????????????????? appHeaderMessage 2?????????
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //ohGpiRef gpi??????
        String ohGpiRef = baseMessage.getUserHeaderBlock().getOhGpiRef();
        //?????????BicCode
        String bhSndlt = swHeader.getBasicHeaderDO().getBhSndlt();
        String senderName = null;
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            //?????????BIC
            String ahRcvlt = swHeader.getAppHeaderSenderDO().getAhRcvlt();
            //????????????cor ??????????????????
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////??????????????? ???????????????cor
                senderName = mtAssemblyService.getBankName(bhSndlt, reqHead);
                if (JudgeUtils.isNull(recBankName)){
                    recBankName = mtAssemblyService.getBankName(ahRcvlt, reqHead);
                }else {
                    recBankName = recBankName.trim();
                }
            }
            String ahMt = swHeader.getAppHeaderSenderDO().getAhMt();
            //??????tag??????
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //??????650????????????
            String printContent = TeleCh650Util.orgMessageTo650(mt202CovStr, msgNo, ahMt,
                    bhSndlt, senderName, recBankName, ahRcvlt, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //??????????????????
            mto = mtAssemblyService.generateMtDto(msgNo, mt202CovStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
            //?????????BIC
            String sender = swHeader.getAppHeaderReciverDO().getAhRefNo().substring(6, 14) + swHeader.getAppHeaderReciverDO().getAhRefNo().substring(15, 18);
            String receBic = bhSndlt;
            //????????????cor  ??????????????????
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////??????????????? ???????????????cor
                recBankName= mtAssemblyService.getBankName(receBic, reqHead);
                senderName = mtAssemblyService.getBankName(sender, reqHead);
            }
            String ahMt = swHeader.getAppHeaderReciverDO().getAhMt();
            //??????tag??????
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //??????650????????????
            String printContent = TeleCh650Util.orgMessageTo650(mt202CovStr, msgNo, ahMt,
                    sender, senderName, recBankName, receBic, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //??????????????????
            mto = mtAssemblyService.generateMtDto(msgNo, mt202CovStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else {
            //?????????2?????????
            KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY);
        }
        logger.info("##### END TO TRANS FOR ASSEMBLY MESSAGE #####");
        return mto;
    }

}
