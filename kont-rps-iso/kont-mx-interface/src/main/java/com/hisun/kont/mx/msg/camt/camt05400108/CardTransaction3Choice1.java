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
 * <p>CardTransaction3Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardTransaction3Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Aggtd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CardAggregated2__1"/>
 *         &lt;element name="Indv" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CardIndividualTransaction2__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardTransaction3Choice__1",  propOrder = {
    "aggtd",
    "indv"
})
public class CardTransaction3Choice1 {

    @XmlElement(name = "Aggtd")
    protected CardAggregated21 aggtd;
    @XmlElement(name = "Indv")
    protected CardIndividualTransaction21 indv;

    /**
     * 获取aggtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardAggregated21 }
     *     
     */
    public CardAggregated21 getAggtd() {
        return aggtd;
    }

    /**
     * 设置aggtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardAggregated21 }
     *     
     */
    public void setAggtd(CardAggregated21 value) {
        this.aggtd = value;
    }

    /**
     * 获取indv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardIndividualTransaction21 }
     *     
     */
    public CardIndividualTransaction21 getIndv() {
        return indv;
    }

    /**
     * 设置indv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardIndividualTransaction21 }
     *     
     */
    public void setIndv(CardIndividualTransaction21 value) {
        this.indv = value;
    }

}
