package com.hisun.kont.pg.dao;

import com.hisun.kont.framework.dao.BaseDao;
import com.hisun.kont.pg.entity.PgstsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Dao Interface:PgstsMapper
 * @author
 * @date 2021-5-18
 */
@Mapper
public interface PgstsDao extends BaseDao<PgstsDO> {

    /** 根据主键查询 */
    PgstsDO getByKey(PgstsDO pgstsDO);

    PgstsDO getByMsgNo(String msgNo);

    //根据报文编号修改业务编号为null
    int updateOurRef(String msgNo);

    List<PgstsDO> getNowDaySwift(HashMap<String,String> map);

    /** 批量修改 pgsts 表状态 */
    void batchUpdateStatus(@Param("mtKeys") ArrayList<String> mtKeys, @Param("status") String status, @Param("updateTime") LocalDateTime updateTime);

    List<PgstsDO> findListByDate(PgstsDO pgstsDO);

    List<PgstsDO> getByOurRef(String ourRef);

    List<PgstsDO> getByGwMsgStatus(String gwMsgStatus);

    List<PgstsDO> getByVoidFlag(String voidFlag);
}