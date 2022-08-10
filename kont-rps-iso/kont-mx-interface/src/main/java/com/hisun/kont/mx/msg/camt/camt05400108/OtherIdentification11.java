//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OtherIdentification1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OtherIdentification1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="Sfx" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}IdentificationSource3Choice__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherIdentification1__1",  propOrder = {
    "id",
    "sfx",
    "tp"
})
public class OtherIdentification11 {

    @XmlElement(name = "Id",  required = true)
    protected String id;
    @XmlElement(name = "Sfx")
    protected String sfx;
    @XmlElement(name = "Tp",  required = true)
    protected IdentificationSource3Choice1 tp;

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
     * 获取sfx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSfx() {
        return sfx;
    }

    /**
     * 设置sfx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSfx(String value) {
        this.sfx = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link IdentificationSource3Choice1 }
     *     
     */
    public IdentificationSource3Choice1 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationSource3Choice1 }
     *     
     */
    public void setTp(IdentificationSource3Choice1 value) {
        this.tp = value;
    }

}
