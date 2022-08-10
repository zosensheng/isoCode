//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionParties6__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionParties6__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__2" minOccurs="0"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CashAccount38__3" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__3" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__3" minOccurs="0"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CashAccount38__3" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__3" minOccurs="0"/>
 *         &lt;element name="TradgPty" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Party40Choice__3" minOccurs="0"/>
 *         &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ProprietaryParty5__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionParties6__1", propOrder = {
    "initgPty",
    "dbtr",
    "dbtrAcct",
    "ultmtDbtr",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr",
    "tradgPty",
    "prtry"
})
public class TransactionParties61 {

    @XmlElement(name = "InitgPty")
    protected Party40Choice1 initgPty;
    @XmlElement(name = "Dbtr")
    protected Party40Choice2 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount383 dbtrAcct;
    @XmlElement(name = "UltmtDbtr")
    protected Party40Choice3 ultmtDbtr;
    @XmlElement(name = "Cdtr")
    protected Party40Choice3 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount383 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected Party40Choice3 ultmtCdtr;
    @XmlElement(name = "TradgPty")
    protected Party40Choice3 tradgPty;
    @XmlElement(name = "Prtry")
    protected List<ProprietaryParty51> prtry;

    /**
     * 获取initgPty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getInitgPty() {
        return initgPty;
    }

    /**
     * 设置initgPty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setInitgPty(Party40Choice1 value) {
        this.initgPty = value;
    }

    /**
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice2 }
     *     
     */
    public Party40Choice2 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice2 }
     *     
     */
    public void setDbtr(Party40Choice2 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount383 }
     *     
     */
    public CashAccount383 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount383 }
     *     
     */
    public void setDbtrAcct(CashAccount383 value) {
        this.dbtrAcct = value;
    }

    /**
     * 获取ultmtDbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice3 }
     *     
     */
    public Party40Choice3 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置ultmtDbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice3 }
     *     
     */
    public void setUltmtDbtr(Party40Choice3 value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice3 }
     *     
     */
    public Party40Choice3 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice3 }
     *     
     */
    public void setCdtr(Party40Choice3 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount383 }
     *     
     */
    public CashAccount383 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount383 }
     *     
     */
    public void setCdtrAcct(CashAccount383 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取ultmtCdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice3 }
     *     
     */
    public Party40Choice3 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置ultmtCdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice3 }
     *     
     */
    public void setUltmtCdtr(Party40Choice3 value) {
        this.ultmtCdtr = value;
    }

    /**
     * 获取tradgPty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice3 }
     *     
     */
    public Party40Choice3 getTradgPty() {
        return tradgPty;
    }

    /**
     * 设置tradgPty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice3 }
     *     
     */
    public void setTradgPty(Party40Choice3 value) {
        this.tradgPty = value;
    }

    /**
     * Gets the value of the prtry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProprietaryParty51 }
     * 
     * 
     */
    public List<ProprietaryParty51> getPrtry() {
        if (prtry == null) {
            prtry = new ArrayList<ProprietaryParty51>();
        }
        return this.prtry;
    }

}
