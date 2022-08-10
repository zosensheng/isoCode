//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:35 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00200110;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentTransaction110__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction110__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}OriginalGroupInformation29__1"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="OrgnlTxId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}UUIDv4Identifier"/>
 *         &lt;element name="TxSts" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}ExternalPaymentTransactionStatus1Code"/>
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}StatusReasonInformation12__1" minOccurs="0"/>
 *         &lt;element name="FctvIntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}DateAndDateTime2Choice__1" minOccurs="0"/>
 *         &lt;element name="ClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="InstgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}BranchAndFinancialInstitutionIdentification6__1"/>
 *         &lt;element name="InstdAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}BranchAndFinancialInstitutionIdentification6__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction110__1", propOrder = {
    "orgnlGrpInf",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlUETR",
    "txSts",
    "stsRsnInf",
    "fctvIntrBkSttlmDt",
    "clrSysRef",
    "instgAgt",
    "instdAgt"
})
public class PaymentTransaction1101 {

    @XmlElement(name = "OrgnlGrpInf", required = true)
    protected OriginalGroupInformation291 orgnlGrpInf;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId", required = true)
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlTxId")
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlUETR", required = true)
    protected String orgnlUETR;
    @XmlElement(name = "TxSts", required = true)
    protected String txSts;
    @XmlElement(name = "StsRsnInf")
    protected StatusReasonInformation121 stsRsnInf;
    @XmlElement(name = "FctvIntrBkSttlmDt")
    protected DateAndDateTime2Choice1 fctvIntrBkSttlmDt;
    @XmlElement(name = "ClrSysRef")
    protected String clrSysRef;
    @XmlElement(name = "InstgAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 instgAgt;
    @XmlElement(name = "InstdAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 instdAgt;

    /**
     * 获取orgnlGrpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformation291 }
     *     
     */
    public OriginalGroupInformation291 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * 设置orgnlGrpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformation291 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupInformation291 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * 获取orgnlInstrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * 设置orgnlInstrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * 获取orgnlEndToEndId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * 设置orgnlEndToEndId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * 获取orgnlTxId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxId() {
        return orgnlTxId;
    }

    /**
     * 设置orgnlTxId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxId(String value) {
        this.orgnlTxId = value;
    }

    /**
     * 获取orgnlUETR属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlUETR() {
        return orgnlUETR;
    }

    /**
     * 设置orgnlUETR属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlUETR(String value) {
        this.orgnlUETR = value;
    }

    /**
     * 获取txSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxSts() {
        return txSts;
    }

    /**
     * 设置txSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxSts(String value) {
        this.txSts = value;
    }

    /**
     * 获取stsRsnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link StatusReasonInformation121 }
     *     
     */
    public StatusReasonInformation121 getStsRsnInf() {
        return stsRsnInf;
    }

    /**
     * 设置stsRsnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReasonInformation121 }
     *     
     */
    public void setStsRsnInf(StatusReasonInformation121 value) {
        this.stsRsnInf = value;
    }

    /**
     * 获取fctvIntrBkSttlmDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public DateAndDateTime2Choice1 getFctvIntrBkSttlmDt() {
        return fctvIntrBkSttlmDt;
    }

    /**
     * 设置fctvIntrBkSttlmDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public void setFctvIntrBkSttlmDt(DateAndDateTime2Choice1 value) {
        this.fctvIntrBkSttlmDt = value;
    }

    /**
     * 获取clrSysRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClrSysRef() {
        return clrSysRef;
    }

    /**
     * 设置clrSysRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClrSysRef(String value) {
        this.clrSysRef = value;
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

}
