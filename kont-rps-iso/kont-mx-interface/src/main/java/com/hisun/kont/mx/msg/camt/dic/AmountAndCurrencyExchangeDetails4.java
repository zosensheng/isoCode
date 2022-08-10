package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to provide information on the original amount and currency exchange.
 * 
 * <p>AmountAndCurrencyExchangeDetails4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AmountAndCurrencyExchangeDetails4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}Max35Text"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CcyXchg" type="{}CurrencyExchange5" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountAndCurrencyExchangeDetails4", propOrder = {
    "tp",
    "amt",
    "ccyXchg"
})
public class AmountAndCurrencyExchangeDetails4 {

    @XmlElement(name = "Tp", required = true)
    protected String tp;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CcyXchg")
    protected CurrencyExchange5 ccyXchg;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTp(String value) {
        this.tp = value;
    }

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
     * ��ȡccyXchg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CurrencyExchange5 }
     *     
     */
    public CurrencyExchange5 getCcyXchg() {
        return ccyXchg;
    }

    /**
     * ����ccyXchg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyExchange5 }
     *     
     */
    public void setCcyXchg(CurrencyExchange5 value) {
        this.ccyXchg = value;
    }

}
