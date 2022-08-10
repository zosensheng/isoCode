package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SequenceType3Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="SequenceType3Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="FRST"/>
 *     &lt;enumeration value="RCUR"/>
 *     &lt;enumeration value="FNAL"/>
 *     &lt;enumeration value="OOFF"/>
 *     &lt;enumeration value="RPRE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SequenceType3Code")
@XmlEnum
public enum SequenceType3Code {


    /**
     * First collection of a series of direct debit instructions.
     * 
     */
    FRST,

    /**
     * Direct debit instruction where the debtor's authorisation is used for regular direct debit transactions initiated by the creditor.
     * 
     */
    RCUR,

    /**
     * Final collection of a series of direct debit instructions.
     * 
     */
    FNAL,

    /**
     * Direct debit instruction where the debtor's authorisation is used to initiate one single direct debit transaction.
     * 
     */
    OOFF,

    /**
     * Collection used to re-present previously reversed or returned direct debit transactions.
     * 
     */
    RPRE;

    public String value() {
        return name();
    }

    public static SequenceType3Code fromValue(String v) {
        return valueOf(v);
    }

}
