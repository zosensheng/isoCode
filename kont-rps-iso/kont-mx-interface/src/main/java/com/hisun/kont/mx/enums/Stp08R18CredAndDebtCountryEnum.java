package com.hisun.kont.mx.enums;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/12 15:27
 */
public enum Stp08R18CredAndDebtCountryEnum {

    //AT,
    AT("AT"),
    // BE,
    BE("BE"),
    // BG,
    BG("BG"),
    // BV,
    BV("BV"),
    // CY,
    CY("CY"),
    // CZ,
    CZ("CZ"),
    // DE,
    DE("DE"),
    // DK,
    DK("DK"),
    // EE,
    EE("EE"),
    // ES,
    ES("ES"),
    // FI,
    FI("FI"),
    // FR,
    FR("FR"),
    // GB,
    GB("GB"),
    // GF,
    GF("GF"),
    // GI,
    GI("GI"),
    // GP,
    GP("GP"),
    // GR,
    GR("GR"),
    // HR,
    HR("HR"),
    // HU,
    HU("HU"),
    // IE,
    IE("IE"),
    // IS,
    IS("IS"),
    // IT,
    IT("IT"),
    // LI,
    LI("LI"),
    // LT,
    LT("LT"),
    // LU,
    LU("LU"),
    //LV,
    LV("LV"),
    // MQ (FR),
    MQ("MQ"),
    // MT,
    MT("MT"),
    // NL,
    NL("NL"),
    // NO,
    NO("NO"),
    // PL,
    PL("PL"),
    // PM(FR),
    PM("PM"),
    // PT,
    PT("PT"),
    // RE (FR),
    RE("RE"),
    // RO,
    RO("RO"),
    // SE,
    SE("SE"),
    // SI,
    SI("SI"),
    // SJ,
    SJ("SJ"),
    // SK
    SK("SK");

    private String countryCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    Stp08R18CredAndDebtCountryEnum(String countryCode) {
        this.countryCode = countryCode;
    }

}
