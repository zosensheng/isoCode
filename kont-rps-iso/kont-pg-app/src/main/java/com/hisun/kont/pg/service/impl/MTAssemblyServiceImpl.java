package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.KontJsonUtil;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.job.remote.JobDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgTagDescribeDao;
import com.hisun.kont.pg.entity.PgTagDescribeDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.mt.remote.AppHeaderReciverDO;
import com.hisun.kont.pg.mt.remote.AppHeaderSenderDO;
import com.hisun.kont.pg.mt.remote.BasicHeaderDO;
import com.hisun.kont.pg.mt.remote.SwHeader;
import com.hisun.kont.pg.mt.remote.TrailersBlockDO;
import com.hisun.kont.pg.mt.remote.UserHeaderDO;
import com.hisun.kont.pg.utils.GpiF79DTO;
import com.hisun.kont.pyrm.client.GPITrackMt199ServiceClient;
import com.hisun.kont.pyrm.client.IgwEncapsulatesInterfacesServiceClient;
import com.hisun.kont.pyrm.client.RpsDtServiceClient;
import com.hisun.kont.pyrm.client.SystemDateServiceClient;
import com.hisun.kont.pyrm.or.remote.GpiTrackerMt199ReqDTO;
import com.hisun.kont.pyrm.or.remote.GpiTrackerMt199RspDTO;
import com.hisun.kont.pyrm.py.remote.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@Transactional
public class MTAssemblyServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(MTAssemblyServiceImpl.class);

    @Value("${spring.profiles.active}")
    private String active;

    @Value("${switch.redisFlag}")
    private Boolean redisFlag;

    @Value("${tracker.bicCode}")
    private String trackerBic;

    @Resource
    PgTagDescribeDao pgTagDescribeDao;

    @Resource
    IgwEncapsulatesInterfacesServiceClient accountServiceClient;


    @Resource
    private SystemDateServiceClient systemDate;

    @Resource
    private RpsDtServiceClient rpsDtServerClient;

    @Resource
    private GPITrackMt199ServiceClient gpiTrackMt199ServiceClient;

    /**
     * ??????????????????????????????
     *
     * @param swHeader ??????????????????
     * @param pgstsDO
     */
    public void HeaderValueCopy(SwHeader swHeader, PgstsDO pgstsDO) {
        logger.info("##### START TO COPY OR CHECK SWHEADER #####");
        // ??????AppHeaderSender???????????????
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            AppHeaderSenderDO appHeaderSenderDOs = swHeader.getAppHeaderSenderDO();
            pgstsDO.setAhMt(appHeaderSenderDOs.getAhMt());
            //?????????11???  ????????????bicCode
            if (appHeaderSenderDOs.getAhRcvlt().length()==12){
                String ahRcvlt = appHeaderSenderDOs.getAhRcvlt();
                ahRcvlt = ahRcvlt.substring(0,8)+ahRcvlt.substring(9);
                pgstsDO.setAhRcvlt(ahRcvlt);
                appHeaderSenderDOs.setAhRcvlt(ahRcvlt);
            }else {
                pgstsDO.setAhRcvlt(appHeaderSenderDOs.getAhRcvlt());
            }

            //????????????dev??? ???????????????0
            if ("dev".equals(active)) {
                appHeaderSenderDOs.setAhRcvlt(
                        StringUtils.substring(appHeaderSenderDOs.getAhRcvlt(), 0, 7) +
                                "0"  + StringUtils.substring(appHeaderSenderDOs.getAhRcvlt(), 8, 11));
            }
            pgstsDO.setAhMpro(appHeaderSenderDOs.getAhMpro());
            pgstsDO.setAhioFlag(appHeaderSenderDOs.getAhioFlag());
        } else {
            // ??????AppHeaderReciver???????????????
            if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
                AppHeaderReciverDO appHeaderReciverDOs = swHeader.getAppHeaderReciverDO();
                String ahRefNo = appHeaderReciverDOs.getAhRefNo();
                String receiveBicCode = ahRefNo.substring(6, 14) + ahRefNo.substring(15, 18);
                pgstsDO.setAhioFlag(appHeaderReciverDOs.getAhioFlag());
                pgstsDO.setAhMt(appHeaderReciverDOs.getAhMt());
                pgstsDO.setAhMpro(appHeaderReciverDOs.getAhMpro());
                pgstsDO.setAhRcvlt(receiveBicCode);
                //????????????
                pgstsDO.setIncomeDate(appHeaderReciverDOs.getAhRecDate());
                pgstsDO.setIncomeTime(appHeaderReciverDOs.getAhRecTime());
            } else {
                KontException.throwBusinessException(MTConstants.MT_GEN_SENDER_OR_RECIVER_IS_EMPTY);
            }
        }
        //??????BasicHeader????????????
        if (JudgeUtils.isNull(swHeader.getBasicHeaderDO())) {
            KontException.throwBusinessException(MTConstants.MT_GEN_BASIC_HEADER_IS_EMPTY);
        } else {
            BasicHeaderDO basicHeaderDOs = swHeader.getBasicHeaderDO();
            if (JudgeUtils.isNull(basicHeaderDOs.getBhIsn())) {
                String seq = "000000";
                basicHeaderDOs.setBhIsn(seq);
                pgstsDO.setBhIsn(basicHeaderDOs.getBhIsn());
            } else {
                pgstsDO.setBhIsn(basicHeaderDOs.getBhIsn());
            }
            //????????????bicCode ???11?????????
            if (JudgeUtils.isNotNull(basicHeaderDOs.getBhSndlt())) {
                if (basicHeaderDOs.getBhSndlt().length()==12){
                    String bhSndlt = basicHeaderDOs.getBhSndlt();
                    bhSndlt=bhSndlt.substring(0,8)+bhSndlt.substring(9);
                    pgstsDO.setBhSndlt(bhSndlt);
                    basicHeaderDOs.setBhSndlt(bhSndlt);
                }else {
                    pgstsDO.setBhSndlt(basicHeaderDOs.getBhSndlt());
                }

                //?????????????????????12??? ???????????????
//                basicHeaderDOs.setBhSndlt(basicHeaderDOs.getBhSndlt().substring(0, 8) + "A" + basicHeaderDOs.getBhSndlt().substring(8));
            }
            if (JudgeUtils.isNull(basicHeaderDOs.getBhSessNo())) {
                String bhSessNo = "0000";
                basicHeaderDOs.setBhSessNo(bhSessNo);
                pgstsDO.setBhSessNo(basicHeaderDOs.getBhSessNo());
            } else {
                pgstsDO.setBhSessNo(basicHeaderDOs.getBhSessNo());
            }
        }
        //?????????????????????
//        BasicHeaderDO basicHeaderDO = swHeader.getBasicHeaderDO();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String date = sdf.format(new Date());
//        String ahRefNoDate = date.substring(2, 8);
//        String ahRefNo = ahRefNoDate + basicHeaderDO.getBhSndlt() + basicHeaderDO.getBhSessNo() + basicHeaderDO.getBhIsn();
//        if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
//            AppHeaderReciverDO appHeaderReciverDO = swHeader.getAppHeaderReciverDO();
//            appHeaderReciverDO.setAhRefNo(ahRefNo);
//        }
        //??????UserHeader????????????
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDOs = swHeader.getUserHeaderDO();
            pgstsDO.setOhGpiRef(userHeaderDOs.getOhGpiRef());
            //???20???????????????108???
            pgstsDO.setOhMuref(pgstsDO.getTrn());
            pgstsDO.setOhCov(userHeaderDOs.getOhCov());
            if (JudgeUtils.isNotNull(userHeaderDOs.getOhGpcFlg())){
                pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
            }else {
                //103 ????????????111???001
                if ("103".equals(pgstsDO.getAhMt())){
                    userHeaderDOs.setOhGpcFlg("001");
                    pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
                }
            }
            pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
            userHeaderDOs.setOhMuref(pgstsDO.getTrn());
            swHeader.setUserHeaderDO(userHeaderDOs);
        }

        //???????????? ??????????????????
        if (JudgeUtils.isNotNull(swHeader.getTrailersBlockDO())) {
            TrailersBlockDO trailersBlockDOs = swHeader.getTrailersBlockDO();
            if (JudgeUtils.isNotEmpty(trailersBlockDOs.getMtPdeNm())) {
                pgstsDO.setMtPdeNm(trailersBlockDOs.getMtPdeNm());
                pgstsDO.setMtRetryFlag("PDE");
            }
            if (JudgeUtils.isNotEmpty(trailersBlockDOs.getMtPdmNm())) {
                pgstsDO.setMtPdmNm(trailersBlockDOs.getMtPdmNm());
                pgstsDO.setMtRetryFlag("PDM");
            }
        }
        //??????????????????  ???????????????
        if (JudgeUtils.isNotNull(swHeader.getFrModule())){
            String frModule = swHeader.getFrModule().toLowerCase();
            pgstsDO.setFrModule(frModule);
        }
        //????????????
        if (JudgeUtils.isNotNull(swHeader.getPagmchOurRef())){
            pgstsDO.setPagmchOurRef(swHeader.getPagmchOurRef());
        }
        //gpi????????????
        if (JudgeUtils.isNotNull(swHeader.getGpiFlag())){
            pgstsDO.setGpiFlag(swHeader.getGpiFlag());
        }
        //??????????????????
        if (JudgeUtils.isNotNull(swHeader.getYourChl())){
            pgstsDO.setYourChl(swHeader.getYourChl());
        }
        //?????????
        if (JudgeUtils.isNotNull(swHeader.getLogNumber())){
            pgstsDO.setLogNumber(swHeader.getLogNumber());
        }
        //?????????
        if (JudgeUtils.isNotNull(swHeader.getTxnCode())){
            pgstsDO.setTxncode(swHeader.getTxnCode());
        }
        //????????????
        if (JudgeUtils.isNotNull(swHeader.getMtTemporary())){
            pgstsDO.setMtTemporary(swHeader.getMtTemporary());
        }
        logger.info("##### END TO COPY OR CHECK SWHEADER #####");
    }

    /**
     * ???????????????????????????????????????
     *
     * @param msgNum        ????????????
     * @param mtStr        ??????????????????
     * @param printContent ??????????????????
     * @param ohGpiRef     121???  GPI??????
     * @param ahMt         ????????????
     * @return
     */
    public MtDto generateMtDto(String msgNum, String mtStr, String printContent, String ohGpiRef, String ahMt,String cnFlag) {
        logger.info("##### START TO ASSEMBLE  RETURN MT DTO #####");
//        String msgNum = msgNo.getMessageNum();
        MtDto mto = new MtDto();
        mto.setMsgNo(msgNum);
        mto.setMtStr(mtStr);
        mto.setMessage(printContent);
        mto.setOhGpiRef(ohGpiRef);
        mto.setAhMt(ahMt);
        mto.setCnFlag(cnFlag);
        logger.info("\nSWIFT MESSAGE ASSEMBLY CONTENT: \n" + mto.getMtStr() + "\nSWIFT MESSAGE PRINT CONTENT: \n" + mto.getMessage());
        logger.info("##### END TO ASSEMBLE  RETURN MT DTO #####");
        return mto;
    }

    /**
     * ??????bicCode?????????????????????
     * ??????????????? QueryCorrPublicData??????  ???????????????????????????(FUNCTION=1)
     * @return ???????????????
     */
    public String getBankName(String bicCode, ReqHead reqHead) {
        logger.info("##### START TO CALL COR TO GET BANK NAME #####");
        logger.info("##### BIC CODE:{}",bicCode);
        GenericDTO<QueryCorrPublicDataReqDTO> genericDTO = new GenericDTO<>();
        QueryCorrPublicDataReqDTO reqDTO = new QueryCorrPublicDataReqDTO();
        //?????????????????????????????????
        List<Fun1> fun1List = new ArrayList<>();
        Fun1 fun1 = new Fun1();
        fun1.setCor1Key(bicCode);
        fun1.setCor1Addty("S");
        fun1.setNtk("N");
        fun1.setRswac("N");
        fun1.setUsagem("Y");
        fun1List.add(fun1);
        reqDTO.setFun1s(fun1List);
        reqDTO.setFun1Cnt(1);
        reqHead.setTarAppId(null);
        reqHead.setSrcAppId("RPS");
        reqDTO.setReqHead(reqHead);
        genericDTO.setBody(reqDTO);
        String  bankName = null;
        logger.info("##### INPUT PARAMETER:{}",genericDTO);
        GenericRspDTO<QueryCorrPublicDataRspDTO> queryCorrPublicData = new GenericRspDTO<>();
        //try catch ??????????????????cor??????650??????????????????????????????
        try {
            queryCorrPublicData = accountServiceClient.queryCorrPublicData(genericDTO);
            logger.info("##### RETURN PARAMETER:{}",queryCorrPublicData);
            if (JudgeUtils.isNotSuccess(queryCorrPublicData.getMsgCd())){
                logger.error("##### CALL COR TO GET BANK NAME ERROR :{}",queryCorrPublicData.getMsgCd());
                KontException.throwKontException(queryCorrPublicData.getMsgCd(),queryCorrPublicData.getMsgInfo());
            }else {
                logger.info("##### GET BANK NAME SUCCESS #####");
                if (JudgeUtils.isNotNull(queryCorrPublicData.getBody().getFun1Returns())){
                    List<Fun1Return> fun1Returns = queryCorrPublicData.getBody().getFun1Returns();
                    for (Fun1Return fun1Return : fun1Returns) {
                        if (JudgeUtils.isNotNull(fun1Return.getCor1Name())){
                            bankName = fun1Return.getCor1Name();
                            logger.info("##### BANK NAME:{}",bankName);
                        }
                    }
                }
            }
        }catch (Exception e){
            logger.error("##### CALL COR ERROR:{}",e);
        }
        if (JudgeUtils.isNotNull(bankName)){
            bankName = bankName.trim();
        }
        logger.info("##### END TO CALL COR TO GET BANK NAME #####");
        return bankName;
    }

    /**
     * ???redis???????????????????????????tag???????????????
     * redisFlag  ???true???redis???????????????  ???false???oracle?????????
     *
     * @param pgstsDO ??????????????????
     * @return ???????????????????????????tag?????????
     */
    public Map<String, String> getTagDescribe(PgstsDO pgstsDO) {
        String ahMt = pgstsDO.getAhMt();
        logger.info("##### START TO GET PG TAG DESCRIBE ,THE MT TYPE:{}",ahMt);
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
        if ("202".equals(ahMt) && JudgeUtils.isNotNull(pgstsDO.getOhCov())){
            logger.info("##### THE MT TYPE IS 202COV,GIVE MT103 TAG DESCRIBE TO IT #####");
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
        logger.info("##### END TO GET PG TAG DESCRIBE #####");
        return map;
    }

    /**
     * ??????bankCode????????????swiftKey  ??????????????????????????? "/"???????????? ??????NAK
     *
     * @param swHeader
     */
    public String checkBicForCor(SwHeader swHeader, ReqHead reqHead) {
        logger.info("##### START TO CALL COR AND CHECK RECEIVE BIC #####");
        //??????????????????bic  ??????????????????????????????
        String receiveName = null;
        //??????PALCPWD-OLD-RECE(???8???)???PAS-GPI-TRCK-BIC(???8???)??????   TRCKCHZZXXX
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            if (!trackerBic.equals(swHeader.getAppHeaderSenderDO().getAhRcvlt())) {
                GenericDTO<QueryCorrPublicDataReqDTO> genericDTO = new GenericDTO<>();
                QueryCorrPublicDataReqDTO reqDTO = new QueryCorrPublicDataReqDTO();
                List<Fun1> fun1List = new ArrayList<>();
                Fun1 fun1 = new Fun1();
                //????????????
                fun1.setCor1Key(swHeader.getAppHeaderSenderDO().getAhRcvlt());
                fun1.setCor1Addty("S");
                fun1.setNtk("N");
                fun1.setRswac("N");
                fun1.setUsagem("Y");
                fun1List.add(fun1);
                reqDTO.setFun1s(fun1List);
                reqDTO.setFun1Cnt(1);
                reqDTO.setReqHead(reqHead);
                genericDTO.setBody(reqDTO);
                logger.info("##### CALL COR PARAMETERS:{}",genericDTO);
                GenericRspDTO<QueryCorrPublicDataRspDTO> queryCorrPublicData = accountServiceClient.queryCorrPublicData(genericDTO);
                logger.info("##### RETURN COR PARAMETERS:{}",queryCorrPublicData);
                //????????????????????????????????????
                if (JudgeUtils.isNotNull(queryCorrPublicData.getBody()) && JudgeUtils.isSuccess(queryCorrPublicData.getMsgCd())){
                    String pgmRtCode = queryCorrPublicData.getBody().getPgmRtCode();
                    //pgmRtCode = 0000 ??????cor??????????????????
                    if ("0000".equals(pgmRtCode)) {
                        List<Fun1Return> returnList = queryCorrPublicData.getBody().getFun1Returns();
                        for (Fun1Return fun1Return : returnList) {
                            String cor1Rtc = fun1Return.getCor1Rtc();
                            logger.info("##### COR RETURN CODE:{}",cor1Rtc);
                            if ("362".equals(cor1Rtc) || "365".equals(cor1Rtc) || "366".equals(cor1Rtc)) {
                                AppHeaderSenderDO appHeaderSenderDO = swHeader.getAppHeaderSenderDO();
                                String ahRcvlt = appHeaderSenderDO.getAhRcvlt();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(ahRcvlt.substring(0, 7) + "/" + ahRcvlt.substring(8));
                                String s = stringBuilder.toString();
                                appHeaderSenderDO.setAhRcvlt(s);
                                swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
                            }else if ("0000".equals(cor1Rtc) || "363".equals(cor1Rtc)|| "367".equals(cor1Rtc)){
                                //??????????????? ????????????
                                logger.info("##### AGENT BANK EXIST #####");
                                //??????????????????????????????
                                if (JudgeUtils.isNotNull(fun1Return.getCor1Name())){
                                    receiveName = fun1Return.getCor1Name();
                                }
                                logger.info("##### RECEIVE BIC BANK NAME:{}",receiveName);
                            }else {
                                //????????????????????????
                                logger.error("##### OTHER CONDITIONS:{}",cor1Rtc);
                                KontException.throwKontException(MTConstants.COR_ERROR);
                            }
                        }
                    }else {
                        //pgmRtCode  ????????????999 851 ????????????
                        logger.error("##### CALL COR ERROR,RETURN PGMRTCODE:{}",pgmRtCode);
                        KontException.throwKontException(MTConstants.COR_ERROR);
                    }
                }else {
                    //cor??????body????????????????????????????????????
                    logger.error("##### CALL COR RETURN ERROR OR BODY IS NULL:{}",queryCorrPublicData.getMsgCd());
                    KontException.throwKontException(queryCorrPublicData.getMsgCd());
                }
            }
        }
        logger.info("##### END TO CALL COR AND CHECK RECEIVE BIC #####");
        return receiveName;
    }

    /**
     * ??????????????? ??????????????????(????????????)
     * @return
     */
    public LocalDateTime getSysLocalDate(){
        logger.info("##### START TO GET SYSTEM DATA #####");
        GenericDTO<GetSysDateTimeReqDTO> genericDTO = new GenericDTO<>();
        GenericRspDTO<GetSysDateTimeRspDTO> sysDateTime = systemDate.getSysDateTime(genericDTO);
        if (JudgeUtils.isNotSuccess(sysDateTime.getMsgCd()) || JudgeUtils.isNull(sysDateTime.getBody())){
            logger.error("##### CALL GET SYSTEM DATA INTERFACE ERROR:{}",sysDateTime.getMsgCd());
            KontException.throwBusinessException(sysDateTime.getMsgCd());
        }
        GetSysDateTimeRspDTO body = sysDateTime.getBody();
        LocalDateTime dateTime = body.getSysDateTime();
        logger.info("##### SYSTEM DATA TIME:{}",dateTime);
        logger.info("##### END TO GET SYSTEM DATA #####");
        return dateTime;
    }

    /**
     * ??????????????????????????????
     * @return
     */
    public LocalDate getAcDate(){
        logger.info("##### START TO GET AC DATA #####");
        GenericDTO<GetNowWorkDayReqDTO> genericDTO = new GenericDTO<>();
        GenericRspDTO<GetNowWorkDayRspDTO> nowWorkDay = rpsDtServerClient.getNowWorkDay(genericDTO);
        if (JudgeUtils.isNotSuccess(nowWorkDay.getMsgCd()) || JudgeUtils.isNull(nowWorkDay.getBody())){
            logger.error("##### CALL GET AC DATA INTERFACE ERROR:{}",nowWorkDay.getMsgCd());
            KontException.throwBusinessException(nowWorkDay.getMsgCd());
        }
        //??????????????? ???????????????yyyyMMdd?????????yyyy-MM-dd
        String idDt = nowWorkDay.getBody().getIdDt();
        LocalDate localDate = LocalDate.parse(idDt, DateTimeFormatter.ofPattern("yyyyMMdd"));
        //?????????????????????
        logger.info("##### AC DATA:{}",localDate);
        logger.info("##### END TO GET AC DATA #####");
        return localDate;
    }

    /**
     * ???GPI199???F79?????????????????????
     * @param pgstsDO
     */
    public String pushF79ToExport(PgstsDO pgstsDO,GpiF79DTO f79Value,ReqHead reqHead){
        logger.info("##### START TO PUSH GPI F79 INFO TO OR #####");
        GenericDTO<GpiTrackerMt199ReqDTO> genericDTO = new GenericDTO<>();
        GpiTrackerMt199ReqDTO gpiTrackerMt199ReqDTO = new GpiTrackerMt199ReqDTO();
        //????????????
        gpiTrackerMt199ReqDTO.setOurRef(pgstsDO.getPagmchOurRef());
        //GPI??????
        gpiTrackerMt199ReqDTO.setOhGpiRef(pgstsDO.getOhGpiRef());
        //????????????
        gpiTrackerMt199ReqDTO.setYourChannel(pgstsDO.getYourChl());
        /* ---------F79??????---------*/
        //F79?????????  ?????? ?????? ??????
        gpiTrackerMt199ReqDTO.setIncomeDate(f79Value.getGpiDate());
        gpiTrackerMt199ReqDTO.setIncomeTime(f79Value.getGpiTime());
        gpiTrackerMt199ReqDTO.setIncomeTimeZone(f79Value.getGpiZone());
        //F79?????????  ??????  ??????
        gpiTrackerMt199ReqDTO.setGpiStatus(f79Value.getGpiStatus());
        gpiTrackerMt199ReqDTO.setGpiReason(f79Value.getGpiReasonCode());
        //F79?????????   ??????????????????
        gpiTrackerMt199ReqDTO.setOriginalBic(f79Value.getStatusOriBic());
        //F79?????????  ??????  ??????
        gpiTrackerMt199ReqDTO.setPayCur(f79Value.getF32ACur());
        gpiTrackerMt199ReqDTO.setF79creditAcAmt(f79Value.getF32Amount());
        //F79?????????  ?????????
        String payRate = null;
        if (JudgeUtils.isNotNull(f79Value.getOriCYY()) && JudgeUtils.isNotNull(f79Value.getTarCYY()) && JudgeUtils.isNotNull(f79Value.getExRate())){
            payRate = "//"+f79Value.getOriCYY()+"/"+f79Value.getTarCYY()+"/"+f79Value.getExRate();
        }
        gpiTrackerMt199ReqDTO.setF79payRate(payRate);
        gpiTrackerMt199ReqDTO.setReqHead(reqHead);
        genericDTO.setBody(gpiTrackerMt199ReqDTO);
        logger.info("##### INPUT PARAMETER:{}",genericDTO);
        GenericRspDTO<GpiTrackerMt199RspDTO> rspDTO = gpiTrackMt199ServiceClient.gpiTrackerMt199(genericDTO);
        logger.info("##### RETURN PARAMETER:{}",rspDTO);
        if (JudgeUtils.isNotSuccess(rspDTO.getMsgCd())){
            logger.error("##### CALL OR GET F79 INFO INTERFACE ERROR:{},MSG NO:{}",rspDTO.getMsgCd(),pgstsDO.getMsgNo());
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
        }
        logger.info("##### END TO PUSH GPI F79 INFO TO OR #####");
        return rspDTO.getMsgCd();
    }

    /**
     * ???????????? ??????????????????id ??????
     * @param pgstsDO
     * @param genericDTO
     * @return
     */
    public PgstsDO saveTaskId(PgstsDO pgstsDO,GenericDTO genericDTO){
        //???????????????id
        JobDTO jobDTO = KontJsonUtil.toBean(genericDTO.getAppExtHeader(), JobDTO.class);
        if (JudgeUtils.isNotNull(jobDTO.getJobJournalNo())){
            pgstsDO.setRetransmissionId(jobDTO.getJobJournalNo());
            logger.info("##### PG RETRANSMISSION ID FOR JOB ID:{}",pgstsDO.getRetransmissionId());
        }
        return pgstsDO;
    }
}
