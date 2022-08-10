package com.hisun.kont.mx.remote;


import com.hisun.kont.common.utils.JudgeUtils;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;

public class ReceiveMxAckRspDTO {

    @ApiModelProperty(
            name = "funCd",
            value = "功能码"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "FuncCode"
    )
    private String funCd;
    @ApiModelProperty(
            name = "errCd",
            value = "错误码"
    )
    @Digits(
            integer = 2,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "ErrCode"
    )
    private Integer errCd;
    @ApiModelProperty(
            name = "frSys",
            value = "所属系统"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @XmlElement(
            name = "FromSys"
    )
    private String frSys;
    @ApiModelProperty(
            name = "id22",
            value = "id22"
    )
    @Size(
            max = 22,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Id"
    )
    private String id22;
    @ApiModelProperty(
            name = "resndInd",
            value = "resendInd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "ResndInd"
    )
    private String resndInd;
    @ApiModelProperty(
            name = "rejInd",
            value = "rejInd"
    )
    @Digits(
            integer = 1,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "RejInd"
    )
    private Integer rejInd;
    @ApiModelProperty(
            name = "impsInd",
            value = "imposeInd"
    )
    @Digits(
            integer = 1,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "ImposeInd"
    )
    private Integer impsInd;
    @ApiModelProperty(
            name = "tlgpBank",
            value = "tlgpBank"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "TlgpBank"
    )
    private String tlgpBank;
    @ApiModelProperty(
            name = "tlgpOsn",
            value = "tlgpOsn"
    )
    @Digits(
            integer = 6,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "TlgpOsn"
    )
    private Integer tlgpOsn;
    @ApiModelProperty(
            name = "tlgpRecno",
            value = "tlgpRecno"
    )
    @Digits(
            integer = 2,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "TlgpRecno"
    )
    private Integer tlgpRecno;
    @ApiModelProperty(
            name = "open39",
            value = "open39"
    )
    @Size(
            max = 39,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Opn"
    )
    private String open39;
    @Valid
    @ApiModelProperty(
            name = "rspHead",
            value = ""
    )
    private RspHead rspHead;

    public ReceiveMxAckRspDTO() {
    }

//    @ApiModelProperty(
//            hidden = true
//    )
//    public List<AuthMsg> getAuthMsgs() {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            this.setRspHead(new RspHead());
//        }
//
//        return this.getRspHead().getAuthMsgs();
//    }
//
//    public void setAuthMsgs(List<AuthMsg> authMsgs) {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            RspHead rspHead = new RspHead();
//            this.setRspHead(rspHead);
//            this.getRspHead().setAuthMsgs(authMsgs);
//        } else {
//            this.getRspHead().setAuthMsgs(authMsgs);
//        }
//
//    }
//
//    @ApiModelProperty(
//            hidden = true
//    )
//    public List<Jnl0001> getJnl0001s() {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            this.setRspHead(new RspHead());
//        }
//
//        return this.getRspHead().getJnl0001s();
//    }
//
//    public void setJnl0001s(List<Jnl0001> jnl0001s) {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            RspHead rspHead = new RspHead();
//            this.setRspHead(rspHead);
//            this.getRspHead().setJnl0001s(jnl0001s);
//        } else {
//            this.getRspHead().setJnl0001s(jnl0001s);
//        }
//
//    }
//
//    @ApiModelProperty(
//            hidden = true
//    )
//    public List<Jnl0002> getJnl0002s() {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            this.setRspHead(new RspHead());
//        }
//
//        return this.getRspHead().getJnl0002s();
//    }
//
//    public void setJnl0002s(List<Jnl0002> jnl0002s) {
//        if (JudgeUtils.isNull(this.getRspHead())) {
//            RspHead rspHead = new RspHead();
//            this.setRspHead(rspHead);
//            this.getRspHead().setJnl0002s(jnl0002s);
//        } else {
//            this.getRspHead().setJnl0002s(jnl0002s);
//        }
//
//    }

    public String getFunCd() {
        return this.funCd;
    }

    public void setFunCd(String funCd) {
        this.funCd = funCd;
    }

    public Integer getErrCd() {
        return this.errCd;
    }

    public void setErrCd(Integer errCd) {
        this.errCd = errCd;
    }

    public String getFrSys() {
        return this.frSys;
    }

    public void setFrSys(String frSys) {
        this.frSys = frSys;
    }

    public String getId22() {
        return this.id22;
    }

    public void setId22(String id22) {
        this.id22 = id22;
    }

    public String getResndInd() {
        return this.resndInd;
    }

    public void setResndInd(String resndInd) {
        this.resndInd = resndInd;
    }

    public Integer getRejInd() {
        return this.rejInd;
    }

    public void setRejInd(Integer rejInd) {
        this.rejInd = rejInd;
    }

    public Integer getImpsInd() {
        return this.impsInd;
    }

    public void setImpsInd(Integer impsInd) {
        this.impsInd = impsInd;
    }

    public String getTlgpBank() {
        return this.tlgpBank;
    }

    public void setTlgpBank(String tlgpBank) {
        this.tlgpBank = tlgpBank;
    }

    public Integer getTlgpOsn() {
        return this.tlgpOsn;
    }

    public void setTlgpOsn(Integer tlgpOsn) {
        this.tlgpOsn = tlgpOsn;
    }

    public Integer getTlgpRecno() {
        return this.tlgpRecno;
    }

    public void setTlgpRecno(Integer tlgpRecno) {
        this.tlgpRecno = tlgpRecno;
    }

    public String getOpen39() {
        return this.open39;
    }

    public void setOpen39(String open39) {
        this.open39 = open39;
    }

    public RspHead getRspHead() {
        return this.rspHead;
    }

    public void setRspHead(RspHead rspHead) {
        this.rspHead = rspHead;
    }

    @Override
    public String toString() {
        return "ReceiveMxAckRspDTO{" +
                "funCd='" + funCd + '\'' +
                ", errCd=" + errCd +
                ", frSys='" + frSys + '\'' +
                ", id22='" + id22 + '\'' +
                ", resndInd='" + resndInd + '\'' +
                ", rejInd=" + rejInd +
                ", impsInd=" + impsInd +
                ", tlgpBank='" + tlgpBank + '\'' +
                ", tlgpOsn=" + tlgpOsn +
                ", tlgpRecno=" + tlgpRecno +
                ", open39='" + open39 + '\'' +
                ", rspHead=" + rspHead +
                '}';
    }
}
