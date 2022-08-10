package com.hisun.kont.mx.service.impl;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.mx.remote.*;
import com.hisun.kont.mx.service.CheckMxMsgService;
import org.springframework.stereotype.Service;

@Service
public class CheckMxMsgServiceImpl implements CheckMxMsgService{
    @Override
    public GenericRspDTO<MxDto> checkPacs00800108Msg(GenericDTO<SendPacs00800108MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00800108StpMsg(GenericDTO<SendPacs00800108StpMsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00900108Msg(GenericDTO<SendPacs00900108MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00900108AdvMsg(GenericDTO<SendPacs00900108AdvMsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00900108CovMsg(GenericDTO<SendPacs00900108CovMsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkCamt05600108Msg(GenericDTO<SendCamt05600108MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkCamt02900109Msg(GenericDTO<SendCamt02900109MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkCamt05700106Msg(GenericDTO<SendCamt05700106MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkCamt05400108Msg(GenericDTO<SendCamt05400108MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00400109Msg(GenericDTO<SendPacs00400109MsgReqDTO> reqDto) {
        return null;
    }

    @Override
    public GenericRspDTO<MxDto> checkPacs00200110Msg(GenericDTO<SendPacs00200110MsgReqDTO> reqDto) {
        return null;
    }
}
