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
 * <p>OnLineCapability1Code的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="OnLineCapability1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="OFLN"/>
 *     &lt;enumeration value="ONLN"/>
 *     &lt;enumeration value="SMON"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OnLineCapability1Code")
@XmlEnum
public enum OnLineCapability1Code {

    OFLN,
    ONLN,
    SMON;

    public String value() {
        return name();
    }

    public static OnLineCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}
