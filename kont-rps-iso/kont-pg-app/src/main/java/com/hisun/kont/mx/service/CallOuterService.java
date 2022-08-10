package com.hisun.kont.mx.service;

import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.igw.remote.SendMXSwiftMsgRspDTO;
import com.hisun.kont.mx.remote.ReqHead;
import com.hisun.kont.mx.remote.RmcMxg01;

public interface CallOuterService {

    GenericRspDTO<SendMXSwiftMsgRspDTO> callIgwSendMxMsg(RmcMxg01 rmcMxg01, ReqHead reqHead);
}
