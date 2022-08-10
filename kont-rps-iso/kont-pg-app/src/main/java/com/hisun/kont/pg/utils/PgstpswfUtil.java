package com.hisun.kont.pg.utils;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgTeletotraDao;
import com.hisun.kont.pg.entity.PgTeletotraDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PgstpswfUtil {

    private static String REGEX = "^[0-9]{4}$";

    private static PgTeletotraDao pgTeletotraDao;

    @Value("${switch.redisFlag}")
    private boolean redisF;

    private static boolean redisFlag;

    @PostConstruct
    public void getRedisFlag() {
        redisFlag = this.redisF;
    }

    @Autowired
    public PgstpswfUtil(PgTeletotraDao pgTeletotraDao) {
        PgstpswfUtil.pgTeletotraDao = pgTeletotraDao;
    }

    /**
     * 电码转中文逻辑
     *
     * @return
     */
    public static String teleToChinese(String content,String tagName) {
        if (content == null || content.isEmpty()) {
            return content;
        } else {
            if (!content.contains(" ")) {
                return content;
            }
            StringBuilder stringBuilder = new StringBuilder();
            //72域特别处理
            if ("72".equals(tagName)){
                if (content.length()>4){
                    //如果是以双斜杠开头
                    if ("//".equals(content.substring(0,2))){
                        stringBuilder.append(content.substring(0,2));
                        content = content.substring(2);
                    }else if ("/".equals(content.substring(0,1))){
                        //如果是/8c/开头
                        if (content.substring(1).contains("/")){
                            String subS = content.substring(1);
                            int index = subS.indexOf("/");
                            //index+2 由于上面截取从1开始 加上还保留该index位置
                            stringBuilder.append(content.substring(0,index+2));
                            content = subS.substring(index + 1);
                        }
                    }
                }
            }
            String[] teleStrs = content.split(" ",-1);
            List<String> teleList = Arrays.asList(teleStrs);
            for (int i = 0; i < teleStrs.length; i++) {
                String nextTeleStr = teleStrs[i + 1 >= teleStrs.length ? i : i + 1];
                //获取前一个str
                String frontTeleStr = null;
                if (i != 0){
                    frontTeleStr = teleStrs[i-1];
                }
                //如果长度不符合直接跳过
                boolean flag = teleIsConvert(teleStrs[i], i, nextTeleStr, teleStrs.length,frontTeleStr);
                if (flag == false) {
                    if (i!=teleStrs.length-1){
                        stringBuilder.append(teleStrs[i] + " ");
                    }else {
                        stringBuilder.append(teleStrs[i]);
                    }
                } else {
                    //此时已确定是电码格式了，需要判断是否可以转成中文，然后拼接
                    if (teleStrs[i].contains("(") && teleStrs[i].charAt(0) == '(') {
                        teleStrs[i] = teleStrs[i].substring(1);
                        String chinese = selectStptswfBySwfTele(teleStrs[i],tagName);
                        stringBuilder.append("(" + chinese);
                    } else if ((teleStrs[i].contains(")") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ')')
                            || (teleStrs[i].contains(",") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ',')) {
                        String subTeleStr = teleStrs[i].substring(0, teleStrs[i].length() - 1);
                        String chinese = selectStptswfBySwfTele(subTeleStr,tagName);
                        if (teleStrs[i].substring(4).equals(",")) {
                            stringBuilder.append(chinese + ",");
                        } else {
                            stringBuilder.append(chinese + ")");
                        }
                    } else {
                        String chinese = selectStptswfBySwfTele(teleStrs[i],tagName);
                        stringBuilder.append(chinese);
                    }
                }
            }
            return stringBuilder.toString();
        }
    }

    //转换规则判断
    public static boolean teleIsConvert(String tele, int i, String nextTele, int totalLength,String frontTeleStr) {
        //如果是最后一个电码，不比较，直接判断能否转换中文
        if (i == totalLength - 1) {
            if (tele.length() >= 4 && tele.length() <= 6) {
                tele = removeKuoHao(tele);
                if (tele.matches(REGEX)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
            //遍历进行比较，如果后一个电码不符合规则为false，如果符合为true，nextTele是后一个char
        } else {
            //拆解时单行的判断逻辑
            if (tele.length() >= 4 && tele.length() < 6) {
                tele = removeKuoHao(tele);
                if (tele.matches(REGEX)) {
                    nextTele = removeKuoHao(nextTele);
                    if (nextTele.matches(REGEX)) {
                        return true;
                    }else {
                        if (JudgeUtils.isNull(frontTeleStr)){
                            return false;
                        }else {
                            //判断前一个是否为电码
                            frontTeleStr = removeKuoHao(frontTeleStr);
                            if (frontTeleStr.matches(REGEX)){
                                return true;
                            }
                        }

                    }
                }
            }
        }
        return false;
    }

    //提取括号
    public static String removeKuoHao(String teleStr) {
        if (teleStr != null && teleStr.equals("")) {
            return teleStr;
        } else {
            char startTeleStr = teleStr.charAt(0);
            char endTeleStr = teleStr.charAt(teleStr.length() - 1);
            if (startTeleStr == '(') {
                teleStr = teleStr.substring(1);
            }
            if (endTeleStr == ')' || endTeleStr == ',') {
                teleStr = teleStr.substring(0, teleStr.length() - 1);
            }
            return teleStr;
        }
    }

    //电码转unicode码
    public static String selectStptswfBySwfTele(String elecCode,String tagName) {
        String chinese = "";
        PgTeletotraDO pgTeletotraDO = new PgTeletotraDO();
        pgTeletotraDO.setTelexCode(elecCode);
        List<PgTeletotraDO> teletotraDaoList = pgTeletotraDao.findList(pgTeletotraDO);
        List<PgTeletotraDO> teletotraDOS = new ArrayList<>();
        for (PgTeletotraDO teletotraDO : teletotraDaoList) {
            if (!"delete".equals(teletotraDO.getTeleAction())){
                teletotraDOS.add(teletotraDO);
            }
        }
            //如果存在电码一对多的情况，给个状态码返回给py，目前的问题是如何搞一个状态码并传出去
            if (teletotraDOS.size() == 0) {
                CopyTagUtils.threadLocal.set(tagName+MTInStatusConstants.MT_TELE_TO_CN_NONE);
                return elecCode;
            }else if (teletotraDOS.size()>1){
                CopyTagUtils.threadLocal.set(tagName+MTInStatusConstants.MT_TELE_TO_CNS);
                return elecCode;
            }
            chinese = teletotraDOS.get(0).getGlyph();
            return chinese;
//        }
    }

    //unicode转中文
    private static String unicodeToCn(String unicode) {
        StringBuilder sbUniCode = new StringBuilder(unicode);
        sbUniCode.insert(0, "\\u");
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = sbUniCode.toString().split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    /**
     * 中文转unicode,unicode去数据库匹配对应电码
     *
     * @param cn
     * @return
     */
    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        String upperCase = returnStr.toUpperCase();
        return upperCase;
    }

    public static void main(String[] args) {
        String cotent = "/ACC/0999 0999 0999 0808 0808";
        String tagName = "72";
        String s = teleToChinese(cotent, tagName);
        System.out.println(s);
    }
}
