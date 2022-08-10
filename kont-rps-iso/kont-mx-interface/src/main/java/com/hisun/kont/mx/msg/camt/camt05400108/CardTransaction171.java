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
 * <p>CardTransaction17__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardTransaction17__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Card" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}PaymentCard4__1" minOccurs="0"/>
 *         &lt;element name="POI" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}PointOfInteraction1__1" minOccurs="0"/>
 *         &lt;element name="Tx" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CardTransaction3Choice__1" minOccurs="0"/>
 *         &lt;element name="PrePdAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CashAccount38__4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardTransaction17__1",  propOrder = {
    "card",
    "poi",
    "tx",
    "prePdAcct"
})
public class CardTransaction171 {

    @XmlElement(name = "Card")
    protected PaymentCard41 card;
    @XmlElement(name = "POI")
    protected PointOfInteraction11 poi;
    @XmlElement(name = "Tx")
    protected CardTransaction3Choice1 tx;
    @XmlElement(name = "PrePdAcct")
    protected CashAccount384 prePdAcct;

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
     * 获取tx属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardTransaction3Choice1 }
     *     
     */
    public CardTransaction3Choice1 getTx() {
        return tx;
    }

    /**
     * 设置tx属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardTransaction3Choice1 }
     *     
     */
    public void setTx(CardTransaction3Choice1 value) {
        this.tx = value;
    }

    /**
     * 获取prePdAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount384 }
     *     
     */
    public CashAccount384 getPrePdAcct() {
        return prePdAcct;
    }

    /**
     * 设置prePdAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount384 }
     *     
     */
    public void setPrePdAcct(CashAccount384 value) {
        this.prePdAcct = value;
    }

}
