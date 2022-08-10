package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.PgtctlDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:PgtctlMapper
 * @author
 * @date 2022-7-6
 */
@Mapper
public interface PgtctlDao extends BaseDao<PgtctlDO> {

    /** 根据主键查询 */
    PgtctlDO getByKey(PgtctlDO pgtctlDO);

    /** 根据主键删除 */
    int deleteByKey(PgtctlDO pgtctlDO);

    PgtctlDO  getListPgtctl(PgtctlDO pgtctlDO);

    int updateListPgtctlDto(PgtctlDO pgtctlDO);

    int insertPgtctDto(PgtctlDO pgtctlDO);

    PgtctlDO getCtl();

    }