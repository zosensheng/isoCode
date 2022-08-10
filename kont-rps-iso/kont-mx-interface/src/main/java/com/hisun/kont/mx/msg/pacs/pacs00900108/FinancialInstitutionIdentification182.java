//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FinancialInstitutionIdentification18__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification18__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BICFI" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}BICFIDec2014Identifier"/>
 *         &lt;element name="ClrSysMmbId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}ClearingSystemMemberIdentification2__1" minOccurs="0"/>
 *         &lt;element name="LEI" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}LEIIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification18__2", propOrder = {
    "bicfi",
    "clrSysMmbId",
    "lei"
})
public class FinancialInstitutionIdentification182 {

    @XmlElement(name = "BICFI", required = true)
    protected String bicfi;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification21 clrSysMmbId;
    @XmlElement(name = "LEI")
    protected String lei;

    /**
     * 获取bicfi属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICFI() {
        return bicfi;
    }

    /**
     * 设置bicfi属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICFI(String value) {
        this.bicfi = value;
    }

    /**
     * 获取clrSysMmbId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemMemberIdentification21 }
     *     
     */
    public ClearingSystemMemberIdentification21 getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * 设置clrSysMmbId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemMemberIdentification21 }
     *     
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification21 value) {
        this.clrSysMmbId = value;
    }

    /**
     * 获取lei属性的值。
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
     * 设置lei属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEI(String value) {
        this.lei = value;
    }

}
