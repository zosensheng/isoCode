//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108cov;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DocumentType6Code的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentType6Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MSIN"/>
 *     &lt;enumeration value="CNFA"/>
 *     &lt;enumeration value="DNFA"/>
 *     &lt;enumeration value="CINV"/>
 *     &lt;enumeration value="CREN"/>
 *     &lt;enumeration value="DEBN"/>
 *     &lt;enumeration value="HIRI"/>
 *     &lt;enumeration value="SBIN"/>
 *     &lt;enumeration value="CMCN"/>
 *     &lt;enumeration value="SOAC"/>
 *     &lt;enumeration value="DISP"/>
 *     &lt;enumeration value="BOLD"/>
 *     &lt;enumeration value="VCHR"/>
 *     &lt;enumeration value="AROI"/>
 *     &lt;enumeration value="TSUT"/>
 *     &lt;enumeration value="PUOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocumentType6Code")
@XmlEnum
public enum DocumentType6Code {

    MSIN,
    CNFA,
    DNFA,
    CINV,
    CREN,
    DEBN,
    HIRI,
    SBIN,
    CMCN,
    SOAC,
    DISP,
    BOLD,
    VCHR,
    AROI,
    TSUT,
    PUOR;

    public String value() {
        return name();
    }

    public static DocumentType6Code fromValue(String v) {
        return valueOf(v);
    }

}
