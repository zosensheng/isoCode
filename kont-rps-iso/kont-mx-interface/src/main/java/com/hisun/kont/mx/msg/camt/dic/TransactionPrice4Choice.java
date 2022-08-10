package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the price information related to the underlying transaction.
 * 
 * <p>TransactionPrice4Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TransactionPrice4Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="DealPric" type="{}Price7"/>
 *         &lt;element name="Prtry" type="{}ProprietaryPrice2" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionPrice4Choice", propOrder = {
    "dealPric",
    "prtry"
})
public class TransactionPrice4Choice {

    @XmlElement(name = "DealPric")
    protected Price7 dealPric;
    @XmlElement(name = "Prtry")
    protected List<ProprietaryPrice2> prtry;

    /**
     * ��ȡdealPric���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Price7 }
     *     
     */
    public Price7 getDealPric() {
        return dealPric;
    }

    /**
     * ����dealPric���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Price7 }
     *     
     */
    public void setDealPric(Price7 value) {
        this.dealPric = value;
    }

    /**
     * Gets the value of the prtry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProprietaryPrice2 }
     * 
     * 
     */
    public List<ProprietaryPrice2> getPrtry() {
        if (prtry == null) {
            prtry = new ArrayList<ProprietaryPrice2>();
        }
        return this.prtry;
    }

}
