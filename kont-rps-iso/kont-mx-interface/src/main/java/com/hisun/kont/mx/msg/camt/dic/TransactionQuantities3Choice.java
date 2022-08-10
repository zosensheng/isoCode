package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the quantities (such as securities) in the underlying transaction.
 * 
 * <p>TransactionQuantities3Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TransactionQuantities3Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Qty" type="{}FinancialInstrumentQuantity1Choice"/>
 *         &lt;element name="OrgnlAndCurFaceAmt" type="{}OriginalAndCurrentQuantities1"/>
 *         &lt;element name="Prtry" type="{}ProprietaryQuantity1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionQuantities3Choice", propOrder = {
    "qty",
    "orgnlAndCurFaceAmt",
    "prtry"
})
public class TransactionQuantities3Choice {

    @XmlElement(name = "Qty")
    protected FinancialInstrumentQuantity1Choice qty;
    @XmlElement(name = "OrgnlAndCurFaceAmt")
    protected OriginalAndCurrentQuantities1 orgnlAndCurFaceAmt;
    @XmlElement(name = "Prtry")
    protected ProprietaryQuantity1 prtry;

    /**
     * ��ȡqty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstrumentQuantity1Choice }
     *     
     */
    public FinancialInstrumentQuantity1Choice getQty() {
        return qty;
    }

    /**
     * ����qty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstrumentQuantity1Choice }
     *     
     */
    public void setQty(FinancialInstrumentQuantity1Choice value) {
        this.qty = value;
    }

    /**
     * ��ȡorgnlAndCurFaceAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalAndCurrentQuantities1 }
     *     
     */
    public OriginalAndCurrentQuantities1 getOrgnlAndCurFaceAmt() {
        return orgnlAndCurFaceAmt;
    }

    /**
     * ����orgnlAndCurFaceAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalAndCurrentQuantities1 }
     *     
     */
    public void setOrgnlAndCurFaceAmt(OriginalAndCurrentQuantities1 value) {
        this.orgnlAndCurFaceAmt = value;
    }

    /**
     * ��ȡprtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ProprietaryQuantity1 }
     *     
     */
    public ProprietaryQuantity1 getPrtry() {
        return prtry;
    }

    /**
     * ����prtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ProprietaryQuantity1 }
     *     
     */
    public void setPrtry(ProprietaryQuantity1 value) {
        this.prtry = value;
    }

}
