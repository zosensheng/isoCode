//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CancellationStatusReason4__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CancellationStatusReason4__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Orgtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}PartyIdentification135__2" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CancellationStatusReason3Choice__1" minOccurs="0"/>
 *         &lt;element name="AddtlInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax105Text" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancellationStatusReason4__1", propOrder = {
    "orgtr",
    "rsn",
    "addtlInf"
})
public class CancellationStatusReason41 {

    @XmlElement(name = "Orgtr")
    protected PartyIdentification1352 orgtr;
    @XmlElement(name = "Rsn")
    protected CancellationStatusReason3Choice1 rsn;
    @XmlElement(name = "AddtlInf")
    protected List<String> addtlInf;

    /**
     * 获取orgtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public PartyIdentification1352 getOrgtr() {
        return orgtr;
    }

    /**
     * 设置orgtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1352 }
     *     
     */
    public void setOrgtr(PartyIdentification1352 value) {
        this.orgtr = value;
    }

    /**
     * 获取rsn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CancellationStatusReason3Choice1 }
     *     
     */
    public CancellationStatusReason3Choice1 getRsn() {
        return rsn;
    }

    /**
     * 设置rsn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationStatusReason3Choice1 }
     *     
     */
    public void setRsn(CancellationStatusReason3Choice1 value) {
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
