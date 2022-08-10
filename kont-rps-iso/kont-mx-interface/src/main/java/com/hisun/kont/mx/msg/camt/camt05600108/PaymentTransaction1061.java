//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05600108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>PaymentTransaction106__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction106__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CxlId" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="Case" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}Case5__1"/>
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}OriginalGroupInformation29__1"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="OrgnlTxId" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}UUIDv4Identifier"/>
 *         &lt;element name="OrgnlClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlIntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_Amount"/>
 *         &lt;element name="OrgnlIntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}ISODate"/>
 *         &lt;element name="CxlRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}PaymentCancellationReason5__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction106__1", propOrder = {
    "cxlId",
    "_case",
    "orgnlGrpInf",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlUETR",
    "orgnlClrSysRef",
    "orgnlIntrBkSttlmAmt",
    "orgnlIntrBkSttlmDt",
    "cxlRsnInf"
})
public class PaymentTransaction1061 {

    @XmlElement(name = "CxlId")
    protected String cxlId;
    @XmlElement(name = "Case", required = true)
    protected Case51 _case;
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
    @XmlElement(name = "OrgnlClrSysRef")
    protected String orgnlClrSysRef;
    @XmlElement(name = "OrgnlIntrBkSttlmAmt", required = true)
    protected CBPRAmount orgnlIntrBkSttlmAmt;
    @XmlElement(name = "OrgnlIntrBkSttlmDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlIntrBkSttlmDt;
    @XmlElement(name = "CxlRsnInf", required = true)
    protected PaymentCancellationReason51 cxlRsnInf;

    /**
     * 获取cxlId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxlId() {
        return cxlId;
    }

    /**
     * 设置cxlId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxlId(String value) {
        this.cxlId = value;
    }

    /**
     * 获取case属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Case51 }
     *     
     */
    public Case51 getCase() {
        return _case;
    }

    /**
     * 设置case属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Case51 }
     *     
     */
    public void setCase(Case51 value) {
        this._case = value;
    }

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
     * 获取orgnlClrSysRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlClrSysRef() {
        return orgnlClrSysRef;
    }

    /**
     * 设置orgnlClrSysRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlClrSysRef(String value) {
        this.orgnlClrSysRef = value;
    }

    /**
     * 获取orgnlIntrBkSttlmAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount }
     *     
     */
    public CBPRAmount getOrgnlIntrBkSttlmAmt() {
        return orgnlIntrBkSttlmAmt;
    }

    /**
     * 设置orgnlIntrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount }
     *     
     */
    public void setOrgnlIntrBkSttlmAmt(CBPRAmount value) {
        this.orgnlIntrBkSttlmAmt = value;
    }

    /**
     * 获取orgnlIntrBkSttlmDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlIntrBkSttlmDt() {
        return orgnlIntrBkSttlmDt;
    }

    /**
     * 设置orgnlIntrBkSttlmDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.orgnlIntrBkSttlmDt = value;
    }

    /**
     * 获取cxlRsnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentCancellationReason51 }
     *     
     */
    public PaymentCancellationReason51 getCxlRsnInf() {
        return cxlRsnInf;
    }

    /**
     * 设置cxlRsnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCancellationReason51 }
     *     
     */
    public void setCxlRsnInf(PaymentCancellationReason51 value) {
        this.cxlRsnInf = value;
    }

}
