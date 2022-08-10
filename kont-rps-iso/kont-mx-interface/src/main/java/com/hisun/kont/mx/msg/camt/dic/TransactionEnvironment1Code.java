package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionEnvironment1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionEnvironment1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="MERC"/>
 *     &lt;enumeration value="PRIV"/>
 *     &lt;enumeration value="PUBL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionEnvironment1Code")
@XmlEnum
public enum TransactionEnvironment1Code {


    /**
     * Merchant environment.
     * 
     */
    MERC,

    /**
     * Private environment.
     * 
     */
    PRIV,

    /**
     * Public environment.
     * 
     */
    PUBL;

    public String value() {
        return name();
    }

    public static TransactionEnvironment1Code fromValue(String v) {
        return valueOf(v);
    }

}
