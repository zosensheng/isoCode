package com.hisun.kont.pg.service.impl;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.dao.PgMatchDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.service.PgMatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author yupeifeng
 * @ClassName: PgMatchServiceImpl
 * @Date 2022/1/11 19:27
 * @Description TODO
 * @Version 1.0
 **/
@Service
@Transactional
public class PgMatchServiceImpl implements PgMatchService {

    private static final Logger log = LoggerFactory.getLogger(PgMatchServiceImpl.class);

    @Resource
    private PgMatchDao pgMatchDao;

    /**
     * 新增
     * @param pgMatchDO
     * @return 处理结果
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int insertPgMatch(PgMatchDO pgMatchDO) {
        PgMatchDO byKey = pgMatchDao.getByKey(pgMatchDO);
        if (JudgeUtils.isNotNull(byKey)){
            log.info("####################### delete pgMatchDO:{}"+pgMatchDO);
            PgMatchDO pgMatchByDelete = new PgMatchDO();
            pgMatchByDelete.setMsgNo(pgMatchDO.getMsgNo());
            pgMatchByDelete.setPagmchOurRef(pgMatchDO.getPagmchOurRef());
            int result = pgMatchDao.deleteEntity(pgMatchByDelete);
            if (result>0){
                log.info("####################### delete pgMatchDO success");
            }else {
                log.info("####################### delete pgMatchDO fail");
            }
        }
        int result = pgMatchDao.insert(pgMatchDO);
        return result;
    }

    /**
     *  根据报文编号或业务编号 删除关联信息
     * @param pgMatchDO
     * @return 处理结果
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int deletePgMatch(PgMatchDO pgMatchDO) {
        int result = pgMatchDao.deleteEntity(pgMatchDO);
        return result;
    }

    /**
     * 根据报文编号更新关联业务编号
     * @param pgMatchDO
     * @return 处理结果
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int updateMatchOurRefByMsgNo(PgMatchDO pgMatchDO) {
        int result = pgMatchDao.updateMatchOurRefByMsgNo(pgMatchDO);
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<PgMatchDO> findListByPgMatchDo(PgMatchDO pgMatchDO) {
        List<PgMatchDO> pgMatchDaoList = pgMatchDao.findList(pgMatchDO);
        return pgMatchDaoList;
    }
}
