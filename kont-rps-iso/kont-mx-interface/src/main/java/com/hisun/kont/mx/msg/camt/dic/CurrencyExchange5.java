package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Set of elements used to provide details of the currency exchange.
 * 
 * <p>CurrencyExchange5 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CurrencyExchange5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="SrcCcy" type="{}ActiveOrHistoricCurrencyCode"/>
 *         &lt;element name="TrgtCcy" type="{}ActiveOrHistoricCurrencyCode" minOccurs="0"/>
 *         &lt;element name="UnitCcy" type="{}ActiveOrHistoricCurrencyCode" minOccurs="0"/>
 *         &lt;element name="XchgRate" type="{}BaseOneRate"/>
 *         &lt;element name="CtrctId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="QtnDt" type="{}ISODateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CurrencyExchange5", propOrder = {
    "srcCcy",
    "trgtCcy",
    "unitCcy",
    "xchgRate",
    "ctrctId",
    "qtnDt"
})
public class CurrencyExchange5 {

    @XmlElement(name = "SrcCcy", required = true)
    protected String srcCcy;
    @XmlElement(name = "TrgtCcy")
    protected String trgtCcy;
    @XmlElement(name = "UnitCcy")
    protected String unitCcy;
    @XmlElement(name = "XchgRate", required = true)
    protected BigDecimal xchgRate;
    @XmlElement(name = "CtrctId")
    protected String ctrctId;
    @XmlElement(name = "QtnDt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar qtnDt;

    /**
     * ��ȡsrcCcy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcCcy() {
        return srcCcy;
    }

    /**
     * ����srcCcy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcCcy(String value) {
        this.srcCcy = value;
    }

    /**
     * ��ȡtrgtCcy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrgtCcy() {
        return trgtCcy;
    }

    /**
     * ����trgtCcy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrgtCcy(String value) {
        this.trgtCcy = value;
    }

    /**
     * ��ȡunitCcy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitCcy() {
        return unitCcy;
    }

    /**
     * ����unitCcy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitCcy(String value) {
        this.unitCcy = value;
    }

    /**
     * ��ȡxchgRate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXchgRate() {
        return xchgRate;
    }

    /**
     * ����xchgRate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXchgRate(BigDecimal value) {
        this.xchgRate = value;
    }

    /**
     * ��ȡctrctId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtrctId() {
        return ctrctId;
    }

    /**
     * ����ctrctId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtrctId(String value) {
        this.ctrctId = value;
    }

    /**
     * ��ȡqtnDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getQtnDt() {
        return qtnDt;
    }

    /**
     * ����qtnDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setQtnDt(XMLGregorianCalendar value) {
        this.qtnDt = value;
    }

}
