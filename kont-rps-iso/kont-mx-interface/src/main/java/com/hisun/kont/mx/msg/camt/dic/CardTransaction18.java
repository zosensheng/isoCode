package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Card transaction details.
 * 
 * <p>CardTransaction18 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CardTransaction18">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Card" type="{}PaymentCard4" minOccurs="0"/>
 *         &lt;element name="POI" type="{}PointOfInteraction1" minOccurs="0"/>
 *         &lt;element name="Tx" type="{}CardTransaction3Choice" minOccurs="0"/>
 *         &lt;element name="PrePdAcct" type="{}CashAccount40" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardTransaction18", propOrder = {
    "card",
    "poi",
    "tx",
    "prePdAcct"
})
public class CardTransaction18 {

    @XmlElement(name = "Card")
    protected PaymentCard4 card;
    @XmlElement(name = "POI")
    protected PointOfInteraction1 poi;
    @XmlElement(name = "Tx")
    protected CardTransaction3Choice tx;
    @XmlElement(name = "PrePdAcct")
    protected CashAccount40 prePdAcct;

    /**
     * ��ȡcard���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PaymentCard4 }
     *     
     */
    public PaymentCard4 getCard() {
        return card;
    }

    /**
     * ����card���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentCard4 }
     *     
     */
    public void setCard(PaymentCard4 value) {
        this.card = value;
    }

    /**
     * ��ȡpoi���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PointOfInteraction1 }
     *     
     */
    public PointOfInteraction1 getPOI() {
        return poi;
    }

    /**
     * ����poi���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PointOfInteraction1 }
     *     
     */
    public void setPOI(PointOfInteraction1 value) {
        this.poi = value;
    }

    /**
     * ��ȡtx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CardTransaction3Choice }
     *     
     */
    public CardTransaction3Choice getTx() {
        return tx;
    }

    /**
     * ����tx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CardTransaction3Choice }
     *     
     */
    public void setTx(CardTransaction3Choice value) {
        this.tx = value;
    }

    /**
     * ��ȡprePdAcct���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CashAccount40 }
     *     
     */
    public CashAccount40 getPrePdAcct() {
        return prePdAcct;
    }

    /**
     * ����prePdAcct���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount40 }
     *     
     */
    public void setPrePdAcct(CashAccount40 value) {
        this.prePdAcct = value;
    }

}
