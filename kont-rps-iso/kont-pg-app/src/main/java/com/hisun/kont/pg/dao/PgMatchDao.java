package com.hisun.kont.pg.dao;

import com.hisun.kont.framework.dao.BaseDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Dao Interface:PgMatchMapper
 * @author
 * @date 2022-1-6
 */
@Mapper
public interface PgMatchDao extends BaseDao<PgMatchDO> {

    /** 根据主键查询 */
    PgMatchDO getByKey(PgMatchDO pgMatchDO);

    /** 根据主键删除 */
    int deleteByKey(PgMatchDO pgMatchDO);

    int updateMatchOurRefByMsgNo(PgMatchDO pgMatchDO);

    //根据批量会计日查询并降序排序
    List<PgMatchDO> getByOurRefAndDesc(PgMatchDO pgMatchDO);

    List<String> getByAcDateAndGroup(PgMatchDO pgMatchDO);

    }