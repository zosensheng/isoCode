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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InterestRecord2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="InterestRecord2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CreditDebitCode"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}InterestType1Choice__1" minOccurs="0"/>
 *         &lt;element name="Rate" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Rate4__1" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}DateTimePeriod1__1" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Tax" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}TaxCharges2__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestRecord2__1", propOrder = {
    "amt",
    "cdtDbtInd",
    "tp",
    "rate",
    "frToDt",
    "rsn",
    "tax"
})
public class InterestRecord21 {

    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "Tp")
    protected InterestType1Choice1 tp;
    @XmlElement(name = "Rate")
    protected Rate41 rate;
    @XmlElement(name = "FrToDt")
    protected DateTimePeriod11 frToDt;
    @XmlElement(name = "Rsn")
    protected String rsn;
    @XmlElement(name = "Tax")
    protected TaxCharges21 tax;

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * 获取cdtDbtInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditDebitCode }
     *     
     */
    public CreditDebitCode getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * 设置cdtDbtInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDebitCode }
     *     
     */
    public void setCdtDbtInd(CreditDebitCode value) {
        this.cdtDbtInd = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InterestType1Choice1 }
     *     
     */
    public InterestType1Choice1 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InterestType1Choice1 }
     *     
     */
    public void setTp(InterestType1Choice1 value) {
        this.tp = value;
    }

    /**
     * 获取rate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Rate41 }
     *     
     */
    public Rate41 getRate() {
        return rate;
    }

    /**
     * 设置rate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Rate41 }
     *     
     */
    public void setRate(Rate41 value) {
        this.rate = value;
    }

    /**
     * 获取frToDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public DateTimePeriod11 getFrToDt() {
        return frToDt;
    }

    /**
     * 设置frToDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public void setFrToDt(DateTimePeriod11 value) {
        this.frToDt = value;
    }

    /**
     * 获取rsn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsn() {
        return rsn;
    }

    /**
     * 设置rsn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsn(String value) {
        this.rsn = value;
    }

    /**
     * 获取tax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxCharges21 }
     *     
     */
    public TaxCharges21 getTax() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCharges21 }
     *     
     */
    public void setTax(TaxCharges21 value) {
        this.tax = value;
    }

}
