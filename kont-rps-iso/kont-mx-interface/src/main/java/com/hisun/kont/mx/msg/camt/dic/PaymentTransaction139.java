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
 * <p>PaymentTransaction139 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction139">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="CxlStsId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RslvdCase" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="OrgnlInstrId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="TxCxlSts" type="{}CancellationIndividualStatus1Code" minOccurs="0"/>
 *         &lt;element name="CxlStsRsnInf" type="{}CancellationStatusReason4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OrgnlInstdAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="OrgnlReqdExctnDt" type="{}DateAndDateTime2Choice" minOccurs="0"/>
 *         &lt;element name="OrgnlReqdColltnDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="OrgnlTxRef" type="{}OriginalTransactionReference35" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransaction139", propOrder = {
    "cxlStsId",
    "rslvdCase",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "uetr",
    "txCxlSts",
    "cxlStsRsnInf",
    "orgnlInstdAmt",
    "orgnlReqdExctnDt",
    "orgnlReqdColltnDt",
    "orgnlTxRef"
})
public class PaymentTransaction139 {

    @XmlElement(name = "CxlStsId")
    protected String cxlStsId;
    @XmlElement(name = "RslvdCase")
    protected Case5 rslvdCase;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId")
    protected String orgnlEndToEndId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "TxCxlSts")
    @XmlSchemaType(name = "string")
    protected CancellationIndividualStatus1Code txCxlSts;
    @XmlElement(name = "CxlStsRsnInf")
    protected List<CancellationStatusReason4> cxlStsRsnInf;
    @XmlElement(name = "OrgnlInstdAmt")
    protected ActiveOrHistoricCurrencyAndAmount orgnlInstdAmt;
    @XmlElement(name = "OrgnlReqdExctnDt")
    protected DateAndDateTime2Choice orgnlReqdExctnDt;
    @XmlElement(name = "OrgnlReqdColltnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlReqdColltnDt;
    @XmlElement(name = "OrgnlTxRef")
    protected OriginalTransactionReference35 orgnlTxRef;

    /**
     * ��ȡcxlStsId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCxlStsId() {
        return cxlStsId;
    }

    /**
     * ����cxlStsId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCxlStsId(String value) {
        this.cxlStsId = value;
    }

    /**
     * ��ȡrslvdCase���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Case5 }
     *     
     */
    public Case5 getRslvdCase() {
        return rslvdCase;
    }

    /**
     * ����rslvdCase���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Case5 }
     *     
     */
    public void setRslvdCase(Case5 value) {
        this.rslvdCase = value;
    }

    /**
     * ��ȡorgnlInstrId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * ����orgnlInstrId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * ��ȡorgnlEndToEndId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * ����orgnlEndToEndId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * ��ȡuetr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUETR() {
        return uetr;
    }

    /**
     * ����uetr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUETR(String value) {
        this.uetr = value;
    }

    /**
     * ��ȡtxCxlSts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CancellationIndividualStatus1Code }
     *     
     */
    public CancellationIndividualStatus1Code getTxCxlSts() {
        return txCxlSts;
    }

    /**
     * ����txCxlSts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationIndividualStatus1Code }
     *     
     */
    public void setTxCxlSts(CancellationIndividualStatus1Code value) {
        this.txCxlSts = value;
    }

    /**
     * Gets the value of the cxlStsRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cxlStsRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCxlStsRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancellationStatusReason4 }
     * 
     * 
     */
    public List<CancellationStatusReason4> getCxlStsRsnInf() {
        if (cxlStsRsnInf == null) {
            cxlStsRsnInf = new ArrayList<CancellationStatusReason4>();
        }
        return this.cxlStsRsnInf;
    }

    /**
     * ��ȡorgnlInstdAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getOrgnlInstdAmt() {
        return orgnlInstdAmt;
    }

    /**
     * ����orgnlInstdAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setOrgnlInstdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.orgnlInstdAmt = value;
    }

    /**
     * ��ȡorgnlReqdExctnDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getOrgnlReqdExctnDt() {
        return orgnlReqdExctnDt;
    }

    /**
     * ����orgnlReqdExctnDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setOrgnlReqdExctnDt(DateAndDateTime2Choice value) {
        this.orgnlReqdExctnDt = value;
    }

    /**
     * ��ȡorgnlReqdColltnDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlReqdColltnDt() {
        return orgnlReqdColltnDt;
    }

    /**
     * ����orgnlReqdColltnDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlReqdColltnDt(XMLGregorianCalendar value) {
        this.orgnlReqdColltnDt = value;
    }

    /**
     * ��ȡorgnlTxRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransactionReference35 }
     *     
     */
    public OriginalTransactionReference35 getOrgnlTxRef() {
        return orgnlTxRef;
    }

    /**
     * ����orgnlTxRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransactionReference35 }
     *     
     */
    public void setOrgnlTxRef(OriginalTransactionReference35 value) {
        this.orgnlTxRef = value;
    }

}
