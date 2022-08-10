//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00400109;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DocumentLineInformation1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="DocumentLineInformation1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}DocumentLineIdentification1__1" maxOccurs="unbounded"/>
 *         &lt;element name="Desc" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text_Extended" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}RemittanceAmount3__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentLineInformation1__1", propOrder = {
    "id",
    "desc",
    "amt"
})
public class DocumentLineInformation11 {

    @XmlElement(name = "Id", required = true)
    protected List<DocumentLineIdentification11> id;
    @XmlElement(name = "Desc")
    protected String desc;
    @XmlElement(name = "Amt")
    protected RemittanceAmount31 amt;

    /**
     * Gets the value of the id property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the id property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentLineIdentification11 }
     * 
     * 
     */
    public List<DocumentLineIdentification11> getId() {
        if (id == null) {
            id = new ArrayList<DocumentLineIdentification11>();
        }
        return this.id;
    }

    /**
     * 获取desc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置desc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceAmount31 }
     *     
     */
    public RemittanceAmount31 getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceAmount31 }
     *     
     */
    public void setAmt(RemittanceAmount31 value) {
        this.amt = value;
    }

}
