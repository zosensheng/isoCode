package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardholderVerificationCapability1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CardholderVerificationCapability1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="MNSG"/>
 *     &lt;enumeration value="NPIN"/>
 *     &lt;enumeration value="FCPN"/>
 *     &lt;enumeration value="FEPN"/>
 *     &lt;enumeration value="FDSG"/>
 *     &lt;enumeration value="FBIO"/>
 *     &lt;enumeration value="MNVR"/>
 *     &lt;enumeration value="FBIG"/>
 *     &lt;enumeration value="APKI"/>
 *     &lt;enumeration value="PKIS"/>
 *     &lt;enumeration value="CHDT"/>
 *     &lt;enumeration value="SCEC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardholderVerificationCapability1Code")
@XmlEnum
public enum CardholderVerificationCapability1Code {


    /**
     * Manual signature verification.
     * 
     */
    MNSG,

    /**
     * Online PIN (Personal Identification Number).
     * 
     */
    NPIN,

    /**
     * Offline PIN in clear (Personal Identification Number).
     * 
     */
    FCPN,

    /**
     * Offline PIN encrypted (Personal Identification Number).
     * 
     */
    FEPN,

    /**
     * Offline digital signature analysis.
     * 
     */
    FDSG,

    /**
     * Offline biometrics.
     * 
     */
    FBIO,

    /**
     * Other manual verification, for example passport or drivers license.
     * 
     */
    MNVR,

    /**
     * Offline biographics.
     * 
     */
    FBIG,

    /**
     * Account based digital signature.
     * 
     */
    APKI,

    /**
     * PKI (Public Key Infrastructure) based digital signature.
     * 
     */
    PKIS,

    /**
     * Cardholder authentication data.
     * 
     */
    CHDT,

    /**
     * Three domain secure (three domain secure authentication of the cardholder).
     * 
     */
    SCEC;

    public String value() {
        return name();
    }

    public static CardholderVerificationCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}
