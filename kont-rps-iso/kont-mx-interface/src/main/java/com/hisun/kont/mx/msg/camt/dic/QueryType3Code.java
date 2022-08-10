package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>QueryType3Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="QueryType3Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="ALLL"/>
 *     &lt;enumeration value="CHNG"/>
 *     &lt;enumeration value="MODF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QueryType3Code")
@XmlEnum
public enum QueryType3Code {


    /**
     * Specifies that the query requests that all matching items be returned.
     * 
     */
    ALLL,

    /**
     * Specifies that the query requests that only new matching items since the last similar query be returned.
     * 
     */
    CHNG,

    /**
     * Specifies that the query requests that only items that have changed since the last query be returned.
     * 
     */
    MODF;

    public String value() {
        return name();
    }

    public static QueryType3Code fromValue(String v) {
        return valueOf(v);
    }

}
