package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to provide the total sum of entries per bank transaction code.
 * 
 * <p>TotalsPerBankTransactionCode5 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TotalsPerBankTransactionCode5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="NbOfNtries" type="{}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="Sum" type="{}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="TtlNetNtry" type="{}AmountAndDirection35" minOccurs="0"/>
 *         &lt;element name="CdtNtries" type="{}NumberAndSumOfTransactions1" minOccurs="0"/>
 *         &lt;element name="DbtNtries" type="{}NumberAndSumOfTransactions1" minOccurs="0"/>
 *         &lt;element name="FcstInd" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="BkTxCd" type="{}BankTransactionCodeStructure4"/>
 *         &lt;element name="Avlbty" type="{}CashAvailability1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Dt" type="{}DateAndDateTime2Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalsPerBankTransactionCode5", propOrder = {
    "nbOfNtries",
    "sum",
    "ttlNetNtry",
    "cdtNtries",
    "dbtNtries",
    "fcstInd",
    "bkTxCd",
    "avlbty",
    "dt"
})
public class TotalsPerBankTransactionCode5 {

    @XmlElement(name = "NbOfNtries")
    protected String nbOfNtries;
    @XmlElement(name = "Sum")
    protected BigDecimal sum;
    @XmlElement(name = "TtlNetNtry")
    protected AmountAndDirection35 ttlNetNtry;
    @XmlElement(name = "CdtNtries")
    protected NumberAndSumOfTransactions1 cdtNtries;
    @XmlElement(name = "DbtNtries")
    protected NumberAndSumOfTransactions1 dbtNtries;
    @XmlElement(name = "FcstInd")
    protected Boolean fcstInd;
    @XmlElement(name = "BkTxCd", required = true)
    protected BankTransactionCodeStructure4 bkTxCd;
    @XmlElement(name = "Avlbty")
    protected List<CashAvailability1> avlbty;
    @XmlElement(name = "Dt")
    protected DateAndDateTime2Choice dt;

    /**
     * ��ȡnbOfNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfNtries() {
        return nbOfNtries;
    }

    /**
     * ����nbOfNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfNtries(String value) {
        this.nbOfNtries = value;
    }

    /**
     * ��ȡsum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * ����sum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSum(BigDecimal value) {
        this.sum = value;
    }

    /**
     * ��ȡttlNetNtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndDirection35 }
     *     
     */
    public AmountAndDirection35 getTtlNetNtry() {
        return ttlNetNtry;
    }

    /**
     * ����ttlNetNtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndDirection35 }
     *     
     */
    public void setTtlNetNtry(AmountAndDirection35 value) {
        this.ttlNetNtry = value;
    }

    /**
     * ��ȡcdtNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getCdtNtries() {
        return cdtNtries;
    }

    /**
     * ����cdtNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setCdtNtries(NumberAndSumOfTransactions1 value) {
        this.cdtNtries = value;
    }

    /**
     * ��ȡdbtNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getDbtNtries() {
        return dbtNtries;
    }

    /**
     * ����dbtNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setDbtNtries(NumberAndSumOfTransactions1 value) {
        this.dbtNtries = value;
    }

    /**
     * ��ȡfcstInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFcstInd() {
        return fcstInd;
    }

    /**
     * ����fcstInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFcstInd(Boolean value) {
        this.fcstInd = value;
    }

    /**
     * ��ȡbkTxCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BankTransactionCodeStructure4 }
     *     
     */
    public BankTransactionCodeStructure4 getBkTxCd() {
        return bkTxCd;
    }

    /**
     * ����bkTxCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BankTransactionCodeStructure4 }
     *     
     */
    public void setBkTxCd(BankTransactionCodeStructure4 value) {
        this.bkTxCd = value;
    }

    /**
     * Gets the value of the avlbty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the avlbty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvlbty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CashAvailability1 }
     * 
     * 
     */
    public List<CashAvailability1> getAvlbty() {
        if (avlbty == null) {
            avlbty = new ArrayList<CashAvailability1>();
        }
        return this.avlbty;
    }

    /**
     * ��ȡdt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getDt() {
        return dt;
    }

    /**
     * ����dt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setDt(DateAndDateTime2Choice value) {
        this.dt = value;
    }

}
