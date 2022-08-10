package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Specifies key elements as defined in the original transaction.
 * 
 * <p>OriginalTransactionReference36 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OriginalTransactionReference36">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="IntrBkSttlmAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}AmountType4Choice" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdColltnDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="ReqdExctnDt" type="{}DateAndDateTime2Choice" minOccurs="0"/>
 *         &lt;element name="CdtrSchmeId" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="SttlmInf" type="{}SettlementInstruction11" minOccurs="0"/>
 *         &lt;element name="PmtTpInf" type="{}PaymentTypeInformation27" minOccurs="0"/>
 *         &lt;element name="PmtMtd" type="{}PaymentMethod4Code" minOccurs="0"/>
 *         &lt;element name="MndtRltdInf" type="{}MandateRelatedData2Choice" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{}RemittanceInformation21" minOccurs="0"/>
 *         &lt;element name="UltmtDbtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="DbtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="CdtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Purp" type="{}Purpose2Choice" minOccurs="0"/>
 *         &lt;element name="UndrlygCstmrCdtTrf" type="{}CreditTransferTransaction52" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransactionReference36", propOrder = {
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
    "purp",
    "undrlygCstmrCdtTrf"
})
public class OriginalTransactionReference36 {

    @XmlElement(name = "IntrBkSttlmAmt")
    protected ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt;
    @XmlElement(name = "Amt")
    protected AmountType4Choice amt;
    @XmlElement(name = "IntrBkSttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "ReqdColltnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "ReqdExctnDt")
    protected DateAndDateTime2Choice reqdExctnDt;
    @XmlElement(name = "CdtrSchmeId")
    protected PartyIdentification135 cdtrSchmeId;
    @XmlElement(name = "SttlmInf")
    protected SettlementInstruction11 sttlmInf;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformation27 pmtTpInf;
    @XmlElement(name = "PmtMtd")
    @XmlSchemaType(name = "string")
    protected PaymentMethod4Code pmtMtd;
    @XmlElement(name = "MndtRltdInf")
    protected MandateRelatedData2Choice mndtRltdInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation21 rmtInf;
    @XmlElement(name = "UltmtDbtr")
    protected Party40Choice ultmtDbtr;
    @XmlElement(name = "Dbtr")
    protected Party40Choice dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount40 dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Cdtr")
    protected Party40Choice cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount40 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected Party40Choice ultmtCdtr;
    @XmlElement(name = "Purp")
    protected Purpose2Choice purp;
    @XmlElement(name = "UndrlygCstmrCdtTrf")
    protected CreditTransferTransaction52 undrlygCstmrCdtTrf;

    /**
     * ��ȡintrBkSttlmAmt���Ե�ֵ��
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
     * ����intrBkSttlmAmt���Ե�ֵ��
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
     * ��ȡamt���Ե�ֵ��
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
     * ����amt���Ե�ֵ��
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
     * ��ȡintrBkSttlmDt���Ե�ֵ��
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
     * ����intrBkSttlmDt���Ե�ֵ��
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
     * ��ȡreqdColltnDt���Ե�ֵ��
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
     * ����reqdColltnDt���Ե�ֵ��
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
     * ��ȡreqdExctnDt���Ե�ֵ��
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
     * ����reqdExctnDt���Ե�ֵ��
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
     * ��ȡcdtrSchmeId���Ե�ֵ��
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
     * ����cdtrSchmeId���Ե�ֵ��
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
     * ��ȡsttlmInf���Ե�ֵ��
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
     * ����sttlmInf���Ե�ֵ��
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
     * ��ȡpmtTpInf���Ե�ֵ��
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
     * ����pmtTpInf���Ե�ֵ��
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
     * ��ȡpmtMtd���Ե�ֵ��
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
     * ����pmtMtd���Ե�ֵ��
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
     * ��ȡmndtRltdInf���Ե�ֵ��
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
     * ����mndtRltdInf���Ե�ֵ��
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
     * ��ȡrmtInf���Ե�ֵ��
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
     * ����rmtInf���Ե�ֵ��
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
     * ��ȡultmtDbtr���Ե�ֵ��
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
     * ����ultmtDbtr���Ե�ֵ��
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
     * ��ȡdbtr���Ե�ֵ��
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
     * ����dbtr���Ե�ֵ��
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
     * ��ȡdbtrAcct���Ե�ֵ��
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
     * ����dbtrAcct���Ե�ֵ��
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
     * ��ȡdbtrAgt���Ե�ֵ��
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
     * ����dbtrAgt���Ե�ֵ��
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
     * ��ȡdbtrAgtAcct���Ե�ֵ��
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
     * ����dbtrAgtAcct���Ե�ֵ��
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
     * ��ȡcdtrAgt���Ե�ֵ��
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
     * ����cdtrAgt���Ե�ֵ��
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
     * ��ȡcdtrAgtAcct���Ե�ֵ��
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
     * ����cdtrAgtAcct���Ե�ֵ��
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
     * ��ȡcdtr���Ե�ֵ��
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
     * ����cdtr���Ե�ֵ��
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
     * ��ȡcdtrAcct���Ե�ֵ��
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
     * ����cdtrAcct���Ե�ֵ��
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
     * ��ȡultmtCdtr���Ե�ֵ��
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
     * ����ultmtCdtr���Ե�ֵ��
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
     * ��ȡpurp���Ե�ֵ��
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
     * ����purp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice }
     *     
     */
    public void setPurp(Purpose2Choice value) {
        this.purp = value;
    }

    /**
     * ��ȡundrlygCstmrCdtTrf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferTransaction52 }
     *     
     */
    public CreditTransferTransaction52 getUndrlygCstmrCdtTrf() {
        return undrlygCstmrCdtTrf;
    }

    /**
     * ����undrlygCstmrCdtTrf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferTransaction52 }
     *     
     */
    public void setUndrlygCstmrCdtTrf(CreditTransferTransaction52 value) {
        this.undrlygCstmrCdtTrf = value;
    }

}
