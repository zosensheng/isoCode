package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Deposit of an amount of money defined in cash notes and/or coins.
 * 
 * <p>CashDeposit1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CashDeposit1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="NoteDnmtn" type="{}ActiveCurrencyAndAmount"/>
 *         &lt;element name="NbOfNotes" type="{}Max15NumericText"/>
 *         &lt;element name="Amt" type="{}ActiveCurrencyAndAmount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CashDeposit1", propOrder = {
    "noteDnmtn",
    "nbOfNotes",
    "amt"
})
public class CashDeposit1 {

    @XmlElement(name = "NoteDnmtn", required = true)
    protected ActiveCurrencyAndAmount noteDnmtn;
    @XmlElement(name = "NbOfNotes", required = true)
    protected String nbOfNotes;
    @XmlElement(name = "Amt", required = true)
    protected ActiveCurrencyAndAmount amt;

    /**
     * ��ȡnoteDnmtn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getNoteDnmtn() {
        return noteDnmtn;
    }

    /**
     * ����noteDnmtn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setNoteDnmtn(ActiveCurrencyAndAmount value) {
        this.noteDnmtn = value;
    }

    /**
     * ��ȡnbOfNotes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfNotes() {
        return nbOfNotes;
    }

    /**
     * ����nbOfNotes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfNotes(String value) {
        this.nbOfNotes = value;
    }

    /**
     * ��ȡamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveCurrencyAndAmount value) {
        this.amt = value;
    }

}
