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
 * <p>PointOfInteraction1__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PointOfInteraction1__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}GenericIdentification32__1"/>
 *         &lt;element name="SysNm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax70Text" minOccurs="0"/>
 *         &lt;element name="GrpId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text" minOccurs="0"/>
 *         &lt;element name="Cpblties" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PointOfInteractionCapabilities1" minOccurs="0"/>
 *         &lt;element name="Cmpnt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PointOfInteractionComponent1__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointOfInteraction1__1", propOrder = {
    "id",
    "sysNm",
    "grpId",
    "cpblties",
    "cmpnt"
})
public class PointOfInteraction11 {

    @XmlElement(name = "Id", required = true)
    protected GenericIdentification321 id;
    @XmlElement(name = "SysNm")
    protected String sysNm;
    @XmlElement(name = "GrpId")
    protected String grpId;
    @XmlElement(name = "Cpblties")
    protected PointOfInteractionCapabilities1 cpblties;
    @XmlElement(name = "Cmpnt")
    protected List<PointOfInteractionComponent11> cmpnt;

    /**
     * 获取id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link GenericIdentification321 }
     *     
     */
    public GenericIdentification321 getId() {
        return id;
    }

    /**
     * 设置id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIdentification321 }
     *     
     */
    public void setId(GenericIdentification321 value) {
        this.id = value;
    }

    /**
     * 获取sysNm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysNm() {
        return sysNm;
    }

    /**
     * 设置sysNm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysNm(String value) {
        this.sysNm = value;
    }

    /**
     * 获取grpId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrpId() {
        return grpId;
    }

    /**
     * 设置grpId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrpId(String value) {
        this.grpId = value;
    }

    /**
     * 获取cpblties属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PointOfInteractionCapabilities1 }
     *     
     */
    public PointOfInteractionCapabilities1 getCpblties() {
        return cpblties;
    }

    /**
     * 设置cpblties属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PointOfInteractionCapabilities1 }
     *     
     */
    public void setCpblties(PointOfInteractionCapabilities1 value) {
        this.cpblties = value;
    }

    /**
     * Gets the value of the cmpnt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmpnt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCmpnt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PointOfInteractionComponent11 }
     * 
     * 
     */
    public List<PointOfInteractionComponent11> getCmpnt() {
        if (cmpnt == null) {
            cmpnt = new ArrayList<PointOfInteractionComponent11>();
        }
        return this.cmpnt;
    }

}
