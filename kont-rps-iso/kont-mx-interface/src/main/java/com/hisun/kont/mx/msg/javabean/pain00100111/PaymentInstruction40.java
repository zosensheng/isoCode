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
 * Characteristics that apply to the debit side of the payment transactions included in the credit transfer initiation.
 * 
 * <p>PaymentInstruction40 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentInstruction40">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text"/>
 *         &lt;element name="PmtMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentMethod3Code"/>
 *         &lt;element name="ReqdAdvcTp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}AdviceType1" minOccurs="0"/>
 *         &lt;element name="BtchBookg" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BatchBookingIndicator" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="CtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentTypeInformation26" minOccurs="0"/>
 *         &lt;element name="ReqdExctnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}DateAndDateTime2Choice"/>
 *         &lt;element name="PoolgAdjstmntDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="ChrgsAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="ChrgsAcctAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtTrfTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CreditTransferTransaction54" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstruction40", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "reqdAdvcTp",
    "btchBookg",
    "nbOfTxs",
    "ctrlSum",
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
public class PaymentInstruction40 {

    @XmlElement(name = "PmtInfId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod3Code pmtMtd;
    @XmlElement(name = "ReqdAdvcTp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected AdviceType1 reqdAdvcTp;
    @XmlElement(name = "BtchBookg", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected Boolean btchBookg;
    @XmlElement(name = "NbOfTxs", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BigDecimal ctrlSum;
    @XmlElement(name = "PmtTpInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PaymentTypeInformation26 pmtTpInf;
    @XmlElement(name = "ReqdExctnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected DateAndDateTime2Choice reqdExctnDt;
    @XmlElement(name = "PoolgAdjstmntDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar poolgAdjstmntDt;
    @XmlElement(name = "Dbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected PartyIdentification135 dbtr;
    @XmlElement(name = "DbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected CashAccount40 dbtrAcct;
    @XmlElement(name = "DbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "InstrForDbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String instrForDbtrAgt;
    @XmlElement(name = "UltmtDbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 ultmtDbtr;
    @XmlElement(name = "ChrgBr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code chrgBr;
    @XmlElement(name = "ChrgsAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 chrgsAcct;
    @XmlElement(name = "ChrgsAcctAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 chrgsAcctAgt;
    @XmlElement(name = "CdtTrfTxInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected List<CreditTransferTransaction54> cdtTrfTxInf;

    /**
     * 获取属性 pmtInfId 的值。
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
     * 设置属性 pmtInfId 的值。
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
     * 获取属性 pmtMtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod3Code }
     *     
     */
    public PaymentMethod3Code getPmtMtd() {
        return pmtMtd;
    }

    /**
     * 设置属性 pmtMtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod3Code }
     *     
     */
    public void setPmtMtd(PaymentMethod3Code value) {
        this.pmtMtd = value;
    }

    /**
     * 获取属性 reqdAdvcTp 的值。
     * 
     * @return
     *     possible object is
     *     {@link AdviceType1 }
     *     
     */
    public AdviceType1 getReqdAdvcTp() {
        return reqdAdvcTp;
    }

    /**
     * 设置属性 reqdAdvcTp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AdviceType1 }
     *     
     */
    public void setReqdAdvcTp(AdviceType1 value) {
        this.reqdAdvcTp = value;
    }

    /**
     * 获取属性 btchBookg 的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBtchBookg() {
        return btchBookg;
    }

    /**
     * 设置属性 btchBookg 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBtchBookg(Boolean value) {
        this.btchBookg = value;
    }

    /**
     * 获取属性 nbOfTxs 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * 设置属性 nbOfTxs 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * 获取属性 ctrlSum 的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * 设置属性 ctrlSum 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * 获取属性 pmtTpInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation26 }
     *     
     */
    public PaymentTypeInformation26 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置属性 pmtTpInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation26 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation26 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取属性 reqdExctnDt 的值。
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
     * 设置属性 reqdExctnDt 的值。
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
     * 获取属性 poolgAdjstmntDt 的值。
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
     * 设置属性 poolgAdjstmntDt 的值。
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
     * 获取属性 dbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getDbtr() {
        return dbtr;
    }

    /**
     * 设置属性 dbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setDbtr(PartyIdentification135 value) {
        this.dbtr = value;
    }

    /**
     * 获取属性 dbtrAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置属性 dbtrAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAcct(CashAccount40 value) {
        this.dbtrAcct = value;
    }

    /**
     * 获取属性 dbtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置属性 dbtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取属性 dbtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置属性 dbtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount40 value) {
        this.dbtrAgtAcct = value;
    }

    /**
     * 获取属性 instrForDbtrAgt 的值。
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
     * 设置属性 instrForDbtrAgt 的值。
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
     * 获取属性 ultmtDbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置属性 ultmtDbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setUltmtDbtr(PartyIdentification135 value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取属性 chrgBr 的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public ChargeBearerType1Code getChrgBr() {
        return chrgBr;
    }

    /**
     * 设置属性 chrgBr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code value) {
        this.chrgBr = value;
    }

    /**
     * 获取属性 chrgsAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getChrgsAcct() {
        return chrgsAcct;
    }

    /**
     * 设置属性 chrgsAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setChrgsAcct(CashAccount40 value) {
        this.chrgsAcct = value;
    }

    /**
     * 获取属性 chrgsAcctAgt 的值。
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
     * 设置属性 chrgsAcctAgt 的值。
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
     * Gets the value of the cdtTrfTxInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdtTrfTxInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdtTrfTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditTransferTransaction54 }
     * 
     * 
     */
    public List<CreditTransferTransaction54> getCdtTrfTxInf() {
        if (cdtTrfTxInf == null) {
            cdtTrfTxInf = new ArrayList<CreditTransferTransaction54>();
        }
        return this.cdtTrfTxInf;
    }

}
