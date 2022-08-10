package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements providing the total sum of entries.
 * 
 * <p>NumberAndSumOfTransactions1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NumberAndSumOfTransactions1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="NbOfNtries" type="{}Max15NumericText" minOccurs="0"/>
 *         &lt;element name="Sum" type="{}DecimalNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumberAndSumOfTransactions1", propOrder = {
    "nbOfNtries",
    "sum"
})
public class NumberAndSumOfTransactions1 {

    @XmlElement(name = "NbOfNtries")
    protected String nbOfNtries;
    @XmlElement(name = "Sum")
    protected BigDecimal sum;

    /**
     * ��ȡnbOfNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfNtries() {
        return nbOfNtries;
    }

    /**
     * ����nbOfNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfNtries(String value) {
        this.nbOfNtries = value;
    }

    /**
     * ��ȡsum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * ����sum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSum(BigDecimal value) {
        this.sum = value;
    }

}
