//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BranchAndFinancialInstitutionIdentification6__5 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BranchAndFinancialInstitutionIdentification6__5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FinInstnId" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}FinancialInstitutionIdentification18__4"/>
 *         &lt;element name="BrnchId" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchData3__2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchAndFinancialInstitutionIdentification6__5",  propOrder = {
    "finInstnId",
    "brnchId"
})
public class BranchAndFinancialInstitutionIdentification65 {

    @XmlElement(name = "FinInstnId",  required = true)
    protected FinancialInstitutionIdentification184 finInstnId;
    @XmlElement(name = "BrnchId")
    protected BranchData32 brnchId;

    /**
     * 获取finInstnId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionIdentification184 }
     *     
     */
    public FinancialInstitutionIdentification184 getFinInstnId() {
        return finInstnId;
    }

    /**
     * 设置finInstnId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionIdentification184 }
     *     
     */
    public void setFinInstnId(FinancialInstitutionIdentification184 value) {
        this.finInstnId = value;
    }

    /**
     * 获取brnchId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchData32 }
     *     
     */
    public BranchData32 getBrnchId() {
        return brnchId;
    }

    /**
     * 设置brnchId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchData32 }
     *     
     */
    public void setBrnchId(BranchData32 value) {
        this.brnchId = value;
    }

}
