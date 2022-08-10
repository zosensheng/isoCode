package com.hisun.kont.mx.enums;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/15 15:57
 * 受管辖权规则影响的国家
 */
public enum StpCountryJurEnum {

    //比利時、保加利亞、捷克、丹麥、德國、愛沙尼亞、愛爾蘭、希臘、西班牙、
    // 法國、克羅地亞、意大利、塞浦路斯、拉脫維亞、立陶宛、盧森堡、匈牙利、
    // 馬耳他、荷蘭、奧地利、波蘭、葡萄牙、羅馬尼亞、斯洛文尼亞、斯洛伐克、
    // 芬蘭、瑞典、冰島、列支敦士登、挪威。

    //比利時	BE
    BE("BE"),

    //保加利亞	BG
    BG("BG"),

    //捷克	CZ
    CZ("CZ"),

    //丹麥	DK
    DK("DK"),

    //德國	DE
    DE("DE"),

    //愛沙尼亞	EE
    EE("EE"),

    //愛爾蘭	IE
    IE("IE"),

    //希臘	GR
    GR("GR"),

    //西班牙	ES
    ES("ES"),

    //法國(法蘭西)	FR
    FR("FR"),

    //克羅埃西亞 / 克羅地亞	HR
    HR("HR"),

    //義大利 / 意大利	IT
    IT("IT"),

    //賽普勒斯 / 塞浦路斯	CY
    CY("CY"),

    //拉脫維亞	LV
    LV("LV"),

    //立陶宛	LT
    LT("LT"),

    //盧森堡	LU
    LU("LU"),

    //匈牙利	HU
    HU("HU"),

    //馬爾他	MT
    MT("MT"),

    //荷蘭	NL
    NL("NL"),

    //奧地利	AT
    AT("AT"),

    //波蘭	PL
    PL("PL"),

    //葡萄牙	PT
    PT("PT"),

    //羅馬尼亞	RO
    RO("RO"),

    //斯洛維尼亞 / 斯洛文尼亞	SI
    SI("SI"),

    //斯洛伐克	SK
    SK("SK"),

    //芬蘭	FI
    FI("FI"),

    //瑞典	SE
    SE("SE"),

    //冰島	IS
    IS("IS"),

    //列支敦斯登 / 列支敦士登	LI
    LI("LI"),

    //挪威	NO
    NO("NO"),
    ;

    private String countryCode;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    StpCountryJurEnum(String countryCode) {
        this.countryCode = countryCode;
    }
}
