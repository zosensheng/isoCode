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


/**
 * <p>CreditTransferTransaction34__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction34__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PmtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PaymentIdentification6__1"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PaymentTypeInformation26__1" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}AmountType4Choice"/>
 *         &lt;element name="XchgRateInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ExchangeRate1" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}ChargeBearerType1Code__1" minOccurs="0"/>
 *         &lt;element name="ChqInstr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Cheque11__1" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PartyIdentification135__3" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}BranchAndFinancialInstitutionIdentification6__3" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PartyIdentification135__4"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PartyIdentification135__5" minOccurs="0"/>
 *         &lt;element name="InstrForCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}InstructionForCreditorAgent1" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="InstrForDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Max140Text" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}Purpose2Choice" minOccurs="0"/>
 *         &lt;element name="RgltryRptg" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}RegulatoryReporting3" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="Tax" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}TaxInformation8" minOccurs="0"/>
 *         &lt;element name="RltdRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}RemittanceLocation7" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}RemittanceInformation16__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction34__1", propOrder = {
    "pmtId",
    "pmtTpInf",
    "amt",
    "xchgRateInf",
    "chrgBr",
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
    "rmtInf"
})
public class CreditTransferTransaction341 {

    @XmlElement(name = "PmtId", required = true)
    protected PaymentIdentification61 pmtId;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation261 pmtTpInf;
    @XmlElement(name = "Amt", required = true)
    protected AmountType4Choice amt;
    @XmlElement(name = "XchgRateInf")
    protected ExchangeRate1 xchgRateInf;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code1 chrgBr;
    @XmlElement(name = "ChqInstr")
    protected Cheque111 chqInstr;
    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentification1353 ultmtDbtr;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification62 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct")
    protected CashAccount38 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification62 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct")
    protected CashAccount38 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification62 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct")
    protected CashAccount38 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification63 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount38 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentification1354 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount38 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentification1355 ultmtCdtr;
    @XmlElement(name = "InstrForCdtrAgt")
    protected List<InstructionForCreditorAgent1> instrForCdtrAgt;
    @XmlElement(name = "InstrForDbtrAgt")
    protected String instrForDbtrAgt;
    @XmlElement(name = "Purp")
    protected Purpose2Choice purp;
    @XmlElement(name = "RgltryRptg")
    protected List<RegulatoryReporting3> rgltryRptg;
    @XmlElement(name = "Tax")
    protected TaxInformation8 tax;
    @XmlElement(name = "RltdRmtInf")
    protected List<RemittanceLocation7> rltdRmtInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation161 rmtInf;

    /**
     * 获取pmtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentIdentification61 }
     *     
     */
    public PaymentIdentification61 getPmtId() {
        return pmtId;
    }

    /**
     * 设置pmtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentIdentification61 }
     *     
     */
    public void setPmtId(PaymentIdentification61 value) {
        this.pmtId = value;
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
     * 获取amt属性的值。
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
     * 设置amt属性的值。
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
     * 获取xchgRateInf属性的值。
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
     * 设置xchgRateInf属性的值。
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
     * 获取chqInstr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Cheque111 }
     *     
     */
    public Cheque111 getChqInstr() {
        return chqInstr;
    }

    /**
     * 设置chqInstr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Cheque111 }
     *     
     */
    public void setChqInstr(Cheque111 value) {
        this.chqInstr = value;
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
     * 获取intrmyAgt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * 设置intrmyAgt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification62 value) {
        this.intrmyAgt1 = value;
    }

    /**
     * 获取intrmyAgt1Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getIntrmyAgt1Acct() {
        return intrmyAgt1Acct;
    }

    /**
     * 设置intrmyAgt1Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setIntrmyAgt1Acct(CashAccount38 value) {
        this.intrmyAgt1Acct = value;
    }

    /**
     * 获取intrmyAgt2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * 设置intrmyAgt2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification62 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * 获取intrmyAgt2Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getIntrmyAgt2Acct() {
        return intrmyAgt2Acct;
    }

    /**
     * 设置intrmyAgt2Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setIntrmyAgt2Acct(CashAccount38 value) {
        this.intrmyAgt2Acct = value;
    }

    /**
     * 获取intrmyAgt3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * 设置intrmyAgt3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification62 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * 获取intrmyAgt3Acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getIntrmyAgt3Acct() {
        return intrmyAgt3Acct;
    }

    /**
     * 设置intrmyAgt3Acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setIntrmyAgt3Acct(CashAccount38 value) {
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
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置cdtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount38 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public PartyIdentification1354 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public void setCdtr(PartyIdentification1354 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setCdtrAcct(CashAccount38 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取ultmtCdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public PartyIdentification1355 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置ultmtCdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1355 }
     *     
     */
    public void setUltmtCdtr(PartyIdentification1355 value) {
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
     * {@link InstructionForCreditorAgent1 }
     * 
     * 
     */
    public List<InstructionForCreditorAgent1> getInstrForCdtrAgt() {
        if (instrForCdtrAgt == null) {
            instrForCdtrAgt = new ArrayList<InstructionForCreditorAgent1>();
        }
        return this.instrForCdtrAgt;
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
     *     {@link Purpose2Choice }
     *     
     */
    public Purpose2Choice getPurp() {
        return purp;
    }

    /**
     * 设置purp属性的值。
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
     * 获取tax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation8 }
     *     
     */
    public TaxInformation8 getTax() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation8 }
     *     
     */
    public void setTax(TaxInformation8 value) {
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

}
