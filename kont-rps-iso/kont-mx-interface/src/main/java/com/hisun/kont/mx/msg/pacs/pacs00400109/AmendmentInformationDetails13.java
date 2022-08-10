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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>AmendmentInformationDetails13 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AmendmentInformationDetails13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlMndtId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="OrgnlCdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="OrgnlDbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38" minOccurs="0"/>
 *         &lt;element name="OrgnlFnlColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="OrgnlFrqcy" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="OrgnlRsn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}MandateSetupReason1Choice" minOccurs="0"/>
 *         &lt;element name="OrgnlTrckgDays" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Exact2NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentInformationDetails13", propOrder = {
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
public class AmendmentInformationDetails13 {

    @XmlElement(name = "OrgnlMndtId")
    protected String orgnlMndtId;
    @XmlElement(name = "OrgnlCdtrSchmeId")
    protected PartyIdentification135 orgnlCdtrSchmeId;
    @XmlElement(name = "OrgnlCdtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 orgnlCdtrAgt;
    @XmlElement(name = "OrgnlCdtrAgtAcct")
    protected CashAccount38 orgnlCdtrAgtAcct;
    @XmlElement(name = "OrgnlDbtr")
    protected PartyIdentification135 orgnlDbtr;
    @XmlElement(name = "OrgnlDbtrAcct")
    protected CashAccount38 orgnlDbtrAcct;
    @XmlElement(name = "OrgnlDbtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 orgnlDbtrAgt;
    @XmlElement(name = "OrgnlDbtrAgtAcct")
    protected CashAccount38 orgnlDbtrAgtAcct;
    @XmlElement(name = "OrgnlFnlColltnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlFnlColltnDt;
    @XmlElement(name = "OrgnlFrqcy")
    protected Frequency36Choice orgnlFrqcy;
    @XmlElement(name = "OrgnlRsn")
    protected MandateSetupReason1Choice orgnlRsn;
    @XmlElement(name = "OrgnlTrckgDays")
    protected String orgnlTrckgDays;

    /**
     * 获取orgnlMndtId属性的值。
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
     * 设置orgnlMndtId属性的值。
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
     * 获取orgnlCdtrSchmeId属性的值。
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
     * 设置orgnlCdtrSchmeId属性的值。
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
     * 获取orgnlCdtrAgt属性的值。
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
     * 设置orgnlCdtrAgt属性的值。
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
     * 获取orgnlCdtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getOrgnlCdtrAgtAcct() {
        return orgnlCdtrAgtAcct;
    }

    /**
     * 设置orgnlCdtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setOrgnlCdtrAgtAcct(CashAccount38 value) {
        this.orgnlCdtrAgtAcct = value;
    }

    /**
     * 获取orgnlDbtr属性的值。
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
     * 设置orgnlDbtr属性的值。
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
     * 获取orgnlDbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getOrgnlDbtrAcct() {
        return orgnlDbtrAcct;
    }

    /**
     * 设置orgnlDbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setOrgnlDbtrAcct(CashAccount38 value) {
        this.orgnlDbtrAcct = value;
    }

    /**
     * 获取orgnlDbtrAgt属性的值。
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
     * 设置orgnlDbtrAgt属性的值。
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
     * 获取orgnlDbtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount38 }
     *     
     */
    public CashAccount38 getOrgnlDbtrAgtAcct() {
        return orgnlDbtrAgtAcct;
    }

    /**
     * 设置orgnlDbtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount38 }
     *     
     */
    public void setOrgnlDbtrAgtAcct(CashAccount38 value) {
        this.orgnlDbtrAgtAcct = value;
    }

    /**
     * 获取orgnlFnlColltnDt属性的值。
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
     * 设置orgnlFnlColltnDt属性的值。
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
     * 获取orgnlFrqcy属性的值。
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
     * 设置orgnlFrqcy属性的值。
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
     * 获取orgnlRsn属性的值。
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
     * 设置orgnlRsn属性的值。
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
     * 获取orgnlTrckgDays属性的值。
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
     * 设置orgnlTrckgDays属性的值。
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
