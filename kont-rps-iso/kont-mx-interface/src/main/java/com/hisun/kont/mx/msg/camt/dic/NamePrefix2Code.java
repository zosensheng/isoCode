package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NamePrefix2Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="NamePrefix2Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="DOCT"/>
 *     &lt;enumeration value="MADM"/>
 *     &lt;enumeration value="MISS"/>
 *     &lt;enumeration value="MIST"/>
 *     &lt;enumeration value="MIKS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NamePrefix2Code")
@XmlEnum
public enum NamePrefix2Code {


    /**
     * Title of the person is Doctor or Dr.
     * 
     */
    DOCT,

    /**
     * Title of the person is Madam.
     * 
     */
    MADM,

    /**
     * Title of the person is Miss.
     * 
     */
    MISS,

    /**
     * Title of the person is Mister or Mr.
     * 
     */
    MIST,

    /**
     * Title of the person is gender neutral (Mx).
     * 
     */
    MIKS;

    public String value() {
        return name();
    }

    public static NamePrefix2Code fromValue(String v) {
        return valueOf(v);
    }

}
