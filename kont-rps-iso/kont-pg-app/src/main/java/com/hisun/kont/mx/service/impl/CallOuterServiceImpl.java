package com.hisun.kont.mx.service.impl;


import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.client.AccountServiceClient;
import com.hisun.kont.igw.igw.remote.SendMXSwiftMsgReqDTO;
import com.hisun.kont.igw.igw.remote.SendMXSwiftMsgRspDTO;
import com.hisun.kont.mx.remote.ReqHead;
import com.hisun.kont.mx.remote.RmcMxg01;
import com.hisun.kont.mx.service.CallOuterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CallOuterServiceImpl implements CallOuterService{

    @Resource
    private AccountServiceClient accountServiceClient;

    /**
     * call igw发出MX报文到RMC
     * @param rmcMxg01
     * @param reqHead
     * @return
     */
    @Override
    public GenericRspDTO<SendMXSwiftMsgRspDTO> callIgwSendMxMsg(RmcMxg01 rmcMxg01, ReqHead reqHead) {
        GenericDTO<SendMXSwiftMsgReqDTO> genericDTO = new GenericDTO<>();
        SendMXSwiftMsgReqDTO sendMXSwiftMsgReqDTO = new SendMXSwiftMsgReqDTO();
        BeanUtils.copyProperties(rmcMxg01,sendMXSwiftMsgReqDTO);
        com.hisun.kont.bocpays.remote.ReqHead reqHeadIgw = new com.hisun.kont.bocpays.remote.ReqHead();
        BeanUtils.copyProperties(reqHead,reqHeadIgw);
        sendMXSwiftMsgReqDTO.setReqHead(reqHeadIgw);
        genericDTO.setBody(sendMXSwiftMsgReqDTO);
        GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = accountServiceClient.sendMXSwiftMsg(genericDTO);
        return sendMXSwiftMsgRspDTOGenericRspDTO;
    }
}
