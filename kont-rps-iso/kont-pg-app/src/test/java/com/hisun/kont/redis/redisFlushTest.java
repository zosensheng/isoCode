//package com.hisun.kont.redis;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.framework.redis.server.RedisClient;
//import com.hisun.kont.pg.constants.RpsRedisKeyConstants;
//import com.hisun.kont.pg.dao.SintoteleDao;
//import com.hisun.kont.pg.dao.TratoteleDao;
//import com.hisun.kont.pg.entity.PgstpswfDO;
//import com.hisun.kont.pg.entity.SintoteleDO;
//import com.hisun.kont.pg.entity.TratoteleDO;
//import org.junit.Test;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import javax.annotation.Resource;
//import java.util.*;
//
///**
// * @author: jcL
// * @create: 2021/7/28 15:29
// */
//public class redisFlushTest extends ApplicationTest {
//
//    @Resource
//    private RedisClient redisClient;
//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
//    @Resource
//    private SintoteleDao sintoteleDao;
//    @Resource
//    private TratoteleDao tratoteleDao;
//
//    @Test
//    public void redisTest(){
//        Set<String> pgKeys = stringRedisTemplate.keys("pg:tratotele:*");
//        //当数据没有了
//        if (pgKeys.size() == 0 && pgKeys.isEmpty()) {
//            //重新读数据库然后存redis
//            tratoteleMethod();
//        }else {
//            //数据库进行了更新，去查redis数据然后删了再重新存一遍
//            String[] keyArr = pgKeys.toArray(new String[pgKeys.size()]);
//            System.out.println(keyArr);
////            redisClient.remove(keyArr);
//        }
//
//    }
//
//    private void tratoteleMethod() {
//        //简体转电码
//        List<TratoteleDO> tratoteleDOList = tratoteleDao.findAll();
//        Map<String, List<String>> map = new HashMap<>();
//        for (TratoteleDO tratoteleDO: tratoteleDOList) {
//            String ch = tratoteleDO.getPgUnicodeT();
//            String tele = tratoteleDO.getPgTeleNum();
//            List<String> teleList = map.get(ch);
//            //如果tele对应的unicode是一个，直接put
//            //第一次肯定没有
//            if (teleList == null || teleList.isEmpty()) {
//                List<String> cList = new ArrayList<>();
//                cList.add(tele);
//                map.put(ch,cList);
//            }else {
//                //如果一对多，就直接放list里
//                teleList.add(tele);
//            }
//        }
//        System.out.println(map.size());
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            String key = RpsRedisKeyConstants.MT_CN_TO_TELE_TRA + entry.getKey();
//            String value = entry.getValue().toString();
//            redisClient.set(key,value);
//        }
//    }
//
//    private void sintoteleMethod() {
//        //简体转电码
//        List<SintoteleDO> sintoteleDOList = sintoteleDao.findAll();
//        Map<String, List<String>> map = new HashMap<>();
//        for (SintoteleDO sintoteleDO: sintoteleDOList) {
//            String ch = sintoteleDO.getPgUnicodeS();
//            String tele = sintoteleDO.getPgTeleNum();
//            List<String> teleList = map.get(ch);
//            //如果tele对应的unicode是一个，直接put
//            //第一次肯定没有
//            if (teleList == null || teleList.isEmpty()) {
//                List<String> cList = new ArrayList<>();
//                cList.add(tele);
//                map.put(ch,cList);
//            }else {
//                //如果一对多，就直接放list里
//                teleList.add(tele);
//            }
//        }
//        System.out.println(map.size());
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            String key = RpsRedisKeyConstants.MT_CN_TO_TELE_SIM + entry.getKey();
//            String value = entry.getValue().toString();
//            redisClient.set(key,value);
//        }
//    }
//}
