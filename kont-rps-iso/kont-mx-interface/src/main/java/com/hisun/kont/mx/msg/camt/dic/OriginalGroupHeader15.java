package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>OriginalGroupHeader15 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="OriginalGroupHeader15">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpCxlId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Case" type="{}Case5" minOccurs="0"/>
 *         &lt;element name="OrgnlMsgId" type="{}Max35Text"/>
 *         &lt;element name="OrgnlMsgNmId" type="{}Max35Text"/>
 *         &lt;element name="OrgnlCreDtTm" type="{}ISODateTime" minOccurs="0"/>
 *         &lt;element name="NbOfTxs" type="{}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="CtrlSum" type="{}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="GrpCxl" type="{}GroupCancellationIndicator" minOccurs="0"/>
 *         &lt;element name="CxlRsnInf" type="{}PaymentCancellationReason5" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalGroupHeader15", propOrder = {
    "grpCxlId",
    "_case",
    "orgnlMsgId",
    "orgnlMsgNmId",
    "orgnlCreDtTm",
    "nbOfTxs",
    "ctrlSum",
    "grpCxl",
    "cxlRsnInf"
})
public class OriginalGroupHeader15 {

    @XmlElement(name = "GrpCxlId")
    protected String grpCxlId;
    @XmlElement(name = "Case")
    protected Case5 _case;
    @XmlElement(name = "OrgnlMsgId", required = true)
    protected String orgnlMsgId;
    @XmlElement(name = "OrgnlMsgNmId", required = true)
    protected String orgnlMsgNmId;
    @XmlElement(name = "OrgnlCreDtTm")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar orgnlCreDtTm;
    @XmlElement(name = "NbOfTxs")
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum")
    protected BigDecimal ctrlSum;
    @XmlElement(name = "GrpCxl")
    protected Boolean grpCxl;
    @XmlElement(name = "CxlRsnInf")
    protected List<PaymentCancellationReason5> cxlRsnInf;

    /**
     * ��ȡgrpCxlId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrpCxlId() {
        return grpCxlId;
    }

    /**
     * ����grpCxlId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrpCxlId(String value) {
        this.grpCxlId = value;
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
     * ��ȡorgnlMsgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMsgId() {
        return orgnlMsgId;
    }

    /**
     * ����orgnlMsgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMsgId(String value) {
        this.orgnlMsgId = value;
    }

    /**
     * ��ȡorgnlMsgNmId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMsgNmId() {
        return orgnlMsgNmId;
    }

    /**
     * ����orgnlMsgNmId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMsgNmId(String value) {
        this.orgnlMsgNmId = value;
    }

    /**
     * ��ȡorgnlCreDtTm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOrgnlCreDtTm() {
        return orgnlCreDtTm;
    }

    /**
     * ����orgnlCreDtTm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOrgnlCreDtTm(XMLGregorianCalendar value) {
        this.orgnlCreDtTm = value;
    }

    /**
     * ��ȡnbOfTxs���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * ����nbOfTxs���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * ��ȡctrlSum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * ����ctrlSum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * ��ȡgrpCxl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGrpCxl() {
        return grpCxl;
    }

    /**
     * ����grpCxl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGrpCxl(Boolean value) {
        this.grpCxl = value;
    }

    /**
     * Gets the value of the cxlRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cxlRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCxlRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentCancellationReason5 }
     * 
     * 
     */
    public List<PaymentCancellationReason5> getCxlRsnInf() {
        if (cxlRsnInf == null) {
            cxlRsnInf = new ArrayList<PaymentCancellationReason5>();
        }
        return this.cxlRsnInf;
    }

}
