package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further individual record details on the charges related to the payment transaction.
 * 
 * <p>ChargesRecord3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ChargesRecord3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{}CreditDebitCode" minOccurs="0"/>
 *         &lt;element name="ChrgInclInd" type="{}ChargeIncludedIndicator" minOccurs="0"/>
 *         &lt;element name="Tp" type="{}ChargeType3Choice" minOccurs="0"/>
 *         &lt;element name="Rate" type="{}PercentageRate" minOccurs="0"/>
 *         &lt;element name="Br" type="{}ChargeBearerType1Code" minOccurs="0"/>
 *         &lt;element name="Agt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="Tax" type="{}TaxCharges2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargesRecord3", propOrder = {
    "amt",
    "cdtDbtInd",
    "chrgInclInd",
    "tp",
    "rate",
    "br",
    "agt",
    "tax"
})
public class ChargesRecord3 {

    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd")
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "ChrgInclInd")
    protected Boolean chrgInclInd;
    @XmlElement(name = "Tp")
    protected ChargeType3Choice tp;
    @XmlElement(name = "Rate")
    protected BigDecimal rate;
    @XmlElement(name = "Br")
    @XmlSchemaType(name = "string")
    protected ChargeBearerType1Code br;
    @XmlElement(name = "Agt")
    protected BranchAndFinancialInstitutionIdentification6 agt;
    @XmlElement(name = "Tax")
    protected TaxCharges2 tax;

    /**
     * ��ȡamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * ��ȡcdtDbtInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditDebitCode }
     *     
     */
    public CreditDebitCode getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * ����cdtDbtInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDebitCode }
     *     
     */
    public void setCdtDbtInd(CreditDebitCode value) {
        this.cdtDbtInd = value;
    }

    /**
     * ��ȡchrgInclInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isChrgInclInd() {
        return chrgInclInd;
    }

    /**
     * ����chrgInclInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChrgInclInd(Boolean value) {
        this.chrgInclInd = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ChargeType3Choice }
     *     
     */
    public ChargeType3Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeType3Choice }
     *     
     */
    public void setTp(ChargeType3Choice value) {
        this.tp = value;
    }

    /**
     * ��ȡrate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * ����rate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * ��ȡbr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public ChargeBearerType1Code getBr() {
        return br;
    }

    /**
     * ����br���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType1Code }
     *     
     */
    public void setBr(ChargeBearerType1Code value) {
        this.br = value;
    }

    /**
     * ��ȡagt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getAgt() {
        return agt;
    }

    /**
     * ����agt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.agt = value;
    }

    /**
     * ��ȡtax���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TaxCharges2 }
     *     
     */
    public TaxCharges2 getTax() {
        return tax;
    }

    /**
     * ����tax���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TaxCharges2 }
     *     
     */
    public void setTax(TaxCharges2 value) {
        this.tax = value;
    }

}
