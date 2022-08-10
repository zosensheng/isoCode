//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EntryDetails9__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EntryDetails9__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Btch" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}BatchInformation2__1" minOccurs="0"/>
 *         &lt;element name="TxDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}EntryTransaction10__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryDetails9__1", propOrder = {
    "btch",
    "txDtls"
})
public class EntryDetails91 {

    @XmlElement(name = "Btch")
    protected BatchInformation21 btch;
    @XmlElement(name = "TxDtls", required = true)
    protected EntryTransaction101 txDtls;

    /**
     * 获取btch属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatchInformation21 }
     *     
     */
    public BatchInformation21 getBtch() {
        return btch;
    }

    /**
     * 设置btch属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatchInformation21 }
     *     
     */
    public void setBtch(BatchInformation21 value) {
        this.btch = value;
    }

    /**
     * 获取txDtls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EntryTransaction101 }
     *     
     */
    public EntryTransaction101 getTxDtls() {
        return txDtls;
    }

    /**
     * 设置txDtls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EntryTransaction101 }
     *     
     */
    public void setTxDtls(EntryTransaction101 value) {
        this.txDtls = value;
    }

}
