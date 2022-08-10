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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides remittance information about a payment for garnishment-related purposes.
 * 
 * <p>Garnishment3 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Garnishment3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}GarnishmentType1"/>
 *         &lt;element name="Grnshee" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="GrnshmtAdmstr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="RefNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate" minOccurs="0"/>
 *         &lt;element name="RmtdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="FmlyMdclInsrncInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="MplyeeTermntnInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TrueFalseIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Garnishment3", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "tp",
    "grnshee",
    "grnshmtAdmstr",
    "refNb",
    "dt",
    "rmtdAmt",
    "fmlyMdclInsrncInd",
    "mplyeeTermntnInd"
})
public class Garnishment3 {

    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected GarnishmentType1 tp;
    @XmlElement(name = "Grnshee", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 grnshee;
    @XmlElement(name = "GrnshmtAdmstr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 grnshmtAdmstr;
    @XmlElement(name = "RefNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String refNb;
    @XmlElement(name = "Dt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "RmtdAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ActiveOrHistoricCurrencyAndAmount rmtdAmt;
    @XmlElement(name = "FmlyMdclInsrncInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected Boolean fmlyMdclInsrncInd;
    @XmlElement(name = "MplyeeTermntnInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected Boolean mplyeeTermntnInd;

    /**
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link GarnishmentType1 }
     *     
     */
    public GarnishmentType1 getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GarnishmentType1 }
     *     
     */
    public void setTp(GarnishmentType1 value) {
        this.tp = value;
    }

    /**
     * 获取属性 grnshee 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getGrnshee() {
        return grnshee;
    }

    /**
     * 设置属性 grnshee 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setGrnshee(PartyIdentification135 value) {
        this.grnshee = value;
    }

    /**
     * 获取属性 grnshmtAdmstr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getGrnshmtAdmstr() {
        return grnshmtAdmstr;
    }

    /**
     * 设置属性 grnshmtAdmstr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setGrnshmtAdmstr(PartyIdentification135 value) {
        this.grnshmtAdmstr = value;
    }

    /**
     * 获取属性 refNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefNb() {
        return refNb;
    }

    /**
     * 设置属性 refNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefNb(String value) {
        this.refNb = value;
    }

    /**
     * 获取属性 dt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * 设置属性 dt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * 获取属性 rmtdAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getRmtdAmt() {
        return rmtdAmt;
    }

    /**
     * 设置属性 rmtdAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setRmtdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.rmtdAmt = value;
    }

    /**
     * 获取属性 fmlyMdclInsrncInd 的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFmlyMdclInsrncInd() {
        return fmlyMdclInsrncInd;
    }

    /**
     * 设置属性 fmlyMdclInsrncInd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFmlyMdclInsrncInd(Boolean value) {
        this.fmlyMdclInsrncInd = value;
    }

    /**
     * 获取属性 mplyeeTermntnInd 的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMplyeeTermntnInd() {
        return mplyeeTermntnInd;
    }

    /**
     * 设置属性 mplyeeTermntnInd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMplyeeTermntnInd(Boolean value) {
        this.mplyeeTermntnInd = value;
    }

}
