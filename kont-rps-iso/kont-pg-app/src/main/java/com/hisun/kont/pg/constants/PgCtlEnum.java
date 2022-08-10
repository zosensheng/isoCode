package com.hisun.kont.pg.constants;

/**
 * @author SKULLMAN
 * @version V1.0
 * @ClassName PgCtlEnum
 * @Desc:
 * @date 2019/9/5 11:55
 */
public enum PgCtlEnum {

    /**
     * 汇入
     */
    SI("I"),

    /**
     * 汇出
     */
    SO("O"),

    /**
     * 汇出
     */
    AML("A");

    private PgCtlEnum(String Typ) {
        this.Typ = Typ;
    }

    /**
     * 类型
     */
    private String Typ;

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String typ) {
        Typ = typ;
    }
}
