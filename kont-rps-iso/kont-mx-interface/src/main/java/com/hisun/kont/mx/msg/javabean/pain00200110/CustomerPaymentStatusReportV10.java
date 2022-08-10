//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean.pain00200110;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CustomerPaymentStatusReportV10 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerPaymentStatusReportV10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}GroupHeader86__1"/>
 *         &lt;element name="OrgnlGrpInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}OriginalGroupHeader17__1"/>
 *         &lt;element name="OrgnlPmtInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}OriginalPaymentInstruction32__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPaymentStatusReportV10", propOrder = {
    "grpHdr",
    "orgnlGrpInfAndSts",
    "orgnlPmtInfAndSts"
})
public class CustomerPaymentStatusReportV10 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader861 grpHdr;
    @XmlElement(name = "OrgnlGrpInfAndSts", required = true)
    protected OriginalGroupHeader171 orgnlGrpInfAndSts;
    @XmlElement(name = "OrgnlPmtInfAndSts", required = true)
    protected OriginalPaymentInstruction321 orgnlPmtInfAndSts;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader861 }
     *     
     */
    public GroupHeader861 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader861 }
     *     
     */
    public void setGrpHdr(GroupHeader861 value) {
        this.grpHdr = value;
    }

    /**
     * 获取orgnlGrpInfAndSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader171 }
     *     
     */
    public OriginalGroupHeader171 getOrgnlGrpInfAndSts() {
        return orgnlGrpInfAndSts;
    }

    /**
     * 设置orgnlGrpInfAndSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader171 }
     *     
     */
    public void setOrgnlGrpInfAndSts(OriginalGroupHeader171 value) {
        this.orgnlGrpInfAndSts = value;
    }

    /**
     * 获取orgnlPmtInfAndSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalPaymentInstruction321 }
     *     
     */
    public OriginalPaymentInstruction321 getOrgnlPmtInfAndSts() {
        return orgnlPmtInfAndSts;
    }

    /**
     * 设置orgnlPmtInfAndSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalPaymentInstruction321 }
     *     
     */
    public void setOrgnlPmtInfAndSts(OriginalPaymentInstruction321 value) {
        this.orgnlPmtInfAndSts = value;
    }

}
