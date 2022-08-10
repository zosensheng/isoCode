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
 * Provides the details to identify an account.
 * 
 * <p>CashAccount40 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CashAccount40">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}AccountIdentification4Choice" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccountType2Choice" minOccurs="0"/>
 *         &lt;element name="Ccy" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ActiveOrHistoricCurrencyCode" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max70Text" minOccurs="0"/>
 *         &lt;element name="Prxy" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ProxyAccountIdentification1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashAccount40", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "id",
    "tp",
    "ccy",
    "nm",
    "prxy"
})
public class CashAccount40 {

    @XmlElement(name = "Id", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected AccountIdentification4Choice id;
    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccountType2Choice tp;
    @XmlElement(name = "Ccy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String ccy;
    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String nm;
    @XmlElement(name = "Prxy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ProxyAccountIdentification1 prxy;

    /**
     * 获取属性 id 的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountIdentification4Choice }
     *     
     */
    public AccountIdentification4Choice getId() {
        return id;
    }

    /**
     * 设置属性 id 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountIdentification4Choice }
     *     
     */
    public void setId(AccountIdentification4Choice value) {
        this.id = value;
    }

    /**
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccountType2Choice }
     *     
     */
    public CashAccountType2Choice getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountType2Choice }
     *     
     */
    public void setTp(CashAccountType2Choice value) {
        this.tp = value;
    }

    /**
     * 获取属性 ccy 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * 设置属性 ccy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

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
     * 获取属性 prxy 的值。
     * 
     * @return
     *     possible object is
     *     {@link ProxyAccountIdentification1 }
     *     
     */
    public ProxyAccountIdentification1 getPrxy() {
        return prxy;
    }

    /**
     * 设置属性 prxy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyAccountIdentification1 }
     *     
     */
    public void setPrxy(ProxyAccountIdentification1 value) {
        this.prxy = value;
    }

}
