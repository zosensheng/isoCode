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
 * Provides further details related to a credit transfer mandate signed between the creditor and the debtor.
 * 
 * <p>CreditTransferMandateData1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferMandateData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateTypeInformation2" minOccurs="0"/>
 *         &lt;element name="DtOfSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="DtOfVrfctn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODateTime" minOccurs="0"/>
 *         &lt;element name="ElctrncSgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max10KBinary" minOccurs="0"/>
 *         &lt;element name="FrstPmtDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="FnlPmtDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="Frqcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateSetupReason1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferMandateData1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "mndtId",
    "tp",
    "dtOfSgntr",
    "dtOfVrfctn",
    "elctrncSgntr",
    "frstPmtDt",
    "fnlPmtDt",
    "frqcy",
    "rsn"
})
public class CreditTransferMandateData1 {

    @XmlElement(name = "MndtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String mndtId;
    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateTypeInformation2 tp;
    @XmlElement(name = "DtOfSgntr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtOfSgntr;
    @XmlElement(name = "DtOfVrfctn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtOfVrfctn;
    @XmlElement(name = "ElctrncSgntr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected byte[] elctrncSgntr;
    @XmlElement(name = "FrstPmtDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frstPmtDt;
    @XmlElement(name = "FnlPmtDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fnlPmtDt;
    @XmlElement(name = "Frqcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Frequency36Choice frqcy;
    @XmlElement(name = "Rsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateSetupReason1Choice rsn;

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
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public MandateTypeInformation2 getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public void setTp(MandateTypeInformation2 value) {
        this.tp = value;
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
     * 获取属性 dtOfVrfctn 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtOfVrfctn() {
        return dtOfVrfctn;
    }

    /**
     * 设置属性 dtOfVrfctn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtOfVrfctn(XMLGregorianCalendar value) {
        this.dtOfVrfctn = value;
    }

    /**
     * 获取属性 elctrncSgntr 的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getElctrncSgntr() {
        return elctrncSgntr;
    }

    /**
     * 设置属性 elctrncSgntr 的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setElctrncSgntr(byte[] value) {
        this.elctrncSgntr = value;
    }

    /**
     * 获取属性 frstPmtDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrstPmtDt() {
        return frstPmtDt;
    }

    /**
     * 设置属性 frstPmtDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrstPmtDt(XMLGregorianCalendar value) {
        this.frstPmtDt = value;
    }

    /**
     * 获取属性 fnlPmtDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFnlPmtDt() {
        return fnlPmtDt;
    }

    /**
     * 设置属性 fnlPmtDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFnlPmtDt(XMLGregorianCalendar value) {
        this.fnlPmtDt = value;
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

}
