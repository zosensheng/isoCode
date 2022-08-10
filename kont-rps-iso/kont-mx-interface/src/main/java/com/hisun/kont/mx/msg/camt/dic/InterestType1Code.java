package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InterestType1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="InterestType1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="INDY"/>
 *     &lt;enumeration value="OVRN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InterestType1Code")
@XmlEnum
public enum InterestType1Code {


    /**
     * During or within a business day.
     * 
     */
    INDY,

    /**
     * Period of time between the end of a business day and the start of the next business day (usually the day after).
     * 
     */
    OVRN;

    public String value() {
        return name();
    }

    public static InterestType1Code fromValue(String v) {
        return valueOf(v);
    }

}
