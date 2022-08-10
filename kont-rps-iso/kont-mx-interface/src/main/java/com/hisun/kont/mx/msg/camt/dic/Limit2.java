package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the minimum value of entries to be reported in the requested message.
 * 
 * <p>Limit2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Limit2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount"/>
 *         &lt;element name="CdtDbtInd" type="{}FloorLimitType1Code"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Limit2", propOrder = {
    "amt",
    "cdtDbtInd"
})
public class Limit2 {

    @XmlElement(name = "Amt", required = true)
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected FloorLimitType1Code cdtDbtInd;

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
     * ��ȡcdtDbtInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FloorLimitType1Code }
     *     
     */
    public FloorLimitType1Code getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * ����cdtDbtInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FloorLimitType1Code }
     *     
     */
    public void setCdtDbtInd(FloorLimitType1Code value) {
        this.cdtDbtInd = value;
    }

}
