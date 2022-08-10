//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00100109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>PaymentInstruction30__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentInstruction30__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max35Text"/>
 *         &lt;element name="PmtMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PaymentMethod3Code__1"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PaymentTypeInformation26__1" minOccurs="0"/>
 *         &lt;element name="ReqdExctnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}DateAndDateTime2Choice"/>
 *         &lt;element name="PoolgAdjstmntDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PartyIdentification135__2"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max140Text" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PartyIdentification135__3" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ChargeBearerType1Code__1" minOccurs="0"/>
 *         &lt;element name="ChrgsAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="ChrgsAcctAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtTrfTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CreditTransferTransaction34__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstruction30__1", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "pmtTpInf",
    "reqdExctnDt",
    "poolgAdjstmntDt",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "instrForDbtrAgt",
    "ultmtDbtr",
    "chrgBr",
    "chrgsAcct",
    "chrgsAcctAgt",
    "cdtTrfTxInf"
})
public class PaymentInstruction301 {

    @XmlElement(name = "PmtInfId", required = true)
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod3Code1 pmtMtd;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation261 pmtTpInf;
    @XmlElement(name = "ReqdExctnDt", required = true)
    protected DateAndDateTime2Choice reqdExctnDt;
    @XmlElement(name = "PoolgAdjstmntDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar poolgAdjstmntDt;
    @XmlElement(name = "Dbtr", required = true)
    protected PartyIdentification1352 dbtr;
    @XmlElement(name = "DbtrAcct", required = true)
    protected CashAccount38 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification62 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount38 dbtrAgtAcct;
    @XmlElement(name = "InstrForDbtrAgt")
    protected String instrForDbtrAgt;
    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentification1353 ultmtDbtr;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code1 chrgBr;
    @XmlElement(name = "ChrgsAcct")
    protected CashAccount38 chrgsAcct;
    @XmlElement(name = "ChrgsAcctAgt")
    protected BranchAndFinancialInstitutionIdentification6 chrgsAcctAgt;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected CreditTransferTransaction341 cdtTrfTxInf;

    /**
     * 获取pmtInfId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtInfId() {
        return pmtInfId;
    }

    /**
     * 设置pmtInfId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtInfId(String value) {
        this.pmtInfId = value;
    }

    /**
     * 获取pmtMtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod3Code1 }
     *     
     */
    public PaymentMethod3Code1 getPmtMtd() {
        return pmtMtd;
    }

    /**
     * 设置pmtMtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod3Code1 }
     *     
     */
    public void setPmtMtd(PaymentMethod3Code1 value) {
        this.pmtMtd = value;
    }

    /**
     * 获取pmtTpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation261 }
     *     
     */
    public PaymentTypeInformation261 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置pmtTpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation261 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation261 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取reqdExctnDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getReqdExctnDt() {
        return reqdExctnDt;
    }

    /**
     * 设置reqdExctnDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setReqdExctnDt(DateAndDateTime2Choice value) {
        this.reqdExctnDt = value;
    }

    /**
     * 获取poolgAdjstmntDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPoolgAdjstmntDt() {
        return poolgAdjstmntDt;
    }

    /**
     * 设置poolgAdjstmntDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPoolgAdjstmntDt(XMLGregorianCalendar value) {
        this.poolgAdjstmntDt = value;
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
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setDbtrAcct(CashAccount38 value) {
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
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置dbtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount38 value) {
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
     * 获取ultmtDbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public PartyIdentification1353 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置ultmtDbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public void setUltmtDbtr(PartyIdentification1353 value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取chrgBr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public ChargeBearerType1Code1 getChrgBr() {
        return chrgBr;
    }

    /**
     * 设置chrgBr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code1 value) {
        this.chrgBr = value;
    }

    /**
     * 获取chrgsAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getChrgsAcct() {
        return chrgsAcct;
    }

    /**
     * 设置chrgsAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setChrgsAcct(CashAccount38 value) {
        this.chrgsAcct = value;
    }

    /**
     * 获取chrgsAcctAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getChrgsAcctAgt() {
        return chrgsAcctAgt;
    }

    /**
     * 设置chrgsAcctAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setChrgsAcctAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.chrgsAcctAgt = value;
    }

    /**
     * 获取cdtTrfTxInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferTransaction341 }
     *     
     */
    public CreditTransferTransaction341 getCdtTrfTxInf() {
        return cdtTrfTxInf;
    }

    /**
     * 设置cdtTrfTxInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferTransaction341 }
     *     
     */
    public void setCdtTrfTxInf(CreditTransferTransaction341 value) {
        this.cdtTrfTxInf = value;
    }

}
