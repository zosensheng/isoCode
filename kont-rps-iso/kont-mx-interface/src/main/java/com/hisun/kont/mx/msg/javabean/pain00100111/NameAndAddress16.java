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
import javax.xml.bind.annotation.XmlType;


/**
 * Information that locates and identifies a party.
 * 
 * <p>NameAndAddress16 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="NameAndAddress16">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text"/>
 *         &lt;element name="Adr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PostalAddress24"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameAndAddress16", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "nm",
    "adr"
})
public class NameAndAddress16 {

    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String nm;
    @XmlElement(name = "Adr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected PostalAddress24 adr;

    /**
     * 获取属性 nm 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * 设置属性 nm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * 获取属性 adr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress24 }
     *     
     */
    public PostalAddress24 getAdr() {
        return adr;
    }

    /**
     * 设置属性 adr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress24 }
     *     
     */
    public void setAdr(PostalAddress24 value) {
        this.adr = value;
    }

}
