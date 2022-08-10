package com.hisun.kont.mx.msg.camt.dic;


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
 * Provides further details of the account statement.
 * 
 * <p>AccountStatement10 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AccountStatement10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="StmtPgntn" type="{}Pagination1" minOccurs="0"/>
 *         &lt;element name="ElctrncSeqNb" type="{}Number" minOccurs="0"/>
 *         &lt;element name="RptgSeq" type="{}SequenceRange1Choice" minOccurs="0"/>
 *         &lt;element name="LglSeqNb" type="{}Number" minOccurs="0"/>
 *         &lt;element name="CreDtTm" type="{}ISODateTime" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{}DateTimePeriod1" minOccurs="0"/>
 *         &lt;element name="CpyDplctInd" type="{}CopyDuplicate1Code" minOccurs="0"/>
 *         &lt;element name="RptgSrc" type="{}ReportingSource1Choice" minOccurs="0"/>
 *         &lt;element name="Acct" type="{}CashAccount41"/>
 *         &lt;element name="RltdAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Intrst" type="{}AccountInterest4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Bal" type="{}CashBalance8" maxOccurs="unbounded"/>
 *         &lt;element name="TxsSummry" type="{}TotalTransactions6" minOccurs="0"/>
 *         &lt;element name="Ntry" type="{}ReportEntry11" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AddtlStmtInf" type="{}Max500Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountStatement10", propOrder = {
    "id",
    "stmtPgntn",
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
    "addtlStmtInf"
})
public class AccountStatement10 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "StmtPgntn")
    protected Pagination1 stmtPgntn;
    @XmlElement(name = "ElctrncSeqNb")
    protected BigDecimal elctrncSeqNb;
    @XmlElement(name = "RptgSeq")
    protected SequenceRange1Choice rptgSeq;
    @XmlElement(name = "LglSeqNb")
    protected BigDecimal lglSeqNb;
    @XmlElement(name = "CreDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "FrToDt")
    protected DateTimePeriod1 frToDt;
    @XmlElement(name = "CpyDplctInd")
    @XmlSchemaType(name = "string")
    protected CopyDuplicate1Code cpyDplctInd;
    @XmlElement(name = "RptgSrc")
    protected ReportingSource1Choice rptgSrc;
    @XmlElement(name = "Acct", required = true)
    protected CashAccount41 acct;
    @XmlElement(name = "RltdAcct")
    protected CashAccount40 rltdAcct;
    @XmlElement(name = "Intrst")
    protected List<AccountInterest4> intrst;
    @XmlElement(name = "Bal", required = true)
    protected List<CashBalance8> bal;
    @XmlElement(name = "TxsSummry")
    protected TotalTransactions6 txsSummry;
    @XmlElement(name = "Ntry")
    protected List<ReportEntry11> ntry;
    @XmlElement(name = "AddtlStmtInf")
    protected String addtlStmtInf;

    /**
     * ��ȡid���Ե�ֵ��
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
     * ����id���Ե�ֵ��
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
     * ��ȡstmtPgntn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Pagination1 }
     *     
     */
    public Pagination1 getStmtPgntn() {
        return stmtPgntn;
    }

    /**
     * ����stmtPgntn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Pagination1 }
     *     
     */
    public void setStmtPgntn(Pagination1 value) {
        this.stmtPgntn = value;
    }

    /**
     * ��ȡelctrncSeqNb���Ե�ֵ��
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
     * ����elctrncSeqNb���Ե�ֵ��
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
     * ��ȡrptgSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SequenceRange1Choice }
     *     
     */
    public SequenceRange1Choice getRptgSeq() {
        return rptgSeq;
    }

    /**
     * ����rptgSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceRange1Choice }
     *     
     */
    public void setRptgSeq(SequenceRange1Choice value) {
        this.rptgSeq = value;
    }

    /**
     * ��ȡlglSeqNb���Ե�ֵ��
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
     * ����lglSeqNb���Ե�ֵ��
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
     * ��ȡcreDtTm���Ե�ֵ��
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
     * ����creDtTm���Ե�ֵ��
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
     * ��ȡfrToDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateTimePeriod1 }
     *     
     */
    public DateTimePeriod1 getFrToDt() {
        return frToDt;
    }

    /**
     * ����frToDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePeriod1 }
     *     
     */
    public void setFrToDt(DateTimePeriod1 value) {
        this.frToDt = value;
    }

    /**
     * ��ȡcpyDplctInd���Ե�ֵ��
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
     * ����cpyDplctInd���Ե�ֵ��
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
     * ��ȡrptgSrc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReportingSource1Choice }
     *     
     */
    public ReportingSource1Choice getRptgSrc() {
        return rptgSrc;
    }

    /**
     * ����rptgSrc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingSource1Choice }
     *     
     */
    public void setRptgSrc(ReportingSource1Choice value) {
        this.rptgSrc = value;
    }

    /**
     * ��ȡacct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount41 }
     *     
     */
    public CashAccount41 getAcct() {
        return acct;
    }

    /**
     * ����acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount41 }
     *     
     */
    public void setAcct(CashAccount41 value) {
        this.acct = value;
    }

    /**
     * ��ȡrltdAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getRltdAcct() {
        return rltdAcct;
    }

    /**
     * ����rltdAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setRltdAcct(CashAccount40 value) {
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
     * {@link AccountInterest4 }
     * 
     * 
     */
    public List<AccountInterest4> getIntrst() {
        if (intrst == null) {
            intrst = new ArrayList<AccountInterest4>();
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
     * {@link CashBalance8 }
     * 
     * 
     */
    public List<CashBalance8> getBal() {
        if (bal == null) {
            bal = new ArrayList<CashBalance8>();
        }
        return this.bal;
    }

    /**
     * ��ȡtxsSummry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TotalTransactions6 }
     *     
     */
    public TotalTransactions6 getTxsSummry() {
        return txsSummry;
    }

    /**
     * ����txsSummry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TotalTransactions6 }
     *     
     */
    public void setTxsSummry(TotalTransactions6 value) {
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
     * {@link ReportEntry11 }
     * 
     * 
     */
    public List<ReportEntry11> getNtry() {
        if (ntry == null) {
            ntry = new ArrayList<ReportEntry11>();
        }
        return this.ntry;
    }

    /**
     * ��ȡaddtlStmtInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlStmtInf() {
        return addtlStmtInf;
    }

    /**
     * ����addtlStmtInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlStmtInf(String value) {
        this.addtlStmtInf = value;
    }

}
