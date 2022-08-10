//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SequenceType3Code 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * <p>
 * <pre>
 * &lt;simpleType name="SequenceType3Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FRST"/>
 *     &lt;enumeration value="RCUR"/>
 *     &lt;enumeration value="FNAL"/>
 *     &lt;enumeration value="OOFF"/>
 *     &lt;enumeration value="RPRE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SequenceType3Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
@XmlEnum
public enum SequenceType3Code {


    /**
     * First collection of a series of direct debit instructions.
     * 
     */
    FRST,

    /**
     * Direct debit instruction where the debtor's authorisation is used for regular direct debit transactions initiated by the creditor.
     * 
     */
    RCUR,

    /**
     * Final collection of a series of direct debit instructions.
     * 
     */
    FNAL,

    /**
     * Direct debit instruction where the debtor's authorisation is used to initiate one single direct debit transaction.
     * 
     */
    OOFF,

    /**
     * Collection used to re-present previously reversed or returned direct debit transactions.
     * 
     */
    RPRE;

    public String value() {
        return name();
    }

    public static SequenceType3Code fromValue(String v) {
        return valueOf(v);
    }

}
