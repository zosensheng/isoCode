package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Type and information about a price.
 * 
 * <p>Price7 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Price7">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}YieldedOrValueType1Choice"/>
 *         &lt;element name="Val" type="{}PriceRateOrAmount3Choice"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Price7", propOrder = {
    "tp",
    "val"
})
public class Price7 {

    @XmlElement(name = "Tp", required = true)
    protected YieldedOrValueType1Choice tp;
    @XmlElement(name = "Val", required = true)
    protected PriceRateOrAmount3Choice val;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link YieldedOrValueType1Choice }
     *     
     */
    public YieldedOrValueType1Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link YieldedOrValueType1Choice }
     *     
     */
    public void setTp(YieldedOrValueType1Choice value) {
        this.tp = value;
    }

    /**
     * ��ȡval���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PriceRateOrAmount3Choice }
     *     
     */
    public PriceRateOrAmount3Choice getVal() {
        return val;
    }

    /**
     * ����val���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PriceRateOrAmount3Choice }
     *     
     */
    public void setVal(PriceRateOrAmount3Choice value) {
        this.val = value;
    }

}
