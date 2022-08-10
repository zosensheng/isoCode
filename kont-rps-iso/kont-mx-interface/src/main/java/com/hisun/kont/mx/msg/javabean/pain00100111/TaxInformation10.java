//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Details about tax paid, or to be paid, to the government in accordance with the law, including pre-defined parameters such as thresholds and type of account.
 * 
 * <p>TaxInformation10 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="TaxInformation10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TaxParty1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TaxParty2" minOccurs="0"/>
 *         &lt;element name="AdmstnZone" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="RefNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text" minOccurs="0"/>
 *         &lt;element name="Mtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="TtlTaxblBaseAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="TtlTaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate" minOccurs="0"/>
 *         &lt;element name="SeqNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Number" minOccurs="0"/>
 *         &lt;element name="Rcrd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TaxRecord3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxInformation10", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "cdtr",
    "dbtr",
    "admstnZone",
    "refNb",
    "mtd",
    "ttlTaxblBaseAmt",
    "ttlTaxAmt",
    "dt",
    "seqNb",
    "rcrd"
})
public class TaxInformation10 {

    @XmlElement(name = "Cdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected TaxParty1 cdtr;
    @XmlElement(name = "Dbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected TaxParty2 dbtr;
    @XmlElement(name = "AdmstnZone", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String admstnZone;
    @XmlElement(name = "RefNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String refNb;
    @XmlElement(name = "Mtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String mtd;
    @XmlElement(name = "TtlTaxblBaseAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt;
    @XmlElement(name = "TtlTaxAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ActiveOrHistoricCurrencyAndAmount ttlTaxAmt;
    @XmlElement(name = "Dt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "SeqNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BigDecimal seqNb;
    @XmlElement(name = "Rcrd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<TaxRecord3> rcrd;

    /**
     * 获取属性 cdtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxParty1 }
     *     
     */
    public TaxParty1 getCdtr() {
        return cdtr;
    }

    /**
     * 设置属性 cdtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxParty1 }
     *     
     */
    public void setCdtr(TaxParty1 value) {
        this.cdtr = value;
    }

    /**
     * 获取属性 dbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxParty2 }
     *     
     */
    public TaxParty2 getDbtr() {
        return dbtr;
    }

    /**
     * 设置属性 dbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxParty2 }
     *     
     */
    public void setDbtr(TaxParty2 value) {
        this.dbtr = value;
    }

    /**
     * 获取属性 admstnZone 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdmstnZone() {
        return admstnZone;
    }

    /**
     * 设置属性 admstnZone 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdmstnZone(String value) {
        this.admstnZone = value;
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
     * 获取属性 mtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMtd() {
        return mtd;
    }

    /**
     * 设置属性 mtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMtd(String value) {
        this.mtd = value;
    }

    /**
     * 获取属性 ttlTaxblBaseAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getTtlTaxblBaseAmt() {
        return ttlTaxblBaseAmt;
    }

    /**
     * 设置属性 ttlTaxblBaseAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlTaxblBaseAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlTaxblBaseAmt = value;
    }

    /**
     * 获取属性 ttlTaxAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getTtlTaxAmt() {
        return ttlTaxAmt;
    }

    /**
     * 设置属性 ttlTaxAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlTaxAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlTaxAmt = value;
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
     * 获取属性 seqNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSeqNb() {
        return seqNb;
    }

    /**
     * 设置属性 seqNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSeqNb(BigDecimal value) {
        this.seqNb = value;
    }

    /**
     * Gets the value of the rcrd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rcrd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRcrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaxRecord3 }
     * 
     * 
     */
    public List<TaxRecord3> getRcrd() {
        if (rcrd == null) {
            rcrd = new ArrayList<TaxRecord3>();
        }
        return this.rcrd;
    }

}
