package com.hisun.kont.mx.service;

import com.hisun.kont.mx.entity.PgMxMstDO;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/6/8 16:19
 */
public interface MxService {
    void insertMt(PgMxMstDO pgMxMstDO);


    void updateMtStatus(String bizMsgIdr, String mtStatusDfail);

    void updateMt(PgMxMstDO pgMxMstDO);
}
