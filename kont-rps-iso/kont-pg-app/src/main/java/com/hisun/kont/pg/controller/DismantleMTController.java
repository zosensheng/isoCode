package com.hisun.kont.pg.controller;

import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.common.MTDismantleReqDTO;
import com.hisun.kont.pg.common.MtMsgNoDTO;
import com.hisun.kont.pg.service.DismantleMTService;
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
@RequestMapping("/pg/DismantleMT")
@Api(description = "MT报文拆解", tags = "DismantleMTController")
public class DismantleMTController {
    @Resource
    private DismantleMTService dismantleMTService;

    @ApiOperation(notes = "报文拆解", value = "103报文拆解")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/dismantleMT103")
    public GenericRspDTO<MtMsgNoDTO> dismantleMT(@Validated @RequestBody GenericDTO<MTDismantleReqDTO> reqDto){
        return dismantleMTService.dismantleMTAll(reqDto);
    }
}
