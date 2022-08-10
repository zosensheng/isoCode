package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Data related to the authentication of the cardholder.
 * 
 * <p>CardholderAuthentication2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CardholderAuthentication2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="AuthntcnMtd" type="{}AuthenticationMethod1Code"/>
 *         &lt;element name="AuthntcnNtty" type="{}AuthenticationEntity1Code"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardholderAuthentication2", propOrder = {
    "authntcnMtd",
    "authntcnNtty"
})
public class CardholderAuthentication2 {

    @XmlElement(name = "AuthntcnMtd", required = true)
    @XmlSchemaType(name = "string")
    protected AuthenticationMethod1Code authntcnMtd;
    @XmlElement(name = "AuthntcnNtty", required = true)
    @XmlSchemaType(name = "string")
    protected AuthenticationEntity1Code authntcnNtty;

    /**
     * ��ȡauthntcnMtd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationMethod1Code }
     *     
     */
    public AuthenticationMethod1Code getAuthntcnMtd() {
        return authntcnMtd;
    }

    /**
     * ����authntcnMtd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationMethod1Code }
     *     
     */
    public void setAuthntcnMtd(AuthenticationMethod1Code value) {
        this.authntcnMtd = value;
    }

    /**
     * ��ȡauthntcnNtty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationEntity1Code }
     *     
     */
    public AuthenticationEntity1Code getAuthntcnNtty() {
        return authntcnNtty;
    }

    /**
     * ����authntcnNtty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationEntity1Code }
     *     
     */
    public void setAuthntcnNtty(AuthenticationEntity1Code value) {
        this.authntcnNtty = value;
    }

}
