package com.hisun.kont.pg.constants;

/**
 * @Author yupeifeng
 * @ClassName: MTConstants
 * @Date 2021/5/14 10:19
 * @Description TODO
 * @Version 1.0
 **/
public  class MTConstants {

    /******************* 1000-1999************************/
    /** MT报文组装 AppHeaderSender和AppHeaderReciver都为空 */
    public final static String MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY = "RPSG1000";
    /** MT报文组装 AppHeaderSender和AppHeaderReciver都不为空 */
    public final static String MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS__NOT_EMPTY = "RPSG1001";
    /** MT报文组装 BasicHeader为空 */
    public final static String MT_GEN_BASIC_HEADER_IS_EMPTY = "RPSG1002";
    /** MT报文组装 UserHeader为空 */
    public final static String MT_GEN_USER_HEADER_IS_EMPTY = "RPSG1003";
    /** MT报文组装 获取f20域的值为空*/
    public final static String MT_GEN_F20_IS_NULL = "RPSG1004";
    /**  MT报文组装  Sender  和 Reciver 为空*/
    public final static String MT_GEN_SENDER_OR_RECIVER_IS_EMPTY = "RPSG1005";
    /**  MT报文重组失败*/
    public final static String MT_GEN_RETRRANSMISSION_FAIL="RPSG1006";
    /** MT报文格式打印 电文编号不存在 */
    public final static String MT_PRINT_MSGNO_IS_EMPTY = "RPSG1007";
    /** 中文转电码异常 含有转换异常中文  */
    public final static String CN_TO_TELENUM_ERROR = "RPSG1008";
    /** 中文转电码异常 没有输入简繁体标识  */
    public final static String TRADITONAL_FLAG_IS_NULL = "RPSG1009";
    /** 650为空   */
    public final static String PRINT_MESSAGE_IS_NULL = "RPSG1010";
    /** 报文类型不支持   */
    public final static String MT_TYPE_NOT_SUPPORT = "RPSG1011";
    /** 金额格式不正确*/
    public final static String MT_AMOUNT_ERROR = "RPSG1012";
    /** 汇率格式不正确*/
    public final static String MT_EXCHANGE_ERROR = "RPSG1013";
    /** 报文重复*/
    public final static String MT_REPETITION = "RPSG1014";
    /** 调用cor接口查询代理行通讯出错*/
    public final static String COR_ERROR = "RPSG1015";
    /** 转汇异常 报文编号为空或库里不存在*/
    public final static String MT_TRANSFER_MSGNO_ERRPR = "RPSG1016";
    /** GPI199 79域异常 79域不符合格式要求*/
    public final static String MT_GPI_PARSE_ERRPR = "RPSG1017";
    /** 没有关联标识  无法关联*/
    public final static String MATCH_FLAG_IS_NULL = "RPSG1018";
    /** 没有关联业务编号  无法关联*/
    public final static String MATCH_OURREF_IS_NULL = "RPSG1019";
    /** 没有报文编号  无法删除关联*/
    public final static String MATCH_MSGNO_IS_NULL = "RPSG1020";
    /** 组装报文 获取string是否含有中文 String转json异常*/
    public final static String STRING_TOJSON_IS_ERROR = "RPSG1021";
    /** 没有报文编号  无法删除关联*/
    public final static String SOPT_SENDER_IS_NULL = "RPSG1022";
    /**------------拆解报文获取fmt103 fmt202接口----------------*/
    /** 报文编号为空*/
    public final static String MT_MSGNO_IS_N0T_NULL = "RPSG1023";
    /** 数据库不存在记录 或查到记录报文不为103 或202*/
    public final static String MT_DATA_ERROR = "RPSG1024";
    /** 发报报文编号为空*/
    public final static String MT_MSGNO_IS_NULL = "RPSG1025";
    /**------------------------暂存接口------------------------*/
    /** 没有根据报文编号找到对应的暂存报文信息*/
    public final static String TEMPORARY_MSGNO_IS_NULL = "RPSG1030";
    /** 报文已发送，无须在发*/
    public final static String TEMPORARY_MESSAGE_SEND_SUCCESS = "RPSG1031";
    /** 暂存成功*/
    public final static String TEMPORARY_MESSAGE_IS_SUCCESS = "KONT0000";

    /******************* 2000-2999************************/

    /** MT报文组装 UserHeader为空 */
    public final static String COPY_ONE_FAIL = "RPSG2001";

    /** MT报文拆解失败 */
    public final static String MT_DISMANTLE_FAIL = "RPSG2002";

    /** 自动派分出错 */
    public final static String MT_AUTO_SEND_ERR = "RPSG2003";

    /** 含有非法字符出错 */
    public final static String MT_CONTAIN_INVALID_CHAR = "RPSG2004";

    /** 路由参数出错 */
    public final static String MT_ROUTESINFO_ERR = "RPSG2005";

    /** 自动派分汇出出错 */
    public final static String MT_AUTO_SEND_OR_ERR = "RPSG2006";


    /******************* 3000-3999************************/
    /** FMT 对象反射获取swHeader */
    public final static String FMT_GET_SWHEADER_ERR = "RPSG3001";

    /******************* 4000-4999************************/
    /** 所属应用不存在！ */
    public final static String FROM_MODULE_ERR = "RPSG4001";

    public final static String RECEIPT_STATE_ERR = "RPSG4002";

    public final static String MT_RECORE_NOT_FOUND = "RPSG4003";

    /******************* 5000-5999************************/
    /** call RMC 失败 */
    public final static String CALL_RMC_ERR = "RPSG5001";
    /** call 汇入失败 */
    public final static String CALL_IR_ERR = "RPSG5002";
    /** call 汇出失败 */
    public final static String CALL_OR_ERR = "RPSG5003";
    /*线程池名称*/
    public final static String TASK_REALTIME_SEND_THREADPOOL_NAME = "task_batchreceive_threadpool";

    /** KONT发报成功码*/
    public final static String SEND_MESSAGE_SUCCESS = "KONT0000";
    /** KONT发报失败码*/
    public final static String SEND_MESSAGE_FAIL = "RPSG9000";

    /*报文组装tips信息提示码*/
    /*报文监察规则tips信息提示码*/
    public static final String MT_MESSAGE_CHECK_FAIL="RPSG9801";
    /*域规则tips信息提示码*/
    public static final String TAG_CHECK_FAIL="RPSG9802";
    /*基础报头，应用报头tips信息提示码*/
    public static final String HEAD_CHECK_FAIL="RPSG9803";

    /** E: system error: 系统异常 */
    public final static String SYS_ERROR = "SYS00001";

}
