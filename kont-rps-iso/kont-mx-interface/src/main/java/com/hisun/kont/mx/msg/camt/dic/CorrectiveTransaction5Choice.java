package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CorrectiveTransaction5Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CorrectiveTransaction5Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Initn" type="{}CorrectivePaymentInitiation5"/>
 *         &lt;element name="IntrBk" type="{}CorrectiveInterbankTransaction3"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrectiveTransaction5Choice", propOrder = {
    "initn",
    "intrBk"
})
public class CorrectiveTransaction5Choice {

    @XmlElement(name = "Initn")
    protected CorrectivePaymentInitiation5 initn;
    @XmlElement(name = "IntrBk")
    protected CorrectiveInterbankTransaction3 intrBk;

    /**
     * ��ȡinitn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CorrectivePaymentInitiation5 }
     *     
     */
    public CorrectivePaymentInitiation5 getInitn() {
        return initn;
    }

    /**
     * ����initn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectivePaymentInitiation5 }
     *     
     */
    public void setInitn(CorrectivePaymentInitiation5 value) {
        this.initn = value;
    }

    /**
     * ��ȡintrBk���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CorrectiveInterbankTransaction3 }
     *     
     */
    public CorrectiveInterbankTransaction3 getIntrBk() {
        return intrBk;
    }

    /**
     * ����intrBk���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectiveInterbankTransaction3 }
     *     
     */
    public void setIntrBk(CorrectiveInterbankTransaction3 value) {
        this.intrBk = value;
    }

}
