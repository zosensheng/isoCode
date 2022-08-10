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
 * Provides the characteristics shared by all individual transactions included in the message.
 * 
 * <p>GroupHeader86 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="GroupHeader86">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODateTime"/>
 *         &lt;element name="InitgPty" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="FwdgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupHeader86", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "msgId",
    "creDtTm",
    "initgPty",
    "fwdgAgt",
    "dbtrAgt",
    "cdtrAgt"
})
public class GroupHeader86 {

    @XmlElement(name = "MsgId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String msgId;
    @XmlElement(name = "CreDtTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "InitgPty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PartyIdentification135 initgPty;
    @XmlElement(name = "FwdgAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 fwdgAgt;
    @XmlElement(name = "DbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "CdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;

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
     * 获取属性 dbtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置属性 dbtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取属性 cdtrAgt 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置属性 cdtrAgt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.cdtrAgt = value;
    }

}
