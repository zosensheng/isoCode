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
 * <p>EntryDetails9__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="EntryDetails9__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Btch" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BatchInformation2__1" minOccurs="0"/>
 *         &lt;element name="TxDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}EntryTransaction10__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryDetails9__1",  propOrder = {
    "btch",
    "txDtls"
})
public class EntryDetails91 {

    @XmlElement(name = "Btch")
    protected BatchInformation21 btch;
    @XmlElement(name = "TxDtls")
    protected List<EntryTransaction101> txDtls;

    /**
     * 获取btch属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BatchInformation21 }
     *     
     */
    public BatchInformation21 getBtch() {
        return btch;
    }

    /**
     * 设置btch属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BatchInformation21 }
     *     
     */
    public void setBtch(BatchInformation21 value) {
        this.btch = value;
    }

    /**
     * Gets the value of the txDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryTransaction101 }
     * 
     * 
     */
    public List<EntryTransaction101> getTxDtls() {
        if (txDtls == null) {
            txDtls = new ArrayList<EntryTransaction101>();
        }
        return this.txDtls;
    }

}
