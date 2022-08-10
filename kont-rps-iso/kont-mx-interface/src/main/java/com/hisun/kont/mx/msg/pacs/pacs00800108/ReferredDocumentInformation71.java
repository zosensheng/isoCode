//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00800108;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ReferredDocumentInformation7__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ReferredDocumentInformation7__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ReferredDocumentType4__1" minOccurs="0"/>
 *         &lt;element name="Nb" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}CBPR_RestrictedFINXMax35Text_Extended" minOccurs="0"/>
 *         &lt;element name="RltdDt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}ISODate" minOccurs="0"/>
 *         &lt;element name="LineDtls" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}DocumentLineInformation1__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferredDocumentInformation7__1", propOrder = {
    "tp",
    "nb",
    "rltdDt",
    "lineDtls"
})
public class ReferredDocumentInformation71 {

    @XmlElement(name = "Tp")
    protected ReferredDocumentType41 tp;
    @XmlElement(name = "Nb")
    protected String nb;
    @XmlElement(name = "RltdDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rltdDt;
    @XmlElement(name = "LineDtls")
    protected List<DocumentLineInformation11> lineDtls;

    /**
     * 获取tp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ReferredDocumentType41 }
     *     
     */
    public ReferredDocumentType41 getTp() {
        return tp;
    }

    /**
     * 设置tp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ReferredDocumentType41 }
     *     
     */
    public void setTp(ReferredDocumentType41 value) {
        this.tp = value;
    }

    /**
     * 获取nb属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNb() {
        return nb;
    }

    /**
     * 设置nb属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNb(String value) {
        this.nb = value;
    }

    /**
     * 获取rltdDt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRltdDt() {
        return rltdDt;
    }

    /**
     * 设置rltdDt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRltdDt(XMLGregorianCalendar value) {
        this.rltdDt = value;
    }

    /**
     * Gets the value of the lineDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentLineInformation11 }
     * 
     * 
     */
    public List<DocumentLineInformation11> getLineDtls() {
        if (lineDtls == null) {
            lineDtls = new ArrayList<DocumentLineInformation11>();
        }
        return this.lineDtls;
    }

}
