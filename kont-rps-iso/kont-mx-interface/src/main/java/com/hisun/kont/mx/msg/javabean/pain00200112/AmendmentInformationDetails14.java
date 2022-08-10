//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides further details on the list of direct debit mandate elements that have been modified when the amendment indicator has been set.
 * 
 * <p>AmendmentInformationDetails14 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="AmendmentInformationDetails14">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlMndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="OrgnlFnlColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="OrgnlFrqcy" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="OrgnlRsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateSetupReason1Choice" minOccurs="0"/>
 *         &lt;element name="OrgnlTrckgDays" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Exact2NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentInformationDetails14", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "orgnlMndtId",
    "orgnlCdtrSchmeId",
    "orgnlCdtrAgt",
    "orgnlCdtrAgtAcct",
    "orgnlDbtr",
    "orgnlDbtrAcct",
    "orgnlDbtrAgt",
    "orgnlDbtrAgtAcct",
    "orgnlFnlColltnDt",
    "orgnlFrqcy",
    "orgnlRsn",
    "orgnlTrckgDays"
})
public class AmendmentInformationDetails14 {

    @XmlElement(name = "OrgnlMndtId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlMndtId;
    @XmlElement(name = "OrgnlCdtrSchmeId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PartyIdentification135 orgnlCdtrSchmeId;
    @XmlElement(name = "OrgnlCdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 orgnlCdtrAgt;
    @XmlElement(name = "OrgnlCdtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 orgnlCdtrAgtAcct;
    @XmlElement(name = "OrgnlDbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PartyIdentification135 orgnlDbtr;
    @XmlElement(name = "OrgnlDbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 orgnlDbtrAcct;
    @XmlElement(name = "OrgnlDbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 orgnlDbtrAgt;
    @XmlElement(name = "OrgnlDbtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 orgnlDbtrAgtAcct;
    @XmlElement(name = "OrgnlFnlColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlFnlColltnDt;
    @XmlElement(name = "OrgnlFrqcy", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Frequency36Choice orgnlFrqcy;
    @XmlElement(name = "OrgnlRsn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateSetupReason1Choice orgnlRsn;
    @XmlElement(name = "OrgnlTrckgDays", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlTrckgDays;

    /**
     * 获取属性 orgnlMndtId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMndtId() {
        return orgnlMndtId;
    }

    /**
     * 设置属性 orgnlMndtId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMndtId(String value) {
        this.orgnlMndtId = value;
    }

    /**
     * 获取属性 orgnlCdtrSchmeId 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getOrgnlCdtrSchmeId() {
        return orgnlCdtrSchmeId;
    }

    /**
     * 设置属性 orgnlCdtrSchmeId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setOrgnlCdtrSchmeId(PartyIdentification135 value) {
        this.orgnlCdtrSchmeId = value;
    }

    /**
     * 获取属性 orgnlCdtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getOrgnlCdtrAgt() {
        return orgnlCdtrAgt;
    }

    /**
     * 设置属性 orgnlCdtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setOrgnlCdtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.orgnlCdtrAgt = value;
    }

    /**
     * 获取属性 orgnlCdtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getOrgnlCdtrAgtAcct() {
        return orgnlCdtrAgtAcct;
    }

    /**
     * 设置属性 orgnlCdtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setOrgnlCdtrAgtAcct(CashAccount40 value) {
        this.orgnlCdtrAgtAcct = value;
    }

    /**
     * 获取属性 orgnlDbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getOrgnlDbtr() {
        return orgnlDbtr;
    }

    /**
     * 设置属性 orgnlDbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setOrgnlDbtr(PartyIdentification135 value) {
        this.orgnlDbtr = value;
    }

    /**
     * 获取属性 orgnlDbtrAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getOrgnlDbtrAcct() {
        return orgnlDbtrAcct;
    }

    /**
     * 设置属性 orgnlDbtrAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setOrgnlDbtrAcct(CashAccount40 value) {
        this.orgnlDbtrAcct = value;
    }

    /**
     * 获取属性 orgnlDbtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getOrgnlDbtrAgt() {
        return orgnlDbtrAgt;
    }

    /**
     * 设置属性 orgnlDbtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setOrgnlDbtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.orgnlDbtrAgt = value;
    }

    /**
     * 获取属性 orgnlDbtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getOrgnlDbtrAgtAcct() {
        return orgnlDbtrAgtAcct;
    }

    /**
     * 设置属性 orgnlDbtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setOrgnlDbtrAgtAcct(CashAccount40 value) {
        this.orgnlDbtrAgtAcct = value;
    }

    /**
     * 获取属性 orgnlFnlColltnDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlFnlColltnDt() {
        return orgnlFnlColltnDt;
    }

    /**
     * 设置属性 orgnlFnlColltnDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlFnlColltnDt(XMLGregorianCalendar value) {
        this.orgnlFnlColltnDt = value;
    }

    /**
     * 获取属性 orgnlFrqcy 的值。
     * 
     * @return
     *     possible object is
     *     {@link Frequency36Choice }
     *     
     */
    public Frequency36Choice getOrgnlFrqcy() {
        return orgnlFrqcy;
    }

    /**
     * 设置属性 orgnlFrqcy 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency36Choice }
     *     
     */
    public void setOrgnlFrqcy(Frequency36Choice value) {
        this.orgnlFrqcy = value;
    }

    /**
     * 获取属性 orgnlRsn 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public MandateSetupReason1Choice getOrgnlRsn() {
        return orgnlRsn;
    }

    /**
     * 设置属性 orgnlRsn 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public void setOrgnlRsn(MandateSetupReason1Choice value) {
        this.orgnlRsn = value;
    }

    /**
     * 获取属性 orgnlTrckgDays 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTrckgDays() {
        return orgnlTrckgDays;
    }

    /**
     * 设置属性 orgnlTrckgDays 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTrckgDays(String value) {
        this.orgnlTrckgDays = value;
    }

}
