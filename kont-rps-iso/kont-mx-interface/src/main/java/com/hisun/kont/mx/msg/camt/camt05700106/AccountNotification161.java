//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:33 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05700106;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>AccountNotification16__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AccountNotification16__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="Acct" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="AcctOwnr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}Party40Choice__2" minOccurs="0"/>
 *         &lt;element name="AcctSvcr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="RltdAcct" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="TtlAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="XpctdValDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}Party40Choice__2" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}BranchAndFinancialInstitutionIdentification6__1" minOccurs="0"/>
 *         &lt;element name="Itm" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}NotificationItem7__1" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountNotification16__1", propOrder = {
    "id",
    "acct",
    "acctOwnr",
    "acctSvcr",
    "rltdAcct",
    "ttlAmt",
    "xpctdValDt",
    "dbtr",
    "dbtrAgt",
    "intrmyAgt",
    "itm"
})
public class AccountNotification161 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Acct")
    protected CashAccount381 acct;
    @XmlElement(name = "AcctOwnr")
    protected Party40Choice2 acctOwnr;
    @XmlElement(name = "AcctSvcr")
    protected BranchAndFinancialInstitutionIdentification61 acctSvcr;
    @XmlElement(name = "RltdAcct")
    protected CashAccount381 rltdAcct;
    @XmlElement(name = "TtlAmt")
    protected ActiveOrHistoricCurrencyAndAmount ttlAmt;
    @XmlElement(name = "XpctdValDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar xpctdValDt;
    @XmlElement(name = "Dbtr")
    protected Party40Choice2 dbtr;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification61 dbtrAgt;
    @XmlElement(name = "IntrmyAgt")
    protected BranchAndFinancialInstitutionIdentification61 intrmyAgt;
    @XmlElement(name = "Itm", required = true)
    protected List<NotificationItem71> itm;

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
     * 获取acct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getAcct() {
        return acct;
    }

    /**
     * 设置acct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setAcct(CashAccount381 value) {
        this.acct = value;
    }

    /**
     * 获取acctOwnr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice2 }
     *     
     */
    public Party40Choice2 getAcctOwnr() {
        return acctOwnr;
    }

    /**
     * 设置acctOwnr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice2 }
     *     
     */
    public void setAcctOwnr(Party40Choice2 value) {
        this.acctOwnr = value;
    }

    /**
     * 获取acctSvcr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getAcctSvcr() {
        return acctSvcr;
    }

    /**
     * 设置acctSvcr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setAcctSvcr(BranchAndFinancialInstitutionIdentification61 value) {
        this.acctSvcr = value;
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
     * 获取ttlAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getTtlAmt() {
        return ttlAmt;
    }

    /**
     * 设置ttlAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlAmt = value;
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
     *     {@link Party40Choice2 }
     *     
     */
    public Party40Choice2 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice2 }
     *     
     */
    public void setDbtr(Party40Choice2 value) {
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
     * Gets the value of the itm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotificationItem71 }
     * 
     * 
     */
    public List<NotificationItem71> getItm() {
        if (itm == null) {
            itm = new ArrayList<NotificationItem71>();
        }
        return this.itm;
    }

}
