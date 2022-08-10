package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>CreditTransferMandateData1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CreditTransferMandateData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="MndtId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Tp" type="{}MandateTypeInformation2" minOccurs="0"/>
 *         &lt;element name="DtOfSgntr" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="DtOfVrfctn" type="{}ISODateTime" minOccurs="0"/>
 *         &lt;element name="ElctrncSgntr" type="{}Max10KBinary" minOccurs="0"/>
 *         &lt;element name="FrstPmtDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="FnlPmtDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="Frqcy" type="{}Frequency36Choice" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{}MandateSetupReason1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditTransferMandateData1", propOrder = {
    "mndtId",
    "tp",
    "dtOfSgntr",
    "dtOfVrfctn",
    "elctrncSgntr",
    "frstPmtDt",
    "fnlPmtDt",
    "frqcy",
    "rsn"
})
public class CreditTransferMandateData1 {

    @XmlElement(name = "MndtId")
    protected String mndtId;
    @XmlElement(name = "Tp")
    protected MandateTypeInformation2 tp;
    @XmlElement(name = "DtOfSgntr")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtOfSgntr;
    @XmlElement(name = "DtOfVrfctn")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtOfVrfctn;
    @XmlElement(name = "ElctrncSgntr")
    protected byte[] elctrncSgntr;
    @XmlElement(name = "FrstPmtDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frstPmtDt;
    @XmlElement(name = "FnlPmtDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fnlPmtDt;
    @XmlElement(name = "Frqcy")
    protected Frequency36Choice frqcy;
    @XmlElement(name = "Rsn")
    protected MandateSetupReason1Choice rsn;

    /**
     * ��ȡmndtId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMndtId() {
        return mndtId;
    }

    /**
     * ����mndtId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMndtId(String value) {
        this.mndtId = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public MandateTypeInformation2 getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MandateTypeInformation2 }
     *     
     */
    public void setTp(MandateTypeInformation2 value) {
        this.tp = value;
    }

    /**
     * ��ȡdtOfSgntr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtOfSgntr() {
        return dtOfSgntr;
    }

    /**
     * ����dtOfSgntr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtOfSgntr(XMLGregorianCalendar value) {
        this.dtOfSgntr = value;
    }

    /**
     * ��ȡdtOfVrfctn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtOfVrfctn() {
        return dtOfVrfctn;
    }

    /**
     * ����dtOfVrfctn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtOfVrfctn(XMLGregorianCalendar value) {
        this.dtOfVrfctn = value;
    }

    /**
     * ��ȡelctrncSgntr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getElctrncSgntr() {
        return elctrncSgntr;
    }

    /**
     * ����elctrncSgntr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setElctrncSgntr(byte[] value) {
        this.elctrncSgntr = value;
    }

    /**
     * ��ȡfrstPmtDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrstPmtDt() {
        return frstPmtDt;
    }

    /**
     * ����frstPmtDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrstPmtDt(XMLGregorianCalendar value) {
        this.frstPmtDt = value;
    }

    /**
     * ��ȡfnlPmtDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFnlPmtDt() {
        return fnlPmtDt;
    }

    /**
     * ����fnlPmtDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFnlPmtDt(XMLGregorianCalendar value) {
        this.fnlPmtDt = value;
    }

    /**
     * ��ȡfrqcy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Frequency36Choice }
     *     
     */
    public Frequency36Choice getFrqcy() {
        return frqcy;
    }

    /**
     * ����frqcy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Frequency36Choice }
     *     
     */
    public void setFrqcy(Frequency36Choice value) {
        this.frqcy = value;
    }

    /**
     * ��ȡrsn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public MandateSetupReason1Choice getRsn() {
        return rsn;
    }

    /**
     * ����rsn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MandateSetupReason1Choice }
     *     
     */
    public void setRsn(MandateSetupReason1Choice value) {
        this.rsn = value;
    }

}
