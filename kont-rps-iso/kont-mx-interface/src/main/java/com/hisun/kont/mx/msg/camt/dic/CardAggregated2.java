package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Globalised card transaction entry details.
 * 
 * <p>CardAggregated2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CardAggregated2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="AddtlSvc" type="{}CardPaymentServiceType2Code" minOccurs="0"/>
 *         &lt;element name="TxCtgy" type="{}ExternalCardTransactionCategory1Code" minOccurs="0"/>
 *         &lt;element name="SaleRcncltnId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="SeqNbRg" type="{}CardSequenceNumberRange1" minOccurs="0"/>
 *         &lt;element name="TxDtRg" type="{}DateOrDateTimePeriod1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAggregated2", propOrder = {
    "addtlSvc",
    "txCtgy",
    "saleRcncltnId",
    "seqNbRg",
    "txDtRg"
})
public class CardAggregated2 {

    @XmlElement(name = "AddtlSvc")
    @XmlSchemaType(name = "string")
    protected CardPaymentServiceType2Code addtlSvc;
    @XmlElement(name = "TxCtgy")
    protected String txCtgy;
    @XmlElement(name = "SaleRcncltnId")
    protected String saleRcncltnId;
    @XmlElement(name = "SeqNbRg")
    protected CardSequenceNumberRange1 seqNbRg;
    @XmlElement(name = "TxDtRg")
    protected DateOrDateTimePeriod1Choice txDtRg;

    /**
     * ��ȡaddtlSvc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardPaymentServiceType2Code }
     *     
     */
    public CardPaymentServiceType2Code getAddtlSvc() {
        return addtlSvc;
    }

    /**
     * ����addtlSvc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardPaymentServiceType2Code }
     *     
     */
    public void setAddtlSvc(CardPaymentServiceType2Code value) {
        this.addtlSvc = value;
    }

    /**
     * ��ȡtxCtgy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxCtgy() {
        return txCtgy;
    }

    /**
     * ����txCtgy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxCtgy(String value) {
        this.txCtgy = value;
    }

    /**
     * ��ȡsaleRcncltnId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleRcncltnId() {
        return saleRcncltnId;
    }

    /**
     * ����saleRcncltnId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleRcncltnId(String value) {
        this.saleRcncltnId = value;
    }

    /**
     * ��ȡseqNbRg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardSequenceNumberRange1 }
     *     
     */
    public CardSequenceNumberRange1 getSeqNbRg() {
        return seqNbRg;
    }

    /**
     * ����seqNbRg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardSequenceNumberRange1 }
     *     
     */
    public void setSeqNbRg(CardSequenceNumberRange1 value) {
        this.seqNbRg = value;
    }

    /**
     * ��ȡtxDtRg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateOrDateTimePeriod1Choice }
     *     
     */
    public DateOrDateTimePeriod1Choice getTxDtRg() {
        return txDtRg;
    }

    /**
     * ����txDtRg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateOrDateTimePeriod1Choice }
     *     
     */
    public void setTxDtRg(DateOrDateTimePeriod1Choice value) {
        this.txDtRg = value;
    }

}
