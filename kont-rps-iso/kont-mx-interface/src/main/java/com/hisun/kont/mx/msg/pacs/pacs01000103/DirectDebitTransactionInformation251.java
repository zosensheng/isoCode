//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:39 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs01000103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>DirectDebitTransactionInformation25__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DirectDebitTransactionInformation25__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}PaymentIdentification7__1"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}PaymentTypeInformation28__1" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}ActiveCurrencyAndAmount"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}ISODate"/>
 *         &lt;element name="SttlmTmReq" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}SettlementTimeRequest2__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CashAccount38__2" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CashAccount38__2" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CBPR_RestrictedFINXMax210Text" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}Purpose2Choice__1" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}RemittanceInformation2__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectDebitTransactionInformation25__1", propOrder = {
    "pmtId",
    "pmtTpInf",
    "intrBkSttlmAmt",
    "intrBkSttlmDt",
    "sttlmTmReq",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "instrForDbtrAgt",
    "purp",
    "rmtInf"
})
public class DirectDebitTransactionInformation251 {

    @XmlElement(name = "PmtId", required = true)
    protected PaymentIdentification71 pmtId;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation281 pmtTpInf;
    @XmlElement(name = "IntrBkSttlmAmt", required = true)
    protected ActiveCurrencyAndAmount intrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "SttlmTmReq")
    protected SettlementTimeRequest21 sttlmTmReq;
    @XmlElement(name = "Dbtr", required = true)
    protected BranchAndFinancialInstitutionIdentification62 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount382 dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification62 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount382 dbtrAgtAcct;
    @XmlElement(name = "InstrForDbtrAgt")
    protected String instrForDbtrAgt;
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
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    /**
     * 设置intrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setIntrBkSttlmAmt(ActiveCurrencyAndAmount value) {
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
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setDbtr(BranchAndFinancialInstitutionIdentification62 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount382 }
     *     
     */
    public CashAccount382 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount382 }
     *     
     */
    public void setDbtrAcct(CashAccount382 value) {
        this.dbtrAcct = value;
    }

    /**
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取dbtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount382 }
     *     
     */
    public CashAccount382 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置dbtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount382 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount382 value) {
        this.dbtrAgtAcct = value;
    }

    /**
     * 获取instrForDbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrForDbtrAgt() {
        return instrForDbtrAgt;
    }

    /**
     * 设置instrForDbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrForDbtrAgt(String value) {
        this.instrForDbtrAgt = value;
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
