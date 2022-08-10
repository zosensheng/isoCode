package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgSinteleDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgSinteleMapper
 * @author
 * @date 2021-10-22
 */
@Mapper
public interface PgSinteleDao extends BaseDao<PgSinteleDO> {

    /** 根据主键查询 */
    PgSinteleDO getByKey(PgSinteleDO pgSinteleDO);

    /** 根据主键删除 */
    int deleteByKey(PgSinteleDO pgSinteleDO);

    }