//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Describes the details of the currency exchange.
 * 
 * <p>CurrencyExchange13 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CurrencyExchange13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SrcCcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveCurrencyCode"/>
 *         &lt;element name="TrgtCcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveCurrencyCode"/>
 *         &lt;element name="XchgRate" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BaseOneRate"/>
 *         &lt;element name="UnitCcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveCurrencyCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyExchange13", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "srcCcy",
    "trgtCcy",
    "xchgRate",
    "unitCcy"
})
public class CurrencyExchange13 {

    @XmlElement(name = "SrcCcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String srcCcy;
    @XmlElement(name = "TrgtCcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String trgtCcy;
    @XmlElement(name = "XchgRate", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected BigDecimal xchgRate;
    @XmlElement(name = "UnitCcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String unitCcy;

    /**
     * 获取属性 srcCcy 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcCcy() {
        return srcCcy;
    }

    /**
     * 设置属性 srcCcy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcCcy(String value) {
        this.srcCcy = value;
    }

    /**
     * 获取属性 trgtCcy 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrgtCcy() {
        return trgtCcy;
    }

    /**
     * 设置属性 trgtCcy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrgtCcy(String value) {
        this.trgtCcy = value;
    }

    /**
     * 获取属性 xchgRate 的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXchgRate() {
        return xchgRate;
    }

    /**
     * 设置属性 xchgRate 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXchgRate(BigDecimal value) {
        this.xchgRate = value;
    }

    /**
     * 获取属性 unitCcy 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitCcy() {
        return unitCcy;
    }

    /**
     * 设置属性 unitCcy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitCcy(String value) {
        this.unitCcy = value;
    }

}
