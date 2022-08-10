package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ResolutionOfInvestigationV11 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ResolutionOfInvestigationV11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Assgnmt" type="{}CaseAssignment5"/>
 *         &lt;element name="RslvdCase" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="Sts" type="{}InvestigationStatus5Choice"/>
 *         &lt;element name="CxlDtls" type="{}UnderlyingTransaction29" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ModDtls" type="{}PaymentTransaction132" minOccurs="0"/>
 *         &lt;element name="ClmNonRctDtls" type="{}ClaimNonReceipt2Choice" minOccurs="0"/>
 *         &lt;element name="StmtDtls" type="{}StatementResolutionEntry4" minOccurs="0"/>
 *         &lt;element name="CrrctnTx" type="{}CorrectiveTransaction5Choice" minOccurs="0"/>
 *         &lt;element name="RsltnRltdInf" type="{}ResolutionData3" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolutionOfInvestigationV11", propOrder = {
    "assgnmt",
    "rslvdCase",
    "sts",
    "cxlDtls",
    "modDtls",
    "clmNonRctDtls",
    "stmtDtls",
    "crrctnTx",
    "rsltnRltdInf",
    "splmtryData"
})
public class ResolutionOfInvestigationV11 {

    @XmlElement(name = "Assgnmt", required = true)
    protected CaseAssignment5 assgnmt;
    @XmlElement(name = "RslvdCase")
    protected Case5 rslvdCase;
    @XmlElement(name = "Sts", required = true)
    protected InvestigationStatus5Choice sts;
    @XmlElement(name = "CxlDtls")
    protected List<UnderlyingTransaction29> cxlDtls;
    @XmlElement(name = "ModDtls")
    protected PaymentTransaction132 modDtls;
    @XmlElement(name = "ClmNonRctDtls")
    protected ClaimNonReceipt2Choice clmNonRctDtls;
    @XmlElement(name = "StmtDtls")
    protected StatementResolutionEntry4 stmtDtls;
    @XmlElement(name = "CrrctnTx")
    protected CorrectiveTransaction5Choice crrctnTx;
    @XmlElement(name = "RsltnRltdInf")
    protected ResolutionData3 rsltnRltdInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡassgnmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CaseAssignment5 }
     *     
     */
    public CaseAssignment5 getAssgnmt() {
        return assgnmt;
    }

    /**
     * ����assgnmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CaseAssignment5 }
     *     
     */
    public void setAssgnmt(CaseAssignment5 value) {
        this.assgnmt = value;
    }

    /**
     * ��ȡrslvdCase���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Case5 }
     *     
     */
    public Case5 getRslvdCase() {
        return rslvdCase;
    }

    /**
     * ����rslvdCase���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Case5 }
     *     
     */
    public void setRslvdCase(Case5 value) {
        this.rslvdCase = value;
    }

    /**
     * ��ȡsts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InvestigationStatus5Choice }
     *     
     */
    public InvestigationStatus5Choice getSts() {
        return sts;
    }

    /**
     * ����sts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InvestigationStatus5Choice }
     *     
     */
    public void setSts(InvestigationStatus5Choice value) {
        this.sts = value;
    }

    /**
     * Gets the value of the cxlDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cxlDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCxlDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnderlyingTransaction29 }
     * 
     * 
     */
    public List<UnderlyingTransaction29> getCxlDtls() {
        if (cxlDtls == null) {
            cxlDtls = new ArrayList<UnderlyingTransaction29>();
        }
        return this.cxlDtls;
    }

    /**
     * ��ȡmodDtls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PaymentTransaction132 }
     *     
     */
    public PaymentTransaction132 getModDtls() {
        return modDtls;
    }

    /**
     * ����modDtls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTransaction132 }
     *     
     */
    public void setModDtls(PaymentTransaction132 value) {
        this.modDtls = value;
    }

    /**
     * ��ȡclmNonRctDtls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClaimNonReceipt2Choice }
     *     
     */
    public ClaimNonReceipt2Choice getClmNonRctDtls() {
        return clmNonRctDtls;
    }

    /**
     * ����clmNonRctDtls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimNonReceipt2Choice }
     *     
     */
    public void setClmNonRctDtls(ClaimNonReceipt2Choice value) {
        this.clmNonRctDtls = value;
    }

    /**
     * ��ȡstmtDtls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link StatementResolutionEntry4 }
     *     
     */
    public StatementResolutionEntry4 getStmtDtls() {
        return stmtDtls;
    }

    /**
     * ����stmtDtls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link StatementResolutionEntry4 }
     *     
     */
    public void setStmtDtls(StatementResolutionEntry4 value) {
        this.stmtDtls = value;
    }

    /**
     * ��ȡcrrctnTx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CorrectiveTransaction5Choice }
     *     
     */
    public CorrectiveTransaction5Choice getCrrctnTx() {
        return crrctnTx;
    }

    /**
     * ����crrctnTx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectiveTransaction5Choice }
     *     
     */
    public void setCrrctnTx(CorrectiveTransaction5Choice value) {
        this.crrctnTx = value;
    }

    /**
     * ��ȡrsltnRltdInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ResolutionData3 }
     *     
     */
    public ResolutionData3 getRsltnRltdInf() {
        return rsltnRltdInf;
    }

    /**
     * ����rsltnRltdInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionData3 }
     *     
     */
    public void setRsltnRltdInf(ResolutionData3 value) {
        this.rsltnRltdInf = value;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
