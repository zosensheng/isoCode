//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details of the contact person.
 * 
 * <p>Contact4 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Contact4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NmPrfx" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}NamePrefix2Code" minOccurs="0"/>
 *         &lt;element name="Nm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max140Text" minOccurs="0"/>
 *         &lt;element name="PhneNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="MobNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="FaxNb" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="EmailAdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max2048Text" minOccurs="0"/>
 *         &lt;element name="EmailPurp" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="JobTitl" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="Rspnsblty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text" minOccurs="0"/>
 *         &lt;element name="Dept" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max70Text" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}OtherContact1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PrefrdMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PreferredContactMethod1Code" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact4", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "nmPrfx",
    "nm",
    "phneNb",
    "mobNb",
    "faxNb",
    "emailAdr",
    "emailPurp",
    "jobTitl",
    "rspnsblty",
    "dept",
    "othr",
    "prefrdMtd"
})
public class Contact4 {

    @XmlElement(name = "NmPrfx", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected NamePrefix2Code nmPrfx;
    @XmlElement(name = "Nm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String nm;
    @XmlElement(name = "PhneNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String phneNb;
    @XmlElement(name = "MobNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String mobNb;
    @XmlElement(name = "FaxNb", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String faxNb;
    @XmlElement(name = "EmailAdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String emailAdr;
    @XmlElement(name = "EmailPurp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String emailPurp;
    @XmlElement(name = "JobTitl", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String jobTitl;
    @XmlElement(name = "Rspnsblty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String rspnsblty;
    @XmlElement(name = "Dept", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected String dept;
    @XmlElement(name = "Othr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<OtherContact1> othr;
    @XmlElement(name = "PrefrdMtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected PreferredContactMethod1Code prefrdMtd;

    /**
     * 获取属性 nmPrfx 的值。
     * 
     * @return
     *     possible object is
     *     {@link NamePrefix2Code }
     *     
     */
    public NamePrefix2Code getNmPrfx() {
        return nmPrfx;
    }

    /**
     * 设置属性 nmPrfx 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NamePrefix2Code }
     *     
     */
    public void setNmPrfx(NamePrefix2Code value) {
        this.nmPrfx = value;
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
     * 获取属性 phneNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhneNb() {
        return phneNb;
    }

    /**
     * 设置属性 phneNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhneNb(String value) {
        this.phneNb = value;
    }

    /**
     * 获取属性 mobNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobNb() {
        return mobNb;
    }

    /**
     * 设置属性 mobNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobNb(String value) {
        this.mobNb = value;
    }

    /**
     * 获取属性 faxNb 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNb() {
        return faxNb;
    }

    /**
     * 设置属性 faxNb 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNb(String value) {
        this.faxNb = value;
    }

    /**
     * 获取属性 emailAdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAdr() {
        return emailAdr;
    }

    /**
     * 设置属性 emailAdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAdr(String value) {
        this.emailAdr = value;
    }

    /**
     * 获取属性 emailPurp 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPurp() {
        return emailPurp;
    }

    /**
     * 设置属性 emailPurp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPurp(String value) {
        this.emailPurp = value;
    }

    /**
     * 获取属性 jobTitl 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTitl() {
        return jobTitl;
    }

    /**
     * 设置属性 jobTitl 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTitl(String value) {
        this.jobTitl = value;
    }

    /**
     * 获取属性 rspnsblty 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspnsblty() {
        return rspnsblty;
    }

    /**
     * 设置属性 rspnsblty 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspnsblty(String value) {
        this.rspnsblty = value;
    }

    /**
     * 获取属性 dept 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置属性 dept 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDept(String value) {
        this.dept = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherContact1 }
     * 
     * 
     */
    public List<OtherContact1> getOthr() {
        if (othr == null) {
            othr = new ArrayList<OtherContact1>();
        }
        return this.othr;
    }

    /**
     * 获取属性 prefrdMtd 的值。
     * 
     * @return
     *     possible object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public PreferredContactMethod1Code getPrefrdMtd() {
        return prefrdMtd;
    }

    /**
     * 设置属性 prefrdMtd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public void setPrefrdMtd(PreferredContactMethod1Code value) {
        this.prefrdMtd = value;
    }

}
