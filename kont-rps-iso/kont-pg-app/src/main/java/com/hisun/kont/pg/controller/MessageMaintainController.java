package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.client.MessageMaintainServiceClient;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.MessageMaintainService;
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
@RequestMapping("/pg/MessageMaintain")
@Api(description = "MT报文维护", tags = "MessageMaintainController")
public class MessageMaintainController extends BaseController implements MessageMaintainServiceClient {
    @Resource
    private MessageMaintainService messageMaintainService;

    @ApiOperation(notes = "报文打印请求", value = "报文打印请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/printMTMessage")
    @ApiId(Id = "008501261335449")
    public GenericRspDTO<PrintMessageRspDTO> printMTMessage (@Validated @RequestBody GenericDTO<PrintMessageReqDTO> reqDto){
    	return messageMaintainService.printMTMessage(reqDto);
    }

    @ApiOperation(notes = "根据报文编号查询报文并打印请求", value = "根据报文编号查询报文并拆解请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/getPrintMessageByNo")
    @ApiId(Id = "008501261335517")
    public GenericRspDTO<GetPrintMessageByNoRspDTO> getPrintMessageByNo (@Validated @RequestBody GenericDTO<GetPrintMessageByNoReqDTO> reqDto){
    	return messageMaintainService.getPrintMessageByNo(reqDto);
    }

    @ApiOperation(notes = "查询报文历史记录请求", value = "查询报文历史记录请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryMsgHisRecd")
    @ApiId(Id = "008501261335529")
    public GenericRspDTO<QueryMsgHisRecdRspDTO> queryMsgHisRecd (@Validated @RequestBody GenericDTO<QueryMsgHisRecdReqDTO> reqDto){
    	return messageMaintainService.queryMsgHisRecd(reqDto);
    }
    @ApiOperation(notes = "报文详情查询请求", value = "报文详情查询请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryMsgHisRecdByNo")
    @ApiId(Id = "008501261335531")
    public GenericRspDTO<QueryMsgHisRecdByNoRspDTO> queryMsgHisRecdByNo (@Validated @RequestBody GenericDTO<QueryMsgHisRecdByNoReqDTO> reqDto){
    	return messageMaintainService.queryMsgHisRecdByNo(reqDto);
    }

    @ApiOperation(notes = "gpi报文关联查询", value = "gpi报文关联查询")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryGpiMsg")
    @ApiId(Id = "0085012613351428")
    public GenericRspDTO<QueryGpiMsgRspDTO> queryGpiMsg (@Validated @RequestBody GenericDTO<F20> reqDto){
        return messageMaintainService.queryGpiMsg(reqDto);
    }

    @ApiOperation(notes = "中文转电码请求", value = "中文转电码请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/cnToTeleNum")
    @ApiId(Id = "0085012613351660")
    public GenericRspDTO<CnToTeleNumRspDTO> cnToTeleNum (@Validated @RequestBody GenericDTO<CnToTeleNumReqDTO> reqDto){
        return messageMaintainService.cnToTeleNum(reqDto);
    }

    @ApiOperation(notes = "根据业务编号查询103报文请求", value = "根据业务编号查询103报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryMsgByOurRef")
    @ApiId(Id = "0085012613351669")
    public GenericRspDTO<QueryMsgByOurRefRspDTO> queryMsgByOurRef (@Validated @RequestBody GenericDTO<QueryMsgByOurRefReqDTO> reqDto){
        return messageMaintainService.queryMsgByOurRef(reqDto);
    }

    @ApiOperation(notes = "字符串的中文折行", value = "字符串的中文折行")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/cnLineWrap")
    @ApiId(Id = "0085012613351662")
    public GenericRspDTO<CnLineWrapRspDTO> cnLineWrap (@Validated @RequestBody GenericDTO<CnLineWrapReqDTO> reqDto){
        return messageMaintainService.cnLineWrap(reqDto);
    }

    @ApiOperation(notes = "一般金额转swift金额请求", value = "一般金额转swift金额请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/amountToSwiftAmount")
    @ApiId(Id = "0085012613351759")
    public GenericRspDTO<AmountToSwiftAmountRspDTO> amountToSwiftAmount (@Validated @RequestBody GenericDTO<AmountToSwiftAmountReqDTO> reqDto){
        return messageMaintainService.amountToSwiftAmount(reqDto);
    }

    @ApiOperation(notes = "關聯或取消關聯業務記錄請求", value = "關聯或取消關聯業務記錄請求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/matchOurRefByMsgNo")
    @ApiId(Id = "0085012613351806")
    public GenericRspDTO<MatchOurRefByMsgNoRspDTO> matchOurRefByMsgNo (@Validated @RequestBody GenericDTO<MatchOurRefByMsgNoReqDTO> reqDto){
        return messageMaintainService.matchOurRefByMsgNo(reqDto);
    }

    @ApiOperation(notes = "一般汇率转报文汇率请求", value = "一般汇率转报文汇率请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/rateToSwiftRate")
    @ApiId(Id = "0085012613351955")
    public GenericRspDTO<RateToSwiftRateRspDTO> rateToSwiftRate (@Validated @RequestBody GenericDTO<RateToSwiftRateReqDTO> reqDto){
        return messageMaintainService.rateToSwiftRate(reqDto);
    }

    @ApiOperation(notes = "报文汇率转一般汇率请求", value = "报文汇率转一般汇率请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/swiftRateToRate")
    @ApiId(Id = "0085012613351956")
    public GenericRspDTO<SwiftRateToRateRspDTO> swiftRateToRate (@Validated @RequestBody GenericDTO<SwiftRateToRateReqDTO> reqDto){
        return messageMaintainService.swiftRateToRate(reqDto);
    }

    @ApiOperation(notes = "报文格式金额转一般金额请求", value = "报文格式金额转一般金额请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/swiftAmountToAmount")
    @ApiId(Id = "0085012613351959")
    public GenericRspDTO<SwiftAmountToAmountRspDTO> swiftAmountToAmount (@Validated @RequestBody GenericDTO<SwiftAmountToAmountReqDTO> reqDto){
        return messageMaintainService.swiftAmountToAmount(reqDto);
    }

    @ApiOperation(notes = "查詢關聯報文請求请求", value = "查詢關聯報文請求请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/queryMatchMessage")
    @ApiId(Id = "0085012613351965")
    public GenericRspDTO<QueryMatchMessageRspDTO> queryMatchMessage (@Validated @RequestBody GenericDTO<QueryMatchMessageReqDTO> reqDto){
        return messageMaintainService.queryMatchMessage(reqDto);
    }

    @ApiOperation(notes = "查询止付关联报文请求", value = "查询止付关联报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/stopPaymentMsg")
    @ApiId(Id = "0085012613352069")
    public GenericRspDTO<StopPaymentMsgRspDTO> stopPaymentMsg (@Validated @RequestBody GenericDTO<StopPaymentMsgReqDTO> reqDto){
        return messageMaintainService.stopPaymentMsg(reqDto);
    }

    @ApiOperation(notes = "发送暂存报文请求", value = "发送暂存报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/SendTemporaryMt")
    @ApiId(Id = "0085012613352071")
    public GenericRspDTO<MtDto> SendTemporaryMt (@Validated @RequestBody GenericDTO<SendTemporaryMtReqDTO> reqDto){
        return messageMaintainService.SendTemporaryMt(reqDto);
    }

    @ApiOperation(notes = "根据报文编号返回fmt103报文信息请求", value = "根据报文编号返回fmt103报文信息请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/getFmt103MessageByMsgNo")
    @ApiId(Id = "0085012613352143")
    public GenericRspDTO<GetFmt103MessageByMsgNoRspDTO> getFmt103MessageByMsgNo (@Validated @RequestBody GenericDTO<GetFmt103MessageByMsgNoReqDTO> reqDto) {
        return messageMaintainService.getFmt103MessageByMsgNo(reqDto);
    }

    @ApiOperation(notes = "根据报文编号返回fmt202报文信息请求请求", value = "根据报文编号返回fmt202报文信息请求请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/getFmt202MessageByMsgNo")
    @ApiId(Id = "0085012613352144")
    public GenericRspDTO<GetFmt202MessageByMsgNoRspDTO> getFmt202MessageByMsgNo (@Validated @RequestBody GenericDTO<GetFmt202MessageByMsgNoReqDTO> reqDto){
        return messageMaintainService.getFmt202MessageByMsgNo(reqDto);
    }

    @ApiOperation(notes = "获取202COVseqB的资料请求", value = "获取202COVseqB的资料请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/get202COVSeqbByMsgNo")
    @ApiId(Id = "0085012613352149")
    public GenericRspDTO<Get202COVSeqbByMsgNoRspDTO> get202COVSeqbByMsgNo (@Validated @RequestBody GenericDTO<Get202COVSeqbByMsgNoReqDTO> reqDto){
        return messageMaintainService.get202COVSeqbByMsgNo(reqDto);
    }

    @ApiOperation(notes = "中文转电码2请求", value = "中文转电码2请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/cnToTeleNumFront")
    @ApiId(Id = "0085012613352196")
    public GenericRspDTO<CnToTeleNumFrontRspDTO> cnToTeleNumFront (@Validated @RequestBody GenericDTO<CnToTeleNumFrontReqDTO> reqDto){
        return messageMaintainService.cnToTeleNumFront(reqDto);
    }

    @ApiOperation(notes = "更改网关流程状态请求", value = "更改网关流程状态请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/updateGwMsgStatusToDele")
    @ApiId(Id = "008501261335220233")
    public GenericRspDTO<UpdateGwMsgStatusToDeleRspDTO> updateGwMsgStatusToDele (@Validated @RequestBody GenericDTO<UpdateGwMsgStatusToDeleReqDTO> reqDto){
        return messageMaintainService.updateGwMsgStatusToDele(reqDto);
    }

    @ApiOperation(notes = "根据报文编号获取RMCTRX01请求", value = "根据报文编号获取RMCTRX01请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/getRmcTrx01ByMsgNo")
    @ApiId(Id = "008501261335220234")
    public GenericRspDTO<GetRmcTrx01ByMsgNoRspDTO> getRmcTrx01ByMsgNo (@Validated @RequestBody GenericDTO<GetRmcTrx01ByMsgNoReqDTO> reqDto){
        return messageMaintainService.getRmcTrx01ByMsgNo(reqDto);
    }
}