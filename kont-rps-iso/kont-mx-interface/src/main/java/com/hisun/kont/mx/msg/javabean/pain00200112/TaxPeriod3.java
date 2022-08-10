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
 * Period of time details related to the tax payment.
 * 
 * <p>TaxPeriod3 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="TaxPeriod3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Yr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISOYear" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}TaxRecordPeriod1Code" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DatePeriod2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxPeriod3", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "yr",
    "tp",
    "frToDt"
})
public class TaxPeriod3 {

    @XmlElement(name = "Yr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yr;
    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "string")
    protected TaxRecordPeriod1Code tp;
    @XmlElement(name = "FrToDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected DatePeriod2 frToDt;

    /**
     * 获取属性 yr 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getYr() {
        return yr;
    }

    /**
     * 设置属性 yr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setYr(XMLGregorianCalendar value) {
        this.yr = value;
    }

    /**
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxRecordPeriod1Code }
     *     
     */
    public TaxRecordPeriod1Code getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRecordPeriod1Code }
     *     
     */
    public void setTp(TaxRecordPeriod1Code value) {
        this.tp = value;
    }

    /**
     * 获取属性 frToDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link DatePeriod2 }
     *     
     */
    public DatePeriod2 getFrToDt() {
        return frToDt;
    }

    /**
     * 设置属性 frToDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriod2 }
     *     
     */
    public void setFrToDt(DatePeriod2 value) {
        this.frToDt = value;
    }

}
