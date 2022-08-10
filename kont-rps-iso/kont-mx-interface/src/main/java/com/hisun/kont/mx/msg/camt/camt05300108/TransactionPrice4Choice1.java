//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TransactionPrice4Choice__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionPrice4Choice__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="DealPric" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}Price7"/>
 *         &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ProprietaryPrice2__1" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionPrice4Choice__1", propOrder = {
    "dealPric",
    "prtry"
})
public class TransactionPrice4Choice1 {

    @XmlElement(name = "DealPric")
    protected Price7 dealPric;
    @XmlElement(name = "Prtry")
    protected List<ProprietaryPrice21> prtry;

    /**
     * 获取dealPric属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Price7 }
     *     
     */
    public Price7 getDealPric() {
        return dealPric;
    }

    /**
     * 设置dealPric属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Price7 }
     *     
     */
    public void setDealPric(Price7 value) {
        this.dealPric = value;
    }

    /**
     * Gets the value of the prtry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prtry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrtry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProprietaryPrice21 }
     * 
     * 
     */
    public List<ProprietaryPrice21> getPrtry() {
        if (prtry == null) {
            prtry = new ArrayList<ProprietaryPrice21>();
        }
        return this.prtry;
    }

}
