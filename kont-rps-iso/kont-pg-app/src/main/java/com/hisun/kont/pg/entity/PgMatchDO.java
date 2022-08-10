package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * entity:PgMatch
 * 
 * @author
 * @version 3.0
 * @date 2022-1-6
 */
public class PgMatchDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 報文編號 */
	private String msgNo;

	/* 關聯業務編號 */
	private String pagmchOurRef;

	/* 创建时间 */
	private LocalDateTime createdTime;

	/* 最後修改時間 */
	private LocalDateTime updateLastTime;

	/* 最後修改櫃員 */
	private String updateLastTeller;

	/* 最后更新会计日 */
	private LocalDate updateLastAcDate;

	/* 最後修改終端號 */
	private Integer updateLastTerm;

	/* 最後交易代碼 */
	private String updateLastTxnCode;

	/* 日志号 */
	private String logNumber;

	//其他自定义属性
	

	// Constructor
	public PgMatchDO() {
	}

	/**
	 * full Constructor
	 */
	public PgMatchDO(String msgNo, String pagmchOurRef, LocalDateTime createdTime, LocalDateTime updateLastTime, String updateLastTeller, LocalDate updateLastAcDate, Integer updateLastTerm, String updateLastTxnCode, String logNumber) {
		this.msgNo = msgNo;
		this.pagmchOurRef = pagmchOurRef;
		this.createdTime = createdTime;
		this.updateLastTime = updateLastTime;
		this.updateLastTeller = updateLastTeller;
		this.updateLastAcDate = updateLastAcDate;
		this.updateLastTerm = updateLastTerm;
		this.updateLastTxnCode = updateLastTxnCode;
		this.logNumber = logNumber;
	}

	public String getMsgNo() {
		return msgNo;
	}

	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}

	public String getPagmchOurRef() {
		return pagmchOurRef;
	}

	public void setPagmchOurRef(String pagmchOurRef) {
		this.pagmchOurRef = pagmchOurRef;
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

	public String getUpdateLastTeller() {
		return updateLastTeller;
	}

	public void setUpdateLastTeller(String updateLastTeller) {
		this.updateLastTeller = updateLastTeller;
	}

	public LocalDate getUpdateLastAcDate() {
		return updateLastAcDate;
	}

	public void setUpdateLastAcDate(LocalDate updateLastAcDate) {
		this.updateLastAcDate = updateLastAcDate;
	}

	public Integer getUpdateLastTerm() {
		return updateLastTerm;
	}

	public void setUpdateLastTerm(Integer updateLastTerm) {
		this.updateLastTerm = updateLastTerm;
	}

	public String getUpdateLastTxnCode() {
		return updateLastTxnCode;
	}

	public void setUpdateLastTxnCode(String updateLastTxnCode) {
		this.updateLastTxnCode = updateLastTxnCode;
	}

	public String getLogNumber() {
		return logNumber;
	}

	public void setLogNumber(String logNumber) {
		this.logNumber = logNumber;
	}

	@Override
	public String toString() {
		return "PgMatchDO{" +
				"msgNo='" + msgNo + '\'' +
				", pagmchOurRef='" + pagmchOurRef + '\'' +
				", createdTime=" + createdTime +
				", updateLastTime=" + updateLastTime +
				", updateLastTeller='" + updateLastTeller + '\'' +
				", updateLastAcDate=" + updateLastAcDate +
				", updateLastTerm=" + updateLastTerm +
				", updateLastTxnCode='" + updateLastTxnCode + '\'' +
				", logNumber='" + logNumber + '\'' +
				'}';
	}
}
