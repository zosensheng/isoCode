//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.06 时间 07:28:49 PM CST
//


package com.hisun.kont.mx.msg.javabean.pain00100111;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Scope

 * The CustomerCreditTransferInitiation message is sent by the initiating party to the forwarding agent or debtor agent. It is used to request movement of funds from the debtor account to a creditor.

 * Usage

 * The CustomerCreditTransferInitiation message can contain one or more customer credit transfer instructions.

 * The CustomerCreditTransferInitiation message is used to exchange:

 * - One or more instances of a credit transfer initiation;

 * - Payment transactions that result in book transfers at the debtor agent or payments to another financial institution;

 * - Payment transactions that result in an electronic cash transfer to the creditor account or in the emission of a cheque.

 * The message can be used in a direct or a relay scenario:

 * - In a direct scenario, the message is sent directly to the debtor agent. The debtor agent is the account servicer of the debtor.

 * - In a relay scenario, the message is sent to a forwarding agent. The forwarding agent acts as a concentrating financial institution. It will forward the CustomerCreditTransferInitiation message to the debtor agent.

 * The message can also be used by an initiating party that has authority to send the message on behalf of the debtor. This caters for example for the scenario of a payments factory initiating all payments on behalf of a large corporate.

 * The CustomerCreditTransferInitiation message can be used in domestic and cross-border scenarios.

 * The CustomerCreditTransferInitiation message must not be used by the debtor agent to execute the credit transfer instruction(s). The FIToFICustomerCreditTransfer message must be used instead.
 * 
 * <p>CustomerCreditTransferInitiationV11 complex type 的 Java 类。
 * 
 * <p>以下模式片段指定此类中包含的期望内容。
 * 
 * <pre>
 * &lt;complexType name="CustomerCreditTransferInitiationV11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}GroupHeader95"/>
 *         &lt;element name="PmtInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}PaymentInstruction40" maxOccurs="unbounded"/>
 *         &lt;element name="SplmtryData" type="{urn:iso:std:iso:20022:tech:xsd:pain.001.001.11}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerCreditTransferInitiationV11", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", propOrder = {
    "grpHdr",
    "pmtInf",
    "splmtryData"
})
public class CustomerCreditTransferInitiationV11 {

    @XmlElement(name = "GrpHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected GroupHeader95 grpHdr;
    @XmlElement(name = "PmtInf", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11", required = true)
    protected List<PaymentInstruction40> pmtInf;
    @XmlElement(name = "SplmtryData", namespace = "urn:iso:std:iso:20022:tech:xsd:pain.001.001.11")
    protected List<SupplementaryData1> splmtryData;

    /**
     * 获取属性 grpHdr 的值。
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader95 }
     *     
     */
    public GroupHeader95 getGrpHdr() {
        return grpHdr;
    }

    /**
     * 设置属性 grpHdr 的值。
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader95 }
     *     
     */
    public void setGrpHdr(GroupHeader95 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the pmtInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pmtInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPmtInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentInstruction40 }
     * 
     * 
     */
    public List<PaymentInstruction40> getPmtInf() {
        if (pmtInf == null) {
            pmtInf = new ArrayList<PaymentInstruction40>();
        }
        return this.pmtInf;
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
