package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ClearingChannel2Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="ClearingChannel2Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="RTGS"/>
 *     &lt;enumeration value="RTNS"/>
 *     &lt;enumeration value="MPNS"/>
 *     &lt;enumeration value="BOOK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClearingChannel2Code")
@XmlEnum
public enum ClearingChannel2Code {


    /**
     * Clearing channel is a real-time gross settlement system.
     * 
     */
    RTGS,

    /**
     * Clearing channel is a real-time net settlement system.
     * 
     */
    RTNS,

    /**
     * Clearing channel is a mass payment net settlement system.
     * 
     */
    MPNS,

    /**
     * Payment through internal book transfer.
     * 
     */
    BOOK;

    public String value() {
        return name();
    }

    public static ClearingChannel2Code fromValue(String v) {
        return valueOf(v);
    }

}
