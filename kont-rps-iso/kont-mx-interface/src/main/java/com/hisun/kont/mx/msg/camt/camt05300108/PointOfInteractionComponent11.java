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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PointOfInteractionComponent1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PointOfInteractionComponent1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POICmpntTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}POIComponentType1Code"/>
 *         &lt;element name="ManfctrId" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Mdl" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="VrsnNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax16Text" minOccurs="0"/>
 *         &lt;element name="SrlNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="ApprvlNb" type="{urn:iso:std:iso:20022:tech:xsd:camt.053.001.08}CBPR_RestrictedFINXMax70Text" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointOfInteractionComponent1__1", propOrder = {
    "poiCmpntTp",
    "manfctrId",
    "mdl",
    "vrsnNb",
    "srlNb",
    "apprvlNb"
})
public class PointOfInteractionComponent11 {

    @XmlElement(name = "POICmpntTp", required = true)
    @XmlSchemaType(name = "string")
    protected POIComponentType1Code poiCmpntTp;
    @XmlElement(name = "ManfctrId")
    protected String manfctrId;
    @XmlElement(name = "Mdl")
    protected String mdl;
    @XmlElement(name = "VrsnNb")
    protected String vrsnNb;
    @XmlElement(name = "SrlNb")
    protected String srlNb;
    @XmlElement(name = "ApprvlNb")
    protected List<String> apprvlNb;

    /**
     * 获取poiCmpntTp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link POIComponentType1Code }
     *     
     */
    public POIComponentType1Code getPOICmpntTp() {
        return poiCmpntTp;
    }

    /**
     * 设置poiCmpntTp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link POIComponentType1Code }
     *     
     */
    public void setPOICmpntTp(POIComponentType1Code value) {
        this.poiCmpntTp = value;
    }

    /**
     * 获取manfctrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManfctrId() {
        return manfctrId;
    }

    /**
     * 设置manfctrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManfctrId(String value) {
        this.manfctrId = value;
    }

    /**
     * 获取mdl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdl() {
        return mdl;
    }

    /**
     * 设置mdl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdl(String value) {
        this.mdl = value;
    }

    /**
     * 获取vrsnNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrsnNb() {
        return vrsnNb;
    }

    /**
     * 设置vrsnNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrsnNb(String value) {
        this.vrsnNb = value;
    }

    /**
     * 获取srlNb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrlNb() {
        return srlNb;
    }

    /**
     * 设置srlNb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrlNb(String value) {
        this.srlNb = value;
    }

    /**
     * Gets the value of the apprvlNb property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the apprvlNb property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApprvlNb().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getApprvlNb() {
        if (apprvlNb == null) {
            apprvlNb = new ArrayList<String>();
        }
        return this.apprvlNb;
    }

}
