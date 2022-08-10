//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further means of referencing a payment transaction.
 * 
 * <p>PaymentIdentification6 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentIdentification6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstrId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="EndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text"/>
 *         &lt;element name="UETR" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}UUIDv4Identifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentIdentification6", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "instrId",
    "endToEndId",
    "uetr"
})
public class PaymentIdentification6 {

    @XmlElement(name = "InstrId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String instrId;
    @XmlElement(name = "EndToEndId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String endToEndId;
    @XmlElement(name = "UETR", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String uetr;

    /**
     * 获取属性 instrId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrId() {
        return instrId;
    }

    /**
     * 设置属性 instrId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrId(String value) {
        this.instrId = value;
    }

    /**
     * 获取属性 endToEndId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndToEndId() {
        return endToEndId;
    }

    /**
     * 设置属性 endToEndId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndToEndId(String value) {
        this.endToEndId = value;
    }

    /**
     * 获取属性 uetr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUETR() {
        return uetr;
    }

    /**
     * 设置属性 uetr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUETR(String value) {
        this.uetr = value;
    }

}
