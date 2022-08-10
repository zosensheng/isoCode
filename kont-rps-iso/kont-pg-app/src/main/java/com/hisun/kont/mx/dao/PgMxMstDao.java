package com.hisun.kont.mx.dao;

import com.hisun.kont.framework.dao.BaseDao;
import com.hisun.kont.mx.entity.PgMxMstDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Dao Interface:PgMxMstMapper
 * @author
 * @date 2022-6-8
 */
@Mapper
public interface PgMxMstDao extends BaseDao<PgMxMstDO> {

    /** 根据主键查询 */
    PgMxMstDO getByKey(PgMxMstDO pgMxMstDO);

    /** 根据主键删除 */
    int deleteByKey(PgMxMstDO pgMxMstDO);

    void updateMtStatus(@Param("bizMsgIdr") String bizMsgIdr,@Param("mtStatus") String mtStatus);
}