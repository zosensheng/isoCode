//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.09 时间 10:49:45 AM CST
//


package com.hisun.kont.mx.msg.javabean.head00100102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Party44Choice complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="Party44Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="OrgId" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}PartyIdentification135"/>
 *         &lt;element name="FIId" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}BranchAndFinancialInstitutionIdentification6"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party44Choice", propOrder = {
    "orgId",
    "fiId"
})
public class Party44Choice {

    @XmlElement(name = "OrgId")
    protected PartyIdentification135 orgId;
    @XmlElement(name = "FIId")
    protected BranchAndFinancialInstitutionIdentification6 fiId;

    /**
     * 获取属性 orgId 的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification135 }
     *     
     */
    public PartyIdentification135 getOrgId() {
        return orgId;
    }

    /**
     * 设置属性 orgId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification135 }
     *     
     */
    public void setOrgId(PartyIdentification135 value) {
        this.orgId = value;
    }

    /**
     * 获取属性 fiId 的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getFIId() {
        return fiId;
    }

    /**
     * 设置属性 fiId 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setFIId(BranchAndFinancialInstitutionIdentification6 value) {
        this.fiId = value;
    }

}
