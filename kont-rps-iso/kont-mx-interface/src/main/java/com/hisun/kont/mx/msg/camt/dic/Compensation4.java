package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Compensation4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Compensation4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{}ActiveCurrencyAndAmount"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="DbtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{}BranchAndFinancialInstitutionIdentification6"/>
 *         &lt;element name="CdtrAgtAcct" type="{}CashAccount40" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{}CompensationReason1Choice"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Compensation4", propOrder = {
    "amt",
    "dbtrAgt",
    "dbtrAgtAcct",
    "cdtrAgt",
    "cdtrAgtAcct",
    "rsn"
})
public class Compensation4 {

    @XmlElement(name = "Amt", required = true)
    protected ActiveCurrencyAndAmount amt;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "DbtrAgtAcct")
    protected CashAccount40 dbtrAgtAcct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "CdtrAgtAcct")
    protected CashAccount40 cdtrAgtAcct;
    @XmlElement(name = "Rsn", required = true)
    protected CompensationReason1Choice rsn;

    /**
     * ��ȡamt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public ActiveCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveCurrencyAndAmount }
     *     
     */
    public void setAmt(ActiveCurrencyAndAmount value) {
        this.amt = value;
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
     * ��ȡrsn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CompensationReason1Choice }
     *     
     */
    public CompensationReason1Choice getRsn() {
        return rsn;
    }

    /**
     * ����rsn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CompensationReason1Choice }
     *     
     */
    public void setRsn(CompensationReason1Choice value) {
        this.rsn = value;
    }

}
