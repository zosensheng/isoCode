//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to provide detailed information on the number of transactions that are reported with a specific transaction status.
 * 
 * <p>NumberOfTransactionsPerStatus5 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="NumberOfTransactionsPerStatus5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DtldNbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}Max15NumericText"/>
 *         &lt;element name="DtldSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}ExternalPaymentTransactionStatus1Code"/>
 *         &lt;element name="DtldCtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}DecimalNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberOfTransactionsPerStatus5", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "dtldNbOfTxs",
    "dtldSts",
    "dtldCtrlSum"
})
public class NumberOfTransactionsPerStatus5 {

    @XmlElement(name = "DtldNbOfTxs", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String dtldNbOfTxs;
    @XmlElement(name = "DtldSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected String dtldSts;
    @XmlElement(name = "DtldCtrlSum", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected BigDecimal dtldCtrlSum;

    /**
     * 获取属性 dtldNbOfTxs 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtldNbOfTxs() {
        return dtldNbOfTxs;
    }

    /**
     * 设置属性 dtldNbOfTxs 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtldNbOfTxs(String value) {
        this.dtldNbOfTxs = value;
    }

    /**
     * 获取属性 dtldSts 的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtldSts() {
        return dtldSts;
    }

    /**
     * 设置属性 dtldSts 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtldSts(String value) {
        this.dtldSts = value;
    }

    /**
     * 获取属性 dtldCtrlSum 的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDtldCtrlSum() {
        return dtldCtrlSum;
    }

    /**
     * 设置属性 dtldCtrlSum 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDtldCtrlSum(BigDecimal value) {
        this.dtldCtrlSum = value;
    }

}
