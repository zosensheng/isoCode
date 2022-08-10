package com.hisun.kont.mx.msg.pacs.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details specific to the individual transaction(s) included in the message.
 * 
 * <p>CreditTransferTransaction52 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction52">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="UltmtDbtr" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{}PartyIdentification135"/>
 *         &lt;element name="DbtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="DbtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="CdtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{}PartyIdentification135"/>
 *         &lt;element name="CdtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="InstrForCdtrAgt" type="{}InstructionForCreditorAgent3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InstrForNxtAgt" type="{}InstructionForNextAgent1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Tax" type="{}TaxInformation10" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{}RemittanceInformation21" minOccurs="0"/>
 *         &lt;element name="InstdAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction52", propOrder = {
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
    "tax",
    "rmtInf",
    "instdAmt"
})
public class CreditTransferTransaction52 {

    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentification135 ultmtDbtr;
    @XmlElement(name = "InitgPty")
    protected PartyIdentification135 initgPty;
    @XmlElement(name = "Dbtr", required = true)
    protected PartyIdentification135 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount40 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "PrvsInstgAgt1")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1;
    @XmlElement(name = "PrvsInstgAgt1Acct")
    protected CashAccount40 prvsInstgAgt1Acct;
    @XmlElement(name = "PrvsInstgAgt2")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2;
    @XmlElement(name = "PrvsInstgAgt2Acct")
    protected CashAccount40 prvsInstgAgt2Acct;
    @XmlElement(name = "PrvsInstgAgt3")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3;
    @XmlElement(name = "PrvsInstgAgt3Acct")
    protected CashAccount40 prvsInstgAgt3Acct;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct")
    protected CashAccount40 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct")
    protected CashAccount40 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct")
    protected CashAccount40 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentification135 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount40 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentification135 ultmtCdtr;
    @XmlElement(name = "InstrForCdtrAgt")
    protected List<InstructionForCreditorAgent3> instrForCdtrAgt;
    @XmlElement(name = "InstrForNxtAgt")
    protected List<InstructionForNextAgent1> instrForNxtAgt;
    @XmlElement(name = "Tax")
    protected TaxInformation10 tax;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation21 rmtInf;
    @XmlElement(name = "InstdAmt")
    protected ActiveOrHistoricCurrencyAndAmount instdAmt;

    /**
     * ��ȡultmtDbtr���Ե�ֵ��
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
     * ����ultmtDbtr���Ե�ֵ��
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
     * ��ȡinitgPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getInitgPty() {
        return initgPty;
    }

    /**
     * ����initgPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setInitgPty(PartyIdentification135 value) {
        this.initgPty = value;
    }

    /**
     * ��ȡdbtr���Ե�ֵ��
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
     * ����dbtr���Ե�ֵ��
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
     * ��ȡdbtrAcct���Ե�ֵ��
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
     * ����dbtrAcct���Ե�ֵ��
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
     * ��ȡdbtrAgt���Ե�ֵ��
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
     * ����dbtrAgt���Ե�ֵ��
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
     * ��ȡdbtrAgtAcct���Ե�ֵ��
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
     * ����dbtrAgtAcct���Ե�ֵ��
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
     * ��ȡprvsInstgAgt1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt1() {
        return prvsInstgAgt1;
    }

    /**
     * ����prvsInstgAgt1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt1(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt1 = value;
    }

    /**
     * ��ȡprvsInstgAgt1Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt1Acct() {
        return prvsInstgAgt1Acct;
    }

    /**
     * ����prvsInstgAgt1Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt1Acct(CashAccount40 value) {
        this.prvsInstgAgt1Acct = value;
    }

    /**
     * ��ȡprvsInstgAgt2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt2() {
        return prvsInstgAgt2;
    }

    /**
     * ����prvsInstgAgt2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt2(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt2 = value;
    }

    /**
     * ��ȡprvsInstgAgt2Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt2Acct() {
        return prvsInstgAgt2Acct;
    }

    /**
     * ����prvsInstgAgt2Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt2Acct(CashAccount40 value) {
        this.prvsInstgAgt2Acct = value;
    }

    /**
     * ��ȡprvsInstgAgt3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt3() {
        return prvsInstgAgt3;
    }

    /**
     * ����prvsInstgAgt3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt3(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt3 = value;
    }

    /**
     * ��ȡprvsInstgAgt3Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt3Acct() {
        return prvsInstgAgt3Acct;
    }

    /**
     * ����prvsInstgAgt3Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt3Acct(CashAccount40 value) {
        this.prvsInstgAgt3Acct = value;
    }

    /**
     * ��ȡintrmyAgt1���Ե�ֵ��
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
     * ����intrmyAgt1���Ե�ֵ��
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
     * ��ȡintrmyAgt1Acct���Ե�ֵ��
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
     * ����intrmyAgt1Acct���Ե�ֵ��
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
     * ��ȡintrmyAgt2���Ե�ֵ��
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
     * ����intrmyAgt2���Ե�ֵ��
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
     * ��ȡintrmyAgt2Acct���Ե�ֵ��
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
     * ����intrmyAgt2Acct���Ե�ֵ��
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
     * ��ȡintrmyAgt3���Ե�ֵ��
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
     * ����intrmyAgt3���Ե�ֵ��
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
     * ��ȡintrmyAgt3Acct���Ե�ֵ��
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
     * ����intrmyAgt3Acct���Ե�ֵ��
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
     * ��ȡcdtrAgt���Ե�ֵ��
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
     * ����cdtrAgt���Ե�ֵ��
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
     * ��ȡcdtrAgtAcct���Ե�ֵ��
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
     * ����cdtrAgtAcct���Ե�ֵ��
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
     * ��ȡcdtr���Ե�ֵ��
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
     * ����cdtr���Ե�ֵ��
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
     * ��ȡcdtrAcct���Ե�ֵ��
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
     * ����cdtrAcct���Ե�ֵ��
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
     * ��ȡultmtCdtr���Ե�ֵ��
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
     * ����ultmtCdtr���Ե�ֵ��
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
     * {@link InstructionForNextAgent1 }
     * 
     * 
     */
    public List<InstructionForNextAgent1> getInstrForNxtAgt() {
        if (instrForNxtAgt == null) {
            instrForNxtAgt = new ArrayList<InstructionForNextAgent1>();
        }
        return this.instrForNxtAgt;
    }

    /**
     * ��ȡtax���Ե�ֵ��
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
     * ����tax���Ե�ֵ��
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
     * ��ȡrmtInf���Ե�ֵ��
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
     * ����rmtInf���Ե�ֵ��
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
     * ��ȡinstdAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getInstdAmt() {
        return instdAmt;
    }

    /**
     * ����instdAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setInstdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.instdAmt = value;
    }

}
