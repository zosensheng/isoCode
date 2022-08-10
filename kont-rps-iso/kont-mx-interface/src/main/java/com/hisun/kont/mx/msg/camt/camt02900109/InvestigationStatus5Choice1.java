//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt02900109;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InvestigationStatus5Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="InvestigationStatus5Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Conf" type="{urn:iso:std:iso:20022:tech:xsd:camt.029.001.09}CBPR_CancellationStatus"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvestigationStatus5Choice__1", propOrder = {
    "conf"
})
public class InvestigationStatus5Choice1 {

    @XmlElement(name = "Conf")
    @XmlSchemaType(name = "string")
    protected CBPRCancellationStatus conf;

    /**
     * 获取conf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CBPRCancellationStatus }
     *     
     */
    public CBPRCancellationStatus getConf() {
        return conf;
    }

    /**
     * 设置conf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CBPRCancellationStatus }
     *     
     */
    public void setConf(CBPRCancellationStatus value) {
        this.conf = value;
    }

}
