package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.AssembleService;
import com.hisun.kont.pg.service.PgstpswftoteleService;
import com.hisun.kont.pg.utils.AssembleUtils;
import com.hisun.kont.pg.utils.GenF121Utils;
import com.hisun.kont.swf.mt.message.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssembleServiceImpl implements AssembleService {
    private static final Logger log = LoggerFactory.getLogger(AssembleServiceImpl.class);

    @Resource
    private MTAssemblyServiceImpl mtAssemblyServiceImpl;

    @Resource
    private SpecialMTServiceImpl specialMTService;

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    AssembleService assembleService;

    @Resource
    private PgstpswftoteleService pgstpswftoteleService;

    /**
     * 组装MT103报文 发报给RMC
     * @param reqDto
     * @return GenericRspDTO<MtDto>
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT103(GenericDTO<SendRemit103ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt103 fmt103 = reqDto.getBody().getFmt103();
        SendRemit103ReqDTO remit103ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = remit103ReqDTO.getReqHead();
        SwHeader swHeader = fmt103.getSwHeader();
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt103.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt103.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域 业务编号入库
            String trn = fmt103.getF20().getTrn();
            String rtrn = null;
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //判断报文是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt103);
        //中文转电码
        fmt103 = commonAssemble.cnToTeleFor103(fmt103);
        MT103 mt103 = new MT103();
        //调用cor接口 检查收报行是否有swiftkey 并返回收报行名称
        String recBankName = mtAssemblyServiceImpl.checkBicForCor(swHeader, reqHead);
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt103, mt103, "Y",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }


    @Override
    public GenericRspDTO<NoBody> headerInfo(GenericDTO<SwHeader> reqDto) {
        GenericRspDTO<NoBody> rspDto = new GenericRspDTO<>();
        return rspDto;
    }

    /**
     * 组装MT910报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT910(GenericDTO<SendRemit910ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt910 fmt910 = reqDto.getBody().getFmt910();
        SendRemit910ReqDTO sendRemit910ReqDTO= reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit910ReqDTO.getReqHead();
        SwHeader swHeader = fmt910.getSwHeader();
        //对FMT910含有中文转电码
        if (JudgeUtils.isNotNull(fmt910.getSwHeader().getTraditionalFlag())){
            fmt910 = pgstpswftoteleService.getTagCnToTeleFor910(fmt910, fmt910.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt910.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt910.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域 业务编号入库
            String trn = fmt910.getF20().getTrn();
            String rtrn = fmt910.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT910 mt910 = new MT910();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt910, mt910, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT192报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT192(GenericDTO<SendRemit192ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt192 fmt192 = reqDto.getBody().getFmt192();
        SendRemit192ReqDTO sendRemit192ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit192ReqDTO.getReqHead();
        SwHeader swHeader = fmt192.getSwHeader();
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt192.getF79())){
            if (JudgeUtils.isNotNull(fmt192.getSwHeader().getTraditionalFlag())){
                F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt192.getF79(), fmt192.getSwHeader().getTraditionalFlag());
                fmt192.setF79(f79);
            }
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt192.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt192.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域 业务编号入库
            String trn = fmt192.getF20().getTrn();
            String rtrn = fmt192.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT192 mt192 = new MT192();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt192, mt192, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT292报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT292(GenericDTO<SendRemit292ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt292 fmt292 = reqDto.getBody().getFmt292();
        SendRemit292ReqDTO sendRemit292ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit292ReqDTO.getReqHead();
        SwHeader swHeader = fmt292.getSwHeader();
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt292.getF79())){
            if (JudgeUtils.isNotNull(fmt292.getSwHeader().getTraditionalFlag())){
                F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt292.getF79(), fmt292.getSwHeader().getTraditionalFlag());
                fmt292.setF79(f79);
            }
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt292.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt292.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt292.getF20().getTrn();
            String rtrn = fmt292.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT292 mt292 = new MT292();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt292, mt292, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT190报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT190(GenericDTO<SendRemit190ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt190 fmt190 = reqDto.getBody().getFmt190();
        SendRemit190ReqDTO sendRemit190ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit190ReqDTO.getReqHead();
        SwHeader swHeader = fmt190.getSwHeader();
        //对FMT190含有中文转电码
        if (JudgeUtils.isNotNull(fmt190.getSwHeader().getTraditionalFlag())){
            fmt190 = pgstpswftoteleService.getTagCnToTeleFor190(fmt190, fmt190.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt190.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt190.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt190.getF20().getTrn();
            String rtrn = fmt190.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT190 mt190 = new MT190();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt190, mt190, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT202报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT202(GenericDTO<SendRemit202ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //判断这笔202是否为转汇
        if (JudgeUtils.isNotNull(reqDto.getBody().getFmt202().getSwHeader().getBussInfoDTO())){
            BussInfoDTO bussInfoDTO = reqDto.getBody().getFmt202().getSwHeader().getBussInfoDTO();
            if ("1".equals(bussInfoDTO.getTransType())){
                //转汇
                GenericRspDTO<MtDto> rspDTO = specialMTService.transMT202COV(reqDto,"Y");
                return rspDTO;
            }
        }
        Fmt202 fmt202 = reqDto.getBody().getFmt202();
        SendRemit202ReqDTO sendRemit202ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit202ReqDTO.getReqHead();
        SwHeader swHeader = fmt202.getSwHeader();
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt202.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt202.getF20().getTrn();
            String rtrn = fmt202.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //判断报文是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt202);
        //中文转电码
        fmt202 = commonAssemble.cnToTeleFor202(fmt202);
        MT202 mt202 = new MT202();
        //调用cor接口 检查bankCode是否有swiftkey
        String recBankName = mtAssemblyServiceImpl.checkBicForCor(swHeader,reqHead);
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt202, mt202, "Y",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT200报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT200(GenericDTO<SendRemit200ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt200 fmt200 = reqDto.getBody().getFmt200();
        SendRemit200ReqDTO sendRemit200ReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        ReqHead reqHead = sendRemit200ReqDTO.getReqHead();
        SwHeader swHeader = fmt200.getSwHeader();
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt200.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt200.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt200.getF20().getTrn();
            String rtrn = null;
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //判断报文是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt200);
        //中文转电码
        fmt200 = commonAssemble.cnToTeleFor200(fmt200);
        MT200 mt200 = new MT200();
        //调用cor接口 检查bankCode是否有swiftkey
        String recBankName = mtAssemblyServiceImpl.checkBicForCor(swHeader,reqHead);
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt200, mt200, "Y",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT191报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT191(GenericDTO<SendRemit191ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt191 fmt191 = reqDto.getBody().getFmt191();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit191ReqDTO sendRemit191ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit191ReqDTO.getFmt191().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对FMT191含有中文转电码
        if (JudgeUtils.isNotNull(fmt191.getSwHeader().getTraditionalFlag())){
            fmt191 = pgstpswftoteleService.getTagCnToTeleFor191(fmt191, fmt191.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt191.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt191.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt191.getF20().getTrn();
            String rtrn = fmt191.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //兼容应用去掉AC栏位的斜杠
        fmt191 = pgstpswftoteleService.removeAcFor191(fmt191);
        MT191 mt191 = new MT191();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt191, mt191, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT290报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT290(GenericDTO<SendRemit290ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt290 fmt290 = reqDto.getBody().getFmt290();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit290ReqDTO sendRemit290ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit290ReqDTO.getFmt290().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对fmt290含有中文转电码
        if (JudgeUtils.isNotNull(fmt290.getSwHeader().getTraditionalFlag())){
            fmt290 = pgstpswftoteleService.getTagCnToTeleFor290(fmt290, fmt290.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt290.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt290.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt290.getF20().getTrn();
            String rtrn = fmt290.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT290 mt290 = new MT290();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt290, mt290, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;

    }

    /**
     * 组装MT291报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT291(GenericDTO<SendRemit291ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt291 fmt291 = reqDto.getBody().getFmt291();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit291ReqDTO sendRemit291ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit291ReqDTO.getFmt291().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对FMT291含有中文转电码
        if (JudgeUtils.isNotNull(fmt291.getSwHeader().getTraditionalFlag())){
            fmt291 = pgstpswftoteleService.getTagCnToTeleFor291(fmt291, fmt291.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt291.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt291.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt291.getF20().getTrn();
            String rtrn = fmt291.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //兼容应用去掉AC栏位的斜杠
        fmt291 = pgstpswftoteleService.removeAcFor291(fmt291);
        MT291 mt291 = new MT291();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt291, mt291, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT196报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT196(GenericDTO<SendRemit196ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt196 fmt196 = reqDto.getBody().getFmt196();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit196ReqDTO sendRemit196ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit196ReqDTO.getFmt196().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对FMT196含有中文转电码
        if (JudgeUtils.isNotNull(fmt196.getSwHeader().getTraditionalFlag())){
            fmt196 = pgstpswftoteleService.getTagCnToTeleFor196(fmt196, fmt196.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt196.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt196.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt196.getF20().getTrn();
            String rtrn = fmt196.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT196 mt196 = new MT196();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt196, mt196, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT950报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT950(GenericDTO<SendRemit950ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt950 fmt950 = reqDto.getBody().getFmt950();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit950ReqDTO sendRemit950ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit950ReqDTO.getFmt950().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt950.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt950.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt950.getF20().getTrn();
            String rtrn = null;
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT950 mt950 = new MT950();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt950, mt950, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT199报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT199(GenericDTO<SendRemit199ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        PgstsDO pgstsDO = new PgstsDO();
        Fmt199 fmt199 = reqDto.getBody().getFmt199();
        SendRemit199ReqDTO sendRemit199ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit199ReqDTO.getFmt199().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt199.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt199.getF79(), fmt199.getSwHeader().getTraditionalFlag());
            fmt199.setF79(f79);
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt199.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt199.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt199.getF20().getTrn();
            String rtrn = null;
            if(JudgeUtils.isNotNull(fmt199.getF21())){
                rtrn = fmt199.getF21().getRtrn();
            }
            //判断199是否为gpi报文
            if (JudgeUtils.isNotNull(fmt199.getSwHeader().getUserHeaderDO())) {
                if (JudgeUtils.isNotNull(fmt199.getSwHeader().getUserHeaderDO().getOhGpcFlg())) {
                    if ("001".equals(fmt199.getSwHeader().getUserHeaderDO().getOhGpcFlg()) ||
                            "002".equals(fmt199.getSwHeader().getUserHeaderDO().getOhGpcFlg())) {
                        pgstsDO = specialMTService.mappingForGpi199(pgstsDO, fmt199);
                    }
                }
            }
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT199 mt199 = new MT199();
        String recBankName = null;
        //报文组装返回参数(包括检查)
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt199, mt199, "Y", reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT299报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT299(GenericDTO<SendRemit299ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt299 fmt299 = reqDto.getBody().getFmt299();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit299ReqDTO sendRemit299ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit299ReqDTO.getFmt299().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt299.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt299.getF79(), fmt299.getSwHeader().getTraditionalFlag());
            fmt299.setF79(f79);
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt299.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt299.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt299.getF20().getTrn();
            String rtrn = null;
            if(JudgeUtils.isNotNull(fmt299.getF21())){
                rtrn = fmt299.getF21().getRtrn();
            }
            //判断299是否为gpi报文
            if (JudgeUtils.isNotNull(fmt299.getSwHeader().getUserHeaderDO())) {
                if (JudgeUtils.isNotNull(fmt299.getSwHeader().getUserHeaderDO().getOhGpcFlg())) {
                    if ("001".equals(fmt299.getSwHeader().getUserHeaderDO().getOhGpcFlg()) ||
                            "002".equals(fmt299.getSwHeader().getUserHeaderDO().getOhGpcFlg())) {
                        pgstsDO = specialMTService.mappingForGpi299(pgstsDO, fmt299);
                    }
                }
            }
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT299 mt299 = new MT299();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt299, mt299, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT296报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT296(GenericDTO<SendRemit296ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt296 fmt296 = reqDto.getBody().getFmt296();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit296ReqDTO sendRemit296ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit296ReqDTO.getFmt296().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对FMT296含有中文转电码
        if (JudgeUtils.isNotNull(fmt296.getSwHeader().getTraditionalFlag())){
            fmt296 = pgstpswftoteleService.getTagCnToTeleFor296(fmt296, fmt296.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt296.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt296.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt296.getF20().getTrn();
            String rtrn = fmt296.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT296 mt296 = new MT296();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt296, mt296, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT999报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT999(GenericDTO<SendRemit999ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt999 fmt999 = reqDto.getBody().getFmt999();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit999ReqDTO sendRemit999ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit999ReqDTO.getFmt999().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt999.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt999.getF79(), fmt999.getSwHeader().getTraditionalFlag());
            fmt999.setF79(f79);
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt999.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt999.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt999.getF20().getTrn();
            String rtrn = null;
            if(JudgeUtils.isNotNull(fmt999.getF21())){
                rtrn = fmt999.getF21().getRtrn();
            }
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT999 mt999 = new MT999();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt999, mt999, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT900报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT900(GenericDTO<SendRemit900ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt900 fmt900 = reqDto.getBody().getFmt900();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit900ReqDTO sendRemit900ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit900ReqDTO.getFmt900().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //对FMT900含有中文转电码
        if (JudgeUtils.isNotNull(fmt900.getSwHeader().getTraditionalFlag())){
            fmt900 = pgstpswftoteleService.getTagCnToTeleFor900(fmt900, fmt900.getSwHeader().getTraditionalFlag());
        }
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt900.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt900.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt900.getF20().getTrn();
            String rtrn = fmt900.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MT900 mt900 = new MT900();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt900, mt900, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装MT202COV报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDtos> assembleMT202COV(GenericDTO<SendRemit202COVReqDTO> reqDto) {
        GenericRspDTO<MtDtos> rspDto = new GenericRspDTO<>();
        MT202Cov mt202Cov = new MT202Cov();
        PgstsDO pgstsDO103 = new PgstsDO();
        PgstsDO pgstsDO202 = new PgstsDO();
        SendRemit202ReqDTO sendRemit202ReqDTO = reqDto.getBody().getSendRemit202ReqDTO();
        SendRemit103ReqDTO sendRemit103ReqDTO = reqDto.getBody().getSendRemit103ReqDTO();
        Fmt103 fmt103 = sendRemit103ReqDTO.getFmt103();
        Fmt202 fmt202 = sendRemit202ReqDTO.getFmt202();
        SwHeader swHeader103 = fmt103.getSwHeader();
        SwHeader swHeader202 = fmt202.getSwHeader();
        ReqHead reqHead202 = sendRemit202ReqDTO.getReqHead();
        ReqHead reqHead103 = sendRemit103ReqDTO.getReqHead();
        GenericRspDTO<MtDto> rspDTOMt103 = new GenericRspDTO<>();
        GenericRspDTO<MtDto> rspDTOMt202 = new GenericRspDTO<>();
        //组装返回信息
        MtDtoBlock mtDtoBlock103 = new MtDtoBlock();
        MtDtoBlock mtDtoBlock202 = new MtDtoBlock();
        List<MtDtoBlock> mtDtoBlockList = new ArrayList<>();
        MtDtos mtDtos = new MtDtos();
        //判断是否已重发标志
        Boolean reFlag103 = false;
        Boolean reFlag202 = false;
        //判断MT103是否已重发 若无 先存报文资料
        if (JudgeUtils.isNotNull(fmt103.getSwHeader().getMsgNo())){
            rspDTOMt103 = commonAssemble.repeatKeyCheck(fmt103.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDTOMt103.getBody())){
                MtDto mt103Dto = rspDTOMt103.getBody();
                BeanUtils.copyProperties(mt103Dto, mtDtoBlock103);
                mtDtoBlockList.add(mtDtoBlock103);
                reFlag103 = true;
            }else {
                //20域 21域 业务编号入库
                String trn = fmt103.getF20().getTrn();
                String rtrn = null;
                commonAssemble.savePreMessage(trn,rtrn,pgstsDO103,swHeader103,reqHead103,reqDto);
            }
        }
        //判断MT202是否已重发 若无 先存报文资料
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getMsgNo())){
            rspDTOMt202 = commonAssemble.repeatKeyCheck(fmt202.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDTOMt202.getBody())){
                MtDto mt202Dto = rspDTOMt202.getBody();
                BeanUtils.copyProperties(mt202Dto, mtDtoBlock202);
                mtDtoBlockList.add(mtDtoBlock202);
                reFlag202 = true;
            }else {
                //20域 21域 业务编号入库
                String trn = fmt202.getF20().getTrn();
                String rtrn = fmt202.getF21().getRtrn();
                commonAssemble.savePreMessage(trn,rtrn,pgstsDO202,swHeader202,reqHead202,reqDto);
            }
        }
        //处理已重发或无重发过程
        if (!reFlag103 && !reFlag202 ){
            //两笔都未重发过
            //判断fmt对象是否含有中文 并将中文转电码
            String cnFlag103 = AssembleUtils.getCnFlag(fmt103);
            fmt103 = commonAssemble.cnToTeleFor103(fmt103);
            String cnFlag202 = AssembleUtils.getCnFlag(fmt202);
            fmt202 = commonAssemble.cnToTeleFor202(fmt202);
            //调用cor接口 检查bankCode是否有swiftkey
            String recBankName103 = mtAssemblyServiceImpl.checkBicForCor(swHeader103,reqHead103);
            String recBankName202 = mtAssemblyServiceImpl.checkBicForCor(swHeader202,reqHead202);
            //手动映射202COV
            mt202Cov = specialMTService.mappingForMt202COV(mt202Cov, fmt202, fmt103);
            //将MT103的121赋值给MT202
            if (JudgeUtils.isNull(swHeader103.getUserHeaderDO())) {
                UserHeaderDO userHeaderDO = new UserHeaderDO();
                userHeaderDO.setOhGpiRef(GenF121Utils.GenF121Id());
                swHeader103.setUserHeaderDO(userHeaderDO);
                fmt103.setSwHeader(swHeader103);
                fmt202.getSwHeader().getUserHeaderDO().setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
                pgstsDO103.setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
                pgstsDO202.setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
            } else if (JudgeUtils.isNull(swHeader103.getUserHeaderDO().getOhGpiRef())){
                fmt103.getSwHeader().getUserHeaderDO().setOhGpiRef(GenF121Utils.GenF121Id());
                fmt202.getSwHeader().getUserHeaderDO().setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
                pgstsDO103.setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
                pgstsDO202.setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
            }
            //103报文组装
            MT103 mt103 = new MT103();
            MtDto mto103 = commonAssemble.comAssembleMessage(fmt103, mt103, "Y",reqHead103,recBankName103);
            mto103.setCnFlag(cnFlag103);
            //报文数据入库
            commonAssemble.updateMessageForPgsts(pgstsDO103,mto103);
            //202报文组装
            MtDto mto202 = commonAssemble.comAssembleMessage(fmt202, mt202Cov, "Y",reqHead202,recBankName202);
            mto202.setCnFlag(cnFlag202);
            log.info("mt202Cov_checkAll():" + mt202Cov.checkAll());
            //报文数据入库
            commonAssemble.updateMessageForPgsts(pgstsDO202,mto202);
            //组装返回信息
            BeanUtils.copyProperties(mto103, mtDtoBlock103);
            BeanUtils.copyProperties(mto202, mtDtoBlock202);
            mtDtoBlockList.add(mtDtoBlock103);
            mtDtoBlockList.add(mtDtoBlock202);
            mtDtos.setMtDtoBlockList(mtDtoBlockList);
            rspDto.setBody(mtDtos);
            //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出  先发202COV
            if ("Y".equals(swHeader202.getMtTemporary())){
                rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
            }else{
                String returnCode = commonAssemble.comSendMessage(sendRemit202ReqDTO.getRmcTrx01(),reqHead202,sendRemit202ReqDTO.getEaiHeaderDTO(),mto202,pgstsDO202);
                if (JudgeUtils.isNotSuccess(returnCode)){
                    KontException.throwBusinessException(returnCode,"SEND MESSAGE FAIL");
                }else {
                    GenericDTO<SendRemit202ReqDTO> genericDTO202 = new GenericDTO<>();
                    genericDTO202.setBody(reqDto.getBody().getSendRemit202ReqDTO());
                    commonAssemble.maskLog(pgstsDO202,genericDTO202);
                }
            }
            //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出  再发普通103
            if ("Y".equals(swHeader103.getMtTemporary())){
                rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
            }else{
                String returnCode = commonAssemble.comSendMessage(sendRemit103ReqDTO.getRmcTrx01(),reqHead103,sendRemit103ReqDTO.getEaiHeaderDTO(),mto103,pgstsDO103);
                if (JudgeUtils.isNotSuccess(returnCode)){
                    KontException.throwBusinessException(returnCode,"SEND MESSAGE FAIL");
                }else {
                    GenericDTO<SendRemit103ReqDTO> genericDTO103 = new GenericDTO<>();
                    genericDTO103.setBody(reqDto.getBody().getSendRemit103ReqDTO());
                    commonAssemble.maskLog(pgstsDO103,genericDTO103);
                }
                rspDto.setMsgCd(returnCode);
            }
        }else if (reFlag103 && !reFlag202){
            //说明103已重发 202未重发
            String cnFlag202 = AssembleUtils.getCnFlag(fmt202);
            fmt202 = commonAssemble.cnToTeleFor202(fmt202);
            String recBankName202 = mtAssemblyServiceImpl.checkBicForCor(swHeader202,reqHead202);
            //手动映射202COV
            mt202Cov = specialMTService.mappingForMt202COV(mt202Cov, fmt202, fmt103);
            MtDto mto202 = commonAssemble.comAssembleMessage(fmt202, mt202Cov, "Y",reqHead202,recBankName202);
            mto202.setCnFlag(cnFlag202);
            log.info("mt202Cov_checkAll():" + mt202Cov.checkAll());
            //报文数据入库
            commonAssemble.updateMessageForPgsts(pgstsDO202,mto202);
            //组装返回信息
            BeanUtils.copyProperties(mto202, mtDtoBlock202);
            mtDtoBlockList.add(mtDtoBlock202);
            mtDtos.setMtDtoBlockList(mtDtoBlockList);
            rspDto.setBody(mtDtos);
            //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出  先发202COV
            if ("Y".equals(swHeader202.getMtTemporary())){
                rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
            }else{
                String returnCode = commonAssemble.comSendMessage(sendRemit202ReqDTO.getRmcTrx01(),reqHead202,sendRemit202ReqDTO.getEaiHeaderDTO(),mto202,pgstsDO202);
                if (JudgeUtils.isNotSuccess(returnCode)){
                    KontException.throwBusinessException(returnCode,"SEND MESSAGE FAIL");
                }
            }
            //记日志
            if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
                GenericDTO<SendRemit202ReqDTO> genericDTO202 = new GenericDTO<>();
                genericDTO202.setBody(reqDto.getBody().getSendRemit202ReqDTO());
                commonAssemble.maskLog(pgstsDO202,genericDTO202);
            }
        }else if (!reFlag103 && reFlag202){
            //说明202已重发 103未重发
            String cnFlag103 = AssembleUtils.getCnFlag(fmt103);
            fmt103 = commonAssemble.cnToTeleFor103(fmt103);
            String recBankName103 = mtAssemblyServiceImpl.checkBicForCor(swHeader103,reqHead103);
            //103报文组装
            MT103 mt103 = new MT103();
            MtDto mto103 = commonAssemble.comAssembleMessage(fmt103, mt103, "Y",reqHead103,recBankName103);
            mto103.setCnFlag(cnFlag103);
            //报文数据入库
            commonAssemble.updateMessageForPgsts(pgstsDO103,mto103);
            //组装返回信息
            BeanUtils.copyProperties(mto103, mtDtoBlock103);
            mtDtoBlockList.add(mtDtoBlock103);
            mtDtos.setMtDtoBlockList(mtDtoBlockList);
            rspDto.setBody(mtDtos);
            //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出  再发普通103
            if ("Y".equals(swHeader103.getMtTemporary())){
                rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
            }else{
                String returnCode = commonAssemble.comSendMessage(sendRemit103ReqDTO.getRmcTrx01(),reqHead103,sendRemit103ReqDTO.getEaiHeaderDTO(),mto103,pgstsDO103);
                if (JudgeUtils.isNotSuccess(returnCode)){
                    KontException.throwBusinessException(returnCode,"SEND MESSAGE FAIL");
                }
                rspDto.setMsgCd(returnCode);
            }
            //记103日志
            if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
                GenericDTO<SendRemit103ReqDTO> genericDTO103 = new GenericDTO<>();
                genericDTO103.setBody(reqDto.getBody().getSendRemit103ReqDTO());
                commonAssemble.maskLog(pgstsDO103,genericDTO103);
            }
        }else {
            //两笔都已重发
            mtDtos.setMtDtoBlockList(mtDtoBlockList);
            rspDto.setBody(mtDtos);
        }
        return rspDto;
    }

    /**
     * 组装MT210报文 发报给RMC
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleMT210(GenericDTO<SendRemit210ReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        Fmt210 fmt210 = reqDto.getBody().getFmt210();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit210ReqDTO sendRemit210ReqDTO = reqDto.getBody();
        SwHeader swHeader = sendRemit210ReqDTO.getFmt210().getSwHeader();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt210.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt210.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt210.getF20().getTrn();
            String rtrn = null;
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        //是否需要中文转电码
        if (JudgeUtils.isNotNull(fmt210.getSwHeader().getTraditionalFlag())){
            fmt210 = pgstpswftoteleService.getTagCnToTeleFor210(fmt210, fmt210.getSwHeader().getTraditionalFlag());
        }
        MT210 mt210 = new MT210();
        String recBankName = null;
        //手动映射210报文为list的集合
        mt210 = specialMTService.mappingForMT210(mt210, fmt210);
        //组装返参
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt210, mt210, "Y",reqHead,recBankName);
        mtDto.setCnFlag("N");
        rspDto.setBody(mtDto);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,reqDto.getBody().getEaiHeaderDTO(),mtDto,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

    /**
     * 组装202COV+202报文  发送给RMC
     * 先发202COV  在发普通202
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDtos> assemblDoubleMT202(GenericDTO<AssemblDoubleMT202ReqDTO> reqDto) {
        AssemblDoubleMT202ReqDTO body = reqDto.getBody();
        List<SendRemit202ReqDTO> sendRemit202ReqDTOList = body.getSendRemit202ReqDTOList();
        //返参
        GenericRspDTO<MtDtos> rspDTO = new GenericRspDTO<>();
        MtDtos mtDtos = new MtDtos();
        List<MtDtoBlock> mtDtoBlockList = new ArrayList<>();
        MtDtoBlock mtDto202CovBlock = new MtDtoBlock();
        MtDtoBlock mtDto202Block = new MtDtoBlock();

        //发202转汇COV
        GenericDTO<SendRemit202ReqDTO> send202CovReqDTO = new GenericDTO<>();
        SendRemit202ReqDTO send202Cov = sendRemit202ReqDTOList.get(0);
        send202CovReqDTO.setAppExtHeader(reqDto.getAppExtHeader());
        send202CovReqDTO.setBody(send202Cov);
        GenericRspDTO<MtDto> rsp202Cov = assembleService.assembleMT202(send202CovReqDTO);
        MtDto mtDto202Cov = rsp202Cov.getBody();
        BeanUtils.copyProperties(mtDto202Cov,mtDto202CovBlock);
        mtDtoBlockList.add(mtDto202CovBlock);
        //发普通202
        GenericDTO<SendRemit202ReqDTO> send202ReqDTO = new GenericDTO<>();
        SendRemit202ReqDTO send202 = sendRemit202ReqDTOList.get(1);
        send202ReqDTO.setAppExtHeader(reqDto.getAppExtHeader());
        send202ReqDTO.setBody(send202);
        GenericRspDTO<MtDto> rsp202 = assembleService.assembleMT202(send202ReqDTO);
        MtDto mtDto202 = rsp202.getBody();
        BeanUtils.copyProperties(mtDto202,mtDto202Block);
        mtDtoBlockList.add(mtDto202Block);

        mtDtos.setMtDtoBlockList(mtDtoBlockList);
        rspDTO.setBody(mtDtos);
        return rspDTO;
    }

    /**
     * 组装单电202COV
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleSingle202COV(GenericDTO<AssembleSingle202COVReqDTO> reqDto) {
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        AssembleSingle202COVReqDTO assembleSingle202COVReqDTO = reqDto.getBody();
        //MT202COV的202部分
        Fmt202 fmt202 = assembleSingle202COVReqDTO.getFmt202();
        //MT202COV的seqB部分
        SequenceB sequencDOs = assembleSingle202COVReqDTO.getSequencDOs();
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        //将seqB映射成fmt103
        Fmt103 fmt103 = new Fmt103();
        BeanUtils.copyProperties(sequencDOs,fmt103);
        //判断报文是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt202);
        //中文转电码
        fmt103 = commonAssemble.cnToTeleForSeqB(fmt103,fmt202);
        fmt202 = commonAssemble.cnToTeleFor202(fmt202);
        ReqHead reqHead = assembleSingle202COVReqDTO.getReqHead();
        SwHeader swHeader = assembleSingle202COVReqDTO.getFmt202().getSwHeader();
        String recBankName202 = null;
        //手动映射202COV
        MT202Cov mt202Cov = new MT202Cov();
        mt202Cov = specialMTService.mappingForMt202COV(mt202Cov, fmt202, fmt103);
        PgstsDO pgstsDO = new PgstsDO();

        //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getMsgNo())){
            rspDto = commonAssemble.repeatKeyCheck(fmt202.getSwHeader().getMsgNo());
            if (JudgeUtils.isNotNull(rspDto.getBody())){
                return rspDto;
            }
            //20域 21域
            String trn = fmt202.getF20().getTrn();
            String rtrn = fmt202.getF21().getRtrn();
            commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
        }
        MtDto mtDto202 = commonAssemble.comAssembleMessage(fmt202, mt202Cov, "N",reqHead,recBankName202);
        mtDto202.setCnFlag(cnFlag);
        rspDto.setBody(mtDto202);
        //报文数据入库
        commonAssemble.updateMessageForPgsts(pgstsDO,mtDto202);
        //外发报文到rmc  根据返回状态更新pgsts表  Y为暂存  其他情况为发出
        if ("Y".equals(swHeader.getMtTemporary())){
            rspDto.setMsgCd(MTConstants.TEMPORARY_MESSAGE_IS_SUCCESS);
        }else{
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(),reqHead,eaiHeaderDTO,mtDto202,pgstsDO);
            rspDto.setMsgCd(returnCode);
        }
        //记日志
        if (JudgeUtils.isSuccess(rspDto.getMsgCd())){
            commonAssemble.maskLog(pgstsDO,reqDto);
        }
        return rspDto;
    }

}