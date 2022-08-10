//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the detailed information as provided by a payment tracking system.
 * 
 * <p>TrackerData1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="TrackerData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConfdDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DateAndDateTime2Choice"/>
 *         &lt;element name="ConfdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveCurrencyAndAmount"/>
 *         &lt;element name="TrckrRcrd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}TrackerRecord1" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackerData1", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "confdDt",
    "confdAmt",
    "trckrRcrd"
})
public class TrackerData1 {

    @XmlElement(name = "ConfdDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected DateAndDateTime2Choice confdDt;
    @XmlElement(name = "ConfdAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected ActiveCurrencyAndAmount confdAmt;
    @XmlElement(name = "TrckrRcrd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected List<TrackerRecord1> trckrRcrd;

    /**
     * 获取属性 confdDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getConfdDt() {
        return confdDt;
    }

    /**
     * 设置属性 confdDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setConfdDt(DateAndDateTime2Choice value) {
        this.confdDt = value;
    }

    /**
     * 获取属性 confdAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getConfdAmt() {
        return confdAmt;
    }

    /**
     * 设置属性 confdAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setConfdAmt(ActiveCurrencyAndAmount value) {
        this.confdAmt = value;
    }

    /**
     * Gets the value of the trckrRcrd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trckrRcrd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrckrRcrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackerRecord1 }
     * 
     * 
     */
    public List<TrackerRecord1> getTrckrRcrd() {
        if (trckrRcrd == null) {
            trckrRcrd = new ArrayList<TrackerRecord1>();
        }
        return this.trckrRcrd;
    }

}
