package com.hisun.kont.pg.entity;

import com.hisun.kont.framework.data.BaseDO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

/**
 * entity:ClientLimitQuota
 * 
 * @author
 * @version 3.0
 * @date 2022-7-12
 */
public class ClientLimitQuotaDO extends BaseDO {
	
	private static final long serialVersionUID = 1L;

	/* 渠道 */
	private String channel;

	/* 服务编码 */
	private String bizSvc;

	/* 付款唯一标识 */
	private String instrId;

	/* 退回交易标识号 */
	private String rtrId;

	/* 交易币种 */
	private String txCcy;

	/* 交易日期 */
	private LocalDate txDate;

	/* 交易金额 */
	private BigDecimal txAmount;

	/* 交易账号 */
	private String txAcct;

	/* 状态 */
	private String txStatus;

	/* 交易标识 */
	private String txFlag;

	/* 创建柜员号 */
	private String createTeller;

	/* 修改柜员号 */
	private String modifyTeller;


	//其他自定义属性
	

	// Constructor
	public ClientLimitQuotaDO() {
	}

	/**
	 * full Constructor
	 */
	public ClientLimitQuotaDO(String channel, String bizSvc, String instrId, String rtrId, String txCcy, LocalDate txDate, BigDecimal txAmount, String txAcct, String txStatus, String txFlag, String createTeller, String modifyTeller) {
		this.channel = channel;
		this.bizSvc = bizSvc;
		this.instrId = instrId;
		this.rtrId = rtrId;
		this.txCcy = txCcy;
		this.txDate = txDate;
		this.txAmount = txAmount;
		this.txAcct = txAcct;
		this.txStatus = txStatus;
		this.txFlag = txFlag;
		this.createTeller = createTeller;
		this.modifyTeller = modifyTeller;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getBizSvc() {
		return bizSvc;
	}

	public void setBizSvc(String bizSvc) {
		this.bizSvc = bizSvc;
	}

	public String getInstrId() {
		return instrId;
	}

	public void setInstrId(String instrId) {
		this.instrId = instrId;
	}

	public String getRtrId() {
		return rtrId;
	}

	public void setRtrId(String rtrId) {
		this.rtrId = rtrId;
	}

	public String getTxCcy() {
		return txCcy;
	}

	public void setTxCcy(String txCcy) {
		this.txCcy = txCcy;
	}

	public LocalDate getTxDate() {
		return txDate;
	}

	public void setTxDate(LocalDate txDate) {
		this.txDate = txDate;
	}

	public BigDecimal getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(BigDecimal txAmount) {
		this.txAmount = txAmount;
	}

	public String getTxAcct() {
		return txAcct;
	}

	public void setTxAcct(String txAcct) {
		this.txAcct = txAcct;
	}

	public String getTxStatus() {
		return txStatus;
	}

	public void setTxStatus(String txStatus) {
		this.txStatus = txStatus;
	}

	public String getTxFlag() {
		return txFlag;
	}

	public void setTxFlag(String txFlag) {
		this.txFlag = txFlag;
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
		return "ClientLimitQuota [" + "channel=" + channel + ", bizSvc=" + bizSvc + ", instrId=" + instrId + ", rtrId=" + rtrId + ", txCcy=" + txCcy + ", txDate=" + txDate + ", txAmount=" + txAmount + ", txAcct=" + txAcct + ", txStatus=" + txStatus + ", txFlag=" + txFlag + ", createTeller=" + createTeller + ", modifyTeller=" + modifyTeller +  "]";
	}
}
