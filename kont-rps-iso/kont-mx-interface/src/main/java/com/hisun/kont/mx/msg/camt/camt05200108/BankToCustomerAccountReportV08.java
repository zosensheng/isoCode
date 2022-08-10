//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BankToCustomerAccountReportV08 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BankToCustomerAccountReportV08">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}GroupHeader81__1"/>
 *         &lt;element name="Rpt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}AccountReport25__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankToCustomerAccountReportV08", propOrder = {
    "grpHdr",
    "rpt"
})
public class BankToCustomerAccountReportV08 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader811 grpHdr;
    @XmlElement(name = "Rpt", required = true)
    protected AccountReport251 rpt;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader811 }
     *     
     */
    public GroupHeader811 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader811 }
     *     
     */
    public void setGrpHdr(GroupHeader811 value) {
        this.grpHdr = value;
    }

    /**
     * 获取rpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountReport251 }
     *     
     */
    public AccountReport251 getRpt() {
        return rpt;
    }

    /**
     * 设置rpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountReport251 }
     *     
     */
    public void setRpt(AccountReport251 value) {
        this.rpt = value;
    }

}
