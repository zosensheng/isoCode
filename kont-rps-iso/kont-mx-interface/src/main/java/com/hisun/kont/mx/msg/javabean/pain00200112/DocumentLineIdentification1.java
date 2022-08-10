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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Identifies the documents referred to in the remittance information.
 * 
 * <p>DocumentLineIdentification1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="DocumentLineIdentification1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DocumentLineType1" minOccurs="0"/>
 *         &lt;element name="Nb" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="RltdDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineIdentification1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "tp",
    "nb",
    "rltdDt"
})
public class DocumentLineIdentification1 {

    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected DocumentLineType1 tp;
    @XmlElement(name = "Nb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String nb;
    @XmlElement(name = "RltdDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rltdDt;

    /**
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link DocumentLineType1 }
     *     
     */
    public DocumentLineType1 getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentLineType1 }
     *     
     */
    public void setTp(DocumentLineType1 value) {
        this.tp = value;
    }

    /**
     * 获取属性 nb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNb() {
        return nb;
    }

    /**
     * 设置属性 nb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNb(String value) {
        this.nb = value;
    }

    /**
     * 获取属性 rltdDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRltdDt() {
        return rltdDt;
    }

    /**
     * 设置属性 rltdDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRltdDt(XMLGregorianCalendar value) {
        this.rltdDt = value;
    }

}
