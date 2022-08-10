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
 * <p>OriginalTransactionReference28__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="OriginalTransactionReference28__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CBPR_Amount__1" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}AmountType4Choice__1" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdExctnDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}DateAndDateTime2Choice__1" minOccurs="0"/>
 *         &lt;element name="CdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="SttlmInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}SettlementInstruction7__2" minOccurs="0"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PaymentTypeInformation27__1" minOccurs="0"/>
 *         &lt;element name="PmtMtd" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PaymentMethod4Code" minOccurs="0"/>
 *         &lt;element name="MndtRltdInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}MandateRelatedInformation14" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}RemittanceInformation16__1" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__1" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__5" minOccurs="0"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}BranchAndFinancialInstitutionIdentification6__3" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__6" minOccurs="0"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}CashAccount38__1" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Party40Choice__4" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}Purpose2Choice__1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransactionReference28__1", propOrder = {
    "intrBkSttlmAmt",
    "amt",
    "intrBkSttlmDt",
    "reqdColltnDt",
    "reqdExctnDt",
    "cdtrSchmeId",
    "sttlmInf",
    "pmtTpInf",
    "pmtMtd",
    "mndtRltdInf",
    "rmtInf",
    "ultmtDbtr",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "dbtrAgtAcct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr",
    "purp"
})
public class OriginalTransactionReference281 {

    @XmlElement(name = "IntrBkSttlmAmt")
    protected CBPRAmount1 intrBkSttlmAmt;
    @XmlElement(name = "Amt")
    protected AmountType4Choice1 amt;
    @XmlElement(name = "IntrBkSttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "ReqdColltnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "ReqdExctnDt")
    protected DateAndDateTime2Choice1 reqdExctnDt;
    @XmlElement(name = "CdtrSchmeId")
    protected PartyIdentification135 cdtrSchmeId;
    @XmlElement(name = "SttlmInf")
    protected SettlementInstruction72 sttlmInf;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation271 pmtTpInf;
    @XmlElement(name = "PmtMtd")
    @XmlSchemaType(name = "string")
    protected PaymentMethod4Code pmtMtd;
    @XmlElement(name = "MndtRltdInf")
    protected MandateRelatedInformation14 mndtRltdInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation161 rmtInf;
    @XmlElement(name = "UltmtDbtr")
    protected Party40Choice1 ultmtDbtr;
    @XmlElement(name = "Dbtr")
    protected Party40Choice5 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount381 dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification65 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount381 dbtrAgtAcct;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification63 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount381 cdtrAgtAcct;
    @XmlElement(name = "Cdtr")
    protected Party40Choice6 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount381 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected Party40Choice4 ultmtCdtr;
    @XmlElement(name = "Purp")
    protected Purpose2Choice1 purp;

    /**
     * 获取intrBkSttlmAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    /**
     * 设置intrBkSttlmAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setIntrBkSttlmAmt(CBPRAmount1 value) {
        this.intrBkSttlmAmt = value;
    }

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountType4Choice1 }
     *     
     */
    public AmountType4Choice1 getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType4Choice1 }
     *     
     */
    public void setAmt(AmountType4Choice1 value) {
        this.amt = value;
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
     * 获取reqdColltnDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReqdColltnDt() {
        return reqdColltnDt;
    }

    /**
     * 设置reqdColltnDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReqdColltnDt(XMLGregorianCalendar value) {
        this.reqdColltnDt = value;
    }

    /**
     * 获取reqdExctnDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public DateAndDateTime2Choice1 getReqdExctnDt() {
        return reqdExctnDt;
    }

    /**
     * 设置reqdExctnDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice1 }
     *     
     */
    public void setReqdExctnDt(DateAndDateTime2Choice1 value) {
        this.reqdExctnDt = value;
    }

    /**
     * 获取cdtrSchmeId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getCdtrSchmeId() {
        return cdtrSchmeId;
    }

    /**
     * 设置cdtrSchmeId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setCdtrSchmeId(PartyIdentification135 value) {
        this.cdtrSchmeId = value;
    }

    /**
     * 获取sttlmInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementInstruction72 }
     *     
     */
    public SettlementInstruction72 getSttlmInf() {
        return sttlmInf;
    }

    /**
     * 设置sttlmInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementInstruction72 }
     *     
     */
    public void setSttlmInf(SettlementInstruction72 value) {
        this.sttlmInf = value;
    }

    /**
     * 获取pmtTpInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation271 }
     *     
     */
    public PaymentTypeInformation271 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置pmtTpInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation271 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation271 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取pmtMtd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod4Code }
     *     
     */
    public PaymentMethod4Code getPmtMtd() {
        return pmtMtd;
    }

    /**
     * 设置pmtMtd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod4Code }
     *     
     */
    public void setPmtMtd(PaymentMethod4Code value) {
        this.pmtMtd = value;
    }

    /**
     * 获取mndtRltdInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedInformation14 }
     *     
     */
    public MandateRelatedInformation14 getMndtRltdInf() {
        return mndtRltdInf;
    }

    /**
     * 设置mndtRltdInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedInformation14 }
     *     
     */
    public void setMndtRltdInf(MandateRelatedInformation14 value) {
        this.mndtRltdInf = value;
    }

    /**
     * 获取rmtInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation161 }
     *     
     */
    public RemittanceInformation161 getRmtInf() {
        return rmtInf;
    }

    /**
     * 设置rmtInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation161 }
     *     
     */
    public void setRmtInf(RemittanceInformation161 value) {
        this.rmtInf = value;
    }

    /**
     * 获取ultmtDbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice1 }
     *     
     */
    public Party40Choice1 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置ultmtDbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice1 }
     *     
     */
    public void setUltmtDbtr(Party40Choice1 value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取dbtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice5 }
     *     
     */
    public Party40Choice5 getDbtr() {
        return dbtr;
    }

    /**
     * 设置dbtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice5 }
     *     
     */
    public void setDbtr(Party40Choice5 value) {
        this.dbtr = value;
    }

    /**
     * 获取dbtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置dbtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setDbtrAcct(CashAccount381 value) {
        this.dbtrAcct = value;
    }

    /**
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取dbtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置dbtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount381 value) {
        this.dbtrAgtAcct = value;
    }

    /**
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification63 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification63 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification63 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification63 value) {
        this.cdtrAgt = value;
    }

    /**
     * 获取cdtrAgtAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置cdtrAgtAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount381 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取cdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice6 }
     *     
     */
    public Party40Choice6 getCdtr() {
        return cdtr;
    }

    /**
     * 设置cdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice6 }
     *     
     */
    public void setCdtr(Party40Choice6 value) {
        this.cdtr = value;
    }

    /**
     * 获取cdtrAcct属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount381 }
     *     
     */
    public CashAccount381 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置cdtrAcct属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount381 }
     *     
     */
    public void setCdtrAcct(CashAccount381 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取ultmtCdtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice4 }
     *     
     */
    public Party40Choice4 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置ultmtCdtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice4 }
     *     
     */
    public void setUltmtCdtr(Party40Choice4 value) {
        this.ultmtCdtr = value;
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
