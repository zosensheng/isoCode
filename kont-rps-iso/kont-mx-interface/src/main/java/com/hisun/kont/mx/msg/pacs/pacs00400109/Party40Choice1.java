//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00400109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Party40Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Party40Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Pty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party40Choice__1", propOrder = {
    "pty"
})
public class Party40Choice1 {

    @XmlElement(name = "Pty")
    protected PartyIdentification1351 pty;

    /**
     * 获取pty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public PartyIdentification1351 getPty() {
        return pty;
    }

    /**
     * 设置pty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public void setPty(PartyIdentification1351 value) {
        this.pty = value;
    }

}
