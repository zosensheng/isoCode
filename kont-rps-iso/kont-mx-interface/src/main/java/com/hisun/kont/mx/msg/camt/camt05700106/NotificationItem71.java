//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:33 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05700106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>NotificationItem7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NotificationItem7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="EndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="RltdAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="XpctdValDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}Party40Choice__3" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}Purpose2Choice__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationItem7__1", propOrder = {
    "id",
    "endToEndId",
    "uetr",
    "rltdAcct",
    "amt",
    "xpctdValDt",
    "dbtr",
    "dbtrAgt",
    "intrmyAgt",
    "purp"
})
public class NotificationItem71 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "EndToEndId")
    protected String endToEndId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "RltdAcct")
    protected CashAccount381 rltdAcct;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "XpctdValDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar xpctdValDt;
    @XmlElement(name = "Dbtr")
    protected Party40Choice3 dbtr;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification61 dbtrAgt;
    @XmlElement(name = "IntrmyAgt")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt;
    @XmlElement(name = "Purp")
    protected Purpose2Choice1 purp;

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
     * 获取endToEndId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndToEndId() {
        return endToEndId;
    }

    /**
     * 设置endToEndId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndToEndId(String value) {
        this.endToEndId = value;
    }

    /**
     * 获取uetr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUETR() {
        return uetr;
    }

    /**
     * 设置uetr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUETR(String value) {
        this.uetr = value;
    }

    /**
     * 获取rltdAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getRltdAcct() {
        return rltdAcct;
    }

    /**
     * 设置rltdAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setRltdAcct(CashAccount381 value) {
        this.rltdAcct = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * 获取xpctdValDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getXpctdValDt() {
        return xpctdValDt;
    }

    /**
     * 设置xpctdValDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setXpctdValDt(XMLGregorianCalendar value) {
        this.xpctdValDt = value;
    }

    /**
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice3 }
     *     
     */
    public Party40Choice3 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice3 }
     *     
     */
    public void setDbtr(Party40Choice3 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取intrmyAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getIntrmyAgt() {
        return intrmyAgt;
    }

    /**
     * 设置intrmyAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setIntrmyAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.intrmyAgt = value;
    }

    /**
     * 获取purp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice1 }
     *     
     */
    public Purpose2Choice1 getPurp() {
        return purp;
    }

    /**
     * 设置purp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice1 }
     *     
     */
    public void setPurp(Purpose2Choice1 value) {
        this.purp = value;
    }

}
