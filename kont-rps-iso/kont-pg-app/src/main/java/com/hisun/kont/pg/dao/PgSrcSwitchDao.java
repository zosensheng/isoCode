package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgSrcSwitchDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgSrcSwitchMapper
 * @author
 * @date 2021-7-19
 */
@Mapper
public interface PgSrcSwitchDao extends BaseDao<PgSrcSwitchDO> {

    /** 根据主键查询 */
    PgSrcSwitchDO getByKey(PgSrcSwitchDO pgSrcSwitchDO);

    /** 根据主键删除 */
    int deleteByKey(PgSrcSwitchDO pgSrcSwitchDO);

    }