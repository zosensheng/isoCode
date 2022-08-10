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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Range of time defined by a start date and an end date.
 * 
 * <p>DatePeriod2 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="DatePeriod2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FrDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate"/>
 *         &lt;element name="ToDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatePeriod2", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "frDt",
    "toDt"
})
public class DatePeriod2 {

    @XmlElement(name = "FrDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frDt;
    @XmlElement(name = "ToDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDt;

    /**
     * 获取属性 frDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrDt() {
        return frDt;
    }

    /**
     * 设置属性 frDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrDt(XMLGregorianCalendar value) {
        this.frDt = value;
    }

    /**
     * 获取属性 toDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDt() {
        return toDt;
    }

    /**
     * 设置属性 toDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDt(XMLGregorianCalendar value) {
        this.toDt = value;
    }

}
