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
 * <p>PaymentReturnReason5__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PaymentReturnReason5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OrgnlBkTxCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}BankTransactionCodeStructure4__1" minOccurs="0"/>
 *         &lt;element name="Orgtr" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}PartyIdentification135__4" minOccurs="0"/>
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}ReturnReason5Choice__1" minOccurs="0"/>
 *         &lt;element name="AddtlInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax105Text" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReturnReason5__1", propOrder = {
    "orgnlBkTxCd",
    "orgtr",
    "rsn",
    "addtlInf"
})
public class PaymentReturnReason51 {

    @XmlElement(name = "OrgnlBkTxCd")
    protected BankTransactionCodeStructure41 orgnlBkTxCd;
    @XmlElement(name = "Orgtr")
    protected PartyIdentification1354 orgtr;
    @XmlElement(name = "Rsn")
    protected ReturnReason5Choice1 rsn;
    @XmlElement(name = "AddtlInf")
    protected List<String> addtlInf;

    /**
     * 获取orgnlBkTxCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BankTransactionCodeStructure41 }
     *     
     */
    public BankTransactionCodeStructure41 getOrgnlBkTxCd() {
        return orgnlBkTxCd;
    }

    /**
     * 设置orgnlBkTxCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BankTransactionCodeStructure41 }
     *     
     */
    public void setOrgnlBkTxCd(BankTransactionCodeStructure41 value) {
        this.orgnlBkTxCd = value;
    }

    /**
     * 获取orgtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public PartyIdentification1354 getOrgtr() {
        return orgtr;
    }

    /**
     * 设置orgtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1354 }
     *     
     */
    public void setOrgtr(PartyIdentification1354 value) {
        this.orgtr = value;
    }

    /**
     * 获取rsn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReturnReason5Choice1 }
     *     
     */
    public ReturnReason5Choice1 getRsn() {
        return rsn;
    }

    /**
     * 设置rsn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnReason5Choice1 }
     *     
     */
    public void setRsn(ReturnReason5Choice1 value) {
        this.rsn = value;
    }

    /**
     * Gets the value of the addtlInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addtlInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddtlInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddtlInf() {
        if (addtlInf == null) {
            addtlInf = new ArrayList<String>();
        }
        return this.addtlInf;
    }

}
