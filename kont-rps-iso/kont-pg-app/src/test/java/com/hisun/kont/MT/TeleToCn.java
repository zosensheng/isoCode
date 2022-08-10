//package com.hisun.kont.MT;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.pg.dao.PgstpswfDao;
//import com.hisun.kont.pg.dao.SintoteleDao;
//import com.hisun.kont.pg.dao.TratoteleDao;
//import com.hisun.kont.pg.entity.PgstpswfDO;
//import com.hisun.kont.pg.entity.SintoteleDO;
//import com.hisun.kont.pg.entity.TratoteleDO;
//import org.junit.Test;
//
//import javax.annotation.Resource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// * @author: jcL
// * @create: 2021/7/2 9:49
// */
//
//public class TeleToCn extends ApplicationTest {
//    private static String REGEX = "^[0-9]{4}$";
//    @Resource
//    private PgstpswfDao pgstpswfDao;
//    @Resource
//    private TratoteleDao tratoteleDao;
//    @Resource
//    private SintoteleDao sintoteleDao;
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
//
//    @Test
//    public void getCnToTele(){
//        //繁体转电码
//        String trafile = readString2("C:\\Users\\35850\\Desktop\\高阳科技\\电码\\CM3H2T");
//        String traStr = trafile.replaceAll("\0", "");
//        //简体转电码
//        String simfile = readString2("C:\\Users\\35850\\Desktop\\高阳科技\\电码\\CM3H2Ts");
//        String simStr = simfile.replaceAll("\0", "");
//        List<TratoteleDO> traList = new ArrayList<>();
//        List<SintoteleDO> simList = new ArrayList<>();
////        for (int i = 0; i < traStr.length(); i = i + 10) {
////            String src = traStr.substring(i, i + 10);
////            String tra = src.substring(1, 1 + 4);
////            String tele = src.substring(6, 6 + 4);
////            String pgswfId = UUID.randomUUID().toString().substring(0, 20).replace("-", "");
////            TratoteleDO tratoteleDO = new TratoteleDO();
////            tratoteleDO.setPgswfId(pgswfId);
////            tratoteleDO.setPgUnicodeT(tra);
////            tratoteleDO.setPgTeleNum(tele);
////            traList.add(tratoteleDO);
////            tratoteleDao.insert(tratoteleDO);
////        }
////        List<TratoteleDO> all = tratoteleDao.findAll();
////        for (int i = 0; i < simStr.length(); i=i+10) {
////            String src = traStr.substring(i, i + 10);
////            String sim = src.substring(1, 1 + 4);
////            String tele = src.substring(6, 6 + 4);
////            String pgswfId = UUID.randomUUID().toString().substring(0, 20).replace("-", "");
////            SintoteleDO sintoteleDO = new SintoteleDO();
////            sintoteleDO.setPgswfId(pgswfId);
////            sintoteleDO.setPgUnicodeS(sim);
////            sintoteleDO.setPgTeleNum(tele);
////            simList.add(sintoteleDO);
////            sintoteleDao.insert(sintoteleDO);
////        }
//        List<SintoteleDO> sintoteleDaoAll = sintoteleDao.findAll();
//        Set<String> set = new HashSet<>();
//        for (SintoteleDO sintoteleDO : sintoteleDaoAll) {
//            set.add(sintoteleDO.getPgUnicodeS());
//        }
////        List<SintoteleDO> collect = sintoteleDaoAll.stream().distinct().collect(Collectors.toList());
//        System.out.println(sintoteleDaoAll.size()+":"+set.size());
////        System.out.println(simList.size() + traList.size()+sintoteleDaoAll.size()+all.size());
//    }
//
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
//        System.out.println("pgList:"+pgstpswfDOList.size());
//        Map<String,List<String>> map = new HashMap<>();
//        for (int i = 0; i < pgstpswfDOList.size(); i++) {
//            PgstpswfDO pgstpswfDO = pgstpswfDOList.get(i);
//            String tele = pgstpswfDO.getPgTeleNum();
//            String ch = pgstpswfDO.getPgChUniCode();
//            List<String> chList = map.get(tele);
//            if (chList == null || ch.isEmpty()) {
//                List<String> cList = new ArrayList<>();
//                cList.add(ch);
//                map.put(tele,cList);
//            }else {
//                chList.add(ch);
//            }
//        }
//        System.out.println(map.size());
//    }
//
//    @Test
//    public void teleToChinese() {
//        String content = "0418 0421";
//        if (content.isEmpty()) {
//            return ;
//        } else {
//            if(!content.contains(" ")){
//                return ;
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
//                    if (teleStrs[i].contains("(") && teleStrs[i].charAt(0) == '(') {
//                        teleStrs[i] = teleStrs[i].substring(1);
//                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
//                        stringBuilder.append("(" + chinese);
//                    } else if (teleStrs[i].contains(")") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ')') {
//                        teleStrs[i] = teleStrs[i].substring(0, teleStrs[i].length() - 1);
//                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
//                        stringBuilder.append(chinese + ")");
//                    } else {
//                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
//                        stringBuilder.append(chinese);
//                    }
//                }
//            }
//            System.out.println(stringBuilder.toString());
//        }
//    }
//
//    //转换规则判断
//    public static boolean teleIsConvert(String tele, int i, String teleStr, int totalLength) {
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
//            //遍历进行比较，如果后一个电码不符合规则为false，如果符合为true
//        } else {
//            if (tele.length() >= 4 && tele.length() <= 6) {
//                tele = removeKuoHao(tele);
//                if (tele.matches(REGEX)) {
//                    teleStr = removeKuoHao(teleStr);
//                    if (teleStr.matches(REGEX)) {
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
//            if (endTeleStr == ')') {
//                teleStr = teleStr.substring(0, teleStr.length() - 1);
//            }
//            return teleStr;
//        }
//    }
//
//    //电码转unicode码
//    public String selectStptswfBySwfTele(String elecCode) {
//        PgstpswfDO pgstpswfDO = new PgstpswfDO();
//        pgstpswfDO.setPgTeleNum(elecCode);
//        List<PgstpswfDO> pgstpswfDOList = pgstpswfDao.findList(pgstpswfDO);
//        if (pgstpswfDOList == null || pgstpswfDOList.size() > 2) {
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
