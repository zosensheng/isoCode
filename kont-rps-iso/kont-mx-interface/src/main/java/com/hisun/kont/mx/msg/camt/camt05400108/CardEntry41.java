//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardEntry4__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardEntry4__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Card" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}PaymentCard4__1" minOccurs="0"/>
 *         &lt;element name="POI" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}PointOfInteraction1__1" minOccurs="0"/>
 *         &lt;element name="AggtdNtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CardAggregated2__1" minOccurs="0"/>
 *         &lt;element name="PrePdAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CashAccount38__2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardEntry4__1",  propOrder = {
    "card",
    "poi",
    "aggtdNtry",
    "prePdAcct"
})
public class CardEntry41 {

    @XmlElement(name = "Card")
    protected PaymentCard41 card;
    @XmlElement(name = "POI")
    protected PointOfInteraction11 poi;
    @XmlElement(name = "AggtdNtry")
    protected CardAggregated21 aggtdNtry;
    @XmlElement(name = "PrePdAcct")
    protected CashAccount382 prePdAcct;

    /**
     * 获取card属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentCard41 }
     *     
     */
    public PaymentCard41 getCard() {
        return card;
    }

    /**
     * 设置card属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCard41 }
     *     
     */
    public void setCard(PaymentCard41 value) {
        this.card = value;
    }

    /**
     * 获取poi属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PointOfInteraction11 }
     *     
     */
    public PointOfInteraction11 getPOI() {
        return poi;
    }

    /**
     * 设置poi属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PointOfInteraction11 }
     *     
     */
    public void setPOI(PointOfInteraction11 value) {
        this.poi = value;
    }

    /**
     * 获取aggtdNtry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardAggregated21 }
     *     
     */
    public CardAggregated21 getAggtdNtry() {
        return aggtdNtry;
    }

    /**
     * 设置aggtdNtry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardAggregated21 }
     *     
     */
    public void setAggtdNtry(CardAggregated21 value) {
        this.aggtdNtry = value;
    }

    /**
     * 获取prePdAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount382 }
     *     
     */
    public CashAccount382 getPrePdAcct() {
        return prePdAcct;
    }

    /**
     * 设置prePdAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount382 }
     *     
     */
    public void setPrePdAcct(CashAccount382 value) {
        this.prePdAcct = value;
    }

}
