//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MandateClassification1Code 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * <p>
 * <pre>
 * &lt;simpleType name="MandateClassification1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIXE"/>
 *     &lt;enumeration value="USGB"/>
 *     &lt;enumeration value="VARI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MandateClassification1Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
@XmlEnum
public enum MandateClassification1Code {


    /**
     * Direct debit amount is fixed.
     * 
     */
    FIXE,

    /**
     * Direct debit amount is based on usage.
     * 
     */
    USGB,

    /**
     * Direct debit amount is variable.
     * 
     */
    VARI;

    public String value() {
        return name();
    }

    public static MandateClassification1Code fromValue(String v) {
        return valueOf(v);
    }

}
