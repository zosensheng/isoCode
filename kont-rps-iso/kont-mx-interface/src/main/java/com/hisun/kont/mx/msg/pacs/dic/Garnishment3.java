package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Provides remittance information about a payment for garnishment-related purposes.
 * 
 * <p>Garnishment3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Garnishment3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}GarnishmentType1"/>
 *         &lt;element name="Grnshee" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="GrnshmtAdmstr" type="{}PartyIdentification135" minOccurs="0"/>
 *         &lt;element name="RefNb" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="Dt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="RmtdAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="FmlyMdclInsrncInd" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="MplyeeTermntnInd" type="{}TrueFalseIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Garnishment3", propOrder = {
    "tp",
    "grnshee",
    "grnshmtAdmstr",
    "refNb",
    "dt",
    "rmtdAmt",
    "fmlyMdclInsrncInd",
    "mplyeeTermntnInd"
})
public class Garnishment3 {

    @XmlElement(name = "Tp", required = true)
    protected GarnishmentType1 tp;
    @XmlElement(name = "Grnshee")
    protected PartyIdentification135 grnshee;
    @XmlElement(name = "GrnshmtAdmstr")
    protected PartyIdentification135 grnshmtAdmstr;
    @XmlElement(name = "RefNb")
    protected String refNb;
    @XmlElement(name = "Dt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "RmtdAmt")
    protected ActiveOrHistoricCurrencyAndAmount rmtdAmt;
    @XmlElement(name = "FmlyMdclInsrncInd")
    protected Boolean fmlyMdclInsrncInd;
    @XmlElement(name = "MplyeeTermntnInd")
    protected Boolean mplyeeTermntnInd;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GarnishmentType1 }
     *     
     */
    public GarnishmentType1 getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GarnishmentType1 }
     *     
     */
    public void setTp(GarnishmentType1 value) {
        this.tp = value;
    }

    /**
     * ��ȡgrnshee���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getGrnshee() {
        return grnshee;
    }

    /**
     * ����grnshee���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setGrnshee(PartyIdentification135 value) {
        this.grnshee = value;
    }

    /**
     * ��ȡgrnshmtAdmstr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getGrnshmtAdmstr() {
        return grnshmtAdmstr;
    }

    /**
     * ����grnshmtAdmstr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setGrnshmtAdmstr(PartyIdentification135 value) {
        this.grnshmtAdmstr = value;
    }

    /**
     * ��ȡrefNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefNb() {
        return refNb;
    }

    /**
     * ����refNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefNb(String value) {
        this.refNb = value;
    }

    /**
     * ��ȡdt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * ����dt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
    }

    /**
     * ��ȡrmtdAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getRmtdAmt() {
        return rmtdAmt;
    }

    /**
     * ����rmtdAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setRmtdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.rmtdAmt = value;
    }

    /**
     * ��ȡfmlyMdclInsrncInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFmlyMdclInsrncInd() {
        return fmlyMdclInsrncInd;
    }

    /**
     * ����fmlyMdclInsrncInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFmlyMdclInsrncInd(Boolean value) {
        this.fmlyMdclInsrncInd = value;
    }

    /**
     * ��ȡmplyeeTermntnInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMplyeeTermntnInd() {
        return mplyeeTermntnInd;
    }

    /**
     * ����mplyeeTermntnInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMplyeeTermntnInd(Boolean value) {
        this.mplyeeTermntnInd = value;
    }

}
