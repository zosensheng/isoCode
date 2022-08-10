package com.hisun.kont.mx.enums;

/**
 * @author hc
 * @version V1.0
 * @Desc: 操作方式（不断完善）
 * @date 2018/4/27 15:08
 */
public enum TypeEnum {

    //M - 手工(MANUAL); A - 自动(AUTO); O - 其他(Other System)

    MANUAL("M", "手工"),

    AUTO("A", "自动"),

    OTHER_SYSTEM("O", "其他");

    /**
     * value
     */
    private final String value;
    /**
     * desc
     */
    private final String desc;

    private TypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
