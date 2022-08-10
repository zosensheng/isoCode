//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:35 PM CST 
//


package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.mx.msg.pacs.pacs00200110.FIToFIPaymentStatusReportV10;

import javax.xml.bind.annotation.*;


/**
 * <p>Document complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIToFIPmtStsRpt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10}FIToFIPaymentStatusReportV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "fiToFIPmtStsRpt"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10")
public class Pacs00200110 {

    @XmlElement(name = "FIToFIPmtStsRpt", required = true)
    protected FIToFIPaymentStatusReportV10 fiToFIPmtStsRpt;

    /**
     * 获取fiToFIPmtStsRpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link FIToFIPaymentStatusReportV10 }
     *     
     */
    public FIToFIPaymentStatusReportV10 getFIToFIPmtStsRpt() {
        return fiToFIPmtStsRpt;
    }

    /**
     * 设置fiToFIPmtStsRpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFIPaymentStatusReportV10 }
     *     
     */
    public void setFIToFIPmtStsRpt(FIToFIPaymentStatusReportV10 value) {
        this.fiToFIPmtStsRpt = value;
    }

}
