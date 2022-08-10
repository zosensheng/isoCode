//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>PlainCardData1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PlainCardData1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PAN" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Min8Max28NumericText"/>
 *         &lt;element name="CardSeqNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Min2Max3NumericText" minOccurs="0"/>
 *         &lt;element name="FctvDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ISOYearMonth" minOccurs="0"/>
 *         &lt;element name="XpryDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ISOYearMonth"/>
 *         &lt;element name="SvcCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Exact3NumericText" minOccurs="0"/>
 *         &lt;element name="TrckData" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TrackData1__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CardSctyCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CardSecurityInformation1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlainCardData1__1", propOrder = {
    "pan",
    "cardSeqNb",
    "fctvDt",
    "xpryDt",
    "svcCd",
    "trckData",
    "cardSctyCd"
})
public class PlainCardData11 {

    @XmlElement(name = "PAN", required = true)
    protected String pan;
    @XmlElement(name = "CardSeqNb")
    protected String cardSeqNb;
    @XmlElement(name = "FctvDt")
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar fctvDt;
    @XmlElement(name = "XpryDt", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar xpryDt;
    @XmlElement(name = "SvcCd")
    protected String svcCd;
    @XmlElement(name = "TrckData")
    protected List<TrackData11> trckData;
    @XmlElement(name = "CardSctyCd")
    protected CardSecurityInformation1 cardSctyCd;

    /**
     * 获取pan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * 设置pan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * 获取cardSeqNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSeqNb() {
        return cardSeqNb;
    }

    /**
     * 设置cardSeqNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSeqNb(String value) {
        this.cardSeqNb = value;
    }

    /**
     * 获取fctvDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFctvDt() {
        return fctvDt;
    }

    /**
     * 设置fctvDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFctvDt(XMLGregorianCalendar value) {
        this.fctvDt = value;
    }

    /**
     * 获取xpryDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getXpryDt() {
        return xpryDt;
    }

    /**
     * 设置xpryDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setXpryDt(XMLGregorianCalendar value) {
        this.xpryDt = value;
    }

    /**
     * 获取svcCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcCd() {
        return svcCd;
    }

    /**
     * 设置svcCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcCd(String value) {
        this.svcCd = value;
    }

    /**
     * Gets the value of the trckData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trckData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrckData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackData11 }
     * 
     * 
     */
    public List<TrackData11> getTrckData() {
        if (trckData == null) {
            trckData = new ArrayList<TrackData11>();
        }
        return this.trckData;
    }

    /**
     * 获取cardSctyCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CardSecurityInformation1 }
     *     
     */
    public CardSecurityInformation1 getCardSctyCd() {
        return cardSctyCd;
    }

    /**
     * 设置cardSctyCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CardSecurityInformation1 }
     *     
     */
    public void setCardSctyCd(CardSecurityInformation1 value) {
        this.cardSctyCd = value;
    }

}
