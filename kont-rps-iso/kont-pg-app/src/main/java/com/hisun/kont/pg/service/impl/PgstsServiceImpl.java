package com.hisun.kont.pg.service.impl;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.pg.mt.remote.RmcTrx04;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PgstsServiceImpl implements PgstsService {

    private static final Logger log = LoggerFactory.getLogger(PgstsServiceImpl.class);
    @Resource
    private PgstsDao pgstsDao;

    /**
     * 根据主键查询
     *
     * @param pgstsDO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PgstsDO getByKey(PgstsDO pgstsDO) {
        return pgstsDao.getByKey(pgstsDO);
    }


    /**
     *  发报 外发失败 重发
     * @param pgstsDO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int insertMtByDalete(PgstsDO pgstsDO) {
        String msgNo = pgstsDO.getMsgNo();
        PgstsDO dao = pgstsDao.getByMsgNo(msgNo);
        if (JudgeUtils.isNotNull(dao)){
            log.info("##### DELETE MSGNO:{}",msgNo);
            int result = pgstsDao.delete(msgNo);
            if (result>0){
                log.info("##### DELETE PGSTSDO SUCCESS #####");
            }else {
                log.error("##### DELETE PGSTSDO FAIL #####");
            }
        }
        int insert = pgstsDao.insert(pgstsDO);
        return insert;
    }

    /**
     * 收报 不带账派分失败读重 重派
     * @param pgstsDO
     * @param msgNo
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public int insertMtForRecv(String msgNo,PgstsDO pgstsDO) {
        log.info("##### DELETE MSGNO:{}",msgNo);
        int result = pgstsDao.delete(msgNo);
        if (result>0){
            log.info("##### DELETE PGSTSDO SUCCESS #####");
        }else {
            log.error("##### DELETE PGSTSDO FAIL #####");
        }
        int insert = pgstsDao.insert(pgstsDO);
        if (insert>0){
            log.info("##### INSERT PGSTSDO SUCCESS #####");
        }else {
            log.error("##### INSERT PGSTSDO FAIL #####");
        }
        return insert;
    }

    /**
     *  接收RMC派分报文先存档
     * @param pgstsDO
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int insertMt(PgstsDO pgstsDO) {
        return pgstsDao.insert(pgstsDO);
    }

    /**
     * 拆解后修改报文
     *
     * @param pgstsDO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int updateMt(PgstsDO pgstsDO, BaseMessage baseMessage, ReqHead reqHead, RmcTrx04 rmcTrx04) {
        return pgstsDao.update(pgstsDO);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public PgstsDO getByMsgNo(String msgNo) {
        return pgstsDao.getByMsgNo(msgNo);
    }

    /**
     * 只用于修改状态
     * @param pgstsDO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int updateMtStatus(PgstsDO pgstsDO) {
        return pgstsDao.update(pgstsDO);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int updateOurRef(String msgNo) {
        int update = pgstsDao.updateOurRef(msgNo);
        return update;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int deleteByMsgNo(String msgNo) {
        int result = pgstsDao.delete(msgNo);
        return result;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<PgstsDO> findListByPgstsDo(PgstsDO pgstsDO) {
        List<PgstsDO> pgstsDaoList = pgstsDao.findList(pgstsDO);
        return pgstsDaoList;
    }

    /**
     * 批量修改 pgsts 表状态
     *
     * @param mtKeys
     * @param status
     */
    @Override
    public void batchUpdateStatus(ArrayList<String> mtKeys, String status, LocalDateTime updateTime) {
        pgstsDao.batchUpdateStatus(mtKeys, status, updateTime);
    }


}
