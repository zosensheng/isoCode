//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:34 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt06000105;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReportingRequest5__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportingRequest5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="ReqdMsgNmId" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="Acct" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="AcctOwnr" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}Party40Choice__1"/>
 *         &lt;element name="AcctSvcr" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="RptgPrd" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}ReportingPeriod2__1" minOccurs="0"/>
 *         &lt;element name="RptgSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}SequenceRange1Choice__1" minOccurs="0"/>
 *         &lt;element name="ReqdTxTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}TransactionType2__1" minOccurs="0"/>
 *         &lt;element name="ReqdBalTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}BalanceType13__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportingRequest5__1", propOrder = {
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
public class ReportingRequest51 {

    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "ReqdMsgNmId", required = true)
    protected String reqdMsgNmId;
    @XmlElement(name = "Acct")
    protected CashAccount381 acct;
    @XmlElement(name = "AcctOwnr", required = true)
    protected Party40Choice1 acctOwnr;
    @XmlElement(name = "AcctSvcr")
    protected BranchAndFinancialInstitutionIdentification61 acctSvcr;
    @XmlElement(name = "RptgPrd")
    protected ReportingPeriod21 rptgPrd;
    @XmlElement(name = "RptgSeq")
    protected SequenceRange1Choice1 rptgSeq;
    @XmlElement(name = "ReqdTxTp")
    protected TransactionType21 reqdTxTp;
    @XmlElement(name = "ReqdBalTp")
    protected List<BalanceType131> reqdBalTp;

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
     * 获取reqdMsgNmId属性的值。
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
     * 设置reqdMsgNmId属性的值。
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
     * 获取acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getAcct() {
        return acct;
    }

    /**
     * 设置acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setAcct(CashAccount381 value) {
        this.acct = value;
    }

    /**
     * 获取acctOwnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getAcctOwnr() {
        return acctOwnr;
    }

    /**
     * 设置acctOwnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setAcctOwnr(Party40Choice1 value) {
        this.acctOwnr = value;
    }

    /**
     * 获取acctSvcr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getAcctSvcr() {
        return acctSvcr;
    }

    /**
     * 设置acctSvcr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setAcctSvcr(BranchAndFinancialInstitutionIdentification61 value) {
        this.acctSvcr = value;
    }

    /**
     * 获取rptgPrd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReportingPeriod21 }
     *     
     */
    public ReportingPeriod21 getRptgPrd() {
        return rptgPrd;
    }

    /**
     * 设置rptgPrd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReportingPeriod21 }
     *     
     */
    public void setRptgPrd(ReportingPeriod21 value) {
        this.rptgPrd = value;
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
     * 获取reqdTxTp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionType21 }
     *     
     */
    public TransactionType21 getReqdTxTp() {
        return reqdTxTp;
    }

    /**
     * 设置reqdTxTp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType21 }
     *     
     */
    public void setReqdTxTp(TransactionType21 value) {
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
     * {@link BalanceType131 }
     * 
     * 
     */
    public List<BalanceType131> getReqdBalTp() {
        if (reqdBalTp == null) {
            reqdBalTp = new ArrayList<BalanceType131>();
        }
        return this.reqdBalTp;
    }

}
