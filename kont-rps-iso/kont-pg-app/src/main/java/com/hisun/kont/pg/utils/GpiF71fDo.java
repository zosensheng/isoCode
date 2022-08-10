package com.hisun.kont.pg.utils;

/**
 * @Author yupeifeng
 * @ClassName: GpiF71Dto
 * @Date 2021/12/14 13:11
 * @Description GPI199的79域以:71F:开头的行不止一行 故创建此do存储
 * @Version 1.0
 **/
public class GpiF71fDo {
    /*银行费用讯息  (代理扣减费用 :71F:USD20)*/
    private String f71fChargeCur;
    private String f71fChargeAmt;

    public GpiF71fDo() {
    }

    public GpiF71fDo(String f71fChargeCur, String f71fChargeAmt) {
        this.f71fChargeCur = f71fChargeCur;
        this.f71fChargeAmt = f71fChargeAmt;
    }

    public String getF71fChargeCur() {
        return f71fChargeCur;
    }

    public void setF71fChargeCur(String f71fChargeCur) {
        this.f71fChargeCur = f71fChargeCur;
    }

    public String getF71fChargeAmt() {
        return f71fChargeAmt;
    }

    public void setF71fChargeAmt(String f71fChargeAmt) {
        this.f71fChargeAmt = f71fChargeAmt;
    }

    @Override
    public String toString() {
        return "GpiF71Do{" +
                "f71fChargeCur='" + f71fChargeCur + '\'' +
                ", f71fChargeAmt='" + f71fChargeAmt + '\'' +
                '}';
    }
}
