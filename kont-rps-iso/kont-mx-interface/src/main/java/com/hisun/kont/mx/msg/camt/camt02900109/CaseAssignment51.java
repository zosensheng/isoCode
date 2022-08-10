//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>CaseAssignment5__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CaseAssignment5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="Assgnr" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}Party40Choice__1"/>
 *         &lt;element name="Assgne" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}Party40Choice__1"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_DateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseAssignment5__1", propOrder = {
    "id",
    "assgnr",
    "assgne",
    "creDtTm"
})
public class CaseAssignment51 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Assgnr", required = true)
    protected Party40Choice1 assgnr;
    @XmlElement(name = "Assgne", required = true)
    protected Party40Choice1 assgne;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * 获取assgnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getAssgnr() {
        return assgnr;
    }

    /**
     * 设置assgnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setAssgnr(Party40Choice1 value) {
        this.assgnr = value;
    }

    /**
     * 获取assgne属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getAssgne() {
        return assgne;
    }

    /**
     * 设置assgne属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setAssgne(Party40Choice1 value) {
        this.assgne = value;
    }

    /**
     * 获取creDtTm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * 设置creDtTm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

}
