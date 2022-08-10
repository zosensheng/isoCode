//package com.hisun.kont.MT;
//
//import com.alibaba.fastjson.JSONObject;
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.common.exception.KontException;
//import com.hisun.kont.common.utils.JudgeUtils;
//import com.hisun.kont.framework.redis.server.RedisClient;
//import com.hisun.kont.pg.constants.RpsRedisKeyConstants;
//import com.hisun.kont.pg.dao.PgstpswfDao;
//import com.hisun.kont.pg.dao.SintoteleDao;
//import com.hisun.kont.pg.dao.TratoteleDao;
//import com.hisun.kont.pg.entity.PgstpswfDO;
//import com.hisun.kont.pg.entity.SintoteleDO;
//import com.hisun.kont.pg.entity.TratoteleDO;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.*;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.*;
//
///**
// * @author: jcL
// * @create: 2021/7/5 17:08
// */
//public class TeleRedis extends ApplicationTest {
//
//    @Resource
//    RedisClient redisClient;
//
//    @Resource
//    SintoteleDao sintoteleDao;
//
//    @Resource
//    PgstpswfDao pgstpswfDao;
//
//    @Resource
//    TratoteleDao tratoteleDao;
//    @Resource
//    RedisTemplate redisTemplate;
//    @Resource
//    StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    public void saveTeleToRedis() {
//        List<String> keys = new ArrayList<String>();
//        List<SintoteleDO> sintoteleDOList = sintoteleDao.findAll();
//        for (SintoteleDO s : sintoteleDOList) {
//            String sinKey = RpsRedisKeyConstants.MT_CN_TO_TELE_SIM + s.getPgUnicodeS();
//            keys.add(sinKey);
//        }
//        System.out.println(keys.size());
//        SintoteleDO sintoteleDO = new SintoteleDO();
//        for (int i = 0; i < keys.size(); i++) {
//            sintoteleDO.setPgUnicodeS(sintoteleDOList.get(i).getPgUnicodeS());
//            List<SintoteleDO> sintoteleDOS = sintoteleDao.findList(sintoteleDO);
//            String str = JSONObject.toJSONString(sintoteleDOS);
////            String str = jsonObject.toString();
//            redisClient.set(keys.get(i), str);
//        }
//    }
//    @Test
//    public void swfTest(){
//        List<String> keys = new ArrayList<String>();
//        List<PgstpswfDO> pgstpswfDOList = pgstpswfDao.findAll();
//        for (PgstpswfDO pgstpswfDO : pgstpswfDOList) {
//            String key = RpsRedisKeyConstants.MT_TELE_TO_CN + pgstpswfDO.getPgTeleNum();
//            keys.add(key);
//        }
//        System.out.println(keys.size());
//        PgstpswfDO pgstpswfDO = new PgstpswfDO();
//        int count = 0;
//        for (int i = 0; i < keys.size(); i++) {
//            pgstpswfDO.setPgTeleNum(pgstpswfDOList.get(i).getPgTeleNum());
//            List<PgstpswfDO> list = pgstpswfDao.findList(pgstpswfDO);
//            if (list.size()>1) {
//                count++;
//            }
//            String value = list.toString();
//            redisClient.set(keys.get(i),value);
//        }
//        System.out.println("重复的中文的个数："+count);
//    }
//
//    public String readString2(String url) {
//        String str = "";
//        File file = new File(url);
//        try {
//            FileInputStream in = new FileInputStream(file);
//            // size 为字串的长度 ，这里一次性读完
//            int size = in.available();
//            byte[] buffer = new byte[size];
//            in.read(buffer);
//            in.close();
//            str = new String(buffer, "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str;
//    }
//    @Test
//    public void getTeleToCh() {
//        //电码转繁体
//        String totalStr = readString2("C:\\Users\\35850\\Desktop\\高阳科技\\电码\\CM3T2H");
//        String splitStr = totalStr.replaceAll("\0", "");
//
//        ArrayList<PgstpswfDO> pgstpswfDOList = new ArrayList<>();
//        for (int i = 0; i < splitStr.length(); i = i + 10) {
//            PgstpswfDO pgstpswfDO = new PgstpswfDO();
//            String src = splitStr.substring(i, i + 10);
//            String pgstpswfId = UUID.randomUUID().toString().substring(0, 20).replace("-", "");
//            pgstpswfDO.setPgswfId(pgstpswfId);
//            pgstpswfDO.setPgTeleNum(src.substring(2, 2 + 4));
//            pgstpswfDO.setPgChUniCode(src.substring(6, 6 + 4));
//            pgstpswfDO.setPgSimTra("1");
//            pgstpswfDOList.add(pgstpswfDO);
////            pgstpswfDao.insert(pgstpswfDO);
//        }
//        int count = 0;
//        System.out.println("pgList:"+pgstpswfDOList.size());
//        Map<String,List<String>> map = new HashMap<>();
//        for (int i = 0; i < pgstpswfDOList.size(); i++) {
//            PgstpswfDO pgstpswfDO = pgstpswfDOList.get(i);
//            String tele = pgstpswfDO.getPgTeleNum();
//            String ch = pgstpswfDO.getPgChUniCode();
//            List<String> chList = map.get(tele);
//            //如果tele对应的unicode是一个，直接put
//            //第一次肯定没有
//            if (chList == null || chList.isEmpty()) {
//                count++;
//                List<String> cList = new ArrayList<>();
//                cList.add(ch);
//                map.put(tele,cList);
//            }else {
//                //如果一对多，就直接放list里
//                chList.add(ch);
//            }
//        }
//        System.out.println("count:"+count);
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            String key = RpsRedisKeyConstants.MT_TELE_TO_CN + entry.getKey();
//            String value = entry.getValue().toString();
//            redisClient.set(key,value);
//        }
//        System.out.println("map:"+map.size());
//    }
//
//    @Test
//    public void selectRedis() {
////        long startTime = System.currentTimeMillis();
////        Object o = redisClient.get(RpsRedisKeyConstants.MT_CN_TO_TELE_SIM + "41C7");
////        System.out.println(o);
////        long endTime = System.currentTimeMillis();
////        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
//        //查650指定103报文前缀的key和value
//        String key = "pg:650:103:"+"*";
//        Set<String> keys = stringRedisTemplate.keys(key);
//        Map<String, String> map = new HashMap<>();
//        for (String s : keys) {
//            String value = stringRedisTemplate.opsForValue().get(s);
//            map.put(s,value);
//        }
//        System.out.println(keys.size());
//    }
//
//    @Test
//    public void saveTeleToRedis1() {
//        List<String> keys = new ArrayList<String>();
//        List<TratoteleDO> tratoteleDOList = tratoteleDao.findAll();
//        for (TratoteleDO t : tratoteleDOList) {
//            String sinKey = RpsRedisKeyConstants.MT_CN_TO_TELE_TRA + t.getPgUnicodeT();
//            keys.add(sinKey);
//        }
//
//        for (int i = 0; i < keys.size(); i++) {
//            TratoteleDO tratoteleDO = new TratoteleDO();
//            tratoteleDO.setPgUnicodeT(tratoteleDOList.get(i).getPgUnicodeT());
//            List<TratoteleDO> tratoteleDOS = tratoteleDao.findList(tratoteleDO);
//            String str = JSONObject.toJSONString(tratoteleDOS);
//            redisClient.set(keys.get(i), str);
//        }
//    }
//}
