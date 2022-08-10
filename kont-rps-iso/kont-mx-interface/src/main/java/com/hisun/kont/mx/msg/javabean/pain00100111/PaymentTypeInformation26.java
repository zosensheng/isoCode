//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details of the type of payment.
 * 
 * <p>PaymentTypeInformation26 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation26">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstrPrty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Priority2Code" minOccurs="0"/>
 *         &lt;element name="SvcLvl" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ServiceLevel8Choice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}CategoryPurpose1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation26", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "instrPrty",
    "svcLvl",
    "lclInstrm",
    "ctgyPurp"
})
public class PaymentTypeInformation26 {

    @XmlElement(name = "InstrPrty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "SvcLvl", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<ServiceLevel8Choice> svcLvl;
    @XmlElement(name = "LclInstrm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "CtgyPurp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected CategoryPurpose1Choice ctgyPurp;

    /**
     * 获取属性 instrPrty 的值。
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
     * 设置属性 instrPrty 的值。
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
     * {@link ServiceLevel8Choice }
     * 
     * 
     */
    public List<ServiceLevel8Choice> getSvcLvl() {
        if (svcLvl == null) {
            svcLvl = new ArrayList<ServiceLevel8Choice>();
        }
        return this.svcLvl;
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

}
