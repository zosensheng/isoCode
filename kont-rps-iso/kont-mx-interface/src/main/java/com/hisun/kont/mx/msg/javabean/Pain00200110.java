//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:40 PM CST 
//


package com.hisun.kont.mx.msg.javabean;

import com.hisun.kont.mx.msg.javabean.pain00200110.CustomerPaymentStatusReportV10;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="CstmrPmtStsRpt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.10}CustomerPaymentStatusReportV10"/>
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
    "cstmrPmtStsRpt"
})
public class Pain00200110 {

    @XmlElement(name = "CstmrPmtStsRpt", required = true)
    protected CustomerPaymentStatusReportV10 cstmrPmtStsRpt;

    /**
     * 获取cstmrPmtStsRpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentStatusReportV10 }
     *     
     */
    public CustomerPaymentStatusReportV10 getCstmrPmtStsRpt() {
        return cstmrPmtStsRpt;
    }

    /**
     * 设置cstmrPmtStsRpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentStatusReportV10 }
     *     
     */
    public void setCstmrPmtStsRpt(CustomerPaymentStatusReportV10 value) {
        this.cstmrPmtStsRpt = value;
    }

}
