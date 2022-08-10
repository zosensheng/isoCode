package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.client.AssembleServiceClient;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.AssembleService;
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
@RequestMapping("/pg/Assemble")
@Api(description = "报文组装", tags = "AssembleController")
public class AssembleController extends BaseController implements AssembleServiceClient {
    @Resource
    private AssembleService assembleService;

    @ApiOperation(notes = "103报文组装请求", value = "103报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT103")
    @ApiId(Id = "008501261194343")
    public GenericRspDTO<MtDto> assembleMT103(@Validated @RequestBody GenericDTO<SendRemit103ReqDTO> reqDto) {
        return assembleService.assembleMT103(reqDto);
    }

    @ApiOperation(notes = "MT报文头信息录入请求", value = "MT报文头信息录入请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/headerInfo")
    @ApiId(Id = "008501261194345")
    public GenericRspDTO<NoBody> headerInfo(@Validated @RequestBody GenericDTO<SwHeader> reqDto) {
        return assembleService.headerInfo(reqDto);
    }

    @ApiOperation(notes = "910报文组装请求", value = "910报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT910")
    @ApiId(Id = "008501261194346")
    public GenericRspDTO<MtDto> assembleMT910(@Validated @RequestBody GenericDTO<SendRemit910ReqDTO> reqDto) {
        return assembleService.assembleMT910(reqDto);
    }

    @ApiOperation(notes = "192报文组装请求", value = "192报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT192")
    @ApiId(Id = "008501261194347")
    public GenericRspDTO<MtDto> assembleMT192(@Validated @RequestBody GenericDTO<SendRemit192ReqDTO> reqDto) {
        return assembleService.assembleMT192(reqDto);
    }

    @ApiOperation(notes = "292报文组装请求", value = "292报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT292")
    @ApiId(Id = "008501261194348")
    public GenericRspDTO<MtDto> assembleMT292(@Validated @RequestBody GenericDTO<SendRemit292ReqDTO> reqDto) {
        return assembleService.assembleMT292(reqDto);
    }

    @ApiOperation(notes = "190报文组装请求", value = "190报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT190")
    @ApiId(Id = "008501261194349")
    public GenericRspDTO<MtDto> assembleMT190(@Validated @RequestBody GenericDTO<SendRemit190ReqDTO> reqDto) {
        return assembleService.assembleMT190(reqDto);
    }

    @ApiOperation(notes = "202报文组装请求", value = "202报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT202")
    @ApiId(Id = "008501261194350")
    public GenericRspDTO<MtDto> assembleMT202(@Validated @RequestBody GenericDTO<SendRemit202ReqDTO> reqDto) {
        return assembleService.assembleMT202(reqDto);
    }

    @ApiOperation(notes = "200报文组装请求", value = "200报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT200")
    @ApiId(Id = "008501261194351")
    public GenericRspDTO<MtDto> assembleMT200(@Validated @RequestBody GenericDTO<SendRemit200ReqDTO> reqDto) {
        return assembleService.assembleMT200(reqDto);
    }

    @ApiOperation(notes = "191报文组装请求", value = "191报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT191")
    @ApiId(Id = "008501261194352")
    public GenericRspDTO<MtDto> assembleMT191(@Validated @RequestBody GenericDTO<SendRemit191ReqDTO> reqDto) {
        return assembleService.assembleMT191(reqDto);
    }

    @ApiOperation(notes = "290报文组装请求", value = "290报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT290")
    @ApiId(Id = "008501261194353")
    public GenericRspDTO<MtDto> assembleMT290(@Validated @RequestBody GenericDTO<SendRemit290ReqDTO> reqDto) {
        return assembleService.assembleMT290(reqDto);
    }

    @ApiOperation(notes = "291报文组装请求", value = "291报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT291")
    @ApiId(Id = "008501261194354")
    public GenericRspDTO<MtDto> assembleMT291(@Validated @RequestBody GenericDTO<SendRemit291ReqDTO> reqDto) {
        return assembleService.assembleMT291(reqDto);
    }

    @ApiOperation(notes = "196报文组装请求", value = "196报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT196")
    @ApiId(Id = "008501261194355")
    public GenericRspDTO<MtDto> assembleMT196(@Validated @RequestBody GenericDTO<SendRemit196ReqDTO> reqDto) {
        return assembleService.assembleMT196(reqDto);
    }

    @ApiOperation(notes = "950报文组装请求", value = "950报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT950")
    @ApiId(Id = "008501261194356")
    public GenericRspDTO<MtDto> assembleMT950(@Validated @RequestBody GenericDTO<SendRemit950ReqDTO> reqDto) {
        return assembleService.assembleMT950(reqDto);
    }

    @ApiOperation(notes = "199报文组装请求", value = "199报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT199")
    @ApiId(Id = "008501261194357")
    public GenericRspDTO<MtDto> assembleMT199(@Validated @RequestBody GenericDTO<SendRemit199ReqDTO> reqDto) {
        return assembleService.assembleMT199(reqDto);
    }

    @ApiOperation(notes = "299报文组装请求", value = "299报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT299")
    @ApiId(Id = "008501261194358")
    public GenericRspDTO<MtDto> assembleMT299(@Validated @RequestBody GenericDTO<SendRemit299ReqDTO> reqDto) {
        return assembleService.assembleMT299(reqDto);
    }

    @ApiOperation(notes = "296报文组装请求", value = "296报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT296")
    @ApiId(Id = "008501261194359")
    public GenericRspDTO<MtDto> assembleMT296(@Validated @RequestBody GenericDTO<SendRemit296ReqDTO> reqDto) {
        return assembleService.assembleMT296(reqDto);
    }

    @ApiOperation(notes = "999报文组装请求", value = "999报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT999")
    @ApiId(Id = "008501261194360")
    public GenericRspDTO<MtDto> assembleMT999(@Validated @RequestBody GenericDTO<SendRemit999ReqDTO> reqDto) {
        return assembleService.assembleMT999(reqDto);
    }

    @ApiOperation(notes = "900报文组装请求", value = "900报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT900")
    @ApiId(Id = "0085012611941156")
    public GenericRspDTO<MtDto> assembleMT900(@Validated @RequestBody GenericDTO<SendRemit900ReqDTO> reqDto) {
        return assembleService.assembleMT900(reqDto);
    }

    @ApiOperation(notes = "210报文组装请求", value = "210报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT210")
    @ApiId(Id = "0085012611941313")
    public GenericRspDTO<MtDto> assembleMT210(@Validated @RequestBody GenericDTO<SendRemit210ReqDTO> reqDto) {
        return assembleService.assembleMT210(reqDto);
    }

    @ApiOperation(notes = "202COV报文组装请求", value = "202COV报文组装请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleMT202COV")
    @ApiId(Id = "0085012611941248")
    public GenericRspDTO<MtDtos> assembleMT202COV(@Validated @RequestBody GenericDTO<SendRemit202COVReqDTO> reqDto) {
        return assembleService.assembleMT202COV(reqDto);
    }

    @ApiOperation(notes = "组装MT202COV+MT202请求", value = "组装MT202COV+MT202请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assemblDoubleMT202")
    @ApiId(Id = "0085012611942076")
    public GenericRspDTO<MtDtos> assemblDoubleMT202 (@Validated @RequestBody GenericDTO<AssemblDoubleMT202ReqDTO> reqDto){
        return assembleService.assemblDoubleMT202(reqDto);
    }

    @ApiOperation(notes = "组装单电202COV请求", value = "组装单电202COV请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/assembleSingle202COV")
    @ApiId(Id = "008501261194220231")
    public GenericRspDTO<MtDto> assembleSingle202COV (@Validated @RequestBody GenericDTO<AssembleSingle202COVReqDTO> reqDto){
        return assembleService.assembleSingle202COV(reqDto);
    }

}


