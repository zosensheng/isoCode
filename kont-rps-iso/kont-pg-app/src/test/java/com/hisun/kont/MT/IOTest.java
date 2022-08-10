//package com.hisun.kont.MT;
//
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.common.utils.JudgeUtils;
//import com.hisun.kont.common.utils.StringUtils;
//import com.hisun.kont.framework.redis.server.RedisClient;
//import com.hisun.kont.pg.constants.RpsRedisKeyConstants;
//import com.hisun.kont.pg.dao.PgTagDescribeDao;
//import com.hisun.kont.pg.dao.PgstsDao;
//import com.hisun.kont.pg.entity.PgTagDescribeDO;
//import com.hisun.kont.pg.entity.PgstsDO;
//import org.junit.Test;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import javax.annotation.Resource;
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class IOTest extends ApplicationTest {
//
//    @Resource
//    PgTagDescribeDao pgTagDescribeDao;
//
//    @Resource
//    RedisClient redisClient;
//
//    @Resource
//    StringRedisTemplate stringRedisTemplate;
//
//    @Resource
//    PgstsDao pgstsDao;
//
//    /**
//     * 提取txt内容到数据库
//     */
//    @Test
//    public void saveTxt() {
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("D:\\FLD TAG.txt"));//打开文件创建数据流
//            String str = null; //定义String变量用来保存每一次读到的每一行的数据
//            String[] s = new String[0];//定义数组用来保存需要的数据
//            while ((str = in.readLine()) != null) {
//                //报文类型
//                String ahMt = str.substring(0, 3);
//                //报文相应的域
//                String key = str.substring(3, 8);
//                //报文相应的域描述
//                String value = str.substring(8);
//                PgTagDescribeDO pgTagDescribeDO = new PgTagDescribeDO();
//                pgTagDescribeDO.setAhMt(ahMt);
//                pgTagDescribeDO.setMtTagKey(key);
//                pgTagDescribeDO.setTagValue(value);
////                System.out.println(pgTagDescribeDO);
////                pgTagDescribeDao.insert(pgTagDescribeDO);
//
//            }
//            in.close();
//        } catch (IOException e) {
//        }
//    }
//
//    /**
//     * 将tag描述存进redis中
//     */
//    @Test
//    public void save650TagToRedis() {
//        List<PgTagDescribeDO> pgTagDescribeDOList = pgTagDescribeDao.findAll();
//        for (PgTagDescribeDO pgTagDescribeDO : pgTagDescribeDOList) {
//            String key = RpsRedisKeyConstants.MT_650_tag_describe + pgTagDescribeDO.getMtTagKey();
//            String value = pgTagDescribeDO.getTagValue();
//            redisClient.set(key,value);
//        }
//    }
//
//    /**
//     * 从redis中获取tag的描述
//     */
//    @Test
//    public void getTagDescribeToRedis() {
//        Object o = redisClient.get(RpsRedisKeyConstants.MT_650_tag_describe + "103" + ":" + "59" + ": ");
//        String value = o.toString();
//        System.out.println(value);
//    }
//
//    @Test
//    public void getTagDes() {
//        String txCode = "103";
////        String tagName = "36";
//        String tagName = "26T";
//        String preStr = RpsRedisKeyConstants.MT_650_tag_describe;
//        String tagDescribe = null;
//        if (tagName.length() == 2) {
//            Object o = redisClient.get(preStr + txCode + ":" + tagName + ": ");
//            tagDescribe = o.toString();
//        }
//        if (tagName.length() == 3) {
//            Object o = redisClient.get(preStr + txCode + ":" + tagName + ":");
//            tagDescribe = o.toString();
//        }
//        System.out.println(tagDescribe);
//    }
//
//    @Test
//    public void getMTTagDes() {
//        String key = "pg:650:103:" + "*";
//        Set<String> keys = stringRedisTemplate.keys(key);
//        Map<String, String> map = new HashMap<>();
//        for (String s : keys) {
//            Object o = redisClient.get(s);
//            String value = o.toString();
//            String tagKey = s.substring(10, 15);
//            if (tagKey.contains(" ")) {
//                tagKey = s.substring(10, 14);
//                System.out.println(tagKey + value);
//            }
//        }
//        System.out.println(keys.size());
//    }
//
//    /**
//     * 生成650打印格式的批量文件
//     */
//    @Test
//    public void getMesToTxt() {
//        String fileName = "650";
//        String filePath = "D:\\temp\\txt";
////        PgstsDO dao = pgstsDao.getByMsgNo("052202107109003034");
//        List<PgstsDO> pgstsDOList = pgstsDao.findAll();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        List<String> result = new ArrayList<>();
//        //        拼文件头
//        result.add("003260HKPAS80059PASMSG1X");
////        统计脏数据
//        int j = 0;
//        for (PgstsDO pgstsDO : pgstsDOList) {
//            if (JudgeUtils.isEmpty(pgstsDO.getMtMessage())){
//                    j++;
//            }else {
//                StringBuilder content= new StringBuilder();
//                StringBuffer sb = new StringBuffer();
////        获取打印格式  根据\r\n进行拆分
//                String[] split = pgstsDO.getMtMessage().split("\r\n");
//                String lineMessage = null;
//                String[] mess = new String[split.length];
////        每个字符数组的长度大小为80长度  不满足长度要求  右边用空格补齐
//                for (int i = 0; i < split.length; i++) {
//                    if (split[i].length() < 80) {
//                        lineMessage = StringUtils.rightPad(split[i], 80, " ");
//                    }
//                    mess[i] = lineMessage;
//                }
////        将数组内容拼接
//                for (int i = 0; i < mess.length; i++) {
//                    sb.append(mess[i]);
//                }
//                content.append("1")
//                        .append("2023/02/07")
//                        .append("N")
//                        .append("53230207BKR00253")
//                        .append(pgstsDO.getMsgNo())
//                        .append("S")
//                        .append(dateFormat.format(date))
//                        .append(pgstsDO.getAhMt())
//                        .append(sb.toString());
//                result.add(content.toString());
//            }
//
//        }
////        拼文件尾
//        SimpleDateFormat sbf = new SimpleDateFormat("yyyy/MM/ddHHmmss");
//        String dateTime = sbf.format(date);
////        文件数量
//        String num = StringUtils.leftPad(String.valueOf(pgstsDOList.size()-j), 9, "0");
//        result.add("2HKPAS800592023/02/07" + dateTime + num);
//        long start = System.currentTimeMillis();
//        BufferedWriter out = null;
//        try {
//            if (result != null && !result.isEmpty() && JudgeUtils.isNotEmpty(fileName)) {
//                fileName += "_" + System.currentTimeMillis() + ".txt";
//                File pathFile = new File(filePath);
//                if (!pathFile.exists()) {
//                    pathFile.mkdirs();
//                }
//                String relFilePath = filePath + File.separator + fileName;
//                File file = new File(relFilePath);
//                if (!file.exists()) {
//                    file.createNewFile();
//                }
//                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
////                //标题头
////                out.write("curr_time,link_id,travel_time,speed,reliabilitycode,link_len,adcode,time_stamp,state,public_rec_time,ds");
////                out.newLine();
//                for (String info : result) {
//                    out.write(info);
//                    out.newLine();
//                }
////                logger.info("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
//                System.out.println("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (out != null) {
//                try {
//                    out.flush();
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//
//    /**
//     * java遍历磁盘文件夹
//     */
//    @Test
//    public void getFile() {
//    }
//}
