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
 * <p>Authorisation1Code 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * <p>
 * <pre>
 * &lt;simpleType name="Authorisation1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUTH"/>
 *     &lt;enumeration value="FDET"/>
 *     &lt;enumeration value="FSUM"/>
 *     &lt;enumeration value="ILEV"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Authorisation1Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
@XmlEnum
public enum Authorisation1Code {


    /**
     * Indicates a file has been pre authorised or approved within the originating customer environment and no further approval is required.
     * 
     */
    AUTH,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view both the payment information block and supporting customer credit transaction detail.
     * 
     */
    FDET,

    /**
     * Indicates that a file requires additional file level approval, with the ability to view only the payment information block level information.
     * 
     */
    FSUM,

    /**
     * Indicates that a file requires all customer transactions to be authorised or approved.
     * 
     */
    ILEV;

    public String value() {
        return name();
    }

    public static Authorisation1Code fromValue(String v) {
        return valueOf(v);
    }

}
