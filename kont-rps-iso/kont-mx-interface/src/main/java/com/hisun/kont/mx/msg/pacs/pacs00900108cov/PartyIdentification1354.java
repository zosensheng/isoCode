//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108cov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PartyIdentification135__4 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PartyIdentification135__4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax140Text_Extended" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}PostalAddress24__3" minOccurs="0"/>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}Party38Choice__1" minOccurs="0"/>
 *         &lt;element name="CtryOfRes" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CountryCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyIdentification135__4", propOrder = {
    "nm",
    "pstlAdr",
    "id",
    "ctryOfRes"
})
public class PartyIdentification1354 {

    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress243 pstlAdr;
    @XmlElement(name = "Id")
    protected Party38Choice1 id;
    @XmlElement(name = "CtryOfRes")
    protected String ctryOfRes;

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
     * 获取pstlAdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress243 }
     *     
     */
    public PostalAddress243 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * 设置pstlAdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress243 }
     *     
     */
    public void setPstlAdr(PostalAddress243 value) {
        this.pstlAdr = value;
    }

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party38Choice1 }
     *     
     */
    public Party38Choice1 getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party38Choice1 }
     *     
     */
    public void setId(Party38Choice1 value) {
        this.id = value;
    }

    /**
     * 获取ctryOfRes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtryOfRes() {
        return ctryOfRes;
    }

    /**
     * 设置ctryOfRes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtryOfRes(String value) {
        this.ctryOfRes = value;
    }

}
