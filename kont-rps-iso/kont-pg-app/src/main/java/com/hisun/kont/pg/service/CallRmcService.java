package com.hisun.kont.pg.service;


import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.igw.remote.LongIncomeMsgFetchRspDTO;
import com.hisun.kont.igw.igw.remote.SendRemitMessageRspDTO;
import com.hisun.kont.igw.igw.remote.SourceSysProcessBussRspDTO;
import com.hisun.kont.pg.mt.remote.*;

public interface CallRmcService {
    GenericRspDTO<ReceiveRemitMsgAckRspDTO> receiveRemitMessageAck (GenericDTO<ReceiveRemitMsgAckReqDTO> reqDto);

    GenericRspDTO<SendRemitMessageRspDTO> sendRemitMessagePG (GenericDTO<SendRemitMsgReqPGDTO> reqDto);

    GenericRspDTO<LongIncomeMsgFetchRspDTO> longIncomeMsgFetchPG (GenericDTO<LongIncomeMsgFetchReqPGDTO> reqDto);

    GenericRspDTO<SourceSysProcessBussRspDTO> sourceSysProcessBussPG (GenericDTO<SourceSysProcessBussReqPGDTO> reqDto);

    GenericRspDTO<AutoChannelRspDto> updateSourceSysProcessBussPG (GenericDTO<AutoChannelReqDto> reqDto);

}