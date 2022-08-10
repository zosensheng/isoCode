package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>NotificationItem8 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NotificationItem8">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="EndToEndId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="AcctOwnr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="AcctSvcr" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="RltdAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="XpctdValDt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="Purp" type="{}Purpose2Choice" minOccurs="0"/>
 *         &lt;element name="RltdRmtInf" type="{}RemittanceLocation7" minOccurs="0"/>
 *         &lt;element name="RmtInf" type="{}RemittanceInformation21" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationItem8", propOrder = {
    "id",
    "endToEndId",
    "uetr",
    "acct",
    "acctOwnr",
    "acctSvcr",
    "rltdAcct",
    "amt",
    "xpctdValDt",
    "dbtr",
    "dbtrAgt",
    "intrmyAgt",
    "purp",
    "rltdRmtInf",
    "rmtInf"
})
public class NotificationItem8 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "EndToEndId")
    protected String endToEndId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "Acct")
    protected CashAccount40 acct;
    @XmlElement(name = "AcctOwnr")
    protected Party40Choice acctOwnr;
    @XmlElement(name = "AcctSvcr")
    protected BranchAndFinancialInstitutionIdentification6 acctSvcr;
    @XmlElement(name = "RltdAcct")
    protected CashAccount40 rltdAcct;
    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "XpctdValDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar xpctdValDt;
    @XmlElement(name = "Dbtr")
    protected Party40Choice dbtr;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "IntrmyAgt")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt;
    @XmlElement(name = "Purp")
    protected Purpose2Choice purp;
    @XmlElement(name = "RltdRmtInf")
    protected RemittanceLocation7 rltdRmtInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformation21 rmtInf;

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * ��ȡacct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getAcct() {
        return acct;
    }

    /**
     * ����acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setAcct(CashAccount40 value) {
        this.acct = value;
    }

    /**
     * ��ȡacctOwnr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getAcctOwnr() {
        return acctOwnr;
    }

    /**
     * ����acctOwnr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setAcctOwnr(Party40Choice value) {
        this.acctOwnr = value;
    }

    /**
     * ��ȡacctSvcr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getAcctSvcr() {
        return acctSvcr;
    }

    /**
     * ����acctSvcr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setAcctSvcr(BranchAndFinancialInstitutionIdentification6 value) {
        this.acctSvcr = value;
    }

    /**
     * ��ȡrltdAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getRltdAcct() {
        return rltdAcct;
    }

    /**
     * ����rltdAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setRltdAcct(CashAccount40 value) {
        this.rltdAcct = value;
    }

    /**
     * ��ȡamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * ��ȡxpctdValDt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getXpctdValDt() {
        return xpctdValDt;
    }

    /**
     * ����xpctdValDt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setXpctdValDt(XMLGregorianCalendar value) {
        this.xpctdValDt = value;
    }

    /**
     * ��ȡdbtr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getDbtr() {
        return dbtr;
    }

    /**
     * ����dbtr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setDbtr(Party40Choice value) {
        this.dbtr = value;
    }

    /**
     * ��ȡdbtrAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * ����dbtrAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.dbtrAgt = value;
    }

    /**
     * ��ȡintrmyAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt() {
        return intrmyAgt;
    }

    /**
     * ����intrmyAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt = value;
    }

    /**
     * ��ȡpurp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Purpose2Choice }
     *     
     */
    public Purpose2Choice getPurp() {
        return purp;
    }

    /**
     * ����purp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Purpose2Choice }
     *     
     */
    public void setPurp(Purpose2Choice value) {
        this.purp = value;
    }

    /**
     * ��ȡrltdRmtInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RemittanceLocation7 }
     *     
     */
    public RemittanceLocation7 getRltdRmtInf() {
        return rltdRmtInf;
    }

    /**
     * ����rltdRmtInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceLocation7 }
     *     
     */
    public void setRltdRmtInf(RemittanceLocation7 value) {
        this.rltdRmtInf = value;
    }

    /**
     * ��ȡrmtInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public RemittanceInformation21 getRmtInf() {
        return rmtInf;
    }

    /**
     * ����rmtInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformation21 }
     *     
     */
    public void setRmtInf(RemittanceInformation21 value) {
        this.rmtInf = value;
    }

}
