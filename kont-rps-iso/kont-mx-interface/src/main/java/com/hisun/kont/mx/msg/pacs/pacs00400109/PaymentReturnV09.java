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
 * <p>PaymentReturnV09 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentReturnV09">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}GroupHeader90__1"/>
 *         &lt;element name="TxInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PaymentTransaction112__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReturnV09", propOrder = {
    "grpHdr",
    "txInf"
})
public class PaymentReturnV09 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader901 grpHdr;
    @XmlElement(name = "TxInf", required = true)
    protected PaymentTransaction1121 txInf;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader901 }
     *     
     */
    public GroupHeader901 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader901 }
     *     
     */
    public void setGrpHdr(GroupHeader901 value) {
        this.grpHdr = value;
    }

    /**
     * 获取txInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction1121 }
     *     
     */
    public PaymentTransaction1121 getTxInf() {
        return txInf;
    }

    /**
     * 设置txInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction1121 }
     *     
     */
    public void setTxInf(PaymentTransaction1121 value) {
        this.txInf = value;
    }

}
