package com.hisun.kont.mx.msg.pacs.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Scope

 * The PaymentReturn message is sent by an agent to the previous agent in the payment chain to undo a payment previously settled.

 * Usage

 * The PaymentReturn message is exchanged between agents to return funds after settlement of credit transfer instructions (that is FIToFICustomerCreditTransfer message and FinancialInstitutionCreditTransfer message) or direct debit instructions (FIToFICustomerDirectDebit message).

 * The PaymentReturn message should not be used between agents and non-financial institution customers. Non-financial institution customers will be informed about a debit or a credit on their account(s) through a BankToCustomerDebitCreditNotification message ('notification') and/or BankToCustomerAccountReport/BankToCustomerStatement message ('statement').

 * The PaymentReturn message can be used to return single instructions or multiple instructions from one or different files.

 * The PaymentReturn message can be used in domestic and cross-border scenarios.

 * The PaymentReturn message refers to the original instruction(s) by means of references only or by means of references and a set of elements from the original instruction.
 * 
 * <p>PaymentReturnV11 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentReturnV11">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{}GroupHeader99"/>
 *         &lt;element name="OrgnlGrpInf" type="{}OriginalGroupHeader18" minOccurs="0"/>
 *         &lt;element name="TxInf" type="{}PaymentTransaction133" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SplmtryData" type="{}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentReturnV11", propOrder = {
    "grpHdr",
    "orgnlGrpInf",
    "txInf",
    "splmtryData"
})
public class PaymentReturnV11 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader99 grpHdr;
    @XmlElement(name = "OrgnlGrpInf")
    protected OriginalGroupHeader18 orgnlGrpInf;
    @XmlElement(name = "TxInf")
    protected List<PaymentTransaction133> txInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡgrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader99 }
     *     
     */
    public GroupHeader99 getGrpHdr() {
        return grpHdr;
    }

    /**
     * ����grpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader99 }
     *     
     */
    public void setGrpHdr(GroupHeader99 value) {
        this.grpHdr = value;
    }

    /**
     * ��ȡorgnlGrpInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupHeader18 }
     *     
     */
    public OriginalGroupHeader18 getOrgnlGrpInf() {
        return orgnlGrpInf;
    }

    /**
     * ����orgnlGrpInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupHeader18 }
     *     
     */
    public void setOrgnlGrpInf(OriginalGroupHeader18 value) {
        this.orgnlGrpInf = value;
    }

    /**
     * Gets the value of the txInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction133 }
     * 
     * 
     */
    public List<PaymentTransaction133> getTxInf() {
        if (txInf == null) {
            txInf = new ArrayList<PaymentTransaction133>();
        }
        return this.txInf;
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
