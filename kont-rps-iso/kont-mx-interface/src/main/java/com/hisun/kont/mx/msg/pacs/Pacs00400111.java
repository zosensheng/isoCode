package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.enums.ActiveCurrencyEnum;
import com.hisun.kont.mx.enums.ActiveOrHistoricCurrencyEnum;
import com.hisun.kont.mx.enums.CountryEnum;
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
 *         &lt;element name="PmtRtr" type="{}PaymentReturnV11"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document002", propOrder = {
    "pmtRtr"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.004.001.11")
public class Pacs00400111 {

    @XmlElement(name = "PmtRtr", required = true)
    protected PaymentReturnV11 pmtRtr;

    /**
     * ��ȡpmtRtr���Ե�ֵ��
     *
     * @return possible object is
     * {@link PaymentReturnV11 }
     */
    public PaymentReturnV11 getPmtRtr() {
        return pmtRtr;
    }

    /**
     * ����pmtRtr���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link PaymentReturnV11 }
     */
    public void setPmtRtr(PaymentReturnV11 value) {
        this.pmtRtr = value;
    }

    //暂不实现
    public String message() {
        return null;
    }


    private static Constraints ruleC1(String str) {
        //正则表达式判断三个连续的字母
        boolean c1 = str.matches("^[a-zA-Z]{3}$");
        if (!c1) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C1_ERROR_CODE, Pacs00400110ErrorConstant.C1_ERROR_TEXT, str);
        }
        ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
        ArrayList<String> ccyLists = new ArrayList<>();
        for (ActiveCurrencyEnum ccyValue : ccyValues) {
            ccyLists.add(ccyValue.getCurrencyCode());
        }
        if (!ccyLists.contains(str)) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C1_ERROR_CODE, Pacs00400110ErrorConstant.C1_ERROR_TEXT, str);
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }

    public Constraints checkC1() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlRtrdIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt)) {
                    String ccy = ttlIntrBkSttlmAmt.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                            return ruleC1(ccy);
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInfo = paymentReturnV11.getTxInf();
            if (JudgeUtils.isNotNull(txInfo)) {
                for (PaymentTransaction133 paymentTransaction133 : txInfo) {
                    ActiveCurrencyAndAmount intrBkSttlmAmt = paymentTransaction133.getRtrdIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        List<Charges7> chrgsInf = paymentTransaction133.getChrgsInf();
                        for (Charges7 charges7 : chrgsInf) {
                            ActiveOrHistoricCurrencyAndAmount amt = charges7.getAmt();
                            if (JudgeUtils.isNotNull(amt)) {
                                String ccy = amt.getCcy();
                                if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                    return ruleC1(ccy);
                                }
                            }
                        }
                        OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
                        if (JudgeUtils.isNotNull(orgnlTxRef)) {
                            AmountType4Choice amt = orgnlTxRef.getAmt();
                            if (JudgeUtils.isNotNull(amt)) {
                                ActiveOrHistoricCurrencyAndAmount instdAmt = amt.getInstdAmt();
                                String ccy = instdAmt.getCcy();
                                if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                    return ruleC1(ccy);
                                }
                                EquivalentAmount2 eqvtAmt = amt.getEqvtAmt();
                                ActiveOrHistoricCurrencyAndAmount amtOr = eqvtAmt.getAmt();
                                if (JudgeUtils.isNotNull(amtOr)) {
                                    String ccyOr = amtOr.getCcy();
                                    if (JudgeUtils.isNotSuccess(ruleC1(ccyOr).getErrorCode())) {
                                        return ruleC1(ccyOr);
                                    }
                                }
                                String ccyOfTrf = eqvtAmt.getCcyOfTrf();
                                if (JudgeUtils.isNotSuccess(ruleC1(ccyOfTrf).getErrorCode())) {
                                    return ruleC1(ccyOfTrf);
                                }

                            }
                            RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                            List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                            for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                RemittanceAmount2 rfrdDocAmt = structuredRemittanceInformation17.getRfrdDocAmt();
                                if (JudgeUtils.isNotNull(rfrdDocAmt)) {
                                    ActiveOrHistoricCurrencyAndAmount duePyblAmt = rfrdDocAmt.getDuePyblAmt();
                                    if (JudgeUtils.isNotNull(duePyblAmt)) {
                                        String ccy = duePyblAmt.getCcy();
                                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                            return ruleC1(ccy);
                                        }
                                    }
                                    ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = rfrdDocAmt.getCdtNoteAmt();
                                    if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                        String ccyCdt = cdtNoteAmt.getCcy();
                                        if (JudgeUtils.isNotSuccess(ruleC1(ccyCdt).getErrorCode())) {
                                            return ruleC1(ccyCdt);
                                        }
                                    }
                                    List<DiscountAmountAndType1> dscntApldAmt = rfrdDocAmt.getDscntApldAmt();
                                    for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                        ActiveOrHistoricCurrencyAndAmount amtAct = discountAmountAndType1.getAmt();
                                        if (JudgeUtils.isNotNull(amtAct)) {
                                            String ccyAct = amtAct.getCcy();
                                            if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                return ruleC1(ccyAct);
                                            }
                                        }
                                    }
                                    List<TaxAmountAndType1> taxAmt = rfrdDocAmt.getTaxAmt();
                                    for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                        ActiveOrHistoricCurrencyAndAmount amtAct = taxAmountAndType1.getAmt();
                                        if (JudgeUtils.isNotNull(amtAct)) {
                                            String ccyAct = amtAct.getCcy();
                                            if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                return ruleC1(ccyAct);
                                            }
                                        }
                                    }
                                    List<DocumentAdjustment1> adjstmntAmtAndRsn = rfrdDocAmt.getAdjstmntAmtAndRsn();
                                    for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                        ActiveOrHistoricCurrencyAndAmount amtAct = documentAdjustment1.getAmt();
                                        if (JudgeUtils.isNotNull(amtAct)) {
                                            String ccyAct = amtAct.getCcy();
                                            if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                return ruleC1(ccyAct);
                                            }
                                        }
                                    }
                                    ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                    if (JudgeUtils.isNotNull(rmtdAmt)) {
                                        String ccyAct = rmtdAmt.getCcy();
                                        if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                            return ruleC1(ccyAct);
                                        }
                                    }
                                }
                            }
                            CreditTransferTransaction52 undrlygCstmrCdtTrf = orgnlTxRef.getUndrlygCstmrCdtTrf();
                            if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                                RemittanceInformation21 rmtInfRem = undrlygCstmrCdtTrf.getRmtInf();
                                if (JudgeUtils.isNotNull(rmtInfRem)) {
                                    List<StructuredRemittanceInformation17> strdRem = rmtInfRem.getStrd();
                                    for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strdRem) {
                                        RemittanceAmount2 rfrdDocAmt = structuredRemittanceInformation17.getRfrdDocAmt();
                                        if (JudgeUtils.isNotNull(rfrdDocAmt)) {
                                            ActiveOrHistoricCurrencyAndAmount duePyblAmt = rfrdDocAmt.getDuePyblAmt();
                                            if (JudgeUtils.isNotNull(duePyblAmt)) {
                                                String ccy = duePyblAmt.getCcy();
                                                if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                                    return ruleC1(ccy);
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = rfrdDocAmt.getCdtNoteAmt();
                                            if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                String ccyCdt = cdtNoteAmt.getCcy();
                                                if (JudgeUtils.isNotSuccess(ruleC1(ccyCdt).getErrorCode())) {
                                                    return ruleC1(ccyCdt);
                                                }
                                            }
                                            List<DiscountAmountAndType1> dscntApldAmt = rfrdDocAmt.getDscntApldAmt();
                                            for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                ActiveOrHistoricCurrencyAndAmount amtAct = discountAmountAndType1.getAmt();
                                                if (JudgeUtils.isNotNull(amtAct)) {
                                                    String ccyAct = amtAct.getCcy();
                                                    if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                        return ruleC1(ccyAct);
                                                    }
                                                }
                                            }
                                            List<TaxAmountAndType1> taxAmt = rfrdDocAmt.getTaxAmt();
                                            for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                ActiveOrHistoricCurrencyAndAmount amtAct = taxAmountAndType1.getAmt();
                                                if (JudgeUtils.isNotNull(amtAct)) {
                                                    String ccyAct = amtAct.getCcy();
                                                    if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                        return ruleC1(ccyAct);
                                                    }
                                                }
                                            }
                                            List<DocumentAdjustment1> adjstmntAmtAndRsn = rfrdDocAmt.getAdjstmntAmtAndRsn();
                                            for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                ActiveOrHistoricCurrencyAndAmount amtAct = documentAdjustment1.getAmt();
                                                if (JudgeUtils.isNotNull(amtAct)) {
                                                    String ccyAct = amtAct.getCcy();
                                                    if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                        return ruleC1(ccyAct);
                                                    }
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                            if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                String ccyAct = rmtdAmt.getCcy();
                                                if (JudgeUtils.isNotSuccess(ruleC1(ccyAct).getErrorCode())) {
                                                    return ruleC1(ccyAct);
                                                }
                                            }
                                        }
                                        Garnishment3 grnshmtRmt = structuredRemittanceInformation17.getGrnshmtRmt();
                                        if (JudgeUtils.isNotNull(grnshmtRmt)) {
                                            ActiveOrHistoricCurrencyAndAmount rmtdAmt = grnshmtRmt.getRmtdAmt();
                                            if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                String ccy = rmtdAmt.getCcy();
                                                if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                                    return ruleC1(ccy);
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


    private static Constraints ruleC2(String str) {
        //通过正则表达式判断
        boolean c2 = str.matches("^[a-zA-Z]{3}$");
        if (!c2) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C2_ERROR_CODE, Pacs00400110ErrorConstant.C2_ERROR_TEXT, str);
        }
        ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
        ArrayList<String> ccyLists = new ArrayList<>();
        for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
            ccyLists.add(ccyValue.getCurrencyCode());
        }
        if (!ccyLists.contains(str)) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C2_ERROR_CODE, Pacs00400110ErrorConstant.C2_ERROR_TEXT, str);
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }

    private static Constraints ruleC2(ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount) {
        if (JudgeUtils.isNotNull(activeOrHistoricCurrencyAndAmount)) {
            String ccy = activeOrHistoricCurrencyAndAmount.getCcy();
            //通过正则表达式判断
            boolean c2 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c2) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C2_ERROR_CODE, Pacs00400110ErrorConstant.C2_ERROR_TEXT, ccy);
            }
            ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
            ArrayList<String> ccyLists = new ArrayList<>();
            for (ActiveCurrencyEnum ccyValue : ccyValues) {
                ccyLists.add(ccyValue.getCurrencyCode());
            }
            if (!ccyLists.contains(ccy)) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C2_ERROR_CODE, Pacs00400110ErrorConstant.C2_ERROR_TEXT, ccy);
            }
        }

        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }


    public Constraints checkC2() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
        if (JudgeUtils.isNotNull(grpHdr)) {
            SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
            if (JudgeUtils.isNotNull(sttlmInf)) {
                CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                if (JudgeUtils.isNotNull(sttlmAcct)) {
                    String ccy = sttlmAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                            return ruleC2(ccy);
                        }
                    }
                }
                CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                    String ccy = instgRmbrsmntAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                            return ruleC2(ccy);
                        }
                    }
                }
                CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                    String ccy = instdRmbrsmntAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                            return ruleC2(ccy);
                        }
                    }
                }
                CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                    String ccy = thrdRmbrsmntAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccy)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                            return ruleC2(ccy);
                        }
                    }
                }

            }
        }
        List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
        for (PaymentTransaction133 paymentTransaction133 : txInf) {
            ActiveOrHistoricCurrencyAndAmount orgnlIntrBkSttlmAmt = paymentTransaction133.getOrgnlIntrBkSttlmAmt();
            if (JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)) {
            String ccy = orgnlIntrBkSttlmAmt.getCcy();
                if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                    return ruleC2(ccy);
                }
            }
            ActiveOrHistoricCurrencyAndAmount rtrdInstdAmt = paymentTransaction133.getRtrdInstdAmt();
            if (JudgeUtils.isNotNull(rtrdInstdAmt)) {
                String ccyRtr = rtrdInstdAmt.getCcy();
                if (JudgeUtils.isNotSuccess(ruleC2(ccyRtr).getErrorCode())) {
                    return ruleC2(ccyRtr);
                }
            }
            ActiveOrHistoricCurrencyAndAmount compstnAmt = paymentTransaction133.getCompstnAmt();
            if (JudgeUtils.isNotNull(compstnAmt)) {
                String ccyCom = compstnAmt.getCcy();
                if (JudgeUtils.isNotSuccess(ruleC2(ccyCom).getErrorCode())) {
                    return ruleC2(ccyCom);
                }
            }
            TransactionParties10 rtrChain = paymentTransaction133.getRtrChain();
            if (JudgeUtils.isNotNull(rtrChain)) {
                CashAccount40 dbtrAcct = rtrChain.getDbtrAcct();
                if (JudgeUtils.isNotNull(dbtrAcct)) {
                    String ccyDbt = dbtrAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyDbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                            return ruleC2(ccyDbt);
                        }
                    }
                }
                CashAccount40 dbtrAgtAcct = rtrChain.getDbtrAgtAcct();
                if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                    String ccyDbt = dbtrAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyDbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                            return ruleC2(ccyDbt);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt1Acct = rtrChain.getPrvsInstgAgt1Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                    String ccyPrv = prvsInstgAgt1Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt2Acct = rtrChain.getPrvsInstgAgt2Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                    String ccyPrv = prvsInstgAgt2Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt3Acct = rtrChain.getPrvsInstgAgt3Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                    String ccyPrv = prvsInstgAgt3Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 intrmyAgt1Acct = rtrChain.getIntrmyAgt1Acct();
                if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                    String ccyInt = intrmyAgt1Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 intrmyAgt2Acct = rtrChain.getIntrmyAgt2Acct();
                if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                    String ccyInt = intrmyAgt2Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 intrmyAgt3Acct = rtrChain.getIntrmyAgt3Acct();
                if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                    String ccyInt = intrmyAgt3Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 cdtrAgtAcct = rtrChain.getCdtrAgtAcct();
                if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                    String ccyCdt = cdtrAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyCdt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                            return ruleC2(ccyCdt);
                        }
                    }
                }
                CashAccount40 cdtrAcct = rtrChain.getCdtrAcct();
                if (JudgeUtils.isNotNull(cdtrAcct)) {
                    String ccydbt = cdtrAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccydbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccydbt).getErrorCode())) {
                            return ruleC2(ccydbt);
                        }
                    }
                }
            }
            OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
            if (JudgeUtils.isNotNull(orgnlTxRef)) {
                ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt = orgnlTxRef.getIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                    String ccyInt = intrBkSttlmAmt.getCcy();
                    if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                        return ruleC2(ccyInt);
                    }
                }
                SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    if (JudgeUtils.isNotNull(sttlmAcct)) {
                        String ccyStt = sttlmAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyStt)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyStt).getErrorCode())) {
                                return ruleC2(ccyStt);
                            }
                        }
                    }
                    CashAccount40 instgRmbrsmntAgtAcct = sttlmInf.getInstgRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                        String ccyIns = instgRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyIns)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyIns).getErrorCode())) {
                                return ruleC2(ccyIns);
                            }
                        }
                    }
                    CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                        String ccyIns = instdRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyIns)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyIns).getErrorCode())) {
                                return ruleC2(ccyIns);
                            }
                        }
                    }
                    CashAccount40 thrdRmbrsmntAgtAcct = sttlmInf.getThrdRmbrsmntAgtAcct();
                    if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                        String ccyThr = thrdRmbrsmntAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyThr)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyThr).getErrorCode())) {
                                return ruleC2(ccyThr);
                            }
                        }
                    }
                }
                MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                CashAccount40 orgnlCdtrAgtAcct = amdmntInfDtls.getOrgnlCdtrAgtAcct();
                if (JudgeUtils.isNotNull(orgnlCdtrAgtAcct)) {
                    String ccyOrg = orgnlCdtrAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyOrg)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyOrg).getErrorCode())) {
                            return ruleC2(ccyOrg);
                        }
                    }
                }
                CashAccount40 orgnlDbtrAcct = amdmntInfDtls.getOrgnlDbtrAcct();
                if (JudgeUtils.isNotNull(orgnlDbtrAcct)) {
                    String ccyOrg = orgnlDbtrAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyOrg)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyOrg).getErrorCode())) {
                            return ruleC2(ccyOrg);
                        }
                    }
                }
                CashAccount40 orgnlDbtrAgtAcct = amdmntInfDtls.getOrgnlDbtrAgtAcct();
                if (JudgeUtils.isNotNull(orgnlDbtrAgtAcct)) {
                    String ccyOrg = orgnlDbtrAgtAcct.getCcy();
                    if (JudgeUtils.isNotNull(ccyOrg)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyOrg).getErrorCode())) {
                            return ruleC2(ccyOrg);
                        }
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
                                                    String ccyDue = duePyblAmt.getCcy();
                                                    if (JudgeUtils.isNotNull(ccyDue)) {
                                                        if (JudgeUtils.isNotSuccess(ruleC2(ccyDue).getErrorCode())) {
                                                            return ruleC2(ccyDue);
                                                        }
                                                    }
                                                }
                                                ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                    String ccyCdt = cdtNoteAmt.getCcy();
                                                    if (JudgeUtils.isNotNull(ccyCdt)) {
                                                        if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                                                            return ruleC2(ccyCdt);
                                                        }
                                                    }
                                                }
                                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                    String ccyRmt = rmtdAmt.getCcy();
                                                    if (JudgeUtils.isNotNull(ccyRmt)) {
                                                        if (JudgeUtils.isNotSuccess(ruleC2(ccyRmt).getErrorCode())) {
                                                            return ruleC2(ccyRmt);
                                                        }
                                                    }
                                                }
                                                List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                    for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            if (JudgeUtils.isNotNull(ccyAmt)) {
                                                                if (JudgeUtils.isNotSuccess(ruleC2(ccyAmt).getErrorCode())) {
                                                                    return ruleC2(ccyAmt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            if (JudgeUtils.isNotNull(ccyAmt)) {
                                                                if (JudgeUtils.isNotSuccess(ruleC2(ccyAmt).getErrorCode())) {
                                                                    return ruleC2(ccyAmt);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                    for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            if (JudgeUtils.isNotNull(ccyAmt)) {
                                                                if (JudgeUtils.isNotSuccess(ruleC2(ccyAmt).getErrorCode())) {
                                                                    return ruleC2(ccyAmt);
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
                            TaxData1 taxRmt = structuredRemittanceInformation17.getTaxRmt();
                            if (JudgeUtils.isNotNull(taxRmt)) {
                                ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                    String ccyttl = ttlTaxblBaseAmt.getCcy();
                                    if (JudgeUtils.isNotNull(ccyttl)) {
                                        if (JudgeUtils.isNotSuccess(ruleC2(ccyttl).getErrorCode())) {
                                            return ruleC2(ccyttl);
                                        }
                                    }
                                }
                                ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                    String ccyTtl = ttlTaxAmt.getCcy();
                                    if (JudgeUtils.isNotNull(ccyTtl)) {
                                        if (JudgeUtils.isNotSuccess(ruleC2(ccyTtl).getErrorCode())) {
                                            return ruleC2(ccyTtl);
                                        }
                                    }
                                }
                                List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                if (JudgeUtils.isNotNull(rcrd)) {
                                    for (TaxRecord3 taxRecord3 : rcrd) {
                                        TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                            ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                            if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                String ccyTax = taxblBaseAmt.getCcy();
                                                if (JudgeUtils.isNotNull(ccyTax)) {
                                                    if (JudgeUtils.isNotSuccess(ruleC2(ccyTax).getErrorCode())) {
                                                        return ruleC2(ccyTax);
                                                    }
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                            if (JudgeUtils.isNotNull(ttlAmt)) {
                                                String ccyTtl = ttlAmt.getCcy();
                                                if (JudgeUtils.isNotNull(ccyTtl)) {
                                                    if (JudgeUtils.isNotSuccess(ruleC2(ccyTtl).getErrorCode())) {
                                                        return ruleC2(ccyTtl);
                                                    }
                                                }
                                            }
                                            List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                            if (JudgeUtils.isNotNull(dtls)) {
                                                for (TaxRecordDetails3 dtl : dtls) {
                                                    ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        String ccyAmt = amt.getCcy();
                                                        if (JudgeUtils.isNotNull(ccyAmt)) {
                                                            if (JudgeUtils.isNotSuccess(ruleC2(ccyAmt).getErrorCode())) {
                                                                return ruleC2(ccyAmt);
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
            CashAccount40 dbtrAcct = orgnlTxRef.getDbtrAcct();
            if (JudgeUtils.isNotNull(dbtrAcct)) {
                String ccyDbt = dbtrAcct.getCcy();
                if (JudgeUtils.isNotNull(ccyDbt)) {
                    if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                        return ruleC2(ccyDbt);
                    }
                }
            }
            CashAccount40 dbtrAgtAcct = orgnlTxRef.getDbtrAgtAcct();
            if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                String ccyDbt = dbtrAgtAcct.getCcy();
                if (JudgeUtils.isNotNull(ccyDbt)) {
                    if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                        return ruleC2(ccyDbt);
                    }
                }
            }
            CashAccount40 cdtrAgtAcct = orgnlTxRef.getCdtrAgtAcct();
            if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                String ccyCdt = cdtrAgtAcct.getCcy();
                if (JudgeUtils.isNotNull(ccyCdt)) {
                    if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                        return ruleC2(ccyCdt);
                    }
                }
            }
            CashAccount40 cdtrAcct = orgnlTxRef.getCdtrAcct();
            if (JudgeUtils.isNotNull(cdtrAcct)) {
                String ccyCdt = cdtrAcct.getCcy();
                if (JudgeUtils.isNotNull(ccyCdt)) {
                    if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                        return ruleC2(ccyCdt);
                    }
                }
            }
            CreditTransferTransaction52 undrlygCstmrCdtTrf = orgnlTxRef.getUndrlygCstmrCdtTrf();
            if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                CashAccount40 dbtrAcct1 = undrlygCstmrCdtTrf.getDbtrAcct();
                if (JudgeUtils.isNotNull(dbtrAcct1)) {
                    String ccyDbt = dbtrAcct1.getCcy();
                    if (JudgeUtils.isNotNull(ccyDbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                            return ruleC2(ccyDbt);
                        }
                    }
                }
                CashAccount40 dbtrAgtAcct1 = undrlygCstmrCdtTrf.getDbtrAgtAcct();
                if (JudgeUtils.isNotNull(dbtrAgtAcct1)) {
                    String ccyDbt = dbtrAgtAcct1.getCcy();
                    if (JudgeUtils.isNotNull(ccyDbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                            return ruleC2(ccyDbt);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt1Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                    String ccyPrv = prvsInstgAgt1Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt2Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                    String ccyPrv = prvsInstgAgt2Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 prvsInstgAgt3Acct = undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                    String ccyPrv = prvsInstgAgt3Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyPrv)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyPrv).getErrorCode())) {
                            return ruleC2(ccyPrv);
                        }
                    }
                }
                CashAccount40 intrmyAgt1Acct = undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                    String ccyInt = intrmyAgt1Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 intrmyAgt2Acct = undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                    String ccyInt = intrmyAgt2Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 intrmyAgt3Acct = undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                    String ccyInt = intrmyAgt3Acct.getCcy();
                    if (JudgeUtils.isNotNull(ccyInt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                }
                CashAccount40 cdtrAgtAcct1 = undrlygCstmrCdtTrf.getCdtrAgtAcct();
                if (JudgeUtils.isNotNull(cdtrAgtAcct1)) {
                    String ccyCdt = cdtrAgtAcct1.getCcy();
                    if (JudgeUtils.isNotNull(ccyCdt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                            return ruleC2(ccyCdt);
                        }
                    }
                }
                CashAccount40 cdtrAcct1 = undrlygCstmrCdtTrf.getCdtrAcct();
                if (JudgeUtils.isNotNull(cdtrAcct1)) {
                    String ccydbt = cdtrAcct1.getCcy();
                    if (JudgeUtils.isNotNull(ccydbt)) {
                        if (JudgeUtils.isNotSuccess(ruleC2(ccydbt).getErrorCode())) {
                            return ruleC2(ccydbt);
                        }
                    }
                }
                TaxInformation10 tax = undrlygCstmrCdtTrf.getTax();
                if (JudgeUtils.isNotNull(tax)) {
                    ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                    if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                        String ccyTtl = ttlTaxblBaseAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccyTtl)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyTtl).getErrorCode())) {
                                return ruleC2(ccyTtl);
                            }
                        }
                    }
                    ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                    if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                        String ccyTtl = ttlTaxAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccyTtl)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyTtl).getErrorCode())) {
                                return ruleC2(ccyTtl);
                            }
                        }
                    }
                    List<TaxRecord3> rcrd = tax.getRcrd();
                    for (TaxRecord3 taxRecord3 : rcrd) {
                        TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                        ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                        if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                            String ccyTax = taxblBaseAmt.getCcy();
                            if (JudgeUtils.isNotNull(ccyTax)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyTax).getErrorCode())) {
                                    return ruleC2(ccyTax);
                                }
                            }
                        }
                        ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                        if (JudgeUtils.isNotNull(ttlAmt)) {
                            String ccyTtl = ttlAmt.getCcy();
                            if (JudgeUtils.isNotNull(ccyTtl)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyTtl).getErrorCode())) {
                                    return ruleC2(ccyTtl);
                                }
                            }
                        }
                        List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                        for (TaxRecordDetails3 taxRecordDetails3 : dtls) {
                            ActiveOrHistoricCurrencyAndAmount amt = taxRecordDetails3.getAmt();
                            if (JudgeUtils.isNotNull(amt)) {
                                String ccyAmt = amt.getCcy();
                                if (JudgeUtils.isNotNull(ccyAmt)) {
                                    if (JudgeUtils.isNotSuccess(ruleC2(ccyAmt).getErrorCode())) {
                                        return ruleC2(ccyAmt);
                                    }
                                }
                            }
                        }
                    }

                }
                RemittanceInformation21 rmtInf21 = undrlygCstmrCdtTrf.getRmtInf();
                if (JudgeUtils.isNotNull(rmtInf21)) {
                    List<StructuredRemittanceInformation17> strd = rmtInf21.getStrd();
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
                                                if (JudgeUtils.isNotSuccess(ruleC2(duePyblAmt).getErrorCode())) {
                                                    return ruleC2(duePyblAmt);
                                                }
                                                ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                if (JudgeUtils.isNotSuccess(ruleC2(cdtNoteAmt).getErrorCode())) {
                                                    return ruleC2(cdtNoteAmt);
                                                }
                                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                if (JudgeUtils.isNotSuccess(ruleC2(rmtdAmt).getErrorCode())) {
                                                    return ruleC2(rmtdAmt);
                                                }
                                                List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                    for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotSuccess(ruleC2(amt1).getErrorCode())) {
                                                            return ruleC2(amt1);
                                                        }
                                                    }
                                                }
                                                List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotSuccess(ruleC2(amt1).getErrorCode())) {
                                                            return ruleC2(amt1);
                                                        }
                                                    }
                                                }
                                                List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                    for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                        if (JudgeUtils.isNotSuccess(ruleC2(amt1).getErrorCode())) {
                                                            return ruleC2(amt1);
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
                                if (JudgeUtils.isNotSuccess(ruleC2(ttlTaxblBaseAmt).getErrorCode())) {
                                    return ruleC2(ttlTaxblBaseAmt);
                                }
                                ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                if (JudgeUtils.isNotSuccess(ruleC2(ttlTaxAmt).getErrorCode())) {
                                    return ruleC2(ttlTaxAmt);
                                }
                                List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                if (JudgeUtils.isNotNull(rcrd)) {
                                    for (TaxRecord3 taxRecord3 : rcrd) {
                                        TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                            ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                            if (JudgeUtils.isNotSuccess(ruleC2(taxblBaseAmt).getErrorCode())) {
                                                return ruleC2(taxblBaseAmt);
                                            }
                                            ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                            if (JudgeUtils.isNotSuccess(ruleC2(ttlAmt).getErrorCode())) {
                                                return ruleC2(ttlAmt);
                                            }
                                            List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                            if (JudgeUtils.isNotNull(dtls)) {
                                                for (TaxRecordDetails3 dtl : dtls) {
                                                    ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                    if (JudgeUtils.isNotSuccess(ruleC2(amt).getErrorCode())) {
                                                        return ruleC2(amt);
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
                ActiveOrHistoricCurrencyAndAmount instdAmt = undrlygCstmrCdtTrf.getInstdAmt();
                if (JudgeUtils.isNotNull(instdAmt)) {
                    if (JudgeUtils.isNotSuccess(ruleC2(instdAmt).getErrorCode())) {
                        return ruleC2(instdAmt);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC3() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
        for (PaymentTransaction133 paymentTransaction133 : txInf) {
            OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
            if (JudgeUtils.isNotNull(orgnlTxRef)) {
                MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                if (JudgeUtils.isNotNull(mndtRltdInf)) {
                    MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                    if (JudgeUtils.isNotNull(drctDbtMndt)) {
                        if (!drctDbtMndt.isAmdmntInd()) {
                            AmendmentInformationDetails14 amdmntInfDtls=drctDbtMndt.getAmdmntInfDtls();
                            if(JudgeUtils.isNotNull(amdmntInfDtls)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C3_ERROR_CODE, Pacs00400110ErrorConstant.C3_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC4() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
        for (PaymentTransaction133 paymentTransaction133 : txInf) {
            OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
            if (JudgeUtils.isNotNull(orgnlTxRef)) {
                MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                if (JudgeUtils.isNotNull(mndtRltdInf)) {
                    MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                    if (JudgeUtils.isNotNull(drctDbtMndt)) {
                        if (drctDbtMndt.isAmdmntInd()) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C4_ERROR_CODE, Pacs00400110ErrorConstant.C4_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }


    private static Constraints ruleC5(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String bicfi = finInstnId.getBICFI();
                if (JudgeUtils.isNotNull(bicfi)) {
                    //通过正则表达式进行匹配
                    boolean c4 = bicfi.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
                    if (!c4) {
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C5_ERROR_CODE, Pacs00400110ErrorConstant.C5_ERROR_TEXT, bicfi);
                    }
                }
            }
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }


    public Constraints checkC5() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf.getThrdRmbrsmntAgt();
                    if (JudgeUtils.isNotSuccess(ruleC5(instgRmbrsmntAgt).getErrorCode())) {
                        return ruleC5(instgRmbrsmntAgt);
                    }
                    if (JudgeUtils.isNotSuccess(ruleC5(instdRmbrsmntAgt).getErrorCode())) {
                        return ruleC5(instgRmbrsmntAgt);
                    }
                    if (JudgeUtils.isNotSuccess(ruleC5(thrdRmbrsmntAgt).getErrorCode())) {
                        return ruleC5(instgRmbrsmntAgt);
                    }
                }
                BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                if (JudgeUtils.isNotSuccess(ruleC5(instgAgt).getErrorCode())) {
                    return ruleC5(instgAgt);
                }
                if (JudgeUtils.isNotSuccess(ruleC5(instdAgt).getErrorCode())) {
                    return ruleC5(instdAgt);
                }
                List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
                for (PaymentTransaction133 paymentTransaction133 : txInf) {
                    BranchAndFinancialInstitutionIdentification6 instgAgt1 = paymentTransaction133.getInstgAgt();
                    BranchAndFinancialInstitutionIdentification6 instdAgt1 = paymentTransaction133.getInstdAgt();
                    TransactionParties10 rtrChain = paymentTransaction133.getRtrChain();
                    if(JudgeUtils.isNotNull(rtrChain)) {
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = rtrChain.getDbtrAgt();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = rtrChain.getPrvsInstgAgt1();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = rtrChain.getPrvsInstgAgt2();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = rtrChain.getPrvsInstgAgt3();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = rtrChain.getIntrmyAgt1();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = rtrChain.getIntrmyAgt2();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = rtrChain.getIntrmyAgt3();
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = rtrChain.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt1).getErrorCode())) {
                            return ruleC5(prvsInstgAgt1);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt2).getErrorCode())) {
                            return ruleC5(prvsInstgAgt2);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt3).getErrorCode())) {
                            return ruleC5(prvsInstgAgt3);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(instgAgt1).getErrorCode())) {
                            return ruleC5(instgAgt1);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(instdAgt1).getErrorCode())) {
                            return ruleC5(instdAgt1);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt1).getErrorCode())) {
                            return ruleC5(intrmyAgt1);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt2).getErrorCode())) {
                            return ruleC5(intrmyAgt2);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt3).getErrorCode())) {
                            return ruleC5(intrmyAgt3);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(dbtrAgt).getErrorCode())) {
                            return ruleC5(dbtrAgt);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(cdtrAgt).getErrorCode())) {
                            return ruleC5(cdtrAgt);
                        }
                    }
                    OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
                    if (JudgeUtils.isNotNull(orgnlTxRef)) {
                        SettlementInstruction11 sttlmInf1=orgnlTxRef.getSttlmInf();
                        if(JudgeUtils.isNotNull(sttlmInf1)) {
                            BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt = sttlmInf1.getInstgRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt = sttlmInf1.getInstdRmbrsmntAgt();
                            BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt = sttlmInf1.getThrdRmbrsmntAgt();
                            if (JudgeUtils.isNotSuccess(ruleC5(instgRmbrsmntAgt).getErrorCode())) {
                                return ruleC5(instgRmbrsmntAgt);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(instdRmbrsmntAgt).getErrorCode())) {
                                return ruleC5(instdRmbrsmntAgt);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(thrdRmbrsmntAgt).getErrorCode())) {
                                return ruleC5(thrdRmbrsmntAgt);
                            }
                        }
                        MandateRelatedData2Choice mndtRltdInf=orgnlTxRef.getMndtRltdInf();
                        if(JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if(JudgeUtils.isNotNull(drctDbtMndt)){
                                AmendmentInformationDetails14 amdmntInfDtls=drctDbtMndt.getAmdmntInfDtls();
                                if(JudgeUtils.isNotNull(amdmntInfDtls)){
                                    BranchAndFinancialInstitutionIdentification6 orgnlCdtrAgt=amdmntInfDtls.getOrgnlCdtrAgt();
                                    BranchAndFinancialInstitutionIdentification6 orgnlDbtrAgt=amdmntInfDtls.getOrgnlDbtrAgt();
                                    if (JudgeUtils.isNotSuccess(ruleC5(orgnlCdtrAgt).getErrorCode())) {
                                        return ruleC5(orgnlCdtrAgt);
                                    }
                                    if (JudgeUtils.isNotSuccess(ruleC5(orgnlDbtrAgt).getErrorCode())) {
                                        return ruleC5(orgnlDbtrAgt);
                                    }
                                }
                            }
                        }
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt=orgnlTxRef.getDbtrAgt();
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt=orgnlTxRef.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleC5(dbtrAgt).getErrorCode())) {
                            return ruleC5(dbtrAgt);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC5(cdtrAgt).getErrorCode())) {
                            return ruleC5(cdtrAgt);
                        }
                        CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                        if(JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                            BranchAndFinancialInstitutionIdentification6 dbtrAgt1=undrlygCstmrCdtTrf.getDbtrAgt();
                            BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1=undrlygCstmrCdtTrf.getPrvsInstgAgt1();
                            BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2=undrlygCstmrCdtTrf.getPrvsInstgAgt2();
                            BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3=undrlygCstmrCdtTrf.getPrvsInstgAgt3();
                            BranchAndFinancialInstitutionIdentification6 intrmyAgt1=undrlygCstmrCdtTrf.getIntrmyAgt1();
                            BranchAndFinancialInstitutionIdentification6 intrmyAgt2=undrlygCstmrCdtTrf.getIntrmyAgt2();
                            BranchAndFinancialInstitutionIdentification6 intrmyAgt3=undrlygCstmrCdtTrf.getIntrmyAgt3();
                            BranchAndFinancialInstitutionIdentification6 cdtrAgt1=undrlygCstmrCdtTrf.getCdtrAgt();
                            if (JudgeUtils.isNotSuccess(ruleC5(dbtrAgt1).getErrorCode())) {
                                return ruleC5(dbtrAgt1);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt1).getErrorCode())) {
                                return ruleC5(prvsInstgAgt1);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt2).getErrorCode())) {
                                return ruleC5(prvsInstgAgt2);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(prvsInstgAgt3).getErrorCode())) {
                                return ruleC5(prvsInstgAgt3);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt1).getErrorCode())) {
                                return ruleC5(intrmyAgt1);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt2).getErrorCode())) {
                                return ruleC5(intrmyAgt2);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(intrmyAgt3).getErrorCode())) {
                                return ruleC5(intrmyAgt3);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC5(cdtrAgt1).getErrorCode())) {
                                return ruleC5(cdtrAgt1);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }

   

    private static Constraints ruleC6(String str) {
        //通过正则表达式进行匹配
        boolean c4 = str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
        if (!c4) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C6_ERROR_CODE, Pacs00400110ErrorConstant.C6_ERROR_TEXT, str);
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }


    public Constraints checkC6() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            for (PaymentTransaction133 paymentTransaction133 : txInf) {
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    PartyIdentification135 cdtrSchmeId = orgnlTxRef.getCdtrSchmeId();
                    if(JudgeUtils.isNotNull(cdtrSchmeId)) {
                        String ctryOfRes = cdtrSchmeId.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes).getErrorCode())) {
                            return ruleC6(ctryOfRes);
                        }

                    }
                    MandateRelatedData2Choice mndtRltdInf=orgnlTxRef.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mndtRltdInf)){
                        MandateRelatedInformation15 drctDbtMndt=mndtRltdInf.getDrctDbtMndt();
                        if(JudgeUtils.isNotNull(drctDbtMndt)){
                            AmendmentInformationDetails14 amdmntInfDtls=drctDbtMndt.getAmdmntInfDtls();
                            if(JudgeUtils.isNotNull(amdmntInfDtls)){
                                PartyIdentification135 orgnlCdtrSchmeId=amdmntInfDtls.getOrgnlCdtrSchmeId();
                                if(JudgeUtils.isNotNull(orgnlCdtrSchmeId)){
                                    String ctryOfRes = orgnlCdtrSchmeId.getCtryOfRes();
                                    if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes).getErrorCode())) {
                                        return ruleC6(ctryOfRes);
                                    }
                                }
                                PartyIdentification135 orgnlDbtr=amdmntInfDtls.getOrgnlDbtr();
                                if(JudgeUtils.isNotNull(orgnlDbtr)){
                                    String ctryOfRes = orgnlDbtr.getCtryOfRes();
                                    if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes).getErrorCode())) {
                                        return ruleC6(ctryOfRes);
                                    }
                                }
                            }
                        }

                    }
                    RemittanceInformation21 rmtInf=orgnlTxRef.getRmtInf();
                    if(JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                        for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                            PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                            String ctryOfRes = invcr.getCtryOfRes();
                            if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes).getErrorCode())) {
                                return ruleC6(ctryOfRes);
                            }
                            PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                            String ctryOfRes1 = invcee.getCtryOfRes();
                            if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes1).getErrorCode())) {
                                return ruleC6(ctryOfRes1);
                            }
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                    if(JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        PartyIdentification135 ultmtDbtr = undrlygCstmrCdtTrf.getUltmtDbtr();
                        PartyIdentification135 initgPty = undrlygCstmrCdtTrf.getInitgPty();
                        PartyIdentification135 dbtr = undrlygCstmrCdtTrf.getDbtr();
                        PartyIdentification135 cdtr=undrlygCstmrCdtTrf.getCdtr();
                        PartyIdentification135 ultmtCdtr=undrlygCstmrCdtTrf.getUltmtCdtr();
                        String ctryOfRes = ultmtDbtr.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes).getErrorCode())) {
                            return ruleC6(ctryOfRes);
                        }
                        String ctryOfRes1 = initgPty.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes1).getErrorCode())) {
                            return ruleC6(ctryOfRes1);
                        }
                        String ctryOfRes2 = dbtr.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes2).getErrorCode())) {
                            return ruleC6(ctryOfRes2);
                        }
                        String ctryOfRes3 = cdtr.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes3).getErrorCode())) {
                            return ruleC6(ctryOfRes3);
                        }
                        String ctryOfRes4 = ultmtCdtr.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes4).getErrorCode())) {
                            return ruleC6(ctryOfRes4);
                        }
                        RemittanceInformation21 rmtInf1=undrlygCstmrCdtTrf.getRmtInf();
                        if(JudgeUtils.isNotNull(rmtInf1)){
                            List<StructuredRemittanceInformation17> strd=rmtInf1.getStrd();
                            for(StructuredRemittanceInformation17 structuredRemittanceInformation17:strd){
                                PartyIdentification135 invcr=structuredRemittanceInformation17.getInvcr();
                                PartyIdentification135 invcee=structuredRemittanceInformation17.getInvcee();
                                String ctryOfRes5 = invcr.getCtryOfRes();
                                if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes5).getErrorCode())) {
                                    return ruleC6(ctryOfRes5);
                                }
                                String ctryOfRes6 = invcee.getCtryOfRes();
                                if (JudgeUtils.isNotSuccess(ruleC6(ctryOfRes6).getErrorCode())) {
                                    return ruleC6(ctryOfRes6);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC7() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if(JudgeUtils.isNotNull(paymentReturnV11)){
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                List<Charges7> chrgsInf=paymentTransaction133.getChrgsInf();
                ActiveOrHistoricCurrencyAndAmount rtrdInstdAmt=paymentTransaction133.getRtrdInstdAmt();
                if(JudgeUtils.isNotNull(chrgsInf)&&JudgeUtils.isNull(rtrdInstdAmt)){
                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                }
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNull(orgnlTxRef)) {
                    AmountType4Choice amt = orgnlTxRef.getAmt();
                    if(JudgeUtils.isNotNull(amt)) {
                        ActiveOrHistoricCurrencyAndAmount instdAmt = amt.getInstdAmt();
                        if(JudgeUtils.isNotNull(chrgsInf)&&JudgeUtils.isNull(instdAmt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                        }
                    }
                    RemittanceInformation21 rmtInf=orgnlTxRef.getRmtInf();
                    if(JudgeUtils.isNotNull(rmtInf)){
                        List<StructuredRemittanceInformation17> strd=rmtInf.getStrd();
                        for(StructuredRemittanceInformation17 structuredRemittanceInformation17:strd){
                            RemittanceAmount2 rfrdDocAmt= structuredRemittanceInformation17.getRfrdDocAmt();
                            if(JudgeUtils.isNotNull(chrgsInf)&&JudgeUtils.isNotNull(rfrdDocAmt)){
                                ActiveOrHistoricCurrencyAndAmount duePyblAmt=rfrdDocAmt.getDuePyblAmt();
                                if(JudgeUtils.isNull(duePyblAmt)){
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                }
                                ActiveOrHistoricCurrencyAndAmount cdtNoteAmt=rfrdDocAmt.getCdtNoteAmt();
                                if(JudgeUtils.isNull(cdtNoteAmt)){
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                }
                                List<DiscountAmountAndType1> dscntApldAmt=rfrdDocAmt.getDscntApldAmt();
                                for(DiscountAmountAndType1 discountAmountAndType1:dscntApldAmt){
                                    ActiveOrHistoricCurrencyAndAmount amt1=discountAmountAndType1.getAmt();
                                    if(JudgeUtils.isNull(amt1)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                List<TaxAmountAndType1> taxAmt=rfrdDocAmt.getTaxAmt();
                                for(TaxAmountAndType1 taxAmountAndType1:taxAmt){
                                    ActiveOrHistoricCurrencyAndAmount amt2=taxAmountAndType1.getAmt();
                                    if(JudgeUtils.isNull(amt2)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                List<DocumentAdjustment1> adjstmntAmtAndRsn=rfrdDocAmt.getAdjstmntAmtAndRsn();
                                for(DocumentAdjustment1 adjustment1:adjstmntAmtAndRsn) {
                                    ActiveOrHistoricCurrencyAndAmount amt3=adjustment1.getAmt();
                                    if(JudgeUtils.isNull(amt3)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                if(JudgeUtils.isNull(rmtdAmt)){
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                }
                            }
                            Garnishment3 grnshmtRmt=structuredRemittanceInformation17.getGrnshmtRmt();
                            if(JudgeUtils.isNotNull(grnshmtRmt)) {
                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = grnshmtRmt.getRmtdAmt();
                                if(JudgeUtils.isNull(rmtdAmt)){
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                }
                            }
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                    if(JudgeUtils.isNotNull(undrlygCstmrCdtTrf)){
                        RemittanceInformation21 rmtInf1= undrlygCstmrCdtTrf.getRmtInf();
                        if(JudgeUtils.isNotNull(rmtInf1)){
                            List<StructuredRemittanceInformation17> strd=rmtInf1.getStrd();
                            for(StructuredRemittanceInformation17 structuredRemittanceInformation17:strd){
                                RemittanceAmount2 rfrdDocAmt= structuredRemittanceInformation17.getRfrdDocAmt();
                                if(JudgeUtils.isNotNull(chrgsInf)&&JudgeUtils.isNotNull(rfrdDocAmt)){
                                    ActiveOrHistoricCurrencyAndAmount duePyblAmt=rfrdDocAmt.getDuePyblAmt();
                                    if(JudgeUtils.isNull(duePyblAmt)){
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                    ActiveOrHistoricCurrencyAndAmount cdtNoteAmt=rfrdDocAmt.getCdtNoteAmt();
                                    if(JudgeUtils.isNull(cdtNoteAmt)){
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                    List<DiscountAmountAndType1> dscntApldAmt=rfrdDocAmt.getDscntApldAmt();
                                    for(DiscountAmountAndType1 discountAmountAndType1:dscntApldAmt){
                                        ActiveOrHistoricCurrencyAndAmount amt1=discountAmountAndType1.getAmt();
                                        if(JudgeUtils.isNull(amt1)) {
                                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                        }
                                    }
                                    List<TaxAmountAndType1> taxAmt=rfrdDocAmt.getTaxAmt();
                                    for(TaxAmountAndType1 taxAmountAndType1:taxAmt){
                                        ActiveOrHistoricCurrencyAndAmount amt2=taxAmountAndType1.getAmt();
                                        if(JudgeUtils.isNull(amt2)) {
                                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                        }
                                    }
                                    List<DocumentAdjustment1> adjstmntAmtAndRsn=rfrdDocAmt.getAdjstmntAmtAndRsn();
                                    for(DocumentAdjustment1 adjustment1:adjstmntAmtAndRsn) {
                                        ActiveOrHistoricCurrencyAndAmount amt3=adjustment1.getAmt();
                                        if(JudgeUtils.isNull(amt3)) {
                                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                        }
                                    }
                                    ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                    if(JudgeUtils.isNull(rmtdAmt)){
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                Garnishment3 grnshmtRmt=structuredRemittanceInformation17.getGrnshmtRmt();
                                if(JudgeUtils.isNotNull(grnshmtRmt)) {
                                    ActiveOrHistoricCurrencyAndAmount rmtdAmt = grnshmtRmt.getRmtdAmt();
                                    if(JudgeUtils.isNull(rmtdAmt)){
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C7_ERROR_CODE, Pacs00400110ErrorConstant.C7_ERROR_TEXT);
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

    public Constraints checkC8() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if(JudgeUtils.isNotNull(paymentReturnV11)){
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                if(grpHdr.isGrpRtr()&&JudgeUtils.isNotNull(grpHdr.getCtrlSum())){
                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C8_ERROR_CODE, Pacs00400110ErrorConstant.C8_ERROR_TEXT);
                }
            }
        }
        return null;
    }

    private static Constraints ruleC9(PartyIdentification135 partyIdentification135) {
        if (JudgeUtils.isNotNull(partyIdentification135)) {
            PostalAddress24 pstlAdr = partyIdentification135.getPstlAdr();
            if (JudgeUtils.isNotNull(pstlAdr)) {
                String ctry = pstlAdr.getCtry();
                if (JudgeUtils.isNotNull(ctry)) {
                    //通过正则表达式判断
                    boolean c9 = ctry.matches("^[a-zA-Z]{2}$");
                    if (!c9) {
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C9_ERROR_CODE, Pacs00400110ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                    CountryEnum[] values = CountryEnum.values();
                    ArrayList<String> ctryLists = new ArrayList<>();
                    for (CountryEnum value : values) {
                        ctryLists.add(value.getCountryCode());
                    }
                    if (!ctryLists.contains(ctry)) {
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C9_ERROR_CODE, Pacs00400110ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                }
            }
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }

    private static Constraints ruleC9(String str) {
        //通过正则表达式判断
        boolean c9 = str.matches("^[a-zA-Z]{2}$");
        if (!c9) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C9_ERROR_CODE, Pacs00400110ErrorConstant.C9_ERROR_TEXT, str);
        }
        CountryEnum[] values = CountryEnum.values();
        ArrayList<String> ctryLists = new ArrayList<>();
        for (CountryEnum value : values) {
            ctryLists.add(value.getCountryCode());
        }
        if (!ctryLists.contains(str)) {
            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C9_ERROR_CODE, Pacs00400110ErrorConstant.C9_ERROR_TEXT, str);
        }

        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }

    public Constraints checkC9() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            for (PaymentTransaction133 paymentTransaction133 : txInf) {
                OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
                if (JudgeUtils.isNotNull(orgnlTxRef)) {
                    PartyIdentification135 cdtrSchmeId = orgnlTxRef.getCdtrSchmeId();
                    if (JudgeUtils.isNotSuccess(ruleC9(cdtrSchmeId).getErrorCode())) {
                        return ruleC9(cdtrSchmeId);
                    }
                    MandateRelatedData2Choice mndtRltdInf = orgnlTxRef.getMndtRltdInf();
                    if (JudgeUtils.isNotNull(mndtRltdInf)) {
                        MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                        if (JudgeUtils.isNotNull(drctDbtMndt)) {
                            AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                            if (JudgeUtils.isNotNull(amdmntInfDtls)) {
                                PartyIdentification135 orgnlCdtrSchmeId = amdmntInfDtls.getOrgnlCdtrSchmeId();
                                if (JudgeUtils.isNotSuccess(ruleC9(orgnlCdtrSchmeId).getErrorCode())) {
                                    return ruleC9(orgnlCdtrSchmeId);
                                }
                                PartyIdentification135 orgnlDbtr = amdmntInfDtls.getOrgnlDbtr();
                                if (JudgeUtils.isNotSuccess(ruleC9(orgnlDbtr).getErrorCode())) {
                                    return ruleC9(orgnlDbtr);
                                }
                            }
                        }

                    }
                    RemittanceInformation21 rmtInf = orgnlTxRef.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation17> strd = rmtInf.getStrd();
                        for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                            PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                            if (JudgeUtils.isNotSuccess(ruleC9(invcr).getErrorCode())) {
                                return ruleC9(invcr);
                            }
                            PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                            if (JudgeUtils.isNotSuccess(ruleC9(invcee).getErrorCode())) {
                                return ruleC9(invcee);
                            }
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf = orgnlTxRef.getUndrlygCstmrCdtTrf();
                    if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                        PartyIdentification135 ultmtDbtr = undrlygCstmrCdtTrf.getUltmtDbtr();
                        PartyIdentification135 initgPty = undrlygCstmrCdtTrf.getInitgPty();
                        PartyIdentification135 dbtr = undrlygCstmrCdtTrf.getDbtr();
                        PartyIdentification135 cdtr = undrlygCstmrCdtTrf.getCdtr();
                        PartyIdentification135 ultmtCdtr = undrlygCstmrCdtTrf.getUltmtCdtr();
                        if (JudgeUtils.isNotSuccess(ruleC9(ultmtDbtr).getErrorCode())) {
                            return ruleC9(ultmtDbtr);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC9(initgPty).getErrorCode())) {
                            return ruleC9(initgPty);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC9(dbtr).getErrorCode())) {
                            return ruleC9(dbtr);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC9(cdtr).getErrorCode())) {
                            return ruleC9(cdtr);
                        }
                        if (JudgeUtils.isNotSuccess(ruleC9(ultmtCdtr).getErrorCode())) {
                            return ruleC9(ultmtCdtr);
                        }
                        RemittanceInformation21 rmtInf1 = undrlygCstmrCdtTrf.getRmtInf();
                        if (JudgeUtils.isNotNull(rmtInf1)) {
                            List<StructuredRemittanceInformation17> strd = rmtInf1.getStrd();
                            for (StructuredRemittanceInformation17 structuredRemittanceInformation17 : strd) {
                                PartyIdentification135 invcr = structuredRemittanceInformation17.getInvcr();
                                PartyIdentification135 invcee = structuredRemittanceInformation17.getInvcee();
                                if (JudgeUtils.isNotSuccess(ruleC9(invcr).getErrorCode())) {
                                    return ruleC9(invcr);
                                }
                                if (JudgeUtils.isNotSuccess(ruleC9(invcee).getErrorCode())) {
                                    return ruleC9(invcee);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Constraints ruleC10(String ccy, BigDecimal bigDecimal) {
        if (JudgeUtils.isNotNull(bigDecimal)) {
            String bigS = bigDecimal.toString();
            int totalDigits = bigS.length();
            int fractionDigits = 0;
            if (bigS.contains(".")) {
                String[] split = bigS.split("\\.");
                if (split.length > 2) {
                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C10_ERROR_CODE, Pacs00400110ErrorConstant.C10_ERROR_TEXT, bigS);
                }
                totalDigits = totalDigits - 1;
                fractionDigits = split[1].length();
            }
            if (totalDigits > 18 || fractionDigits > 5) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C10_ERROR_CODE, Pacs00400110ErrorConstant.C10_ERROR_TEXT, bigS);
            }
        }
        if (JudgeUtils.isNotNull(ccy)) {
            //通过正则表达式判断
            boolean c10 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c10) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C10_ERROR_CODE, Pacs00400110ErrorConstant.C10_ERROR_TEXT, ccy);
            }
            ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
            ArrayList<String> ccyLists = new ArrayList<>();
            for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
                ccyLists.add(ccyValue.getCurrencyCode());
            }
            if (!ccyLists.contains(ccy)) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C10_ERROR_CODE, Pacs00400110ErrorConstant.C10_ERROR_TEXT, ccy);
            }
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }


    public Constraints checkC10() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                ActiveCurrencyAndAmount ttlRtrdIntrBkSttlmAmt=grpHdr.getTtlRtrdIntrBkSttlmAmt();
                if(JudgeUtils.isNotNull(ttlRtrdIntrBkSttlmAmt)){
                    String ccy = ttlRtrdIntrBkSttlmAmt.getCcy();
                    BigDecimal value = ttlRtrdIntrBkSttlmAmt.getValue();
                    if (JudgeUtils.isNotSuccess(ruleC10(ccy, value).getErrorCode())) {
                        return ruleC10(ccy, value);
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                ActiveCurrencyAndAmount rtrdIntrBkSttlmAmt=paymentTransaction133.getRtrdIntrBkSttlmAmt();
                if(JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    String ccy = rtrdIntrBkSttlmAmt.getCcy();
                    BigDecimal value = rtrdIntrBkSttlmAmt.getValue();
                    if (JudgeUtils.isNotSuccess(ruleC10(ccy, value).getErrorCode())) {
                        return ruleC10(ccy, value);
                    }
                }
            }
        }
        return null;
    }


    private static Constraints ruleC11(String ccy, BigDecimal bigDecimal) {
        if (JudgeUtils.isNotNull(bigDecimal)) {
            String bigS = bigDecimal.toString();
            int totalDigits = bigS.length();
            int fractionDigits = 0;
            if (bigS.contains(".")) {
                String[] split = bigS.split("\\.");
                if (split.length > 2) {
                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C11_ERROR_CODE, Pacs00400110ErrorConstant.C11_ERROR_TEXT, bigS);
                }
                totalDigits = totalDigits - 1;
                fractionDigits = split[1].length();
            }
            if (totalDigits > 18 || fractionDigits > 5) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C11_ERROR_CODE, Pacs00400110ErrorConstant.C11_ERROR_TEXT, bigS);
            }
        }
        if (JudgeUtils.isNotNull(ccy)) {
            //通过正则表达式判断
            boolean c11 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c11) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C11_ERROR_CODE, Pacs00400110ErrorConstant.C11_ERROR_TEXT, ccy);
            }
            ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
            ArrayList<String> ccyLists = new ArrayList<>();
            for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
                ccyLists.add(ccyValue.getCurrencyCode());
            }
            if (!ccyLists.contains(ccy)) {
                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C11_ERROR_CODE, Pacs00400110ErrorConstant.C11_ERROR_TEXT, ccy);
            }
        }
        return new Constraints(Pacs00400110ErrorConstant.SUCCESS_CODE);
    }

    public Constraints checkC11() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
        for (PaymentTransaction133 paymentTransaction133 : txInf) {
            ActiveOrHistoricCurrencyAndAmount orgnlIntrBkSttlmAmt = paymentTransaction133.getOrgnlIntrBkSttlmAmt();
            if (JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)) {
                String ccy = orgnlIntrBkSttlmAmt.getCcy();
                BigDecimal value = orgnlIntrBkSttlmAmt.getValue();
                if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                    return ruleC11(ccy,value);
                }
            }
            ActiveOrHistoricCurrencyAndAmount rtrdInstdAmt = paymentTransaction133.getRtrdInstdAmt();
            if (JudgeUtils.isNotNull(rtrdInstdAmt)) {
                String ccyRtr = rtrdInstdAmt.getCcy();
                BigDecimal value = rtrdInstdAmt.getValue();
                if (JudgeUtils.isNotSuccess(ruleC11(ccyRtr,value).getErrorCode())) {
                    return ruleC11(ccyRtr,value);
                }
            }
            ActiveOrHistoricCurrencyAndAmount compstnAmt = paymentTransaction133.getCompstnAmt();
            if (JudgeUtils.isNotNull(compstnAmt)) {
                String ccyCom = compstnAmt.getCcy();
                BigDecimal value = compstnAmt.getValue();
                if (JudgeUtils.isNotSuccess(ruleC11(ccyCom,value).getErrorCode())) {
                    return ruleC11(ccyCom,value);
                }
            }
            OriginalTransactionReference36 orgnlTxRef = paymentTransaction133.getOrgnlTxRef();
            if (JudgeUtils.isNotNull(orgnlTxRef)) {
                ActiveOrHistoricCurrencyAndAmount intrBkSttlmAmt = orgnlTxRef.getIntrBkSttlmAmt();
                if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                    String ccyInt = intrBkSttlmAmt.getCcy();
                    BigDecimal value = intrBkSttlmAmt.getValue();
                    if (JudgeUtils.isNotSuccess(ruleC11(ccyInt,value).getErrorCode())) {
                        return ruleC11(ccyInt,value);
                    }
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
                                                String ccyDue = duePyblAmt.getCcy();
                                                BigDecimal value = duePyblAmt.getValue();
                                                if (JudgeUtils.isNotSuccess(ruleC11(ccyDue,value).getErrorCode())) {
                                                    return ruleC11(ccyDue,value);
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                            if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                String ccyCdt = cdtNoteAmt.getCcy();
                                                BigDecimal value = cdtNoteAmt.getValue();
                                                if (JudgeUtils.isNotSuccess(ruleC11(ccyCdt,value).getErrorCode())) {
                                                    return ruleC11(ccyCdt,value);
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                            if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                String ccyRmt = rmtdAmt.getCcy();
                                                BigDecimal value = rmtdAmt.getValue();
                                                if (JudgeUtils.isNotSuccess(ruleC11(ccyRmt,value).getErrorCode())) {
                                                    return ruleC11(ccyRmt,value);
                                                }
                                            }
                                            List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                            if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                    ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                    if (JudgeUtils.isNotNull(amt1)) {
                                                        String ccyAmt = amt1.getCcy();
                                                        BigDecimal value = amt1.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                            return ruleC11(ccyAmt,value);
                                                        }
                                                    }
                                                }
                                            }
                                            List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                            if (JudgeUtils.isNotNull(taxAmt)) {
                                                for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                    ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                    if (JudgeUtils.isNotNull(amt1)) {
                                                        String ccyAmt = amt1.getCcy();
                                                        BigDecimal value = amt1.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                            return ruleC11(ccyAmt,value);
                                                        }
                                                    }
                                                }
                                            }
                                            List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                            if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                    ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                    if (JudgeUtils.isNotNull(amt1)) {
                                                        String ccyAmt = amt1.getCcy();
                                                        BigDecimal value = amt1.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                            return ruleC11(ccyAmt,value);
                                                        }
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
                            if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                String ccyttl = ttlTaxblBaseAmt.getCcy();
                                BigDecimal value = ttlTaxblBaseAmt.getValue();
                                if (JudgeUtils.isNotSuccess(ruleC11(ccyttl,value).getErrorCode())) {
                                    return ruleC11(ccyttl,value);
                                }
                            }
                            ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                            if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                String ccyTtl = ttlTaxAmt.getCcy();
                                BigDecimal value = ttlTaxAmt.getValue();
                                if (JudgeUtils.isNotSuccess(ruleC11(ccyTtl,value).getErrorCode())) {
                                    return ruleC11(ccyTtl,value);
                                }
                            }
                            List<TaxRecord3> rcrd = taxRmt.getRcrd();
                            if (JudgeUtils.isNotNull(rcrd)) {
                                for (TaxRecord3 taxRecord3 : rcrd) {
                                    TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                    if (JudgeUtils.isNotNull(taxAmt)) {
                                        ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                        if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                            String ccyTax = taxblBaseAmt.getCcy();
                                            BigDecimal value = taxblBaseAmt.getValue();
                                            if (JudgeUtils.isNotSuccess(ruleC11(ccyTax,value).getErrorCode())) {
                                                return ruleC11(ccyTax,value);
                                            }
                                        }
                                        ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                        if (JudgeUtils.isNotNull(ttlAmt)) {
                                            String ccyTtl = ttlAmt.getCcy();
                                            BigDecimal value = ttlAmt.getValue();
                                            if (JudgeUtils.isNotSuccess(ruleC11(ccyTtl,value).getErrorCode())) {
                                                return ruleC11(ccyTtl,value);
                                            }
                                        }
                                        List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                        if (JudgeUtils.isNotNull(dtls)) {
                                            for (TaxRecordDetails3 dtl : dtls) {
                                                ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    String ccyAmt = amt.getCcy();
                                                    BigDecimal value = amt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                        return ruleC11(ccyAmt,value);
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
            CreditTransferTransaction52 undrlygCstmrCdtTrf = orgnlTxRef.getUndrlygCstmrCdtTrf();
            if (JudgeUtils.isNotNull(undrlygCstmrCdtTrf)) {
                TaxInformation10 tax = undrlygCstmrCdtTrf.getTax();
                if (JudgeUtils.isNotNull(tax)) {
                    ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = tax.getTtlTaxblBaseAmt();
                    if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                        String ccyTtl = ttlTaxblBaseAmt.getCcy();
                        BigDecimal value = ttlTaxblBaseAmt.getValue();
                        if (JudgeUtils.isNotSuccess(ruleC11(ccyTtl,value).getErrorCode())) {
                            return ruleC11(ccyTtl,value);
                        }
                    }
                    ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = tax.getTtlTaxAmt();
                    if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                        String ccyTtl = ttlTaxAmt.getCcy();
                        BigDecimal value = ttlTaxAmt.getValue();
                        if (JudgeUtils.isNotSuccess(ruleC11(ccyTtl,value).getErrorCode())) {
                            return ruleC11(ccyTtl,value);
                        }
                    }
                    List<TaxRecord3> rcrd = tax.getRcrd();
                    for (TaxRecord3 taxRecord3 : rcrd) {
                        TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                        ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                        if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                            String ccyTax = taxblBaseAmt.getCcy();
                            BigDecimal value = taxblBaseAmt.getValue();
                            if (JudgeUtils.isNotSuccess(ruleC11(ccyTax,value).getErrorCode())) {
                                return ruleC11(ccyTax,value);
                            }
                        }
                        ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                        if (JudgeUtils.isNotNull(ttlAmt)) {
                            String ccyTtl = ttlAmt.getCcy();
                            BigDecimal value = ttlAmt.getValue();
                            if (JudgeUtils.isNotSuccess(ruleC11(ccyTtl,value).getErrorCode())) {
                                return ruleC11(ccyTtl,value);
                            }
                        }
                        List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                        for (TaxRecordDetails3 taxRecordDetails3 : dtls) {
                            ActiveOrHistoricCurrencyAndAmount amt = taxRecordDetails3.getAmt();
                            if (JudgeUtils.isNotNull(amt)) {
                                String ccyAmt = amt.getCcy();
                                BigDecimal value = amt.getValue();
                                if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                    return ruleC11(ccyAmt,value);
                                }
                            }
                        }
                    }
                }
                RemittanceInformation21 rmtInf21 = undrlygCstmrCdtTrf.getRmtInf();
                if (JudgeUtils.isNotNull(rmtInf21)) {
                    List<StructuredRemittanceInformation17> strd = rmtInf21.getStrd();
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
                                                    String ccyAmt = duePyblAmt.getCcy();
                                                    BigDecimal value = duePyblAmt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                        return ruleC11(ccyAmt,value);
                                                    }
                                                }
                                                ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                    String ccyAmt = cdtNoteAmt.getCcy();
                                                    BigDecimal value = cdtNoteAmt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                        return ruleC11(ccyAmt,value);
                                                    }
                                                }
                                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                    String ccyAmt = rmtdAmt.getCcy();
                                                    BigDecimal value = rmtdAmt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                        return ruleC11(ccyAmt,value);
                                                    }
                                                }
                                                List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                    for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            BigDecimal value = amt1.getValue();
                                                            if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                                return ruleC11(ccyAmt,value);
                                                            }
                                                        }
                                                    }
                                                }
                                                List<TaxAmountAndType1> taxAmt = amt.getTaxAmt();
                                                if (JudgeUtils.isNotNull(taxAmt)) {
                                                    for (TaxAmountAndType1 taxAmountAndType1 : taxAmt) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            BigDecimal value = amt1.getValue();
                                                            if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                                return ruleC11(ccyAmt,value);
                                                            }
                                                        }
                                                    }
                                                }
                                                List<DocumentAdjustment1> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                    for (DocumentAdjustment1 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                        ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                        if (JudgeUtils.isNotNull(amt1)) {
                                                            String ccyAmt = amt1.getCcy();
                                                            BigDecimal value = amt1.getValue();
                                                            if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                                return ruleC11(ccyAmt,value);
                                                            }
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
                                if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                    String ccyAmt = ttlTaxblBaseAmt.getCcy();
                                    BigDecimal value = ttlTaxblBaseAmt.getValue();
                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                        return ruleC11(ccyAmt,value);
                                    }
                                }
                                ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                    String ccyAmt = ttlTaxAmt.getCcy();
                                    BigDecimal value = ttlTaxAmt.getValue();
                                    if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                        return ruleC11(ccyAmt,value);
                                    }
                                }
                                List<TaxRecord3> rcrd = taxRmt.getRcrd();
                                if (JudgeUtils.isNotNull(rcrd)) {
                                    for (TaxRecord3 taxRecord3 : rcrd) {
                                        TaxAmount3 taxAmt = taxRecord3.getTaxAmt();
                                        if (JudgeUtils.isNotNull(taxAmt)) {
                                            ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                            if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                String ccyAmt = taxblBaseAmt.getCcy();
                                                BigDecimal value = taxblBaseAmt.getValue();
                                                if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                    return ruleC11(ccyAmt,value);
                                                }
                                            }
                                            ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                            if (JudgeUtils.isNotNull(ttlAmt)) {
                                                String ccyAmt = ttlAmt.getCcy();
                                                BigDecimal value = ttlAmt.getValue();
                                                if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                    return ruleC11(ccyAmt,value);
                                                }
                                            }
                                            List<TaxRecordDetails3> dtls = taxAmt.getDtls();
                                            if (JudgeUtils.isNotNull(dtls)) {
                                                for (TaxRecordDetails3 dtl : dtls) {
                                                    ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                    if (JudgeUtils.isNotNull(amt)) {
                                                        String ccyAmt = amt.getCcy();
                                                        BigDecimal value = amt.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                                                            return ruleC11(ccyAmt,value);
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
                ActiveOrHistoricCurrencyAndAmount instdAmt = undrlygCstmrCdtTrf.getInstdAmt();
                if (JudgeUtils.isNotNull(instdAmt)) {
                        String ccyAmt = instdAmt.getCcy();
                        BigDecimal value = instdAmt.getValue();
                        if (JudgeUtils.isNotSuccess(ruleC11(ccyAmt,value).getErrorCode())) {
                            return ruleC11(ccyAmt,value);
                        }
                }
            }
        }
        return null;
    }

    public Constraints checkC18() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if(JudgeUtils.isNotNull(paymentReturnV11)) {
                GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                        if (JudgeUtils.isNotNull(sttlmAcct)) {
                            AccountIdentification4Choice id = sttlmAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                            AccountIdentification4Choice id = instgRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                            AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                            AccountIdentification4Choice id = thrdRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }

                    }
                }
                List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
                for(PaymentTransaction133 paymentTransaction133:txInf){
                    TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                    if(JudgeUtils.isNotNull(rtrChain)){
                        CashAccount40 dbtrAcct=rtrChain.getDbtrAcct();
                        if (JudgeUtils.isNotNull(dbtrAcct)) {
                            AccountIdentification4Choice id = dbtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 dbtrAgtAcct=rtrChain.getDbtrAgtAcct();
                        if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                            AccountIdentification4Choice id = dbtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 prvsInstgAgt1Acct=rtrChain.getPrvsInstgAgt1Acct();
                        if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                            AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 prvsInstgAgt2Acct=rtrChain.getPrvsInstgAgt2Acct();
                        if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                            AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 prvsInstgAgt3Acct=rtrChain.getPrvsInstgAgt3Acct();
                        if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                            AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 intrmyAgt1Acct=rtrChain.getIntrmyAgt1Acct();
                        if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                            AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 intrmyAgt2Acct=rtrChain.getIntrmyAgt2Acct();
                        if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                            AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 intrmyAgt3Acct=rtrChain.getIntrmyAgt3Acct();
                        if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                            AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAgtAcct=rtrChain.getCdtrAgtAcct();
                        if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                            AccountIdentification4Choice id = cdtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAcct=rtrChain.getCdtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAcct)) {
                            AccountIdentification4Choice id = cdtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                    }
                    OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                    if(JudgeUtils.isNotNull(orgnlTxRef)){
                        SettlementInstruction11 sttlmInf=orgnlTxRef.getSttlmInf();
                        if(JudgeUtils.isNotNull(sttlmInf)){
                            CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                            if (JudgeUtils.isNotNull(sttlmAcct)) {
                                AccountIdentification4Choice id = sttlmAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = instgRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = instdRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                            if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                                AccountIdentification4Choice id = thrdRmbrsmntAgtAcct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                        }
                        MandateRelatedData2Choice mndtRltdInf=orgnlTxRef.getMndtRltdInf();
                        if(JudgeUtils.isNotNull(mndtRltdInf)) {
                            MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                            if(JudgeUtils.isNotNull(drctDbtMndt.getFnlColltnDt())) {
                                AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                                if(JudgeUtils.isNotNull(amdmntInfDtls)) {
                                    CashAccount40 orgnlCdtrAgtAcct = amdmntInfDtls.getOrgnlCdtrAgtAcct();
                                    if (JudgeUtils.isNotNull(orgnlCdtrAgtAcct)) {
                                        AccountIdentification4Choice id = orgnlCdtrAgtAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban=id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                        }
                                    }
                                    CashAccount40 orgnlDbtrAcct = amdmntInfDtls.getOrgnlDbtrAcct();
                                    if (JudgeUtils.isNotNull(orgnlDbtrAcct)) {
                                        AccountIdentification4Choice id = orgnlDbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban=id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                        }
                                    }
                                    CashAccount40 orgnlDbtrAgtAcct = amdmntInfDtls.getOrgnlDbtrAgtAcct();
                                    if (JudgeUtils.isNotNull(orgnlDbtrAgtAcct)) {
                                        AccountIdentification4Choice id = orgnlDbtrAgtAcct.getId();
                                        if (JudgeUtils.isNotNull(id)) {
                                            String iban=id.getIBAN();
                                            if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                                        }
                                    }
                                }
                            }
                        }
                        CashAccount40 dbtrAcct=orgnlTxRef.getDbtrAcct();
                        if (JudgeUtils.isNotNull(dbtrAcct)) {
                            AccountIdentification4Choice id = dbtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 dbtrAgtAcct=orgnlTxRef.getDbtrAgtAcct();
                        if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                            AccountIdentification4Choice id = dbtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAgtAcct=orgnlTxRef.getCdtrAgtAcct();
                        if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                            AccountIdentification4Choice id = cdtrAgtAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CashAccount40 cdtrAcct=orgnlTxRef.getCdtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAcct)) {
                            AccountIdentification4Choice id = cdtrAcct.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                String iban=id.getIBAN();
                                if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                    return RuleUtils.checkIBAN(iban);
                                }
                            }
                        }
                        CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                        if(JudgeUtils.isNotNull(undrlygCstmrCdtTrf)){
                            CashAccount40 dbtrAcct1=undrlygCstmrCdtTrf.getDbtrAcct();
                            if (JudgeUtils.isNotNull(dbtrAcct1)) {
                                AccountIdentification4Choice id = dbtrAcct1.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 dbtrAgtAcct1=undrlygCstmrCdtTrf.getDbtrAgtAcct();
                            if (JudgeUtils.isNotNull(dbtrAgtAcct1)) {
                                AccountIdentification4Choice id = dbtrAgtAcct1.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 prvsInstgAgt1Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                            if (JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                                AccountIdentification4Choice id = prvsInstgAgt1Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 prvsInstgAgt2Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                            if (JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                                AccountIdentification4Choice id = prvsInstgAgt2Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 prvsInstgAgt3Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                            if (JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                                AccountIdentification4Choice id = prvsInstgAgt3Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                        return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 intrmyAgt1Acct=undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                            if (JudgeUtils.isNotNull(intrmyAgt1Acct)) {
                                AccountIdentification4Choice id = intrmyAgt1Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 intrmyAgt2Acct=undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                            if (JudgeUtils.isNotNull(intrmyAgt2Acct)) {
                                AccountIdentification4Choice id = intrmyAgt2Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 intrmyAgt3Acct=undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                            if (JudgeUtils.isNotNull(intrmyAgt3Acct)) {
                                AccountIdentification4Choice id = intrmyAgt3Acct.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 cdtrAgtAcct1=undrlygCstmrCdtTrf.getCdtrAgtAcct();
                            if (JudgeUtils.isNotNull(cdtrAgtAcct1)) {
                                AccountIdentification4Choice id = cdtrAgtAcct1.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
                                    if (JudgeUtils.isNotSuccess(RuleUtils.checkIBAN(iban).getErrorCode())) {
                                       return RuleUtils.checkIBAN(iban);
                                }
                                }
                            }
                            CashAccount40 cdtrAcct1 =undrlygCstmrCdtTrf.getCdtrAcct();
                            if (JudgeUtils.isNotNull(cdtrAcct1)) {
                                AccountIdentification4Choice id = cdtrAcct1.getId();
                                if (JudgeUtils.isNotNull(id)) {
                                    String iban=id.getIBAN();
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


    public Constraints checkC13() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            OriginalGroupHeader18 orgnlGrpInf=paymentReturnV11.getOrgnlGrpInf();
            if(JudgeUtils.isNotNull(grpHdr)&&JudgeUtils.isNotNull(orgnlGrpInf)){
              if(grpHdr.isGrpRtr()){
                  String nbOfTxs=grpHdr.getNbOfTxs();
                  String orgnlMsgNmId=orgnlGrpInf.getOrgnlMsgNmId();
                  if(!JudgeUtils.equals(nbOfTxs,orgnlMsgNmId)){
                      return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C13_ERROR_CODE, Pacs00400110ErrorConstant.C13_ERROR_TEXT);
                  }
              }
            }
        }
        return null;
    }

    public Constraints checkC14() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                Boolean grpRtr=grpHdr.isGrpRtr();
                if(JudgeUtils.equals(grpRtr,"false")){
                    String nbOfTxs=grpHdr.getNbOfTxs();
                    if(!JudgeUtils.equals(nbOfTxs,"Number Occurrences TransactionInformation")){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C14_ERROR_CODE, Pacs00400110ErrorConstant.C14_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

//    If GroupHeader/GroupReturn is true, then OriginalGroupInformation/ReturnReasonInformation/
//    ReturnReason must be present. (CrossElementComplexRule)
//    On
    public Constraints checkC15() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            OriginalGroupHeader18 orgnlGrpInf=paymentReturnV11.getOrgnlGrpInf();
            if (JudgeUtils.isNotNull(grpHdr)&&JudgeUtils.isNotNull(orgnlGrpInf)) {
                List<PaymentReturnReason6> rtrRsnInf=orgnlGrpInf.getRtrRsnInf();
                Boolean grpRtr=grpHdr.isGrpRtr();
                if(grpRtr){
                    for(PaymentReturnReason6 paymentReturnReason6:rtrRsnInf){
                        ReturnReason5Choice rsn=paymentReturnReason6.getRsn();
                        if(!JudgeUtils.isNotNull(rsn)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C15_ERROR_CODE, Pacs00400110ErrorConstant.C15_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

//    If GroupHeader/GroupReturn is true,
//    then TransactionInformation is not allowed. (CrossElementComplexRule)
    public Constraints checkC16() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf= paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(grpHdr)){
                Boolean grpRtr=grpHdr.isGrpRtr();
                if(grpRtr){
                    if(JudgeUtils.isNotNull(txInf)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C16_ERROR_CODE, Pacs00400110ErrorConstant.C16_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC17() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf= paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(grpHdr)){
                Boolean grpRtr=grpHdr.isGrpRtr();
                if(!grpRtr){
                    if(!JudgeUtils.isNotNull(txInf)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C17_ERROR_CODE, Pacs00400110ErrorConstant.C17_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC12() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            Optional<PaymentReturnV11> paymentReturnV111 = Optional.of(paymentReturnV11);
            Optional<XMLGregorianCalendar> xmlGregorianCalendar = paymentReturnV111.map(PaymentReturnV11::getGrpHdr)
                    .map(GroupHeader99::getIntrBkSttlmDt);
            if (xmlGregorianCalendar.isPresent()) {
                List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
                for (PaymentTransaction133 paymentTransaction133 : txInf) {
                    XMLGregorianCalendar intrBkSttlmDt = paymentTransaction133.getIntrBkSttlmDt();
                    if (xmlGregorianCalendar.isPresent()) {
                        if (JudgeUtils.isNotNull(intrBkSttlmDt)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C12_ERROR_CODE, Pacs00400110ErrorConstant.C12_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC19() {
        //无错误信息
        return null;
    }

    public Constraints checkC20() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if(JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                SettlementInstruction11 sttlmInf = grpHdr.getSttlmInf();
                if (JudgeUtils.isNotNull(sttlmInf)) {
                    CashAccount40 sttlmAcct = sttlmInf.getSttlmAcct();
                    if(JudgeUtils.isNotNull(sttlmAcct)){
                        ProxyAccountIdentification1 prxy=sttlmAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=sttlmAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                    if(JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)){
                        ProxyAccountIdentification1 prxy=instgRmbrsmntAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=instgRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                    if(JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)){
                        ProxyAccountIdentification1 prxy=instdRmbrsmntAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=instdRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                    if(JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)){
                        ProxyAccountIdentification1 prxy=thrdRmbrsmntAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=thrdRmbrsmntAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }

                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 dbtrAcct=rtrChain.getDbtrAcct();
                    if(JudgeUtils.isNotNull(dbtrAcct)){
                        ProxyAccountIdentification1 prxy=dbtrAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=dbtrAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 dbtrAgtAcct=rtrChain.getDbtrAgtAcct();
                    if(JudgeUtils.isNotNull(dbtrAgtAcct)){
                        ProxyAccountIdentification1 prxy=dbtrAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=dbtrAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 prvsInstgAgt1Acct=rtrChain.getPrvsInstgAgt1Acct();
                    if(JudgeUtils.isNotNull(prvsInstgAgt1Acct)){
                        ProxyAccountIdentification1 prxy=prvsInstgAgt1Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt1Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 prvsInstgAgt2Acct=rtrChain.getPrvsInstgAgt2Acct();
                    if(JudgeUtils.isNotNull(prvsInstgAgt2Acct)){
                        ProxyAccountIdentification1 prxy=prvsInstgAgt2Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt2Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 prvsInstgAgt3Acct=rtrChain.getPrvsInstgAgt3Acct();
                    if(JudgeUtils.isNotNull(prvsInstgAgt3Acct)){
                        ProxyAccountIdentification1 prxy=prvsInstgAgt3Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt3Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt1Acct=rtrChain.getIntrmyAgt1Acct();
                    if(JudgeUtils.isNotNull(intrmyAgt1Acct)){
                        ProxyAccountIdentification1 prxy=intrmyAgt1Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=intrmyAgt1Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt2Acct=rtrChain.getIntrmyAgt2Acct();
                    if(JudgeUtils.isNotNull(intrmyAgt2Acct)){
                        ProxyAccountIdentification1 prxy=intrmyAgt2Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=intrmyAgt2Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 intrmyAgt3Acct=rtrChain.getIntrmyAgt3Acct();
                    if(JudgeUtils.isNotNull(intrmyAgt3Acct)){
                        ProxyAccountIdentification1 prxy=intrmyAgt3Acct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=intrmyAgt3Acct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAgtAcct=rtrChain.getCdtrAgtAcct();
                    if(JudgeUtils.isNotNull(cdtrAgtAcct)){
                        ProxyAccountIdentification1 prxy=cdtrAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=cdtrAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAcct=rtrChain.getCdtrAcct();
                    if(JudgeUtils.isNotNull(cdtrAcct)){
                        ProxyAccountIdentification1 prxy=cdtrAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=cdtrAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                }
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    SettlementInstruction11 sttlmInf=orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                        if(JudgeUtils.isNotNull(sttlmAcct)){
                            ProxyAccountIdentification1 prxy=sttlmAcct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=sttlmAcct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                        if(JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)){
                            ProxyAccountIdentification1 prxy=instgRmbrsmntAgtAcct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=instgRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                        if(JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)){
                            ProxyAccountIdentification1 prxy=instdRmbrsmntAgtAcct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=instdRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                        if(JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)){
                            ProxyAccountIdentification1 prxy=thrdRmbrsmntAgtAcct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=thrdRmbrsmntAgtAcct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                    }
                    MandateRelatedData2Choice mndtRltdInf=orgnlTxRef.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mndtRltdInf)) {
                        MandateRelatedInformation15 drctDbtMndt = mndtRltdInf.getDrctDbtMndt();
                        if(JudgeUtils.isNotNull(drctDbtMndt.getFnlColltnDt())) {
                            AmendmentInformationDetails14 amdmntInfDtls = drctDbtMndt.getAmdmntInfDtls();
                            if(JudgeUtils.isNotNull(amdmntInfDtls)) {
                                CashAccount40 orgnlCdtrAgtAcct = amdmntInfDtls.getOrgnlCdtrAgtAcct();
                                if(JudgeUtils.isNotNull(orgnlCdtrAgtAcct)){
                                    ProxyAccountIdentification1 prxy=orgnlCdtrAgtAcct.getPrxy();
                                    AccountIdentification4Choice accountIdentification4Choice=orgnlCdtrAgtAcct.getId();
                                    if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                                    }
                                }
                                CashAccount40 orgnlDbtrAcct = amdmntInfDtls.getOrgnlDbtrAcct();
                                if(JudgeUtils.isNotNull(orgnlDbtrAcct)){
                                    ProxyAccountIdentification1 prxy=orgnlDbtrAcct.getPrxy();
                                    AccountIdentification4Choice accountIdentification4Choice=orgnlDbtrAcct.getId();
                                    if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                                    }
                                }
                                CashAccount40 orgnlDbtrAgtAcct = amdmntInfDtls.getOrgnlDbtrAgtAcct();
                                if(JudgeUtils.isNotNull(orgnlDbtrAgtAcct)){
                                    ProxyAccountIdentification1 prxy=orgnlDbtrAgtAcct.getPrxy();
                                    AccountIdentification4Choice accountIdentification4Choice=orgnlDbtrAgtAcct.getId();
                                    if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                                    }
                                }
                            }
                        }
                    }
                    CashAccount40 dbtrAcct=orgnlTxRef.getDbtrAcct();
                    if(JudgeUtils.isNotNull(dbtrAcct)){
                        ProxyAccountIdentification1 prxy=dbtrAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=dbtrAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 dbtrAgtAcct=orgnlTxRef.getDbtrAgtAcct();
                    if(JudgeUtils.isNotNull(dbtrAgtAcct)){
                        ProxyAccountIdentification1 prxy=dbtrAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=dbtrAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAgtAcct=orgnlTxRef.getCdtrAgtAcct();
                    if(JudgeUtils.isNotNull(cdtrAgtAcct)){
                        ProxyAccountIdentification1 prxy=cdtrAgtAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=cdtrAgtAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CashAccount40 cdtrAcct=orgnlTxRef.getCdtrAcct();
                    if(JudgeUtils.isNotNull(cdtrAcct)){
                        ProxyAccountIdentification1 prxy=cdtrAcct.getPrxy();
                        AccountIdentification4Choice accountIdentification4Choice=cdtrAcct.getId();
                        if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                    CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                    if(JudgeUtils.isNotNull(undrlygCstmrCdtTrf)){
                        CashAccount40 dbtrAcct1=undrlygCstmrCdtTrf.getDbtrAcct();
                        if(JudgeUtils.isNotNull(dbtrAcct1)){
                            ProxyAccountIdentification1 prxy=dbtrAcct1.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=dbtrAcct1.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 dbtrAgtAcct1=undrlygCstmrCdtTrf.getDbtrAgtAcct();
                        if(JudgeUtils.isNotNull(dbtrAgtAcct1)){
                            ProxyAccountIdentification1 prxy=dbtrAgtAcct1.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=dbtrAgtAcct1.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 prvsInstgAgt1Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt1Acct();
                        if(JudgeUtils.isNotNull(prvsInstgAgt1Acct)){
                            ProxyAccountIdentification1 prxy=prvsInstgAgt1Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt1Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 prvsInstgAgt2Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt2Acct();
                        if(JudgeUtils.isNotNull(prvsInstgAgt2Acct)){
                            ProxyAccountIdentification1 prxy=prvsInstgAgt2Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt2Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 prvsInstgAgt3Acct=undrlygCstmrCdtTrf.getPrvsInstgAgt3Acct();
                        if(JudgeUtils.isNotNull(prvsInstgAgt3Acct)){
                            ProxyAccountIdentification1 prxy=prvsInstgAgt3Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=prvsInstgAgt3Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 intrmyAgt1Acct=undrlygCstmrCdtTrf.getIntrmyAgt1Acct();
                        if(JudgeUtils.isNotNull(intrmyAgt1Acct)){
                            ProxyAccountIdentification1 prxy=intrmyAgt1Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=intrmyAgt1Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 intrmyAgt2Acct=undrlygCstmrCdtTrf.getIntrmyAgt2Acct();
                        if(JudgeUtils.isNotNull(intrmyAgt2Acct)){
                            ProxyAccountIdentification1 prxy=intrmyAgt2Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=intrmyAgt2Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 intrmyAgt3Acct=undrlygCstmrCdtTrf.getIntrmyAgt3Acct();
                        if(JudgeUtils.isNotNull(intrmyAgt3Acct)){
                            ProxyAccountIdentification1 prxy=intrmyAgt3Acct.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=intrmyAgt3Acct.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 cdtrAgtAcct1=undrlygCstmrCdtTrf.getCdtrAgtAcct();
                        if(JudgeUtils.isNotNull(cdtrAgtAcct1)){
                            ProxyAccountIdentification1 prxy=cdtrAgtAcct1.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=cdtrAgtAcct1.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                        CashAccount40 cdtrAcct1 =undrlygCstmrCdtTrf.getCdtrAcct();
                        if(JudgeUtils.isNotNull(cdtrAcct1)){
                            ProxyAccountIdentification1 prxy=cdtrAcct1.getPrxy();
                            AccountIdentification4Choice accountIdentification4Choice=cdtrAcct1.getId();
                            if (JudgeUtils.isNull(prxy) && JudgeUtils.isNull(accountIdentification4Choice)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C20_ERROR_CODE, Pacs00400110ErrorConstant.C20_ERROR_TEXT);
                            }
                        }
                    }
                }

            }
        }
        return null;
    }

    public Constraints checkC21() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf= paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(grpHdr)){
                BranchAndFinancialInstitutionIdentification6 instdAgt=grpHdr.getInstdAgt();
                if(JudgeUtils.isNotNull(instdAgt)){
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        BranchAndFinancialInstitutionIdentification6 instdAgt1=paymentTransaction133.getInstdAgt();
                        if(JudgeUtils.isNotNull(instdAgt1)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C21_ERROR_CODE, Pacs00400110ErrorConstant.C21_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC22() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    CashAccount40 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)&&JudgeUtils.isNull(instdRmbrsmntAgt)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C22_ERROR_CODE, Pacs00400110ErrorConstant.C22_ERROR_TEXT);
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount40 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)&&JudgeUtils.isNull(instdRmbrsmntAgt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C22_ERROR_CODE, Pacs00400110ErrorConstant.C22_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC23() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf= paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(grpHdr)){
                BranchAndFinancialInstitutionIdentification6 instgAgt=grpHdr.getInstgAgt();
                if(JudgeUtils.isNotNull(instgAgt)){
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        BranchAndFinancialInstitutionIdentification6 instgAgt1=paymentTransaction133.getInstgAgt();
                        if(JudgeUtils.isNotNull(instgAgt1)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C23_ERROR_CODE, Pacs00400110ErrorConstant.C23_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC24() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)&&JudgeUtils.isNull(instgRmbrsmntAgt)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C24_ERROR_CODE, Pacs00400110ErrorConstant.C24_ERROR_TEXT);
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount40 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)&&JudgeUtils.isNull(instgRmbrsmntAgt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C24_ERROR_CODE, Pacs00400110ErrorConstant.C24_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }


    public Constraints checkC25() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt1Acct=rtrChain.getIntrmyAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1=rtrChain.getIntrmyAgt1();
                    if(JudgeUtils.isNotNull(intrmyAgt1Acct)&&JudgeUtils.isNull(intrmyAgt1)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C25_ERROR_CODE, Pacs00400110ErrorConstant.C25_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }


    public Constraints checkC26() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt1Acct=rtrChain.getIntrmyAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1=rtrChain.getIntrmyAgt1();
                    if(JudgeUtils.isNotNull(intrmyAgt1Acct)&&JudgeUtils.isNull(intrmyAgt1)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C26_ERROR_CODE, Pacs00400110ErrorConstant.C26_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC27() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt2Acct=rtrChain.getIntrmyAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2=rtrChain.getIntrmyAgt2();
                    if(JudgeUtils.isNotNull(intrmyAgt2Acct)&&JudgeUtils.isNull(intrmyAgt2)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C27_ERROR_CODE, Pacs00400110ErrorConstant.C27_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC28() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt2Acct=rtrChain.getIntrmyAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2=rtrChain.getIntrmyAgt2();
                    if(JudgeUtils.isNotNull(intrmyAgt2Acct)&&JudgeUtils.isNull(intrmyAgt2)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C28_ERROR_CODE, Pacs00400110ErrorConstant.C28_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC29() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2=rtrChain.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt1=rtrChain.getIntrmyAgt1();
                    if(JudgeUtils.isNotNull(intrmyAgt2)&&JudgeUtils.isNull(intrmyAgt1)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C29_ERROR_CODE, Pacs00400110ErrorConstant.C29_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC30() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt3Acct=rtrChain.getIntrmyAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3=rtrChain.getIntrmyAgt3();
                    if(JudgeUtils.isNotNull(intrmyAgt3Acct)&&JudgeUtils.isNull(intrmyAgt3)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C30_ERROR_CODE, Pacs00400110ErrorConstant.C30_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC31() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 intrmyAgt3Acct=rtrChain.getIntrmyAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3=rtrChain.getIntrmyAgt3();
                    if(JudgeUtils.isNotNull(intrmyAgt3Acct)&&JudgeUtils.isNull(intrmyAgt3)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C31_ERROR_CODE, Pacs00400110ErrorConstant.C31_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC32() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt3=rtrChain.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification6 intrmyAgt2=rtrChain.getIntrmyAgt2();
                    if(JudgeUtils.isNotNull(intrmyAgt3)&&JudgeUtils.isNull(intrmyAgt2)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C32_ERROR_CODE, Pacs00400110ErrorConstant.C32_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC33() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            OriginalGroupHeader18 orgnlGrpInf=paymentReturnV11.getOrgnlGrpInf();
            if(JudgeUtils.isNotNull(grpHdr)&&JudgeUtils.isNotNull(orgnlGrpInf)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String name=sttlmMtd.name();
                        if(JudgeUtils.equals(name,"CoverMethod")) {
                            String orgnlMsgNmId = orgnlGrpInf.getOrgnlMsgNmId();
                            orgnlMsgNmId = orgnlMsgNmId.substring(1, 8);
                            if (JudgeUtils.equals(orgnlMsgNmId, "pacs.003")) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C33_ERROR_CODE, Pacs00400110ErrorConstant.C33_ERROR_TEXT);
                            }
                        }
                    }
                }

            }

        }
        return null;
    }

    public Constraints checkC34() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            OriginalGroupHeader18 orgnlGrpInf = paymentReturnV11.getOrgnlGrpInf();
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(orgnlGrpInf)){
                if(JudgeUtils.isNotNull(txInf)){
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        OriginalGroupInformation29 orgnlGrpInf1= paymentTransaction133.getOrgnlGrpInf();
                        if(JudgeUtils.isNotNull(orgnlGrpInf1)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C34_ERROR_CODE, Pacs00400110ErrorConstant.C34_ERROR_TEXT);
                        }
                    }
                }
            }

        }
        return null;
    }

    public Constraints checkC35() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            if(JudgeUtils.isNotNull(grpHdr)){
                PaymentTypeInformation28 pmtTpInf=grpHdr.getPmtTpInf();
                if(JudgeUtils.isNotNull(pmtTpInf)&&JudgeUtils.isNotNull(txInf)){
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        PaymentTypeInformation28 pmtTpInf1=paymentTransaction133.getPmtTpInf();
                        if(JudgeUtils.isNotNull(pmtTpInf1)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C35_ERROR_CODE, Pacs00400110ErrorConstant.C35_ERROR_TEXT);
                        }
                    }
                }
            }

        }
        return null;
    }

    public Constraints checkC36() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt1Acct=rtrChain.getPrvsInstgAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1=rtrChain.getPrvsInstgAgt1();
                    if(JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt1)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C36_ERROR_CODE, Pacs00400110ErrorConstant.C36_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC37() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt1Acct=rtrChain.getPrvsInstgAgt1Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1=rtrChain.getPrvsInstgAgt1();
                    if(JudgeUtils.isNotNull(prvsInstgAgt1Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt1)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C37_ERROR_CODE, Pacs00400110ErrorConstant.C37_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC38() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf) {
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    CreditTransferTransaction52 undrlygCstmrCdtTrf=orgnlTxRef.getUndrlygCstmrCdtTrf();
                }
            }
            }
        return null;
    }

    public Constraints checkC39() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt2Acct=rtrChain.getPrvsInstgAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2=rtrChain.getPrvsInstgAgt2();
                    if(JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt2)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C39_ERROR_CODE, Pacs00400110ErrorConstant.C39_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC40() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt2Acct=rtrChain.getPrvsInstgAgt2Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2=rtrChain.getPrvsInstgAgt2();
                    if(JudgeUtils.isNotNull(prvsInstgAgt2Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt2)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C40_ERROR_CODE, Pacs00400110ErrorConstant.C40_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC41() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2=rtrChain.getPrvsInstgAgt2();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1=rtrChain.getPrvsInstgAgt1();
                    if(JudgeUtils.isNotNull(prvsInstgAgt2)) {
                        if (JudgeUtils.isNull(prvsInstgAgt1)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C41_ERROR_CODE, Pacs00400110ErrorConstant.C41_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC42() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt3Acct=rtrChain.getPrvsInstgAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3=rtrChain.getPrvsInstgAgt3();
                    if(JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt3)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C42_ERROR_CODE, Pacs00400110ErrorConstant.C42_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC43() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    CashAccount40 prvsInstgAgt3Acct=rtrChain.getPrvsInstgAgt3Acct();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3=rtrChain.getPrvsInstgAgt3();
                    if(JudgeUtils.isNotNull(prvsInstgAgt3Acct)) {
                        if (JudgeUtils.isNull(prvsInstgAgt3)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C43_ERROR_CODE, Pacs00400110ErrorConstant.C43_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC44() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                TransactionParties10 rtrChain= paymentTransaction133.getRtrChain();
                if(JudgeUtils.isNotNull(rtrChain)){
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3=rtrChain.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2=rtrChain.getPrvsInstgAgt2();
                    if(JudgeUtils.isNotNull(prvsInstgAgt3)) {
                        if (JudgeUtils.isNull(prvsInstgAgt2)) {
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C44_ERROR_CODE, Pacs00400110ErrorConstant.C44_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC45() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                ActiveOrHistoricCurrencyAndAmount rtrdInstdAmt=paymentTransaction133.getRtrdInstdAmt();
                ActiveCurrencyAndAmount rtrdIntrBkSttlmAmt=paymentTransaction133.getRtrdIntrBkSttlmAmt();
                BigDecimal xchgRate=paymentTransaction133.getXchgRate();
                if(JudgeUtils.isNotNull(rtrdInstdAmt)&&JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    String ccy=rtrdInstdAmt.getCcy();
                    String ccyBk=rtrdIntrBkSttlmAmt.getCcy();
                    if(!JudgeUtils.equals(ccy,ccyBk)){
                        if(JudgeUtils.isNull(xchgRate)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C45_ERROR_CODE, Pacs00400110ErrorConstant.C45_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return  null;
    }

    public Constraints checkC46() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                ActiveOrHistoricCurrencyAndAmount rtrdInstdAmt=paymentTransaction133.getRtrdInstdAmt();
                ActiveCurrencyAndAmount rtrdIntrBkSttlmAmt=paymentTransaction133.getRtrdIntrBkSttlmAmt();
                BigDecimal xchgRate=paymentTransaction133.getXchgRate();
                if(JudgeUtils.isNotNull(rtrdInstdAmt)&&JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    String ccy=rtrdInstdAmt.getCcy();
                    String ccyBk=rtrdIntrBkSttlmAmt.getCcy();
                    if(JudgeUtils.equals(ccy,ccyBk)){
                        if(JudgeUtils.isNotNull(xchgRate)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C46_ERROR_CODE, Pacs00400110ErrorConstant.C46_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return  null;
    }


    public Constraints checkC47() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            OriginalGroupHeader18 orgnlGrpInf=paymentReturnV11.getOrgnlGrpInf();
            if(JudgeUtils.isNotNull(orgnlGrpInf)){
                List<PaymentReturnReason6> rtrRsnInf=orgnlGrpInf.getRtrRsnInf();
                for(PaymentReturnReason6 paymentReturnReason6:rtrRsnInf){
                    ReturnReason5Choice rsn=paymentReturnReason6.getRsn();
                    List<String> addtlInf=paymentReturnReason6.getAddtlInf();
                    if(JudgeUtils.isNotNull(rsn)){
                        String code=rsn.getCd();
                        if(JudgeUtils.equals(code,"NARR")){
                            if(JudgeUtils.isNull(addtlInf)){
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C47_ERROR_CODE, Pacs00400110ErrorConstant.C47_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                List<PaymentReturnReason6> rtrRsnInf=paymentTransaction133.getRtrRsnInf();
                for(PaymentReturnReason6 paymentReturnReason6:rtrRsnInf){
                    ReturnReason5Choice rsn=paymentReturnReason6.getRsn();
                    List<String> addtlInf=paymentReturnReason6.getAddtlInf();
                    if(JudgeUtils.isNotNull(rsn)){
                        String code=rsn.getCd();
                        if(JudgeUtils.equals(code,"NARR")){
                            if(JudgeUtils.isNull(addtlInf)){
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C47_ERROR_CODE, Pacs00400110ErrorConstant.C47_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return  null;
    }

    public Constraints checkC48() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                    ClearingSystemIdentification3Choice clrSys=sttlmInf.getClrSys();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equalsAny(value,"INDA","INGA")){
                            if (JudgeUtils.isNotNull(clrSys) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C48_ERROR_CODE, Pacs00400110ErrorConstant.C48_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                        ClearingSystemIdentification3Choice clrSys=sttlmInf.getClrSys();
                        BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equalsAny(value,"INDA","INGA")){
                                if (JudgeUtils.isNotNull(clrSys) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C48_ERROR_CODE, Pacs00400110ErrorConstant.C48_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC49() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                    CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equals(value,"CLRG")){
                            if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C48_ERROR_CODE, Pacs00400110ErrorConstant.C37_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                        CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                        BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"CLRG")){
                                if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C48_ERROR_CODE, Pacs00400110ErrorConstant.C37_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC50() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equals(value,"COVE")){
                            if (JudgeUtils.isNull(instgRmbrsmntAgt)&&JudgeUtils.isNull(instdRmbrsmntAgt)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C50_ERROR_CODE, Pacs00400110ErrorConstant.C50_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                        BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"COVE")){
                                if (JudgeUtils.isNull(instgRmbrsmntAgt)&&JudgeUtils.isNull(instdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C50_ERROR_CODE, Pacs00400110ErrorConstant.C50_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC51() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                    CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                    ClearingSystemIdentification3Choice clrSys=sttlmInf.getClrSys();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equals(value,"COVE")){
                            if (JudgeUtils.isNotNull(sttlmAcct)||JudgeUtils.isNotNull(clrSys)) {
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C51_ERROR_CODE, Pacs00400110ErrorConstant.C51_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        SettlementMethod1Code sttlmMtd=sttlmInf.getSttlmMtd();
                        CashAccount40 sttlmAcct=sttlmInf.getSttlmAcct();
                        ClearingSystemIdentification3Choice clrSys=sttlmInf.getClrSys();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"COVE")){
                                if (JudgeUtils.isNotNull(sttlmAcct)||JudgeUtils.isNotNull(clrSys)) {
                                    return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C51_ERROR_CODE, Pacs00400110ErrorConstant.C51_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }


    public Constraints checkC54() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)){
                        if(JudgeUtils.isNull(thrdRmbrsmntAgt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C54_ERROR_CODE, Pacs00400110ErrorConstant.C54_ERROR_TEXT);
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        CashAccount40 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)){
                            if(JudgeUtils.isNull(thrdRmbrsmntAgt)){
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C54_ERROR_CODE, Pacs00400110ErrorConstant.C54_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC55() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr=paymentReturnV11.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction11 sttlmInf=grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                    BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                    if(JudgeUtils.isNotNull(thrdRmbrsmntAgt)){
                        if(JudgeUtils.isNull(instgRmbrsmntAgt)||JudgeUtils.isNull(instdRmbrsmntAgt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C55_ERROR_CODE, Pacs00400110ErrorConstant.C55_ERROR_TEXT);
                        }
                    }
                }
            }
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            for(PaymentTransaction133 paymentTransaction133:txInf){
                OriginalTransactionReference36 orgnlTxRef=paymentTransaction133.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction11 sttlmInf = orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        BranchAndFinancialInstitutionIdentification6 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification6 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(thrdRmbrsmntAgt)){
                            if(JudgeUtils.isNull(instgRmbrsmntAgt)||JudgeUtils.isNull(instdRmbrsmntAgt)){
                                return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C55_ERROR_CODE, Pacs00400110ErrorConstant.C55_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC56() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlRtrdIntrBkSttlmAmt=grpHdr.getTtlRtrdIntrBkSttlmAmt();
                XMLGregorianCalendar intrBkSttlmDt=grpHdr.getIntrBkSttlmDt();
                if(JudgeUtils.isNotNull(ttlRtrdIntrBkSttlmAmt)){
                    if(JudgeUtils.isNull(intrBkSttlmDt)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C56_ERROR_CODE, Pacs00400110ErrorConstant.C56_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC57() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf=paymentReturnV11.getTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                ActiveCurrencyAndAmount ttlRtrdIntrBkSttlmAmt=grpHdr.getTtlRtrdIntrBkSttlmAmt();
                if(JudgeUtils.isNull(ttlRtrdIntrBkSttlmAmt)){
                    BigDecimal value=ttlRtrdIntrBkSttlmAmt.getValue();
                    BigDecimal sumValue=new BigDecimal(0);
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        ActiveCurrencyAndAmount rtrdIntrBkSttlmAmt=paymentTransaction133.getRtrdIntrBkSttlmAmt();
                        if(JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                            BigDecimal value1=rtrdIntrBkSttlmAmt.getValue();
                            sumValue.add(value1);
                        }
                    }
                    if(!JudgeUtils.equals(value,sumValue)){
                        return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C57_ERROR_CODE, Pacs00400110ErrorConstant.C57_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC58() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            if (JudgeUtils.isNotNull(grpHdr)&&JudgeUtils.isNotNull(txInf)) {
                ActiveCurrencyAndAmount ttlRtrdIntrBkSttlmAmt=grpHdr.getTtlRtrdIntrBkSttlmAmt();
                for(PaymentTransaction133 paymentTransaction133:txInf){
                    ActiveCurrencyAndAmount rtrdIntrBkSttlmAmt=paymentTransaction133.getRtrdIntrBkSttlmAmt();
                    if(JudgeUtils.isNotNull(ttlRtrdIntrBkSttlmAmt)&&JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                        String ccyTt=ttlRtrdIntrBkSttlmAmt.getCcy();
                        String ccyRt=rtrdIntrBkSttlmAmt.getCcy();
                        if(!JudgeUtils.equals(ccyRt,ccyTt)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C58_ERROR_CODE, Pacs00400110ErrorConstant.C58_ERROR_TEXT);

                        }
                    }
                }
            }
        }
        return null;
    }

    public Constraints checkC59() {
        PaymentReturnV11 paymentReturnV11 = this.getPmtRtr();
        if (JudgeUtils.isNotNull(paymentReturnV11)) {
            GroupHeader99 grpHdr = paymentReturnV11.getGrpHdr();
            List<PaymentTransaction133> txInf = paymentReturnV11.getTxInf();
            if (JudgeUtils.isNotNull(grpHdr)) {
                XMLGregorianCalendar intrBkSttlmDt = grpHdr.getIntrBkSttlmDt();
                if(JudgeUtils.isNull(intrBkSttlmDt)){
                    for(PaymentTransaction133 paymentTransaction133:txInf){
                        XMLGregorianCalendar intrBkSttlmDt1= paymentTransaction133.getIntrBkSttlmDt();
                        if(JudgeUtils.isNull(intrBkSttlmDt1)){
                            return new Constraints(Pacs00400110ErrorConstant.C_ERROR_SEVERITY, Pacs00400110ErrorConstant.C59_ERROR_CODE, Pacs00400110ErrorConstant.C59_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }



}



