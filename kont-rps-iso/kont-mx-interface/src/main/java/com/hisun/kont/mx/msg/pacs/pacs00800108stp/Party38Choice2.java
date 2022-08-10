//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108stp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Party38Choice__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Party38Choice__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="OrgId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}OrganisationIdentification29__2"/>
 *         &lt;element name="PrvtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}PersonIdentification13__2"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party38Choice__2", propOrder = {
    "orgId",
    "prvtId"
})
public class Party38Choice2 {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentification292 orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification132 prvtId;

    /**
     * 获取orgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification292 }
     *     
     */
    public OrganisationIdentification292 getOrgId() {
        return orgId;
    }

    /**
     * 设置orgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification292 }
     *     
     */
    public void setOrgId(OrganisationIdentification292 value) {
        this.orgId = value;
    }

    /**
     * 获取prvtId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification132 }
     *     
     */
    public PersonIdentification132 getPrvtId() {
        return prvtId;
    }

    /**
     * 设置prvtId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification132 }
     *     
     */
    public void setPrvtId(PersonIdentification132 value) {
        this.prvtId = value;
    }

}
