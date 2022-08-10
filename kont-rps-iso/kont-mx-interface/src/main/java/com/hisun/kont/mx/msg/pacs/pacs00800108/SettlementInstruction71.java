//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SettlementInstruction7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SettlementInstruction7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SttlmMtd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}SettlementMethod1Code__1"/>
 *         &lt;element name="SttlmAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CashAccount38__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementInstruction7__1", propOrder = {
    "sttlmMtd",
    "sttlmAcct",
    "instgRmbrsmntAgt",
    "instgRmbrsmntAgtAcct",
    "instdRmbrsmntAgt",
    "instdRmbrsmntAgtAcct",
    "thrdRmbrsmntAgt",
    "thrdRmbrsmntAgtAcct"
})
public class SettlementInstruction71 {

    @XmlElement(name = "SttlmMtd", required = true)
    @XmlSchemaType(name = "string")
    protected SettlementMethod1Code1 sttlmMtd;
    @XmlElement(name = "SttlmAcct")
    protected CashAccount381 sttlmAcct;
    @XmlElement(name = "InstgRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt;
    @XmlElement(name = "InstgRmbrsmntAgtAcct")
    protected CashAccount381 instgRmbrsmntAgtAcct;
    @XmlElement(name = "InstdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt;
    @XmlElement(name = "InstdRmbrsmntAgtAcct")
    protected CashAccount381 instdRmbrsmntAgtAcct;
    @XmlElement(name = "ThrdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt;
    @XmlElement(name = "ThrdRmbrsmntAgtAcct")
    protected CashAccount381 thrdRmbrsmntAgtAcct;

    /**
     * 获取sttlmMtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod1Code1 }
     *     
     */
    public SettlementMethod1Code1 getSttlmMtd() {
        return sttlmMtd;
    }

    /**
     * 设置sttlmMtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod1Code1 }
     *     
     */
    public void setSttlmMtd(SettlementMethod1Code1 value) {
        this.sttlmMtd = value;
    }

    /**
     * 获取sttlmAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getSttlmAcct() {
        return sttlmAcct;
    }

    /**
     * 设置sttlmAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setSttlmAcct(CashAccount381 value) {
        this.sttlmAcct = value;
    }

    /**
     * 获取instgRmbrsmntAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getInstgRmbrsmntAgt() {
        return instgRmbrsmntAgt;
    }

    /**
     * 设置instgRmbrsmntAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setInstgRmbrsmntAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.instgRmbrsmntAgt = value;
    }

    /**
     * 获取instgRmbrsmntAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getInstgRmbrsmntAgtAcct() {
        return instgRmbrsmntAgtAcct;
    }

    /**
     * 设置instgRmbrsmntAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setInstgRmbrsmntAgtAcct(CashAccount381 value) {
        this.instgRmbrsmntAgtAcct = value;
    }

    /**
     * 获取instdRmbrsmntAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getInstdRmbrsmntAgt() {
        return instdRmbrsmntAgt;
    }

    /**
     * 设置instdRmbrsmntAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setInstdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.instdRmbrsmntAgt = value;
    }

    /**
     * 获取instdRmbrsmntAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getInstdRmbrsmntAgtAcct() {
        return instdRmbrsmntAgtAcct;
    }

    /**
     * 设置instdRmbrsmntAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setInstdRmbrsmntAgtAcct(CashAccount381 value) {
        this.instdRmbrsmntAgtAcct = value;
    }

    /**
     * 获取thrdRmbrsmntAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getThrdRmbrsmntAgt() {
        return thrdRmbrsmntAgt;
    }

    /**
     * 设置thrdRmbrsmntAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setThrdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.thrdRmbrsmntAgt = value;
    }

    /**
     * 获取thrdRmbrsmntAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getThrdRmbrsmntAgtAcct() {
        return thrdRmbrsmntAgtAcct;
    }

    /**
     * 设置thrdRmbrsmntAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setThrdRmbrsmntAgtAcct(CashAccount381 value) {
        this.thrdRmbrsmntAgtAcct = value;
    }

}
