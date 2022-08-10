//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EntryTransaction10__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EntryTransaction10__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Refs" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionReferences6__1"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CreditDebitCode"/>
 *         &lt;element name="AmtDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchange3__2" minOccurs="0"/>
 *         &lt;element name="Avlbty" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashAvailability1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BkTxCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}BankTransactionCodeStructure4__1" minOccurs="0"/>
 *         &lt;element name="Chrgs" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Charges6__1" minOccurs="0"/>
 *         &lt;element name="Intrst" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionInterest4__1" minOccurs="0"/>
 *         &lt;element name="RltdPties" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionParties6__1" minOccurs="0"/>
 *         &lt;element name="RltdAgts" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionAgents5__1" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}LocalInstrument2Choice__1" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Purpose2Choice__1" minOccurs="0"/>
 *         &lt;element name="RltdRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}RemittanceLocation7__1" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}RemittanceInformation16__1" minOccurs="0"/>
 *         &lt;element name="RltdDts" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionDates3__1" minOccurs="0"/>
 *         &lt;element name="RltdPric" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionPrice4Choice__1" minOccurs="0"/>
 *         &lt;element name="RltdQties" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionQuantities3Choice__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FinInstrmId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}SecurityIdentification19__1" minOccurs="0"/>
 *         &lt;element name="Tax" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TaxInformation8__1" minOccurs="0"/>
 *         &lt;element name="RtrInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PaymentReturnReason5__1" minOccurs="0"/>
 *         &lt;element name="CorpActn" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CorporateAction9__1" minOccurs="0"/>
 *         &lt;element name="SfkpgAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}SecuritiesAccount19__1" minOccurs="0"/>
 *         &lt;element name="CshDpst" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashDeposit1__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CardTx" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CardTransaction17__1" minOccurs="0"/>
 *         &lt;element name="AddtlTxInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax500Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryTransaction10__1", propOrder = {
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
    "addtlTxInf"
})
public class EntryTransaction101 {

    @XmlElement(name = "Refs", required = true)
    protected TransactionReferences61 refs;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "AmtDtls")
    protected AmountAndCurrencyExchange32 amtDtls;
    @XmlElement(name = "Avlbty")
    protected List<CashAvailability1> avlbty;
    @XmlElement(name = "BkTxCd")
    protected BankTransactionCodeStructure41 bkTxCd;
    @XmlElement(name = "Chrgs")
    protected Charges61 chrgs;
    @XmlElement(name = "Intrst")
    protected TransactionInterest41 intrst;
    @XmlElement(name = "RltdPties")
    protected TransactionParties61 rltdPties;
    @XmlElement(name = "RltdAgts")
    protected TransactionAgents51 rltdAgts;
    @XmlElement(name = "LclInstrm")
    protected LocalInstrument2Choice1 lclInstrm;
    @XmlElement(name = "Purp")
    protected Purpose2Choice1 purp;
    @XmlElement(name = "RltdRmtInf")
    protected List<RemittanceLocation71> rltdRmtInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation161 rmtInf;
    @XmlElement(name = "RltdDts")
    protected TransactionDates31 rltdDts;
    @XmlElement(name = "RltdPric")
    protected TransactionPrice4Choice1 rltdPric;
    @XmlElement(name = "RltdQties")
    protected List<TransactionQuantities3Choice1> rltdQties;
    @XmlElement(name = "FinInstrmId")
    protected SecurityIdentification191 finInstrmId;
    @XmlElement(name = "Tax")
    protected TaxInformation81 tax;
    @XmlElement(name = "RtrInf")
    protected PaymentReturnReason51 rtrInf;
    @XmlElement(name = "CorpActn")
    protected CorporateAction91 corpActn;
    @XmlElement(name = "SfkpgAcct")
    protected SecuritiesAccount191 sfkpgAcct;
    @XmlElement(name = "CshDpst")
    protected List<CashDeposit11> cshDpst;
    @XmlElement(name = "CardTx")
    protected CardTransaction171 cardTx;
    @XmlElement(name = "AddtlTxInf")
    protected String addtlTxInf;

    /**
     * 获取refs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionReferences61 }
     *     
     */
    public TransactionReferences61 getRefs() {
        return refs;
    }

    /**
     * 设置refs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionReferences61 }
     *     
     */
    public void setRefs(TransactionReferences61 value) {
        this.refs = value;
    }

    /**
     * 获取amt属性的值。
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
     * 设置amt属性的值。
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
     * 获取cdtDbtInd属性的值。
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
     * 设置cdtDbtInd属性的值。
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
     * 获取amtDtls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchange32 }
     *     
     */
    public AmountAndCurrencyExchange32 getAmtDtls() {
        return amtDtls;
    }

    /**
     * 设置amtDtls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchange32 }
     *     
     */
    public void setAmtDtls(AmountAndCurrencyExchange32 value) {
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
     * 获取bkTxCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BankTransactionCodeStructure41 }
     *     
     */
    public BankTransactionCodeStructure41 getBkTxCd() {
        return bkTxCd;
    }

    /**
     * 设置bkTxCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BankTransactionCodeStructure41 }
     *     
     */
    public void setBkTxCd(BankTransactionCodeStructure41 value) {
        this.bkTxCd = value;
    }

    /**
     * 获取chrgs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Charges61 }
     *     
     */
    public Charges61 getChrgs() {
        return chrgs;
    }

    /**
     * 设置chrgs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Charges61 }
     *     
     */
    public void setChrgs(Charges61 value) {
        this.chrgs = value;
    }

    /**
     * 获取intrst属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionInterest41 }
     *     
     */
    public TransactionInterest41 getIntrst() {
        return intrst;
    }

    /**
     * 设置intrst属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionInterest41 }
     *     
     */
    public void setIntrst(TransactionInterest41 value) {
        this.intrst = value;
    }

    /**
     * 获取rltdPties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionParties61 }
     *     
     */
    public TransactionParties61 getRltdPties() {
        return rltdPties;
    }

    /**
     * 设置rltdPties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionParties61 }
     *     
     */
    public void setRltdPties(TransactionParties61 value) {
        this.rltdPties = value;
    }

    /**
     * 获取rltdAgts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionAgents51 }
     *     
     */
    public TransactionAgents51 getRltdAgts() {
        return rltdAgts;
    }

    /**
     * 设置rltdAgts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionAgents51 }
     *     
     */
    public void setRltdAgts(TransactionAgents51 value) {
        this.rltdAgts = value;
    }

    /**
     * 获取lclInstrm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LocalInstrument2Choice1 }
     *     
     */
    public LocalInstrument2Choice1 getLclInstrm() {
        return lclInstrm;
    }

    /**
     * 设置lclInstrm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LocalInstrument2Choice1 }
     *     
     */
    public void setLclInstrm(LocalInstrument2Choice1 value) {
        this.lclInstrm = value;
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
     * {@link RemittanceLocation71 }
     * 
     * 
     */
    public List<RemittanceLocation71> getRltdRmtInf() {
        if (rltdRmtInf == null) {
            rltdRmtInf = new ArrayList<RemittanceLocation71>();
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

    /**
     * 获取rltdDts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionDates31 }
     *     
     */
    public TransactionDates31 getRltdDts() {
        return rltdDts;
    }

    /**
     * 设置rltdDts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionDates31 }
     *     
     */
    public void setRltdDts(TransactionDates31 value) {
        this.rltdDts = value;
    }

    /**
     * 获取rltdPric属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionPrice4Choice1 }
     *     
     */
    public TransactionPrice4Choice1 getRltdPric() {
        return rltdPric;
    }

    /**
     * 设置rltdPric属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionPrice4Choice1 }
     *     
     */
    public void setRltdPric(TransactionPrice4Choice1 value) {
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
     * {@link TransactionQuantities3Choice1 }
     * 
     * 
     */
    public List<TransactionQuantities3Choice1> getRltdQties() {
        if (rltdQties == null) {
            rltdQties = new ArrayList<TransactionQuantities3Choice1>();
        }
        return this.rltdQties;
    }

    /**
     * 获取finInstrmId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SecurityIdentification191 }
     *     
     */
    public SecurityIdentification191 getFinInstrmId() {
        return finInstrmId;
    }

    /**
     * 设置finInstrmId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityIdentification191 }
     *     
     */
    public void setFinInstrmId(SecurityIdentification191 value) {
        this.finInstrmId = value;
    }

    /**
     * 获取tax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation81 }
     *     
     */
    public TaxInformation81 getTax() {
        return tax;
    }

    /**
     * 设置tax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation81 }
     *     
     */
    public void setTax(TaxInformation81 value) {
        this.tax = value;
    }

    /**
     * 获取rtrInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentReturnReason51 }
     *     
     */
    public PaymentReturnReason51 getRtrInf() {
        return rtrInf;
    }

    /**
     * 设置rtrInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReturnReason51 }
     *     
     */
    public void setRtrInf(PaymentReturnReason51 value) {
        this.rtrInf = value;
    }

    /**
     * 获取corpActn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CorporateAction91 }
     *     
     */
    public CorporateAction91 getCorpActn() {
        return corpActn;
    }

    /**
     * 设置corpActn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateAction91 }
     *     
     */
    public void setCorpActn(CorporateAction91 value) {
        this.corpActn = value;
    }

    /**
     * 获取sfkpgAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SecuritiesAccount191 }
     *     
     */
    public SecuritiesAccount191 getSfkpgAcct() {
        return sfkpgAcct;
    }

    /**
     * 设置sfkpgAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SecuritiesAccount191 }
     *     
     */
    public void setSfkpgAcct(SecuritiesAccount191 value) {
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
     * {@link CashDeposit11 }
     * 
     * 
     */
    public List<CashDeposit11> getCshDpst() {
        if (cshDpst == null) {
            cshDpst = new ArrayList<CashDeposit11>();
        }
        return this.cshDpst;
    }

    /**
     * 获取cardTx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardTransaction171 }
     *     
     */
    public CardTransaction171 getCardTx() {
        return cardTx;
    }

    /**
     * 设置cardTx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardTransaction171 }
     *     
     */
    public void setCardTx(CardTransaction171 value) {
        this.cardTx = value;
    }

    /**
     * 获取addtlTxInf属性的值。
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
     * 设置addtlTxInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlTxInf(String value) {
        this.addtlTxInf = value;
    }

}
