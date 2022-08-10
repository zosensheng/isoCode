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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides further details related to a direct debit mandate signed between the creditor and the debtor.
 * 
 * <p>MandateRelatedInformation15 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="MandateRelatedInformation15">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="DtOfSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="AmdmntInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="AmdmntInfDtls" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}AmendmentInformationDetails14" minOccurs="0"/>
 *         &lt;element name="ElctrncSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max1025Text" minOccurs="0"/>
 *         &lt;element name="FrstColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="FnlColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="Frqcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateSetupReason1Choice" minOccurs="0"/>
 *         &lt;element name="TrckgDays" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Exact2NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateRelatedInformation15", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "mndtId",
    "dtOfSgntr",
    "amdmntInd",
    "amdmntInfDtls",
    "elctrncSgntr",
    "frstColltnDt",
    "fnlColltnDt",
    "frqcy",
    "rsn",
    "trckgDays"
})
public class MandateRelatedInformation15 {

    @XmlElement(name = "MndtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String mndtId;
    @XmlElement(name = "DtOfSgntr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtOfSgntr;
    @XmlElement(name = "AmdmntInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Boolean amdmntInd;
    @XmlElement(name = "AmdmntInfDtls", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected AmendmentInformationDetails14 amdmntInfDtls;
    @XmlElement(name = "ElctrncSgntr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String elctrncSgntr;
    @XmlElement(name = "FrstColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frstColltnDt;
    @XmlElement(name = "FnlColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fnlColltnDt;
    @XmlElement(name = "Frqcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Frequency36Choice frqcy;
    @XmlElement(name = "Rsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateSetupReason1Choice rsn;
    @XmlElement(name = "TrckgDays", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String trckgDays;

    /**
     * 获取属性 mndtId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtId() {
        return mndtId;
    }

    /**
     * 设置属性 mndtId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtId(String value) {
        this.mndtId = value;
    }

    /**
     * 获取属性 dtOfSgntr 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtOfSgntr() {
        return dtOfSgntr;
    }

    /**
     * 设置属性 dtOfSgntr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtOfSgntr(XMLGregorianCalendar value) {
        this.dtOfSgntr = value;
    }

    /**
     * 获取属性 amdmntInd 的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAmdmntInd() {
        return amdmntInd;
    }

    /**
     * 设置属性 amdmntInd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAmdmntInd(Boolean value) {
        this.amdmntInd = value;
    }

    /**
     * 获取属性 amdmntInfDtls 的值。
     * 
     * @return
     *     possible object is
     *     {@link AmendmentInformationDetails14 }
     *     
     */
    public AmendmentInformationDetails14 getAmdmntInfDtls() {
        return amdmntInfDtls;
    }

    /**
     * 设置属性 amdmntInfDtls 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmendmentInformationDetails14 }
     *     
     */
    public void setAmdmntInfDtls(AmendmentInformationDetails14 value) {
        this.amdmntInfDtls = value;
    }

    /**
     * 获取属性 elctrncSgntr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElctrncSgntr() {
        return elctrncSgntr;
    }

    /**
     * 设置属性 elctrncSgntr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElctrncSgntr(String value) {
        this.elctrncSgntr = value;
    }

    /**
     * 获取属性 frstColltnDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrstColltnDt() {
        return frstColltnDt;
    }

    /**
     * 设置属性 frstColltnDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrstColltnDt(XMLGregorianCalendar value) {
        this.frstColltnDt = value;
    }

    /**
     * 获取属性 fnlColltnDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFnlColltnDt() {
        return fnlColltnDt;
    }

    /**
     * 设置属性 fnlColltnDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFnlColltnDt(XMLGregorianCalendar value) {
        this.fnlColltnDt = value;
    }

    /**
     * 获取属性 frqcy 的值。
     * 
     * @return
     *     possible object is
     *     {@link Frequency36Choice }
     *     
     */
    public Frequency36Choice getFrqcy() {
        return frqcy;
    }

    /**
     * 设置属性 frqcy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency36Choice }
     *     
     */
    public void setFrqcy(Frequency36Choice value) {
        this.frqcy = value;
    }

    /**
     * 获取属性 rsn 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public MandateSetupReason1Choice getRsn() {
        return rsn;
    }

    /**
     * 设置属性 rsn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public void setRsn(MandateSetupReason1Choice value) {
        this.rsn = value;
    }

    /**
     * 获取属性 trckgDays 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckgDays() {
        return trckgDays;
    }

    /**
     * 设置属性 trckgDays 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckgDays(String value) {
        this.trckgDays = value;
    }

}
