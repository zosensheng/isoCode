package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the identification of a person or an organisation.
 * 
 * <p>PartyIdentification135 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PartyIdentification135">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{}PostalAddress24" minOccurs="0"/>
 *         &lt;element name="Id" type="{}Party38Choice" minOccurs="0"/>
 *         &lt;element name="CtryOfRes" type="{}CountryCode" minOccurs="0"/>
 *         &lt;element name="CtctDtls" type="{}Contact4" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyIdentification135", propOrder = {
    "nm",
    "pstlAdr",
    "id",
    "ctryOfRes",
    "ctctDtls"
})
public class PartyIdentification135 {

    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress24 pstlAdr;
    @XmlElement(name = "Id")
    protected Party38Choice id;
    @XmlElement(name = "CtryOfRes")
    protected String ctryOfRes;
    @XmlElement(name = "CtctDtls")
    protected Contact4 ctctDtls;

    /**
     * ��ȡnm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * ����nm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * ��ȡpstlAdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress24 }
     *     
     */
    public PostalAddress24 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * ����pstlAdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress24 }
     *     
     */
    public void setPstlAdr(PostalAddress24 value) {
        this.pstlAdr = value;
    }

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party38Choice }
     *     
     */
    public Party38Choice getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party38Choice }
     *     
     */
    public void setId(Party38Choice value) {
        this.id = value;
    }

    /**
     * ��ȡctryOfRes���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtryOfRes() {
        return ctryOfRes;
    }

    /**
     * ����ctryOfRes���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtryOfRes(String value) {
        this.ctryOfRes = value;
    }

    /**
     * ��ȡctctDtls���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Contact4 }
     *     
     */
    public Contact4 getCtctDtls() {
        return ctctDtls;
    }

    /**
     * ����ctctDtls���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Contact4 }
     *     
     */
    public void setCtctDtls(Contact4 value) {
        this.ctctDtls = value;
    }

}
