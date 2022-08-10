package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies the underlying transaction.
 * 
 * <p>EntryTransaction11 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EntryTransaction11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Refs" type="{}TransactionReferences6" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="CdtDbtInd" type="{}CreditDebitCode" minOccurs="0"/>
 *         &lt;element name="AmtDtls" type="{}AmountAndCurrencyExchange3" minOccurs="0"/>
 *         &lt;element name="Avlbty" type="{}CashAvailability1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BkTxCd" type="{}BankTransactionCodeStructure4" minOccurs="0"/>
 *         &lt;element name="Chrgs" type="{}Charges6" minOccurs="0"/>
 *         &lt;element name="Intrst" type="{}TransactionInterest4" minOccurs="0"/>
 *         &lt;element name="RltdPties" type="{}TransactionParties9" minOccurs="0"/>
 *         &lt;element name="RltdAgts" type="{}TransactionAgents5" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="Purp" type="{}Purpose2Choice" minOccurs="0"/>
 *         &lt;element name="RltdRmtInf" type="{}RemittanceLocation7" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{}RemittanceInformation21" minOccurs="0"/>
 *         &lt;element name="RltdDts" type="{}TransactionDates3" minOccurs="0"/>
 *         &lt;element name="RltdPric" type="{}TransactionPrice4Choice" minOccurs="0"/>
 *         &lt;element name="RltdQties" type="{}TransactionQuantities3Choice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FinInstrmId" type="{}SecurityIdentification19" minOccurs="0"/>
 *         &lt;element name="Tax" type="{}TaxInformation10" minOccurs="0"/>
 *         &lt;element name="RtrInf" type="{}PaymentReturnReason5" minOccurs="0"/>
 *         &lt;element name="CorpActn" type="{}CorporateAction9" minOccurs="0"/>
 *         &lt;element name="SfkpgAcct" type="{}SecuritiesAccount19" minOccurs="0"/>
 *         &lt;element name="CshDpst" type="{}CashDeposit1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CardTx" type="{}CardTransaction18" minOccurs="0"/>
 *         &lt;element name="AddtlTxInf" type="{}Max500Text" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryTransaction11", propOrder = {
    "refs",
    "amt",
    "cdtDbtInd",
    "amtDtls",
    "avlbty",
    "bkTxCd",
    "chrgs",
    "intrst",
    "rltdPties",
    "rltdAgts",
    "lclInstrm",
    "purp",
    "rltdRmtInf",
    "rmtInf",
    "rltdDts",
    "rltdPric",
    "rltdQties",
    "finInstrmId",
    "tax",
    "rtrInf",
    "corpActn",
    "sfkpgAcct",
    "cshDpst",
    "cardTx",
    "addtlTxInf",
    "splmtryData"
})
public class EntryTransaction11 {

    @XmlElement(name = "Refs")
    protected TransactionReferences6 refs;
    @XmlElement(name = "Amt")
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd")
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "AmtDtls")
    protected AmountAndCurrencyExchange3 amtDtls;
    @XmlElement(name = "Avlbty")
    protected List<CashAvailability1> avlbty;
    @XmlElement(name = "BkTxCd")
    protected BankTransactionCodeStructure4 bkTxCd;
    @XmlElement(name = "Chrgs")
    protected Charges6 chrgs;
    @XmlElement(name = "Intrst")
    protected TransactionInterest4 intrst;
    @XmlElement(name = "RltdPties")
    protected TransactionParties9 rltdPties;
    @XmlElement(name = "RltdAgts")
    protected TransactionAgents5 rltdAgts;
    @XmlElement(name = "LclInstrm")
    protected LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "Purp")
    protected Purpose2Choice purp;
    @XmlElement(name = "RltdRmtInf")
    protected List<RemittanceLocation7> rltdRmtInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation21 rmtInf;
    @XmlElement(name = "RltdDts")
    protected TransactionDates3 rltdDts;
    @XmlElement(name = "RltdPric")
    protected TransactionPrice4Choice rltdPric;
    @XmlElement(name = "RltdQties")
    protected List<TransactionQuantities3Choice> rltdQties;
    @XmlElement(name = "FinInstrmId")
    protected SecurityIdentification19 finInstrmId;
    @XmlElement(name = "Tax")
    protected TaxInformation10 tax;
    @XmlElement(name = "RtrInf")
    protected PaymentReturnReason5 rtrInf;
    @XmlElement(name = "CorpActn")
    protected CorporateAction9 corpActn;
    @XmlElement(name = "SfkpgAcct")
    protected SecuritiesAccount19 sfkpgAcct;
    @XmlElement(name = "CshDpst")
    protected List<CashDeposit1> cshDpst;
    @XmlElement(name = "CardTx")
    protected CardTransaction18 cardTx;
    @XmlElement(name = "AddtlTxInf")
    protected String addtlTxInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡrefs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionReferences6 }
     *     
     */
    public TransactionReferences6 getRefs() {
        return refs;
    }

    /**
     * ����refs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionReferences6 }
     *     
     */
    public void setRefs(TransactionReferences6 value) {
        this.refs = value;
    }

    /**
     * ��ȡamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * ��ȡcdtDbtInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditDebitCode }
     *     
     */
    public CreditDebitCode getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * ����cdtDbtInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDebitCode }
     *     
     */
    public void setCdtDbtInd(CreditDebitCode value) {
        this.cdtDbtInd = value;
    }

    /**
     * ��ȡamtDtls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchange3 }
     *     
     */
    public AmountAndCurrencyExchange3 getAmtDtls() {
        return amtDtls;
    }

    /**
     * ����amtDtls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchange3 }
     *     
     */
    public void setAmtDtls(AmountAndCurrencyExchange3 value) {
        this.amtDtls = value;
    }

    /**
     * Gets the value of the avlbty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avlbty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvlbty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashAvailability1 }
     * 
     * 
     */
    public List<CashAvailability1> getAvlbty() {
        if (avlbty == null) {
            avlbty = new ArrayList<CashAvailability1>();
        }
        return this.avlbty;
    }

    /**
     * ��ȡbkTxCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BankTransactionCodeStructure4 }
     *     
     */
    public BankTransactionCodeStructure4 getBkTxCd() {
        return bkTxCd;
    }

    /**
     * ����bkTxCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BankTransactionCodeStructure4 }
     *     
     */
    public void setBkTxCd(BankTransactionCodeStructure4 value) {
        this.bkTxCd = value;
    }

    /**
     * ��ȡchrgs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Charges6 }
     *     
     */
    public Charges6 getChrgs() {
        return chrgs;
    }

    /**
     * ����chrgs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Charges6 }
     *     
     */
    public void setChrgs(Charges6 value) {
        this.chrgs = value;
    }

    /**
     * ��ȡintrst���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterest4 }
     *     
     */
    public TransactionInterest4 getIntrst() {
        return intrst;
    }

    /**
     * ����intrst���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterest4 }
     *     
     */
    public void setIntrst(TransactionInterest4 value) {
        this.intrst = value;
    }

    /**
     * ��ȡrltdPties���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionParties9 }
     *     
     */
    public TransactionParties9 getRltdPties() {
        return rltdPties;
    }

    /**
     * ����rltdPties���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionParties9 }
     *     
     */
    public void setRltdPties(TransactionParties9 value) {
        this.rltdPties = value;
    }

    /**
     * ��ȡrltdAgts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionAgents5 }
     *     
     */
    public TransactionAgents5 getRltdAgts() {
        return rltdAgts;
    }

    /**
     * ����rltdAgts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionAgents5 }
     *     
     */
    public void setRltdAgts(TransactionAgents5 value) {
        this.rltdAgts = value;
    }

    /**
     * ��ȡlclInstrm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public LocalInstrument2Choice getLclInstrm() {
        return lclInstrm;
    }

    /**
     * ����lclInstrm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public void setLclInstrm(LocalInstrument2Choice value) {
        this.lclInstrm = value;
    }

    /**
     * ��ȡpurp���Ե�ֵ��
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
     * ����purp���Ե�ֵ��
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
     * ��ȡrltdDts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionDates3 }
     *     
     */
    public TransactionDates3 getRltdDts() {
        return rltdDts;
    }

    /**
     * ����rltdDts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDates3 }
     *     
     */
    public void setRltdDts(TransactionDates3 value) {
        this.rltdDts = value;
    }

    /**
     * ��ȡrltdPric���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionPrice4Choice }
     *     
     */
    public TransactionPrice4Choice getRltdPric() {
        return rltdPric;
    }

    /**
     * ����rltdPric���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionPrice4Choice }
     *     
     */
    public void setRltdPric(TransactionPrice4Choice value) {
        this.rltdPric = value;
    }

    /**
     * Gets the value of the rltdQties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rltdQties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRltdQties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransactionQuantities3Choice }
     * 
     * 
     */
    public List<TransactionQuantities3Choice> getRltdQties() {
        if (rltdQties == null) {
            rltdQties = new ArrayList<TransactionQuantities3Choice>();
        }
        return this.rltdQties;
    }

    /**
     * ��ȡfinInstrmId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SecurityIdentification19 }
     *     
     */
    public SecurityIdentification19 getFinInstrmId() {
        return finInstrmId;
    }

    /**
     * ����finInstrmId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityIdentification19 }
     *     
     */
    public void setFinInstrmId(SecurityIdentification19 value) {
        this.finInstrmId = value;
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
     * ��ȡrtrInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PaymentReturnReason5 }
     *     
     */
    public PaymentReturnReason5 getRtrInf() {
        return rtrInf;
    }

    /**
     * ����rtrInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReturnReason5 }
     *     
     */
    public void setRtrInf(PaymentReturnReason5 value) {
        this.rtrInf = value;
    }

    /**
     * ��ȡcorpActn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CorporateAction9 }
     *     
     */
    public CorporateAction9 getCorpActn() {
        return corpActn;
    }

    /**
     * ����corpActn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateAction9 }
     *     
     */
    public void setCorpActn(CorporateAction9 value) {
        this.corpActn = value;
    }

    /**
     * ��ȡsfkpgAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SecuritiesAccount19 }
     *     
     */
    public SecuritiesAccount19 getSfkpgAcct() {
        return sfkpgAcct;
    }

    /**
     * ����sfkpgAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SecuritiesAccount19 }
     *     
     */
    public void setSfkpgAcct(SecuritiesAccount19 value) {
        this.sfkpgAcct = value;
    }

    /**
     * Gets the value of the cshDpst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cshDpst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCshDpst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashDeposit1 }
     * 
     * 
     */
    public List<CashDeposit1> getCshDpst() {
        if (cshDpst == null) {
            cshDpst = new ArrayList<CashDeposit1>();
        }
        return this.cshDpst;
    }

    /**
     * ��ȡcardTx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardTransaction18 }
     *     
     */
    public CardTransaction18 getCardTx() {
        return cardTx;
    }

    /**
     * ����cardTx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardTransaction18 }
     *     
     */
    public void setCardTx(CardTransaction18 value) {
        this.cardTx = value;
    }

    /**
     * ��ȡaddtlTxInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlTxInf() {
        return addtlTxInf;
    }

    /**
     * ����addtlTxInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlTxInf(String value) {
        this.addtlTxInf = value;
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
