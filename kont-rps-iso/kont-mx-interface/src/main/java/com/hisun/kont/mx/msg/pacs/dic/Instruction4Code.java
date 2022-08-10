package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Instruction4Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="Instruction4Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="PHOA"/>
 *     &lt;enumeration value="TELA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Instruction4Code")
@XmlEnum
public enum Instruction4Code {


    /**
     * Please advise/contact next agent by phone.
     * 
     */
    PHOA,

    /**
     * Please advise/contact next agent by the most efficient means of telecommunication.
     * 
     */
    TELA;

    public String value() {
        return name();
    }

    public static Instruction4Code fromValue(String v) {
        return valueOf(v);
    }

}
