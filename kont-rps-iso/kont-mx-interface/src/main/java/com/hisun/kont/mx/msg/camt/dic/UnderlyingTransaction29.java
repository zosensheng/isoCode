package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnderlyingTransaction29 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="UnderlyingTransaction29">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="OrgnlGrpInfAndSts" type="{}OriginalGroupHeader14" minOccurs="0"/>
 *         &lt;element name="OrgnlPmtInfAndSts" type="{}OriginalPaymentInstruction43" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TxInfAndSts" type="{}PaymentTransaction138" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnderlyingTransaction29", propOrder = {
    "orgnlGrpInfAndSts",
    "orgnlPmtInfAndSts",
    "txInfAndSts"
})
public class UnderlyingTransaction29 {

    @XmlElement(name = "OrgnlGrpInfAndSts")
    protected OriginalGroupHeader14 orgnlGrpInfAndSts;
    @XmlElement(name = "OrgnlPmtInfAndSts")
    protected List<OriginalPaymentInstruction43> orgnlPmtInfAndSts;
    @XmlElement(name = "TxInfAndSts")
    protected List<PaymentTransaction138> txInfAndSts;

    /**
     * ��ȡorgnlGrpInfAndSts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader14 }
     *     
     */
    public OriginalGroupHeader14 getOrgnlGrpInfAndSts() {
        return orgnlGrpInfAndSts;
    }

    /**
     * ����orgnlGrpInfAndSts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader14 }
     *     
     */
    public void setOrgnlGrpInfAndSts(OriginalGroupHeader14 value) {
        this.orgnlGrpInfAndSts = value;
    }

    /**
     * Gets the value of the orgnlPmtInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgnlPmtInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgnlPmtInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OriginalPaymentInstruction43 }
     * 
     * 
     */
    public List<OriginalPaymentInstruction43> getOrgnlPmtInfAndSts() {
        if (orgnlPmtInfAndSts == null) {
            orgnlPmtInfAndSts = new ArrayList<OriginalPaymentInstruction43>();
        }
        return this.orgnlPmtInfAndSts;
    }

    /**
     * Gets the value of the txInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction138 }
     * 
     * 
     */
    public List<PaymentTransaction138> getTxInfAndSts() {
        if (txInfAndSts == null) {
            txInfAndSts = new ArrayList<PaymentTransaction138>();
        }
        return this.txInfAndSts;
    }

}
