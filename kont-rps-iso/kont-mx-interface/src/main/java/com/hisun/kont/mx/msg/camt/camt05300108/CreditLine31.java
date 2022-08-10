//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CreditLine3__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CreditLine3__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Incl" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}TrueFalseIndicator"/>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CreditLineType1Choice__1" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}DateAndDateTime2Choice__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditLine3__1", propOrder = {
    "incl",
    "tp",
    "amt",
    "dt"
})
public class CreditLine31 {

    @XmlElement(name = "Incl")
    protected boolean incl;
    @XmlElement(name = "Tp")
    protected CreditLineType1Choice1 tp;
    @XmlElement(name = "Amt")
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "Dt")
    protected DateAndDateTime2Choice1 dt;

    /**
     * 获取incl属性的值。
     * 
     */
    public boolean isIncl() {
        return incl;
    }

    /**
     * 设置incl属性的值。
     * 
     */
    public void setIncl(boolean value) {
        this.incl = value;
    }

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditLineType1Choice1 }
     *     
     */
    public CreditLineType1Choice1 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLineType1Choice1 }
     *     
     */
    public void setTp(CreditLineType1Choice1 value) {
        this.tp = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * 获取dt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public DateAndDateTime2Choice1 getDt() {
        return dt;
    }

    /**
     * 设置dt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public void setDt(DateAndDateTime2Choice1 value) {
        this.dt = value;
    }

}
