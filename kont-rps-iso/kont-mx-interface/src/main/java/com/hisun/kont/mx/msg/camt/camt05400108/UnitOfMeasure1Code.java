//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UnitOfMeasure1Code的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasure1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PIEC"/>
 *     &lt;enumeration value="TONS"/>
 *     &lt;enumeration value="FOOT"/>
 *     &lt;enumeration value="GBGA"/>
 *     &lt;enumeration value="USGA"/>
 *     &lt;enumeration value="GRAM"/>
 *     &lt;enumeration value="INCH"/>
 *     &lt;enumeration value="KILO"/>
 *     &lt;enumeration value="PUND"/>
 *     &lt;enumeration value="METR"/>
 *     &lt;enumeration value="CMET"/>
 *     &lt;enumeration value="MMET"/>
 *     &lt;enumeration value="LITR"/>
 *     &lt;enumeration value="CELI"/>
 *     &lt;enumeration value="MILI"/>
 *     &lt;enumeration value="GBOU"/>
 *     &lt;enumeration value="USOU"/>
 *     &lt;enumeration value="GBQA"/>
 *     &lt;enumeration value="USQA"/>
 *     &lt;enumeration value="GBPI"/>
 *     &lt;enumeration value="USPI"/>
 *     &lt;enumeration value="MILE"/>
 *     &lt;enumeration value="KMET"/>
 *     &lt;enumeration value="YARD"/>
 *     &lt;enumeration value="SQKI"/>
 *     &lt;enumeration value="HECT"/>
 *     &lt;enumeration value="ARES"/>
 *     &lt;enumeration value="SMET"/>
 *     &lt;enumeration value="SCMT"/>
 *     &lt;enumeration value="SMIL"/>
 *     &lt;enumeration value="SQMI"/>
 *     &lt;enumeration value="SQYA"/>
 *     &lt;enumeration value="SQFO"/>
 *     &lt;enumeration value="SQIN"/>
 *     &lt;enumeration value="ACRE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasure1Code")
@XmlEnum
public enum UnitOfMeasure1Code {

    PIEC,
    TONS,
    FOOT,
    GBGA,
    USGA,
    GRAM,
    INCH,
    KILO,
    PUND,
    METR,
    CMET,
    MMET,
    LITR,
    CELI,
    MILI,
    GBOU,
    USOU,
    GBQA,
    USQA,
    GBPI,
    USPI,
    MILE,
    KMET,
    YARD,
    SQKI,
    HECT,
    ARES,
    SMET,
    SCMT,
    SMIL,
    SQMI,
    SQYA,
    SQFO,
    SQIN,
    ACRE;

    public String value() {
        return name();
    }

    public static UnitOfMeasure1Code fromValue(String v) {
        return valueOf(v);
    }

}
