//package com.hisun.kont.teleCH;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.framework.redis.server.RedisClient;
//import com.hisun.kont.pg.constants.MTInStatusConstants;
//import com.hisun.kont.pg.constants.RpsRedisKeyConstants;
//import com.hisun.kont.pg.dao.PgstpswfDao;
//import com.hisun.kont.pg.entity.PgstpswfDO;
//import com.hisun.kont.pg.utils.CopyTagUtils;
//import com.hisun.kont.pg.utils.PgstpswfUtil;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 电码转中文测试类
// * @author: jcL
// * @create: 2021/7/16 17:38
// */
//public class MTTeleToCh extends ApplicationTest {
//
//    private static String REGEX = "^[0-9]{4}$";
//
//    private static PgstpswfDao pgstpswfDao;
//
//    private static RedisClient redisClient;
//
//    @Autowired
//    public void setRedisClient(RedisClient redisClient) {
//        MTTeleToCh.redisClient = redisClient;
//    }
//
//    @Autowired
//    public void setPgstpswfDao(PgstpswfDao pgstpswfDao) {
//        MTTeleToCh.pgstpswfDao = pgstpswfDao;
//    }
//
//
//    @Test
//    public void test(){
//        //2502 2494 B ===>星 2494 B
//        //                   鵴3331 33312, 橳,彙)(5131 ,0418 哏0694) &*(12 *(&*^ haha (正确)
//        String context = "3331 3331 33312, (4568, 5456) (5131 ,0418 0432 0694) &*(12 *(&*^ haha";
////        String tele = MTTeleToCh.teleToChinese(context);
//        String tele = PgstpswfUtil.teleToChinese(context,new String());
//        System.out.println("转换后："+tele);
//    }
//    public static String teleToChinese(String content) {
//        if (content == null || content.isEmpty()) {
//            return content;
//        } else {
//            if (!content.contains(" ")) {
//                return content;
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            String[] teleStrs = content.split(" ");
//            List<String> teleList = Arrays.asList(teleStrs);
//            for (int i = 0; i < teleStrs.length; i++) {
//                String nextTeleStr = teleStrs[i + 1 >= teleStrs.length ? i : i + 1];
//                //如果长度不符合直接跳过
//                boolean flag = teleIsConvert(teleStrs[i], i, nextTeleStr, teleStrs.length);
//                if (flag == false) {
//                    stringBuilder.append(teleStrs[i] + " ");
//                } else {
//                    //此时已确定是电码格式了，需要判断是否可以转成中文，然后拼接
//                    if (teleStrs[i].contains("(") && teleStrs[i].charAt(0) == '(') {
//                        teleStrs[i] = teleStrs[i].substring(1);
//                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
//                        stringBuilder.append("(" + chinese);
//                    } else if ((teleStrs[i].contains(")") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ')')
//                            || (teleStrs[i].contains(",") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ',')) {
//                        String subTeleStr = teleStrs[i].substring(0, teleStrs[i].length() - 1);
//                        String chinese = selectStptswfBySwfTele(subTeleStr);
//                        if (teleStrs[i].substring(4).equals(",")) {
//                            stringBuilder.append(chinese + ",");
//                        } else {
//                            stringBuilder.append(chinese + ")");
//                        }
//                    } else {
//                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
//                        stringBuilder.append(chinese);
//                    }
//                }
//            }
//            return stringBuilder.toString();
//        }
//    }
//
//    //转换规则判断
//    public static boolean teleIsConvert(String tele, int i, String nextTele, int totalLength) {
//        //如果是最后一个电码，不比较，直接判断能否转换中文
//        if (i == totalLength - 1) {
//            if (tele.length() >= 4 && tele.length() <= 6) {
//                tele = removeKuoHao(tele);
//                if (tele.matches(REGEX)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//            //遍历进行比较，如果后一个电码不符合规则为false，如果符合为true，nextTele是后一个char
//        } else {
//            //拆解时单行的判断逻辑
//            if (tele.length() >= 4 && tele.length() < 6) {
//                tele = removeKuoHao(tele);
//                if (tele.matches(REGEX)) {
//                    nextTele = removeKuoHao(nextTele);
//                    if (nextTele.matches(REGEX)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    //提取括号
//    public static String removeKuoHao(String teleStr) {
//        if (teleStr != null && teleStr.equals("")) {
//            return teleStr;
//        } else {
//            char startTeleStr = teleStr.charAt(0);
//            char endTeleStr = teleStr.charAt(teleStr.length() - 1);
//            if (startTeleStr == '(') {
//                teleStr = teleStr.substring(1);
//            }
//            if (endTeleStr == ')' || endTeleStr == ',') {
//                teleStr = teleStr.substring(0, teleStr.length() - 1);
//            }
//            return teleStr;
//        }
//    }
//
//    //电码转unicode码
//    public static String selectStptswfBySwfTele(String elecCode) {
//        PgstpswfDO pgstpswfDO = new PgstpswfDO();
//        pgstpswfDO.setPgTeleNum(elecCode);
//        List<PgstpswfDO> pgstpswfDOList = pgstpswfDao.findList(pgstpswfDO);
//        Object o = redisClient.get(RpsRedisKeyConstants.MT_TELE_TO_CN + elecCode);
//        //如果存在电码一对多的情况，给个状态码返回给py，目前的问题是如何搞一个状态码并传出去
//        if (pgstpswfDOList == null || pgstpswfDOList.size() >= 2) {
//            CopyTagUtils.threadLocal.set(MTInStatusConstants.MT_TELE_TO_CNS);
//            return elecCode;
//        }
//        String chinese = unicodeToCn(pgstpswfDOList.get(0).getPgChUniCode());
//        return chinese;
//    }
//
//    //unicode转中文
//    private static String unicodeToCn(String unicode) {
//        StringBuilder sbUniCode = new StringBuilder(unicode);
//        sbUniCode.insert(0, "\\u");
//        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
//        String[] strs = sbUniCode.toString().split("\\\\u");
//        String returnStr = "";
//        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
//        for (int i = 1; i < strs.length; i++) {
//            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
//        }
//        return returnStr;
//    }
//}
