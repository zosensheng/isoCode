package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides the details on the user identification or any user key that allows to check if the initiating party is allowed to issue the transaction.
 * 
 * <p>Authorisation1Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Authorisation1Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Cd" type="{}Authorisation1Code"/>
 *         &lt;element name="Prtry" type="{}Max128Text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Authorisation1Choice", propOrder = {
    "cd",
    "prtry"
})
public class Authorisation1Choice {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected Authorisation1Code cd;
    @XmlElement(name = "Prtry")
    protected String prtry;

    /**
     * ��ȡcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Authorisation1Code }
     *     
     */
    public Authorisation1Code getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Authorisation1Code }
     *     
     */
    public void setCd(Authorisation1Code value) {
        this.cd = value;
    }

    /**
     * ��ȡprtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtry() {
        return prtry;
    }

    /**
     * ����prtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtry(String value) {
        this.prtry = value;
    }

}
