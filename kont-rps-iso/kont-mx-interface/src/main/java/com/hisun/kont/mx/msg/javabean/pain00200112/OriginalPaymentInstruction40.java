//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides detailed information on the original transaction, to which the status report message refers.
 * 
 * <p>OriginalPaymentInstruction40 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="OriginalPaymentInstruction40">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlPmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max35Text"/>
 *         &lt;element name="OrgnlNbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="OrgnlCtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="PmtInfSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ExternalPaymentGroupStatus1Code" minOccurs="0"/>
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}StatusReasonInformation12" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NbOfTxsPerSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}NumberOfTransactionsPerStatus5" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TxInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}PaymentTransaction129" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPaymentInstruction40", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "orgnlPmtInfId",
    "orgnlNbOfTxs",
    "orgnlCtrlSum",
    "pmtInfSts",
    "stsRsnInf",
    "nbOfTxsPerSts",
    "txInfAndSts"
})
public class OriginalPaymentInstruction40 {

    @XmlElement(name = "OrgnlPmtInfId", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String orgnlPmtInfId;
    @XmlElement(name = "OrgnlNbOfTxs", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String orgnlNbOfTxs;
    @XmlElement(name = "OrgnlCtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BigDecimal orgnlCtrlSum;
    @XmlElement(name = "PmtInfSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected String pmtInfSts;
    @XmlElement(name = "StsRsnInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<StatusReasonInformation12> stsRsnInf;
    @XmlElement(name = "NbOfTxsPerSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<NumberOfTransactionsPerStatus5> nbOfTxsPerSts;
    @XmlElement(name = "TxInfAndSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<PaymentTransaction129> txInfAndSts;

    /**
     * 获取属性 orgnlPmtInfId 的值。
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
     * 设置属性 orgnlPmtInfId 的值。
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
     * 获取属性 orgnlNbOfTxs 的值。
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
     * 设置属性 orgnlNbOfTxs 的值。
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
     * 获取属性 orgnlCtrlSum 的值。
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
     * 设置属性 orgnlCtrlSum 的值。
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
     * 获取属性 pmtInfSts 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtInfSts() {
        return pmtInfSts;
    }

    /**
     * 设置属性 pmtInfSts 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtInfSts(String value) {
        this.pmtInfSts = value;
    }

    /**
     * Gets the value of the stsRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stsRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStsRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusReasonInformation12 }
     * 
     * 
     */
    public List<StatusReasonInformation12> getStsRsnInf() {
        if (stsRsnInf == null) {
            stsRsnInf = new ArrayList<StatusReasonInformation12>();
        }
        return this.stsRsnInf;
    }

    /**
     * Gets the value of the nbOfTxsPerSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nbOfTxsPerSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNbOfTxsPerSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumberOfTransactionsPerStatus5 }
     * 
     * 
     */
    public List<NumberOfTransactionsPerStatus5> getNbOfTxsPerSts() {
        if (nbOfTxsPerSts == null) {
            nbOfTxsPerSts = new ArrayList<NumberOfTransactionsPerStatus5>();
        }
        return this.nbOfTxsPerSts;
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
     * {@link PaymentTransaction129 }
     * 
     * 
     */
    public List<PaymentTransaction129> getTxInfAndSts() {
        if (txInfAndSts == null) {
            txInfAndSts = new ArrayList<PaymentTransaction129>();
        }
        return this.txInfAndSts;
    }

}
