package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details on the interest that applies to the account at a particular moment in time.
 * 
 * <p>AccountInterest4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AccountInterest4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}InterestType1Choice" minOccurs="0"/>
 *         &lt;element name="Rate" type="{}Rate4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{}DateTimePeriod1" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{}Max35Text" minOccurs="0"/>
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
@XmlType(name = "AccountInterest4", propOrder = {
    "tp",
    "rate",
    "frToDt",
    "rsn",
    "tax"
})
public class AccountInterest4 {

    @XmlElement(name = "Tp")
    protected InterestType1Choice tp;
    @XmlElement(name = "Rate")
    protected List<Rate4> rate;
    @XmlElement(name = "FrToDt")
    protected DateTimePeriod1 frToDt;
    @XmlElement(name = "Rsn")
    protected String rsn;
    @XmlElement(name = "Tax")
    protected TaxCharges2 tax;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InterestType1Choice }
     *     
     */
    public InterestType1Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InterestType1Choice }
     *     
     */
    public void setTp(InterestType1Choice value) {
        this.tp = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rate4 }
     * 
     * 
     */
    public List<Rate4> getRate() {
        if (rate == null) {
            rate = new ArrayList<Rate4>();
        }
        return this.rate;
    }

    /**
     * ��ȡfrToDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateTimePeriod1 }
     *     
     */
    public DateTimePeriod1 getFrToDt() {
        return frToDt;
    }

    /**
     * ����frToDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePeriod1 }
     *     
     */
    public void setFrToDt(DateTimePeriod1 value) {
        this.frToDt = value;
    }

    /**
     * ��ȡrsn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRsn() {
        return rsn;
    }

    /**
     * ����rsn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRsn(String value) {
        this.rsn = value;
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
