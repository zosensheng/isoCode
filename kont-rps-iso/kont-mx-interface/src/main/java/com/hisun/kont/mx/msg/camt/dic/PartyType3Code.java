package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PartyType3Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="PartyType3Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="OPOI"/>
 *     &lt;enumeration value="MERC"/>
 *     &lt;enumeration value="ACCP"/>
 *     &lt;enumeration value="ITAG"/>
 *     &lt;enumeration value="ACQR"/>
 *     &lt;enumeration value="CISS"/>
 *     &lt;enumeration value="DLIS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PartyType3Code")
@XmlEnum
public enum PartyType3Code {


    /**
     * Point Of Interaction initiating the card payment transaction.
     * 
     */
    OPOI,

    /**
     * Merchant providing goods and service in the card payment transaction.
     * 
     */
    MERC,

    /**
     * Card acceptor, party accepting the card and presenting transaction data to the acquirer.
     * 
     */
    ACCP,

    /**
     * Party acting on behalf of other parties to process or forward data to other parties.
     * 
     */
    ITAG,

    /**
     * Entity acquiring card transactions.
     * 
     */
    ACQR,

    /**
     * Party that issues cards.
     * 
     */
    CISS,

    /**
     * Party to whom the card issuer delegates to authorise card payment transactions.
     * 
     */
    DLIS;

    public String value() {
        return name();
    }

    public static PartyType3Code fromValue(String v) {
        return valueOf(v);
    }

}
