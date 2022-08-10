package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AuthenticationEntity1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AuthenticationEntity1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="ICCD"/>
 *     &lt;enumeration value="AGNT"/>
 *     &lt;enumeration value="MERC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthenticationEntity1Code")
@XmlEnum
public enum AuthenticationEntity1Code {


    /**
     * Application in the chip card (Integrated Circuit Card), for instance an offline PIN verification.
     * 
     */
    ICCD,

    /**
     * Authorisation agent of the issuer.
     * 
     */
    AGNT,

    /**
     * Merchant (for example signature verification by the attendant).
     * 
     */
    MERC;

    public String value() {
        return name();
    }

    public static AuthenticationEntity1Code fromValue(String v) {
        return valueOf(v);
    }

}
