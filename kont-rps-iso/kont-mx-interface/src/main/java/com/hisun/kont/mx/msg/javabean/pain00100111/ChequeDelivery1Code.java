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
 * <p>ChequeDelivery1Code 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * <p>
 * <pre>
 * &lt;simpleType name="ChequeDelivery1Code">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MLDB"/>
 *     &lt;enumeration value="MLCD"/>
 *     &lt;enumeration value="MLFA"/>
 *     &lt;enumeration value="CRDB"/>
 *     &lt;enumeration value="CRCD"/>
 *     &lt;enumeration value="CRFA"/>
 *     &lt;enumeration value="PUDB"/>
 *     &lt;enumeration value="PUCD"/>
 *     &lt;enumeration value="PUFA"/>
 *     &lt;enumeration value="RGDB"/>
 *     &lt;enumeration value="RGCD"/>
 *     &lt;enumeration value="RGFA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChequeDelivery1Code", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
@XmlEnum
public enum ChequeDelivery1Code {


    /**
     * Cheque is to be sent through mail services to debtor.
     * 
     */
    MLDB,

    /**
     * Cheque is to be sent through mail services to creditor.
     * 
     */
    MLCD,

    /**
     * Cheque is to be sent through mail services to creditor agent.
     * 
     */
    MLFA,

    /**
     * Cheque is to be sent through courier services to debtor.
     * 
     */
    CRDB,

    /**
     * Cheque is to be sent through courier services to creditor.
     * 
     */
    CRCD,

    /**
     * Cheque is to be sent through courier services to creditor agent.
     * 
     */
    CRFA,

    /**
     * Cheque will be picked up by the debtor.
     * 
     */
    PUDB,

    /**
     * Cheque will be picked up by the creditor.
     * 
     */
    PUCD,

    /**
     * Cheque will be picked up by the creditor agent.
     * 
     */
    PUFA,

    /**
     * Cheque is to be sent through registered mail services to debtor.
     * 
     */
    RGDB,

    /**
     * Cheque is to be sent through registered mail services to creditor.
     * 
     */
    RGCD,

    /**
     * Cheque is to be sent through registered mail services to creditor agent.
     * 
     */
    RGFA;

    public String value() {
        return name();
    }

    public static ChequeDelivery1Code fromValue(String v) {
        return valueOf(v);
    }

}
