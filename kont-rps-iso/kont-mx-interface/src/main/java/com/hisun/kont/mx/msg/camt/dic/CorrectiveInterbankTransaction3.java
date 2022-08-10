package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>CorrectiveInterbankTransaction3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CorrectiveInterbankTransaction3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{}CorrectiveGroupInformation1" minOccurs="0"/>
 *         &lt;element name="InstrId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="EndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="TxId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="IntrBkSttlmAmt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="IntrBkSttlmDt" type="{}ISODate"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrectiveInterbankTransaction3", propOrder = {
    "grpHdr",
    "instrId",
    "endToEndId",
    "txId",
    "uetr",
    "intrBkSttlmAmt",
    "intrBkSttlmDt"
})
public class CorrectiveInterbankTransaction3 {

    @XmlElement(name = "GrpHdr")
    protected CorrectiveGroupInformation1 grpHdr;
    @XmlElement(name = "InstrId")
    protected String instrId;
    @XmlElement(name = "EndToEndId")
    protected String endToEndId;
    @XmlElement(name = "TxId")
    protected String txId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "IntrBkSttlmAmt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt;
    @XmlElement(name = "IntrBkSttlmDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar intrBkSttlmDt;

    /**
     * ��ȡgrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CorrectiveGroupInformation1 }
     *     
     */
    public CorrectiveGroupInformation1 getGrpHdr() {
        return grpHdr;
    }

    /**
     * ����grpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectiveGroupInformation1 }
     *     
     */
    public void setGrpHdr(CorrectiveGroupInformation1 value) {
        this.grpHdr = value;
    }

    /**
     * ��ȡinstrId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrId() {
        return instrId;
    }

    /**
     * ����instrId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrId(String value) {
        this.instrId = value;
    }

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

}
