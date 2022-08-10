package com.hisun.kont.mx.controller;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import com.hisun.kont.mx.service.ListenMxRmcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mx/ListenMxRmc")
@Api(description = "监听RMC的MX功能", tags = "监听RMC的MX功能")
public class ListenMxRmcController {

    @Resource
    private ListenMxRmcService listenMxRmcService;

    @ApiOperation(notes = "接收MX报文", value = "接收MX报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveMxMsg")
    public GenericRspDTO<ReceiveMxMsgRspDTO> receiveMxMsg (@Validated @RequestBody GenericDTO<ReceiveMxMsgReqDTO> reqDto){
        return listenMxRmcService.receiveMxMsg(reqDto);
    }

    @ApiOperation(notes = "接收MX发出报文回执", value = "接收MX发出报文回执")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveMxAck")
    public GenericRspDTO<ReceiveMxAckRspDTO> receiveMxAck (@Validated @RequestBody GenericDTO<ReceiveMxAckReqDTO> reqDto){
        return listenMxRmcService.receiveMxAck(reqDto);
    }

    @ApiOperation(notes = "接收mx_future报文请求", value = "接收mx_future报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveMxFutureMsg")
    public GenericRspDTO<ReceiveMxFutureMsgRspDTO> receiveMxFutureMsg (@Validated @RequestBody GenericDTO<ReceiveMxFutureMsgReqDTO> reqDto){
        return listenMxRmcService.receiveMxFutureMsg(reqDto);
    }
}
