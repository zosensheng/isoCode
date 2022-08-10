//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:33 PM CST 
//


package com.hisun.kont.mx.msg.camt;

import com.hisun.kont.mx.msg.camt.camt05700106.NotificationToReceiveV06;

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
 *         &lt;element name="NtfctnToRcv" type="{urn:iso:std:iso:20022:tech:xsd:camt.057.001.06}NotificationToReceiveV06"/>
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
    "ntfctnToRcv"
})
public class Camt05700106 {

    @XmlElement(name = "NtfctnToRcv", required = true)
    protected NotificationToReceiveV06 ntfctnToRcv;

    /**
     * 获取ntfctnToRcv属性的值。
     * 
     * @return
     *     possible object is
     *     {@link NotificationToReceiveV06 }
     *     
     */
    public NotificationToReceiveV06 getNtfctnToRcv() {
        return ntfctnToRcv;
    }

    /**
     * 设置ntfctnToRcv属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationToReceiveV06 }
     *     
     */
    public void setNtfctnToRcv(NotificationToReceiveV06 value) {
        this.ntfctnToRcv = value;
    }

}
