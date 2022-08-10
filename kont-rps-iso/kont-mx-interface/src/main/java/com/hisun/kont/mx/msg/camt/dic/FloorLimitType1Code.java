package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FloorLimitType1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="FloorLimitType1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="CRED"/>
 *     &lt;enumeration value="DEBT"/>
 *     &lt;enumeration value="BOTH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FloorLimitType1Code")
@XmlEnum
public enum FloorLimitType1Code {


    /**
     * Floor limit applies to credit entries.
     * 
     */
    CRED,

    /**
     * Floor limit applies to debit entries.
     * 
     */
    DEBT,

    /**
     * Floor limit applies to both credit and debit entries.
     * 
     */
    BOTH;

    public String value() {
        return name();
    }

    public static FloorLimitType1Code fromValue(String v) {
        return valueOf(v);
    }

}
