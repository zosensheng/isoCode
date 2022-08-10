//package com.hisun.kont.teleCH;
//
//import com.hisun.kont.Application;
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.common.exception.KontException;
//import com.hisun.kont.common.utils.KontJsonUtil;
//import com.hisun.kont.framework.redis.server.RedisClient;
//import com.hisun.kont.pg.constants.RpsRedisKeyConstants;
//import com.hisun.kont.pg.dao.SintoteleDao;
//import com.hisun.kont.pg.entity.SintoteleDO;
//import com.hisun.kont.pg.service.impl.PgstpswftoteleServiceImpl;
//import com.hisun.kont.swf.mt.message.MT103;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author: jcL
// * @create: 2021/7/17 9:25
// */
//public class MTChToTele extends ApplicationTest{
//
//    private static RedisClient redisClient;
//
//    @Autowired
//    public void setRedisClient(RedisClient redisClient) {
//        MTChToTele.redisClient = redisClient;
//    }
//
//    private static SintoteleDao sintoteleDao;
//
//    @Autowired
//    public void setSintoteleDao(SintoteleDao sintoteleDao) {
//        MTChToTele.sintoteleDao = sintoteleDao;
//    }
//
//    @Test
//    public void test() throws Exception {
////        String msg = "鵴3331 33312, 橳,彙)(5131 ,0418 哏0694) &*(12 *(&*^ haha";
//        String msg = " 杆(杈aa杆杈";
//        String tele = getTagChToTele(msg);
//        System.out.println("tele:"+tele);
//    }
//    /**
//     * 中文转电码(用于组装)
//     *
//     * @param mt103Json
//     * @return
//     * @throws Exception
//     */
//    public static String getTagChToTele(String mt103Json) throws Exception {
//        StringBuilder stringBuilder = new StringBuilder();
//        //分组
//        mt103Json = new String(mt103Json.getBytes(), "UTF-8");
//        char c;
//        for (int i = 0; i < mt103Json.length(); i++) {
//            c = mt103Json.charAt(i);
//            int byteLength = String.valueOf(c).getBytes().length;
//            if (byteLength > 1) {
//                String chinese = cnToUnicode(String.valueOf(c));
//                String cn = chinese.substring(2, 2 + 4);
//                //redis取值
//                List<SintoteleDO> sintoteleDOS = getTeleToDB(cn);
//                if (sintoteleDOS.size() > 1 || sintoteleDOS.size() < 1) {
//                    throw new Exception("含有多个或没有电码,无法转换");
//                }
//                if (i!=mt103Json.length()-1){
//                    if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
//                        stringBuilder.append(sintoteleDOS.get(0).getPgTeleNum() + " ");
//                    } else {
//                        stringBuilder.append(sintoteleDOS.get(0).getPgTeleNum());
//                    }
//                }else {
//                    stringBuilder.append(sintoteleDOS.get(0).getPgTeleNum());
//                }
//            } else {
//                stringBuilder.append(c);
//            }
//        }
//        return stringBuilder.toString();
//    }
//
//    /**
//     * redis取值
//     *
//     * @param cn
//     * @return
//     */
//    public static List<SintoteleDO> getTeleToRedis(String cn) {
//        try {
//            List<SintoteleDO> sintoteleDOS = new ArrayList<>();
//            SintoteleDO sintoteleDO = new SintoteleDO();
//            Object teleStr = redisClient.get(RpsRedisKeyConstants.MT_CN_TO_TELE_SIM + cn);
//            List<SintoteleDO> SintoteleList = KontJsonUtil.toList(teleStr, SintoteleDO.class);
//            for (int i = 0; i < SintoteleList.size(); i++) {
//                sintoteleDO.setPgTeleNum(SintoteleList.get(i).getPgTeleNum());
//                sintoteleDOS.add(sintoteleDO);
//            }
//            System.out.println(teleStr.toString());
//            return sintoteleDOS;
//        } catch (Exception e) {
//            KontException.throwKontException();
//        }
//        return null;
//    }
//
//    /**
//     * 中文转unicode,unicode去数据库匹配对应电码
//     *
//     * @param cn
//     * @return
//     */
//    private static String cnToUnicode(String cn) {
//        char[] chars = cn.toCharArray();
//        String returnStr = "";
//        for (int i = 0; i < chars.length; i++) {
//            returnStr += "\\u" + Integer.toString(chars[i], 16);
//        }
//        String upperCase = returnStr.toUpperCase();
//        return upperCase;
//    }
//
//    /**
//     * 数据库取值
//     * @param cn
//     * @return
//     */
//    private static List<SintoteleDO> getTeleToDB(String cn) {
//        SintoteleDO sintoteleDO = new SintoteleDO();
//        sintoteleDO.setPgUnicodeS(cn);
//        List<SintoteleDO> sintoteleDOS = sintoteleDao.findList(sintoteleDO);
//        return sintoteleDOS;
//    }
//}
