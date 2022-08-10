package com.hisun.kont.pg.service;

import com.hisun.kont.pg.entity.PgMatchDO;

import java.util.List;

public interface PgMatchService{

    int insertPgMatch(PgMatchDO pgMatchDO);

    int deletePgMatch(PgMatchDO pgMatchDO);

    int updateMatchOurRefByMsgNo(PgMatchDO pgMatchDO);

    List<PgMatchDO> findListByPgMatchDo(PgMatchDO pgMatchDO);
}
