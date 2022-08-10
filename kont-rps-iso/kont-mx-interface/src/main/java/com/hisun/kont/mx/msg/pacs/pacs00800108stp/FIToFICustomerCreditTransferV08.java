//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108stp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FIToFICustomerCreditTransferV08 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FIToFICustomerCreditTransferV08">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}GroupHeader93__1"/>
 *         &lt;element name="CdtTrfTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CreditTransferTransaction39__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIToFICustomerCreditTransferV08", propOrder = {
    "grpHdr",
    "cdtTrfTxInf"
})
public class FIToFICustomerCreditTransferV08 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader931 grpHdr;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected CreditTransferTransaction391 cdtTrfTxInf;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader931 }
     *     
     */
    public GroupHeader931 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader931 }
     *     
     */
    public void setGrpHdr(GroupHeader931 value) {
        this.grpHdr = value;
    }

    /**
     * 获取cdtTrfTxInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferTransaction391 }
     *     
     */
    public CreditTransferTransaction391 getCdtTrfTxInf() {
        return cdtTrfTxInf;
    }

    /**
     * 设置cdtTrfTxInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferTransaction391 }
     *     
     */
    public void setCdtTrfTxInf(CreditTransferTransaction391 value) {
        this.cdtTrfTxInf = value;
    }

}
