package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Priority2Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Priority2Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="HIGH"/>
 *     &lt;enumeration value="NORM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Priority2Code")
@XmlEnum
public enum Priority2Code {


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

    public static Priority2Code fromValue(String v) {
        return valueOf(v);
    }

}
