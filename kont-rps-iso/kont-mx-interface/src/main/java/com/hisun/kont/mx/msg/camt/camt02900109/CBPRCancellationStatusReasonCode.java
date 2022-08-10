//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CBPR_CancellationStatusReasonCode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CBPR_CancellationStatusReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NOOR"/>
 *     &lt;enumeration value="NOAS"/>
 *     &lt;enumeration value="ARDT"/>
 *     &lt;enumeration value="CUST"/>
 *     &lt;enumeration value="AGNT"/>
 *     &lt;enumeration value="LEGL"/>
 *     &lt;enumeration value="AC04"/>
 *     &lt;enumeration value="AM04"/>
 *     &lt;enumeration value="PTNA"/>
 *     &lt;enumeration value="RQDA"/>
 *     &lt;enumeration value="INDM"/>
 *     &lt;enumeration value="NARR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CBPR_CancellationStatusReasonCode")
@XmlEnum
public enum CBPRCancellationStatusReasonCode {

    NOOR("NOOR"),
    NOAS("NOAS"),
    ARDT("ARDT"),
    CUST("CUST"),
    AGNT("AGNT"),
    LEGL("LEGL"),
    @XmlEnumValue("AC04")
    AC_04("AC04"),
    @XmlEnumValue("AM04")
    AM_04("AM04"),
    PTNA("PTNA"),
    RQDA("RQDA"),
    INDM("INDM"),
    NARR("NARR");
    private final String value;

    CBPRCancellationStatusReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CBPRCancellationStatusReasonCode fromValue(String v) {
        for (CBPRCancellationStatusReasonCode c: CBPRCancellationStatusReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
