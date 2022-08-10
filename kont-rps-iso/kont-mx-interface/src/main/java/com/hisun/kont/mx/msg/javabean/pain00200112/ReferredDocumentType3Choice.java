//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the type of the document referred in the remittance information.
 * 
 * <p>ReferredDocumentType3Choice complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="ReferredDocumentType3Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Cd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DocumentType6Code"/>
 *         &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferredDocumentType3Choice", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "cd",
    "prtry"
})
public class ReferredDocumentType3Choice {

    @XmlElement(name = "Cd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "string")
    protected DocumentType6Code cd;
    @XmlElement(name = "Prtry", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String prtry;

    /**
     * 获取属性 cd 的值。
     * 
     * @return
     *     possible object is
     *     {@link DocumentType6Code }
     *     
     */
    public DocumentType6Code getCd() {
        return cd;
    }

    /**
     * 设置属性 cd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType6Code }
     *     
     */
    public void setCd(DocumentType6Code value) {
        this.cd = value;
    }

    /**
     * 获取属性 prtry 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtry() {
        return prtry;
    }

    /**
     * 设置属性 prtry 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtry(String value) {
        this.prtry = value;
    }

}
