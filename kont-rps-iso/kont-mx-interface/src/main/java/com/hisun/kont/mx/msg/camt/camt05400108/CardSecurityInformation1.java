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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardSecurityInformation1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CardSecurityInformation1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CSCMgmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CSCManagement1Code"/>
 *         &lt;element name="CSCVal" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}Min3Max4NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardSecurityInformation1",  propOrder = {
    "cscMgmt",
    "cscVal"
})
public class CardSecurityInformation1 {

    @XmlElement(name = "CSCMgmt",  required = true)
    @XmlSchemaType(name = "string")
    protected CSCManagement1Code cscMgmt;
    @XmlElement(name = "CSCVal")
    protected String cscVal;

    /**
     * 获取cscMgmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CSCManagement1Code }
     *     
     */
    public CSCManagement1Code getCSCMgmt() {
        return cscMgmt;
    }

    /**
     * 设置cscMgmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CSCManagement1Code }
     *     
     */
    public void setCSCMgmt(CSCManagement1Code value) {
        this.cscMgmt = value;
    }

    /**
     * 获取cscVal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSCVal() {
        return cscVal;
    }

    /**
     * 设置cscVal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSCVal(String value) {
        this.cscVal = value;
    }

}
