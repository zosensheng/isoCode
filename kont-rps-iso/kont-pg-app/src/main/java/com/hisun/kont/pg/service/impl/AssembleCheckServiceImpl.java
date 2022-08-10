package com.hisun.kont.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.AssembleCheckService;
import com.hisun.kont.pg.service.PgstpswftoteleService;
import com.hisun.kont.pg.utils.*;
import com.hisun.kont.pyrm.client.RpsDtServiceClient;
import com.hisun.kont.pyrm.py.remote.GetMessageNumRspDTO;
import com.hisun.kont.pyrm.py.remote.GetNowWorkDayReqDTO;
import com.hisun.kont.pyrm.py.remote.GetNowWorkDayRspDTO;
import com.hisun.kont.swf.mt.message.*;
import com.hisun.kont.swf.mt.message.header.AppHeaderReciverBlock;
import com.hisun.kont.swf.mt.message.header.AppHeaderSenderBlock;
import com.hisun.kont.swf.mt.message.subItem.BlockMt;
import com.hisun.kont.swf.mt.tag.*;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AssembleCheckServiceImpl implements AssembleCheckService {

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    private SpecialMTServiceImpl specialMTService;

    @Resource
    private PgstpswftoteleService pgstpswftoteleService;

    private static final Logger logger = LoggerFactory.getLogger(AssembleCheckServiceImpl.class);
    @Override
    public GenericRspDTO<MtDto> assembleCheckMT103(GenericDTO<Fmt103> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT103","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt103 fmt103Obj = reqDto.getBody();
        String fmt103Json = JSONObject.toJSON(fmt103Obj).toString();
        Fmt103 fmt103 = JSONObject.parseObject(fmt103Json, Fmt103.class);
        //判断fmt对象是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt103);
        //中文转电码
        fmt103 = commonAssemble.cnToTeleFor103(fmt103);
        MT103 mt103 = new MT103();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt103, mt103, "N",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT103","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT202(GenericDTO<Fmt202> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT202","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt202 fmt202Obj = reqDto.getBody();
        String fmt202Json = JSONObject.toJSON(fmt202Obj).toString();
        Fmt202 fmt202 = JSONObject.parseObject(fmt202Json, Fmt202.class);
        //转汇 检查打包
        if (JudgeUtils.isNotNull(fmt202.getSwHeader().getBussInfoDTO())){
            BussInfoDTO bussInfoDTO = fmt202.getSwHeader().getBussInfoDTO();
            if ("1".equals(bussInfoDTO.getTransType())){
                GenericDTO<SendRemit202ReqDTO> genericDTO = new GenericDTO<>();
                SendRemit202ReqDTO sendRemit202ReqDTO = new SendRemit202ReqDTO();
                ReqHead reqHead = new ReqHead();
                sendRemit202ReqDTO.setFmt202(fmt202);
                sendRemit202ReqDTO.setReqHead(reqHead);
                genericDTO.setBody(sendRemit202ReqDTO);
                GenericRspDTO<MtDto> rspDTO = specialMTService.transMT202COV(genericDTO,"N");
                return rspDTO;
            }
        }
        //判断fmt对象是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt202);
        fmt202 = commonAssemble.cnToTeleFor202(fmt202);
        MT202 mt202 = new MT202();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt202, mt202, "N",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT202","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT200(GenericDTO<Fmt200> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT200","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt200 fmt200Obj = reqDto.getBody();
        String fmt200Json = JSONObject.toJSON(fmt200Obj).toString();
        Fmt200 fmt200 = JSONObject.parseObject(fmt200Json, Fmt200.class);
        //判断fmt对象是否含有中文
        String cnFlag = AssembleUtils.getCnFlag(fmt200);
        //简繁体标识
        fmt200 = commonAssemble.cnToTeleFor200(fmt200);
        MT200 mt200 = new MT200();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt200, mt200, "N",reqHead,recBankName);
        mtDto.setCnFlag(cnFlag);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT200","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDtos> assembleCheckMT202Cov(GenericDTO<Fmt202Cov> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT202COV","---start---");
        //隔离对象 防止原FMT中文被修改成电码
        Fmt103 fmt103Obj = reqDto.getBody().getFmt103();
        String fmt103Json = JSONObject.toJSON(fmt103Obj).toString();
        Fmt103 fmt103 = JSONObject.parseObject(fmt103Json, Fmt103.class);
        //判断fmt对象是否含有中文
        String cnFlag103 = AssembleUtils.getCnFlag(fmt103);
        //中文转电码
        fmt103 = commonAssemble.cnToTeleFor103(fmt103);
        //隔离对象 防止原FMT中文被修改成电码
        Fmt202 fmt202Obj = reqDto.getBody().getFmt202();
        String fmt202Json = JSONObject.toJSON(fmt202Obj).toString();
        Fmt202 fmt202 = JSONObject.parseObject(fmt202Json, Fmt202.class);
        //判断fmt对象是否含有中文
        String cnFlag202 = AssembleUtils.getCnFlag(fmt202);
        fmt202 = commonAssemble.cnToTeleFor202(fmt202);
        String ohGpiRef = fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef();
        //判断121域里面的值是否有值
        if (JudgeUtils.isNull(ohGpiRef)) {
            fmt103.getSwHeader().getUserHeaderDO().setOhGpiRef(GenF121Utils.GenF121Id());
        } else {
            fmt103.getSwHeader().getUserHeaderDO().setOhGpiRef(ohGpiRef);
        }
        fmt202.getSwHeader().getUserHeaderDO().setOhGpiRef(fmt103.getSwHeader().getUserHeaderDO().getOhGpiRef());
        MT103 mt103 = new MT103();
        ReqHead reqHead = new ReqHead();
        String recBankName103 = null;
        String recBankName202 = null;
        //手动映射202COV
        MT202Cov mt202Cov = new MT202Cov();
        mt202Cov = specialMTService.mappingForMt202COV(mt202Cov, fmt202, fmt103);
        MtDto mtDto103 = commonAssemble.comAssembleMessage(fmt103, mt103, "N",reqHead,recBankName103);
        MtDto mtDto202 = commonAssemble.comAssembleMessage(fmt202, mt202Cov, "N",reqHead,recBankName202);
        mtDto103.setCnFlag(cnFlag103);
        mtDto202.setCnFlag(cnFlag202);
        //组装返回信息
        GenericRspDTO<MtDtos> rspDTO = new GenericRspDTO<>();
        MtDtoBlock mtDtoBlock103 = new MtDtoBlock();
        MtDtoBlock mtDtoBlock202 = new MtDtoBlock();
        List<MtDtoBlock> mtDtoBlockList = new ArrayList<>();
        MtDtos mtDtos = new MtDtos();
        BeanUtils.copyProperties(mtDto103, mtDtoBlock103);
        BeanUtils.copyProperties(mtDto202, mtDtoBlock202);
        mtDtoBlockList.add(mtDtoBlock103);
        mtDtoBlockList.add(mtDtoBlock202);
        mtDtos.setMtDtoBlockList(mtDtoBlockList);
        rspDTO.setBody(mtDtos);
        logger.info("###{}###{}","Assemble Check MT202COV","---end---");
        return rspDTO;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT196(GenericDTO<Fmt196> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT196","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt196 fmt196Obj = reqDto.getBody();
        String fmt196Json = JSONObject.toJSON(fmt196Obj).toString();
        Fmt196 fmt196 = JSONObject.parseObject(fmt196Json, Fmt196.class);
        MT196 mt196 = new MT196();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT196含有中文转电码
        if (JudgeUtils.isNotNull(fmt196.getSwHeader().getTraditionalFlag())){
            fmt196 = pgstpswftoteleService.getTagCnToTeleFor196(fmt196, fmt196.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt196, mt196, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT196","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT199(GenericDTO<Fmt199> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT199","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt199 fmt199Obj = reqDto.getBody();
        String fmt199Json = JSONObject.toJSON(fmt199Obj).toString();
        Fmt199 fmt199 = JSONObject.parseObject(fmt199Json, Fmt199.class);
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt199.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt199.getF79(), fmt199.getSwHeader().getTraditionalFlag());
            fmt199.setF79(f79);
        }
        MT199 mt199 = new MT199();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt199, mt199, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT199","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT296(GenericDTO<Fmt296> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT296","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt296 fmt296Obj = reqDto.getBody();
        String fmt296Json = JSONObject.toJSON(fmt296Obj).toString();
        Fmt296 fmt296 = JSONObject.parseObject(fmt296Json, Fmt296.class);
        MT296 mt296 = new MT296();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT296含有中文转电码
        if (JudgeUtils.isNotNull(fmt296.getSwHeader().getTraditionalFlag())){
            fmt296 = pgstpswftoteleService.getTagCnToTeleFor296(fmt296, fmt296.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt296, mt296, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT296","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT299(GenericDTO<Fmt299> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT299","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt299 fmt299Obj = reqDto.getBody();
        String fmt299Json = JSONObject.toJSON(fmt299Obj).toString();
        Fmt299 fmt299 = JSONObject.parseObject(fmt299Json, Fmt299.class);
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt299.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt299.getF79(), fmt299.getSwHeader().getTraditionalFlag());
            fmt299.setF79(f79);
        }
        MT299 mt299 = new MT299();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt299, mt299, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT299","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT999(GenericDTO<Fmt999> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT999","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt999 fmt999Obj = reqDto.getBody();
        String fmt999Json = JSONObject.toJSON(fmt999Obj).toString();
        Fmt999 fmt999 = JSONObject.parseObject(fmt999Json, Fmt999.class);
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt999.getSwHeader().getTraditionalFlag())){
            F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt999.getF79(), fmt999.getSwHeader().getTraditionalFlag());
            fmt999.setF79(f79);
        }
        MT999 mt999 = new MT999();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt999, mt999, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT999","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT910(GenericDTO<Fmt910> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT910","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt910 fmt910Obj = reqDto.getBody();
        String fmt910Json = JSONObject.toJSON(fmt910Obj).toString();
        Fmt910 fmt910 = JSONObject.parseObject(fmt910Json, Fmt910.class);
        MT910 mt910 = new MT910();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT910含有中文转电码
        if (JudgeUtils.isNotNull(fmt910.getSwHeader().getTraditionalFlag())){
            fmt910 = pgstpswftoteleService.getTagCnToTeleFor910(fmt910, fmt910.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt910, mt910, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT910","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT192(GenericDTO<Fmt192> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT192","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt192 fmt192Obj = reqDto.getBody();
        String fmt192Json = JSONObject.toJSON(fmt192Obj).toString();
        Fmt192 fmt192 = JSONObject.parseObject(fmt192Json, Fmt192.class);
        MT192 mt192 = new MT192();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt192.getF79())){
            if (JudgeUtils.isNotNull(fmt192.getSwHeader().getTraditionalFlag())){
                F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt192.getF79(), fmt192.getSwHeader().getTraditionalFlag());
                fmt192.setF79(f79);
            }
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt192, mt192, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT192","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT292(GenericDTO<Fmt292> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT292","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt292 fmt292Obj = reqDto.getBody();
        String fmt292Json = JSONObject.toJSON(fmt292Obj).toString();
        Fmt292 fmt292 = JSONObject.parseObject(fmt292Json, Fmt292.class);
        MT292 mt292 = new MT292();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //F79中文转电码
        if (JudgeUtils.isNotNull(fmt292.getF79())){
            if (JudgeUtils.isNotNull(fmt292.getSwHeader().getTraditionalFlag())){
                F79 f79 = pgstpswftoteleService.cnToTeleForN99(fmt292.getF79(), fmt292.getSwHeader().getTraditionalFlag());
                fmt292.setF79(f79);
            }
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt292, mt292, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT292","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT190(GenericDTO<Fmt190> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT190","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt190 fmt190Obj = reqDto.getBody();
        String fmt190Json = JSONObject.toJSON(fmt190Obj).toString();
        Fmt190 fmt190 = JSONObject.parseObject(fmt190Json, Fmt190.class);
        MT190 mt190 = new MT190();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT190含有中文转电码
        if (JudgeUtils.isNotNull(fmt190.getSwHeader().getTraditionalFlag())){
            fmt190 = pgstpswftoteleService.getTagCnToTeleFor190(fmt190, fmt190.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt190, mt190, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT190","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT191(GenericDTO<Fmt191> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT191","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt191 fmt191Obj = reqDto.getBody();
        String fmt191Json = JSONObject.toJSON(fmt191Obj).toString();
        Fmt191 fmt191 = JSONObject.parseObject(fmt191Json, Fmt191.class);
        //兼容应用去掉AC栏位的斜杠
        fmt191 = pgstpswftoteleService.removeAcFor191(fmt191);
        MT191 mt191 = new MT191();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT191含有中文转电码
        if (JudgeUtils.isNotNull(fmt191.getSwHeader().getTraditionalFlag())){
            fmt191 = pgstpswftoteleService.getTagCnToTeleFor191(fmt191, fmt191.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt191, mt191, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT191","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT290(GenericDTO<Fmt290> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT290","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt290 fmt290Obj = reqDto.getBody();
        String fmt290Json = JSONObject.toJSON(fmt290Obj).toString();
        Fmt290 fmt290 = JSONObject.parseObject(fmt290Json, Fmt290.class);
        MT290 mt290 = new MT290();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对fmt290含有中文转电码
        if (JudgeUtils.isNotNull(fmt290.getSwHeader().getTraditionalFlag())){
            fmt290 = pgstpswftoteleService.getTagCnToTeleFor290(fmt290, fmt290.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt290, mt290, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT290","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT291(GenericDTO<Fmt291> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT291","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt291 fmt291Obj = reqDto.getBody();
        String fmt291Json = JSONObject.toJSON(fmt291Obj).toString();
        Fmt291 fmt291 = JSONObject.parseObject(fmt291Json, Fmt291.class);
        //兼容应用去掉AC栏位的斜杠
        fmt291 = pgstpswftoteleService.removeAcFor291(fmt291);
        MT291 mt291 = new MT291();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT291含有中文转电码
        if (JudgeUtils.isNotNull(fmt291.getSwHeader().getTraditionalFlag())){
            fmt291 = pgstpswftoteleService.getTagCnToTeleFor291(fmt291, fmt291.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt291, mt291, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT291","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT950(GenericDTO<Fmt950> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT950","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt950 fmt950Obj = reqDto.getBody();
        String fmt950Json = JSONObject.toJSON(fmt950Obj).toString();
        Fmt950 fmt950 = JSONObject.parseObject(fmt950Json, Fmt950.class);
        MT950 mt950 = new MT950();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt950, mt950, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT950","---end---");
        return rspDto;
    }

    @Override
    public GenericRspDTO<MtDto> assembleCheckMT900(GenericDTO<Fmt900> reqDto)  {
        logger.info("###{}###{}","Assemble Check MT900","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt900 fmt900Obj = reqDto.getBody();
        String fmt900Json = JSONObject.toJSON(fmt900Obj).toString();
        Fmt900 fmt900 = JSONObject.parseObject(fmt900Json, Fmt900.class);
        MT900 mt900 = new MT900();
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        //对FMT900含有中文转电码
        if (JudgeUtils.isNotNull(fmt900.getSwHeader().getTraditionalFlag())){
            fmt900 = pgstpswftoteleService.getTagCnToTeleFor900(fmt900, fmt900.getSwHeader().getTraditionalFlag());
        }
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt900, mt900, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT900","---end---");
        return rspDto;
    }

    /**
     * MT210报文检查
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleCheckMT210(GenericDTO<Fmt210> reqDto){
        logger.info("###{}###{}","Assemble Check MT210","---start---");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        //隔离对象 防止原FMT中文被修改成电码
        Fmt210 fmt210Obj = reqDto.getBody();
        String fmt210Json = JSONObject.toJSON(fmt210Obj).toString();
        Fmt210 fmt210 = JSONObject.parseObject(fmt210Json, Fmt210.class);
        //是否需要中文转电码
        if (JudgeUtils.isNotNull(fmt210.getSwHeader().getTraditionalFlag())){
            fmt210 = pgstpswftoteleService.getTagCnToTeleFor210(fmt210, fmt210.getSwHeader().getTraditionalFlag());
        }
        MT210 mt210 = new MT210();
        List<BlockMt> blockMts = new ArrayList<>();
        for (int i = 0; i < fmt210.getmTBlockList().size(); i++) {
            MT210Bolck mt210Bolck = new MT210Bolck();
            BlockMt blockMt = new BlockMt();
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF21())) {
                Tag21 tag21 = new Tag21();
                tag21.setRtrn(fmt210.getmTBlockList().get(i).getF21().getRtrn());
                mt210Bolck.putTagDataList(tag21);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF32B())) {
                Tag32B tag32B = new Tag32B();
                tag32B.setCur(fmt210.getmTBlockList().get(i).getF32B().getCur());
                tag32B.setIntbkSetAmt(fmt210.getmTBlockList().get(i).getF32B().getIntbkSetAmt());
                mt210Bolck.putTagDataList(tag32B);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50())) {
                Tag50 tag50 = new Tag50();
                tag50.setOrdCustAddrList(fmt210.getmTBlockList().get(i).getF50().getOrdCustAddrList());
                mt210Bolck.putTagDataList(tag50);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50C())) {
                Tag50C tag50C = new Tag50C();
                tag50C.setOrdCustBic(fmt210.getmTBlockList().get(i).getF50C().getOrdCustBic());
                mt210Bolck.putTagDataList(tag50C);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50F())) {
                Tag50F tag50F = new Tag50F();
                tag50F.setInstrCd(fmt210.getmTBlockList().get(i).getF50F().getInstrCd());
                tag50F.setCtryCode(fmt210.getmTBlockList().get(i).getF50F().getCtryCode());
                tag50F.setOrdCustBic(fmt210.getmTBlockList().get(i).getF50F().getOrdCustBic());
                tag50F.setOrdCustAc(fmt210.getmTBlockList().get(i).getF50F().getOrdCustAc());
                tag50F.setOrdCustAddrList(fmt210.getmTBlockList().get(i).getF50F().getOrdCustAddrList());
                mt210Bolck.putTagDataList(tag50F);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF52A())) {
                Tag52A tag52A = new Tag52A();
                tag52A.setOrdInstBic(fmt210.getmTBlockList().get(i).getF52A().getOrdInstBic());
                tag52A.setOrdInstType(fmt210.getmTBlockList().get(i).getF52A().getOrdInstType());
                tag52A.setOrdInstAc(fmt210.getmTBlockList().get(i).getF52A().getOrdInstAc());
                mt210Bolck.putTagDataList(tag52A);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF52D())) {
                Tag52D tag52D = new Tag52D();
                tag52D.setOrdInstAddrList(fmt210.getmTBlockList().get(i).getF52D().getOrdInstAddrList());
                tag52D.setOrdInstType(fmt210.getmTBlockList().get(i).getF52D().getOrdInstType());
                tag52D.setOrdInstAc(fmt210.getmTBlockList().get(i).getF52D().getOrdInstAc());
                mt210Bolck.putTagDataList(tag52D);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF56A())) {
                Tag56A tag56A = new Tag56A();
                tag56A.setMedInstType(fmt210.getmTBlockList().get(i).getF56A().getMedInstType());
                tag56A.setMedInstBic(fmt210.getmTBlockList().get(i).getF56A().getMedInstBic());
                tag56A.setMedInstAc(fmt210.getmTBlockList().get(i).getF56A().getMedInstAc());
                mt210Bolck.putTagDataList(tag56A);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF56D())) {
                Tag56D tag56D = new Tag56D();
                tag56D.setMedInstAddrList(fmt210.getmTBlockList().get(i).getF56D().getMedInstAddrList());
                tag56D.setMedInstType(fmt210.getmTBlockList().get(i).getF56D().getMedInstType());
                tag56D.setMedInstAc(fmt210.getmTBlockList().get(i).getF56D().getMedInstAc());
                mt210Bolck.putTagDataList(tag56D);
            }
            blockMt.setBlockbaseMessage(mt210Bolck);
            blockMts.add(blockMt);
        }
        for (BlockMt blockMt : blockMts) {
            BaseTag baseTag = new BaseTag();
            baseTag.setName("210Bolck");
            baseTag.setBlockMt(blockMt.getBlockbaseMessage());
            mt210.putTagDataList(baseTag);
        }
        ReqHead reqHead = new ReqHead();
        String recBankName = null;
        MtDto mtDto = commonAssemble.comAssembleMessage(fmt210, mt210, "N",reqHead,recBankName);
        rspDto.setBody(mtDto);
        logger.info("###{}###{}","Assemble Check MT210","---end---");
        return rspDto;
    }

    /**
     * 单电202COV检查
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> assembleCheckSingle202COV(GenericDTO<AssembleCheckSingle202COVReqDTO> reqDto) {
        AssembleCheckSingle202COVReqDTO single202COVReqDTO = reqDto.getBody();
        //MT202COV的202部分
        //隔离对象 防止原FMT中文被修改成电码
        Fmt202 fmt202Obj = single202COVReqDTO.getFmt202();
        String fmt202Json = JSONObject.toJSON(fmt202Obj).toString();
        Fmt202 fmt202 = JSONObject.parseObject(fmt202Json, Fmt202.class);
        //MT202COV的seqB部分
        SequenceB sequencDOs = single202COVReqDTO.getSequencDOs();
        //将seqB映射成fmt103
        Fmt103 fmt103Obj = new Fmt103();
        BeanUtils.copyProperties(sequencDOs,fmt103Obj);
        //隔离对象 防止原FMT中文被修改成电码
        String fmt103Json = JSONObject.toJSON(fmt103Obj).toString();
        Fmt103 fmt103 = JSONObject.parseObject(fmt103Json, Fmt103.class);
        //中文转电码
        fmt103 = commonAssemble.cnToTeleForSeqB(fmt103,fmt202);
        fmt202 = commonAssemble.cnToTeleFor202(fmt202);
        ReqHead reqHead = new ReqHead();
        String recBankName202 = null;
        //手动映射202COV
        MT202Cov mt202Cov = new MT202Cov();
        mt202Cov = specialMTService.mappingForMt202COV(mt202Cov, fmt202, fmt103);
        MtDto mtDto202 = commonAssemble.comAssembleMessage(fmt202, mt202Cov, "N",reqHead,recBankName202);
        GenericRspDTO<MtDto> genericRspDTO = new GenericRspDTO<>();
        genericRspDTO.setBody(mtDto202);
        return genericRspDTO;
    }

}