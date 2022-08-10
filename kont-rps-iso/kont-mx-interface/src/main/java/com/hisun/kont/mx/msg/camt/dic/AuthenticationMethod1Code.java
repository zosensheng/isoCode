package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AuthenticationMethod1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AuthenticationMethod1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="UKNW"/>
 *     &lt;enumeration value="BYPS"/>
 *     &lt;enumeration value="NPIN"/>
 *     &lt;enumeration value="FPIN"/>
 *     &lt;enumeration value="CPSG"/>
 *     &lt;enumeration value="PPSG"/>
 *     &lt;enumeration value="MANU"/>
 *     &lt;enumeration value="MERC"/>
 *     &lt;enumeration value="SCRT"/>
 *     &lt;enumeration value="SNCT"/>
 *     &lt;enumeration value="SCNL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AuthenticationMethod1Code")
@XmlEnum
public enum AuthenticationMethod1Code {


    /**
     * Authentication method is performed unknown.
     * 
     */
    UKNW,

    /**
     * Authentication bypassed by the merchant.
     * 
     */
    BYPS,

    /**
     * On-line PIN authentication (Personal Identification Number).
     * 
     */
    NPIN,

    /**
     * Off-line PIN authentication (Personal Identification Number).
     * 
     */
    FPIN,

    /**
     * Electronic signature capture (handwritten signature).
     * 
     */
    CPSG,

    /**
     * Handwritten paper signature.
     * 
     */
    PPSG,

    /**
     * Manual verification, for example passport or drivers license.
     * 
     */
    MANU,

    /**
     * Merchant-related authentication.
     * 
     */
    MERC,

    /**
     * Electronic commerce transaction secured with the X.509 certificate of a customer.
     * 
     */
    SCRT,

    /**
     * Secure electronic transaction without cardholder certificate.
     * 
     */
    SNCT,

    /**
     * Channel-encrypted transaction.
     * 
     */
    SCNL;

    public String value() {
        return name();
    }

    public static AuthenticationMethod1Code fromValue(String v) {
        return valueOf(v);
    }

}
