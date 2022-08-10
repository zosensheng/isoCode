package com.hisun.kont.mx.remote;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class RspHead {

    @ApiModelProperty(
            name = "bankCode",
            value = "银行行号"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String bankCode;
    @ApiModelProperty(
            name = "branchCode",
            value = "机构号"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String branchCode;
    @ApiModelProperty(
            name = "txnCode",
            value = "交易碼"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String txnCode;
    @ApiModelProperty(
            name = "channel",
            value = "渠道"
    )
    @Size(
            max = 50,
            message = "SYS20002"
    )
    @Pattern(
            regexp = "BR|CBS|CTR|TBS|PAS|RMC|",
            message = "BR|CBS|CTR|TBS|PAS|RMC|"
    )
    private String channel;
    @ApiModelProperty(
            name = "subChannel",
            value = "子渠道"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    @Pattern(
            regexp = "CFI|CLM|GMB|GTB|MBK|SCO|SDR|SIM|SUB|GCS|",
            message = "CFI|CLM|GMB|GTB|MBK|SCO|SDR|SIM|SUB|GCS|"
    )
    private String subChannel;
    @ApiModelProperty(
            name = "terminalNo",
            value = "终端号"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String terminalNo;
    @ApiModelProperty(
            name = "refSeqNo",
            value = "业务流水号"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String refSeqNo;
    @ApiModelProperty(
            name = "journalNo",
            value = "日志号"
    )
    @Size(
            max = 12,
            message = "SYS20002"
    )
    private String journalNo;
    @ApiModelProperty(
            name = "acDate",
            value = "文件提交会计日期"
    )
    @Size(
            max = 10,
            message = "SYS20002"
    )
    private String acDate;
    @ApiModelProperty(
            name = "dateTimestamp",
            value = "交易完成時間"
    )
    private LocalDateTime dateTimestamp;
    @ApiModelProperty(
            name = "tellerID",
            value = "經辦櫃員"
    )
    @Size(
            max = 20,
            message = "SYS20002"
    )
    private String tellerID;
    @ApiModelProperty(
            name = "txnType",
            value = "交易類型"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    @Pattern(
            regexp = "O|I|",
            message = "O|I|"
    )
    private String txnType;
    @ApiModelProperty(
            name = "tipMsg",
            value = "提示信息"
    )
    @Size(
            max = 50,
            message = "SYS20002"
    )
    private String tipMsg;
    @ApiModelProperty(
            name = "errorMsg",
            value = "錯誤信息"
    )
    @Size(
            max = 50,
            message = "SYS20002"
    )
    private String errorMsg;
//    @Valid
//    @ApiModelProperty(
//            name = "authMsgs",
//            value = ""
//    )
//    private List<AuthMsg> authMsgs;
    @ApiModelProperty(
            name = "financialFlag",
            value = "金融标志"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String financialFlag;
    @ApiModelProperty(
            name = "eaiDmTxn",
            value = "eaiDmTxn"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String eaiDmTxn;
    @ApiModelProperty(
            name = "eaiRc",
            value = "eaiRc"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String eaiRc;
    @ApiModelProperty(
            name = "eaiHdrVerNo",
            value = "eaiHdrVerNo"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String eaiHdrVerNo;
    @ApiModelProperty(
            name = "txnMd",
            value = "txnMd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnMd;
    @ApiModelProperty(
            name = "srcAppId",
            value = "srcAppId"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String srcAppId;
    @ApiModelProperty(
            name = "txnDt",
            value = "txnDt"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String txnDt;
    @ApiModelProperty(
            name = "txnTm",
            value = "txnTm"
    )
    @Size(
            max = 6,
            message = "SYS20002"
    )
    private String txnTm;
    @ApiModelProperty(
            name = "timezone",
            value = "timezone"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String timezone;
    @ApiModelProperty(
            name = "srcAppLkgCnt",
            value = "srcAppLkgCnt"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String srcAppLkgCnt;
    @ApiModelProperty(
            name = "tlrInd",
            value = "tlrInd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String tlrInd;
    @ApiModelProperty(
            name = "eaiICCtrlFg",
            value = "eaiICCtrlFg"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String eaiICCtrlFg;
    @ApiModelProperty(
            name = "ovrSts",
            value = "ovrSts"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String ovrSts;
    @ApiModelProperty(
            name = "supId1",
            value = "supId1"
    )
    @Size(
            max = 7,
            message = "SYS20002"
    )
    private String supId1;
    @ApiModelProperty(
            name = "ovrLvl1",
            value = "ovrLvl1"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String ovrLvl1;
    @ApiModelProperty(
            name = "supId2",
            value = "supId2"
    )
    @Size(
            max = 7,
            message = "SYS20002"
    )
    private String supId2;
    @ApiModelProperty(
            name = "overLvl2",
            value = "overLvl2"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String overLvl2;
    @ApiModelProperty(
            name = "orgTmlNo",
            value = "orgTmlNo"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String orgTmlNo;
    @ApiModelProperty(
            name = "orgTmlId",
            value = "orgTmlId"
    )
    @Size(
            max = 15,
            message = "SYS20002"
    )
    private String orgTmlId;
    @ApiModelProperty(
            name = "deptCd",
            value = "deptCd"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String deptCd;
    @ApiModelProperty(
            name = "divCd",
            value = "divCd"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String divCd;
    @ApiModelProperty(
            name = "eaiSrcRgnCd",
            value = "eaiSrcRgnCd"
    )
    @Size(
            max = 4,
            message = "SYS20002"
    )
    private String eaiSrcRgnCd;
    @ApiModelProperty(
            name = "chnlId",
            value = "渠道号"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String chnlId;
    @ApiModelProperty(
            name = "txnReqRv",
            value = "txnReqRv"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnReqRv;
    @ApiModelProperty(
            name = "etyCnt",
            value = "etyCnt"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String etyCnt;
    @ApiModelProperty(
            name = "comApplId",
            value = "comApplId"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String comApplId;
    @ApiModelProperty(
            name = "comTxnId",
            value = "comTxnId"
    )
    @Size(
            max = 10,
            message = "SYS20002"
    )
    private String comTxnId;
    @ApiModelProperty(
            name = "opnFld",
            value = "opnFld"
    )
    @Size(
            max = 42,
            message = "SYS20002"
    )
    private String opnFld;
    @ApiModelProperty(
            name = "txnPrty",
            value = "txnPrty"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnPrty;
    @ApiModelProperty(
            name = "tarRgnCd",
            value = "tarRgnCd"
    )
    @Size(
            max = 4,
            message = "SYS20002"
    )
    private String tarRgnCd;
    @ApiModelProperty(
            name = "tarAppId",
            value = "tarAppId"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String tarAppId;
    @ApiModelProperty(
            name = "txnSts",
            value = "txnSts"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnSts;
    @ApiModelProperty(
            name = "txnRpyCd",
            value = "txnRpyCd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnRpyCd;
    @ApiModelProperty(
            name = "txnErrCd",
            value = "txnErrCd"
    )
    @Size(
            max = 6,
            message = "SYS20002"
    )
    private String txnErrCd;
    @ApiModelProperty(
            name = "txnOvrSts",
            value = "txnOvrSts"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnOvrSts;
    @ApiModelProperty(
            name = "txnReqOvrLv1",
            value = "txnReqOvrLv1"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String txnReqOvrLv1;
    @ApiModelProperty(
            name = "txnReqOvrLv2",
            value = "txnReqOvrLv2"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String txnReqOvrLv2;
    @ApiModelProperty(
            name = "ovrAmt",
            value = "ovrAmt"
    )
    @Size(
            max = 15,
            message = "SYS20002"
    )
    private String ovrAmt;
    @ApiModelProperty(
            name = "txnEndInd",
            value = "txnEndInd"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnEndInd;
    @ApiModelProperty(
            name = "txnDataLen",
            value = "txnDataLen"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String txnDataLen;
    @ApiModelProperty(
            name = "txnBkCd",
            value = "txnBkCd"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String txnBkCd;
    @ApiModelProperty(
            name = "txnBrCd",
            value = "txnBrCd"
    )
    @Size(
            max = 5,
            message = "SYS20002"
    )
    private String txnBrCd;
    @ApiModelProperty(
            name = "txnICSeq",
            value = "txnICSeq"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String txnICSeq;
    @ApiModelProperty(
            name = "txnUpdOrigTot",
            value = "txnUpdOrigTot"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnUpdOrigTot;
    @ApiModelProperty(
            name = "tarAcDt",
            value = "tarAcDt"
    )
    @Size(
            max = 8,
            message = "SYS20002"
    )
    private String tarAcDt;
    @ApiModelProperty(
            name = "apTrNo",
            value = "apTrNo"
    )
    @Size(
            max = 32,
            message = "SYS20002"
    )
    private String apTrNo;
    @ApiModelProperty(
            name = "apRc",
            value = "apRc"
    )
    @Size(
            max = 10,
            message = "SYS20002"
    )
    private String apRc;
    @ApiModelProperty(
            name = "prodCd",
            value = "产品码"
    )
    @Size(
            max = 20,
            message = "SYS20002"
    )
    private String prodCd;
    @ApiModelProperty(
            name = "extFlg",
            value = "extFlg"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String extFlg;
    @ApiModelProperty(
            name = "opnFld2",
            value = "opnFld2"
    )
    @Size(
            max = 43,
            message = "SYS20002"
    )
    private String opnFld2;
    @ApiModelProperty(
            name = "srcTxnId",
            value = "srcTxnId"
    )
    @Size(
            max = 10,
            message = "SYS20002"
    )
    private String srcTxnId;
    @ApiModelProperty(
            name = "srcAppJnlNo",
            value = "srcAppJnlNo"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String srcAppJnlNo;
    @ApiModelProperty(
            name = "ovrLvl2",
            value = "ovrLvl2"
    )
    @Size(
            max = 2,
            message = "SYS20002"
    )
    private String ovrLvl2;
    @ApiModelProperty(
            name = "tlrId",
            value = "tlrId"
    )
    @Size(
            max = 7,
            message = "SYS20002"
    )
    private String tlrId;
    @ApiModelProperty(
            name = "authId",
            value = "授权ID"
    )
    @Digits(
            integer = 8,
            message = "PARAMTER FORMAT ERROR",
            fraction = 0
    )
    private Integer authId;
    @ApiModelProperty(
            name = "txnTp",
            value = "txnTp"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String txnTp;
    @ApiModelProperty(
            name = "authorizeTeller1",
            value = "授权柜员1"
    )
    @Size(
            max = 20,
            message = "SYS20002"
    )
    private String authorizeTeller1;
    @ApiModelProperty(
            name = "authorizeTeller2",
            value = "授权柜员2"
    )
    @Size(
            max = 20,
            message = "SYS20002"
    )
    private String authorizeTeller2;
//    @Valid
//    @ApiModelProperty(
//            name = "jnl0001s",
//            value = ""
//    )
//    private List<Jnl0001> jnl0001s;
//    @Valid
//    @ApiModelProperty(
//            name = "jnl0002s",
//            value = ""
//    )
//    private List<Jnl0002> jnl0002s;
    @ApiModelProperty(
            name = "journal0001",
            value = "journal0001"
    )
    @Size(
            max = 9999,
            message = "SYS20002"
    )
    private String journal0001;
    @ApiModelProperty(
            name = "uuid",
            value = "uuid"
    )
    @Size(
            max = 32,
            message = "SYS20002"
    )
    private String uuid;
    @ApiModelProperty(
            name = "needAuthLevel1",
            value = "需要授权级别1"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String needAuthLevel1;
    @ApiModelProperty(
            name = "revFlag",
            value = "经办复核标志"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String revFlag;
    @ApiModelProperty(
            name = "needAuthLevel2",
            value = "需要授权级别2"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String needAuthLevel2;
    @ApiModelProperty(
            name = "refSeqSubNo",
            value = "业务子流水号"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String refSeqSubNo;
    @ApiModelProperty(
            name = "refJournalNo",
            value = "业务日志号"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String refJournalNo;
    @ApiModelProperty(
            name = "holOnlineFlag",
            value = "假日联机标志"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String holOnlineFlag;
    @ApiModelProperty(
            name = "needDeAuthLevel1",
            value = "需要可降级授权级别1"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String needDeAuthLevel1;
    @ApiModelProperty(
            name = "needDeAuthLevel2",
            value = "需要可降级授权级别2"
    )
    @Size(
            max = 3,
            message = "SYS20002"
    )
    private String needDeAuthLevel2;
    @ApiModelProperty(
            name = "tarAppJnlNo",
            value = "tarAppJnlNo"
    )
    @Size(
            max = 11,
            message = "SYS20002"
    )
    private String tarAppJnlNo;
    @ApiModelProperty(
            name = "computerName",
            value = "设备名称"
    )
    @Size(
            max = 15,
            message = "SYS20002"
    )
    private String computerName;
    @ApiModelProperty(
            name = "icAuthFlag",
            value = "ic授权标志"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String icAuthFlag;
    @ApiModelProperty(
            name = "ourRef",
            value = "付款業務編號"
    )
    @Size(
            max = 16,
            message = "SYS20002"
    )
    private String ourRef;
    @ApiModelProperty(
            name = "centerBankFlag",
            value = "centerBankFlag"
    )
    @Size(
            max = 1,
            message = "SYS20002"
    )
    private String centerBankFlag;

    public RspHead() {
    }

    public String getBankCode() {
        return this.bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBranchCode() {
        return this.branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getTxnCode() {
        return this.txnCode;
    }

    public void setTxnCode(String txnCode) {
        this.txnCode = txnCode;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSubChannel() {
        return this.subChannel;
    }

    public void setSubChannel(String subChannel) {
        this.subChannel = subChannel;
    }

    public String getTerminalNo() {
        return this.terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getRefSeqNo() {
        return this.refSeqNo;
    }

    public void setRefSeqNo(String refSeqNo) {
        this.refSeqNo = refSeqNo;
    }

    public String getJournalNo() {
        return this.journalNo;
    }

    public void setJournalNo(String journalNo) {
        this.journalNo = journalNo;
    }

    public String getAcDate() {
        return this.acDate;
    }

    public void setAcDate(String acDate) {
        this.acDate = acDate;
    }

    public LocalDateTime getDateTimestamp() {
        return this.dateTimestamp;
    }

    public void setDateTimestamp(LocalDateTime dateTimestamp) {
        this.dateTimestamp = dateTimestamp;
    }

    public String getTellerID() {
        return this.tellerID;
    }

    public void setTellerID(String tellerID) {
        this.tellerID = tellerID;
    }

    public String getTxnType() {
        return this.txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public void setTipMsg(String tipMsg) {
        this.tipMsg = tipMsg;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

//    public List<AuthMsg> getAuthMsgs() {
//        return this.authMsgs;
//    }
//
//    public void setAuthMsgs(List<AuthMsg> authMsgs) {
//        this.authMsgs = authMsgs;
//    }

    public String getFinancialFlag() {
        return this.financialFlag;
    }

    public void setFinancialFlag(String financialFlag) {
        this.financialFlag = financialFlag;
    }

    public String getEaiDmTxn() {
        return this.eaiDmTxn;
    }

    public void setEaiDmTxn(String eaiDmTxn) {
        this.eaiDmTxn = eaiDmTxn;
    }

    public String getEaiRc() {
        return this.eaiRc;
    }

    public void setEaiRc(String eaiRc) {
        this.eaiRc = eaiRc;
    }

    public String getEaiHdrVerNo() {
        return this.eaiHdrVerNo;
    }

    public void setEaiHdrVerNo(String eaiHdrVerNo) {
        this.eaiHdrVerNo = eaiHdrVerNo;
    }

    public String getTxnMd() {
        return this.txnMd;
    }

    public void setTxnMd(String txnMd) {
        this.txnMd = txnMd;
    }

    public String getSrcAppId() {
        return this.srcAppId;
    }

    public void setSrcAppId(String srcAppId) {
        this.srcAppId = srcAppId;
    }

    public String getTxnDt() {
        return this.txnDt;
    }

    public void setTxnDt(String txnDt) {
        this.txnDt = txnDt;
    }

    public String getTxnTm() {
        return this.txnTm;
    }

    public void setTxnTm(String txnTm) {
        this.txnTm = txnTm;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getSrcAppLkgCnt() {
        return this.srcAppLkgCnt;
    }

    public void setSrcAppLkgCnt(String srcAppLkgCnt) {
        this.srcAppLkgCnt = srcAppLkgCnt;
    }

    public String getTlrInd() {
        return this.tlrInd;
    }

    public void setTlrInd(String tlrInd) {
        this.tlrInd = tlrInd;
    }

    public String getEaiICCtrlFg() {
        return this.eaiICCtrlFg;
    }

    public void setEaiICCtrlFg(String eaiICCtrlFg) {
        this.eaiICCtrlFg = eaiICCtrlFg;
    }

    public String getOvrSts() {
        return this.ovrSts;
    }

    public void setOvrSts(String ovrSts) {
        this.ovrSts = ovrSts;
    }

    public String getSupId1() {
        return this.supId1;
    }

    public void setSupId1(String supId1) {
        this.supId1 = supId1;
    }

    public String getOvrLvl1() {
        return this.ovrLvl1;
    }

    public void setOvrLvl1(String ovrLvl1) {
        this.ovrLvl1 = ovrLvl1;
    }

    public String getSupId2() {
        return this.supId2;
    }

    public void setSupId2(String supId2) {
        this.supId2 = supId2;
    }

    public String getOverLvl2() {
        return this.overLvl2;
    }

    public void setOverLvl2(String overLvl2) {
        this.overLvl2 = overLvl2;
    }

    public String getOrgTmlNo() {
        return this.orgTmlNo;
    }

    public void setOrgTmlNo(String orgTmlNo) {
        this.orgTmlNo = orgTmlNo;
    }

    public String getOrgTmlId() {
        return this.orgTmlId;
    }

    public void setOrgTmlId(String orgTmlId) {
        this.orgTmlId = orgTmlId;
    }

    public String getDeptCd() {
        return this.deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getDivCd() {
        return this.divCd;
    }

    public void setDivCd(String divCd) {
        this.divCd = divCd;
    }

    public String getEaiSrcRgnCd() {
        return this.eaiSrcRgnCd;
    }

    public void setEaiSrcRgnCd(String eaiSrcRgnCd) {
        this.eaiSrcRgnCd = eaiSrcRgnCd;
    }

    public String getChnlId() {
        return this.chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId;
    }

    public String getTxnReqRv() {
        return this.txnReqRv;
    }

    public void setTxnReqRv(String txnReqRv) {
        this.txnReqRv = txnReqRv;
    }

    public String getEtyCnt() {
        return this.etyCnt;
    }

    public void setEtyCnt(String etyCnt) {
        this.etyCnt = etyCnt;
    }

    public String getComApplId() {
        return this.comApplId;
    }

    public void setComApplId(String comApplId) {
        this.comApplId = comApplId;
    }

    public String getComTxnId() {
        return this.comTxnId;
    }

    public void setComTxnId(String comTxnId) {
        this.comTxnId = comTxnId;
    }

    public String getOpnFld() {
        return this.opnFld;
    }

    public void setOpnFld(String opnFld) {
        this.opnFld = opnFld;
    }

    public String getTxnPrty() {
        return this.txnPrty;
    }

    public void setTxnPrty(String txnPrty) {
        this.txnPrty = txnPrty;
    }

    public String getTarRgnCd() {
        return this.tarRgnCd;
    }

    public void setTarRgnCd(String tarRgnCd) {
        this.tarRgnCd = tarRgnCd;
    }

    public String getTarAppId() {
        return this.tarAppId;
    }

    public void setTarAppId(String tarAppId) {
        this.tarAppId = tarAppId;
    }

    public String getTxnSts() {
        return this.txnSts;
    }

    public void setTxnSts(String txnSts) {
        this.txnSts = txnSts;
    }

    public String getTxnRpyCd() {
        return this.txnRpyCd;
    }

    public void setTxnRpyCd(String txnRpyCd) {
        this.txnRpyCd = txnRpyCd;
    }

    public String getTxnErrCd() {
        return this.txnErrCd;
    }

    public void setTxnErrCd(String txnErrCd) {
        this.txnErrCd = txnErrCd;
    }

    public String getTxnOvrSts() {
        return this.txnOvrSts;
    }

    public void setTxnOvrSts(String txnOvrSts) {
        this.txnOvrSts = txnOvrSts;
    }

    public String getTxnReqOvrLv1() {
        return this.txnReqOvrLv1;
    }

    public void setTxnReqOvrLv1(String txnReqOvrLv1) {
        this.txnReqOvrLv1 = txnReqOvrLv1;
    }

    public String getTxnReqOvrLv2() {
        return this.txnReqOvrLv2;
    }

    public void setTxnReqOvrLv2(String txnReqOvrLv2) {
        this.txnReqOvrLv2 = txnReqOvrLv2;
    }

    public String getOvrAmt() {
        return this.ovrAmt;
    }

    public void setOvrAmt(String ovrAmt) {
        this.ovrAmt = ovrAmt;
    }

    public String getTxnEndInd() {
        return this.txnEndInd;
    }

    public void setTxnEndInd(String txnEndInd) {
        this.txnEndInd = txnEndInd;
    }

    public String getTxnDataLen() {
        return this.txnDataLen;
    }

    public void setTxnDataLen(String txnDataLen) {
        this.txnDataLen = txnDataLen;
    }

    public String getTxnBkCd() {
        return this.txnBkCd;
    }

    public void setTxnBkCd(String txnBkCd) {
        this.txnBkCd = txnBkCd;
    }

    public String getTxnBrCd() {
        return this.txnBrCd;
    }

    public void setTxnBrCd(String txnBrCd) {
        this.txnBrCd = txnBrCd;
    }

    public String getTxnICSeq() {
        return this.txnICSeq;
    }

    public void setTxnICSeq(String txnICSeq) {
        this.txnICSeq = txnICSeq;
    }

    public String getTxnUpdOrigTot() {
        return this.txnUpdOrigTot;
    }

    public void setTxnUpdOrigTot(String txnUpdOrigTot) {
        this.txnUpdOrigTot = txnUpdOrigTot;
    }

    public String getTarAcDt() {
        return this.tarAcDt;
    }

    public void setTarAcDt(String tarAcDt) {
        this.tarAcDt = tarAcDt;
    }

    public String getApTrNo() {
        return this.apTrNo;
    }

    public void setApTrNo(String apTrNo) {
        this.apTrNo = apTrNo;
    }

    public String getApRc() {
        return this.apRc;
    }

    public void setApRc(String apRc) {
        this.apRc = apRc;
    }

    public String getProdCd() {
        return this.prodCd;
    }

    public void setProdCd(String prodCd) {
        this.prodCd = prodCd;
    }

    public String getExtFlg() {
        return this.extFlg;
    }

    public void setExtFlg(String extFlg) {
        this.extFlg = extFlg;
    }

    public String getOpnFld2() {
        return this.opnFld2;
    }

    public void setOpnFld2(String opnFld2) {
        this.opnFld2 = opnFld2;
    }

    public String getSrcTxnId() {
        return this.srcTxnId;
    }

    public void setSrcTxnId(String srcTxnId) {
        this.srcTxnId = srcTxnId;
    }

    public String getSrcAppJnlNo() {
        return this.srcAppJnlNo;
    }

    public void setSrcAppJnlNo(String srcAppJnlNo) {
        this.srcAppJnlNo = srcAppJnlNo;
    }

    public String getOvrLvl2() {
        return this.ovrLvl2;
    }

    public void setOvrLvl2(String ovrLvl2) {
        this.ovrLvl2 = ovrLvl2;
    }

    public String getTlrId() {
        return this.tlrId;
    }

    public void setTlrId(String tlrId) {
        this.tlrId = tlrId;
    }

    public Integer getAuthId() {
        return this.authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getTxnTp() {
        return this.txnTp;
    }

    public void setTxnTp(String txnTp) {
        this.txnTp = txnTp;
    }

    public String getAuthorizeTeller1() {
        return this.authorizeTeller1;
    }

    public void setAuthorizeTeller1(String authorizeTeller1) {
        this.authorizeTeller1 = authorizeTeller1;
    }

    public String getAuthorizeTeller2() {
        return this.authorizeTeller2;
    }

    public void setAuthorizeTeller2(String authorizeTeller2) {
        this.authorizeTeller2 = authorizeTeller2;
    }

//    public List<Jnl0001> getJnl0001s() {
//        return this.jnl0001s;
//    }
//
//    public void setJnl0001s(List<Jnl0001> jnl0001s) {
//        this.jnl0001s = jnl0001s;
//    }
//
//    public List<Jnl0002> getJnl0002s() {
//        return this.jnl0002s;
//    }
//
//    public void setJnl0002s(List<Jnl0002> jnl0002s) {
//        this.jnl0002s = jnl0002s;
//    }

    public String getJournal0001() {
        return this.journal0001;
    }

    public void setJournal0001(String journal0001) {
        this.journal0001 = journal0001;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNeedAuthLevel1() {
        return this.needAuthLevel1;
    }

    public void setNeedAuthLevel1(String needAuthLevel1) {
        this.needAuthLevel1 = needAuthLevel1;
    }

    public String getRevFlag() {
        return this.revFlag;
    }

    public void setRevFlag(String revFlag) {
        this.revFlag = revFlag;
    }

    public String getNeedAuthLevel2() {
        return this.needAuthLevel2;
    }

    public void setNeedAuthLevel2(String needAuthLevel2) {
        this.needAuthLevel2 = needAuthLevel2;
    }

    public String getRefSeqSubNo() {
        return this.refSeqSubNo;
    }

    public void setRefSeqSubNo(String refSeqSubNo) {
        this.refSeqSubNo = refSeqSubNo;
    }

    public String getRefJournalNo() {
        return this.refJournalNo;
    }

    public void setRefJournalNo(String refJournalNo) {
        this.refJournalNo = refJournalNo;
    }

    public String getHolOnlineFlag() {
        return this.holOnlineFlag;
    }

    public void setHolOnlineFlag(String holOnlineFlag) {
        this.holOnlineFlag = holOnlineFlag;
    }

    public String getNeedDeAuthLevel1() {
        return this.needDeAuthLevel1;
    }

    public void setNeedDeAuthLevel1(String needDeAuthLevel1) {
        this.needDeAuthLevel1 = needDeAuthLevel1;
    }

    public String getNeedDeAuthLevel2() {
        return this.needDeAuthLevel2;
    }

    public void setNeedDeAuthLevel2(String needDeAuthLevel2) {
        this.needDeAuthLevel2 = needDeAuthLevel2;
    }

    public String getTarAppJnlNo() {
        return this.tarAppJnlNo;
    }

    public void setTarAppJnlNo(String tarAppJnlNo) {
        this.tarAppJnlNo = tarAppJnlNo;
    }

    public String getComputerName() {
        return this.computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getIcAuthFlag() {
        return this.icAuthFlag;
    }

    public void setIcAuthFlag(String icAuthFlag) {
        this.icAuthFlag = icAuthFlag;
    }

    public String getOurRef() {
        return this.ourRef;
    }

    public void setOurRef(String ourRef) {
        this.ourRef = ourRef;
    }

    public String getCenterBankFlag() {
        return this.centerBankFlag;
    }

    public void setCenterBankFlag(String centerBankFlag) {
        this.centerBankFlag = centerBankFlag;
    }

    @Override
    public String toString() {
        return "RspHead{" +
                "bankCode='" + bankCode + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", txnCode='" + txnCode + '\'' +
                ", channel='" + channel + '\'' +
                ", subChannel='" + subChannel + '\'' +
                ", terminalNo='" + terminalNo + '\'' +
                ", refSeqNo='" + refSeqNo + '\'' +
                ", journalNo='" + journalNo + '\'' +
                ", acDate='" + acDate + '\'' +
                ", dateTimestamp=" + dateTimestamp +
                ", tellerID='" + tellerID + '\'' +
                ", txnType='" + txnType + '\'' +
                ", tipMsg='" + tipMsg + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                ", financialFlag='" + financialFlag + '\'' +
                ", eaiDmTxn='" + eaiDmTxn + '\'' +
                ", eaiRc='" + eaiRc + '\'' +
                ", eaiHdrVerNo='" + eaiHdrVerNo + '\'' +
                ", txnMd='" + txnMd + '\'' +
                ", srcAppId='" + srcAppId + '\'' +
                ", txnDt='" + txnDt + '\'' +
                ", txnTm='" + txnTm + '\'' +
                ", timezone='" + timezone + '\'' +
                ", srcAppLkgCnt='" + srcAppLkgCnt + '\'' +
                ", tlrInd='" + tlrInd + '\'' +
                ", eaiICCtrlFg='" + eaiICCtrlFg + '\'' +
                ", ovrSts='" + ovrSts + '\'' +
                ", supId1='" + supId1 + '\'' +
                ", ovrLvl1='" + ovrLvl1 + '\'' +
                ", supId2='" + supId2 + '\'' +
                ", overLvl2='" + overLvl2 + '\'' +
                ", orgTmlNo='" + orgTmlNo + '\'' +
                ", orgTmlId='" + orgTmlId + '\'' +
                ", deptCd='" + deptCd + '\'' +
                ", divCd='" + divCd + '\'' +
                ", eaiSrcRgnCd='" + eaiSrcRgnCd + '\'' +
                ", chnlId='" + chnlId + '\'' +
                ", txnReqRv='" + txnReqRv + '\'' +
                ", etyCnt='" + etyCnt + '\'' +
                ", comApplId='" + comApplId + '\'' +
                ", comTxnId='" + comTxnId + '\'' +
                ", opnFld='" + opnFld + '\'' +
                ", txnPrty='" + txnPrty + '\'' +
                ", tarRgnCd='" + tarRgnCd + '\'' +
                ", tarAppId='" + tarAppId + '\'' +
                ", txnSts='" + txnSts + '\'' +
                ", txnRpyCd='" + txnRpyCd + '\'' +
                ", txnErrCd='" + txnErrCd + '\'' +
                ", txnOvrSts='" + txnOvrSts + '\'' +
                ", txnReqOvrLv1='" + txnReqOvrLv1 + '\'' +
                ", txnReqOvrLv2='" + txnReqOvrLv2 + '\'' +
                ", ovrAmt='" + ovrAmt + '\'' +
                ", txnEndInd='" + txnEndInd + '\'' +
                ", txnDataLen='" + txnDataLen + '\'' +
                ", txnBkCd='" + txnBkCd + '\'' +
                ", txnBrCd='" + txnBrCd + '\'' +
                ", txnICSeq='" + txnICSeq + '\'' +
                ", txnUpdOrigTot='" + txnUpdOrigTot + '\'' +
                ", tarAcDt='" + tarAcDt + '\'' +
                ", apTrNo='" + apTrNo + '\'' +
                ", apRc='" + apRc + '\'' +
                ", prodCd='" + prodCd + '\'' +
                ", extFlg='" + extFlg + '\'' +
                ", opnFld2='" + opnFld2 + '\'' +
                ", srcTxnId='" + srcTxnId + '\'' +
                ", srcAppJnlNo='" + srcAppJnlNo + '\'' +
                ", ovrLvl2='" + ovrLvl2 + '\'' +
                ", tlrId='" + tlrId + '\'' +
                ", authId=" + authId +
                ", txnTp='" + txnTp + '\'' +
                ", authorizeTeller1='" + authorizeTeller1 + '\'' +
                ", authorizeTeller2='" + authorizeTeller2 + '\'' +
                ", journal0001='" + journal0001 + '\'' +
                ", uuid='" + uuid + '\'' +
                ", needAuthLevel1='" + needAuthLevel1 + '\'' +
                ", revFlag='" + revFlag + '\'' +
                ", needAuthLevel2='" + needAuthLevel2 + '\'' +
                ", refSeqSubNo='" + refSeqSubNo + '\'' +
                ", refJournalNo='" + refJournalNo + '\'' +
                ", holOnlineFlag='" + holOnlineFlag + '\'' +
                ", needDeAuthLevel1='" + needDeAuthLevel1 + '\'' +
                ", needDeAuthLevel2='" + needDeAuthLevel2 + '\'' +
                ", tarAppJnlNo='" + tarAppJnlNo + '\'' +
                ", computerName='" + computerName + '\'' +
                ", icAuthFlag='" + icAuthFlag + '\'' +
                ", ourRef='" + ourRef + '\'' +
                ", centerBankFlag='" + centerBankFlag + '\'' +
                '}';
    }
}
