//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Information needed due to regulatory and/or statutory requirements.
 * 
 * <p>RegulatoryReporting3 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="RegulatoryReporting3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DbtCdtRptgInd" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RegulatoryReportingType1Code" minOccurs="0"/>
 *         &lt;element name="Authrty" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}RegulatoryAuthority2" minOccurs="0"/>
 *         &lt;element name="Dtls" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}StructuredRegulatoryReporting3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegulatoryReporting3", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "dbtCdtRptgInd",
    "authrty",
    "dtls"
})
public class RegulatoryReporting3 {

    @XmlElement(name = "DbtCdtRptgInd", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    @XmlSchemaType(name = "string")
    protected RegulatoryReportingType1Code dbtCdtRptgInd;
    @XmlElement(name = "Authrty", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected RegulatoryAuthority2 authrty;
    @XmlElement(name = "Dtls", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<StructuredRegulatoryReporting3> dtls;

    /**
     * 获取属性 dbtCdtRptgInd 的值。
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public RegulatoryReportingType1Code getDbtCdtRptgInd() {
        return dbtCdtRptgInd;
    }

    /**
     * 设置属性 dbtCdtRptgInd 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryReportingType1Code }
     *     
     */
    public void setDbtCdtRptgInd(RegulatoryReportingType1Code value) {
        this.dbtCdtRptgInd = value;
    }

    /**
     * 获取属性 authrty 的值。
     * 
     * @return
     *     possible object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public RegulatoryAuthority2 getAuthrty() {
        return authrty;
    }

    /**
     * 设置属性 authrty 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RegulatoryAuthority2 }
     *     
     */
    public void setAuthrty(RegulatoryAuthority2 value) {
        this.authrty = value;
    }

    /**
     * Gets the value of the dtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StructuredRegulatoryReporting3 }
     * 
     * 
     */
    public List<StructuredRegulatoryReporting3> getDtls() {
        if (dtls == null) {
            dtls = new ArrayList<StructuredRegulatoryReporting3>();
        }
        return this.dtls;
    }

}
