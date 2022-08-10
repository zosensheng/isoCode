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
 * <p>TransactionAgents5__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="TransactionAgents5__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InstgAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="InstdAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__8" minOccurs="0"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt1" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt2" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="IntrmyAgt3" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="RcvgAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="DlvrgAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="IssgAgt" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="SttlmPlc" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}BranchAndFinancialInstitutionIdentification6__5" minOccurs="0"/>
 *         &lt;element name="Prtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.054.001.08}ProprietaryAgent4__1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionAgents5__1",  propOrder = {
    "instgAgt",
    "instdAgt",
    "dbtrAgt",
    "cdtrAgt",
    "intrmyAgt1",
    "intrmyAgt2",
    "intrmyAgt3",
    "rcvgAgt",
    "dlvrgAgt",
    "issgAgt",
    "sttlmPlc",
    "prtry"
})
public class TransactionAgents51 {

    @XmlElement(name = "InstgAgt")
    protected BranchAndFinancialInstitutionIdentification65 instgAgt;
    @XmlElement(name = "InstdAgt")
    protected BranchAndFinancialInstitutionIdentification65 instdAgt;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentification68 dbtrAgt;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentification65 cdtrAgt;
    @XmlElement(name = "IntrmyAgt1")
    protected BranchAndFinancialInstitutionIdentification65 intrmyAgt1;
    @XmlElement(name = "IntrmyAgt2")
    protected BranchAndFinancialInstitutionIdentification65 intrmyAgt2;
    @XmlElement(name = "IntrmyAgt3")
    protected BranchAndFinancialInstitutionIdentification65 intrmyAgt3;
    @XmlElement(name = "RcvgAgt")
    protected BranchAndFinancialInstitutionIdentification65 rcvgAgt;
    @XmlElement(name = "DlvrgAgt")
    protected BranchAndFinancialInstitutionIdentification65 dlvrgAgt;
    @XmlElement(name = "IssgAgt")
    protected BranchAndFinancialInstitutionIdentification65 issgAgt;
    @XmlElement(name = "SttlmPlc")
    protected BranchAndFinancialInstitutionIdentification65 sttlmPlc;
    @XmlElement(name = "Prtry")
    protected List<ProprietaryAgent41> prtry;

    /**
     * 获取instgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getInstgAgt() {
        return instgAgt;
    }

    /**
     * 设置instgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setInstgAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.instgAgt = value;
    }

    /**
     * 获取instdAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getInstdAgt() {
        return instdAgt;
    }

    /**
     * 设置instdAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setInstdAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.instdAgt = value;
    }

    /**
     * 获取dbtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification68 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification68 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * 设置dbtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification68 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentification68 value) {
        this.dbtrAgt = value;
    }

    /**
     * 获取cdtrAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * 设置cdtrAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.cdtrAgt = value;
    }

    /**
     * 获取intrmyAgt1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getIntrmyAgt1() {
        return intrmyAgt1;
    }

    /**
     * 设置intrmyAgt1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setIntrmyAgt1(BranchAndFinancialInstitutionIdentification65 value) {
        this.intrmyAgt1 = value;
    }

    /**
     * 获取intrmyAgt2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getIntrmyAgt2() {
        return intrmyAgt2;
    }

    /**
     * 设置intrmyAgt2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setIntrmyAgt2(BranchAndFinancialInstitutionIdentification65 value) {
        this.intrmyAgt2 = value;
    }

    /**
     * 获取intrmyAgt3属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getIntrmyAgt3() {
        return intrmyAgt3;
    }

    /**
     * 设置intrmyAgt3属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setIntrmyAgt3(BranchAndFinancialInstitutionIdentification65 value) {
        this.intrmyAgt3 = value;
    }

    /**
     * 获取rcvgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getRcvgAgt() {
        return rcvgAgt;
    }

    /**
     * 设置rcvgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setRcvgAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.rcvgAgt = value;
    }

    /**
     * 获取dlvrgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getDlvrgAgt() {
        return dlvrgAgt;
    }

    /**
     * 设置dlvrgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setDlvrgAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.dlvrgAgt = value;
    }

    /**
     * 获取issgAgt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getIssgAgt() {
        return issgAgt;
    }

    /**
     * 设置issgAgt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setIssgAgt(BranchAndFinancialInstitutionIdentification65 value) {
        this.issgAgt = value;
    }

    /**
     * 获取sttlmPlc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification65 getSttlmPlc() {
        return sttlmPlc;
    }

    /**
     * 设置sttlmPlc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification65 }
     *     
     */
    public void setSttlmPlc(BranchAndFinancialInstitutionIdentification65 value) {
        this.sttlmPlc = value;
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
     * {@link ProprietaryAgent41 }
     * 
     * 
     */
    public List<ProprietaryAgent41> getPrtry() {
        if (prtry == null) {
            prtry = new ArrayList<ProprietaryAgent41>();
        }
        return this.prtry;
    }

}
