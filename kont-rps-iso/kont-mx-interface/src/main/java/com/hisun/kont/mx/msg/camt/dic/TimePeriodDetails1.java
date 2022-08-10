package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Particular time span specified between a start time and an end time. The time period cannot exceed 24 hours.
 * 
 * <p>TimePeriodDetails1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TimePeriodDetails1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FrTm" type="{}ISOTime"/>
 *         &lt;element name="ToTm" type="{}ISOTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimePeriodDetails1", propOrder = {
    "frTm",
    "toTm"
})
public class TimePeriodDetails1 {

    @XmlElement(name = "FrTm", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar frTm;
    @XmlElement(name = "ToTm")
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar toTm;

    /**
     * ��ȡfrTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrTm() {
        return frTm;
    }

    /**
     * ����frTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrTm(XMLGregorianCalendar value) {
        this.frTm = value;
    }

    /**
     * ��ȡtoTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToTm() {
        return toTm;
    }

    /**
     * ����toTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToTm(XMLGregorianCalendar value) {
        this.toTm = value;
    }

}
