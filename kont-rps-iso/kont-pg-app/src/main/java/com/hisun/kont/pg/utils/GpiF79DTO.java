package com.hisun.kont.pg.utils;

import java.util.List;

/**
 * @Author yupeifeng
 * @ClassName: F79Dto
 * @Date 2021/5/11 15:25
 * @Description TODO
 * @Version 1.0
 **/
public class GpiF79DTO {
    //第一行
    /*时间格式YYMMDD 年月日  例210806*/
    private String gpiDate;
    /*时间格式HHMM 时分  例1627*/
    private String gpiTime;
    /*时区格式 例+0080*/
    private String gpiZone;

    //第二行
    /*状态码 例ACCC ASCP*/
    private String gpiStatus;
    /*原因码 例AC01(成功没有原因码)*/
    private String gpiReasonCode;

    //第三行
    /*发起行*/
    private String statusOriBic;
    /*代理行(可能没有)*/
    private String agentBic;

    //第四行
    /*按FLD32A货币、金额、交换标志(可能没)*/
    private String f32ACur;
    private String f32Amount;
    private String f32AChargeFlag;

    //第五行(不固定)
    /*交易类型*/
    private String exType;
    /*原始货币*/
    private String oriCYY;
    /*目标货币*/
    private String tarCYY;
    /*兑换率*/
    private String exRate;

    //第六行(不固定)
    /*银行费用讯息  (代理扣减费用 :71F:USD20)*/
    private List<GpiF71fDo> f71fList;

    public GpiF79DTO() {
    }

    public GpiF79DTO(String gpiDate, String gpiTime, String gpiZone, String gpiStatus, String gpiReasonCode, String statusOriBic, String agentBic, String f32ACur, String f32Amount, String f32AChargeFlag, String exType, String oriCYY, String tarCYY, String exRate, List<GpiF71fDo> f71fList) {
        this.gpiDate = gpiDate;
        this.gpiTime = gpiTime;
        this.gpiZone = gpiZone;
        this.gpiStatus = gpiStatus;
        this.gpiReasonCode = gpiReasonCode;
        this.statusOriBic = statusOriBic;
        this.agentBic = agentBic;
        this.f32ACur = f32ACur;
        this.f32Amount = f32Amount;
        this.f32AChargeFlag = f32AChargeFlag;
        this.exType = exType;
        this.oriCYY = oriCYY;
        this.tarCYY = tarCYY;
        this.exRate = exRate;
        this.f71fList = f71fList;
    }

    public String getGpiDate() {
        return gpiDate;
    }

    public void setGpiDate(String gpiDate) {
        this.gpiDate = gpiDate;
    }

    public String getGpiTime() {
        return gpiTime;
    }

    public void setGpiTime(String gpiTime) {
        this.gpiTime = gpiTime;
    }

    public String getGpiZone() {
        return gpiZone;
    }

    public void setGpiZone(String gpiZone) {
        this.gpiZone = gpiZone;
    }

    public String getGpiStatus() {
        return gpiStatus;
    }

    public void setGpiStatus(String gpiStatus) {
        this.gpiStatus = gpiStatus;
    }

    public String getGpiReasonCode() {
        return gpiReasonCode;
    }

    public void setGpiReasonCode(String gpiReasonCode) {
        this.gpiReasonCode = gpiReasonCode;
    }

    public String getStatusOriBic() {
        return statusOriBic;
    }

    public void setStatusOriBic(String statusOriBic) {
        this.statusOriBic = statusOriBic;
    }

    public String getAgentBic() {
        return agentBic;
    }

    public void setAgentBic(String agentBic) {
        this.agentBic = agentBic;
    }

    public String getF32ACur() {
        return f32ACur;
    }

    public void setF32ACur(String f32ACur) {
        this.f32ACur = f32ACur;
    }

    public String getF32Amount() {
        return f32Amount;
    }

    public void setF32Amount(String f32Amount) {
        this.f32Amount = f32Amount;
    }

    public String getF32AChargeFlag() {
        return f32AChargeFlag;
    }

    public void setF32AChargeFlag(String f32AChargeFlag) {
        this.f32AChargeFlag = f32AChargeFlag;
    }

    public String getExType() {
        return exType;
    }

    public void setExType(String exType) {
        this.exType = exType;
    }

    public String getOriCYY() {
        return oriCYY;
    }

    public void setOriCYY(String oriCYY) {
        this.oriCYY = oriCYY;
    }

    public String getTarCYY() {
        return tarCYY;
    }

    public void setTarCYY(String tarCYY) {
        this.tarCYY = tarCYY;
    }

    public String getExRate() {
        return exRate;
    }

    public void setExRate(String exRate) {
        this.exRate = exRate;
    }

    public List<GpiF71fDo> getF71fList() {
        return f71fList;
    }

    public void setF71fList(List<GpiF71fDo> f71fList) {
        this.f71fList = f71fList;
    }

    @Override
    public String toString() {
        return "GpiF79DTO{" +
                "gpiDate='" + gpiDate + '\'' +
                ", gpiTime='" + gpiTime + '\'' +
                ", gpiZone='" + gpiZone + '\'' +
                ", gpiStatus='" + gpiStatus + '\'' +
                ", gpiReasonCode='" + gpiReasonCode + '\'' +
                ", statusOriBic='" + statusOriBic + '\'' +
                ", agentBic='" + agentBic + '\'' +
                ", f32ACur='" + f32ACur + '\'' +
                ", f32Amount='" + f32Amount + '\'' +
                ", f32AChargeFlag='" + f32AChargeFlag + '\'' +
                ", exType='" + exType + '\'' +
                ", oriCYY='" + oriCYY + '\'' +
                ", tarCYY='" + tarCYY + '\'' +
                ", exRate='" + exRate + '\'' +
                ", f71fList=" + f71fList +
                '}';
    }
}
