package com.hisun.kont.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.KontJsonUtil;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.mt.remote.EaiHeaderDTO;
import com.hisun.kont.pg.mt.remote.F20;
import com.hisun.kont.pg.mt.remote.F21;
import com.hisun.kont.pg.mt.remote.F25;
import com.hisun.kont.pg.mt.remote.F30;
import com.hisun.kont.pg.mt.remote.F32B;
import com.hisun.kont.pg.mt.remote.F50;
import com.hisun.kont.pg.mt.remote.F50C;
import com.hisun.kont.pg.mt.remote.F50F;
import com.hisun.kont.pg.mt.remote.F52A;
import com.hisun.kont.pg.mt.remote.F52D;
import com.hisun.kont.pg.mt.remote.F56A;
import com.hisun.kont.pg.mt.remote.F56D;
import com.hisun.kont.pg.mt.remote.Fmt103;
import com.hisun.kont.pg.mt.remote.Fmt190;
import com.hisun.kont.pg.mt.remote.Fmt191;
import com.hisun.kont.pg.mt.remote.Fmt192;
import com.hisun.kont.pg.mt.remote.Fmt199;
import com.hisun.kont.pg.mt.remote.Fmt200;
import com.hisun.kont.pg.mt.remote.Fmt202;
import com.hisun.kont.pg.mt.remote.Fmt210;
import com.hisun.kont.pg.mt.remote.Fmt290;
import com.hisun.kont.pg.mt.remote.Fmt291;
import com.hisun.kont.pg.mt.remote.Fmt292;
import com.hisun.kont.pg.mt.remote.Fmt299;
import com.hisun.kont.pg.mt.remote.Fmt900;
import com.hisun.kont.pg.mt.remote.Fmt910;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.pg.mt.remote.MTBlock;
import com.hisun.kont.pg.mt.remote.RmcTrx04;
import com.hisun.kont.pg.mt.remote.SwHeader;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.service.SendService;
import com.hisun.kont.pg.utils.AssembleUtils;
import com.hisun.kont.pg.utils.CopyTagUtils;
import com.hisun.kont.pg.utils.GpiF79DTO;
import com.hisun.kont.pyrm.client.InwardReceiveInfoServiceClient;
import com.hisun.kont.pyrm.ir.remote.*;
import com.hisun.kont.swf.mt.message.MT199;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.TreeTag;
import com.hisun.kont.swf.mt.tag.*;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Function;

@Service
public class SendServiceImpl  implements SendService {
    private static final Logger logger = LoggerFactory.getLogger(SendServiceImpl.class);

    @Resource
    PgstsService pgstsService;

    @Resource
    InwardReceiveInfoServiceClient inwardReceiveInfoServiceClient;

    @Resource
    private PgMatchServiceImpl pgMatchService;

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    private SpecialMTServiceImpl specialMTService;

    @Resource
    private DismantleMTServiceImpl dismantleMTService;

    /**
     * switch 分路，发送前更新状态，发送后更新状态
     */
    @Override
    public String SendToInsts(BaseMessage baseMessage, PgstsDO pgstsDO, RmcTrx04 rmcTrx04, EaiHeaderDTO eaiHeaderDTO, ReqHead reqHead) {
        GenericRspDTO genericRspDTO = new GenericRspDTO();
        //报文来源入档
        if (JudgeUtils.isNotNull(rmcTrx04.getMsgSrc())){
            pgstsDO.setMsgSrc(rmcTrx04.getMsgSrc());
        }
        //报文信息入档
        pgstsDO = commonAssemble.mtMessageToPg(pgstsDO, baseMessage,reqHead);
        pgstsService.updateMt(pgstsDO,baseMessage,reqHead,rmcTrx04);
        //获取分路资料。根据报文类型创建不同对象。判断报文类型目前是否为汇入可接受
        String txCode = baseMessage.getTxCode();
        if (!AssembleUtils.incomeSupportType.containsKey("MT"+txCode)){
            logger.error("##### RPS DO NOT SUPPORT THE MT MESSAGE TYPE:{},MSG NO:{}",txCode,pgstsDO.getMsgNo());
            genericRspDTO.setMsgCd(MTConstants.MT_TYPE_NOT_SUPPORT);
            return genericRspDTO.getMsgCd();
        }
        //判断GPI199 或者GPI299关联是否成功
        if ("Y".equals(pgstsDO.getGpiFlag())){
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
            List<PgMatchDO> matchDo = pgMatchService.findListByPgMatchDo(pgMatchDO);
            //查看关联表是否有记录 有则说明关联成功  不用派给汇入落otherQ
            if (matchDo.size()>0){
                PgstsDO updatePgstsDO = new PgstsDO();
                updatePgstsDO.setMsgNo(pgstsDO.getMsgNo());
                if ("TFAIL".equals(pgstsDO.getGwMsgStatus())){
                    pgstsService.updateMtStatus(updatePgstsDO);
                }else {
                    updatePgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
                    pgstsService.updateMtStatus(updatePgstsDO);
                }
                return "KONT0000";
            }else {
                PgstsDO updatePgstsDO = new PgstsDO();
                updatePgstsDO.setMsgNo(pgstsDO.getMsgNo());
                if ("TFAIL".equals(pgstsDO.getGwMsgStatus())){
                    int result = pgstsService.updateMtStatus(updatePgstsDO);
                    if (result<1){
                        logger.error("##### UPDATE PGSTS GWMSGSTATUS TFAIL FAIL :{}",pgstsDO.getMsgNo());
                    }
                    return "KONT0000";
                }
            }
        }
        RoutesInfo routesInfo = null;
        //这里的try catch 是抓我们处理报文转成入参dto和电码转中文等逻辑是否异常
        try {
            routesInfo = getRoutesInfo(txCode,rmcTrx04,eaiHeaderDTO,baseMessage,pgstsDO.getMsgNo(),reqHead);
        } catch (Exception e) {
           logger.error("##### DISPATCH MESSAGE ERROR:{}",e);
           //异常更新表
            PgstsDO updPgstsDo = new PgstsDO();
            updPgstsDo.setMsgNo(pgstsDO.getMsgNo());
            updPgstsDo.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
            //派分失败 对汇入的入参进行存json
            if (!("103".equals(pgstsDO.getAhMt()) || "202".equals(pgstsDO.getAhMt()) || "200".equals(pgstsDO.getAhMt())
                    ||"Y".equals(pgstsDO.getFutureFg()))){
                if (JudgeUtils.isNotNull(routesInfo)){
                    Object json = JSONObject.toJSON(routesInfo);
                    String mtBean = json.toString();
                    updPgstsDo.setMtBean(mtBean);
                }
            }
            pgstsService.updateMtStatus(updPgstsDo);
            KontException.throwBusinessException(MTConstants.MT_ROUTESINFO_ERR);
        }
        //将FMT103对象转json 再装mvc发送对象
        String souObjectStr = KontJsonUtil.toJSON(routesInfo.getPrarmObject());
        //组装Fegin请求参数
        Object outMtobject = KontJsonUtil.toBean(souObjectStr, routesInfo.getTarClass());
        //获取调用函数  todo：一个参数可能不够用，有需要再进行扩展
        Function function = routesInfo.getFunction();
        //通过函数调用
        genericRspDTO = (GenericRspDTO) function.apply(outMtobject);

        // 派汇入异常 存json 支持重派
        if (JudgeUtils.isNotSuccess(genericRspDTO.getMsgCd())){
            logger.info("##### DISPATCH MESSAGE TO IR ERROR:{},MSG NO:{}",genericRspDTO.getMsgCd(),pgstsDO.getMsgNo());
            //应用处理异常 更新报文状态 派分失败
            PgstsDO updPgstsDo = new PgstsDO();
            updPgstsDo.setMsgNo(pgstsDO.getMsgNo());
            updPgstsDo.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
            //派分失败 对汇入的入参进行存json
            if (!("103".equals(pgstsDO.getAhMt()) || "202".equals(pgstsDO.getAhMt()) || "200".equals(pgstsDO.getAhMt())
                    ||"Y".equals(pgstsDO.getFutureFg()))){
                Object json = JSONObject.toJSON(routesInfo);
                String mtBean = json.toString();
                updPgstsDo.setMtBean(mtBean);
            }
            pgstsService.updateMtStatus(updPgstsDo);
            return genericRspDTO.getMsgCd();
        }else {
            logger.info("##### DISPATCH MESSAGE TO IR SUCCESS #####");
            PgstsDO updatePgstsDO = new PgstsDO();
            updatePgstsDO.setMsgNo(pgstsDO.getMsgNo());
            updatePgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
            pgstsService.updateMtStatus(updatePgstsDO);
            return "KONT0000";
        }
    }


    /**
     * 实现类中提供switch 语句分路，发送前更新状态，发送后更新状态。
     */
    @Override
    public void SendToIgwsts() {
           //组装 发送参数
          //获取路由信息
          //组装IGW参数发送
         //状态入库

    }


    /**
     *路由设置方法  通过报文编号决定报文类型以及之后逻辑。
     * @param txCpde
     * @return
     */
    public RoutesInfo getRoutesInfo(String txCpde, RmcTrx04 rmcTrx04, EaiHeaderDTO eaiHeaderDTO,BaseMessage baseMessage,String msgNo,ReqHead reqHead) throws Exception {
        RoutesInfo routesInfo = new RoutesInfo();
        GenericDTO genericDTO = new GenericDTO();
        logger.info("##### MAPPING MT MESSAGE TO FMT AND CALL IR 23390,MT TYPE:{}",txCpde);
        switch (txCpde) {
            case "103":
                ReceiveRemit103ReqDTO receiveRemit103ReqDTO = new ReceiveRemit103ReqDTO();
                receiveRemit103ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit103ReqDTO.setReqHead(reqHead);
                Fmt103 fmt103 = new Fmt103();
                receiveRemit103ReqDTO.setFmt103(fmt103);
                SwHeader swHeader = new SwHeader();
                fmt103.setSwHeader(swHeader);
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT103 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt103);
                CopyTagUtils.CphaderInfo("I", fmt103.getSwHeader(),baseMessage);
                receiveRemit103ReqDTO.getFmt103().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT103 #####");
                routesInfo.setPrarmObject(receiveRemit103ReqDTO);
                routesInfo.setTarClass(MT103ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT103ReceiveReqDTO o1 = (MT103ReceiveReqDTO) o;
                    o1.getFmt103().getSwHeader().setMsgNo(receiveRemit103ReqDTO.getFmt103().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT103Info(genericDTO);
                });
                return routesInfo;
            case "202":
                ReceiveRemit202ReqDTO receiveRemit202ReqDTO = new ReceiveRemit202ReqDTO();
                receiveRemit202ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit202ReqDTO.setReqHead(reqHead);
                Fmt202 fmt202 = new Fmt202();
                receiveRemit202ReqDTO.setFmt202(fmt202);
                fmt202.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT202 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt202);
                CopyTagUtils.CphaderInfo("I", fmt202.getSwHeader(),baseMessage);
                receiveRemit202ReqDTO.getFmt202().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT202 #####");
                routesInfo.setPrarmObject(receiveRemit202ReqDTO);
                routesInfo.setTarClass(MT202ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT202ReceiveReqDTO o1 = (MT202ReceiveReqDTO) o;
                    o1.getFmt202().getSwHeader().setMsgNo(receiveRemit202ReqDTO.getFmt202().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT202Info(genericDTO);
                });
                return routesInfo;
            case "200":
                ReceiveRemit200ReqDTO receiveRemit200ReqDTO = new ReceiveRemit200ReqDTO();
                receiveRemit200ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit200ReqDTO.setReqHead(reqHead);
                Fmt200 fmt200 = new Fmt200();
                receiveRemit200ReqDTO.setFmt200(fmt200);
                fmt200.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT200 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt200);
                CopyTagUtils.CphaderInfo("I", fmt200.getSwHeader(),baseMessage);
                receiveRemit200ReqDTO.getFmt200().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT200 #####");
                routesInfo.setPrarmObject(receiveRemit200ReqDTO);
                routesInfo.setTarClass(MT200ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT200ReceiveReqDTO o1 = (MT200ReceiveReqDTO) o;
                    o1.getFmt200().getSwHeader().setMsgNo(receiveRemit200ReqDTO.getFmt200().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT200Info(genericDTO);
                });
                return routesInfo;
            case "192":
                ReceiveRemit192ReqDTO receiveRemit192ReqDTO = new ReceiveRemit192ReqDTO();
                receiveRemit192ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit192ReqDTO.setReqHead(reqHead);
                Fmt192 fmt192 = new Fmt192();
                receiveRemit192ReqDTO.setFmt192(fmt192);
                fmt192.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT192 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt192);
                CopyTagUtils.CphaderInfo("I", fmt192.getSwHeader(),baseMessage);
                receiveRemit192ReqDTO.getFmt192().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT192 #####");
                routesInfo.setPrarmObject(receiveRemit192ReqDTO);
                routesInfo.setTarClass(MT192ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT192ReceiveReqDTO o1 = (MT192ReceiveReqDTO) o;
                    o1.getFmt192().getSwHeader().setMsgNo(receiveRemit192ReqDTO.getFmt192().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT192Info(genericDTO);
                });
                return routesInfo;
            case "292":
                ReceiveRemit292ReqDTO receiveRemit292ReqDTO = new ReceiveRemit292ReqDTO();
                receiveRemit292ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit292ReqDTO.setReqHead(reqHead);
                Fmt292 fmt292 = new Fmt292();
                receiveRemit292ReqDTO.setFmt292(fmt292);
                fmt292.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT292 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt292);
                CopyTagUtils.CphaderInfo("I", fmt292.getSwHeader(),baseMessage);
                receiveRemit292ReqDTO.getFmt292().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT292 #####");
                routesInfo.setPrarmObject(receiveRemit292ReqDTO);
                routesInfo.setTarClass(MT292ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT292ReceiveReqDTO o1 = (MT292ReceiveReqDTO) o;
                    o1.getFmt292().getSwHeader().setMsgNo(receiveRemit292ReqDTO.getFmt292().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT292Info(genericDTO);
                });
                return routesInfo;
            case "190":
                ReceiveRemit190ReqDTO receiveRemit190ReqDTO = new ReceiveRemit190ReqDTO();
                receiveRemit190ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit190ReqDTO.setReqHead(reqHead);
                Fmt190 fmt190 = new Fmt190();
                receiveRemit190ReqDTO.setFmt190(fmt190);
                fmt190.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT190 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt190);
                CopyTagUtils.CphaderInfo("I", fmt190.getSwHeader(),baseMessage);
                receiveRemit190ReqDTO.getFmt190().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT190 #####");
                routesInfo.setPrarmObject(receiveRemit190ReqDTO);
                routesInfo.setTarClass(MT190ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT190ReceiveReqDTO o1 = (MT190ReceiveReqDTO) o;
                    o1.getFmt190().getSwHeader().setMsgNo(receiveRemit190ReqDTO.getFmt190().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT190Info(genericDTO);
                });
                return routesInfo;
            case "191":
                ReceiveRemit191ReqDTO receiveRemit191ReqDTO = new ReceiveRemit191ReqDTO();
                receiveRemit191ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit191ReqDTO.setReqHead(reqHead);
                Fmt191 fmt191 = new Fmt191();
                receiveRemit191ReqDTO.setFmt191(fmt191);
                fmt191.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT191 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt191);
                CopyTagUtils.CphaderInfo("I", fmt191.getSwHeader(),baseMessage);
                receiveRemit191ReqDTO.getFmt191().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT191 #####");
                routesInfo.setPrarmObject(receiveRemit191ReqDTO);
                routesInfo.setTarClass(MT191ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT191ReceiveReqDTO o1 = (MT191ReceiveReqDTO) o;
                    o1.getFmt191().getSwHeader().setMsgNo(receiveRemit191ReqDTO.getFmt191().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT191Info(genericDTO);
                });
                return routesInfo;
            case "290":
                ReceiveRemit290ReqDTO receiveRemit290ReqDTO = new ReceiveRemit290ReqDTO();
                receiveRemit290ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit290ReqDTO.setReqHead(reqHead);
                Fmt290 fmt290 = new Fmt290();
                receiveRemit290ReqDTO.setFmt290(fmt290);
                fmt290.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT290 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt290);
                CopyTagUtils.CphaderInfo("I", fmt290.getSwHeader(),baseMessage);
                receiveRemit290ReqDTO.getFmt290().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT290 #####");
                routesInfo.setPrarmObject(receiveRemit290ReqDTO);
                routesInfo.setTarClass(MT290ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT290ReceiveReqDTO o1 = (MT290ReceiveReqDTO) o;
                    o1.getFmt290().getSwHeader().setMsgNo(receiveRemit290ReqDTO.getFmt290().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT290Info(genericDTO);
                });
                return routesInfo;
            case "291":
                ReceiveRemit291ReqDTO receiveRemit291ReqDTO = new ReceiveRemit291ReqDTO();
                receiveRemit291ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit291ReqDTO.setReqHead(reqHead);
                Fmt291 fmt291 = new Fmt291();
                receiveRemit291ReqDTO.setFmt291(fmt291);
                fmt291.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT291 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt291);
                CopyTagUtils.CphaderInfo("I", fmt291.getSwHeader(),baseMessage);
                receiveRemit291ReqDTO.getFmt291().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT291 #####");
                routesInfo.setPrarmObject(receiveRemit291ReqDTO);
                routesInfo.setTarClass(MT291ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT291ReceiveReqDTO o1 = (MT291ReceiveReqDTO) o;
                    o1.getFmt291().getSwHeader().setMsgNo(receiveRemit291ReqDTO.getFmt291().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT291Info(genericDTO);
                });
                return routesInfo;
            case "900":
                ReceiveRemit900ReqDTO receiveRemit900ReqDTO = new ReceiveRemit900ReqDTO();
                receiveRemit900ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit900ReqDTO.setReqHead(reqHead);
                Fmt900 fmt900 = new Fmt900();
                receiveRemit900ReqDTO.setFmt900(fmt900);
                fmt900.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT900 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt900);
                CopyTagUtils.CphaderInfo("I", fmt900.getSwHeader(),baseMessage);
                receiveRemit900ReqDTO.getFmt900().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT900 #####");
                routesInfo.setPrarmObject(receiveRemit900ReqDTO);
                routesInfo.setTarClass(MT900ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT900ReceiveReqDTO o1 = (MT900ReceiveReqDTO) o;
                    o1.getFmt900().getSwHeader().setMsgNo(receiveRemit900ReqDTO.getFmt900().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InwardReceiveMT900Info(genericDTO);
                });
                return routesInfo;
            case "910":
                ReceiveRemit910ReqDTO receiveRemit910ReqDTO = new ReceiveRemit910ReqDTO();
                receiveRemit910ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit910ReqDTO.setReqHead(reqHead);
                Fmt910 fmt910 = new Fmt910();
                receiveRemit910ReqDTO.setFmt910(fmt910);
                fmt910.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT910 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt910);
                CopyTagUtils.CphaderInfo("I", fmt910.getSwHeader(),baseMessage);
                receiveRemit910ReqDTO.getFmt910().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT910 #####");
                routesInfo.setPrarmObject(receiveRemit910ReqDTO);
                routesInfo.setTarClass(MT910ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT910ReceiveReqDTO o1 = (MT910ReceiveReqDTO) o;
                    o1.getFmt910().getSwHeader().setMsgNo(receiveRemit910ReqDTO.getFmt910().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT910Info(genericDTO);
                });
                return routesInfo;
            // TODO: 2021/8/20 汇入没有对应199接口
            case "199":
                ReceiveRemit199ReqDTO receiveRemit199ReqDTO = new ReceiveRemit199ReqDTO();
                receiveRemit199ReqDTO.setRmcTrx04(rmcTrx04);
//                receiveRemit199ReqDTO.setEaiHeaderDTO(eaiHeaderDTO);
                receiveRemit199ReqDTO.setReqHead(reqHead);
                Fmt199 fmt199 = new Fmt199();
                receiveRemit199ReqDTO.setFmt199(fmt199);
                fmt199.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT199 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt199);
                CopyTagUtils.CphaderInfo("I", fmt199.getSwHeader(),baseMessage);
                receiveRemit199ReqDTO.getFmt199().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT199 #####");
                routesInfo.setPrarmObject(receiveRemit199ReqDTO);
                routesInfo.setTarClass(MT199ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT199ReceiveReqDTO o1 = (MT199ReceiveReqDTO) o;
                    o1.getFmt199().getSwHeader().setMsgNo(receiveRemit199ReqDTO.getFmt199().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT199Info(genericDTO);
                });
                return routesInfo;

            case "299":
                ReceiveRemit299ReqDTO receiveRemit299ReqDTO = new ReceiveRemit299ReqDTO();
                receiveRemit299ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit299ReqDTO.setReqHead(reqHead);
                Fmt299 fmt299 = new Fmt299();
                receiveRemit299ReqDTO.setFmt299(fmt299);
                fmt299.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT199 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                CopyTagUtils.mappingMtToDto(baseMessage,fmt299);
                CopyTagUtils.CphaderInfo("I", fmt299.getSwHeader(),baseMessage);
                receiveRemit299ReqDTO.getFmt299().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT199 #####");
                routesInfo.setPrarmObject(receiveRemit299ReqDTO);
                routesInfo.setTarClass(MT299ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT299ReceiveReqDTO o1 = (MT299ReceiveReqDTO) o;
                    o1.getFmt299().getSwHeader().setMsgNo(receiveRemit299ReqDTO.getFmt299().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InWardReceiveMT299Info(genericDTO);
                });
                return routesInfo;

           case "210":
                ReceiveRemit210ReqDTO receiveRemit210ReqDTO = new ReceiveRemit210ReqDTO();
                receiveRemit210ReqDTO.setRmcTrx04(rmcTrx04);
                receiveRemit210ReqDTO.setEaiHeaderDTO(eaiHeaderDTO);
                receiveRemit210ReqDTO.setReqHead(reqHead);
                Fmt210 fmt210 = new Fmt210();
                receiveRemit210ReqDTO.setFmt210(fmt210);
                fmt210.setSwHeader(new SwHeader());
                logger.info("##### START TO ASSEMBLY PARAMETER FOR FMT210 #####");
                //press 组装参数  ——BaseMessage -->f103(本地) ->Json -F103(汇入)
                //由于210中存在多tag循环，无法使用工具类中的方法,需要手工映射
                ArrayList<BaseTag> tag20DataList = baseMessage.getTagDataList("20");
                Tag20 tag20 = (Tag20) tag20DataList.get(0);
                F20 f20 = new F20();
                BeanUtils.copyProperties(tag20, f20);
                fmt210.setF20(f20);
                ArrayList<BaseTag> tag25DataList = baseMessage.getTagDataList("25");
                if (JudgeUtils.isNotNull(tag25DataList)) {
                    Tag25 tag25 = (Tag25) tag25DataList.get(0);
                    F25 f25 = new F25();
                    BeanUtils.copyProperties(tag25, f25);
                    fmt210.setF25(f25);
                }
                ArrayList<BaseTag> tag30DataList = baseMessage.getTagDataList("30");
                Tag30 tag30 = (Tag30) tag30DataList.get(0);
                F30 f30 = new F30();
                BeanUtils.copyProperties(tag30, f30);
                fmt210.setF30(f30);
                //多tag循环中数据的获取方法
                TreeMap<TreeTag, ArrayList<BaseTag>> messageTagTree = baseMessage.getMessageTagTree();
                //定义一个map集合用于存储数据
                LinkedHashMap<Integer, ArrayList<BaseTag>> listMap = new LinkedHashMap<>();
                //定义map集合的初始key
                Integer listMapIndex = 1;
                for (Map.Entry<TreeTag, ArrayList<BaseTag>> treeTagArrayListEntry : messageTagTree.entrySet()) {
                    ArrayList<BaseTag> baseTags = treeTagArrayListEntry.getValue();
                    if (JudgeUtils.isNotNull(baseTags)) {
                        listMap.put(listMapIndex, baseTags);
                        listMapIndex++;
                    }
                }

                //由于对MT210采取的是TreeMap存储所以遍历之后最后一个就是210bolck()
                ArrayList<BaseTag> baseTags = listMap.get(listMap.size());
                List<MTBlock> mtBlockList = new ArrayList<>();
                for (BaseTag baseTag : baseTags) {
                    MTBlock mtBlock = new MTBlock();
                    BaseMessage baseTagBlockMt = baseTag.getBlockMt();
                    ArrayList<BaseTag> tag21DataList = baseTagBlockMt.getTagDataList("21");
                    ArrayList<BaseTag> tag32BDataList = baseTagBlockMt.getTagDataList("32B");
                    ArrayList<BaseTag> tag50DataList = baseTagBlockMt.getTagDataList("50");
                    ArrayList<BaseTag> tag50CDataList = baseTagBlockMt.getTagDataList("50C");
                    ArrayList<BaseTag> tag50FDataList = baseTagBlockMt.getTagDataList("50F");
                    ArrayList<BaseTag> tag52ADataList = baseTagBlockMt.getTagDataList("52A");
                    ArrayList<BaseTag> tag52DDataList = baseTagBlockMt.getTagDataList("52D");
                    ArrayList<BaseTag> tag56ADataList = baseTagBlockMt.getTagDataList("56A");
                    ArrayList<BaseTag> tag56DDataList = baseTagBlockMt.getTagDataList("56D");
                    //获取tag内容
                    if (JudgeUtils.isNotNull(tag21DataList)) {
                        Tag21 tag21 = (Tag21) tag21DataList.get(0);
                        String rtrn = tag21.getRtrn();
                        F21 f21 = new F21();
                        f21.setRtrn(rtrn);
                        mtBlock.setF21(f21);
                    }
                    if (JudgeUtils.isNotNull(tag32BDataList)) {
                        Tag32B tag32B = (Tag32B) tag32BDataList.get(0);
                        F32B f32B = new F32B();
                        BeanUtils.copyProperties(tag32B, f32B);
                        mtBlock.setF32B(f32B);
                    }
                    if (JudgeUtils.isNotNull(tag50DataList)) {
                        Tag50 tag50 = (Tag50) tag50DataList.get(0);
                        F50 f50 = new F50();
                        //F50和Tag50中的变量名不一致无法使用BeanUtils
                        List<String> ordCustAddr = tag50.getOrdCustAddrList();
                        f50.setOrdCustAddrList(ordCustAddr);
                        mtBlock.setF50(f50);
                    }
                    if (JudgeUtils.isNotNull(tag50CDataList)) {
                        Tag50C tag50C = (Tag50C) tag50CDataList.get(0);
                        F50C f50C = new F50C();
                        BeanUtils.copyProperties(tag50C, f50C);
                        mtBlock.setF50C(f50C);
                    }
                    if (JudgeUtils.isNotNull(tag50FDataList)) {
                        Tag50F tag50F = (Tag50F) tag50FDataList.get(0);
                        F50F f50F = new F50F();
                        BeanUtils.copyProperties(tag50F, f50F);
                        mtBlock.setF50F(f50F);
                    }
                    if (JudgeUtils.isNotNull(tag52ADataList)) {
                        Tag52A tag52A = (Tag52A) tag52ADataList.get(0);
                        F52A f52A = new F52A();
                        BeanUtils.copyProperties(tag52A, f52A);
                        mtBlock.setF52A(f52A);
                    }
                    if (JudgeUtils.isNotNull(tag52DDataList)) {
                        Tag52D tag52D = (Tag52D) tag52DDataList.get(0);
                        F52D f52D = new F52D();
                        BeanUtils.copyProperties(tag52D, f52D);
                        mtBlock.setF52D(f52D);
                    }
                    if (JudgeUtils.isNotNull(tag56ADataList)) {
                        Tag56A tag56A = (Tag56A) tag56ADataList.get(0);
                        F56A f56A = new F56A();
                        String medInstAc = tag56A.getMedInstAc();
                        String medInstType = tag56A.getMedInstType();
                        BeanUtils.copyProperties(tag56A, f56A);
                        mtBlock.setF56A(f56A);
                    }
                    if (JudgeUtils.isNotNull(tag56DDataList)) {
                        Tag56D tag56D = (Tag56D) tag56DDataList.get(0);
                        F56D f56D = new F56D();
                        BeanUtils.copyProperties(tag56D, f56D);
                        mtBlock.setF56D(f56D);
                    }
                    mtBlockList.add(mtBlock);
                }
                fmt210.setmTBlockList(mtBlockList);
                CopyTagUtils.CphaderInfo("I", fmt210.getSwHeader(),baseMessage);
                receiveRemit210ReqDTO.getFmt210().getSwHeader().setMsgNo(msgNo);
                logger.info("##### END TO ASSEMBLY PARAMETER FOR FMT210 #####");
                routesInfo.setPrarmObject(receiveRemit210ReqDTO);
                routesInfo.setTarClass(MT210ReceiveReqDTO.class);
                routesInfo.setFunction((o)->{
                    MT210ReceiveReqDTO o1 = (MT210ReceiveReqDTO) o;
                    o1.getFmt210().getSwHeader().setMsgNo(receiveRemit210ReqDTO.getFmt210().getSwHeader().getMsgNo());
                    BeanUtils.copyProperties(reqHead,o1.getReqHead());
                    genericDTO.setBody(o);
                    return inwardReceiveInfoServiceClient.InwardReceiveMT210Info(genericDTO);
                });
                return routesInfo;
           //不支持报文类型
            default:
                logger.error("##### THE MT TYPE IS IR NOT SUPPORT #####");
        }
        logger.info("##### END TO MAPPING MT MESSAGE TO FMT AND CALL IR 23390 #####");
        return routesInfo;

    }

    static class RoutesInfo{
        //本地中间F对象（rps）
        private Object  prarmObject;
        //fegin 入参类型 ，用于给json 进行copy 的目标入参
        private Class tarClass;
        //fegin 调用方法
        private Function function;

        public Function getFunction() {
            return function;
        }

        public void setFunction(Function function) {
            this.function = function;
        }

        public Object getPrarmObject() {
            return prarmObject;
        }

        public void setPrarmObject(Object prarmObject) {
            this.prarmObject = prarmObject;
        }

        public Class getTarClass() {
            return tarClass;
        }

        public void setTarClass(Class tarClass) {
            this.tarClass = tarClass;
        }
    }

    /**
     * 报文重派(低配版)
     * @param msgNo  报文编号
     * @return
     */
    @Override
    public String redistriMsg(String msgNo,ReqHead reqHead){
        //获取重派报文编号数据  拿到json入参
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
        //获取json
        String mtBean = pgstsDO.getMtBean();
        String ahMt = pgstsDO.getAhMt();
        //反序列化
        RoutesInfo routesInfo = JSONObject.parseObject(mtBean, RoutesInfo.class);
        GenericDTO genericDTO = new GenericDTO();
        GenericRspDTO genericRspDTO = new GenericRspDTO();
        //根据类型派给汇入
        switch (ahMt){
            case "103":
                ReceiveRemit103ReqDTO receiveRemit103ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit103ReqDTO.class);
                genericDTO.setBody(receiveRemit103ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT103Info(genericDTO);
                break;
            case "190":
                ReceiveRemit190ReqDTO receiveRemit190ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit190ReqDTO.class);
                genericDTO.setBody(receiveRemit190ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT190Info(genericDTO);
                break;
            case "191":
                ReceiveRemit191ReqDTO receiveRemit191ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit191ReqDTO.class);
                genericDTO.setBody(receiveRemit191ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT191Info(genericDTO);
                break;
            case "192":
                ReceiveRemit192ReqDTO receiveRemit192ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit192ReqDTO.class);
                genericDTO.setBody(receiveRemit192ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT192Info(genericDTO);
                break;
            case "196":
                ReceiveRemit196ReqDTO receiveRemit196ReqDTO = (ReceiveRemit196ReqDTO)routesInfo.getPrarmObject();
                genericDTO.setBody(receiveRemit196ReqDTO);
//                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT196Info(genericDTO);
                break;
            case "199":
                if ("Y".equals(pgstsDO.getGpiFlag())){
                    //重新推送GPI信息给汇出
                    String rtrn = pgstsDO.getRtrn();
                    String ohGpiRef = pgstsDO.getOhGpiRef();
                    String mtStr = pgstsDO.getMtStr();
                    BaseMessage baseMessage = dismantleMTService.dismantleMT(mtStr);
                    MT199 mt199 = (MT199) baseMessage;
                    ArrayList<BaseTag> tagDataListFor199 = mt199.getTagDataList("79");
                    Tag79 tag79For199 = (Tag79) tagDataListFor199.get(0);
                    List<String> narratList = tag79For199.getNarratList();
                    GpiF79DTO f79Value = AssembleUtils.getF79Value(narratList);
                    specialMTService.autoMatchGpiN99(pgstsDO,f79Value,ohGpiRef,rtrn,reqHead);
                    //查看是否推送成功及建立关联关系
                    PgMatchDO pgMatchDO = new PgMatchDO();
                    pgMatchDO.setMsgNo(pgstsDO.getMsgNo());
                    List<PgMatchDO> matchDo = pgMatchService.findListByPgMatchDo(pgMatchDO);
                    //查看关联表是否有记录 有则说明关联成功  不用派给汇入落otherQ
                    if (matchDo.size()>0){
                        PgstsDO updatePgstsDO = new PgstsDO();
                        updatePgstsDO.setMsgNo(pgstsDO.getMsgNo());
                        if ("TFAIL".equals(pgstsDO.getGwMsgStatus())){
                            genericRspDTO.setMsgCd(MTConstants.MT_AUTO_SEND_OR_ERR);
                        }
                    }else {
                        if ("TFAIL".equals(pgstsDO.getGwMsgStatus())){
                            genericRspDTO.setMsgCd(MTConstants.MT_AUTO_SEND_OR_ERR);
                        }else {
                            ReceiveRemit199ReqDTO receiveRemit199ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit199ReqDTO.class);
                            genericDTO.setBody(receiveRemit199ReqDTO);
                            genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT199Info(genericDTO);
                        }
                    }
                }else {
                    ReceiveRemit199ReqDTO receiveRemit199ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit199ReqDTO.class);
                    genericDTO.setBody(receiveRemit199ReqDTO);
                    genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT199Info(genericDTO);
                }
                break;
            case "200":
                ReceiveRemit200ReqDTO receiveRemit200ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit200ReqDTO.class);
                genericDTO.setBody(receiveRemit200ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT200Info(genericDTO);
                break;
            case "202":
                ReceiveRemit202ReqDTO receiveRemit202ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit202ReqDTO.class);
                genericDTO.setBody(receiveRemit202ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT202Info(genericDTO);
                break;
            case "210":
                ReceiveRemit210ReqDTO receiveRemit210ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit210ReqDTO.class);
                genericDTO.setBody(receiveRemit210ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InwardReceiveMT210Info(genericDTO);
                break;
            case "290":
                ReceiveRemit290ReqDTO receiveRemit290ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit290ReqDTO.class);
                genericDTO.setBody(receiveRemit290ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT200Info(genericDTO);
                break;
            case "291":
                ReceiveRemit291ReqDTO receiveRemit291ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit291ReqDTO.class);
                genericDTO.setBody(receiveRemit291ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT291Info(genericDTO);
                break;
            case "292":
                ReceiveRemit292ReqDTO receiveRemit292ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit292ReqDTO.class);
                genericDTO.setBody(receiveRemit292ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT292Info(genericDTO);
                break;
            case "296":
                ReceiveRemit296ReqDTO receiveRemit296ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit296ReqDTO.class);
                genericDTO.setBody(receiveRemit296ReqDTO);
//                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT296Info(genericDTO);
                break;
            case "299":
                ReceiveRemit299ReqDTO receiveRemit299ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit299ReqDTO.class);
                genericDTO.setBody(receiveRemit299ReqDTO);
//                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT299Info(genericDTO);
                break;
            case "900":
                ReceiveRemit900ReqDTO receiveRemit900ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit900ReqDTO.class);
                genericDTO.setBody(receiveRemit900ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InwardReceiveMT900Info(genericDTO);
                break;
            case "910":
                ReceiveRemit910ReqDTO receiveRemit910ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit910ReqDTO.class);
                genericDTO.setBody(receiveRemit910ReqDTO);
                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT910Info(genericDTO);
                break;
            case "950":
                ReceiveRemit950ReqDTO receiveRemit950ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit950ReqDTO.class);
                genericDTO.setBody(receiveRemit950ReqDTO);
//                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT950Info(genericDTO);
                break;
            case "999":
                ReceiveRemit999ReqDTO receiveRemit999ReqDTO = KontJsonUtil.toBean(routesInfo.getPrarmObject(), ReceiveRemit999ReqDTO.class);
                genericDTO.setBody(receiveRemit999ReqDTO);
//                genericRspDTO = inwardReceiveInfoServiceClient.InWardReceiveMT999Info(genericDTO);
                break;
        }
        //处理结果
        if (JudgeUtils.isNotSuccess(genericRspDTO.getMsgCd())){
            //应用处理异常 更新报文状态 派分失败
            PgstsDO updPgstsDo = new PgstsDO();
            updPgstsDo.setMsgNo(msgNo);
            updPgstsDo.setGwMsgStatus(MTInStatusConstants.MT_STATUS_TFAIL);
            pgstsService.updateMtStatus(updPgstsDo);
            return genericRspDTO.getMsgCd();
        }else {
            //应用处理异常 更新报文状态 派分成功
            PgstsDO updPgstsDo = new PgstsDO();
            updPgstsDo.setMsgNo(msgNo);
            updPgstsDo.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
            pgstsService.updateMtStatus(updPgstsDo);
            return genericRspDTO.getMsgCd();
        }

    }
}
