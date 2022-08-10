package com.hisun.kont.mx.service;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

public interface SendMxMsgService {

    GenericRspDTO<MxDto> sendPacs00800108Msg(@Validated @RequestBody GenericDTO<SendPacs00800108MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00800108StpMsg(@Validated @RequestBody GenericDTO<SendPacs00800108StpMsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00900108Msg(@Validated @RequestBody GenericDTO<SendPacs00900108MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00900108AdvMsg(@Validated @RequestBody GenericDTO<SendPacs00900108AdvMsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00900108CovMsg(@Validated @RequestBody GenericDTO<SendPacs00900108CovMsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendCamt05600108Msg(@Validated @RequestBody GenericDTO<SendCamt05600108MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendCamt02900109Msg(@Validated @RequestBody GenericDTO<SendCamt02900109MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendCamt05700106Msg(@Validated @RequestBody GenericDTO<SendCamt05700106MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendCamt05400108Msg(@Validated @RequestBody GenericDTO<SendCamt05400108MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00400109Msg(@Validated @RequestBody GenericDTO<SendPacs00400109MsgReqDTO> reqDto);

    GenericRspDTO<MxDto> sendPacs00200110Msg(@Validated @RequestBody GenericDTO<SendPacs00200110MsgReqDTO> reqDto);


}
