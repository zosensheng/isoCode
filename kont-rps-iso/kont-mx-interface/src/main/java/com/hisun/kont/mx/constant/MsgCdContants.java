package com.hisun.kont.mx.constant;

/**
 * 错误码枚举类
 *
 * @author ZHANG YI FA
 * @date 2019-07-15
 **/
public class MsgCdContants {

    /**
     * 交易成功
     */
    public static final String SUCCESS = "KONT0000";
    /**
     * 交易失败
     */
    public static final String FAIL = "KONT0001";

    /* **************************************************************
     * 科目管理 ACCT2300 - ACCT2399
     ***************************************************************/
    /**
     * 科目体系必须输入
     */
    public static final String COAFLG_MUST_INPUT = "ACCT2300";
    /**
     * 科目体系长度最大为2
     */
    public static final String COAFLG_LENGTH_OUT_OF_RANGE = "ACCT2301";
    /**
     * 科目体系长度取值范围越界
     */
    public static final String CAOFLG_VALUE_OUT_OF_RANGE = "ACCT2302";
    /**
     * 科目号必须输入
     */
    public static final String ITM_MUST_INPUT = "ACCT2303";
    /**
     * 科目号长度最大为10
     */
    public static final String ITM_LENGTH_OUT_OF_RANGE = "ACCT2304";
    /**
     * 科目号取值范围越界
     */
    public static final String ITM_VALUE_OUT_OF_RANGE = "ACCT2305";
    /**
     * 科目英文名称必须输入
     */
    public static final String ITM_ENGNM_MUST_INPUT = "ACCT2306";
    /**
     * 科目英文名称长度最大为80
     */
    public static final String TM_ENGNM_LENGTH_OUT_OF_RANGE = "ACCT2307";
    /**
     * 科目中文名称必须输入
     */
    public static final String ITM_CHSNM_MUST_INPUT = "ACCT2308";
    /**
     * 科目中文名称长度最大为80
     */
    public static final String ITM_CHSNM_LENGTH_OUT_OF_RANGE = "ACCT2309";
    /**
     * 科目类别长度最大为1
     */
    public static final String ITM_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2310";
    /**
     * 科目类别取值范围越界
     */
    public static final String ITM_TYPE_VALUE_OUT_OF_RANGE = "ACCT2311";
    /**
     * 科目分类必须输入
     */
    public static final String CATE_MUST_INPUT = "ACCT2312";
    /**
     * 科目分类长度最大为2
     */
    public static final String CATE_LENGTH_OUT_OF_RANGE = "ACCT2313";
    /**
     * 科目分类取值范围越界
     */
    public static final String CATE_VALUE_OUT_OF_RANGE = "ACCT2314";
    /**
     * 科目记账方式必须输入
     */
    public static final String POST_TYPE_MUST_INPUT = "ACCT2315";
    /**
     * 科目记账方式长度最大为2
     */
    public static final String POST_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2316";
    /**
     * 科目记账方式取值范围越界
     */
    public static final String POST_TYPE_VALUE_OUT_OF_RANGE = "ACCT2317";
    /**
     * 自动生成总账标识必须输入
     */
    public static final String AUTO_GEN_MUST_INPUT = "ACCT2318";
    /**
     * 自动生成总账标识长度最大为2
     */
    public static final String AUTO_GEN_LENGTH_OUT_OF_RANGE = "ACCT2319";
    /**
     * 自动生成总账标识取值范围越界
     */
    public static final String AUTO_GEN_VALUE_OUT_OF_RANGE = "ACCT2320";
    /**
     * 明细科目标识必须输入
     */
    public static final String DTL_IND_MUST_INPUT = "ACCT2321";
    /**
     * 明细科目标识长度最大为2
     */
    public static final String DTL_IND_LENGTH_OUT_OF_RANGE = "ACCT2322";
    /**
     * 明细科目标识取值范围越界
     */
    public static final String DTL_IND_VALUE_OUT_OF_RANGE = "ACCT2323";
    /**
     * 科目余额为零标识必须输入
     */
    public static final String BAL_ZERO_FLG_MUST_INPUT = "ACCT2324";
    /**
     * 科目余额为零标识长度最大为2
     */
    public static final String BAL_ZERO_FLG_LENGTH_OUT_OF_RANGE = "ACCT2325";
    /**
     * 科目余额为零标识取值范围越界
     */
    public static final String BAL_ZERO_FLG_VALUE_OUT_OF_RANGE = "ACCT2326";
    /**
     * 余额方向必须输入
     */
    public static final String BAL_SIGN_FLG_MUST_INPUT = "ACCT2327";
    /**
     * 余额方向长度最大为2
     */
    public static final String BAL_SIGN_FLG_LENGTH_OUT_OF_RANGE = "ACCT2328";
    /**
     * 余额方向取值范围越界
     */
    public static final String BAL_SIGN_FLG_VALUE_OUT_OF_RANG = "ACCT2329";
    /**
     * 生效日期必须输入
     */
    public static final String EFF_DATE_MUST_INPUT = "ACCT2330";
    /**
     * 失效日期必须输入
     */
    public static final String EXP_DATE_MUST_INPUT = "ACCT2331";
    /**
     * 主键ID必输
     */
    public static final String PRIMARY_KEY_ID_MUST_INPUT = "ACCT2332";
    /**
     * 主键ID最大为 12位
     */
    public static final String PRIMARY_KEY_ID_LENGTH_OUT_OF_RANGE = "ACCT2333";
    /**
     * 失效日期必须大于生效日期
     */
    public static final String EXP_DATE_MUST_BE_GREATER_THAN_EFF_DATE = "ACCT2334";
    /**
     * 支援账户、同业控制账户不允许和标准账户及控制账户互相转换
     */
    public static final String BACKING_OR_IB_CANT_TRANSFER_TO_STAND_OR_CONTROL = "ACCT2335";
    /**
     * 生效日期不在系统开放周期内
     */
    public static final String EFF_DATE_IS_BEYOND_SYSTEM_OPEN_PERIOD = "ACCT2336";
    /**
     * 科目状态必须是待生效或有效
     */
    public static final String ITM_STATUS_MUST_BE_PENDING_OR_ACTIVE = "ACCT2337";
    /**
     * 总账账户各种余额不为零
     */
    public static final String GENERAL_LEDGER_ACCOUNT_BALANCES_ARE_NOT_ZERO = "ACCT2338";
    /**
     * 总账账户有暂停账户
     */
    public static final String GENERAL_LEDGER_ACCOUNT_HAS_FROZEN_ACCOUNT = "ACCT2339";
    /**
     * 科目状态必须为有效
     */
    public static final String ITM_STATUS_MUST_BE_ACTIVE = "ACCT2340";
    /**
     * 科目状态必须为注销或停止使用
     */
    public static final String ITM_STATUS_MUST_BE_CANCELLED_OR_CLOSED = "ACCT2341";
    /**
     * 总账账户状态必须为关闭或激活状态
     */
    public static final String GENERAL_LEDGER_ACCOUNT_STATUS_CLOSE_OR_ACTIVE = "ACCT2342";
    /**
     * 科目状态必须为冻结
     */
    public static final String ITM_STATUS_MUST_BE_FREEZE = "ACCT2343";
    /**
     * 状态为“有效”的科目不可以通过修改其生效日期将其状态改为“待生效
     */
    public static final String ITM_EFFDATE_NO_UPDATE = "ACCT2344";



    /* **************************************************************
     * 账套管理 ACCT2400 - ACCT2499
     ***************************************************************/
    /**
     * 账套类别必须输入
     */
    public static final String BOOK_FLG_MUST_INPUT = "ACCT2401";
    /**
     * 账套类别长度最大为5
     */
    public static final String BOOK_FLG_LENGTH_OUT_OF_RANGE = "ACCT2402";
    /**
     * 账套序号必输
     */
    public static final String BOOK_TYP_MUST_INPUT = "ACCT2403";
    /**
     * 账套序号长度最大为 2
     */
    public static final String BOOK_TYP_LENGTH_OUT_OF_RANGE = "ACCT2404";
    /**
     * 状态必输
     */
    public static final String STS_MUST_INPUT = "ACCT2405";
    /**
     * 状态长度最大为 1
     */
    public static final String STS_LENGTH_OUT_OF_RANGE = "ACCT2406";
    /**
     * 状态取值范围越界
     */
    public static final String STS_VALUE_OUT_OF_RANG = "ACCT2407";
    /**
     * 科目长度必输
     */
    public static final String ITM_LEN_MUST_INPUT = "ACCT2408";
    /**
     * 科目长度长度最大为 6
     */
    public static final String ITM_LEN_LENGTH_OUT_OF_RANGE = "ACCT2409";
    /**
     * 表内挂账科目必输
     */
    public static final String REAL_SUS_ITM_MUST_INPUT = "ACCT2410";
    /**
     * 表内挂账科目长度最大为 10
     */
    public static final String REAL_SUS_ITM_LENGTH_OUT_OF_RANGE = "ACCT2411";
    /**
     * 表外挂账科目必输
     */
    public static final String MEMO_SUS_ITM_MUST_INPUT = "ACCT2412";
    /**
     * 表外挂账科目长度最大为 10
     */
    public static final String MEMO_SUS_ITM_LENGTH_OUT_OF_RANGE = "ACCT2413";
    /**
     * 未分配利润科目必输
     */
    public static final String PL_ITM_MUST_INPUT = "ACCT2414";
    /**
     * 未分配利润科目长度最大为 10
     */
    public static final String PL_ITM_LENGTH_OUT_OF_RANGE = "ACCT2415";
    /**
     * 内部清算科目必输
     */
    public static final String CRS_BR_ITM_MUST_INPUT = "ACCT2416";
    /**
     * 内部清算科目长度最大为 10
     */
    public static final String CRS_BR_ITM_LENGTH_OUT_OF_RANGE = "ACCT2417";
    /**
     * 名称一致标志必输
     */
    public static final String SAME_NM_FLG_MUST_INPUT = "ACCT2418";
    /**
     * 名称一致标志长度最大为 1
     */
    public static final String SAME_NM_FLG_LENGTH_OUT_OF_RANGE = "ACCT2419";
    /**
     * 表内挂账科目取值范围越界
     */
    public static final String REAL_SUS_ITM_VALUE_OUT_OF_RANG = "ACCT2420";
    /**
     * 表外挂账科目取值范围越界
     */
    public static final String MEMO_SUS_ITM_VALUE_OUT_OF_RANG = "ACCT2421";
    /**
     * 未分配利润科目取值范围越界
     */
    public static final String PL_ITM_LENGTH_VALUE_OUT_OF_RANG = "ACCT2422";
    /**
     * 内部清算科目取值范围越界
     */
    public static final String CRS_BR_ITM_VALUE_OUT_OF_RANG = "ACCT2423";
    /**
     * 名称一致标志取值范围越界
     */
    public static final String SAME_NM_FLG_VALUE_OUT_OF_RANG = "ACCT2424";
    /**
     * 外汇敞口估值损益科目必输
     */
    public static final String REL_RV_ITM_MUST_INPUT = "ACCT2425";
    /**
     * 外汇敞口估值损益科目长度最大为 10
     */
    public static final String REL_RV_ITM_LENGTH_OUT_OF_RANGE = "ACCT2426";
    /**
     * 外汇敞口估值损益科目取值范围越界
     */
    public static final String REL_RV_ITM_VALUE_OUT_OF_RANG = "ACCT2427";
    /**
     * 年度利润科目必输
     */
    public static final String CRT_YR_ITM_MUST_INPUT = "ACCT2428";
    /**
     * 年度利润科目长度最大为 10
     */
    public static final String CRT_YR_ITM_LENGTH_OUT_OF_RANGE = "ACCT2429";
    /**
     * 年度利润科目取值范围越界
     */
    public static final String CRT_YR_ITM_VALUE_OUT_OF_RANG = "ACCT2430";
    /**
     * 科目长度必须一致
     */
    public static final String ITM_LENGTH_MUST_BE_CONSISTENT = "ACCT2431";
    /**
     * 科目号不能重复
     */
    public static final String ITM_NUMBER_CANNOT_BE_REPEATED = "ACCT2432";
    /**
     * 科目号必须存在
     */
    public static final String ITM_NUMBER_MUST_BE_EXIST = "ACCT2433";
    /**
     * 科目必须全部为明细科目
     */
    public static final String ITMS_MUST_BE_ALL_DETAILED = "ACCT2434";
    /**
     * 科目表内表外记账标志必须一致
     */
    public static final String ACCOUNTING_MARKS_MUST_BE_CONSISTENT = "ACCT2435";
    /**
     * 账套更新redis缓存失败
     */
    public static final String REFRESH_AIBKPM_REDIS_FAILED = "ACCT2436";
    /**
     * 账套中文名长度最大为20
     */
    public static final String BOOK_CNM_LENGTH_OUT_OF_RANGE = "ACCT2437";
    /**
     * 账套中文名必须输入
     */
    public static final String BOOK_CNM_MUST_INPUT = "ACCT2438";
    /**
     * 账套英文名长度最大为20
     */
    public static final String BOOK_NM_LENGTH_OUT_OF_RANGE = "ACCT2439";
    /**
     * 账套英文名必须输入
     */
    public static final String BOOK_NM_MUST_INPUT = "ACCT2440";


    /* **************************************************************
     * 科目组管理 ACCT2500 - ACCT2599
     ***************************************************************/
    /**
     * 主科目号必须输入
     */
    public static final String GLMST_MUST_INPUT = "ACCT2500";
    /**
     * 主科目号长度最大为6
     */
    public static final String GLMST_LENGTH_OUT_OF_RANGE = "ACCT2501";
    /**
     * 主科目号取值范围越界
     */
    public static final String GLMST_VALUE_OUT_OF_RANG = "ACCT2502";
    /**
     * 主科目号短名必须输入
     */
    public static final String GLM_SNAME_MUST_INPUT = "ACCT2503";
    /**
     * 主科目号短名长度最大为35
     */
    public static final String GLM_SNAME_LENGTH_OUT_OF_RANGE = "ACCT2504";
    /**
     * 主科目号长名必须输入
     */
    public static final String GLM_LNAME_MUST_INPUT = "ACCT2505";
    /**
     * 主科目号长名长度最大为70
     */
    public static final String GLM_LNAME_LENGTH_OUT_OF_RANGE = "ACCT2506";
    /**
     * 操作标志必须输入
     */
    public static final String GLM_OPT_FLG_MUST_INPUT = "ACCT2507";
    /**
     * 操作标志长度最大为1
     */
    public static final String GLM_OPT_FLG_LENGTH_OUT_OF_RANGE = "ACCT2508";
    /**
     * 操作标志取值范围越界
     */
    public static final String GLM_OPT_FLG_VALUE_OUT_OF_RANG = "ACCT2509";
    /**
     * 相关合约类型1必须输入
     */
    public static final String GLM_CNTY1_MUST_INPUT = "ACCT2510";
    /**
     * 相关合约类型长度最大为8
     */
    public static final String GLM_CNTY1_LENGTH_OUT_OF_RANGE = "ACCT2511";
    /**
     * 交易核对标志必须输入
     */
    public static final String GLM_CKFLG_MUST_INPUT = "ACCT2512";
    /**
     * 交易核对标志长度最大为1
     */
    public static final String GLM_CKFLG_LENGTH_OUT_OF_RANGE = "ACCT2513";
    /**
     * 交易核对标志取值范围越界
     */
    public static final String GLM_CKFLG_VALUE_OUT_OF_RANG = "ACCT2514";
    /**
     * 科目组主键ID必须输入
     */
    public static final String AI_GLM_ID_MUST_INPUT = "ACCT2515";
    /**
     * 科目组主键ID长度最大为12
     */
    public static final String AI_GLM_ID_LENGTH_OUT_OF_RANGE = "ACCT2516";
    /**
     * 科目组主键ID取值范围越界
     */
    public static final String AI_GLM_ID_VALUE_OUT_OF_RANG = "ACCT2517";
    /**
     * 相关合约类型必须存在
     */
    public static final String RELATED_CONTRACT_TYPE_MUST_EXIST = "ACCT2518";
    /**
     * 生效日期必须大于等于当前会计日期
     */
    public static final String EFF_DATE_MUST_BE_GREATER_OR_EQUAL_TO_ACDATE = "ACCT2519";
    /**
     * 生效日期必须小于失效日期
     */
    public static final String EFF_DATE_MUST_BE_LESS_THAN_EXP_DATE = "ACCT2520";
    /**
     * 表内挂账科目必须存在
     */
    public static final String REAL_POSTING_ITM_MUST_BE_EXIST = "ACCT2521";
    /**
     * 表外挂账科目必须存在
     */
    public static final String MEMO_POSTING_ITM_MUST_BE_EXIST = "ACCT2522";
    /**
     * 关联子科目必须存在
     */
    public static final String ASSOCIATED_SUB_ITMS_MUST_BE_EXIST = "ACCT2523";
    /**
     * 表内表外挂账科目必须存在
     */
    public static final String REAL_POSTING_AND_MEMO_POSTING_ITM_MUST_BE_EXIST = "ACCT2524";
    /**
     * 该主科目号已被使用
     */
    public static final String MAIN_ITM_HAS_BEEN_USED = "ACCT2525";
    /**
     * 科目指针必须输入
     */
    public static final String SUB_POINT_MUST_INPUT = "ACCT2526";
    /**
     * 科目指针必长度越界
     */
    public static final String SUB_POINT_LENGTH_OUT_OF_RANGE = "ACCT2527";
    /**
     * 科目指针取值范围越界
     */
    public static final String SUB_POINT_VALUE_OUT_OF_RANG = "ACCT2528";

    /**
     * 子科目必须输入
     */
    public static final String SUB_POINT_VALUE_MUST_INPUT = "ACCT2528";


    //**********************未完待续*********************************/
    /**
     * 请求地址必输
     */
    public static final String URI_MUST_INPUT = "ACCT2600";
    /**
     * 请求地址长度最大为200
     */
    public static final String URI_LENGTH_OUT_OF_RANGE = "ACCT2601";
    /**
     * 新核算单元长度最大为11
     */
    public static final String NEW_BR_LENGTH_OUT_OF_RANGE = "ACCT2602";
    /**
     * 交易类型长度最大为2
     */
    public static final String TR_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2603";
    /**
     * 交易摘要长度最大为120
     */
    public static final String POST_NARR_LENGTH_OUT_OF_RANGE = "ACCT2604";
    /**
     * 合约号/帐号/费用代码必输
     */
    public static final String AC_NO_MUST_INPUT = "ACCT2605";
    /**
     * 合约号/帐号/费用代码 长度最大为25
     */
    public static final String AC_NO_LENGTH_OUT_OF_RANGE = "ACCT2606";
    /**
     * 产品类型 必输
     */
    public static final String PROD_TYPE_MUST_INPUT = "ACCT2607";
    /**
     * 产品类型 长度最大为8
     */
    public static final String PROD_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2608";
    /**
     * 交易描述 长度最大为120
     */
    public static final String DE_SC_LENGTH_OUT_OF_RANGE = "ACCT2609";
    /**
     * 交易助记符 长度最大为8
     */
    public static final String TR_CD_LENGTH_OUT_OF_RANGE = "ACCT2610";
    /**
     * 业务编号 长度最大为32
     */
    public static final String REF_NO_LENGTH_OUT_OF_RANGE = "ACCT2611";
    /**
     * 客户号 长度最大为20
     */
    public static final String CI_NO_LENGTH_OUT_OF_RANGE = "ACCT2612";
    /**
     * 产品码 长度最大为8
     */
    public static final String PROD_CD_LENGTH_OUT_OF_RANGE = "ACCT2613";


    //必输校验
    /**
     * 传票号必须输入
     */
    public static final String SET_NO_MUST_INPUT = "ACCT2001";
    /**
     * 顺序号必须输入
     */
    public static final String SET_SEQ_MUST_INPUT = "ACCT2002";
    /**
     * 新核算单元不能为空
     */
    public static final String NEW_BR_MUST_INPUT = "ACCT2003";
    /**
     * 旧核算单元必须输入
     */
    public static final String OLD_MUST_INPUT = "ACCT2004";
    /**
     * 事件代码必须输入
     */
    public static final String EVEN_CODE_MUST_INPUT = "ACCT2005";
    /**
     * 合约类型必须输入
     */
    public static final String CNTR_TYPE_MUST_INPUT = "ACCT2006";
    /**
     * 货币符必须输入
     */
    public static final String CCY_MUST_INPUT = "ACCT2007";
    /**
     * 事件分录排序序号必须输入
     */
    public static final String ENTY_SORT_SEQ_MUST_INPUT = "ACCT2008";
    /**
     * 交易组别必须输入
     */
    public static final String ENTY_TR_GROUP_MUST_INPUT = "ACCT2009";
    /**
     * 主科目指针必须输入
     */
    public static final String GLMST_PNT_MUST_INPUT = "ACCT2010";
    /**
     * 借贷标志必须输入
     */
    public static final String DR_CR_FLG_MUST_INPUT = "ACCT2011";
    /**
     * 科目指针必须输入
     */
    public static final String ITM_PNT_MUST_INPUT = "ACCT2012";
    /**
     * 表内/表外记账检查标志必须输入
     */
    public static final String ENTY_RM_FLG_MUST_INPUT = "ACCT2013";
    /**
     * 传票生效标志必须输入
     */
    public static final String ENTY_EFF_DAYS_MUST_INPUT = "ACCT2014";
    /**
     * 核算单元必须输入
     */
    public static final String BR_MUST_INPUT = "ACCT2015";
    /**
     * 日志号必须输入
     */
    public static final String MSG_ID_MUST_INPUT = "ACCT2016";
    /**
     * 使用方式必须输入
     */
    public static final String USE_METHOD_FLG_MUST_INPUT = "ACCT2017";
    /**
     * 服务中心必须输入
     */
    public static final String SERV_CTR_MUST_INPUT = "ACCT2018";
    /**
     * 交易时间必须输入
     */
    public static final String TR_TIME_CTR_MUST_INPUT = "ACCT2019";
    /**
     * 账务生成类型必须输入
     */
    public static final String GEN_TYPE_CTR_MUST_INPUT = "ACCT2020";
    /**
     * 业务编号必须输入
     */
    public static final String REF_NO__MUST_INPUT = "ACCT2021";
    /**
     * 挂账标志必须输入
     */
    public static final String SUSPENSE_FLG_MUST_INPUT = "ACCT2022";
    /**
     * 删除标识必须输入
     */
    public static final String DELETE_FLAG_MUST_INPUT = "ACCT2023";
    /**
     * 最后更新用户必须输入
     */
    public static final String LAST_UPDATE_TLR_MUST_INPUT = "ACCT2024";
    //--

    //长度校验
    /**
     * 传票号长度超长
     */
    public static final String SET_NO_LENGTH_OUT_OF_RANGE = "ACCT2101";
    /**
     * 顺序号长度超长
     */
    public static final String SET_SEQ_LENGTH_OUT_OF_RANGE = "ACCT2102";
    /**
     * 旧核算单元号长度超长
     */
    public static final String OLD_LENGTH_OUT_OF_RANGE = "ACCT2103";
    /**
     * 事件代码长度超长
     */
    public static final String EVEN_CODE_LENGTH_OUT_OF_RANGE = "ACCT2104";
    /**
     * 合约类型长度超长
     */
    public static final String CNTR_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2105";
    /**
     * 货币符长度超长
     */
    public static final String CCY_LENGTH_OUT_OF_RANGE = "ACCT2106";
    /**
     * 交易组别长度超长
     */
    public static final String ENTY_TR_GROUP_LENGTH_OUT_OF_RANGE = "ACCT2107";
    /**
     * 科目指针长度超长
     */
    public static final String ITM_PNT_LENGTH_OUT_OF_RANGE = "ACCT2108";
    /**
     * 核算单元长度超长
     */
    public static final String BR_LENGTH_OUT_OF_RANGE = "ACCT2109";
    /**
     * 传票套内顺序号长度超长
     */
    public static final String MSG_ID_LENGTH_OUT_OF_RANGE = "ACCT2110";
    /**
     * 日志号长度超长
     */
    public static final String USE_METHOD_FLG_LENGTH_OUT_OF_RANGE = "ACCT2111";
    /**
     * 服务中心长度超长
     */
    public static final String SERV_CTR_LENGTH_OUT_OF_RANGE = "ACCT2112";
    /**
     * 交易时间长度超长
     */
    public static final String TR_TIME_LENGTH_OUT_OF_RANGE = "ACCT2113";
    /**
     * 账务生成类型长度超长
     */
    public static final String SGEN_TYPE_LENGTH_OUT_OF_RANGE = "ACCT2114";
    /**
     * 挂账标志长度超长
     */
    public static final String SUSPENSE_FLG_LENGTH_OUT_OF_RANGE = "ACCT2115";
    /**
     * 删除标识长度超长
     */
    public static final String DELETE_FLAG_LENGTH_OUT_OF_RANGE = "ACCT2116";
    /**
     * 最后更新用户长度超长
     */
    public static final String LAST_UPDATE_TLR_LENGTH_OUT_OF_RANGE = "ACCT2117";
    //--

    /**
     * 事件分录排序序号越界
     */
    public static final String ENTY_SORT_SEQ_MAX_VALUE = "ACCT2200";
    //枚举
    /**
     * 借贷标志枚举值越界
     */
    public static final String DR_CR_FLG_VALUE_OUT_OF_RANGE = "ACCT2201";
    /**
     * 核算单元标志枚举值越界
     */
    public static final String ENTY_BR_FLG_VALUE_OUT_OF_RANGE = "ACCT2202";
    /**
     * 传票生效标志枚举值越界
     */
    public static final String ENTY_EFF_DAYS_VALUE_OUT_OF_RANGE = "ACCT2203";
    /**
     * 请求参数为空
     */
    public static final String REQ_PARAMETER_IS_EMPTY = "ACCT2204";
    /**
     * 请输入有效ID
     */
    public static final String INPUT_EFFECTIVE_ID = "ACCT2700";
    /**
     * 数据ID已存在，不可重复新增
     */
    public static final String RECORD_ALREADY_EXISTS = "ACCT2701";
    /**
     * 记录不存在，请重新输入
     */
    public static final String RECORD_DOES_NOT_EXIST = "ACCT2702";

    /**
     * 业务事件新增异常
     */
    public static final String AIENTY_TEMP_ADD_EXCEPTION = "ACCT2703";
    /**
     * 传票号不统一
     */
    public static final String SETNO_NOT_UNIFIED = "ACCT2704";
    /**
     * 科目参数配置异常
     */
    public static final String ITM_PARA_CONFIG_EXCEPTION = "ACCT2705";
    /**
     * 起息日期必须输入
     */
    public static final String VAL_DATE_MUST_INPUT = "ACCT2706";
    /**
     * 金额指针必须输入
     */
    public static final String AMT_PNT_MUST_INPUT = "ACCT2707";
    /**
     * 金额指针最大长度为2位
     */
    public static final String AMT_PNT__MAX_VALUE = "ACCT2708";

    /**
     * 金额必须输入
     */
    public static final String AMT_MUST_INPUT = "ACCT2709";

    /**
     * GL产品码必须输入
     */
    public static final String GL_PROD_MUST_INPUT = "ACCT2710";


    /* **************************************************************
     * ACCT 错误码 ACCT3000
     ***************************************************************/
    /**
     * 业务事件新增异常
     */
    public static final String BUZ_EVENT_ADD_EXP = "ACCT3101";
    /**
     * 账务处理异常
     */
    public static final String ACC_HAND_EXP = "ACCT3301";
    /**
     * 科目参数配置异常
     */
    public static final String ACC_PARA_CONF_EXP = "ACCT3302";
    /**
     * 当前会计日已完成记账通知调用
     */
    public static final String CUR_ACC_DATE_FIN_NOTICE = "ACCT3303";
    /**
     * 总账横向检查异常
     */
    public static final String GEN_LED_HOR_CHECKE_EXP = "ACCT3401";
    /**
     * 总账纵向检查异常，当日账面余额异常
     */
    public static final String BOOK_DAY_BAL_EXP = "ACCT3402";
    /**
     * 总账纵向检查异常，上日账面余额异常
     */
    public static final String BOOK_PRE_DAY_BAL_EXP = "ACCT3403";
    /**
     * 总账纵向检查异常，当日借贷发生额异常
     */
    public static final String LOAN_AMOUNT_DAY_EXP = "ACCT3404";
    /**
     * 总账日终处理异常
     */
    public static final String GEN_LED_HAND_DAY_EXP = "ACCT3405";
    /**
     * 总账账户科目的余额日终不为零，科目号：
     */
    public static final String GEN_LED_ACCOUNT_DAY_NOT_ZERO = "ACCT3406";
    /**
     * 总账账户科目的余额月终不为零，科目号：
     */
    public static final String GEN_LED_ACCOUNT_MONTH_NOT_ZERO = "ACCT3407";
    /**
     * 总账账户科目的余额年终不为零，科目号：
     */
    public static final String GEN_LED_ACCOUNT_YEAR_NOT_ZERO = "ACCT3408";
    /**
     * 总账账户上日余额不为零，不能注销，总账账户：
     */
    public static final String CANT_OFF_ACC_PRE_DAY_NOT_ZERO = "ACCT3409";
    /**
     * 总账账户上月余额不为零，不能注销，总账账户：
     */
    public static final String CANT_OFF_ACC_PRE_MONTH_NOT_ZERO = "ACCT3410";
    /**
     * 总账账户上年余额不为零，不能注销，总账账户：
     */
    public static final String CANT_OFF_ACC_PRE_YEAR_NOT_ZERO = "ACCT3411";
    /**
     * 总账账户当日余额不为零，不能注销，总账账户：
     */
    public static final String CANT_OFF_ACC_CUR_DAY_NOT_ZERO = "ACCT3412";
    /**
     * 日期不能为空
     */
    public static final String DATE_CANT_BE_NULL = "ACCT3413";
    /**
     * 总分核对异常，轧差额不为零
     */
    public static final String CHECK_TOTAL_SCORE_ABNORMAL = "ACCT3414";
    /**
     * 该年度下存在超过一条余额信息
     */
    public static final String MORE_THAN_ONE_RECORD_AIHYPL = "ACCT3415";
    /**
     * 余额类分户帐一个分户当天只能存在一条余额记录
     */
    public static final String MORE_THAN_ONE_BAL_RECORD = "ACCT3416";
    /**
     * 获取总账外币损益科目信息为空
     */
    public static final String PROFITS_FOREIGN_CCY_RECORD_NOT_FOUND = "ACCT3417";
    /**
     * 获取总账账套记录为空
     */
    public static final String ACCOUNT_SET_RECORD_NOT_FOUND = "ACCT3418";
    /**
     * 总账账套参数配置错误
     */
    public static final String ACCOUNT_SET_PARAMETER_ERROR = "ACCT3419";



    /* **************************************************************
     * ACC 校验码
     ***************************************************************/
    /**
     * 传票号不符合要求
     */
    public static final String VOU_NUM_NOT_MEET_REQ = "ACCT4001";
    /**
     * 交易核算单元不符合要求
     */
    public static final String TRAN_ACC_UNIT_NOT_MEET_REQ = "ACCT4002";
    /**
     * 核算单元号不符合要求
     */
    public static final String ACC_UNIT_NUM_NOT_MEET_REQ = "ACCT4003";
    /**
     * 交易码不符合要求
     */
    public static final String TRAN_CODE_NOT_MEET_REQ = "ACCT4004";
    /**
     * 货币不符合要求
     */
    public static final String CUR_NOT_MEET_REQ = "ACCT4005";
    /**
     * 交易类型不符合要求
     */
    public static final String TRAN_TYPE_NOT_MEET_REQ = "ACCT4006";
    /**
     * 事件代码不符合要求
     */
    public static final String EVENT_CODE_NOT_MEET_REQ = "ACCT4007";
    /**
     * 合约类型不符合要求
     */
    public static final String CONTRACT_TYPE_NOT_MEET_REQ = "ACCT4008";
    /**
     * 交易描述不符合要求
     */
    public static final String TRAN_DESC_NOT_MEET_REQ = "ACCT4009";
    /**
     * 科目体系不符合要求
     */
    public static final String SUBJECT_SYS_NOT_MEET_REQ = "ACCT4010";
    /**
     * 科目号不符合要求
     */
    public static final String SUBJECT_NUM_NOT_MEET_REQ = "ACCT4011";
    /**
     * 科目中文名不符合要求
     */
    public static final String SUBJECT_CN_NAME_NOT_REQ = "ACCT4012";
    /**
     * 科目类别不符合要求
     */
    public static final String SUBJECT_CATE_NOT_MEET_REQ = "ACCT4013";
    /**
     * 科目分类不符合要求
     */
    public static final String SUBJECT_CLASS_NOT_MEET_REQ = "ACCT4014";
    /**
     * 科目记账方式不符合要求
     */
    public static final String ACC_BOOK_METHOD_NOT_REQ = "ACCT4015";
    /**
     * 自动总账标识不符合要求
     */
    public static final String AUTO_GEN_LED_FLG_NOT_REQ = "ACCT4016";
    /**
     * 明细科目标识不符合要求
     */
    public static final String DETAIL_ACC_FLG_NOT_REQ = "ACCT4017";
    /**
     * 科目余额零标志不符合要求
     */
    public static final String SUBJECT_BAL_ZERO_FLG_NOT_REQ = "ACCT4018";
    /**
     * 余额方向不符合要求
     */
    public static final String BAL_DIRECT_NOT_MEET_REQ = "ACCT4019";
    /**
     * 账套类别不符合要求
     */
    public static final String BOOK_KIND_NOT_MEET_REQ = "ACCT4020";
    /**
     * 账套序号不符合要求
     */
    public static final String BOOK_NUM_NOT_MEET_REQ = "ACCT4021";
    /**
     * 账套状态不符合要求
     */
    public static final String BOOK_STATUS_NOT_MEET_REQ = "ACCT4022";
    /**
     * 科目长度不符合要求
     */
    public static final String SUBJECT_LEN_NOT_MEET_REQ = "ACCT4023";
    /**
     * 科目不符合要求
     */
    public static final String SUBJECT_NOT_MEET_REQ = "ACCT4024";
    /**
     * 名称一致标识不符合要求
     */
    public static final String NAME_EQUAL_FLG_NOT_REQ = "ACCT4025";
    /**
     * 合约主科目对照条件代码不符合要求
     */
    public static final String CONTRACT_MAIN_COMP_CODE_NOT_REQ = "ACCT4026";
    /**
     * 主科目号不符合要求
     */
    public static final String MAIN_SUB_NUM_NOT_REQ = "ACCT4027";
    /**
     * 事件分录排序号不符合要求
     */
    public static final String EVENT_SORT_NUM_NOT_REQ = "ACCT4028";
    /**
     * 交易组别不符合要求
     */
    public static final String TRAN_GROUP_NOT_REQ = "ACCT4029";
    /**
     * 主科目指针不符合要求
     */
    public static final String MAIN_SUB_POINTER_NOT_REQ = "ACCT4030";
    /**
     * 借贷方向不符合要求
     */
    public static final String LEND_DIRECT_NOT_REQ = "ACCT4031";
    /**
     * 科目指针不符合要求
     */
    public static final String SUBJECT_POINTER_NOT_REQ = "ACCT4032";
    /**
     * 核算单元标志不符合要求
     */
    public static final String ACCT_UNIT_FLG_NOT_REQ = "ACCT4033";
    /**
     * 表内/外记账标志不符合要求
     */
    public static final String INTRA_OUTSIDE_RECORD_FLG_NOT_REQ = "ACCT4034";
    /**
     * 传票生效标志不符合要求
     */
    public static final String SUBPOENA_VALID_FLG_NOT_REQ = "ACCT4035";
    /**
     * 事件类型不符合要求
     */
    public static final String EVENT_TYPE_NOT_REQ = "ACCT4036";
    /**
     * 事件备注不符合要求
     */
    public static final String EVENT_NOTES_NOT_REQ = "ACCT4037";
    /**
     * 金额下标不符合要求
     */
    public static final String AMOUNT_SUBSCRIPT_NOT_REQ = "ACCT4038";
    /**
     * 金额计算方式不符合要求
     */
    public static final String AMOUNT_CAL_METHOD_NOT_REQ = "ACCT4039";
    /**
     * 科目名称不符合要求
     */
    public static final String SUBJECT_NAME_NOT_REQ = "ACCT4040";
    /**
     * 主科目操作标志不符合要求
     */
    public static final String MAIN_SUB_OPT_FLG_NOT_REQ = "ACCT4041";
    /**
     * 交易核对标志不符合要求
     */
    public static final String TRAN_CHECK_MARK_NOT_REQ = "ACCT4042";
    /**
     * 科目容器下标不符合要求
     */
    public static final String SUBJECT_CONTAINER_DOWN_NOT_REQ = "ACCT4043";
    /**
     * 科目备注不符合要求
     */
    public static final String SUBJECT_NOTES_NOT_REQ = "ACCT4044";
    /**
     * 事件笔数不符合要求
     */
    public static final String FREQUENCY_OF_THE_EVENT = "ACCT4045";
    /**
     * 金额类型不符合要求
     */
    public static final String AMOUNT_FLG_NOT_REQ = "ACCT4046";


    /**
     * 传票号不统一
     */
    public static final String VOU_NUM_NOT_UNIFORM = "ACCT5001";
    /**
     * 发生额下标不能小于1
     */
    public static final String SUBSCRIPT_AMOUNT_CANT_SMALL_ONE = "ACCT5002";
    /**
     * 金额不能小于0
     */
    public static final String AMOUNT_CANT_SMALL_ZERO = "ACCT5003";
    /**
     * 已记账，不能重复记账
     */
    public static final String CANT_REPEAT_ACCOUNTING = "ACCT5004";
    /**
     * 发起记账，发起人不能为空
     */
    public static final String INITIATOR_OF_BILLING_CANT_NULL = "ACCT5005";
    /**
     * 传票不平，传票号为：
     */
    public static final String SUBPOENA_IS_UNEVEN = "ACCT5006";
    /**
     * 当日未有入账传票
     */
    public static final String NO_SUBPOENA_RECORDED_ON_DAY = "ACCT5007";
    /**
     * 合约类型与事件类型不匹配
     */
    public static final String CONTRACT_TYPE_NOT_MATCH_EVENT_TYPE = "ACCT5008";
    /**
     * 借贷方异常
     */
    public static final String LENDER_DEBIT_EXP = "ACCT5009";
    /**
     * 未找到系统来往科目账户，科目号：
     */
    public static final String SYSTEM_ACCOUNT_ACCOUNT_NOT_FOUND = "ACCT5010";
    /**
     * ID 不能为空
     */
    public static final String ID_CANT_BE_NULL = "ACCT5011";
    /**
     * SFTP 配置不能为空
     */
    public static final String SFTP_CONF_CANT_BE_NULL = "ACCT5012";
    /**
     * SFTP 登录失败
     */
    public static final String SFTP_LOGIN_FAIlED = "ACCT5013";
    /**
     * 该 合约类型 和 产品码 下科目信息不存在
     */
    public static final String ITM_RECORD_NO_EXIST = "ACCT5014";
    /**
     * 该金额指针下匹配不到事件分录
     */
    public static final String AMT_INDEX_ENTRY_RECORD_NO_EXIST = "ACCT5015";
    /**
     * 处理完成标志不符合要求
     */
    public static final String FINISH_FLG_NOT_REQ = "ACCT5016";
    /**
     * 不允许更新历史表数据
     */
    public static final String UPDATE_HIS_TABLE_NOT_ALLOWED = "ACCT5017";
    /**
     * 金额不能为空
     */
    public static final String AMOUNT_CANT_NULL = "ACCT5018";
    /**
     * 应用不符合要求
     */
    public static final String APP_NOT_MEET_REQ = "ACCT5019";
    /**
     * UUID列表入库失败
     */
    public static final String UUID_LIST_INSERT_FAIL = "ACCT5020";
    /**
     * UUID列表为空
     */
    public static final String UUID_LIST_EMPTY = "ACCT5021";
    /**
     * 金额列表为空
     */
    public static final String AMT_LIST_EMPTY = "ACCT5022";

}
