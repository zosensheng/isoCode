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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Case5__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Case5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}CBPR_RestrictedFINXMax16Text"/>
 *         &lt;element name="Cretr" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}Party40Choice__2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Case5__1", propOrder = {
    "id",
    "cretr"
})
public class Case51 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Cretr", required = true)
    protected Party40Choice2 cretr;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取cretr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice2 }
     *     
     */
    public Party40Choice2 getCretr() {
        return cretr;
    }

    /**
     * 设置cretr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice2 }
     *     
     */
    public void setCretr(Party40Choice2 value) {
        this.cretr = value;
    }

}
