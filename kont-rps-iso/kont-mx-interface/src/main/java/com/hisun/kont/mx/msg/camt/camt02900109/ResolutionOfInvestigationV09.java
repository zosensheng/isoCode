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
 * <p>ResolutionOfInvestigationV09 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ResolutionOfInvestigationV09">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Assgnmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CaseAssignment5__1"/>
 *         &lt;element name="Sts" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}InvestigationStatus5Choice__1"/>
 *         &lt;element name="CxlDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}UnderlyingTransaction22__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResolutionOfInvestigationV09", propOrder = {
    "assgnmt",
    "sts",
    "cxlDtls"
})
public class ResolutionOfInvestigationV09 {

    @XmlElement(name = "Assgnmt", required = true)
    protected CaseAssignment51 assgnmt;
    @XmlElement(name = "Sts", required = true)
    protected InvestigationStatus5Choice1 sts;
    @XmlElement(name = "CxlDtls", required = true)
    protected UnderlyingTransaction221 cxlDtls;

    /**
     * 获取assgnmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CaseAssignment51 }
     *     
     */
    public CaseAssignment51 getAssgnmt() {
        return assgnmt;
    }

    /**
     * 设置assgnmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CaseAssignment51 }
     *     
     */
    public void setAssgnmt(CaseAssignment51 value) {
        this.assgnmt = value;
    }

    /**
     * 获取sts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link InvestigationStatus5Choice1 }
     *     
     */
    public InvestigationStatus5Choice1 getSts() {
        return sts;
    }

    /**
     * 设置sts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link InvestigationStatus5Choice1 }
     *     
     */
    public void setSts(InvestigationStatus5Choice1 value) {
        this.sts = value;
    }

    /**
     * 获取cxlDtls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UnderlyingTransaction221 }
     *     
     */
    public UnderlyingTransaction221 getCxlDtls() {
        return cxlDtls;
    }

    /**
     * 设置cxlDtls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UnderlyingTransaction221 }
     *     
     */
    public void setCxlDtls(UnderlyingTransaction221 value) {
        this.cxlDtls = value;
    }

}
