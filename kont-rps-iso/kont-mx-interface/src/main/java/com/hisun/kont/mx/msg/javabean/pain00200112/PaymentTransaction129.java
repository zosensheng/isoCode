//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides further details on the original transactions, to which the status report message refers.
 * 
 * <p>PaymentTransaction129 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction129">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StsId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="TxSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ExternalPaymentTransactionStatus1Code" minOccurs="0"/>
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}StatusReasonInformation12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ChrgsInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Charges7" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TrckrData" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}TrackerData1" minOccurs="0"/>
 *         &lt;element name="AccptncDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODateTime" minOccurs="0"/>
 *         &lt;element name="AcctSvcrRef" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="ClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlTxRef" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}OriginalTransactionReference35" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction129", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "stsId",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlUETR",
    "txSts",
    "stsRsnInf",
    "chrgsInf",
    "trckrData",
    "accptncDtTm",
    "acctSvcrRef",
    "clrSysRef",
    "orgnlTxRef",
    "splmtryData"
})
public class PaymentTransaction129 {

    @XmlElement(name = "StsId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String stsId;
    @XmlElement(name = "OrgnlInstrId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlUETR", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlUETR;
    @XmlElement(name = "TxSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String txSts;
    @XmlElement(name = "StsRsnInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<StatusReasonInformation12> stsRsnInf;
    @XmlElement(name = "ChrgsInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<Charges7> chrgsInf;
    @XmlElement(name = "TrckrData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected TrackerData1 trckrData;
    @XmlElement(name = "AccptncDtTm", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar accptncDtTm;
    @XmlElement(name = "AcctSvcrRef", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String acctSvcrRef;
    @XmlElement(name = "ClrSysRef", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String clrSysRef;
    @XmlElement(name = "OrgnlTxRef", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected OriginalTransactionReference35 orgnlTxRef;
    @XmlElement(name = "SplmtryData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<SupplementaryData1> splmtryData;

    /**
     * 获取属性 stsId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStsId() {
        return stsId;
    }

    /**
     * 设置属性 stsId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStsId(String value) {
        this.stsId = value;
    }

    /**
     * 获取属性 orgnlInstrId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * 设置属性 orgnlInstrId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * 获取属性 orgnlEndToEndId 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * 设置属性 orgnlEndToEndId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * 获取属性 orgnlUETR 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlUETR() {
        return orgnlUETR;
    }

    /**
     * 设置属性 orgnlUETR 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlUETR(String value) {
        this.orgnlUETR = value;
    }

    /**
     * 获取属性 txSts 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxSts() {
        return txSts;
    }

    /**
     * 设置属性 txSts 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxSts(String value) {
        this.txSts = value;
    }

    /**
     * Gets the value of the stsRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stsRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStsRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusReasonInformation12 }
     * 
     * 
     */
    public List<StatusReasonInformation12> getStsRsnInf() {
        if (stsRsnInf == null) {
            stsRsnInf = new ArrayList<StatusReasonInformation12>();
        }
        return this.stsRsnInf;
    }

    /**
     * Gets the value of the chrgsInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chrgsInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChrgsInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Charges7 }
     * 
     * 
     */
    public List<Charges7> getChrgsInf() {
        if (chrgsInf == null) {
            chrgsInf = new ArrayList<Charges7>();
        }
        return this.chrgsInf;
    }

    /**
     * 获取属性 trckrData 的值。
     * 
     * @return
     *     possible object is
     *     {@link TrackerData1 }
     *     
     */
    public TrackerData1 getTrckrData() {
        return trckrData;
    }

    /**
     * 设置属性 trckrData 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TrackerData1 }
     *     
     */
    public void setTrckrData(TrackerData1 value) {
        this.trckrData = value;
    }

    /**
     * 获取属性 accptncDtTm 的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccptncDtTm() {
        return accptncDtTm;
    }

    /**
     * 设置属性 accptncDtTm 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccptncDtTm(XMLGregorianCalendar value) {
        this.accptncDtTm = value;
    }

    /**
     * 获取属性 acctSvcrRef 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSvcrRef() {
        return acctSvcrRef;
    }

    /**
     * 设置属性 acctSvcrRef 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSvcrRef(String value) {
        this.acctSvcrRef = value;
    }

    /**
     * 获取属性 clrSysRef 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClrSysRef() {
        return clrSysRef;
    }

    /**
     * 设置属性 clrSysRef 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClrSysRef(String value) {
        this.clrSysRef = value;
    }

    /**
     * 获取属性 orgnlTxRef 的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransactionReference35 }
     *     
     */
    public OriginalTransactionReference35 getOrgnlTxRef() {
        return orgnlTxRef;
    }

    /**
     * 设置属性 orgnlTxRef 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransactionReference35 }
     *     
     */
    public void setOrgnlTxRef(OriginalTransactionReference35 value) {
        this.orgnlTxRef = value;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
