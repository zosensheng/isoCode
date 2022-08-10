package com.hisun.kont.mx.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

public interface ListenMxRmcService {

    GenericRspDTO<ReceiveMxMsgRspDTO> receiveMxMsg (@Validated @RequestBody GenericDTO<ReceiveMxMsgReqDTO> reqDto);

    GenericRspDTO<ReceiveMxAckRspDTO> receiveMxAck (@Validated @RequestBody GenericDTO<ReceiveMxAckReqDTO> reqDto);

    GenericRspDTO<ReceiveMxFutureMsgRspDTO> receiveMxFutureMsg(GenericDTO<ReceiveMxFutureMsgReqDTO> reqDto);

}
