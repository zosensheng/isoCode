//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NumberAndSumOfTransactions4 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NumberAndSumOfTransactions4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NbOfNtries" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="Sum" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="TtlNetNtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}AmountAndDirection35" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberAndSumOfTransactions4",  propOrder = {
    "nbOfNtries",
    "sum",
    "ttlNetNtry"
})
public class NumberAndSumOfTransactions4 {

    @XmlElement(name = "NbOfNtries")
    protected String nbOfNtries;
    @XmlElement(name = "Sum")
    protected BigDecimal sum;
    @XmlElement(name = "TtlNetNtry")
    protected AmountAndDirection35 ttlNetNtry;

    /**
     * 获取nbOfNtries属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfNtries() {
        return nbOfNtries;
    }

    /**
     * 设置nbOfNtries属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfNtries(String value) {
        this.nbOfNtries = value;
    }

    /**
     * 获取sum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * 设置sum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSum(BigDecimal value) {
        this.sum = value;
    }

    /**
     * 获取ttlNetNtry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndDirection35 }
     *     
     */
    public AmountAndDirection35 getTtlNetNtry() {
        return ttlNetNtry;
    }

    /**
     * 设置ttlNetNtry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndDirection35 }
     *     
     */
    public void setTtlNetNtry(AmountAndDirection35 value) {
        this.ttlNetNtry = value;
    }

}
