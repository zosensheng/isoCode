//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05300108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TaxRecord2__2 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TaxRecord2__2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Ctgy" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="CtgyDtls" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="DbtrSts" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="CertId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="FrmsCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Prd" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}TaxPeriod2" minOccurs="0"/>
 *         &lt;element name="TaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}TaxAmount2" minOccurs="0"/>
 *         &lt;element name="AddtlInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}RestrictedFINXMax140Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxRecord2__2", propOrder = {
    "tp",
    "ctgy",
    "ctgyDtls",
    "dbtrSts",
    "certId",
    "frmsCd",
    "prd",
    "taxAmt",
    "addtlInf"
})
public class TaxRecord22 {

    @XmlElement(name = "Tp")
    protected String tp;
    @XmlElement(name = "Ctgy")
    protected String ctgy;
    @XmlElement(name = "CtgyDtls")
    protected String ctgyDtls;
    @XmlElement(name = "DbtrSts")
    protected String dbtrSts;
    @XmlElement(name = "CertId")
    protected String certId;
    @XmlElement(name = "FrmsCd")
    protected String frmsCd;
    @XmlElement(name = "Prd")
    protected TaxPeriod2 prd;
    @XmlElement(name = "TaxAmt")
    protected TaxAmount2 taxAmt;
    @XmlElement(name = "AddtlInf")
    protected String addtlInf;

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTp(String value) {
        this.tp = value;
    }

    /**
     * 获取ctgy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtgy() {
        return ctgy;
    }

    /**
     * 设置ctgy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtgy(String value) {
        this.ctgy = value;
    }

    /**
     * 获取ctgyDtls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtgyDtls() {
        return ctgyDtls;
    }

    /**
     * 设置ctgyDtls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtgyDtls(String value) {
        this.ctgyDtls = value;
    }

    /**
     * 获取dbtrSts属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDbtrSts() {
        return dbtrSts;
    }

    /**
     * 设置dbtrSts属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDbtrSts(String value) {
        this.dbtrSts = value;
    }

    /**
     * 获取certId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertId() {
        return certId;
    }

    /**
     * 设置certId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertId(String value) {
        this.certId = value;
    }

    /**
     * 获取frmsCd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrmsCd() {
        return frmsCd;
    }

    /**
     * 设置frmsCd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrmsCd(String value) {
        this.frmsCd = value;
    }

    /**
     * 获取prd属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxPeriod2 }
     *     
     */
    public TaxPeriod2 getPrd() {
        return prd;
    }

    /**
     * 设置prd属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxPeriod2 }
     *     
     */
    public void setPrd(TaxPeriod2 value) {
        this.prd = value;
    }

    /**
     * 获取taxAmt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link TaxAmount2 }
     *     
     */
    public TaxAmount2 getTaxAmt() {
        return taxAmt;
    }

    /**
     * 设置taxAmt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link TaxAmount2 }
     *     
     */
    public void setTaxAmt(TaxAmount2 value) {
        this.taxAmt = value;
    }

    /**
     * 获取addtlInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlInf() {
        return addtlInf;
    }

    /**
     * 设置addtlInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlInf(String value) {
        this.addtlInf = value;
    }

}
