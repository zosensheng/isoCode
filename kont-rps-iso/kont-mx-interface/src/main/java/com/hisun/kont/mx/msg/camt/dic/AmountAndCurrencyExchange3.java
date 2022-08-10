package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Set of elements used to provide information on the original amount.
 * 
 * <p>AmountAndCurrencyExchange3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AmountAndCurrencyExchange3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="InstdAmt" type="{}AmountAndCurrencyExchangeDetails3" minOccurs="0"/>
 *         &lt;element name="TxAmt" type="{}AmountAndCurrencyExchangeDetails3" minOccurs="0"/>
 *         &lt;element name="CntrValAmt" type="{}AmountAndCurrencyExchangeDetails3" minOccurs="0"/>
 *         &lt;element name="AnncdPstngAmt" type="{}AmountAndCurrencyExchangeDetails3" minOccurs="0"/>
 *         &lt;element name="PrtryAmt" type="{}AmountAndCurrencyExchangeDetails4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmountAndCurrencyExchange3", propOrder = {
    "instdAmt",
    "txAmt",
    "cntrValAmt",
    "anncdPstngAmt",
    "prtryAmt"
})
public class AmountAndCurrencyExchange3 {

    @XmlElement(name = "InstdAmt")
    protected AmountAndCurrencyExchangeDetails3 instdAmt;
    @XmlElement(name = "TxAmt")
    protected AmountAndCurrencyExchangeDetails3 txAmt;
    @XmlElement(name = "CntrValAmt")
    protected AmountAndCurrencyExchangeDetails3 cntrValAmt;
    @XmlElement(name = "AnncdPstngAmt")
    protected AmountAndCurrencyExchangeDetails3 anncdPstngAmt;
    @XmlElement(name = "PrtryAmt")
    protected List<AmountAndCurrencyExchangeDetails4> prtryAmt;

    /**
     * ��ȡinstdAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public AmountAndCurrencyExchangeDetails3 getInstdAmt() {
        return instdAmt;
    }

    /**
     * ����instdAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public void setInstdAmt(AmountAndCurrencyExchangeDetails3 value) {
        this.instdAmt = value;
    }

    /**
     * ��ȡtxAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public AmountAndCurrencyExchangeDetails3 getTxAmt() {
        return txAmt;
    }

    /**
     * ����txAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public void setTxAmt(AmountAndCurrencyExchangeDetails3 value) {
        this.txAmt = value;
    }

    /**
     * ��ȡcntrValAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public AmountAndCurrencyExchangeDetails3 getCntrValAmt() {
        return cntrValAmt;
    }

    /**
     * ����cntrValAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public void setCntrValAmt(AmountAndCurrencyExchangeDetails3 value) {
        this.cntrValAmt = value;
    }

    /**
     * ��ȡanncdPstngAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public AmountAndCurrencyExchangeDetails3 getAnncdPstngAmt() {
        return anncdPstngAmt;
    }

    /**
     * ����anncdPstngAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AmountAndCurrencyExchangeDetails3 }
     *     
     */
    public void setAnncdPstngAmt(AmountAndCurrencyExchangeDetails3 value) {
        this.anncdPstngAmt = value;
    }

    /**
     * Gets the value of the prtryAmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtryAmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtryAmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountAndCurrencyExchangeDetails4 }
     * 
     * 
     */
    public List<AmountAndCurrencyExchangeDetails4> getPrtryAmt() {
        if (prtryAmt == null) {
            prtryAmt = new ArrayList<AmountAndCurrencyExchangeDetails4>();
        }
        return this.prtryAmt;
    }

}
