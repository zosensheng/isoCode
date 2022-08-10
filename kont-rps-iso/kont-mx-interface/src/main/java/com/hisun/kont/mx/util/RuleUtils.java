package com.hisun.kont.mx.util;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;
import com.hisun.kont.mx.enums.CountryEnum;
import com.hisun.kont.mx.msg.pacs.dic.*;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/8/1 15:24
 */
public class RuleUtils {

    private static final String ActiveCurrency_ERROR_SEVERITY = "Fatal";
    private static final String ActiveCurrency_ERROR_CODE = "D00005";
    private static final String ActiveCurrency_ERROR_TEXT = "Invalid currency code.";

    private static final String ActiveOrHistoricCurrency_ERROR_SEVERITY = "Fatal";
    private static final String ActiveOrHistoricCurrency_ERROR_CODE = "D00006";
    private static final String ActiveOrHistoricCurrency_ERROR_TEXT = "Invalid currency code.";

    private static final String BICFI_ERROR_SEVERITY = "Fatal";
    private static final String BICFI_ERROR_CODE = "D00001";
    private static final String BICFI_ERROR_TEXT = "Invalid FI BIC.";

    private static final String AnyBIC_ERROR_SEVERITY = "Fatal";
    private static final String AnyBIC_ERROR_CODE = "D00008";
    private static final String AnyBIC_ERROR_TEXT = "Invalid BIC.";

    private static final String Country_ERROR_SEVERITY = "Fatal";
    private static final String Country_ERROR_CODE = "D00004";
    private static final String Country_ERROR_TEXT = "Invalid Country Code.";

    private static final String IdentificationOrProxyPresenceRule_ERROR_SEVERITY = "Fatal";
    private static final String IdentificationOrProxyPresenceRule_ERROR_CODE = "D00007";
    private static final String IdentificationOrProxyPresenceRule_ERROR_TEXT = "Invalid currency code or too many decimal digits.";

    private static final String IBAN_ERROR_SEVERITY = "Fatal";
    private static final String IBAN_ERROR_CODE = "D00003";
    private static final String IBAN_ERROR_TEXT = "Invalid IBAN format or invalid check digits.";

    /**
     * ActiveCurrency ✓
     * (Rule)
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered with
     * the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     * <p>
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回检查结果
     */
    public static Constraints checkActiveCurrency(String str) {
        //通过正则表达式判断
        boolean Ccy = str.matches("^[a-zA-Z]{3}$");
        if (!Ccy) {
            return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, str);
        }
//        ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
//        ArrayList<String> ccyLists = new ArrayList<>();
//        for (ActiveCurrencyEnum ccyValue : ccyValues) {
//            ccyLists.add(ccyValue.getCurrencyCode());
//        }
//        if (!ccyLists.contains(str)) {
//            return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, str);
//        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * ActiveCurrency ✓
     * (Rule)
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered with
     * the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     * <p>
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回检查结果
     */
    public static Constraints checkActiveCurrency(ActiveCurrencyAndAmount activeCurrencyAndAmount) {
        if (JudgeUtils.isNotNull(activeCurrencyAndAmount)) {
            String ccy = activeCurrencyAndAmount.getCcy();
            //通过正则表达式判断
            boolean c1 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c1) {
                return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, ccy);
            }
//            ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
//            ArrayList<String> ccyLists = new ArrayList<>();
//            for (ActiveCurrencyEnum ccyValue : ccyValues) {
//                ccyLists.add(ccyValue.getCurrencyCode());
//            }
//            if (!ccyLists.contains(ccy)) {
//                return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, ccy);
//            }
        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * ActiveOrHistoricCurrency ✓
     * (Rule)
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * <p>
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回检查结果
     */
    public static Constraints checkActiveOrHistoricCurrency(String str) {
        //通过正则表达式判断
        boolean Ccy = str.matches("^[a-zA-Z]{3}$");
        if (!Ccy) {
            return new Constraints(Pacs00800110ErrorConstant.C2_ERROR_SEVERITY, Pacs00800110ErrorConstant.C2_ERROR_CODE, Pacs00800110ErrorConstant.C2_ERROR_TEXT, str);
        }
//        ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
//        ArrayList<String> ccyLists = new ArrayList<>();
//        for (ActiveCurrencyEnum ccyValue : ccyValues) {
//            ccyLists.add(ccyValue.getCurrencyCode());
//        }
//        if (!ccyLists.contains(str)) {
//            return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, str);
//        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * ActiveOrHistoricCurrency ✓
     * (Rule)
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回检查结果
     */
    public static Constraints checkActiveOrHistoricCurrency(ActiveOrHistoricCurrencyAndAmount activeOrHistoricCurrencyAndAmount) {
        if (JudgeUtils.isNotNull(activeOrHistoricCurrencyAndAmount)) {
            String ccy = activeOrHistoricCurrencyAndAmount.getCcy();
            //通过正则表达式判断
            boolean c1 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c1) {
                return new Constraints(Pacs00800110ErrorConstant.C2_ERROR_SEVERITY, Pacs00800110ErrorConstant.C2_ERROR_CODE, Pacs00800110ErrorConstant.C2_ERROR_TEXT, ccy);
            }
//            ActiveCurrencyEnum[] ccyValues = ActiveCurrencyEnum.values();
//            ArrayList<String> ccyLists = new ArrayList<>();
//            for (ActiveCurrencyEnum ccyValue : ccyValues) {
//                ccyLists.add(ccyValue.getCurrencyCode());
//            }
//            if (!ccyLists.contains(ccy)) {
//                return new Constraints(Pacs00800110ErrorConstant.C1_ERROR_SEVERITY, Pacs00800110ErrorConstant.C1_ERROR_CODE, Pacs00800110ErrorConstant.C1_ERROR_TEXT, ccy);
//            }
        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * ActiveOrHistoricCurrency ✓
     * (Rule)
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回检查结果
     */
    public static Constraints checkActiveOrHistoricCurrency(CashAccount40 cashAccount40) {
        if (JudgeUtils.isNotNull(cashAccount40)) {
            String ccy = cashAccount40.getCcy();
            boolean c1 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c1) {
                return new Constraints(Pacs00800110ErrorConstant.C2_ERROR_SEVERITY, Pacs00800110ErrorConstant.C2_ERROR_CODE, Pacs00800110ErrorConstant.C2_ERROR_TEXT, ccy);
            }
        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }


    /**
     * BICFI ✓
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断规则 符合返回true 不符合返回false
     */
    public static Constraints checkBICFI(String str) {

        //通过正则表达式进行匹配
        boolean bicfi = str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");

        if (!bicfi) {
            return new Constraints(Pacs00800110ErrorConstant.C4_ERROR_SEVERITY, Pacs00800110ErrorConstant.C4_ERROR_CODE, Pacs00800110ErrorConstant.C4_ERROR_TEXT, str);
        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * BICFI ✓
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断规则 符合返回true 不符合返回false
     */
    public static Constraints checkBICFI(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String bicfi = finInstnId.getBICFI();
                if (JudgeUtils.isNotNull(bicfi)) {
                    boolean c3 = bicfi.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
                    if (!c3) {
                        return new Constraints(Pacs00800110ErrorConstant.C4_ERROR_SEVERITY, Pacs00800110ErrorConstant.C4_ERROR_CODE, Pacs00800110ErrorConstant.C4_ERROR_TEXT, bicfi);
                    }
                }
            }
        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * AnyBIC
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断规则 符合返回true 不符合返回false
     */
    public static Constraints checkAnyBIC(String str) {

        //通过正则表达式进行匹配
        boolean anyBic = str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");

        if (!anyBic) {
            return new Constraints(Pacs00800110ErrorConstant.C3_ERROR_SEVERITY, Pacs00800110ErrorConstant.C3_ERROR_CODE, Pacs00800110ErrorConstant.C3_ERROR_TEXT, str);
        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * AnyBIC
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断C4规则 符合返回true 不符合返回false
     */
    public static Constraints checkAnyBIC(PartyIdentification135 partyIdentification135) {
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
                            return new Constraints(Pacs00800110ErrorConstant.C3_ERROR_SEVERITY, Pacs00800110ErrorConstant.C3_ERROR_CODE, Pacs00800110ErrorConstant.C3_ERROR_TEXT, anyBIC);
                        }

                    }
                }
            }
        }


        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * Country
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     *
     * @return 判断规则
     */
    public static Constraints checkCountry(String str) {
        //通过正则表达式判断
        boolean country = str.matches("^[a-zA-Z]{2}$");
        if (!country) {
            return new Constraints(Pacs00800110ErrorConstant.C9_ERROR_SEVERITY, Pacs00800110ErrorConstant.C9_ERROR_CODE, Pacs00800110ErrorConstant.C9_ERROR_TEXT, str);
        }
//        CountryEnum[] values = CountryEnum.values();
//        ArrayList<String> ctryLists = new ArrayList<>();
//        for (CountryEnum value : values) {
//            ctryLists.add(value.getCountryCode());
//        }
//        if (!ctryLists.contains(str)) {
//            return new Constraints(Pacs00800110ErrorConstant.C9_ERROR_SEVERITY, Pacs00800110ErrorConstant.C9_ERROR_CODE, Pacs00800110ErrorConstant.C9_ERROR_TEXT, str);
//        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * Country
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     *
     * @return 判断规则
     */
    public static Constraints checkCountry(PartyIdentification135 partyIdentification135) {
        if (JudgeUtils.isNotNull(partyIdentification135)) {
            PostalAddress24 pstlAdr = partyIdentification135.getPstlAdr();
            if (JudgeUtils.isNotNull(pstlAdr)) {
                String ctry = pstlAdr.getCtry();
                if (JudgeUtils.isNotNull(ctry)) {
                    //通过正则表达式判断
                    boolean c9 = ctry.matches("^[a-zA-Z]{2}$");
                    if (!c9) {
                        return new Constraints(Pacs00800110ErrorConstant.C9_ERROR_SEVERITY, Pacs00800110ErrorConstant.C9_ERROR_CODE, Pacs00800110ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                    CountryEnum[] values = CountryEnum.values();
                    ArrayList<String> ctryLists = new ArrayList<>();
                    for (CountryEnum value : values) {
                        ctryLists.add(value.getCountryCode());
                    }
                    if (!ctryLists.contains(ctry)) {
                        return new Constraints(Pacs00800110ErrorConstant.C9_ERROR_SEVERITY, Pacs00800110ErrorConstant.C9_ERROR_CODE, Pacs00800110ErrorConstant.C9_ERROR_TEXT, ctry);
                    }
                }
            }
        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * IdentificationOrProxyPresenceRule ✓
     * (Rule)
     * Identification must be present or Proxy must be present. Both may be
     * present. (CrossElementSimpleRule)
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     *
     * @return 返回检查结果
     */
    public static Constraints checkIdentificationOrProxyPresenceRule(String ccy, BigDecimal bigDecimal) {
        if (JudgeUtils.isNotNull(bigDecimal)) {
            String bigS = bigDecimal.toString();
            int totalDigits = bigS.length();
            int fractionDigits = 0;
            if (bigS.contains(".")) {
                String[] split = bigS.split("\\.");
                if (split.length > 2) {
                    return new Constraints(Pacs00800110ErrorConstant.C11_ERROR_SEVERITY, Pacs00800110ErrorConstant.C11_ERROR_CODE, Pacs00800110ErrorConstant.C11_ERROR_TEXT, bigS);
                }
                totalDigits = totalDigits - 1;
                fractionDigits = split[1].length();
            }
            if (totalDigits > 18 || fractionDigits > 5) {
                return new Constraints(Pacs00800110ErrorConstant.C11_ERROR_SEVERITY, Pacs00800110ErrorConstant.C11_ERROR_CODE, Pacs00800110ErrorConstant.C11_ERROR_TEXT, bigS);
            }
        }
        if (JudgeUtils.isNotNull(ccy)) {
            //通过正则表达式判断
            boolean c11 = ccy.matches("^[a-zA-Z]{3}$");
            if (!c11) {
                return new Constraints(Pacs00800110ErrorConstant.C11_ERROR_SEVERITY, Pacs00800110ErrorConstant.C11_ERROR_CODE, Pacs00800110ErrorConstant.C11_ERROR_TEXT, ccy);
            }
//            ActiveOrHistoricCurrencyEnum[] ccyValues = ActiveOrHistoricCurrencyEnum.values();
//            ArrayList<String> ccyLists = new ArrayList<>();
//            for (ActiveOrHistoricCurrencyEnum ccyValue : ccyValues) {
//                ccyLists.add(ccyValue.getCurrencyCode());
//            }
//            if (!ccyLists.contains(ccy)) {
//                return new Constraints(Pacs00800110ErrorConstant.C11_ERROR_SEVERITY, Pacs00800110ErrorConstant.C11_ERROR_CODE, Pacs00800110ErrorConstant.C11_ERROR_TEXT, ccy);
//            }
        }
        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }

    /**
     * IBAN
     * A valid IBAN consists of all three of the following components: Country Code, check digits and
     * BBAN. (Algorithm)
     * Format
     * pattern [A-Z]{2,2}[0-9]{2,2}[a-zA-Z0-9]{1,30}
     *
     * @return 返回检查结果
     */
    public static Constraints checkIBAN(String string) {
        if (JudgeUtils.isNotNull(string)) {
            boolean iban = string.matches("^[A-Z]{2}[0-9]{2}[a-zA-Z0-9]{1,30}$");

            if (!iban) {
                return new Constraints(Pacs00800110ErrorConstant.C13_ERROR_SEVERITY, Pacs00800110ErrorConstant.C13_ERROR_CODE, Pacs00800110ErrorConstant.C13_ERROR_TEXT, string);
            }
        }

//        String substring = string.substring(0, 2);
//        CountryEnum[] values = CountryEnum.values();
//        ArrayList<String> ctryLists = new ArrayList<>();
//        for (CountryEnum value : values) {
//            ctryLists.add(value.getCountryCode());
//        }
//        if (!ctryLists.contains(substring)) {
//            return new Constraints(Pacs00800110ErrorConstant.C13_ERROR_SEVERITY, Pacs00800110ErrorConstant.C13_ERROR_CODE, Pacs00800110ErrorConstant.C13_ERROR_TEXT);
//        }

        return new Constraints(Pacs00800110ErrorConstant.SUCCESS_CODE);
    }
}
