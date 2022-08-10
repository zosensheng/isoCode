package com.hisun.kont.pg.utils;

import com.hisun.kont.swf.mt.constants.MTConstants;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
//import org.junit.Assert;


public class MTMessageTestUtils {
    //测试Tag消息从文本解析到最终生成
    public static void testPaserToGenMTMessage(String tagStr,Class<?> clazz) {
        System.out.println("=================BEGIN======================");
        BaseTag baseTag=testMTMessageToTag(tagStr,clazz);
        String genMessage=testTagToMTMessage(baseTag);
//        Assert.assertEquals(tagStr,genMessage);
        System.out.println("=================END======================");
    }

    //测试Tag消息从BaseTag到消息，再从消息解析回tag
    public static void testGenToParserMTMessage(BaseTag baseTag) {
        System.out.println("=================BEGIN======================");
        String genMessage=testTagToMTMessage(baseTag);
        BaseTag parserTag=testMTMessageToTag(genMessage,baseTag.getClass());
//        Assert.assertEquals(parserTag.toString(),baseTag.toString());
        System.out.println("=================END======================");
    }

    // 测试Tag消息生成
    public static String testTagToMTMessage(BaseTag baseTag) {
        String message=baseTag.toMTMessage();
        System.out.println(message);
        return message;
    }

    // 测试Tag消息解析
    public static BaseTag testMTMessageToTag(String tagStr,Class<?> clazz) {
        try {
            BaseTag baseTag =(BaseTag) clazz.newInstance();
            baseTag.parser(tagStr);
            System.out.println(baseTag);
            return baseTag;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static String testTagCheckSuccess(BaseTag baseTag) {
        return testTagCheckEqualsCode(baseTag, MTConstants.CHECK_RESULT_CODE_SUCCESS);
    }

    public static String testTagCheckDefaulFailed(BaseTag baseTag) {
        String checkResultCode=baseTag.checkAll();
        System.out.println(checkResultCode);
//        Assert.assertNotEquals(checkResultCode,MTConstants.CHECK_RESULT_CODE_SUCCESS);
        return checkResultCode;
    }

    // 测试Tag消息生成
    public static String testTagCheckEqualsCode(BaseTag baseTag,String resultCode) {
        String checkResultCode=baseTag.checkAll();
        System.out.println(checkResultCode);
//        Assert.assertEquals(checkResultCode,resultCode);
        return checkResultCode;
    }



}
