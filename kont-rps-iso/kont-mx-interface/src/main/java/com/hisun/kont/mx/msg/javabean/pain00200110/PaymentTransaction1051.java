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
 * <p>PaymentTransaction105__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction105__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}Max35Text"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}UUIDv4Identifier"/>
 *         &lt;element name="TxSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}ExternalPaymentTransactionStatus1Code"/>
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}StatusReasonInformation12__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction105__1", propOrder = {
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlUETR",
    "txSts",
    "stsRsnInf"
})
public class PaymentTransaction1051 {

    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId", required = true)
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlUETR", required = true)
    protected String orgnlUETR;
    @XmlElement(name = "TxSts", required = true)
    protected String txSts;
    @XmlElement(name = "StsRsnInf")
    protected StatusReasonInformation121 stsRsnInf;

    /**
     * 获取orgnlInstrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * 设置orgnlInstrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * 获取orgnlEndToEndId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * 设置orgnlEndToEndId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * 获取orgnlUETR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlUETR() {
        return orgnlUETR;
    }

    /**
     * 设置orgnlUETR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlUETR(String value) {
        this.orgnlUETR = value;
    }

    /**
     * 获取txSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxSts() {
        return txSts;
    }

    /**
     * 设置txSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxSts(String value) {
        this.txSts = value;
    }

    /**
     * 获取stsRsnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StatusReasonInformation121 }
     *     
     */
    public StatusReasonInformation121 getStsRsnInf() {
        return stsRsnInf;
    }

    /**
     * 设置stsRsnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReasonInformation121 }
     *     
     */
    public void setStsRsnInf(StatusReasonInformation121 value) {
        this.stsRsnInf = value;
    }

}
