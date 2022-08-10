package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MandateClassification1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="MandateClassification1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="FIXE"/>
 *     &lt;enumeration value="USGB"/>
 *     &lt;enumeration value="VARI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MandateClassification1Code")
@XmlEnum
public enum MandateClassification1Code {


    /**
     * Direct debit amount is fixed.
     * 
     */
    FIXE,

    /**
     * Direct debit amount is based on usage.
     * 
     */
    USGB,

    /**
     * Direct debit amount is variable.
     * 
     */
    VARI;

    public String value() {
        return name();
    }

    public static MandateClassification1Code fromValue(String v) {
        return valueOf(v);
    }

}
