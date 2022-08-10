//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardholderVerificationCapability1Code的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CardholderVerificationCapability1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MNSG"/>
 *     &lt;enumeration value="NPIN"/>
 *     &lt;enumeration value="FCPN"/>
 *     &lt;enumeration value="FEPN"/>
 *     &lt;enumeration value="FDSG"/>
 *     &lt;enumeration value="FBIO"/>
 *     &lt;enumeration value="MNVR"/>
 *     &lt;enumeration value="FBIG"/>
 *     &lt;enumeration value="APKI"/>
 *     &lt;enumeration value="PKIS"/>
 *     &lt;enumeration value="CHDT"/>
 *     &lt;enumeration value="SCEC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardholderVerificationCapability1Code")
@XmlEnum
public enum CardholderVerificationCapability1Code {

    MNSG,
    NPIN,
    FCPN,
    FEPN,
    FDSG,
    FBIO,
    MNVR,
    FBIG,
    APKI,
    PKIS,
    CHDT,
    SCEC;

    public String value() {
        return name();
    }

    public static CardholderVerificationCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}
