//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00100109;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentMethod3Code__1的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethod3Code__1">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CHK"/>
 *     &lt;enumeration value="TRF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethod3Code__1")
@XmlEnum
public enum PaymentMethod3Code1 {

    CHK,
    TRF;

    public String value() {
        return name();
    }

    public static PaymentMethod3Code1 fromValue(String v) {
        return valueOf(v);
    }

}
