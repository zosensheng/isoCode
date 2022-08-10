//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108cov;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Document complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FICdtTrf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}FinancialInstitutionCreditTransferV08"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiCdtTrf"
})
public class Document {

    @XmlElement(name = "FICdtTrf", required = true)
    protected FinancialInstitutionCreditTransferV08 fiCdtTrf;

    /**
     * 获取fiCdtTrf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionCreditTransferV08 }
     *     
     */
    public FinancialInstitutionCreditTransferV08 getFICdtTrf() {
        return fiCdtTrf;
    }

    /**
     * 设置fiCdtTrf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionCreditTransferV08 }
     *     
     */
    public void setFICdtTrf(FinancialInstitutionCreditTransferV08 value) {
        this.fiCdtTrf = value;
    }

}
