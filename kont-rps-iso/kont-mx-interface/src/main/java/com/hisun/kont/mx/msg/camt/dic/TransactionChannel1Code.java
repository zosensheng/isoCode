package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionChannel1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionChannel1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="MAIL"/>
 *     &lt;enumeration value="TLPH"/>
 *     &lt;enumeration value="ECOM"/>
 *     &lt;enumeration value="TVPY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionChannel1Code")
@XmlEnum
public enum TransactionChannel1Code {


    /**
     * Mail order.
     * 
     */
    MAIL,

    /**
     * Telephone order.
     * 
     */
    TLPH,

    /**
     * Electronic commerce.
     * 
     */
    ECOM,

    /**
     * Payment on television.
     * 
     */
    TVPY;

    public String value() {
        return name();
    }

    public static TransactionChannel1Code fromValue(String v) {
        return valueOf(v);
    }

}
