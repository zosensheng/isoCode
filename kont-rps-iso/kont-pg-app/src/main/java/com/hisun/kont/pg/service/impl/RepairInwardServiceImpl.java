package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.RepairInwardService;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author: jcL
 * @create: 2021/7/16 11:07
 */
@Service
@Transactional
public class RepairInwardServiceImpl implements RepairInwardService {
    private static final Logger logger = LoggerFactory.getLogger(RepairInwardServiceImpl.class);

    @Resource
    private PgstsDao pgstsDao;
    @Resource
    private DismantleMTServiceImpl dismantleMTService;
    @Resource
    private SendServiceImpl sendService;

    @Override
    public GenericRspDTO<RspDto> repairInward(GenericDTO<RepairInfoDTO> reqDto) {
        ReceiveRemitMsgRspDTO receiveRemitMsgRspDTO = new ReceiveRemitMsgRspDTO();
        // 填充 rmc info
        RmcTrx04 rmcTrx04 = new RmcTrx04();
        BeanUtils.copyProperties(receiveRemitMsgRspDTO, rmcTrx04);
        // 填充 eai header
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        BeanUtils.copyProperties(receiveRemitMsgRspDTO, eaiHeaderDTO);
        RepairInfoDTO repairInfoDTO = reqDto.getBody();
        //入库
        PgstsDO pgstsDO = new PgstsDO();
        pgstsDO.setMtStr(repairInfoDTO.getSwiftInfo());
        pgstsDO.setMsgNo(repairInfoDTO.getMsgNo());
        pgstsDO.setCreatedTime(LocalDateTime.now());
        pgstsDO.setMtStatus(MTInStatusConstants.MT_STATUS_RECV);
        // TODO: 2021/8/19 手工标识 入库
        pgstsDao.insert(pgstsDO);

        BaseMessage baseMessage = null;
        ReqHead reqHead = reqDto.getBody().getReqHead();
        try {
            //拆解
            baseMessage = dismantleMTService.dismantleMT(repairInfoDTO.getSwiftInfo());
            if (baseMessage == null) {
                KontException.throwKontException();
            }
            sendService.SendToInsts(baseMessage,pgstsDO,rmcTrx04,eaiHeaderDTO,reqHead);
        }catch (Exception e){
            logger.error("Swift automatic distribution error!");
        }

        return new  GenericRspDTO<RspDto>();
    }
}
