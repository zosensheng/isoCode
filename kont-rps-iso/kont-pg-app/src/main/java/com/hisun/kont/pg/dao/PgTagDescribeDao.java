package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgTagDescribeDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgTagDescribeMapper
 * @author
 * @date 2021-8-3
 */
@Mapper
public interface PgTagDescribeDao extends BaseDao<PgTagDescribeDO> {

    /** 根据主键查询 */
    PgTagDescribeDO getByKey(PgTagDescribeDO pgTagDescribeDO);

    /** 根据主键删除 */
    int deleteByKey(PgTagDescribeDO pgTagDescribeDO);

    }