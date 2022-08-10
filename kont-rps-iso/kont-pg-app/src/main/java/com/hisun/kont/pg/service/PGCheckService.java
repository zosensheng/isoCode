package com.hisun.kont.pg.service;


import com.hisun.kont.pg.constants.PgCtlEnum;

/**
 * @author SKULLMAN
 * @version V1.0
 * @ClassName PGHandleService
 * @Desc: TODO
 * @date 2019/9/3 21:32
 */
public interface PGCheckService {



    Boolean checkSwitchCtl(PgCtlEnum ctl);


}
