//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108cov;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreditTransferTransaction37__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction37__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PartyIdentification135__1" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PartyIdentification135__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PartyIdentification135__2"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__3"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PartyIdentification135__3"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PartyIdentification135__4" minOccurs="0"/>
 *         &lt;element name="InstrForCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}InstructionForCreditorAgent1__1" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="InstrForNxtAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}InstructionForNextAgent1__1" maxOccurs="6" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}RemittanceInformation16__1" minOccurs="0"/>
 *         &lt;element name="InstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_Amount__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction37__1", propOrder = {
    "ultmtDbtr",
    "initgPty",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "prvsInstgAgt1",
    "prvsInstgAgt1Acct",
    "prvsInstgAgt2",
    "prvsInstgAgt2Acct",
    "prvsInstgAgt3",
    "prvsInstgAgt3Acct",
    "intrmyAgt1",
    "intrmyAgt1Acct",
    "intrmyAgt2",
    "intrmyAgt2Acct",
    "intrmyAgt3",
    "intrmyAgt3Acct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr",
    "instrForCdtrAgt",
    "instrForNxtAgt",
    "rmtInf",
    "instdAmt"
})
public class CreditTransferTransaction371 {

    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentification1351 ultmtDbtr;
    @XmlElement(name = "InitgPty")
    protected PartyIdentification1351 initgPty;
    @XmlElement(name = "Dbtr", required = true)
    protected PartyIdentification1352 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount381 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount381 dbtrAgtAcct;
    @XmlElement(name = "PrvsInstgAgt1")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1;
    @XmlElement(name = "PrvsInstgAgt1Acct")
    protected CashAccount381 prvsInstgAgt1Acct;
    @XmlElement(name = "PrvsInstgAgt2")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2;
    @XmlElement(name = "PrvsInstgAgt2Acct")
    protected CashAccount381 prvsInstgAgt2Acct;
    @XmlElement(name = "PrvsInstgAgt3")
    protected BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3;
    @XmlElement(name = "PrvsInstgAgt3Acct")
    protected CashAccount381 prvsInstgAgt3Acct;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct")
    protected CashAccount381 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct")
    protected CashAccount381 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct")
    protected CashAccount381 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification63 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount381 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentification1353 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount381 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentification1354 ultmtCdtr;
    @XmlElement(name = "InstrForCdtrAgt")
    protected List<InstructionForCreditorAgent11> instrForCdtrAgt;
    @XmlElement(name = "InstrForNxtAgt")
    protected List<InstructionForNextAgent11> instrForNxtAgt;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation161 rmtInf;
    @XmlElement(name = "InstdAmt")
    protected CBPRAmount1 instdAmt;

    /**
     * 获取ultmtDbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public PartyIdentification1351 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置ultmtDbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public void setUltmtDbtr(PartyIdentification1351 value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取initgPty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public PartyIdentification1351 getInitgPty() {
        return initgPty;
    }

    /**
     * 设置initgPty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public void setInitgPty(PartyIdentification1351 value) {
        this.initgPty = value;
    }

    /**
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public PartyIdentification1352 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public void setDbtr(PartyIdentification1352 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setDbtrAcct(CashAccount381 value) {
        this.dbtrAcct = value;
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
     * 获取dbtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置dbtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount381 value) {
        this.dbtrAgtAcct = value;
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
     * 获取prvsInstgAgt1Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getPrvsInstgAgt1Acct() {
        return prvsInstgAgt1Acct;
    }

    /**
     * 设置prvsInstgAgt1Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setPrvsInstgAgt1Acct(CashAccount381 value) {
        this.prvsInstgAgt1Acct = value;
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
     * 获取prvsInstgAgt2Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getPrvsInstgAgt2Acct() {
        return prvsInstgAgt2Acct;
    }

    /**
     * 设置prvsInstgAgt2Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setPrvsInstgAgt2Acct(CashAccount381 value) {
        this.prvsInstgAgt2Acct = value;
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
     * 获取prvsInstgAgt3Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getPrvsInstgAgt3Acct() {
        return prvsInstgAgt3Acct;
    }

    /**
     * 设置prvsInstgAgt3Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setPrvsInstgAgt3Acct(CashAccount381 value) {
        this.prvsInstgAgt3Acct = value;
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
     * 获取intrmyAgt1Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getIntrmyAgt1Acct() {
        return intrmyAgt1Acct;
    }

    /**
     * 设置intrmyAgt1Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setIntrmyAgt1Acct(CashAccount381 value) {
        this.intrmyAgt1Acct = value;
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
     * 获取intrmyAgt2Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getIntrmyAgt2Acct() {
        return intrmyAgt2Acct;
    }

    /**
     * 设置intrmyAgt2Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setIntrmyAgt2Acct(CashAccount381 value) {
        this.intrmyAgt2Acct = value;
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
     * 获取intrmyAgt3Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getIntrmyAgt3Acct() {
        return intrmyAgt3Acct;
    }

    /**
     * 设置intrmyAgt3Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setIntrmyAgt3Acct(CashAccount381 value) {
        this.intrmyAgt3Acct = value;
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
     * 获取cdtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置cdtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount381 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public PartyIdentification1353 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public void setCdtr(PartyIdentification1353 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setCdtrAcct(CashAccount381 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取ultmtCdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public PartyIdentification1354 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置ultmtCdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public void setUltmtCdtr(PartyIdentification1354 value) {
        this.ultmtCdtr = value;
    }

    /**
     * Gets the value of the instrForCdtrAgt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrForCdtrAgt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrForCdtrAgt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstructionForCreditorAgent11 }
     * 
     * 
     */
    public List<InstructionForCreditorAgent11> getInstrForCdtrAgt() {
        if (instrForCdtrAgt == null) {
            instrForCdtrAgt = new ArrayList<InstructionForCreditorAgent11>();
        }
        return this.instrForCdtrAgt;
    }

    /**
     * Gets the value of the instrForNxtAgt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrForNxtAgt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrForNxtAgt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InstructionForNextAgent11 }
     * 
     * 
     */
    public List<InstructionForNextAgent11> getInstrForNxtAgt() {
        if (instrForNxtAgt == null) {
            instrForNxtAgt = new ArrayList<InstructionForNextAgent11>();
        }
        return this.instrForNxtAgt;
    }

    /**
     * 获取rmtInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation161 }
     *     
     */
    public RemittanceInformation161 getRmtInf() {
        return rmtInf;
    }

    /**
     * 设置rmtInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation161 }
     *     
     */
    public void setRmtInf(RemittanceInformation161 value) {
        this.rmtInf = value;
    }

    /**
     * 获取instdAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getInstdAmt() {
        return instdAmt;
    }

    /**
     * 设置instdAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setInstdAmt(CBPRAmount1 value) {
        this.instdAmt = value;
    }

}
