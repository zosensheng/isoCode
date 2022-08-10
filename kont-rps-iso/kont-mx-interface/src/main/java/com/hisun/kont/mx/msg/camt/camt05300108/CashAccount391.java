//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CashAccount39__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CashAccount39__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}AccountIdentification4Choice__1"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CashAccountType2Choice__1" minOccurs="0"/>
 *         &lt;element name="Ccy" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ActiveOrHistoricCurrencyCode"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax70Text" minOccurs="0"/>
 *         &lt;element name="Prxy" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ProxyAccountIdentification1__1" minOccurs="0"/>
 *         &lt;element name="Ownr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}PartyIdentification135__2" minOccurs="0"/>
 *         &lt;element name="Svcr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashAccount39__1", propOrder = {
    "id",
    "tp",
    "ccy",
    "nm",
    "prxy",
    "ownr",
    "svcr"
})
public class CashAccount391 {

    @XmlElement(name = "Id", required = true)
    protected AccountIdentification4Choice1 id;
    @XmlElement(name = "Tp")
    protected CashAccountType2Choice1 tp;
    @XmlElement(name = "Ccy", required = true)
    protected String ccy;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "Prxy")
    protected ProxyAccountIdentification11 prxy;
    @XmlElement(name = "Ownr")
    protected PartyIdentification1352 ownr;
    @XmlElement(name = "Svcr")
    protected BranchAndFinancialInstitutionIdentification61 svcr;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountIdentification4Choice1 }
     *     
     */
    public AccountIdentification4Choice1 getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountIdentification4Choice1 }
     *     
     */
    public void setId(AccountIdentification4Choice1 value) {
        this.id = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccountType2Choice1 }
     *     
     */
    public CashAccountType2Choice1 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountType2Choice1 }
     *     
     */
    public void setTp(CashAccountType2Choice1 value) {
        this.tp = value;
    }

    /**
     * 获取ccy属性的值。
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
     * 设置ccy属性的值。
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
     * 获取nm属性的值。
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
     * 设置nm属性的值。
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
     * 获取prxy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ProxyAccountIdentification11 }
     *     
     */
    public ProxyAccountIdentification11 getPrxy() {
        return prxy;
    }

    /**
     * 设置prxy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyAccountIdentification11 }
     *     
     */
    public void setPrxy(ProxyAccountIdentification11 value) {
        this.prxy = value;
    }

    /**
     * 获取ownr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public PartyIdentification1352 getOwnr() {
        return ownr;
    }

    /**
     * 设置ownr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public void setOwnr(PartyIdentification1352 value) {
        this.ownr = value;
    }

    /**
     * 获取svcr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getSvcr() {
        return svcr;
    }

    /**
     * 设置svcr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setSvcr(BranchAndFinancialInstitutionIdentification61 value) {
        this.svcr = value;
    }

}
