package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AttendanceContext1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="AttendanceContext1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="ATTD"/>
 *     &lt;enumeration value="SATT"/>
 *     &lt;enumeration value="UATT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AttendanceContext1Code")
@XmlEnum
public enum AttendanceContext1Code {


    /**
     * Attended payment, with an attendant.
     * 
     */
    ATTD,

    /**
     * Semi-attended, including self checkout. An attendant supervises several payment, and could be called to help the cardholder.
     * 
     */
    SATT,

    /**
     * Unattended payment, no attendant present.
     * 
     */
    UATT;

    public String value() {
        return name();
    }

    public static AttendanceContext1Code fromValue(String v) {
        return valueOf(v);
    }

}
