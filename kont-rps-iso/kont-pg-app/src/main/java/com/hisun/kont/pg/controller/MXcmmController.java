package com.hisun.kont.pg.controller;

import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.mx.remote.*;
import com.hisun.kont.pg.service.MXcmmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pg/MXcmm")
@Api(description = "mx公共参数", tags = "MXcmmController")
public class MXcmmController extends BaseController {
    @Resource
    private MXcmmService mXcmmService;

    @ApiOperation(notes = "查看管理类开关状态请求", value = "查看管理类开关状态请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryButtenPgtctl")
    @ApiId(Id = "0007000505912164")
    public GenericRspDTO<QueryButtenPgtctlRspDTO> queryButtenPgtctl (@Validated @RequestBody GenericDTO<QueryButtenPgtctlReqDTO> reqDto){
    	return mXcmmService.queryButtenPgtctl(reqDto);
    }

    @ApiOperation(notes = "修改管理类开关状态请求", value = "修改管理类开关状态请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/updateListPgtctl")
    @ApiId(Id = "0007000505912166")
    public GenericRspDTO<UpdateListPgtctlRspDTO> updateListPgtctl (@Validated @RequestBody GenericDTO<UpdateListPgtctlReqDTO> reqDto){
    	return mXcmmService.updateListPgtctl(reqDto);
    }

    @ApiOperation(notes = "检查支付金额是否超过限额请求", value = "检查支付金额是否超过限额请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/checkTransferLimit")
    @ApiId(Id = "0007000505912171")
    public GenericRspDTO<CheckTransferLimitRspDTO> checkTransferLimit (@Validated @RequestBody GenericDTO<CheckTransferLimitReqDTO> reqDto){
        return mXcmmService.checkTransferLimit(reqDto);
    }

}