//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Charges6__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Charges6__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TtlChrgsAndTaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Rcrd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}ChargesRecord3__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charges6__1",  propOrder = {
    "ttlChrgsAndTaxAmt",
    "rcrd"
})
public class Charges61 {

    @XmlElement(name = "TtlChrgsAndTaxAmt")
    protected ActiveOrHistoricCurrencyAndAmount ttlChrgsAndTaxAmt;
    @XmlElement(name = "Rcrd")
    protected List<ChargesRecord31> rcrd;

    /**
     * 获取ttlChrgsAndTaxAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getTtlChrgsAndTaxAmt() {
        return ttlChrgsAndTaxAmt;
    }

    /**
     * 设置ttlChrgsAndTaxAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlChrgsAndTaxAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlChrgsAndTaxAmt = value;
    }

    /**
     * Gets the value of the rcrd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rcrd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRcrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargesRecord31 }
     * 
     * 
     */
    public List<ChargesRecord31> getRcrd() {
        if (rcrd == null) {
            rcrd = new ArrayList<ChargesRecord31>();
        }
        return this.rcrd;
    }

}
