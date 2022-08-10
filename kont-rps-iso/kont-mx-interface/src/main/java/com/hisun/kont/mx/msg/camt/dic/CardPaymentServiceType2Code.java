package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardPaymentServiceType2Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CardPaymentServiceType2Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="AGGR"/>
 *     &lt;enumeration value="DCCV"/>
 *     &lt;enumeration value="GRTT"/>
 *     &lt;enumeration value="INSP"/>
 *     &lt;enumeration value="LOYT"/>
 *     &lt;enumeration value="NRES"/>
 *     &lt;enumeration value="PUCO"/>
 *     &lt;enumeration value="RECP"/>
 *     &lt;enumeration value="SOAF"/>
 *     &lt;enumeration value="UNAF"/>
 *     &lt;enumeration value="VCAU"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardPaymentServiceType2Code")
@XmlEnum
public enum CardPaymentServiceType2Code {


    /**
     * Aggregation of low payments.
     * 
     */
    AGGR,

    /**
     * Dynamic currency conversion (DCC).
     * 
     */
    DCCV,

    /**
     * Card payment with gratuity.
     * 
     */
    GRTT,

    /**
     * Instalment payment.
     * 
     */
    INSP,

    /**
     * Loyalty services.
     * 
     */
    LOYT,

    /**
     * No show after reservation.
     * 
     */
    NRES,

    /**
     * Purchase and corporate data.
     * 
     */
    PUCO,

    /**
     * Recurring payment.
     * 
     */
    RECP,

    /**
     * Solicited available funds.
     * 
     */
    SOAF,

    /**
     * Unsolicited available funds.
     * 
     */
    UNAF,

    /**
     * Voice authorisation.
     * 
     */
    VCAU;

    public String value() {
        return name();
    }

    public static CardPaymentServiceType2Code fromValue(String v) {
        return valueOf(v);
    }

}
