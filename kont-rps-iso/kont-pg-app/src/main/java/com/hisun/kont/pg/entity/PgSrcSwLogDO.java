package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;
import java.time.LocalDateTime;

/**
 * entity:PgSrcSwLog
 * 
 * @author
 * @version 3.0
 * @date 2021-7-20
 */
public class PgSrcSwLogDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 源业务系统开关表ID */
	private Integer srcSwId;

	/* 源业务系统开关类型 */
	private String srcSwType;

	/* 开关操作前状态 */
	private String swPreStatus;

	/* 开关操作后状态 */
	private String swPostStatus;

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
	public PgSrcSwLogDO() {
	}

	/**
	 * full Constructor
	 */
	public PgSrcSwLogDO(Integer srcSwId, String srcSwType, String swPreStatus, String swPostStatus, String operateTeller, String branchId, String srcAppl, LocalDateTime updatedLastTime) {
		this.srcSwId = srcSwId;
		this.srcSwType = srcSwType;
		this.swPreStatus = swPreStatus;
		this.swPostStatus = swPostStatus;
		this.operateTeller = operateTeller;
		this.branchId = branchId;
		this.srcAppl = srcAppl;
		this.updatedLastTime = updatedLastTime;
	}

	public Integer getSrcSwId() {
		return srcSwId;
	}

	public void setSrcSwId(Integer srcSwId) {
		this.srcSwId = srcSwId;
	}

	public String getSrcSwType() {
		return srcSwType;
	}

	public void setSrcSwType(String srcSwType) {
		this.srcSwType = srcSwType;
	}

	public String getSwPreStatus() {
		return swPreStatus;
	}

	public void setSwPreStatus(String swPreStatus) {
		this.swPreStatus = swPreStatus;
	}

	public String getSwPostStatus() {
		return swPostStatus;
	}

	public void setSwPostStatus(String swPostStatus) {
		this.swPostStatus = swPostStatus;
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
		return "PgSrcSwLog [" + "srcSwId=" + srcSwId + ", srcSwType=" + srcSwType + ", swPreStatus=" + swPreStatus + ", swPostStatus=" + swPostStatus + ", operateTeller=" + operateTeller + ", branchId=" + branchId + ", srcAppl=" + srcAppl + ", updatedLastTime=" + updatedLastTime +  "]";
	}
}
