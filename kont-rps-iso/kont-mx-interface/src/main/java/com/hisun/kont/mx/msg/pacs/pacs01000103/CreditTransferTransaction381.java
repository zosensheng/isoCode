//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:39 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs01000103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreditTransferTransaction38__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditTransferTransaction38__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CdtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="InstgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="InstdAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__2" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CashAccount38__2" minOccurs="0"/>
 *         &lt;element name="DrctDbtTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}DirectDebitTransactionInformation25__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferTransaction38__1", propOrder = {
    "cdtId",
    "instgAgt",
    "instdAgt",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "drctDbtTxInf"
})
public class CreditTransferTransaction381 {

    @XmlElement(name = "CdtId", required = true)
    protected String cdtId;
    @XmlElement(name = "InstgAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 instgAgt;
    @XmlElement(name = "InstdAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 instdAgt;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification62 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount381 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected BranchAndFinancialInstitutionIdentification62 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount382 cdtrAcct;
    @XmlElement(name = "DrctDbtTxInf", required = true)
    protected DirectDebitTransactionInformation251 drctDbtTxInf;

    /**
     * 获取cdtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtId() {
        return cdtId;
    }

    /**
     * 设置cdtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtId(String value) {
        this.cdtId = value;
    }

    /**
     * 获取instgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getInstgAgt() {
        return instgAgt;
    }

    /**
     * 设置instgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setInstgAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.instgAgt = value;
    }

    /**
     * 获取instdAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getInstdAgt() {
        return instdAgt;
    }

    /**
     * 设置instdAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setInstdAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.instdAgt = value;
    }

    /**
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.cdtrAgt = value;
    }

    /**
     * 获取cdtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置cdtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount381 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setCdtr(BranchAndFinancialInstitutionIdentification62 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount382 }
     *     
     */
    public CashAccount382 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount382 }
     *     
     */
    public void setCdtrAcct(CashAccount382 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取drctDbtTxInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DirectDebitTransactionInformation251 }
     *     
     */
    public DirectDebitTransactionInformation251 getDrctDbtTxInf() {
        return drctDbtTxInf;
    }

    /**
     * 设置drctDbtTxInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DirectDebitTransactionInformation251 }
     *     
     */
    public void setDrctDbtTxInf(DirectDebitTransactionInformation251 value) {
        this.drctDbtTxInf = value;
    }

}
