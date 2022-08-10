package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details on the reporting request.
 * 
 * <p>ReportingRequest6 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReportingRequest6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="ReqdMsgNmId" type="{}Max35Text"/>
 *         &lt;element name="Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="AcctOwnr" type="{}Party40Choice"/>
 *         &lt;element name="AcctSvcr" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="RptgPrd" type="{}ReportingPeriod5" minOccurs="0"/>
 *         &lt;element name="RptgSeq" type="{}SequenceRange1Choice" minOccurs="0"/>
 *         &lt;element name="ReqdTxTp" type="{}TransactionType2" minOccurs="0"/>
 *         &lt;element name="ReqdBalTp" type="{}BalanceType13" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportingRequest6", propOrder = {
    "id",
    "reqdMsgNmId",
    "acct",
    "acctOwnr",
    "acctSvcr",
    "rptgPrd",
    "rptgSeq",
    "reqdTxTp",
    "reqdBalTp"
})
public class ReportingRequest6 {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "ReqdMsgNmId", required = true)
    protected String reqdMsgNmId;
    @XmlElement(name = "Acct")
    protected CashAccount40 acct;
    @XmlElement(name = "AcctOwnr", required = true)
    protected Party40Choice acctOwnr;
    @XmlElement(name = "AcctSvcr")
    protected BranchAndFinancialInstitutionIdentification6 acctSvcr;
    @XmlElement(name = "RptgPrd")
    protected ReportingPeriod5 rptgPrd;
    @XmlElement(name = "RptgSeq")
    protected SequenceRange1Choice rptgSeq;
    @XmlElement(name = "ReqdTxTp")
    protected TransactionType2 reqdTxTp;
    @XmlElement(name = "ReqdBalTp")
    protected List<BalanceType13> reqdBalTp;

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
     * ��ȡreqdMsgNmId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReqdMsgNmId() {
        return reqdMsgNmId;
    }

    /**
     * ����reqdMsgNmId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReqdMsgNmId(String value) {
        this.reqdMsgNmId = value;
    }

    /**
     * ��ȡacct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getAcct() {
        return acct;
    }

    /**
     * ����acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setAcct(CashAccount40 value) {
        this.acct = value;
    }

    /**
     * ��ȡacctOwnr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getAcctOwnr() {
        return acctOwnr;
    }

    /**
     * ����acctOwnr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setAcctOwnr(Party40Choice value) {
        this.acctOwnr = value;
    }

    /**
     * ��ȡacctSvcr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getAcctSvcr() {
        return acctSvcr;
    }

    /**
     * ����acctSvcr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setAcctSvcr(BranchAndFinancialInstitutionIdentification6 value) {
        this.acctSvcr = value;
    }

    /**
     * ��ȡrptgPrd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ReportingPeriod5 }
     *     
     */
    public ReportingPeriod5 getRptgPrd() {
        return rptgPrd;
    }

    /**
     * ����rptgPrd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingPeriod5 }
     *     
     */
    public void setRptgPrd(ReportingPeriod5 value) {
        this.rptgPrd = value;
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
     * ��ȡreqdTxTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionType2 }
     *     
     */
    public TransactionType2 getReqdTxTp() {
        return reqdTxTp;
    }

    /**
     * ����reqdTxTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType2 }
     *     
     */
    public void setReqdTxTp(TransactionType2 value) {
        this.reqdTxTp = value;
    }

    /**
     * Gets the value of the reqdBalTp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reqdBalTp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReqdBalTp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BalanceType13 }
     * 
     * 
     */
    public List<BalanceType13> getReqdBalTp() {
        if (reqdBalTp == null) {
            reqdBalTp = new ArrayList<BalanceType13>();
        }
        return this.reqdBalTp;
    }

}
