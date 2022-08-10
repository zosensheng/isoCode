package com.hisun.kont.pg.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.pg.mt.remote.ReceiveRemitMsgRspDTO;
import com.hisun.kont.pg.mt.remote.RepairInfoDTO;
import com.hisun.kont.pg.mt.remote.RspDto;

/**
 * @author: jcL
 * @create: 2021/7/16 11:05
 */
public interface RepairInwardService {
    GenericRspDTO<RspDto> repairInward(GenericDTO<RepairInfoDTO> reqDto);
}
