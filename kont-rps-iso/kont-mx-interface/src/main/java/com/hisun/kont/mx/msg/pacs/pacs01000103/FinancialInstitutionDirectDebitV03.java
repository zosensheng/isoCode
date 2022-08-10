//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:39 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs01000103;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>FinancialInstitutionDirectDebitV03 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionDirectDebitV03">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}GroupHeader92__1"/>
 *         &lt;element name="CdtInstr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.010.001.03}CreditTransferTransaction38__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionDirectDebitV03", propOrder = {
    "grpHdr",
    "cdtInstr"
})
public class FinancialInstitutionDirectDebitV03 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader921 grpHdr;
    @XmlElement(name = "CdtInstr", required = true)
    protected CreditTransferTransaction381 cdtInstr;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader921 }
     *     
     */
    public GroupHeader921 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader921 }
     *     
     */
    public void setGrpHdr(GroupHeader921 value) {
        this.grpHdr = value;
    }

    /**
     * 获取cdtInstr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferTransaction381 }
     *     
     */
    public CreditTransferTransaction381 getCdtInstr() {
        return cdtInstr;
    }

    /**
     * 设置cdtInstr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferTransaction381 }
     *     
     */
    public void setCdtInstr(CreditTransferTransaction381 value) {
        this.cdtInstr = value;
    }

}
