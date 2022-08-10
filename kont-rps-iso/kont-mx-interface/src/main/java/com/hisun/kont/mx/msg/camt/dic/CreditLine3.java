package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to provide details of the credit line.
 * 
 * <p>CreditLine3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CreditLine3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Incl" type="{}TrueFalseIndicator"/>
 *         &lt;element name="Tp" type="{}CreditLineType1Choice" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Dt" type="{}DateAndDateTime2Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditLine3", propOrder = {
    "incl",
    "tp",
    "amt",
    "dt"
})
public class CreditLine3 {

    @XmlElement(name = "Incl")
    protected boolean incl;
    @XmlElement(name = "Tp")
    protected CreditLineType1Choice tp;
    @XmlElement(name = "Amt")
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "Dt")
    protected DateAndDateTime2Choice dt;

    /**
     * ��ȡincl���Ե�ֵ��
     * 
     */
    public boolean isIncl() {
        return incl;
    }

    /**
     * ����incl���Ե�ֵ��
     * 
     */
    public void setIncl(boolean value) {
        this.incl = value;
    }

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditLineType1Choice }
     *     
     */
    public CreditLineType1Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditLineType1Choice }
     *     
     */
    public void setTp(CreditLineType1Choice value) {
        this.tp = value;
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
     * ��ȡdt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getDt() {
        return dt;
    }

    /**
     * ����dt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setDt(DateAndDateTime2Choice value) {
        this.dt = value;
    }

}
