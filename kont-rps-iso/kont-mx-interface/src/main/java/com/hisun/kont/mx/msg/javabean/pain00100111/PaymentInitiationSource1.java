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
 * Specifies the source used to initiate the payment (such as an application or a software).
 * 
 * <p>PaymentInitiationSource1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentInitiationSource1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text"/>
 *         &lt;element name="Prvdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="Vrsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInitiationSource1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "nm",
    "prvdr",
    "vrsn"
})
public class PaymentInitiationSource1 {

    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String nm;
    @XmlElement(name = "Prvdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String prvdr;
    @XmlElement(name = "Vrsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String vrsn;

    /**
     * 获取属性 nm 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * 设置属性 nm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * 获取属性 prvdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrvdr() {
        return prvdr;
    }

    /**
     * 设置属性 prvdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrvdr(String value) {
        this.prvdr = value;
    }

    /**
     * 获取属性 vrsn 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrsn() {
        return vrsn;
    }

    /**
     * 设置属性 vrsn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrsn(String value) {
        this.vrsn = value;
    }

}
