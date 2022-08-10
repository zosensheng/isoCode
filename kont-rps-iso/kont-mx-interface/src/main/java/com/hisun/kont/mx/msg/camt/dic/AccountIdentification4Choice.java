package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the unique identification of an account as assigned by the account servicer.
 * 
 * <p>AccountIdentification4Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AccountIdentification4Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="IBAN" type="{}IBAN2007Identifier"/>
 *         &lt;element name="Othr" type="{}GenericAccountIdentification1"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountIdentification4Choice", propOrder = {
    "iban",
    "othr"
})
public class AccountIdentification4Choice {

    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "Othr")
    protected GenericAccountIdentification1 othr;

    /**
     * ��ȡiban���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * ����iban���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * ��ȡothr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GenericAccountIdentification1 }
     *     
     */
    public GenericAccountIdentification1 getOthr() {
        return othr;
    }

    /**
     * ����othr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GenericAccountIdentification1 }
     *     
     */
    public void setOthr(GenericAccountIdentification1 value) {
        this.othr = value;
    }

}
