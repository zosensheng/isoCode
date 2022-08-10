package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Interest type is expressed as a code or a text.
 * 
 * <p>InterestType1Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="InterestType1Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Cd" type="{}InterestType1Code"/>
 *         &lt;element name="Prtry" type="{}Max35Text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InterestType1Choice", propOrder = {
    "cd",
    "prtry"
})
public class InterestType1Choice {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected InterestType1Code cd;
    @XmlElement(name = "Prtry")
    protected String prtry;

    /**
     * ��ȡcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link InterestType1Code }
     *     
     */
    public InterestType1Code getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link InterestType1Code }
     *     
     */
    public void setCd(InterestType1Code value) {
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
