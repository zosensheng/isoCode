//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05600108;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CBPR_CancellationReasonCode的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CBPR_CancellationReasonCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DUPL"/>
 *     &lt;enumeration value="CUTA"/>
 *     &lt;enumeration value="UPAY"/>
 *     &lt;enumeration value="CUST"/>
 *     &lt;enumeration value="CURR"/>
 *     &lt;enumeration value="AGNT"/>
 *     &lt;enumeration value="TECH"/>
 *     &lt;enumeration value="FRAD"/>
 *     &lt;enumeration value="COVR"/>
 *     &lt;enumeration value="AM09"/>
 *     &lt;enumeration value="NARR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CBPR_CancellationReasonCode")
@XmlEnum
public enum CBPRCancellationReasonCode {

    DUPL("DUPL"),
    CUTA("CUTA"),
    UPAY("UPAY"),
    CUST("CUST"),
    CURR("CURR"),
    AGNT("AGNT"),
    TECH("TECH"),
    FRAD("FRAD"),
    COVR("COVR"),
    @XmlEnumValue("AM09")
    AM_09("AM09"),
    NARR("NARR");
    private final String value;

    CBPRCancellationReasonCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CBPRCancellationReasonCode fromValue(String v) {
        for (CBPRCancellationReasonCode c: CBPRCancellationReasonCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
