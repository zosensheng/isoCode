package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Defines a frequency in terms a specific moment within a specified period type.
 * 
 * <p>FrequencyAndMoment1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FrequencyAndMoment1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}Frequency6Code"/>
 *         &lt;element name="PtInTm" type="{}Exact2NumericText"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FrequencyAndMoment1", propOrder = {
    "tp",
    "ptInTm"
})
public class FrequencyAndMoment1 {

    @XmlElement(name = "Tp", required = true)
    @XmlSchemaType(name = "string")
    protected Frequency6Code tp;
    @XmlElement(name = "PtInTm", required = true)
    protected String ptInTm;

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
     * ��ȡptInTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPtInTm() {
        return ptInTm;
    }

    /**
     * ����ptInTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPtInTm(String value) {
        this.ptInTm = value;
    }

}
