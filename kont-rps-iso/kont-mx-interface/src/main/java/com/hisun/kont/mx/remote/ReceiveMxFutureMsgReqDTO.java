//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.hisun.kont.mx.remote;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
        name = "FrmData"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMxFutureMsgReqDTO {
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
    @XmlElement(
            name = "SrcSeq"
    )
    private String srcSeq;
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
            name = "ImpsInd"
    )
    private Integer impsInd;
    @ApiModelProperty(
            name = "opn",
            value = "9位预留字段"
    )
    @Size(
            max = 9,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Opn"
    )
    private String opn;
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
            name = "sndr",
            value = "发报人"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Sndr"
    )
    private String sndr;
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
            max = 10000,
            message = "SYS20002"
    )
    @XmlElement(
            name = "SwiftInfo"
    )
    private String swiftInfo;
    @ApiModelProperty(
            name = "RmcOrgRef",
            value = "Rmc MX原文參考號"
    )
    @Size(
            max = 35,
            message = "SYS20002"
    )
    @XmlElement(
            name = "RmcOrgRef"
    )
    private String rmcOrgRef;

    @ApiModelProperty(
            name = "MxSessionID",
            value = "存放FTM下送收文通讯级reference"
    )
    @Size(
            max = 50,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MxSessionID"
    )
    private String mxSessionID;

    @ApiModelProperty(
            name = "MxSeqNum",
            value = "存放FTM下送收文通讯级reference"
    )
    @Size(
            max = 10,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MxSeqNum"
    )
    private String mxSeqNum;

    @ApiModelProperty(
            name = "MxMsgId",
            value = "存放报文标识号"
    )
    @Size(
            max = 35,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MxMsgId"
    )
    private String mxMsgId;

    @ApiModelProperty(
            name = "MxSupplyInd",
            value = "存放RMC转换的mx报文"
    )
//    @Size(
//            max = 35,
//            message = "SYS20002"
//    )
    @XmlElement(
            name = "MxSupplyInd"
    )
    private String mxSupplyInd;

    @ApiModelProperty(
            name = "MxAddInd",
            value = "存放MX新增但未能转换到MT的资料"
    )
//    @Size(
//            max = 35,
//            message = "SYS20002"
//    )
    @XmlElement(
            name = "MxAddInd"
    )
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

    public ReceiveMxFutureMsgReqDTO() {
    }

//    @ApiModelProperty(
//        hidden = true
//    )
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

    public String getOpn() {
        return this.opn;
    }

    public void setOpn(String opn) {
        this.opn = opn;
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

    public Integer getMt() {
        return this.mt;
    }

    public void setMt(Integer mt) {
        this.mt = mt;
    }

    public String getSndr() {
        return this.sndr;
    }

    public void setSndr(String sndr) {
        this.sndr = sndr;
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

    public LocalDate getValDt() {
        return this.valDt;
    }

    public void setValDt(LocalDate valDt) {
        this.valDt = valDt;
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

    public String getRmcOrgRef() {
        return rmcOrgRef;
    }

    public void setRmcOrgRef(String rmcOrgRef) {
        this.rmcOrgRef = rmcOrgRef;
    }

    public String getMxSessionID() {
        return mxSessionID;
    }

    public void setMxSessionID(String mxSessionID) {
        this.mxSessionID = mxSessionID;
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

    public String toString() {
        return "ReceiveFutureMsgReqDTO {funCd = '" + this.funCd + "', errCd = '" + this.errCd + "', frSys = '" + this.frSys + "', srcBk = '" + this.srcBk + "', srcDt = '" + this.srcDt + "', srcSeq = '" + this.srcSeq + "', resndInd = '" + this.resndInd + "', rejInd = '" + this.rejInd + "', impsInd = '" + this.impsInd + "', opn = '" + this.opn + "', msgSrc = '" + this.msgSrc + "', open1 = '" + this.open1 + "', toSys = '" + this.toSys + "', mt = '" + this.mt + "', sndr = '" + this.sndr + "', trnRef = '" + this.trnRef + "', relRef = '" + this.relRef + "', valDt = '" + this.valDt + "', rmtCur = '" + this.rmtCur + "', rmtAmt = '" + this.rmtAmt + "', ofacRst = '" + this.ofacRst + "', msgFg = '" + this.msgFg + "', msgLen = '" + this.msgLen + "', swiftInfo = '" + this.swiftInfo + "', reqHead = '" + this.reqHead + "', frontContent = '" + this.frontContent + "', memopadContent = '" + this.memopadContent + "', rmcOrgRef = '" + this.rmcOrgRef + "', mxSessionID = '" + this.mxSessionID + "', mxSeqNum = '" + this.mxSeqNum + "', mxMsgId = '" + this.mxMsgId + "', mxSupplyInd = '" + this.mxSupplyInd + "', mxAddInd = '" + this.mxAddInd + "'}";
    }
}
