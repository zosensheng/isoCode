package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;
import java.time.LocalDateTime;

/**
 * entity:PgSrcSwitch
 * 
 * @author
 * @version 3.0
 * @date 2021-7-19
 */
public class PgSrcSwitchDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 源业务系统开关类型 */
	private String srcSwType;

	/* 源业务系统开关状态 */
	private String srcSwStatus;

	/* 操作柜员 */
	private String operateTeller;

	/* branchId */
	private String branchId;

	/* 源应用 */
	private String srcAppl;

	/* 最後更新日期 */
	private LocalDateTime updatedLastTime;


	//其他自定义属性
	

	// Constructor
	public PgSrcSwitchDO() {
	}

	/**
	 * full Constructor
	 */
	public PgSrcSwitchDO(String srcSwType, String srcSwStatus, String operateTeller, String branchId, String srcAppl, LocalDateTime updatedLastTime) {
		this.srcSwType = srcSwType;
		this.srcSwStatus = srcSwStatus;
		this.operateTeller = operateTeller;
		this.branchId = branchId;
		this.srcAppl = srcAppl;
		this.updatedLastTime = updatedLastTime;
	}

	public String getSrcSwType() {
		return srcSwType;
	}

	public void setSrcSwType(String srcSwType) {
		this.srcSwType = srcSwType;
	}

	public String getSrcSwStatus() {
		return srcSwStatus;
	}

	public void setSrcSwStatus(String srcSwStatus) {
		this.srcSwStatus = srcSwStatus;
	}

	public String getOperateTeller() {
		return operateTeller;
	}

	public void setOperateTeller(String operateTeller) {
		this.operateTeller = operateTeller;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getSrcAppl() {
		return srcAppl;
	}

	public void setSrcAppl(String srcAppl) {
		this.srcAppl = srcAppl;
	}

	public LocalDateTime getUpdatedLastTime() {
		return updatedLastTime;
	}

	public void setUpdatedLastTime(LocalDateTime updatedLastTime) {
		this.updatedLastTime = updatedLastTime;
	}

	@Override
	public String toString() {
		return "PgSrcSwitch [" + "srcSwType=" + srcSwType + ", srcSwStatus=" + srcSwStatus + ", operateTeller=" + operateTeller + ", branchId=" + branchId + ", srcAppl=" + srcAppl + ", updatedLastTime=" + updatedLastTime +  "]";
	}
}
