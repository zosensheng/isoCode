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


/**
 * Provide further details specific to the individual transaction(s) included in the message.
 * 
 * <p>CreditTransferTransaction54 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction54">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentIdentification6"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentTypeInformation26" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}AmountType4Choice"/>
 *         &lt;element name="XchgRateInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ExchangeRate1" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="MndtRltdInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CreditTransferMandateData1" minOccurs="0"/>
 *         &lt;element name="ChqInstr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Cheque11" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CashAccount40" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="InstrForCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}InstructionForCreditorAgent3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}InstructionForDebtorAgent1" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Purpose2Choice" minOccurs="0"/>
 *         &lt;element name="RgltryRptg" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RegulatoryReporting3" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="Tax" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}TaxInformation10" minOccurs="0"/>
 *         &lt;element name="RltdRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RemittanceLocation7" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RemittanceInformation21" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction54", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "pmtId",
    "pmtTpInf",
    "amt",
    "xchgRateInf",
    "chrgBr",
    "mndtRltdInf",
    "chqInstr",
    "ultmtDbtr",
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
    "instrForDbtrAgt",
    "purp",
    "rgltryRptg",
    "tax",
    "rltdRmtInf",
    "rmtInf",
    "splmtryData"
})
public class CreditTransferTransaction54 {

    @XmlElement(name = "PmtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected PaymentIdentification6 pmtId;
    @XmlElement(name = "PmtTpInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PaymentTypeInformation26 pmtTpInf;
    @XmlElement(name = "Amt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected AmountType4Choice amt;
    @XmlElement(name = "XchgRateInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ExchangeRate1 xchgRateInf;
    @XmlElement(name = "ChrgBr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code chrgBr;
    @XmlElement(name = "MndtRltdInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CreditTransferMandateData1 mndtRltdInf;
    @XmlElement(name = "ChqInstr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected Cheque11 chqInstr;
    @XmlElement(name = "UltmtDbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 ultmtDbtr;
    @XmlElement(name = "IntrmyAgt1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 cdtr;
    @XmlElement(name = "CdtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CashAccount40 cdtrAcct;
    @XmlElement(name = "UltmtCdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PartyIdentification135 ultmtCdtr;
    @XmlElement(name = "InstrForCdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<InstructionForCreditorAgent3> instrForCdtrAgt;
    @XmlElement(name = "InstrForDbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected InstructionForDebtorAgent1 instrForDbtrAgt;
    @XmlElement(name = "Purp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected Purpose2Choice purp;
    @XmlElement(name = "RgltryRptg", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<RegulatoryReporting3> rgltryRptg;
    @XmlElement(name = "Tax", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected TaxInformation10 tax;
    @XmlElement(name = "RltdRmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<RemittanceLocation7> rltdRmtInf;
    @XmlElement(name = "RmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected RemittanceInformation21 rmtInf;
    @XmlElement(name = "SplmtryData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<SupplementaryData1> splmtryData;

    /**
     * 获取属性 pmtId 的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentIdentification6 }
     *     
     */
    public PaymentIdentification6 getPmtId() {
        return pmtId;
    }

    /**
     * 设置属性 pmtId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentIdentification6 }
     *     
     */
    public void setPmtId(PaymentIdentification6 value) {
        this.pmtId = value;
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
     * 获取属性 amt 的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountType4Choice }
     *     
     */
    public AmountType4Choice getAmt() {
        return amt;
    }

    /**
     * 设置属性 amt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType4Choice }
     *     
     */
    public void setAmt(AmountType4Choice value) {
        this.amt = value;
    }

    /**
     * 获取属性 xchgRateInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link ExchangeRate1 }
     *     
     */
    public ExchangeRate1 getXchgRateInf() {
        return xchgRateInf;
    }

    /**
     * 设置属性 xchgRateInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangeRate1 }
     *     
     */
    public void setXchgRateInf(ExchangeRate1 value) {
        this.xchgRateInf = value;
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
     * 获取属性 mndtRltdInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public CreditTransferMandateData1 getMndtRltdInf() {
        return mndtRltdInf;
    }

    /**
     * 设置属性 mndtRltdInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public void setMndtRltdInf(CreditTransferMandateData1 value) {
        this.mndtRltdInf = value;
    }

    /**
     * 获取属性 chqInstr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Cheque11 }
     *     
     */
    public Cheque11 getChqInstr() {
        return chqInstr;
    }

    /**
     * 设置属性 chqInstr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Cheque11 }
     *     
     */
    public void setChqInstr(Cheque11 value) {
        this.chqInstr = value;
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
     * 获取属性 intrmyAgt1 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * 设置属性 intrmyAgt1 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt1 = value;
    }

    /**
     * 获取属性 intrmyAgt1Acct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt1Acct() {
        return intrmyAgt1Acct;
    }

    /**
     * 设置属性 intrmyAgt1Acct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt1Acct(CashAccount40 value) {
        this.intrmyAgt1Acct = value;
    }

    /**
     * 获取属性 intrmyAgt2 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * 设置属性 intrmyAgt2 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * 获取属性 intrmyAgt2Acct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt2Acct() {
        return intrmyAgt2Acct;
    }

    /**
     * 设置属性 intrmyAgt2Acct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt2Acct(CashAccount40 value) {
        this.intrmyAgt2Acct = value;
    }

    /**
     * 获取属性 intrmyAgt3 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * 设置属性 intrmyAgt3 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * 获取属性 intrmyAgt3Acct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt3Acct() {
        return intrmyAgt3Acct;
    }

    /**
     * 设置属性 intrmyAgt3Acct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt3Acct(CashAccount40 value) {
        this.intrmyAgt3Acct = value;
    }

    /**
     * 获取属性 cdtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置属性 cdtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.cdtrAgt = value;
    }

    /**
     * 获取属性 cdtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置属性 cdtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount40 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取属性 cdtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getCdtr() {
        return cdtr;
    }

    /**
     * 设置属性 cdtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setCdtr(PartyIdentification135 value) {
        this.cdtr = value;
    }

    /**
     * 获取属性 cdtrAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置属性 cdtrAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAcct(CashAccount40 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取属性 ultmtCdtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置属性 ultmtCdtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setUltmtCdtr(PartyIdentification135 value) {
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
     * {@link InstructionForCreditorAgent3 }
     * 
     * 
     */
    public List<InstructionForCreditorAgent3> getInstrForCdtrAgt() {
        if (instrForCdtrAgt == null) {
            instrForCdtrAgt = new ArrayList<InstructionForCreditorAgent3>();
        }
        return this.instrForCdtrAgt;
    }

    /**
     * 获取属性 instrForDbtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link InstructionForDebtorAgent1 }
     *     
     */
    public InstructionForDebtorAgent1 getInstrForDbtrAgt() {
        return instrForDbtrAgt;
    }

    /**
     * 设置属性 instrForDbtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InstructionForDebtorAgent1 }
     *     
     */
    public void setInstrForDbtrAgt(InstructionForDebtorAgent1 value) {
        this.instrForDbtrAgt = value;
    }

    /**
     * 获取属性 purp 的值。
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice }
     *     
     */
    public Purpose2Choice getPurp() {
        return purp;
    }

    /**
     * 设置属性 purp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice }
     *     
     */
    public void setPurp(Purpose2Choice value) {
        this.purp = value;
    }

    /**
     * Gets the value of the rgltryRptg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rgltryRptg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRgltryRptg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegulatoryReporting3 }
     * 
     * 
     */
    public List<RegulatoryReporting3> getRgltryRptg() {
        if (rgltryRptg == null) {
            rgltryRptg = new ArrayList<RegulatoryReporting3>();
        }
        return this.rgltryRptg;
    }

    /**
     * 获取属性 tax 的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation10 }
     *     
     */
    public TaxInformation10 getTax() {
        return tax;
    }

    /**
     * 设置属性 tax 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation10 }
     *     
     */
    public void setTax(TaxInformation10 value) {
        this.tax = value;
    }

    /**
     * Gets the value of the rltdRmtInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rltdRmtInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRltdRmtInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemittanceLocation7 }
     * 
     * 
     */
    public List<RemittanceLocation7> getRltdRmtInf() {
        if (rltdRmtInf == null) {
            rltdRmtInf = new ArrayList<RemittanceLocation7>();
        }
        return this.rltdRmtInf;
    }

    /**
     * 获取属性 rmtInf 的值。
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
     * 设置属性 rmtInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public void setRmtInf(RemittanceInformation21 value) {
        this.rmtInf = value;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
