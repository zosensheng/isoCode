package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StatementResolutionEntry4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="StatementResolutionEntry4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="OrgnlGrpInf" type="{}OriginalGroupInformation29" minOccurs="0"/>
 *         &lt;element name="OrgnlStmtId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="UETR" type="{}UUIDv4Identifier" minOccurs="0"/>
 *         &lt;element name="AcctSvcrRef" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="CrrctdAmt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Chrgs" type="{}Charges6" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Purp" type="{}Purpose2Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatementResolutionEntry4", propOrder = {
    "orgnlGrpInf",
    "orgnlStmtId",
    "uetr",
    "acctSvcrRef",
    "crrctdAmt",
    "chrgs",
    "purp"
})
public class StatementResolutionEntry4 {

    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupInformation29 orgnlGrpInf;
    @XmlElement(name = "OrgnlStmtId")
    protected String orgnlStmtId;
    @XmlElement(name = "UETR")
    protected String uetr;
    @XmlElement(name = "AcctSvcrRef")
    protected String acctSvcrRef;
    @XmlElement(name = "CrrctdAmt")
    protected ActiveOrHistoricCurrencyAndAmount crrctdAmt;
    @XmlElement(name = "Chrgs")
    protected List<Charges6> chrgs;
    @XmlElement(name = "Purp")
    protected Purpose2Choice purp;

    /**
     * ��ȡorgnlGrpInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformation29 }
     *     
     */
    public OriginalGroupInformation29 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * ����orgnlGrpInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformation29 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupInformation29 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * ��ȡorgnlStmtId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlStmtId() {
        return orgnlStmtId;
    }

    /**
     * ����orgnlStmtId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlStmtId(String value) {
        this.orgnlStmtId = value;
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
     * ��ȡacctSvcrRef���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctSvcrRef() {
        return acctSvcrRef;
    }

    /**
     * ����acctSvcrRef���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctSvcrRef(String value) {
        this.acctSvcrRef = value;
    }

    /**
     * ��ȡcrrctdAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getCrrctdAmt() {
        return crrctdAmt;
    }

    /**
     * ����crrctdAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setCrrctdAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.crrctdAmt = value;
    }

    /**
     * Gets the value of the chrgs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chrgs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChrgs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Charges6 }
     * 
     * 
     */
    public List<Charges6> getChrgs() {
        if (chrgs == null) {
            chrgs = new ArrayList<Charges6>();
        }
        return this.chrgs;
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

}
