package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.BankLimitQuotaDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:BankLimitQuotaMapper
 * @author
 * @date 2022-7-12
 */
@Mapper
public interface BankLimitQuotaDao extends BaseDao<BankLimitQuotaDO> {

    /** 根据主键查询 */
    BankLimitQuotaDO getByKey(BankLimitQuotaDO bankLimitQuotaDO);
    /**条件查询*/
    BankLimitQuotaDO select(BankLimitQuotaDO bankLimitQuotaDO);

    /** 根据主键删除 */
    int deleteByKey(BankLimitQuotaDO bankLimitQuotaDO);

    }