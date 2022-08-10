package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details on the parties specific to the individual transaction.
 * 
 * <p>TransactionParties10 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TransactionParties10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="UltmtDbtr" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="Dbtr" type="{}Party40Choice"/>
 *         &lt;element name="DbtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="InitgPty" type="{}Party40Choice" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DbtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt1Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt2Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="PrvsInstgAgt3Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3Acct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Cdtr" type="{}Party40Choice"/>
 *         &lt;element name="CdtrAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="UltmtCdtr" type="{}Party40Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionParties10", propOrder = {
    "ultmtDbtr",
    "dbtr",
    "dbtrAcct",
    "initgPty",
    "dbtrAgt",
    "dbtrAgtAcct",
    "prvsInstgAgt1",
    "prvsInstgAgt1Acct",
    "prvsInstgAgt2",
    "prvsInstgAgt2Acct",
    "prvsInstgAgt3",
    "prvsInstgAgt3Acct",
    "intrmyAgt1",
    "intrmyAgt1Acct",
    "intrmyAgt2",
    "intrmyAgt2Acct",
    "intrmyAgt3",
    "intrmyAgt3Acct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr"
})
public class TransactionParties10 {

    @XmlElement(name = "UltmtDbtr")
    protected Party40Choice ultmtDbtr;
    @XmlElement(name = "Dbtr", required = true)
    protected Party40Choice dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccount40 dbtrAcct;
    @XmlElement(name = "InitgPty")
    protected Party40Choice initgPty;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "PrvsInstgAgt1")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1;
    @XmlElement(name = "PrvsInstgAgt1Acct")
    protected CashAccount40 prvsInstgAgt1Acct;
    @XmlElement(name = "PrvsInstgAgt2")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2;
    @XmlElement(name = "PrvsInstgAgt2Acct")
    protected CashAccount40 prvsInstgAgt2Acct;
    @XmlElement(name = "PrvsInstgAgt3")
    protected BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3;
    @XmlElement(name = "PrvsInstgAgt3Acct")
    protected CashAccount40 prvsInstgAgt3Acct;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt1Acct")
    protected CashAccount40 intrmyAgt1Acct;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt2Acct")
    protected CashAccount40 intrmyAgt2Acct;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt3;
    @XmlElement(name = "IntrmyAgt3Acct")
    protected CashAccount40 intrmyAgt3Acct;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Cdtr", required = true)
    protected Party40Choice cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccount40 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected Party40Choice ultmtCdtr;

    /**
     * ��ȡultmtDbtr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * ����ultmtDbtr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setUltmtDbtr(Party40Choice value) {
        this.ultmtDbtr = value;
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
     * ��ȡdbtrAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * ����dbtrAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAcct(CashAccount40 value) {
        this.dbtrAcct = value;
    }

    /**
     * ��ȡinitgPty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getInitgPty() {
        return initgPty;
    }

    /**
     * ����initgPty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setInitgPty(Party40Choice value) {
        this.initgPty = value;
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
     * ��ȡdbtrAgtAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getDbtrAgtAcct() {
        return dbtrAgtAcct;
    }

    /**
     * ����dbtrAgtAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setDbtrAgtAcct(CashAccount40 value) {
        this.dbtrAgtAcct = value;
    }

    /**
     * ��ȡprvsInstgAgt1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt1() {
        return prvsInstgAgt1;
    }

    /**
     * ����prvsInstgAgt1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt1(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt1 = value;
    }

    /**
     * ��ȡprvsInstgAgt1Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt1Acct() {
        return prvsInstgAgt1Acct;
    }

    /**
     * ����prvsInstgAgt1Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt1Acct(CashAccount40 value) {
        this.prvsInstgAgt1Acct = value;
    }

    /**
     * ��ȡprvsInstgAgt2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt2() {
        return prvsInstgAgt2;
    }

    /**
     * ����prvsInstgAgt2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt2(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt2 = value;
    }

    /**
     * ��ȡprvsInstgAgt2Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt2Acct() {
        return prvsInstgAgt2Acct;
    }

    /**
     * ����prvsInstgAgt2Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt2Acct(CashAccount40 value) {
        this.prvsInstgAgt2Acct = value;
    }

    /**
     * ��ȡprvsInstgAgt3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getPrvsInstgAgt3() {
        return prvsInstgAgt3;
    }

    /**
     * ����prvsInstgAgt3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setPrvsInstgAgt3(BranchAndFinancialInstitutionIdentification6 value) {
        this.prvsInstgAgt3 = value;
    }

    /**
     * ��ȡprvsInstgAgt3Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrvsInstgAgt3Acct() {
        return prvsInstgAgt3Acct;
    }

    /**
     * ����prvsInstgAgt3Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrvsInstgAgt3Acct(CashAccount40 value) {
        this.prvsInstgAgt3Acct = value;
    }

    /**
     * ��ȡintrmyAgt1���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * ����intrmyAgt1���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt1 = value;
    }

    /**
     * ��ȡintrmyAgt1Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt1Acct() {
        return intrmyAgt1Acct;
    }

    /**
     * ����intrmyAgt1Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt1Acct(CashAccount40 value) {
        this.intrmyAgt1Acct = value;
    }

    /**
     * ��ȡintrmyAgt2���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * ����intrmyAgt2���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * ��ȡintrmyAgt2Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt2Acct() {
        return intrmyAgt2Acct;
    }

    /**
     * ����intrmyAgt2Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt2Acct(CashAccount40 value) {
        this.intrmyAgt2Acct = value;
    }

    /**
     * ��ȡintrmyAgt3���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * ����intrmyAgt3���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification6 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * ��ȡintrmyAgt3Acct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getIntrmyAgt3Acct() {
        return intrmyAgt3Acct;
    }

    /**
     * ����intrmyAgt3Acct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setIntrmyAgt3Acct(CashAccount40 value) {
        this.intrmyAgt3Acct = value;
    }

    /**
     * ��ȡcdtrAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * ����cdtrAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.cdtrAgt = value;
    }

    /**
     * ��ȡcdtrAgtAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAgtAcct() {
        return cdtrAgtAcct;
    }

    /**
     * ����cdtrAgtAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAgtAcct(CashAccount40 value) {
        this.cdtrAgtAcct = value;
    }

    /**
     * ��ȡcdtr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getCdtr() {
        return cdtr;
    }

    /**
     * ����cdtr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setCdtr(Party40Choice value) {
        this.cdtr = value;
    }

    /**
     * ��ȡcdtrAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * ����cdtrAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setCdtrAcct(CashAccount40 value) {
        this.cdtrAcct = value;
    }

    /**
     * ��ȡultmtCdtr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * ����ultmtCdtr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setUltmtCdtr(Party40Choice value) {
        this.ultmtCdtr = value;
    }

}
