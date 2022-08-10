//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Set of characteristics shared by all individual transactions included in the message.
 * 
 * <p>GroupHeader95 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="GroupHeader95">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}ISODateTime"/>
 *         &lt;element name="Authstn" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Authorisation1Choice" maxOccurs="2" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}Max15NumericText"/>
 *         &lt;element name="CtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PartyIdentification135"/>
 *         &lt;element name="FwdgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InitnSrc" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentInitiationSource1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupHeader95", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "msgId",
    "creDtTm",
    "authstn",
    "nbOfTxs",
    "ctrlSum",
    "initgPty",
    "fwdgAgt",
    "initnSrc"
})
public class GroupHeader95 {

    @XmlElement(name = "MsgId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String msgId;
    @XmlElement(name = "CreDtTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "Authstn", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<Authorisation1Choice> authstn;
    @XmlElement(name = "NbOfTxs", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BigDecimal ctrlSum;
    @XmlElement(name = "InitgPty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected PartyIdentification135 initgPty;
    @XmlElement(name = "FwdgAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected BranchAndFinancialInstitutionIdentification6 fwdgAgt;
    @XmlElement(name = "InitnSrc", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected PaymentInitiationSource1 initnSrc;

    /**
     * 获取属性 msgId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置属性 msgId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * 获取属性 creDtTm 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * 设置属性 creDtTm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * Gets the value of the authstn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authstn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthstn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Authorisation1Choice }
     * 
     * 
     */
    public List<Authorisation1Choice> getAuthstn() {
        if (authstn == null) {
            authstn = new ArrayList<Authorisation1Choice>();
        }
        return this.authstn;
    }

    /**
     * 获取属性 nbOfTxs 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * 设置属性 nbOfTxs 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * 获取属性 ctrlSum 的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * 设置属性 ctrlSum 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * 获取属性 initgPty 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getInitgPty() {
        return initgPty;
    }

    /**
     * 设置属性 initgPty 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setInitgPty(PartyIdentification135 value) {
        this.initgPty = value;
    }

    /**
     * 获取属性 fwdgAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getFwdgAgt() {
        return fwdgAgt;
    }

    /**
     * 设置属性 fwdgAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setFwdgAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.fwdgAgt = value;
    }

    /**
     * 获取属性 initnSrc 的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentInitiationSource1 }
     *     
     */
    public PaymentInitiationSource1 getInitnSrc() {
        return initnSrc;
    }

    /**
     * 设置属性 initnSrc 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInitiationSource1 }
     *     
     */
    public void setInitnSrc(PaymentInitiationSource1 value) {
        this.initnSrc = value;
    }

}
