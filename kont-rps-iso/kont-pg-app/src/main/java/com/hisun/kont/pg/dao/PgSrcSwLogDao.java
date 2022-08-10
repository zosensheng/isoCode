package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgSrcSwLogDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgSrcSwLogMapper
 * @author
 * @date 2021-7-20
 */
@Mapper
public interface PgSrcSwLogDao extends BaseDao<PgSrcSwLogDO> {

    /** 根据主键查询 */
    PgSrcSwLogDO getByKey(PgSrcSwLogDO pgSrcSwLogDO);

    /** 根据主键删除 */
    int deleteByKey(PgSrcSwLogDO pgSrcSwLogDO);

    }