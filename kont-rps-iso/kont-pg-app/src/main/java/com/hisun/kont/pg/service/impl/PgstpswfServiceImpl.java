package com.hisun.kont.pg.service.impl;

import com.hisun.kont.pg.dao.PgTeletotraDao;
import com.hisun.kont.pg.entity.PgTeletotraDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jcL
 * @create: 2021/6/9 17:03
 * (拆解报文)电码转中文
 */
@Service
@Transactional
public class PgstpswfServiceImpl{

    private static String REGEX = "^[0-9]{4}$";

//    @Resource
//    private PgstpswfDao pgstpswfDao;

    @Resource
    private PgTeletotraDao teletotraDao;

    /**
     * 电码转中文逻辑
     * @return
     */
    public String teleToChinese(String content) {
        if (content.isEmpty() && content == null) {
            return content;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String[] teleStrs = content.split(" ");
            List<String> teleList = Arrays.asList(teleStrs);
            for (int i = 0; i < teleStrs.length; i++) {
                String nextTeleStr = teleStrs[i + 1 >= teleStrs.length ? i : i + 1];
                //如果长度不符合直接跳过
                boolean flag = teleIsConvert(teleStrs[i], i, nextTeleStr, teleStrs.length);
                if (flag == false) {
                    stringBuilder.append(teleStrs[i] + " ");
                } else {
                    if (teleStrs[i].contains("(") && teleStrs[i].charAt(0) == '(') {
                        teleStrs[i] = teleStrs[i].substring(1);
                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
                        stringBuilder.append("(" + chinese);
                    } else if (teleStrs[i].contains(")") && teleStrs[i].charAt(teleStrs[i].length() - 1) == ')') {
                        teleStrs[i] = teleStrs[i].substring(0, teleStrs[i].length() - 1);
                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
                        stringBuilder.append(chinese + ")");
                    } else {
                        String chinese = selectStptswfBySwfTele(teleStrs[i]);
                        stringBuilder.append(chinese);
                    }
                }
            }
            return stringBuilder.toString();
        }
    }

    //转换规则判断
    public boolean teleIsConvert(String tele, int i, String teleStr, int totalLength) {
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
            //遍历进行比较，如果后一个电码不符合规则为false，如果符合为true
        } else {
            if (tele.length() >= 4 && tele.length() <= 6) {
                tele = removeKuoHao(tele);
                if (tele.matches(REGEX)) {
                    teleStr = removeKuoHao(teleStr);
                    if (teleStr.matches(REGEX)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //提取括号
    public String removeKuoHao(String teleStr) {
        if (teleStr != null && teleStr.equals("")) {
            return teleStr;
        } else {
            char startTeleStr = teleStr.charAt(0);
            char endTeleStr = teleStr.charAt(teleStr.length() - 1);
            if (startTeleStr == '(') {
                teleStr = teleStr.substring(1);
            }
            if (endTeleStr == ')') {
                teleStr = teleStr.substring(0, teleStr.length() - 1);
            }
            return teleStr;
        }
    }

    //电码转unicode码
    public String selectStptswfBySwfTele(String elecCode) {
        PgTeletotraDO pgTeletotraDO = new PgTeletotraDO();
        pgTeletotraDO.setTelexCode(elecCode);
        List<PgTeletotraDO> teletotraDOS = teletotraDao.findList(pgTeletotraDO);
//        PgstpswfDO pgstpswfDO = new PgstpswfDO();
//        pgstpswfDO.setPgTeleNum(elecCode);
//        List<PgstpswfDO> pgstpswfDOList = pgstpswfDao.findList(pgstpswfDO);
        if (teletotraDOS == null || teletotraDOS.size() > 2) {
            return elecCode;
        }
//        String chinese = unicodeToCn(teletotraDOS.get(0).getPgChUniCode());
        String chinese = teletotraDOS.get(0).getGlyph();
        return chinese;
    }

    //unicode转中文
//    private String unicodeToCn(String unicode) {
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

}
