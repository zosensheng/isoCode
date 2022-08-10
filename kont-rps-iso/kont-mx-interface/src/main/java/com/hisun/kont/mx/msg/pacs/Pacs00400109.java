//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.08.03 时间 03:59:36 PM CST 
//


package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.constant.Pacs00400109ErrorConstant;
import com.hisun.kont.mx.constant.Pacs00400109ErrorConstant;
import com.hisun.kont.mx.enums.ActiveCurrencyEnum;
import com.hisun.kont.mx.enums.ActiveOrHistoricCurrencyEnum;
import com.hisun.kont.mx.enums.CountryEnum;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.msg.pacs.pacs00400109.*;
import com.hisun.kont.mx.msg.pacs.pacs00400109.ActiveOrHistoricCurrencyAndAmount;
import com.hisun.kont.mx.msg.pacs.pacs00400109.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.pacs.pacs00400109.DiscountAmountAndType1;
import com.hisun.kont.mx.msg.pacs.pacs00400109.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.pacs.pacs00400109.OrganisationIdentification29;
import com.hisun.kont.mx.msg.pacs.pacs00400109.Party38Choice;
import com.hisun.kont.mx.msg.pacs.pacs00400109.PartyIdentification135;
import com.hisun.kont.mx.msg.pacs.pacs00400109.PostalAddress24;
import com.hisun.kont.mx.util.RuleUtils;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="PmtRtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09}PaymentReturnV09"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "pmtRtr"
})
@XmlRootElement(name = "Document", namespace = "urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09")
public class Pacs00400109 {

    @XmlElement(name = "PmtRtr", required = true)
    protected PaymentReturnV09 pmtRtr;

    /**
     * 获取pmtRtr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PaymentReturnV09 }
     *     
     */
    public PaymentReturnV09 getPmtRtr() {
        return pmtRtr;
    }

    /**
     * 设置pmtRtr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentReturnV09 }
     *     
     */
    public void setPmtRtr(PaymentReturnV09 value) {
        this.pmtRtr = value;
    }


    private static Constraints ruleC1(String str) {
        //正则表达式判断三个连续的字母
        boolean c1 = str.matches("^[a-zA-Z]{3}$");
        if (!c1) {
            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C1_ERROR_CODE, Pacs00400109ErrorConstant.C1_ERROR_TEXT, str);
        }
        ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
        ArrayList<String> ccyLists = new ArrayList<>();
        for (ActiveCurrencyEnum ccyValue : ccyValues) {
            ccyLists.add(ccyValue.getCurrencyCode());
        }
        if (!ccyLists.contains(str)) {
            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C1_ERROR_CODE, Pacs00400109ErrorConstant.C1_ERROR_TEXT, str);
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    /*
    C1   ActiveCurrency
    The currency code must be a valid active currency code, not yet withdrawn on the day the
    message containing the currency is exchanged. Valid active currency codes are registered
    with the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
    withdrawn on the day the message containing the Currency is exchanged
    */
    public Constraints checkC1() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 paymentTransaction1121 = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(paymentTransaction1121)) {
                List<Charges71> chrgsInf=paymentTransaction1121.getChrgsInf();
                for(Charges71 charges71:chrgsInf){
                    CBPRAmount1 amt=charges71.getAmt();
                    if (JudgeUtils.isNotNull(amt)) {
                        String ccy = amt.getCcy();
                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                            return ruleC1(ccy);
                        }
                    }
                }
                CBPRAmount1 rtrdIntrBkSttlmAmt=paymentTransaction1121.getRtrdIntrBkSttlmAmt();
                CBPRAmount1 rtrdInstdAmt=paymentTransaction1121.getRtrdInstdAmt();
                if(JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    if (JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)) {
                        String ccy = rtrdIntrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                            return ruleC1(ccy);
                        }
                    }
                }
                if(JudgeUtils.isNotNull(rtrdInstdAmt)){
                    if (JudgeUtils.isNotNull(rtrdInstdAmt)) {
                        String ccy = rtrdInstdAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                            return ruleC1(ccy);
                        }
                    }
                }
                OriginalTransactionReference281 orgnlTxRef=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    CBPRAmount1 intrBkSttlmAmt=orgnlTxRef.getIntrBkSttlmAmt();
                    if(JudgeUtils.isNotNull(intrBkSttlmAmt)){
                        if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            String ccy = intrBkSttlmAmt.getCcy();
                            if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                return ruleC1(ccy);
                            }
                        }
                    }
                    AmountType4Choice1 amt= orgnlTxRef.getAmt();
                    if(JudgeUtils.isNotNull(amt)){
                        CBPRAmount1 instdAmt=amt.getInstdAmt();
                        if(JudgeUtils.isNotNull(instdAmt)){
                            if (JudgeUtils.isNotNull(instdAmt)) {
                                String ccy = instdAmt.getCcy();
                                if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                                    return ruleC1(ccy);
                                }
                            }
                        }
                        EquivalentAmount21 eqvtAmt=amt.getEqvtAmt();
                        if(JudgeUtils.isNotNull(eqvtAmt)){
                            CBPRAmount1 amt1=eqvtAmt.getAmt();
                            if(JudgeUtils.isNotNull(amt1)){
                                if (JudgeUtils.isNotNull(amt1)) {
                                    String ccy = amt1.getCcy();
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
        return null;
    }



    //C2 ActiveOrHistoricCurrency  无标签
    private static Constraints ruleC2(String str) {
        //通过正则表达式判断
        boolean c2 = str.matches("^[a-zA-Z]{3}$");
        if (!c2) {
            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C2_ERROR_CODE, Pacs00400109ErrorConstant.C2_ERROR_TEXT, str);
        }
        ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
        ArrayList<String> ccyLists = new ArrayList<>();
        for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
            ccyLists.add(ccyValue.getCurrencyCode());
        }
        if (!ccyLists.contains(str)) {
            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C2_ERROR_CODE, Pacs00400109ErrorConstant.C2_ERROR_TEXT, str);
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    public Constraints checkC2() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            GroupHeader901 grpHdr=paymentReturnV09.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction71 sttlmInf= grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    CashAccount381 sttlmAcct=sttlmInf.getSttlmAcct();
                    if(JudgeUtils.isNotNull(sttlmAcct)){
                        String ccy = sttlmAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccy).getErrorCode())) {
                                return ruleC2(ccy);
                            }
                        }
                    }
                }
            }
            PaymentTransaction1121 paymentTransaction1121 = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(paymentTransaction1121)) {
                CBPRAmount1 orgnlIntrBkSttlmAmt=paymentTransaction1121.getOrgnlIntrBkSttlmAmt();
                if(JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)){
                    if (JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)) {
                        String ccy = orgnlIntrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(ruleC1(ccy).getErrorCode())) {
                            return ruleC1(ccy);
                        }
                    }
                }
                OriginalTransactionReference281 orgnlTxRef= paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    CBPRAmount1 intrBkSttlmAmt=orgnlTxRef.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccyInt = intrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotSuccess(ruleC2(ccyInt).getErrorCode())) {
                            return ruleC2(ccyInt);
                        }
                    }
                    SettlementInstruction72 sttlmInf= orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        CashAccount382 sttlmAcct=sttlmInf.getSttlmAcct();
                        if (JudgeUtils.isNotNull(sttlmAcct)) {
                            String ccyStt = sttlmAcct.getCcy();
                            if (JudgeUtils.isNotNull(ccyStt)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyStt).getErrorCode())) {
                                    return ruleC2(ccyStt);
                                }
                            }
                        }
                        CashAccount382 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)) {
                            String ccyIns = instgRmbrsmntAgtAcct.getCcy();
                            if (JudgeUtils.isNotNull(ccyIns)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyIns).getErrorCode())) {
                                    return ruleC2(ccyIns);
                                }
                            }
                        }
                        CashAccount382 instdRmbrsmntAgtAcct=sttlmInf.getInstdRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)) {
                            String ccyIns = instdRmbrsmntAgtAcct.getCcy();
                            if (JudgeUtils.isNotNull(ccyIns)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyIns).getErrorCode())) {
                                    return ruleC2(ccyIns);
                                }
                            }
                        }
                        CashAccount382 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                        if (JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)) {
                            String ccyThr = thrdRmbrsmntAgtAcct.getCcy();
                            if (JudgeUtils.isNotNull(ccyThr)) {
                                if (JudgeUtils.isNotSuccess(ruleC2(ccyThr).getErrorCode())) {
                                    return ruleC2(ccyThr);
                                }
                            }
                        }
                    }
                    RemittanceInformation161 rmtInf = orgnlTxRef.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation161> strd = rmtInf.getStrd();
                        if (JudgeUtils.isNotNull(strd)) {
                            for (StructuredRemittanceInformation161 structuredRemittanceInformation161 : strd) {
                                List<ReferredDocumentInformation71> rfrdDocInf = structuredRemittanceInformation161.getRfrdDocInf();
                                if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                    for (ReferredDocumentInformation71 referredDocumentInformation71 : rfrdDocInf) {
                                        List<DocumentLineInformation11> lineDtls = referredDocumentInformation71.getLineDtls();
                                        if (JudgeUtils.isNotNull(lineDtls)) {
                                            for (DocumentLineInformation11 lineDtl : lineDtls) {
                                                RemittanceAmount31 amt = lineDtl.getAmt();
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
                                                    List<TaxAmountAndType11> taxAmt = amt.getTaxAmt();
                                                    if (JudgeUtils.isNotNull(taxAmt)) {
                                                        for (TaxAmountAndType11 taxAmountAndType11 : taxAmt) {
                                                            ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType11.getAmt();
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
                                                    List<DocumentAdjustment11> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                    if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                        for (DocumentAdjustment11 documentAdjustment1 : adjstmntAmtAndRsn) {
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
                                TaxInformation71 taxRmt = structuredRemittanceInformation161.getTaxRmt();
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
                                    List<TaxRecord21> rcrd = taxRmt.getRcrd();
                                    if (JudgeUtils.isNotNull(rcrd)) {
                                        for (TaxRecord21 taxRecord21 : rcrd) {
                                            TaxAmount2 taxAmt = taxRecord21.getTaxAmt();
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
                                                List<TaxRecordDetails2> dtls = taxAmt.getDtls();
                                                if (JudgeUtils.isNotNull(dtls)) {
                                                    for (TaxRecordDetails2 dtl : dtls) {
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
                    CashAccount381 dbtrAcct = orgnlTxRef.getDbtrAcct();
                    if (JudgeUtils.isNotNull(dbtrAcct)) {
                        String ccyDbt = dbtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyDbt)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                                return ruleC2(ccyDbt);
                            }
                        }
                    }
                    CashAccount381 dbtrAgtAcct = orgnlTxRef.getDbtrAgtAcct();
                    if (JudgeUtils.isNotNull(dbtrAgtAcct)) {
                        String ccyDbt = dbtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyDbt)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyDbt).getErrorCode())) {
                                return ruleC2(ccyDbt);
                            }
                        }
                    }
                    CashAccount381 cdtrAgtAcct = orgnlTxRef.getCdtrAgtAcct();
                    if (JudgeUtils.isNotNull(cdtrAgtAcct)) {
                        String ccyCdt = cdtrAgtAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyCdt)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                                return ruleC2(ccyCdt);
                            }
                        }
                    }
                    CashAccount381 cdtrAcct = orgnlTxRef.getCdtrAcct();
                    if (JudgeUtils.isNotNull(cdtrAcct)) {
                        String ccyCdt = cdtrAcct.getCcy();
                        if (JudgeUtils.isNotNull(ccyCdt)) {
                            if (JudgeUtils.isNotSuccess(ruleC2(ccyCdt).getErrorCode())) {
                                return ruleC2(ccyCdt);
                            }
                        }
                    }
                }
            }

        }
        return null;
    }


    //C3 AmendmentIndicatorFalseRule
    public Constraints checkC3() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 paymentTransaction1121=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                OriginalTransactionReference281 originalTransactionReference281=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(originalTransactionReference281)){
                    MandateRelatedInformation14 mandateRelatedInformation14=originalTransactionReference281.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mandateRelatedInformation14)){
                        Boolean amdmntInd=mandateRelatedInformation14.isAmdmntInd();
                        if(!amdmntInd){
                            AmendmentInformationDetails13 amdmntInfDtls= mandateRelatedInformation14.getAmdmntInfDtls();
                            if(JudgeUtils.isNotNull(amdmntInfDtls)){
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C3_ERROR_CODE, Pacs00400109ErrorConstant.C3_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C4 AmendmentIndicatorTrueRule
    public Constraints checkC4() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 paymentTransaction1121=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                OriginalTransactionReference281 originalTransactionReference281=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(originalTransactionReference281)){
                    MandateRelatedInformation14 mandateRelatedInformation14=originalTransactionReference281.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mandateRelatedInformation14)){
                        Boolean amdmntInd=mandateRelatedInformation14.isAmdmntInd();
                        if(amdmntInd){
                            AmendmentInformationDetails13 amdmntInfDtls= mandateRelatedInformation14.getAmdmntInfDtls();
                            if(JudgeUtils.isNull(amdmntInfDtls)){
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C4_ERROR_CODE, Pacs00400109ErrorConstant.C4_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static Constraints ruleAnyBIC(PartyIdentification135 partyIdentification135) {
        if (JudgeUtils.isNotNull(partyIdentification135)) {
            Party38Choice id = partyIdentification135.getId();
            if (JudgeUtils.isNotNull(id)) {
                OrganisationIdentification29 orgId = id.getOrgId();
                if (JudgeUtils.isNotNull(orgId)) {
                    String anyBIC = orgId.getAnyBIC();
                    if (JudgeUtils.isNotNull(anyBIC)) {
                        //通过正则表达式进行匹配
                        boolean c3 = anyBIC.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
                        if (!c3) {
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C5_ERROR_CODE, Pacs00400109ErrorConstant.C5_ERROR_TEXT, anyBIC);
                        }

                    }
                }
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    //C5 AnyBIC
    public Constraints checkC5() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 paymentTransaction1121=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                OriginalTransactionReference281 originalTransactionReference281=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(originalTransactionReference281)){
                    MandateRelatedInformation14 mandateRelatedInformation14=originalTransactionReference281.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mandateRelatedInformation14)){
                            AmendmentInformationDetails13 amdmntInfDtls= mandateRelatedInformation14.getAmdmntInfDtls();
                            if(JudgeUtils.isNotNull(amdmntInfDtls)){
                                PartyIdentification135 orgnlCdtrSchmeId=amdmntInfDtls.getOrgnlCdtrSchmeId();
                                PartyIdentification135 orgnlDbtr=amdmntInfDtls.getOrgnlDbtr();
                                if (JudgeUtils.isNotSuccess(ruleAnyBIC(orgnlCdtrSchmeId).getErrorCode())) {
                                    return ruleAnyBIC(orgnlCdtrSchmeId);
                                }
                                if (JudgeUtils.isNotSuccess(ruleAnyBIC(orgnlDbtr).getErrorCode())) {
                                    return ruleAnyBIC(orgnlDbtr);
                                }
                            }
                    }
                }
            }
        }
        return null;
    }


    public static Constraints ruleBICFI(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String bicfi = finInstnId.getBICFI();
                if (JudgeUtils.isNotNull(bicfi)) {
                    boolean c3 = bicfi.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
                    if (!c3) {
                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C6_ERROR_CODE, Pacs00400109ErrorConstant.C6_ERROR_TEXT, bicfi);
                    }
                }
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    //C6 BICFI
    public Constraints checkC6() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 paymentTransaction1121=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                OriginalTransactionReference281 originalTransactionReference281=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(originalTransactionReference281)){
                    MandateRelatedInformation14 mandateRelatedInformation14=originalTransactionReference281.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mandateRelatedInformation14)){
                        AmendmentInformationDetails13 amdmntInfDtls= mandateRelatedInformation14.getAmdmntInfDtls();
                        if(JudgeUtils.isNotNull(amdmntInfDtls)){
                            BranchAndFinancialInstitutionIdentification6 orgnlCdtrAgt=amdmntInfDtls.getOrgnlCdtrAgt();
                            BranchAndFinancialInstitutionIdentification6 orgnlDbtrAgt=amdmntInfDtls.getOrgnlDbtrAgt();
                            if (JudgeUtils.isNotSuccess(ruleBICFI(orgnlCdtrAgt).getErrorCode())) {
                                return ruleBICFI(orgnlCdtrAgt);
                            }
                            if (JudgeUtils.isNotSuccess(ruleBICFI(orgnlDbtrAgt).getErrorCode())) {
                                return ruleBICFI(orgnlDbtrAgt);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C7 ChargesInformationAndReturnedInstructedAmountRule
    public Constraints checkC7() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(txInf)) {
                List<Charges71> chrgsInf = txInf.getChrgsInf();
                CBPRAmount1 rtrdInstdAmt = txInf.getRtrdInstdAmt();
                if (JudgeUtils.isNotNull(chrgsInf) && JudgeUtils.isNull(rtrdInstdAmt)) {
                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                }
                OriginalTransactionReference281 orgnlTxRef = txInf.getOrgnlTxRef();
                if (JudgeUtils.isNull(orgnlTxRef)) {
                    AmountType4Choice1 amt = orgnlTxRef.getAmt();
                    if (JudgeUtils.isNotNull(amt)) {
                        CBPRAmount1 instdAmt = amt.getInstdAmt();
                        if (JudgeUtils.isNotNull(chrgsInf) && JudgeUtils.isNull(instdAmt)) {
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                        }
                    }
                    RemittanceInformation161 rmtInf = orgnlTxRef.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation161> strd = rmtInf.getStrd();
                        for (StructuredRemittanceInformation161 structuredRemittanceInformation161 : strd) {
                            RemittanceAmount21 rfrdDocAmt = structuredRemittanceInformation161.getRfrdDocAmt();
                            if (JudgeUtils.isNotNull(chrgsInf) && JudgeUtils.isNotNull(rfrdDocAmt)) {
                                ActiveOrHistoricCurrencyAndAmount duePyblAmt = rfrdDocAmt.getDuePyblAmt();
                                if (JudgeUtils.isNull(duePyblAmt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                }
                                ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = rfrdDocAmt.getCdtNoteAmt();
                                if (JudgeUtils.isNull(cdtNoteAmt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                }
                                List<DiscountAmountAndType11> dscntApldAmt = rfrdDocAmt.getDscntApldAmt();
                                for (DiscountAmountAndType11 discountAmountAndType11 : dscntApldAmt) {
                                    ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType11.getAmt();
                                    if (JudgeUtils.isNull(amt1)) {
                                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                List<TaxAmountAndType12> taxAmt = rfrdDocAmt.getTaxAmt();
                                for (TaxAmountAndType12 taxAmountAndType12 : taxAmt) {
                                    ActiveOrHistoricCurrencyAndAmount amt2 = taxAmountAndType12.getAmt();
                                    if (JudgeUtils.isNull(amt2)) {
                                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                List<DocumentAdjustment11> adjstmntAmtAndRsn = rfrdDocAmt.getAdjstmntAmtAndRsn();
                                for (DocumentAdjustment11 adjustment11 : adjstmntAmtAndRsn) {
                                    ActiveOrHistoricCurrencyAndAmount amt3 = adjustment11.getAmt();
                                    if (JudgeUtils.isNull(amt3)) {
                                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                    }
                                }
                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = rfrdDocAmt.getRmtdAmt();
                                if (JudgeUtils.isNull(rmtdAmt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                }
                            }
                            Garnishment31 grnshmtRmt = structuredRemittanceInformation161.getGrnshmtRmt();
                            if (JudgeUtils.isNotNull(grnshmtRmt)) {
                                ActiveOrHistoricCurrencyAndAmount rmtdAmt = grnshmtRmt.getRmtdAmt();
                                if (JudgeUtils.isNull(rmtdAmt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C7_ERROR_CODE, Pacs00400109ErrorConstant.C7_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C8 ControlSumAndGroupReturnRule  没有GroupReturn<GrpRtr> 和ControlSum<CtrlSum>
    public Constraints checkC8() {
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
                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C9_ERROR_CODE, Pacs00400109ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                    CountryEnum[] values = CountryEnum.values();
                    ArrayList<String> ctryLists = new ArrayList<>();
                    for (CountryEnum value : values) {
                        ctryLists.add(value.getCountryCode());
                    }
                    if (!ctryLists.contains(ctry)) {
                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C9_ERROR_CODE, Pacs00400109ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                }
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    private static Constraints ruleC9(PartyIdentification1355 partyIdentification1355) {
        if (JudgeUtils.isNotNull(partyIdentification1355)) {
            PostalAddress244 pstlAdr = partyIdentification1355.getPstlAdr();
            if (JudgeUtils.isNotNull(pstlAdr)) {
                String ctry = pstlAdr.getCtry();
                if (JudgeUtils.isNotNull(ctry)) {
                    //通过正则表达式判断
                    boolean c9 = ctry.matches("^[a-zA-Z]{2}$");
                    if (!c9) {
                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C9_ERROR_CODE, Pacs00400109ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                    CountryEnum[] values = CountryEnum.values();
                    ArrayList<String> ctryLists = new ArrayList<>();
                    for (CountryEnum value : values) {
                        ctryLists.add(value.getCountryCode());
                    }
                    if (!ctryLists.contains(ctry)) {
                        return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C9_ERROR_CODE, Pacs00400109ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                }
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    //C9 Country
    public Constraints checkC9() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 paymentTransaction1121=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                OriginalTransactionReference281 originalTransactionReference281=paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(originalTransactionReference281)){
                    MandateRelatedInformation14 mandateRelatedInformation14=originalTransactionReference281.getMndtRltdInf();
                    if(JudgeUtils.isNotNull(mandateRelatedInformation14)){
                        AmendmentInformationDetails13 amdmntInfDtls= mandateRelatedInformation14.getAmdmntInfDtls();
                        if(JudgeUtils.isNotNull(amdmntInfDtls)){
                            PartyIdentification135 orgnlCdtrSchmeId=amdmntInfDtls.getOrgnlCdtrSchmeId();
                            PartyIdentification135 orgnlDbtr=amdmntInfDtls.getOrgnlDbtr();
                            if (JudgeUtils.isNotSuccess(ruleC9(orgnlCdtrSchmeId).getErrorCode())) {
                                return ruleC9(orgnlCdtrSchmeId);
                            }
                            if (JudgeUtils.isNotSuccess(ruleC9(orgnlDbtr).getErrorCode())) {
                                return ruleC9(orgnlDbtr);
                            }
                        }
                    }
                    RemittanceInformation161 rmtInf = originalTransactionReference281.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation161> strd = rmtInf.getStrd();
                        for (StructuredRemittanceInformation161 structuredRemittanceInformation161 : strd) {
                            PartyIdentification1355 invcr = structuredRemittanceInformation161.getInvcr();
                            if (JudgeUtils.isNotSuccess(ruleC9(invcr).getErrorCode())) {
                                return ruleC9(invcr);
                            }
                            PartyIdentification1355 invcee = structuredRemittanceInformation161.getInvcee();
                            if (JudgeUtils.isNotSuccess(ruleC9(invcee).getErrorCode())) {
                                return ruleC9(invcee);
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
                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, bigS);
                }
                totalDigits = totalDigits - 1;
                fractionDigits = split[1].length();
            }
            if (totalDigits > 18 || fractionDigits > 5) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, bigS);
            }
        }
        if (JudgeUtils.isNotNull(ccy)) {
            //通过正则表达式判断
            boolean c10 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c10) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, ccy);
            }
            ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
            ArrayList<String> ccyLists = new ArrayList<>();
            for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
                ccyLists.add(ccyValue.getCurrencyCode());
            }
            if (!ccyLists.contains(ccy)) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, ccy);
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }


    //C10 CurrencyAmount
    public Constraints checkC10() {
        PaymentReturnV09 paymentReturnV09 = new PaymentReturnV09();
        if (JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 paymentTransaction1121 = paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(paymentTransaction1121)){
                CBPRAmount1 rtrdIntrBkSttlmAmt=paymentTransaction1121.getRtrdIntrBkSttlmAmt();
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
                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, bigS);
                }
                totalDigits = totalDigits - 1;
                fractionDigits = split[1].length();
            }
            if (totalDigits > 18 || fractionDigits > 5) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, bigS);
            }
        }
        if (JudgeUtils.isNotNull(ccy)) {
            //通过正则表达式判断
            boolean c10 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c10) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, ccy);
            }
            ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
            ArrayList<String> ccyLists = new ArrayList<>();
            for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
                ccyLists.add(ccyValue.getCurrencyCode());
            }
            if (!ccyLists.contains(ccy)) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C10_ERROR_CODE, Pacs00400109ErrorConstant.C10_ERROR_TEXT, ccy);
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    //  C11 CurrencyAmount
    public Constraints checkC11() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 paymentTransaction1121 = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(paymentTransaction1121)) {
                CBPRAmount1 orgnlIntrBkSttlmAmt=paymentTransaction1121.getOrgnlIntrBkSttlmAmt();
                if(JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)){
                    if (JudgeUtils.isNotNull(orgnlIntrBkSttlmAmt)) {
                        String ccy = orgnlIntrBkSttlmAmt.getCcy();
                        BigDecimal value = orgnlIntrBkSttlmAmt.getValue();
                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                            return ruleC11(ccy,value);
                        }
                    }
                }
                OriginalTransactionReference281 orgnlTxRef= paymentTransaction1121.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    CBPRAmount1 intrBkSttlmAmt=orgnlTxRef.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccy = intrBkSttlmAmt.getCcy();
                        BigDecimal value = intrBkSttlmAmt.getValue();
                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                            return ruleC11(ccy,value);
                        }
                    }
                    RemittanceInformation161 rmtInf = orgnlTxRef.getRmtInf();
                    if (JudgeUtils.isNotNull(rmtInf)) {
                        List<StructuredRemittanceInformation161> strd = rmtInf.getStrd();
                        if (JudgeUtils.isNotNull(strd)) {
                            for (StructuredRemittanceInformation161 structuredRemittanceInformation161 : strd) {
                                List<ReferredDocumentInformation71> rfrdDocInf = structuredRemittanceInformation161.getRfrdDocInf();
                                if (JudgeUtils.isNotNull(rfrdDocInf)) {
                                    for (ReferredDocumentInformation71 referredDocumentInformation71 : rfrdDocInf) {
                                        List<DocumentLineInformation11> lineDtls = referredDocumentInformation71.getLineDtls();
                                        if (JudgeUtils.isNotNull(lineDtls)) {
                                            for (DocumentLineInformation11 lineDtl : lineDtls) {
                                                RemittanceAmount31 amt = lineDtl.getAmt();
                                                if (JudgeUtils.isNotNull(amt)) {
                                                    ActiveOrHistoricCurrencyAndAmount duePyblAmt = amt.getDuePyblAmt();
                                                    if (JudgeUtils.isNotNull(duePyblAmt)) {
                                                        String ccy = duePyblAmt.getCcy();
                                                        BigDecimal value = duePyblAmt.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                            return ruleC11(ccy,value);
                                                        }
                                                    }
                                                    ActiveOrHistoricCurrencyAndAmount cdtNoteAmt = amt.getCdtNoteAmt();
                                                    if (JudgeUtils.isNotNull(cdtNoteAmt)) {
                                                        String ccy = cdtNoteAmt.getCcy();
                                                        BigDecimal value = cdtNoteAmt.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                            return ruleC11(ccy,value);
                                                        }
                                                    }
                                                    ActiveOrHistoricCurrencyAndAmount rmtdAmt = amt.getRmtdAmt();
                                                    if (JudgeUtils.isNotNull(rmtdAmt)) {
                                                        String ccy = rmtdAmt.getCcy();
                                                        BigDecimal value = rmtdAmt.getValue();
                                                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                            return ruleC11(ccy,value);
                                                        }
                                                    }
                                                    List<DiscountAmountAndType1> dscntApldAmt = amt.getDscntApldAmt();
                                                    if (JudgeUtils.isNotNull(dscntApldAmt)) {
                                                        for (DiscountAmountAndType1 discountAmountAndType1 : dscntApldAmt) {
                                                            ActiveOrHistoricCurrencyAndAmount amt1 = discountAmountAndType1.getAmt();
                                                            if (JudgeUtils.isNotNull(amt1)) {
                                                                String ccy = amt1.getCcy();
                                                                BigDecimal value = amt1.getValue();
                                                                if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                                    return ruleC11(ccy,value);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    List<TaxAmountAndType11> taxAmt = amt.getTaxAmt();
                                                    if (JudgeUtils.isNotNull(taxAmt)) {
                                                        for (TaxAmountAndType11 taxAmountAndType11 : taxAmt) {
                                                            ActiveOrHistoricCurrencyAndAmount amt1 = taxAmountAndType11.getAmt();
                                                            if (JudgeUtils.isNotNull(amt1)) {
                                                                String ccy = amt1.getCcy();
                                                                BigDecimal value = amt1.getValue();
                                                                if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                                    return ruleC11(ccy,value);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    List<DocumentAdjustment11> adjstmntAmtAndRsn = amt.getAdjstmntAmtAndRsn();
                                                    if (JudgeUtils.isNotNull(adjstmntAmtAndRsn)) {
                                                        for (DocumentAdjustment11 documentAdjustment1 : adjstmntAmtAndRsn) {
                                                            ActiveOrHistoricCurrencyAndAmount amt1 = documentAdjustment1.getAmt();
                                                            if (JudgeUtils.isNotNull(amt1)) {
                                                                String ccy = amt1.getCcy();
                                                                BigDecimal value = amt1.getValue();
                                                                if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                                    return ruleC11(ccy,value);
                                                                }
                                                            }

                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                TaxInformation71 taxRmt = structuredRemittanceInformation161.getTaxRmt();
                                if (JudgeUtils.isNotNull(taxRmt)) {
                                    ActiveOrHistoricCurrencyAndAmount ttlTaxblBaseAmt = taxRmt.getTtlTaxblBaseAmt();
                                    if (JudgeUtils.isNotNull(ttlTaxblBaseAmt)) {
                                        String ccy = ttlTaxblBaseAmt.getCcy();
                                        BigDecimal value = ttlTaxblBaseAmt.getValue();
                                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                            return ruleC11(ccy,value);
                                        }
                                    }
                                    ActiveOrHistoricCurrencyAndAmount ttlTaxAmt = taxRmt.getTtlTaxAmt();
                                    if (JudgeUtils.isNotNull(ttlTaxAmt)) {
                                        String ccy = ttlTaxAmt.getCcy();
                                        BigDecimal value = ttlTaxAmt.getValue();
                                        if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                            return ruleC11(ccy,value);
                                        }
                                    }
                                    List<TaxRecord21> rcrd = taxRmt.getRcrd();
                                    if (JudgeUtils.isNotNull(rcrd)) {
                                        for (TaxRecord21 taxRecord21 : rcrd) {
                                            TaxAmount2 taxAmt = taxRecord21.getTaxAmt();
                                            if (JudgeUtils.isNotNull(taxAmt)) {
                                                ActiveOrHistoricCurrencyAndAmount taxblBaseAmt = taxAmt.getTaxblBaseAmt();
                                                if (JudgeUtils.isNotNull(taxblBaseAmt)) {
                                                    String ccy = taxblBaseAmt.getCcy();
                                                    BigDecimal value = taxblBaseAmt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                        return ruleC11(ccy,value);
                                                    }
                                                }
                                                ActiveOrHistoricCurrencyAndAmount ttlAmt = taxAmt.getTtlAmt();
                                                if (JudgeUtils.isNotNull(ttlAmt)) {
                                                    String ccy = ttlAmt.getCcy();
                                                    BigDecimal value = ttlAmt.getValue();
                                                    if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                        return ruleC11(ccy,value);
                                                    }
                                                }
                                                List<TaxRecordDetails2> dtls = taxAmt.getDtls();
                                                if (JudgeUtils.isNotNull(dtls)) {
                                                    for (TaxRecordDetails2 dtl : dtls) {
                                                        ActiveOrHistoricCurrencyAndAmount amt = dtl.getAmt();
                                                        if (JudgeUtils.isNotNull(amt)) {
                                                            String ccy = amt.getCcy();
                                                            BigDecimal value = amt.getValue();
                                                            if (JudgeUtils.isNotSuccess(ruleC11(ccy,value).getErrorCode())) {
                                                                return ruleC11(ccy,value);
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



    //C12 GroupHeaderInterbankSettlementDateRule  没有标签InterbankSettlementDate<IntrBkSttlmDt>
    public Constraints checkC12() {
        return null;
    }

    //C13 GroupReturnAndNumberOfTransactionsGuideline  无错误信息
    public Constraints checkC13() {
        return null;
    }

    //C14 GroupReturnAndNumberOfTransactionsRule
    public Constraints checkC14() {
        return null;
    }

    //C15 GroupReturnAndReturnReasonRule
    public Constraints checkC15() {
        return null;
    }

    //C16 GroupReturnAndTransactionInformationNotPresentRule
    public Constraints checkC16() {
        return null;
    }

    //C17 GroupReturnAndTransactionInformationPresentRule
    public Constraints checkC17() {
        return null;
    }

    public static Constraints checkIBAN(String string) {
        if (JudgeUtils.isNotNull(string)) {
            boolean iban = string.matches("^[A-Z]{2}[0-9]{2}[a-zA-Z0-9]{1,30}$");

            if (!iban) {
                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C18_ERROR_CODE, Pacs00400109ErrorConstant.C18_ERROR_TEXT, string);
            }
        }
        return new Constraints(Pacs00400109ErrorConstant.SUCCESS_CODE);
    }

    //C18 IBAN
    public Constraints checkC18() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            GroupHeader901 grpHdr=paymentReturnV09.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction71 sttlmInf= grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    CashAccount381 sttlmAcct= sttlmInf.getSttlmAcct();
                    if(JudgeUtils.isNotNull(sttlmAcct)){
                        AccountIdentification4Choice1 id=sttlmAcct.getId();
                        if(JudgeUtils.isNotNull(id)){
                            String iban=id.getIBAN();
                            if (JudgeUtils.isNotSuccess(checkIBAN(iban).getErrorCode())) {
                                return checkIBAN(iban);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C19 InstructedAgentRule  无标签
    public Constraints checkC19() {
        return null;
    }

    //C20 InstructedReimbursementAgentAccountRule
    public Constraints checkC20() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(txInf)){
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    SettlementInstruction72 sttlmInf= orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        CashAccount382 instdRmbrsmntAgtAcct = sttlmInf.getInstdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(instdRmbrsmntAgtAcct)&&JudgeUtils.isNull(instdRmbrsmntAgt)){
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C20_ERROR_CODE, Pacs00400109ErrorConstant.C20_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    //C21 InstructingAgentRule  无标签
    public Constraints checkC21() {
        return null;
    }

    //C22 InstructingReimbursementAgentAccountRule
    public Constraints checkC22() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf=paymentReturnV09.getTxInf();
            if(JudgeUtils.isNotNull(txInf)){
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)){
                    SettlementInstruction72 sttlmInf= orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        CashAccount382 instgRmbrsmntAgtAcct=sttlmInf.getInstgRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(instgRmbrsmntAgtAcct)&&JudgeUtils.isNull(instgRmbrsmntAgt)){
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C22_ERROR_CODE, Pacs00400109ErrorConstant.C22_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    //C23 NoCoverSettlementMethodRule  无错误信息
    public Constraints checkC23() {
        return null;
    }

    //C24 OriginalGroupInformationRule  无标签
    public Constraints checkC24() {
        return null;
    }

    //C25 ReturnedInstructedAmountAndExchangeRate1Rule
    public Constraints checkC25() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                CBPRAmount1 rtrdInstdAmt = txInf.getRtrdInstdAmt();
                CBPRAmount1 rtrdIntrBkSttlmAmt = txInf.getRtrdIntrBkSttlmAmt();
                BigDecimal xchgRate = txInf.getXchgRate();
                if(JudgeUtils.isNotNull(rtrdInstdAmt)&&JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    String ccy=rtrdInstdAmt.getCcy();
                    String ccyBk=rtrdIntrBkSttlmAmt.getCcy();
                    if(!JudgeUtils.equals(ccy,ccyBk)){
                        if(JudgeUtils.isNull(xchgRate)){
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C25_ERROR_CODE, Pacs00400109ErrorConstant.C25_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    //C26 ReturnedInstructedAmountAndExchangeRate2Rule
    public Constraints checkC26() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                CBPRAmount1 rtrdInstdAmt = txInf.getRtrdInstdAmt();
                CBPRAmount1 rtrdIntrBkSttlmAmt = txInf.getRtrdIntrBkSttlmAmt();
                BigDecimal xchgRate = txInf.getXchgRate();
                if(JudgeUtils.isNotNull(rtrdInstdAmt)&&JudgeUtils.isNotNull(rtrdIntrBkSttlmAmt)){
                    String ccy=rtrdInstdAmt.getCcy();
                    String ccyBk=rtrdIntrBkSttlmAmt.getCcy();
                    if(JudgeUtils.equals(ccy,ccyBk)){
                        if(JudgeUtils.isNotNull(xchgRate)){
                            return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C26_ERROR_CODE, Pacs00400109ErrorConstant.C26_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    //C27 ReturnReasonRule
    public Constraints checkC27() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)) {
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                PaymentReturnReason61 rtrRsnInf=txInf.getRtrRsnInf();
                if(JudgeUtils.isNotNull(rtrRsnInf)){
                    ReturnReason5Choice1 rsn=rtrRsnInf.getRsn();
                    List<String> addtlInf=rtrRsnInf.getAddtlInf();
                    if(JudgeUtils.isNotNull(rsn)){
                        String code=rsn.getCd();
                        if(JudgeUtils.equals(code,"NARR")){
                            if(JudgeUtils.isNull(addtlInf)){
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C27_ERROR_CODE, Pacs00400109ErrorConstant.C27_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C28 SettlementMethodAgentRule  无clrSys标签
    public Constraints checkC28() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code2 sttlmMtd=sttlmInf.getSttlmMtd();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equalsAny(value,"INDA","INGA")){
                                if ( JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C28_ERROR_CODE, Pacs00400109ErrorConstant.C28_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C29 SettlementMethodClearingRule
    public Constraints checkC29() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            GroupHeader901 grpHdr=paymentReturnV09.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction71 sttlmInf= grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code1 sttlmMtd=sttlmInf.getSttlmMtd();
                    CashAccount381 sttlmAcct=sttlmInf.getSttlmAcct();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equals(value,"CLRG")){
                            if (JudgeUtils.isNotNull(sttlmAcct)) {
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C29_ERROR_CODE, Pacs00400109ErrorConstant.C29_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code2 sttlmMtd=sttlmInf.getSttlmMtd();
                        CashAccount382 sttlmAcct=sttlmInf.getSttlmAcct();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"CLRG")){
                                if (JudgeUtils.isNotNull(sttlmAcct) || JudgeUtils.isNotNull(instgRmbrsmntAgt) || JudgeUtils.isNotNull(instdRmbrsmntAgt) || JudgeUtils.isNotNull(thrdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C29_ERROR_CODE, Pacs00400109ErrorConstant.C29_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C30 SettlementMethodCoverAgentRule
    public Constraints checkC30() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code2 sttlmMtd=sttlmInf.getSttlmMtd();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"COVE")){
                                if (JudgeUtils.isNull(instgRmbrsmntAgt)&&JudgeUtils.isNull(instdRmbrsmntAgt)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C30_ERROR_CODE, Pacs00400109ErrorConstant.C30_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C31 SettlementMethodCoverRule
    public Constraints checkC31() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            GroupHeader901 grpHdr=paymentReturnV09.getGrpHdr();
            if(JudgeUtils.isNotNull(grpHdr)){
                SettlementInstruction71 sttlmInf= grpHdr.getSttlmInf();
                if(JudgeUtils.isNotNull(sttlmInf)){
                    SettlementMethod1Code1 sttlmMtd=sttlmInf.getSttlmMtd();
                    CashAccount381 sttlmAcct=sttlmInf.getSttlmAcct();
                    if(JudgeUtils.isNotNull(sttlmMtd)){
                        String value=sttlmMtd.value();
                        if(JudgeUtils.equals(value,"COVE")){
                            if (JudgeUtils.isNotNull(sttlmAcct)) {
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C31_ERROR_CODE, Pacs00400109ErrorConstant.C31_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        SettlementMethod1Code2 sttlmMtd=sttlmInf.getSttlmMtd();
                        CashAccount382 sttlmAcct=sttlmInf.getSttlmAcct();
                        if(JudgeUtils.isNotNull(sttlmMtd)){
                            String value=sttlmMtd.value();
                            if(JudgeUtils.equals(value,"COVE")){
                                if (JudgeUtils.isNotNull(sttlmAcct)) {
                                    return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C31_ERROR_CODE, Pacs00400109ErrorConstant.C31_ERROR_TEXT);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C32 SupplementaryDataRule  无错误信息
    public Constraints checkC32() {
        return null;
    }

    //C33 SupplementaryDataRule  无错误信息
    public Constraints checkC33() {
        return null;
    }


    //C34 ThirdReimbursementAgentAccountRule
    public Constraints checkC34() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        CashAccount382 thrdRmbrsmntAgtAcct=sttlmInf.getThrdRmbrsmntAgtAcct();
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(thrdRmbrsmntAgtAcct)){
                            if(JudgeUtils.isNull(thrdRmbrsmntAgt)){
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C34_ERROR_CODE, Pacs00400109ErrorConstant.C34_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C35 ThirdReimbursementAgentRule
    public Constraints checkC35() {
        PaymentReturnV09 paymentReturnV09=new PaymentReturnV09();
        if(JudgeUtils.isNotNull(paymentReturnV09)){
            PaymentTransaction1121 txInf = paymentReturnV09.getTxInf();
            if (JudgeUtils.isNotNull(txInf)) {
                OriginalTransactionReference281 orgnlTxRef=txInf.getOrgnlTxRef();
                if(JudgeUtils.isNotNull(orgnlTxRef)) {
                    SettlementInstruction72 sttlmInf = orgnlTxRef.getSttlmInf();
                    if(JudgeUtils.isNotNull(sttlmInf)){
                        BranchAndFinancialInstitutionIdentification61 thrdRmbrsmntAgt=sttlmInf.getThrdRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt=sttlmInf.getInstgRmbrsmntAgt();
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt=sttlmInf.getInstdRmbrsmntAgt();
                        if(JudgeUtils.isNotNull(thrdRmbrsmntAgt)){
                            if(JudgeUtils.isNull(instgRmbrsmntAgt)||JudgeUtils.isNull(instdRmbrsmntAgt)){
                                return new Constraints(Pacs00400109ErrorConstant.C_ERROR_SEVERITY, Pacs00400109ErrorConstant.C35_ERROR_CODE, Pacs00400109ErrorConstant.C35_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    //C36 TotalInterbankSettlementAmountAndDateRule  无标签
    public Constraints checkC36() {

        return null;
    }

    //C37 TotalReturnedInterbankSettlementAmountAndSumRule  无标签
    public Constraints checkC37() {
        return null;
    }

    //C38 TotalReturnedInterbankSettlementAmountRule  无标签
    public Constraints checkC38() {

        return null;
    }

    //C39 TransactionInterbankSettlementDateRule  无标签
    public Constraints checkC39() {

        return null;
    }

}
