package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CSCManagement1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CSCManagement1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="PRST"/>
 *     &lt;enumeration value="BYPS"/>
 *     &lt;enumeration value="UNRD"/>
 *     &lt;enumeration value="NCSC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CSCManagement1Code")
@XmlEnum
public enum CSCManagement1Code {


    /**
     * Card security code present.
     * 
     */
    PRST,

    /**
     * Card security code by-passed or not provided by the merchant.
     * 
     */
    BYPS,

    /**
     * Card security code unreadable.
     * 
     */
    UNRD,

    /**
     * No card security code imprint.
     * 
     */
    NCSC;

    public String value() {
        return name();
    }

    public static CSCManagement1Code fromValue(String v) {
        return valueOf(v);
    }

}
