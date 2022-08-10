//package com.hisun.kont.MT;
//
//import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
//import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;
//import org.junit.Test;
//
///**
// * @author: jcL
// * @create: 2021/7/10 11:12
// */
//public class Mtparser {
//    @Test
//    public void test(){
//        String mt = "{1:F01PONCHKH0AXXX3000000103}{2:O1031226190529BKCHHKH0AXXX76422043131905291929N}{3:{108:387IR000050178}{121:ed6305c9-1f7a-40de-aed0-1621021924c1}}{4:\n" +
//                ":20:HU0225WEI0001\n" +
//                ":23B:CRED\n" +
//                ":32A:230207USD1111,\n" +
//                ":50K:/1234\n" +
//                ":56D:SDFSDFSDF\n" +
//                ":57A:CIYUHKH0XXX\n" +
//                ":59:/01287520009173 \n" +
//                "CHAN SZE\n" +
//                ":71A:SHA\n" +
//                "-}{5:{CHK:4496505D1A00}{TNG:}}{S:{SAC:}{COP:S}}";
//        MessageEnvelope messageEnvelope = new MessageEnvelope(mt);
//        messageEnvelope.paserStrToBlockMap();
//        BaseMessage baseMessage = new BaseMessage();
//        baseMessage = messageEnvelope.getMessageList().get(0);
//        String parserMessage = baseMessage.parserMessage();
//        System.out.println(parserMessage);
//    }
//}
