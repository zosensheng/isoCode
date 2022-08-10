package com.hisun.kont.mx.entity;

import com.hisun.kont.framework.data.BaseDO;
import java.time.LocalDateTime;

/**
 * entity:PgMxMst
 * 
 * @author
 * @version 3.0
 * @date 2022-6-8
 */
public class PgMxMstDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 电文编号 */
	private String bizMsgIdr;

	/* 发报机构 */
	private String frId;

	/* 收报机构 */
	private String toId;

	/* 服务类型 */
	private String bizSvc;

	/* 报文创建时间 */
	private LocalDateTime creDt;

	/* 重报标志 */
	private String pssbleDplct;

	/* 优先级 */
	private String party;

	/* GROUP ID */
	private String msgId;

	/* 电文类型 */
	private String msgDefIdr;

	/* 报文组装内容 */
	private String mtStr;

	/* 电文状态码 */
	private String mtStatus;

	/* 所属模块/ 汇入发出/汇出发出 */
	private String frModule;

	/* 手动标识 是否属于应变 */
	private String manualFg;

	/* future报文标志 */
	private String futureFg;

	/* 起始系统 */
	private String srcSys;

	/* 目标系统 */
	private String targetSys;

	/* 網關流程狀態 */
	private String gwMsgStatus;

	/* 会计日期 */
	private LocalDateTime acDate;

	/* 最后更新用户 */
	private String lastUpdateTlr;


	//其他自定义属性
	

	// Constructor
	public PgMxMstDO() {
	}

	/**
	 * full Constructor
	 */
	public PgMxMstDO(String bizMsgIdr, String frId, String toId, String bizSvc, LocalDateTime creDt, String pssbleDplct, String party, String msgId, String msgDefIdr, String mtStr, String mtStatus, String frModule, String manualFg, String futureFg, String srcSys, String targetSys, String gwMsgStatus, LocalDateTime acDate, String lastUpdateTlr) {
		this.bizMsgIdr = bizMsgIdr;
		this.frId = frId;
		this.toId = toId;
		this.bizSvc = bizSvc;
		this.creDt = creDt;
		this.pssbleDplct = pssbleDplct;
		this.party = party;
		this.msgId = msgId;
		this.msgDefIdr = msgDefIdr;
		this.mtStr = mtStr;
		this.mtStatus = mtStatus;
		this.frModule = frModule;
		this.manualFg = manualFg;
		this.futureFg = futureFg;
		this.srcSys = srcSys;
		this.targetSys = targetSys;
		this.gwMsgStatus = gwMsgStatus;
		this.acDate = acDate;
		this.lastUpdateTlr = lastUpdateTlr;
	}

	public String getBizMsgIdr() {
		return bizMsgIdr;
	}

	public void setBizMsgIdr(String bizMsgIdr) {
		this.bizMsgIdr = bizMsgIdr;
	}

	public String getFrId() {
		return frId;
	}

	public void setFrId(String frId) {
		this.frId = frId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public String getBizSvc() {
		return bizSvc;
	}

	public void setBizSvc(String bizSvc) {
		this.bizSvc = bizSvc;
	}

	public LocalDateTime getCreDt() {
		return creDt;
	}

	public void setCreDt(LocalDateTime creDt) {
		this.creDt = creDt;
	}

	public String getPssbleDplct() {
		return pssbleDplct;
	}

	public void setPssbleDplct(String pssbleDplct) {
		this.pssbleDplct = pssbleDplct;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgDefIdr() {
		return msgDefIdr;
	}

	public void setMsgDefIdr(String msgDefIdr) {
		this.msgDefIdr = msgDefIdr;
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

	public String getFutureFg() {
		return futureFg;
	}

	public void setFutureFg(String futureFg) {
		this.futureFg = futureFg;
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

	public String getGwMsgStatus() {
		return gwMsgStatus;
	}

	public void setGwMsgStatus(String gwMsgStatus) {
		this.gwMsgStatus = gwMsgStatus;
	}

	public LocalDateTime getAcDate() {
		return acDate;
	}

	public void setAcDate(LocalDateTime acDate) {
		this.acDate = acDate;
	}

	public String getLastUpdateTlr() {
		return lastUpdateTlr;
	}

	public void setLastUpdateTlr(String lastUpdateTlr) {
		this.lastUpdateTlr = lastUpdateTlr;
	}

	@Override
	public String toString() {
		return "PgMxMst [" + "bizMsgIdr=" + bizMsgIdr + ", frId=" + frId + ", toId=" + toId + ", bizSvc=" + bizSvc + ", creDt=" + creDt + ", pssbleDplct=" + pssbleDplct + ", party=" + party + ", msgId=" + msgId + ", msgDefIdr=" + msgDefIdr + ", mtStr=" + mtStr + ", mtStatus=" + mtStatus + ", frModule=" + frModule + ", manualFg=" + manualFg + ", futureFg=" + futureFg + ", srcSys=" + srcSys + ", targetSys=" + targetSys + ", gwMsgStatus=" + gwMsgStatus + ", acDate=" + acDate + ", lastUpdateTlr=" + lastUpdateTlr +  "]";
	}
}
