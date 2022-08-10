//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00400109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Garnishment3__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Garnishment3__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}GarnishmentType1__1"/>
 *         &lt;element name="Grnshee" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135__5" minOccurs="0"/>
 *         &lt;element name="GrnshmtAdmstr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135__5" minOccurs="0"/>
 *         &lt;element name="RefNb" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax140Text_Extended" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="RmtdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="FmlyMdclInsrncInd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="MplyeeTermntnInd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}TrueFalseIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Garnishment3__1", propOrder = {
    "tp",
    "grnshee",
    "grnshmtAdmstr",
    "refNb",
    "dt",
    "rmtdAmt",
    "fmlyMdclInsrncInd",
    "mplyeeTermntnInd"
})
public class Garnishment31 {

    @XmlElement(name = "Tp", required = true)
    protected GarnishmentType11 tp;
    @XmlElement(name = "Grnshee")
    protected PartyIdentification1355 grnshee;
    @XmlElement(name = "GrnshmtAdmstr")
    protected PartyIdentification1355 grnshmtAdmstr;
    @XmlElement(name = "RefNb")
    protected String refNb;
    @XmlElement(name = "Dt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "RmtdAmt")
    protected ActiveOrHistoricCurrencyAndAmount rmtdAmt;
    @XmlElement(name = "FmlyMdclInsrncInd")
    protected Boolean fmlyMdclInsrncInd;
    @XmlElement(name = "MplyeeTermntnInd")
    protected Boolean mplyeeTermntnInd;

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GarnishmentType11 }
     *     
     */
    public GarnishmentType11 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GarnishmentType11 }
     *     
     */
    public void setTp(GarnishmentType11 value) {
        this.tp = value;
    }

    /**
     * 获取grnshee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public PartyIdentification1355 getGrnshee() {
        return grnshee;
    }

    /**
     * 设置grnshee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public void setGrnshee(PartyIdentification1355 value) {
        this.grnshee = value;
    }

    /**
     * 获取grnshmtAdmstr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public PartyIdentification1355 getGrnshmtAdmstr() {
        return grnshmtAdmstr;
    }

    /**
     * 设置grnshmtAdmstr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public void setGrnshmtAdmstr(PartyIdentification1355 value) {
        this.grnshmtAdmstr = value;
    }

    /**
     * 获取refNb属性的值。
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
     * 设置refNb属性的值。
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
     * 获取dt属性的值。
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
     * 设置dt属性的值。
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
     * 获取rmtdAmt属性的值。
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
     * 设置rmtdAmt属性的值。
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
     * 获取fmlyMdclInsrncInd属性的值。
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
     * 设置fmlyMdclInsrncInd属性的值。
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
     * 获取mplyeeTermntnInd属性的值。
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
     * 设置mplyeeTermntnInd属性的值。
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
