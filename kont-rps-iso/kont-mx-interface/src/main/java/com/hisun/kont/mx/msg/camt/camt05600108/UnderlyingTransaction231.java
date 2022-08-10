//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05600108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnderlyingTransaction23__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UnderlyingTransaction23__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TxInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.056.001.08}PaymentTransaction106__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderlyingTransaction23__1", propOrder = {
    "txInf"
})
public class UnderlyingTransaction231 {

    @XmlElement(name = "TxInf", required = true)
    protected PaymentTransaction1061 txInf;

    /**
     * 获取txInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction1061 }
     *     
     */
    public PaymentTransaction1061 getTxInf() {
        return txInf;
    }

    /**
     * 设置txInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction1061 }
     *     
     */
    public void setTxInf(PaymentTransaction1061 value) {
        this.txInf = value;
    }

}
