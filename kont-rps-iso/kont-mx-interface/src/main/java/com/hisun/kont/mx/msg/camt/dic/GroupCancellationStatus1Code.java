package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>GroupCancellationStatus1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="GroupCancellationStatus1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="PACR"/>
 *     &lt;enumeration value="RJCR"/>
 *     &lt;enumeration value="ACCR"/>
 *     &lt;enumeration value="PDCR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GroupCancellationStatus1Code")
@XmlEnum
public enum GroupCancellationStatus1Code {

    PACR,
    RJCR,
    ACCR,
    PDCR;

    public String value() {
        return name();
    }

    public static GroupCancellationStatus1Code fromValue(String v) {
        return valueOf(v);
    }

}
