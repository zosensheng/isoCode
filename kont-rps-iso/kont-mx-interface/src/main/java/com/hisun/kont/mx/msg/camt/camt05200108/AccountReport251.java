//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

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
 * <p>AccountReport25__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AccountReport25__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="RptPgntn" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Pagination1"/>
 *         &lt;element name="ElctrncSeqNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Number" minOccurs="0"/>
 *         &lt;element name="RptgSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}SequenceRange1Choice__1" minOccurs="0"/>
 *         &lt;element name="LglSeqNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Number" minOccurs="0"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_DateTime" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}DateTimePeriod1__1" minOccurs="0"/>
 *         &lt;element name="CpyDplctInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CopyDuplicate1Code" minOccurs="0"/>
 *         &lt;element name="RptgSrc" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ReportingSource1Choice__1" minOccurs="0"/>
 *         &lt;element name="Acct" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashAccount39__1"/>
 *         &lt;element name="RltdAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Intrst" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AccountInterest4__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bal" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CashBalance8__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TxsSummry" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TotalTransactions6__1" minOccurs="0"/>
 *         &lt;element name="Ntry" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ReportEntry10__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AddtlRptInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax500Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountReport25__1", propOrder = {
    "id",
    "rptPgntn",
    "elctrncSeqNb",
    "rptgSeq",
    "lglSeqNb",
    "creDtTm",
    "frToDt",
    "cpyDplctInd",
    "rptgSrc",
    "acct",
    "rltdAcct",
    "intrst",
    "bal",
    "txsSummry",
    "ntry",
    "addtlRptInf"
})
public class AccountReport251 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "RptPgntn", required = true)
    protected Pagination1 rptPgntn;
    @XmlElement(name = "ElctrncSeqNb")
    protected BigDecimal elctrncSeqNb;
    @XmlElement(name = "RptgSeq")
    protected SequenceRange1Choice1 rptgSeq;
    @XmlElement(name = "LglSeqNb")
    protected BigDecimal lglSeqNb;
    @XmlElement(name = "CreDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "FrToDt")
    protected DateTimePeriod11 frToDt;
    @XmlElement(name = "CpyDplctInd")
    @XmlSchemaType(name = "string")
    protected CopyDuplicate1Code cpyDplctInd;
    @XmlElement(name = "RptgSrc")
    protected ReportingSource1Choice1 rptgSrc;
    @XmlElement(name = "Acct", required = true)
    protected CashAccount391 acct;
    @XmlElement(name = "RltdAcct")
    protected CashAccount381 rltdAcct;
    @XmlElement(name = "Intrst")
    protected List<AccountInterest41> intrst;
    @XmlElement(name = "Bal")
    protected List<CashBalance81> bal;
    @XmlElement(name = "TxsSummry")
    protected TotalTransactions61 txsSummry;
    @XmlElement(name = "Ntry")
    protected List<ReportEntry101> ntry;
    @XmlElement(name = "AddtlRptInf")
    protected String addtlRptInf;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取rptPgntn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Pagination1 }
     *     
     */
    public Pagination1 getRptPgntn() {
        return rptPgntn;
    }

    /**
     * 设置rptPgntn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Pagination1 }
     *     
     */
    public void setRptPgntn(Pagination1 value) {
        this.rptPgntn = value;
    }

    /**
     * 获取elctrncSeqNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getElctrncSeqNb() {
        return elctrncSeqNb;
    }

    /**
     * 设置elctrncSeqNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setElctrncSeqNb(BigDecimal value) {
        this.elctrncSeqNb = value;
    }

    /**
     * 获取rptgSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SequenceRange1Choice1 }
     *     
     */
    public SequenceRange1Choice1 getRptgSeq() {
        return rptgSeq;
    }

    /**
     * 设置rptgSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceRange1Choice1 }
     *     
     */
    public void setRptgSeq(SequenceRange1Choice1 value) {
        this.rptgSeq = value;
    }

    /**
     * 获取lglSeqNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLglSeqNb() {
        return lglSeqNb;
    }

    /**
     * 设置lglSeqNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLglSeqNb(BigDecimal value) {
        this.lglSeqNb = value;
    }

    /**
     * 获取creDtTm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * 设置creDtTm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * 获取frToDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public DateTimePeriod11 getFrToDt() {
        return frToDt;
    }

    /**
     * 设置frToDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public void setFrToDt(DateTimePeriod11 value) {
        this.frToDt = value;
    }

    /**
     * 获取cpyDplctInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CopyDuplicate1Code }
     *     
     */
    public CopyDuplicate1Code getCpyDplctInd() {
        return cpyDplctInd;
    }

    /**
     * 设置cpyDplctInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CopyDuplicate1Code }
     *     
     */
    public void setCpyDplctInd(CopyDuplicate1Code value) {
        this.cpyDplctInd = value;
    }

    /**
     * 获取rptgSrc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportingSource1Choice1 }
     *     
     */
    public ReportingSource1Choice1 getRptgSrc() {
        return rptgSrc;
    }

    /**
     * 设置rptgSrc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingSource1Choice1 }
     *     
     */
    public void setRptgSrc(ReportingSource1Choice1 value) {
        this.rptgSrc = value;
    }

    /**
     * 获取acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount391 }
     *     
     */
    public CashAccount391 getAcct() {
        return acct;
    }

    /**
     * 设置acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount391 }
     *     
     */
    public void setAcct(CashAccount391 value) {
        this.acct = value;
    }

    /**
     * 获取rltdAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getRltdAcct() {
        return rltdAcct;
    }

    /**
     * 设置rltdAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setRltdAcct(CashAccount381 value) {
        this.rltdAcct = value;
    }

    /**
     * Gets the value of the intrst property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intrst property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntrst().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountInterest41 }
     * 
     * 
     */
    public List<AccountInterest41> getIntrst() {
        if (intrst == null) {
            intrst = new ArrayList<AccountInterest41>();
        }
        return this.intrst;
    }

    /**
     * Gets the value of the bal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashBalance81 }
     * 
     * 
     */
    public List<CashBalance81> getBal() {
        if (bal == null) {
            bal = new ArrayList<CashBalance81>();
        }
        return this.bal;
    }

    /**
     * 获取txsSummry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TotalTransactions61 }
     *     
     */
    public TotalTransactions61 getTxsSummry() {
        return txsSummry;
    }

    /**
     * 设置txsSummry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTransactions61 }
     *     
     */
    public void setTxsSummry(TotalTransactions61 value) {
        this.txsSummry = value;
    }

    /**
     * Gets the value of the ntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportEntry101 }
     * 
     * 
     */
    public List<ReportEntry101> getNtry() {
        if (ntry == null) {
            ntry = new ArrayList<ReportEntry101>();
        }
        return this.ntry;
    }

    /**
     * 获取addtlRptInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlRptInf() {
        return addtlRptInf;
    }

    /**
     * 设置addtlRptInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlRptInf(String value) {
        this.addtlRptInf = value;
    }

}
