package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>POIComponentType1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="POIComponentType1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="SOFT"/>
 *     &lt;enumeration value="EMVK"/>
 *     &lt;enumeration value="EMVO"/>
 *     &lt;enumeration value="MRIT"/>
 *     &lt;enumeration value="CHIT"/>
 *     &lt;enumeration value="SECM"/>
 *     &lt;enumeration value="PEDV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "POIComponentType1Code")
@XmlEnum
public enum POIComponentType1Code {


    /**
     * Payment or other software application.
     * 
     */
    SOFT,

    /**
     * EMV application kernel (EMV is the chip card specifications initially defined by Eurocard, Mastercard and Visa).
     * 
     */
    EMVK,

    /**
     * EMV physical interface (EMV is the chip card specifications initially defined by Eurocard, Mastercard and Visa).
     * 
     */
    EMVO,

    /**
     * Merchant interface.
     * 
     */
    MRIT,

    /**
     * Cardholder Interface.
     * 
     */
    CHIT,

    /**
     * Security module.
     * 
     */
    SECM,

    /**
     * Personal identification number (or PIN) entry device (PED).
     * 
     */
    PEDV;

    public String value() {
        return name();
    }

    public static POIComponentType1Code fromValue(String v) {
        return valueOf(v);
    }

}
