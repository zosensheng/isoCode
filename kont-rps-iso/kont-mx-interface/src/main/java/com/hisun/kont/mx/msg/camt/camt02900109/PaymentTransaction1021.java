//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentTransaction102__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction102__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CxlStsId" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax16Text"/>
 *         &lt;element name="RslvdCase" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}Case5__1"/>
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}OriginalGroupInformation29__1"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlTxId" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}UUIDv4Identifier"/>
 *         &lt;element name="CxlStsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CancellationStatusReason4__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction102__1", propOrder = {
    "cxlStsId",
    "rslvdCase",
    "orgnlGrpInf",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlClrSysRef",
    "orgnlUETR",
    "cxlStsRsnInf"
})
public class PaymentTransaction1021 {

    @XmlElement(name = "CxlStsId", required = true)
    protected String cxlStsId;
    @XmlElement(name = "RslvdCase", required = true)
    protected Case51 rslvdCase;
    @XmlElement(name = "OrgnlGrpInf", required = true)
    protected OriginalGroupInformation291 orgnlGrpInf;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId")
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlTxId")
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlClrSysRef")
    protected String orgnlClrSysRef;
    @XmlElement(name = "OrgnlUETR", required = true)
    protected String orgnlUETR;
    @XmlElement(name = "CxlStsRsnInf")
    protected CancellationStatusReason41 cxlStsRsnInf;

    /**
     * 获取cxlStsId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxlStsId() {
        return cxlStsId;
    }

    /**
     * 设置cxlStsId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxlStsId(String value) {
        this.cxlStsId = value;
    }

    /**
     * 获取rslvdCase属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Case51 }
     *     
     */
    public Case51 getRslvdCase() {
        return rslvdCase;
    }

    /**
     * 设置rslvdCase属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Case51 }
     *     
     */
    public void setRslvdCase(Case51 value) {
        this.rslvdCase = value;
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
     * 获取cxlStsRsnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancellationStatusReason41 }
     *     
     */
    public CancellationStatusReason41 getCxlStsRsnInf() {
        return cxlStsRsnInf;
    }

    /**
     * 设置cxlStsRsnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationStatusReason41 }
     *     
     */
    public void setCxlStsRsnInf(CancellationStatusReason41 value) {
        this.cxlStsRsnInf = value;
    }

}
