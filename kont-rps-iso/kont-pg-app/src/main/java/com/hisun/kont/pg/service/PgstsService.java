package com.hisun.kont.pg.service;

import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.pg.mt.remote.RmcTrx04;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: jcL
 * @create: 2021/5/20 11:09
 */
public interface PgstsService {

    /** 根据主键查询 */
    PgstsDO getByKey(PgstsDO pgstsDO);

    /** 新增报文记录 */
    int insertMt(PgstsDO pgstsDO);
    /** 给发报读重用的 */
    int insertMtByDalete(PgstsDO pgstsDO);
    /**给收报读重用的*/
    int insertMtForRecv(String msgNo,PgstsDO pgstsDO);
    /** 修改 */
    int updateMt(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead, RmcTrx04 rmcTrx04);
    /** (用于测试)根据编号获取pgsts */
    PgstsDO getByMsgNo(String msgNo);

    int updateMtStatus(PgstsDO pgstsDO);

    int updateOurRef(String msgNo);

    int deleteByMsgNo(String msgNo);

    List<PgstsDO> findListByPgstsDo(PgstsDO pgstsDO);

    /** 批量修改 pgsts 表状态 */
    void batchUpdateStatus(ArrayList<String> mtKeys, String status, LocalDateTime updateTime);
}
