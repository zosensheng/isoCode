package com.hisun.kont.mx.msg.camt.dic;


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

    FRST,
    RCUR,
    FNAL,
    OOFF,
    RPRE;

    public String value() {
        return name();
    }

    public static SequenceType3Code fromValue(String v) {
        return valueOf(v);
    }

}
