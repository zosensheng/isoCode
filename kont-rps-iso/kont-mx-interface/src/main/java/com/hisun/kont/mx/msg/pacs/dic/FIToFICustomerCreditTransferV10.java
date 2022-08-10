package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * Scope
 * <p>
 * The FinancialInstitutionToFinancialInstitutionCustomerCreditTransfer message is sent by the debtor agent to the creditor agent, directly or through other agents and/or a payment clearing and settlement system. It is used to move funds from a debtor account to a creditor.
 * <p>
 * Usage
 * <p>
 * The FIToFICustomerCreditTransfer message is exchanged between agents and can contain one or more customer credit transfer instructions.
 * <p>
 * The FIToFICustomerCreditTransfer message does not allow for grouping: a CreditTransferTransactionInformation block must be present for each credit transfer transaction.
 * <p>
 * The FIToFICustomerCreditTransfer message can be used in different ways:
 * <p>
 * - If the instructing agent and the instructed agent wish to use their direct account relationship in the currency of the transfer then the message contains both the funds for the customer transfer(s) as well as the payment details;
 * <p>
 * - If the instructing agent and the instructed agent have no direct account relationship in the currency of the transfer, or do not wish to use their account relationship, then other (reimbursement) agents will be involved to cover for the customer transfer(s). The FIToFICustomerCreditTransfer contains only the payment details and the instructing agent must cover the customer transfer by sending a FinancialInstitutionCreditTransfer to a reimbursement agent. This payment method is called the Cover method;
 * <p>
 * - If more than two financial institutions are involved in the payment chain and if the FIToFICustomerCreditTransfer is sent from one financial institution to the next financial institution in the payment chain, then the payment method is called the Serial method.
 * <p>
 * The FIToFICustomerCreditTransfer message can be used in domestic and cross-border scenarios.
 *
 * <p>FIToFICustomerCreditTransferV10 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="FIToFICustomerCreditTransferV10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{}GroupHeader96"/>
 *         &lt;element name="CdtTrfTxInf" type="{}CreditTransferTransaction50" maxOccurs="unbounded"/>
 *         &lt;element name="SplmtryData" type="{}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIToFICustomerCreditTransferV10", propOrder = {
        "grpHdr",
        "cdtTrfTxInf",
        "splmtryData"
})
public class FIToFICustomerCreditTransferV10 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader96 grpHdr;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected List<CreditTransferTransaction50> cdtTrfTxInf;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡgrpHdr���Ե�ֵ��
     *
     * @return possible object is
     * {@link GroupHeader96 }
     */
    public GroupHeader96 getGrpHdr() {
        return grpHdr;
    }

    /**
     * ����grpHdr���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link GroupHeader96 }
     */
    public void setGrpHdr(GroupHeader96 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the cdtTrfTxInf property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdtTrfTxInf property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdtTrfTxInf().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditTransferTransaction50 }
     */
    public List<CreditTransferTransaction50> getCdtTrfTxInf() {
        if (cdtTrfTxInf == null) {
            cdtTrfTxInf = new ArrayList<CreditTransferTransaction50>();
        }
        return this.cdtTrfTxInf;
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
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }
}