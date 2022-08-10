package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides further details on the agents specific to the individual transaction.
 * 
 * <p>TransactionAgents5 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TransactionAgents5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="InstgAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="InstdAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="RcvgAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="DlvrgAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="IssgAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="SttlmPlc" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *         &lt;element name="Prtry" type="{}ProprietaryAgent4" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionAgents5", propOrder = {
    "instgAgt",
    "instdAgt",
    "dbtrAgt",
    "cdtrAgt",
    "intrmyAgt1",
    "intrmyAgt2",
    "intrmyAgt3",
    "rcvgAgt",
    "dlvrgAgt",
    "issgAgt",
    "sttlmPlc",
    "prtry"
})
public class TransactionAgents5 {

    @XmlElement(name = "InstgAgt")
    protected BranchAndFinancialInstitutionIdentification6 instgAgt;
    @XmlElement(name = "InstdAgt")
    protected BranchAndFinancialInstitutionIdentification6 instdAgt;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 dbtrAgt;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification6 cdtrAgt;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification6 intrmyAgt3;
    @XmlElement(name = "RcvgAgt")
    protected BranchAndFinancialInstitutionIdentification6 rcvgAgt;
    @XmlElement(name = "DlvrgAgt")
    protected BranchAndFinancialInstitutionIdentification6 dlvrgAgt;
    @XmlElement(name = "IssgAgt")
    protected BranchAndFinancialInstitutionIdentification6 issgAgt;
    @XmlElement(name = "SttlmPlc")
    protected BranchAndFinancialInstitutionIdentification6 sttlmPlc;
    @XmlElement(name = "Prtry")
    protected List<ProprietaryAgent4> prtry;

    /**
     * ��ȡinstgAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstgAgt() {
        return instgAgt;
    }

    /**
     * ����instgAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstgAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instgAgt = value;
    }

    /**
     * ��ȡinstdAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getInstdAgt() {
        return instdAgt;
    }

    /**
     * ����instdAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setInstdAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.instdAgt = value;
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
     * ��ȡrcvgAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getRcvgAgt() {
        return rcvgAgt;
    }

    /**
     * ����rcvgAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setRcvgAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.rcvgAgt = value;
    }

    /**
     * ��ȡdlvrgAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getDlvrgAgt() {
        return dlvrgAgt;
    }

    /**
     * ����dlvrgAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setDlvrgAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.dlvrgAgt = value;
    }

    /**
     * ��ȡissgAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getIssgAgt() {
        return issgAgt;
    }

    /**
     * ����issgAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setIssgAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.issgAgt = value;
    }

    /**
     * ��ȡsttlmPlc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getSttlmPlc() {
        return sttlmPlc;
    }

    /**
     * ����sttlmPlc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setSttlmPlc(BranchAndFinancialInstitutionIdentification6 value) {
        this.sttlmPlc = value;
    }

    /**
     * Gets the value of the prtry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProprietaryAgent4 }
     * 
     * 
     */
    public List<ProprietaryAgent4> getPrtry() {
        if (prtry == null) {
            prtry = new ArrayList<ProprietaryAgent4>();
        }
        return this.prtry;
    }

}
