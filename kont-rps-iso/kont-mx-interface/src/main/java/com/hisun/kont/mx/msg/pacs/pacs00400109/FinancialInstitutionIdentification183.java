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
 * <p>FinancialInstitutionIdentification18__3 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification18__3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BICFI" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BICFIDec2014Identifier" minOccurs="0"/>
 *         &lt;element name="ClrSysMmbId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ClearingSystemMemberIdentification2__2" minOccurs="0"/>
 *         &lt;element name="LEI" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}LEIIdentifier" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax140Text_Extended" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PostalAddress24__1" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}GenericFinancialIdentification1__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification18__3", propOrder = {
    "bicfi",
    "clrSysMmbId",
    "lei",
    "nm",
    "pstlAdr",
    "othr"
})
public class FinancialInstitutionIdentification183 {

    @XmlElement(name = "BICFI")
    protected String bicfi;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification22 clrSysMmbId;
    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress241 pstlAdr;
    @XmlElement(name = "Othr")
    protected GenericFinancialIdentification11 othr;

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
     *     {@link ClearingSystemMemberIdentification22 }
     *     
     */
    public ClearingSystemMemberIdentification22 getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * 设置clrSysMmbId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemMemberIdentification22 }
     *     
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification22 value) {
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

    /**
     * 获取nm属性的值。
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
     * 设置nm属性的值。
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
     * 获取pstlAdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress241 }
     *     
     */
    public PostalAddress241 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * 设置pstlAdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress241 }
     *     
     */
    public void setPstlAdr(PostalAddress241 value) {
        this.pstlAdr = value;
    }

    /**
     * 获取othr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GenericFinancialIdentification11 }
     *     
     */
    public GenericFinancialIdentification11 getOthr() {
        return othr;
    }

    /**
     * 设置othr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GenericFinancialIdentification11 }
     *     
     */
    public void setOthr(GenericFinancialIdentification11 value) {
        this.othr = value;
    }

}
