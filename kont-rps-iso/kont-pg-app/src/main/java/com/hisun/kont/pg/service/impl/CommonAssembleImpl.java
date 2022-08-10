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
 * @Description 组装与检查报文逻辑(必须为同一个逻辑) 按Flag标识组装外发和检查
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
     * 组装外发和检查报文逻辑
     *
     * @param fmt  报文参数对象(包含域和头部)
     * @param flag 区分组装和检查逻辑
     * @param <T>  泛型
     */
    public <T> MtDto comAssembleMessage(T fmt, BaseMessage baseMessage, String flag, ReqHead reqHead,String recBankName) {
        logger.info("##### START TO ASSEMBLY MESSAGE #####");
        MtDto mto = null;
        //判断fmt对象是否含有中文
        String cnFlag = null;
        Class fmtClass = fmt.getClass();
        //电码转中文处理  根据类型调不同接口

        Method getSwHeaderMethod = null;
        SwHeader swHeader = null;
        //利用反射获取泛型对象里的swHeader
        try {
            getSwHeaderMethod = fmtClass.getMethod("getSwHeader");
            swHeader = (SwHeader) getSwHeaderMethod.invoke(fmt);
        } catch (Exception e) {
            logger.error("##### REFLECTION GET SWHEADER EXCEPTION #####");
            KontException.throwKontException(MTConstants.FMT_GET_SWHEADER_ERR);
        }
        //复制MT对象
        logger.info("##### START TO MAPPING DTO TO MT OBJECT #####");
        CopyTagUtils.mappingDtoToMt(fmt, baseMessage);
        logger.info("##### END TO MAPPING DTO TO MT OBJECT #####");
        //复制头部 O表示发送报文 2头应为sender
        CopyTagUtils.CphaderInfo("O", swHeader, baseMessage);
        //报文内容
        logger.info("##### START TO MESSAGE ASSEMBLY #####");
        String mtStr = this.assembleMTMessage(baseMessage);
        logger.info("##### END TO MESSAGE ASSEMBLY #####");
        //获取报文编号 检查不需要
        String msgNo = null;
        if (JudgeUtils.isNotNull(swHeader.getMsgNo())) {
            msgNo = swHeader.getMsgNo();
        } else {
            //传入外发或检查标志 银行号  生成报文编号
            //如果为Y 发报报文编号不能为空
            if ("Y".equals(flag)){
                logger.error("##### SEND MESSAGE MSGNO IS NULL #####");
                KontException.throwBusinessException(MTConstants.MT_MSGNO_IS_NULL);
            }
        }
        //获取GPI标识 001或002为GPI报文
        String ohGpcFlg = null;
        String ohCov = null;
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDO = swHeader.getUserHeaderDO();
            ohGpcFlg = userHeaderDO.getOhGpcFlg();
            ohCov = userHeaderDO.getOhCov();
        }
        //组装返回参数 appHeaderMessage 2头内容
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //ohGpiRef gpi编号
        String ohGpiRef = baseMessage.getUserHeaderBlock().getOhGpiRef();
        //发报行BicCode
        String bhSndlt = swHeader.getBasicHeaderDO().getBhSndlt();
        String senderName = null;
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            //收报行BIC
            String ahRcvlt = swHeader.getAppHeaderSenderDO().getAhRcvlt();
            //检查不查cor 发报需要查询
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////发报行名称 发报需要查cor
                senderName = mtAssemblyService.getBankName(bhSndlt, reqHead);
                if (JudgeUtils.isNull(recBankName)){
                    recBankName = mtAssemblyService.getBankName(ahRcvlt, reqHead);
                }else {
                    recBankName = recBankName.trim();
                }
            }
            String ahMt = swHeader.getAppHeaderSenderDO().getAhMt();
            //获取tag描述
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //获取650打印格式
            String printContent = TeleCh650Util.orgMessageTo650(mtStr, msgNo, ahMt,
                    bhSndlt, senderName, recBankName, ahRcvlt, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //组装返回参数
            mto = mtAssemblyService.generateMtDto(msgNo, mtStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
            //发报行BIC
            String sender = swHeader.getAppHeaderReciverDO().getAhRefNo().substring(6, 14) + swHeader.getAppHeaderReciverDO().getAhRefNo().substring(15, 18);
            String receBic = bhSndlt;
            //检查不查cor  发报需要查询
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////发报行名称 发报需要查cor
                recBankName= mtAssemblyService.getBankName(receBic, reqHead);
                senderName = mtAssemblyService.getBankName(sender, reqHead);
            }
            String ahMt = swHeader.getAppHeaderReciverDO().getAhMt();
            //获取tag描述
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //获取650打印格式
            String printContent = TeleCh650Util.orgMessageTo650(mtStr, msgNo, ahMt,
                    sender, senderName, recBankName, receBic, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //组装返回参数
            mto = mtAssemblyService.generateMtDto(msgNo, mtStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else {
            //报文头2都为空
            logger.error("##### APP HEADER IS NULL #####");
            KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY);
        }
        logger.info("##### END TO ASSEMBLY MESSAGE #####");
        return mto;
    }

    /**
     * 根据银行号获取报文编号
     * @param bankNo 银行号
     * @return
     */
    public String getMsgNo(String flag, String bankNo) {
        logger.info("##### DO YOU GET MESSAGE NUMBER:{}",flag);
        String msgNo = null;
        //外发报文 网关生成报文编号
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
     * 根据报文类型获取域的描述(从库里查)
     * @param ahMt 报文类型
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
        //如果是202COV 需要查询103的部分tag描述 33B 50 59 70
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
     * 外发报文 调igw发报到rmc  根据返回结果处理数据 更新状态
     *
     * @param rmcTrx01     rmc参数
     * @param mtDto        组装报文返参
     * @param pgstsDO      入库对象
     * @param reqHead      eai头
     * @param eaiHeaderDTO 旧EAI头
     */
    public String comSendMessage(RmcTrx01 rmcTrx01, ReqHead reqHead, EaiHeaderDTO eaiHeaderDTO, MtDto mtDto, PgstsDO pgstsDO) {
        logger.info("##### START TO ASSEMBLE RMC DATA AND SEND MT MESSAGE #####");
        //补充外发rmc需要的参数
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
        //调用igw发报后，根据返回体判断是否发报成功
        if (JudgeUtils.isSuccess(rspDTO.getMsgCd()) && JudgeUtils.isNotNull(rspDTO.getBody())) {
            if ("00".equals(rspDTO.getBody().getErrCode())) {
                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_SUCCESS);
                pgstsService.updateMtStatus(pgstsDO);
                logger.info("#### CALL IGW AND RMC SEND MT MESSAGE SUCCESS ######");
                return MTConstants.SEND_MESSAGE_SUCCESS;
                //igw返回40 且 返回信息为 RTN DUPLICATE 为报文编号重复 视为发报成功
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
     * 报文数据存入psgts主档表
     *
     * @param remitReqDTO 报文
     * @param pgstsDO     入库对象
     * @param mtDto       组报返参
     * @param swHeader    头部
     * @param reqHead     eai头部
     * @param <T>
     */
    public <T> void messageForPgsts(T remitReqDTO, PgstsDO pgstsDO, MtDto mtDto, SwHeader swHeader, ReqHead reqHead) {
        logger.info("##### START TO SAVE MT MESSAGE INFO #####");
        String msgNo = mtDto.getMsgNo();
        String mtStr = mtDto.getMtStr();
        pgstsDO.setMtSeq(1);
        pgstsDO.setMsgNo(msgNo);
        //调公共接口获取系统日期
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        pgstsDO.setMtStr(mtStr);
        //报文状态给空格
        pgstsDO.setMtStatus(" ");
        pgstsDO.setMtMessage(mtDto.getMessage());
        pgstsDO.setUpdateLastTime(sysLocalDate);
        //调公共接口获取当前会计日
        LocalDate acDate = mtAssemblyService.getAcDate();
        pgstsDO.setAcDate(acDate);
//        pgstsDO.setUpdateLastAcDate(acDate);
        //应用不传 从eai头获取交易码
        if (JudgeUtils.isNull(swHeader.getTxnCode())) {
            if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
                pgstsDO.setTxncode(reqHead.getTxnCode());
            }
        }
        //应用不传 从eai头获取日志号
        if (JudgeUtils.isNull(swHeader.getLogNumber())) {
            if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
                pgstsDO.setLogNumber(reqHead.getJournalNo());
            }
        }
        //最后更新交易号
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgstsDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //最后修改柜员号
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgstsDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //最后修改会计日
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate updateAcDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgstsDO.setUpdateLastAcDate(updateAcDate);
        }
        //最后修改终端号
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgstsDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        pgstsService.insertMtByDalete(pgstsDO);
        logger.info("##### END TO SAVE MT MESSAGE #####");
        //match入档 报文编号和match关联业务编号不为空
        if (JudgeUtils.isNotNull(pgstsDO.getMsgNo()) && JudgeUtils.isNotNull(pgstsDO.getPagmchOurRef())){
            logger.info("##### START TO SAVE MT MESSAGE MATCH INFO #####");
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
            pgMatchDO.setPagmchOurRef(pgstsDO.getPagmchOurRef());
            //创建时间跟报文创建时间一致
            pgMatchDO.setCreatedTime(sysLocalDate);
            pgMatchDO = setLastUpdateParams(reqHead, pgMatchDO);
            int result = pgMatchService.insertPgMatch(pgMatchDO);
            logger.info("##### END TO SAVE MT MESSAGE MATCH INFO,RESULT:{}",result);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO #####");
    }

    /**
     * fmt103报文对象参数转中文转电码
     * 应用传简繁体标识来进行中文转电码
     * @param fmt103
     * @return
     */
    public Fmt103 cnToTeleFor103(Fmt103 fmt103) {
        //检查103报文含有中文的域 中文转电码  CN为中文简体
        logger.info("##### START TO CHINESE TO TELE CODE FOR FMT103 #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt103.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt103.getSwHeader().getTraditionalFlag();
            fmt103 = pgstpswftoteleService.getTagCnToTeleFor103(fmt103, traditionalFlag);
        }else {
            //应用没有传简繁体标识 改报文不需要转电码
            return fmt103;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT103 #####");
        return fmt103;
    }

    /**
     * 用于202COV中seqB部分转电码
     * @param fmt103
     * @return
     */
    public Fmt103 cnToTeleForSeqB(Fmt103 fmt103,Fmt202 fmt202) {
        //检查103报文含有中文的域 中文转电码  CN为中文简体
        logger.info("##### START TO CHINESE TO TELE CODE FOR MT202COV SEQB #####");
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getTraditionalFlag())){
            traditionalFlag = fmt202.getSwHeader().getTraditionalFlag();
            fmt103 = pgstpswftoteleService.getTagCnToTeleFor103(fmt103, traditionalFlag);
        }else {
            //应用没有传简繁体标识 改报文不需要转电码
            return fmt103;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR MT202COV SEQB #####");
        return fmt103;
    }

    /**
     * fmt200报文对象参数转中文转电码
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
            //应用没有传简繁体标识 改报文不需要转电码
            return fmt200;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT200 #####");
        return fmt200;
    }

    /**
     * fmt202报文对象参数转中文转电码
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
            //应用没有传简繁体标识 改报文不需要转电码
            return fmt202;
        }
        logger.info("##### END TO CHINESE TO TELE CODE FOR FMT202 #####");
        return fmt202;
    }

    /**
     * 根据编号查询是否带账电文 是否有止付  回复  关联信息
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
            //止付信息 N92 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getStopMsgNo())) {
                String stopMsgNo = checkVerifyMsgRspDTO.getStopMsgNo();
                String stopMsgType = checkVerifyMsgRspDTO.getStopMsgType();
                str650.append("**********STOP PAYMNET’S INFORMATION.*************" + lineFeed);
                str650.append("STOP SWIFT KEY : " + stopMsgNo + "   " + "STOP TYPE: " + stopMsgType + "   " + "STOP CHNL: FTM" + lineFeed);

            }
            //回复信息 N96 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getReplyMsgNo())) {
                String replyMsgNo = checkVerifyMsgRspDTO.getReplyMsgNo();
                String replyMsgType = checkVerifyMsgRspDTO.getReplyMsgType();
                str650.append("REPLY SWIFT KEY : " + replyMsgNo + "   " + "RPLY TYPE: " + replyMsgType + "   " + "RPLY CHNL: SWF" + lineFeed);
            }
            //关联信息1 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo1())) {
                String matchingMsgNo1 = checkVerifyMsgRspDTO.getMatchingMsgNo1();
                String matchingMsgType1 = checkVerifyMsgRspDTO.getMatchingMsgType1();
                str650.append("**********RELATE SWIFT/CHATS INFORMATION**********" + lineFeed);
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo1 + "     " + "MT TYPE:" + matchingMsgType1 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息2 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo2())) {
                String matchingMsgNo2 = checkVerifyMsgRspDTO.getMatchingMsgNo2();
                String matchingMsgType2 = checkVerifyMsgRspDTO.getMatchingMsgType1();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo2 + "     " + "MT TYPE:" + matchingMsgType2 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息3 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo3())) {
                String matchingMsgNo3 = checkVerifyMsgRspDTO.getMatchingMsgNo3();
                String matchingMsgType3 = checkVerifyMsgRspDTO.getMatchingMsgType3();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo3 + "     " + "MT TYPE:" + matchingMsgType3 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息4 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo4())) {
                String matchingMsgNo4 = checkVerifyMsgRspDTO.getMatchingMsgNo4();
                String matchingMsgType4 = checkVerifyMsgRspDTO.getMatchingMsgType4();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo4 + "     " + "MT TYPE:" + matchingMsgType4 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息5 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo5())) {
                String matchingMsgNo5 = checkVerifyMsgRspDTO.getMatchingMsgNo5();
                String matchingMsgType5 = checkVerifyMsgRspDTO.getMatchingMsgType5();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo5 + "     " + "MT TYPE:" + matchingMsgType5 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息6 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo6())) {
                String matchingMsgNo6 = checkVerifyMsgRspDTO.getMatchingMsgNo6();
                String matchingMsgType6 = checkVerifyMsgRspDTO.getMatchingMsgType6();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo6 + "     " + "MT TYPE:" + matchingMsgType6 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息7 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo7())) {
                String matchingMsgNo7 = checkVerifyMsgRspDTO.getMatchingMsgNo7();
                String matchingMsgType7 = checkVerifyMsgRspDTO.getMatchingMsgType7();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo7 + "     " + "MT TYPE:" + matchingMsgType7 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息8 拼650
            if (JudgeUtils.isNotNull(checkVerifyMsgRspDTO.getMatchingMsgNo8())) {
                String matchingMsgNo8 = checkVerifyMsgRspDTO.getMatchingMsgNo8();
                String matchingMsgType8 = checkVerifyMsgRspDTO.getMatchingMsgType8();
                str650.append("SWIFT/CHATS KEY: " + matchingMsgNo8 + "     " + "MT TYPE:" + matchingMsgType8 + "     " + "CHANNEL:SWF" + lineFeed);
            }
            //关联信息9 拼650
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
     * 收入报文 数据入库
     *
     * @param baseMessage
     * @param pgstsDO
     * @param reqHead
     * @return
     */
    public PgstsDO receiveHeaderToPg(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead) {
        //基础报文头1 数据入库
        logger.info("##### START TO SAVE RECEIVE MT MESSAGE HEADER #####");
        BasicHeaderBlock basicHeaderBlock = baseMessage.getBasicHeaderBlock();
        String bhSndlt = basicHeaderBlock.getBhSndlt();
        //这里block1 是收报行
        pgstsDO.setAhRcvlt(bhSndlt.substring(0, 8) + bhSndlt.substring(9));
        //用户报文头3 数据入库
        if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
            UserHeaderBlock userHeaderBlock = baseMessage.getUserHeaderBlock();
            pgstsDO.setOhHkl(userHeaderBlock.getOhHkl());
            pgstsDO.setOhCov(userHeaderBlock.getOhCov());
            pgstsDO.setOhGpiRef(userHeaderBlock.getOhGpiRef());
            pgstsDO.setOhMuref(userHeaderBlock.getOhMuref());
            pgstsDO.setGpcFlag(userHeaderBlock.getOhGpcFlg());
        }
        //报尾5 数据入库
        if (JudgeUtils.isNotNull(baseMessage.getTrailersBlock())) {
            TrailersBlock trailersBlock = baseMessage.getTrailersBlock();
            pgstsDO.setMtRetryFlag(trailersBlock.getMtRetryFlag());
            pgstsDO.setMtPdeNm(trailersBlock.getMtPdeNm());
            pgstsDO.setMtPdmNm(trailersBlock.getMtPdmNm());
        }
        //应用报文头2 数据 入库
        AppHeaderBlock appHeaderBlock = baseMessage.getAppHeaderBlock();
        if (appHeaderBlock instanceof AppHeaderSenderBlock) {
            //收报一般不会有I  但也支持
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
            //收报一般为O  此下面会在 真正业务上执行
            AppHeaderReciverBlock appHeaderReciverBlock = (AppHeaderReciverBlock) appHeaderBlock;
            //收报行截取
            String ahRcvlt = appHeaderReciverBlock.getAhRefNo().substring(6, 14) + appHeaderReciverBlock.getAhRefNo().substring(15, 18);
            //这里block2 中是发报行
            pgstsDO.setBhSndlt(ahRcvlt);
            pgstsDO.setAhMt(appHeaderReciverBlock.getAhMt());
            pgstsDO.setAhMpro(appHeaderReciverBlock.getAhMpro());
            pgstsDO.setAhioFlag(appHeaderReciverBlock.getAhioFlag());
            //收报日期
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
     * 针对不同类型报文 部分可用数据入库
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
                if (JudgeUtils.isNotNull(mt199.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList199 = mt199.getTagDataList("21");
                    Tag21 tag21For199 = (Tag21) tag21DataList199.get(0);
                    String rtrn = tag21For199.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                //gpi 199特殊处理
                if (JudgeUtils.isNotNull(mt199.getUserHeaderBlock())) {
                    if ("001".equals(mt199.getUserHeaderBlock().getOhGpcFlg()) || "002".equals(mt199.getUserHeaderBlock().getOhGpcFlg())) {
                        logger.info("##### START TO AUTO MATCH AND PUSH F79 TO OR FOR GPIN99 #####");
                        ArrayList<BaseTag> tagDataListFor199 = mt199.getTagDataList("79");
                        Tag79 tag79For199 = (Tag79) tagDataListFor199.get(0);
                        List<String> narratList = tag79For199.getNarratList();
                        GpiF79DTO f79Value = AssembleUtils.getF79Value(narratList);
                        //79域内容入库
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
                    //分202COV  跟 普通202处理
                    if ("COV".equals(ohCov)){
                        MT202Cov mt202cov = (MT202Cov) baseMessage;
                        ArrayList<BaseTag> tagDataList202 = mt202cov.getTagDataList("20","A");
                        Tag20 tag20For202 = (Tag20) tagDataList202.get(0);
                        pgstsDO.setTrn(tag20For202.getTrn());
                        //关联业务编号
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
                        //关联业务编号
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
                    //关联业务编号
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
                //21在List里面
                break;

            case "290":
                MT290 mt290 = (MT290) baseMessage;
                ArrayList<BaseTag> tagDataList290 = mt290.getTagDataList("20");
                Tag20 tag20For290 = (Tag20) tagDataList290.get(0);
                pgstsDO.setTrn(tag20For290.getTrn());
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
                if (JudgeUtils.isNotNull(mt299.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList299 = mt299.getTagDataList("21");
                    Tag21 tag21For299 = (Tag21) tag21DataList299.get(0);
                    String rtrn = tag21For299.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                //gpi 299特殊处理
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
                        //GPI标识入库
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
                //关联业务编号
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
                //关联业务编号
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
                //关联业务编号
                if (JudgeUtils.isNotNull(mt999.getTagDataList("21"))) {
                    ArrayList<BaseTag> tag21DataList999 = mt999.getTagDataList("21");
                    Tag21 tag21For999 = (Tag21) tag21DataList999.get(0);
                    String rtrn = tag21For999.getRtrn();
                    pgstsDO.setRtrn(rtrn);
                }
                break;

            default:
                //RPS一期 不支持的报文类型
                KontException.throwKontException(MTConstants.MT_TYPE_NOT_SUPPORT);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO BY MT TYPE:{}",mtType);
        return pgstsDO;
    }

    /**
     * 收报拆解报文 对一期不支持的报文类型只拆解头 不拆体 人工toRMC
     *
     * @param mtStr
     * @return
     */
    public BaseMessage disassemblyMessage(String mtStr, PgstsDO pgstsDO, ReqHead reqHead) {
        logger.info("##### START TO DISASSEMBLY RECEIVE MT MESSAGE HEADER #####");
        MessageEnvelope envelope = new MessageEnvelope(mtStr);
        envelope.paserStrToBlockMap();
        BaseMessage baseMessage = new BaseMessage();
        //这里接下来的动作是拆头 不拆体
        baseMessage = envelope.getMessageList().get(0);
        //这里先对头部数据入库
        pgstsDO = receiveHeaderToPg(pgstsDO, baseMessage, reqHead);
        pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DFAIL);
        pgstsService.updateMtStatus(pgstsDO);
        logger.info("##### END TO DISASSEMBLY RECEIVE MT MESSAGE HEADER #####");
        return baseMessage;
    }

    /**
     * 重复key判断  判断该报文是否已重发并且状态为外发成功 即不需要在继续往下走
     * @param msgNo
     * @return
     */
    public GenericRspDTO<MtDto> repeatKeyCheck(String msgNo){
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        logger.info("##### MESSAGE NUMBER:{}",msgNo);
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
        //状态为外发成功或已废除 停止重发
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
     * future value报文历史表填充数据方法
     *
     * @param pgstsDO 报文历史表实例对象
     * @param baseMessage 报文解析对象
     * @param reqHead 报文请求头
     */
    public void futureValueDataPadding(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead){
        //获取baseMessage中的基本报头（1），应用报头（2），用户报头（3），电报正文（4），报尾（5）
        //基本报头
        BasicHeaderBlock basicHeaderBlock = baseMessage.getBasicHeaderBlock();
        //应用报头
        AppHeaderBlock appHeaderBlock = baseMessage.getAppHeaderBlock();
        //用户报头
        UserHeaderBlock userHeaderBlock = baseMessage.getUserHeaderBlock();
        //电报正文
        ArrayList<BaseMessage> bolcks = baseMessage.getBolcks();
        //报尾
        TrailersBlock trailersBlock = baseMessage.getTrailersBlock();
        //基础报文头数据入库
        logger.info("###{}###{}","BASIC HEADER BLOCK PADDING","---START---");
        //获取逻辑终端地址
        String bhSndlt = basicHeaderBlock.getBhSndlt();
        //去掉逻辑终端地址的第十位，获取银行识别代码
        String bicCode = bhSndlt.substring(0, 8) + bhSndlt.substring(9);
        pgstsDO.setAhRcvlt(bicCode);
        logger.info("###{}###{}","BASIC HEADER BLOCK PADDING","---END---");
        //用户报文头数据入库
        logger.info("###{}###{}","USER HEADER BLOCK PADDING","---START---");
        if (JudgeUtils.isNotNull(userHeaderBlock)) {
            pgstsDO.setOhHkl(userHeaderBlock.getOhHkl());
            pgstsDO.setOhCov(userHeaderBlock.getOhCov());
            pgstsDO.setOhGpiRef(userHeaderBlock.getOhGpiRef());
            pgstsDO.setOhMuref(userHeaderBlock.getOhMuref());
        }
        logger.info("###{}###{}","USER HEADER BLOCK PADDING","---END---");
        //报尾数据入库
        logger.info("###{}###{}","TRAILER BLOCK PADDING","---START---");
        if (JudgeUtils.isNotNull(trailersBlock)) {
            pgstsDO.setMtRetryFlag(trailersBlock.getMtRetryFlag());
            pgstsDO.setMtPdeNm(trailersBlock.getMtPdeNm());
            pgstsDO.setMtPdmNm(trailersBlock.getMtPdmNm());
        }
        logger.info("###{}###{}","TRAILER BLOCK PADDING","---END---");
        //应用报文头2 数据入库
        logger.info("###{}###{}","APPLICATION HEADER BLOCK PADDING","---START---");
        //通过instanceof关键字向下转型
        if (appHeaderBlock instanceof AppHeaderSenderBlock) {
            //收报一般不会有I  但也支持
            AppHeaderSenderBlock appHeaderSenderBlock = (AppHeaderSenderBlock) appHeaderBlock;
            //入库输入输出标识符
            pgstsDO.setAhioFlag(appHeaderSenderBlock.getAhioFlag());
            //入库报文类型
            pgstsDO.setAhMt(appHeaderSenderBlock.getAhMt());
            //入库电文优先级
            pgstsDO.setAhMpro(appHeaderSenderBlock.getAhMpro());
            //接收地址(ahRcvlt) 例子：BKCHBNB0XXXX，截取字符串获取银行识别代码
            String ahRcvlt = appHeaderSenderBlock.getAhRcvlt();
            pgstsDO.setAhRcvlt(ahRcvlt.substring(0,8)+ahRcvlt.substring(9));
            reqHead.setTxnCode("23385");
            //报文信息生成650之后入库
            String orgMessage = messageGenerate650(pgstsDO, baseMessage, reqHead);
            pgstsDO.setMtMessage(orgMessage);
        }
        if (appHeaderBlock instanceof AppHeaderReciverBlock) {
            //收报一般为O  此下面会在 真正业务上执行
            AppHeaderReciverBlock appHeaderReciverBlock = (AppHeaderReciverBlock) appHeaderBlock;
            //ahRefNo(报文输入参号)例子：910103BKCHBNB0XXXX22221234569101031201N，截取字符串获取银行识别代码
            String ahRefNo = appHeaderReciverBlock.getAhRefNo();
            String ahRcvlt = ahRefNo.substring(6, 14) + ahRefNo.substring(15, 18);
            pgstsDO.setBhSndlt(ahRcvlt);
            //入库报文类型
            pgstsDO.setAhMt(appHeaderReciverBlock.getAhMt());
            //入库电文优先级
            pgstsDO.setAhMpro(appHeaderReciverBlock.getAhMpro());
            //入库输入输出标识
            pgstsDO.setAhioFlag(appHeaderReciverBlock.getAhioFlag());
            //收报日期
            pgstsDO.setIncomeDate(appHeaderReciverBlock.getAhRecDate());
            pgstsDO.setIncomeTime(appHeaderReciverBlock.getAhRecTime());
            reqHead.setTxnCode("23385");
            //报文信息生成650之后入库
            String orgMessage = messageGenerate650(pgstsDO, baseMessage, reqHead);
            pgstsDO.setMtMessage(orgMessage);
        }
        logger.info("###{}###{}","APPLICATION HEADER BLOCK PADDING","---END---");
        //更新数据
        pgstsService.updateMtStatus(pgstsDO);
    }

    /**
     * 报文生成650信息方法的抽取
     *
     * @param pgstsDO 报文历史表实例对象
     * @param baseMessage 报文解析对象
     * @param reqHead 报文请求头
     * @return 报文历史表实例对象
     */
    private String messageGenerate650(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead) {
        //根据银行识别代码和报文请求头调用外围接口获取接收行和发送行的银行名
        String receiveName = mtAssemblyService.getBankName(pgstsDO.getAhRcvlt(), reqHead);
        String senderName = mtAssemblyService.getBankName(pgstsDO.getBhSndlt(), reqHead);
        //获取数据库中存储相应报文类型对应的域的描述
        Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
        String ohGpcFlg = null;
        if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
            ohGpcFlg = baseMessage.getUserHeaderBlock().getOhGpcFlg();
        }
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //调用650工具的方法，传递参数生成650信息
        return TeleCh650Util.orgMessageTo650(pgstsDO.getMtStr(), pgstsDO.getMsgNo(), pgstsDO.getAhMt(),
                pgstsDO.getBhSndlt(), senderName, receiveName, pgstsDO.getAhRcvlt(), map, pgstsDO.getMtStatus(),
                pgstsDO.getOhGpiRef(), ohGpcFlg, appHeaderMessage);
    }

    /**
     * match表更新LAST信息入库
     * @param reqHead 公共请求头 从里面取LAST信息
     * @param pgMatchDO
     * @return
     */
    public PgMatchDO setLastUpdateParams(ReqHead reqHead,PgMatchDO pgMatchDO){
        logger.info("##### START TO SAVE LAST INFO FOR MATCH #####");
        // 最后更新信息
        //最后更新交易号
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgMatchDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //最后修改柜员号
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgMatchDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //最后修改会计日
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate acDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgMatchDO.setUpdateLastAcDate(acDate);
        }
        //最后修改终端号
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgMatchDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        //日志号
        if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
            pgMatchDO.setLogNumber(reqHead.getJournalNo());
        }
        //最后修改时间
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgMatchDO.setUpdateLastTime(sysLocalDate);
        logger.info("##### END TO SAVE LAST INFO FOR MATCH #####");
        return pgMatchDO;
    }

    /**
     * 组装报文,添加出现异常时将错误信息添加到tips
     * @param baseMessage
     * @return
     */
    private String assembleMTMessage(BaseMessage baseMessage) {
        String mtStr = null;
        try {
            mtStr = baseMessage.toMTMessage();
        } catch (Exception e) {
            //开始处理异常
            //判断异常是不是KontException,(异常的向下转型)
            if(e instanceof KontException){
                KontException kontException =(KontException) e;
                //获取错误码,并记录日志信息
                logger.info("MsgCode:{}",kontException.getMsgCd());
                String msgCd = kontException.getMsgCd();
                //获取错误信息,并记录日志信息
                logger.info("MsgInfo:{}",kontException.getMsgInfo());
                String msgInfo = kontException.getMsgInfo();
                //处理msgInfo
                String[] resultArr = msgInfo.split("\\|");
                //正则表达式判断当前的提示信息是否符合规则，防止下面进行字符串分割的时候出现索引越界
                String regex = "^[A-Za-z0-9\\[\\],\\s]+:[A-Za-z0-9]+\\/.+$";
                Pattern pattern = Pattern.compile(regex);
                for (String result : resultArr) {
                    //返回错误分三种（result）：
                    // （1）报文检查失败：MTXXX:错误码/错误描述
                    // （2）Tag检查错误：域名:错误码/错误描述
                    // （3）基本报头和应用报头检查报错：1:错误码/错误描述
                    //开始判断提示信息是否符合标准，不符合标准下面字符串分割将会报错
                    Matcher matcher = pattern.matcher(result);
                    if(matcher.matches()){
                        String[] resultErrCodeTemp = result.split(":");
                        //拿出分割完成的字符串的数组的的一个来判断使用那个信息码进行添加错误信息到tips
                        String mtOrTagOrHead = resultErrCodeTemp[0];
                        //拿出错误码和错误信息：错误码/错误信息
                        String errCode = resultErrCodeTemp[1].split("/")[0];
                        String errInfoDesc = resultErrCodeTemp[1].split("/")[1];
                        //开始把错误信息添加到tips里面
                        /*使用tips信息提示码符合规范的代码要将下面两行注掉，开启下面注释*/
                        KontData kontdata = KontHolder.getKontData();
                        kontdata.addTipMsg(errCode, mtOrTagOrHead + "/" + errInfoDesc, null);
                    }
                /*//tips符合信息提示码规范的代码
                if (mtOrTagOrHead.contains("MT")) {
                    //为报文检查失败
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.MT_MESSAGE_CHECK_FAIL, Collections.singletonList(result));
                } else if (mtOrTagOrHead.compareTo("1") == 0 || mtOrTagOrHead.compareTo("2") == 0) {
                    //为基本报头和应用报头的检查失败
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.HEAD_CHECK_FAIL, Collections.singletonList(result));
                } else {
                    //为Tag的检查失败
                    MsgInfoUtils.addTipsMsgCdyWithArgs(MTConstants.TAG_CHECK_FAIL, Collections.singletonList(result));
                }*/
                }
                //处理之后抛出异常
                KontException.throwBusinessException(msgCd, "MT MESSAGE ASSEMBLE FAIL");
            }
            //判断之后非KontException抛出的异常信息，直接抛出
            throw e;
        }
        return mtStr;
    }

    /**
     * 记发报日志
     * @param pgstsDO
     * @param genericReqDTO
     */
    public <T> void maskLog(PgstsDO pgstsDO, GenericDTO<T> genericReqDTO){
        logger.info("##### START PG 23918 REMEMBER LOG #####");
        //获取业务日志号
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

        //参数记表
        GenericDTO<AddBusinessLogReqDTO> reqDTOGenericDTO = new GenericDTO<>();
        AddBusinessLogReqDTO reqDTO = new AddBusinessLogReqDTO();
        //业务日志号
        reqDTO.setBusinessCode(businessCode);
        //会计日期
        LocalDate localDate = mtAssemblyService.getAcDate();
        String acDate = localDate.toString().replace("-", "");
        reqDTO.setAcDt(Integer.valueOf(acDate));
        //交易码
        reqDTO.setTxnCode("23918");
        //金融标志
        if ("103".equals(pgstsDO.getAhMt()) ||"200".equals(pgstsDO.getAhMt()) ||"202".equals(pgstsDO.getAhMt())
                ||"Y".equals(pgstsDO.getFutureFg())){
            reqDTO.setFinancialFlag("F");
        }else {
            reqDTO.setFinancialFlag("N");
        }
        //电文编号
        reqDTO.setMtKey(pgstsDO.getMsgNo());
        //业务编号
        reqDTO.setBusinessNo(pgstsDO.getPagmchOurRef());
        //其他业务编号标志
        reqDTO.setRefSub(pgstsDO.getRefSub());
        Object json = JSONObject.toJSON(genericReqDTO);
        if (JudgeUtils.isNotNull(json)){
            //交易内容
            reqDTO.setBusinessContent(json.toString());
            //页面请求参数
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
     * 发报进来开始存数据入表
     * @param pgstsDO 表dto
     * @param swHeader 报文头部+业务参数
     * @param reqHead  公共请求头
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
        //调公共接口获取系统日期
        LocalDateTime sysLocalDate = mtAssemblyService.getSysLocalDate();
        pgstsDO.setCreatedTime(sysLocalDate);
        //报文状态给空格
        pgstsDO.setMtStatus(" ");
        pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_GEN_OUT_FAIL);
        pgstsDO.setUpdateLastTime(sysLocalDate);
        //调公共接口获取当前会计日
        LocalDate acDate = mtAssemblyService.getAcDate();
        pgstsDO.setAcDate(acDate);
        //应用不传 从eai头获取交易码
        if (JudgeUtils.isNull(swHeader.getTxnCode())) {
            if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
                pgstsDO.setTxncode(reqHead.getTxnCode());
            }
        }
        //应用不传 从eai头获取日志号
        if (JudgeUtils.isNull(swHeader.getLogNumber())) {
            if (JudgeUtils.isNotNull(reqHead.getJournalNo())){
                pgstsDO.setLogNumber(reqHead.getJournalNo());
            }
        }
        //最后更新交易号
        if (JudgeUtils.isNotNull(reqHead.getTxnCode())){
            pgstsDO.setUpdateLastTxnCode(reqHead.getTxnCode());
        }
        //最后修改柜员号
        if (JudgeUtils.isNotNull(reqHead.getTellerID())){
            pgstsDO.setUpdateLastTeller(reqHead.getTellerID());
        }
        //最后修改会计日
        if (JudgeUtils.isNotNull(reqHead.getAcDate())){
            String date = reqHead.getAcDate();
            LocalDate updateAcDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            pgstsDO.setUpdateLastAcDate(updateAcDate);
        }
        //最后修改终端号
        if (JudgeUtils.isNotNull(reqHead.getTerminalNo())){
            pgstsDO.setUpdateLastTerm(Integer.valueOf(reqHead.getTerminalNo()));
        }
        pgstsService.insertMtByDalete(pgstsDO);
        logger.info("##### END TO SAVE MT MESSAGE INFO FOR PGSTS #####");
        //match入档 报文编号和match关联业务编号不为空
        if (JudgeUtils.isNotNull(pgstsDO.getMsgNo()) && JudgeUtils.isNotNull(pgstsDO.getPagmchOurRef())){
            logger.info("##### START TO SAVE MT MATCH INFO FOR PG_MATCH #####");
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
            pgMatchDO.setPagmchOurRef(pgstsDO.getPagmchOurRef());
            //创建时间跟报文创建时间一致
            pgMatchDO.setCreatedTime(sysLocalDate);
            pgMatchDO = setLastUpdateParams(reqHead, pgMatchDO);
            int result = pgMatchService.insertPgMatch(pgMatchDO);
            logger.info("##### END TO SAVE MT MATCH INFO FOR PG_MATCH,RESULT:{}",result);
        }
        logger.info("##### END TO SAVE MT MESSAGE INFO FOR PGSTS #####");
        return pgstsDO;
    }

    /**
     * 组报成功后，将生成的报文跟650存表
     * @param pgstsDO
     * @param mtDto
     */
    public void updateMessageForPgsts(PgstsDO pgstsDO, MtDto mtDto){
        logger.info("##### START TO UPDATE PGSTS FOR SAVING MT STR ADN PRINT MESSAGE #####");
        //报文内容、650
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
     * 发报预存数据
     * @param trn  20域
     * @param rtrn 21域
     * @param pgstsDO  表对象
     * @param swHeader 报文头+业务参数
     * @param reqHead  公共请求头
     * @param genericDTO  取jobId
     */
    public void savePreMessage(String trn,String rtrn,PgstsDO pgstsDO, SwHeader swHeader, ReqHead reqHead, GenericDTO genericDTO){
        //存报文、rmc、eai数据
        //20域 业务编号入库
        pgstsDO.setTrn(trn);
        pgstsDO.setRtrn(rtrn);
        //记重发任务id
        logger.info("##### START TO GET RETRANSMISSION ID #####");
        JobDTO jobDTO = KontJsonUtil.toBean(genericDTO.getAppExtHeader(), JobDTO.class);
        if (JudgeUtils.isNotNull(jobDTO)){
            pgstsDO.setRetransmissionId(jobDTO.getJobJournalNo());
            logger.info("##### END TO GET RETRANSMISSION ID :{}",jobDTO.getJobJournalNo());
        }
        //头部信息存档
        mtAssemblyService.HeaderValueCopy(swHeader, pgstsDO);
        //存应用发报数据
        savePgstsMsg(pgstsDO,swHeader,reqHead);
    }

    /**
     * 记23930日志
     * @param autoChannelDto
     */
    public void mask23930Log(AutoChannelReqDto autoChannelDto,GenericDTO<AutoChannelReqDto> reqDtoGenericDTO){
        logger.info("##### START TO REMEMBER 23930 BUSINESS LOG #####");
        //获取业务日志号
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

        //参数记表
        GenericDTO<AddBusinessLogReqDTO> reqDTOGenericDTO = new GenericDTO<>();
        AddBusinessLogReqDTO reqDTO = new AddBusinessLogReqDTO();
        //业务日志号
        reqDTO.setBusinessCode(businessCode);
        //会计日期
        LocalDate localDate = mtAssemblyService.getAcDate();
        String acDate = localDate.toString().replace("-", "");
        reqDTO.setAcDt(Integer.valueOf(acDate));
        ReqHead reqHead = autoChannelDto.getReqHead();
        //交易码
        reqDTO.setTxnCode(reqHead.getTxnCode());
        //金融标志
        reqDTO.setFinancialFlag("N");
        //电文编号
        reqDTO.setMtKey("");
        //业务编号
        reqDTO.setBusinessNo("");
        //其他业务编号标志
        reqDTO.setRefSub("");
        //交易内容
        Map map = new HashMap();
        map.put("action",autoChannelDto.getAction());
        map.put("103",autoChannelDto.getMt103());
        map.put("202",autoChannelDto.getMt202());
        map.put("os",autoChannelDto.getOtherSwiftTel());
        map.put("chats",autoChannelDto.getCharts());
        map.put("all",autoChannelDto.getAllTelMessege());
        Object json1 = JSONObject.toJSON(map);
        reqDTO.setBusinessContent(json1.toString());
        //页面请求参数
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
     * 组装外发和检查报文逻辑
     *
     * @param fmt  报文参数对象(包含域和头部)
     * @param flag 区分组装和检查逻辑
     * @param <T>  泛型
     */
    public <T> MtDto comAssembleMessageForTrans(T fmt, BaseMessage baseMessage, String flag, ReqHead reqHead,String recBankName,String mt103Str) {
        logger.info("##### START TO TRANS FOR ASSEMBLY MESSAGE #####");
        MtDto mto = null;
        //判断fmt对象是否含有中文
        String cnFlag = null;
        Class fmtClass = fmt.getClass();
        //电码转中文处理  根据类型调不同接口

        Method getSwHeaderMethod = null;
        SwHeader swHeader = null;
        //利用反射获取泛型对象里的swHeader
        try {
            getSwHeaderMethod = fmtClass.getMethod("getSwHeader");
            swHeader = (SwHeader) getSwHeaderMethod.invoke(fmt);
        } catch (Exception e) {
            logger.error("##### REFLECTION TO GET SWHEADER ERROR #####");
            logger.error(JSONObject.toJSONString(e));
            KontException.throwKontException(MTConstants.FMT_GET_SWHEADER_ERR);
        }
        //复制MT对象
        logger.info("##### START TO MAPPING FMT TO BASSMESSAGE #####");
        CopyTagUtils.mappingDtoToMt(fmt, baseMessage);
        logger.info("##### END TO MAPPING FMT TO BASSMESSAGE #####");
        //复制头部 O表示发送报文 2头应为sender
        CopyTagUtils.CphaderInfo("O", swHeader, baseMessage);
        //报文内容
        logger.info("##### START TO ASSEMBLY MESSAGE #####");
        String mtStr = this.assembleMTMessage(baseMessage);
        logger.info("##### END TO ASSEMBLY MESSAGE #####");

        logger.info("##### START TO GIVE SEQB TO MT202COV #####");
        //拼103部分到202报文组成202COV
        String messageBody202 = mtStr.substring(0, mtStr.indexOf("-}"));
        String tailHeader = mtStr.substring(mtStr.indexOf("-}"));
        String mt202CovStr = messageBody202+mt103Str+tailHeader;
        logger.info("##### RETURN PARAMETER:{}",mt202CovStr);
        logger.info("##### END TO GIVE SEQB TO MT202COV #####");
        //获取报文编号 检查不需要
        String msgNo = null;
        if (JudgeUtils.isNotNull(swHeader.getMsgNo())) {
            msgNo = swHeader.getMsgNo();
        } else {
            //传入外发或检查标志 银行号  生成报文编号
            //如果为Y 发报报文编号不能为空
            if ("Y".equals(flag)){
                KontException.throwBusinessException(MTConstants.MT_MSGNO_IS_NULL);
            }
        }
        //获取GPI标识 001或002为GPI报文
        String ohGpcFlg = null;
        String ohCov = null;
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDO = swHeader.getUserHeaderDO();
            ohGpcFlg = userHeaderDO.getOhGpcFlg();
            ohCov = userHeaderDO.getOhCov();
        }
        //组装返回参数 appHeaderMessage 2头内容
        String appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        //ohGpiRef gpi编号
        String ohGpiRef = baseMessage.getUserHeaderBlock().getOhGpiRef();
        //发报行BicCode
        String bhSndlt = swHeader.getBasicHeaderDO().getBhSndlt();
        String senderName = null;
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            //收报行BIC
            String ahRcvlt = swHeader.getAppHeaderSenderDO().getAhRcvlt();
            //检查不查cor 发报需要查询
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////发报行名称 发报需要查cor
                senderName = mtAssemblyService.getBankName(bhSndlt, reqHead);
                if (JudgeUtils.isNull(recBankName)){
                    recBankName = mtAssemblyService.getBankName(ahRcvlt, reqHead);
                }else {
                    recBankName = recBankName.trim();
                }
            }
            String ahMt = swHeader.getAppHeaderSenderDO().getAhMt();
            //获取tag描述
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //获取650打印格式
            String printContent = TeleCh650Util.orgMessageTo650(mt202CovStr, msgNo, ahMt,
                    bhSndlt, senderName, recBankName, ahRcvlt, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //组装返回参数
            mto = mtAssemblyService.generateMtDto(msgNo, mt202CovStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
            //发报行BIC
            String sender = swHeader.getAppHeaderReciverDO().getAhRefNo().substring(6, 14) + swHeader.getAppHeaderReciverDO().getAhRefNo().substring(15, 18);
            String receBic = bhSndlt;
            //检查不查cor  发报需要查询
            if ("N".equals(flag)){
                senderName = null;
            }else {
                ////发报行名称 发报需要查cor
                recBankName= mtAssemblyService.getBankName(receBic, reqHead);
                senderName = mtAssemblyService.getBankName(sender, reqHead);
            }
            String ahMt = swHeader.getAppHeaderReciverDO().getAhMt();
            //获取tag描述
            Map<String, String> map = getTagDescribe(ahMt,ohCov);
            //获取650打印格式
            String printContent = TeleCh650Util.orgMessageTo650(mt202CovStr, msgNo, ahMt,
                    sender, senderName, recBankName, receBic, map, ohCov,
                    ohGpiRef, ohGpcFlg, appHeaderMessage);
            //组装返回参数
            mto = mtAssemblyService.generateMtDto(msgNo, mt202CovStr, printContent, ohGpiRef, ahMt, cnFlag);
        } else {
            //报文头2都为空
            KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY);
        }
        logger.info("##### END TO TRANS FOR ASSEMBLY MESSAGE #####");
        return mto;
    }

}
