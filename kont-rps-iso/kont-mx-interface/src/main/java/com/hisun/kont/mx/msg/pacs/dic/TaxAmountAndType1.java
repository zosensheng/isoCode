package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the amount with a specific type.
 * 
 * <p>TaxAmountAndType1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TaxAmountAndType1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}TaxAmountType1Choice" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxAmountAndType1", propOrder = {
    "tp",
    "amt"
})
public class TaxAmountAndType1 {

    @XmlElement(name = "Tp")
    protected TaxAmountType1Choice tp;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TaxAmountType1Choice }
     *     
     */
    public TaxAmountType1Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmountType1Choice }
     *     
     */
    public void setTp(TaxAmountType1Choice value) {
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

}
