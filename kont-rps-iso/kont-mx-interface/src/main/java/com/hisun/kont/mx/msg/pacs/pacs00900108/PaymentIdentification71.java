//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentIdentification7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentIdentification7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax16Text"/>
 *         &lt;element name="EndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="TxId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}UUIDv4Identifier"/>
 *         &lt;element name="ClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentIdentification7__1", propOrder = {
    "instrId",
    "endToEndId",
    "txId",
    "uetr",
    "clrSysRef"
})
public class PaymentIdentification71 {

    @XmlElement(name = "InstrId", required = true)
    protected String instrId;
    @XmlElement(name = "EndToEndId", required = true)
    protected String endToEndId;
    @XmlElement(name = "TxId")
    protected String txId;
    @XmlElement(name = "UETR", required = true)
    protected String uetr;
    @XmlElement(name = "ClrSysRef")
    protected String clrSysRef;

    /**
     * 获取instrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrId() {
        return instrId;
    }

    /**
     * 设置instrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrId(String value) {
        this.instrId = value;
    }

    /**
     * 获取endToEndId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndToEndId() {
        return endToEndId;
    }

    /**
     * 设置endToEndId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndToEndId(String value) {
        this.endToEndId = value;
    }

    /**
     * 获取txId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxId() {
        return txId;
    }

    /**
     * 设置txId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxId(String value) {
        this.txId = value;
    }

    /**
     * 获取uetr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUETR() {
        return uetr;
    }

    /**
     * 设置uetr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUETR(String value) {
        this.uetr = value;
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

}
