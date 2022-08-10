package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.common.MTDismantleReqDTO;
import com.hisun.kont.pg.common.MtMsgNoDTO;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.DismantleMTService;
import com.hisun.kont.pg.service.SendService;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DismantleMTServiceImpl implements DismantleMTService {

    private static final Logger log = LoggerFactory.getLogger(DismantleMTServiceImpl.class);

    @Resource
    private com.hisun.kont.pg.service.impl.PgstsServiceImpl pgstsService;

    @Resource
    private SendService sendService;

    @Override
    public BaseMessage dismantleMT(String mtStr) {
        //拆解报文
        BaseMessage baseMessage = parserStr(mtStr);
        return baseMessage.getMessageTagTree() != null && baseMessage.getMessageTagTree().size() != 0 ? baseMessage : null;
    }

    @Override
    public GenericRspDTO<MtMsgNoDTO> dismantleMTAll(GenericDTO<MTDismantleReqDTO> reqDto) {

        MTDismantleReqDTO mtDismantleReqDTO = reqDto.getBody();
        String msgStr = mtDismantleReqDTO.getMsgStr();
        //放入pgsts表中
        PgstsDO pgstsDO = new PgstsDO();
        pgstsDO.setMtStr(msgStr);
        pgstsService.insertMt(pgstsDO);

        GenericRspDTO<MtMsgNoDTO> msgNoDTOGenericRspDTO = new GenericRspDTO<>();
        MtMsgNoDTO mtMsgNoDTO = new MtMsgNoDTO();
        mtMsgNoDTO.setMsgNo(pgstsDO.getMsgNo());
        msgNoDTOGenericRspDTO.setBody(mtMsgNoDTO);

        // 报文拆解
        BaseMessage baseMessage = parserStr(msgStr);
        RmcTrx04 rmcTrx04 = new RmcTrx04();
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        ReqHead reqHead = new ReqHead();
        if (JudgeUtils.isNotNull(baseMessage)) {
            // 拆解成功，对接应用
            sendService.SendToInsts(baseMessage, pgstsDO, rmcTrx04, eaiHeaderDTO,reqHead);
            return msgNoDTOGenericRspDTO;
        }else {
            KontException.throwKontException(MTInStatusConstants.MT_STATUS_DFAIL);
        }
        return null;
    }

    public BaseMessage parserStr(String msgStr){
        //拆解动作
        MessageEnvelope envelope = new MessageEnvelope(msgStr);
        envelope.paserStrToBlockMap();
        BaseMessage baseMessage = new BaseMessage();
        baseMessage = envelope.getMessageList().get(0);
        if (envelope.getInstanceMap().containsKey(baseMessage.getTxCode())) {
            baseMessage.parserMessage();
        }
        return baseMessage;
    }
}
