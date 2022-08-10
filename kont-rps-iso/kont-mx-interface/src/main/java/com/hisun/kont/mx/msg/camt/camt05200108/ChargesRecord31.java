//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChargesRecord3__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ChargesRecord3__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CreditDebitCode" minOccurs="0"/>
 *         &lt;element name="ChrgInclInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ChargeIncludedIndicator" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ChargeType3Choice__1" minOccurs="0"/>
 *         &lt;element name="Rate" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PercentageRate" minOccurs="0"/>
 *         &lt;element name="Br" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="Tax" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TaxCharges2__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargesRecord3__1", propOrder = {
    "amt",
    "cdtDbtInd",
    "chrgInclInd",
    "tp",
    "rate",
    "br",
    "agt",
    "tax"
})
public class ChargesRecord31 {

    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd")
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "ChrgInclInd")
    protected Boolean chrgInclInd;
    @XmlElement(name = "Tp")
    protected ChargeType3Choice1 tp;
    @XmlElement(name = "Rate")
    protected BigDecimal rate;
    @XmlElement(name = "Br")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code br;
    @XmlElement(name = "Agt")
    protected BranchAndFinancialInstitutionIdentification62 agt;
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
     * 获取chrgInclInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChrgInclInd() {
        return chrgInclInd;
    }

    /**
     * 设置chrgInclInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChrgInclInd(Boolean value) {
        this.chrgInclInd = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeType3Choice1 }
     *     
     */
    public ChargeType3Choice1 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeType3Choice1 }
     *     
     */
    public void setTp(ChargeType3Choice1 value) {
        this.tp = value;
    }

    /**
     * 获取rate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置rate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * 获取br属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public ChargeBearerType1Code getBr() {
        return br;
    }

    /**
     * 设置br属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public void setBr(ChargeBearerType1Code value) {
        this.br = value;
    }

    /**
     * 获取agt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getAgt() {
        return agt;
    }

    /**
     * 设置agt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.agt = value;
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
