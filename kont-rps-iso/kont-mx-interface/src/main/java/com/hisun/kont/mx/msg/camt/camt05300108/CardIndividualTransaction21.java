//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>CardIndividualTransaction2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardIndividualTransaction2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ICCRltdData" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax1025Text" minOccurs="0"/>
 *         &lt;element name="PmtCntxt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}PaymentContext3" minOccurs="0"/>
 *         &lt;element name="AddtlSvc" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CardPaymentServiceType2Code" minOccurs="0"/>
 *         &lt;element name="TxCtgy" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ExternalCardTransactionCategory1Code" minOccurs="0"/>
 *         &lt;element name="SaleRcncltnId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="SaleRefNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="RePresntmntRsn" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ExternalRePresentmentReason1Code" minOccurs="0"/>
 *         &lt;element name="SeqNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="TxId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}TransactionIdentifier1__1" minOccurs="0"/>
 *         &lt;element name="Pdct" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Product2__1" minOccurs="0"/>
 *         &lt;element name="VldtnDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ISODate" minOccurs="0"/>
 *         &lt;element name="VldtnSeqNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardIndividualTransaction2__1", propOrder = {
    "iccRltdData",
    "pmtCntxt",
    "addtlSvc",
    "txCtgy",
    "saleRcncltnId",
    "saleRefNb",
    "rePresntmntRsn",
    "seqNb",
    "txId",
    "pdct",
    "vldtnDt",
    "vldtnSeqNb"
})
public class CardIndividualTransaction21 {

    @XmlElement(name = "ICCRltdData")
    protected String iccRltdData;
    @XmlElement(name = "PmtCntxt")
    protected PaymentContext3 pmtCntxt;
    @XmlElement(name = "AddtlSvc")
    @XmlSchemaType(name = "string")
    protected CardPaymentServiceType2Code addtlSvc;
    @XmlElement(name = "TxCtgy")
    protected String txCtgy;
    @XmlElement(name = "SaleRcncltnId")
    protected String saleRcncltnId;
    @XmlElement(name = "SaleRefNb")
    protected String saleRefNb;
    @XmlElement(name = "RePresntmntRsn")
    protected String rePresntmntRsn;
    @XmlElement(name = "SeqNb")
    protected String seqNb;
    @XmlElement(name = "TxId")
    protected TransactionIdentifier11 txId;
    @XmlElement(name = "Pdct")
    protected Product21 pdct;
    @XmlElement(name = "VldtnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vldtnDt;
    @XmlElement(name = "VldtnSeqNb")
    protected String vldtnSeqNb;

    /**
     * 获取iccRltdData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICCRltdData() {
        return iccRltdData;
    }

    /**
     * 设置iccRltdData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICCRltdData(String value) {
        this.iccRltdData = value;
    }

    /**
     * 获取pmtCntxt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentContext3 }
     *     
     */
    public PaymentContext3 getPmtCntxt() {
        return pmtCntxt;
    }

    /**
     * 设置pmtCntxt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentContext3 }
     *     
     */
    public void setPmtCntxt(PaymentContext3 value) {
        this.pmtCntxt = value;
    }

    /**
     * 获取addtlSvc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardPaymentServiceType2Code }
     *     
     */
    public CardPaymentServiceType2Code getAddtlSvc() {
        return addtlSvc;
    }

    /**
     * 设置addtlSvc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardPaymentServiceType2Code }
     *     
     */
    public void setAddtlSvc(CardPaymentServiceType2Code value) {
        this.addtlSvc = value;
    }

    /**
     * 获取txCtgy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxCtgy() {
        return txCtgy;
    }

    /**
     * 设置txCtgy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxCtgy(String value) {
        this.txCtgy = value;
    }

    /**
     * 获取saleRcncltnId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleRcncltnId() {
        return saleRcncltnId;
    }

    /**
     * 设置saleRcncltnId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleRcncltnId(String value) {
        this.saleRcncltnId = value;
    }

    /**
     * 获取saleRefNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleRefNb() {
        return saleRefNb;
    }

    /**
     * 设置saleRefNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleRefNb(String value) {
        this.saleRefNb = value;
    }

    /**
     * 获取rePresntmntRsn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRePresntmntRsn() {
        return rePresntmntRsn;
    }

    /**
     * 设置rePresntmntRsn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRePresntmntRsn(String value) {
        this.rePresntmntRsn = value;
    }

    /**
     * 获取seqNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNb() {
        return seqNb;
    }

    /**
     * 设置seqNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNb(String value) {
        this.seqNb = value;
    }

    /**
     * 获取txId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentifier11 }
     *     
     */
    public TransactionIdentifier11 getTxId() {
        return txId;
    }

    /**
     * 设置txId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentifier11 }
     *     
     */
    public void setTxId(TransactionIdentifier11 value) {
        this.txId = value;
    }

    /**
     * 获取pdct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Product21 }
     *     
     */
    public Product21 getPdct() {
        return pdct;
    }

    /**
     * 设置pdct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Product21 }
     *     
     */
    public void setPdct(Product21 value) {
        this.pdct = value;
    }

    /**
     * 获取vldtnDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVldtnDt() {
        return vldtnDt;
    }

    /**
     * 设置vldtnDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVldtnDt(XMLGregorianCalendar value) {
        this.vldtnDt = value;
    }

    /**
     * 获取vldtnSeqNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVldtnSeqNb() {
        return vldtnSeqNb;
    }

    /**
     * 设置vldtnSeqNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVldtnSeqNb(String value) {
        this.vldtnSeqNb = value;
    }

}
