package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ChargeBearerType1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="ChargeBearerType1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="DEBT"/>
 *     &lt;enumeration value="CRED"/>
 *     &lt;enumeration value="SHAR"/>
 *     &lt;enumeration value="SLEV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChargeBearerType1Code")
@XmlEnum
public enum ChargeBearerType1Code {


    /**
     * All transaction charges are to be borne by the debtor.
     * 
     */
    DEBT,

    /**
     * All transaction charges are to be borne by the creditor.
     * 
     */
    CRED,

    /**
     * In a credit transfer context, means that transaction charges on the sender side are to be borne by the debtor, transaction charges on the receiver side are to be borne by the creditor. In a direct debit context, means that transaction charges on the sender side are to be borne by the creditor, transaction charges on the receiver side are to be borne by the debtor.
     * 
     */
    SHAR,

    /**
     * Charges are to be applied following the rules agreed in the service level and/or scheme.
     * 
     */
    SLEV;

    public String value() {
        return name();
    }

    public static ChargeBearerType1Code fromValue(String v) {
        return valueOf(v);
    }

}
