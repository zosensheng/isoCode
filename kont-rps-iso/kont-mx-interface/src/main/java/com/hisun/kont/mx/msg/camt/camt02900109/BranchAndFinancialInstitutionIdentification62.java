//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BranchAndFinancialInstitutionIdentification6__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BranchAndFinancialInstitutionIdentification6__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FinInstnId" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}FinancialInstitutionIdentification18__2"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchAndFinancialInstitutionIdentification6__2", propOrder = {
    "finInstnId"
})
public class BranchAndFinancialInstitutionIdentification62 {

    @XmlElement(name = "FinInstnId", required = true)
    protected FinancialInstitutionIdentification182 finInstnId;

    /**
     * 获取finInstnId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionIdentification182 }
     *     
     */
    public FinancialInstitutionIdentification182 getFinInstnId() {
        return finInstnId;
    }

    /**
     * 设置finInstnId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionIdentification182 }
     *     
     */
    public void setFinInstnId(FinancialInstitutionIdentification182 value) {
        this.finInstnId = value;
    }

}
