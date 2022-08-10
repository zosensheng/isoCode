package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to identify the type or operations code of a transaction entry.
 * 
 * <p>BankTransactionCodeStructure4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BankTransactionCodeStructure4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Domn" type="{}BankTransactionCodeStructure5" minOccurs="0"/>
 *         &lt;element name="Prtry" type="{}ProprietaryBankTransactionCodeStructure1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankTransactionCodeStructure4", propOrder = {
    "domn",
    "prtry"
})
public class BankTransactionCodeStructure4 {

    @XmlElement(name = "Domn")
    protected BankTransactionCodeStructure5 domn;
    @XmlElement(name = "Prtry")
    protected ProprietaryBankTransactionCodeStructure1 prtry;

    /**
     * ��ȡdomn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BankTransactionCodeStructure5 }
     *     
     */
    public BankTransactionCodeStructure5 getDomn() {
        return domn;
    }

    /**
     * ����domn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BankTransactionCodeStructure5 }
     *     
     */
    public void setDomn(BankTransactionCodeStructure5 value) {
        this.domn = value;
    }

    /**
     * ��ȡprtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ProprietaryBankTransactionCodeStructure1 }
     *     
     */
    public ProprietaryBankTransactionCodeStructure1 getPrtry() {
        return prtry;
    }

    /**
     * ����prtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ProprietaryBankTransactionCodeStructure1 }
     *     
     */
    public void setPrtry(ProprietaryBankTransactionCodeStructure1 value) {
        this.prtry = value;
    }

}
