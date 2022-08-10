package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Range of time defined by a start date and an end date.
 * 
 * <p>DatePeriod2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DatePeriod2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FrDt" type="{}ISODate"/>
 *         &lt;element name="ToDt" type="{}ISODate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatePeriod2", propOrder = {
    "frDt",
    "toDt"
})
public class DatePeriod2 {

    @XmlElement(name = "FrDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frDt;
    @XmlElement(name = "ToDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar toDt;

    /**
     * ��ȡfrDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrDt() {
        return frDt;
    }

    /**
     * ����frDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrDt(XMLGregorianCalendar value) {
        this.frDt = value;
    }

    /**
     * ��ȡtoDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDt() {
        return toDt;
    }

    /**
     * ����toDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDt(XMLGregorianCalendar value) {
        this.toDt = value;
    }

}
