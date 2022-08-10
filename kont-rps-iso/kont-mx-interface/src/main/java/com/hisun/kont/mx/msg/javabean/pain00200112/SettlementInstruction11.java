//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details on the settlement of the instruction.
 * 
 * <p>SettlementInstruction11 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="SettlementInstruction11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SttlmMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}SettlementMethod1Code"/>
 *         &lt;element name="SttlmAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="ClrSys" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ClearingSystemIdentification3Choice" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementInstruction11", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "sttlmMtd",
    "sttlmAcct",
    "clrSys",
    "instgRmbrsmntAgt",
    "instgRmbrsmntAgtAcct",
    "instdRmbrsmntAgt",
    "instdRmbrsmntAgtAcct",
    "thrdRmbrsmntAgt",
    "thrdRmbrsmntAgtAcct"
})
public class SettlementInstruction11 {

    @XmlElement(name = "SttlmMtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    @XmlSchemaType(name = "string")
    protected SettlementMethod1Code sttlmMtd;
    @XmlElement(name = "SttlmAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 sttlmAcct;
    @XmlElement(name = "ClrSys", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected ClearingSystemIdentification3Choice clrSys;
    @XmlElement(name = "InstgRmbrsmntAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt;
    @XmlElement(name = "InstgRmbrsmntAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 instgRmbrsmntAgtAcct;
    @XmlElement(name = "InstdRmbrsmntAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt;
    @XmlElement(name = "InstdRmbrsmntAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 instdRmbrsmntAgtAcct;
    @XmlElement(name = "ThrdRmbrsmntAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt;
    @XmlElement(name = "ThrdRmbrsmntAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 thrdRmbrsmntAgtAcct;

    /**
     * 获取属性 sttlmMtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public SettlementMethod1Code getSttlmMtd() {
        return sttlmMtd;
    }

    /**
     * 设置属性 sttlmMtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public void setSttlmMtd(SettlementMethod1Code value) {
        this.sttlmMtd = value;
    }

    /**
     * 获取属性 sttlmAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getSttlmAcct() {
        return sttlmAcct;
    }

    /**
     * 设置属性 sttlmAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setSttlmAcct(CashAccount40 value) {
        this.sttlmAcct = value;
    }

    /**
     * 获取属性 clrSys 的值。
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public ClearingSystemIdentification3Choice getClrSys() {
        return clrSys;
    }

    /**
     * 设置属性 clrSys 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public void setClrSys(ClearingSystemIdentification3Choice value) {
        this.clrSys = value;
    }

    /**
     * 获取属性 instgRmbrsmntAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstgRmbrsmntAgt() {
        return instgRmbrsmntAgt;
    }

    /**
     * 设置属性 instgRmbrsmntAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstgRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instgRmbrsmntAgt = value;
    }

    /**
     * 获取属性 instgRmbrsmntAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getInstgRmbrsmntAgtAcct() {
        return instgRmbrsmntAgtAcct;
    }

    /**
     * 设置属性 instgRmbrsmntAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setInstgRmbrsmntAgtAcct(CashAccount40 value) {
        this.instgRmbrsmntAgtAcct = value;
    }

    /**
     * 获取属性 instdRmbrsmntAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstdRmbrsmntAgt() {
        return instdRmbrsmntAgt;
    }

    /**
     * 设置属性 instdRmbrsmntAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instdRmbrsmntAgt = value;
    }

    /**
     * 获取属性 instdRmbrsmntAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getInstdRmbrsmntAgtAcct() {
        return instdRmbrsmntAgtAcct;
    }

    /**
     * 设置属性 instdRmbrsmntAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setInstdRmbrsmntAgtAcct(CashAccount40 value) {
        this.instdRmbrsmntAgtAcct = value;
    }

    /**
     * 获取属性 thrdRmbrsmntAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getThrdRmbrsmntAgt() {
        return thrdRmbrsmntAgt;
    }

    /**
     * 设置属性 thrdRmbrsmntAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setThrdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.thrdRmbrsmntAgt = value;
    }

    /**
     * 获取属性 thrdRmbrsmntAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getThrdRmbrsmntAgtAcct() {
        return thrdRmbrsmntAgtAcct;
    }

    /**
     * 设置属性 thrdRmbrsmntAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setThrdRmbrsmntAgtAcct(CashAccount40 value) {
        this.thrdRmbrsmntAgtAcct = value;
    }

}
