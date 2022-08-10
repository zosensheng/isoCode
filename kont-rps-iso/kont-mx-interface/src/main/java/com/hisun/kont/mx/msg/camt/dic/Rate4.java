package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to qualify the interest rate.
 * 
 * <p>Rate4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Rate4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}RateType4Choice"/>
 *         &lt;element name="VldtyRg" type="{}ActiveOrHistoricCurrencyAndAmountRange2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rate4", propOrder = {
    "tp",
    "vldtyRg"
})
public class Rate4 {

    @XmlElement(name = "Tp", required = true)
    protected RateType4Choice tp;
    @XmlElement(name = "VldtyRg")
    protected ActiveOrHistoricCurrencyAndAmountRange2 vldtyRg;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RateType4Choice }
     *     
     */
    public RateType4Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RateType4Choice }
     *     
     */
    public void setTp(RateType4Choice value) {
        this.tp = value;
    }

    /**
     * ��ȡvldtyRg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmountRange2 }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmountRange2 getVldtyRg() {
        return vldtyRg;
    }

    /**
     * ����vldtyRg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmountRange2 }
     *     
     */
    public void setVldtyRg(ActiveOrHistoricCurrencyAndAmountRange2 value) {
        this.vldtyRg = value;
    }

}
