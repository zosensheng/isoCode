package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnderlyingTransaction28 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="UnderlyingTransaction28">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="OrgnlGrpInfAndCxl" type="{}OriginalGroupHeader15" minOccurs="0"/>
 *         &lt;element name="TxInf" type="{}PaymentTransaction137" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderlyingTransaction28", propOrder = {
    "orgnlGrpInfAndCxl",
    "txInf"
})
public class UnderlyingTransaction28 {

    @XmlElement(name = "OrgnlGrpInfAndCxl")
    protected OriginalGroupHeader15 orgnlGrpInfAndCxl;
    @XmlElement(name = "TxInf")
    protected List<PaymentTransaction137> txInf;

    /**
     * ��ȡorgnlGrpInfAndCxl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader15 }
     *     
     */
    public OriginalGroupHeader15 getOrgnlGrpInfAndCxl() {
        return orgnlGrpInfAndCxl;
    }

    /**
     * ����orgnlGrpInfAndCxl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader15 }
     *     
     */
    public void setOrgnlGrpInfAndCxl(OriginalGroupHeader15 value) {
        this.orgnlGrpInfAndCxl = value;
    }

    /**
     * Gets the value of the txInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction137 }
     * 
     * 
     */
    public List<PaymentTransaction137> getTxInf() {
        if (txInf == null) {
            txInf = new ArrayList<PaymentTransaction137>();
        }
        return this.txInf;
    }

}
