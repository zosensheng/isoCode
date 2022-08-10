package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Frequency6Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Frequency6Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="YEAR"/>
 *     &lt;enumeration value="MNTH"/>
 *     &lt;enumeration value="QURT"/>
 *     &lt;enumeration value="MIAN"/>
 *     &lt;enumeration value="WEEK"/>
 *     &lt;enumeration value="DAIL"/>
 *     &lt;enumeration value="ADHO"/>
 *     &lt;enumeration value="INDA"/>
 *     &lt;enumeration value="FRTN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Frequency6Code")
@XmlEnum
public enum Frequency6Code {

    YEAR,
    MNTH,
    QURT,
    MIAN,
    WEEK,
    DAIL,
    ADHO,
    INDA,
    FRTN;

    public String value() {
        return name();
    }

    public static Frequency6Code fromValue(String v) {
        return valueOf(v);
    }

}
