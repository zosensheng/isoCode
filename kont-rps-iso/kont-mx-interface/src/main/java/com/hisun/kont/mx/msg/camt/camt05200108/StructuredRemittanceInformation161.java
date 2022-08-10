//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StructuredRemittanceInformation16__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StructuredRemittanceInformation16__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RfrdDocInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}ReferredDocumentInformation7__1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RfrdDocAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}RemittanceAmount2__1" minOccurs="0"/>
 *         &lt;element name="CdtrRefInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CreditorReferenceInformation2__1" minOccurs="0"/>
 *         &lt;element name="Invcr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PartyIdentification135__3" minOccurs="0"/>
 *         &lt;element name="Invcee" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PartyIdentification135__3" minOccurs="0"/>
 *         &lt;element name="TaxRmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}TaxInformation7__1" minOccurs="0"/>
 *         &lt;element name="GrnshmtRmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}Garnishment3__1" minOccurs="0"/>
 *         &lt;element name="AddtlRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax140Text_Extended" maxOccurs="3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRemittanceInformation16__1", propOrder = {
    "rfrdDocInf",
    "rfrdDocAmt",
    "cdtrRefInf",
    "invcr",
    "invcee",
    "taxRmt",
    "grnshmtRmt",
    "addtlRmtInf"
})
public class StructuredRemittanceInformation161 {

    @XmlElement(name = "RfrdDocInf")
    protected List<ReferredDocumentInformation71> rfrdDocInf;
    @XmlElement(name = "RfrdDocAmt")
    protected RemittanceAmount21 rfrdDocAmt;
    @XmlElement(name = "CdtrRefInf")
    protected CreditorReferenceInformation21 cdtrRefInf;
    @XmlElement(name = "Invcr")
    protected PartyIdentification1353 invcr;
    @XmlElement(name = "Invcee")
    protected PartyIdentification1353 invcee;
    @XmlElement(name = "TaxRmt")
    protected TaxInformation71 taxRmt;
    @XmlElement(name = "GrnshmtRmt")
    protected Garnishment31 grnshmtRmt;
    @XmlElement(name = "AddtlRmtInf")
    protected List<String> addtlRmtInf;

    /**
     * Gets the value of the rfrdDocInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rfrdDocInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRfrdDocInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferredDocumentInformation71 }
     * 
     * 
     */
    public List<ReferredDocumentInformation71> getRfrdDocInf() {
        if (rfrdDocInf == null) {
            rfrdDocInf = new ArrayList<ReferredDocumentInformation71>();
        }
        return this.rfrdDocInf;
    }

    /**
     * 获取rfrdDocAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RemittanceAmount21 }
     *     
     */
    public RemittanceAmount21 getRfrdDocAmt() {
        return rfrdDocAmt;
    }

    /**
     * 设置rfrdDocAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceAmount21 }
     *     
     */
    public void setRfrdDocAmt(RemittanceAmount21 value) {
        this.rfrdDocAmt = value;
    }

    /**
     * 获取cdtrRefInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceInformation21 }
     *     
     */
    public CreditorReferenceInformation21 getCdtrRefInf() {
        return cdtrRefInf;
    }

    /**
     * 设置cdtrRefInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceInformation21 }
     *     
     */
    public void setCdtrRefInf(CreditorReferenceInformation21 value) {
        this.cdtrRefInf = value;
    }

    /**
     * 获取invcr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public PartyIdentification1353 getInvcr() {
        return invcr;
    }

    /**
     * 设置invcr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public void setInvcr(PartyIdentification1353 value) {
        this.invcr = value;
    }

    /**
     * 获取invcee属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public PartyIdentification1353 getInvcee() {
        return invcee;
    }

    /**
     * 设置invcee属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1353 }
     *     
     */
    public void setInvcee(PartyIdentification1353 value) {
        this.invcee = value;
    }

    /**
     * 获取taxRmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxInformation71 }
     *     
     */
    public TaxInformation71 getTaxRmt() {
        return taxRmt;
    }

    /**
     * 设置taxRmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxInformation71 }
     *     
     */
    public void setTaxRmt(TaxInformation71 value) {
        this.taxRmt = value;
    }

    /**
     * 获取grnshmtRmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Garnishment31 }
     *     
     */
    public Garnishment31 getGrnshmtRmt() {
        return grnshmtRmt;
    }

    /**
     * 设置grnshmtRmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Garnishment31 }
     *     
     */
    public void setGrnshmtRmt(Garnishment31 value) {
        this.grnshmtRmt = value;
    }

    /**
     * Gets the value of the addtlRmtInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addtlRmtInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddtlRmtInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddtlRmtInf() {
        if (addtlRmtInf == null) {
            addtlRmtInf = new ArrayList<String>();
        }
        return this.addtlRmtInf;
    }

}
