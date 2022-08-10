package com.hisun.kont.pg.service;

import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.EaiHeaderDTO;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.pg.mt.remote.RmcTrx04;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;

public interface SendService {


     /**
      *switch 分路，发送前更新状态，发送后更新状态
      */
     String SendToInsts(BaseMessage baseMessage, PgstsDO pgstsDO, RmcTrx04 rmcTrx04, EaiHeaderDTO eaiHeaderDTO, ReqHead reqHead);


     /**
      * 实现类中提供switch 语句分路，发送前更新状态，发送后更新状态。
      */
     void SendToIgwsts();

     String redistriMsg(String msgNo,ReqHead reqHead);

}
