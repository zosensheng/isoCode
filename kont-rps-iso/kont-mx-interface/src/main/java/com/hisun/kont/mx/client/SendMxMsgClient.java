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
public interface SendMxMsgClient {

    @PostMapping("/mx/SendMxMsg/SendPacs00800108Msg")
    @ApiOperation(value = "发送Pacs00800108接口", notes = "发送Pacs00800108接口")
    GenericRspDTO<MxDto> SendPacs00800108Msg(@Validated @RequestBody GenericDTO<SendPacs00800108MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/SendPacs00800108StpMsg")
    @ApiOperation(value = "发送Pacs00800108Stp接口", notes = "发送Pacs00800108Stp接口")
    GenericRspDTO<MxDto> SendPacs00800108StpMsg(@Validated @RequestBody GenericDTO<SendPacs00800108StpMsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendPacs00900108Msg")
    @ApiOperation(value = "发送sendPacs00900108Msg接口", notes = "发送sendPacs00900108Msg接口")
    GenericRspDTO<MxDto> sendPacs00900108Msg(@Validated @RequestBody GenericDTO<SendPacs00900108MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendPacs00900108AdvMsg")
    @ApiOperation(value = "发送sendPacs00900108AdvMsg接口", notes = "发送sendPacs00900108AdvMsg接口")
    GenericRspDTO<MxDto> sendPacs00900108AdvMsg(@Validated @RequestBody GenericDTO<SendPacs00900108AdvMsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendPacs00900108CovMsg")
    @ApiOperation(value = "发送sendPacs00900108CovMsg接口", notes = "发送sendPacs00900108CovMsg接口")
    GenericRspDTO<MxDto> sendPacs00900108CovMsg(@Validated @RequestBody GenericDTO<SendPacs00900108CovMsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendCamt05600108Msg")
    @ApiOperation(value = "发送sendCamt05600108Msg接口", notes = "发送sendCamt05600108Msg接口")
    GenericRspDTO<MxDto> sendCamt05600108Msg(@Validated @RequestBody GenericDTO<SendCamt05600108MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendCamt02900109Msg")
    @ApiOperation(value = "发送sendCamt02900109Msg接口", notes = "发送sendCamt02900109Msg接口")
    GenericRspDTO<MxDto> sendCamt02900109Msg(@Validated @RequestBody GenericDTO<SendCamt02900109MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendCamt05700106Msg")
    @ApiOperation(value = "发送sendCamt05700106Msg接口", notes = "发送sendCamt05700106Msg接口")
    GenericRspDTO<MxDto> sendCamt05700106Msg(@Validated @RequestBody GenericDTO<SendCamt05700106MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendCamt05400108Msg")
    @ApiOperation(value = "发送sendCamt05400108Msg接口", notes = "发送sendCamt05400108Msg接口")
    GenericRspDTO<MxDto> sendCamt05400108Msg(@Validated @RequestBody GenericDTO<SendCamt05400108MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendPacs00400109Msg")
    @ApiOperation(value = "发送sendPacs00400109Msg接口", notes = "发送sendPacs00400109Msg接口")
    GenericRspDTO<MxDto> sendPacs00400109Msg(@Validated @RequestBody GenericDTO<SendPacs00400109MsgReqDTO> reqDto);

    @PostMapping("/mx/SendMxMsg/sendPacs00200110Msg")
    @ApiOperation(value = "发送sendPacs00200110Msg接口", notes = "发送sendPacs00200110Msg接口")
    GenericRspDTO<MxDto> sendPacs00200110Msg(@Validated @RequestBody GenericDTO<SendPacs00200110MsgReqDTO> reqDto);
}
