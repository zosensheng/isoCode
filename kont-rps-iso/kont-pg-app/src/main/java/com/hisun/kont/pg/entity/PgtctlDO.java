package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

/**
 * entity:Pgtctl
 * 
 * @author
 * @version 3.0
 * @date 2022-7-6
 */
public class PgtctlDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 记录的ID号 */
	private String ctlId;

	/* 渠道 */
	private String channel;

	/* INCOMING电文开关状态 */
	private String ctlIStatus;

	/* OUTGOING电文开关状态 */
	private String ctlOStatus;

	/* 自动打开INCOMING电文标志 */
	private String ctlIAutoSts;

	/* 自动打开OUTGOING电文标志 */
	private String ctlOAutoSts;

	/* AML开关 */
	private String ctlAmlSts;

	/* 时间戳 */
	private String ctlTs;


	//其他自定义属性
	

	// Constructor
	public PgtctlDO() {
	}

	/**
	 * full Constructor
	 */
	public PgtctlDO(String ctlId, String channel, String ctlIStatus, String ctlOStatus, String ctlIAutoSts, String ctlOAutoSts, String ctlAmlSts, String ctlTs) {
		this.ctlId = ctlId;
		this.channel = channel;
		this.ctlIStatus = ctlIStatus;
		this.ctlOStatus = ctlOStatus;
		this.ctlIAutoSts = ctlIAutoSts;
		this.ctlOAutoSts = ctlOAutoSts;
		this.ctlAmlSts = ctlAmlSts;
		this.ctlTs = ctlTs;
	}

	public String getCtlId() {
		return ctlId;
	}

	public void setCtlId(String ctlId) {
		this.ctlId = ctlId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCtlIStatus() {
		return ctlIStatus;
	}

	public void setCtlIStatus(String ctlIStatus) {
		this.ctlIStatus = ctlIStatus;
	}

	public String getCtlOStatus() {
		return ctlOStatus;
	}

	public void setCtlOStatus(String ctlOStatus) {
		this.ctlOStatus = ctlOStatus;
	}

	public String getCtlIAutoSts() {
		return ctlIAutoSts;
	}

	public void setCtlIAutoSts(String ctlIAutoSts) {
		this.ctlIAutoSts = ctlIAutoSts;
	}

	public String getCtlOAutoSts() {
		return ctlOAutoSts;
	}

	public void setCtlOAutoSts(String ctlOAutoSts) {
		this.ctlOAutoSts = ctlOAutoSts;
	}

	public String getCtlAmlSts() {
		return ctlAmlSts;
	}

	public void setCtlAmlSts(String ctlAmlSts) {
		this.ctlAmlSts = ctlAmlSts;
	}

	public String getCtlTs() {
		return ctlTs;
	}

	public void setCtlTs(String ctlTs) {
		this.ctlTs = ctlTs;
	}

	@Override
	public String toString() {
		return "Pgtctl [" + "ctlId=" + ctlId + ", channel=" + channel + ", ctlIStatus=" + ctlIStatus + ", ctlOStatus=" + ctlOStatus + ", ctlIAutoSts=" + ctlIAutoSts + ", ctlOAutoSts=" + ctlOAutoSts + ", ctlAmlSts=" + ctlAmlSts + ", ctlTs=" + ctlTs +  "]";
	}
}
