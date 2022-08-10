//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:34 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt06000105;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionType2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionType2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sts" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}EntryStatus1Choice__1"/>
 *         &lt;element name="CdtDbtInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}CreditDebitCode"/>
 *         &lt;element name="FlrLmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}Limit2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionType2__1", propOrder = {
    "sts",
    "cdtDbtInd",
    "flrLmt"
})
public class TransactionType21 {

    @XmlElement(name = "Sts", required = true)
    protected EntryStatus1Choice1 sts;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "FlrLmt")
    protected List<Limit2> flrLmt;

    /**
     * 获取sts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EntryStatus1Choice1 }
     *     
     */
    public EntryStatus1Choice1 getSts() {
        return sts;
    }

    /**
     * 设置sts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EntryStatus1Choice1 }
     *     
     */
    public void setSts(EntryStatus1Choice1 value) {
        this.sts = value;
    }

    /**
     * 获取cdtDbtInd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditDebitCode }
     *     
     */
    public CreditDebitCode getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * 设置cdtDbtInd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDebitCode }
     *     
     */
    public void setCdtDbtInd(CreditDebitCode value) {
        this.cdtDbtInd = value;
    }

    /**
     * Gets the value of the flrLmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flrLmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlrLmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Limit2 }
     * 
     * 
     */
    public List<Limit2> getFlrLmt() {
        if (flrLmt == null) {
            flrLmt = new ArrayList<Limit2>();
        }
        return this.flrLmt;
    }

}
