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
 * <p>CreditorReferenceType2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditorReferenceType2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CdOrPrtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CreditorReferenceType1Choice__1"/>
 *         &lt;element name="Issr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text_Extended" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorReferenceType2__1", propOrder = {
    "cdOrPrtry",
    "issr"
})
public class CreditorReferenceType21 {

    @XmlElement(name = "CdOrPrtry", required = true)
    protected CreditorReferenceType1Choice1 cdOrPrtry;
    @XmlElement(name = "Issr")
    protected String issr;

    /**
     * 获取cdOrPrtry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceType1Choice1 }
     *     
     */
    public CreditorReferenceType1Choice1 getCdOrPrtry() {
        return cdOrPrtry;
    }

    /**
     * 设置cdOrPrtry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceType1Choice1 }
     *     
     */
    public void setCdOrPrtry(CreditorReferenceType1Choice1 value) {
        this.cdOrPrtry = value;
    }

    /**
     * 获取issr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssr() {
        return issr;
    }

    /**
     * 设置issr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssr(String value) {
        this.issr = value;
    }

}
