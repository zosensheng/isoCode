package com.hisun.kont.mx.remote;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceiveMxMsgReqDTO {

    @ApiModelProperty(
            name = "funCd",
            value = "功能码"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "FunCd"
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
            name = "ErrCd"
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
            name = "FrSys"
    )
    private String frSys;
    @ApiModelProperty(
            name = "srcBk",
            value = "源系统银行代码"
    )
    @Digits(
            integer = 3,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @NotNull(
            message = "SYS20003"
    )
    @XmlElement(
            name = "SrcBk"
    )
    private Integer srcBk;
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty(
            name = "srcDt",
            value = "源系统日期"
    )
    @NotNull(
            message = "SYS20003"
    )
    @XmlElement(
            name = "SrcDt"
    )
    private LocalDate srcDt;
    @ApiModelProperty(
            name = "srcSeq",
            value = "源系统序列号"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    @NotNull(
            message = "SYS20003"
    )
    @XmlElement(
            name = "SrcSeq"
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
    @XmlElement(
            name = "ResndInd"
    )
    private String resendInd;
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
            name = "imposeInd",
            value = "imposeInd"
    )
    @Digits(
            integer = 1,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "ImpsInd"
    )
    private Integer imposeInd;
    @ApiModelProperty(
            name = "open",
            value = "open"
    )
    @Size(
            max = 9,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Opn"
    )
    private String open;
    @ApiModelProperty(
            name = "msgSrc",
            value = "msgSrc"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MsgSrc"
    )
    private String msgSrc;
    @ApiModelProperty(
            name = "open1",
            value = "open1"
    )
    @Size(
            max = 35,
            message = "SYS20002"
    )
    @XmlElement(
            name = "OPEN1"
    )
    private String open1;
    @ApiModelProperty(
            name = "toSys",
            value = "目标系统"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @XmlElement(
            name = "ToSys"
    )
    private String toSys;
    @ApiModelProperty(
            name = "msgNat",
            value = "msgNat"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MsgNat"
    )
    private String msgNat;
    @ApiModelProperty(
            name = "cvrSts",
            value = "cvrSts"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "CVRSts"
    )
    private String cvrSts;
    @ApiModelProperty(
            name = "frSys2",
            value = "frSys2"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @XmlElement(
            name = "FrSys2"
    )
    private String frSys2;
    @ApiModelProperty(
            name = "relBk",
            value = "关联银行"
    )
    @Digits(
            integer = 3,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "RelBk"
    )
    private Integer relBk;
    @ApiModelProperty(
            name = "relDt",
            value = "关联日期"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    @XmlElement(
            name = "RelDt"
    )
    private String relDt;
    @ApiModelProperty(
            name = "relSeq",
            value = "关联序列号"
    )
    @Digits(
            integer = 7,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "RelSeq"
    )
    private Integer relSeq;
    @ApiModelProperty(
            name = "procSts",
            value = "procSts"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "ProcSts"
    )
    private String procSts;
    @ApiModelProperty(
            name = "tlxMailFg",
            value = "tlxMailFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "TlxMailFg"
    )
    private String tlxMailFg;
    @ApiModelProperty(
            name = "mt",
            value = "报文类型"
    )
    @Digits(
            integer = 3,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "MT"
    )
    private Integer mt;
    @ApiModelProperty(
            name = "sender",
            value = "发送行"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Sndr"
    )
    private String sender;
    @ApiModelProperty(
            name = "trnRef",
            value = "trnRef"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    @XmlElement(
            name = "TrnRef"
    )
    private String trnRef;
    @ApiModelProperty(
            name = "relRef",
            value = "relRef"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    @XmlElement(
            name = "RelRef"
    )
    private String relRef;
    @ApiModelProperty(
            name = "osn",
            value = "osn"
    )
    @Digits(
            integer = 6,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "OSN"
    )
    private Integer osn;
    @ApiModelProperty(
            name = "inDueFmFg",
            value = "inDueFmFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "InDueFMFg"
    )
    private String inDueFmFg;
    @JsonFormat(
            pattern = "yyyy-MM-dd"
    )
    @ApiModelProperty(
            name = "valDt",
            value = "生效日"
    )
    @XmlElement(
            name = "ValDt"
    )
    private LocalDate valDt;
    @ApiModelProperty(
            name = "bkDt",
            value = "bkDt"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    @XmlElement(
            name = "BkDt"
    )
    private String bkDt;
    @ApiModelProperty(
            name = "rmtInd",
            value = "rmtInd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "RMTInd"
    )
    private String rmtInd;
    @ApiModelProperty(
            name = "stlBk",
            value = "清算行"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    @XmlElement(
            name = "StlBnk"
    )
    private String stlBk;
    @ApiModelProperty(
            name = "stlAc",
            value = "清算账户"
    )
    @Digits(
            integer = 16,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "StlAc"
    )
    private Long stlAc;
    @ApiModelProperty(
            name = "stlCur",
            value = "结算货币"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @XmlElement(
            name = "StlCur"
    )
    private String stlCur;
    @ApiModelProperty(
            name = "stlAmt",
            value = "结算金额"
    )
    @Digits(
            integer = 13,
            message = "PARAMTER FORMAT ERROR",
            fraction = 2
    )
    @XmlElement(
            name = "StlAmt"
    )
    private BigDecimal stlAmt;
    @ApiModelProperty(
            name = "stlRt",
            value = "结算汇率"
    )
    @Digits(
            integer = 8,
            message = "PARAMTER FORMAT ERROR",
            fraction = 7
    )
    @XmlElement(
            name = "StlRT"
    )
    private BigDecimal stlRt;
    @ApiModelProperty(
            name = "rmtCur",
            value = "rmtCur"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @XmlElement(
            name = "RMTCur"
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
    @XmlElement(
            name = "RMTAmt"
    )
    private BigDecimal rmtAmt;
    @ApiModelProperty(
            name = "ofacRst",
            value = "ofacRst"
    )
    @Digits(
            integer = 1,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "OFACRST"
    )
    private Integer ofacRst;
    @ApiModelProperty(
            name = "msgFg",
            value = "msgFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MsgFg"
    )
    private String msgFg;
    @ApiModelProperty(
            name = "msgLen",
            value = "swift 报文长度"
    )
    @Digits(
            integer = 5,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "MsgLen"
    )
    private Integer msgLen;
    @ApiModelProperty(
            name = "swiftInfo",
            value = "swift 报文内容"
    )
    @Size(
            max = 6000,
            message = "SYS20002"
    )
    @XmlElement(
            name = "SwiftInfo"
    )
    private String swiftInfo;
    @ApiModelProperty(
            name = "rmk",
            value = "报文备注"
    )
    @Size(
            max = 40,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Rmk"
    )
    private String rmk;
    @ApiModelProperty(
            name = "fininformFg",
            value = "fininformFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "FININFORMFg"
    )
    private String fininformFg;
    @ApiModelProperty(
            name = "gpiFg",
            value = "gpiFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "GPIFg"
    )
    private String gpiFg;
    @ApiModelProperty(
            name = "nxtDtFg",
            value = "nxtDtFg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "NxtDtFg"
    )
    private String nxtDtFg;

    private String rmcOrgRef;
    private String mxSessionId;
    private String mxSeqNum;
    private String mxMsgId;
    private String mxSupplyInd;
    private String mxAddInd;


    @Valid
    @ApiModelProperty(
            name = "reqHead",
            value = ""
    )
    private ReqHead reqHead;
    @ApiModelProperty(
            name = "frontContent",
            value = "前端界面内容"
    )
    private String frontContent;
    @ApiModelProperty(
            name = "memopadContent",
            value = "memopad内容"
    )
    @Size(
            max = 400,
            message = "SYS20002"
    )
    private String memopadContent;

    public ReceiveMxMsgReqDTO() {
    }

    @ApiModelProperty(
            hidden = true
    )
//    public List<AuthMsg> getAuthMsgs() {
//        if (JudgeUtils.isNull(this.getReqHead())) {
//            this.setReqHead(new ReqHead());
//        }
//
//        return this.getReqHead().getAuthMsgs();
//    }
//
//    public void setAuthMsgs(List<AuthMsg> authMsgs) {
//        if (JudgeUtils.isNull(this.getReqHead())) {
//            ReqHead reqHead = new ReqHead();
//            this.setReqHead(reqHead);
//            this.getReqHead().setAuthMsgs(authMsgs);
//        } else {
//            this.getReqHead().setAuthMsgs(authMsgs);
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

    public Integer getSrcBk() {
        return this.srcBk;
    }

    public void setSrcBk(Integer srcBk) {
        this.srcBk = srcBk;
    }

    public LocalDate getSrcDt() {
        return this.srcDt;
    }

    public void setSrcDt(LocalDate srcDt) {
        this.srcDt = srcDt;
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

    public Integer getRejInd() {
        return this.rejInd;
    }

    public void setRejInd(Integer rejInd) {
        this.rejInd = rejInd;
    }

    public Integer getImposeInd() {
        return this.imposeInd;
    }

    public void setImposeInd(Integer imposeInd) {
        this.imposeInd = imposeInd;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getMsgSrc() {
        return this.msgSrc;
    }

    public void setMsgSrc(String msgSrc) {
        this.msgSrc = msgSrc;
    }

    public String getOpen1() {
        return this.open1;
    }

    public void setOpen1(String open1) {
        this.open1 = open1;
    }

    public String getToSys() {
        return this.toSys;
    }

    public void setToSys(String toSys) {
        this.toSys = toSys;
    }

    public String getMsgNat() {
        return this.msgNat;
    }

    public void setMsgNat(String msgNat) {
        this.msgNat = msgNat;
    }

    public String getCvrSts() {
        return this.cvrSts;
    }

    public void setCvrSts(String cvrSts) {
        this.cvrSts = cvrSts;
    }

    public String getFrSys2() {
        return this.frSys2;
    }

    public void setFrSys2(String frSys2) {
        this.frSys2 = frSys2;
    }

    public Integer getRelBk() {
        return this.relBk;
    }

    public void setRelBk(Integer relBk) {
        this.relBk = relBk;
    }

    public String getRelDt() {
        return this.relDt;
    }

    public void setRelDt(String relDt) {
        this.relDt = relDt;
    }

    public Integer getRelSeq() {
        return this.relSeq;
    }

    public void setRelSeq(Integer relSeq) {
        this.relSeq = relSeq;
    }

    public String getProcSts() {
        return this.procSts;
    }

    public void setProcSts(String procSts) {
        this.procSts = procSts;
    }

    public String getTlxMailFg() {
        return this.tlxMailFg;
    }

    public void setTlxMailFg(String tlxMailFg) {
        this.tlxMailFg = tlxMailFg;
    }

    public Integer getMt() {
        return this.mt;
    }

    public void setMt(Integer mt) {
        this.mt = mt;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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

    public Integer getOsn() {
        return this.osn;
    }

    public void setOsn(Integer osn) {
        this.osn = osn;
    }

    public String getInDueFmFg() {
        return this.inDueFmFg;
    }

    public void setInDueFmFg(String inDueFmFg) {
        this.inDueFmFg = inDueFmFg;
    }

    public LocalDate getValDt() {
        return this.valDt;
    }

    public void setValDt(LocalDate valDt) {
        this.valDt = valDt;
    }

    public String getBkDt() {
        return this.bkDt;
    }

    public void setBkDt(String bkDt) {
        this.bkDt = bkDt;
    }

    public String getRmtInd() {
        return this.rmtInd;
    }

    public void setRmtInd(String rmtInd) {
        this.rmtInd = rmtInd;
    }

    public String getStlBk() {
        return this.stlBk;
    }

    public void setStlBk(String stlBk) {
        this.stlBk = stlBk;
    }

    public Long getStlAc() {
        return this.stlAc;
    }

    public void setStlAc(Long stlAc) {
        this.stlAc = stlAc;
    }

    public String getStlCur() {
        return this.stlCur;
    }

    public void setStlCur(String stlCur) {
        this.stlCur = stlCur;
    }

    public BigDecimal getStlAmt() {
        return this.stlAmt;
    }

    public void setStlAmt(BigDecimal stlAmt) {
        this.stlAmt = stlAmt;
    }

    public BigDecimal getStlRt() {
        return this.stlRt;
    }

    public void setStlRt(BigDecimal stlRt) {
        this.stlRt = stlRt;
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

    public Integer getOfacRst() {
        return this.ofacRst;
    }

    public void setOfacRst(Integer ofacRst) {
        this.ofacRst = ofacRst;
    }

    public String getMsgFg() {
        return this.msgFg;
    }

    public void setMsgFg(String msgFg) {
        this.msgFg = msgFg;
    }

    public Integer getMsgLen() {
        return this.msgLen;
    }

    public void setMsgLen(Integer msgLen) {
        this.msgLen = msgLen;
    }

    public String getSwiftInfo() {
        return this.swiftInfo;
    }

    public void setSwiftInfo(String swiftInfo) {
        this.swiftInfo = swiftInfo;
    }

    public String getRmk() {
        return this.rmk;
    }

    public void setRmk(String rmk) {
        this.rmk = rmk;
    }

    public String getFininformFg() {
        return this.fininformFg;
    }

    public void setFininformFg(String fininformFg) {
        this.fininformFg = fininformFg;
    }

    public String getGpiFg() {
        return this.gpiFg;
    }

    public void setGpiFg(String gpiFg) {
        this.gpiFg = gpiFg;
    }

    public String getNxtDtFg() {
        return this.nxtDtFg;
    }

    public void setNxtDtFg(String nxtDtFg) {
        this.nxtDtFg = nxtDtFg;
    }

    public String getRmcOrgRef() {
        return rmcOrgRef;
    }

    public void setRmcOrgRef(String rmcOrgRef) {
        this.rmcOrgRef = rmcOrgRef;
    }

    public String getMxSessionId() {
        return mxSessionId;
    }

    public void setMxSessionId(String mxSessionId) {
        this.mxSessionId = mxSessionId;
    }

    public String getMxSeqNum() {
        return mxSeqNum;
    }

    public void setMxSeqNum(String mxSeqNum) {
        this.mxSeqNum = mxSeqNum;
    }

    public String getMxMsgId() {
        return mxMsgId;
    }

    public void setMxMsgId(String mxMsgId) {
        this.mxMsgId = mxMsgId;
    }

    public String getMxSupplyInd() {
        return mxSupplyInd;
    }

    public void setMxSupplyInd(String mxSupplyInd) {
        this.mxSupplyInd = mxSupplyInd;
    }

    public String getMxAddInd() {
        return mxAddInd;
    }

    public void setMxAddInd(String mxAddInd) {
        this.mxAddInd = mxAddInd;
    }

    public ReqHead getReqHead() {
        return this.reqHead;
    }

    public void setReqHead(ReqHead reqHead) {
        this.reqHead = reqHead;
    }

    public String getFrontContent() {
        return this.frontContent;
    }

    public void setFrontContent(String frontContent) {
        this.frontContent = frontContent;
    }

    public String getMemopadContent() {
        return this.memopadContent;
    }

    public void setMemopadContent(String memopadContent) {
        this.memopadContent = memopadContent;
    }

    @Override
    public String toString() {
        return "ReceiveMxMsgReqDTO{" +
                "funCd='" + funCd + '\'' +
                ", errCd=" + errCd +
                ", frSys='" + frSys + '\'' +
                ", srcBk=" + srcBk +
                ", srcDt=" + srcDt +
                ", srcSeq='" + srcSeq + '\'' +
                ", resendInd='" + resendInd + '\'' +
                ", rejInd=" + rejInd +
                ", imposeInd=" + imposeInd +
                ", open='" + open + '\'' +
                ", msgSrc='" + msgSrc + '\'' +
                ", open1='" + open1 + '\'' +
                ", toSys='" + toSys + '\'' +
                ", msgNat='" + msgNat + '\'' +
                ", cvrSts='" + cvrSts + '\'' +
                ", frSys2='" + frSys2 + '\'' +
                ", relBk=" + relBk +
                ", relDt='" + relDt + '\'' +
                ", relSeq=" + relSeq +
                ", procSts='" + procSts + '\'' +
                ", tlxMailFg='" + tlxMailFg + '\'' +
                ", mt=" + mt +
                ", sender='" + sender + '\'' +
                ", trnRef='" + trnRef + '\'' +
                ", relRef='" + relRef + '\'' +
                ", osn=" + osn +
                ", inDueFmFg='" + inDueFmFg + '\'' +
                ", valDt=" + valDt +
                ", bkDt='" + bkDt + '\'' +
                ", rmtInd='" + rmtInd + '\'' +
                ", stlBk='" + stlBk + '\'' +
                ", stlAc=" + stlAc +
                ", stlCur='" + stlCur + '\'' +
                ", stlAmt=" + stlAmt +
                ", stlRt=" + stlRt +
                ", rmtCur='" + rmtCur + '\'' +
                ", rmtAmt=" + rmtAmt +
                ", ofacRst=" + ofacRst +
                ", msgFg='" + msgFg + '\'' +
                ", msgLen=" + msgLen +
                ", swiftInfo='" + swiftInfo + '\'' +
                ", rmk='" + rmk + '\'' +
                ", fininformFg='" + fininformFg + '\'' +
                ", gpiFg='" + gpiFg + '\'' +
                ", nxtDtFg='" + nxtDtFg + '\'' +
                ", rmcOrgRef='" + rmcOrgRef + '\'' +
                ", mxSessionId='" + mxSessionId + '\'' +
                ", mxSeqNum='" + mxSeqNum + '\'' +
                ", mxMsgId='" + mxMsgId + '\'' +
                ", mxSupplyInd='" + mxSupplyInd + '\'' +
                ", mxAddInd='" + mxAddInd + '\'' +
                ", reqHead=" + reqHead +
                ", frontContent='" + frontContent + '\'' +
                ", memopadContent='" + memopadContent + '\'' +
                '}';
    }
}
