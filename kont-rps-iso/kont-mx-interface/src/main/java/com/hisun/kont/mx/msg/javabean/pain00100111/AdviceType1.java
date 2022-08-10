//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the type of advice to report back for the transaction.
 * 
 * <p>AdviceType1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="AdviceType1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CdtAdvc" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}AdviceType1Choice" minOccurs="0"/>
 *         &lt;element name="DbtAdvc" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}AdviceType1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdviceType1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "cdtAdvc",
    "dbtAdvc"
})
public class AdviceType1 {

    @XmlElement(name = "CdtAdvc", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected AdviceType1Choice cdtAdvc;
    @XmlElement(name = "DbtAdvc", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected AdviceType1Choice dbtAdvc;

    /**
     * 获取属性 cdtAdvc 的值。
     * 
     * @return
     *     possible object is
     *     {@link AdviceType1Choice }
     *     
     */
    public AdviceType1Choice getCdtAdvc() {
        return cdtAdvc;
    }

    /**
     * 设置属性 cdtAdvc 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AdviceType1Choice }
     *     
     */
    public void setCdtAdvc(AdviceType1Choice value) {
        this.cdtAdvc = value;
    }

    /**
     * 获取属性 dbtAdvc 的值。
     * 
     * @return
     *     possible object is
     *     {@link AdviceType1Choice }
     *     
     */
    public AdviceType1Choice getDbtAdvc() {
        return dbtAdvc;
    }

    /**
     * 设置属性 dbtAdvc 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AdviceType1Choice }
     *     
     */
    public void setDbtAdvc(AdviceType1Choice value) {
        this.dbtAdvc = value;
    }

}
