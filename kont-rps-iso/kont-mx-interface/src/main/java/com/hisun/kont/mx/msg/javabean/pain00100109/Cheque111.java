//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00100109;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Cheque11__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Cheque11__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChqTp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ChequeType2Code__1" minOccurs="0"/>
 *         &lt;element name="ChqNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text" minOccurs="0"/>
 *         &lt;element name="ChqFr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}NameAndAddress16__1" minOccurs="0"/>
 *         &lt;element name="DlvryMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ChequeDeliveryMethod1Choice" minOccurs="0"/>
 *         &lt;element name="DlvrTo" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}NameAndAddress16__1" minOccurs="0"/>
 *         &lt;element name="InstrPrty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Priority2Code" minOccurs="0"/>
 *         &lt;element name="ChqMtrtyDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="FrmsCd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text" minOccurs="0"/>
 *         &lt;element name="MemoFld" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="RgnlClrZone" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text" minOccurs="0"/>
 *         &lt;element name="PrtLctn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text" minOccurs="0"/>
 *         &lt;element name="Sgntr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max70Text" maxOccurs="5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cheque11__1", propOrder = {
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
public class Cheque111 {

    @XmlElement(name = "ChqTp")
    @XmlSchemaType(name = "string")
    protected ChequeType2Code1 chqTp;
    @XmlElement(name = "ChqNb")
    protected String chqNb;
    @XmlElement(name = "ChqFr")
    protected NameAndAddress161 chqFr;
    @XmlElement(name = "DlvryMtd")
    protected ChequeDeliveryMethod1Choice dlvryMtd;
    @XmlElement(name = "DlvrTo")
    protected NameAndAddress161 dlvrTo;
    @XmlElement(name = "InstrPrty")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "ChqMtrtyDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar chqMtrtyDt;
    @XmlElement(name = "FrmsCd")
    protected String frmsCd;
    @XmlElement(name = "MemoFld")
    protected List<String> memoFld;
    @XmlElement(name = "RgnlClrZone")
    protected String rgnlClrZone;
    @XmlElement(name = "PrtLctn")
    protected String prtLctn;
    @XmlElement(name = "Sgntr")
    protected List<String> sgntr;

    /**
     * 获取chqTp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChequeType2Code1 }
     *     
     */
    public ChequeType2Code1 getChqTp() {
        return chqTp;
    }

    /**
     * 设置chqTp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChequeType2Code1 }
     *     
     */
    public void setChqTp(ChequeType2Code1 value) {
        this.chqTp = value;
    }

    /**
     * 获取chqNb属性的值。
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
     * 设置chqNb属性的值。
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
     * 获取chqFr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress161 }
     *     
     */
    public NameAndAddress161 getChqFr() {
        return chqFr;
    }

    /**
     * 设置chqFr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress161 }
     *     
     */
    public void setChqFr(NameAndAddress161 value) {
        this.chqFr = value;
    }

    /**
     * 获取dlvryMtd属性的值。
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
     * 设置dlvryMtd属性的值。
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
     * 获取dlvrTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress161 }
     *     
     */
    public NameAndAddress161 getDlvrTo() {
        return dlvrTo;
    }

    /**
     * 设置dlvrTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress161 }
     *     
     */
    public void setDlvrTo(NameAndAddress161 value) {
        this.dlvrTo = value;
    }

    /**
     * 获取instrPrty属性的值。
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
     * 设置instrPrty属性的值。
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
     * 获取chqMtrtyDt属性的值。
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
     * 设置chqMtrtyDt属性的值。
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
     * 获取frmsCd属性的值。
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
     * 设置frmsCd属性的值。
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
     * 获取rgnlClrZone属性的值。
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
     * 设置rgnlClrZone属性的值。
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
     * 获取prtLctn属性的值。
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
     * 设置prtLctn属性的值。
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
