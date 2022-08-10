package com.hisun.kont.mx;

import com.hisun.kont.ApplicationTest;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.util.*;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.Source;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

public class XsdTest  {




    @Test
    public void xsdTxt() throws Exception {
//        String result = "";
//        //创建SchemaFactory工厂
//        SchemaFactory sch=SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
//        Source source = new StringSource(xmlContent);
//        //s = s.replaceAll(" ","");
//        Source source1 = new StringSource(xsdContent);
//        //利用SchemaFactory工厂对象，接收验证的文件对象，生成Schema对象
//        Schema schema=sch.newSchema(source1);
//        //产生对此schema的验证器
//        Validator validator=schema.newValidator();
        String xml =
                        "\t<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\">\t\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t<FIToFICstmrCdtTrf>\t\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t<GrpHdr>\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<MsgId>pacs8bizmsgidr01</MsgId>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<CreDtTm>2021-04-09T09:00:00+01:00</CreDtTm>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<NbOfTxs>1</NbOfTxs>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<SttlmInf>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<SttlmMtd>INDA</SttlmMtd>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</SttlmInf>\t\t\t\t\t\t\t\n" +
                        "\t\t\t</GrpHdr>\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t<CdtTrfTxInf>\t\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<PmtId>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<InstrId>pacs8bizmsgidr01</InstrId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<EndToEndId>pacs008EndToEndId-001</EndToEndId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<UETR>8a562c67-ca16-48ba-b074-65581be6f001</UETR>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</PmtId>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<IntrBkSttlmAmt Ccy=\"EUR\">15669.38</IntrBkSttlmAmt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<IntrBkSttlmDt>2021-04-09</IntrBkSttlmDt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<ChrgBr>DEBT</ChrgBr>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<InstgAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<BICFI>RBOSGB2LXXX</BICFI>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</InstgAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<InstdAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<BICFI>ABNANL2AXXX</BICFI>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</InstdAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<IntrmyAgt1>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<BICFI>NDEAFIHHXXX</BICFI>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</IntrmyAgt1>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<Dbtr>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<Nm>C Consumer</Nm>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<PstlAdr>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<StrtNm>High Street</StrtNm>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<TwnNm>Epping</TwnNm>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<Ctry>GB</Ctry>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</PstlAdr>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</Dbtr>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<DbtrAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<BICFI>RBOSGB2LXXX</BICFI>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</DbtrAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<CdtrAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<BICFI>HELSFIHHXXX</BICFI>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</FinInstnId>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</CdtrAgt>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t<Cdtr>\t\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<Nm>Evli</Nm>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t<PstlAdr>\t\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<StrtNm>Aleksanterinkatu 19</StrtNm>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<TwnNm>Helsinki</TwnNm>\t\t\t\t\t\n" +
                        "\t\t\t\t\t\t<Ctry>FI</Ctry>\t\t\t\t\t\n" +
                        "\t\t\t\t\t</PstlAdr>\t\t\t\t\t\t\n" +
                        "\t\t\t\t</Cdtr>\t\t\t\t\t\t\t\n" +
                        "\t\t\t</CdtTrfTxInf>\t\t\t\t\t\t\t\t\n" +
                        "\t\t</FIToFICstmrCdtTrf>\t\t\t\t\t\t\t\t\t\n" +
                        "\t</Document>\t\t\t\t\t\t\t\t\t\t\n" ;

//        CheckXML checkXML = new CheckXML();
//        checkXML.checkXML(xml);

//        InputStream xmlStream = IOUtils.toInputStream(
//                new String(xml), StandardCharsets.UTF_8.name());
//                String xsdPath = "D:\\swiftPgProject\\kont-pg\\kont-mx-interface\\src\\main\\resources\\pacs.008.001.10.xsd";
//        FileInputStream xsd = new FileInputStream(xsdPath);
////        FileInputStream xmlStream = new FileInputStream(text_xml.getText());
//        InputStream xsdStream = this.getClass().getResourceAsStream(xsdPath);
//       boolean isPassed = XmlValidate.validate(xmlStream, xsd);
//        System.out.println(isPassed);

        XmlValidateUtils xmlValidateUtils = new XmlValidateUtils();
        xmlValidateUtils.validate("pacs008.001.08",xml);
    }


    @Test
    public void OptionalTest() throws Exception {
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
                "        <BizMsgIdr>12312312312</BizMsgIdr>\n" +
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
//                "                            <AdrTp>PBOX</AdrTp>\n" +
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
//                "                        <AdrTp>HOME</AdrTp>\n" +
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


        Optional<AppHdr> appHdr = AppHdrParser.parse(xml);

        BusinessApplicationHeaderV02 appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();

        System.out.println(appHdr.get());
        System.out.println(appHdr1);

        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(xml, AbstractMX.DOCUMENT_LOCALNAME);
//        AppHdr appHdr2 = appHdr1;
//        document.setBusinessApplicationHeaderV02(appHdr1);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();

        Optional.ofNullable(pacs00800110);

        Optional<Pacs00800110> pacs008001101 = Optional.of(pacs00800110);
        Optional<BusinessApplicationHeaderV02> appHdr11 = Optional.of(appHdr1);

        String s = appHdr11.map(BusinessApplicationHeaderV02::getFr)
                .map(Party44Choice::getFIId)
                .map(BranchAndFinancialInstitutionIdentification6::getBrnchId)
                .map(BranchData3::getId).orElse("");

        Optional<String> s1 = appHdr11.map(BusinessApplicationHeaderV02::getFr)
                .map(Party44Choice::getFIId)
                .map(BranchAndFinancialInstitutionIdentification6::getBrnchId)
                .map(BranchData3::getId);

        //如果该值不存在则 s1.isPresent(); 有值true  无值为false
            s1.isPresent();


        System.out.println();

        System.out.println(s);

//        Optional.ofNullable(param).map(Param::getCity).map(City::getCode).map(Code::getValue).orElse("init")


    }

    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx =  MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }

}
