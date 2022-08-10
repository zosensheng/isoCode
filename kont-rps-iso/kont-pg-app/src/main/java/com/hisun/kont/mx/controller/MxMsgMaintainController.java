package com.hisun.kont.mx.controller;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.service.MxMsgMainService;
import com.hisun.kont.mx.service.MxParseService;
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
@RequestMapping("/mx/MxMsgMaintain")
@Api(description = "MxMsgMaintainController", tags = "MX报文维护")
public class MxMsgMaintainController {

    @Resource
    private MxMsgMainService mxMsgMainService;

    @Resource
    private MxParseService mxParseService;

    @ApiOperation(notes = "Mx原文转Json", value = "Mx原文转Json")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/mxMsgToJson")
    public GenericRspDTO<String> mxMsgToJson(@Validated @RequestBody GenericDTO<Object> reqDto){
        return mxMsgMainService.mxMsgToJson(reqDto);
    }

    @ApiOperation(notes = "测试", value = "测试")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/mxParse")
    public String mxParse(String xml){
        return mxParseService.rec(xml);
    }
}
