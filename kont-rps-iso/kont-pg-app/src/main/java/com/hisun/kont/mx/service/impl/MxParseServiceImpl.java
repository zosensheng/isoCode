package com.hisun.kont.mx.service.impl;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.mx.client.PyIrGlClient;
import com.hisun.kont.mx.dao.PgMxMstDao;
import com.hisun.kont.mx.entity.PgMxMstDO;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.javabean.head00100102.Party44Choice;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.service.MxParseService;
import com.hisun.kont.mx.service.MxService;
import com.hisun.kont.mx.util.AppHdrParser;
import com.hisun.kont.mx.util.MxParseUtils;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.sax.SAXSource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MxParseServiceImpl implements MxParseService {

    @Resource
    private MxService mxService;

    @Resource
    private PyIrGlClient pyIrGlClient;


    @Override
    public String rec(String reqXml) {
        //1 、入库
        //2 拆解头部 update
        //3、拆解体 插入表
        // 关联业务
        //4、catoff
        //5 反洗钱
        //6 派分逻辑（派分配置表）
        // 派分版本映射
        //7 调用py
        //8 应答（应答配置  002模板内容）
        String xml = "<message>\n" +
                "    <AppHdr xmlns='urn:iso:std:iso:20022:tech:xsd:head.001.001.02'\n" +
                "            xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <Fr>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>ABCDUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </Fr>\n" +
                "        <To>\n" +
                "            <FIId>\n" +
                "                <FinInstnId>\n" +
                "                    <BICFI>EFGHUS33XXX</BICFI>\n" +
                "                </FinInstnId>\n" +
                "            </FIId>\n" +
                "        </To>\n" +
                "        <BizMsgIdr>052202208105001001</BizMsgIdr>\n" +
                "        <MsgDefIdr>pacs.008.001.07</MsgDefIdr>\n" +
                "        <CreDt>2019-10-19T20:53:13Z</CreDt>\n" +
                "        <PssblDplct>false</PssblDplct>\n" +
                "    </AppHdr>\n" +
                "    <Document xmlns='urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10'\n" +
                "              xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\n" +
                "        <FIToFICstmrCdtTrf>\n" +
                "            <GrpHdr>\n" +
                "                <MsgId>823823423</MsgId>\n" +
                "                <CreDtTm>2019-10-19T21:00:45</CreDtTm>\n" +
                "                <BtchBookg>false</BtchBookg>\n" +
                "                <NbOfTxs>1</NbOfTxs>\n" +
                "                <CtrlSum>10000</CtrlSum>\n" +
                "                <TtlIntrBkSttlmAmt Ccy='USD'>10000</TtlIntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2019-10-28</IntrBkSttlmDt>\n" +
                "                <SttlmInf>\n" +
                "                    <SttlmMtd>INDA</SttlmMtd>\n" +
                "                </SttlmInf>\n" +
                "                <InstgAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>CITTGB2LPBG</BICFI>\n" +
                "                        <Nm>Lionel Messi</Nm>\n" +
                "                        <Othr>\n" +
                "                            <Id>2342342342</Id>\n" +
                "                            <Issr>FOOISSUER</Issr>\n" +
                "                        </Othr>\n" +
                "                    </FinInstnId>\n" +
                "                </InstgAgt>\n" +
                "                <InstdAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ICBCUS4CXXX</BICFI>\n" +
                "                        <Nm>Manu Ginobili</Nm>\n" +
                "                        <PstlAdr>\n" +
                "                            <AdrTp>PBOX</AdrTp>\n" +
                "                            <Dept>1</Dept>\n" +
                "                            <SubDept>DFGH</SubDept>\n" +
                "                            <StrtNm>My Street</StrtNm>\n" +
                "                            <BldgNb>1122</BldgNb>\n" +
                "                            <PstCd>10002</PstCd>\n" +
                "                            <TwnNm>Los Angeles</TwnNm>\n" +
                "                            <CtrySubDvsn>ABCD</CtrySubDvsn>\n" +
                "                        </PstlAdr>\n" +
                "                    </FinInstnId>\n" +
                "                </InstdAgt>\n" +
                "            </GrpHdr>\n" +
                "            <CdtTrfTxInf>\n" +
                "                <PmtId>\n" +
                "                    <InstrId>2233445566</InstrId>\n" +
                "                    <EndToEndId>987654321987654321</EndToEndId>\n" +
                "                    <TxId>123456789</TxId>\n" +
                "                    <ClrSysRef>SDSDS333</ClrSysRef>\n" +
                "                </PmtId>\n" +
                "                <IntrBkSttlmAmt Ccy='USD'>5000</IntrBkSttlmAmt>\n" +
                "                <IntrBkSttlmDt>2019-07-31</IntrBkSttlmDt>\n" +
                "                <SttlmPrty>URGT</SttlmPrty>\n" +
                "                <AccptncDtTm>2019-04-28T20:54:39</AccptncDtTm>\n" +
                "                <PoolgAdjstmntDt>2019-04-29</PoolgAdjstmntDt>\n" +
                "                <InstdAmt Ccy='USD'>5000</InstdAmt>\n" +
                "                <ChrgBr>SHAR</ChrgBr>\n" +
                "                <Dbtr>\n" +
                "                    <Nm>Jhon Doe</Nm>\n" +
                "                    <PstlAdr>\n" +
                "                        <AdrTp>HOME</AdrTp>\n" +
                "                        <Dept>ABCD</Dept>\n" +
                "                        <SubDept>1</SubDept>\n" +
                "                        <StrtNm>Foo Street</StrtNm>\n" +
                "                        <BldgNb>1</BldgNb>\n" +
                "                        <PstCd>1234</PstCd>\n" +
                "                        <TwnNm>Buenos Aires</TwnNm>\n" +
                "                        <CtrySubDvsn>CABA</CtrySubDvsn>\n" +
                "                        <Ctry>AR</Ctry>\n" +
                "                    </PstlAdr>\n" +
                "                    <CtryOfRes>AR</CtryOfRes>\n" +
                "                </Dbtr>\n" +
                "                <DbtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>ITUSUSP1XXX</BICFI>\n" +
                "                        <Nm>Foo Corp</Nm>\n" +
                "                    </FinInstnId>\n" +
                "                </DbtrAgt>\n" +
                "                <CdtrAgt>\n" +
                "                    <FinInstnId>\n" +
                "                        <BICFI>USTBUS31XXX</BICFI>\n" +
                "                    </FinInstnId>\n" +
                "                </CdtrAgt>\n" +
                "                <Cdtr>\n" +
                "                    <Nm>Mike Smith</Nm>\n" +
                "                </Cdtr>\n" +
                "            </CdtTrfTxInf>\n" +
                "        </FIToFICstmrCdtTrf>\n" +
                "    </Document>\n" +
                "</message>";
        //1.报文已接收 状态码 RECV

        //1.1 获取报文头 获取电文编码
        Optional<AppHdr> appHdr = AppHdrParser.parse(xml);
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
        // 获取电文编号
        String bizMsgIdr = appHdr1.getBizMsgIdr();
        // 获取重报标志
        Boolean pssblDplct = appHdr1.isPssblDplct();
        String sPssblDplct = "";
        if (JudgeUtils.isNotNull(pssblDplct)){
             sPssblDplct = pssblDplct.toString();
        }

        //1.2 将接收的报文插入到数据库
        PgMxMstDO pgMxMstDO = new PgMxMstDO();
        pgMxMstDO.setBizSvc(bizSvc);
        pgMxMstDO.setBizMsgIdr(bizMsgIdr);
        pgMxMstDO.setMtStr(reqXml);
        pgMxMstDO.setCreDt(creDt);
        pgMxMstDO.setFrId(frBic);
        pgMxMstDO.setToId(toBic);
        pgMxMstDO.setMsgDefIdr(msgDefIdr);
        pgMxMstDO.setMtStatus(MTInStatusConstants.MT_STATUS_RECV);
        pgMxMstDO.setPssbleDplct(sPssblDplct);
        mxService.insertMt(pgMxMstDO);


        try {
            //2报文拆解
            SAXSource documentSource = MxParseUtils.createFilteredSAXSource(reqXml, AbstractMX.DOCUMENT_LOCALNAME);
            Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
            Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
            //1.3 获取请求体的内容
            Optional<Pacs00800110> pacs008001101 = Optional.of(pacs00800110);
            String msgId = pacs008001101.map(Pacs00800110::getFIToFICstmrCdtTrf)
                    .map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getMsgId)
                    .orElse("");
           //FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            //System.out.println("报文检查测试========================>>>>"+fiToFICstmrCdtTrf.checkAll());
            //获取paty优先级
//            Optional<List<CreditTransferTransaction50>> creditTransferTransaction50s = pacs008001101.map(Pacs00800110::getFIToFICstmrCdtTrf)
//                    .map(FIToFICustomerCreditTransferV10::getCdtTrfTxInf);
//            ArrayList<String> strings = new ArrayList<>();
//            if (creditTransferTransaction50s.isPresent()){
//                List<CreditTransferTransaction50> cdtTrfTxInf = pacs00800110.getFIToFICstmrCdtTrf().getCdtTrfTxInf();
//                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
//                    Optional<CreditTransferTransaction50> creditTransferTransaction501 = Optional.of(creditTransferTransaction50);
//                    String value = creditTransferTransaction501.map(CreditTransferTransaction50::getPmtTpInf)
//                            .map(PaymentTypeInformation28::getInstrPrty)
//                            .map(Priority2Code::value)
//                            .orElse("");
//                    strings.add(value);
//                }
//            }
//            pgMxMstDO.setParty(strings.toString());
            pgMxMstDO.setMsgId(msgId);
            //mxService.updateMt(pgMxMstDO);
            MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
            mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
            mxPacs00800110.setPacs00800110(pacs00800110);
            System.out.println(mxPacs00800110);

            //3.报文已派分汇入 状态码为 DTED
            //派分报文汇入失败 状态码为  TFAIL

            //3.1 获取报文体
            GenericDTO<MXPacs00800110> pacs00800110GenericDTO = new GenericDTO<>();
            pacs00800110GenericDTO.setBody(mxPacs00800110);
            GenericRspDTO<NoBody> noBodyGenericRspDTO = pyIrGlClient.irPacs00800110(pacs00800110GenericDTO);
            System.out.println("*****" + noBodyGenericRspDTO.getMsgCd());
            if ("KONT0000".equals(noBodyGenericRspDTO.getMsgCd())) {
                // update 更新状态为 DTED
                pgMxMstDO.setMtStatus(MTInStatusConstants.MT_STATUS_DTED);
                mxService.updateMt(pgMxMstDO);
            } else {
                // update 更新状态为 TFAIL
                pgMxMstDO.setMtStatus(MTInStatusConstants.MT_STATUS_TFAIL);
                mxService.updateMt(pgMxMstDO);
            }

        } catch (Exception e) {
            // update 更新状状态码：拆解失败 DFAIL
            pgMxMstDO.setMtStatus(MTInStatusConstants.MT_STATUS_DFAIL);
            mxService.updateMt(pgMxMstDO);
            e.printStackTrace();
        }


        //4.报文已退回RMC 状态码为 RTN


        //reqXml = xml;

        //发送 py成功


        return null;
    }


    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx = MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }


}
