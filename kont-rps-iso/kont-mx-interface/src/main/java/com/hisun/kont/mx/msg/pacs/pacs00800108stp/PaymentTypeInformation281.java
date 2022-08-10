//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108stp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentTypeInformation28__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation28__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstrPrty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}Priority2Code" minOccurs="0"/>
 *         &lt;element name="ClrChanl" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ClearingChannel2Code" minOccurs="0"/>
 *         &lt;element name="SvcLvl" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ServiceLevel8Choice__1" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}LocalInstrument2Choice__1" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CategoryPurpose1Choice__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation28__1", propOrder = {
    "instrPrty",
    "clrChanl",
    "svcLvl",
    "lclInstrm",
    "ctgyPurp"
})
public class PaymentTypeInformation281 {

    @XmlElement(name = "InstrPrty")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "ClrChanl")
    @XmlSchemaType(name = "string")
    protected ClearingChannel2Code clrChanl;
    @XmlElement(name = "SvcLvl")
    protected List<ServiceLevel8Choice1> svcLvl;
    @XmlElement(name = "LclInstrm")
    protected LocalInstrument2Choice1 lclInstrm;
    @XmlElement(name = "CtgyPurp")
    protected CategoryPurpose1Choice1 ctgyPurp;

    /**
     * 获取instrPrty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Priority2Code }
     *     
     */
    public Priority2Code getInstrPrty() {
        return instrPrty;
    }

    /**
     * 设置instrPrty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Priority2Code }
     *     
     */
    public void setInstrPrty(Priority2Code value) {
        this.instrPrty = value;
    }

    /**
     * 获取clrChanl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public ClearingChannel2Code getClrChanl() {
        return clrChanl;
    }

    /**
     * 设置clrChanl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public void setClrChanl(ClearingChannel2Code value) {
        this.clrChanl = value;
    }

    /**
     * Gets the value of the svcLvl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the svcLvl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSvcLvl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceLevel8Choice1 }
     * 
     * 
     */
    public List<ServiceLevel8Choice1> getSvcLvl() {
        if (svcLvl == null) {
            svcLvl = new ArrayList<ServiceLevel8Choice1>();
        }
        return this.svcLvl;
    }

    /**
     * 获取lclInstrm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link LocalInstrument2Choice1 }
     *     
     */
    public LocalInstrument2Choice1 getLclInstrm() {
        return lclInstrm;
    }

    /**
     * 设置lclInstrm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link LocalInstrument2Choice1 }
     *     
     */
    public void setLclInstrm(LocalInstrument2Choice1 value) {
        this.lclInstrm = value;
    }

    /**
     * 获取ctgyPurp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CategoryPurpose1Choice1 }
     *     
     */
    public CategoryPurpose1Choice1 getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * 设置ctgyPurp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryPurpose1Choice1 }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1Choice1 value) {
        this.ctgyPurp = value;
    }

}
