//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AmountAndCurrencyExchange3__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AmountAndCurrencyExchange3__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchangeDetails3__1" minOccurs="0"/>
 *         &lt;element name="TxAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchangeDetails3__1" minOccurs="0"/>
 *         &lt;element name="CntrValAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchangeDetails3__1" minOccurs="0"/>
 *         &lt;element name="AnncdPstngAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchangeDetails3__1" minOccurs="0"/>
 *         &lt;element name="PrtryAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AmountAndCurrencyExchangeDetails4__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountAndCurrencyExchange3__1", propOrder = {
    "instdAmt",
    "txAmt",
    "cntrValAmt",
    "anncdPstngAmt",
    "prtryAmt"
})
public class AmountAndCurrencyExchange31 {

    @XmlElement(name = "InstdAmt")
    protected AmountAndCurrencyExchangeDetails31 instdAmt;
    @XmlElement(name = "TxAmt")
    protected AmountAndCurrencyExchangeDetails31 txAmt;
    @XmlElement(name = "CntrValAmt")
    protected AmountAndCurrencyExchangeDetails31 cntrValAmt;
    @XmlElement(name = "AnncdPstngAmt")
    protected AmountAndCurrencyExchangeDetails31 anncdPstngAmt;
    @XmlElement(name = "PrtryAmt")
    protected List<AmountAndCurrencyExchangeDetails41> prtryAmt;

    /**
     * 获取instdAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public AmountAndCurrencyExchangeDetails31 getInstdAmt() {
        return instdAmt;
    }

    /**
     * 设置instdAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public void setInstdAmt(AmountAndCurrencyExchangeDetails31 value) {
        this.instdAmt = value;
    }

    /**
     * 获取txAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public AmountAndCurrencyExchangeDetails31 getTxAmt() {
        return txAmt;
    }

    /**
     * 设置txAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public void setTxAmt(AmountAndCurrencyExchangeDetails31 value) {
        this.txAmt = value;
    }

    /**
     * 获取cntrValAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public AmountAndCurrencyExchangeDetails31 getCntrValAmt() {
        return cntrValAmt;
    }

    /**
     * 设置cntrValAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public void setCntrValAmt(AmountAndCurrencyExchangeDetails31 value) {
        this.cntrValAmt = value;
    }

    /**
     * 获取anncdPstngAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public AmountAndCurrencyExchangeDetails31 getAnncdPstngAmt() {
        return anncdPstngAmt;
    }

    /**
     * 设置anncdPstngAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails31 }
     *     
     */
    public void setAnncdPstngAmt(AmountAndCurrencyExchangeDetails31 value) {
        this.anncdPstngAmt = value;
    }

    /**
     * Gets the value of the prtryAmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtryAmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtryAmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountAndCurrencyExchangeDetails41 }
     * 
     * 
     */
    public List<AmountAndCurrencyExchangeDetails41> getPrtryAmt() {
        if (prtryAmt == null) {
            prtryAmt = new ArrayList<AmountAndCurrencyExchangeDetails41>();
        }
        return this.prtryAmt;
    }

}
