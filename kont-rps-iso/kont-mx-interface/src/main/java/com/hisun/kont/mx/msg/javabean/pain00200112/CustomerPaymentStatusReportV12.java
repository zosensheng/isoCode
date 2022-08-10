//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:48 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00200112;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Scope

 * The CustomerPaymentStatusReport message is sent by an instructed agent to the previous party in the payment chain. It is used to inform this party about the positive or negative status of an instruction (either single or file). It is also used to report on a pending instruction.

 * Usage

 * The CustomerPaymentStatusReport message is exchanged between an agent and a non-financial institution customer to provide status information on instructions previously sent. Its usage will always be governed by a bilateral agreement between the agent and the non-financial institution customer.

 * The CustomerPaymentStatusReport message can be used to provide information about the status (for example a rejection, an acceptance) of the initiation of a credit transfer, a direct debit, as well as on the initiation of other customer instructions.

 * The CustomerPaymentStatusReport message refers to the original instruction(s) by means of references only or by means of references and a set of elements from the original instruction.

 * The CustomerPaymentStatusReport message can be used in domestic and cross-border scenarios.

 * The CustomerPaymentStatusReport may also be sent to the receiver of the payment in a real time payment scenario, as both sides of the transactions must be informed of the status of the transaction (that is either the beneficiary is credited, or the transaction is rejected).
 * 
 * <p>CustomerPaymentStatusReportV12 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerPaymentStatusReportV12">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}GroupHeader86"/>
 *         &lt;element name="OrgnlGrpInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}OriginalGroupHeader17"/>
 *         &lt;element name="OrgnlPmtInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}OriginalPaymentInstruction40" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.12}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerPaymentStatusReportV12", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", propOrder = {
    "grpHdr",
    "orgnlGrpInfAndSts",
    "orgnlPmtInfAndSts",
    "splmtryData"
})
public class CustomerPaymentStatusReportV12 {

    @XmlElement(name = "GrpHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected GroupHeader86 grpHdr;
    @XmlElement(name = "OrgnlGrpInfAndSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12", required = true)
    protected OriginalGroupHeader17 orgnlGrpInfAndSts;
    @XmlElement(name = "OrgnlPmtInfAndSts", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<OriginalPaymentInstruction40> orgnlPmtInfAndSts;
    @XmlElement(name = "SplmtryData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.12")
    protected List<SupplementaryData1> splmtryData;

    /**
     * 获取属性 grpHdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader86 }
     *     
     */
    public GroupHeader86 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置属性 grpHdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader86 }
     *     
     */
    public void setGrpHdr(GroupHeader86 value) {
        this.grpHdr = value;
    }

    /**
     * 获取属性 orgnlGrpInfAndSts 的值。
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader17 }
     *     
     */
    public OriginalGroupHeader17 getOrgnlGrpInfAndSts() {
        return orgnlGrpInfAndSts;
    }

    /**
     * 设置属性 orgnlGrpInfAndSts 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader17 }
     *     
     */
    public void setOrgnlGrpInfAndSts(OriginalGroupHeader17 value) {
        this.orgnlGrpInfAndSts = value;
    }

    /**
     * Gets the value of the orgnlPmtInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orgnlPmtInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrgnlPmtInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OriginalPaymentInstruction40 }
     * 
     * 
     */
    public List<OriginalPaymentInstruction40> getOrgnlPmtInfAndSts() {
        if (orgnlPmtInfAndSts == null) {
            orgnlPmtInfAndSts = new ArrayList<OriginalPaymentInstruction40>();
        }
        return this.orgnlPmtInfAndSts;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
