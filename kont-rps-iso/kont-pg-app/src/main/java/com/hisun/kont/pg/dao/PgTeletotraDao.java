package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgTeletotraDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgTeletotraMapper
 * @author
 * @date 2021-10-22
 */
@Mapper
public interface PgTeletotraDao extends BaseDao<PgTeletotraDO> {

    /** 根据主键查询 */
    PgTeletotraDO getByKey(PgTeletotraDO pgTeletotraDO);

    /** 根据主键删除 */
    int deleteByKey(PgTeletotraDO pgTeletotraDO);

    }