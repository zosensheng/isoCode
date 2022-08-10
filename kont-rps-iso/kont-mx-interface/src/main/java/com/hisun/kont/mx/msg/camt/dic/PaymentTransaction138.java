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
 * <p>PaymentTransaction138 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction138">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="CxlStsId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RslvdCase" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="OrgnlGrpInf" type="{}OriginalGroupInformation29" minOccurs="0"/>
 *         &lt;element name="OrgnlInstrId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlTxId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlClrSysRef" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="TxCxlSts" type="{}CancellationIndividualStatus1Code" minOccurs="0"/>
 *         &lt;element name="CxlStsRsnInf" type="{}CancellationStatusReason4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RsltnRltdInf" type="{}ResolutionData3" minOccurs="0"/>
 *         &lt;element name="OrgnlIntrBkSttlmAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="OrgnlIntrBkSttlmDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="Assgnr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Assgne" type="{}Party40Choice" minOccurs="0"/>
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
@XmlType(name = "PaymentTransaction138", propOrder = {
    "cxlStsId",
    "rslvdCase",
    "orgnlGrpInf",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlClrSysRef",
    "orgnlUETR",
    "txCxlSts",
    "cxlStsRsnInf",
    "rsltnRltdInf",
    "orgnlIntrBkSttlmAmt",
    "orgnlIntrBkSttlmDt",
    "assgnr",
    "assgne",
    "orgnlTxRef"
})
public class PaymentTransaction138 {

    @XmlElement(name = "CxlStsId")
    protected String cxlStsId;
    @XmlElement(name = "RslvdCase")
    protected Case5 rslvdCase;
    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupInformation29 orgnlGrpInf;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId")
    protected String orgnlEndToEndId;
    @XmlElement(name = "OrgnlTxId")
    protected String orgnlTxId;
    @XmlElement(name = "OrgnlClrSysRef")
    protected String orgnlClrSysRef;
    @XmlElement(name = "OrgnlUETR")
    protected String orgnlUETR;
    @XmlElement(name = "TxCxlSts")
    @XmlSchemaType(name = "string")
    protected CancellationIndividualStatus1Code txCxlSts;
    @XmlElement(name = "CxlStsRsnInf")
    protected List<CancellationStatusReason4> cxlStsRsnInf;
    @XmlElement(name = "RsltnRltdInf")
    protected ResolutionData3 rsltnRltdInf;
    @XmlElement(name = "OrgnlIntrBkSttlmAmt")
    protected ActiveOrHistoricCurrencyAndAmount orgnlIntrBkSttlmAmt;
    @XmlElement(name = "OrgnlIntrBkSttlmDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar orgnlIntrBkSttlmDt;
    @XmlElement(name = "Assgnr")
    protected Party40Choice assgnr;
    @XmlElement(name = "Assgne")
    protected Party40Choice assgne;
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
     * ��ȡorgnlGrpInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformation29 }
     *     
     */
    public OriginalGroupInformation29 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * ����orgnlGrpInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformation29 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupInformation29 value) {
        this.orgnlGrpInf = value;
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
     * ��ȡorgnlTxId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlTxId() {
        return orgnlTxId;
    }

    /**
     * ����orgnlTxId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlTxId(String value) {
        this.orgnlTxId = value;
    }

    /**
     * ��ȡorgnlClrSysRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlClrSysRef() {
        return orgnlClrSysRef;
    }

    /**
     * ����orgnlClrSysRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlClrSysRef(String value) {
        this.orgnlClrSysRef = value;
    }

    /**
     * ��ȡorgnlUETR���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlUETR() {
        return orgnlUETR;
    }

    /**
     * ����orgnlUETR���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlUETR(String value) {
        this.orgnlUETR = value;
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
     * ��ȡrsltnRltdInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ResolutionData3 }
     *     
     */
    public ResolutionData3 getRsltnRltdInf() {
        return rsltnRltdInf;
    }

    /**
     * ����rsltnRltdInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionData3 }
     *     
     */
    public void setRsltnRltdInf(ResolutionData3 value) {
        this.rsltnRltdInf = value;
    }

    /**
     * ��ȡorgnlIntrBkSttlmAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getOrgnlIntrBkSttlmAmt() {
        return orgnlIntrBkSttlmAmt;
    }

    /**
     * ����orgnlIntrBkSttlmAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setOrgnlIntrBkSttlmAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.orgnlIntrBkSttlmAmt = value;
    }

    /**
     * ��ȡorgnlIntrBkSttlmDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlIntrBkSttlmDt() {
        return orgnlIntrBkSttlmDt;
    }

    /**
     * ����orgnlIntrBkSttlmDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlIntrBkSttlmDt(XMLGregorianCalendar value) {
        this.orgnlIntrBkSttlmDt = value;
    }

    /**
     * ��ȡassgnr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getAssgnr() {
        return assgnr;
    }

    /**
     * ����assgnr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setAssgnr(Party40Choice value) {
        this.assgnr = value;
    }

    /**
     * ��ȡassgne���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getAssgne() {
        return assgne;
    }

    /**
     * ����assgne���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setAssgne(Party40Choice value) {
        this.assgne = value;
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
