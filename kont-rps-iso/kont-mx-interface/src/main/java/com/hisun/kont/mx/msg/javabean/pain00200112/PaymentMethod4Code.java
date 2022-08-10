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
 * <p>PaymentMethod4Code 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * <p>
 * <pre>
 * &lt;simpleType name="PaymentMethod4Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CHK"/>
 *     &lt;enumeration value="TRF"/>
 *     &lt;enumeration value="DD"/>
 *     &lt;enumeration value="TRA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PaymentMethod4Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
@XmlEnum
public enum PaymentMethod4Code {


    /**
     * Written order to a bank to pay a certain amount of money from one person to another person.
     * 
     */
    CHK,

    /**
     * Transfer of an amount of money in the books of the account servicer.
     * 
     */
    TRF,

    /**
     * Collection of an amount of money from the debtor's bank account by the creditor. The amount of money and dates of collections may vary.
     * 
     */
    DD,

    /**
     * Transfer of an amount of money in the books of the account servicer. An advice should be sent back to the account owner.
     * 
     */
    TRA;

    public String value() {
        return name();
    }

    public static PaymentMethod4Code fromValue(String v) {
        return valueOf(v);
    }

}
