package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217. The number of fractional digits (or minor unit of currency) is not checked as per ISO 4217: It must be lesser than or equal to 13.
 * Note: The decimal separator is a dot.
 * 
 * <p>ActiveOrHistoricCurrencyAnd13DecimalAmount complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ActiveOrHistoricCurrencyAnd13DecimalAmount">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>ActiveOrHistoricCurrencyAnd13DecimalAmount_SimpleType">
 *       &lt;attribute name="Ccy" use="required" type="{}ActiveOrHistoricCurrencyCode" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveOrHistoricCurrencyAnd13DecimalAmount", propOrder = {
    "value"
})
public class ActiveOrHistoricCurrencyAnd13DecimalAmount {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "Ccy", required = true)
    protected String ccy;

    /**
     * ��ȡvalue���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * ����value���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * ��ȡccy���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * ����ccy���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

}
