package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SettlementMethod1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="SettlementMethod1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="INDA"/>
 *     &lt;enumeration value="INGA"/>
 *     &lt;enumeration value="COVE"/>
 *     &lt;enumeration value="CLRG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SettlementMethod1Code")
@XmlEnum
public enum SettlementMethod1Code {


    /**
     * Settlement is done by the agent instructed to execute a payment instruction.
     * 
     */
    INDA,

    /**
     * Settlement is done by the agent instructing and forwarding the payment to the next party in the payment chain.
     * 
     */
    INGA,

    /**
     * Settlement is done through a cover payment.
     * 
     */
    COVE,

    /**
     * Settlement is done through a payment clearing system.
     * 
     */
    CLRG;

    public String value() {
        return name();
    }

    public static SettlementMethod1Code fromValue(String v) {
        return valueOf(v);
    }

}
