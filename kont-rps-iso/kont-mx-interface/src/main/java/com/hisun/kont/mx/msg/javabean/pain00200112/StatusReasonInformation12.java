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
 * Provides information on the status reason of the transaction.
 * 
 * <p>StatusReasonInformation12 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="StatusReasonInformation12">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Orgtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}StatusReason6Choice" minOccurs="0"/>
 *         &lt;element name="AddtlInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max105Text" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusReasonInformation12", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "orgtr",
    "rsn",
    "addtlInf"
})
public class StatusReasonInformation12 {

    @XmlElement(name = "Orgtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PartyIdentification135 orgtr;
    @XmlElement(name = "Rsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected StatusReason6Choice rsn;
    @XmlElement(name = "AddtlInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<String> addtlInf;

    /**
     * 获取属性 orgtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getOrgtr() {
        return orgtr;
    }

    /**
     * 设置属性 orgtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setOrgtr(PartyIdentification135 value) {
        this.orgtr = value;
    }

    /**
     * 获取属性 rsn 的值。
     * 
     * @return
     *     possible object is
     *     {@link StatusReason6Choice }
     *     
     */
    public StatusReason6Choice getRsn() {
        return rsn;
    }

    /**
     * 设置属性 rsn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReason6Choice }
     *     
     */
    public void setRsn(StatusReason6Choice value) {
        this.rsn = value;
    }

    /**
     * Gets the value of the addtlInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addtlInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddtlInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddtlInf() {
        if (addtlInf == null) {
            addtlInf = new ArrayList<String>();
        }
        return this.addtlInf;
    }

}
