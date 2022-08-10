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
 * Specifies the type of the document line identification.
 * 
 * <p>DocumentLineType1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="DocumentLineType1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CdOrPrtry" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}DocumentLineType1Choice"/>
 *         &lt;element name="Issr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineType1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "cdOrPrtry",
    "issr"
})
public class DocumentLineType1 {

    @XmlElement(name = "CdOrPrtry", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected DocumentLineType1Choice cdOrPrtry;
    @XmlElement(name = "Issr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String issr;

    /**
     * 获取属性 cdOrPrtry 的值。
     * 
     * @return
     *     possible object is
     *     {@link DocumentLineType1Choice }
     *     
     */
    public DocumentLineType1Choice getCdOrPrtry() {
        return cdOrPrtry;
    }

    /**
     * 设置属性 cdOrPrtry 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentLineType1Choice }
     *     
     */
    public void setCdOrPrtry(DocumentLineType1Choice value) {
        this.cdOrPrtry = value;
    }

    /**
     * 获取属性 issr 的值。
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
     * 设置属性 issr 的值。
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
