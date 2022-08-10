//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides additional details on the remittance advice.
 * 
 * <p>RemittanceLocationData1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="RemittanceLocationData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RemittanceLocationMethod2Code"/>
 *         &lt;element name="ElctrncAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max2048Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}NameAndAddress16" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemittanceLocationData1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "mtd",
    "elctrncAdr",
    "pstlAdr"
})
public class RemittanceLocationData1 {

    @XmlElement(name = "Mtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    @XmlSchemaType(name = "string")
    protected RemittanceLocationMethod2Code mtd;
    @XmlElement(name = "ElctrncAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String elctrncAdr;
    @XmlElement(name = "PstlAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected NameAndAddress16 pstlAdr;

    /**
     * 获取属性 mtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceLocationMethod2Code }
     *     
     */
    public RemittanceLocationMethod2Code getMtd() {
        return mtd;
    }

    /**
     * 设置属性 mtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceLocationMethod2Code }
     *     
     */
    public void setMtd(RemittanceLocationMethod2Code value) {
        this.mtd = value;
    }

    /**
     * 获取属性 elctrncAdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElctrncAdr() {
        return elctrncAdr;
    }

    /**
     * 设置属性 elctrncAdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElctrncAdr(String value) {
        this.elctrncAdr = value;
    }

    /**
     * 获取属性 pstlAdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress16 }
     *     
     */
    public NameAndAddress16 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * 设置属性 pstlAdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress16 }
     *     
     */
    public void setPstlAdr(NameAndAddress16 value) {
        this.pstlAdr = value;
    }

}
