//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnderlyingTransaction22__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UnderlyingTransaction22__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TxInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}PaymentTransaction102__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderlyingTransaction22__1", propOrder = {
    "txInfAndSts"
})
public class UnderlyingTransaction221 {

    @XmlElement(name = "TxInfAndSts", required = true)
    protected PaymentTransaction1021 txInfAndSts;

    /**
     * 获取txInfAndSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction1021 }
     *     
     */
    public PaymentTransaction1021 getTxInfAndSts() {
        return txInfAndSts;
    }

    /**
     * 设置txInfAndSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction1021 }
     *     
     */
    public void setTxInfAndSts(PaymentTransaction1021 value) {
        this.txInfAndSts = value;
    }

}
