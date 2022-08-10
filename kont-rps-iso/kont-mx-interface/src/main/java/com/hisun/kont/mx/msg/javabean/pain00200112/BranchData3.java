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
import javax.xml.bind.annotation.XmlType;


/**
 * Information that locates and identifies a specific branch of a financial institution.
 * 
 * <p>BranchData3 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="BranchData3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="LEI" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}LEIIdentifier" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PostalAddress24" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchData3", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "id",
    "lei",
    "nm",
    "pstlAdr"
})
public class BranchData3 {

    @XmlElement(name = "Id", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String id;
    @XmlElement(name = "LEI", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String lei;
    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String nm;
    @XmlElement(name = "PstlAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PostalAddress24 pstlAdr;

    /**
     * 获取属性 id 的值。
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
     * 设置属性 id 的值。
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
     * 获取属性 lei 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEI() {
        return lei;
    }

    /**
     * 设置属性 lei 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEI(String value) {
        this.lei = value;
    }

    /**
     * 获取属性 nm 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * 设置属性 nm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * 获取属性 pstlAdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress24 }
     *     
     */
    public PostalAddress24 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * 设置属性 pstlAdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress24 }
     *     
     */
    public void setPstlAdr(PostalAddress24 value) {
        this.pstlAdr = value;
    }

}
