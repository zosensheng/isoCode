package com.hisun.kont.mx.remote;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class RmcMxg01 {

    @ApiModelProperty(
            name = "funCode",
            value = "funCode"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String funCode;
    @ApiModelProperty(
            name = "errCode",
            value = "errCode"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String errCode;
    @ApiModelProperty(
            name = "toSys",
            value = "toSys"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String toSys;
    @ApiModelProperty(
            name = "srcBk",
            value = "srcBk"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String srcBk;
    @ApiModelProperty(
            name = "srcDate",
            value = "srcDate"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String srcDate;
    @ApiModelProperty(
            name = "srcSeq",
            value = "srcSeq"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String srcSeq;
    @ApiModelProperty(
            name = "resendInd",
            value = "resendInd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String resendInd;
    @ApiModelProperty(
            name = "open",
            value = "open"
    )
    @Size(
            max = 255,
            message = "SYS20002"
    )
    private String open;
    @ApiModelProperty(
            name = "srcAppl",
            value = "srcAppl"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String srcAppl;
    @ApiModelProperty(
            name = "msgNature",
            value = "msgNature"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String msgNature;
    @ApiModelProperty(
            name = "msgPrio",
            value = "msgPrio"
    )
    @Digits(
            integer = 1,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    private Integer msgPrio;
    @ApiModelProperty(
            name = "msgType",
            value = "报文类型"
    )
    @Size(
            max = 35,
            message = "PARAMTER FORMAT ERROR"
    )
    private String msgType;
    @ApiModelProperty(
            name = "receiver",
            value = "receiver"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String receiver;
    @ApiModelProperty(
            name = "trnRef",
            value = "trnRef"
    )
    @Size(
            max = 35,
            message = "SYS20002"
    )
    private String trnRef;
    @ApiModelProperty(
            name = "relRef",
            value = "relRef"
    )
    @Size(
            max = 35,
            message = "SYS20002"
    )
    private String relRef;
    @ApiModelProperty(
            name = "valueDate",
            value = "valueDate"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String valueDate;
    @ApiModelProperty(
            name = "bbk",
            value = "bbk"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String bbk;
    @ApiModelProperty(
            name = "abk",
            value = "abk"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String abk;
    @ApiModelProperty(
            name = "ibk",
            value = "ibk"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String ibk;
    @ApiModelProperty(
            name = "bbkAc",
            value = "bbkAc"
    )
    @Size(
            max = 34,
            message = "SYS20002"
    )
    private String bbkAc;
    @ApiModelProperty(
            name = "stlAc",
            value = "stlAc"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String stlAc;
    @ApiModelProperty(
            name = "rmtCur",
            value = "rmtCur"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String rmtCur;
    @ApiModelProperty(
            name = "rmtAmt",
            value = "rmtAmt"
    )
    @Digits(
            integer = 13,
            message = "PARAMTER FORMAT ERROR",
            fraction = 2
    )
    private BigDecimal rmtAmt;
    @ApiModelProperty(
            name = "maBk",
            value = "maBk"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String maBk;
    @ApiModelProperty(
            name = "maDate",
            value = "maDate"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String maDate;
    @ApiModelProperty(
            name = "maSeq",
            value = "maSeq"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String maSeq;
    @ApiModelProperty(
            name = "open2",
            value = "open2"
    )
    @Size(
            max = 197,
            message = "SYS20002"
    )
    private String open2;
    @ApiModelProperty(
            name = "msgFrCHL",
            value = "msgFrCHL"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String msgFrCHL;
    @ApiModelProperty(
            name = "innerFlag",
            value = "innerFlag"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String innerFlag;
    @ApiModelProperty(
            name = "msgFlag",
            value = "msgFlag"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String msgFlag;
    @ApiModelProperty(
            name = "msgLen",
            value = "msgLen"
    )
    @Digits(
            integer = 5,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    private Integer msgLen;
    @ApiModelProperty(
            name = "swiftInfo",
            value = "swiftInfo"
    )
    @Size(
            max = 31000,
            message = "SYS20002"
    )
    private String swiftInformation;

    public RmcMxg01() {
    }

    public String getFunCode() {
        return this.funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getToSys() {
        return this.toSys;
    }

    public void setToSys(String toSys) {
        this.toSys = toSys;
    }

    public String getSrcBk() {
        return this.srcBk;
    }

    public void setSrcBk(String srcBk) {
        this.srcBk = srcBk;
    }

    public String getSrcDate() {
        return this.srcDate;
    }

    public void setSrcDate(String srcDate) {
        this.srcDate = srcDate;
    }

    public String getSrcSeq() {
        return this.srcSeq;
    }

    public void setSrcSeq(String srcSeq) {
        this.srcSeq = srcSeq;
    }

    public String getResendInd() {
        return this.resendInd;
    }

    public void setResendInd(String resendInd) {
        this.resendInd = resendInd;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getSrcAppl() {
        return this.srcAppl;
    }

    public void setSrcAppl(String srcAppl) {
        this.srcAppl = srcAppl;
    }

    public String getMsgNature() {
        return this.msgNature;
    }

    public void setMsgNature(String msgNature) {
        this.msgNature = msgNature;
    }

    public Integer getMsgPrio() {
        return this.msgPrio;
    }

    public void setMsgPrio(Integer msgPrio) {
        this.msgPrio = msgPrio;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTrnRef() {
        return this.trnRef;
    }

    public void setTrnRef(String trnRef) {
        this.trnRef = trnRef;
    }

    public String getRelRef() {
        return this.relRef;
    }

    public void setRelRef(String relRef) {
        this.relRef = relRef;
    }

    public String getValueDate() {
        return this.valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getBbk() {
        return this.bbk;
    }

    public void setBbk(String bbk) {
        this.bbk = bbk;
    }

    public String getAbk() {
        return this.abk;
    }

    public void setAbk(String abk) {
        this.abk = abk;
    }

    public String getIbk() {
        return this.ibk;
    }

    public void setIbk(String ibk) {
        this.ibk = ibk;
    }

    public String getBbkAc() {
        return this.bbkAc;
    }

    public void setBbkAc(String bbkAc) {
        this.bbkAc = bbkAc;
    }

    public String getStlAc() {
        return this.stlAc;
    }

    public void setStlAc(String stlAc) {
        this.stlAc = stlAc;
    }

    public String getRmtCur() {
        return this.rmtCur;
    }

    public void setRmtCur(String rmtCur) {
        this.rmtCur = rmtCur;
    }

    public BigDecimal getRmtAmt() {
        return this.rmtAmt;
    }

    public void setRmtAmt(BigDecimal rmtAmt) {
        this.rmtAmt = rmtAmt;
    }

    public String getMaBk() {
        return this.maBk;
    }

    public void setMaBk(String maBk) {
        this.maBk = maBk;
    }

    public String getMaDate() {
        return this.maDate;
    }

    public void setMaDate(String maDate) {
        this.maDate = maDate;
    }

    public String getMaSeq() {
        return this.maSeq;
    }

    public void setMaSeq(String maSeq) {
        this.maSeq = maSeq;
    }

    public String getOpen2() {
        return this.open2;
    }

    public void setOpen2(String open2) {
        this.open2 = open2;
    }

    public String getMsgFrCHL() {
        return this.msgFrCHL;
    }

    public void setMsgFrCHL(String msgFrCHL) {
        this.msgFrCHL = msgFrCHL;
    }

    public String getInnerFlag() {
        return this.innerFlag;
    }

    public void setInnerFlag(String innerFlag) {
        this.innerFlag = innerFlag;
    }

    public String getMsgFlag() {
        return this.msgFlag;
    }

    public void setMsgFlag(String msgFlag) {
        this.msgFlag = msgFlag;
    }

    public Integer getMsgLen() {
        return this.msgLen;
    }

    public void setMsgLen(Integer msgLen) {
        this.msgLen = msgLen;
    }

    public String getSwiftInformation() {
        return swiftInformation;
    }

    public void setSwiftInformation(String swiftInformation) {
        this.swiftInformation = swiftInformation;
    }

    @Override
    public String toString() {
        return "RmcMxg01{" +
                "funCode='" + funCode + '\'' +
                ", errCode='" + errCode + '\'' +
                ", toSys='" + toSys + '\'' +
                ", srcBk='" + srcBk + '\'' +
                ", srcDate='" + srcDate + '\'' +
                ", srcSeq='" + srcSeq + '\'' +
                ", resendInd='" + resendInd + '\'' +
                ", open='" + open + '\'' +
                ", srcAppl='" + srcAppl + '\'' +
                ", msgNature='" + msgNature + '\'' +
                ", msgPrio=" + msgPrio +
                ", msgType='" + msgType + '\'' +
                ", receiver='" + receiver + '\'' +
                ", trnRef='" + trnRef + '\'' +
                ", relRef='" + relRef + '\'' +
                ", valueDate='" + valueDate + '\'' +
                ", bbk='" + bbk + '\'' +
                ", abk='" + abk + '\'' +
                ", ibk='" + ibk + '\'' +
                ", bbkAc='" + bbkAc + '\'' +
                ", stlAc='" + stlAc + '\'' +
                ", rmtCur='" + rmtCur + '\'' +
                ", rmtAmt=" + rmtAmt +
                ", maBk='" + maBk + '\'' +
                ", maDate='" + maDate + '\'' +
                ", maSeq='" + maSeq + '\'' +
                ", open2='" + open2 + '\'' +
                ", msgFrCHL='" + msgFrCHL + '\'' +
                ", innerFlag='" + innerFlag + '\'' +
                ", msgFlag='" + msgFlag + '\'' +
                ", msgLen=" + msgLen +
                ", swiftInformation='" + swiftInformation + '\'' +
                '}';
    }
}
