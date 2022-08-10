package com.hisun.kont.pg.scheduled;


import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.service.PgBatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class PgCtlSchedule {

    private static final Logger logger = LoggerFactory.getLogger(PgCtlSchedule.class);

    @Resource
    PgBatService pgBatService;
    /**
     *  自动打开/关闭开关
     */
//    @Scheduled(cron = "0 0 8 * * ?")
    public void autoOpenCtl() {
        try{
            pgBatService.autoCtl(MTInStatusConstants.PG_CTL_OPEN);
        }catch (Exception e){
            logger.error("报文开关",e);
            return;
        }
    }

//    @Scheduled(cron = "0 0 19 * * ?")
    public void autoCloseCtl() {
        try{
            pgBatService.autoCtl(MTInStatusConstants.PG_CTL_CLOSE);
        }catch (Exception e){
            logger.info("报文开关",e);
        }
    }
}
