package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.client.AssembleCheckServiceClient;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.AssembleCheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
/**
 * 这个接口用于报文拆解检查功能，与DismantleMTController相似，区别是这个接口组报后不需要发送
 */
@RestController
@RequestMapping("/pg/AssembleCheck")
@Api(description = "MT报文检查", tags = "AssembleCheckController")
public class AssembleCheckController extends BaseController implements AssembleCheckServiceClient {
    @Resource
    private AssembleCheckService checkService;

    @ApiOperation(notes = "103报文组装检查请求", value = "103报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT103")
    @ApiId(Id = "008501261195873")
    public GenericRspDTO<MtDto> assembleCheckMT103 (@Validated @RequestBody GenericDTO<Fmt103> reqDto)  {
        return checkService.assembleCheckMT103(reqDto);
    }
    @ApiOperation(notes = "202报文组装检查请求", value = "202报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT202")
    @ApiId(Id = "0085012611951288")
    public GenericRspDTO<MtDto> assembleCheckMT202 (@Validated @RequestBody GenericDTO<Fmt202> reqDto)  {
        return checkService.assembleCheckMT202(reqDto);
    }
    @ApiOperation(notes = "200报文组装检查请求", value = "200报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT200")
    @ApiId(Id = "0085012611951366")
    public GenericRspDTO<MtDto> assembleCheckMT200 (@Validated @RequestBody GenericDTO<Fmt200> reqDto)  {
        return checkService.assembleCheckMT200(reqDto);
    }
    @ApiOperation(notes = "202COV报文组装检查请求", value = "202COV报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT202Cov")
    @ApiId(Id = "0085012611951392")
    public GenericRspDTO<MtDtos> assembleCheckMT202Cov (@Validated @RequestBody GenericDTO<Fmt202Cov> reqDto)  {
        return checkService.assembleCheckMT202Cov(reqDto);
    }

    @ApiOperation(notes = "196报文组装检查请求", value = "196报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT196")
    @ApiId(Id = "0085012611951367")
    public GenericRspDTO<MtDto> assembleCheckMT196 (@Validated @RequestBody GenericDTO<Fmt196> reqDto)  {
        return checkService.assembleCheckMT196(reqDto);
    }
    @ApiOperation(notes = "199报文组装检查请求", value = "199报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT199")
    @ApiId(Id = "0085012611951320")
    public GenericRspDTO<MtDto> assembleCheckMT199 (@Validated @RequestBody GenericDTO<Fmt199> reqDto)  {
        return checkService.assembleCheckMT199(reqDto);
    }
    @ApiOperation(notes = "296报文组装检查请求", value = "296报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT296")
    @ApiId(Id = "0085012611951368")
    public GenericRspDTO<MtDto> assembleCheckMT296 (@Validated @RequestBody GenericDTO<Fmt296> reqDto)  {
        return checkService.assembleCheckMT296(reqDto);
    }
    @ApiOperation(notes = "299报文组装检查请求", value = "299报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT299")
    @ApiId(Id = "0085012611951369")
    public GenericRspDTO<MtDto> assembleCheckMT299 (@Validated @RequestBody GenericDTO<Fmt299> reqDto)  {
        return checkService.assembleCheckMT299(reqDto);
    }
    @ApiOperation(notes = "999报文组装检查请求", value = "999报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT999")
    @ApiId(Id = "0085012611951376")
    public GenericRspDTO<MtDto> assembleCheckMT999 (@Validated @RequestBody GenericDTO<Fmt999> reqDto)  {
        return checkService.assembleCheckMT999(reqDto);
    }
    @ApiOperation(notes = "910报文组装检查请求", value = "910报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT910")
    @ApiId(Id = "0085012611951377")
    public GenericRspDTO<MtDto> assembleCheckMT910 (@Validated @RequestBody GenericDTO<Fmt910> reqDto)  {
        return checkService.assembleCheckMT910(reqDto);
    }

    @ApiOperation(notes = "192报文组装检查请求", value = "192报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT192")
    @ApiId(Id = "0085012611951300")
    public GenericRspDTO<MtDto> assembleCheckMT192 (@Validated @RequestBody GenericDTO<Fmt192> reqDto)  {
        return checkService.assembleCheckMT192(reqDto);
    }

    @ApiOperation(notes = "292报文组装检查请求", value = "292报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT292")
    @ApiId(Id = "0085012611951378")
    public GenericRspDTO<MtDto> assembleCheckMT292 (@Validated @RequestBody GenericDTO<Fmt292> reqDto)  {
        return checkService.assembleCheckMT292(reqDto);
    }

    @ApiOperation(notes = "190报文组装检查请求", value = "190报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT190")
    @ApiId(Id = "0085012611951379")
    public GenericRspDTO<MtDto> assembleCheckMT190 (@Validated @RequestBody GenericDTO<Fmt190> reqDto)  {
        return checkService.assembleCheckMT190(reqDto);
    }

    @ApiOperation(notes = "191报文组装检查请求", value = "191报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT191")
    @ApiId(Id = "0085012611951352")
    public GenericRspDTO<MtDto> assembleCheckMT191 (@Validated @RequestBody GenericDTO<Fmt191> reqDto)  {
        return checkService.assembleCheckMT191(reqDto);
    }

    @ApiOperation(notes = "290报文组装检查请求", value = "290报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT290")
    @ApiId(Id = "0085012611951380")
    public GenericRspDTO<MtDto> assembleCheckMT290(@Validated @RequestBody GenericDTO<Fmt290> reqDto)  {
        return checkService.assembleCheckMT290(reqDto);
    }

    @ApiOperation(notes = "291报文组装检查请求", value = "291报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT291")
    @ApiId(Id = "0085012611951381")
    public GenericRspDTO<MtDto> assembleCheckMT291 (@Validated @RequestBody GenericDTO<Fmt291> reqDto)  {
        return checkService.assembleCheckMT291(reqDto);
    }

    @ApiOperation(notes = "950报文组装检查请求", value = "950报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT950")
    @ApiId(Id = "0085012611951382")
    public GenericRspDTO<MtDto> assembleCheckMT950 (@Validated @RequestBody GenericDTO<Fmt950> reqDto)  {
        return checkService.assembleCheckMT950(reqDto);
    }

    @ApiOperation(notes = "900报文组装检查请求", value = "900报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT900")
    @ApiId(Id = "0085012611951383")
    public GenericRspDTO<MtDto> assembleCheckMT900 (@Validated @RequestBody GenericDTO<Fmt900> reqDto)  {
        return checkService.assembleCheckMT900(reqDto);
    }

    @ApiOperation(notes = "210报文组装检查请求", value = "210报文组装检查请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckMT210")
    @ApiId(Id = "0085012611951384")
    public GenericRspDTO<MtDto> assembleCheckMT210 (@Validated @RequestBody GenericDTO<Fmt210> reqDto)  {
        return checkService.assembleCheckMT210(reqDto);
    }

    @ApiOperation(notes = "组装检查单电202COV请求", value = "组装检查单电202COV请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleCheckSingle202COV")
    @ApiId(Id = "008501261195220214")
    public GenericRspDTO<MtDto> assembleCheckSingle202COV (@Validated @RequestBody GenericDTO<AssembleCheckSingle202COVReqDTO> reqDto){
        return checkService.assembleCheckSingle202COV(reqDto);
    }
}