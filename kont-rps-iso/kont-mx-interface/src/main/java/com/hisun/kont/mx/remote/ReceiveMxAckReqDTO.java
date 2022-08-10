package com.hisun.kont.mx.remote;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hisun.kont.common.utils.JudgeUtils;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;


public class ReceiveMxAckReqDTO {
    @ApiModelProperty(
            name = "funCd",
            value = "功能码"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @NotNull(
            message = "SYS20003"
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
    @NotNull(
            message = "SYS20003"
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
    @NotNull(
            message = "SYS20003"
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
            name = "resndInd",
            value = "resndInd"
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
            name = "swiftRST",
            value = "报文处理结果"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    @XmlElement(
            name = "SwiftRST"
    )
    private String swiftRST;
    @ApiModelProperty(
            name = "swiftRSTMsg",
            value = "报文返回信息"
    )
    @Size(
            max = 20,
            message = "SYS20002"
    )
    @XmlElement(
            name = "SwiftRSTMsg"
    )
    private String swiftRSTMsg;
    @ApiModelProperty(
            name = "fllr30",
            value = "30位填充"
    )
    @Size(
            max = 30,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Fllr30"
    )
    private String fllr30;
    @ApiModelProperty(
            name = "swiftISN",
            value = "swiftISN"
    )
    @Digits(
            integer = 6,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "SwiftISN"
    )
    private Integer swiftISN;
    @ApiModelProperty(
            name = "ssnNo",
            value = "会话编号"
    )
    @Digits(
            integer = 4,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    @XmlElement(
            name = "SsnNo"
    )
    private Integer ssnNo;
    @ApiModelProperty(
            name = "msgSOURCE2",
            value = "msgSOURCE2"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @XmlElement(
            name = "MsgSOURCE2"
    )
    private String msgSOURCE2;
    @ApiModelProperty(
            name = "eTERef",
            value = "eTERef"
    )
    @Size(
            max = 36,
            message = "SYS20002"
    )
    @XmlElement(
            name = "ETERef"
    )
    private String eTERef;
    @ApiModelProperty(
            name = "fllr",
            value = "23位填充"
    )
    @Size(
            max = 23,
            message = "SYS20002"
    )
    @XmlElement(
            name = "Fllr"
    )
    private String fllr;
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

    public ReceiveMxAckReqDTO() {
    }

//    @ApiModelProperty(
//            hidden = true
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

    public String getSwiftRST() {
        return this.swiftRST;
    }

    public void setSwiftRST(String swiftRST) {
        this.swiftRST = swiftRST;
    }

    public String getSwiftRSTMsg() {
        return this.swiftRSTMsg;
    }

    public void setSwiftRSTMsg(String swiftRSTMsg) {
        this.swiftRSTMsg = swiftRSTMsg;
    }

    public String getFllr30() {
        return this.fllr30;
    }

    public void setFllr30(String fllr30) {
        this.fllr30 = fllr30;
    }

    public Integer getSwiftISN() {
        return this.swiftISN;
    }

    public void setSwiftISN(Integer swiftISN) {
        this.swiftISN = swiftISN;
    }

    public Integer getSsnNo() {
        return this.ssnNo;
    }

    public void setSsnNo(Integer ssnNo) {
        this.ssnNo = ssnNo;
    }

    public String getMsgSOURCE2() {
        return this.msgSOURCE2;
    }

    public void setMsgSOURCE2(String msgSOURCE2) {
        this.msgSOURCE2 = msgSOURCE2;
    }

    public String geteTERef() {
        return this.eTERef;
    }

    public void seteTERef(String eTERef) {
        this.eTERef = eTERef;
    }

    public String getFllr() {
        return this.fllr;
    }

    public void setFllr(String fllr) {
        this.fllr = fllr;
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
        return "ReceiveMxAckReqDTO{" +
                "funCd='" + funCd + '\'' +
                ", errCd=" + errCd +
                ", frSys='" + frSys + '\'' +
                ", srcBk=" + srcBk +
                ", srcDt=" + srcDt +
                ", srcSeq='" + srcSeq + '\'' +
                ", resndInd='" + resndInd + '\'' +
                ", rejInd=" + rejInd +
                ", impsInd=" + impsInd +
                ", opn='" + opn + '\'' +
                ", msgSrc='" + msgSrc + '\'' +
                ", open1='" + open1 + '\'' +
                ", toSys='" + toSys + '\'' +
                ", swiftRST='" + swiftRST + '\'' +
                ", swiftRSTMsg='" + swiftRSTMsg + '\'' +
                ", fllr30='" + fllr30 + '\'' +
                ", swiftISN=" + swiftISN +
                ", ssnNo=" + ssnNo +
                ", msgSOURCE2='" + msgSOURCE2 + '\'' +
                ", eTERef='" + eTERef + '\'' +
                ", fllr='" + fllr + '\'' +
                ", reqHead=" + reqHead +
                ", frontContent='" + frontContent + '\'' +
                ", memopadContent='" + memopadContent + '\'' +
                '}';
    }
}
