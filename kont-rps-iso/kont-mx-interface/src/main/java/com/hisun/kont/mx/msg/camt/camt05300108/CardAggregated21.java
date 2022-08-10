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


/**
 * <p>CardAggregated2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardAggregated2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddtlSvc" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CardPaymentServiceType2Code" minOccurs="0"/>
 *         &lt;element name="TxCtgy" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ExternalCardTransactionCategory1Code" minOccurs="0"/>
 *         &lt;element name="SaleRcncltnId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="SeqNbRg" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CardSequenceNumberRange1__1" minOccurs="0"/>
 *         &lt;element name="TxDtRg" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}DateOrDateTimePeriod1Choice__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAggregated2__1", propOrder = {
    "addtlSvc",
    "txCtgy",
    "saleRcncltnId",
    "seqNbRg",
    "txDtRg"
})
public class CardAggregated21 {

    @XmlElement(name = "AddtlSvc")
    @XmlSchemaType(name = "string")
    protected CardPaymentServiceType2Code addtlSvc;
    @XmlElement(name = "TxCtgy")
    protected String txCtgy;
    @XmlElement(name = "SaleRcncltnId")
    protected String saleRcncltnId;
    @XmlElement(name = "SeqNbRg")
    protected CardSequenceNumberRange11 seqNbRg;
    @XmlElement(name = "TxDtRg")
    protected DateOrDateTimePeriod1Choice1 txDtRg;

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
     * 获取seqNbRg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardSequenceNumberRange11 }
     *     
     */
    public CardSequenceNumberRange11 getSeqNbRg() {
        return seqNbRg;
    }

    /**
     * 设置seqNbRg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardSequenceNumberRange11 }
     *     
     */
    public void setSeqNbRg(CardSequenceNumberRange11 value) {
        this.seqNbRg = value;
    }

    /**
     * 获取txDtRg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateOrDateTimePeriod1Choice1 }
     *     
     */
    public DateOrDateTimePeriod1Choice1 getTxDtRg() {
        return txDtRg;
    }

    /**
     * 设置txDtRg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateOrDateTimePeriod1Choice1 }
     *     
     */
    public void setTxDtRg(DateOrDateTimePeriod1Choice1 value) {
        this.txDtRg = value;
    }

}
