//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the agent specific tracking system information of a payment transaction.
 * 
 * <p>TrackerRecord1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="TrackerRecord1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="ChrgsAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="XchgRateData" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CurrencyExchange13" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackerRecord1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "agt",
    "chrgBr",
    "chrgsAmt",
    "xchgRateData"
})
public class TrackerRecord1 {

    @XmlElement(name = "Agt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected BranchAndFinancialInstitutionIdentification6 agt;
    @XmlElement(name = "ChrgBr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code chrgBr;
    @XmlElement(name = "ChrgsAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected ActiveCurrencyAndAmount chrgsAmt;
    @XmlElement(name = "XchgRateData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CurrencyExchange13 xchgRateData;

    /**
     * 获取属性 agt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getAgt() {
        return agt;
    }

    /**
     * 设置属性 agt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.agt = value;
    }

    /**
     * 获取属性 chrgBr 的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public ChargeBearerType1Code getChrgBr() {
        return chrgBr;
    }

    /**
     * 设置属性 chrgBr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code value) {
        this.chrgBr = value;
    }

    /**
     * 获取属性 chrgsAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getChrgsAmt() {
        return chrgsAmt;
    }

    /**
     * 设置属性 chrgsAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setChrgsAmt(ActiveCurrencyAndAmount value) {
        this.chrgsAmt = value;
    }

    /**
     * 获取属性 xchgRateData 的值。
     * 
     * @return
     *     possible object is
     *     {@link CurrencyExchange13 }
     *     
     */
    public CurrencyExchange13 getXchgRateData() {
        return xchgRateData;
    }

    /**
     * 设置属性 xchgRateData 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyExchange13 }
     *     
     */
    public void setXchgRateData(CurrencyExchange13 value) {
        this.xchgRateData = value;
    }

}
