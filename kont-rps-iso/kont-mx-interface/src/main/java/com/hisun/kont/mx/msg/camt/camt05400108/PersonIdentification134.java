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
 * <p>PersonIdentification13__4 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="PersonIdentification13__4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DtAndPlcOfBirth" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}DateAndPlaceOfBirth1__1" minOccurs="0"/>
 *         &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}GenericPersonIdentification1__3" maxOccurs="2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonIdentification13__4",  propOrder = {
    "dtAndPlcOfBirth",
    "othr"
})
public class PersonIdentification134 {

    @XmlElement(name = "DtAndPlcOfBirth")
    protected DateAndPlaceOfBirth11 dtAndPlcOfBirth;
    @XmlElement(name = "Othr")
    protected List<GenericPersonIdentification13> othr;

    /**
     * 获取dtAndPlcOfBirth属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DateAndPlaceOfBirth11 }
     *     
     */
    public DateAndPlaceOfBirth11 getDtAndPlcOfBirth() {
        return dtAndPlcOfBirth;
    }

    /**
     * 设置dtAndPlcOfBirth属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndPlaceOfBirth11 }
     *     
     */
    public void setDtAndPlcOfBirth(DateAndPlaceOfBirth11 value) {
        this.dtAndPlcOfBirth = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPersonIdentification13 }
     * 
     * 
     */
    public List<GenericPersonIdentification13> getOthr() {
        if (othr == null) {
            othr = new ArrayList<GenericPersonIdentification13>();
        }
        return this.othr;
    }

}
