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
 * <p>Party40Choice__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Party40Choice__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Pty" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}PartyIdentification135__4"/>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party40Choice__2",  propOrder = {
    "pty",
    "agt"
})
public class Party40Choice2 {

    @XmlElement(name = "Pty")
    protected PartyIdentification1354 pty;
    @XmlElement(name = "Agt")
    protected BranchAndFinancialInstitutionIdentification65 agt;

    /**
     * 获取pty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public PartyIdentification1354 getPty() {
        return pty;
    }

    /**
     * 设置pty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public void setPty(PartyIdentification1354 value) {
        this.pty = value;
    }

    /**
     * 获取agt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getAgt() {
        return agt;
    }

    /**
     * 设置agt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.agt = value;
    }

}
