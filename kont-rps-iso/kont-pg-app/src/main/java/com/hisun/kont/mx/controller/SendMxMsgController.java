package com.hisun.kont.mx.controller;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import com.hisun.kont.mx.service.SendMxMsgService;
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
@RequestMapping("/mx/SendMxMsg")
@Api(description = "发送MX报文", tags = "发送MX报文")
public class SendMxMsgController {

    @Resource
    private SendMxMsgService mxMsgService;

    @ApiOperation(notes = "发送pacs00800108报文", value = "发送pacs00800108报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00800108Msg")
    public GenericRspDTO<MxDto> sendPacs00800108Msg (@Validated @RequestBody GenericDTO<SendPacs00800108MsgReqDTO> reqDto){
        return mxMsgService.sendPacs00800108Msg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00800108Stp报文", value = "发送Pacs00800108Stp报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00800108StpMsg")
    public GenericRspDTO<MxDto> sendPacs00800108StpMsg ( @Validated @RequestBody GenericDTO<SendPacs00800108StpMsgReqDTO> reqDto){
        return mxMsgService.sendPacs00800108StpMsg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00900108报文", value = "发送Pacs00900108报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00900108Msg")
    public GenericRspDTO<MxDto> sendPacs00900108Msg ( @Validated @RequestBody GenericDTO<SendPacs00900108MsgReqDTO> reqDto){
        return mxMsgService.sendPacs00900108Msg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00900108Adv报文", value = "发送Pacs00900108Adv报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00900108AdvMsg")
    public GenericRspDTO<MxDto> sendPacs00900108AdvMsg ( @Validated @RequestBody GenericDTO<SendPacs00900108AdvMsgReqDTO> reqDto){
        return mxMsgService.sendPacs00900108AdvMsg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00900108Cov报文", value = "发送Pacs00900108Cov报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00900108CovMsg")
    public GenericRspDTO<MxDto> sendPacs00900108CovMsg ( @Validated @RequestBody GenericDTO<SendPacs00900108CovMsgReqDTO> reqDto){
        return mxMsgService.sendPacs00900108CovMsg(reqDto);
    }

    @ApiOperation(notes = "发送Camt05600108报文", value = "发送Camt05600108报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendCamt05600108Msg")
    public GenericRspDTO<MxDto> sendCamt05600108Msg ( @Validated @RequestBody GenericDTO<SendCamt05600108MsgReqDTO> reqDto){
        return mxMsgService.sendCamt05600108Msg(reqDto);
    }

    @ApiOperation(notes = "发送Camt02900109报文", value = "发送Camt02900109报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendCamt02900109Msg")
    public GenericRspDTO<MxDto> sendCamt02900109Msg ( @Validated @RequestBody GenericDTO<SendCamt02900109MsgReqDTO> reqDto){
        return mxMsgService.sendCamt02900109Msg(reqDto);
    }

    @ApiOperation(notes = "发送Camt05700106报文", value = "发送Camt05700106报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendCamt05700106Msg")
    public GenericRspDTO<MxDto> sendCamt05700106Msg ( @Validated @RequestBody GenericDTO<SendCamt05700106MsgReqDTO> reqDto){
        return mxMsgService.sendCamt05700106Msg(reqDto);
    }

    @ApiOperation(notes = "发送Camt05400108报文", value = "发送Camt05400108报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendCamt05400108Msg")
    public GenericRspDTO<MxDto> sendCamt05400108Msg ( @Validated @RequestBody GenericDTO<SendCamt05400108MsgReqDTO> reqDto){
        return mxMsgService.sendCamt05400108Msg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00400109报文", value = "发送Pacs00400109报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00400109Msg")
    public GenericRspDTO<MxDto> sendPacs00400109Msg ( @Validated @RequestBody GenericDTO<SendPacs00400109MsgReqDTO> reqDto){
        return mxMsgService.sendPacs00400109Msg(reqDto);
    }

    @ApiOperation(notes = "发送Pacs00200110报文", value = "发送Pacs00200110报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendPacs00200110Msg")
    public GenericRspDTO<MxDto> sendPacs00200110Msg ( @Validated @RequestBody GenericDTO<SendPacs00200110MsgReqDTO> reqDto){
        return mxMsgService.sendPacs00200110Msg(reqDto);
    }
}
