//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Choice of mandate related information.
 * 
 * <p>MandateRelatedData2Choice complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="MandateRelatedData2Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="DrctDbtMndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}MandateRelatedInformation15" minOccurs="0"/>
 *         &lt;element name="CdtTrfMndt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}CreditTransferMandateData1" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateRelatedData2Choice", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "drctDbtMndt",
    "cdtTrfMndt"
})
public class MandateRelatedData2Choice {

    @XmlElement(name = "DrctDbtMndt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected MandateRelatedInformation15 drctDbtMndt;
    @XmlElement(name = "CdtTrfMndt", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected CreditTransferMandateData1 cdtTrfMndt;

    /**
     * 获取属性 drctDbtMndt 的值。
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedInformation15 }
     *     
     */
    public MandateRelatedInformation15 getDrctDbtMndt() {
        return drctDbtMndt;
    }

    /**
     * 设置属性 drctDbtMndt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedInformation15 }
     *     
     */
    public void setDrctDbtMndt(MandateRelatedInformation15 value) {
        this.drctDbtMndt = value;
    }

    /**
     * 获取属性 cdtTrfMndt 的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public CreditTransferMandateData1 getCdtTrfMndt() {
        return cdtTrfMndt;
    }

    /**
     * 设置属性 cdtTrfMndt 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public void setCdtTrfMndt(CreditTransferMandateData1 value) {
        this.cdtTrfMndt = value;
    }

}
