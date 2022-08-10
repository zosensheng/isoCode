package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.client.CallRmcServiceClient;
import com.hisun.kont.pg.mt.remote.AutoChannelReqDto;
import com.hisun.kont.pg.mt.remote.AutoChannelRspDto;
import com.hisun.kont.pg.mt.remote.ReceiveRemitMsgAckReqDTO;
import com.hisun.kont.pg.mt.remote.ReceiveRemitMsgAckRspDTO;
import com.hisun.kont.pg.service.CallRmcService;
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
@RequestMapping("/pg/CallRmc")
@Api(description = "调用rmc", tags = "CallRmcController")
public class CallRmcController extends BaseController implements CallRmcServiceClient {
    @Resource
    private CallRmcService callRmcService;

    @ApiOperation(notes = "收入報文的處理結果请求", value = "收入報文的處理結果请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveRemitMessageAck")
    @ApiId(Id = "008501261209773")
    public GenericRspDTO<ReceiveRemitMsgAckRspDTO> receiveRemitMessageAck (@Validated @RequestBody GenericDTO<ReceiveRemitMsgAckReqDTO> reqDto){
    	return callRmcService.receiveRemitMessageAck(reqDto);
    }

    @ApiOperation(notes = "源業務系統開啓暫停處理業務通知接口", value = "源業務系統開啓暫停處理業務通知接口")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sourceSysProcessBussPG")
    @ApiId(Id = "0085012612091108")
    public GenericRspDTO<AutoChannelRspDto> updateSourceSysProcessBussPG (@Validated @RequestBody GenericDTO<AutoChannelReqDto> reqDto){
        return callRmcService.updateSourceSysProcessBussPG(reqDto);
    }
}