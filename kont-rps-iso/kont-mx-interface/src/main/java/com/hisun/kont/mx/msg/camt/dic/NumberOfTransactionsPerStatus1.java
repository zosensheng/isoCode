package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NumberOfTransactionsPerStatus1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NumberOfTransactionsPerStatus1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="DtldNbOfTxs" type="{}Max15NumericText"/>
 *         &lt;element name="DtldSts" type="{}TransactionIndividualStatus1Code"/>
 *         &lt;element name="DtldCtrlSum" type="{}DecimalNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberOfTransactionsPerStatus1", propOrder = {
    "dtldNbOfTxs",
    "dtldSts",
    "dtldCtrlSum"
})
public class NumberOfTransactionsPerStatus1 {

    @XmlElement(name = "DtldNbOfTxs", required = true)
    protected String dtldNbOfTxs;
    @XmlElement(name = "DtldSts", required = true)
    @XmlSchemaType(name = "string")
    protected TransactionIndividualStatus1Code dtldSts;
    @XmlElement(name = "DtldCtrlSum")
    protected BigDecimal dtldCtrlSum;

    /**
     * ��ȡdtldNbOfTxs���Ե�ֵ��
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
     * ����dtldNbOfTxs���Ե�ֵ��
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
     * ��ȡdtldSts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionIndividualStatus1Code }
     *     
     */
    public TransactionIndividualStatus1Code getDtldSts() {
        return dtldSts;
    }

    /**
     * ����dtldSts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIndividualStatus1Code }
     *     
     */
    public void setDtldSts(TransactionIndividualStatus1Code value) {
        this.dtldSts = value;
    }

    /**
     * ��ȡdtldCtrlSum���Ե�ֵ��
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
     * ����dtldCtrlSum���Ե�ֵ��
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
