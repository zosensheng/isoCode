//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.09 时间 10:49:45 AM CST
//


package com.hisun.kont.mx.msg.javabean.head00100102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OtherContact1 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="OtherContact1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChanlTp" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max4Text"/>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max128Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OtherContact1", propOrder = {
    "chanlTp",
    "id"
})
public class OtherContact1 {

    @XmlElement(name = "ChanlTp", required = true)
    protected String chanlTp;
    @XmlElement(name = "Id")
    protected String id;

    /**
     * 获取属性 chanlTp 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChanlTp() {
        return chanlTp;
    }

    /**
     * 设置属性 chanlTp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChanlTp(String value) {
        this.chanlTp = value;
    }

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

}
