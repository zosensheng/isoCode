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
     * 对头部信息做一些检查
     *
     * @param swHeader 报文头部对象
     * @param pgstsDO
     */
    public void HeaderValueCopy(SwHeader swHeader, PgstsDO pgstsDO) {
        logger.info("##### START TO COPY OR CHECK SWHEADER #####");
        // 判断AppHeaderSender是否不为空
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            AppHeaderSenderDO appHeaderSenderDOs = swHeader.getAppHeaderSenderDO();
            pgstsDO.setAhMt(appHeaderSenderDOs.getAhMt());
            //入库存11位  收报行的bicCode
            if (appHeaderSenderDOs.getAhRcvlt().length()==12){
                String ahRcvlt = appHeaderSenderDOs.getAhRcvlt();
                ahRcvlt = ahRcvlt.substring(0,8)+ahRcvlt.substring(9);
                pgstsDO.setAhRcvlt(ahRcvlt);
                appHeaderSenderDOs.setAhRcvlt(ahRcvlt);
            }else {
                pgstsDO.setAhRcvlt(appHeaderSenderDOs.getAhRcvlt());
            }

            //测试环境dev下 改第八位为0
            if ("dev".equals(active)) {
                appHeaderSenderDOs.setAhRcvlt(
                        StringUtils.substring(appHeaderSenderDOs.getAhRcvlt(), 0, 7) +
                                "0"  + StringUtils.substring(appHeaderSenderDOs.getAhRcvlt(), 8, 11));
            }
            pgstsDO.setAhMpro(appHeaderSenderDOs.getAhMpro());
            pgstsDO.setAhioFlag(appHeaderSenderDOs.getAhioFlag());
        } else {
            // 判断AppHeaderReciver是否不为空
            if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
                AppHeaderReciverDO appHeaderReciverDOs = swHeader.getAppHeaderReciverDO();
                String ahRefNo = appHeaderReciverDOs.getAhRefNo();
                String receiveBicCode = ahRefNo.substring(6, 14) + ahRefNo.substring(15, 18);
                pgstsDO.setAhioFlag(appHeaderReciverDOs.getAhioFlag());
                pgstsDO.setAhMt(appHeaderReciverDOs.getAhMt());
                pgstsDO.setAhMpro(appHeaderReciverDOs.getAhMpro());
                pgstsDO.setAhRcvlt(receiveBicCode);
                //收报日期
                pgstsDO.setIncomeDate(appHeaderReciverDOs.getAhRecDate());
                pgstsDO.setIncomeTime(appHeaderReciverDOs.getAhRecTime());
            } else {
                KontException.throwBusinessException(MTConstants.MT_GEN_SENDER_OR_RECIVER_IS_EMPTY);
            }
        }
        //判断BasicHeader是否为空
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
            //发报行的bicCode 存11位入库
            if (JudgeUtils.isNotNull(basicHeaderDOs.getBhSndlt())) {
                if (basicHeaderDOs.getBhSndlt().length()==12){
                    String bhSndlt = basicHeaderDOs.getBhSndlt();
                    bhSndlt=bhSndlt.substring(0,8)+bhSndlt.substring(9);
                    pgstsDO.setBhSndlt(bhSndlt);
                    basicHeaderDOs.setBhSndlt(bhSndlt);
                }else {
                    pgstsDO.setBhSndlt(basicHeaderDOs.getBhSndlt());
                }

                //由于终端地址位12位 则补充一位
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
        //报文输入参考号
//        BasicHeaderDO basicHeaderDO = swHeader.getBasicHeaderDO();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String date = sdf.format(new Date());
//        String ahRefNoDate = date.substring(2, 8);
//        String ahRefNo = ahRefNoDate + basicHeaderDO.getBhSndlt() + basicHeaderDO.getBhSessNo() + basicHeaderDO.getBhIsn();
//        if (JudgeUtils.isNotNull(swHeader.getAppHeaderReciverDO())) {
//            AppHeaderReciverDO appHeaderReciverDO = swHeader.getAppHeaderReciverDO();
//            appHeaderReciverDO.setAhRefNo(ahRefNo);
//        }
        //判断UserHeader是否为空
        if (JudgeUtils.isNotNull(swHeader.getUserHeaderDO())) {
            UserHeaderDO userHeaderDOs = swHeader.getUserHeaderDO();
            pgstsDO.setOhGpiRef(userHeaderDOs.getOhGpiRef());
            //将20域的值赋给108域
            pgstsDO.setOhMuref(pgstsDO.getTrn());
            pgstsDO.setOhCov(userHeaderDOs.getOhCov());
            if (JudgeUtils.isNotNull(userHeaderDOs.getOhGpcFlg())){
                pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
            }else {
                //103 全都设置111为001
                if ("103".equals(pgstsDO.getAhMt())){
                    userHeaderDOs.setOhGpcFlg("001");
                    pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
                }
            }
            pgstsDO.setGpcFlag(userHeaderDOs.getOhGpcFlg());
            userHeaderDOs.setOhMuref(pgstsDO.getTrn());
            swHeader.setUserHeaderDO(userHeaderDOs);
        }

        //报尾信息 判断是否重发
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
        //所属模块入库  统一转小写
        if (JudgeUtils.isNotNull(swHeader.getFrModule())){
            String frModule = swHeader.getFrModule().toLowerCase();
            pgstsDO.setFrModule(frModule);
        }
        //业务编号
        if (JudgeUtils.isNotNull(swHeader.getPagmchOurRef())){
            pgstsDO.setPagmchOurRef(swHeader.getPagmchOurRef());
        }
        //gpi优先标志
        if (JudgeUtils.isNotNull(swHeader.getGpiFlag())){
            pgstsDO.setGpiFlag(swHeader.getGpiFlag());
        }
        //发动交易渠道
        if (JudgeUtils.isNotNull(swHeader.getYourChl())){
            pgstsDO.setYourChl(swHeader.getYourChl());
        }
        //日志号
        if (JudgeUtils.isNotNull(swHeader.getLogNumber())){
            pgstsDO.setLogNumber(swHeader.getLogNumber());
        }
        //交易码
        if (JudgeUtils.isNotNull(swHeader.getTxnCode())){
            pgstsDO.setTxncode(swHeader.getTxnCode());
        }
        //暂存标识
        if (JudgeUtils.isNotNull(swHeader.getMtTemporary())){
            pgstsDO.setMtTemporary(swHeader.getMtTemporary());
        }
        logger.info("##### END TO COPY OR CHECK SWHEADER #####");
    }

    /**
     * 组装成功后，返回的消息内容
     *
     * @param msgNum        报文编号
     * @param mtStr        报文组装内容
     * @param printContent 报文打印内容
     * @param ohGpiRef     121域  GPI编号
     * @param ahMt         报文类型
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
     * 根据bicCode获得代理行名称
     * 调公共接口 QueryCorrPublicData接口  查询代理行公有资料(FUNCTION=1)
     * @return 代理行名称
     */
    public String getBankName(String bicCode, ReqHead reqHead) {
        logger.info("##### START TO CALL COR TO GET BANK NAME #####");
        logger.info("##### BIC CODE:{}",bicCode);
        GenericDTO<QueryCorrPublicDataReqDTO> genericDTO = new GenericDTO<>();
        QueryCorrPublicDataReqDTO reqDTO = new QueryCorrPublicDataReqDTO();
        //填写查询代理行资料入参
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
        //try catch 收报不因为调cor生成650异常，而不继续往下派
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
     * 从redis或者数据库表中获得tag的描述信息
     * redisFlag  为true查redis数据库数据  为false查oracle数据库
     *
     * @param pgstsDO 获得报文类型
     * @return 某种报文类型的所有tag域信息
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
        //如果是202COV 需要查询103的部分tag描述 33B 50 59 70
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
     * 检查bankCode是否存在swiftKey  不存在修改第八位为 "/"以便拒纳 返回NAK
     *
     * @param swHeader
     */
    public String checkBicForCor(SwHeader swHeader, ReqHead reqHead) {
        logger.info("##### START TO CALL COR AND CHECK RECEIVE BIC #####");
        //检查收报行的bic  顺便记下收报行的名称
        String receiveName = null;
        //如果PALCPWD-OLD-RECE(前8位)和PAS-GPI-TRCK-BIC(前8位)相等   TRCKCHZZXXX
        if (JudgeUtils.isNotNull(swHeader.getAppHeaderSenderDO())) {
            if (!trackerBic.equals(swHeader.getAppHeaderSenderDO().getAhRcvlt())) {
                GenericDTO<QueryCorrPublicDataReqDTO> genericDTO = new GenericDTO<>();
                QueryCorrPublicDataReqDTO reqDTO = new QueryCorrPublicDataReqDTO();
                List<Fun1> fun1List = new ArrayList<>();
                Fun1 fun1 = new Fun1();
                //设置参数
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
                //判断调用接口返回是否正常
                if (JudgeUtils.isNotNull(queryCorrPublicData.getBody()) && JudgeUtils.isSuccess(queryCorrPublicData.getMsgCd())){
                    String pgmRtCode = queryCorrPublicData.getBody().getPgmRtCode();
                    //pgmRtCode = 0000 调用cor接口处理成功
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
                                //代理行存在 不用修改
                                logger.info("##### AGENT BANK EXIST #####");
                                //成功后拿下收报行名字
                                if (JudgeUtils.isNotNull(fun1Return.getCor1Name())){
                                    receiveName = fun1Return.getCor1Name();
                                }
                                logger.info("##### RECEIVE BIC BANK NAME:{}",receiveName);
                            }else {
                                //其他情况返回报错
                                logger.error("##### OTHER CONDITIONS:{}",cor1Rtc);
                                KontException.throwKontException(MTConstants.COR_ERROR);
                            }
                        }
                    }else {
                        //pgmRtCode  为其他值999 851 处理失败
                        logger.error("##### CALL COR ERROR,RETURN PGMRTCODE:{}",pgmRtCode);
                        KontException.throwKontException(MTConstants.COR_ERROR);
                    }
                }else {
                    //cor返回body为空或者处理接口调用异常
                    logger.error("##### CALL COR RETURN ERROR OR BODY IS NULL:{}",queryCorrPublicData.getMsgCd());
                    KontException.throwKontException(queryCorrPublicData.getMsgCd());
                }
            }
        }
        logger.info("##### END TO CALL COR AND CHECK RECEIVE BIC #####");
        return receiveName;
    }

    /**
     * 调公共接口 获取系统日期(当天时间)
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
     * 调公共接口获取会计日
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
        //格式化日期 将公共返回yyyyMMdd格式成yyyy-MM-dd
        String idDt = nowWorkDay.getBody().getIdDt();
        LocalDate localDate = LocalDate.parse(idDt, DateTimeFormatter.ofPattern("yyyyMMdd"));
        //转换后的会计日
        logger.info("##### AC DATA:{}",localDate);
        logger.info("##### END TO GET AC DATA #####");
        return localDate;
    }

    /**
     * 送GPI199的F79给汇出进行推送
     * @param pgstsDO
     */
    public String pushF79ToExport(PgstsDO pgstsDO,GpiF79DTO f79Value,ReqHead reqHead){
        logger.info("##### START TO PUSH GPI F79 INFO TO OR #####");
        GenericDTO<GpiTrackerMt199ReqDTO> genericDTO = new GenericDTO<>();
        GpiTrackerMt199ReqDTO gpiTrackerMt199ReqDTO = new GpiTrackerMt199ReqDTO();
        //业务编号
        gpiTrackerMt199ReqDTO.setOurRef(pgstsDO.getPagmchOurRef());
        //GPI编号
        gpiTrackerMt199ReqDTO.setOhGpiRef(pgstsDO.getOhGpiRef());
        //发动渠道
        gpiTrackerMt199ReqDTO.setYourChannel(pgstsDO.getYourChl());
        /* ---------F79赋值---------*/
        //F79第一行  日期 时间 时区
        gpiTrackerMt199ReqDTO.setIncomeDate(f79Value.getGpiDate());
        gpiTrackerMt199ReqDTO.setIncomeTime(f79Value.getGpiTime());
        gpiTrackerMt199ReqDTO.setIncomeTimeZone(f79Value.getGpiZone());
        //F79第二行  状态  原因
        gpiTrackerMt199ReqDTO.setGpiStatus(f79Value.getGpiStatus());
        gpiTrackerMt199ReqDTO.setGpiReason(f79Value.getGpiReasonCode());
        //F79第三行   原状态发起行
        gpiTrackerMt199ReqDTO.setOriginalBic(f79Value.getStatusOriBic());
        //F79第四行  货币  金额
        gpiTrackerMt199ReqDTO.setPayCur(f79Value.getF32ACur());
        gpiTrackerMt199ReqDTO.setF79creditAcAmt(f79Value.getF32Amount());
        //F79第五行  兑换率
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
     * 调用工具 获取重发任务id 记档
     * @param pgstsDO
     * @param genericDTO
     * @return
     */
    public PgstsDO saveTaskId(PgstsDO pgstsDO,GenericDTO genericDTO){
        //记重发任务id
        JobDTO jobDTO = KontJsonUtil.toBean(genericDTO.getAppExtHeader(), JobDTO.class);
        if (JudgeUtils.isNotNull(jobDTO.getJobJournalNo())){
            pgstsDO.setRetransmissionId(jobDTO.getJobJournalNo());
            logger.info("##### PG RETRANSMISSION ID FOR JOB ID:{}",pgstsDO.getRetransmissionId());
        }
        return pgstsDO;
    }
}
