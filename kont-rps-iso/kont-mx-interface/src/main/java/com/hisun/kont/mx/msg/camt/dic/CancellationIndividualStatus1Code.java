package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CancellationIndividualStatus1Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="CancellationIndividualStatus1Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="RJCR"/>
 *     &lt;enumeration value="ACCR"/>
 *     &lt;enumeration value="PDCR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CancellationIndividualStatus1Code")
@XmlEnum
public enum CancellationIndividualStatus1Code {

    RJCR,
    ACCR,
    PDCR;

    public String value() {
        return name();
    }

    public static CancellationIndividualStatus1Code fromValue(String v) {
        return valueOf(v);
    }

}
