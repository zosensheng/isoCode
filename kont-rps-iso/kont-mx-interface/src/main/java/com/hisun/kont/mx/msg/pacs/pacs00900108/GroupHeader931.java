//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs.pacs00900108;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>GroupHeader93__1 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="GroupHeader93__1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgId" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_RestrictedFINXMax35Text"/>
 *         &lt;element name="CreDtTm" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}CBPR_DateTime"/>
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}Max15NumericText_fixed"/>
 *         &lt;element name="SttlmInf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}SettlementInstruction7__1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupHeader93__1", propOrder = {
    "msgId",
    "creDtTm",
    "nbOfTxs",
    "sttlmInf"
})
public class GroupHeader931 {

    @XmlElement(name = "MsgId", required = true)
    protected String msgId;
    @XmlElement(name = "CreDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDtTm;
    @XmlElement(name = "NbOfTxs", required = true)
    protected String nbOfTxs;
    @XmlElement(name = "SttlmInf", required = true)
    protected SettlementInstruction71 sttlmInf;

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
     * 获取nbOfTxs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * 设置nbOfTxs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * 获取sttlmInf属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SettlementInstruction71 }
     *     
     */
    public SettlementInstruction71 getSttlmInf() {
        return sttlmInf;
    }

    /**
     * 设置sttlmInf属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SettlementInstruction71 }
     *     
     */
    public void setSttlmInf(SettlementInstruction71 value) {
        this.sttlmInf = value;
    }

}
