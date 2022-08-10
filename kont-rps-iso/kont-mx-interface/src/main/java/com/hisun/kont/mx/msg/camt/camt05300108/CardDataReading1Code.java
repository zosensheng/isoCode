//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CardDataReading1Code的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="CardDataReading1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TAGC"/>
 *     &lt;enumeration value="PHYS"/>
 *     &lt;enumeration value="BRCD"/>
 *     &lt;enumeration value="MGST"/>
 *     &lt;enumeration value="CICC"/>
 *     &lt;enumeration value="DFLE"/>
 *     &lt;enumeration value="CTLS"/>
 *     &lt;enumeration value="ECTL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CardDataReading1Code")
@XmlEnum
public enum CardDataReading1Code {

    TAGC,
    PHYS,
    BRCD,
    MGST,
    CICC,
    DFLE,
    CTLS,
    ECTL;

    public String value() {
        return name();
    }

    public static CardDataReading1Code fromValue(String v) {
        return valueOf(v);
    }

}
