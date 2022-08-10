//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:35 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00200110;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FIToFIPaymentStatusReportV10 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FIToFIPaymentStatusReportV10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}GroupHeader91__1"/>
 *         &lt;element name="TxInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}PaymentTransaction110__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIToFIPaymentStatusReportV10", propOrder = {
    "grpHdr",
    "txInfAndSts"
})
public class FIToFIPaymentStatusReportV10 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader911 grpHdr;
    @XmlElement(name = "TxInfAndSts", required = true)
    protected PaymentTransaction1101 txInfAndSts;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader911 }
     *     
     */
    public GroupHeader911 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader911 }
     *     
     */
    public void setGrpHdr(GroupHeader911 value) {
        this.grpHdr = value;
    }

    /**
     * 获取txInfAndSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction1101 }
     *     
     */
    public PaymentTransaction1101 getTxInfAndSts() {
        return txInfAndSts;
    }

    /**
     * 设置txInfAndSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction1101 }
     *     
     */
    public void setTxInfAndSts(PaymentTransaction1101 value) {
        this.txInfAndSts = value;
    }

}
