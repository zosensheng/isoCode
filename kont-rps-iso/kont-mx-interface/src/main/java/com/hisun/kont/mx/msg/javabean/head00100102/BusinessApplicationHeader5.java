//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.09 时间 10:49:45 AM CST
//


package com.hisun.kont.mx.msg.javabean.head00100102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Objects;


/**
 * <p>BusinessApplicationHeader5 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="BusinessApplicationHeader5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CharSet" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}UnicodeChartsCode" minOccurs="0"/>
 *         &lt;element name="Fr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Party44Choice"/>
 *         &lt;element name="To" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Party44Choice"/>
 *         &lt;element name="BizMsgIdr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text"/>
 *         &lt;element name="MsgDefIdr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text"/>
 *         &lt;element name="BizSvc" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text" minOccurs="0"/>
 *         &lt;element name="CreDt" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}ISODateTime"/>
 *         &lt;element name="CpyDplct" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}CopyDuplicate1Code" minOccurs="0"/>
 *         &lt;element name="PssblDplct" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}YesNoIndicator" minOccurs="0"/>
 *         &lt;element name="Prty" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}BusinessMessagePriorityCode" minOccurs="0"/>
 *         &lt;element name="Sgntr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}SignatureEnvelope" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessApplicationHeader5", propOrder = {
    "charSet",
    "fr",
    "to",
    "bizMsgIdr",
    "msgDefIdr",
    "bizSvc",
    "creDt",
    "cpyDplct",
    "pssblDplct",
    "prty",
    "sgntr"
})
public class BusinessApplicationHeader5 {

    @XmlElement(name = "CharSet")
    protected String charSet;
    @XmlElement(name = "Fr", required = true)
    protected Party44Choice fr;
    @XmlElement(name = "To", required = true)
    protected Party44Choice to;
    @XmlElement(name = "BizMsgIdr", required = true)
    protected String bizMsgIdr;
    @XmlElement(name = "MsgDefIdr", required = true)
    protected String msgDefIdr;
    @XmlElement(name = "BizSvc")
    protected String bizSvc;
    @XmlElement(name = "CreDt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDt;
    @XmlElement(name = "CpyDplct")
    @XmlSchemaType(name = "string")
    protected CopyDuplicate1Code cpyDplct;
    @XmlElement(name = "PssblDplct")
    protected Boolean pssblDplct;
    @XmlElement(name = "Prty")
    protected String prty;
    @XmlElement(name = "Sgntr")
    protected SignatureEnvelope sgntr;

    /**
     * 获取属性 charSet 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharSet() {
        return charSet;
    }

    /**
     * 设置属性 charSet 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharSet(String value) {
        this.charSet = value;
    }

    /**
     * 获取属性 fr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party44Choice }
     *     
     */
    public Party44Choice getFr() {
        return fr;
    }

    /**
     * 设置属性 fr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party44Choice }
     *     
     */
    public void setFr(Party44Choice value) {
        this.fr = value;
    }

    /**
     * 获取属性 to 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party44Choice }
     *     
     */
    public Party44Choice getTo() {
        return to;
    }

    /**
     * 设置属性 to 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party44Choice }
     *     
     */
    public void setTo(Party44Choice value) {
        this.to = value;
    }

    /**
     * 获取属性 bizMsgIdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizMsgIdr() {
        return bizMsgIdr;
    }

    /**
     * 设置属性 bizMsgIdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizMsgIdr(String value) {
        this.bizMsgIdr = value;
    }

    /**
     * 获取属性 msgDefIdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgDefIdr() {
        return msgDefIdr;
    }

    /**
     * 设置属性 msgDefIdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgDefIdr(String value) {
        this.msgDefIdr = value;
    }

    /**
     * 获取属性 bizSvc 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizSvc() {
        return bizSvc;
    }

    /**
     * 设置属性 bizSvc 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizSvc(String value) {
        this.bizSvc = value;
    }

    /**
     * 获取属性 creDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDt() {
        return creDt;
    }

    /**
     * 设置属性 creDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDt(XMLGregorianCalendar value) {
        this.creDt = value;
    }

    /**
     * 获取属性 cpyDplct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CopyDuplicate1Code }
     *     
     */
    public CopyDuplicate1Code getCpyDplct() {
        return cpyDplct;
    }

    /**
     * 设置属性 cpyDplct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CopyDuplicate1Code }
     *     
     */
    public void setCpyDplct(CopyDuplicate1Code value) {
        this.cpyDplct = value;
    }

    /**
     * 获取属性 pssblDplct 的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPssblDplct() {
        return pssblDplct;
    }

    /**
     * 设置属性 pssblDplct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPssblDplct(Boolean value) {
        this.pssblDplct = value;
    }

    /**
     * 获取属性 prty 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrty() {
        return prty;
    }

    /**
     * 设置属性 prty 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrty(String value) {
        this.prty = value;
    }

    /**
     * 获取属性 sgntr 的值。
     * 
     * @return
     *     possible object is
     *     {@link SignatureEnvelope }
     *     
     */
    public SignatureEnvelope getSgntr() {
        return sgntr;
    }

    /**
     * 设置属性 sgntr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureEnvelope }
     *     
     */
    public void setSgntr(SignatureEnvelope value) {
        this.sgntr = value;
    }



}
