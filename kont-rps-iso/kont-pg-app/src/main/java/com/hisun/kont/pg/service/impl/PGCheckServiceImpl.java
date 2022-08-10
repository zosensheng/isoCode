package com.hisun.kont.pg.service.impl;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.constants.PgCtlEnum;
import com.hisun.kont.pg.dao.PgtctlDao;
import com.hisun.kont.pg.entity.PgtctlDO;
import com.hisun.kont.pg.service.PGCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author SKULLMAN
 * @version V1.0
 * @ClassName PgHandleServiceImpl
 * @Desc: 检查类
 * @date 2019/9/3 11:15
 */
@Service
public class PGCheckServiceImpl implements PGCheckService {


    @Resource
    PgtctlDao pgtctlDao;






    /**
     *  检查开关
     */
    @Override
    public Boolean checkSwitchCtl(PgCtlEnum ctl) {
        //查询CTL表
        Boolean flag = false;
        PgtctlDO pgtctlDO = pgtctlDao.getCtl();
        if(JudgeUtils.isNull(pgtctlDO)){
            return true;
        }
        if(ctl.equals(PgCtlEnum.SI)){
            if(MTInStatusConstants.PG_CTL_OPEN.equals(pgtctlDO.getCtlIStatus())){
                flag =  true;
            }else {
                flag =  false;
            }
        }
        if(ctl.equals(PgCtlEnum.SO)){
            if(MTInStatusConstants.PG_CTL_OPEN.equals(pgtctlDO.getCtlOStatus())){
                flag =  true;
            }else {
                flag =  false;
            }
        }
        if(ctl.equals(PgCtlEnum.AML)){
            if(MTInStatusConstants.PG_CTL_OPEN.equals(pgtctlDO.getCtlAmlSts())){
                flag =  true;
            }else {
                flag =  false;
            }
        }
        return flag;
    }




}
