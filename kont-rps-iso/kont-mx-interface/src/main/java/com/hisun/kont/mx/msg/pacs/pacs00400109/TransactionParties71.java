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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionParties7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionParties7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__2"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__1" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__3" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__3"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionParties7__1", propOrder = {
    "ultmtDbtr",
    "dbtr",
    "initgPty",
    "dbtrAgt",
    "prvsInstgAgt1",
    "prvsInstgAgt2",
    "prvsInstgAgt3",
    "intrmyAgt1",
    "intrmyAgt2",
    "intrmyAgt3",
    "cdtrAgt",
    "cdtr",
    "ultmtCdtr"
})
public class TransactionParties71 {

    @XmlElement(name = "UltmtDbtr")
    protected Party40Choice1 ultmtDbtr;
    @XmlElement(name = "Dbtr", required = true)
    protected Party40Choice2 dbtr;
    @XmlElement(name = "InitgPty")
    protected Party40Choice1 initgPty;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification61 dbtrAgt;
    @XmlElement(name = "PrvsInstgAgt1")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1;
    @XmlElement(name = "PrvsInstgAgt2")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2;
    @XmlElement(name = "PrvsInstgAgt3")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt3;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification63 cdtrAgt;
    @XmlElement(name = "Cdtr", required = true)
    protected Party40Choice3 cdtr;
    @XmlElement(name = "UltmtCdtr")
    protected Party40Choice4 ultmtCdtr;

    /**
     * 获取ultmtDbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置ultmtDbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setUltmtDbtr(Party40Choice1 value) {
        this.ultmtDbtr = value;
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
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取prvsInstgAgt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getPrvsInstgAgt1() {
        return prvsInstgAgt1;
    }

    /**
     * 设置prvsInstgAgt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setPrvsInstgAgt1(BranchAndFinancialInstitutionIdentification61 value) {
        this.prvsInstgAgt1 = value;
    }

    /**
     * 获取prvsInstgAgt2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getPrvsInstgAgt2() {
        return prvsInstgAgt2;
    }

    /**
     * 设置prvsInstgAgt2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setPrvsInstgAgt2(BranchAndFinancialInstitutionIdentification61 value) {
        this.prvsInstgAgt2 = value;
    }

    /**
     * 获取prvsInstgAgt3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getPrvsInstgAgt3() {
        return prvsInstgAgt3;
    }

    /**
     * 设置prvsInstgAgt3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setPrvsInstgAgt3(BranchAndFinancialInstitutionIdentification61 value) {
        this.prvsInstgAgt3 = value;
    }

    /**
     * 获取intrmyAgt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * 设置intrmyAgt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification61 value) {
        this.intrmyAgt1 = value;
    }

    /**
     * 获取intrmyAgt2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * 设置intrmyAgt2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification61 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * 获取intrmyAgt3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * 设置intrmyAgt3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification61 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification63 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification63 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification63 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification63 value) {
        this.cdtrAgt = value;
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
     * 获取ultmtCdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice4 }
     *     
     */
    public Party40Choice4 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置ultmtCdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice4 }
     *     
     */
    public void setUltmtCdtr(Party40Choice4 value) {
        this.ultmtCdtr = value;
    }

}
