package com.hisun.kont.mx.constant;

import java.time.LocalDate;

/**
 * @author hc
 * @version V1.0
 * @Desc: ACC 公共常量类
 * @date 2018/4/27 10:51
 */
public class CommConstant {
    /**
     * 业务系统
     */
    public static final String ACC = "ACC";

    /**
     * 货币标识
     */
    public static final String CCY = "RMB";

    /**
     * 货币标识
     */
    public static final String HKD = "HKD";

    /**
     * one
     */
    public static final long INT_ONE = 1;

    /**
     * 负数
     */
    public static final int INT_NEGATIVE = -1;

    /**
     * zero
     */
    public static final int INT_ZERO = 0;

    /**
     * two
     */
    public static final int INT_TWO = 2;

    /**
     * six
     */
    public static final int INT_SIX = 6;

    /**
     * 金额
     */
    public static final String AMT_ZERO = "0.00";

    /**
     * 入账错误标识,系统错误标识
     */
    public static final String E = "E";

    /**
     * 传票不平标识
     */
    public static final String B = "B";

    /**
     * 业务编号
     */
    //联机生成传票
    public static final String ACC0001 = "ACC00001";

    //内部清算
    public static final String ACC0002 = "ACC00002";


    /**
     * 挂账原因
     */
    public static final String DE_SC1 = "系统错误,入账失败，进行错误挂账";

    /**
     * 挂账原因
     */
    public static final String DE_SC2 = "传票不平，进行错误挂账";

    /**
     * 初始化总账
     */
    public static final String BOOK_FLG = "HK001";

    /**
     * 核算单元号
     */
    public static final String BR = "99999999999";

    /**
     * 销户日期
     */
    public static final LocalDate CLOSE_DATE = LocalDate.parse("2099-12-31");

    /**
     * 清算
     */
    public static final String DE_SC = "Liquidation";    // 清算
    /**
     * 记账接口 MQ 信息消息通道
     */
    public static final String AI_ASYN_ACCT_CONSUMER = "aiAsynAcctConsumer";

    /**
     * 日期最大值
     */
    public static final String DATE_MAX = "9999-12-31";

    /**
     * 记账标志_M
     */
    public static final  String POST_M = "M";

    /**
     * 记账标志_R
     */
    public static final  String POST_R = "R";

    /**
     * 系统用户 system
     */
    public static final String USER_SYSTEM="system";

    /**
     * 交易银行
     */
    public static final String TR_BANK="TRBK";

    /**
     * 交易银行代码
     */
    public static final String TR_CODE="code";

    /**
     * 损益结转
     */
    public static final String LOSS_PROFIT_DE_SC = "损益结转";

    /**
     * MQ异步记账流水登记
     */
    public static final String ACCT_ASYN_EVENT_CONSUMER = "acctAsynEventConsumer";

    /**
     * MQ异步科目记账,活期转科目
     */
    public static final String ACCT_ASYN_TRANS_DD_ITM = "acctAsynTransDdItm";

    /**
     * MQ异步同步各个应用余额和流水登记
     */
    public static final String ACCT_ASYN_BAL_CONSUMER = "acctAsynBalConsumer";

    /**
     * 年终损益结转
     */
    public static final String YEAR_PROFIT_CARRIED_FORWARD = "年终结算";

    /**
     * 系统开放周期 公共类型
     */
    public static final String PARAM_TYPE_BKAI = "BKAI";

    /**
     * 系统开放周期 公共代码
     */
    public static final String PARAM_CODE_BKAI = "387";
    /**
     * 账套Redis缓存KEY
     */
    public static final String DYNAMIC_CODE_TYPE_AIBKPM = "AIBKPM";
    /**
     * 合约类型-外汇买卖
     */
    public static final String CNTR_TYPE_FXMK = "FXMK";

}
