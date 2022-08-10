package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SettlementInstruction11 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SettlementInstruction11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="SttlmMtd" type="{}SettlementMethod1Code"/>
 *         &lt;element name="SttlmAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="ClrSys" type="{}ClearingSystemIdentification3Choice" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InstgRmbrsmntAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InstdRmbrsmntAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="ThrdRmbrsmntAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementInstruction11", propOrder = {
    "sttlmMtd",
    "sttlmAcct",
    "clrSys",
    "instgRmbrsmntAgt",
    "instgRmbrsmntAgtAcct",
    "instdRmbrsmntAgt",
    "instdRmbrsmntAgtAcct",
    "thrdRmbrsmntAgt",
    "thrdRmbrsmntAgtAcct"
})
public class SettlementInstruction11 {

    @XmlElement(name = "SttlmMtd", required = true)
    @XmlSchemaType(name = "string")
    protected SettlementMethod1Code sttlmMtd;
    @XmlElement(name = "SttlmAcct")
    protected CashAccount40 sttlmAcct;
    @XmlElement(name = "ClrSys")
    protected ClearingSystemIdentification3Choice clrSys;
    @XmlElement(name = "InstgRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt;
    @XmlElement(name = "InstgRmbrsmntAgtAcct")
    protected CashAccount40 instgRmbrsmntAgtAcct;
    @XmlElement(name = "InstdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt;
    @XmlElement(name = "InstdRmbrsmntAgtAcct")
    protected CashAccount40 instdRmbrsmntAgtAcct;
    @XmlElement(name = "ThrdRmbrsmntAgt")
    protected BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt;
    @XmlElement(name = "ThrdRmbrsmntAgtAcct")
    protected CashAccount40 thrdRmbrsmntAgtAcct;

    /**
     * ��ȡsttlmMtd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public SettlementMethod1Code getSttlmMtd() {
        return sttlmMtd;
    }

    /**
     * ����sttlmMtd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementMethod1Code }
     *     
     */
    public void setSttlmMtd(SettlementMethod1Code value) {
        this.sttlmMtd = value;
    }

    /**
     * ��ȡsttlmAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getSttlmAcct() {
        return sttlmAcct;
    }

    /**
     * ����sttlmAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setSttlmAcct(CashAccount40 value) {
        this.sttlmAcct = value;
    }

    /**
     * ��ȡclrSys���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public ClearingSystemIdentification3Choice getClrSys() {
        return clrSys;
    }

    /**
     * ����clrSys���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemIdentification3Choice }
     *     
     */
    public void setClrSys(ClearingSystemIdentification3Choice value) {
        this.clrSys = value;
    }

    /**
     * ��ȡinstgRmbrsmntAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstgRmbrsmntAgt() {
        return instgRmbrsmntAgt;
    }

    /**
     * ����instgRmbrsmntAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstgRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instgRmbrsmntAgt = value;
    }

    /**
     * ��ȡinstgRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getInstgRmbrsmntAgtAcct() {
        return instgRmbrsmntAgtAcct;
    }

    /**
     * ����instgRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setInstgRmbrsmntAgtAcct(CashAccount40 value) {
        this.instgRmbrsmntAgtAcct = value;
    }

    /**
     * ��ȡinstdRmbrsmntAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstdRmbrsmntAgt() {
        return instdRmbrsmntAgt;
    }

    /**
     * ����instdRmbrsmntAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instdRmbrsmntAgt = value;
    }

    /**
     * ��ȡinstdRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getInstdRmbrsmntAgtAcct() {
        return instdRmbrsmntAgtAcct;
    }

    /**
     * ����instdRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setInstdRmbrsmntAgtAcct(CashAccount40 value) {
        this.instdRmbrsmntAgtAcct = value;
    }

    /**
     * ��ȡthrdRmbrsmntAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getThrdRmbrsmntAgt() {
        return thrdRmbrsmntAgt;
    }

    /**
     * ����thrdRmbrsmntAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setThrdRmbrsmntAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.thrdRmbrsmntAgt = value;
    }

    /**
     * ��ȡthrdRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getThrdRmbrsmntAgtAcct() {
        return thrdRmbrsmntAgtAcct;
    }

    /**
     * ����thrdRmbrsmntAgtAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setThrdRmbrsmntAgtAcct(CashAccount40 value) {
        this.thrdRmbrsmntAgtAcct = value;
    }

}
