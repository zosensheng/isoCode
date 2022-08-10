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
 * <p>PaymentTransaction132 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentTransaction132">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="ModStsId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RslvdCase" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="OrgnlGrpInf" type="{}OriginalGroupInformation29"/>
 *         &lt;element name="OrgnlPmtInfId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlInstrId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlEndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlTxId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlClrSysRef" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="OrgnlUETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="ModStsRsnInf" type="{}ModificationStatusReason2" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "PaymentTransaction132", propOrder = {
    "modStsId",
    "rslvdCase",
    "orgnlGrpInf",
    "orgnlPmtInfId",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "orgnlTxId",
    "orgnlClrSysRef",
    "orgnlUETR",
    "modStsRsnInf",
    "rsltnRltdInf",
    "orgnlIntrBkSttlmAmt",
    "orgnlIntrBkSttlmDt",
    "assgnr",
    "assgne",
    "orgnlTxRef"
})
public class PaymentTransaction132 {

    @XmlElement(name = "ModStsId")
    protected String modStsId;
    @XmlElement(name = "RslvdCase")
    protected Case5 rslvdCase;
    @XmlElement(name = "OrgnlGrpInf", required = true)
    protected OriginalGroupInformation29 orgnlGrpInf;
    @XmlElement(name = "OrgnlPmtInfId")
    protected String orgnlPmtInfId;
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
    @XmlElement(name = "ModStsRsnInf")
    protected List<ModificationStatusReason2> modStsRsnInf;
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
     * ��ȡmodStsId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModStsId() {
        return modStsId;
    }

    /**
     * ����modStsId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModStsId(String value) {
        this.modStsId = value;
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
     * ��ȡorgnlPmtInfId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlPmtInfId() {
        return orgnlPmtInfId;
    }

    /**
     * ����orgnlPmtInfId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlPmtInfId(String value) {
        this.orgnlPmtInfId = value;
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
     * Gets the value of the modStsRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modStsRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModStsRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModificationStatusReason2 }
     * 
     * 
     */
    public List<ModificationStatusReason2> getModStsRsnInf() {
        if (modStsRsnInf == null) {
            modStsRsnInf = new ArrayList<ModificationStatusReason2>();
        }
        return this.modStsRsnInf;
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
