//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00100109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustomerCreditTransferInitiationV09 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransferInitiationV09">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}GroupHeader85__1"/>
 *         &lt;element name="PmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.09}PaymentInstruction30__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransferInitiationV09", propOrder = {
    "grpHdr",
    "pmtInf"
})
public class CustomerCreditTransferInitiationV09 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader851 grpHdr;
    @XmlElement(name = "PmtInf", required = true)
    protected PaymentInstruction301 pmtInf;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader851 }
     *     
     */
    public GroupHeader851 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader851 }
     *     
     */
    public void setGrpHdr(GroupHeader851 value) {
        this.grpHdr = value;
    }

    /**
     * 获取pmtInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstruction301 }
     *     
     */
    public PaymentInstruction301 getPmtInf() {
        return pmtInf;
    }

    /**
     * 设置pmtInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstruction301 }
     *     
     */
    public void setPmtInf(PaymentInstruction301 value) {
        this.pmtInf = value;
    }

}
