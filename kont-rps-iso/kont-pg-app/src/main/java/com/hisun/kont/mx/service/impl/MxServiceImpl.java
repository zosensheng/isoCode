package com.hisun.kont.mx.service.impl;

import com.hisun.kont.mx.dao.PgMxMstDao;
import com.hisun.kont.mx.entity.PgMxMstDO;
import com.hisun.kont.mx.service.MxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/6/8 16:20
 */
@Service
public class MxServiceImpl implements MxService {

    @Resource
    private PgMxMstDao pgMxMstDao;


    @Override
    public void insertMt(PgMxMstDO pgMxMstDO) {
        pgMxMstDao.insert(pgMxMstDO);

    }

    @Override
    public void updateMtStatus(String bizMsgIdr, String mtStatusDfail) {

        pgMxMstDao.updateMtStatus(bizMsgIdr, mtStatusDfail);
    }

    @Override
    public void updateMt(PgMxMstDO pgMxMstDO) {
        pgMxMstDao.update(pgMxMstDO);
    }

}
