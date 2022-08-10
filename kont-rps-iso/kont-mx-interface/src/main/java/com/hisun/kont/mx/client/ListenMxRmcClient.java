package com.hisun.kont.mx.client;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "pg-app",
        url = "${fegin.pgUrl}"
)
public interface ListenMxRmcClient {

    @PostMapping("/mx/ListenMxRmc/receiveMxMsg")
    @ApiOperation(value = "接收MX报文", notes = "接收MX报文")
    GenericRspDTO<ReceiveMxMsgRspDTO> receiveMxMsg (@Validated @RequestBody GenericDTO<ReceiveMxMsgReqDTO> reqDto);

    @PostMapping("/mx/ListenMxRmc/receiveMxAck")
    @ApiOperation(value = "接收MX发出报文回执", notes = "接收MX发出报文回执")
    GenericRspDTO<ReceiveMxAckRspDTO> receiveMxAck (@Validated @RequestBody GenericDTO<ReceiveMxAckReqDTO> reqDto);

    @PostMapping("/mx/ListenMxRmc/receiveMxFutureMsg")
    @ApiOperation(value = "接收mx_future報文請求", notes = "接收mx_future報文請求")
    GenericRspDTO<ReceiveMxFutureMsgRspDTO> receiveMxFutureMsg (@Validated @RequestBody GenericDTO<ReceiveMxFutureMsgReqDTO> reqDto);
}
