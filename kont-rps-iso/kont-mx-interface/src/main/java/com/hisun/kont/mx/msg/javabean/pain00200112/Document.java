//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Document complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CstmrPmtStsRpt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CustomerPaymentStatusReportV12"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "cstmrPmtStsRpt"
})
public class Document {

    @XmlElement(name = "CstmrPmtStsRpt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected CustomerPaymentStatusReportV12 cstmrPmtStsRpt;

    /**
     * 获取属性 cstmrPmtStsRpt 的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentStatusReportV12 }
     *     
     */
    public CustomerPaymentStatusReportV12 getCstmrPmtStsRpt() {
        return cstmrPmtStsRpt;
    }

    /**
     * 设置属性 cstmrPmtStsRpt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentStatusReportV12 }
     *     
     */
    public void setCstmrPmtStsRpt(CustomerPaymentStatusReportV12 value) {
        this.cstmrPmtStsRpt = value;
    }

}
