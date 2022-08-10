package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Period of time details related to the tax payment.
 * 
 * <p>TaxPeriod3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TaxPeriod3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Yr" type="{}ISOYear" minOccurs="0"/>
 *         &lt;element name="Tp" type="{}TaxRecordPeriod1Code" minOccurs="0"/>
 *         &lt;element name="FrToDt" type="{}DatePeriod2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxPeriod3", propOrder = {
    "yr",
    "tp",
    "frToDt"
})
public class TaxPeriod3 {

    @XmlElement(name = "Yr")
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yr;
    @XmlElement(name = "Tp")
    @XmlSchemaType(name = "string")
    protected TaxRecordPeriod1Code tp;
    @XmlElement(name = "FrToDt")
    protected DatePeriod2 frToDt;

    /**
     * ��ȡyr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getYr() {
        return yr;
    }

    /**
     * ����yr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setYr(XMLGregorianCalendar value) {
        this.yr = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TaxRecordPeriod1Code }
     *     
     */
    public TaxRecordPeriod1Code getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TaxRecordPeriod1Code }
     *     
     */
    public void setTp(TaxRecordPeriod1Code value) {
        this.tp = value;
    }

    /**
     * ��ȡfrToDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DatePeriod2 }
     *     
     */
    public DatePeriod2 getFrToDt() {
        return frToDt;
    }

    /**
     * ����frToDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DatePeriod2 }
     *     
     */
    public void setFrToDt(DatePeriod2 value) {
        this.frToDt = value;
    }

}
