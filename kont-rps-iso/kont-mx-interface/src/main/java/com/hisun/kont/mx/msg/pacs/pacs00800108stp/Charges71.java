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
 * <p>Charges7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Charges7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_Amount__1"/>
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}BranchAndFinancialInstitutionIdentification6__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Charges7__1", propOrder = {
    "amt",
    "agt"
})
public class Charges71 {

    @XmlElement(name = "Amt", required = true)
    protected CBPRAmount1 amt;
    @XmlElement(name = "Agt", required = true)
    protected BranchAndFinancialInstitutionIdentification61 agt;

    /**
     * 获取amt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRAmount1 }
     *     
     */
    public CBPRAmount1 getAmt() {
        return amt;
    }

    /**
     * 设置amt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRAmount1 }
     *     
     */
    public void setAmt(CBPRAmount1 value) {
        this.amt = value;
    }

    /**
     * 获取agt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification61 getAgt() {
        return agt;
    }

    /**
     * 设置agt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification61 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification61 value) {
        this.agt = value;
    }

}
