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
 * Set of elements used to further detail the information related to the type of payment.
 * 
 * <p>MandateTypeInformation2 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="MandateTypeInformation2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SvcLvl" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ServiceLevel8Choice" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CategoryPurpose1Choice" minOccurs="0"/>
 *         &lt;element name="Clssfctn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}MandateClassification1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateTypeInformation2", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "svcLvl",
    "lclInstrm",
    "ctgyPurp",
    "clssfctn"
})
public class MandateTypeInformation2 {

    @XmlElement(name = "SvcLvl", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected ServiceLevel8Choice svcLvl;
    @XmlElement(name = "LclInstrm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "CtgyPurp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CategoryPurpose1Choice ctgyPurp;
    @XmlElement(name = "Clssfctn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected MandateClassification1Choice clssfctn;

    /**
     * 获取属性 svcLvl 的值。
     * 
     * @return
     *     possible object is
     *     {@link ServiceLevel8Choice }
     *     
     */
    public ServiceLevel8Choice getSvcLvl() {
        return svcLvl;
    }

    /**
     * 设置属性 svcLvl 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceLevel8Choice }
     *     
     */
    public void setSvcLvl(ServiceLevel8Choice value) {
        this.svcLvl = value;
    }

    /**
     * 获取属性 lclInstrm 的值。
     * 
     * @return
     *     possible object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public LocalInstrument2Choice getLclInstrm() {
        return lclInstrm;
    }

    /**
     * 设置属性 lclInstrm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public void setLclInstrm(LocalInstrument2Choice value) {
        this.lclInstrm = value;
    }

    /**
     * 获取属性 ctgyPurp 的值。
     * 
     * @return
     *     possible object is
     *     {@link CategoryPurpose1Choice }
     *     
     */
    public CategoryPurpose1Choice getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * 设置属性 ctgyPurp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryPurpose1Choice }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1Choice value) {
        this.ctgyPurp = value;
    }

    /**
     * 获取属性 clssfctn 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateClassification1Choice }
     *     
     */
    public MandateClassification1Choice getClssfctn() {
        return clssfctn;
    }

    /**
     * 设置属性 clssfctn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateClassification1Choice }
     *     
     */
    public void setClssfctn(MandateClassification1Choice value) {
        this.clssfctn = value;
    }

}
