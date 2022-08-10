//package com.hisun.kont.MT;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.common.exception.KontException;
//import com.hisun.kont.common.utils.StringUtils;
//import com.hisun.kont.pg.utils.*;
//import com.hisun.kont.swf.mt.message.MT103;
//import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
//import com.hisun.kont.swf.mt.message.subItem.MessageEnvelope;
//import com.hisun.kont.swf.mt.message.subItem.TreeTag;
//import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
//import org.junit.Test;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import javax.annotation.Resource;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
///**
// * @author: jcL
// * @create: 2021/7/8 19:28
// */
//public class CnToTeleMT650 extends ApplicationTest {
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//
//    private HashSet<String> tagSet = new HashSet<String>(){{
//        add("50K");
//        add("50F");
//        add("52D");
//        add("53B");
//        add("53D");
//        add("54B");
//        add("54D");
//        add("55B");
//        add("55D");
//        add("56C");
//        add("56D");
//        add("57B");
//        add("57D");
//        add("59");
//        add("70");
//        add("72");
//    }};
//
//    @Test
//    public void four() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//
//        String className = "MT103";
//        Class<?> aClass = Class.forName("com.hisun.kont.swf.mt.message.MT103");
//        MT103 o =(MT103) aClass.newInstance();
//        o.getMtDescription();
//
//    }
//
//    public HashSet<String> getTagSet() {
//        return tagSet;
//    }
//    @Test
//    public void two(){
//        String msg = "STATUS                   :    AK\n" +
//                "SWIFT KEY                :    052202107099002847\n" +
//                "MT103                    :    SINGLE CUSTOMER CREDIT TRANSFER\n" +
//                "RECEIVE DATE             :    2021/07/09\n" +
//                "SENDER                   :    BKOJOUMNA30\n" +
//                "SENDER NAME              :    SZDBCNBS\n" +
//                "RECEIVE                  :    PONCHKH0XXX\n" +
//                "RECEIVE NAME             :    BANK OF CHINA\n" +
//                "MT TYPE/PAYMENT CODE     :    103\n" +
//                "----------MESSAGE TEXT----------\n" +
//                ":20:Send Bank's Number\n" +
//                "353ALT17081910\n" +
//                ":13C:Time Indication\n" +
//                "/CLSTIME/1201+0620\n" +
//                ":23B:Bank Operation Code\n" +
//                "CRED\n" +
//                ":23E:Instruction Code\n" +
//                "PHOB/this is attachInfo\n" +
//                ":26T:Transaction Type Code\n" +
//                "ABC\n" +
//                ":32A:Value Date/Currency/Interbank Settled Amount\n" +
//                "200731HKD850,00\n" +
//                ":33B:Currency/Instructed Amount\n" +
//                "HKD1000,00\n" +
//                ":36:Exchange Rate\n" +
//                "7,7552\n" +
//                ":50A:Ordering Customer\n" +
//                "/LINZHONG\n" +
//                "CMACMOMXXXX\n" +
//                ":51A:Sending Institution\n" +
//                "/D/linzhong\n" +
//                "CMACMOMXXXX\n" +
//                ":52D:Ordering Institution\n" +
//                "/E/linzhong\n" +
//                "(0418 0483, 0694)\n" +
//                "shanghai (0418 0483, 0694\n" +
//                ":53D:Sender's Correspondent\n" +
//                "/E/linzhong\n" +
//                "0418 0483\n" +
//                "(0418) (0418 0418)\n" +
//                ":54B:Receiver's Correspondent\n" +
//                "/E/linzhong\n" +
//                "tianjin\n" +
//                ":55D:Third Reimbursement Institution\n" +
//                "/A/zmm\n" +
//                "beijing\n" +
//                ":56D:Intermediary Institution\n" +
//                "/B/LINZHONG\n" +
//                "DSBAHKH0XXX\n" +
//                ":57D:Account With Institution\n" +
//                "/A/zmm\n" +
//                "beijing\n" +
//                ":59A:Beneficiary Customer\n" +
//                "/linzhong\n" +
//                "CMACMOMXXXX\n" +
//                ":70:Remittance Information\n" +
//                "TEST CHATS FOR OR 103\n" +
//                ":71A:Details of Charges\n" +
//                "SHA\n" +
//                ":71F:Sender's Charges\n" +
//                "HKD1000,00\n" +
//                ":71G:Receiver's Charges\n" +
//                "HKD1000,00\n" +
//                ":72:Sender to Receiver Information\n" +
//                "//SPRO/01/DEPN/06\n" +
//                ":77B:Regulatory Reporting\n" +
//                "/SPRO/ab/DEPN 06\n" +
//                "SPROab/DEPN 06\n" +
//                "----------END OF MESSAGE TEXT----------";
////        String teleToChMethod = TeleCh650Util.teleToChMethod(msg);
////        System.out.println(teleToChMethod);
//        String str192 = "{1:F01DSBAHKH0AXXX0000000000}{2:O1921226190529BKCHBNBBAXXX76422043131905291929N}{3:{108:2020083100000066}}{4:\n" +
//                ":20:ON392000900262CA\n" +
//                ":21:OR392000900826\n" +
//                ":11S:103 200831\n" +
//                ":79:OR392000900826 HKD1.00 WE REGRET TO INFORM THAT WE HAVE STILL NOT RECEIVED THE COVER FUND OF THE ABOVE PAYMENT AS OF TODAY, PLEASE REMIT YOUR FUND WITHIN 3 DAYS ELSE WE WOULD DEEM YOUR PAYMENT INSTRUCTION AS CANCELLED AND CLOSE OUR FILE. REGARDS REMITTANCES AND SETTLEMENT DEPARTMENT\n" +
//                ":20:OR392000900826\n" +
//                ":23B:CRED\n" +
//                ":32A:200831HKD1,00\n" +
//                ":50K:/73931500258 RXXXX CXXXX SXX WX XXXXX KXXX ADD. TYPE 2-1:O GXXXX LXXXXX ZXXXXX TYPE 2-2:\n" +
//                ":59:/1324435465 ASS HONG KONG\n" +
//                "-}";
//    }
//    @Test
//    public void test3() {
//        String msg = "{1:F01BKOJOUMNAHUK0000000000}{2:I202PONCHKH0XXXXN}{3:{103:null}{108:353ALT17081910}{199:COV}}{4:\n" +
//                ":20:353ALT17081910\n" +
//                ":21:0123456789123456\n" +
//                ":13C:/CLSTIME/1201+0620\n" +
//                ":32A:200702HKD68,\n" +
//                ":52D:/E/linzhong\n" +
//                "beijing\n" +
//                "shanghai\n" +
//                ":53D:/E/linzhong\n" +
//                "beijing\n" +
//                "shanghai\n" +
//                ":54A:/B/LINZHONG\n" +
//                "DSBAHKH0XXX\n" +
//                ":56D:/B/LINZHONG\n" +
//                "DSBAHKH0XXX\n" +
//                ":57D:/A/zmm\n" +
//                "beijing\n" +
//                "shanghai\n" +
//                ":58D:/X/linzhong\n" +
//                "this is address1\n" +
//                "this is address2\n" +
//                "this is address3\n" +
//                "this is address4\n" +
//                ":72:/SPRO/01/DEPN/06\n" +
//                ":50A://LINZHONB\n" +
//                "CMACMOMXXXB\n" +
//                ":52D:/E/linzhongB\n" +
//                "beijing2B\n" +
//                "shanghai2B\n" +
//                ":56D:/B/BBBBBB\n" +
//                "DSBAHKH0XXX\n" +
//                ":57D:bbbbbbb\n" +
//                "bbbbbbbb\n" +
//                ":59A:/linzhong\n" +
//                "CMACMOMXXXB\n" +
//                ":70:TEST CHATS FOR OR 103\n" +
//                ":72://SPRO/01/DEPN/09\n" +
//                "-}";
//        String key = "pg:650:202:"+"*";
//        Set<String> keys = stringRedisTemplate.keys(key);
//        Map<String, String> map = new HashMap<>();
//        for (String s : keys) {
//            String value = stringRedisTemplate.opsForValue().get(s);
//            String tagKey = s.substring(10, 15);
//            if (s.contains(" ")){
//                tagKey = s.substring(10,14);
//            }
//            map.put(tagKey,value);
//        }
//        String status = "";
//        String message = TeleCh650Util.messageTo650(msg,"1","202","1","1","1","1",map,status);
//        System.out.println(message);
//    }
//
//    @Test
//    public void theTest(){
//        int[] arr = new int[20];
//        arr[0] = 1;
//        arr[1] = 1;
//        for (int i = 2; i < arr.length; i++) {
//            arr[i] = arr[i-1] + arr[i-2];
//        }
//        System.out.println(arr[arr.length - 1]+"个");
//    }
//
//
//    //    @Resource
////    private PgstpswfUtil pgstpswfUtil;
//    @Test
//    public void test() throws InstantiationException, IllegalAccessException {
//        String s = "beijing (0418 0483, 0694)";
//        String str = "(0418) (0418 0418)";
//        String sss = "0418";
////        String s1 = PgstpswfUtil.selectStptswfBySwfTele(sss);
//        String msg = "STATUS                   :    AK\n" +
//                "SWIFT KEY                :    052202106299002304\n" +
//                "MT103                    :    SINGLE CUSTOMER CREDIT TRANSFER\n" +
//                "RECEIVE DATE             :    2021/07/19\n" +
//                "SENDER                   :    BKOJOUMNA30\n" +
//                "SENDER NAME              :    SZDBCNBS\n" +
//                "RECEIVE                  :    PONCHKH0XXX\n" +
//                "RECEIVE NAME             :    BANK OF CHINA (HONG KONG) LTD\n" +
//                "MT TYPE/PAYMENT CODE     :    103\n" +
//                "----------MESSAGE TEXT----------\n" +
//                ":20:Send Bank's Number\n" +
//                "353ALT17081910\n" +
//                ":13C:Time Indication\n" +
//                "/CLSTIME/1201+0620\n" +
//                ":23B:Bank Operation Code\n" +
//                "CRED\n" +
//                ":23E:Instruction Code\n" +
//                "PHOB/this is attachInfo\n" +
//                ":26T:Transaction Type Code\n" +
//                "ABC\n" +
//                ":32A:Value Date/Currency/Interbank Settled Amount\n" +
//                "200731HKD850,00\n" +
//                ":33B:Currency/Instructed Amount\n" +
//                "HKD1000,00\n" +
//                ":36:Exchange Rate\n" +
//                "7,7552\n" +
//                ":50A:Ordering Customer\n" +
//                "/LINZHONG\r\n" +
//                "CMACMOMXXXX\n" +
//                ":51A:Sending Institution\n" +
//                "/D/linzhong\r\n" +
//                "CMACMOMXXXX\n" +
//                ":52D:Ordering Institution\n" +
//                "/E/linzhong\r\n" +
//                "beijing\r\n" +
//                "shanghai\n" +
//                ":53D:Sender's Correspondent\n" +
//                "/E/linzhong\n" +
//                "beijing\n" +
//                "shanghai\n" +
//                ":54B:Receiver's Correspondent\n" +
//                "/E/linzhong\n" +
//                "tianjin\n" +
//                ":55D:Third Reimbursement Institution\n" +
//                "/A/zmm\n" +
//                "beijing\n" +
//                ":56D:Intermediary Institution\n" +
//                "/B/LINZHONG\n" +
//                "DSBAHKH0XXX\n" +
//                ":57D:Account With Institution\n" +
//                "/A/zmm\n" +
//                "beijing\n" +
//                ":59A:Beneficiary Customer\n" +
//                "/linzhong\n" +
//                "CMACMOMXXXX\n" +
//                ":70:Remittance Information\n" +
//                "TEST CHATS FOR OR 103\n" +
//                ":71A:Details of Charges\n" +
//                "SHA\n" +
//                ":71F:Sender's Charges\n" +
//                "HKD1000,00\n" +
//                ":71G:Receiver's Charges\n" +
//                "HKD1000,00\n" +
//                ":72:Sender to Receiver Information\n" +
//                "//SPRO/01/DEPN/06\n" +
//                ":77B:Regulatory Reporting\n" +
//                "/SPRO/ab/DEPN 06\n" +
//                "SPROab/DEPN 06\n" +
//                "----------END OF MESSAGE TEXT----------";
//        //先存分开存进map中，用parser拆解每个tag，把需要转换的map拿出来处理
//        String regex = "^:[0-9a-zA-Z]{2,3}:";
//        StringBuilder sb = new StringBuilder();
//        BaseMessage baseMessage = new BaseMessage();
//        String start = "----------MESSAGE TEXT----------";
//        String end = "----------END OF MESSAGE TEXT----------";
//        //获取这些域属于哪个报文
//        String[] header = msg.split(start);
//        String[] sp = header[0].split("\n");
//        for (int i = 0; i < sp.length; i++) {
//            if (sp[i].contains("MT TYPE/PAYMENT CODE") && sp[i].contains("103")) {
//                baseMessage.setTxCode("103");
//            }
//        }
//        String[] bodyAndTail = header[1].split(end);
//        //拿到了域的数据
//        String bodyStr = bodyAndTail[0];
//        //获取域和描述信息，不做改动，用于后续拼接
//        String[] bodyTagMsg = bodyStr.split("\n");
//        List<String> tagMsgList = new ArrayList<>();
//        for (int i = 0; i < bodyTagMsg.length; i++) {
//            Pattern p = Pattern.compile(regex);
//            Matcher matcher = p.matcher(bodyTagMsg[i]);
//            if (matcher.find()) {
//                tagMsgList.add(bodyTagMsg[i] + "\n");
//            }
//        }
//
//        // 进行分类
//        //keyList里面有域的描述信息，需要取出
//        ArrayList<Map.Entry<String, String>> keyList = parserDataToKeyList(bodyStr);
//
//        //tagList是已经处理完的list了，只需要进行拆解
//        ArrayList<Map.Entry<String, String>> tagList = new ArrayList<>();
//        String tagValue = "";
//        String key = "";
//        for (int i = 0; i < keyList.size(); i++) {
//            //域信息做转换处理
//            key = keyList.get(i).getKey();
//            tagValue = keyList.get(i).getValue().substring(keyList.get(i).getValue().indexOf("\n") + 1);
//            Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(key, tagValue);
//            tagList.add(tag);
//        }
//         //做转换处理的域信息
//        for (int i = 0; i < tagList.size(); i++) {
//            String k = tagList.get(i).getKey();
//            String value = tagList.get(i).getValue();
//            String[] spValue = value.split("\n");
//            HashSet<String> tagSet = getTagSet();
//            if (tagSet.contains(k)) {
//                String v = "";
//                //遍历域信息，转换
//                for (int j = 0; j < spValue.length; j++) {
//                    if (spValue[j].startsWith("/")) {
//                        v += spValue[j]+"\n";
//                        continue;
//                    }else {
//                        String chinese = PgstpswfUtil.teleToChinese(spValue[j],new String());
//                        spValue[j] = chinese;
//                        v += spValue[j]+"\n";
//                    }
//                }
//                value = v;
//            }
//            //转换完后更新tagList，此时tagList是转换后的，用作拼接即可
//            Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(k, value);
//            tagList.set(i,tag);
//        }
//
//
//         //现在开始拼接字符串
//        //头部
//        sb.append(header[0] + start + "\n");
//        //报文体
//        List<String> msgList = tagMsgList.stream().distinct().collect(Collectors.toList());
//        for (int i = 0; i < msgList.size(); i++) {
//            String tagKey = msgList.get(i);
//            for (Map.Entry<String, String> entry : tagList) {
//                if (tagKey.contains(entry.getKey())) {
//                    sb.append(tagKey + entry.getValue());
//                }
//            }
//        }
//        //尾部
//        sb.append(end);
//        String bodyString = sb.toString();
//
////        String toChMethod = TeleCh650Util.teleToChMethod(msg);
////        System.out.println(toChMethod);
//
//
//        //盗版的拆解方法，把所有的域拆完了，此时baseMessage里已经有域的值了
////        parserBody(baseMessage, tagList);
//
//         //到这里就剩下判断哪些域具有电码且需要转中文的操作，然后拿出来挨个转换，最后拼接成原来的字符串
////        Map<String, Map> map = MTParseCodeConfig.getMap();
////        //取出tag
////        TreeMap<TreeTag, ArrayList<BaseTag>> tagTree = baseMessage.getMessageTagTree();
////        Set<TreeTag> treeTags = tagTree.keySet();
////        if (map.containsKey(mtType)) {
////            //遍历tag
////            for (TreeTag tag : treeTags) {
////                ArrayList<BaseTag> baseTags = messageTagTree.get(tag);
////                String tagName = baseTags.get(0).getName();
////                baseTags = CopyTagUtils.checkNeedParseForList(mtType,tagName,baseTags);
////                tagTree.put(tag,baseTags);
//////                System.out.println(baseTags);
////            }
////        }
////        String mtMessage = baseMessage.toBodyMTMessage();
////        String message = mtMessage;
////        System.out.println(message);
////        System.out.println(tagTree);
//    }
//
//    private String parserBody(BaseMessage baseMessage, ArrayList<Map.Entry<String, String>> keyList) {
//        Iterator tagTreeIter = baseMessage.messageTagTree.entrySet().iterator();
//        ArrayList<BaseTag> treeTagDataList = null;
//        Map.Entry indexTreeEntry = null;
//        Iterator var6 = keyList.iterator();
//
//        while (var6.hasNext()) {
//            Map.Entry entity = (Map.Entry) var6.next();
//            String tagKey = (String) entity.getKey();
//            String tagValue = (String) entity.getValue();
//            Class tagClass = null;
//            TreeTag currentTreeTag;
//            if (indexTreeEntry != null) {
//                currentTreeTag = (TreeTag) indexTreeEntry.getKey();
//                tagClass = currentTreeTag.getTagClass(tagKey);
//            }
//
//            if (tagClass == null) {
//                while (tagTreeIter.hasNext()) {
//                    indexTreeEntry = (Map.Entry) tagTreeIter.next();
//                    currentTreeTag = (TreeTag) indexTreeEntry.getKey();
//                    tagClass = currentTreeTag.getTagClass(tagKey);
//                    if (tagClass != null) {
//                        break;
//                    }
//
//                    currentTreeTag = null;
//                    tagClass = null;
//                    indexTreeEntry = null;
//                }
//            }
//
//            if (tagClass == null) {
//                KontException.throwBusinessException("MTP99999");
//            }
//
//            try {
//                currentTreeTag = (TreeTag) indexTreeEntry.getKey();
//                Boolean nullTagFlag = false;
//                if (StringUtils.isNoneBlank(new CharSequence[]{tagValue})) {
//                    String tmpTagValue = StringUtils.remove(tagValue, "\n");
//                    if (StringUtils.isNoneBlank(new CharSequence[]{tmpTagValue})) {
//                        tmpTagValue = StringUtils.remove(tmpTagValue, "\r");
//                    }
//
//                    if (StringUtils.isEmpty(tmpTagValue)) {
//                        nullTagFlag = true;
//                    }
//                } else {
//                    nullTagFlag = true;
//                }
//
//                BaseTag baseTag = (BaseTag) tagClass.newInstance();
//                baseTag.setName(tagKey);
//                baseTag.parser(tagValue);
//                treeTagDataList = (ArrayList) indexTreeEntry.getValue();
//                if (treeTagDataList == null || treeTagDataList.size() == 0) {
//                    treeTagDataList = new ArrayList();
//                }
//
//                treeTagDataList.add(baseTag);
//                indexTreeEntry.setValue(treeTagDataList);
//                tagKey = null;
//                tagValue = null;
//            } catch (Exception var14) {
//                var14.printStackTrace();
//                KontException.throwBusinessException("MTP99999");
//            }
//        }
//        return "";
//    }
//
//    private ArrayList<Map.Entry<String, String>> parserDataToKeyList(String messageStr) {
//        ArrayList<Map.Entry<String, String>> keyList = new ArrayList();
//        String[] dataArrary = messageStr.split("\\:");
//        String tagValue = "";
//        String firstTagKey = "";
//        String secondTagKey = "";
//        String[] var7 = dataArrary;
//        int var8 = dataArrary.length;
//
//        for (int var9 = 0; var9 < var8; ++var9) {
//            String data = var7[var9];
//            String tmpTagKey = StringUtils.trim(data);
//            if (StringUtils.isNoneBlank(new CharSequence[]{secondTagKey})) {
//                Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(firstTagKey, tagValue);
//                keyList.add(tag);
//                firstTagKey = secondTagKey;
//                tagValue = data;
//                secondTagKey = "";
//            } else if (tmpTagKey.length() != 0) {
//                if (tmpTagKey.length() == 3 || tmpTagKey.length() == 2) {
//                    if (StringUtils.isEmpty(firstTagKey)) {
//                        firstTagKey = tmpTagKey;
//                    } else {
//                        secondTagKey = tmpTagKey;
//                    }
//                } else if (StringUtils.isNoneBlank(new CharSequence[]{tagValue})) {
//                    tagValue = tagValue + ":" + data;
//                } else {
//                    tagValue = data;
//                }
//            }
//        }
//
//        if (StringUtils.isNoneBlank(new CharSequence[]{firstTagKey, tagValue})) {
//            Map.Entry<String, String> tag = new AbstractMap.SimpleEntry(firstTagKey, tagValue);
//            keyList.add(tag);
//        }
//
//        return keyList;
//    }
//
//}
