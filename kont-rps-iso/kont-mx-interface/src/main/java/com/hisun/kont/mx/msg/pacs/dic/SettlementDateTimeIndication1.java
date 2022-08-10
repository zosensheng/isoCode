package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Information on the occurred settlement time(s) of the payment transaction.
 * 
 * <p>SettlementDateTimeIndication1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SettlementDateTimeIndication1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="DbtDtTm" type="{}ISODateTime" minOccurs="0"/>
 *         &lt;element name="CdtDtTm" type="{}ISODateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SettlementDateTimeIndication1", propOrder = {
    "dbtDtTm",
    "cdtDtTm"
})
public class SettlementDateTimeIndication1 {

    @XmlElement(name = "DbtDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dbtDtTm;
    @XmlElement(name = "CdtDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar cdtDtTm;

    /**
     * ��ȡdbtDtTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDbtDtTm() {
        return dbtDtTm;
    }

    /**
     * ����dbtDtTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDbtDtTm(XMLGregorianCalendar value) {
        this.dbtDtTm = value;
    }

    /**
     * ��ȡcdtDtTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCdtDtTm() {
        return cdtDtTm;
    }

    /**
     * ����cdtDtTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCdtDtTm(XMLGregorianCalendar value) {
        this.cdtDtTm = value;
    }

}
