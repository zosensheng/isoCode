package com.hisun.kont.mx;

import com.hisun.kont.ApplicationTest;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.controller.MonitSwiftXmlController;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;

import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.model.MxWriteParams;
import com.hisun.kont.mx.msg.pacs.MXPacs00800110;
import com.hisun.kont.mx.msg.pacs.Pacs00800110;
import com.hisun.kont.mx.msg.pacs.dic.FIToFICustomerCreditTransferV10;
import com.hisun.kont.mx.msg.pacs.dic.GroupHeader96;
import com.hisun.kont.mx.service.MxParseService;
import com.hisun.kont.mx.util.*;
import org.dom4j.*;
import org.junit.Test;


import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.sax.SAXSource;
import java.util.*;
import java.util.stream.Collectors;


public class LogbackTest extends ApplicationTest {

    @Resource
    MxParseService mxParseService;
    @Resource
    MonitSwiftXmlController monitSwiftXmlController;




    @Test
    public void saveTxt() throws Exception {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<RequestPayload>\n" +
                "<AppHdr xmlns=\"urn:iso:std:iso:20022:tech:xsd:head.001.001.02\">\n" +
                "    <BizMsgIdr>111111111111111</BizMsgIdr>\n" +
                "</AppHdr>\n" +
                "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10\">\n" +
                "    <FIToFICstmrCdtTrf>\n" +
                "        <GrpHdr>\n" +
                "            <MsgId>TBEXO12345</MsgId>\n" +
                "            <CreDtTm>2022-08-10T14:14:22.638+08:00</CreDtTm>\n" +
                "            <NbOfTxs>1</NbOfTxs>\n" +
                "        </GrpHdr>\n" +
                "    </FIToFICstmrCdtTrf>\n" +
                "</Document>\n" +
                "</RequestPayload>\n";


        Optional<AppHdr> appHdr = AppHdrParser.parse(xml);

        BusinessApplicationHeaderV02   appHdr1 = (BusinessApplicationHeaderV02) appHdr.get();
        System.out.println(appHdr.get());
        System.out.println(appHdr1);
        SAXSource documentSource2 = MxParseUtils.createFilteredSAXSource(xml, AppHdr.HEADER_LOCALNAME);
        Object o = MxParseUtils.parseSAXSource(documentSource2, BusinessApplicationHeaderV02.class, BusinessApplicationHeaderV02._classes);


        SAXSource documentSource = MxParseUtils.createFilteredSAXSource(xml, AbstractMX.DOCUMENT_LOCALNAME);
//        AppHdr appHdr2 = appHdr1;
//        document.setBusinessApplicationHeaderV02(appHdr1);
        Optional<Object> mx = parseDocumentFromSAXSource(documentSource, Pacs00800110.class, MXPacs00800110._classes);
        Pacs00800110 pacs00800110 = (Pacs00800110) mx.get();
        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();
        mxPacs00800110.setBusinessApplicationHeaderV02(appHdr1);
        mxPacs00800110.setPacs00800110(pacs00800110);
        System.out.println(mxPacs00800110);


    }


    private static Optional<Object> parseDocumentFromSAXSource(SAXSource source, Class targetClass, Class<?>[] classes) {
        final Object mx =  MxParseUtils.parseSAXSource(source, targetClass, classes);
        return Optional.ofNullable(mx);
    }



    @Test
    public void genMsg() throws Exception {
        String xml = "";

        /*
         * Initialize the MX object
         */
        Pacs00800110 mx = new Pacs00800110();
        /*
         * Initialize main message content main objects
         */

        FIToFICustomerCreditTransferV10 fiToFICustomerCreditTransferV10 = new FIToFICustomerCreditTransferV10();
        fiToFICustomerCreditTransferV10.setGrpHdr(new GroupHeader96());
        mx.setFIToFICstmrCdtTrf(fiToFICustomerCreditTransferV10);

        /*
         * General Information
         */
        mx.getFIToFICstmrCdtTrf().getGrpHdr().setMsgId("TBEXO12345");
        mx.getFIToFICstmrCdtTrf().getGrpHdr().setCreDtTm(getXMLGregorianCalendarNow());
        mx.getFIToFICstmrCdtTrf().getGrpHdr().setNbOfTxs("1");
//        pacs00800110.getNamespace();
//        pacs00800110.getBusinessProcess();


        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = new BusinessApplicationHeaderV02();
        businessApplicationHeaderV02.setBizMsgIdr("111111111111111");

        MXPacs00800110 mxPacs00800110 = new MXPacs00800110();

        mxPacs00800110.setBusinessApplicationHeaderV02(businessApplicationHeaderV02);

//        String s = mx.toJson();
//        System.out.println(s);

//        AbstractMX abstractMX=  mx;
//        String s2 = abstractMX.toJson();
//        System.out.println( s2) ;

//        xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10", mx, mxPacs00800110.getClasses(), new MxWriteParams());
//        System.out.println(xml);


//        MxWriteImpl.write(namespace, obj, classes, prefix, includeXMLDeclaration, escapeHandler);

        mxPacs00800110.setPacs00800110(mx);
        System.out.println(mxPacs00800110.message());


        String message = mxPacs00800110.message();
        String genXml = "<Envelope xmlns=\"urn:swift:xsd:envelope\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:swift:xsd:envelope ../../../../March21Schemas/Translator_envelope.xsd\">" +
                "<AppHdr>\n" +
                "\t<Fr>\n" +
                "\t\t<FIId>\n" +
                "\t\t\t<FinInstnId>\n" +
                "\t\t\t\t<BICFI>CHASGB2LXXX</BICFI>\n" +
                "\t\t\t</FinInstnId>\n" +
                "\t\t</FIId>\n" +
                "\t</Fr>\n" +
                "\t<To>\n" +
                "\t\t<FIId>\n" +
                "\t\t\t<FinInstnId>\n" +
                "\t\t\t\t<BICFI>CHASUS33XXX</BICFI>\n" +
                "\t\t\t</FinInstnId>\n" +
                "\t\t</FIId>\n" +
                "\t</To>\n" +
                "\t<BizMsgIdr>A2B0506272708</BizMsgIdr>\n" +
                "\t<MsgDefIdr>pacs.008.001.08</MsgDefIdr>\n" +
                "\t<BizSvc>swift.cbprplus.02</BizSvc>\n" +
                "\t<CreDt>2020-01-11T12:43:41.960+00:00</CreDt>\n" +
                "</AppHdr>\n" +
                "<Document xmlns=\"urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "\t<FIToFICstmrCdtTrf>\n" +
                "\t\t<GrpHdr>\n" +
                "\t\t\t<MsgId>A2B0506272708</MsgId>\n" +
                "\t\t\t<CreDtTm>2020-01-11T12:43:41.960+00:00</CreDtTm>\n" +
                "\t\t\t<NbOfTxs>1</NbOfTxs>\n" +
                "\t\t\t<SttlmInf>\n" +
                "\t\t\t\t<SttlmMtd>INDA</SttlmMtd>\n" +
                "\t\t\t</SttlmInf>\n" +
                "\t\t</GrpHdr>\n" +
                "\t\t<CdtTrfTxInf>\n" +
                "\t\t\t<PmtId>\n" +
                "\t\t\t\t<InstrId>A2B0506272708</InstrId>\n" +
                "\t\t\t\t<EndToEndId>E2E04044506271305</EndToEndId>\n" +
                "\t\t\t\t<UETR>174c245f-2682-4291-ad67-2a41e530cd27</UETR>\n" +
                "\t\t\t</PmtId>\n" +
                "\t\t\t<IntrBkSttlmAmt Ccy=\"USD\">40000</IntrBkSttlmAmt>\n" +
                "\t\t\t<IntrBkSttlmDt>2020-01-11</IntrBkSttlmDt>\n" +
                "\t\t\t<InstdAmt Ccy=\"USD\">40000</InstdAmt>\n" +
                "\t\t\t<ChrgBr>SHAR</ChrgBr>\n" +
                "\t\t\t<InstgAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BICFI>CHASGB2LXXX</BICFI>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</InstgAgt>\n" +
                "\t\t\t<InstdAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BICFI>CHASUS33XXX</BICFI>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</InstdAgt>\n" +
                "\t\t\t<IntrmyAgt1>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BICFI>FTSBUS33XXX</BICFI>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</IntrmyAgt1>\n" +
                "\t\t\t<Dbtr>\n" +
                "\t\t\t\t<Nm>NOKIA CORPORATION</Nm>\n" +
                "\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t<StrtNm>1510 ARLINGTON BUSINESS PARK</StrtNm>\n" +
                "\t\t\t\t\t<PstCd>RG74SA</PstCd>\n" +
                "\t\t\t\t\t<TwnNm>THEALE</TwnNm>\n" +
                "\t\t\t\t\t<Ctry>GB</Ctry>\n" +
                "\t\t\t\t</PstlAdr>\n" +
                "\t\t\t</Dbtr>\n" +
                "\t\t\t<DbtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BICFI>CHASGB2LXXX</BICFI>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</DbtrAgt>\n" +
                "\t\t\t<CdtrAgt>\n" +
                "\t\t\t\t<FinInstnId>\n" +
                "\t\t\t\t\t<BICFI>BAUTUS31XXX</BICFI>\n" +
                "\t\t\t\t</FinInstnId>\n" +
                "\t\t\t</CdtrAgt>\n" +
                "\t\t\t<Cdtr>\n" +
                "\t\t\t\t<Nm>ATnT</Nm>\n" +
                "\t\t\t\t<PstlAdr>\n" +
                "\t\t\t\t\t<StrtNm>208 ARAKD ST</StrtNm>\n" +
                "\t\t\t\t\t<PstCd>1096</PstCd>\n" +
                "\t\t\t\t\t<TwnNm>DALLAS</TwnNm>\n" +
                "\t\t\t\t\t<TwnLctnNm>TEXAS</TwnLctnNm>\n" +
                "\t\t\t\t\t<Ctry>US</Ctry>\n" +
                "\t\t\t\t</PstlAdr>\n" +
                "\t\t\t</Cdtr>\n" +
                "\t\t\t<CdtrAcct>\n" +
                "\t\t\t\t<Id>\n" +
                "\t\t\t\t\t<Othr>\n" +
                "\t\t\t\t\t\t<Id>794115296</Id>\n" +
                "\t\t\t\t\t</Othr>\n" +
                "\t\t\t\t</Id>\n" +
                "\t\t\t</CdtrAcct>\n" +
                "\t\t\t<RmtInf>\n" +
                "\t\t\t\t<Ustrd>INV2708</Ustrd>\n" +
                "\t\t\t</RmtInf>\n" +
                "\t\t</CdtTrfTxInf>\n" +
                "\t</FIToFICstmrCdtTrf>\n" +
                "</Document>\n" +
                "</Envelope>";

//        String xmlNode = getXmlNode(genXml, "/Envelope/Document");
        String xmlNode = getDocumentXmlNode(genXml);
        System.out.println(xmlNode);


        XmlValidateUtils xmlValidateUtils = new XmlValidateUtils();
        xmlValidateUtils.validate("pacs008.001.08",xmlNode);



    }
    public String getDocumentXmlNode(String xmlStr) throws DocumentException {
        Document document = DocumentHelper.parseText(xmlStr);
        Element rootElement = document.getRootElement();
        List<Element> documents = rootElement.elements();

        //5、Document；获取标签下的所有子节点列表
        Element Document = documents.stream()
                .filter(el -> (JudgeUtils.equals(el.getName(), "Document"))).collect(Collectors.toList()).get(0);
        String xml = Document.asXML();

        return xml;
    }





    public String getXmlNode(String xmlStr,String xpath) throws DocumentException {
        Document document = DocumentHelper.parseText(xmlStr);
//        org.dom4j.Document ment = DocumentHelper.parseText(xml);
        String xpath1 = "/return/service/arguments/param/param[@name='record']";
        org.dom4j.Element ele = (org.dom4j.Element)document.selectSingleNode(xpath);


        HashMap nsMap=new HashMap();
        nsMap.put("ext","http://www.jee-soft.cn/bpm");
        nsMap.put("bpmn2","http://www.omg.org/spec/BPMN/20100524/MODEL");

        nsMap.put("Document","http://www.w3.org/2001/XMLSchema-instance");
        nsMap.put("Document2","urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08");
//        nsMap.put("ext","urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08");

        XPath xpath3=document.createXPath(xpath);
        Element rootElement = document.getRootElement();
        rootElement.getData();
//        document.getElementsByTagName("");
        List<Element> documents = rootElement.elements();

        //5、AppHdr；获取标签下的所有子节点列表
        Element AppHdrElement = documents.stream()
                .filter(el -> (JudgeUtils.equals(el.getName(), "AppHdr"))).collect(Collectors.toList()).get(0);
        AppHdrElement.asXML();

        //5、AppHdr；获取标签下的所有子节点列表
        Element Document = documents.stream()
                .filter(el -> (JudgeUtils.equals(el.getName(), "Document"))).collect(Collectors.toList()).get(0);
        Document.asXML();


        nsMap.put("xmlns","namespaceURI");
        xpath3.setNamespaceURIs(nsMap);
//        xpath3.

//         ele.asXML();

        return "";
    }




    public static XMLGregorianCalendar getXMLGregorianCalendarNow() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = null;
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        XMLGregorianCalendar now = datatypeFactory.newXMLGregorianCalendar(gregorianCalendar);
        return now;
    }









}



