//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Party38Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Party38Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="OrgId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}OrganisationIdentification29__1"/>
 *         &lt;element name="PrvtId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PersonIdentification13__1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party38Choice__1", propOrder = {
    "orgId",
    "prvtId"
})
public class Party38Choice1 {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentification291 orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification131 prvtId;

    /**
     * 获取orgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification291 }
     *     
     */
    public OrganisationIdentification291 getOrgId() {
        return orgId;
    }

    /**
     * 设置orgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification291 }
     *     
     */
    public void setOrgId(OrganisationIdentification291 value) {
        this.orgId = value;
    }

    /**
     * 获取prvtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification131 }
     *     
     */
    public PersonIdentification131 getPrvtId() {
        return prvtId;
    }

    /**
     * 设置prvtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification131 }
     *     
     */
    public void setPrvtId(PersonIdentification131 value) {
        this.prvtId = value;
    }

}
