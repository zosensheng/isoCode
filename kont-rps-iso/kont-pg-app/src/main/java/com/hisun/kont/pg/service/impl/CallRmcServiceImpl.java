package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.client.AccountServiceClient;
import com.hisun.kont.igw.igw.remote.*;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgSrcSwLogDao;
import com.hisun.kont.pg.dao.PgSrcSwitchDao;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgSrcSwLogDO;
import com.hisun.kont.pg.entity.PgSrcSwitchDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.bocpays.remote.RspHead;
import com.hisun.kont.pg.service.CallRmcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Author: Li ZhiJian
 * @ClassName: CallRmcServiceImpl
 * @Date 2021/6/24 14:57
 * @Description: 通过 igw 调用 rmc
 * @Version 1.0
 **/
@Service
public class CallRmcServiceImpl implements CallRmcService {

    private static final Logger logger = LoggerFactory.getLogger(CallRmcServiceImpl.class);

    @Resource
    private AccountServiceClient accountServiceClient;

    @Resource
    private PgSrcSwitchDao pgSrcSwitchDao;

    @Resource
    private PgSrcSwLogDao pgSrcSwLogDao;

    @Resource
    private PgstsDao pgstsDao;

    @Resource
    private CommonAssembleImpl commonAssemble;

    /**
     * 接收报文返回结果
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<ReceiveRemitMsgAckRspDTO> receiveRemitMessageAck(GenericDTO<ReceiveRemitMsgAckReqDTO> reqDto) {
        ReceiveRemitMsgAckReqDTO receiveRemitMsgAckReqDTO = reqDto.getBody();

        /** 填充调用 IGW 接口的请求字段 */
        ReceiveRemitMsgResReqDTO receiveRemitMsgResReqDTO = new ReceiveRemitMsgResReqDTO();
        // 填充应用传来的数据
        BeanUtils.copyProperties(receiveRemitMsgAckReqDTO, receiveRemitMsgResReqDTO);
        // 补充数据
        receiveRemitMsgResReqDTO.setFunCd("8");
        //判断是否为toRmc传过来的交易码
        ReqHead reqHead = receiveRemitMsgAckReqDTO.getReqHead();
        if (JudgeUtils.isNull(reqHead.getTxnCode())){
            reqHead.setTxnCode("23635");
        }
        receiveRemitMsgResReqDTO.setReqHead(new ReqHead());
        BeanUtils.copyProperties(receiveRemitMsgAckReqDTO.getReqHead(), receiveRemitMsgResReqDTO.getReqHead());
        GenericDTO<ReceiveRemitMsgResReqDTO> igwReqDTO = new GenericDTO<>();
        igwReqDTO.setBody(receiveRemitMsgResReqDTO);

        /** 调用 IGW 接口*/
        GenericRspDTO<ReceiveRemitMsgResRspDTO> igwRspDTO = accountServiceClient.receiveRemitMessageRes(igwReqDTO);
        GenericRspDTO<ReceiveRemitMsgAckRspDTO> rspDTO = new GenericRspDTO<>();
        if (JudgeUtils.isNull(igwRspDTO)||JudgeUtils.isNotSuccess(igwRspDTO.getMsgCd())) {
            rspDTO.setMsgCd(MTConstants.CALL_RMC_ERR);
            if (JudgeUtils.isNotNull(igwRspDTO.getBody())) {
                rspDTO.setMsgInfo(igwRspDTO.getBody().getRspHead().getErrorMsg());
            }
        } else {
            ReceiveRemitMsgAckRspDTO receiveRemitMsgAckRspDTO = new ReceiveRemitMsgAckRspDTO();
            if (JudgeUtils.isNotNull(igwRspDTO.getBody())) {
                BeanUtils.copyProperties(igwRspDTO.getBody(), receiveRemitMsgAckRspDTO);
            }
            RspHead rspHead = new RspHead();
            BeanUtils.copyProperties(reqHead,rspHead);
            //模拟生成日志号
//            String logPgNumber = IdGenUtils.generateId("logPgNumber",11);
//            rspHead.setJournalNo(logPgNumber);
            rspHead.setTxnType("N");
            //退回RMC成功，修改网关报文状态为 RTN
            PgstsDO pgstsDO = new PgstsDO();
            String srcBk = receiveRemitMsgAckReqDTO.getSrcBk();
            String srcDate = receiveRemitMsgAckReqDTO.getSrcDate();
            String srcSeq = receiveRemitMsgAckReqDTO.getSrcSeq();
            pgstsDO.setMsgNo(srcBk+srcDate+srcSeq);
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_RTN);
            pgstsDao.update(pgstsDO);

            receiveRemitMsgAckRspDTO.setRspHead(rspHead);
            rspDTO.setMsgCd(igwRspDTO.getMsgCd());
            rspDTO.setBody(receiveRemitMsgAckRspDTO);
        }
        return rspDTO;
    }

    /**
     * 发出报文接口
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<SendRemitMessageRspDTO> sendRemitMessagePG(GenericDTO<SendRemitMsgReqPGDTO> reqDto) {
        /** 获取应用给的数据 */
        SendRemitMsgReqPGDTO sendRemitMessageReqPGDTO = reqDto.getBody();

        /** 填充调用 IGW 接口的请求字段 */
        SendRemitMessageReqDTO sendRemitMessageReqDTO = new SendRemitMessageReqDTO();
        // 填充应用传来的数据
        BeanUtils.copyProperties(sendRemitMessageReqPGDTO.getEaiHeaderDTO(), sendRemitMessageReqDTO);
        BeanUtils.copyProperties(sendRemitMessageReqPGDTO.getRmcTrx01(), sendRemitMessageReqDTO);
        sendRemitMessageReqDTO.setReqHead(new ReqHead());
        BeanUtils.copyProperties(sendRemitMessageReqPGDTO.getReqHead(), sendRemitMessageReqDTO.getReqHead());
        // 补充数据
        sendRemitMessageReqDTO.setFunCode("7");
        GenericDTO<SendRemitMessageReqDTO> reqDTO = new GenericDTO<>();
        reqDTO.setBody(sendRemitMessageReqDTO);

        /** 调用 IGW 接口*/
        GenericRspDTO<SendRemitMessageRspDTO> rspDTO = accountServiceClient.sendRemitMessage(reqDTO);
        if (JudgeUtils.isNull(rspDTO)) {
            rspDTO = new GenericRspDTO<>();
            rspDTO.setMsgCd(MTConstants.CALL_RMC_ERR);
        }
        return rspDTO;
    }

    /**
     * 取长收入报文接口
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<LongIncomeMsgFetchRspDTO> longIncomeMsgFetchPG(GenericDTO<LongIncomeMsgFetchReqPGDTO> reqDto) {
        /** 获取应用给的数据 */
        LongIncomeMsgFetchReqPGDTO longIncomeMsgFetchReqPGDTO = reqDto.getBody();

        /** 填充调用 IGW 接口的请求字段 */
        LongIncomeMsgFetchReqDTO longIncomeMsgFetchReqDTO = new LongIncomeMsgFetchReqDTO();
        // 填充应用传来的数据
        BeanUtils.copyProperties(longIncomeMsgFetchReqPGDTO, longIncomeMsgFetchReqDTO);
        // 补充数据
        longIncomeMsgFetchReqDTO.setFunCd("D");
        longIncomeMsgFetchReqDTO.setReqHead(new ReqHead());
        BeanUtils.copyProperties(longIncomeMsgFetchReqPGDTO.getReqHead(), longIncomeMsgFetchReqDTO.getReqHead());
        GenericDTO<LongIncomeMsgFetchReqDTO> reqDTO = new GenericDTO<>();
        reqDTO.setBody(longIncomeMsgFetchReqDTO);

        /** 调用 IGW 接口*/
        GenericRspDTO<LongIncomeMsgFetchRspDTO> rspDTO = accountServiceClient.longIncomeMsgFetch(reqDTO);
        if (JudgeUtils.isNull(rspDTO)) {
            rspDTO = new GenericRspDTO<>();
            rspDTO.setMsgCd(MTConstants.CALL_RMC_ERR);
        }
        return rspDTO;
    }

    /**
     * 源業務系統開啓暫停處理業務通知接口
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<SourceSysProcessBussRspDTO> sourceSysProcessBussPG(GenericDTO<SourceSysProcessBussReqPGDTO> reqDto) {
        /** 获取应用给的数据 */
        SourceSysProcessBussReqPGDTO sourceSysProcessBussReqPGDTO = reqDto.getBody();
        /** 填充调用 IGW 接口的请求字段 */
        SourceSysProcessBussReqDTO sourceSysProcessBussReqDTO = new SourceSysProcessBussReqDTO();
        // 填充应用传来的数据
        BeanUtils.copyProperties(sourceSysProcessBussReqPGDTO, sourceSysProcessBussReqDTO);
        // 补充数据
        sourceSysProcessBussReqDTO.setFunCd("C");
        sourceSysProcessBussReqDTO.setErrCode("00");
        sourceSysProcessBussReqDTO.setSrcAppl("RPS");
        sourceSysProcessBussReqDTO.setReqHead(new ReqHead());
        sourceSysProcessBussReqDTO.setSrcBk(sourceSysProcessBussReqPGDTO.getReqHead().getBankCode());
        BeanUtils.copyProperties(sourceSysProcessBussReqPGDTO.getReqHead(), sourceSysProcessBussReqDTO.getReqHead());
        GenericDTO<SourceSysProcessBussReqDTO> reqDTO = new GenericDTO<>();
        reqDTO.setBody(sourceSysProcessBussReqDTO);

        /** 调用 IGW 接口*/
        GenericRspDTO<SourceSysProcessBussRspDTO> rspDTO = accountServiceClient.sourceSysProcessBuss(reqDTO);
        if (JudgeUtils.isNull(rspDTO)) {
            rspDTO = new GenericRspDTO<>();
            rspDTO.setMsgCd(MTConstants.CALL_RMC_ERR);
        }
        return rspDTO;
    }

    /**
     * 源业务系统开关状态 查询（I）/修改（U）
     * @param reqDto
     * @return 所有状态的查询结果 or 修改后的结果
     */
    public GenericRspDTO<AutoChannelRspDto> updateSourceSysProcessBussPG(GenericDTO<AutoChannelReqDto> reqDto) {
        AutoChannelReqDto autoChannelDto = reqDto.getBody();
        GenericRspDTO<AutoChannelRspDto> genericRspDTO = new GenericRspDTO<>();
        GenericDTO<SourceSysProcessBussReqPGDTO> genericDTO = new GenericDTO<>();
        /** 原业务系统开关查询 */
        PgSrcSwitchDO pgSrcSwitchDO = new PgSrcSwitchDO();
        AutoChannelRspDto channelDto = new AutoChannelRspDto();
        logger.info("##### START TO 23930 #####");
        if ("I".equals(autoChannelDto.getAction())){
            logger.info("##### QUERY INFORMATION FOR 23930 #####");
            channelDto.setAction("I");
            pgSrcSwitchDO.setSrcSwType("MT103 / 103+");
            PgSrcSwitchDO mt103 = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            channelDto.setMt103(mt103.getSrcSwStatus());
            pgSrcSwitchDO.setSrcSwType("MT202 / 200");
            PgSrcSwitchDO mt202 = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            channelDto.setMt202(mt202.getSrcSwStatus());
            pgSrcSwitchDO.setSrcSwType("XML");
            PgSrcSwitchDO xml = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            channelDto.setXml(xml.getSrcSwStatus());
            pgSrcSwitchDO.setSrcSwType("OTHER SWIFT TEL");
            PgSrcSwitchDO other = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            channelDto.setOtherSwiftTel(other.getSrcSwStatus());
            pgSrcSwitchDO.setSrcSwType("CHATS");
            PgSrcSwitchDO chats = pgSrcSwitchDao.getByKey(pgSrcSwitchDO);
            channelDto.setCharts(chats.getSrcSwStatus());

            genericRspDTO.setBody(channelDto);
        }
        /** 原业务系统开关修改  修改一次 调一次接口 */
        if ("U".equals(autoChannelDto.getAction())){
            logger.info("##### UPDATE INFORMATION FOR 23930 #####");
            SourceSysProcessBussReqPGDTO srcPgDto = new SourceSysProcessBussReqPGDTO();
            ReqHead reqHead = reqDto.getBody().getReqHead();
            reqHead.setTxnCode("23930");
            srcPgDto.setSrcBk("012");
            srcPgDto.setSrcDate("20210701");
            srcPgDto.setSrcSeq("1234567");
            srcPgDto.setResndInd("0");
            srcPgDto.setReqHead(autoChannelDto.getReqHead());
            if (JudgeUtils.isNull(autoChannelDto.getAllTelMessege())){
                // MT103 / 103+
                if (JudgeUtils.isNotEmpty(autoChannelDto.getMt103())){
                    // call rmc
                    srcPgDto.setFunCat("1");
                    srcPgDto.setSw(autoChannelDto.getMt103());
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDto103 = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    if (JudgeUtils.isNotSuccess(srcRspDto103.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDto103.getMsgCd());
                    }else {
                        updateSrcSysInfo("MT103 / 103+", autoChannelDto.getMt103(),reqHead);
                    }
                }
                // MT202 / 200
                if (JudgeUtils.isNotEmpty(autoChannelDto.getMt202())){
                    // call rmc
                    srcPgDto.setFunCat("2");
                    srcPgDto.setSw(autoChannelDto.getMt202());
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDto202 = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    if (JudgeUtils.isNotSuccess(srcRspDto202.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDto202.getMsgCd());
                    }else {
                        updateSrcSysInfo("MT202 / 200", autoChannelDto.getMt202(),reqHead);
                    }
                }
                // CHATS
                if (JudgeUtils.isNotEmpty(autoChannelDto.getCharts())){
                    // call rmc
                    srcPgDto.setFunCat("C");
                    srcPgDto.setSw(autoChannelDto.getCharts());
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDtoCharts = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    if (JudgeUtils.isNotSuccess(srcRspDtoCharts.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDtoCharts.getMsgCd());
                    }else {
                        updateSrcSysInfo("CHATS", autoChannelDto.getCharts(),reqHead);
                    }
                }
                // OTHER SWIFT TEL
                if (JudgeUtils.isNotEmpty(autoChannelDto.getOtherSwiftTel())){
                    // call rmc
                    srcPgDto.setFunCat("O");
                    srcPgDto.setSw(autoChannelDto.getOtherSwiftTel());
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDtoOther = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    if (JudgeUtils.isNotSuccess(srcRspDtoOther.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDtoOther.getMsgCd());
                    }else {
                        updateSrcSysInfo("OTHER SWIFT TEL", autoChannelDto.getOtherSwiftTel(),reqHead);
                    }
                }
                // XML
                if (JudgeUtils.isNotEmpty(autoChannelDto.getXml())){
                    // call rmc
                    srcPgDto.setFunCat("X");
                    srcPgDto.setSw(autoChannelDto.getXml());
                    //二期需求
//                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDtoXml = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDtoXml = new GenericRspDTO<>();
                    if (JudgeUtils.isNotSuccess(srcRspDtoXml.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDtoXml.getMsgCd());
                    }else {
                        updateSrcSysInfo("XML", autoChannelDto.getXml(),reqHead);
                    }
                }
            }else {
                // AllTelMessege
                if (JudgeUtils.isNotEmpty(autoChannelDto.getAllTelMessege())){
                    // call rmc
                    srcPgDto.setFunCat("A");
                    srcPgDto.setSw(autoChannelDto.getAllTelMessege());
                    GenericRspDTO<SourceSysProcessBussRspDTO> srcRspDtoAll = this.sourceSysProcessBussPG(GenericDTO.newInstance(srcPgDto));
                    if (JudgeUtils.isNotSuccess(srcRspDtoAll.getMsgCd())) {
                        logger.error("call RMC RMCTRX11 error");
                        KontException.throwBusinessException(srcRspDtoAll.getMsgCd());
                    }else {
                        updateSrcSysInfo("MT103 / 103+", autoChannelDto.getAllTelMessege(),reqHead);
                        updateSrcSysInfo("MT202 / 200", autoChannelDto.getAllTelMessege(),reqHead);
                        updateSrcSysInfo("CHATS", autoChannelDto.getAllTelMessege(),reqHead);
                        updateSrcSysInfo("OTHER SWIFT TEL", autoChannelDto.getAllTelMessege(),reqHead);
                        updateSrcSysInfo("XML", autoChannelDto.getAllTelMessege(),reqHead);
                    }
                }
            }

            RspHead rspHead = new RspHead();
            BeanUtils.copyProperties(reqHead,rspHead);
//            PgCommonFormatUtils.GenerateCommonFormat(rspHead,"N","23930");
//            String logPgNumber = IdGenUtils.generateId("logPgNumber",11);
            rspHead.setTxnCode("23930");
            rspHead.setTxnType("N");
//            rspHead.setJournalNo(logPgNumber);

            channelDto.setRspHead(rspHead);
            genericRspDTO.setBody(channelDto);
        }
        //记日志
        commonAssemble.mask23930Log(autoChannelDto,reqDto);
        logger.info("##### END TO 23930 #####");
        return genericRspDTO;
    }

    /**
     * 修改源业务系统开关状态表
     * @param swType
     * @param swStatus
     */
    public void updateSrcSysInfo(String swType, String swStatus, ReqHead reqHead) {
        /** 修改开关状态 */
        PgSrcSwitchDO srcSwDo = new PgSrcSwitchDO();      // 开关状态表 DO
        srcSwDo.setSrcSwType(swType);
        PgSrcSwitchDO updateSrcSwDo = pgSrcSwitchDao.getByKey(srcSwDo);
        String beforeUpdateSts = updateSrcSwDo.getSrcSwStatus();    // 记录操作前的状态，用于记历史
        updateSrcSwDo.setBranchId(reqHead.getBankCode());
        updateSrcSwDo.setOperateTeller(reqHead.getTellerID());
        updateSrcSwDo.setSrcAppl("RPS");
        updateSrcSwDo.setSrcSwStatus(swStatus);
        updateSrcSwDo.setUpdatedLastTime(LocalDateTime.now());
        pgSrcSwitchDao.update(updateSrcSwDo);

        /** 记录操作历史 */
        PgSrcSwLogDO pgSrcSwLogDO = new PgSrcSwLogDO();
        pgSrcSwLogDO.setSwPreStatus(beforeUpdateSts);
        pgSrcSwLogDO.setSrcSwType(updateSrcSwDo.getSrcSwType());
        pgSrcSwLogDO.setBranchId(updateSrcSwDo.getBranchId());
        pgSrcSwLogDO.setOperateTeller(updateSrcSwDo.getOperateTeller());
        pgSrcSwLogDO.setSrcAppl(updateSrcSwDo.getSrcAppl());
        pgSrcSwLogDO.setSwPostStatus(updateSrcSwDo.getSrcSwStatus());
        pgSrcSwLogDO.setCreateTime(updateSrcSwDo.getUpdatedLastTime());
        pgSrcSwLogDO.setUpdatedLastTime(updateSrcSwDo.getUpdatedLastTime());
        pgSrcSwLogDao.insert(pgSrcSwLogDO);
    }
}
