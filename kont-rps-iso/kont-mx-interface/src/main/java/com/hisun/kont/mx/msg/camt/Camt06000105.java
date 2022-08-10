//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:34 PM CST 
//


package com.hisun.kont.mx.msg.camt;

import com.hisun.kont.mx.msg.camt.camt06000105.AccountReportingRequestV05;

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
 *         &lt;element name="AcctRptgReq" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}AccountReportingRequestV05"/>
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
    "acctRptgReq"
})
public class Camt06000105 {

    @XmlElement(name = "AcctRptgReq", required = true)
    protected AccountReportingRequestV05 acctRptgReq;

    /**
     * 获取acctRptgReq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountReportingRequestV05 }
     *     
     */
    public AccountReportingRequestV05 getAcctRptgReq() {
        return acctRptgReq;
    }

    /**
     * 设置acctRptgReq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountReportingRequestV05 }
     *     
     */
    public void setAcctRptgReq(AccountReportingRequestV05 value) {
        this.acctRptgReq = value;
    }

}
