package com.hisun.kont.pg.service;

import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;

public class RecService {


    /**
     * 拆解方法
     * @param mtStr
     * @return
     */
    public BaseMessage ParsMt(String mtStr){
//        BaseMessage baseMessage = new BaseMessage();
        MessageEnvelope envelope = new MessageEnvelope(mtStr);
        envelope.paserStrToBlockMap();
        BaseMessage baseMessage = new BaseMessage();
        baseMessage = envelope.getMessageList().get(0);
        return baseMessage;
    }







}
