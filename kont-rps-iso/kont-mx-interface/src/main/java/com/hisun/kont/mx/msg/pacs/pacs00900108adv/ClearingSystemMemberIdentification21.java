//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:38 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108adv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ClearingSystemMemberIdentification2__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ClearingSystemMemberIdentification2__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClrSysId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}ClearingSystemIdentification2Choice__1"/>
 *         &lt;element name="MmbId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax28Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClearingSystemMemberIdentification2__1", propOrder = {
    "clrSysId",
    "mmbId"
})
public class ClearingSystemMemberIdentification21 {

    @XmlElement(name = "ClrSysId", required = true)
    protected ClearingSystemIdentification2Choice1 clrSysId;
    @XmlElement(name = "MmbId", required = true)
    protected String mmbId;

    /**
     * 获取clrSysId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemIdentification2Choice1 }
     *     
     */
    public ClearingSystemIdentification2Choice1 getClrSysId() {
        return clrSysId;
    }

    /**
     * 设置clrSysId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemIdentification2Choice1 }
     *     
     */
    public void setClrSysId(ClearingSystemIdentification2Choice1 value) {
        this.clrSysId = value;
    }

    /**
     * 获取mmbId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMmbId() {
        return mmbId;
    }

    /**
     * 设置mmbId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMmbId(String value) {
        this.mmbId = value;
    }

}
