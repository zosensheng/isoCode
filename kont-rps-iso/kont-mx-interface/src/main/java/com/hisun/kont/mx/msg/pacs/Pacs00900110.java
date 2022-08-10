package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00900110ErrorConstant;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.util.RuleUtils;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * <p>Document complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FICdtTrf" type="{}FinancialInstitutionCreditTransferV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document002", propOrder = {
        "fiCdtTrf"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.10")
public class Pacs00900110 {


    @XmlElement(name = "FICdtTrf", required = true)
    protected FinancialInstitutionCreditTransferV10 fiCdtTrf;

    /**
     * ��ȡfiCdtTrf���Ե�ֵ��
     *
     * @return possible object is
     * {@link FinancialInstitutionCreditTransferV10 }
     */
    public FinancialInstitutionCreditTransferV10 getFICdtTrf() {
        return fiCdtTrf;
    }

    /**
     * ����fiCdtTrf���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link FinancialInstitutionCreditTransferV10 }
     */
    public void setFICdtTrf(FinancialInstitutionCreditTransferV10 value) {
        this.fiCdtTrf = value;
    }

    public ArrayList<Constraints> checkAll() {
        ArrayList<Constraints> constraints = new ArrayList<>();
        constraints.add(checkC1());
        constraints.add(checkC2());
        constraints.add(checkC3());
        constraints.add(checkC4());
        constraints.add(checkC5());
        constraints.add(checkC6());
        constraints.add(checkC7());
        constraints.add(checkC8());
        constraints.add(checkC9());
        constraints.add(checkC10());
        constraints.add(checkC11());
        constraints.add(checkC13());
        constraints.add(checkC14());
        constraints.add(checkC15());
        constraints.add(checkC16());
        constraints.add(checkC17());
        constraints.add(checkC18());
        constraints.add(checkC19());
        constraints.add(checkC20());
        constraints.add(checkC21());
        constraints.add(checkC22());
        constraints.add(checkC23());
        constraints.add(checkC24());
        constraints.add(checkC25());
        constraints.add(checkC26());
        constraints.add(checkC27());
        constraints.add(checkC28());
        constraints.add(checkC29());
        constraints.add(checkC30());
        constraints.add(checkC31());
        constraints.add(checkC34());
        constraints.add(checkC35());
        constraints.add(checkC36());
        constraints.add(checkC37());
        constraints.add(checkC38());
        constraints.add(checkC39());
        constraints.add(checkC40());
        constraints.add(checkC41());
        constraints.add(checkC42());
        constraints.add(checkC43());
        constraints.add(checkC44());
        constraints.add(checkC45());
        constraints.add(checkC48());
        constraints.add(checkC49());
        constraints.add(checkC50());
        constraints.add(checkC51());
        constraints.add(checkC52());
        constraints.add(checkC53());
        constraints.add(checkC54());

        ArrayList<Constraints> constraints1 = new ArrayList<>();
        for (Constraints constraint : constraints) {
            if (JudgeUtils.isNotNull(constraint)) {
                constraints1.add(constraint);
            }
        }
        return constraints1;
    }

    /**
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered with
     * the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     * todo are not yet withdrawn on the day the message containing the Currency is exchanged.
     * <TtlIntrBkSttlmAmt>
     * <IntrBkSttlmAmt>
     *
     * @return 返回C1检查结果
     */
    public Constraints checkC1() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt)) {
                    String ccy = ttlIntrBkSttlmAmt.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveCurrency(ccy).getErrorCode())) {
                            return RuleUtils.checkActiveCurrency(ccy);
                        }
                    }
                }
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction56.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccy = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveCurrency(ccy);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }


    /**
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * todo  may be or not be withdrawn on the day the message containing the Currency is exchanged.
     *
     * @return C2规则检查
     */
    public Constraints checkC2() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(sttlmAcct)) {
                        String ccy = sttlmAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                        String ccy = instgRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        String ccy = instdRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                        String ccy = thrdRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                }
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction56.getPrvsInstgAgt1Acct();
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction56.getPrvsInstgAgt2Acct();
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction56.getPrvsInstgAgt3Acct();
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction56.getIntrmyAgt1Acct();
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction56.getIntrmyAgt2Acct();
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction56.getIntrmyAgt3Acct();
                    CashAccount40 dbtrAcct = creditTransferTransaction56.getDbtrAcct();
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction56.getDbtrAgtAcct();
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction56.getCdtrAgtAcct();
                    CashAccount40 cdtrAcct = creditTransferTransaction56.getCdtrAcct();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 dbtrAcct1 = undrlygCstmrCdtTrf.getDbtrAcct();
                        CashAccount40 dbtrAgtAcct1 = undrlygCstmrCdtTrf.getDbtrAgtAcct();
                        CashAccount40 prvsInstgAgt1Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                        CashAccount40 prvsInstgAgt2Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                        CashAccount40 prvsInstgAgt3Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                        CashAccount40 intrmyAgt1Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                        CashAccount40 intrmyAgt2Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                        CashAccount40 intrmyAgt3Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                        CashAccount40 cdtrAgtAcct1 = undrlygCstmrCdtTrf.getCdtrAgtAcct();
                        CashAccount40 cdtrAcct1 = undrlygCstmrCdtTrf.getCdtrAcct();
                        TaxInformation10 tax = undrlygCstmrCdtTrf.getTax();
                        RemittanceInformation21 rmtInf = undrlygCstmrCdtTrf.getRmtInf();
                        ActiveOrHistoricCurrencyAndAmount instdAmt = undrlygCstmrCdtTrf.getInstdAmt();
                        if (JudgeUtils.isNotNull(dbtrAcct1)) {
                            String ccy = dbtrAcct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtrAgtAcct1)) {
                            String ccy = dbtrAgtAcct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt1Acct1)) {
                            String ccy = prvsInstgAgt1Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt2Acct1)) {
                            String ccy = prvsInstgAgt2Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt3Acct1)) {
                            String ccy = prvsInstgAgt3Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt1Acct1)) {
                            String ccy = intrmyAgt1Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt2Acct1)) {
                            String ccy = intrmyAgt2Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt3Acct1)) {
                            String ccy = intrmyAgt3Acct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAgtAcct1)) {
                            String ccy = cdtrAgtAcct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAcct1)) {
                            String ccy = cdtrAcct1.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(tax)) {
                            ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                            ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                            List<TaxRecord3> rcrd = tax.getRcrd();
                            if (JudgeUtils.isNotNull(rcrd)) {
                                for (TaxRecord3 taxRecord3 : rcrd) {
                                    TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                    if (JudgeUtils.isNotNull(taxAmt)) {
                                        ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                        ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                        List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                        if (JudgeUtils.isNotNull(dtls)) {
                                            for (TaxRecordDetails3 dtl : dtls) {
                                                ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    String ccy = amt.getCcy();
                                                    if (JudgeUtils.isNotNull(ccy)) {
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                            return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                            String ccy = taxblBaseAmt.getCcy();
                                            if (JudgeUtils.isNotNull(ccy)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlAmt)) {
                                            String ccy = ttlAmt.getCcy();
                                            if (JudgeUtils.isNotNull(ccy)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                            if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                String ccy = ttlTaxblBaseAmt.getCcy();
                                if (JudgeUtils.isNotNull(ccy)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                        return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                    }
                                }

                            }
                            if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                String ccy = ttlTaxAmt.getCcy();
                                if (JudgeUtils.isNotNull(ccy)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                        return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                    }
                                }

                            }
                        }
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    List<ReferredDocumentInformation7> rfrdDocInf = structuredRemittanceInformation17.getRfrdDocInf();
                                    TaxData1 taxRmt = structuredRemittanceInformation17.getTaxRmt();
                                    if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                        for (ReferredDocumentInformation7 referredDocumentInformation7 : rfrdDocInf) {
                                            List<DocumentLineInformation1> lineDtls = referredDocumentInformation7.getLineDtls();
                                            if (JudgeUtils.isNotNull(lineDtls)) {
                                                for (DocumentLineInformation1 lineDtl : lineDtls) {
                                                    RemittanceAmount3 amt = lineDtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        ActiveOrHistoricCurrencyAndAmount duePyblAmt = amt.getDuePyblAmt();
                                                        List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                        ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                        List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                        List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                        ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                        if (JudgeUtils.isNotNull(duePyblAmt)) {
                                                            String ccy = duePyblAmt.getCcy();
                                                            if (JudgeUtils.isNotNull(ccy)) {
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                }
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                                if (JudgeUtils.isNotNull(discountAmountAndType1)) {
                                                                    ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                                    if (JudgeUtils.isNotNull(amt1)) {
                                                                        String ccy = amt1.getCcy();
                                                                        if (JudgeUtils.isNotNull(ccy)) {
                                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                            String ccy = cdtNoteAmt.getCcy();
                                                            if (JudgeUtils.isNotNull(ccy)) {
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                }
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                                            for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                                if (JudgeUtils.isNotNull(amt1)) {
                                                                    String ccy = amt1.getCcy();
                                                                    if (JudgeUtils.isNotNull(ccy)) {
                                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                            return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                            for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                                ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                                if (JudgeUtils.isNotNull(amt1)) {
                                                                    String ccy = amt1.getCcy();
                                                                    if (JudgeUtils.isNotNull(ccy)) {
                                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                            return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                            String ccy = rmtdAmt.getCcy();
                                                            if (JudgeUtils.isNotNull(ccy)) {
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(taxRmt)) {
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                        List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                        if (JudgeUtils.isNotNull(rcrd)) {
                                            for (TaxRecord3 taxRecord3 : rcrd) {
                                                TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                    ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                                    List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                                    if (JudgeUtils.isNotNull(dtls)) {
                                                        for (TaxRecordDetails3 dtl : dtls) {
                                                            ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                            if (JudgeUtils.isNotNull(amt)) {
                                                                String ccy = amt.getCcy();
                                                                if (JudgeUtils.isNotNull(ccy)) {
                                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                        return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                        String ccy = taxblBaseAmt.getCcy();
                                                        if (JudgeUtils.isNotNull(ccy)) {
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                            }
                                                        }
                                                    }
                                                    if (JudgeUtils.isNotNull(ttlAmt)) {
                                                        String ccy = ttlAmt.getCcy();
                                                        if (JudgeUtils.isNotNull(ccy)) {
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                            String ccy = ttlTaxblBaseAmt.getCcy();
                                            if (JudgeUtils.isNotNull(ccy)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                            String ccy = ttlTaxAmt.getCcy();
                                            if (JudgeUtils.isNotNull(ccy)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(instdAmt)) {
                            String ccy = instdAmt.getCcy();
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        String ccy = prvsInstgAgt1Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        String ccy = prvsInstgAgt2Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        String ccy = prvsInstgAgt3Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        String ccy = intrmyAgt1Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        String ccy = intrmyAgt2Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        String ccy = intrmyAgt3Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        String ccy = dbtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        String ccy = dbtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        String ccy = cdtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        String ccy = cdtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
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
     * 7.4.2.36 UnderlyingCustomerCreditTransfer <UndrlygCstmrCdtTrf>
     * 7.4.2.36.1 UltimateDebtor <UltmtDbtr>
     * 7.4.2.36.2 InitiatingParty <InitgPty>
     * 7.4.2.36.3 Debtor <Dbtr>
     * 7.4.2.36.21 Creditor <Cdtr>
     * 7.4.2.36.23 UltimateCreditor <UltmtCdtr>
     *
     * @return C3规则检查
     */
    public Constraints checkC3() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        PartyIdentification135 ultmtDbtr = undrlygCstmrCdtTrf.getUltmtDbtr();
                        PartyIdentification135 initgPty = undrlygCstmrCdtTrf.getInitgPty();
                        PartyIdentification135 dbtr = undrlygCstmrCdtTrf.getDbtr();
                        PartyIdentification135 cdtr = undrlygCstmrCdtTrf.getCdtr();
                        PartyIdentification135 ultmtCdtr = undrlygCstmrCdtTrf.getUltmtCdtr();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(ultmtDbtr).getErrorCode())) {
                            return RuleUtils.checkAnyBIC(ultmtDbtr);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(initgPty).getErrorCode())) {
                            return RuleUtils.checkAnyBIC(initgPty);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(dbtr).getErrorCode())) {
                            return RuleUtils.checkAnyBIC(dbtr);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(cdtr).getErrorCode())) {
                            return RuleUtils.checkAnyBIC(cdtr);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(ultmtCdtr).getErrorCode())) {
                            return RuleUtils.checkAnyBIC(ultmtCdtr);
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
     *
     * @return C4规则检查
     */
    public Constraints checkC4() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instdAgt);
                }
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instgAgt);
                }
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();

                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgRmbrsmntAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(instgRmbrsmntAgt);
                    }

                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdRmbrsmntAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(instdRmbrsmntAgt);
                    }

                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(thrdRmbrsmntAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(thrdRmbrsmntAgt);
                    }
                }
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification6 instgAgt = creditTransferTransaction56.getInstgAgt();
                    BranchAndFinancialInstitutionIdentification6 instdAgt = creditTransferTransaction56.getInstdAgt();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification6 ultmtDbtr = creditTransferTransaction56.getUltmtDbtr();
                    BranchAndFinancialInstitutionIdentification6 dbtr = creditTransferTransaction56.getDbtr();
                    BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                    BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                    BranchAndFinancialInstitutionIdentification6 cdtr = creditTransferTransaction56.getCdtr();
                    BranchAndFinancialInstitutionIdentification6 ultmtCdtr = creditTransferTransaction56.getUltmtCdtr();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt1).getErrorCode())) {
                        return RuleUtils.checkBICFI(prvsInstgAgt1);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt2).getErrorCode())) {
                        return RuleUtils.checkBICFI(prvsInstgAgt2);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt3).getErrorCode())) {
                        return RuleUtils.checkBICFI(prvsInstgAgt3);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(instgAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(instdAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt1).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt1);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt2).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt2);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt3).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt3);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(ultmtDbtr).getErrorCode())) {
                        return RuleUtils.checkBICFI(ultmtDbtr);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(dbtr).getErrorCode())) {
                        return RuleUtils.checkBICFI(dbtr);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(dbtrAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(dbtrAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(cdtrAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(cdtrAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(cdtr).getErrorCode())) {
                        return RuleUtils.checkBICFI(cdtr);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(ultmtCdtr).getErrorCode())) {
                        return RuleUtils.checkBICFI(ultmtCdtr);
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt1 = undrlygCstmrCdtTrf.getDbtrAgt();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt11 = undrlygCstmrCdtTrf.getPrvsInstgAgt1();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt21 = undrlygCstmrCdtTrf.getPrvsInstgAgt2();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt31 = undrlygCstmrCdtTrf.getPrvsInstgAgt3();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt11 = undrlygCstmrCdtTrf.getIntrmyAgt1();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt21 = undrlygCstmrCdtTrf.getIntrmyAgt2();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt31 = undrlygCstmrCdtTrf.getIntrmyAgt3();
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt1 = undrlygCstmrCdtTrf.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(dbtrAgt1).getErrorCode())) {
                            return RuleUtils.checkBICFI(dbtrAgt1);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt11).getErrorCode())) {
                            return RuleUtils.checkBICFI(prvsInstgAgt11);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt21).getErrorCode())) {
                            return RuleUtils.checkBICFI(prvsInstgAgt21);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt31).getErrorCode())) {
                            return RuleUtils.checkBICFI(prvsInstgAgt31);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(prvsInstgAgt31).getErrorCode())) {
                            return RuleUtils.checkBICFI(prvsInstgAgt31);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt11).getErrorCode())) {
                            return RuleUtils.checkBICFI(intrmyAgt11);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt21).getErrorCode())) {
                            return RuleUtils.checkBICFI(intrmyAgt21);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt31).getErrorCode())) {
                            return RuleUtils.checkBICFI(intrmyAgt31);
                        }
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(cdtrAgt1).getErrorCode())) {
                            return RuleUtils.checkBICFI(cdtrAgt1);
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
     *
     * @return C5规则检查
     */
    public Constraints checkC5() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        PartyIdentification135 ultmtDbtr = undrlygCstmrCdtTrf.getUltmtDbtr();
                        PartyIdentification135 initgPty = undrlygCstmrCdtTrf.getInitgPty();
                        PartyIdentification135 dbtr = undrlygCstmrCdtTrf.getDbtr();
                        PartyIdentification135 cdtr = undrlygCstmrCdtTrf.getCdtr();
                        PartyIdentification135 ultmtCdtr = undrlygCstmrCdtTrf.getUltmtCdtr();
                        if (JudgeUtils.isNotNull(ultmtCdtr)) {
                            PostalAddress24 pstlAdr = ultmtCdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(ultmtDbtr)) {
                            PostalAddress24 pstlAdr = ultmtDbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(initgPty)) {
                            PostalAddress24 pstlAdr = initgPty.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtr)) {
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtr)) {
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                        }
                        RemittanceInformation21 rmtInf = undrlygCstmrCdtTrf.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                    PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                    if (JudgeUtils.isNotNull(invcr)) {
                                        PostalAddress24 pstlAdr = invcr.getPstlAdr();
                                        if (JudgeUtils.isNotNull(pstlAdr)) {
                                            String ctry = pstlAdr.getCtry();
                                            if (JudgeUtils.isNotNull(ctry)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                                    return RuleUtils.checkCountry(ctry);
                                                }
                                            }
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(invcee)) {
                                        PostalAddress24 pstlAdr = invcee.getPstlAdr();
                                        if (JudgeUtils.isNotNull(pstlAdr)) {
                                            String ctry = pstlAdr.getCtry();
                                            if (JudgeUtils.isNotNull(ctry)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                                    return RuleUtils.checkCountry(ctry);
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
     * If CreditorAgentAccount is present, then CreditorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C6规则检查
     */
    public Constraints checkC6() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction56.getCdtrAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                    if (JudgeUtils.isNotNull(cdtrAgtAcct) && JudgeUtils.isNull(cdtrAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C6_ERROR_SEVERITY, Pacs00900110ErrorConstant.C6_ERROR_CODE, Pacs00900110ErrorConstant.C6_ERROR_TEXT);
                    }
                }

            }
        }
        return null;
    }

    /**
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * RfrdDocAmt Strd RmtInf UndrlygCstmrCdtTrf CdtTrfTxInf
     *
     * @return C7规则检查
     */
    public Constraints checkC7() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt)) {
                    BigDecimal value = ttlIntrBkSttlmAmt.getValue();
                    String ccy = ttlIntrBkSttlmAmt.getCcy();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                    }
                }
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction56.getIntrBkSttlmAmt();
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        BigDecimal value = intrBkSttlmAmt.getValue();
                        String ccy = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                        }
                    }
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        RemittanceInformation21 rmtInf = undrlygCstmrCdtTrf.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    RemittanceAmount2 rfrdDocAmt = structuredRemittanceInformation17.getRfrdDocAmt();
                                    if (JudgeUtils.isNotNull(rfrdDocAmt)) {
                                        ActiveOrHistoricCurrencyAndAmount duePyblAmt = rfrdDocAmt.getDuePyblAmt();
                                        List<DiscountAmountAndType1> dscntApldAmt = rfrdDocAmt.getDscntApldAmt();
                                        ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = rfrdDocAmt.getCdtNoteAmt();
                                        List<TaxAmountAndType1> taxAmt = rfrdDocAmt.getTaxAmt();
                                        List<DocumentAdjustment1> adjstmntAmtAndRsn = rfrdDocAmt.getAdjstmntAmtAndRsn();
                                        ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                        if (JudgeUtils.isNotNull(duePyblAmt)) {
                                            BigDecimal value = duePyblAmt.getValue();
                                            String ccy = intrBkSttlmAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                ActiveOrHistoricCurrencyAndAmount amt = discountAmountAndType1.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    BigDecimal value = amt.getValue();
                                                    String ccy = amt.getCcy();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                            BigDecimal value = cdtNoteAmt.getValue();
                                            String ccy = cdtNoteAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                            for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                ActiveOrHistoricCurrencyAndAmount amt = taxAmountAndType1.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    BigDecimal value = amt.getValue();
                                                    String ccy = amt.getCcy();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                            for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                ActiveOrHistoricCurrencyAndAmount amt = documentAdjustment1.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    BigDecimal value = amt.getValue();
                                                    String ccy = amt.getCcy();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                    }
                                                }
                                            }
                                        }
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
                }
            }
        }
        return null;
    }


//    private static Constraints RuleUtils.checkCcyAndDigits(BigDecimal bigDecimal) {
//        String bigS = bigDecimal.toString();
//        int totalDigits = bigS.length();
//        int fractionDigits = 0;
//        if (bigS.contains(".")) {
//            String[] split = bigS.split("\\.");
//            if (split.length > 2) {
//                return new Constraints(Pacs00900110ErrorConstant.C7_ERROR_SEVERITY, Pacs00900110ErrorConstant.C7_ERROR_CODE, Pacs00900110ErrorConstant.C7_ERROR_TEXT, bigS);
//            }
//            totalDigits = totalDigits - 1;
//            fractionDigits = split[1].length();
//        }
//        if (totalDigits > 18 || fractionDigits > 5) {
//            return new Constraints(Pacs00900110ErrorConstant.C7_ERROR_SEVERITY, Pacs00900110ErrorConstant.C7_ERROR_CODE, Pacs00900110ErrorConstant.C7_ERROR_TEXT, bigS);
//        } else {
//            return new Constraints(Pacs00900110ErrorConstant.SUCCESS_CODE);
//        }
//    }


    /**
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     *
     * @return C8规则检查
     */
    public Constraints checkC8() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        TaxInformation10 tax = undrlygCstmrCdtTrf.getTax();
                        RemittanceInformation21 rmtInf = undrlygCstmrCdtTrf.getRmtInf();
                        ActiveOrHistoricCurrencyAndAmount instdAmt = undrlygCstmrCdtTrf.getInstdAmt();
                        if (JudgeUtils.isNotNull(tax)) {
                            ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                            ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                            List<TaxRecord3> rcrd = tax.getRcrd();
                            if (JudgeUtils.isNotNull(rcrd)) {
                                for (TaxRecord3 taxRecord3 : rcrd) {
                                    TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                    if (JudgeUtils.isNotNull(taxAmt)) {
                                        ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                        ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
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
                                        if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                            BigDecimal value = taxblBaseAmt.getValue();
                                            String ccy = taxblBaseAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlAmt)) {
                                            BigDecimal value = ttlAmt.getValue();
                                            String ccy = ttlAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                    }
                                }
                            }
                            if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                BigDecimal value = ttlTaxblBaseAmt.getValue();
                                String ccy = ttlTaxblBaseAmt.getCcy();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                    return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                }
                            }
                            if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                BigDecimal value = ttlTaxAmt.getValue();
                                String ccy = ttlTaxAmt.getCcy();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                    return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(rmtInf)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            if (JudgeUtils.isNotNull(strd)) {
                                for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                    List<ReferredDocumentInformation7> rfrdDocInf = structuredRemittanceInformation17.getRfrdDocInf();
                                    TaxData1 taxRmt = structuredRemittanceInformation17.getTaxRmt();
                                    if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                        for (ReferredDocumentInformation7 referredDocumentInformation7 : rfrdDocInf) {
                                            List<DocumentLineInformation1> lineDtls = referredDocumentInformation7.getLineDtls();
                                            if (JudgeUtils.isNotNull(lineDtls)) {
                                                for (DocumentLineInformation1 lineDtl : lineDtls) {
                                                    RemittanceAmount3 amt = lineDtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        ActiveOrHistoricCurrencyAndAmount duePyblAmt = amt.getDuePyblAmt();
                                                        List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                        ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                        List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                        List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                        ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                        if (JudgeUtils.isNotNull(duePyblAmt)) {
                                                            BigDecimal value = duePyblAmt.getValue();
                                                            String ccy = duePyblAmt.getCcy();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                            }
                                                        }
                                                        if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                                if (JudgeUtils.isNotNull(discountAmountAndType1)) {
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
                                                        }
                                                        if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                            BigDecimal value = cdtNoteAmt.getValue();
                                                            String ccy = cdtNoteAmt.getCcy();
                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                            }
                                                        }
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
                                    if (JudgeUtils.isNotNull(taxRmt)) {
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                        List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                        if (JudgeUtils.isNotNull(rcrd)) {
                                            for (TaxRecord3 taxRecord3 : rcrd) {
                                                TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                    ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
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
                                                    if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                        BigDecimal value = taxblBaseAmt.getValue();
                                                        String ccy = taxblBaseAmt.getCcy();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                        }
                                                    }
                                                    if (JudgeUtils.isNotNull(ttlAmt)) {
                                                        BigDecimal value = ttlAmt.getValue();
                                                        String ccy = ttlAmt.getCcy();
                                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                            BigDecimal value = ttlTaxblBaseAmt.getValue();
                                            String ccy = ttlTaxblBaseAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                            BigDecimal value = ttlTaxAmt.getValue();
                                            String ccy = ttlTaxAmt.getCcy();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(instdAmt)) {
                            BigDecimal value = instdAmt.getValue();
                            String ccy = instdAmt.getCcy();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }


    /**
     * If DebtorAgentAccount is present, then DebtorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C9规则检查
     */
    public Constraints checkC9() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction56.getDbtrAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                    if (JudgeUtils.isNotNull(dbtrAgtAcct) && JudgeUtils.isNull(dbtrAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C9_ERROR_SEVERITY, Pacs00900110ErrorConstant.C9_ERROR_CODE, Pacs00900110ErrorConstant.C9_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }

    /**
     * If GroupHeader/InterbankSettlementDate is present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate is not
     * allowed. (CrossElementComplexRule)
     *
     * @return C10规则检查
     */
    public Constraints checkC10() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        XMLGregorianCalendar intrBkSttlmDt1 = creditTransferTransaction56.getIntrBkSttlmDt();
                        if (JudgeUtils.isNotNull(intrBkSttlmDt) && JudgeUtils.isNotNull(intrBkSttlmDt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C10_ERROR_SEVERITY, Pacs00900110ErrorConstant.C10_ERROR_CODE, Pacs00900110ErrorConstant.C10_ERROR_TEXT);
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
     *
     * @return C11规则检查
     */
    public Constraints checkC11() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(sttlmAcct)) {
                        AccountIdentification4Choice id = sttlmAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = instgRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
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
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction56.getPrvsInstgAgt1Acct();
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction56.getPrvsInstgAgt2Acct();
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction56.getPrvsInstgAgt3Acct();
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction56.getIntrmyAgt1Acct();
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction56.getIntrmyAgt2Acct();
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction56.getIntrmyAgt3Acct();
                    CashAccount40 dbtrAcct = creditTransferTransaction56.getDbtrAcct();
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction56.getDbtrAgtAcct();
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction56.getCdtrAgtAcct();
                    CashAccount40 cdtrAcct = creditTransferTransaction56.getCdtrAcct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        AccountIdentification4Choice id = dbtrAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        AccountIdentification4Choice id = dbtrAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        AccountIdentification4Choice id = cdtrAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        AccountIdentification4Choice id = cdtrAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                return RuleUtils.checkIBAN(iban);
                            }
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 dbtrAcct1 = undrlygCstmrCdtTrf.getDbtrAcct();
                        CashAccount40 dbtrAgtAcct1 = undrlygCstmrCdtTrf.getDbtrAgtAcct();
                        CashAccount40 prvsInstgAgt1Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                        CashAccount40 prvsInstgAgt2Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                        CashAccount40 prvsInstgAgt3Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                        CashAccount40 intrmyAgt1Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                        CashAccount40 intrmyAgt2Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                        CashAccount40 intrmyAgt3Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                        CashAccount40 cdtrAgtAcct1 = undrlygCstmrCdtTrf.getCdtrAgtAcct();
                        CashAccount40 cdtrAcct1 = undrlygCstmrCdtTrf.getCdtrAcct();
                        if (JudgeUtils.isNotNull(dbtrAcct1)) {
                            AccountIdentification4Choice id = dbtrAcct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtrAgtAcct1)) {
                            AccountIdentification4Choice id = dbtrAgtAcct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt1Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt1Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt2Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt2Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt3Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt3Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt1Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt1Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt2Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt2Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt3Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt3Acct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAgtAcct1)) {
                            AccountIdentification4Choice id = cdtrAgtAcct1.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban = id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAcct1)) {
                            AccountIdentification4Choice id = cdtrAcct1.getId();
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
     * @return C13规则检查
     */
    public Constraints checkC13() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(sttlmAcct)) {
                        AccountIdentification4Choice id = sttlmAcct.getId();
                        ProxyAccountIdentification1 prxy = sttlmAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = instgRmbrsmntAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = instgRmbrsmntAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = instdRmbrsmntAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = thrdRmbrsmntAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = thrdRmbrsmntAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                }
            }
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction56.getPrvsInstgAgt1Acct();
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction56.getPrvsInstgAgt2Acct();
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction56.getPrvsInstgAgt3Acct();
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction56.getIntrmyAgt1Acct();
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction56.getIntrmyAgt2Acct();
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction56.getIntrmyAgt3Acct();
                    CashAccount40 dbtrAcct = creditTransferTransaction56.getDbtrAcct();
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction56.getDbtrAgtAcct();
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction56.getCdtrAgtAcct();
                    CashAccount40 cdtrAcct = creditTransferTransaction56.getCdtrAcct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt1Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt2Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt3Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt1Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt2Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt3Acct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        AccountIdentification4Choice id = dbtrAcct.getId();
                        ProxyAccountIdentification1 prxy = dbtrAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        AccountIdentification4Choice id = dbtrAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = dbtrAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        AccountIdentification4Choice id = cdtrAcct.getId();
                        ProxyAccountIdentification1 prxy = cdtrAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }

                    }
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        AccountIdentification4Choice id = cdtrAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = cdtrAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                            return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 dbtrAcct1 = undrlygCstmrCdtTrf.getDbtrAcct();
                        CashAccount40 dbtrAgtAcct1 = undrlygCstmrCdtTrf.getDbtrAgtAcct();
                        CashAccount40 prvsInstgAgt1Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                        CashAccount40 prvsInstgAgt2Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                        CashAccount40 prvsInstgAgt3Acct1 = undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                        CashAccount40 intrmyAgt1Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                        CashAccount40 intrmyAgt2Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                        CashAccount40 intrmyAgt3Acct1 = undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                        CashAccount40 cdtrAgtAcct1 = undrlygCstmrCdtTrf.getCdtrAgtAcct();
                        CashAccount40 cdtrAcct1 = undrlygCstmrCdtTrf.getCdtrAcct();
                        if (JudgeUtils.isNotNull(prvsInstgAgt1Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt1Acct1.getId();
                            ProxyAccountIdentification1 prxy = prvsInstgAgt1Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt2Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt2Acct1.getId();
                            ProxyAccountIdentification1 prxy = prvsInstgAgt2Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt3Acct1)) {
                            AccountIdentification4Choice id = prvsInstgAgt3Acct1.getId();
                            ProxyAccountIdentification1 prxy = prvsInstgAgt3Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt1Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt1Acct1.getId();
                            ProxyAccountIdentification1 prxy = intrmyAgt1Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt2Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt2Acct1.getId();
                            ProxyAccountIdentification1 prxy = intrmyAgt2Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt3Acct1)) {
                            AccountIdentification4Choice id = intrmyAgt3Acct1.getId();
                            ProxyAccountIdentification1 prxy = intrmyAgt3Acct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtrAcct1)) {
                            AccountIdentification4Choice id = dbtrAcct1.getId();
                            ProxyAccountIdentification1 prxy = dbtrAcct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtrAgtAcct1)) {
                            AccountIdentification4Choice id = dbtrAgtAcct1.getId();
                            ProxyAccountIdentification1 prxy = dbtrAgtAcct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAcct1)) {
                            AccountIdentification4Choice id = cdtrAcct1.getId();
                            ProxyAccountIdentification1 prxy = cdtrAcct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }

                        }
                        if (JudgeUtils.isNotNull(cdtrAgtAcct1)) {
                            AccountIdentification4Choice id = cdtrAgtAcct1.getId();
                            ProxyAccountIdentification1 prxy = cdtrAgtAcct1.getPrxy();
                            if (JudgeUtils.isNull(id) && JudgeUtils.isNull(prxy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C13_ERROR_SEVERITY, Pacs00900110ErrorConstant.C13_ERROR_CODE, Pacs00900110ErrorConstant.C13_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If GroupHeader/InstructedAgent is present, then CreditTransferTransactionInformation/
     * InstructedAgent is not allowed. (CrossElementComplexRule)
     *
     * @return C14规则检查
     */
    public Constraints checkC14() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 instdAgt1 = creditTransferTransaction56.getInstdAgt();
                        if (JudgeUtils.isNotNull(instdAgt) && JudgeUtils.isNotNull(instdAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C14_ERROR_SEVERITY, Pacs00900110ErrorConstant.C14_ERROR_CODE, Pacs00900110ErrorConstant.C14_ERROR_TEXT);
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
     *
     * @return C15规则检查
     */
    public Constraints checkC15() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct) && JudgeUtils.isNull(instdRmbrsmntAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C15_ERROR_SEVERITY, Pacs00900110ErrorConstant.C15_ERROR_CODE, Pacs00900110ErrorConstant.C15_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If GroupHeader/InstructingAgent is present, then CreditTransferTransactionInformation/
     * InstructingAgent is not allowed. (CrossElementComplexRule)
     *
     * @return C16规则检查
     */
    public Constraints checkC16() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 instgAgt1 = creditTransferTransaction56.getInstgAgt();
                        if (JudgeUtils.isNotNull(instgAgt) && JudgeUtils.isNotNull(instgAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C16_ERROR_SEVERITY, Pacs00900110ErrorConstant.C16_ERROR_CODE, Pacs00900110ErrorConstant.C16_ERROR_TEXT);
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
     *
     * @return C17规则检查
     */
    public Constraints checkC17() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C17_ERROR_SEVERITY, Pacs00900110ErrorConstant.C17_ERROR_CODE, Pacs00900110ErrorConstant.C17_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C18规则检查
     */
    public Constraints checkC18() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction56.getIntrmyAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct) && JudgeUtils.isNull(intrmyAgt1)) {
                        return new Constraints(Pacs00900110ErrorConstant.C18_ERROR_SEVERITY, Pacs00900110ErrorConstant.C18_ERROR_CODE, Pacs00900110ErrorConstant.C18_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C19规则检查
     */
    public Constraints checkC19() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 intrmyAgt1Acct = undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = undrlygCstmrCdtTrf.getIntrmyAgt1();
                        if (JudgeUtils.isNotNull(intrmyAgt1Acct) && JudgeUtils.isNull(intrmyAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C19_ERROR_SEVERITY, Pacs00900110ErrorConstant.C19_ERROR_CODE, Pacs00900110ErrorConstant.C19_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent1 is present, then CreditorAgent must be
     * present. (CrossElementComplexRule)
     *
     * @return C20规则检查
     */
    public Constraints checkC20() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                    BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                    if (JudgeUtils.isNotNull(intrmyAgt1) && JudgeUtils.isNull(cdtrAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C20_ERROR_SEVERITY, Pacs00900110ErrorConstant.C20_ERROR_CODE, Pacs00900110ErrorConstant.C20_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent2Account is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C21规则检查
     */
    public Constraints checkC21() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction56.getIntrmyAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct) && JudgeUtils.isNull(intrmyAgt2)) {
                        return new Constraints(Pacs00900110ErrorConstant.C21_ERROR_SEVERITY, Pacs00900110ErrorConstant.C21_ERROR_CODE, Pacs00900110ErrorConstant.C21_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent2Account is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C22规则检查
     */
    public Constraints checkC22() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 intrmyAgt2Acct = undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = undrlygCstmrCdtTrf.getIntrmyAgt2();
                        if (JudgeUtils.isNotNull(intrmyAgt2Acct) && JudgeUtils.isNull(intrmyAgt2)) {
                            return new Constraints(Pacs00900110ErrorConstant.C22_ERROR_SEVERITY, Pacs00900110ErrorConstant.C22_ERROR_CODE, Pacs00900110ErrorConstant.C22_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent2 is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C23规则检查
     */
    public Constraints checkC23() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                    if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
                        return new Constraints(Pacs00900110ErrorConstant.C23_ERROR_SEVERITY, Pacs00900110ErrorConstant.C23_ERROR_CODE, Pacs00900110ErrorConstant.C23_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent2 is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C24规则检查
     */
    public Constraints checkC24() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = undrlygCstmrCdtTrf.getIntrmyAgt2();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = undrlygCstmrCdtTrf.getIntrmyAgt1();
                        if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C24_ERROR_SEVERITY, Pacs00900110ErrorConstant.C24_ERROR_CODE, Pacs00900110ErrorConstant.C24_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent3Account is present, then IntermediaryAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C25规则检查
     */
    public Constraints checkC25() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction56.getIntrmyAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct) && JudgeUtils.isNull(intrmyAgt3)) {
                        return new Constraints(Pacs00900110ErrorConstant.C25_ERROR_SEVERITY, Pacs00900110ErrorConstant.C25_ERROR_CODE, Pacs00900110ErrorConstant.C25_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent3Account is present, then IntermediaryAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C26规则检查
     */
    public Constraints checkC26() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 intrmyAgt3Acct = undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = undrlygCstmrCdtTrf.getIntrmyAgt3();
                        if (JudgeUtils.isNotNull(intrmyAgt3Acct) && JudgeUtils.isNull(intrmyAgt3)) {
                            return new Constraints(Pacs00900110ErrorConstant.C26_ERROR_SEVERITY, Pacs00900110ErrorConstant.C26_ERROR_CODE, Pacs00900110ErrorConstant.C26_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent3 is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C27规则检查
     */
    public Constraints checkC27() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                    if (JudgeUtils.isNotNull(intrmyAgt3) && JudgeUtils.isNull(intrmyAgt2)) {
                        return new Constraints(Pacs00900110ErrorConstant.C27_ERROR_SEVERITY, Pacs00900110ErrorConstant.C27_ERROR_CODE, Pacs00900110ErrorConstant.C27_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If IntermediaryAgent3 is present, then IntermediaryAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C28规则检查
     */
    public Constraints checkC28() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = undrlygCstmrCdtTrf.getIntrmyAgt3();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = undrlygCstmrCdtTrf.getIntrmyAgt2();
                        if (JudgeUtils.isNotNull(intrmyAgt3) && JudgeUtils.isNull(intrmyAgt2)) {
                            return new Constraints(Pacs00900110ErrorConstant.C28_ERROR_SEVERITY, Pacs00900110ErrorConstant.C28_ERROR_CODE, Pacs00900110ErrorConstant.C28_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If GroupHeader/PaymentTypeInformation is present, then
     * CreditTransferTransactionInformation/PaymentTypeInformation is not
     * allowed. (CrossElementComplexRule)
     *
     * @return C29规则检查
     */
    public Constraints checkC29() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                PaymentTypeInformation28 pmtTpInf = grpHdr.getPmtTpInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        PaymentTypeInformation28 pmtTpInf1 = creditTransferTransaction56.getPmtTpInf();
                        if (JudgeUtils.isNotNull(pmtTpInf) && JudgeUtils.isNotNull(pmtTpInf1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C29_ERROR_SEVERITY, Pacs00900110ErrorConstant.C29_ERROR_CODE, Pacs00900110ErrorConstant.C29_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C30规则检查
     */
    public Constraints checkC30() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction56.getPrvsInstgAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct) && JudgeUtils.isNull(prvsInstgAgt1)) {
                        return new Constraints(Pacs00900110ErrorConstant.C30_ERROR_SEVERITY, Pacs00900110ErrorConstant.C30_ERROR_CODE, Pacs00900110ErrorConstant.C30_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C31规则检查
     */
    public Constraints checkC31() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 prvsInstgAgt1Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = undrlygCstmrCdtTrf.getPrvsInstgAgt1();
                        if (JudgeUtils.isNotNull(prvsInstgAgt1Acct) && JudgeUtils.isNull(prvsInstgAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C31_ERROR_SEVERITY, Pacs00900110ErrorConstant.C31_ERROR_CODE, Pacs00900110ErrorConstant.C31_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent2Account is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C34规则检查
     */
    public Constraints checkC34() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction56.getPrvsInstgAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct) && JudgeUtils.isNull(prvsInstgAgt2)) {
                        return new Constraints(Pacs00900110ErrorConstant.C34_ERROR_SEVERITY, Pacs00900110ErrorConstant.C34_ERROR_CODE, Pacs00900110ErrorConstant.C34_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent2Account is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C35规则检查
     */
    public Constraints checkC35() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 prvsInstgAgt2Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = undrlygCstmrCdtTrf.getPrvsInstgAgt2();
                        if (JudgeUtils.isNotNull(prvsInstgAgt2Acct) && JudgeUtils.isNull(prvsInstgAgt2)) {
                            return new Constraints(Pacs00900110ErrorConstant.C35_ERROR_SEVERITY, Pacs00900110ErrorConstant.C35_ERROR_CODE, Pacs00900110ErrorConstant.C35_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent2 is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C36规则检查
     */
    public Constraints checkC36() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2) && JudgeUtils.isNull(prvsInstgAgt1)) {
                        return new Constraints(Pacs00900110ErrorConstant.C36_ERROR_SEVERITY, Pacs00900110ErrorConstant.C36_ERROR_CODE, Pacs00900110ErrorConstant.C36_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent2 is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     *
     * @return C37规则检查
     */
    public Constraints checkC37() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = undrlygCstmrCdtTrf.getPrvsInstgAgt2();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = undrlygCstmrCdtTrf.getPrvsInstgAgt1();
                        if (JudgeUtils.isNotNull(prvsInstgAgt2) && JudgeUtils.isNull(prvsInstgAgt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C37_ERROR_SEVERITY, Pacs00900110ErrorConstant.C37_ERROR_CODE, Pacs00900110ErrorConstant.C37_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent3Account is present, then PreviousInstructingAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C38规则检查
     */
    public Constraints checkC38() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction56.getPrvsInstgAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct) && JudgeUtils.isNull(prvsInstgAgt3)) {
                        return new Constraints(Pacs00900110ErrorConstant.C38_ERROR_SEVERITY, Pacs00900110ErrorConstant.C38_ERROR_CODE, Pacs00900110ErrorConstant.C38_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent3Account is present, then PreviousInstructingAgent3 must be
     * present. (CrossElementComplexRule)
     *
     * @return C39规则检查
     */
    public Constraints checkC39() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        CashAccount40 prvsInstgAgt3Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = undrlygCstmrCdtTrf.getPrvsInstgAgt3();
                        if (JudgeUtils.isNotNull(prvsInstgAgt3Acct) && JudgeUtils.isNull(prvsInstgAgt3)) {
                            return new Constraints(Pacs00900110ErrorConstant.C39_ERROR_SEVERITY, Pacs00900110ErrorConstant.C39_ERROR_CODE, Pacs00900110ErrorConstant.C39_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent3 is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C40规则检查
     */
    public Constraints checkC40() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3) && JudgeUtils.isNull(prvsInstgAgt2)) {
                        return new Constraints(Pacs00900110ErrorConstant.C40_ERROR_SEVERITY, Pacs00900110ErrorConstant.C40_ERROR_CODE, Pacs00900110ErrorConstant.C40_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If PreviousInstructingAgent3 is present, then PreviousInstructingAgent2 must be
     * present. (CrossElementComplexRule)
     *
     * @return C41规则检查
     */
    public Constraints checkC41() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = creditTransferTransaction56.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = undrlygCstmrCdtTrf.getPrvsInstgAgt3();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = undrlygCstmrCdtTrf.getPrvsInstgAgt2();
                        if (JudgeUtils.isNotNull(prvsInstgAgt3) && JudgeUtils.isNull(prvsInstgAgt2)) {
                            return new Constraints(Pacs00900110ErrorConstant.C41_ERROR_SEVERITY, Pacs00900110ErrorConstant.C41_ERROR_CODE, Pacs00900110ErrorConstant.C41_ERROR_TEXT);
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
     * @return C42规则检查
     */
    public Constraints checkC42() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("INDA".equals(value) || "INGA".equals(value)) {
                            if (JudgeUtils.isNotNull(clrSys) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                return new Constraints(Pacs00900110ErrorConstant.C42_ERROR_SEVERITY, Pacs00900110ErrorConstant.C42_ERROR_CODE, Pacs00900110ErrorConstant.C42_ERROR_TEXT);
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
     * @return C43规则检查
     */
    public Constraints checkC43() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("CLRG".equals(value)) {
                            if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                return new Constraints(Pacs00900110ErrorConstant.C43_ERROR_SEVERITY, Pacs00900110ErrorConstant.C43_ERROR_CODE, Pacs00900110ErrorConstant.C43_ERROR_TEXT);
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
     * @return C44规则检查
     */
    public Constraints checkC44() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("COVE".equals(value)) {
                            if (JudgeUtils.isNull(instgRmbrsmntAgt) && JudgeUtils.isNull(instdRmbrsmntAgt)) {
                                return new Constraints(Pacs00900110ErrorConstant.C44_ERROR_SEVERITY, Pacs00900110ErrorConstant.C44_ERROR_CODE, Pacs00900110ErrorConstant.C44_ERROR_TEXT);
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
     * @return C45规则检查
     */
    public Constraints checkC45() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("COVE".equals(value)) {
                            if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(clrSys)) {
                                return new Constraints(Pacs00900110ErrorConstant.C45_ERROR_SEVERITY, Pacs00900110ErrorConstant.C45_ERROR_CODE, Pacs00900110ErrorConstant.C45_ERROR_TEXT);
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
     * @return C48规则检查
     */
    public Constraints checkC48() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct) && JudgeUtils.isNull(thrdRmbrsmntAgt)) {
                        return new Constraints(Pacs00900110ErrorConstant.C48_ERROR_SEVERITY, Pacs00900110ErrorConstant.C48_ERROR_CODE, Pacs00900110ErrorConstant.C48_ERROR_TEXT);
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
     * @return C49规则检查
     */
    public Constraints checkC49() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgt) && (JudgeUtils.isNull(instdRmbrsmntAgt) || JudgeUtils.isNull(instgRmbrsmntAgt))) {
                        return new Constraints(Pacs00900110ErrorConstant.C49_ERROR_SEVERITY, Pacs00900110ErrorConstant.C49_ERROR_CODE, Pacs00900110ErrorConstant.C49_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * If TotalInterbankSettlementAmount is present, then InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     *
     * @return C50规则检查
     */
    public Constraints checkC50() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt) && JudgeUtils.isNull(intrBkSttlmDt)) {
                    return new Constraints(Pacs00900110ErrorConstant.C50_ERROR_SEVERITY, Pacs00900110ErrorConstant.C50_ERROR_CODE, Pacs00900110ErrorConstant.C50_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    /**
     * If GroupHeader/TotalInterbankSettlementAmount is present, then it must equal the sum of all
     * occurrences of CreditTransferTransactionInformation/
     * InterbankSettlementAmount. (CrossElementComplexRule)
     *
     * @return C51规则检查
     */
    public Constraints checkC51() {
        if (JudgeUtils.isNotNull(this.getFICdtTrf())) {
            FinancialInstitutionCreditTransferV10 fiToFICstmrCdtTrf = this.getFICdtTrf();
            Optional<FinancialInstitutionCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<BigDecimal> bigDecimal = fiToFICustomerCreditTransferV10.map(FinancialInstitutionCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getTtlIntrBkSttlmAmt)
                    .map(ActiveCurrencyAndAmount::getValue);
            BigDecimal intrBkSttlmAmt = new BigDecimal(0);
//        BigDecimal intrBkSttlmAmt = BigDecimal.ZERO;
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt1 = creditTransferTransaction56.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt1)) {
                        BigDecimal value = intrBkSttlmAmt1.getValue();
                        if (JudgeUtils.isNotNull(value)) {
                            intrBkSttlmAmt = intrBkSttlmAmt.add(value);
                        }
                    }
                }
            }
            if (bigDecimal.isPresent()) {
                BigDecimal ttlIntrBkSttlmAmt = fiToFICstmrCdtTrf.getGrpHdr().getTtlIntrBkSttlmAmt().getValue();
                if (!ttlIntrBkSttlmAmt.equals(intrBkSttlmAmt)) {
                    return new Constraints(Pacs00900110ErrorConstant.C51_ERROR_SEVERITY, Pacs00900110ErrorConstant.C51_ERROR_CODE, Pacs00900110ErrorConstant.C51_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * If GroupHeader/TotalInterbankSettlementAmount is present, then all occurrences of
     * CreditTransferTransactionInformation/InterbankSettlementAmount must have the same
     * currency as the currency of GroupHeader/
     * TotalInterbankSettlementAmount. (CrossElementComplexRule)
     *
     * @return C52规则检查
     */
    public Constraints checkC52() {
        if (JudgeUtils.isNotNull(this.getFICdtTrf())) {
            FinancialInstitutionCreditTransferV10 fiToFICstmrCdtTrf = this.getFICdtTrf();
            Optional<FinancialInstitutionCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<String> aCcy = fiToFICustomerCreditTransferV10.map(FinancialInstitutionCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getTtlIntrBkSttlmAmt)
                    .map(ActiveCurrencyAndAmount::getCcy);
            if (aCcy.isPresent()) {
                String ttlIntrBkSttlmAmtCcy = fiToFICstmrCdtTrf.getGrpHdr().getTtlIntrBkSttlmAmt().getCcy();
                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                    List<CreditTransferTransaction56> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        ActiveCurrencyAndAmount intrBkSttlmAmt1 = creditTransferTransaction56.getIntrBkSttlmAmt();
                        if (JudgeUtils.isNotNull(intrBkSttlmAmt1)) {
                            String ccy = intrBkSttlmAmt1.getCcy();
                            if (!ccy.equals(ttlIntrBkSttlmAmtCcy)) {
                                return new Constraints(Pacs00900110ErrorConstant.C52_ERROR_SEVERITY, Pacs00900110ErrorConstant.C52_ERROR_CODE, Pacs00900110ErrorConstant.C52_ERROR_TEXT, ccy);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * TransactionIdentification or UETR must be present. Both may be
     * present (CrossElementSimpleRule)
     * PaymentIdentification <PmtId> [1..1] ± ✓C53
     *
     * @return C53规则检查
     */
    public Constraints checkC53() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                    PaymentIdentification13 pmtId = creditTransferTransaction56.getPmtId();
                    if (JudgeUtils.isNotNull(pmtId)) {
                        String txId = pmtId.getTxId();
                        String uetr = pmtId.getUETR();
                        if (JudgeUtils.isNull(txId) && JudgeUtils.isNull(uetr)) {
                            return new Constraints(Pacs00900110ErrorConstant.C53_ERROR_SEVERITY, Pacs00900110ErrorConstant.C53_ERROR_CODE, Pacs00900110ErrorConstant.C53_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If GroupHeader/InterbankSettlementDate is not present, then
     * CreditTransferTransactionInformation/InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     *
     * @return C54规则检查
     */
    public Constraints checkC54() {
        FinancialInstitutionCreditTransferV10 fiCdtTrf = this.getFICdtTrf();
        if (JudgeUtils.isNotNull(fiCdtTrf)) {
            List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
            GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        XMLGregorianCalendar intrBkSttlmDt1 = creditTransferTransaction56.getIntrBkSttlmDt();
                        if (JudgeUtils.isNull(intrBkSttlmDt) && JudgeUtils.isNull(intrBkSttlmDt1)) {
                            return new Constraints(Pacs00900110ErrorConstant.C54_ERROR_SEVERITY, Pacs00900110ErrorConstant.C54_ERROR_CODE, Pacs00900110ErrorConstant.C54_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public String checkC() {

        return "未更改调用";
    }
}
