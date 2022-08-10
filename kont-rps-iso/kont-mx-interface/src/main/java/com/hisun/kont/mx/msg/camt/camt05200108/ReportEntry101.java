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
 * <p>ReportEntry10__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportEntry10__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NtryRef" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CreditDebitCode"/>
 *         &lt;element name="RvslInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="Sts" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}EntryStatus1Choice__1"/>
 *         &lt;element name="BookgDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}DateAndDateTime2Choice__1" minOccurs="0"/>
 *         &lt;element name="ValDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}DateAndDateTime2Choice__1"/>
 *         &lt;element name="AcctSvcrRef" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Avlbty" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashAvailability1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BkTxCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}BankTransactionCodeStructure4__1"/>
 *         &lt;element name="ComssnWvrInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}YesNoIndicator" minOccurs="0"/>
 *         &lt;element name="AddtlInfInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}MessageIdentification2__1" minOccurs="0"/>
 *         &lt;element name="AmtDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchange3__1" minOccurs="0"/>
 *         &lt;element name="Chrgs" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Charges6__1" minOccurs="0"/>
 *         &lt;element name="TechInptChanl" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TechnicalInputChannel1Choice__1" minOccurs="0"/>
 *         &lt;element name="Intrst" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TransactionInterest4__1" minOccurs="0"/>
 *         &lt;element name="CardTx" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CardEntry4__1" minOccurs="0"/>
 *         &lt;element name="NtryDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}EntryDetails9__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AddtlNtryInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax500Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportEntry10__1", propOrder = {
    "ntryRef",
    "amt",
    "cdtDbtInd",
    "rvslInd",
    "sts",
    "bookgDt",
    "valDt",
    "acctSvcrRef",
    "avlbty",
    "bkTxCd",
    "comssnWvrInd",
    "addtlInfInd",
    "amtDtls",
    "chrgs",
    "techInptChanl",
    "intrst",
    "cardTx",
    "ntryDtls",
    "addtlNtryInf"
})
public class ReportEntry101 {

    @XmlElement(name = "NtryRef")
    protected String ntryRef;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "RvslInd")
    protected Boolean rvslInd;
    @XmlElement(name = "Sts", required = true)
    protected EntryStatus1Choice1 sts;
    @XmlElement(name = "BookgDt")
    protected DateAndDateTime2Choice1 bookgDt;
    @XmlElement(name = "ValDt", required = true)
    protected DateAndDateTime2Choice1 valDt;
    @XmlElement(name = "AcctSvcrRef")
    protected String acctSvcrRef;
    @XmlElement(name = "Avlbty")
    protected List<CashAvailability1> avlbty;
    @XmlElement(name = "BkTxCd", required = true)
    protected BankTransactionCodeStructure41 bkTxCd;
    @XmlElement(name = "ComssnWvrInd")
    protected Boolean comssnWvrInd;
    @XmlElement(name = "AddtlInfInd")
    protected MessageIdentification21 addtlInfInd;
    @XmlElement(name = "AmtDtls")
    protected AmountAndCurrencyExchange31 amtDtls;
    @XmlElement(name = "Chrgs")
    protected Charges61 chrgs;
    @XmlElement(name = "TechInptChanl")
    protected TechnicalInputChannel1Choice1 techInptChanl;
    @XmlElement(name = "Intrst")
    protected TransactionInterest41 intrst;
    @XmlElement(name = "CardTx")
    protected CardEntry41 cardTx;
    @XmlElement(name = "NtryDtls")
    protected List<EntryDetails91> ntryDtls;
    @XmlElement(name = "AddtlNtryInf")
    protected String addtlNtryInf;

    /**
     * 获取ntryRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtryRef() {
        return ntryRef;
    }

    /**
     * 设置ntryRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtryRef(String value) {
        this.ntryRef = value;
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
     * 获取rvslInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRvslInd() {
        return rvslInd;
    }

    /**
     * 设置rvslInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRvslInd(Boolean value) {
        this.rvslInd = value;
    }

    /**
     * 获取sts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EntryStatus1Choice1 }
     *     
     */
    public EntryStatus1Choice1 getSts() {
        return sts;
    }

    /**
     * 设置sts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EntryStatus1Choice1 }
     *     
     */
    public void setSts(EntryStatus1Choice1 value) {
        this.sts = value;
    }

    /**
     * 获取bookgDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public DateAndDateTime2Choice1 getBookgDt() {
        return bookgDt;
    }

    /**
     * 设置bookgDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public void setBookgDt(DateAndDateTime2Choice1 value) {
        this.bookgDt = value;
    }

    /**
     * 获取valDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public DateAndDateTime2Choice1 getValDt() {
        return valDt;
    }

    /**
     * 设置valDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public void setValDt(DateAndDateTime2Choice1 value) {
        this.valDt = value;
    }

    /**
     * 获取acctSvcrRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSvcrRef() {
        return acctSvcrRef;
    }

    /**
     * 设置acctSvcrRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSvcrRef(String value) {
        this.acctSvcrRef = value;
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
     * 获取comssnWvrInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isComssnWvrInd() {
        return comssnWvrInd;
    }

    /**
     * 设置comssnWvrInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setComssnWvrInd(Boolean value) {
        this.comssnWvrInd = value;
    }

    /**
     * 获取addtlInfInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MessageIdentification21 }
     *     
     */
    public MessageIdentification21 getAddtlInfInd() {
        return addtlInfInd;
    }

    /**
     * 设置addtlInfInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MessageIdentification21 }
     *     
     */
    public void setAddtlInfInd(MessageIdentification21 value) {
        this.addtlInfInd = value;
    }

    /**
     * 获取amtDtls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchange31 }
     *     
     */
    public AmountAndCurrencyExchange31 getAmtDtls() {
        return amtDtls;
    }

    /**
     * 设置amtDtls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchange31 }
     *     
     */
    public void setAmtDtls(AmountAndCurrencyExchange31 value) {
        this.amtDtls = value;
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
     * 获取techInptChanl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TechnicalInputChannel1Choice1 }
     *     
     */
    public TechnicalInputChannel1Choice1 getTechInptChanl() {
        return techInptChanl;
    }

    /**
     * 设置techInptChanl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalInputChannel1Choice1 }
     *     
     */
    public void setTechInptChanl(TechnicalInputChannel1Choice1 value) {
        this.techInptChanl = value;
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
     * 获取cardTx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardEntry41 }
     *     
     */
    public CardEntry41 getCardTx() {
        return cardTx;
    }

    /**
     * 设置cardTx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardEntry41 }
     *     
     */
    public void setCardTx(CardEntry41 value) {
        this.cardTx = value;
    }

    /**
     * Gets the value of the ntryDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ntryDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNtryDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryDetails91 }
     * 
     * 
     */
    public List<EntryDetails91> getNtryDtls() {
        if (ntryDtls == null) {
            ntryDtls = new ArrayList<EntryDetails91>();
        }
        return this.ntryDtls;
    }

    /**
     * 获取addtlNtryInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlNtryInf() {
        return addtlNtryInf;
    }

    /**
     * 设置addtlNtryInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlNtryInf(String value) {
        this.addtlNtryInf = value;
    }

}
