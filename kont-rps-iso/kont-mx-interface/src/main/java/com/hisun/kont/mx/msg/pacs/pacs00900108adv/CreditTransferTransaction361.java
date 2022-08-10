//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108adv;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>CreditTransferTransaction36__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction36__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PaymentIdentification7__1"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PaymentTypeInformation28__1" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_Amount"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}ISODate"/>
 *         &lt;element name="SttlmPrty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}Priority3Code" minOccurs="0"/>
 *         &lt;element name="SttlmTmIndctn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}SettlementDateTimeIndication1__1" minOccurs="0"/>
 *         &lt;element name="SttlmTmReq" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}SettlementTimeRequest2__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="InstgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="InstdAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="InstrForCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}InstructionForCreditorAgent2__1" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="InstrForNxtAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}InstructionForNextAgent1__1" maxOccurs="6" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}Purpose2Choice__1" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}RemittanceInformation2__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction36__1", propOrder = {
    "pmtId",
    "pmtTpInf",
    "intrBkSttlmAmt",
    "intrBkSttlmDt",
    "sttlmPrty",
    "sttlmTmIndctn",
    "sttlmTmReq",
    "prvsInstgAgt1",
    "prvsInstgAgt1Acct",
    "prvsInstgAgt2",
    "prvsInstgAgt2Acct",
    "prvsInstgAgt3",
    "prvsInstgAgt3Acct",
    "instgAgt",
    "instdAgt",
    "intrmyAgt1",
    "intrmyAgt1Acct",
    "intrmyAgt2",
    "intrmyAgt2Acct",
    "intrmyAgt3",
    "intrmyAgt3Acct",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "instrForCdtrAgt",
    "instrForNxtAgt",
    "purp",
    "rmtInf"
})
public class CreditTransferTransaction361 {

    @XmlElement(name = "PmtId", required = true)
    protected PaymentIdentification71 pmtId;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation281 pmtTpInf;
    @XmlElement(name = "IntrBkSttlmAmt", required = true)
    protected CBPRAmount intrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "SttlmPrty")
    @XmlSchemaType(name = "string")
    protected Priority3Code sttlmPrty;
    @XmlElement(name = "SttlmTmIndctn")
    protected SettlementDateTimeIndication11 sttlmTmIndctn;
    @XmlElement(name = "SttlmTmReq")
    protected SettlementTimeRequest21 sttlmTmReq;
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
    @XmlElement(name = "InstgAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification62 instgAgt;
    @XmlElement(name = "InstdAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification62 instdAgt;
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
    @XmlElement(name = "Dbtr", required = true)
    protected BranchAndFinancialInstitutionIdentification61 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount381 dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification61 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount381 dbtrAgtAcct;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification61 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount381 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected BranchAndFinancialInstitutionIdentification61 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount381 cdtrAcct;
    @XmlElement(name = "InstrForCdtrAgt")
    protected List<InstructionForCreditorAgent21> instrForCdtrAgt;
    @XmlElement(name = "InstrForNxtAgt")
    protected List<InstructionForNextAgent11> instrForNxtAgt;
    @XmlElement(name = "Purp")
    protected Purpose2Choice1 purp;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation21 rmtInf;

    /**
     * 获取pmtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentIdentification71 }
     *     
     */
    public PaymentIdentification71 getPmtId() {
        return pmtId;
    }

    /**
     * 设置pmtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentIdentification71 }
     *     
     */
    public void setPmtId(PaymentIdentification71 value) {
        this.pmtId = value;
    }

    /**
     * 获取pmtTpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation281 }
     *     
     */
    public PaymentTypeInformation281 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置pmtTpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation281 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation281 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取intrBkSttlmAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount }
     *     
     */
    public CBPRAmount getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    /**
     * 设置intrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount }
     *     
     */
    public void setIntrBkSttlmAmt(CBPRAmount value) {
        this.intrBkSttlmAmt = value;
    }

    /**
     * 获取intrBkSttlmDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIntrBkSttlmDt() {
        return intrBkSttlmDt;
    }

    /**
     * 设置intrBkSttlmDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.intrBkSttlmDt = value;
    }

    /**
     * 获取sttlmPrty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Priority3Code }
     *     
     */
    public Priority3Code getSttlmPrty() {
        return sttlmPrty;
    }

    /**
     * 设置sttlmPrty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Priority3Code }
     *     
     */
    public void setSttlmPrty(Priority3Code value) {
        this.sttlmPrty = value;
    }

    /**
     * 获取sttlmTmIndctn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementDateTimeIndication11 }
     *     
     */
    public SettlementDateTimeIndication11 getSttlmTmIndctn() {
        return sttlmTmIndctn;
    }

    /**
     * 设置sttlmTmIndctn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDateTimeIndication11 }
     *     
     */
    public void setSttlmTmIndctn(SettlementDateTimeIndication11 value) {
        this.sttlmTmIndctn = value;
    }

    /**
     * 获取sttlmTmReq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementTimeRequest21 }
     *     
     */
    public SettlementTimeRequest21 getSttlmTmReq() {
        return sttlmTmReq;
    }

    /**
     * 设置sttlmTmReq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementTimeRequest21 }
     *     
     */
    public void setSttlmTmReq(SettlementTimeRequest21 value) {
        this.sttlmTmReq = value;
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
     * 获取instgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getInstgAgt() {
        return instgAgt;
    }

    /**
     * 设置instgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setInstgAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.instgAgt = value;
    }

    /**
     * 获取instdAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getInstdAgt() {
        return instdAgt;
    }

    /**
     * 设置instdAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setInstdAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.instdAgt = value;
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
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setDbtr(BranchAndFinancialInstitutionIdentification61 value) {
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
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification61 value) {
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
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setCdtr(BranchAndFinancialInstitutionIdentification61 value) {
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
     * {@link InstructionForCreditorAgent21 }
     * 
     * 
     */
    public List<InstructionForCreditorAgent21> getInstrForCdtrAgt() {
        if (instrForCdtrAgt == null) {
            instrForCdtrAgt = new ArrayList<InstructionForCreditorAgent21>();
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
     * 获取purp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice1 }
     *     
     */
    public Purpose2Choice1 getPurp() {
        return purp;
    }

    /**
     * 设置purp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice1 }
     *     
     */
    public void setPurp(Purpose2Choice1 value) {
        this.purp = value;
    }

    /**
     * 获取rmtInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public RemittanceInformation21 getRmtInf() {
        return rmtInf;
    }

    /**
     * 设置rmtInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public void setRmtInf(RemittanceInformation21 value) {
        this.rmtInf = value;
    }

}
