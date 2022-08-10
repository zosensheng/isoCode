package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Sensible data associated with the payment card performing the transaction.
 * 
 * <p>PlainCardData1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PlainCardData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="PAN" type="{}Min8Max28NumericText"/>
 *         &lt;element name="CardSeqNb" type="{}Min2Max3NumericText" minOccurs="0"/>
 *         &lt;element name="FctvDt" type="{}ISOYearMonth" minOccurs="0"/>
 *         &lt;element name="XpryDt" type="{}ISOYearMonth"/>
 *         &lt;element name="SvcCd" type="{}Exact3NumericText" minOccurs="0"/>
 *         &lt;element name="TrckData" type="{}TrackData1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CardSctyCd" type="{}CardSecurityInformation1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlainCardData1", propOrder = {
    "pan",
    "cardSeqNb",
    "fctvDt",
    "xpryDt",
    "svcCd",
    "trckData",
    "cardSctyCd"
})
public class PlainCardData1 {

    @XmlElement(name = "PAN", required = true)
    protected String pan;
    @XmlElement(name = "CardSeqNb")
    protected String cardSeqNb;
    @XmlElement(name = "FctvDt")
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar fctvDt;
    @XmlElement(name = "XpryDt", required = true)
    @XmlSchemaType(name = "gYearMonth")
    protected XMLGregorianCalendar xpryDt;
    @XmlElement(name = "SvcCd")
    protected String svcCd;
    @XmlElement(name = "TrckData")
    protected List<TrackData1> trckData;
    @XmlElement(name = "CardSctyCd")
    protected CardSecurityInformation1 cardSctyCd;

    /**
     * ��ȡpan���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * ����pan���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * ��ȡcardSeqNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSeqNb() {
        return cardSeqNb;
    }

    /**
     * ����cardSeqNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSeqNb(String value) {
        this.cardSeqNb = value;
    }

    /**
     * ��ȡfctvDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFctvDt() {
        return fctvDt;
    }

    /**
     * ����fctvDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFctvDt(XMLGregorianCalendar value) {
        this.fctvDt = value;
    }

    /**
     * ��ȡxpryDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getXpryDt() {
        return xpryDt;
    }

    /**
     * ����xpryDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setXpryDt(XMLGregorianCalendar value) {
        this.xpryDt = value;
    }

    /**
     * ��ȡsvcCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcCd() {
        return svcCd;
    }

    /**
     * ����svcCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcCd(String value) {
        this.svcCd = value;
    }

    /**
     * Gets the value of the trckData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trckData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrckData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackData1 }
     * 
     * 
     */
    public List<TrackData1> getTrckData() {
        if (trckData == null) {
            trckData = new ArrayList<TrackData1>();
        }
        return this.trckData;
    }

    /**
     * ��ȡcardSctyCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardSecurityInformation1 }
     *     
     */
    public CardSecurityInformation1 getCardSctyCd() {
        return cardSctyCd;
    }

    /**
     * ����cardSctyCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardSecurityInformation1 }
     *     
     */
    public void setCardSctyCd(CardSecurityInformation1 value) {
        this.cardSctyCd = value;
    }

}
