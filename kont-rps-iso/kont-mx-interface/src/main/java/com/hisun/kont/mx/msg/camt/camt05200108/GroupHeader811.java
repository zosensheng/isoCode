//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:30 PM CST 
//


package com.hisun.kont.mx.msg.camt.camt05200108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>GroupHeader81__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GroupHeader81__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_DateTime"/>
 *         &lt;element name="MsgRcpt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}PartyIdentification135__1" minOccurs="0"/>
 *         &lt;element name="OrgnlBizQry" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}OriginalBusinessQuery1__1" minOccurs="0"/>
 *         &lt;element name="AddtlInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.08}CBPR_RestrictedFINXMax500Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupHeader81__1", propOrder = {
    "msgId",
    "creDtTm",
    "msgRcpt",
    "orgnlBizQry",
    "addtlInf"
})
public class GroupHeader811 {

    @XmlElement(name = "MsgId", required = true)
    protected String msgId;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "MsgRcpt")
    protected PartyIdentification1351 msgRcpt;
    @XmlElement(name = "OrgnlBizQry")
    protected OriginalBusinessQuery11 orgnlBizQry;
    @XmlElement(name = "AddtlInf")
    protected String addtlInf;

    /**
     * 获取msgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * 设置msgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgId(String value) {
        this.msgId = value;
    }

    /**
     * 获取creDtTm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreDtTm() {
        return creDtTm;
    }

    /**
     * 设置creDtTm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreDtTm(XMLGregorianCalendar value) {
        this.creDtTm = value;
    }

    /**
     * 获取msgRcpt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public PartyIdentification1351 getMsgRcpt() {
        return msgRcpt;
    }

    /**
     * 设置msgRcpt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification1351 }
     *     
     */
    public void setMsgRcpt(PartyIdentification1351 value) {
        this.msgRcpt = value;
    }

    /**
     * 获取orgnlBizQry属性的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalBusinessQuery11 }
     *     
     */
    public OriginalBusinessQuery11 getOrgnlBizQry() {
        return orgnlBizQry;
    }

    /**
     * 设置orgnlBizQry属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalBusinessQuery11 }
     *     
     */
    public void setOrgnlBizQry(OriginalBusinessQuery11 value) {
        this.orgnlBizQry = value;
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
