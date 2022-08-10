package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OriginalPaymentInstruction43 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OriginalPaymentInstruction43">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="OrgnlPmtInfCxlId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RslvdCase" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="OrgnlPmtInfId" type="{}Max35Text"/>
 *         &lt;element name="OrgnlGrpInf" type="{}OriginalGroupInformation29" minOccurs="0"/>
 *         &lt;element name="OrgnlNbOfTxs" type="{}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="OrgnlCtrlSum" type="{}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="PmtInfCxlSts" type="{}GroupCancellationStatus1Code" minOccurs="0"/>
 *         &lt;element name="CxlStsRsnInf" type="{}CancellationStatusReason4" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NbOfTxsPerCxlSts" type="{}NumberOfCancellationsPerStatus1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TxInfAndSts" type="{}PaymentTransaction139" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPaymentInstruction43", propOrder = {
    "orgnlPmtInfCxlId",
    "rslvdCase",
    "orgnlPmtInfId",
    "orgnlGrpInf",
    "orgnlNbOfTxs",
    "orgnlCtrlSum",
    "pmtInfCxlSts",
    "cxlStsRsnInf",
    "nbOfTxsPerCxlSts",
    "txInfAndSts"
})
public class OriginalPaymentInstruction43 {

    @XmlElement(name = "OrgnlPmtInfCxlId")
    protected String orgnlPmtInfCxlId;
    @XmlElement(name = "RslvdCase")
    protected Case5 rslvdCase;
    @XmlElement(name = "OrgnlPmtInfId", required = true)
    protected String orgnlPmtInfId;
    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupInformation29 orgnlGrpInf;
    @XmlElement(name = "OrgnlNbOfTxs")
    protected String orgnlNbOfTxs;
    @XmlElement(name = "OrgnlCtrlSum")
    protected BigDecimal orgnlCtrlSum;
    @XmlElement(name = "PmtInfCxlSts")
    @XmlSchemaType(name = "string")
    protected GroupCancellationStatus1Code pmtInfCxlSts;
    @XmlElement(name = "CxlStsRsnInf")
    protected List<CancellationStatusReason4> cxlStsRsnInf;
    @XmlElement(name = "NbOfTxsPerCxlSts")
    protected List<NumberOfCancellationsPerStatus1> nbOfTxsPerCxlSts;
    @XmlElement(name = "TxInfAndSts")
    protected List<PaymentTransaction139> txInfAndSts;

    /**
     * ��ȡorgnlPmtInfCxlId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlPmtInfCxlId() {
        return orgnlPmtInfCxlId;
    }

    /**
     * ����orgnlPmtInfCxlId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlPmtInfCxlId(String value) {
        this.orgnlPmtInfCxlId = value;
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
     * ��ȡorgnlNbOfTxs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlNbOfTxs() {
        return orgnlNbOfTxs;
    }

    /**
     * ����orgnlNbOfTxs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlNbOfTxs(String value) {
        this.orgnlNbOfTxs = value;
    }

    /**
     * ��ȡorgnlCtrlSum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrgnlCtrlSum() {
        return orgnlCtrlSum;
    }

    /**
     * ����orgnlCtrlSum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrgnlCtrlSum(BigDecimal value) {
        this.orgnlCtrlSum = value;
    }

    /**
     * ��ȡpmtInfCxlSts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GroupCancellationStatus1Code }
     *     
     */
    public GroupCancellationStatus1Code getPmtInfCxlSts() {
        return pmtInfCxlSts;
    }

    /**
     * ����pmtInfCxlSts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GroupCancellationStatus1Code }
     *     
     */
    public void setPmtInfCxlSts(GroupCancellationStatus1Code value) {
        this.pmtInfCxlSts = value;
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
     * Gets the value of the nbOfTxsPerCxlSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbOfTxsPerCxlSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNbOfTxsPerCxlSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumberOfCancellationsPerStatus1 }
     * 
     * 
     */
    public List<NumberOfCancellationsPerStatus1> getNbOfTxsPerCxlSts() {
        if (nbOfTxsPerCxlSts == null) {
            nbOfTxsPerCxlSts = new ArrayList<NumberOfCancellationsPerStatus1>();
        }
        return this.nbOfTxsPerCxlSts;
    }

    /**
     * Gets the value of the txInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction139 }
     * 
     * 
     */
    public List<PaymentTransaction139> getTxInfAndSts() {
        if (txInfAndSts == null) {
            txInfAndSts = new ArrayList<PaymentTransaction139>();
        }
        return this.txInfAndSts;
    }

}
