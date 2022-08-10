//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SequenceRange1Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SequenceRange1Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="FrSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="ToSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="FrToSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}SequenceRange1__1" maxOccurs="unbounded"/>
 *         &lt;element name="EQSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" maxOccurs="unbounded"/>
 *         &lt;element name="NEQSeq" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceRange1Choice__1", propOrder = {
    "frSeq",
    "toSeq",
    "frToSeq",
    "eqSeq",
    "neqSeq"
})
public class SequenceRange1Choice1 {

    @XmlElement(name = "FrSeq")
    protected String frSeq;
    @XmlElement(name = "ToSeq")
    protected String toSeq;
    @XmlElement(name = "FrToSeq")
    protected List<SequenceRange11> frToSeq;
    @XmlElement(name = "EQSeq")
    protected List<String> eqSeq;
    @XmlElement(name = "NEQSeq")
    protected List<String> neqSeq;

    /**
     * 获取frSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrSeq() {
        return frSeq;
    }

    /**
     * 设置frSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrSeq(String value) {
        this.frSeq = value;
    }

    /**
     * 获取toSeq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSeq() {
        return toSeq;
    }

    /**
     * 设置toSeq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSeq(String value) {
        this.toSeq = value;
    }

    /**
     * Gets the value of the frToSeq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the frToSeq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFrToSeq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SequenceRange11 }
     * 
     * 
     */
    public List<SequenceRange11> getFrToSeq() {
        if (frToSeq == null) {
            frToSeq = new ArrayList<SequenceRange11>();
        }
        return this.frToSeq;
    }

    /**
     * Gets the value of the eqSeq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eqSeq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEQSeq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getEQSeq() {
        if (eqSeq == null) {
            eqSeq = new ArrayList<String>();
        }
        return this.eqSeq;
    }

    /**
     * Gets the value of the neqSeq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the neqSeq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNEQSeq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNEQSeq() {
        if (neqSeq == null) {
            neqSeq = new ArrayList<String>();
        }
        return this.neqSeq;
    }

}
