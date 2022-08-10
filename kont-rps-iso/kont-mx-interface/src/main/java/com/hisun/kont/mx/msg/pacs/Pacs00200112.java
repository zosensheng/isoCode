package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00200112ErrorConstant;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.util.RuleUtils;

import javax.xml.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>Document053 complex type�� Java �ࡣ
 * <p>
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;complexType name="Document053">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFIPmtStsRpt" type="{}FIToFIPaymentStatusReportV12"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document053", propOrder = {
        "fiToFIPmtStsRpt"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.12")
public class Pacs00200112 {


    @XmlElement(name = "FIToFIPmtStsRpt", required = true)
    protected FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt;

    /**
     * ��ȡfiToFIPmtStsRpt���Ե�ֵ��
     *
     * @return possible object is
     * {@link FIToFIPaymentStatusReportV12 }
     */
    public FIToFIPaymentStatusReportV12 getFIToFIPmtStsRpt() {
        return fiToFIPmtStsRpt;
    }

    /**
     * ����fiToFIPmtStsRpt���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link FIToFIPaymentStatusReportV12 }
     */
    public void setFIToFIPmtStsRpt(FIToFIPaymentStatusReportV12 value) {
        this.fiToFIPmtStsRpt = value;
    }

    //暂不实现
    public String message() {
        return null;
    }

    /**
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.7 SettlementInformation <SttlmInf>
     * 2.4.3.16.7.2 SettlementAccount <SttlmAcct>
     * 2.4.3.16.7.2.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.7.5 InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct>
     * 2.4.3.16.7.5.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.7.7 InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct>
     * 2.4.3.16.7.7.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.7.9 ThirdReimbursementAgentAccount <ThrdRmbrsmntAgtAcct>
     * 2.4.3.16.7.9.3 Currency <Ccy>
     * <p>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     * 2.4.3.16.10.1.4 AmendmentInformationDetails <AmdmntInfDtls>
     * 2.4.3.16.10.1.4.4 OriginalCreditorAgentAccount <OrgnlCdtrAgtAcct>
     * 2.4.3.16.10.1.4.4.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.10.1.4.6 OriginalDebtorAccount <OrgnlDbtrAcct>
     * 2.4.3.16.10.1.4.6.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.10.1.4.8 OriginalDebtorAgentAccount <OrgnlDbtrAgtAcct>
     * 2.4.3.16.10.1.4.8.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.14 DebtorAccount <DbtrAcct>
     * 2.4.3.16.14.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.16 DebtorAgentAccount <DbtrAgtAcct>
     * 2.4.3.16.16.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.18 CreditorAgentAccount <CdtrAgtAcct>
     * 2.4.3.16.18.3 Currency <Ccy>
     * <p>
     * 2.4.3.16.20 CreditorAccount <CdtrAcct>
     * 2.4.3.16.20.3 Currency <Ccy>
     *
     * @return 返回C1检查结果
     */
    public Constraints checkC1() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt = orgnlTxRef.getIntrBkSttlmAmt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(intrBkSttlmAmt).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(intrBkSttlmAmt);
                        }
                        RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    List<ReferredDocumentInformation7> rfrdDocInf = structuredRemittanceInformation17.getRfrdDocInf();
                                    if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                        for (ReferredDocumentInformation7 referredDocumentInformation7 : rfrdDocInf) {
                                            List<DocumentLineInformation1> lineDtls = referredDocumentInformation7.getLineDtls();
                                            if (JudgeUtils.isNotNull(lineDtls)) {
                                                for (DocumentLineInformation1 lineDtl : lineDtls) {
                                                    RemittanceAmount3 amt = lineDtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        ActiveOrHistoricCurrencyAndAmount duePyblAmt = amt.getDuePyblAmt();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(duePyblAmt).getErrorCode())) {
                                                            return RuleUtils.checkActiveOrHistoricCurrency(duePyblAmt);
                                                        }
                                                        List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                        if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(amt1).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(amt1);
                                                                }
                                                            }
                                                        }
                                                        ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(cdtNoteAmt).getErrorCode())) {
                                                            return RuleUtils.checkActiveOrHistoricCurrency(cdtNoteAmt);
                                                        }
                                                        List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                                            for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(amt1).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(amt1);
                                                                }
                                                            }
                                                        }
                                                        List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                        if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                            for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(amt1).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(amt1);
                                                                }
                                                            }
                                                        }
                                                        ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(rmtdAmt).getErrorCode())) {
                                                            return RuleUtils.checkActiveOrHistoricCurrency(rmtdAmt);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    TaxData1 taxRmt = structuredRemittanceInformation17.getTaxRmt();
                                    if (JudgeUtils.isNotNull(taxRmt)) {
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ttlTaxblBaseAmt).getErrorCode())) {
                                            return RuleUtils.checkActiveOrHistoricCurrency(ttlTaxblBaseAmt);
                                        }
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ttlTaxAmt).getErrorCode())) {
                                            return RuleUtils.checkActiveOrHistoricCurrency(ttlTaxAmt);
                                        }
                                        List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                        if (JudgeUtils.isNotNull(rcrd)) {
                                            for (TaxRecord3 taxRecord3 : rcrd) {
                                                TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(taxblBaseAmt).getErrorCode())) {
                                                        return RuleUtils.checkActiveOrHistoricCurrency(taxblBaseAmt);
                                                    }
                                                    ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ttlAmt).getErrorCode())) {
                                                        return RuleUtils.checkActiveOrHistoricCurrency(ttlAmt);
                                                    }
                                                    List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                                    if (JudgeUtils.isNotNull(dtls)) {
                                                        for (TaxRecordDetails3 dtl : dtls) {
                                                            ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(amt).getErrorCode())) {
                                                                return RuleUtils.checkActiveOrHistoricCurrency(amt);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(sttlmAcct).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(sttlmAcct);
                            }
                            CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(instgRmbrsmntAgtAcct).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(instgRmbrsmntAgtAcct);
                            }
                            CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(instdRmbrsmntAgtAcct).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(instdRmbrsmntAgtAcct);
                            }
                            CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(thrdRmbrsmntAgtAcct).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(thrdRmbrsmntAgtAcct);
                            }
                        }
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    CashAccount40 orgnlCdtrAgtAcct = amdmntInfDtls.getOrgnlCdtrAgtAcct();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(orgnlCdtrAgtAcct).getErrorCode())) {
                                        return RuleUtils.checkActiveOrHistoricCurrency(orgnlCdtrAgtAcct);
                                    }
                                    CashAccount40 orgnlDbtrAcct = amdmntInfDtls.getOrgnlDbtrAcct();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(orgnlDbtrAcct).getErrorCode())) {
                                        return RuleUtils.checkActiveOrHistoricCurrency(orgnlDbtrAcct);
                                    }
                                    CashAccount40 orgnlDbtrAgtAcct = amdmntInfDtls.getOrgnlDbtrAgtAcct();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(orgnlDbtrAgtAcct).getErrorCode())) {
                                        return RuleUtils.checkActiveOrHistoricCurrency(orgnlDbtrAgtAcct);
                                    }
                                }
                            }
                        }
                        CashAccount40 dbtrAcct = orgnlTxRef.getDbtrAcct();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(dbtrAcct).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(dbtrAcct);
                        }
                        CashAccount40 dbtrAgtAcct = orgnlTxRef.getDbtrAgtAcct();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(dbtrAgtAcct).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(dbtrAgtAcct);
                        }
                        CashAccount40 cdtrAgtAcct = orgnlTxRef.getCdtrAgtAcct();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(cdtrAgtAcct).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(cdtrAgtAcct);
                        }
                        CashAccount40 cdtrAcct = orgnlTxRef.getCdtrAcct();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(cdtrAcct).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(cdtrAcct);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If AmendmentIndicator is false, then AmendmentInformationDetails is not
     * allowed. (CrossElementComplexRule)
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     *
     * @return 返回C2检查结果
     */
    public Constraints checkC2() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                Boolean amdmntInd = drctDbtMndt.isAmdmntInd();
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (amdmntInd.equals(false)) {
                                    if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C2_ERROR_SEVERITY, Pacs00200112ErrorConstant.C2_ERROR_CODE, Pacs00200112ErrorConstant.C2_ERROR_TEXT);
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
     * If AmendmentIndicator is true, then AmendementInformationDetails must be
     * present. (CrossElementComplexRule)
     *
     * @return 返回C3检查结果
     */
    public Constraints checkC3() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                Boolean amdmntInd = drctDbtMndt.isAmdmntInd();
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (amdmntInd.equals(true)) {
                                    if (JudgeUtils.isNull(amdmntInfDtls)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C3_ERROR_SEVERITY, Pacs00200112ErrorConstant.C3_ERROR_CODE, Pacs00200112ErrorConstant.C3_ERROR_TEXT);
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
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * <p>
     * 2.4.2 OriginalGroupInformationAndStatus <OrgnlGrpInfAndSts>
     * 2.4.2.7 StatusReasonInformation <StsRsnInf>
     * 2.4.2.7.1 Originator <Orgtr>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.8 StatusReasonInformation <StsRsnInf>
     * 2.4.3.8.1 Originator <Orgtr>
     * <p>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.6 CreditorSchemeIdentification <CdtrSchmeId>
     * <p>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     * 2.4.3.16.10.1.4 AmendmentInformationDetails <AmdmntInfDtls>
     * 2.4.3.16.10.1.4.2 OriginalCreditorSchemeIdentification <OrgnlCdtrSchmeId>
     * <p>
     * 2.4.3.16.10.1.4.5 OriginalDebtor <OrgnlDbtr>
     * <p>
     * 2.4.3.16.11 RemittanceInformation <RmtInf>
     * 2.4.3.16.11.2 Structured <Strd>
     * 2.4.3.16.11.2.4 Invoicer <Invcr>
     * <p>
     * 2.4.3.16.11.2.5 Invoicee <Invcee>
     *
     * @return 返回C4检查结果
     */
    public Constraints checkC4() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    List<StatusReasonInformation12> stsRsnInf = orgnlGrpInfAndSt.getStsRsnInf();
                    if (JudgeUtils.isNotNull(stsRsnInf)) {
                        for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                            PartyIdentification135 orgtr = statusReasonInformation12.getOrgtr();
                            if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(orgtr))) {
                                return RuleUtils.checkAnyBIC(orgtr);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    List<StatusReasonInformation12> stsRsnInf = txInfAndSt.getStsRsnInf();
                    if (JudgeUtils.isNotNull(stsRsnInf)) {
                        for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                            PartyIdentification135 orgtr = statusReasonInformation12.getOrgtr();
                            if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(orgtr))) {
                                return RuleUtils.checkAnyBIC(orgtr);
                            }
                        }
                    }
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        PartyIdentification135 cdtrSchmeId = orgnlTxRef.getCdtrSchmeId();
                        if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(cdtrSchmeId))) {
                            return RuleUtils.checkAnyBIC(cdtrSchmeId);
                        }
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    PartyIdentification135 orgnlCdtrSchmeId = amdmntInfDtls.getOrgnlCdtrSchmeId();
                                    if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(orgnlCdtrSchmeId))) {
                                        return RuleUtils.checkAnyBIC(orgnlCdtrSchmeId);
                                    }
                                    PartyIdentification135 orgnlDbtr = amdmntInfDtls.getOrgnlDbtr();
                                    if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(orgnlDbtr))) {
                                        return RuleUtils.checkAnyBIC(orgnlDbtr);
                                    }
                                }
                            }
                        }
                        RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                    if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(invcr))) {
                                        return RuleUtils.checkAnyBIC(invcr);
                                    }
                                    PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                    if (JudgeUtils.isNotNull(RuleUtils.checkAnyBIC(invcee))) {
                                        return RuleUtils.checkAnyBIC(invcee);
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
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * <p>
     * 2.4.1.3 InstructingAgent <InstgAgt>
     * <p>
     * 2.4.1.4 InstructedAgent <InstdAgt>
     * <p>
     * 2.4.3.14 InstructingAgent <InstgAgt>
     * <p>
     * 2.4.3.15 InstructedAgent <InstdAgt>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.7 SettlementInformation <SttlmInf>
     * 2.4.3.16.7.4 InstructingReimbursementAgent <InstgRmbrsmntAgt>
     * <p>
     * 2.4.3.16.7.6 InstructedReimbursementAgent <InstdRmbrsmntAgt>
     * <p>
     * 2.4.3.16.7.8 ThirdReimbursementAgent <ThrdRmbrsmntAgt>
     * <p>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     * 2.4.3.16.10.1.4 AmendmentInformationDetails <AmdmntInfDtls>
     * 2.4.3.16.10.1.4.3 OriginalCreditorAgent <OrgnlCdtrAgt>
     * <p>
     * 2.4.3.16.10.1.4.7 OriginalDebtorAgent <OrgnlDbtrAgt>
     * <p>
     * 2.4.3.16.15 DebtorAgent <DbtrAgt>
     * <p>
     * 2.4.3.16.17 CreditorAgent <CdtrAgt>
     *
     * @return 返回C5检查结果
     */
    public Constraints checkC5() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            GroupHeader101 grpHdr = fiToFIPmtStsRpt.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instdAgt);
                }
                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instgAgt);
                }
            }
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgRmbrsmntAgt).getErrorCode())) {
                                return RuleUtils.checkBICFI(instgRmbrsmntAgt);
                            }
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdRmbrsmntAgt).getErrorCode())) {
                                return RuleUtils.checkBICFI(instdRmbrsmntAgt);
                            }
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(thrdRmbrsmntAgt).getErrorCode())) {
                                return RuleUtils.checkBICFI(thrdRmbrsmntAgt);
                            }
                        }
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    BranchAndFinancialInstitutionIdentification6 orgnlCdtrAgt = amdmntInfDtls.getOrgnlCdtrAgt();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(orgnlCdtrAgt).getErrorCode())) {
                                        return RuleUtils.checkBICFI(orgnlCdtrAgt);
                                    }
                                    BranchAndFinancialInstitutionIdentification6 orgnlDbtrAgt = amdmntInfDtls.getOrgnlDbtrAgt();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(orgnlDbtrAgt).getErrorCode())) {
                                        return RuleUtils.checkBICFI(orgnlDbtrAgt);
                                    }
                                }
                            }
                        }
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = orgnlTxRef.getDbtrAgt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(dbtrAgt).getErrorCode())) {
                            return RuleUtils.checkBICFI(dbtrAgt);
                        }
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = orgnlTxRef.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(cdtrAgt).getErrorCode())) {
                            return RuleUtils.checkBICFI(cdtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     * 2.4.2 OriginalGroupInformationAndStatus <OrgnlGrpInfAndSts>
     * 2.4.2.7 StatusReasonInformation <StsRsnInf>
     * 2.4.2.7.1 Originator <Orgtr>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.8 StatusReasonInformation <StsRsnInf>
     * 2.4.3.8.1 Originator <Orgtr>
     * <p>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.6 CreditorSchemeIdentification <CdtrSchmeId>
     * <p>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     * 2.4.3.16.10.1.4 AmendmentInformationDetails <AmdmntInfDtls>
     * 2.4.3.16.10.1.4.2 OriginalCreditorSchemeIdentification <OrgnlCdtrSchmeId>
     * <p>
     * 2.4.3.16.10.1.4.5 OriginalDebtor <OrgnlDbtr>
     * <p>
     * 2.4.3.16.11 RemittanceInformation <RmtInf>
     * 2.4.3.16.11.2 Structured <Strd>
     * 2.4.3.16.11.2.4 Invoicer <Invcr>
     * <p>
     * 2.4.3.16.11.2.5 Invoicee <Invcee>
     *
     * @return 返回C6检查结果
     */
    public Constraints checkC6() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    List<StatusReasonInformation12> stsRsnInf = orgnlGrpInfAndSt.getStsRsnInf();
                    if (JudgeUtils.isNotNull(stsRsnInf)) {
                        for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                            PartyIdentification135 orgtr = statusReasonInformation12.getOrgtr();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(orgtr).getErrorCode())) {
                                return RuleUtils.checkCountry(orgtr);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    List<StatusReasonInformation12> stsRsnInf = txInfAndSt.getStsRsnInf();
                    if (JudgeUtils.isNotNull(stsRsnInf)) {
                        for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                            PartyIdentification135 orgtr = statusReasonInformation12.getOrgtr();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(orgtr).getErrorCode())) {
                                return RuleUtils.checkCountry(orgtr);
                            }
                        }
                    }
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        PartyIdentification135 cdtrSchmeId = orgnlTxRef.getCdtrSchmeId();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(cdtrSchmeId).getErrorCode())) {
                            return RuleUtils.checkCountry(cdtrSchmeId);
                        }
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    PartyIdentification135 orgnlCdtrSchmeId = amdmntInfDtls.getOrgnlCdtrSchmeId();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(orgnlCdtrSchmeId).getErrorCode())) {
                                        return RuleUtils.checkCountry(orgnlCdtrSchmeId);
                                    }
                                    PartyIdentification135 orgnlDbtr = amdmntInfDtls.getOrgnlDbtr();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(orgnlDbtr).getErrorCode())) {
                                        return RuleUtils.checkCountry(orgnlDbtr);
                                    }
                                }
                            }
                        }
                        RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(invcr).getErrorCode())) {
                                        return RuleUtils.checkCountry(invcr);
                                    }
                                    PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(invcee).getErrorCode())) {
                                        return RuleUtils.checkCountry(invcee);
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
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.1 InterbankSettlementAmount <IntrBkSttlmAmt>
     * <p>
     * 2.4.3.16.11 RemittanceInformation <RmtInf>
     * 2.4.3.16.11.2 Structured <Strd>
     * 2.4.3.16.11.2.1 ReferredDocumentInformation <RfrdDocInf>
     * 2.4.3.16.11.2.1.4 LineDetails <LineDtls>
     * 2.4.3.16.11.2.1.4.3 Amount <Amt>
     * 2.4.3.16.11.2.1.4.3.1 DuePayableAmount <DuePyblAmt>
     * 2.4.3.16.11.2.1.4.3.2 DiscountAppliedAmount <DscntApldAmt>
     * 2.4.3.16.11.2.1.4.3.2.2 Amount <Amt>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.11 RemittanceInformation <RmtInf>
     * 2.4.3.16.11.2 Structured <Strd>
     * 2.4.3.16.11.2.6 TaxRemittance <TaxRmt>
     * 2.4.3.16.11.2.6.7 TotalTaxableBaseAmount <TtlTaxblBaseAmt>
     *
     * @return 返回C7检查结果
     */
    public Constraints checkC7() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt = orgnlTxRef.getIntrBkSttlmAmt();
                        if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            BigDecimal value = intrBkSttlmAmt.getValue();
                            String ccy = intrBkSttlmAmt.getCcy();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                            }
                        }
                        RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    List<ReferredDocumentInformation7> rfrdDocInf = structuredRemittanceInformation17.getRfrdDocInf();
                                    if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                        for (ReferredDocumentInformation7 referredDocumentInformation7 : rfrdDocInf) {
                                            List<DocumentLineInformation1> lineDtls = referredDocumentInformation7.getLineDtls();
                                            if (JudgeUtils.isNotNull(lineDtls)) {
                                                for (DocumentLineInformation1 lineDtl : lineDtls) {
                                                    RemittanceAmount3 amt = lineDtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        ActiveOrHistoricCurrencyAndAmount duePyblAmt = amt.getDuePyblAmt();
                                                        if (JudgeUtils.isNotNull(duePyblAmt)) {
                                                            BigDecimal value = duePyblAmt.getValue();
                                                            String ccy = duePyblAmt.getCcy();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                            }
                                                        }
                                                        List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                        if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                                if (JudgeUtils.isNotNull(amt1)) {
                                                                    BigDecimal value = amt1.getValue();
                                                                    String ccy = amt1.getCcy();
                                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                        if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                            BigDecimal value = cdtNoteAmt.getValue();
                                                            String ccy = cdtNoteAmt.getCcy();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                            }
                                                        }
                                                        List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                                            for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                                if (JudgeUtils.isNotNull(amt1)) {
                                                                    BigDecimal value = amt1.getValue();
                                                                    String ccy = amt1.getCcy();
                                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                        if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                            for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                                if (JudgeUtils.isNotNull(amt1)) {
                                                                    BigDecimal value = amt1.getValue();
                                                                    String ccy = amt1.getCcy();
                                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                        if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                            BigDecimal value = rmtdAmt.getValue();
                                                            String ccy = rmtdAmt.getCcy();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    TaxData1 taxRmt = structuredRemittanceInformation17.getTaxRmt();
                                    if (JudgeUtils.isNotNull(taxRmt)) {
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                        if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                            BigDecimal value = ttlTaxblBaseAmt.getValue();
                                            String ccy = ttlTaxblBaseAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                        if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                            BigDecimal value = ttlTaxAmt.getValue();
                                            String ccy = ttlTaxAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                        if (JudgeUtils.isNotNull(rcrd)) {
                                            for (TaxRecord3 taxRecord3 : rcrd) {
                                                TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                    if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                        BigDecimal value = taxblBaseAmt.getValue();
                                                        String ccy = taxblBaseAmt.getCcy();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                        }
                                                    }
                                                    ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                                    if (JudgeUtils.isNotNull(ttlAmt)) {
                                                        BigDecimal value = ttlAmt.getValue();
                                                        String ccy = ttlAmt.getCcy();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                        }
                                                    }
                                                    List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                                    if (JudgeUtils.isNotNull(dtls)) {
                                                        for (TaxRecordDetails3 dtl : dtls) {
                                                            ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                            if (JudgeUtils.isNotNull(amt)) {
                                                                BigDecimal value = amt.getValue();
                                                                String ccy = amt.getCcy();
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                    return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
     * If OriginalGroupInformationAndStatus/GroupStatus is present and is equal to ACTC
     * (AcceptedTechnicalValidation), ACCP (AcceptedCustomerProfile), ACSP
     * (AcceptedSettlementInProcess), ACSC (AcceptedSettlementCompleted) or ACWC
     * (AcceptedWithChange), then TransactionInformationAndStatus/TransactionStatus must be
     * different from RJCT (Rejected). (CrossElementComplexRule)
     *
     * @return 返回C8检查结果
     */
    public Constraints checkC8() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    String grpSts = orgnlGrpInfAndSt.getGrpSts();
                    if ("ACTC".equals(grpSts) || "ACCP".equals(grpSts) || "ACSP".equals(grpSts) || "ACSC".equals(grpSts) || "ACWC".equals(grpSts)) {
                        if (JudgeUtils.isNotNull(grpSts)) {
                            if (JudgeUtils.isNotNull(txInfAndSts)) {
                                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                                    String txSts = txInfAndSt.getTxSts();
                                    if ("RJCT".equals(txSts)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C9_ERROR_SEVERITY, Pacs00200112ErrorConstant.C9_ERROR_CODE, Pacs00200112ErrorConstant.C9_ERROR_TEXT);
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
     * If OriginalGroupInformationAndStatus/GroupStatus is present and is equal to PDNG (Pending),
     * then TransactionInformationAndStatus/TransactionStatus must be different from RJCT
     * (Rejected). (CrossElementComplexRule)
     *
     * @return 返回C9检查结果
     */
    public Constraints checkC9() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    String grpSts = orgnlGrpInfAndSt.getGrpSts();
                    if ("PDNG".equals(grpSts)) {
                        if (JudgeUtils.isNotNull(grpSts)) {
                            if (JudgeUtils.isNotNull(txInfAndSts)) {
                                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                                    String txSts = txInfAndSt.getTxSts();
                                    if ("RJCT".equals(txSts)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C9_ERROR_SEVERITY, Pacs00200112ErrorConstant.C9_ERROR_CODE, Pacs00200112ErrorConstant.C9_ERROR_TEXT);
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
     * If OriginalGroupInformationAndStatus/GroupStatus is present and is equal to RCVD
     * (Received), then TransactionInformationAndStatus/TransactionStatus is not
     * allowed. (CrossElementComplexRule)
     *
     * @return 返回C10检查结果
     */
    public Constraints checkC10() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    String grpSts = orgnlGrpInfAndSt.getGrpSts();
                    if ("RCVD".equals(grpSts)) {
                        if (JudgeUtils.isNotNull(grpSts)) {
                            if (JudgeUtils.isNotNull(txInfAndSts)) {
                                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                                    String txSts = txInfAndSt.getTxSts();
                                    if (JudgeUtils.isNotNull(txSts)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C10_ERROR_SEVERITY, Pacs00200112ErrorConstant.C10_ERROR_CODE, Pacs00200112ErrorConstant.C10_ERROR_TEXT);
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
     * If OriginalGroupInformationAndStatus/GroupStatus is present and is equal to RJCT (Rejected),
     * then TransactionInformationAndStatus/TransactionStatus, if present, must be equal to RJCT
     * (Rejected). (CrossElementComplexRule)
     *
     * @return 返回C11检查结果
     */
    public Constraints checkC11() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    String grpSts = orgnlGrpInfAndSt.getGrpSts();
                    if ("RJCT".equals(grpSts)) {
                        if (JudgeUtils.isNotNull(grpSts)) {
                            if (JudgeUtils.isNotNull(txInfAndSts)) {
                                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                                    String txSts = txInfAndSt.getTxSts();
                                    if (!"RJCT".equals(txSts)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C11_ERROR_SEVERITY, Pacs00200112ErrorConstant.C11_ERROR_CODE, Pacs00200112ErrorConstant.C11_ERROR_TEXT);
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
     * A valid IBAN consists of all three of the following components: Country Code, check digits and
     * BBAN. (Algorithm)
     * 2.4.3.16.7 SettlementInformation <SttlmInf>
     * 2.4.3.16.7.2 SettlementAccount <SttlmAcct>
     * 2.4.3.16.7.2.1 Identification <Id>
     * 2.4.3.16.7.5 InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct>
     * 2.4.3.16.7.5.1 Identification <Id>
     * 2.4.3.16.7.7 InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct>
     * 2.4.3.16.7.7.1 Identification <Id>
     * 2.4.3.16.7.9 ThirdReimbursementAgentAccount <ThrdRmbrsmntAgtAcct>
     * 2.4.3.16.7.9.1 Identification <Id>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.10 MandateRelatedInformation <MndtRltdInf>
     * 2.4.3.16.10.1 DirectDebitMandate <DrctDbtMndt>
     * 2.4.3.16.10.1.4 AmendmentInformationDetails <AmdmntInfDtls>
     * 2.4.3.16.10.1.4.4 OriginalCreditorAgentAccount <OrgnlCdtrAgtAcct>
     * 2.4.3.16.10.1.4.4.1 Identification <Id>
     * 2.4.3.16.10.1.4.6 OriginalDebtorAccount <OrgnlDbtrAcct>
     * 2.4.3.16.10.1.4.6.1 Identification <Id>
     * 2.4.3.16.10.1.4.8 OriginalDebtorAgentAccount <OrgnlDbtrAgtAcct>
     * 2.4.3.16.10.1.4.8.1 Identification <Id>
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.14 DebtorAccount <DbtrAcct>
     * 2.4.3.16.14.1 Identification <Id>
     * 2.4.3.16.16 DebtorAgentAccount <DbtrAgtAcct>
     * 2.4.3.16.16.1 Identification <Id>
     * 2.4.3.16.18 CreditorAgentAccount <CdtrAgtAcct>
     * 2.4.3.16.18.1 Identification <Id>
     * 2.4.3.16.20 CreditorAccount <CdtrAcct>
     * 2.4.3.16.20.1 Identification <Id>
     *
     * @return 返回C12检查结果
     */
    public Constraints checkC12() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                            if (JudgeUtils.isNotNull(sttlmAcct)) {
                                AccountIdentification4Choice id = sttlmAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban = id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                        return RuleUtils.checkIBAN(iban);
                                    }
                                }
                            }
                            CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = instgRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban = id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                        return RuleUtils.checkIBAN(iban);
                                    }
                                }
                            }
                            CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban = id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                        return RuleUtils.checkIBAN(iban);
                                    }
                                }
                            }
                            CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = thrdRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban = id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                        return RuleUtils.checkIBAN(iban);
                                    }
                                }
                            }
                        }
                        MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                        if (JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if (JudgeUtils.isNotNull(drctDbtMndt)) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    CashAccount40 orgnlCdtrAgtAcct = amdmntInfDtls.getOrgnlCdtrAgtAcct();
                                    if (JudgeUtils.isNotNull(orgnlCdtrAgtAcct)) {
                                        AccountIdentification4Choice id = orgnlCdtrAgtAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban = id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                                return RuleUtils.checkIBAN(iban);
                                            }
                                        }
                                    }
                                    CashAccount40 orgnlDbtrAcct = amdmntInfDtls.getOrgnlDbtrAcct();
                                    if (JudgeUtils.isNotNull(orgnlDbtrAcct)) {
                                        AccountIdentification4Choice id = orgnlDbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban = id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                                return RuleUtils.checkIBAN(iban);
                                            }
                                        }
                                    }
                                    CashAccount40 orgnlDbtrAgtAcct = amdmntInfDtls.getOrgnlDbtrAgtAcct();
                                    if (JudgeUtils.isNotNull(orgnlDbtrAgtAcct)) {
                                        AccountIdentification4Choice id = orgnlDbtrAgtAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban = id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                                return RuleUtils.checkIBAN(iban);
                                            }
                                        }
                                    }

                                }
                            }
                        }
                        CashAccount40 dbtrAcct = orgnlTxRef.getDbtrAcct();
                        if (JudgeUtils.isNotNull(dbtrAcct)) {
                            AccountIdentification4Choice id = dbtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 dbtrAgtAcct = orgnlTxRef.getDbtrAgtAcct();
                        if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                            AccountIdentification4Choice id = dbtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAgtAcct = orgnlTxRef.getCdtrAgtAcct();
                        if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                            AccountIdentification4Choice id = cdtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAcct = orgnlTxRef.getCdtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAcct)) {
                            AccountIdentification4Choice id = cdtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
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
     * Identification must be present or Proxy must be present. Both may be
     * present. (CrossElementSimpleRule)
     *
     * @return 返回C14检查结果
     */
    public Constraints checkC14() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                            if (JudgeUtils.isNotNull(sttlmAcct)) {
                                AccountIdentification4Choice id = sttlmAcct.getId();
                                ProxyAccountIdentification1 prxy = sttlmAcct.getPrxy();
                                if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                    return new Constraints(Pacs00200112ErrorConstant.C14_ERROR_SEVERITY, Pacs00200112ErrorConstant.C14_ERROR_CODE, Pacs00200112ErrorConstant.C14_ERROR_TEXT);
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
     * If InstructedReimbursementAgentAccount is present, then InstructedReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * <p>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.7 SettlementInformation <SttlmInf>
     * InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct>
     * InstructedReimbursementAgent <InstdRmbrsmntAgt>
     *
     * @return C15规则检查
     */
    public Constraints checkC15() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct) && JudgeUtils.isNull(instdRmbrsmntAgt)) {
                                return new Constraints(Pacs00200112ErrorConstant.C15_ERROR_SEVERITY, Pacs00200112ErrorConstant.C15_ERROR_CODE, Pacs00200112ErrorConstant.C15_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * If InstructingReimbursementAgentAccount is present, then InstructingReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.16 OriginalTransactionReference <OrgnlTxRef>
     * 2.4.3.16.7 SettlementInformation <SttlmInf>
     * InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct>
     * InstructingReimbursementAgent <InstgRmbrsmntAgt>
     *
     * @return C16规则检查
     */

    public Constraints checkC16() {
        if (JudgeUtils.isNotNull(this.getFIToFIPmtStsRpt())) {
            FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
            if (JudgeUtils.isNotNull(fiToFIPmtStsRpt.getTxInfAndSts())) {
                List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
                if (JudgeUtils.isNotNull(txInfAndSts)) {
                    for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                        OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                        if (JudgeUtils.isNotNull(orgnlTxRef)) {
                            SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                            if (JudgeUtils.isNotNull(sttlmInf)) {
                                CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                                BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                                if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                                    return new Constraints(Pacs00200112ErrorConstant.C16_ERROR_SEVERITY, Pacs00200112ErrorConstant.C16_ERROR_CODE, Pacs00200112ErrorConstant.C16_ERROR_TEXT);
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
     * (Rule)
     * If OriginalGroupInformationAndStatus is absent, then
     * TransactionInformationAndStatus[*]/OriginalGroupInformation must be
     * present. (CrossElementComplexRule)
     * <p>
     * <p>
     * 2.4.2 OriginalGroupInformationAndStatus <OrgnlGrpInfAndSts>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.2 OriginalGroupInformation <OrgnlGrpInf>
     *
     * @return C18规则检查
     */
    public Constraints checkC18() {
        if (JudgeUtils.isNotNull(this.getFIToFIPmtStsRpt())) {
            FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
            if (JudgeUtils.isNotNull(fiToFIPmtStsRpt.getOrgnlGrpInfAndSts())) {
                List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
                List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalGroupInformation29 orgnlGrpInf = txInfAndSt.getOrgnlGrpInf();
                    if (JudgeUtils.isNull(orgnlGrpInfAndSts)) {
                        if (!JudgeUtils.isNotNull(txInfAndSts) && !JudgeUtils.isNotNull(orgnlGrpInf)) {
                            return new Constraints(Pacs00200112ErrorConstant.C18_ERROR_SEVERITY, Pacs00200112ErrorConstant.C18_ERROR_CODE, Pacs00200112ErrorConstant.C18_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If OriginalGroupInformationAndStatus is present and multiple times (Occurrence > 1), then
     * TransactionInformationAndStatus[*]/OriginalGroupInformation must be
     * present. (CrossElementComplexRule)
     * <p>
     * 2.4.2 OriginalGroupInformationAndStatus <OrgnlGrpInfAndSts>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.2 OriginalGroupInformation <OrgnlGrpInf>
     *
     * @return 返回C19检查结果
     */
    public Constraints checkC19() {
        if (JudgeUtils.isNotNull(this.getFIToFIPmtStsRpt())) {
            FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
            if (JudgeUtils.isNotNull(fiToFIPmtStsRpt.getOrgnlGrpInfAndSts())) {
                List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
                if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                    if (orgnlGrpInfAndSts.size() > 1) {
                        List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
                        if (JudgeUtils.isNotNull(txInfAndSts)) {
                            for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                                OriginalGroupInformation29 orgnlGrpInf = txInfAndSt.getOrgnlGrpInf();
                                if (JudgeUtils.isNull(orgnlGrpInf)) {
                                    return new Constraints(Pacs00200112ErrorConstant.C19_ERROR_SEVERITY, Pacs00200112ErrorConstant.C19_ERROR_CODE, Pacs00200112ErrorConstant.C19_ERROR_TEXT);

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
     * If OriginalGroupInformationAndStatus is present and only once, then
     * TransactionInformationAndStatus[*]/OriginalGroupInformation must be
     * absent. (CrossElementComplexRule)
     * <p>
     * 2.4.2 OriginalGroupInformationAndStatus<OrgnlGrpInfAndSts>
     * 2.4.3 TransactionInformationAndStatus <TxInfAndSts>
     * 2.4.3.2 OriginalGroupInformation <OrgnlGrpInf>
     *
     * @return 返回C20检查结果
     */
    public Constraints checkC20() {
        if (JudgeUtils.isNotNull(this.getFIToFIPmtStsRpt())) {
            FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
            if (JudgeUtils.isNotNull(fiToFIPmtStsRpt.getOrgnlGrpInfAndSts())) {
                List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
                if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                    List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
                    if (JudgeUtils.isNotNull(txInfAndSts)) {
                        for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                            if (JudgeUtils.isNotNull(txInfAndSt)) {
                                OriginalGroupInformation29 orgnlGrpInf = txInfAndSt.getOrgnlGrpInf();
                                if (orgnlGrpInfAndSts.size() == 1) {
                                    if (JudgeUtils.isNotNull(txInfAndSt) && JudgeUtils.isNotNull(orgnlGrpInf)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C20_ERROR_SEVERITY, Pacs00200112ErrorConstant.C20_ERROR_CODE, Pacs00200112ErrorConstant.C20_ERROR_TEXT);
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
     * If SettlementMethod is equal to INDA or INGA, then ReimbursementAgent(s) and
     * ClearingSystem are not allowed. (CrossElementComplexRule)
     *
     * @return 返回C21检查结果
     */
    public Constraints checkC21() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                            ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                            if (JudgeUtils.isNotNull(sttlmMtd)) {
                                String value = sttlmMtd.value();
                                if ("INDA".equals(value) || "INGA".equals(value)) {
                                    if (JudgeUtils.isNotNull(clrSys) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C21_ERROR_SEVERITY, Pacs00200112ErrorConstant.C21_ERROR_CODE, Pacs00200112ErrorConstant.C21_ERROR_TEXT);
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
     * If SettlementMethod is equal to CLRG, then SettlementAccount and ReimbursementAgent(s)
     * are not allowed. (CrossElementComplexRule)
     *
     * @return 返回C22检查结果
     */
    public Constraints checkC22() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                            CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                            if (JudgeUtils.isNotNull(sttlmMtd)) {
                                String value = sttlmMtd.value();
                                if ("CLRG".equals(value)) {
                                    if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C22_ERROR_SEVERITY, Pacs00200112ErrorConstant.C22_ERROR_CODE, Pacs00200112ErrorConstant.C22_ERROR_TEXT);
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
     * If SettlementMethod is equal to COVE, then InstructedReimbursementAgent or
     * InstructingReimbursementAgent must be present. (CrossElementComplexRule)
     *
     * @return 返回C23检查结果
     */
    public Constraints checkC23() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            if (JudgeUtils.isNotNull(sttlmMtd)) {
                                String value = sttlmMtd.value();
                                if ("COVE".equals(value)) {
                                    if (JudgeUtils.isNull(instdRmbrsmntAgt) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C23_ERROR_SEVERITY, Pacs00200112ErrorConstant.C23_ERROR_CODE, Pacs00200112ErrorConstant.C23_ERROR_TEXT);
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
     * If SettlementMethod is equal to COVE, then SettlementAccount and ClearingSystem are not
     * allowed. (CrossElementComplexRule)
     *
     * @return 返回C24检查结果
     */
    public Constraints checkC24() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                            CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                            ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                            if (JudgeUtils.isNotNull(sttlmMtd)) {
                                String value = sttlmMtd.value();
                                if ("COVE".equals(value)) {
                                    if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(clrSys)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C24_ERROR_SEVERITY, Pacs00200112ErrorConstant.C24_ERROR_CODE, Pacs00200112ErrorConstant.C24_ERROR_TEXT);
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
     * If GroupStatus is present and is different from RJCT or PDNG then StatusReasonInformation/
     * AdditionalInformation must be absent. (CrossElementComplexRule)
     *
     * @return 返回C25检查结果
     */
    public Constraints checkC25() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    String grpSts = orgnlGrpInfAndSt.getGrpSts();
                    List<StatusReasonInformation12> stsRsnInf = orgnlGrpInfAndSt.getStsRsnInf();
                    if (!"RJCT".equals(grpSts) && !"PDNG".equals(grpSts)) {
                        if (JudgeUtils.isNotNull(stsRsnInf)) {
                            for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                                List<String> addtlInf = statusReasonInformation12.getAddtlInf();
                                if (JudgeUtils.isNotNull(addtlInf)) {
                                    return new Constraints(Pacs00200112ErrorConstant.C25_ERROR_SEVERITY, Pacs00200112ErrorConstant.C25_ERROR_CODE, Pacs00200112ErrorConstant.C25_ERROR_TEXT);
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
     * If Reason/Code is equal to NARR, then AddititionalInformation must be
     * present. (CrossElementComplexRule)
     * <p>
     * 2.4.2 OriginalGroupInformationAndStatus <OrgnlGrpInfAndSts>
     * 2.4.2.7 StatusReasonInformation <StsRsnInf>
     * 2.4.2.7.2 Reason <Rsn>
     * 2.4.2.7.2.1 Code <Cd>
     * 2.4.2.7.3 AdditionalInformation <AddtlInf>
     *
     * @return 返回C26检查结果
     */
    public Constraints checkC26() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<OriginalGroupHeader17> orgnlGrpInfAndSts = fiToFIPmtStsRpt.getOrgnlGrpInfAndSts();
            if (JudgeUtils.isNotNull(orgnlGrpInfAndSts)) {
                for (OriginalGroupHeader17 orgnlGrpInfAndSt : orgnlGrpInfAndSts) {
                    List<StatusReasonInformation12> stsRsnInf = orgnlGrpInfAndSt.getStsRsnInf();
                    if (JudgeUtils.isNotNull(stsRsnInf)) {
                        for (StatusReasonInformation12 statusReasonInformation12 : stsRsnInf) {
                            StatusReason6Choice rsn = statusReasonInformation12.getRsn();
                            List<String> addtlInf = statusReasonInformation12.getAddtlInf();
                            if (JudgeUtils.isNotNull(rsn)) {
                                String cd = rsn.getCd();
                                if (JudgeUtils.isNotNull(cd)) {
                                    if ("NARR".equals(cd) && JudgeUtils.isNull(addtlInf)) {
                                        return new Constraints(Pacs00200112ErrorConstant.C26_ERROR_SEVERITY, Pacs00200112ErrorConstant.C26_ERROR_CODE, Pacs00200112ErrorConstant.C26_ERROR_TEXT);
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
     * If ThirdReimbursementAgentAccount is present, then ThirdReimbursementAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return 返回C29检查结果
     */
    public Constraints checkC29() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                            CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct) && JudgeUtils.isNull(thrdRmbrsmntAgt)) {
                                return new Constraints(Pacs00200112ErrorConstant.C29_ERROR_SEVERITY, Pacs00200112ErrorConstant.C29_ERROR_CODE, Pacs00200112ErrorConstant.C29_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If ThirdReimbursementAgent is present, then InstructingReimbursementAgent and
     * InstructedReimbursementAgent must both be present. (CrossElementComplexRule)
     *
     * @return 返回C30检查结果
     */
    public Constraints checkC30() {
        FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt = this.getFIToFIPmtStsRpt();
        if (JudgeUtils.isNotNull(fiToFIPmtStsRpt)) {
            List<PaymentTransaction130> txInfAndSts = fiToFIPmtStsRpt.getTxInfAndSts();
            if (JudgeUtils.isNotNull(txInfAndSts)) {
                for (PaymentTransaction130 txInfAndSt : txInfAndSts) {
                    OriginalTransactionReference35 orgnlTxRef = txInfAndSt.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                        if (JudgeUtils.isNotNull(sttlmInf)) {
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                            if (JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                if (JudgeUtils.isNull(instdRmbrsmntAgt) || JudgeUtils.isNull(instgRmbrsmntAgt)) {
                                    return new Constraints(Pacs00200112ErrorConstant.C30_ERROR_SEVERITY, Pacs00200112ErrorConstant.C30_ERROR_CODE, Pacs00200112ErrorConstant.C30_ERROR_TEXT);
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
     * @return 返回C检查结果
     */
    public String checkC() {

        return "调用未更改";
    }

}
