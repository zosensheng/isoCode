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
 * Additional information that can not be captured in the structured fields and/or any other specific block.
 * 
 * <p>SupplementaryData1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="SupplementaryData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PlcAndNm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max350Text" minOccurs="0"/>
 *         &lt;element name="Envlp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}SupplementaryDataEnvelope1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplementaryData1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "plcAndNm",
    "envlp"
})
public class SupplementaryData1 {

    @XmlElement(name = "PlcAndNm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String plcAndNm;
    @XmlElement(name = "Envlp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected SupplementaryDataEnvelope1 envlp;

    /**
     * 获取属性 plcAndNm 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlcAndNm() {
        return plcAndNm;
    }

    /**
     * 设置属性 plcAndNm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlcAndNm(String value) {
        this.plcAndNm = value;
    }

    /**
     * 获取属性 envlp 的值。
     * 
     * @return
     *     possible object is
     *     {@link SupplementaryDataEnvelope1 }
     *     
     */
    public SupplementaryDataEnvelope1 getEnvlp() {
        return envlp;
    }

    /**
     * 设置属性 envlp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementaryDataEnvelope1 }
     *     
     */
    public void setEnvlp(SupplementaryDataEnvelope1 value) {
        this.envlp = value;
    }

}
