package com.hisun.kont.pg.utils;

import com.hisun.kont.common.exception.KontException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 金额转String。
 *
 * @author E
 */
public class ConversionUtil {


    public static void main(String[] args) {
        String swiftAmount = "225909090,202";
        BigDecimal bigDecimal = strAmountToBigAmount(swiftAmount);
        System.out.println(bigDecimal);


//        String swiftRate = "13,";
//        BigDecimal bigDecimal = strRateToDouRate(swiftRate);
//        System.out.println(bigDecimal);
    }
    /**
     * "."转","
     *
     * @param ob
     * @return
     */
    public static String conversionFormat(Object ob) {
        String conversion = "";
        String conversions = ob.toString();
        List<String> list = new ArrayList<String>();
        //保存数组
        for (int i = 0; i < conversions.length(); i++) {
            String temp = conversions.substring(i, i + 1);
            list.add(i, temp);
        }
        for (int k = 0; k < list.size(); k++) {
            String str = list.get(k);
            //中间有","时
            if (",".equals(str)) {
                list.remove(k);
                String st = String.join("", list.toArray(new String[list.size()]));
                conversion = st + ",";
            }
            //开头是"."时
            if (".".equals(list.get(0))) {
                list.remove(0);
                list.add(0, "0,");
                String st = String.join("", list.toArray(new String[list.size()]));
                conversion = st;
            }
            //中间有"."时
            if (".".equals(list.get(k))) {
                list.remove(".");
                list.add(k, ",");
                conversion = String.join("", list.toArray(new String[list.size()]));
            }
        }
        //如果是短整数
        if (conversion.contains(",")) {
        } else {
            String st = String.join("", list.toArray(new String[list.size()]));
            conversion = st + ",";
        }
        //为0时
        if ("0".equals(conversions)) {
            conversion = "0,";
        }
        //末尾小数为0时,需要去掉
        conversion = conversion.replaceAll("(0)+$", "");
        return conversion;
    }

    /**
     * ","转"."
     *
     * @param
     * @return
     */
    public static String conversRoutine(String str) {
        String conversion = "";
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            list.add(i, temp);
        }
        for (int k = 0; k < list.size(); k++) {
            String ss = list.get(k);
            if (",".equals(ss)) {
                //结尾为,时
                if ((k + 1) == list.size()) {
                    list.remove(k);
                } else {
                    //","在中间时
                    list.remove(",");
                    list.add(k, ".");
                }
                String st = String.join("", list.toArray(new String[list.size()]));
                conversion = st;
            }
        }
        return conversion;
    }

    /**
     * 金额校验规则
     *金额转报文格式
     * 15位整数金额，其中最大整数位13+小数点1位+1位小数或者13位整数+小数点1位+2位小数(最后以为小数为0)
     * 小数位可能最多四位
     * @param amount
     * @return
     */
    public static String checkAmountRule(BigDecimal amount) {
        String strBg = amount.toString();
        String str = conversionFormat(strBg);
        if (str.length() <= 15) {
//            if (str.contains(",")) {
//                if (str.length() > 5) {
//                    String amtStr = str.substring(str.length() - 5);
//                    if (amtStr.contains(",")) {
//                        String spStr = ",";
//                        int count = 0;
//                        Pattern pattern = Pattern.compile(spStr);
//                        Matcher matcher = pattern.matcher(amtStr);
//                        while (matcher.find()) {
//                            count++;
//                        }
//                        if (count > 1) {
//                            KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_AMOUNT_ERROR);
//                        }
//                        return str;
//                    } else {
//                        KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_AMOUNT_ERROR);
//                    }
//                } else {
//                    return str;
//                }
//            }
            return str;
        }else {
            KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_AMOUNT_ERROR);
        }
        return "";
    }

    /**
     * 报文格式金额转一般常规金额
     * 有效数字不能超过两位
     * @param str
     * @return
     */
    public static BigDecimal strAmountToBigAmount(String str){
        //末尾小数为0时,需要去掉
        str = str.replaceAll("(0)+$", "");
        if (str.length()<=16){
            //,转.
            int length = str.substring(str.indexOf(",") + 1).length();
            if (length<=4){
                String conversRoutine = conversRoutine(str);
                BigDecimal bigDecimal = new BigDecimal(conversRoutine);
//                double amount = Double.parseDouble(conversRoutine);
                return bigDecimal;
            }else {
                KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_AMOUNT_ERROR);
            }
        }else {
            KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_AMOUNT_ERROR);
        }
        return new BigDecimal(0);
    }

    /**
     * 汇率校验规则   一般常规汇率转报文格式汇率
     * 汇率有效数字不超过13位  小数位不能超过7位
     * @param rate
     * @return
     */
    public static String checkExchange(BigDecimal rate) {
        BigDecimal bigDecimal = rate;
        //去除末尾的零
        String strBg = bigDecimal.stripTrailingZeros().toString();
        String str = conversionFormat(strBg);
        if (str.length() > 13) {
            KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
        } else {
            if (str.contains(",")) {
                if (str.length() > 7) {
                    String substring = str.substring(str.length() - 8);
                    if (!substring.contains(",")) {
                        KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
                    }
                    String spStr = ",";
                    int count = 0;
                    Pattern pattern = Pattern.compile(spStr);
                    Matcher matcher = pattern.matcher(substring);
                    while (matcher.find()) {
                        count++;
                    }
                    if (count > 1) {
                        KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
                    }
                    return str;
                } else {
                    String substring = str;
                    if (!substring.contains(",")) {
                        KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
                    }
                    String spStr = ",";
                    int count = 0;
                    Pattern pattern = Pattern.compile(spStr);
                    Matcher matcher = pattern.matcher(substring);
                    while (matcher.find()) {
                        count++;
                    }
                    if (count > 1) {
                        KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
                    }
                    return str;
                }
            }

        }
        return "";
    }

    /**
     * 报文汇率转一般常规汇率
     * @return
     */
    public static BigDecimal strRateToDouRate(String rate){
        if (rate.length()>13){
            KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
        }else {
            int length = rate.substring(rate.indexOf(",") + 1).length();
            if (length<=7){
                String dRate = conversRoutine(rate);
                BigDecimal bigDecimal = new BigDecimal(dRate);
                return bigDecimal;
            }else {
                KontException.throwKontException(com.hisun.kont.pg.constants.MTConstants.MT_EXCHANGE_ERROR);
            }
        }
        return null;
    }

}
