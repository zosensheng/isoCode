package com.hisun.kont.pg.utils;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.swf.mt.constants.MTConstants;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Pattern;


/**
 * 支持650打印格式中的电码转中文
 * @author: jcL
 * @create: 2021/7/15 10:05
 */
public class TeleCh650Util {

    private static final Logger logger = LoggerFactory.getLogger(TeleCh650Util.class);
    /* 会存在电码且需要转换的域 */
    private static HashSet<String> tagSet = new HashSet<String>(){{
        add("50K");
        add("50F");
        add("52D");
        add("53B");
        add("53D");
        add("54B");
        add("54D");
        add("55B");
        add("55D");
        add("56C");
        add("56D");
        add("57B");
        add("57D");
        add("58D");
        add("59");
        add("70");
        add("72");
        add("79");
    }};
    /**
     * 报文描述
     */
    public static HashMap<String, String> describe = new HashMap<String, String>() {{
        put("MT103","SINGLE CUSTOMER CREDIT TRANSFER");
//        put("MT110","Advice of Cheque(s)");
//        put("MT111","Request for Stop Payment of a Cheque");
//        put("MT112","Status of a Request for Stop Payment of a Chequ");
        put("MT190","Advice of Charges, Interest and Other Adjustments");
        put("MT191","Request for Payment of Charges, Interest and Other Expenses");
        put("MT192","Request for Cancellation");
//        put("MT195","Queries");
        put("MT196","Answers");
        put("MT199","Free Format Message");
        put("MT200","Financial Institution Transfer for its Own Account");
//        put("MT201","Multiple Financial Institution Transfer for its Own Account");
        put("MT202","General Financial Institution Transfer");
        put("MT202 COV","General Financial Institution Transfer");
//        put("MT203","Multiple General Financial Institution Transfer");
//        put("MT205","Financial Institution Transfer Execution");
        put("MT210","Notice to Receive");
        put("MT290","Advice of Charges, Interest and Other Adjustments");
        put("MT291","Request for Payment of Charges, Interest and Other Expenses");
        put("MT292","Request for Cancellation");
//        put("MT295","Queries");
        put("MT296","Answers");
        put("MT299","Free Format Message");
//        put("MT395","Queries");
//        put("MT396","Answers");
//        put("MT399","Free Format Message");
//        put("MT400","Advice of Payment");
//        put("MT410","Acknowledgement");
//        put("MT412","Advice of Acceptance");
//        put("MT416","Advice of Non-Payment/Non-Acceptance");
//        put("MT420","Tracer");
//        put("MT422","Advice of Fate and Request for Instructions");
//        put("MT430","Amendment of Instructions");
//        put("MT450","Cash Letter Credit Advice");
//        put("MT455","Cash Letter Credit Adjustment Advice");
//        put("MT456","Advice of Dishonour");
//        put("MT491","Request for Payment of Charges, Interest and Other Expenses");
//        put("MT492","Request for Cancellatio");
//        put("MT495","Queries");
//        put("MT496","Answers");
//        put("MT499","Free Format Message");
//        put("MT595","Queries");
//        put("MT596","Answers");
//        put("MT599","Free Format Message");
//        put("MT695","Queries");
//        put("MT696","Answers");
//        put("MT699","Free Format Message");
//        put("MT701","Issue of a Documentary Credit");
//        put("MT795","Queries");
//        put("MT796","Answers");
//        put("MT895","Queries");
//        put("MT896","Answers");
//        put("MT899","Free Format Message");
        put("MT900","Confirmation of Debit");
        put("MT910","Confirmation of Credit");
//        put("MT940","Customer Statement Message");
        put("MT950","Statement Message");
//        put("MT995","Queries");
//        put("MT996","Answers");
        put("MT999","Free Format Message");
//        put("MTN99","  ");
    }};

    private static String regex = "^:[0-9a-zA-Z]{2,3}:";

    public static HashSet<String> getTagSet() {
        return tagSet;
    }

    /**
     * 打印原报文的格式(带电码)
     * @param message  报文组装内容
     * @param swiftKey 报文编号
     * @param txCode 报文类型
     * @param sender  发报行bicCode
     * @param senderName 发报行名称
     * @param receiveName 收报行名称
     * @param receive  收报行bicCode
     * @param tagDescriptionMap
     * @param ohCov 报文状态
     * @return  打印格式
     */
    public static String orgMessageTo650(String message,String swiftKey, String txCode, String sender,
                                      String senderName,String receiveName, String receive,Map<String,String> tagDescriptionMap,
                                         String ohCov,String ohGpiRef,String ohGpcFlg,String appHeaderMessage){
        logger.info("##### START TO 23650,PRINT MT MESSAGE #####");
        if (message == null || StringUtils.isEmpty(message)) {
            return message;
        }else {
            //组650打印格式
            StringBuilder str650 = new StringBuilder();
            BaseMessage baseMessage = new BaseMessage();
            //获取报文描述信息
            String mtDescription = null;
            if (JudgeUtils.isNotNull(ohCov)){
                mtDescription = describe.get("MT"+txCode+" "+ohCov) == null ? "" : describe.get("MT"+txCode+" "+ohCov);
            }else {
                mtDescription = describe.get("MT"+txCode) == null ? "" : describe.get("MT"+txCode);
            }
            //打印报文编号
            str650.append(baseMessage.printFormatDefine("SWIFT KEY", swiftKey));
            if ("202".equals(txCode) && JudgeUtils.isNotNull(ohCov)){
                str650.append(printDefine("MT "+txCode+" "+ohCov+" / "+ mtDescription+ MTConstants.MT_MESSAGE_LINE_MARK));
            }else {
                str650.append(printDefine("MT "+txCode+" / "+ mtDescription+ MTConstants.MT_MESSAGE_LINE_MARK));
            }
            //接收日期  只有为收入报文时判断  判断收报根据报文编号第12位
            if (JudgeUtils.isNotNull(swiftKey)){
                if ("0".equals(swiftKey.substring(11,12))||"2".equals(swiftKey.substring(11,12))){
                    //截取收报日期
//                    String recDate = appHeaderMessage.substring(36, 42);
                    String recDate = swiftKey.substring(3, 11);
                    String receiveDate = MTMsgUtils.strFormat(recDate);
                    str650.append(baseMessage.printFormatDefine("RECEIVE DATE", receiveDate));
                }
            }
            str650.append(baseMessage.printFormatDefine("SENDER", sender));
            //第六行~第九行
            if (JudgeUtils.isNull(senderName)){
                str650.append(baseMessage.printFormatDefine("SENDER NAME", ""));
            }else {
                if (senderName.length()<35){
                    str650.append(baseMessage.printFormatDefine("SENDER NAME", senderName));
                }else if (senderName.length()>=35&&senderName.length()<70){
                    str650.append(baseMessage.printFormatDefine("SENDER NAME", senderName.substring(0,35)));
                    str650.append(printFormat("", senderName.substring(35)));
                }else if (senderName.length()>=70&&senderName.length()<105){
                    str650.append(baseMessage.printFormatDefine("SENDER NAME", senderName.substring(0,35)));
                    str650.append(printFormat("", senderName.substring(35,70)));
                    str650.append(printFormat("", senderName.substring(70)));
                }else if (senderName.length()>=105){
                    str650.append(baseMessage.printFormatDefine("SENDER NAME", senderName.substring(0,35)));
                    str650.append(printFormat("", senderName.substring(35,70)));
                    str650.append(printFormat("", senderName.substring(70,105)));
                    str650.append(printFormat("", senderName.substring(105)));
                }
            }
            str650.append(baseMessage.printFormatDefine("RECEIVER", receive));
            //第十一行~第十四行
            if (JudgeUtils.isNull(receiveName)){
                str650.append(baseMessage.printFormatDefine("RECEIVER NAME", ""));
            }else {
                if (receiveName.length()<35){
                    str650.append(baseMessage.printFormatDefine("RECEIVER NAME", receiveName));
                }else if(receiveName.length()>=35&&receiveName.length()<70){
                    str650.append(baseMessage.printFormatDefine("RECEIVER NAME", receiveName.substring(0,35)));
                    str650.append(printFormat("", receiveName.substring(35)));
                }else if(receiveName.length()>=70&&receiveName.length()<105){
                    str650.append(baseMessage.printFormatDefine("RECEIVER NAME", receiveName.substring(0,35)));
                    str650.append(printFormat("", receiveName.substring(35,70)));
                    str650.append(printFormat("", receiveName.substring(70)));
                }else if(receiveName.length()>=105){
                    str650.append(baseMessage.printFormatDefine("RECEIVER NAME", receiveName.substring(0,35)));
                    str650.append(printFormat("", receiveName.substring(35,70)));
                    str650.append(printFormat("", receiveName.substring(70,105)));
                    str650.append(printFormat("", receiveName.substring(105)));
                }
            }
            //第十五行
            str650.append(baseMessage.printFormatDefine("MT TYPE/PAYMENT CODE", txCode));
            //第十六行 报文头部 2 的所有资料  如果为收入报文则显示本行
            if (JudgeUtils.isNotNull(swiftKey)){
                if ("0".equals(swiftKey.substring(11,12))||"2".equals(swiftKey.substring(11,12))){
                    str650.append(printDefine(appHeaderMessage.substring(4)));
                }
            }
            //第十七行 111域没有则显示000
            if (JudgeUtils.isNotNull(ohGpcFlg)){
                str650.append(baseMessage.printFormatDefine("111:SERVICE TYPE ID",ohGpcFlg));
            }
            //第十八行 121
            if (JudgeUtils.isNotNull(ohGpiRef)){
                str650.append(baseMessage.printFormatDefine("121:UETR",ohGpiRef));
            }else {
                str650.append(baseMessage.printFormatDefine("121:UETR",""));
            }
            logger.info("##### PRINT MT MESSAGE HEADER SUCCESS #####");
            // 如果报文类型不存在
            String mtName = "MT" + txCode;
            if (!describe.containsKey(mtName)) {
                return str650.toString();
            }

            /*================tag域组装=================*/
            str650.append("----------MESSAGE TEXT----------\r\n");

            //获取4域的tag域所有信息，并组好分类
            String substring = message.substring(message.indexOf("{4:") + 3);
            String messageBody = substring.substring(0,substring.indexOf("-}"));
            ArrayList<Map.Entry<String, String>> tagList = parserDataToKeyList(messageBody);

            //做好分类的tag信息挨个做电码转中文处理
            for (int i = 0; i < tagList.size(); i++) {
                String k = tagList.get(i).getKey();
                //202COV特殊处理
//                if (describe.containsKey(mtName) && mtName.equals("MT202") && (k.equals("50A") || k.equals("50F") || k.equals("50K"))) {
//                    break;
//                }
                // TODO: 2021/8/12 n92特殊处理 只打印可选的79或者打印必选  又或者两者都打印
//                if (describe.containsKey(mtName) && mtName.equals("MT192")) {
//                    String lastK = tagList.get(i-1).getKey();
//                    if (lastK.equals("11S") || lastK.equals("79")) {
//                        break;
//                    }
//                }
                String value = tagList.get(i).getValue();
                //报文不存在的tag域 不打印tag描述，其他要求打印
                if (!tagDescriptionMap.containsKey(":"+k+":")) {
                    String[] noDescValue = value.split("(\\r\\n)|(\\n)");
                    if(noDescValue.length>1){
                        str650.append(":").append(k).append(":");
                        for (int i1 = 0; i1 < noDescValue.length; i1++) {
                            str650.append(noDescValue[i1]).append("\r\n");
                        }
                    }else {
                        str650.append(":").append(k).append(":").append("\r\n").append(noDescValue[0]).append("\r\n");
                    }

                    continue;
                }
                //拼接tag名字+tag描述+tagValue
                for (Map.Entry<String, String> entry : tagDescriptionMap.entrySet()) {
                    //拼接
                    if (entry.getKey().substring(1,entry.getKey().length()-1).equals(k)) {
                        String[] valueTemp = value.split("(\\r\\n)|(\\n)");
                        if(valueTemp.length>1){
                            str650.append(entry.getKey()).append(entry.getValue()).append("\r\n");
                            for (int i1 = 0; i1 < valueTemp.length; i1++) {
                                str650.append(valueTemp[i1]).append("\r\n");
                            }
                        }else {
                            str650.append(entry.getKey()).append(entry.getValue()).append("\r\n").append(valueTemp[0]).append("\r\n");
                        }
                    }
                }
            }

            str650.append("----------END OF MESSAGE TEXT----------");
            logger.info("##### END TO 23650,PRINT MT MESSAGE #####");
            return str650.toString();
        }
    }

    /**
     * 单独提供给汇入 电码转中文的650
     * @return
     */
    public static String newMessageTo650(String printMessage,String message,String txCode,
                                         Map<String,String> tagDescriptionMap){
        logger.info("##### START TO PRINT MT MESSAGE(23650) FOR TELE TO CHINESS #####");
        //拆出头部以上的内容
        String[] split = printMessage.split("----------MESSAGE TEXT----------");
        StringBuilder str650 = new StringBuilder();
        str650.append(split[0]);

        // 如果报文类型不存在  只打印头部信息返回去
        String mtName = "MT" + txCode;
        if (!describe.containsKey(mtName)) {
            return str650.toString();
        }
        /*================tag域组装=================*/
        str650.append("----------MESSAGE TEXT----------\r\n");

        //获取4域的tag域所有信息，并组好分类
        String substring = message.substring(message.indexOf("{4:") + 3);
        String messageBody = substring.substring(0,substring.indexOf("-}"));
        ArrayList<Map.Entry<String, String>> tagList = parserDataToKeyList(messageBody);

        //做好分类的tag信息挨个做电码转中文处理
        for (int i = 0; i < tagList.size(); i++) {
            String k = tagList.get(i).getKey();
            //202COV特殊处理
//            if (describe.containsKey(mtName) && mtName.equals("MT202") && (k.equals("50A") || k.equals("50F") || k.equals("50K"))) {
//                break;
//            }
            // TODO: 2021/8/11 n92特殊处理 只打印可选的79或者打印必选  又或者两者都打印
//                if (describe.containsKey(mtName) && mtName.equals("MT192")) {
//                    String lastK = tagList.get(i).getKey();
//                    if (lastK.equals("79")) {
//                        break;
//                    }
//                }
            String value = tagList.get(i).getValue();
            //RMC派送的电文以\n换行 RPS自己做的报文是以\r\n换行 两者需都匹配
            String[] spValue = value.split("(\\r\\n)|(\\n)");
            HashSet<String> tagSet = getTagSet();
            if (tagSet.contains(k)) {
                logger.info("##### THE FIELD NEED TO CHINESE:{}",k);
                String v = "";
                //遍历域信息，转换
                for (int j = 0; j < spValue.length; j++) {
                    //72域特别判断 处理
                    if ("72".equals(k)){
                        logger.info("##### BEFORE TELE CONTENT:{}",spValue[j]);
                        String chinese = PgstpswfUtil.teleToChinese(spValue[j],k);
                        logger.info("##### AFTER CHINESE CONTENT:{}",chinese);
                        Object o = CopyTagUtils.threadLocal.get();
                        if (o == null) {
                            spValue[j] = chinese;
                        }
                        v += spValue[j]+"\r\n";
                    }else if (spValue[j].startsWith("/")){
                        v += spValue[j]+"\r\n";
                        continue;
                    }else {
                        logger.info("##### BEFORE TELE CONTENT:{}",spValue[j]);
                        String chinese = PgstpswfUtil.teleToChinese(spValue[j],k);
                        logger.info("##### AFTER CHINESE CONTENT:{}",chinese);
                        Object o = CopyTagUtils.threadLocal.get();
                        if (o == null) {
                            spValue[j] = chinese;
                        }
                        v += spValue[j]+"\r\n";
                    }
                }
                value = v;
            }
            //报文不存在的tag域 不打印tag描述，其他要求打印
            if (!tagDescriptionMap.containsKey(":"+k+":")) {
                String[] noDescValue = value.split("(\\r\\n)|(\\n)");
                if(noDescValue.length>1){
                    str650.append(":").append(k).append(":");
                    for (int i1 = 0; i1 < noDescValue.length; i1++) {
                        str650.append(noDescValue[i1]).append("\r\n");
                    }
                }else {
                    str650.append(":").append(k).append(":").append("\r\n").append(noDescValue[0]).append("\r\n");
                }

                continue;
            }
            //拼接tag名字+tag描述+tagValue
            for (Map.Entry<String, String> entry : tagDescriptionMap.entrySet()) {
                //拼接
                if (entry.getKey().substring(1,entry.getKey().length()-1).equals(k)) {
                    String[] valueTemp = value.split("(\\r\\n)|(\\n)");
                    if(valueTemp.length>1){
                        str650.append(entry.getKey()).append(entry.getValue()).append("\r\n");
                        for (int i1 = 0; i1 < valueTemp.length; i1++) {
                            str650.append(valueTemp[i1]).append("\r\n");
                        }
                    }else {
                        str650.append(entry.getKey()).append(entry.getValue()).append("\r\n").append(valueTemp[0]).append("\r\n");
                    }
                }
            }
        }

        str650.append("----------END OF MESSAGE TEXT----------");
        logger.info("##### END TO PRINT MT MESSAGE(23650) FOR TELE TO CHINESS #####");
        return str650.toString();
    }

    public static ArrayList<Map.Entry<String, String>> parserDataToKeyList(String messageStr) {
        ArrayList<Map.Entry<String, String>> keyList = new ArrayList();
        //处理field 20前面的换行符以及冒号  例如\r\n:或者\n:
        logger.info("##### START TO MESSAGE CONTENT PROCESSING #####");
        int length = messageStr.length();
        if (length>3){
            if ("\r\n".equals(messageStr.substring(0,2))){
                messageStr = messageStr.substring(3);
            }else {
                messageStr = messageStr.substring(2);
            }
        }
        String[] dataArrary = messageStr.split("\\:",-1);
        //数据清洗
        String[] dataArrary2 = new String[dataArrary.length];
        Boolean flag = false;
        int flagNum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dataArrary.length; i++) {
            String data= dataArrary[i];
            if ("79".equals(data)){
                dataArrary2[i] = data;
                flagNum = i+1;
                flag = true;
                continue;
            }
            if (flag){
                if ("71F".equals(data)){
                    data = ":"+data+":";
                }
                sb.append(data);
            }else {
                dataArrary2[i] = dataArrary[i];
            }
        }
        Integer arrNum = 0;
        if (flagNum !=0){
            dataArrary2[flagNum] = sb.toString();
            arrNum = flagNum+1;
        }else {
            arrNum = dataArrary2.length;
        }
        String[] dataArrary3 = new String[arrNum];
        for (int i = 0; i <dataArrary3.length; i++) {
            dataArrary3[i] = dataArrary2[i];
        }
        String tagValue = "";
        String firstTagKey = "";
        String secondTagKey = "";
        String[] var7 = dataArrary3;
        int var8 = dataArrary3.length;
        for (int var9 = 0; var9 < var8; ++var9) {
            String data = var7[var9];
            String tmpTagKey = StringUtils.trim(data);
            if (StringUtils.isNoneBlank(new CharSequence[]{secondTagKey})) {
                Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(firstTagKey, tagValue);
                keyList.add(tag);
                firstTagKey = secondTagKey;
                tagValue = data;
                secondTagKey = "";
            } else if (tmpTagKey.length() != 0) {
                if ((tmpTagKey.length() == 3 || tmpTagKey.length() == 2) && isNumeric(tmpTagKey)) {
                    if (StringUtils.isEmpty(firstTagKey)) {
                        firstTagKey = tmpTagKey;
                    } else {
                        secondTagKey = tmpTagKey;
                    }
                } else if (StringUtils.isNoneBlank(new CharSequence[]{tagValue})) {
                    tagValue = tagValue + ":" + data;
                } else {
                    tagValue = data;
                }
            }else {
                //如果为空串 需要补回:
                tagValue = tagValue + ":" + data;
            }
        }

        if (StringUtils.isNoneBlank(new CharSequence[]{firstTagKey, tagValue})) {
            Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(firstTagKey, tagValue);
            keyList.add(tag);
        }
        logger.info("##### END TO MESSAGE CONTENT PROCESSING #####");
        return keyList;
    }

    /**
     * 报文头部信息打印格式定义
     */
    public static String printDefine(String keyName) {
        StringBuilder message = new StringBuilder();
        byte[] nameBytes = keyName.getBytes();
        //定义内容长度
        int blankSpaces = 25;
        message.append(keyName);
        return message.toString();
    }

    public static String printFormat(String keyName, String param) {
        StringBuilder message = new StringBuilder();
        //定义内容长度
        int blankSpaces = 25;
        message.append(keyName);
        //拼接空格
        for (int i = 0; i < blankSpaces - keyName.length(); i++) {
            message.append(" ");
        }
        message.append("     " + param + MTConstants.MT_MESSAGE_LINE_MARK);
        return message.toString();
    }

    /**
     * 判断是否包含数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile(".*[0-9].*");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) {
//        String str = "\\n:20:OG888000900110SE\\n:21:5221053126900076\\n:79://1903041515+0800\\n//ACSP/G002\\n//BKCHHKHHXXX\\n//USD1000,/OUR\\n//EXCH//USD/EUR/1,09\\n//:71F:USD20,\\n//:71F:USD20,//:71F:USD20,//:71F:USD20,\n";
//        String str = "\\n:20:OG888000900110SE\\n:21:5221053126900076\\n";
        String str2 = "\n:20:OR:RR\r\n:21:20\r\n:32A:200703HKD100,00\r\n:56A:/05212020005052\r\nHKICHKHHXXX\r\n:57A:/05212020005052\r\nHKICHKHHXXX\r\n:58A:HKICHKHHXXX\r\n:72:/ACC/CHEN ZI HAO\r\n//NIHAO HAHA\r\n//SHENZHEN:KKA\r\n//SHENZHEN:KK\r\n:50A:/05212020005052\r\nCMACMOMXXXX\r\n:59A:/05212020005052\r\nPNBPHKHHXXX\r\n:72:/ACC/CHEN ZI:::HAO\r\n//NIHAO HAHA:::\r\n//SHENZHEN:KKA\r\n//SHENZHEN:F50L::::\r\n:33B:HKD650,00\r\n";
        ArrayList<Map.Entry<String, String>> keyList = parserDataToKeyList(str2);
        System.out.println(keyList);
        for (Map.Entry<String, String> stringStringEntry : keyList) {
            System.out.println(stringStringEntry);
        }

//        String numStr = "32B";
//        if (isNumeric(numStr)){
//            System.out.println("含有数字:"+numStr);
//        }else {
//            System.out.println("没有数字:"+numStr);
//        }



    }
}
