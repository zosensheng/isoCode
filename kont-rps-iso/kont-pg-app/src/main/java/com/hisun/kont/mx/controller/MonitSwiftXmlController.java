package com.hisun.kont.mx.controller;

import com.hisun.kont.mx.service.MxParseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/swfit/client")
@Api(description = "监听swfit发过来的报文", tags = "MonitFpsXmlController")
public class MonitSwiftXmlController {

    @Resource
    MxParseService mxParseService;

    @ApiOperation(notes = "监听swfit发过来的报文", value = "监听swfit发过来的报文")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/api")
    public String ProcessFpsXml ( @RequestBody String xml){

        return mxParseService.rec(xml);
    }

}
