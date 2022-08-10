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
 * <p>GenericOrganisationIdentification1__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GenericOrganisationIdentification1__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="SchmeNm" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}OrganisationIdentificationSchemeName1Choice__1"/>
 *         &lt;element name="Issr" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericOrganisationIdentification1__2",  propOrder = {
    "id",
    "schmeNm",
    "issr"
})
public class GenericOrganisationIdentification12 {

    @XmlElement(name = "Id",  required = true)
    protected String id;
    @XmlElement(name = "SchmeNm",  required = true)
    protected OrganisationIdentificationSchemeName1Choice1 schmeNm;
    @XmlElement(name = "Issr")
    protected String issr;

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
     * 获取schmeNm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentificationSchemeName1Choice1 }
     *     
     */
    public OrganisationIdentificationSchemeName1Choice1 getSchmeNm() {
        return schmeNm;
    }

    /**
     * 设置schmeNm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentificationSchemeName1Choice1 }
     *     
     */
    public void setSchmeNm(OrganisationIdentificationSchemeName1Choice1 value) {
        this.schmeNm = value;
    }

    /**
     * 获取issr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssr() {
        return issr;
    }

    /**
     * 设置issr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssr(String value) {
        this.issr = value;
    }

}
