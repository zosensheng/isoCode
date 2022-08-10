package com.hisun.kont.pg.service;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.common.MTDismantleReqDTO;
import com.hisun.kont.pg.common.MtMsgNoDTO;
import com.hisun.kont.pg.mt.remote.ReceiveRemit103ReqDTO;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;


public interface DismantleMTService {
    BaseMessage dismantleMT(String mtStr);

    GenericRspDTO<MtMsgNoDTO> dismantleMTAll(GenericDTO<MTDismantleReqDTO> reqDto);

   /* GenericRspDTO<MT202ReqDTO> dismantleMT202(GenericDTO<MTDismantleReqDTO> reqDto) throws Exception;

    GenericRspDTO<MT200ReqDTO> dismantleMT200(GenericDTO<MTDismantleReqDTO> reqDto);*/
}
