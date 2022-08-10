package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * entity:Pgsts
 *
 * @author
 * @version 3.0
 * @date 2021-7-23
 */
public class PgstsDO extends BaseDO {

	private static final long serialVersionUID = 1L;

	/* 邏輯終端地址 */
	private String bhSndlt;

	/* 接收地址 */
	private String ahRcvlt;

	/* 電文優先級 */
	private String ahMpro;

	/* chats電文標誌 */
	private String ohHkl;

	/* 電報用戶參號 */
	private String ohMuref;

	/* cover電文標誌 */
	private String ohCov;

	/* GPI編號 */
	private String ohGpiRef;

	/* 業務編號 */
	private String trn;

	/* 相關業務編號 */
	private String rtrn;

	/* 记录顺序号 */
	private Integer mtSeq;

	/* 重发标志 */
	private String mtRetryFlag;

	/* PDM/PDE 编号 */
	private String mtPdmNm;

	/* mtPdeNm */
	private String mtPdeNm;

	/* 报文组装内容 */
	private String mtStr;

	/* 电文状态码 */
	private String mtStatus;

	/* gpiStatus */
	private String gpiStatus;

	/* 创建时间 */
	private LocalDateTime createdTime;

	/* 最後修改時間 */
	private LocalDateTime updateLastTime;

	/* 报文对象Json格式内容 */
	private String mtBean;

	/* 最後修改終端號 */
	private Integer updateLastTerm;

	/* 最後修改櫃員 */
	private String updateLastTeller;

	/* 最新修改授權櫃員 */
	private String updateLastAuthor;

	/* 授權櫃員提示信息 */
	private String authorReminderMsg;

	/* 審計信息 */
	private String authorComment;

	/* 無需審批記錄狀態 */
	private String recordStatusNoauthor;

	/* 最後交易代碼 */
	private String updateLastTxnCode;

	/* 拒絕信息碼 */
	private String rejectCode;

	/* 刪除請求標誌 */
	private String clearReqFlag;

	/* 报文打印格式 */
	private String mtMessage;

	/* srcSys */
	private String srcSys;

	/* 目标系统 */
	private String targetSys;

	/* 關聯的報文方式 */
	private String msgMethod;

	/* message Source */
	private String msgSrc;

	/* 暂存报文标志 */
	private String mtTemporary;

	/* 所属模块 */
	private String frModule;

	/* 手动标识 */
	private String manualFg;

	/* GPI原因码 */
	private String gpiReasonCode;

	/* 報文編號 */
	private String msgNo;

	/* 基本報頭對話序號 */
	private String bhSessNo;

	/* 基本報頭ISN發報序號 */
	private String bhIsn;

	/* 報文類別 */
	private String ahMt;

	/* 报文输入输出标志 */
	private String ahioFlag;

	/* GPI电文标志 */
	private String gpiFlag;

	/*future报文标志*/
	private String futureFg;

	/* 会计日 */
	private LocalDate acDate;

	/* 繁体电码标识 */
	private String traditionalFlag;

	/* 業務編號 */
	private String pagmchOurRef;

	/* 其他業務編號標誌 */
	private String refSub;

	/* 發動交易渠道 */
	private String yourChl;

	/* 報文收入日期 */
	private String incomeDate;

	/* 報文收入時間 */
	private String incomeTime;

	/* 收入電文所在時區 */
	private String incomeTimeZone;

	/* 最后更新会计日 */
	private LocalDate updateLastAcDate;

	/* 日志号 */
	private String logNumber;

	/* RMC返回报文失败原因 */
	private String rejectedReason;

	/* 报文流程状态 */
	private String gwMsgStatus;

	/* 交易碼 */
	private String txncode;

	/* GPI日期 */
	private String gpiDate;

	/* GPI时间 */
	private String gpiTime;

	/* GPI时区 */
	private String gpiTimezone;

	/* 重发任务id */
	private String retransmissionId;

	/* F111 GPC報文標誌 */
	private String gpcFlag;

	/* GPIN99的F79内容 */
	private String mtNarrat;

	/* 报文作废标识 */
	private String voidFlag;

	private String mxType;
	private String mxStr;
	private String mxFlag;
	private String mxBussService;

	//其他自定义属性


	// Constructor
	public PgstsDO() {
	}

	/**
	 * full Constructor
	 */
	public PgstsDO(String bhSndlt, String ahRcvlt, String ahMpro, String ohHkl, String ohMuref, String ohCov, String ohGpiRef, String trn, String rtrn, Integer mtSeq, String mtRetryFlag, String mtPdmNm, String mtPdeNm, String mtStr, String mtStatus, String gpiStatus, LocalDateTime createdTime, LocalDateTime updateLastTime, String mtBean, Integer updateLastTerm, String updateLastTeller, String updateLastAuthor, String authorReminderMsg, String authorComment, String recordStatusNoauthor, String updateLastTxnCode, String rejectCode, String clearReqFlag, String mtMessage, String srcSys, String targetSys, String msgMethod, String msgSrc, String mtTemporary, String frModule, String manualFg, String gpiReasonCode, String msgNo, String bhSessNo, String bhIsn, String ahMt, String ahioFlag, String gpiFlag, String futureFg, LocalDate acDate, String traditionalFlag, String pagmchOurRef, String refSub, String yourChl, String incomeDate, String incomeTime, String incomeTimeZone, LocalDate updateLastAcDate, String logNumber, String rejectedReason, String gwMsgStatus, String txncode, String gpiDate, String gpiTime, String gpiTimezone, String retransmissionId, String gpcFlag, String mtNarrat, String voidFlag, String mxType, String mxStr, String mxFlag, String mxBussService) {
		this.bhSndlt = bhSndlt;
		this.ahRcvlt = ahRcvlt;
		this.ahMpro = ahMpro;
		this.ohHkl = ohHkl;
		this.ohMuref = ohMuref;
		this.ohCov = ohCov;
		this.ohGpiRef = ohGpiRef;
		this.trn = trn;
		this.rtrn = rtrn;
		this.mtSeq = mtSeq;
		this.mtRetryFlag = mtRetryFlag;
		this.mtPdmNm = mtPdmNm;
		this.mtPdeNm = mtPdeNm;
		this.mtStr = mtStr;
		this.mtStatus = mtStatus;
		this.gpiStatus = gpiStatus;
		this.createdTime = createdTime;
		this.updateLastTime = updateLastTime;
		this.mtBean = mtBean;
		this.updateLastTerm = updateLastTerm;
		this.updateLastTeller = updateLastTeller;
		this.updateLastAuthor = updateLastAuthor;
		this.authorReminderMsg = authorReminderMsg;
		this.authorComment = authorComment;
		this.recordStatusNoauthor = recordStatusNoauthor;
		this.updateLastTxnCode = updateLastTxnCode;
		this.rejectCode = rejectCode;
		this.clearReqFlag = clearReqFlag;
		this.mtMessage = mtMessage;
		this.srcSys = srcSys;
		this.targetSys = targetSys;
		this.msgMethod = msgMethod;
		this.msgSrc = msgSrc;
		this.mtTemporary = mtTemporary;
		this.frModule = frModule;
		this.manualFg = manualFg;
		this.gpiReasonCode = gpiReasonCode;
		this.msgNo = msgNo;
		this.bhSessNo = bhSessNo;
		this.bhIsn = bhIsn;
		this.ahMt = ahMt;
		this.ahioFlag = ahioFlag;
		this.gpiFlag = gpiFlag;
		this.futureFg = futureFg;
		this.acDate = acDate;
		this.traditionalFlag = traditionalFlag;
		this.pagmchOurRef = pagmchOurRef;
		this.refSub = refSub;
		this.yourChl = yourChl;
		this.incomeDate = incomeDate;
		this.incomeTime = incomeTime;
		this.incomeTimeZone = incomeTimeZone;
		this.updateLastAcDate = updateLastAcDate;
		this.logNumber = logNumber;
		this.rejectedReason = rejectedReason;
		this.gwMsgStatus = gwMsgStatus;
		this.txncode = txncode;
		this.gpiDate = gpiDate;
		this.gpiTime = gpiTime;
		this.gpiTimezone = gpiTimezone;
		this.retransmissionId = retransmissionId;
		this.gpcFlag = gpcFlag;
		this.mtNarrat = mtNarrat;
		this.voidFlag = voidFlag;
		this.mxType = mxType;
		this.mxStr = mxStr;
		this.mxFlag = mxFlag;
		this.mxBussService = mxBussService;
	}

	public String getMxType() {
		return mxType;
	}

	public void setMxType(String mxType) {
		this.mxType = mxType;
	}

	public String getMxStr() {
		return mxStr;
	}

	public void setMxStr(String mxStr) {
		this.mxStr = mxStr;
	}

	public String getMxFlag() {
		return mxFlag;
	}

	public void setMxFlag(String mxFlag) {
		this.mxFlag = mxFlag;
	}

	public String getMxBussService() {
		return mxBussService;
	}

	public void setMxBussService(String mxBussService) {
		this.mxBussService = mxBussService;
	}

	public String getBhSndlt() {
		return bhSndlt;
	}

	public void setBhSndlt(String bhSndlt) {
		this.bhSndlt = bhSndlt;
	}

	public String getAhRcvlt() {
		return ahRcvlt;
	}

	public void setAhRcvlt(String ahRcvlt) {
		this.ahRcvlt = ahRcvlt;
	}

	public String getAhMpro() {
		return ahMpro;
	}

	public void setAhMpro(String ahMpro) {
		this.ahMpro = ahMpro;
	}

	public String getOhHkl() {
		return ohHkl;
	}

	public void setOhHkl(String ohHkl) {
		this.ohHkl = ohHkl;
	}

	public String getOhMuref() {
		return ohMuref;
	}

	public void setOhMuref(String ohMuref) {
		this.ohMuref = ohMuref;
	}

	public String getOhCov() {
		return ohCov;
	}

	public void setOhCov(String ohCov) {
		this.ohCov = ohCov;
	}

	public String getOhGpiRef() {
		return ohGpiRef;
	}

	public void setOhGpiRef(String ohGpiRef) {
		this.ohGpiRef = ohGpiRef;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getRtrn() {
		return rtrn;
	}

	public void setRtrn(String rtrn) {
		this.rtrn = rtrn;
	}

	public Integer getMtSeq() {
		return mtSeq;
	}

	public void setMtSeq(Integer mtSeq) {
		this.mtSeq = mtSeq;
	}

	public String getMtRetryFlag() {
		return mtRetryFlag;
	}

	public void setMtRetryFlag(String mtRetryFlag) {
		this.mtRetryFlag = mtRetryFlag;
	}

	public String getMtPdmNm() {
		return mtPdmNm;
	}

	public void setMtPdmNm(String mtPdmNm) {
		this.mtPdmNm = mtPdmNm;
	}

	public String getMtPdeNm() {
		return mtPdeNm;
	}

	public void setMtPdeNm(String mtPdeNm) {
		this.mtPdeNm = mtPdeNm;
	}

	public String getMtStr() {
		return mtStr;
	}

	public void setMtStr(String mtStr) {
		this.mtStr = mtStr;
	}

	public String getMtStatus() {
		return mtStatus;
	}

	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	public String getGpiStatus() {
		return gpiStatus;
	}

	public void setGpiStatus(String gpiStatus) {
		this.gpiStatus = gpiStatus;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getUpdateLastTime() {
		return updateLastTime;
	}

	public void setUpdateLastTime(LocalDateTime updateLastTime) {
		this.updateLastTime = updateLastTime;
	}

	public String getMtBean() {
		return mtBean;
	}

	public void setMtBean(String mtBean) {
		this.mtBean = mtBean;
	}

	public Integer getUpdateLastTerm() {
		return updateLastTerm;
	}

	public void setUpdateLastTerm(Integer updateLastTerm) {
		this.updateLastTerm = updateLastTerm;
	}

	public String getUpdateLastTeller() {
		return updateLastTeller;
	}

	public void setUpdateLastTeller(String updateLastTeller) {
		this.updateLastTeller = updateLastTeller;
	}

	public String getUpdateLastAuthor() {
		return updateLastAuthor;
	}

	public void setUpdateLastAuthor(String updateLastAuthor) {
		this.updateLastAuthor = updateLastAuthor;
	}

	public String getAuthorReminderMsg() {
		return authorReminderMsg;
	}

	public void setAuthorReminderMsg(String authorReminderMsg) {
		this.authorReminderMsg = authorReminderMsg;
	}

	public String getAuthorComment() {
		return authorComment;
	}

	public void setAuthorComment(String authorComment) {
		this.authorComment = authorComment;
	}

	public String getRecordStatusNoauthor() {
		return recordStatusNoauthor;
	}

	public void setRecordStatusNoauthor(String recordStatusNoauthor) {
		this.recordStatusNoauthor = recordStatusNoauthor;
	}

	public String getUpdateLastTxnCode() {
		return updateLastTxnCode;
	}

	public void setUpdateLastTxnCode(String updateLastTxnCode) {
		this.updateLastTxnCode = updateLastTxnCode;
	}

	public String getRejectCode() {
		return rejectCode;
	}

	public void setRejectCode(String rejectCode) {
		this.rejectCode = rejectCode;
	}

	public String getClearReqFlag() {
		return clearReqFlag;
	}

	public void setClearReqFlag(String clearReqFlag) {
		this.clearReqFlag = clearReqFlag;
	}

	public String getMtMessage() {
		return mtMessage;
	}

	public void setMtMessage(String mtMessage) {
		this.mtMessage = mtMessage;
	}

	public String getSrcSys() {
		return srcSys;
	}

	public void setSrcSys(String srcSys) {
		this.srcSys = srcSys;
	}

	public String getTargetSys() {
		return targetSys;
	}

	public void setTargetSys(String targetSys) {
		this.targetSys = targetSys;
	}

	public String getMsgMethod() {
		return msgMethod;
	}

	public void setMsgMethod(String msgMethod) {
		this.msgMethod = msgMethod;
	}

	public String getMsgSrc() {
		return msgSrc;
	}

	public void setMsgSrc(String msgSrc) {
		this.msgSrc = msgSrc;
	}

	public String getMtTemporary() {
		return mtTemporary;
	}

	public void setMtTemporary(String mtTemporary) {
		this.mtTemporary = mtTemporary;
	}

	public String getFrModule() {
		return frModule;
	}

	public void setFrModule(String frModule) {
		this.frModule = frModule;
	}

	public String getManualFg() {
		return manualFg;
	}

	public void setManualFg(String manualFg) {
		this.manualFg = manualFg;
	}

	public String getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}

	public String getBhSessNo() {
		return bhSessNo;
	}

	public void setBhSessNo(String bhSessNo) {
		this.bhSessNo = bhSessNo;
	}

	public String getBhIsn() {
		return bhIsn;
	}

	public void setBhIsn(String bhIsn) {
		this.bhIsn = bhIsn;
	}

	public String getAhMt() {
		return ahMt;
	}

	public void setAhMt(String ahMt) {
		this.ahMt = ahMt;
	}

	public String getAhioFlag() {
		return ahioFlag;
	}

	public void setAhioFlag(String ahioFlag) {
		this.ahioFlag = ahioFlag;
	}

	public String getGpiReasonCode() {
		return gpiReasonCode;
	}

	public void setGpiReasonCode(String gpiReasonCode) {
		this.gpiReasonCode = gpiReasonCode;
	}

	public String getGpiFlag() {
		return gpiFlag;
	}

	public void setGpiFlag(String gpiFlag) {
		this.gpiFlag = gpiFlag;
	}

	public String getFutureFg() {
		return futureFg;
	}

	public void setFutureFg(String futureFg) {
		this.futureFg = futureFg;
	}

	public LocalDate getAcDate() {
		return acDate;
	}

	public void setAcDate(LocalDate acDate) {
		this.acDate = acDate;
	}

	public String getTraditionalFlag() {
		return traditionalFlag;
	}

	public void setTraditionalFlag(String traditionalFlag) {
		this.traditionalFlag = traditionalFlag;
	}

	public String getPagmchOurRef() {
		return pagmchOurRef;
	}

	public void setPagmchOurRef(String pagmchOurRef) {
		this.pagmchOurRef = pagmchOurRef;
	}

	public String getRefSub() {
		return refSub;
	}

	public void setRefSub(String refSub) {
		this.refSub = refSub;
	}

	public String getYourChl() {
		return yourChl;
	}

	public void setYourChl(String yourChl) {
		this.yourChl = yourChl;
	}

	public String getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(String incomeDate) {
		this.incomeDate = incomeDate;
	}

	public String getIncomeTime() {
		return incomeTime;
	}

	public void setIncomeTime(String incomeTime) {
		this.incomeTime = incomeTime;
	}

	public String getIncomeTimeZone() {
		return incomeTimeZone;
	}

	public void setIncomeTimeZone(String incomeTimeZone) {
		this.incomeTimeZone = incomeTimeZone;
	}

	public LocalDate getUpdateLastAcDate() {
		return updateLastAcDate;
	}

	public void setUpdateLastAcDate(LocalDate updateLastAcDate) {
		this.updateLastAcDate = updateLastAcDate;
	}

	public String getLogNumber() {
		return logNumber;
	}

	public void setLogNumber(String logNumber) {
		this.logNumber = logNumber;
	}

	public String getRejectedReason() {
		return rejectedReason;
	}

	public void setRejectedReason(String rejectedReason) {
		this.rejectedReason = rejectedReason;
	}

	public String getGwMsgStatus() {
		return gwMsgStatus;
	}

	public void setGwMsgStatus(String gwMsgStatus) {
		this.gwMsgStatus = gwMsgStatus;
	}

	public String getTxncode() {
		return txncode;
	}

	public void setTxncode(String txncode) {
		this.txncode = txncode;
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

	public String getGpiTimezone() {
		return gpiTimezone;
	}

	public void setGpiTimezone(String gpiTimezone) {
		this.gpiTimezone = gpiTimezone;
	}

	public String getRetransmissionId() {
		return retransmissionId;
	}

	public void setRetransmissionId(String retransmissionId) {
		this.retransmissionId = retransmissionId;
	}

	public String getGpcFlag() {
		return gpcFlag;
	}

	public void setGpcFlag(String gpcFlag) {
		this.gpcFlag = gpcFlag;
	}

	public String getMtNarrat() {
		return mtNarrat;
	}

	public void setMtNarrat(String mtNarrat) {
		this.mtNarrat = mtNarrat;
	}

	public String getVoidFlag() {
		return voidFlag;
	}

	public void setVoidFlag(String voidFlag) {
		this.voidFlag = voidFlag;
	}

	@Override
	public String toString() {
		return "PgstsDO{" +
				"bhSndlt='" + bhSndlt + '\'' +
				", ahRcvlt='" + ahRcvlt + '\'' +
				", ahMpro='" + ahMpro + '\'' +
				", ohHkl='" + ohHkl + '\'' +
				", ohMuref='" + ohMuref + '\'' +
				", ohCov='" + ohCov + '\'' +
				", ohGpiRef='" + ohGpiRef + '\'' +
				", trn='" + trn + '\'' +
				", rtrn='" + rtrn + '\'' +
				", mtSeq=" + mtSeq +
				", mtRetryFlag='" + mtRetryFlag + '\'' +
				", mtPdmNm='" + mtPdmNm + '\'' +
				", mtPdeNm='" + mtPdeNm + '\'' +
				", mtStr='" + mtStr + '\'' +
				", mtStatus='" + mtStatus + '\'' +
				", gpiStatus='" + gpiStatus + '\'' +
				", createdTime=" + createdTime +
				", updateLastTime=" + updateLastTime +
				", mtBean='" + mtBean + '\'' +
				", updateLastTerm=" + updateLastTerm +
				", updateLastTeller='" + updateLastTeller + '\'' +
				", updateLastAuthor='" + updateLastAuthor + '\'' +
				", authorReminderMsg='" + authorReminderMsg + '\'' +
				", authorComment='" + authorComment + '\'' +
				", recordStatusNoauthor='" + recordStatusNoauthor + '\'' +
				", updateLastTxnCode='" + updateLastTxnCode + '\'' +
				", rejectCode='" + rejectCode + '\'' +
				", clearReqFlag='" + clearReqFlag + '\'' +
				", mtMessage='" + mtMessage + '\'' +
				", srcSys='" + srcSys + '\'' +
				", targetSys='" + targetSys + '\'' +
				", msgMethod='" + msgMethod + '\'' +
				", msgSrc='" + msgSrc + '\'' +
				", mtTemporary='" + mtTemporary + '\'' +
				", frModule='" + frModule + '\'' +
				", manualFg='" + manualFg + '\'' +
				", gpiReasonCode='" + gpiReasonCode + '\'' +
				", msgNo='" + msgNo + '\'' +
				", bhSessNo='" + bhSessNo + '\'' +
				", bhIsn='" + bhIsn + '\'' +
				", ahMt='" + ahMt + '\'' +
				", ahioFlag='" + ahioFlag + '\'' +
				", gpiFlag='" + gpiFlag + '\'' +
				", futureFg='" + futureFg + '\'' +
				", acDate=" + acDate +
				", traditionalFlag='" + traditionalFlag + '\'' +
				", pagmchOurRef='" + pagmchOurRef + '\'' +
				", refSub='" + refSub + '\'' +
				", yourChl='" + yourChl + '\'' +
				", incomeDate='" + incomeDate + '\'' +
				", incomeTime='" + incomeTime + '\'' +
				", incomeTimeZone='" + incomeTimeZone + '\'' +
				", updateLastAcDate=" + updateLastAcDate +
				", logNumber='" + logNumber + '\'' +
				", rejectedReason='" + rejectedReason + '\'' +
				", gwMsgStatus='" + gwMsgStatus + '\'' +
				", txncode='" + txncode + '\'' +
				", gpiDate='" + gpiDate + '\'' +
				", gpiTime='" + gpiTime + '\'' +
				", gpiTimezone='" + gpiTimezone + '\'' +
				", retransmissionId='" + retransmissionId + '\'' +
				", gpcFlag='" + gpcFlag + '\'' +
				", mtNarrat='" + mtNarrat + '\'' +
				", voidFlag='" + voidFlag + '\'' +
				", mxType='" + mxType + '\'' +
				", mxStr='" + mxStr + '\'' +
				", mxFlag='" + mxFlag + '\'' +
				", mxBussService='" + mxBussService + '\'' +
				'}';
	}
}
