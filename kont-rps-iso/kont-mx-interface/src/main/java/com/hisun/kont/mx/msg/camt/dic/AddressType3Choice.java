package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice of formats for the type of address.
 * 
 * <p>AddressType3Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="AddressType3Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Cd" type="{}AddressType2Code"/>
 *         &lt;element name="Prtry" type="{}GenericIdentification30"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType3Choice", propOrder = {
    "cd",
    "prtry"
})
public class AddressType3Choice {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected AddressType2Code cd;
    @XmlElement(name = "Prtry")
    protected GenericIdentification30 prtry;

    /**
     * ��ȡcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AddressType2Code }
     *     
     */
    public AddressType2Code getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType2Code }
     *     
     */
    public void setCd(AddressType2Code value) {
        this.cd = value;
    }

    /**
     * ��ȡprtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GenericIdentification30 }
     *     
     */
    public GenericIdentification30 getPrtry() {
        return prtry;
    }

    /**
     * ����prtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIdentification30 }
     *     
     */
    public void setPrtry(GenericIdentification30 value) {
        this.prtry = value;
    }

}
