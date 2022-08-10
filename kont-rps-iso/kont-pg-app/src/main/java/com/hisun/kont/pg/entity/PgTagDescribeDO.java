package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.time.LocalDateTime;

/**
 * entity:PgTagDescribe
 * 
 * @author
 * @version 3.0
 * @date 2021-8-3
 */
public class PgTagDescribeDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 650tag描述id */
	private String pgTagId;

	/* 報文類別 */
	private String ahMt;

	/* 650描述Key */
	private String mtTagKey;

	/* 650tag描述值 */
	private String tagValue;

	/* 最后更新时间 */
	private LocalDateTime updateLastTime;

	//其他自定义属性
	

	// Constructor
	public PgTagDescribeDO() {
	}

	/**
	 * full Constructor
	 */
	public PgTagDescribeDO(String pgTagId, String ahMt, String mtTagKey, String tagValue, LocalDateTime updateLastTime) {
		this.pgTagId = pgTagId;
		this.ahMt = ahMt;
		this.mtTagKey = mtTagKey;
		this.tagValue = tagValue;
		this.updateLastTime = updateLastTime;
	}

	public String getPgTagId() {
		return pgTagId;
	}

	public void setPgTagId(String pgTagId) {
		this.pgTagId = pgTagId;
	}

	public String getAhMt() {
		return ahMt;
	}

	public void setAhMt(String ahMt) {
		this.ahMt = ahMt;
	}

	public String getMtTagKey() {
		return mtTagKey;
	}

	public void setMtTagKey(String mtTagKey) {
		this.mtTagKey = mtTagKey;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public LocalDateTime getUpdateLastTime() {
		return updateLastTime;
	}

	public void setUpdateLastTime(LocalDateTime updateLastTime) {
		this.updateLastTime = updateLastTime;
	}

	@Override
	public String toString() {
		return "PgTagDescribeDO{" +
				"pgTagId='" + pgTagId + '\'' +
				", ahMt='" + ahMt + '\'' +
				", mtTagKey='" + mtTagKey + '\'' +
				", tagValue='" + tagValue + '\'' +
				", updateLastTime=" + updateLastTime +
				'}';
	}
}
