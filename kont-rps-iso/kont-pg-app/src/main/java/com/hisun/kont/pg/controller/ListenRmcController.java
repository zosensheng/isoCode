package com.hisun.kont.pg.controller;


import com.hisun.kont.framework.controller.BaseController;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.data.NoBody;
import com.hisun.kont.metadata.common.apiid.ApiId;
import com.hisun.kont.pg.batch.BatchACK;
import com.hisun.kont.pg.client.ListenRmcServiceClient;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.ListenRmcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/pg/ListenRmcController")
@Api(description = "监听rmc", tags = "ListenRmcController")
public class ListenRmcController extends BaseController implements ListenRmcServiceClient {
    @Resource
    private BatchACK batchACK;

    @Resource
    private ListenRmcService listenRmcService;

    @ApiOperation(notes = "接收報文请求", value = "接收報文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveRemitMessage")
    @ApiId(Id = "008501261329772")
    public GenericRspDTO<ReceiveRemitMsgRspDTO> receiveRemitMessage (@Validated @RequestBody GenericDTO<ReceiveRemitMsgReqDTO> reqDto){
        return listenRmcService.receiveRemitMessage(reqDto);
    }

    @ApiOperation(notes = "發出報文的處理結果请求", value = "發出報文的處理結果请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/sendRemitMessageACK")
    @ApiId(Id = "008501261329817")
    public GenericRspDTO<SendRemitMsgACKRspDTO> sendRemitMessageACK (@Validated @RequestBody GenericDTO<SendRemitMsgACKReqDTO> reqDto){
        return listenRmcService.sendRemitMessageACK(reqDto);
    }

    @ApiOperation(notes = "测试批量ack", value = "测试批量ack")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/testBatchACK")
    public GenericRspDTO<NoBody> testBatchACK (){
        batchACK.batchReceiveMsgAck();
//        GenericDTO<ReceiveRemitMsgReqDTO> reqDTO1 = new GenericDTO<>();
//        ReceiveRemitMsgReqDTO remitMsgReqDTO = new ReceiveRemitMsgReqDTO();
//        remitMsgReqDTO.setBkDt("");
//        remitMsgReqDTO.setCvrSts("");
//        remitMsgReqDTO.setErrCd(0);
//        remitMsgReqDTO.setFininformFg("");
//        remitMsgReqDTO.setFrSys("");
//        remitMsgReqDTO.setFrSys2("");
//        remitMsgReqDTO.setFunCd("");
//        remitMsgReqDTO.setGpiFg("");
//        remitMsgReqDTO.setImposeInd(0);
//        remitMsgReqDTO.setInDueFmFg("");
//        remitMsgReqDTO.setMsgFg("");
//        remitMsgReqDTO.setMsgLen(765);
//        remitMsgReqDTO.setMsgNat("");
//        remitMsgReqDTO.setMsgSrc("");
//        remitMsgReqDTO.setMt(0);
//        remitMsgReqDTO.setNxtDtFg("");
//        remitMsgReqDTO.setOfacRst(0);
//        remitMsgReqDTO.setOpen("");
//        remitMsgReqDTO.setOpen1("");
//        remitMsgReqDTO.setOsn(0);
//        remitMsgReqDTO.setProcSts("");
//        remitMsgReqDTO.setRejInd(0);
//        remitMsgReqDTO.setRelBk(0);
//        remitMsgReqDTO.setRelDt("");
//        remitMsgReqDTO.setRelRef("");
//        remitMsgReqDTO.setRelSeq(0);
//        remitMsgReqDTO.setResendInd("");
//        remitMsgReqDTO.setRmk("");
//        remitMsgReqDTO.setRmtAmt(new BigDecimal(0));
//        remitMsgReqDTO.setRmtCur("");
//        remitMsgReqDTO.setRmtInd("");
//        remitMsgReqDTO.setSender("");
//        remitMsgReqDTO.setSrcBk(12);
//        remitMsgReqDTO.setSrcDt(LocalDate.now());
//        remitMsgReqDTO.setSrcSeq("9999987");
//        remitMsgReqDTO.setStlAc(0l);
//        remitMsgReqDTO.setStlAmt(new BigDecimal(0));
//        remitMsgReqDTO.setStlBk("");
//        remitMsgReqDTO.setStlCur("");
//        remitMsgReqDTO.setStlRt(new BigDecimal(0));
//        remitMsgReqDTO.setSwiftInfo("{1:F01PONCHKH0AXXX3000000103}{2:O1031226190529BKCHBNBBAXXX76422043131905291929N}{3:{108:387IR000050178}{121:ed6305c9-1f7a-40de-aed0-1621021924c1}}{4:\n:20:353ALT17081910\n:13C:/CLSTIME/1201+0620\n:23B:CRED\n:23E:PHOB/this is attachInfo\n:26T:ABC\n:32A:200731HKD850,00\n:33B:HKD1000,00\n:36:7,7552\n:50A:/LINZHONG\r\nCMACMOMXXXX\n:51A:/D/linzhong\r\nCMACMOMXXXX\n:52D:/E/linzhong\r\nbeijing\r\nshanghai\n:53D:/E/linzhong\r\nbeijing\r\nshanghai\n:54B:/E/linzhong\r\ntianjin\n:55D:/A/zmm\r\nbeijing\n:56D:/B/LINZHONG\r\nDSBAHKH0XXX\n:57D:/A/zmm\r\nbeijing\n:59A:/linzhong\r\nCMACMOMXXXX\n:70:TEST CHATS FOR OR 103\n:71A:SHA\n:71F:HKD1000,00\n:71G:HKD1000,00\n:72://SPRO/01/DEPN/06\n:77B:/SPRO/ab/DEPN 06\nSPROab/DEPN 06\n-}{5:{CHK:4496505D1A00}{TNG:}}{S:{SAC:}{COP:S}}");
//        remitMsgReqDTO.setTlxMailFg("");
//        remitMsgReqDTO.setToSys("");
//        remitMsgReqDTO.setTrnRef("");
//        remitMsgReqDTO.setValDt(LocalDate.now());
//        reqDTO1.setBody(remitMsgReqDTO);
//        GenericRspDTO<TR> rspDTO = listenRmcService.receiveRemitMessage(reqDTO1);
//        TR body = rspDTO.getBody();
//        if (body instanceof ReceiveRemitMsgRspDTO) {
//            ReceiveRemitMsgRspDTO receiveRemitMsgRspDTO = (ReceiveRemitMsgRspDTO) body;
//            System.out.println(receiveRemitMsgRspDTO);
//        }
//        if (body instanceof ReceiveRemitMsg2RspDTO) {
//            ReceiveRemitMsg2RspDTO receiveRemitMsg2RspDTO = (ReceiveRemitMsg2RspDTO) body;
//            System.out.println(receiveRemitMsg2RspDTO);
//        }
        return new GenericRspDTO<>();
    }

    @ApiOperation(notes = "接收future报文请求", value = "接收future报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/receiveFutureMsg")
    @ApiId(Id = "0085012613291542")
    public GenericRspDTO<ReceiveFutureMsgRspDTO> receiveFutureMsg (@Validated @RequestBody GenericDTO<ReceiveFutureMsgReqDTO> reqDto){
        return listenRmcService.receiveFutureMsg(reqDto);
    }

    @ApiOperation(notes = "支援IGTB渠道查詢電文请求", value = "支援IGTB渠道查詢電文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/pasPadiSwf")
    @ApiId(Id = "0085012613291813")
    public GenericRspDTO<PasPadiSwfRspDTO> pasPadiSwf (@Validated @RequestBody GenericDTO<PasPadiSwfReqDTO> reqDto){
        return listenRmcService.pasPadiSwf(reqDto);
    }

    @ApiOperation(notes = "重新派送rmc报文请求", value = "重新派送rmc报文请求")
    @ApiResponse(code = 200, message = "")
    @PostMapping("/redisbuteMsg")
    @ApiId(Id = "0085012613292066")
    public GenericRspDTO<RedisbuteMsgRspDTO> redisbuteMsg (@Validated @RequestBody GenericDTO<RedisbuteMsgReqDTO> reqDto){
        return listenRmcService.redisbuteMsg(reqDto);
    }
}