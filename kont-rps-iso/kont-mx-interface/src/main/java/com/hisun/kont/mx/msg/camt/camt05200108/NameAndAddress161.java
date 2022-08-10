//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NameAndAddress16__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NameAndAddress16__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax140Text_Extended"/>
 *         &lt;element name="Adr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PostalAddress24__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameAndAddress16__1", propOrder = {
    "nm",
    "adr"
})
public class NameAndAddress161 {

    @XmlElement(name = "Nm", required = true)
    protected String nm;
    @XmlElement(name = "Adr", required = true)
    protected PostalAddress241 adr;

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
     * 获取adr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress241 }
     *     
     */
    public PostalAddress241 getAdr() {
        return adr;
    }

    /**
     * 设置adr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress241 }
     *     
     */
    public void setAdr(PostalAddress241 value) {
        this.adr = value;
    }

}
