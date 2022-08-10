package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.client.RepairInwardServiceClient;
import com.hisun.kont.pg.common.MTDismantleReqDTO;
import com.hisun.kont.pg.mt.remote.ReceiveRemitMsgRspDTO;
import com.hisun.kont.pg.mt.remote.RepairInfoDTO;
import com.hisun.kont.pg.mt.remote.RspDto;
import com.hisun.kont.pg.service.RepairInwardService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: jcL
 * @create: 2021/7/16 10:59
 */
@RestController
@RequestMapping("/pg/RepairInward")
public class RepairInwardController implements RepairInwardServiceClient {

    @Resource
    private RepairInwardService repairInwardService;

    @ApiOperation(notes = "repair汇入请求", value = "repair汇入请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/repairInward")
    @ApiId(Id = "0085012614001214")
    public GenericRspDTO<RspDto> repairInward(@Validated @RequestBody GenericDTO<RepairInfoDTO> reqDto){
        return repairInwardService.repairInward(reqDto);
    }
}
