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
 * <p>TransactionQuantities3Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionQuantities3Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Qty" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}FinancialInstrumentQuantity1Choice"/>
 *         &lt;element name="OrgnlAndCurFaceAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}OriginalAndCurrentQuantities1"/>
 *         &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ProprietaryQuantity1__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionQuantities3Choice__1", propOrder = {
    "qty",
    "orgnlAndCurFaceAmt",
    "prtry"
})
public class TransactionQuantities3Choice1 {

    @XmlElement(name = "Qty")
    protected FinancialInstrumentQuantity1Choice qty;
    @XmlElement(name = "OrgnlAndCurFaceAmt")
    protected OriginalAndCurrentQuantities1 orgnlAndCurFaceAmt;
    @XmlElement(name = "Prtry")
    protected ProprietaryQuantity11 prtry;

    /**
     * 获取qty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstrumentQuantity1Choice }
     *     
     */
    public FinancialInstrumentQuantity1Choice getQty() {
        return qty;
    }

    /**
     * 设置qty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstrumentQuantity1Choice }
     *     
     */
    public void setQty(FinancialInstrumentQuantity1Choice value) {
        this.qty = value;
    }

    /**
     * 获取orgnlAndCurFaceAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalAndCurrentQuantities1 }
     *     
     */
    public OriginalAndCurrentQuantities1 getOrgnlAndCurFaceAmt() {
        return orgnlAndCurFaceAmt;
    }

    /**
     * 设置orgnlAndCurFaceAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalAndCurrentQuantities1 }
     *     
     */
    public void setOrgnlAndCurFaceAmt(OriginalAndCurrentQuantities1 value) {
        this.orgnlAndCurFaceAmt = value;
    }

    /**
     * 获取prtry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ProprietaryQuantity11 }
     *     
     */
    public ProprietaryQuantity11 getPrtry() {
        return prtry;
    }

    /**
     * 设置prtry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ProprietaryQuantity11 }
     *     
     */
    public void setPrtry(ProprietaryQuantity11 value) {
        this.prtry = value;
    }

}
