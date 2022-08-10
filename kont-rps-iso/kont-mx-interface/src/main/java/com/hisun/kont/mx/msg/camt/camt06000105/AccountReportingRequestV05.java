//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:34 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt06000105;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>AccountReportingRequestV05 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="AccountReportingRequestV05">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}GroupHeader77__1"/>
 *         &lt;element name="RptgReq" type="{urn:iso:std:iso:20022:tech:xsd:camt.060.001.05}ReportingRequest5__1" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccountReportingRequestV05", propOrder = {
    "grpHdr",
    "rptgReq"
})
public class AccountReportingRequestV05 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader771 grpHdr;
    @XmlElement(name = "RptgReq", required = true)
    protected List<ReportingRequest51> rptgReq;

    /**
     * 获取grpHdr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader771 }
     *     
     */
    public GroupHeader771 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置grpHdr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader771 }
     *     
     */
    public void setGrpHdr(GroupHeader771 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the rptgReq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rptgReq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRptgReq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportingRequest51 }
     * 
     * 
     */
    public List<ReportingRequest51> getRptgReq() {
        if (rptgReq == null) {
            rptgReq = new ArrayList<ReportingRequest51>();
        }
        return this.rptgReq;
    }

}
