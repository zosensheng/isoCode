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
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the amount of money to be moved between the debtor and creditor, before deduction of charges, expressed in the currency as ordered by the initiating party.
 * 
 * <p>AmountType4Choice complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="AmountType4Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="InstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="EqvtAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}EquivalentAmount2"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType4Choice", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "instdAmt",
    "eqvtAmt"
})
public class AmountType4Choice {

    @XmlElement(name = "InstdAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected ActiveOrHistoricCurrencyAndAmount instdAmt;
    @XmlElement(name = "EqvtAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected EquivalentAmount2 eqvtAmt;

    /**
     * 获取属性 instdAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getInstdAmt() {
        return instdAmt;
    }

    /**
     * 设置属性 instdAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setInstdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.instdAmt = value;
    }

    /**
     * 获取属性 eqvtAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link EquivalentAmount2 }
     *     
     */
    public EquivalentAmount2 getEqvtAmt() {
        return eqvtAmt;
    }

    /**
     * 设置属性 eqvtAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EquivalentAmount2 }
     *     
     */
    public void setEqvtAmt(EquivalentAmount2 value) {
        this.eqvtAmt = value;
    }

}
