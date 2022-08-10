package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PreferredContactMethod1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="PreferredContactMethod1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="LETT"/>
 *     &lt;enumeration value="MAIL"/>
 *     &lt;enumeration value="PHON"/>
 *     &lt;enumeration value="FAXX"/>
 *     &lt;enumeration value="CELL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PreferredContactMethod1Code")
@XmlEnum
public enum PreferredContactMethod1Code {


    /**
     * Preferred method used to reach the contact is per letter.
     * 
     */
    LETT,

    /**
     * Preferred method used to reach the contact is per email.
     * 
     */
    MAIL,

    /**
     * Preferred method used to reach the contact is per phone.
     * 
     */
    PHON,

    /**
     * Preferred method used to reach the contact is per fax.
     * 
     */
    FAXX,

    /**
     * Preferred method used to reach the contact is per mobile or cell phone.
     * 
     */
    CELL;

    public String value() {
        return name();
    }

    public static PreferredContactMethod1Code fromValue(String v) {
        return valueOf(v);
    }

}
