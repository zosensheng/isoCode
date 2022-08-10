//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108stp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>StructuredRegulatoryReporting3__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StructuredRegulatoryReporting3__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Dt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ISODate" minOccurs="0"/>
 *         &lt;element name="Ctry" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CountryCode" minOccurs="0"/>
 *         &lt;element name="Cd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_RestrictedFINXMax10Text" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_Amount__1" minOccurs="0"/>
 *         &lt;element name="Inf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_RestrictedFINXMax35Text" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRegulatoryReporting3__1", propOrder = {
    "tp",
    "dt",
    "ctry",
    "cd",
    "amt",
    "inf"
})
public class StructuredRegulatoryReporting31 {

    @XmlElement(name = "Tp")
    protected String tp;
    @XmlElement(name = "Dt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "Ctry")
    protected String ctry;
    @XmlElement(name = "Cd")
    protected String cd;
    @XmlElement(name = "Amt")
    protected CBPRAmount1 amt;
    @XmlElement(name = "Inf")
    protected List<String> inf;

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTp(String value) {
        this.tp = value;
    }

    /**
     * 获取dt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * 设置dt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * 获取ctry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtry() {
        return ctry;
    }

    /**
     * 设置ctry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtry(String value) {
        this.ctry = value;
    }

    /**
     * 获取cd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCd() {
        return cd;
    }

    /**
     * 设置cd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCd(String value) {
        this.cd = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setAmt(CBPRAmount1 value) {
        this.amt = value;
    }

    /**
     * Gets the value of the inf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getInf() {
        if (inf == null) {
            inf = new ArrayList<String>();
        }
        return this.inf;
    }

}
