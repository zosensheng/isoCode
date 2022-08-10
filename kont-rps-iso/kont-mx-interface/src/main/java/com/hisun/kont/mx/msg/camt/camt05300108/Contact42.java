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
 * <p>Contact4__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Contact4__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax140Text_Extended" minOccurs="0"/>
 *         &lt;element name="PrefrdMtd" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}PreferredContactMethod1Code" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact4__2", propOrder = {
    "nm",
    "prefrdMtd"
})
public class Contact42 {

    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PrefrdMtd")
    @XmlSchemaType(name = "string")
    protected PreferredContactMethod1Code prefrdMtd;

    /**
     * 获取nm属性的值。
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
     * 设置nm属性的值。
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
     * 获取prefrdMtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public PreferredContactMethod1Code getPrefrdMtd() {
        return prefrdMtd;
    }

    /**
     * 设置prefrdMtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public void setPrefrdMtd(PreferredContactMethod1Code value) {
        this.prefrdMtd = value;
    }

}
