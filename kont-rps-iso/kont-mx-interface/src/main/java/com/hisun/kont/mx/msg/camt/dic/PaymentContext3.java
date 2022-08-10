package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Payment context in which the transaction is performed.
 * 
 * <p>PaymentContext3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentContext3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="CardPres" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="CrdhldrPres" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="OnLineCntxt" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="AttndncCntxt" type="{}AttendanceContext1Code" minOccurs="0"/>
 *         &lt;element name="TxEnvt" type="{}TransactionEnvironment1Code" minOccurs="0"/>
 *         &lt;element name="TxChanl" type="{}TransactionChannel1Code" minOccurs="0"/>
 *         &lt;element name="AttndntMsgCpbl" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="AttndntLang" type="{}ISO2ALanguageCode" minOccurs="0"/>
 *         &lt;element name="CardDataNtryMd" type="{}CardDataReading1Code"/>
 *         &lt;element name="FllbckInd" type="{}TrueFalseIndicator" minOccurs="0"/>
 *         &lt;element name="AuthntcnMtd" type="{}CardholderAuthentication2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentContext3", propOrder = {
    "cardPres",
    "crdhldrPres",
    "onLineCntxt",
    "attndncCntxt",
    "txEnvt",
    "txChanl",
    "attndntMsgCpbl",
    "attndntLang",
    "cardDataNtryMd",
    "fllbckInd",
    "authntcnMtd"
})
public class PaymentContext3 {

    @XmlElement(name = "CardPres")
    protected Boolean cardPres;
    @XmlElement(name = "CrdhldrPres")
    protected Boolean crdhldrPres;
    @XmlElement(name = "OnLineCntxt")
    protected Boolean onLineCntxt;
    @XmlElement(name = "AttndncCntxt")
    @XmlSchemaType(name = "string")
    protected AttendanceContext1Code attndncCntxt;
    @XmlElement(name = "TxEnvt")
    @XmlSchemaType(name = "string")
    protected TransactionEnvironment1Code txEnvt;
    @XmlElement(name = "TxChanl")
    @XmlSchemaType(name = "string")
    protected TransactionChannel1Code txChanl;
    @XmlElement(name = "AttndntMsgCpbl")
    protected Boolean attndntMsgCpbl;
    @XmlElement(name = "AttndntLang")
    protected String attndntLang;
    @XmlElement(name = "CardDataNtryMd", required = true)
    @XmlSchemaType(name = "string")
    protected CardDataReading1Code cardDataNtryMd;
    @XmlElement(name = "FllbckInd")
    protected Boolean fllbckInd;
    @XmlElement(name = "AuthntcnMtd")
    protected CardholderAuthentication2 authntcnMtd;

    /**
     * ��ȡcardPres���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCardPres() {
        return cardPres;
    }

    /**
     * ����cardPres���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCardPres(Boolean value) {
        this.cardPres = value;
    }

    /**
     * ��ȡcrdhldrPres���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrdhldrPres() {
        return crdhldrPres;
    }

    /**
     * ����crdhldrPres���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrdhldrPres(Boolean value) {
        this.crdhldrPres = value;
    }

    /**
     * ��ȡonLineCntxt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOnLineCntxt() {
        return onLineCntxt;
    }

    /**
     * ����onLineCntxt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOnLineCntxt(Boolean value) {
        this.onLineCntxt = value;
    }

    /**
     * ��ȡattndncCntxt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AttendanceContext1Code }
     *     
     */
    public AttendanceContext1Code getAttndncCntxt() {
        return attndncCntxt;
    }

    /**
     * ����attndncCntxt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AttendanceContext1Code }
     *     
     */
    public void setAttndncCntxt(AttendanceContext1Code value) {
        this.attndncCntxt = value;
    }

    /**
     * ��ȡtxEnvt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionEnvironment1Code }
     *     
     */
    public TransactionEnvironment1Code getTxEnvt() {
        return txEnvt;
    }

    /**
     * ����txEnvt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionEnvironment1Code }
     *     
     */
    public void setTxEnvt(TransactionEnvironment1Code value) {
        this.txEnvt = value;
    }

    /**
     * ��ȡtxChanl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link TransactionChannel1Code }
     *     
     */
    public TransactionChannel1Code getTxChanl() {
        return txChanl;
    }

    /**
     * ����txChanl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionChannel1Code }
     *     
     */
    public void setTxChanl(TransactionChannel1Code value) {
        this.txChanl = value;
    }

    /**
     * ��ȡattndntMsgCpbl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAttndntMsgCpbl() {
        return attndntMsgCpbl;
    }

    /**
     * ����attndntMsgCpbl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttndntMsgCpbl(Boolean value) {
        this.attndntMsgCpbl = value;
    }

    /**
     * ��ȡattndntLang���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttndntLang() {
        return attndntLang;
    }

    /**
     * ����attndntLang���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttndntLang(String value) {
        this.attndntLang = value;
    }

    /**
     * ��ȡcardDataNtryMd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardDataReading1Code }
     *     
     */
    public CardDataReading1Code getCardDataNtryMd() {
        return cardDataNtryMd;
    }

    /**
     * ����cardDataNtryMd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardDataReading1Code }
     *     
     */
    public void setCardDataNtryMd(CardDataReading1Code value) {
        this.cardDataNtryMd = value;
    }

    /**
     * ��ȡfllbckInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFllbckInd() {
        return fllbckInd;
    }

    /**
     * ����fllbckInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFllbckInd(Boolean value) {
        this.fllbckInd = value;
    }

    /**
     * ��ȡauthntcnMtd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardholderAuthentication2 }
     *     
     */
    public CardholderAuthentication2 getAuthntcnMtd() {
        return authntcnMtd;
    }

    /**
     * ����authntcnMtd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardholderAuthentication2 }
     *     
     */
    public void setAuthntcnMtd(CardholderAuthentication2 value) {
        this.authntcnMtd = value;
    }

}
