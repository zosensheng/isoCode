//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:37 PM CST 
//


package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00900108ErrorConstant;
import com.hisun.kont.mx.msg.pacs.pacs00900108.*;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="FICdtTrf" type="{urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08}FinancialInstitutionCreditTransferV08"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
        "fiCdtTrf"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08")
public class Pacs00900108 {

    @XmlElement(name = "FICdtTrf", required = true)
    protected FinancialInstitutionCreditTransferV08 fiCdtTrf;

    /**
     * 获取fiCdtTrf属性的值。
     *
     * @return possible object is
     * {@link FinancialInstitutionCreditTransferV08 }
     */
    public FinancialInstitutionCreditTransferV08 getFICdtTrf() {
        return fiCdtTrf;
    }

    /**
     * 设置fiCdtTrf属性的值。
     *
     * @param value allowed object is
     *              {@link FinancialInstitutionCreditTransferV08 }
     */
    public void setFICdtTrf(FinancialInstitutionCreditTransferV08 value) {
        this.fiCdtTrf = value;
    }

    /**
     * C1 ActiveCurrency ✓
     * (Rule)
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered
     * with the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     * todo are not yet withdrawn on the day the message containing the Currency is exchanged.
     * <TtlIntrBkSttlmAmt>
     * <IntrBkSttlmAmt>
     *
     * @return 返回C1检查结果
     */
    public Constraints checkC1() {


        return null;
    }


    /**
     * C2 ActiveOrHistoricCurrency ✓
     * (Rule)
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * todo  may be or not be withdrawn on the day the message containing the Currency is exchanged.
     *
     * @return C2规则检查
     */
    public Constraints checkC2() {

        return null;
    }


    /**
     * C3 AnyBIC ✓
     * (Rule)
     * Only a valid Business identifier code is allowed. Business identifier codes for financial
     * or non-financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * 7.4.2.36 UnderlyingCustomerCreditTransfer <UndrlygCstmrCdtTrf>
     * 7.4.2.36.1 UltimateDebtor <UltmtDbtr>
     * 7.4.2.36.2 InitiatingParty <InitgPty>
     * 7.4.2.36.3 Debtor <Dbtr>
     * 7.4.2.36.21 Creditor <Cdtr>
     * 7.4.2.36.23 UltimateCreditor <UltmtCdtr>
     * todo
     *
     * @return C3规则检查
     */
    public Constraints checkC3() {

        return null;
    }


    /**
     * C4 BICFI ✓
     * (Rule)
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * 7.4.1 GroupHeader <GrpHdr>
     * 7.4.1.8 SettlementInformation <SttlmInf>
     * 7.4.1.8.4 InstructingReimbursementAgent <InstgRmbrsmntAgt>
     * 7.4.1.8.6 InstructedReimbursementAgent <InstdRmbrsmntAgt>
     * 7.4.1.8.8 ThirdReimbursementAgent <ThrdRmbrsmntAgt>
     * 7.4.1.10 InstructingAgent <InstgAgt>
     * 7.4.1.11 InstructedAgent <InstdAgt>
     * <p>
     * 7.4.2 CreditTransferTransactionInformation <CdtTrfTxInf>
     * 7.4.2.8 PreviousInstructingAgent1 <PrvsInstgAgt1>
     * 7.4.2.10 PreviousInstructingAgent2 <PrvsInstgAgt2>
     * 7.4.2.12 PreviousInstructingAgent3 <PrvsInstgAgt3>
     * 7.4.2.14 InstructingAgent <InstgAgt>
     * 7.4.2.15 InstructedAgent <InstdAgt>
     * 7.4.2.16 IntermediaryAgent1 <IntrmyAgt1>
     * 7.4.2.18 IntermediaryAgent2 <IntrmyAgt2>
     * 7.4.2.20 IntermediaryAgent3 <IntrmyAgt3>
     * 7.4.2.22 UltimateDebtor <UltmtDbtr>
     * 7.4.2.23 Debtor <Dbtr>
     * 7.4.2.25 DebtorAgent <DbtrAgt>
     * 7.4.2.27 CreditorAgent <CdtrAgt>
     * 7.4.2.29 Creditor <Cdtr>
     * 7.4.2.31 UltimateCreditor <UltmtCdtr>
     * <p>
     * 7.4.2.36 UnderlyingCustomerCreditTransfer <UndrlygCstmrCdtTrf>
     * 7.4.2.36.5 DebtorAgent <DbtrAgt>
     * 7.4.2.36.7 PreviousInstructingAgent1 <PrvsInstgAgt1>
     * 7.4.2.36.9 PreviousInstructingAgent2 <PrvsInstgAgt2>
     * 7.4.2.36.11 PreviousInstructingAgent3 <PrvsInstgAgt3>
     * 7.4.2.36.13 IntermediaryAgent1 <IntrmyAgt1>
     * 7.4.2.36.15 IntermediaryAgent2 <IntrmyAgt2>
     * 7.4.2.36.17 IntermediaryAgent3 <IntrmyAgt3>
     * 7.4.2.36.19 CreditorAgent <CdtrAgt>
     * todo
     *
     * @return C4规则检查
     */
    public Constraints checkC4() {

        return null;
    }


    /**
     * C5 Country ✓
     * (Rule)
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     * Dtls
     * Authrty
     * PstlAdr（AdrTp）
     * Details <Dtls> [0..*]
     * **PstlAdr***
     * UltimateDebtor <UltmtDbtr>
     * InitiatingParty <InitgPty>
     * Debtor <Dbtr>
     * Creditor <Cdtr>
     * UltimateCreditor <UltmtCdtr>
     * Invoicer <Invcr>\\
     * Invoicee <Invcee>\\
     * todo
     *
     * @return C5规则检查
     */
    public Constraints checkC5() {

        return null;
    }


    /**
     * C6 CreditorAgentAccountRule ✓
     * (Rule)
     * If CreditorAgentAccount is present, then CreditorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C6规则检查
     */
    public Constraints checkC6() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 cdtrAgtAcct = cdtTrfTxInf.getCdtrAgtAcct();
                BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                if (JudgeUtils.isNotNull(cdtrAgtAcct) && JudgeUtils.isNull(cdtrAgt)) {
                    return new Constraints(Pacs00900108ErrorConstant.C6_ERROR_SEVERITY, Pacs00900108ErrorConstant.C6_ERROR_CODE, Pacs00900108ErrorConstant.C6_ERROR_TEXT);
                }
            }

        }
        return null;
    }

    /**
     * C7 CurrencyAmount ✓
     * (Rule)
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * RfrdDocAmt Strd RmtInf UndrlygCstmrCdtTrf CdtTrfTxInf
     * todo
     *
     * @return C7规则检查
     */
    public Constraints checkC7() {

        return null;
    }


//    private static Constraints RuleUtils.checkCcyAndDigits(BigDecimal bigDecimal) {
//        String bigS = bigDecimal.toString();
//        int totalDigits = bigS.length();
//        int fractionDigits = 0;
//        if (bigS.contains(".")) {
//            String[] split = bigS.split("\\.");
//            if (split.length > 2) {
//                return new Constraints(Pacs00900108ErrorConstant.C7_ERROR_SEVERITY, Pacs00900108ErrorConstant.C7_ERROR_CODE, Pacs00900108ErrorConstant.C7_ERROR_TEXT, bigS);
//            }
//            totalDigits = totalDigits - 1;
//            fractionDigits = split[1].length();
//        }
//        if (totalDigits > 18 || fractionDigits > 5) {
//            return new Constraints(Pacs00900108ErrorConstant.C7_ERROR_SEVERITY, Pacs00900108ErrorConstant.C7_ERROR_CODE, Pacs00900108ErrorConstant.C7_ERROR_TEXT, bigS);
//        } else {
//            return new Constraints(Pacs00900108ErrorConstant.SUCCESS_CODE);
//        }
//    }


    /**
     * C8 CurrencyAmount ✓
     * (Rule)
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * todo
     *
     * @return C8规则检查
     */
    public Constraints checkC8() {

        return null;
    }


    /**
     * C9 DebtorAgentAccountRule ✓
     * (Rule)
     * If DebtorAgentAccount is present, then DebtorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C9规则检查
     */
    public Constraints checkC9() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 dbtrAgtAcct = cdtTrfTxInf.getDbtrAgtAcct();
                BranchAndFinancialInstitutionIdentification61 dbtrAgt = cdtTrfTxInf.getDbtrAgt();
                if (JudgeUtils.isNotNull(dbtrAgtAcct) && JudgeUtils.isNull(dbtrAgt)) {
                    return new Constraints(Pacs00900108ErrorConstant.C9_ERROR_SEVERITY, Pacs00900108ErrorConstant.C9_ERROR_CODE, Pacs00900108ErrorConstant.C9_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * C10 GroupHeaderInterbankSettlementDateRule ✓
     * (Rule)
     * If GroupHeader/InterbankSettlementDate is present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate is not
     * allowed. (CrossElementComplexRule)
     * todo GroupHeader/InterbankSettlementDate 不存在
     *
     * @return C10规则检查
     */
    public Constraints checkC10() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
//                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
//                        XMLGregorianCalendar intrBkSttlmDt1 = cdtTrfTxInf.getIntrBkSttlmDt();
//                        if (JudgeUtils.isNotNull(intrBkSttlmDt) && JudgeUtils.isNotNull(intrBkSttlmDt1)) {
//                            return new Constraints(Pacs00900108ErrorConstant.C10_ERROR_SEVERITY, Pacs00900108ErrorConstant.C10_ERROR_CODE, Pacs00900108ErrorConstant.C10_ERROR_TEXT);
//                        }
//                    }
//            }
//        }

        return null;
    }

    /**
     * C11 IBAN ✓
     * (Rule)
     * A valid IBAN consists of all three of the following components: Country Code, check digits and
     * BBAN. (Algorithm)
     * todo
     *
     * @return C11规则检查
     */
    public Constraints checkC11() {

        return null;
    }

    /**
     * C12 InstructedAgentRule ✓
     * (Rule)
     * If GroupHeader/InstructedAgent is present, then CreditTransferTransactionInformation/
     * InstructedAgent is not allowed. (CrossElementComplexRule)
     * todo GroupHeader/InstructedAgent 不存在
     *
     * @return C12规则检查
     */
    public Constraints checkC12() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            List<CreditTransferTransaction56> cdtTrfTxInf = (List<CreditTransferTransaction56>) fiCdtTrf.getCdtTrfTxInf();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
//                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
//                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
//                        BranchAndFinancialInstitutionIdentification6 instdAgt1 = creditTransferTransaction56.getInstdAgt();
//                        if (JudgeUtils.isNotNull(instdAgt) && JudgeUtils.isNotNull(instdAgt1)) {
//                            return new Constraints(Pacs00900108ErrorConstant.C14_ERROR_SEVERITY, Pacs00900108ErrorConstant.C14_ERROR_CODE, Pacs00900108ErrorConstant.C14_ERROR_TEXT);
//                        }
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C13 InstructedReimbursementAgentAccountRule ✓
     * (Rule)
     * If InstructedReimbursementAgentAccount is present, then InstructedReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * todo InstructedReimbursementAgentAccount InstructedReimbursementAgent 不存在
     *
     * @return C13规则检查
     */
    public Constraints checkC13() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
//                if (JudgeUtils.isNotNull(sttlmInf)) {
//                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
//                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
//                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct) && JudgeUtils.isNull(instdRmbrsmntAgt)) {
//                        return new Constraints(Pacs00900108ErrorConstant.C15_ERROR_SEVERITY, Pacs00900108ErrorConstant.C15_ERROR_CODE, Pacs00900108ErrorConstant.C15_ERROR_TEXT);
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C14 InstructingAgentRule ✓
     * (Rule)
     * If GroupHeader/InstructingAgent is present, then CreditTransferTransactionInformation/
     * InstructingAgent is not allowed. (CrossElementComplexRule)
     * todo getInstgAgt 不存在
     *
     * @return C14规则检查
     */
    public Constraints checkC14() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
//                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
//                    BranchAndFinancialInstitutionIdentification62 instgAgt1 = cdtTrfTxInf.getInstgAgt();
//                    if (JudgeUtils.isNotNull(instgAgt) && JudgeUtils.isNotNull(instgAgt1)) {
//                        return new Constraints(Pacs00900108ErrorConstant.C16_ERROR_SEVERITY, Pacs00900108ErrorConstant.C16_ERROR_CODE, Pacs00900108ErrorConstant.C16_ERROR_TEXT);
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C15 InstructingReimbursementAgentAccountRule ✓
     * (Rule)
     * If InstructingReimbursementAgentAccount is present, then InstructingReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * ·todo InstructingReimbursementAgentAccount InstructingReimbursementAgent 不存在
     *
     * @return C15规则检查
     */
    public Constraints checkC15() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
//                if (JudgeUtils.isNotNull(sttlmInf)) {
//                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
//                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
//                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
//                        return new Constraints(Pacs00900108ErrorConstant.C17_ERROR_SEVERITY, Pacs00900108ErrorConstant.C17_ERROR_CODE, Pacs00900108ErrorConstant.C17_ERROR_TEXT);
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C16 IntermediaryAgent1AccountRule ✓
     * (Rule)
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C16规则检查
     */
    public Constraints checkC16() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 intrmyAgt1Acct = cdtTrfTxInf.getIntrmyAgt1Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                if (JudgeUtils.isNotNull(intrmyAgt1Acct) && JudgeUtils.isNull(intrmyAgt1)) {
                    return new Constraints(Pacs00900108ErrorConstant.C16_ERROR_SEVERITY, Pacs00900108ErrorConstant.C16_ERROR_CODE, Pacs00900108ErrorConstant.C16_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C17 IntermediaryAgent1AccountRule ✓
     * (Rule)
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C17规则检查
     */
    public Constraints checkC17() {

        return null;
    }

    /**
     * C18 IntermediaryAgent1Rule ✓
     * (Rule)
     * If IntermediaryAgent1 is present, then CreditorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C18规则检查
     */
    public Constraints checkC18() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                if (JudgeUtils.isNotNull(intrmyAgt1) && JudgeUtils.isNull(cdtrAgt)) {
                    return new Constraints(Pacs00900108ErrorConstant.C18_ERROR_SEVERITY, Pacs00900108ErrorConstant.C18_ERROR_CODE, Pacs00900108ErrorConstant.C18_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C19 IntermediaryAgent2AccountRule ✓
     * (Rule)
     * If IntermediaryAgent2Account is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C19规则检查
     */
    public Constraints checkC19() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 intrmyAgt2Acct = cdtTrfTxInf.getIntrmyAgt2Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                if (JudgeUtils.isNotNull(intrmyAgt2Acct) && JudgeUtils.isNull(intrmyAgt2)) {
                    return new Constraints(Pacs00900108ErrorConstant.C19_ERROR_SEVERITY, Pacs00900108ErrorConstant.C19_ERROR_CODE, Pacs00900108ErrorConstant.C19_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C20 IntermediaryAgent2AccountRule ✓
     * (Rule)
     * If IntermediaryAgent2Account is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C20规则检查
     */
    public Constraints checkC20() {

        return null;
    }

    /**
     * C21 IntermediaryAgent2Rule ✓
     * (Rule)
     * If IntermediaryAgent2 is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C21规则检查
     */
    public Constraints checkC21() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
                    return new Constraints(Pacs00900108ErrorConstant.C21_ERROR_SEVERITY, Pacs00900108ErrorConstant.C21_ERROR_CODE, Pacs00900108ErrorConstant.C21_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C22 IntermediaryAgent2Rule ✓
     * (Rule)
     * If IntermediaryAgent2 is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C22规则检查
     */
    public Constraints checkC22() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
//            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
//                    CreditTransferTransaction52 undrlygCstmrCdtTrf = cdtTrfTxInf.getUndrlygCstmrCdtTrf();
//                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
//                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = undrlygCstmrCdtTrf.getIntrmyAgt2();
//                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = undrlygCstmrCdtTrf.getIntrmyAgt1();
//                        if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
//                            return new Constraints(Pacs00900108ErrorConstant.C24_ERROR_SEVERITY, Pacs00900108ErrorConstant.C24_ERROR_CODE, Pacs00900108ErrorConstant.C24_ERROR_TEXT);
//                        }
//                    }
//            }
//        }
        return null;
    }

    /**
     * C23 IntermediaryAgent3AccountRule ✓
     * (Rule)
     * If IntermediaryAgent3Account is present, then IntermediaryAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C23规则检查
     */
    public Constraints checkC23() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 intrmyAgt3Acct = cdtTrfTxInf.getIntrmyAgt3Acct();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                if (JudgeUtils.isNotNull(intrmyAgt3Acct) && JudgeUtils.isNull(intrmyAgt3)) {
                    return new Constraints(Pacs00900108ErrorConstant.C23_ERROR_SEVERITY, Pacs00900108ErrorConstant.C23_ERROR_CODE, Pacs00900108ErrorConstant.C23_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C24 IntermediaryAgent3AccountRule ✓
     * (Rule)
     * If IntermediaryAgent3Account is present, then IntermediaryAgent3 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C24规则检查
     */
    public Constraints checkC24() {

        return null;
    }

    /**
     * C25 IntermediaryAgent3Rule ✓
     * (Rule)
     * If IntermediaryAgent3 is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C25规则检查
     */
    public Constraints checkC25() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                if (JudgeUtils.isNotNull(intrmyAgt3) && JudgeUtils.isNull(intrmyAgt2)) {
                    return new Constraints(Pacs00900108ErrorConstant.C25_ERROR_SEVERITY, Pacs00900108ErrorConstant.C25_ERROR_CODE, Pacs00900108ErrorConstant.C25_ERROR_TEXT);
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
     * todo 没打勾
     *
     * @return C26规则检查
     */
    public Constraints checkC26() {

        return null;
    }

    /**
     * C27 PaymentTypeInformationRule ✓
     * (Rule)
     * If GroupHeader/PaymentTypeInformation is present, then
     * CreditTransferTransactionInformation/PaymentTypeInformation is not
     * allowed. (CrossElementComplexRule)
     * todo GroupHeader/PaymentTypeInformation 不存在
     *
     * @return C27规则检查
     */
    public Constraints checkC27() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                PaymentTypeInformation28 pmtTpInf = grpHdr.getPmtTpInf();
//                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
//                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
//                        PaymentTypeInformation28 pmtTpInf1 = creditTransferTransaction56.getPmtTpInf();
//                        if (JudgeUtils.isNotNull(pmtTpInf) && JudgeUtils.isNotNull(pmtTpInf1)) {
//                            return new Constraints(Pacs00900108ErrorConstant.C29_ERROR_SEVERITY, Pacs00900108ErrorConstant.C29_ERROR_CODE, Pacs00900108ErrorConstant.C29_ERROR_TEXT);
//                        }
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C28 PreviousInstructingAgent1AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C28规则检查
     */
    public Constraints checkC28() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 prvsInstgAgt1Acct = cdtTrfTxInf.getPrvsInstgAgt1Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                if (JudgeUtils.isNotNull(prvsInstgAgt1Acct) && JudgeUtils.isNull(prvsInstgAgt1)) {
                    return new Constraints(Pacs00900108ErrorConstant.C28_ERROR_SEVERITY, Pacs00900108ErrorConstant.C28_ERROR_CODE, Pacs00900108ErrorConstant.C28_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C29 PreviousInstructingAgent1AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C29规则检查
     */
    public Constraints checkC29() {

        return null;
    }

    /**
     * C32 PreviousInstructingAgent2AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent2Account is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C32规则检查
     */
    public Constraints checkC32() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 prvsInstgAgt2Acct = cdtTrfTxInf.getPrvsInstgAgt2Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                if (JudgeUtils.isNotNull(prvsInstgAgt2Acct) && JudgeUtils.isNull(prvsInstgAgt2)) {
                    return new Constraints(Pacs00900108ErrorConstant.C33_ERROR_SEVERITY, Pacs00900108ErrorConstant.C33_ERROR_CODE, Pacs00900108ErrorConstant.C33_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C33 PreviousInstructingAgent2AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent2Account is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C33规则检查
     */
    public Constraints checkC33() {

        return null;
    }

    /**
     * C34 PreviousInstructingAgent3AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent3Account is present, then PreviousInstructingAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C34规则检查
     */
    public Constraints checkC34() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                CashAccount381 prvsInstgAgt3Acct = cdtTrfTxInf.getPrvsInstgAgt3Acct();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                if (JudgeUtils.isNotNull(prvsInstgAgt3Acct) && JudgeUtils.isNull(prvsInstgAgt3)) {
                    return new Constraints(Pacs00900108ErrorConstant.C34_ERROR_SEVERITY, Pacs00900108ErrorConstant.C34_ERROR_CODE, Pacs00900108ErrorConstant.C34_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C35 PreviousInstructingAgent3AccountRule ✓
     * (Rule)
     * If PreviousInstructingAgent3Account is present, then PreviousInstructingAgent3 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C35规则检查
     */
    public Constraints checkC35() {

        return null;
    }

    /**
     * C36 PreviousInstructionAgent2Rule ✓
     * (Rule)
     * If PreviousInstructingAgent2 is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C36规则检查
     */
    public Constraints checkC36() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                if (JudgeUtils.isNotNull(prvsInstgAgt2) && JudgeUtils.isNull(prvsInstgAgt1)) {
                    return new Constraints(Pacs00900108ErrorConstant.C36_ERROR_SEVERITY, Pacs00900108ErrorConstant.C36_ERROR_CODE, Pacs00900108ErrorConstant.C36_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C37 PreviousInstructionAgent2Rule ✓
     * (Rule)
     * If PreviousInstructingAgent2 is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C37规则检查
     */
    public Constraints checkC37() {

        return null;
    }

    /**
     * C38 PreviousInstructionAgent3Rule ✓
     * (Rule)
     * If PreviousInstructingAgent3 is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C38规则检查
     */
    public Constraints checkC38() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                if (JudgeUtils.isNotNull(prvsInstgAgt3) && JudgeUtils.isNull(prvsInstgAgt2)) {
                    return new Constraints(Pacs00900108ErrorConstant.C38_ERROR_SEVERITY, Pacs00900108ErrorConstant.C38_ERROR_CODE, Pacs00900108ErrorConstant.C38_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * C39 PreviousInstructionAgent3Rule ✓
     * (Rule)
     * If PreviousInstructingAgent3 is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C39规则检查
     */
    public Constraints checkC39() {

        return null;
    }

    /**
     * C40 SettlementMethodAgentRule ✓
     * (Rule)
     * If SettlementMethod is equal to INDA or INGA, then ReimbursementAgent(s) and
     * ClearingSystem are not allowed. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C40规则检查
     */
    public Constraints checkC40() {

        return null;
    }

    /**
     * C41 SettlementMethodClearingRule ✓
     * (Rule)
     * If SettlementMethod is equal to CLRG, then SettlementAccount and ReimbursementAgent(s)
     * are not allowed. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C41规则检查
     */
    public Constraints checkC41() {

        return null;
    }

    /**
     * C42 SettlementMethodCoverAgentRule ✓
     * (Rule)
     * If SettlementMethod is equal to COVE, then InstructedReimbursementAgent or
     * InstructingReimbursementAgent must be present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C42规则检查
     */
    public Constraints checkC42() {

        return null;
    }

    /**
     * C43 SettlementMethodCoverRule ✓
     * (Rule)
     * If SettlementMethod is equal to COVE, then SettlementAccount and ClearingSystem are not
     * allowed. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C43规则检查
     */
    public Constraints checkC43() {

        return null;
    }

    /**
     * C46 ThirdReimbursementAgentAccountRule ✓
     * (Rule)
     * If ThirdReimbursementAgentAccount is present, then ThirdReimbursementAgent must be
     * present. (CrossElementComplexRule)
     * todo 没打勾
     *
     * @return C46规则检查
     */
    public Constraints checkC46() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
//                if (JudgeUtils.isNotNull(sttlmInf)) {
//                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
//                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
//                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct) && JudgeUtils.isNull(thrdRmbrsmntAgt)) {
//                        return new Constraints(Pacs00900108ErrorConstant.C48_ERROR_SEVERITY, Pacs00900108ErrorConstant.C48_ERROR_CODE, Pacs00900108ErrorConstant.C48_ERROR_TEXT);
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C47 ThirdReimbursementAgentRule ✓
     * (Rule)
     * If ThirdReimbursementAgent is present, then InstructingReimbursementAgent and
     * InstructedReimbursementAgent must both be present. (CrossElementComplexRule)
     * Error
     * todo 没打勾
     *
     * @return C47规则检查
     */
    public Constraints checkC47() {

        return null;
    }

    /**
     * C48 TotalInterbankSettlementAmountAndDateRule ✓
     * (Rule)
     * If TotalInterbankSettlementAmount is present, then InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     * todo TotalInterbankSettlementAmount InterbankSettlementDate 不存在
     *
     * @return C48规则检查
     */
    public Constraints checkC48() {
//        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
//        if (JudgeUtils.isNotNull(fiCdtTrf)) {
//            GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
//            if (JudgeUtils.isNotNull(grpHdr)) {
//                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
//                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
//                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt) && JudgeUtils.isNull(intrBkSttlmDt)) {
//                    return new Constraints(Pacs00900108ErrorConstant.C50_ERROR_SEVERITY, Pacs00900108ErrorConstant.C50_ERROR_CODE, Pacs00900108ErrorConstant.C50_ERROR_TEXT);
//                }
//            }
//        }
        return null;
    }

    /**
     * C49 TotalInterbankSettlementAmountAndSumRule
     * (Rule)
     * If GroupHeader/TotalInterbankSettlementAmount is present, then it must
     * equal the sum of all occurrences of CreditTransferTransactionInformation/
     * InterbankSettlementAmount. (CrossElementComplexRule)
     * todo 未打勾
     *
     * @return C49规则检查
     */
    public Constraints checkC49() {

        return null;
    }

    /**
     * C50 TotalInterbankSettlementAmountRule ✓
     * (Rule)
     * If GroupHeader/TotalInterbankSettlementAmount is present, then all occurrences
     * of CreditTransferTransactionInformation/InterbankSettlementAmount
     * must have the same currency as the currency of GroupHeader/
     * TotalInterbankSettlementAmount. (CrossElementComplexRule)
     * todo TotalInterbankSettlementAmount 不存在
     *
     * @return C50规则检查
     */
    public Constraints checkC50() {
//        if (JudgeUtils.isNotNull(this.getFICdtTrf())) {
//            FinancialInstitutionCreditTransferV08 fiToFICstmrCdtTrf = this.getFICdtTrf();
//            Optional<FinancialInstitutionCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
//            Optional<String> aCcy = fiToFICustomerCreditTransferV10.map(FinancialInstitutionCreditTransferV10::getGrpHdr)
//                    .map(GroupHeader96::getTtlIntrBkSttlmAmt)
//                    .map(ActiveCurrencyAndAmount::getCcy);
//            if (aCcy.isPresent()) {
//                String ttlIntrBkSttlmAmtCcy = fiToFICstmrCdtTrf.getGrpHdr().getTtlIntrBkSttlmAmt().getCcy();
//                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
//                    List<CreditTransferTransaction56> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
//                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
//                        ActiveCurrencyAndAmount intrBkSttlmAmt1 = creditTransferTransaction56.getIntrBkSttlmAmt();
//                        if (JudgeUtils.isNotNull(intrBkSttlmAmt1)) {
//                            String ccy = intrBkSttlmAmt1.getCcy();
//                            if (!ccy.equals(ttlIntrBkSttlmAmtCcy)) {
//                                return new Constraints(Pacs00900108ErrorConstant.C52_ERROR_SEVERITY, Pacs00900108ErrorConstant.C52_ERROR_CODE, Pacs00900108ErrorConstant.C52_ERROR_TEXT, ccy);
//                            }
//                        }
//                    }
//                }
//            }
//        }
        return null;
    }

    /**
     * C51 TransactionIdentificationPresenceRule
     * (Rule)
     * TransactionIdentification or UETR must be present. Both may be
     * present (CrossElementSimpleRule)
     *
     * @return C51规则检查
     */
    public Constraints checkC51() {
        FinancialInstitutionCreditTransferV08 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
                if (JudgeUtils.isNotNull(pmtId)) {
                    String txId = pmtId.getTxId();
                    String uetr = pmtId.getUETR();
                    if (JudgeUtils.isNull(txId) && JudgeUtils.isNull(uetr)) {
                        return new Constraints(Pacs00900108ErrorConstant.C51_ERROR_SEVERITY, Pacs00900108ErrorConstant.C51_ERROR_CODE, Pacs00900108ErrorConstant.C51_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * C52 TransactionInterbankSettlementDateRule ✓
     * (Rule)
     * If GroupHeader/InterbankSettlementDate is not present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     * todo 不存在
     *
     * @return C52规则检查
     */
    public Constraints checkC52() {
        return null;
    }


}
