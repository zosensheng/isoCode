package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.util.RuleUtils;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * <p>Document053 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document053">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{}FIToFICustomerCreditTransferV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document053", propOrder = {
        "fiToFICstmrCdtTrf"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10")
public class Pacs00800110 {

    @XmlElement(name = "FIToFICstmrCdtTrf", required = true)
    protected FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf;

    /**
     * ��ȡfiToFICstmrCdtTrf���Ե�ֵ��
     *
     * @return possible object is
     * {@link FIToFICustomerCreditTransferV10 }
     */
    public FIToFICustomerCreditTransferV10 getFIToFICstmrCdtTrf() {
        return fiToFICstmrCdtTrf;
    }

    /**
     * ����fiToFICstmrCdtTrf���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link FIToFICustomerCreditTransferV10 }
     */
    public void setFIToFICstmrCdtTrf(FIToFICustomerCreditTransferV10 value) {
        this.fiToFICstmrCdtTrf = value;
    }


    public ArrayList<Constraints> checkAll() {

        ArrayList<Constraints> constraints = new ArrayList<>();
        constraints.add(checkC1());
        constraints.add(checkC2());
        constraints.add(checkC3());
        constraints.add(checkC4());
        constraints.add(checkC5());
        constraints.add(checkC7());
        constraints.add(checkC9());
        constraints.add(checkC10());
        constraints.add(checkC11());
        constraints.add(checkC12());
        constraints.add(checkC13());
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
        constraints.add(checkC33());
        constraints.add(checkC34());
        constraints.add(checkC35());
        constraints.add(checkC36());
        constraints.add(checkC37());
        constraints.add(checkC38());
        constraints.add(checkC39());
        constraints.add(checkC40());
        constraints.add(checkC43());
        constraints.add(checkC44());
        constraints.add(checkC45());
        constraints.add(checkC46());
        constraints.add(checkC47());
        constraints.add(checkC48());
        constraints.add(checkC49());
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
     *
     * @return 返回C1检查结果
     */
    public Constraints checkC1() {
        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
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
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccy = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotNull(ccy)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveCurrency(ccy).getErrorCode())) {
                                    return RuleUtils.checkActiveCurrency(ccy);
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
     *
     * @return C2规则检查
     */
    public Constraints checkC2() {
        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    if (JudgeUtils.isNotNull(sttlmAcct)) {
                        String ccy = sttlmAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                        String ccy = instgRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        String ccy = instdRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
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
            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(instdAmt).getErrorCode())) {
                        return RuleUtils.checkActiveOrHistoricCurrency(instdAmt);
                    }
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction50.getPrvsInstgAgt1Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        String ccy = prvsInstgAgt1Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction50.getPrvsInstgAgt2Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        String ccy = prvsInstgAgt2Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction50.getPrvsInstgAgt3Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        String ccy = prvsInstgAgt3Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction50.getIntrmyAgt1Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        String ccy = intrmyAgt1Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction50.getIntrmyAgt2Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        String ccy = intrmyAgt2Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction50.getIntrmyAgt3Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        String ccy = intrmyAgt3Acct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        String ccy = dbtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction50.getDbtrAgtAcct();
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        String ccy = dbtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction50.getCdtrAgtAcct();
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        String ccy = cdtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        String ccy = cdtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ccy).getErrorCode())) {
                                return RuleUtils.checkActiveOrHistoricCurrency(ccy);
                            }
                        }
                    }
                    TaxInformation10 tax = creditTransferTransaction50.getTax();
                    if (JudgeUtils.isNotNull(tax)) {
                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ttlTaxblBaseAmt).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(ttlTaxblBaseAmt);
                        }
                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(ttlTaxAmt).getErrorCode())) {
                            return RuleUtils.checkActiveOrHistoricCurrency(ttlTaxAmt);
                        }
                        List<TaxRecord3> rcrd = tax.getRcrd();
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
                    RemittanceInformation21 rmtInf = creditTransferTransaction50.getRmtInf();
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
                                                    ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(cdtNoteAmt).getErrorCode())) {
                                                        return RuleUtils.checkActiveOrHistoricCurrency(cdtNoteAmt);
                                                    }
                                                    ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkActiveOrHistoricCurrency(rmtdAmt).getErrorCode())) {
                                                        return RuleUtils.checkActiveOrHistoricCurrency(rmtdAmt);
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
                }
            }
        }
        return null;
    }


    /**
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial
     * institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * todo 查看是否是在注册的
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
     *
     * @return C3规则检查
     */
    public Constraints checkC3() {
        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                    PartyIdentification135 initgPty = creditTransferTransaction50.getInitgPty();
                    PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                    PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                    PartyIdentification135 ultmtCdtr = creditTransferTransaction50.getUltmtCdtr();
                    RemittanceInformation21 rmtInf = creditTransferTransaction50.getRmtInf();
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
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                        if (JudgeUtils.isNotNull(strd)) {
                            for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(invcr).getErrorCode())) {
                                    return RuleUtils.checkAnyBIC(invcr);
                                }
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkAnyBIC(invcee).getErrorCode())) {
                                    return RuleUtils.checkAnyBIC(invcee);
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
     * todo 查看是否是在注册的
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
     *
     * @return C4规则检查
     */
    public Constraints checkC4() {
        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instdAgt);
                }
                if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instgAgt).getErrorCode())) {
                    return RuleUtils.checkBICFI(instgAgt);
                }
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
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction50.getPrvsInstgAgt1();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction50.getPrvsInstgAgt2();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction50.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification6 instgAgt = creditTransferTransaction50.getInstgAgt();
                    BranchAndFinancialInstitutionIdentification6 instdAgt = creditTransferTransaction50.getInstdAgt();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction50.getIntrmyAgt1();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction50.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction50.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                    BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
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
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt1).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt1);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt2).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt2);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(intrmyAgt3).getErrorCode())) {
                        return RuleUtils.checkBICFI(intrmyAgt3);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(dbtrAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(dbtrAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(cdtrAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(cdtrAgt);
                    }
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkBICFI(instdAgt).getErrorCode())) {
                        return RuleUtils.checkBICFI(instdAgt);
                    }


                }
            }
        }
        return null;
    }


    /**
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
     *
     * @return C9规则检查
     */
    public Constraints checkC9() {
        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    PartyIdentification135 ultmtCdtr = creditTransferTransaction50.getUltmtCdtr();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ultmtCdtr).getErrorCode())) {
                        return RuleUtils.checkCountry(ultmtCdtr);
                    }
                    PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ultmtDbtr).getErrorCode())) {
                        return RuleUtils.checkCountry(ultmtDbtr);
                    }
                    PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(cdtr).getErrorCode())) {
                        return RuleUtils.checkCountry(cdtr);
                    }
                    PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(dbtr).getErrorCode())) {
                        return RuleUtils.checkCountry(dbtr);
                    }
                    PartyIdentification135 initgPty = creditTransferTransaction50.getInitgPty();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(initgPty).getErrorCode())) {
                        return RuleUtils.checkCountry(initgPty);
                    }
                    RemittanceInformation21 rmtInf = creditTransferTransaction50.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                        if (JudgeUtils.isNotNull(strd)) {
                            for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(invcee).getErrorCode())) {
                                    return RuleUtils.checkCountry(invcee);
                                }
                                PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(invcr).getErrorCode())) {
                                    return RuleUtils.checkCountry(invcr);
                                }
                            }
                        }
                    }
                    List<RegulatoryReporting3> rgltryRptg = creditTransferTransaction50.getRgltryRptg();
                    if (JudgeUtils.isNotNull(rgltryRptg)) {
                        for (RegulatoryReporting3 regulatoryReporting3 : rgltryRptg) {
                            RegulatoryAuthority2 authrty = regulatoryReporting3.getAuthrty();
                            List<StructuredRegulatoryReporting3> dtls = regulatoryReporting3.getDtls();
                            if (JudgeUtils.isNotNull(authrty)) {
                                String ctry = authrty.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                        return RuleUtils.checkCountry(ctry);
                                    }
                                }
                            }
                            if (JudgeUtils.isNotNull(dtls)) {
                                for (StructuredRegulatoryReporting3 dtl : dtls) {
                                    String ctry = dtl.getCtry();
                                    if (JudgeUtils.isNotNull(ctry)) {
                                        if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ctry).getErrorCode())) {
                                            return RuleUtils.checkCountry(ctry);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    List<RemittanceLocation7> rltdRmtInf = creditTransferTransaction50.getRltdRmtInf();
                    if (JudgeUtils.isNotNull(rltdRmtInf)) {
                        for (RemittanceLocation7 remittanceLocation7 : rltdRmtInf) {
                            List<RemittanceLocationData1> rmtLctnDtls = remittanceLocation7.getRmtLctnDtls();
                            if (JudgeUtils.isNotNull(rmtLctnDtls)) {
                                for (RemittanceLocationData1 rmtLctnDtl : rmtLctnDtls) {
                                    NameAndAddress16 pstlAdr = rmtLctnDtl.getPstlAdr();
                                    if (JudgeUtils.isNotNull(pstlAdr)) {
                                        PostalAddress24 adr = pstlAdr.getAdr();
                                        if (JudgeUtils.isNotNull(adr)) {
                                            String ctry = adr.getCtry();
                                            if (JudgeUtils.isNotNull(ctry)) {
                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkCountry(ultmtCdtr).getErrorCode())) {
                                                    return RuleUtils.checkCountry(ultmtCdtr);
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
     *
     * @return 返回C11检查结果
     */
    public Constraints checkC11() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                    TaxInformation10 tax = creditTransferTransaction50.getTax();
                    RemittanceInformation21 rmtInf = creditTransferTransaction50.getRmtInf();
                    if (JudgeUtils.isNotNull(instdAmt)) {
                        BigDecimal value = instdAmt.getValue();
                        String ccy = instdAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                        }
                    }
                    if (JudgeUtils.isNotNull(tax)) {
                        ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                        if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                            BigDecimal value = ttlTaxblBaseAmt.getValue();
                            String ccy = ttlTaxblBaseAmt.getCcy();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                            }
                        }
                        ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                        if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                            BigDecimal value = ttlTaxAmt.getValue();
                            String ccy = ttlTaxAmt.getCcy();
                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                            }
                        }
                        List<TaxRecord3> rcrd = tax.getRcrd();
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
                                                            ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                            if (JudgeUtils.isNotNull(amt1)) {
                                                                BigDecimal value = amt1.getValue();
                                                                List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                                String ccy = amt1.getCcy();
                                                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                                                                    return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                                                                }
                                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                                    for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                                        ActiveOrHistoricCurrencyAndAmount amt2 = taxAmountAndType1.getAmt();
                                                                        if (JudgeUtils.isNotNull(amt2)) {
                                                                            BigDecimal value1 = amt2.getValue();
                                                                            String ccy1 = amt2.getCcy();
                                                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy1, value1).getErrorCode())) {
                                                                                return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy1, value1);
                                                                            }
                                                                        }
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
                                    if (JudgeUtils.isNotNull(rcrd)) {
                                        for (TaxRecord3 taxRecord3 : rcrd) {
                                            TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                            if (JudgeUtils.isNotNull(taxAmt)) {
                                                ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                                List<TaxRecordDetails3> dtls = taxAmt.getDtls();
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
    //todo 可能存在问题
    public Constraints checkC5() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                    List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                    if (JudgeUtils.isNotNull(chrgBr)) {
                        String value = chrgBr.value();
                        if ("CRED".equals(value)) {
                            if (JudgeUtils.isNotNull(chrgsInf)) {
                                for (Charges7 charges7 : chrgsInf) {
                                    ActiveOrHistoricCurrencyAndAmount amt = charges7.getAmt();
                                    BranchAndFinancialInstitutionIdentification6 agt = charges7.getAgt();
                                    if (JudgeUtils.isNull(amt) || JudgeUtils.isNull(agt)) {
                                        return new Constraints(Pacs00800110ErrorConstant.C5_ERROR_SEVERITY, Pacs00800110ErrorConstant.C5_ERROR_CODE, Pacs00800110ErrorConstant.C5_ERROR_TEXT);
                                    }
                                }
                            } else {
                                return new Constraints(Pacs00800110ErrorConstant.C5_ERROR_SEVERITY, Pacs00800110ErrorConstant.C5_ERROR_CODE, Pacs00800110ErrorConstant.C5_ERROR_TEXT);
                            }
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
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotEmpty(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                    ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                    if (JudgeUtils.isNotNull(chrgsInf) && JudgeUtils.isNull(instdAmt)) {
                        return new Constraints(Pacs00800110ErrorConstant.C7_ERROR_SEVERITY, Pacs00800110ErrorConstant.C7_ERROR_CODE, Pacs00800110ErrorConstant.C7_ERROR_TEXT);
                    }
                }
            }

        }
        return null;
    }

    /**
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     * TotalInterbankSettlementAmount <TtlIntrBkSttlmAmt> [0..1] Amount ✓C1,✓C10
     * InterbankSettlementAmount <IntrBkSttlmAmt> [1..1] Amount ✓C1,✓C10
     *
     * @return C10规则检查
     */
    public Constraints checkC10() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt)) {
                    String ccy = ttlIntrBkSttlmAmt.getCcy();
                    BigDecimal value = ttlIntrBkSttlmAmt.getValue();
                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                        return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                    }
                }
            }
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccy = intrBkSttlmAmt.getCcy();
                        BigDecimal value = intrBkSttlmAmt.getValue();
                        if (JudgeUtils.isNotSuccess(RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value).getErrorCode())) {
                            return RuleUtils.checkIdentificationOrProxyPresenceRule(ccy, value);
                        }
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
     * GroupHeader/InterbankSettlementDate >< CreditTransferTransactionInformation/InterbankSettlementDate
     * <GrpHdr>/<IntrBkSttlmDt>     <CdtTrfTxInf>/<IntrBkSttlmDt>
     *
     * @return C12规则检查
     */
    public Constraints checkC12() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<XMLGregorianCalendar> xmlGregorianCalendar = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getIntrBkSttlmDt);

            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {

                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    XMLGregorianCalendar intrBkSttlmDt = creditTransferTransaction50.getIntrBkSttlmDt();
                    if (xmlGregorianCalendar.isPresent()) {
                        if (JudgeUtils.isNotNull(intrBkSttlmDt)) {
                            return new Constraints(Pacs00800110ErrorConstant.C12_ERROR_SEVERITY, Pacs00800110ErrorConstant.C12_ERROR_CODE, Pacs00800110ErrorConstant.C12_ERROR_TEXT);
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
     * IBAN Id SttlmAcct SttlmInf GrpHdr
     * IBAN Id InstgRmbrsmntAgtAcct SttlmInf GrpHdr
     * IBAN Id PrvsInstgAgt1Acct CdtTrfTxInf
     * <p>
     * Format
     * pattern [A-Z]{2,2}[0-9]{2,2}[a-zA-Z0-9]{1,30}
     *
     * @return C13规则检查
     */
    public Constraints checkC13() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
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
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                        AccountIdentification4Choice id = thrdRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                }
            }
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction50.getPrvsInstgAgt1Acct();
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction50.getPrvsInstgAgt2Acct();
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction50.getPrvsInstgAgt3Acct();
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction50.getIntrmyAgt1Acct();
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction50.getIntrmyAgt2Acct();
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction50.getIntrmyAgt3Acct();
                    CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction50.getCdtrAgtAcct();
                    CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction50.getDbtrAgtAcct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        AccountIdentification4Choice id = cdtrAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        AccountIdentification4Choice id = cdtrAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        AccountIdentification4Choice id = dbtrAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        AccountIdentification4Choice id = dbtrAgtAcct.getId();
                        if (JudgeUtils.isNotNull(id)) {
                            String iban = id.getIBAN();
                            if (JudgeUtils.isNotNull(iban)) {
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
     * SettlementAccount <SttlmAcct> [0..1] ✓C15,C14
     * InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct> [0..1] ✓C15,C14
     * InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct> [0..1] ✓C15,C14
     * ThirdReimbursementAgentAccount <ThrdRmbrsmntAgtAcct> [0..1] ✓C15,C14
     * PreviousInstructingAgent1Account <PrvsInstgAgt1Acct> [0..1] ✓C15,C14>
     * PreviousInstructingAgent2Account <PrvsInstgAgt2Acct> [0..1] ✓C15,C14
     * PreviousInstructingAgent3Account <PrvsInstgAgt3Acct> [0..1] ✓C15,C14
     * IntermediaryAgent1Account <IntrmyAgt1Acct> [0..1] ✓C15,C14
     * IntermediaryAgent2Account <IntrmyAgt2Acct> [0..1] ✓C15,C14
     * IntermediaryAgent3Account <IntrmyAgt3Acct> [0..1] ✓C15,C14
     * DebtorAccount <DbtrAcct> [0..1] ✓C15,C14
     * DebtorAgentAccount <DbtrAgtAcct> [0..1] ✓C15,C14
     * CreditorAgentAccount <CdtrAgtAcct> [0..1] ✓C15,C14
     * CreditorAccount <CdtrAcct> [0..1] ✓C15,C14
     *
     * @return C15规则检查
     */
    public Constraints checkC15() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<SettlementInstruction11> settlementInstruction11 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf);
            Optional<CashAccount40> cashAccount40 = settlementInstruction11.map(SettlementInstruction11::getSttlmAcct);
            if (cashAccount40.isPresent()) {
                ProxyAccountIdentification1 prxy = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getSttlmAcct().getPrxy();
                AccountIdentification4Choice identification4Choice = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getSttlmAcct().getId();
                if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(identification4Choice)) {
                    return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);

                }
            }
            Optional<CashAccount40> cashAccount401 = settlementInstruction11.map(SettlementInstruction11::getInstdRmbrsmntAgtAcct);
            if (cashAccount401.isPresent()) {
                ProxyAccountIdentification1 prxy = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getInstdRmbrsmntAgtAcct().getPrxy();
                AccountIdentification4Choice identification4Choice = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getInstdRmbrsmntAgtAcct().getId();
                if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(identification4Choice)) {
                    return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                }
            }
            Optional<CashAccount40> cashAccount402 = settlementInstruction11.map(SettlementInstruction11::getInstgRmbrsmntAgtAcct);
            if (cashAccount402.isPresent()) {
                ProxyAccountIdentification1 prxy = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getInstgRmbrsmntAgtAcct().getPrxy();
                AccountIdentification4Choice identification4Choice = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getInstgRmbrsmntAgtAcct().getId();
                if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(identification4Choice)) {
                    return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                }
            }
            Optional<CashAccount40> cashAccount403 = settlementInstruction11.map(SettlementInstruction11::getThrdRmbrsmntAgtAcct);
            if (cashAccount403.isPresent()) {
                ProxyAccountIdentification1 prxy = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getThrdRmbrsmntAgtAcct().getPrxy();
                AccountIdentification4Choice identification4Choice = fiToFICstmrCdtTrf.getGrpHdr().getSttlmInf().getThrdRmbrsmntAgtAcct().getId();
                if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(identification4Choice)) {
                    return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                }
            }
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction50.getPrvsInstgAgt1Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt1Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction50.getPrvsInstgAgt2Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt2Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction50.getPrvsInstgAgt3Acct();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                        ProxyAccountIdentification1 prxy = prvsInstgAgt3Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction50.getIntrmyAgt1Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                        AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt1Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction50.getIntrmyAgt2Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                        AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt2Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction50.getIntrmyAgt3Acct();
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                        AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                        ProxyAccountIdentification1 prxy = intrmyAgt3Acct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        AccountIdentification4Choice id = dbtrAcct.getId();
                        ProxyAccountIdentification1 prxy = dbtrAcct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        AccountIdentification4Choice id = cdtrAcct.getId();
                        ProxyAccountIdentification1 prxy = cdtrAcct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAgtAcct = creditTransferTransaction50.getCdtrAgtAcct();
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        AccountIdentification4Choice id = cdtrAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = cdtrAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                    CashAccount40 dbtrAgtAcct = creditTransferTransaction50.getDbtrAgtAcct();
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        AccountIdentification4Choice id = dbtrAgtAcct.getId();
                        ProxyAccountIdentification1 prxy = dbtrAgtAcct.getPrxy();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(id)) {
                            return new Constraints(Pacs00800110ErrorConstant.C15_ERROR_SEVERITY, Pacs00800110ErrorConstant.C15_ERROR_CODE, Pacs00800110ErrorConstant.C15_ERROR_TEXT);
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
     * <GrpHdr><InstdAgt>        <cdtTrfTxInf><InstdAgt>
     *
     * @return C16检查规则
     */
    public Constraints checkC16() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                if (JudgeUtils.isNotNull(instdAgt)) {
                    if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                        List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                        for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                            BranchAndFinancialInstitutionIdentification6 instdAgt1 = creditTransferTransaction50.getInstdAgt();
                            if (JudgeUtils.isNotNull(instdAgt1)) {
                                return new Constraints(Pacs00800110ErrorConstant.C16_ERROR_SEVERITY, Pacs00800110ErrorConstant.C16_ERROR_CODE, Pacs00800110ErrorConstant.C16_ERROR_TEXT);
                            }
                        }
                    }
                }
            }

        }
        return null;
    }

    /**
     * If InstructedAmount is present and the currency is different from the currency in
     * InterbankSettlementAmount, then ExchangeRate must be
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
     * @return C17检查规则
     */
    public Constraints checkC17() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotEmpty(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    if (JudgeUtils.isNotNull(creditTransferTransaction50.getInstdAmt())) {
                        ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                        ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                        BigDecimal xchgRate = creditTransferTransaction50.getXchgRate();
                        if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            String ccyInstdAmt = instdAmt.getCcy();
                            String ccyIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                            if (JudgeUtils.isNotNull(ccyInstdAmt) && JudgeUtils.isNotNull(ccyIntrBkSttlmAmt)) {
                                if (!ccyInstdAmt.equals(ccyIntrBkSttlmAmt)) {
                                    if (JudgeUtils.isNull(xchgRate)) {
                                        return new Constraints(Pacs00800110ErrorConstant.C17_ERROR_SEVERITY, Pacs00800110ErrorConstant.C17_ERROR_CODE, Pacs00800110ErrorConstant.C17_ERROR_TEXT);
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
     * If InstructedAmount is present and the currency is the same as the currency in InterbankSettlementAmount,
     * then ExchangeRate is not allowed. (CrossElementComplexRule)
     *
     * @return C18检查规则
     */
    public Constraints checkC18() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotEmpty(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    if (JudgeUtils.isNotNull(creditTransferTransaction50.getInstdAmt())) {
                        ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                        ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                        BigDecimal xchgRate = creditTransferTransaction50.getXchgRate();
                        if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            String ccyInstdAmt = instdAmt.getCcy();
                            String ccyIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                            if (JudgeUtils.isNotNull(ccyInstdAmt) && JudgeUtils.isNotNull(ccyIntrBkSttlmAmt)) {
                                if (ccyInstdAmt.equals(ccyIntrBkSttlmAmt)) {
                                    if (JudgeUtils.isNotNull(xchgRate)) {
                                        return new Constraints(Pacs00800110ErrorConstant.C18_ERROR_SEVERITY, Pacs00800110ErrorConstant.C18_ERROR_CODE, Pacs00800110ErrorConstant.C18_ERROR_TEXT);
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
     * If InstructedAmount is not present, then ExchangeRate is not
     * allowed. (CrossElementComplexRule)
     *
     * @return C19检查规则
     */
    public Constraints checkC19() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotEmpty(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                    BigDecimal xchgRate = creditTransferTransaction50.getXchgRate();
                    if (JudgeUtils.isNull(instdAmt) && JudgeUtils.isNotNull(xchgRate)) {
                        return new Constraints(Pacs00800110ErrorConstant.C19_ERROR_SEVERITY, Pacs00800110ErrorConstant.C19_ERROR_CODE, Pacs00800110ErrorConstant.C19_ERROR_TEXT);
                    }
                }
            }

        }
        return null;
    }

    /**
     * If InstructedReimbursementAgentAccount is present, then InstructedReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * InstructedReimbursementAgentAccount <InstdRmbrsmntAgtAcct> [0..1] ✓C15,C14 SttlmInf GrpHdr
     * InstructedReimbursementAgent <InstdRmbrsmntAgt> [0..1] ± SttlmInf GrpHdr
     *
     * @return C20检查规则
     */
    public Constraints checkC20() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<CashAccount40> cashAccount40 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstdRmbrsmntAgtAcct);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification6 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstdRmbrsmntAgt);
            if (cashAccount40.isPresent() && !branchAndFinancialInstitutionIdentification6.isPresent()) {
                return new Constraints(Pacs00800110ErrorConstant.C20_ERROR_SEVERITY, Pacs00800110ErrorConstant.C20_ERROR_CODE, Pacs00800110ErrorConstant.C20_ERROR_TEXT);
            }
        }

        return null;
    }


    /**
     * If GroupHeader/InstructedAgent is present, then CreditTransferTransactionInformation/
     * InstructedAgent is not allowed. (CrossElementComplexRule)
     * GroupHeader <GrpHdr>
     * InstructedAgent <InstdAgt> [0..1] ± 771
     * CreditTransferTransactionInformation <CdtTrfTxInf>
     * InstructedAgent <InstdAgt> [0..1] ±
     *
     * @return 返回C21检查结果
     */
    public Constraints checkC21() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification6 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getInstdAgt);
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 instdAgt = creditTransferTransaction50.getInstdAgt();
                    if (branchAndFinancialInstitutionIdentification6.isPresent() && JudgeUtils.isNotNull(instdAgt)) {
                        return new Constraints(Pacs00800110ErrorConstant.C21_ERROR_SEVERITY, Pacs00800110ErrorConstant.C21_ERROR_CODE, Pacs00800110ErrorConstant.C21_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }

    /**
     * If InstructingReimbursementAgentAccount is present, then InstructingReimbursementAgent
     * must be present. (CrossElementComplexRule)
     * InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct> [0..1] ✓C15,C14
     * InstructingReimbursementAgent <InstgRmbrsmntAgt> [0..1] ±
     *
     * @return 返回C22检查结果
     */
    public Constraints checkC22() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<CashAccount40> cashAccount40 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstgRmbrsmntAgtAcct);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification6 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstgRmbrsmntAgt);
            if (cashAccount40.isPresent() && branchAndFinancialInstitutionIdentification6.isPresent()) {
                return new Constraints(Pacs00800110ErrorConstant.C22_ERROR_SEVERITY, Pacs00800110ErrorConstant.C22_ERROR_CODE, Pacs00800110ErrorConstant.C22_ERROR_TEXT);
            }
        }

        return null;
    }

    /**
     * If InstructionForCreditorAgent/Code contains CHQB (PayCreditorByCheque), then
     * CreditorAccount is not allowed. (CrossElementComplexRule)
     * InstructionForCreditorAgent <InstrForCdtrAgt> [0..*] ± CdtTrfTxInf
     * Code <Cd> [0..1] CodeSet
     * CreditorAccount <CdtrAcct> [0..1] ✓C15,C14
     *
     * @return 返回C23检查结果
     */
    public Constraints checkC23() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    List<InstructionForCreditorAgent3> instrForCdtrAgt = creditTransferTransaction50.getInstrForCdtrAgt();
                    CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                    if (JudgeUtils.isNotNull(instrForCdtrAgt)) {
                        for (InstructionForCreditorAgent3 instructionForCreditorAgent3 : instrForCdtrAgt) {
                            String cd = instructionForCreditorAgent3.getCd();
                            if (JudgeUtils.isNotNull(cd)) {
                                if (cd.contains("CHQB") && JudgeUtils.isNotNull(cdtrAcct)) {
                                    return new Constraints(Pacs00800110ErrorConstant.C23_ERROR_SEVERITY, Pacs00800110ErrorConstant.C23_ERROR_CODE, Pacs00800110ErrorConstant.C23_ERROR_TEXT);
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
     * If IntermediaryAgent1Account is present, then IntermediaryAgent1 must be
     * present. (CrossElementComplexRule)
     * IntermediaryAgent1Account <IntrmyAgt1Acct> [0..1] ✓C15,C14
     * IntermediaryAgent1 <IntrmyAgt1> [0..1] ±
     *
     * @return 返回C24检查结果
     */
    public Constraints checkC24() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt1Acct = creditTransferTransaction50.getIntrmyAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction50.getIntrmyAgt1();
                    if (JudgeUtils.isNotNull(intrmyAgt1Acct) && JudgeUtils.isNull(intrmyAgt1)) {
                        return new Constraints(Pacs00800110ErrorConstant.C24_ERROR_SEVERITY, Pacs00800110ErrorConstant.C24_ERROR_CODE, Pacs00800110ErrorConstant.C24_ERROR_TEXT);
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
     * @return 返回C25检查结果
     */
    public Constraints checkC25() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt2Acct = creditTransferTransaction50.getIntrmyAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction50.getIntrmyAgt2();
                    if (JudgeUtils.isNotNull(intrmyAgt2Acct) && JudgeUtils.isNull(intrmyAgt2)) {
                        return new Constraints(Pacs00800110ErrorConstant.C25_ERROR_SEVERITY, Pacs00800110ErrorConstant.C25_ERROR_CODE, Pacs00800110ErrorConstant.C25_ERROR_TEXT);
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
     * @return 返回C26检查结果
     */
    public Constraints checkC26() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction50.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction50.getIntrmyAgt1();
                    if (JudgeUtils.isNotNull(intrmyAgt2) && JudgeUtils.isNull(intrmyAgt1)) {
                        return new Constraints(Pacs00800110ErrorConstant.C26_ERROR_SEVERITY, Pacs00800110ErrorConstant.C26_ERROR_CODE, Pacs00800110ErrorConstant.C26_ERROR_TEXT);
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
     * @return 返回C27检查结果
     */
    public Constraints checkC27() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 intrmyAgt3Acct = creditTransferTransaction50.getIntrmyAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction50.getIntrmyAgt3();
                    if (JudgeUtils.isNotNull(intrmyAgt3Acct) && JudgeUtils.isNull(intrmyAgt3)) {
                        return new Constraints(Pacs00800110ErrorConstant.C27_ERROR_SEVERITY, Pacs00800110ErrorConstant.C27_ERROR_CODE, Pacs00800110ErrorConstant.C27_ERROR_TEXT);
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
     * @return 返回C28检查结果
     */
    public Constraints checkC28() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction50.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction50.getIntrmyAgt2();
                    if (JudgeUtils.isNotNull(intrmyAgt3) && JudgeUtils.isNull(intrmyAgt2)) {
                        return new Constraints(Pacs00800110ErrorConstant.C28_ERROR_SEVERITY, Pacs00800110ErrorConstant.C28_ERROR_CODE, Pacs00800110ErrorConstant.C28_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }

    /**
     * GroupHeader/NumberOfTransactions must equal the number of occurrences of
     * CreditTransferTransactionInformation. (CrossElementSimpleRule)
     * NumberOfTransactions <NbOfTxs> [1..1] Text
     * CreditTransferTransactionInformation <CdtTrfTxInf>
     *
     * @return 返回C29检查结果
     */
    public Constraints checkC29() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<String> NbOfTxs = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getNbOfTxs);
            int nbOfTxsInt = 0;
            if (NbOfTxs.isPresent()) {
                String nbOfTxs = fiToFICstmrCdtTrf.getGrpHdr().getNbOfTxs();
                nbOfTxsInt = Integer.parseInt(nbOfTxs);
            }
            int number = 0;
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                number = cdtTrfTxInf.size();
            }
            if (nbOfTxsInt != number) {
                return new Constraints(Pacs00800110ErrorConstant.C29_ERROR_SEVERITY, Pacs00800110ErrorConstant.C29_ERROR_CODE, Pacs00800110ErrorConstant.C29_ERROR_TEXT);
            }
        }

        return null;
    }

    /**
     * If GroupHeader/PaymentTypeInformation is present, then
     * CreditTransferTransactionInformation/PaymentTypeInformation is not
     * allowed. (CrossElementComplexRule)
     *
     * @return 返回C30检查结果
     */
    public Constraints checkC30() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<PaymentTypeInformation28> paymentTypeInformation28 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getPmtTpInf);
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    PaymentTypeInformation28 pmtTpInf = creditTransferTransaction50.getPmtTpInf();
                    if (paymentTypeInformation28.isPresent() && JudgeUtils.isNotNull(pmtTpInf)) {
                        return new Constraints(Pacs00800110ErrorConstant.C30_ERROR_SEVERITY, Pacs00800110ErrorConstant.C30_ERROR_CODE, Pacs00800110ErrorConstant.C30_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }

    /**
     * If PreviousInstructingAgent1Account is present, then PreviousInstructingAgent1 must be
     * present. (CrossElementComplexRule)
     * PreviousInstructingAgent1Account <PrvsInstgAgt1Acct> [0..1] ✓C15,C14 CdtTrfTxInf
     * PreviousInstructingAgent1 <PrvsInstgAgt1> [0..1] ± CdtTrfTxInf
     *
     * @return 返回C31检查结果
     */
    public Constraints checkC31() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt1Acct = creditTransferTransaction50.getPrvsInstgAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction50.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotNull(prvsInstgAgt1Acct) && JudgeUtils.isNull(prvsInstgAgt1)) {
                        return new Constraints(Pacs00800110ErrorConstant.C31_ERROR_SEVERITY, Pacs00800110ErrorConstant.C31_ERROR_CODE, Pacs00800110ErrorConstant.C31_ERROR_TEXT);
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
     * @return 返回C33检查结果
     */
    public Constraints checkC33() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt2Acct = creditTransferTransaction50.getPrvsInstgAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction50.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2Acct) && JudgeUtils.isNull(prvsInstgAgt2)) {
                        return new Constraints(Pacs00800110ErrorConstant.C33_ERROR_SEVERITY, Pacs00800110ErrorConstant.C33_ERROR_CODE, Pacs00800110ErrorConstant.C33_ERROR_TEXT);
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
     * @return 返回C34检查结果
     */
    public Constraints checkC34() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction50.getPrvsInstgAgt1();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction50.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotNull(prvsInstgAgt2) && JudgeUtils.isNull(prvsInstgAgt1)) {
                        return new Constraints(Pacs00800110ErrorConstant.C34_ERROR_SEVERITY, Pacs00800110ErrorConstant.C34_ERROR_CODE, Pacs00800110ErrorConstant.C34_ERROR_TEXT);
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
     * @return 返回C35检查结果
     */
    public Constraints checkC35() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    CashAccount40 prvsInstgAgt3Acct = creditTransferTransaction50.getPrvsInstgAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction50.getPrvsInstgAgt3();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3Acct) && JudgeUtils.isNull(prvsInstgAgt3)) {
                        return new Constraints(Pacs00800110ErrorConstant.C35_ERROR_SEVERITY, Pacs00800110ErrorConstant.C35_ERROR_CODE, Pacs00800110ErrorConstant.C35_ERROR_TEXT);
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
     * @return 返回C36检查结果
     */
    public Constraints checkC36() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction50.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction50.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotNull(prvsInstgAgt3) && JudgeUtils.isNull(prvsInstgAgt2)) {
                        return new Constraints(Pacs00800110ErrorConstant.C36_ERROR_SEVERITY, Pacs00800110ErrorConstant.C36_ERROR_CODE, Pacs00800110ErrorConstant.C36_ERROR_TEXT);
                    }
                }
            }
        }

        return null;
    }

    /**
     * If SettlementMethod is equal to INDA or INGA, then ReimbursementAgent(s) and
     * ClearingSystem are not allowed. (CrossElementComplexRule)
     * On Condition
     * /SettlementMethod is equal to value 'InstructingAgent'
     * Or /SettlementMethod is equal to value 'InstructedAgent'
     * Following Must be True
     * /ClearingSystem Must be absent
     * And /InstructingReimbursementAgent Must be absent
     * And /InstructedReimbursementAgent Must be absent
     * And /ThirdReimbursementAgent Must be absent
     * SettlementMethod <SttlmMtd> [1..1] CodeSet GrpHdr
     * InstructingReimbursementAgentAccount <InstgRmbrsmntAgtAcct> [0..1] ✓C15,C14
     * ClearingSystem <ClrSys> [0..1]
     * InstructingReimbursementAgent <InstgRmbrsmntAgt> [0..1] ± SttlmInf GrpHdr
     * InstructedReimbursementAgent <InstdRmbrsmntAgt> [0..1] ± SttlmInf GrpHdr
     * ThirdReimbursementAgent <ThrdRmbrsmntAgt> [0..1] ± SttlmInf GrpHdr
     *
     * @return 返回C37检查结果
     */
    public Constraints checkC37() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if (JudgeUtils.isNotNull(value)) {
                            if ("INDA".equals(value) || "INGA".equals(value)) {
                                if (JudgeUtils.isNotNull(clrSys) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00800110ErrorConstant.C37_ERROR_SEVERITY, Pacs00800110ErrorConstant.C37_ERROR_CODE, Pacs00800110ErrorConstant.C37_ERROR_TEXT);
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
     * @return 返回C38检查结果
     */
    public Constraints checkC38() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
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
                            if (JudgeUtils.isNotNull(value)) {
                                if ("CLRG".equals(value)) {
                                    if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                        return new Constraints(Pacs00800110ErrorConstant.C38_ERROR_SEVERITY, Pacs00800110ErrorConstant.C38_ERROR_CODE, Pacs00800110ErrorConstant.C38_ERROR_TEXT);
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
     * @return 返回C39检查结果
     */
    public Constraints checkC39() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("COVE".equals(value)) {
                            if (JudgeUtils.isNull(instdRmbrsmntAgt) && JudgeUtils.isNull(instgRmbrsmntAgt)) {
                                return new Constraints(Pacs00800110ErrorConstant.C39_ERROR_SEVERITY, Pacs00800110ErrorConstant.C39_ERROR_CODE, Pacs00800110ErrorConstant.C39_ERROR_TEXT);
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
     * @return 返回C40检查结果
     */
    public Constraints checkC40() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    SettlementMethod1Code sttlmMtd = sttlmInf.getSttlmMtd();
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    ClearingSystemIdentification3Choice clrSys = sttlmInf.getClrSys();
                    if (JudgeUtils.isNotNull(sttlmMtd)) {
                        String value = sttlmMtd.value();
                        if ("COVE".equals(value)) {
                            if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(clrSys)) {
                                return new Constraints(Pacs00800110ErrorConstant.C40_ERROR_SEVERITY, Pacs00800110ErrorConstant.C40_ERROR_CODE, Pacs00800110ErrorConstant.C40_ERROR_TEXT);
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
     * ThirdReimbursementAgentAccount <ThrdRmbrsmntAgtAcct> [0..1] ✓C15,C14 GrpHdr
     * ThirdReimbursementAgent <ThrdRmbrsmntAgt> [0..1] ± GrpHdr
     *
     * @return 返回C43检查结果
     */
    public Constraints checkC43() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getGrpHdr())) {
                GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct) && JudgeUtils.isNull(thrdRmbrsmntAgt)) {
                            return new Constraints(Pacs00800110ErrorConstant.C43_ERROR_SEVERITY, Pacs00800110ErrorConstant.C43_ERROR_CODE, Pacs00800110ErrorConstant.C43_ERROR_TEXT);
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
     * InstructingReimbursementAgent <InstgRmbrsmntAgt> [0..1] ± GrpHdr
     * InstructedReimbursementAgent <InstdRmbrsmntAgt> [0..1] ± GrpHdr
     *
     * @return 返回C44检查结果
     */
    public Constraints checkC44() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification6 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getThrdRmbrsmntAgt);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification61 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstgRmbrsmntAgt);
            Optional<BranchAndFinancialInstitutionIdentification6> branchAndFinancialInstitutionIdentification62 = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getSttlmInf)
                    .map(SettlementInstruction11::getInstdRmbrsmntAgt);
            if (branchAndFinancialInstitutionIdentification6.isPresent()) {
                if (!branchAndFinancialInstitutionIdentification61.isPresent() || !branchAndFinancialInstitutionIdentification62.isPresent()) {
                    return new Constraints(Pacs00800110ErrorConstant.C44_ERROR_SEVERITY, Pacs00800110ErrorConstant.C44_ERROR_CODE, Pacs00800110ErrorConstant.C44_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * If TotalInterbankSettlementAmount is present, then InterbankSettlementDate must be
     * present. (CrossElementComplexRule)
     * TotalInterbankSettlementAmount <TtlIntrBkSttlmAmt> [0..1] Amount ✓C1,✓C10 GrpHdr
     * InterbankSettlementDate <IntrBkSttlmDt> [0..1] Date GrpHdr
     *
     * @return 返回C45检查结果
     */
    public Constraints checkC45() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<ActiveCurrencyAndAmount> activeCurrencyAndAmount = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getTtlIntrBkSttlmAmt);
            Optional<XMLGregorianCalendar> xmlGregorianCalendar = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getIntrBkSttlmDt);
            if (activeCurrencyAndAmount.isPresent() && !xmlGregorianCalendar.isPresent()) {
                return new Constraints(Pacs00800110ErrorConstant.C45_ERROR_SEVERITY, Pacs00800110ErrorConstant.C45_ERROR_CODE, Pacs00800110ErrorConstant.C45_ERROR_TEXT);
            }
        }

        return null;
    }

    /**
     * If GroupHeader/TotalInterbankSettlementAmount is present, then it must equal the sum of all
     * occurrences of CreditTransferTransactionInformation/
     * InterbankSettlementAmount. (CrossElementComplexRule)
     * TotalInterbankSettlementAmount <TtlIntrBkSttlmAmt> [0..1] Amount ✓C1,✓C10
     * InterbankSettlementAmount <IntrBkSttlmAmt> [1..1] Amount ✓C1,✓C10
     *
     * @return 返回C46检查结果
     */
    public Constraints checkC46() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<BigDecimal> bigDecimal = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getTtlIntrBkSttlmAmt)
                    .map(ActiveCurrencyAndAmount::getValue);
            BigDecimal intrBkSttlmAmt = new BigDecimal(0);
//        BigDecimal intrBkSttlmAmt = BigDecimal.ZERO;
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt1 = creditTransferTransaction50.getIntrBkSttlmAmt();
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
                    return new Constraints(Pacs00800110ErrorConstant.C46_ERROR_SEVERITY, Pacs00800110ErrorConstant.C46_ERROR_CODE, Pacs00800110ErrorConstant.C46_ERROR_TEXT);
                }
            }
        }

        return null;
    }

    /**
     * If GroupHeader/TotalInterbankSettlementAmount is present, then all occurrences of
     * CreditTransferTransactionInformation/InterbankSettlementAmount must have the same
     * currency as the currency of GroupHeader/TotalInterbankSettlementAmount. (CrossElementComplexRule)
     * On Condition
     * /GroupHeader/TotalInterbankSettlementAmount is present
     * Following Must be True
     * /CreditTransferTransactionInformation[*]/InterbankSettlementAmount/
     * attribute::Currency Must be equal to /GroupHeader/
     * TotalInterbankSettlementAmount/attribute::Currency
     * TotalInterbankSettlementAmount <TtlIntrBkSttlmAmt> [0..1] Amount ✓C1,✓C10
     *
     * @return 返回C47检查结果
     */
    public Constraints checkC47() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<String> aCcy = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getTtlIntrBkSttlmAmt)
                    .map(ActiveCurrencyAndAmount::getCcy);
            if (aCcy.isPresent()) {
                String ttlIntrBkSttlmAmtCcy = fiToFICstmrCdtTrf.getGrpHdr().getTtlIntrBkSttlmAmt().getCcy();
                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                    List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ActiveCurrencyAndAmount intrBkSttlmAmt1 = creditTransferTransaction50.getIntrBkSttlmAmt();
                        if (JudgeUtils.isNotNull(intrBkSttlmAmt1)) {
                            String ccy = intrBkSttlmAmt1.getCcy();
                            if (!ccy.equals(ttlIntrBkSttlmAmtCcy)) {
                                return new Constraints(Pacs00800110ErrorConstant.C47_ERROR_SEVERITY, Pacs00800110ErrorConstant.C47_ERROR_CODE, Pacs00800110ErrorConstant.C47_ERROR_TEXT, ccy);
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
     * TransactionIdentification <TxId> [0..1] Text PmtId CdtTrfTxInf
     * UETR <UETR> [0..1] IdentifierSet PmtId CdtTrfTxInf
     *
     * @return 返回C48检查结果
     */
    public Constraints checkC48() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    PaymentIdentification13 pmtId = creditTransferTransaction50.getPmtId();
                    if (JudgeUtils.isNotNull(pmtId)) {
                        String txId = pmtId.getTxId();
                        String uetr = pmtId.getUETR();
                        if (JudgeUtils.isNull(txId) && JudgeUtils.isNull(uetr)) {
                            return new Constraints(Pacs00800110ErrorConstant.C48_ERROR_SEVERITY, Pacs00800110ErrorConstant.C48_ERROR_CODE, Pacs00800110ErrorConstant.C48_ERROR_TEXT);
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
     * GroupHeader/InterbankSettlementDate <IntrBkSttlmDt> [0..1] Date GrpHdr
     *
     * @return 返回C49检查结果
     */
    public Constraints checkC49() {
        if (JudgeUtils.isNotNull(this.getFIToFICstmrCdtTrf())) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = this.getFIToFICstmrCdtTrf();
            Optional<FIToFICustomerCreditTransferV10> fiToFICustomerCreditTransferV10 = Optional.of(fiToFICstmrCdtTrf);
            Optional<XMLGregorianCalendar> xmlGregorianCalendar = fiToFICustomerCreditTransferV10.map(FIToFICustomerCreditTransferV10::getGrpHdr)
                    .map(GroupHeader96::getIntrBkSttlmDt);
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf.getCdtTrfTxInf())) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                    XMLGregorianCalendar intrBkSttlmDt = creditTransferTransaction50.getIntrBkSttlmDt();
                    if (!xmlGregorianCalendar.isPresent()) {
                        if (JudgeUtils.isNull(intrBkSttlmDt)) {
                            return new Constraints(Pacs00800110ErrorConstant.C49_ERROR_SEVERITY, Pacs00800110ErrorConstant.C49_ERROR_CODE, Pacs00800110ErrorConstant.C49_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return null;
    }


}
