//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:32 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05400108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>BankToCustomerDebitCreditNotificationV08 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="BankToCustomerDebitCreditNotificationV08">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}GroupHeader81__1"/>
 *         &lt;element name="Ntfctn" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}AccountNotification17__1" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankToCustomerDebitCreditNotificationV08",  propOrder = {
    "grpHdr",
    "ntfctn"
})
public class BankToCustomerDebitCreditNotificationV08 {

    @XmlElement(name = "GrpHdr",  required = true)
    protected GroupHeader811 grpHdr;
    @XmlElement(name = "Ntfctn",  required = true)
    protected List<AccountNotification171> ntfctn;

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
     * Gets the value of the ntfctn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ntfctn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNtfctn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountNotification171 }
     * 
     * 
     */
    public List<AccountNotification171> getNtfctn() {
        if (ntfctn == null) {
            ntfctn = new ArrayList<AccountNotification171>();
        }
        return this.ntfctn;
    }

}
