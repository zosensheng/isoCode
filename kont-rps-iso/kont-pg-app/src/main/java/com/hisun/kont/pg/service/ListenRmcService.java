package com.hisun.kont.pg.service;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.mt.remote.*;

public interface ListenRmcService {
    GenericRspDTO<ReceiveRemitMsgRspDTO> receiveRemitMessage (GenericDTO<ReceiveRemitMsgReqDTO> reqDto);

    GenericRspDTO<SendRemitMsgACKRspDTO> sendRemitMessageACK (GenericDTO<SendRemitMsgACKReqDTO> reqDto);

    GenericRspDTO<ReceiveFutureMsgRspDTO> receiveFutureMsg (GenericDTO<ReceiveFutureMsgReqDTO> reqDto);

    GenericRspDTO<PasPadiSwfRspDTO> pasPadiSwf (GenericDTO<PasPadiSwfReqDTO> reqDto);

    GenericRspDTO<RedisbuteMsgRspDTO> redisbuteMsg (GenericDTO<RedisbuteMsgReqDTO> reqDto);

}