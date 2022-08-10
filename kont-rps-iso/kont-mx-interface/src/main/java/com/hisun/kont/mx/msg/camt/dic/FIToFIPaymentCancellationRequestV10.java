package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FIToFIPaymentCancellationRequestV10 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FIToFIPaymentCancellationRequestV10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Assgnmt" type="{}CaseAssignment5"/>
 *         &lt;element name="Case" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="CtrlData" type="{}ControlData1" minOccurs="0"/>
 *         &lt;element name="Undrlyg" type="{}UnderlyingTransaction28" maxOccurs="unbounded"/>
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
@XmlType(name = "FIToFIPaymentCancellationRequestV10", propOrder = {
    "assgnmt",
    "_case",
    "ctrlData",
    "undrlyg",
    "splmtryData"
})
public class FIToFIPaymentCancellationRequestV10 {

    @XmlElement(name = "Assgnmt", required = true)
    protected CaseAssignment5 assgnmt;
    @XmlElement(name = "Case")
    protected Case5 _case;
    @XmlElement(name = "CtrlData")
    protected ControlData1 ctrlData;
    @XmlElement(name = "Undrlyg", required = true)
    protected List<UnderlyingTransaction28> undrlyg;
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
     * ��ȡcase���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Case5 }
     *     
     */
    public Case5 getCase() {
        return _case;
    }

    /**
     * ����case���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Case5 }
     *     
     */
    public void setCase(Case5 value) {
        this._case = value;
    }

    /**
     * ��ȡctrlData���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ControlData1 }
     *     
     */
    public ControlData1 getCtrlData() {
        return ctrlData;
    }

    /**
     * ����ctrlData���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ControlData1 }
     *     
     */
    public void setCtrlData(ControlData1 value) {
        this.ctrlData = value;
    }

    /**
     * Gets the value of the undrlyg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the undrlyg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUndrlyg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnderlyingTransaction28 }
     * 
     * 
     */
    public List<UnderlyingTransaction28> getUndrlyg() {
        if (undrlyg == null) {
            undrlyg = new ArrayList<UnderlyingTransaction28>();
        }
        return this.undrlyg;
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
