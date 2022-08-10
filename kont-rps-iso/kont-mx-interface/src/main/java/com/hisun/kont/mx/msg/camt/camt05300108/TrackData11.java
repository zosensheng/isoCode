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
 * <p>TrackData1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TrackData1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrckNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Exact1NumericText" minOccurs="0"/>
 *         &lt;element name="TrckVal" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax140Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackData1__1", propOrder = {
    "trckNb",
    "trckVal"
})
public class TrackData11 {

    @XmlElement(name = "TrckNb")
    protected String trckNb;
    @XmlElement(name = "TrckVal", required = true)
    protected String trckVal;

    /**
     * 获取trckNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckNb() {
        return trckNb;
    }

    /**
     * 设置trckNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckNb(String value) {
        this.trckNb = value;
    }

    /**
     * 获取trckVal属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckVal() {
        return trckVal;
    }

    /**
     * 设置trckVal属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckVal(String value) {
        this.trckVal = value;
    }

}
