package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserInterface2Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="UserInterface2Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="MDSP"/>
 *     &lt;enumeration value="CDSP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UserInterface2Code")
@XmlEnum
public enum UserInterface2Code {


    /**
     * Merchant display or interface.
     * 
     */
    MDSP,

    /**
     * Cardholder display or interface.
     * 
     */
    CDSP;

    public String value() {
        return name();
    }

    public static UserInterface2Code fromValue(String v) {
        return valueOf(v);
    }

}
