package com.hisun.kont.pg.dao;

import com.hisun.kont.pg.entity.ClientLimitQuotaDO;
import com.hisun.kont.framework.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * Dao Interface:ClientLimitQuotaMapper
 * @author
 * @date 2022-7-12
 */
@Mapper
public interface ClientLimitQuotaDao extends BaseDao<ClientLimitQuotaDO> {

    /** 根据主键查询 */
    ClientLimitQuotaDO getByKey(ClientLimitQuotaDO clientLimitQuotaDO);


    /** 根据主键删除 */
    int deleteByKey(ClientLimitQuotaDO clientLimitQuotaDO);



    ClientLimitQuotaDO sumTxAmount(ClientLimitQuotaDO clientLimitQuotaDO);

    }