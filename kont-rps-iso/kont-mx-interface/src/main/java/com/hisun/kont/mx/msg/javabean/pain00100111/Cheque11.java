//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Characteristics of a cheque instruction, such as cheque type or cheque number.
 * 
 * <p>Cheque11 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Cheque11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChqTp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ChequeType2Code" minOccurs="0"/>
 *         &lt;element name="ChqNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="ChqFr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}NameAndAddress16" minOccurs="0"/>
 *         &lt;element name="DlvryMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ChequeDeliveryMethod1Choice" minOccurs="0"/>
 *         &lt;element name="DlvrTo" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}NameAndAddress16" minOccurs="0"/>
 *         &lt;element name="InstrPrty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Priority2Code" minOccurs="0"/>
 *         &lt;element name="ChqMtrtyDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate" minOccurs="0"/>
 *         &lt;element name="FrmsCd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="MemoFld" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="RgnlClrZone" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="PrtLctn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="Sgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max70Text" maxOccurs="5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cheque11", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "chqTp",
    "chqNb",
    "chqFr",
    "dlvryMtd",
    "dlvrTo",
    "instrPrty",
    "chqMtrtyDt",
    "frmsCd",
    "memoFld",
    "rgnlClrZone",
    "prtLctn",
    "sgntr"
})
public class Cheque11 {

    @XmlElement(name = "ChqTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected ChequeType2Code chqTp;
    @XmlElement(name = "ChqNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String chqNb;
    @XmlElement(name = "ChqFr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected NameAndAddress16 chqFr;
    @XmlElement(name = "DlvryMtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ChequeDeliveryMethod1Choice dlvryMtd;
    @XmlElement(name = "DlvrTo", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected NameAndAddress16 dlvrTo;
    @XmlElement(name = "InstrPrty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "ChqMtrtyDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar chqMtrtyDt;
    @XmlElement(name = "FrmsCd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String frmsCd;
    @XmlElement(name = "MemoFld", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<String> memoFld;
    @XmlElement(name = "RgnlClrZone", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String rgnlClrZone;
    @XmlElement(name = "PrtLctn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String prtLctn;
    @XmlElement(name = "Sgntr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<String> sgntr;

    /**
     * 获取属性 chqTp 的值。
     * 
     * @return
     *     possible object is
     *     {@link ChequeType2Code }
     *     
     */
    public ChequeType2Code getChqTp() {
        return chqTp;
    }

    /**
     * 设置属性 chqTp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeType2Code }
     *     
     */
    public void setChqTp(ChequeType2Code value) {
        this.chqTp = value;
    }

    /**
     * 获取属性 chqNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChqNb() {
        return chqNb;
    }

    /**
     * 设置属性 chqNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChqNb(String value) {
        this.chqNb = value;
    }

    /**
     * 获取属性 chqFr 的值。
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress16 }
     *     
     */
    public NameAndAddress16 getChqFr() {
        return chqFr;
    }

    /**
     * 设置属性 chqFr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress16 }
     *     
     */
    public void setChqFr(NameAndAddress16 value) {
        this.chqFr = value;
    }

    /**
     * 获取属性 dlvryMtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link ChequeDeliveryMethod1Choice }
     *     
     */
    public ChequeDeliveryMethod1Choice getDlvryMtd() {
        return dlvryMtd;
    }

    /**
     * 设置属性 dlvryMtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeDeliveryMethod1Choice }
     *     
     */
    public void setDlvryMtd(ChequeDeliveryMethod1Choice value) {
        this.dlvryMtd = value;
    }

    /**
     * 获取属性 dlvrTo 的值。
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress16 }
     *     
     */
    public NameAndAddress16 getDlvrTo() {
        return dlvrTo;
    }

    /**
     * 设置属性 dlvrTo 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress16 }
     *     
     */
    public void setDlvrTo(NameAndAddress16 value) {
        this.dlvrTo = value;
    }

    /**
     * 获取属性 instrPrty 的值。
     * 
     * @return
     *     possible object is
     *     {@link Priority2Code }
     *     
     */
    public Priority2Code getInstrPrty() {
        return instrPrty;
    }

    /**
     * 设置属性 instrPrty 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Priority2Code }
     *     
     */
    public void setInstrPrty(Priority2Code value) {
        this.instrPrty = value;
    }

    /**
     * 获取属性 chqMtrtyDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getChqMtrtyDt() {
        return chqMtrtyDt;
    }

    /**
     * 设置属性 chqMtrtyDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setChqMtrtyDt(XMLGregorianCalendar value) {
        this.chqMtrtyDt = value;
    }

    /**
     * 获取属性 frmsCd 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrmsCd() {
        return frmsCd;
    }

    /**
     * 设置属性 frmsCd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrmsCd(String value) {
        this.frmsCd = value;
    }

    /**
     * Gets the value of the memoFld property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the memoFld property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMemoFld().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMemoFld() {
        if (memoFld == null) {
            memoFld = new ArrayList<String>();
        }
        return this.memoFld;
    }

    /**
     * 获取属性 rgnlClrZone 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRgnlClrZone() {
        return rgnlClrZone;
    }

    /**
     * 设置属性 rgnlClrZone 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRgnlClrZone(String value) {
        this.rgnlClrZone = value;
    }

    /**
     * 获取属性 prtLctn 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtLctn() {
        return prtLctn;
    }

    /**
     * 设置属性 prtLctn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtLctn(String value) {
        this.prtLctn = value;
    }

    /**
     * Gets the value of the sgntr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sgntr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSgntr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSgntr() {
        if (sgntr == null) {
            sgntr = new ArrayList<String>();
        }
        return this.sgntr;
    }

}
