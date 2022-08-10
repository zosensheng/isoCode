package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.time.LocalDateTime;

/**
 * entity:PgSintratele
 * 
 * @author
 * @version 3.0
 * @date 2021-10-21
 */
public class PgSintrateleDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 電碼編號 */
	private String pgswfId;

	/* 簡繁體漢字 */
	private String glyph;

	/* UTF-32編碼 */
	private String ucs;

	/* HOST CODE(61388) */
	private String hostCode;

	/* 電碼 */
	private String telexCode;

	/* 狀態 */
	private String teleAction;

	/* 修改时间 */
	private LocalDateTime updatedLastTime;


	//其他自定义属性
	

	// Constructor
	public PgSintrateleDO() {
	}

	/**
	 * full Constructor
	 */
	public PgSintrateleDO(String pgswfId, String glyph, String ucs, String hostCode, String telexCode, String teleAction, LocalDateTime updatedLastTime) {
		this.pgswfId = pgswfId;
		this.glyph = glyph;
		this.ucs = ucs;
		this.hostCode = hostCode;
		this.telexCode = telexCode;
		this.teleAction = teleAction;
		this.updatedLastTime = updatedLastTime;
	}

	public String getPgswfId() {
		return pgswfId;
	}

	public void setPgswfId(String pgswfId) {
		this.pgswfId = pgswfId;
	}

	public String getGlyph() {
		return glyph;
	}

	public void setGlyph(String glyph) {
		this.glyph = glyph;
	}

	public String getUcs() {
		return ucs;
	}

	public void setUcs(String ucs) {
		this.ucs = ucs;
	}

	public String getHostCode() {
		return hostCode;
	}

	public void setHostCode(String hostCode) {
		this.hostCode = hostCode;
	}

	public String getTelexCode() {
		return telexCode;
	}

	public void setTelexCode(String telexCode) {
		this.telexCode = telexCode;
	}

	public String getTeleAction() {
		return teleAction;
	}

	public void setTeleAction(String teleAction) {
		this.teleAction = teleAction;
	}

	public LocalDateTime getUpdatedLastTime() {
		return updatedLastTime;
	}

	public void setUpdatedLastTime(LocalDateTime updatedLastTime) {
		this.updatedLastTime = updatedLastTime;
	}

	@Override
	public String toString() {
		return "PgSintrateleDO{" +
				"pgswfId='" + pgswfId + '\'' +
				", glyph='" + glyph + '\'' +
				", ucs='" + ucs + '\'' +
				", hostCode='" + hostCode + '\'' +
				", telexCode='" + telexCode + '\'' +
				", teleAction='" + teleAction + '\'' +
				", updatedLastTime=" + updatedLastTime +
				'}';
	}
}
