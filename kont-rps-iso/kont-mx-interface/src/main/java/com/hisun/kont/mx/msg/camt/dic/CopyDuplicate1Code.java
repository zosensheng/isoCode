package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CopyDuplicate1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CopyDuplicate1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="CODU"/>
 *     &lt;enumeration value="COPY"/>
 *     &lt;enumeration value="DUPL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CopyDuplicate1Code")
@XmlEnum
public enum CopyDuplicate1Code {


    /**
     * Message is being sent as a copy to a party other than the account owner, for information purposes and the message is a duplicate of a message previously sent.
     * 
     */
    CODU,

    /**
     * Message is being sent as a copy to a party other than the account owner, for information purposes.
     * 
     */
    COPY,

    /**
     * Message is for information/confirmation purposes. It is a duplicate of a message previously sent.
     * 
     */
    DUPL;

    public String value() {
        return name();
    }

    public static CopyDuplicate1Code fromValue(String v) {
        return valueOf(v);
    }

}
