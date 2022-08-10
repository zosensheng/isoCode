package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OnLineCapability1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="OnLineCapability1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="OFLN"/>
 *     &lt;enumeration value="ONLN"/>
 *     &lt;enumeration value="SMON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OnLineCapability1Code")
@XmlEnum
public enum OnLineCapability1Code {


    /**
     * Off-line only capable.
     * 
     */
    OFLN,

    /**
     * On-line only capable.
     * 
     */
    ONLN,

    /**
     * Off-line capable with possible on-line requests to the acquirer.
     * 
     */
    SMON;

    public String value() {
        return name();
    }

    public static OnLineCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}
