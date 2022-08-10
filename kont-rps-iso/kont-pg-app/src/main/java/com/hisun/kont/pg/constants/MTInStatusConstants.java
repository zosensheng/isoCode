package com.hisun.kont.pg.constants;

/**
 * 报文状态常量
 */
public class MTInStatusConstants {

    /** 网关发报状态 */
    //组装报文成功
    public final static String MT_GEN_GEN_SUCCESS = "GSC";
    //报文发送失败
    public final static String MT_GEN_OUT_FAIL = "OFAIL";
    //报文发送成功
    public final static String MT_GEN_OUT_SUCCESS = "OSC";
    //报文外发失败 手动ACK
    public final static String GW_MSG_STATUS_HANDLE_ACK = "HACK";
    //报文外发失败 手动NAK
    public final static String GW_MSG_STATUS_HANDLE_NAK = "HNAK";

    /** 网关收报状态 */
    //报文已接收
    public final static String MT_STATUS_RECV = "RECV";
    //报文拆解失敗
    public final static String MT_STATUS_DFAIL = "DFAIL";
    //报文已派分应用
    public final static String MT_STATUS_DTED = "DTED";
    //报文派分应用失败
    public final static String MT_STATUS_TFAIL = "TFAIL";
    //退回RMC成功
    public final static String MT_STATUS_RTN = "RTN";

    /** 报文业务状态 */
    //报文已发送到swift
    public final static String MT_STATUS_ACK = "ACK";
    //报文发送到FTM或swift被拒的状态 NAK
    public final static String MT_STATUS_NAK = "NAK";


    /** 電文类型不支持 */
    public final static String MT_STATUS_NOT_SUPPORT = "NSPT";

    /** 发报重复key rmc返回信息内容*/
    public final static String MT_RTN_DUP = "RTN DUPLICATE";

    public final static String MT_DUP_MSG = "DUPLICATE MSG";



    /** 电码转中文失败：电码对应中文存在一对多 */
    public final static String MT_TELE_TO_CNS = "TELEFAIL:HAS MANY";
    /** 电码转中文失败：电码不存在对应中文 */
    public final static String MT_TELE_TO_CN_NONE = "TELEFAIL:NONE";

    /**
     * FUNC_CD的值
     */


    public final static String PG_CTL_OPEN = "O";
    public final static String PG_CTL_CLOSE = "C";


    /**
     * 	开关用户权限
     */
    public static final String SWIFT_O="O";
    public static final String SWIFT_C="C";
    public static final String SWIFT_Y="Y";
    public static final String SWIFT_N="N";


    /*
   支付限额
   status	1:init | 2:success | 3:failed | 4:return | 5:error（接收admi.002及camt.056拒绝报文）
   flag	O:outward | I:inward | OR:outward return 汇出退汇 | IR:inward return 汇入退汇
    */
    public static final String LIMIT_STATU_INIT = "1";
    public static final String LIMIT_STATU_SUCCESS = "2";
    // public static final String LIMIT_STATU_REFUSE = "3";
    public static final String LIMIT_STATU_FAILED = "3";
    public static final String LIMIT_STATU_RETURN = "4";
    public static final String LIMIT_STATU_ERROR = "5";
    public static final String LIMIT_FLAG_OUTWARD = "O";
    public static final String LIMIT_FLAG_INWARD = "I";
    public static final String LIMIT_FLAG_OUTWARD_RETURN = "OR";
    public static final String LIMIT_FLAG_INWARD_RETURN = "IR";
}
