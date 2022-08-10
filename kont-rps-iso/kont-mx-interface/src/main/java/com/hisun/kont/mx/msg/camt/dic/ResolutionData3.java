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
 * <p>ResolutionData3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ResolutionData3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="EndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="TxId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="ClrChanl" type="{}ClearingChannel2Code" minOccurs="0"/>
 *         &lt;element name="Compstn" type="{}Compensation4" minOccurs="0"/>
 *         &lt;element name="Chrgs" type="{}Charges9" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolutionData3", propOrder = {
    "endToEndId",
    "txId",
    "uetr",
    "intrBkSttlmAmt",
    "intrBkSttlmDt",
    "clrChanl",
    "compstn",
    "chrgs"
})
public class ResolutionData3 {

    @XmlElement(name = "EndToEndId")
    protected String endToEndId;
    @XmlElement(name = "TxId")
    protected String txId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "IntrBkSttlmAmt")
    protected ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;
    @XmlElement(name = "ClrChanl")
    @XmlSchemaType(name = "string")
    protected ClearingChannel2Code clrChanl;
    @XmlElement(name = "Compstn")
    protected Compensation4 compstn;
    @XmlElement(name = "Chrgs")
    protected List<Charges9> chrgs;

    /**
     * ��ȡendToEndId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndToEndId() {
        return endToEndId;
    }

    /**
     * ����endToEndId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndToEndId(String value) {
        this.endToEndId = value;
    }

    /**
     * ��ȡtxId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxId() {
        return txId;
    }

    /**
     * ����txId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxId(String value) {
        this.txId = value;
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
     * ��ȡintrBkSttlmAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getIntrBkSttlmAmt() {
        return intrBkSttlmAmt;
    }

    /**
     * ����intrBkSttlmAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setIntrBkSttlmAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.intrBkSttlmAmt = value;
    }

    /**
     * ��ȡintrBkSttlmDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIntrBkSttlmDt() {
        return intrBkSttlmDt;
    }

    /**
     * ����intrBkSttlmDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.intrBkSttlmDt = value;
    }

    /**
     * ��ȡclrChanl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public ClearingChannel2Code getClrChanl() {
        return clrChanl;
    }

    /**
     * ����clrChanl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public void setClrChanl(ClearingChannel2Code value) {
        this.clrChanl = value;
    }

    /**
     * ��ȡcompstn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Compensation4 }
     *     
     */
    public Compensation4 getCompstn() {
        return compstn;
    }

    /**
     * ����compstn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Compensation4 }
     *     
     */
    public void setCompstn(Compensation4 value) {
        this.compstn = value;
    }

    /**
     * Gets the value of the chrgs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chrgs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChrgs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Charges9 }
     * 
     * 
     */
    public List<Charges9> getChrgs() {
        if (chrgs == null) {
            chrgs = new ArrayList<Charges9>();
        }
        return this.chrgs;
    }

}
