package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Authorisation1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Authorisation1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="FDET"/>
 *     &lt;enumeration value="FSUM"/>
 *     &lt;enumeration value="ILEV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Authorisation1Code")
@XmlEnum
public enum Authorisation1Code {


    /**
     * Indicates a file has been pre authorised or approved within the originating customer environment and no further approval is required.
     * 
     */
    AUTH,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view both the payment information block and supporting customer credit transaction detail.
     * 
     */
    FDET,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view only the payment information block level information.
     * 
     */
    FSUM,

    /**
     * Indicates that a file requires all customer transactions to be authorised or approved.
     * 
     */
    ILEV;

    public String value() {
        return name();
    }

    public static Authorisation1Code fromValue(String v) {
        return valueOf(v);
    }

}
