//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Pagination1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Pagination1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PgNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}Max5NumericText"/>
 *         &lt;element name="LastPgInd" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}YesNoIndicator"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pagination1",  propOrder = {
    "pgNb",
    "lastPgInd"
})
public class Pagination1 {

    @XmlElement(name = "PgNb",  required = true)
    protected String pgNb;
    @XmlElement(name = "LastPgInd")
    protected boolean lastPgInd;

    /**
     * 获取pgNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPgNb() {
        return pgNb;
    }

    /**
     * 设置pgNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPgNb(String value) {
        this.pgNb = value;
    }

    /**
     * 获取lastPgInd属性的值。
     * 
     */
    public boolean isLastPgInd() {
        return lastPgInd;
    }

    /**
     * 设置lastPgInd属性的值。
     * 
     */
    public void setLastPgInd(boolean value) {
        this.lastPgInd = value;
    }

}
