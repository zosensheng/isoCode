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
 * <p>CorporateAction9__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CorporateAction9__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EvtTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="EvtId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorporateAction9__1", propOrder = {
    "evtTp",
    "evtId"
})
public class CorporateAction91 {

    @XmlElement(name = "EvtTp", required = true)
    protected String evtTp;
    @XmlElement(name = "EvtId", required = true)
    protected String evtId;

    /**
     * 获取evtTp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtTp() {
        return evtTp;
    }

    /**
     * 设置evtTp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtTp(String value) {
        this.evtTp = value;
    }

    /**
     * 获取evtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtId() {
        return evtId;
    }

    /**
     * 设置evtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtId(String value) {
        this.evtId = value;
    }

}
