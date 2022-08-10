package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionIndividualStatus1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="TransactionIndividualStatus1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="ACTC"/>
 *     &lt;enumeration value="RJCT"/>
 *     &lt;enumeration value="PDNG"/>
 *     &lt;enumeration value="ACCP"/>
 *     &lt;enumeration value="ACSP"/>
 *     &lt;enumeration value="ACSC"/>
 *     &lt;enumeration value="ACCR"/>
 *     &lt;enumeration value="ACWC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TransactionIndividualStatus1Code")
@XmlEnum
public enum TransactionIndividualStatus1Code {

    ACTC,
    RJCT,
    PDNG,
    ACCP,
    ACSP,
    ACSC,
    ACCR,
    ACWC;

    public String value() {
        return name();
    }

    public static TransactionIndividualStatus1Code fromValue(String v) {
        return valueOf(v);
    }

}
