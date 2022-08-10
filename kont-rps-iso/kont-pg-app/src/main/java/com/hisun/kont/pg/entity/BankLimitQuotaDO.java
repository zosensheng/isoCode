package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.math.BigDecimal;

/**
 * entity:BankLimitQuota
 * 
 * @author
 * @version 3.0
 * @date 2022-7-12
 */
public class BankLimitQuotaDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 渠道 */
	private String channel;

	/* 限制金额的所属币种 */
	private String limitCcy;

	/* 服务编码 */
	private String bizSvc;

	/* 每日限额 */
	private BigDecimal dailyLimitAmount;

	/* 单笔限额 */
	private BigDecimal singleLimitAmount;

	/* 创建柜员号 */
	private String createTeller;

	/* 修改柜员号 */
	private String modifyTeller;


	//其他自定义属性
	

	// Constructor
	public BankLimitQuotaDO() {
	}

	/**
	 * full Constructor
	 */
	public BankLimitQuotaDO(String channel, String limitCcy, String bizSvc, BigDecimal dailyLimitAmount, BigDecimal singleLimitAmount, String createTeller, String modifyTeller) {
		this.channel = channel;
		this.limitCcy = limitCcy;
		this.bizSvc = bizSvc;
		this.dailyLimitAmount = dailyLimitAmount;
		this.singleLimitAmount = singleLimitAmount;
		this.createTeller = createTeller;
		this.modifyTeller = modifyTeller;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getLimitCcy() {
		return limitCcy;
	}

	public void setLimitCcy(String limitCcy) {
		this.limitCcy = limitCcy;
	}

	public String getBizSvc() {
		return bizSvc;
	}

	public void setBizSvc(String bizSvc) {
		this.bizSvc = bizSvc;
	}

	public BigDecimal getDailyLimitAmount() {
		return dailyLimitAmount;
	}

	public void setDailyLimitAmount(BigDecimal dailyLimitAmount) {
		this.dailyLimitAmount = dailyLimitAmount;
	}

	public BigDecimal getSingleLimitAmount() {
		return singleLimitAmount;
	}

	public void setSingleLimitAmount(BigDecimal singleLimitAmount) {
		this.singleLimitAmount = singleLimitAmount;
	}

	public String getCreateTeller() {
		return createTeller;
	}

	public void setCreateTeller(String createTeller) {
		this.createTeller = createTeller;
	}

	public String getModifyTeller() {
		return modifyTeller;
	}

	public void setModifyTeller(String modifyTeller) {
		this.modifyTeller = modifyTeller;
	}

	@Override
	public String toString() {
		return "BankLimitQuota [" + "channel=" + channel + ", limitCcy=" + limitCcy + ", bizSvc=" + bizSvc + ", dailyLimitAmount=" + dailyLimitAmount + ", singleLimitAmount=" + singleLimitAmount + ", createTeller=" + createTeller + ", modifyTeller=" + modifyTeller +  "]";
	}
}
