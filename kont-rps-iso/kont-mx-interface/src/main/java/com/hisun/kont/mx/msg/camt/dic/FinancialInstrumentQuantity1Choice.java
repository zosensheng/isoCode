package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice between formats for the quantity of security.
 * 
 * <p>FinancialInstrumentQuantity1Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FinancialInstrumentQuantity1Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Unit" type="{}DecimalNumber"/>
 *         &lt;element name="FaceAmt" type="{}ImpliedCurrencyAndAmount"/>
 *         &lt;element name="AmtsdVal" type="{}ImpliedCurrencyAndAmount"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstrumentQuantity1Choice", propOrder = {
    "unit",
    "faceAmt",
    "amtsdVal"
})
public class FinancialInstrumentQuantity1Choice {

    @XmlElement(name = "Unit")
    protected BigDecimal unit;
    @XmlElement(name = "FaceAmt")
    protected BigDecimal faceAmt;
    @XmlElement(name = "AmtsdVal")
    protected BigDecimal amtsdVal;

    /**
     * ��ȡunit���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnit() {
        return unit;
    }

    /**
     * ����unit���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnit(BigDecimal value) {
        this.unit = value;
    }

    /**
     * ��ȡfaceAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFaceAmt() {
        return faceAmt;
    }

    /**
     * ����faceAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFaceAmt(BigDecimal value) {
        this.faceAmt = value;
    }

    /**
     * ��ȡamtsdVal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmtsdVal() {
        return amtsdVal;
    }

    /**
     * ����amtsdVal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmtsdVal(BigDecimal value) {
        this.amtsdVal = value;
    }

}
