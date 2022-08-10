package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgSintrateleDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgSintrateleMapper
 * @author
 * @date 2021-10-21
 */
@Mapper
public interface PgSintrateleDao extends BaseDao<PgSintrateleDO> {

    /** 根据主键查询 */
    PgSintrateleDO getByKey(PgSintrateleDO pgSintrateleDO);

    /** 根据主键删除 */
    int deleteByKey(PgSintrateleDO pgSintrateleDO);

    }