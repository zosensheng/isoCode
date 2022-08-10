//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00200110;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OriginalPaymentInstruction32__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OriginalPaymentInstruction32__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlPmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}Max35Text"/>
 *         &lt;element name="TxInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}PaymentTransaction105__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPaymentInstruction32__1", propOrder = {
    "orgnlPmtInfId",
    "txInfAndSts"
})
public class OriginalPaymentInstruction321 {

    @XmlElement(name = "OrgnlPmtInfId", required = true)
    protected String orgnlPmtInfId;
    @XmlElement(name = "TxInfAndSts", required = true)
    protected PaymentTransaction1051 txInfAndSts;

    /**
     * 获取orgnlPmtInfId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlPmtInfId() {
        return orgnlPmtInfId;
    }

    /**
     * 设置orgnlPmtInfId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlPmtInfId(String value) {
        this.orgnlPmtInfId = value;
    }

    /**
     * 获取txInfAndSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction1051 }
     *     
     */
    public PaymentTransaction1051 getTxInfAndSts() {
        return txInfAndSts;
    }

    /**
     * 设置txInfAndSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction1051 }
     *     
     */
    public void setTxInfAndSts(PaymentTransaction1051 value) {
        this.txInfAndSts = value;
    }

}
