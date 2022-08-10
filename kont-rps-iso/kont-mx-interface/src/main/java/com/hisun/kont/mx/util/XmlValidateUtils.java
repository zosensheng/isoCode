package com.hisun.kont.mx.util;

import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class XmlValidateUtils {

    public static final Map<String, String> xsdPathMaps = new HashMap<String, String>()
    {
        {
            put("pacs008.001.08stp", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_STP_FIToFICustomerCreditTransfer_20220730_2239_iso15.xsd");
            put("pacs008.001.08", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_008_001_08_FIToFICustomerCreditTransfer_20220730_1022_iso15.xsd");
            put("test", "pacs.008.001.10.xsd");

            put("pacs009.001.08adv", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_ADV_FinancialInstitutionCreditTransfer_20220730_1012_iso15.xsd");
            put("pacs009.001.08cov", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_COV_FinancialInstitutionCreditTransfer_20220730_1017_iso15.xsd");
            put("pacs009.001.08", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_009_001_08_FinancialInstitutionCreditTransfer_20220730_1004_iso15.xsd");


            put("camt.056.001.08", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_056_001_08_FIToFIPaymentCancellationRequest_20220730_1032_iso15.xsd");
            put("camt.029.001.08", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_029_001_09_ResolutionOfInvestigation_20220730_1042_iso15.xsd");
            put("camt.057.001.06", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_057_001_06_NotificationToReceive_20220730_1057_iso15.xsd");
            put("camt.054.001.08", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-camt_054_001_08_BankToCustomerDebitCreditNotification_20220730_1628_iso15.xsd");
            put("pacs.004.001.09", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_004_001_09_PaymentReturn_20220730_1005_iso15.xsd");
            put("pacs.002.001.10", "CBPRPlus_ISO_20022_Portfolio_November_2022_Release_CBPRPlus-pacs_002_001_10_FIToFIPaymentStatusReport_20220801_0725_iso15.xsd");

        }
    };

    /**
     * xsd校验
     * @param xmlStr
     * @throws Exception
     */
    public void validate(String mxType ,String xmlStr ){
        String xsdName = getXsd(mxType);
        String xsdFilePath = "/xsd/" + xsdName;
        // 获取xml文件的流、获取xsd文件流
        try(ByteArrayInputStream xmlStream = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
            InputStream xsdStream = XmlValidateUtils.class.getResourceAsStream(xsdFilePath);) {
            if (xsdStream == null) {
                KontException.throwKontException("RPSG9425", "Mx Xsd alert: The verification of schema XSD is failed since missing the corresponding XSD definition file in " + xsdFilePath);
            }
            // 进入校验逻辑
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            Source xsdSource = new StreamSource(xsdStream);
            Schema schema = schemaFactory.newSchema(xsdSource);
            Source xmlSource = new StreamSource(xmlStream);
            Validator validator = schema.newValidator();
            validator.validate(xmlSource);
        } catch (UnsupportedEncodingException e) {
//            todo:异常处理优化。
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取xml对应的xsd的名称
     * @param xsdType
     * @return
     */
    private String getXsd(String xsdType) {
       return xsdPathMaps.get(xsdType);

    }

    /**
     * xml中 Document 的校验
     * @param xml
     */
    public void  validateDocument(String xml){

        String xmlNode = getDocumentXmlNode(xml,"Document");
        System.out.println(xmlNode);
        this.validate("pacs008.001.08",xmlNode);


    }

    /**
     *
     * @param xmlStr
     * @return
     * @throws DocumentException
     */
    public String getDocumentXmlNode(String xmlStr ,String tagName)  {
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
        } catch (DocumentException e) {
//            todo:异常处理优化
            e.printStackTrace();
        }
        Element rootElement = document.getRootElement();
        List<Element> documents = rootElement.elements();

        //获取标签下的所有子节点列表
        Element Document = documents.stream()
                .filter(el -> (JudgeUtils.equals(el.getName(), tagName))).collect(Collectors.toList()).get(0);
        String xml = Document.asXML();
        return xml;
    }

}