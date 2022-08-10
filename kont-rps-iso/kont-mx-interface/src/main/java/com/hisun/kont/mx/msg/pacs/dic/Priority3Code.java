package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Priority3Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Priority3Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="URGT"/>
 *     &lt;enumeration value="HIGH"/>
 *     &lt;enumeration value="NORM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Priority3Code")
@XmlEnum
public enum Priority3Code {


    /**
     * Priority level is urgent (highest priority possible).
     * 
     */
    URGT,

    /**
     * Priority level is high.
     * 
     */
    HIGH,

    /**
     * Priority level is normal.
     * 
     */
    NORM;

    public String value() {
        return name();
    }

    public static Priority3Code fromValue(String v) {
        return valueOf(v);
    }

}
