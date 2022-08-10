//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00400109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AmountType4Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AmountType4Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="InstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_Amount__1"/>
 *         &lt;element name="EqvtAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}EquivalentAmount2__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountType4Choice__1", propOrder = {
    "instdAmt",
    "eqvtAmt"
})
public class AmountType4Choice1 {

    @XmlElement(name = "InstdAmt")
    protected CBPRAmount1 instdAmt;
    @XmlElement(name = "EqvtAmt")
    protected EquivalentAmount21 eqvtAmt;

    /**
     * 获取instdAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getInstdAmt() {
        return instdAmt;
    }

    /**
     * 设置instdAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setInstdAmt(CBPRAmount1 value) {
        this.instdAmt = value;
    }

    /**
     * 获取eqvtAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EquivalentAmount21 }
     *     
     */
    public EquivalentAmount21 getEqvtAmt() {
        return eqvtAmt;
    }

    /**
     * 设置eqvtAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EquivalentAmount21 }
     *     
     */
    public void setEqvtAmt(EquivalentAmount21 value) {
        this.eqvtAmt = value;
    }

}
