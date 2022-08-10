//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:33 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05700106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AccountIdentification4Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AccountIdentification4Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="IBAN" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}IBAN2007Identifier"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}GenericAccountIdentification1__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIdentification4Choice__1", propOrder = {
    "iban",
    "othr"
})
public class AccountIdentification4Choice1 {

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "Othr")
    protected GenericAccountIdentification11 othr;

    /**
     * 获取iban属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * 设置iban属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * 获取othr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GenericAccountIdentification11 }
     *     
     */
    public GenericAccountIdentification11 getOthr() {
        return othr;
    }

    /**
     * 设置othr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GenericAccountIdentification11 }
     *     
     */
    public void setOthr(GenericAccountIdentification11 value) {
        this.othr = value;
    }

}
