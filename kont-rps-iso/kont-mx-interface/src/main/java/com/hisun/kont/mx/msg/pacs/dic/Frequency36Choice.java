package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice of format for a frequency, for example, the frequency of payment.
 * 
 * <p>Frequency36Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Frequency36Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Tp" type="{}Frequency6Code"/>
 *         &lt;element name="Prd" type="{}FrequencyPeriod1"/>
 *         &lt;element name="PtInTm" type="{}FrequencyAndMoment1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Frequency36Choice", propOrder = {
    "tp",
    "prd",
    "ptInTm"
})
public class Frequency36Choice {

    @XmlElement(name = "Tp")
    @XmlSchemaType(name = "string")
    protected Frequency6Code tp;
    @XmlElement(name = "Prd")
    protected FrequencyPeriod1 prd;
    @XmlElement(name = "PtInTm")
    protected FrequencyAndMoment1 ptInTm;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Frequency6Code }
     *     
     */
    public Frequency6Code getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency6Code }
     *     
     */
    public void setTp(Frequency6Code value) {
        this.tp = value;
    }

    /**
     * ��ȡprd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FrequencyPeriod1 }
     *     
     */
    public FrequencyPeriod1 getPrd() {
        return prd;
    }

    /**
     * ����prd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyPeriod1 }
     *     
     */
    public void setPrd(FrequencyPeriod1 value) {
        this.prd = value;
    }

    /**
     * ��ȡptInTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FrequencyAndMoment1 }
     *     
     */
    public FrequencyAndMoment1 getPtInTm() {
        return ptInTm;
    }

    /**
     * ����ptInTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FrequencyAndMoment1 }
     *     
     */
    public void setPtInTm(FrequencyAndMoment1 value) {
        this.ptInTm = value;
    }

}
