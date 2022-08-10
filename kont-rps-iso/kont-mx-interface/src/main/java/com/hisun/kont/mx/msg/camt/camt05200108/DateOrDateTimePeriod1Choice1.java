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
 * <p>DateOrDateTimePeriod1Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DateOrDateTimePeriod1Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}DatePeriod2"/>
 *         &lt;element name="DtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}DateTimePeriod1__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateOrDateTimePeriod1Choice__1", propOrder = {
    "dt",
    "dtTm"
})
public class DateOrDateTimePeriod1Choice1 {

    @XmlElement(name = "Dt")
    protected DatePeriod2 dt;
    @XmlElement(name = "DtTm")
    protected DateTimePeriod11 dtTm;

    /**
     * 获取dt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DatePeriod2 }
     *     
     */
    public DatePeriod2 getDt() {
        return dt;
    }

    /**
     * 设置dt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriod2 }
     *     
     */
    public void setDt(DatePeriod2 value) {
        this.dt = value;
    }

    /**
     * 获取dtTm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public DateTimePeriod11 getDtTm() {
        return dtTm;
    }

    /**
     * 设置dtTm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePeriod11 }
     *     
     */
    public void setDtTm(DateTimePeriod11 value) {
        this.dtTm = value;
    }

}
