package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Individual card transaction entry details.
 * 
 * <p>CardIndividualTransaction2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CardIndividualTransaction2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="ICCRltdData" type="{}Max1025Text" minOccurs="0"/>
 *         &lt;element name="PmtCntxt" type="{}PaymentContext3" minOccurs="0"/>
 *         &lt;element name="AddtlSvc" type="{}CardPaymentServiceType2Code" minOccurs="0"/>
 *         &lt;element name="TxCtgy" type="{}ExternalCardTransactionCategory1Code" minOccurs="0"/>
 *         &lt;element name="SaleRcncltnId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="SaleRefNb" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RePresntmntRsn" type="{}ExternalRePresentmentReason1Code" minOccurs="0"/>
 *         &lt;element name="SeqNb" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="TxId" type="{}TransactionIdentifier1" minOccurs="0"/>
 *         &lt;element name="Pdct" type="{}Product2" minOccurs="0"/>
 *         &lt;element name="VldtnDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="VldtnSeqNb" type="{}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardIndividualTransaction2", propOrder = {
    "iccRltdData",
    "pmtCntxt",
    "addtlSvc",
    "txCtgy",
    "saleRcncltnId",
    "saleRefNb",
    "rePresntmntRsn",
    "seqNb",
    "txId",
    "pdct",
    "vldtnDt",
    "vldtnSeqNb"
})
public class CardIndividualTransaction2 {

    @XmlElement(name = "ICCRltdData")
    protected String iccRltdData;
    @XmlElement(name = "PmtCntxt")
    protected PaymentContext3 pmtCntxt;
    @XmlElement(name = "AddtlSvc")
    @XmlSchemaType(name = "string")
    protected CardPaymentServiceType2Code addtlSvc;
    @XmlElement(name = "TxCtgy")
    protected String txCtgy;
    @XmlElement(name = "SaleRcncltnId")
    protected String saleRcncltnId;
    @XmlElement(name = "SaleRefNb")
    protected String saleRefNb;
    @XmlElement(name = "RePresntmntRsn")
    protected String rePresntmntRsn;
    @XmlElement(name = "SeqNb")
    protected String seqNb;
    @XmlElement(name = "TxId")
    protected TransactionIdentifier1 txId;
    @XmlElement(name = "Pdct")
    protected Product2 pdct;
    @XmlElement(name = "VldtnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vldtnDt;
    @XmlElement(name = "VldtnSeqNb")
    protected String vldtnSeqNb;

    /**
     * ��ȡiccRltdData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICCRltdData() {
        return iccRltdData;
    }

    /**
     * ����iccRltdData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setICCRltdData(String value) {
        this.iccRltdData = value;
    }

    /**
     * ��ȡpmtCntxt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PaymentContext3 }
     *     
     */
    public PaymentContext3 getPmtCntxt() {
        return pmtCntxt;
    }

    /**
     * ����pmtCntxt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentContext3 }
     *     
     */
    public void setPmtCntxt(PaymentContext3 value) {
        this.pmtCntxt = value;
    }

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
     * ��ȡsaleRefNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaleRefNb() {
        return saleRefNb;
    }

    /**
     * ����saleRefNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaleRefNb(String value) {
        this.saleRefNb = value;
    }

    /**
     * ��ȡrePresntmntRsn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRePresntmntRsn() {
        return rePresntmntRsn;
    }

    /**
     * ����rePresntmntRsn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRePresntmntRsn(String value) {
        this.rePresntmntRsn = value;
    }

    /**
     * ��ȡseqNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqNb() {
        return seqNb;
    }

    /**
     * ����seqNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqNb(String value) {
        this.seqNb = value;
    }

    /**
     * ��ȡtxId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionIdentifier1 }
     *     
     */
    public TransactionIdentifier1 getTxId() {
        return txId;
    }

    /**
     * ����txId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIdentifier1 }
     *     
     */
    public void setTxId(TransactionIdentifier1 value) {
        this.txId = value;
    }

    /**
     * ��ȡpdct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Product2 }
     *     
     */
    public Product2 getPdct() {
        return pdct;
    }

    /**
     * ����pdct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Product2 }
     *     
     */
    public void setPdct(Product2 value) {
        this.pdct = value;
    }

    /**
     * ��ȡvldtnDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVldtnDt() {
        return vldtnDt;
    }

    /**
     * ����vldtnDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVldtnDt(XMLGregorianCalendar value) {
        this.vldtnDt = value;
    }

    /**
     * ��ȡvldtnSeqNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVldtnSeqNb() {
        return vldtnSeqNb;
    }

    /**
     * ����vldtnSeqNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVldtnSeqNb(String value) {
        this.vldtnSeqNb = value;
    }

}
