//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00800108ErrorConstant;
import com.hisun.kont.mx.msg.pacs.pacs00800108.*;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


/**
 * <p>Document complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08}FIToFICustomerCreditTransferV08"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
        "fiToFICstmrCdtTrf"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08")
public class Pacs00800108 {

    @XmlElement(name = "FIToFICstmrCdtTrf", required = true)
    protected FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf;

    /**
     * 获取fiToFICstmrCdtTrf属性的值。
     *
     * @return possible object is
     * {@link FIToFICustomerCreditTransferV08 }
     */
    public FIToFICustomerCreditTransferV08 getFIToFICstmrCdtTrf() {
        return fiToFICstmrCdtTrf;
    }

    /**
     * 设置fiToFICstmrCdtTrf属性的值。
     *
     * @param value allowed object is
     *              {@link FIToFICustomerCreditTransferV08 }
     */
    public void setFIToFICstmrCdtTrf(FIToFICustomerCreditTransferV08 value) {
        this.fiToFICstmrCdtTrf = value;
    }


    /**
     * ActiveCurrency
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered with
     * the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     * todo
     *
     * @return 返回C1检查结果
     */
    public Constraints checkC1() {

        return null;
    }


    /**
     * ActiveOrHistoricCurrency
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 Dtls TaxAmt Rcrd TaxRmt Strd Strd RmtInf CdtTrfTxInf v
     * TotalAmount <TtlAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd TaxRmt Strd Strd RmtInf CdtTrfTxInf v
     * TaxableBaseAmount <TaxblBaseAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd TaxRmt Strd Strd RmtInf CdtTrfTxInf v
     * TotalTaxAmount <TtlTaxAmt> [0..1] Amount ✓C2,✓C11 TaxRmt Strd Strd RmtInf CdtTrfTxInf v
     * TotalTaxableBaseAmount <TtlTaxblBaseAmt> [0..1] Amount ✓C2,✓C11 TaxRmt Strd Strd RmtInf CdtTrfTxInf v
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 AdjstmntAmtAndRsn LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf ！！！！
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 DscntApldAmt LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf v
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 TaxAmt Amt LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf v
     * RemittedAmount <RmtdAmt> [0..1] Amount ✓C2,✓C11 Amt LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf
     * CreditNoteAmount <CdtNoteAmt> [0..1] Amount ✓C2,✓C11 Amt LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf
     * DuePayableAmount <DuePyblAmt> [0..1] Amount ✓C2,✓C11 Amt LineDtls RfrdDocInf Strd Strd RmtInf CdtTrfTxInf
     * todo
     *
     * @return C2规则检查
     */
    public Constraints checkC2() {

        return null;
    }


    /**
     * AnyBIC
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial
     * institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * 6.4.2 CreditTransferTransactionInformation <CdtTrfTxInf>
     * 6.4.2.29 UltimateDebtor <UltmtDbtr>
     * 6.4.2.30 InitiatingParty <InitgPty>
     * 6.4.2.31 Debtor <Dbtr>
     * 6.4.2.37 Creditor <Cdtr>
     * 6.4.2.39 UltimateCreditor <UltmtCdtr>
     * <p>
     * 6.4.2.46 RemittanceInformation <RmtInf>
     * 6.4.2.46.2.4 Invoicer <Invcr>
     * 6.4.2.46.2.5 Invoicee <Invcee>
     * todo
     *
     * @return C3规则检查
     */
    public Constraints checkC3() {

        return null;
    }


    /**
     * BICFI
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * 6.4.1.8 SettlementInformation <SttlmInf>
     * 6.4.1.8.4 InstructingReimbursementAgent <InstgRmbrsmntAgt>
     * 6.4.1.8.6 InstructedReimbursementAgent <InstdRmbrsmntAgt>
     * 6.4.1.8.8 ThirdReimbursementAgent <ThrdRmbrsmntAgt>
     * 6.4.1.10 InstructingAgent <InstgAgt>
     * 6.4.1.11 InstructedAgent <InstdAgt>
     * <p>
     * 6.4.2 CreditTransferTransactionInformation <CdtTrfTxInf>
     * 6.4.2.15 PreviousInstructingAgent1 <PrvsInstgAgt1>
     * 6.4.2.17 PreviousInstructingAgent2 <PrvsInstgAgt2>
     * 6.4.2.19 PreviousInstructingAgent3 <PrvsInstgAgt3>
     * 6.4.2.21 InstructingAgent <InstgAgt>
     * 6.4.2.22 InstructedAgent <InstdAgt>
     * 6.4.2.23 IntermediaryAgent1 <IntrmyAgt1>
     * 6.4.2.25 IntermediaryAgent2 <IntrmyAgt2>
     * 6.4.2.27 IntermediaryAgent3 <IntrmyAgt3>
     * 6.4.2.33 DebtorAgent <DbtrAgt>
     * 6.4.2.35 CreditorAgent <CdtrAgt>
     * todo
     *
     * @return C4规则检查
     */
    public Constraints checkC4() {

        return null;
    }


    /**
     * If ChargeBearer contains DEBT, then ChargesInformation may be present to communicate
     * charges that have been added for (the) InstructedAgent(s).
     * If ChargeBearer contains CRED, then at least one occurrence of ChargesInformation must be
     * present to communicate charges that have been deducted from the InstructedAmount by (the)
     * InstructingAgent(s).
     * If ChargeBearer contains SHAR or SLEV, then ChargesInformation is
     * optional. (CrossElementComplexRule)
     * ChargeBearer <ChrgBr> [1..1] CodeSet CdtTrfTxInf
     * ChargesInformation <ChrgsInf> [0..*] ± CdtTrfTxInf
     * On Condition
     * /ChargeBearer is equal to value 'BorneByCreditor'
     * Following Must be True
     * /ChargesInformation[1] Must be present
     *
     * @return C5规则检查
     */
    public Constraints checkC5() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                ChargeBearerType1Code1 chrgBr = cdtTrfTxInf.getChrgBr();
                List<Charges71> chrgsInf = cdtTrfTxInf.getChrgsInf();
                if (JudgeUtils.isNotNull(chrgBr)) {
                    String value = chrgBr.value();
                    if ("CRED".equals(value)) {
                        if (JudgeUtils.isNotNull(chrgsInf)) {
                            for (Charges71 charges7 : chrgsInf) {
                                CBPRAmount1 amt = charges7.getAmt();
                                BranchAndFinancialInstitutionIdentification61 agt = charges7.getAgt();
                                if (JudgeUtils.isNull(amt) || JudgeUtils.isNull(agt)) {
                                    return new Constraints(Pacs00800108ErrorConstant.C5_ERROR_SEVERITY, Pacs00800108ErrorConstant.C5_ERROR_CODE, Pacs00800108ErrorConstant.C5_ERROR_TEXT);
                                }
                            }
                        } else {
                            return new Constraints(Pacs00800108ErrorConstant.C5_ERROR_SEVERITY, Pacs00800108ErrorConstant.C5_ERROR_CODE, Pacs00800108ErrorConstant.C5_ERROR_TEXT);
                        }
                    }
                }
            }

        }
        return null;
    }

    /**
     * If ChargesInformation is present, then InstructedAmount must be
     * present. (CrossElementComplexRule)
     * <ChrgsInf> <-> <InstdAmt>
     * ChrgsInf CdtTrfTxInf
     * InstdAmt CdtTrfTxInf
     * present. (CrossElementComplexRule)
     *
     * @return C7规则检查
     */
    public Constraints checkC7() {
        FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf1 = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf1)) {
            CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf1.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                List<Charges71> chrgsInf = cdtTrfTxInf.getChrgsInf();
                CBPRAmount1 instdAmt = cdtTrfTxInf.getInstdAmt();
                if (JudgeUtils.isNotNull(chrgsInf) && JudgeUtils.isNull(instdAmt)) {
                    return new Constraints(Pacs00800108ErrorConstant.C7_ERROR_SEVERITY, Pacs00800108ErrorConstant.C7_ERROR_CODE, Pacs00800108ErrorConstant.C7_ERROR_TEXT);
                }
            }
        }
        return null;
    }


    /**
     * Country
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     * Adr
     * Dtls
     * Authrty
     * PstlAdr（AdrTp）
     * 6.4.2 CreditTransferTransactionInformation <CdtTrfTxInf>
     * 6.4.2.29 UltimateDebtor <UltmtDbtr>
     * 6.4.2.30 InitiatingParty <InitgPty>
     * 6.4.2.31 Debtor <Dbtr>
     * 6.4.2.37 Creditor <Cdtr>
     * 6.4.2.39 UltimateCreditor <UltmtCdtr>
     * 6.4.2.46 RemittanceInformation <RmtInf>
     * 6.4.2.46.2 Structured <Strd>
     * 6.4.2.46.2.4 Invoicer <Invcr>
     * 6.4.2.46.2.5 Invoicee <Invcee>
     * todo
     *
     * @return C9规则检查
     */
    public Constraints checkC9() {

        return null;
    }


    /**
     * CurrencyAmount
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * TotalInterbankSettlementAmount <TtlIntrBkSttlmAmt> [0..1] Amount ✓C1,✓C10
     * InterbankSettlementAmount <IntrBkSttlmAmt> [1..1] Amount ✓C1,✓C10
     * todo
     *
     * @return C10规则检查
     */
    public Constraints checkC10() {
        return null;
    }

    /**
     * CurrencyAmount
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * InstructedAmount <InstdAmt> [0..1] Amount ✓C2,✓C11 CdtTrfTxInf
     * TotalTaxableBaseAmount <TtlTaxblBaseAmt> [0..1] Amount ✓C2,✓C11 Tax CdtTrfTxInf
     * TotalTaxAmount <TtlTaxAmt> [0..1] Amount ✓C2,✓C11 Tax CdtTrfTxInf
     * TaxableBaseAmount <TaxblBaseAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd Tax CdtTrfTxInf
     * TotalAmount <TtlAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd Tax CdtTrfTxInf
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 Dtls TaxAmt Rcrd Tax CdtTrfTxInf
     * DuePayableAmount <DuePyblAmt> [0..1] Amount ✓C2,✓C11 Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 DscntApldAmt Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * CreditNoteAmount <CdtNoteAmt> [0..1] Amount ✓C2,✓C11 Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 TaxAmt Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 AdjstmntAmtAndRsn Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * RemittedAmount <RmtdAmt> [0..1] Amount ✓C2,✓C11  Amt LineDtls RfrdDocInf Strd RmtInf CdtTrfTxInf
     * TotalTaxableBaseAmount <TtlTaxblBaseAmt> [0..1] Amount ✓C2,✓C11 TaxRmt Strd RmtInf CdtTrfTxInf
     * TotalTaxAmount <TtlTaxAmt> [0..1] Amount ✓C2,✓C11 TaxRmt Strd RmtInf CdtTrfTxInf
     * TaxableBaseAmount <TaxblBaseAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd TaxRmt Strd RmtInf CdtTrfTxInf
     * TotalAmount <TtlAmt> [0..1] Amount ✓C2,✓C11 TaxAmt Rcrd TaxRmt Strd RmtInf CdtTrfTxInf
     * Amount <Amt> [1..1] Amount ✓C2,✓C11 Dtls TaxAmt Rcrd TaxRmt Strd RmtInf CdtTrfTxInf
     * todo
     *
     * @return 返回C11检查结果
     */
    public Constraints checkC11() {
        return null;
    }

    /**
     * C12 GroupHeaderInterbankSettlementDateRule ✓
     * (Rule)
     * If GroupHeader/InterbankSettlementDate is present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate is not
     * allowed. (CrossElementComplexRule)
     * GroupHeader/InterbankSettlementDate >< CreditTransferTransactionInformation/InterbankSettlementDate
     * <GrpHdr>/<IntrBkSttlmDt>     <CdtTrfTxInf>/<IntrBkSttlmDt>
     * todo GroupHeader/InterbankSettlementDate 不存在
     *
     * @return C12规则检查
     */
    public Constraints checkC12() {

        return null;
    }

    /**
     * C13 IBAN ✓
     * (Rule)
     * A valid IBAN consists of all three of the following components: Country Code, check digits and
     * BBAN. (Algorithm)
     *
     * @return C13规则检查
     */
    public Constraints checkC13() {

        return null;
    }

    /**
     * C14 InstructedAgentRule ✓
     * (Rule)
     * If GroupHeader/InstructedAgent is present, then CreditTransferTransactionInformation/
     * InstructedAgent is not allowed. (CrossElementComplexRule)
     * todo GroupHeader/InstructedAgent 不存在
     *
     * @return C14规则检查
     */
    public Constraints checkC14() {

        return null;
    }

    /**
     * C15 InstructedAmountAndExchangeRate1Rule ✓
     * (Rule)
     * If InstructedAmount is present and the currency is different from the
     * currency in InterbankSettlementAmount, then ExchangeRate must be
     * present. (CrossElementComplexRule)
     * On Condition
     * /InstructedAmount is present
     * And /InstructedAmount/attribute::Currency is different from /
     * InterbankSettlementAmount/attribute::Currency
     * Following Must be True
     * /ExchangeRate Must be present
     * (如果InstructedAmount存在，且货币与银行间结算金额中的货币不同，则ExchangeRate必须存在。(CrossElementComplexRule))
     * InstructedAmount <InstdAmt> [0..1] Amount ✓C2,✓C11
     * InterbankSettlementAmount <IntrBkSttlmAmt> [1..1] Amount ✓C1,✓C10
     * ExchangeRate <XchgRate> [0..1] Rate
     *
     * @return C15检查规则
     */
    public Constraints checkC15() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf.getInstdAmt())) {
                    CBPRAmount1 instdAmt = cdtTrfTxInf.getInstdAmt();
                    CBPRAmount1 intrBkSttlmAmt = cdtTrfTxInf.getIntrBkSttlmAmt();
                    BigDecimal xchgRate = cdtTrfTxInf.getXchgRate();
                    if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccyInstdAmt = instdAmt.getCcy();
                        String ccyIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccyInstdAmt) && JudgeUtils.isNotNull(ccyIntrBkSttlmAmt)) {
                            if (!ccyInstdAmt.equals(ccyIntrBkSttlmAmt)) {
                                if (JudgeUtils.isNull(xchgRate)) {
                                    return new Constraints(Pacs00800108ErrorConstant.C15_ERROR_SEVERITY, Pacs00800108ErrorConstant.C15_ERROR_CODE, Pacs00800108ErrorConstant.C15_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * C18 InstructedAmountAndExchangeRate2Rule ✓
     * (Rule)
     * If InstructedAmount is present and the currency is the same as the currency in
     * InterbankSettlementAmount, then ExchangeRate is not allowed. (CrossElementComplexRule)
     *
     * @return C16检查规则
     */
    public Constraints checkC16() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    CBPRAmount1 instdAmt = cdtTrfTxInf.getInstdAmt();
                    CBPRAmount1 intrBkSttlmAmt = cdtTrfTxInf.getIntrBkSttlmAmt();
                    BigDecimal xchgRate = cdtTrfTxInf.getXchgRate();
                    if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccyInstdAmt = instdAmt.getCcy();
                        String ccyIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccyInstdAmt) && JudgeUtils.isNotNull(ccyIntrBkSttlmAmt)) {
                            if (ccyInstdAmt.equals(ccyIntrBkSttlmAmt)) {
                                if (JudgeUtils.isNotNull(xchgRate)) {
                                    return new Constraints(Pacs00800108ErrorConstant.C16_ERROR_SEVERITY, Pacs00800108ErrorConstant.C16_ERROR_CODE, Pacs00800108ErrorConstant.C16_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * C17 InstructedAmountAndExchangeRate3Rule ✓
     * (Rule)
     * If InstructedAmount is not present, then ExchangeRate is not
     * allowed. (CrossElementComplexRule)
     *
     * @return C17检查规则
     */
    public Constraints checkC17() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CBPRAmount1 instdAmt = cdtTrfTxInf.getInstdAmt();
                BigDecimal xchgRate = cdtTrfTxInf.getXchgRate();
                if (JudgeUtils.isNull(instdAmt) && JudgeUtils.isNotNull(xchgRate)) {
                    return new Constraints(Pacs00800108ErrorConstant.C17_ERROR_SEVERITY, Pacs00800108ErrorConstant.C17_ERROR_CODE, Pacs00800108ErrorConstant.C17_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C18 InstructedReimbursementAgentAccountRule ✓
     * (Rule)
     * If InstructedReimbursementAgentAccount is present, then InstructedReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct> [0..1] ✓C15,C14 SttlmInf GrpHdr
     * InstructedReimbursementAgent <InstdRmbrsmntAgt> [0..1] ± SttlmInf GrpHdr
     *
     * @return C18检查规则
     */
    public Constraints checkC18() {
        FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount381 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgt) && JudgeUtils.isNull(instdRmbrsmntAgtAcct)) {
                        return new Constraints(Pacs00800108ErrorConstant.C18_ERROR_SEVERITY, Pacs00800108ErrorConstant.C18_ERROR_CODE, Pacs00800108ErrorConstant.C18_ERROR_TEXT);
                    }
                }
            }
        }


        return null;
    }

    /**
     * C19 InstructingAgentRule ✓
     * (Rule)
     * If GroupHeader/InstructingAgent is present, then CreditTransferTransactionInformation/
     * InstructingAgent is not allowed. (CrossElementComplexRule)
     * GroupHeader <GrpHdr>
     * InstructedAgent <InstdAgt> [0..1] ± 771
     * CreditTransferTransactionInformation <CdtTrfTxInf>
     * InstructedAgent <InstdAgt> [0..1] ±
     * todo GroupHeader/InstructingAgent 不存在
     *
     * @return C19检查规则
     */
    public Constraints checkC19() {


        return null;
    }

    /**
     * C20 InstructingReimbursementAgentAccountRule ✓
     * (Rule)
     * If InstructingReimbursementAgentAccount is present, then InstructingReimbursementAgent
     * must be present. (CrossElementComplexRule)
     *
     * @return C20检查规则
     */
    public Constraints checkC20() {
        FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount381 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                        return new Constraints(Pacs00800108ErrorConstant.C20_ERROR_SEVERITY, Pacs00800108ErrorConstant.C20_ERROR_CODE, Pacs00800108ErrorConstant.C20_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }


    /**
     * C21 InstructionForCreditorAgentRule ✓
     * (Rule)
     * If InstructionForCreditorAgent/Code contains CHQB (PayCreditorByCheque), then
     * CreditorAccount is not allowed. (CrossElementComplexRule)
     *
     * @return C21检查规则
     */
    public Constraints checkC21() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                List<InstructionForCreditorAgent11> instrForCdtrAgt = cdtTrfTxInf.getInstrForCdtrAgt();
                CashAccount381 cdtrAcct = cdtTrfTxInf.getCdtrAcct();
                if (JudgeUtils.isNotNull(instrForCdtrAgt)) {
                    for (InstructionForCreditorAgent11 instructionForCreditorAgent3 : instrForCdtrAgt) {
                        Instruction3Code cd = instructionForCreditorAgent3.getCd();
                        if (JudgeUtils.isNotNull(cd)) {
                            String value = cd.value();
                            if (JudgeUtils.isNotNull(value)) {
                                if (value.contains("CHQB") && JudgeUtils.isNotNull(cdtrAcct)) {
                                    return new Constraints(Pacs00800108ErrorConstant.C21_ERROR_SEVERITY, Pacs00800108ErrorConstant.C21_ERROR_CODE, Pacs00800108ErrorConstant.C21_ERROR_TEXT);
                                }
                            }

                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * C22 IntermediaryAgent1AccountRule ✓
     * (Rule)
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C22检查规则
     */
    public Constraints checkC22() {

        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 intrmyAgt1Acct = cdtTrfTxInf.getIntrmyAgt1Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                if (JudgeUtils.isNotNull(intrmyAgt1Acct) && JudgeUtils.isNull(intrmyAgt1)) {
                    return new Constraints(Pacs00800108ErrorConstant.C22_ERROR_SEVERITY, Pacs00800108ErrorConstant.C22_ERROR_CODE, Pacs00800108ErrorConstant.C22_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C23 IntermediaryAgent2AccountRule ✓
     * (Rule)
     * If IntermediaryAgent2Account is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C23检查规则
     */
    public Constraints checkC23() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 intrmyAgt2Acct = cdtTrfTxInf.getIntrmyAgt2Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                if (JudgeUtils.isNotNull(intrmyAgt2Acct) && JudgeUtils.isNull(intrmyAgt2)) {
                    return new Constraints(Pacs00800108ErrorConstant.C23_ERROR_SEVERITY, Pacs00800108ErrorConstant.C23_ERROR_CODE, Pacs00800108ErrorConstant.C23_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C24 IntermediaryAgent2Rule ✓
     * (Rule)
     * If IntermediaryAgent2 is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C24检查规则
     */
    public Constraints checkC24() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
                    return new Constraints(Pacs00800108ErrorConstant.C24_ERROR_SEVERITY, Pacs00800108ErrorConstant.C24_ERROR_CODE, Pacs00800108ErrorConstant.C24_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C25 IntermediaryAgent3AccountRule ✓
     * (Rule)
     * If IntermediaryAgent3Account is present, then IntermediaryAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C25检查规则
     */
    public Constraints checkC25() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 intrmyAgt3Acct = cdtTrfTxInf.getIntrmyAgt3Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                if (JudgeUtils.isNotNull(intrmyAgt3Acct) && JudgeUtils.isNull(intrmyAgt3)) {
                    return new Constraints(Pacs00800108ErrorConstant.C25_ERROR_SEVERITY, Pacs00800108ErrorConstant.C25_ERROR_CODE, Pacs00800108ErrorConstant.C25_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C26 IntermediaryAgent3Rule ✓
     * (Rule)
     * If IntermediaryAgent3 is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C26检查规则
     */
    public Constraints checkC26() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                if (JudgeUtils.isNotNull(intrmyAgt3) && JudgeUtils.isNull(intrmyAgt2)) {
                    return new Constraints(Pacs00800108ErrorConstant.C26_ERROR_SEVERITY, Pacs00800108ErrorConstant.C26_ERROR_CODE, Pacs00800108ErrorConstant.C26_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C27 NumberOfTransactionsAndCreditTransfersRule
     * (Rule)
     * GroupHeader/NumberOfTransactions must equal the number of occurrences of
     * CreditTransferTransactionInformation. (CrossElementSimpleRule)
     *
     * @return C27检查规则
     */
    public Constraints checkC27() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV08> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<String> NbOfTxs = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV08::getGrpHdr)
                    .map(GroupHeader931::getNbOfTxs);
            int nbOfTxsInt = 0;
            if (NbOfTxs.isPresent()) {
                String nbOfTxs = fiToFICstmrCdtTrf.getGrpHdr().getNbOfTxs();
                nbOfTxsInt = Integer.parseInt(nbOfTxs);
            }
            int number = 0;
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    number = 1;
                } else {
                    number = 0;
                }
            }
            if (nbOfTxsInt != number) {
                return new Constraints(Pacs00800108ErrorConstant.C27_ERROR_SEVERITY, Pacs00800108ErrorConstant.C27_ERROR_CODE, Pacs00800108ErrorConstant.C27_ERROR_TEXT);
            }
        }

        return null;
    }

    /**
     * C28 PaymentTypeInformationRule ✓
     * (Rule)
     * If GroupHeader/PaymentTypeInformation is present, then
     * CreditTransferTransactionInformation/PaymentTypeInformation is not
     * allowed. (CrossElementComplexRule)
     * todo GroupHeader/PaymentTypeInformation 不存在
     *
     * @return C28检查规则
     */
    public Constraints checkC28() {

        return null;
    }

    /**
     * C29 PreviousInstructingAgent1AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C29检查规则
     */
    public Constraints checkC29() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 prvsInstgAgt1Acct = cdtTrfTxInf.getPrvsInstgAgt1Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                if (JudgeUtils.isNotNull(prvsInstgAgt1Acct) && JudgeUtils.isNull(prvsInstgAgt1)) {
                    return new Constraints(Pacs00800108ErrorConstant.C29_ERROR_SEVERITY, Pacs00800108ErrorConstant.C29_ERROR_CODE, Pacs00800108ErrorConstant.C29_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C31 PreviousInstructingAgent2AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent2Account is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C31检查规则
     */
    public Constraints checkC31() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 prvsInstgAgt2Acct = cdtTrfTxInf.getPrvsInstgAgt2Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                if (JudgeUtils.isNotNull(prvsInstgAgt2Acct) && JudgeUtils.isNull(prvsInstgAgt2)) {
                    return new Constraints(Pacs00800108ErrorConstant.C31_ERROR_SEVERITY, Pacs00800108ErrorConstant.C31_ERROR_CODE, Pacs00800108ErrorConstant.C31_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C32 PreviousInstructingAgent3AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent3Account is present, then PreviousInstructingAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C32检查规则
     */
    public Constraints checkC32() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                CashAccount381 prvsInstgAgt3Acct = cdtTrfTxInf.getPrvsInstgAgt3Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                if (JudgeUtils.isNotNull(prvsInstgAgt3Acct) && JudgeUtils.isNull(prvsInstgAgt3)) {
                    return new Constraints(Pacs00800108ErrorConstant.C32_ERROR_SEVERITY, Pacs00800108ErrorConstant.C32_ERROR_CODE, Pacs00800108ErrorConstant.C32_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C33 PreviousInstructionAgent2Rule ✓
     * (Rule)
     * If PreviousInstructingAgent2 is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C33检查规则
     */
    public Constraints checkC33() {

        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                if (JudgeUtils.isNotNull(prvsInstgAgt2) && JudgeUtils.isNull(prvsInstgAgt1)) {
                    return new Constraints(Pacs00800108ErrorConstant.C33_ERROR_SEVERITY, Pacs00800108ErrorConstant.C33_ERROR_CODE, Pacs00800108ErrorConstant.C33_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C34 PreviousInstructionAgent3Rule ✓
     * (Rule)
     * If PreviousInstructingAgent3 is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C34检查规则
     */
    public Constraints checkC34() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
            BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
            BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
            if (JudgeUtils.isNotNull(prvsInstgAgt3) && JudgeUtils.isNull(prvsInstgAgt2)) {
                return new Constraints(Pacs00800108ErrorConstant.C34_ERROR_SEVERITY, Pacs00800108ErrorConstant.C34_ERROR_CODE, Pacs00800108ErrorConstant.C34_ERROR_TEXT);
            }
        }
        return null;
    }

    /**
     * C35 SettlementMethodAgentRule ✓
     * (Rule)
     * If SettlementMethod is equal to INDA or INGA, then ReimbursementAgent(s) and
     * ClearingSystem are not allowed. (CrossElementComplexRule)
     * todo ClearingSystem ClrSys 没打勾
     *
     * @return C35检查规则
     */
    public Constraints checkC35() {
//        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
//            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
//            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
//                GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
//                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
//                if (JudgeUtils.isNotNull(sttlmInf)) {
//                    SettlementMethod1Code1 sttlmMtd = sttlmInf.getSttlmMtd();
////                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
//                    BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
//                    BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
//                    BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
//                    if (JudgeUtils.isNotNull(sttlmMtd)) {
//                        String value = sttlmMtd.value();
//                        if (JudgeUtils.isNotNull(value)) {
//                            if ("INDA".equals(value) || "INGA".equals(value)) {
//                                if (JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
//                                    return new Constraints(Pacs00800108ErrorConstant.C35_ERROR_SEVERITY, Pacs00800108ErrorConstant.C35_ERROR_CODE, Pacs00800108ErrorConstant.C35_ERROR_TEXT);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }

        return null;
    }

    /**
     * C36 SettlementMethodClearingRule ✓
     * (Rule)
     * If SettlementMethod is equal to CLRG, then SettlementAccount and ReimbursementAgent(s)
     * are not allowed. (CrossElementComplexRule)
     *
     * @return C36检查规则
     */
    public Constraints checkC36() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code1 sttlmMtd = sttlmInf.getSttlmMtd();
                        CashAccount381 sttlmAcct = sttlmInf.getSttlmAcct();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(sttlmMtd)) {
                            String value = sttlmMtd.value();
                            if (JudgeUtils.isNotNull(value)) {
                                if ("CLRG".equals(value)) {
                                    if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                        return new Constraints(Pacs00800108ErrorConstant.C36_ERROR_SEVERITY, Pacs00800108ErrorConstant.C36_ERROR_CODE, Pacs00800108ErrorConstant.C36_ERROR_TEXT);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * C37 SettlementMethodCoverAgentRule ✓
     * (Rule)
     * If SettlementMethod is equal to COVE, then InstructedReimbursementAgent or
     * InstructingReimbursementAgent must be present. (CrossElementComplexRule)
     *
     * @return C37检查规则
     */
    public Constraints checkC37() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code1 sttlmMtd = sttlmInf.getSttlmMtd();
                    BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("COVE".equals(value)) {
                            if (JudgeUtils.isNull(instdRmbrsmntAgt) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                                return new Constraints(Pacs00800108ErrorConstant.C37_ERROR_SEVERITY, Pacs00800108ErrorConstant.C37_ERROR_CODE, Pacs00800108ErrorConstant.C37_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * C38 SettlementMethodCoverRule ✓
     * (Rule)
     * If SettlementMethod is equal to COVE, then SettlementAccount and ClearingSystem are not
     * allowed. (CrossElementComplexRule)
     * todo ClearingSystem ClrSys 没打勾
     *
     * @return C38检查规则
     */
    public Constraints checkC38() {
//        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
//            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
//            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
//                GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
//                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
//                if (JudgeUtils.isNotNull(sttlmInf)) {
//                    SettlementMethod1Code1 sttlmMtd = sttlmInf.getSttlmMtd();
//                    CashAccount381 sttlmAcct = sttlmInf.getSttlmAcct();
////                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
//                    if (JudgeUtils.isNotNull(sttlmMtd)) {
//                        String value = sttlmMtd.value();
//                        if ("COVE".equals(value)) {
//                            if (JudgeUtils.isNotNull(sttlmAcct)) {
//                                return new Constraints(Pacs00800108ErrorConstant.C38_ERROR_SEVERITY, Pacs00800108ErrorConstant.C38_ERROR_CODE, Pacs00800108ErrorConstant.C38_ERROR_TEXT);
//                            }
//                        }
//                    }
//                }
//            }
//        }


        return null;
    }

    /**
     * C41 ThirdReimbursementAgentAccountRule ✓
     * (Rule)
     * If ThirdReimbursementAgentAccount is present, then ThirdReimbursementAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C41检查规则
     */
    public Constraints checkC41() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader931 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount381 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct) && JudgeUtils.isNull(thrdRmbrsmntAgt)) {
                            return new Constraints(Pacs00800108ErrorConstant.C41_ERROR_SEVERITY, Pacs00800108ErrorConstant.C41_ERROR_CODE, Pacs00800108ErrorConstant.C41_ERROR_TEXT);
                        }
                    }
                }
            }
        }


        return null;
    }

    /**
     * C42 ThirdReimbursementAgentRule ✓
     * (Rule)
     * If ThirdReimbursementAgent is present, then InstructingReimbursementAgent and
     * InstructedReimbursementAgent must both be present. (CrossElementComplexRule)
     *
     * @return C42检查规则
     */
    public Constraints checkC42() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV08> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<BranchAndFinancialInstitutionIdentification61> branchAndFinancialInstitutionIdentification6 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV08::getGrpHdr)
                    .map(GroupHeader931::getSttlmInf)
                    .map(SettlementInstruction71::getThrdRmbrsmntAgt);
            Optional<BranchAndFinancialInstitutionIdentification61> branchAndFinancialInstitutionIdentification61 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV08::getGrpHdr)
                    .map(GroupHeader931::getSttlmInf)
                    .map(SettlementInstruction71::getInstgRmbrsmntAgt);
            Optional<BranchAndFinancialInstitutionIdentification61> branchAndFinancialInstitutionIdentification62 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV08::getGrpHdr)
                    .map(GroupHeader931::getSttlmInf)
                    .map(SettlementInstruction71::getInstdRmbrsmntAgt);
            if (branchAndFinancialInstitutionIdentification6.isPresent()) {
                if (!branchAndFinancialInstitutionIdentification61.isPresent() || !branchAndFinancialInstitutionIdentification62.isPresent()) {
                    return new Constraints(Pacs00800108ErrorConstant.C42_ERROR_SEVERITY, Pacs00800108ErrorConstant.C42_ERROR_CODE, Pacs00800108ErrorConstant.C42_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C43 TotalInterbankSettlementAmountAndDateRule ✓
     * (Rule)
     * If TotalInterbankSettlementAmount is present, then InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     * todo TotalInterbankSettlementAmount TtlIntrBkSttlmAmt    InterbankSettlementDate IntrBkSttlmDt 不存在
     *
     * @return C43检查规则
     */
    public Constraints checkC43() {
//        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
//            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
//            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
//            Optional<ActiveCurrencyAndAmount> activeCurrencyAndAmount = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
//                    .map(GroupHeader96::getTtlIntrBkSttlmAmt);
//            Optional<XMLGregorianCalendar> xmlGregorianCalendar = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
//                    .map(GroupHeader96::getIntrBkSttlmDt);
//            if (activeCurrencyAndAmount.isPresent() && !xmlGregorianCalendar.isPresent()) {
//                return new Constraints(Pacs00800108ErrorConstant.C45_ERROR_SEVERITY, Pacs00800108ErrorConstant.C45_ERROR_CODE, Pacs00800108ErrorConstant.C45_ERROR_TEXT);
//            }
//        }

        return null;
    }

    /**
     * C44 TotalInterbankSettlementAmountAndSumRule
     * (Rule)
     * If GroupHeader/TotalInterbankSettlementAmount is present, then it must
     * equal the sum of all occurrences of CreditTransferTransactionInformation/
     * InterbankSettlementAmount. (CrossElementComplexRule)
     * todo TotalInterbankSettlementAmount TtlIntrBkSttlmAmt 不存在
     *
     * @return C44检查规则
     */
    public Constraints checkC44() {

        return null;
    }

    /**
     * C45 TotalInterbankSettlementAmountRule ✓
     * (Rule)
     * If GroupHeader/TotalInterbankSettlementAmount is present, then all occurrences
     * of CreditTransferTransactionInformation/InterbankSettlementAmount
     * must have the same currency as the currency of GroupHeader/
     * TotalInterbankSettlementAmount. (CrossElementComplexRule)
     * todo TotalInterbankSettlementAmount TtlIntrBkSttlmAmt 不存在
     *
     * @return C45检查规则
     */
    public Constraints checkC45() {

        return null;
    }

    /**
     * C46 TransactionIdentificationPresenceRule
     * (Rule)
     * TransactionIdentification or UETR must be present. Both may be
     * present (CrossElementSimpleRule)
     *
     * @return C46检查规则
     */
    public Constraints checkC46() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV08 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                CreditTransferTransaction391 cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
                if (JudgeUtils.isNotNull(pmtId)) {
                    String txId = pmtId.getTxId();
                    String uetr = pmtId.getUETR();
                    if (JudgeUtils.isNull(txId) && JudgeUtils.isNull(uetr)) {
                        return new Constraints(Pacs00800108ErrorConstant.C46_ERROR_SEVERITY, Pacs00800108ErrorConstant.C46_ERROR_CODE, Pacs00800108ErrorConstant.C46_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * C47 TransactionInterbankSettlementDateRule ✓
     * (Rule)
     * If GroupHeader/InterbankSettlementDate is not present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     * todo GroupHeader/InterbankSettlementDate getIntrBkSttlmDt 不存在
     *
     * @return C47检查规则
     */
    public Constraints checkC47() {
        return null;
    }


    /**
     * @return C检查规则
     */
    public String checkC() {


        return "未更改调用";
    }


}
