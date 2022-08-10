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
 * <p>PaymentCard4__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentCard4__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlainCardData" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PlainCardData1__1" minOccurs="0"/>
 *         &lt;element name="CardCtryCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Exact3NumericText" minOccurs="0"/>
 *         &lt;element name="CardBrnd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}GenericIdentification1__1" minOccurs="0"/>
 *         &lt;element name="AddtlCardData" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax70Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentCard4__1", propOrder = {
    "plainCardData",
    "cardCtryCd",
    "cardBrnd",
    "addtlCardData"
})
public class PaymentCard41 {

    @XmlElement(name = "PlainCardData")
    protected PlainCardData11 plainCardData;
    @XmlElement(name = "CardCtryCd")
    protected String cardCtryCd;
    @XmlElement(name = "CardBrnd")
    protected GenericIdentification11 cardBrnd;
    @XmlElement(name = "AddtlCardData")
    protected String addtlCardData;

    /**
     * 获取plainCardData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PlainCardData11 }
     *     
     */
    public PlainCardData11 getPlainCardData() {
        return plainCardData;
    }

    /**
     * 设置plainCardData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PlainCardData11 }
     *     
     */
    public void setPlainCardData(PlainCardData11 value) {
        this.plainCardData = value;
    }

    /**
     * 获取cardCtryCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardCtryCd() {
        return cardCtryCd;
    }

    /**
     * 设置cardCtryCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardCtryCd(String value) {
        this.cardCtryCd = value;
    }

    /**
     * 获取cardBrnd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GenericIdentification11 }
     *     
     */
    public GenericIdentification11 getCardBrnd() {
        return cardBrnd;
    }

    /**
     * 设置cardBrnd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIdentification11 }
     *     
     */
    public void setCardBrnd(GenericIdentification11 value) {
        this.cardBrnd = value;
    }

    /**
     * 获取addtlCardData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlCardData() {
        return addtlCardData;
    }

    /**
     * 设置addtlCardData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlCardData(String value) {
        this.addtlCardData = value;
    }

}
