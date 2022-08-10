//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:34 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt06000105;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ReportingPeriod2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReportingPeriod2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FrToDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}DatePeriodDetails1"/>
 *         &lt;element name="FrToTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}TimePeriodDetails1__1" minOccurs="0"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}QueryType3Code"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportingPeriod2__1", propOrder = {
    "frToDt",
    "frToTm",
    "tp"
})
public class ReportingPeriod21 {

    @XmlElement(name = "FrToDt", required = true)
    protected DatePeriodDetails1 frToDt;
    @XmlElement(name = "FrToTm")
    protected TimePeriodDetails11 frToTm;
    @XmlElement(name = "Tp", required = true)
    @XmlSchemaType(name = "string")
    protected QueryType3Code tp;

    /**
     * 获取frToDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DatePeriodDetails1 }
     *     
     */
    public DatePeriodDetails1 getFrToDt() {
        return frToDt;
    }

    /**
     * 设置frToDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriodDetails1 }
     *     
     */
    public void setFrToDt(DatePeriodDetails1 value) {
        this.frToDt = value;
    }

    /**
     * 获取frToTm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodDetails11 }
     *     
     */
    public TimePeriodDetails11 getFrToTm() {
        return frToTm;
    }

    /**
     * 设置frToTm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodDetails11 }
     *     
     */
    public void setFrToTm(TimePeriodDetails11 value) {
        this.frToTm = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QueryType3Code }
     *     
     */
    public QueryType3Code getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QueryType3Code }
     *     
     */
    public void setTp(QueryType3Code value) {
        this.tp = value;
    }

}
