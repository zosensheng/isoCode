package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the requested reporting period.
 * 
 * <p>ReportingPeriod5 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ReportingPeriod5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FrToDt" type="{}DatePeriod3"/>
 *         &lt;element name="FrToTm" type="{}TimePeriodDetails1" minOccurs="0"/>
 *         &lt;element name="Tp" type="{}QueryType3Code"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportingPeriod5", propOrder = {
    "frToDt",
    "frToTm",
    "tp"
})
public class ReportingPeriod5 {

    @XmlElement(name = "FrToDt", required = true)
    protected DatePeriod3 frToDt;
    @XmlElement(name = "FrToTm")
    protected TimePeriodDetails1 frToTm;
    @XmlElement(name = "Tp", required = true)
    @XmlSchemaType(name = "string")
    protected QueryType3Code tp;

    /**
     * ��ȡfrToDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DatePeriod3 }
     *     
     */
    public DatePeriod3 getFrToDt() {
        return frToDt;
    }

    /**
     * ����frToDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriod3 }
     *     
     */
    public void setFrToDt(DatePeriod3 value) {
        this.frToDt = value;
    }

    /**
     * ��ȡfrToTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TimePeriodDetails1 }
     *     
     */
    public TimePeriodDetails1 getFrToTm() {
        return frToTm;
    }

    /**
     * ����frToTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TimePeriodDetails1 }
     *     
     */
    public void setFrToTm(TimePeriodDetails1 value) {
        this.frToTm = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link QueryType3Code }
     *     
     */
    public QueryType3Code getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link QueryType3Code }
     *     
     */
    public void setTp(QueryType3Code value) {
        this.tp = value;
    }

}
