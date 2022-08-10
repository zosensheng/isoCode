//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00400109;

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
 * <p>PaymentTransaction112__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction112__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RtrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlGrpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}OriginalGroupInformation29__1" minOccurs="0"/>
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="OrgnlTxId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}UUIDv4Identifier"/>
 *         &lt;element name="OrgnlClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlIntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_Amount__1" minOccurs="0"/>
 *         &lt;element name="OrgnlIntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="RtrdIntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_Amount__1"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate"/>
 *         &lt;element name="SttlmPrty" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Priority3Code" minOccurs="0"/>
 *         &lt;element name="SttlmTmIndctn" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}SettlementDateTimeIndication1__1" minOccurs="0"/>
 *         &lt;element name="RtrdInstdAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_Amount__1" minOccurs="0"/>
 *         &lt;element name="XchgRate" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BaseOneRate" minOccurs="0"/>
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ChargeBearerType1Code__1"/>
 *         &lt;element name="ChrgsInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Charges7__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ClrSysRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="InstgAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="InstdAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__2"/>
 *         &lt;element name="RtrChain" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}TransactionParties7__1"/>
 *         &lt;element name="RtrRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PaymentReturnReason6__1"/>
 *         &lt;element name="OrgnlTxRef" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}OriginalTransactionReference28__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction112__1", propOrder = {
    "rtrId",
    "orgnlGrpInf",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlUETR",
    "orgnlClrSysRef",
    "orgnlIntrBkSttlmAmt",
    "orgnlIntrBkSttlmDt",
    "rtrdIntrBkSttlmAmt",
    "intrBkSttlmDt",
    "sttlmPrty",
    "sttlmTmIndctn",
    "rtrdInstdAmt",
    "xchgRate",
    "chrgBr",
    "chrgsInf",
    "clrSysRef",
    "instgAgt",
    "instdAgt",
    "rtrChain",
    "rtrRsnInf",
    "orgnlTxRef"
})
public class PaymentTransaction1121 {

    @XmlElement(name = "RtrId")
    protected String rtrId;
    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupInformation291 orgnlGrpInf;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId", required = true)
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlTxId")
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlUETR", required = true)
    protected String orgnlUETR;
    @XmlElement(name = "OrgnlClrSysRef")
    protected String orgnlClrSysRef;
    @XmlElement(name = "OrgnlIntrBkSttlmAmt")
    protected CBPRAmount1 orgnlIntrBkSttlmAmt;
    @XmlElement(name = "OrgnlIntrBkSttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlIntrBkSttlmDt;
    @XmlElement(name = "RtrdIntrBkSttlmAmt", required = true)
    protected CBPRAmount1 rtrdIntrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "SttlmPrty")
    @XmlSchemaType(name = "string")
    protected Priority3Code sttlmPrty;
    @XmlElement(name = "SttlmTmIndctn")
    protected SettlementDateTimeIndication11 sttlmTmIndctn;
    @XmlElement(name = "RtrdInstdAmt")
    protected CBPRAmount1 rtrdInstdAmt;
    @XmlElement(name = "XchgRate")
    protected BigDecimal xchgRate;
    @XmlElement(name = "ChrgBr", required = true)
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code1 chrgBr;
    @XmlElement(name = "ChrgsInf")
    protected List<Charges71> chrgsInf;
    @XmlElement(name = "ClrSysRef")
    protected String clrSysRef;
    @XmlElement(name = "InstgAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification62 instgAgt;
    @XmlElement(name = "InstdAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification62 instdAgt;
    @XmlElement(name = "RtrChain", required = true)
    protected TransactionParties71 rtrChain;
    @XmlElement(name = "RtrRsnInf", required = true)
    protected PaymentReturnReason61 rtrRsnInf;
    @XmlElement(name = "OrgnlTxRef")
    protected OriginalTransactionReference281 orgnlTxRef;

    /**
     * 获取rtrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRtrId() {
        return rtrId;
    }

    /**
     * 设置rtrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRtrId(String value) {
        this.rtrId = value;
    }

    /**
     * 获取orgnlGrpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformation291 }
     *     
     */
    public OriginalGroupInformation291 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * 设置orgnlGrpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformation291 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupInformation291 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * 获取orgnlInstrId属性的值。
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
     * 设置orgnlInstrId属性的值。
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
     * 获取orgnlEndToEndId属性的值。
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
     * 设置orgnlEndToEndId属性的值。
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
     * 获取orgnlTxId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxId() {
        return orgnlTxId;
    }

    /**
     * 设置orgnlTxId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxId(String value) {
        this.orgnlTxId = value;
    }

    /**
     * 获取orgnlUETR属性的值。
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
     * 设置orgnlUETR属性的值。
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
     * 获取orgnlClrSysRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlClrSysRef() {
        return orgnlClrSysRef;
    }

    /**
     * 设置orgnlClrSysRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlClrSysRef(String value) {
        this.orgnlClrSysRef = value;
    }

    /**
     * 获取orgnlIntrBkSttlmAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getOrgnlIntrBkSttlmAmt() {
        return orgnlIntrBkSttlmAmt;
    }

    /**
     * 设置orgnlIntrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setOrgnlIntrBkSttlmAmt(CBPRAmount1 value) {
        this.orgnlIntrBkSttlmAmt = value;
    }

    /**
     * 获取orgnlIntrBkSttlmDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlIntrBkSttlmDt() {
        return orgnlIntrBkSttlmDt;
    }

    /**
     * 设置orgnlIntrBkSttlmDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.orgnlIntrBkSttlmDt = value;
    }

    /**
     * 获取rtrdIntrBkSttlmAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getRtrdIntrBkSttlmAmt() {
        return rtrdIntrBkSttlmAmt;
    }

    /**
     * 设置rtrdIntrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setRtrdIntrBkSttlmAmt(CBPRAmount1 value) {
        this.rtrdIntrBkSttlmAmt = value;
    }

    /**
     * 获取intrBkSttlmDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIntrBkSttlmDt() {
        return intrBkSttlmDt;
    }

    /**
     * 设置intrBkSttlmDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.intrBkSttlmDt = value;
    }

    /**
     * 获取sttlmPrty属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Priority3Code }
     *     
     */
    public Priority3Code getSttlmPrty() {
        return sttlmPrty;
    }

    /**
     * 设置sttlmPrty属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Priority3Code }
     *     
     */
    public void setSttlmPrty(Priority3Code value) {
        this.sttlmPrty = value;
    }

    /**
     * 获取sttlmTmIndctn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementDateTimeIndication11 }
     *     
     */
    public SettlementDateTimeIndication11 getSttlmTmIndctn() {
        return sttlmTmIndctn;
    }

    /**
     * 设置sttlmTmIndctn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementDateTimeIndication11 }
     *     
     */
    public void setSttlmTmIndctn(SettlementDateTimeIndication11 value) {
        this.sttlmTmIndctn = value;
    }

    /**
     * 获取rtrdInstdAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getRtrdInstdAmt() {
        return rtrdInstdAmt;
    }

    /**
     * 设置rtrdInstdAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setRtrdInstdAmt(CBPRAmount1 value) {
        this.rtrdInstdAmt = value;
    }

    /**
     * 获取xchgRate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXchgRate() {
        return xchgRate;
    }

    /**
     * 设置xchgRate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXchgRate(BigDecimal value) {
        this.xchgRate = value;
    }

    /**
     * 获取chrgBr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public ChargeBearerType1Code1 getChrgBr() {
        return chrgBr;
    }

    /**
     * 设置chrgBr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code1 }
     *     
     */
    public void setChrgBr(ChargeBearerType1Code1 value) {
        this.chrgBr = value;
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
     * {@link Charges71 }
     * 
     * 
     */
    public List<Charges71> getChrgsInf() {
        if (chrgsInf == null) {
            chrgsInf = new ArrayList<Charges71>();
        }
        return this.chrgsInf;
    }

    /**
     * 获取clrSysRef属性的值。
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
     * 设置clrSysRef属性的值。
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
     * 获取instgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getInstgAgt() {
        return instgAgt;
    }

    /**
     * 设置instgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setInstgAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.instgAgt = value;
    }

    /**
     * 获取instdAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification62 getInstdAgt() {
        return instdAgt;
    }

    /**
     * 设置instdAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification62 }
     *     
     */
    public void setInstdAgt(BranchAndFinancialInstitutionIdentification62 value) {
        this.instdAgt = value;
    }

    /**
     * 获取rtrChain属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TransactionParties71 }
     *     
     */
    public TransactionParties71 getRtrChain() {
        return rtrChain;
    }

    /**
     * 设置rtrChain属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionParties71 }
     *     
     */
    public void setRtrChain(TransactionParties71 value) {
        this.rtrChain = value;
    }

    /**
     * 获取rtrRsnInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentReturnReason61 }
     *     
     */
    public PaymentReturnReason61 getRtrRsnInf() {
        return rtrRsnInf;
    }

    /**
     * 设置rtrRsnInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReturnReason61 }
     *     
     */
    public void setRtrRsnInf(PaymentReturnReason61 value) {
        this.rtrRsnInf = value;
    }

    /**
     * 获取orgnlTxRef属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransactionReference281 }
     *     
     */
    public OriginalTransactionReference281 getOrgnlTxRef() {
        return orgnlTxRef;
    }

    /**
     * 设置orgnlTxRef属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransactionReference281 }
     *     
     */
    public void setOrgnlTxRef(OriginalTransactionReference281 value) {
        this.orgnlTxRef = value;
    }

}
