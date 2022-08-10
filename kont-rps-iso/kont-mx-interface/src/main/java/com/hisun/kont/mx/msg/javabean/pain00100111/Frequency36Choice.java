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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice of format for a frequency, for example, the frequency of payment.
 * 
 * <p>Frequency36Choice complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Frequency36Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Frequency6Code"/>
 *         &lt;element name="Prd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}FrequencyPeriod1"/>
 *         &lt;element name="PtInTm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}FrequencyAndMoment1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Frequency36Choice", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "tp",
    "prd",
    "ptInTm"
})
public class Frequency36Choice {

    @XmlElement(name = "Tp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected Frequency6Code tp;
    @XmlElement(name = "Prd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected FrequencyPeriod1 prd;
    @XmlElement(name = "PtInTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected FrequencyAndMoment1 ptInTm;

    /**
     * 获取属性 tp 的值。
     * 
     * @return
     *     possible object is
     *     {@link Frequency6Code }
     *     
     */
    public Frequency6Code getTp() {
        return tp;
    }

    /**
     * 设置属性 tp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency6Code }
     *     
     */
    public void setTp(Frequency6Code value) {
        this.tp = value;
    }

    /**
     * 获取属性 prd 的值。
     * 
     * @return
     *     possible object is
     *     {@link FrequencyPeriod1 }
     *     
     */
    public FrequencyPeriod1 getPrd() {
        return prd;
    }

    /**
     * 设置属性 prd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyPeriod1 }
     *     
     */
    public void setPrd(FrequencyPeriod1 value) {
        this.prd = value;
    }

    /**
     * 获取属性 ptInTm 的值。
     * 
     * @return
     *     possible object is
     *     {@link FrequencyAndMoment1 }
     *     
     */
    public FrequencyAndMoment1 getPtInTm() {
        return ptInTm;
    }

    /**
     * 设置属性 ptInTm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyAndMoment1 }
     *     
     */
    public void setPtInTm(FrequencyAndMoment1 value) {
        this.ptInTm = value;
    }

}
