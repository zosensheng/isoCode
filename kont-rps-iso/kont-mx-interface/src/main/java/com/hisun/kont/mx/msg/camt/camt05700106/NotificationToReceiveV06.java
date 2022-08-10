//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:33 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05700106;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NotificationToReceiveV06 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="NotificationToReceiveV06">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}GroupHeader77__1"/>
 *         &lt;element name="Ntfctn" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}AccountNotification16__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotificationToReceiveV06", propOrder = {
    "grpHdr",
    "ntfctn"
})
public class NotificationToReceiveV06 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader771 grpHdr;
    @XmlElement(name = "Ntfctn", required = true)
    protected AccountNotification161 ntfctn;

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
     * 获取ntfctn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AccountNotification161 }
     *     
     */
    public AccountNotification161 getNtfctn() {
        return ntfctn;
    }

    /**
     * 设置ntfctn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AccountNotification161 }
     *     
     */
    public void setNtfctn(AccountNotification161 value) {
        this.ntfctn = value;
    }

}
