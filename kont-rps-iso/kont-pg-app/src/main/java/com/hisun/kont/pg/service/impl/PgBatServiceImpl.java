package com.hisun.kont.pg.service.impl;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgtctlDao;
import com.hisun.kont.pg.entity.PgtctlDO;
import com.hisun.kont.pg.service.PgBatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author SKULLMAN
 * @version V1.0
 * @ClassName PgBatServiceImpl
 */
@Service
public class PgBatServiceImpl implements PgBatService {

    private static final Logger logger = LoggerFactory.getLogger(PgBatServiceImpl.class);



    @Resource
    PgtctlDao pgtctlDao;



    @Override
    public void autoCtl(String status) {
        PgtctlDO pgtctlDO = pgtctlDao.getCtl();
        if (JudgeUtils.isNotNull(pgtctlDO)) {
            if (MTInStatusConstants.PG_CTL_OPEN.equals(status)) {
                if ("Y".equals(pgtctlDO.getCtlIAutoSts())) {
                    pgtctlDO.setCtlIStatus(MTInStatusConstants.PG_CTL_OPEN);
                }
                if ("Y".equals(pgtctlDO.getCtlOAutoSts())) {
                    pgtctlDO.setCtlOStatus(MTInStatusConstants.PG_CTL_OPEN);
                }
            }
            if (MTInStatusConstants.PG_CTL_CLOSE.equals(status)) {
                if ("Y".equals(pgtctlDO.getCtlIAutoSts())) {
                    pgtctlDO.setCtlIStatus(MTInStatusConstants.PG_CTL_CLOSE);
                }
                if ("Y".equals(pgtctlDO.getCtlOAutoSts())) {
                    pgtctlDO.setCtlOStatus(MTInStatusConstants.PG_CTL_CLOSE);
                }
            }
            pgtctlDao.updateListPgtctlDto(pgtctlDO);
        }


    }


}
