package com.hisun.kont.mx.service.impl;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.constant.SendMxConstant;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.javabean.head00100102.Party44Choice;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.msg.pacs.dic.FIToFICustomerCreditTransferV10;
import com.hisun.kont.mx.msg.pacs.dic.GroupHeader96;
import com.hisun.kont.mx.remote.*;
import com.hisun.kont.mx.service.ListenMxRmcService;
import com.hisun.kont.mx.util.AppHdrParser;
import com.hisun.kont.mx.util.MxParseUtils;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.service.impl.PgstsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.sax.SAXSource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Optional;

@Service
public class ListenMxRmcServiceImpl implements ListenMxRmcService {

    private static final Logger logger = LoggerFactory.getLogger(ListenMxRmcServiceImpl.class);

    @Resource
    private PgstsService pgstsService;

    /**
     * 接收MX报文
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<ReceiveMxMsgRspDTO> receiveMxMsg(GenericDTO<ReceiveMxMsgReqDTO> reqDto) {
        logger.info("##### START TO 23391 , RECEIVE MX MESSAGE #####");
        GenericRspDTO<ReceiveMxMsgRspDTO> genericRspDTO = new GenericRspDTO<>();
        ReceiveMxMsgReqDTO receiveMxMsgReqDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        if (JudgeUtils.isNotNull(receiveMxMsgReqDTO.getSwiftInfo())){
            //先存MX原文
            String swiftInfo = receiveMxMsgReqDTO.getSwiftInfo();
            String srcBk = String.format("%03d", receiveMxMsgReqDTO.getSrcBk());
            String srcDt = receiveMxMsgReqDTO.getSrcDt().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            String srcSeq = receiveMxMsgReqDTO.getSrcSeq().trim();
            String msgNo = srcBk+srcDt+srcSeq;
            pgstsDO.setMsgNo(msgNo);
            pgstsDO.setMxStr(swiftInfo);
            pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_RECV);
            pgstsDO.setMxFlag("X");
            pgstsService.insertMt(pgstsDO);
            //1.拆解头部 获取报文头 获取电文编码
            Optional<AppHdr> appHdr = AppHdrParser.parse(swiftInfo);
            BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

            // 检查报文数据是否符合规范
            //String checkAll = appHdr1.checkAll();
            //System.out.println(checkAll);

            // 获取报文头数据
            Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);

            // 获取发报银行BIC    获取数据 如果位空则置为“”
            String frBic = appHdr11.map(BusinessApplicationHeaderV02::getFr)
                    .map(Party44Choice::getFIId)
                    .map(BranchAndFinancialInstitutionIdentification6::getFinInstnId)
                    .map(FinancialInstitutionIdentification18::getBICFI)
                    .orElse("");
            // 获取收报机构BIC    获取数据 如果为空则置为“”
            String toBic = appHdr11.map(BusinessApplicationHeaderV02::getTo)
                    .map(Party44Choice::getFIId)
                    .map(BranchAndFinancialInstitutionIdentification6::getFinInstnId)
                    .map(FinancialInstitutionIdentification18::getBICFI)
                    .orElse("");
            // 获取发报时间
            XMLGregorianCalendar creDt1 = appHdr1.getCreDt();
            LocalDateTime creDt = null;
            if (JudgeUtils.isNotNull(creDt1)){
                GregorianCalendar gregorianCalendar = creDt1.toGregorianCalendar();
                if (JudgeUtils.isNotNull(gregorianCalendar)){
                    ZonedDateTime zonedDateTime = gregorianCalendar.toZonedDateTime();
                    if (JudgeUtils.isNotNull(zonedDateTime)){
                        creDt = zonedDateTime.toLocalDateTime();
                    }
                }
            }
            // 获取服务类型
            String bizSvc = appHdr1.getBizSvc();
            // 获取电文类型
            String msgDefIdr = appHdr1.getMsgDefIdr();
            // 获取业务编号
            String bizMsgIdr = appHdr1.getBizMsgIdr();
            // 获取重报标志
            Boolean pssblDplct = appHdr1.isPssblDplct();
            //获取电文标识
            String bizSvc1 = appHdr1.getBizSvc();
            String sPssblDplct = "";
            if (JudgeUtils.isNotNull(pssblDplct)){
                sPssblDplct = pssblDplct.toString();
            }

            //2.报文数据入库
            pgstsDO.setMxType(msgDefIdr);
            pgstsDO.setMxBussService(bizSvc1);
            pgstsService.updateMtStatus(pgstsDO);
            //3.报文拆解
            //4.报文派分汇入
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.RECEIVE_MX_FAIL);
            genericRspDTO.setMsgInfo(SendMxConstant.RECEIVE_MX_SWIFT_INFO_IS_NULL);
        }
        return genericRspDTO;
    }

    /**
     * 接收MX发出报文回执
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<ReceiveMxAckRspDTO> receiveMxAck(GenericDTO<ReceiveMxAckReqDTO> reqDto) {
        GenericRspDTO<ReceiveMxAckRspDTO> genericRspDTO = new GenericRspDTO<>();
        return genericRspDTO;
    }

    /**
     * 接收mx_future报文
     * @param reqDto 请求体
     * @return 返回体
     */
    @Override
    public GenericRspDTO<ReceiveMxFutureMsgRspDTO> receiveMxFutureMsg(GenericDTO<ReceiveMxFutureMsgReqDTO> reqDto) {
        //定义返回体
        GenericRspDTO<ReceiveMxFutureMsgRspDTO> rspDTO = new GenericRspDTO<>();
        ReceiveMxFutureMsgRspDTO receiveMxFutureMsgRspDTO =new ReceiveMxFutureMsgRspDTO();
        //1,获取请求参数,获取一些报文基础信息
        ReceiveMxFutureMsgReqDTO receiveMxFutureMsgReqDTO = reqDto.getBody();
        //报文类型
        Integer mt = receiveMxFutureMsgReqDTO.getMt();
        //获取srcBk,acData,srcSeq用于组成报文编号

        //2 判断接收mx报文开关是否打开

        //3 判读当前交易是否在中心行交易

        //4 判断当前报文是否是长报文

        //5 解析报文，生成报文详细信息

        //6 调用汇入接口

        //7 完成交易，返回数据
        rspDTO.setBody(receiveMxFutureMsgRspDTO);
        return rspDTO;
    }


    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }
}
