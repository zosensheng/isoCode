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
 * Specifies key elements as defined in the original transaction.
 * 
 * <p>OriginalTransactionReference35 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="OriginalTransactionReference35">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IntrBkSttlmAmt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}AmountType4Choice" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdExctnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DateAndDateTime2Choice" minOccurs="0"/>
 *         &lt;element name="CdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="SttlmInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}SettlementInstruction11" minOccurs="0"/>
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PaymentTypeInformation27" minOccurs="0"/>
 *         &lt;element name="PmtMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PaymentMethod4Code" minOccurs="0"/>
 *         &lt;element name="MndtRltdInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateRelatedData2Choice" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}RemittanceInformation21" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Party40Choice" minOccurs="0"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Party40Choice" minOccurs="0"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CashAccount40" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Purp" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Purpose2Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransactionReference35", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
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
public class OriginalTransactionReference35 {

    @XmlElement(name = "IntrBkSttlmAmt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt;
    @XmlElement(name = "Amt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected AmountType4Choice amt;
    @XmlElement(name = "IntrBkSttlmDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "ReqdColltnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "ReqdExctnDt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected DateAndDateTime2Choice reqdExctnDt;
    @XmlElement(name = "CdtrSchmeId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PartyIdentification135 cdtrSchmeId;
    @XmlElement(name = "SttlmInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected SettlementInstruction11 sttlmInf;
    @XmlElement(name = "PmtTpInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected PaymentTypeInformation27 pmtTpInf;
    @XmlElement(name = "PmtMtd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    @XmlSchemaType(name = "string")
    protected PaymentMethod4Code pmtMtd;
    @XmlElement(name = "MndtRltdInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateRelatedData2Choice mndtRltdInf;
    @XmlElement(name = "RmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected RemittanceInformation21 rmtInf;
    @XmlElement(name = "UltmtDbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Party40Choice ultmtDbtr;
    @XmlElement(name = "Dbtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Party40Choice dbtr;
    @XmlElement(name = "DbtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 dbtrAcct;
    @XmlElement(name = "DbtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "CdtrAgt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Party40Choice cdtr;
    @XmlElement(name = "CdtrAcct", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CashAccount40 cdtrAcct;
    @XmlElement(name = "UltmtCdtr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Party40Choice ultmtCdtr;
    @XmlElement(name = "Purp", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected Purpose2Choice purp;

    /**
     * 获取属性 intrBkSttlmAmt 的值。
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    /**
     * 设置属性 intrBkSttlmAmt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setIntrBkSttlmAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.intrBkSttlmAmt = value;
    }

    /**
     * 获取属性 amt 的值。
     * 
     * @return
     *     possible object is
     *     {@link AmountType4Choice }
     *     
     */
    public AmountType4Choice getAmt() {
        return amt;
    }

    /**
     * 设置属性 amt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType4Choice }
     *     
     */
    public void setAmt(AmountType4Choice value) {
        this.amt = value;
    }

    /**
     * 获取属性 intrBkSttlmDt 的值。
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
     * 设置属性 intrBkSttlmDt 的值。
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
     * 获取属性 reqdColltnDt 的值。
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
     * 设置属性 reqdColltnDt 的值。
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
     * 获取属性 reqdExctnDt 的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getReqdExctnDt() {
        return reqdExctnDt;
    }

    /**
     * 设置属性 reqdExctnDt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setReqdExctnDt(DateAndDateTime2Choice value) {
        this.reqdExctnDt = value;
    }

    /**
     * 获取属性 cdtrSchmeId 的值。
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
     * 设置属性 cdtrSchmeId 的值。
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
     * 获取属性 sttlmInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementInstruction11 }
     *     
     */
    public SettlementInstruction11 getSttlmInf() {
        return sttlmInf;
    }

    /**
     * 设置属性 sttlmInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementInstruction11 }
     *     
     */
    public void setSttlmInf(SettlementInstruction11 value) {
        this.sttlmInf = value;
    }

    /**
     * 获取属性 pmtTpInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformation27 }
     *     
     */
    public PaymentTypeInformation27 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * 设置属性 pmtTpInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation27 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation27 value) {
        this.pmtTpInf = value;
    }

    /**
     * 获取属性 pmtMtd 的值。
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
     * 设置属性 pmtMtd 的值。
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
     * 获取属性 mndtRltdInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedData2Choice }
     *     
     */
    public MandateRelatedData2Choice getMndtRltdInf() {
        return mndtRltdInf;
    }

    /**
     * 设置属性 mndtRltdInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedData2Choice }
     *     
     */
    public void setMndtRltdInf(MandateRelatedData2Choice value) {
        this.mndtRltdInf = value;
    }

    /**
     * 获取属性 rmtInf 的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public RemittanceInformation21 getRmtInf() {
        return rmtInf;
    }

    /**
     * 设置属性 rmtInf 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public void setRmtInf(RemittanceInformation21 value) {
        this.rmtInf = value;
    }

    /**
     * 获取属性 ultmtDbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * 设置属性 ultmtDbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setUltmtDbtr(Party40Choice value) {
        this.ultmtDbtr = value;
    }

    /**
     * 获取属性 dbtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getDbtr() {
        return dbtr;
    }

    /**
     * 设置属性 dbtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setDbtr(Party40Choice value) {
        this.dbtr = value;
    }

    /**
     * 获取属性 dbtrAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * 设置属性 dbtrAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAcct(CashAccount40 value) {
        this.dbtrAcct = value;
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
     * 获取属性 dbtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * 设置属性 dbtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount40 value) {
        this.dbtrAgtAcct = value;
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

    /**
     * 获取属性 cdtrAgtAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * 设置属性 cdtrAgtAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount40 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * 获取属性 cdtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getCdtr() {
        return cdtr;
    }

    /**
     * 设置属性 cdtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setCdtr(Party40Choice value) {
        this.cdtr = value;
    }

    /**
     * 获取属性 cdtrAcct 的值。
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * 设置属性 cdtrAcct 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAcct(CashAccount40 value) {
        this.cdtrAcct = value;
    }

    /**
     * 获取属性 ultmtCdtr 的值。
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * 设置属性 ultmtCdtr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setUltmtCdtr(Party40Choice value) {
        this.ultmtCdtr = value;
    }

    /**
     * 获取属性 purp 的值。
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice }
     *     
     */
    public Purpose2Choice getPurp() {
        return purp;
    }

    /**
     * 设置属性 purp 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice }
     *     
     */
    public void setPurp(Purpose2Choice value) {
        this.purp = value;
    }

}
