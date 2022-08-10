//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AmountRangeBoundary1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AmountRangeBoundary1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BdryAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ImpliedCurrencyAndAmount"/>
 *         &lt;element name="Incl" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}YesNoIndicator"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountRangeBoundary1", propOrder = {
    "bdryAmt",
    "incl"
})
public class AmountRangeBoundary1 {

    @XmlElement(name = "BdryAmt", required = true)
    protected BigDecimal bdryAmt;
    @XmlElement(name = "Incl")
    protected boolean incl;

    /**
     * 获取bdryAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBdryAmt() {
        return bdryAmt;
    }

    /**
     * 设置bdryAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBdryAmt(BigDecimal value) {
        this.bdryAmt = value;
    }

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

}
