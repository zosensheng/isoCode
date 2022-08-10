package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ClaimNonReceipt2Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClaimNonReceipt2Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Accptd" type="{}ClaimNonReceipt2"/>
 *         &lt;element name="Rjctd" type="{}ClaimNonReceiptRejectReason1Choice"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimNonReceipt2Choice", propOrder = {
    "accptd",
    "rjctd"
})
public class ClaimNonReceipt2Choice {

    @XmlElement(name = "Accptd")
    protected ClaimNonReceipt2 accptd;
    @XmlElement(name = "Rjctd")
    protected ClaimNonReceiptRejectReason1Choice rjctd;

    /**
     * ��ȡaccptd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClaimNonReceipt2 }
     *     
     */
    public ClaimNonReceipt2 getAccptd() {
        return accptd;
    }

    /**
     * ����accptd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimNonReceipt2 }
     *     
     */
    public void setAccptd(ClaimNonReceipt2 value) {
        this.accptd = value;
    }

    /**
     * ��ȡrjctd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClaimNonReceiptRejectReason1Choice }
     *     
     */
    public ClaimNonReceiptRejectReason1Choice getRjctd() {
        return rjctd;
    }

    /**
     * ����rjctd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimNonReceiptRejectReason1Choice }
     *     
     */
    public void setRjctd(ClaimNonReceiptRejectReason1Choice value) {
        this.rjctd = value;
    }

}
