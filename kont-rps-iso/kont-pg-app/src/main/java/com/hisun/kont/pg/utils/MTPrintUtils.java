package com.hisun.kont.pg.utils;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;

import java.util.*;

public class MTPrintUtils {

    public static String getMTPrintContent(String message, String swiftKey, String senderName, String receiveName){
        MessageEnvelope envelope = new MessageEnvelope(message);
        envelope.paserStrToBlockMap();
        ArrayList<BaseMessage> baseMessageList = envelope.getMessageList();
        BaseMessage baseMessage = baseMessageList.get(0);
        baseMessage.parserMessage();
        String msgPrint = baseMessage.getPrintFormat(swiftKey,senderName,receiveName);
        return msgPrint;
    }

    /**
     * 对于不支持的报文类型  只打印头部
     */
    public static String getHeaderPrintContent(String message,String swiftKey,String senderName,String receiveName){
        MessageEnvelope envelope = new MessageEnvelope(message);
        envelope.paserStrToBlockMap();
        ArrayList<BaseMessage> baseMessageList = envelope.getMessageList();
        BaseMessage baseMessage = baseMessageList.get(0);
        baseMessage.parserMessage();
        String msgPrint = baseMessage.getPrintFormatWithoutMt(swiftKey,senderName,receiveName);
        return msgPrint;
    }
}
