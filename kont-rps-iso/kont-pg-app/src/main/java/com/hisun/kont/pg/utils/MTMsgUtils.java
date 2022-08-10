package com.hisun.kont.pg.utils;

import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.swf.mt.constants.MTConstants;
import com.hisun.kont.swf.mt.constants.MsgCdEnum;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MTMsgUtils {
    public static HashSet<Byte> signalSet = new HashSet<Byte>() {{
        add((byte) '/');
        add((byte) '-');
        add((byte) '?');
        add((byte) ':');
        add((byte) '(');
        add((byte) ')');
        add((byte) '.');
        add((byte) ',');
        add((byte) '\'');
        add((byte) '+');
        add((byte) '\r');
        add((byte) '\n');
        add((byte) ' ');
    }};

    /**
     * 非法字符集
     */
    public static Set<String> unLegalCharacterSet = new HashSet<String>() {{
        add(",");
        add(";");
        add("’");
        add("<");
        add(">");
        add(":");
        add("”");
        add("“");
        add("`");
        add("~");
        add("!");
        add("@");
        add("#");
        add("%");
        add("&");
        add("_");
        add(" ");
    }};

    // 生成订单号
    public static ArrayList<String> paserFormatLine(String content, String data) {
        ArrayList<String> resultList = new ArrayList<String>();
        return null;
    }

    public static BaseTag setFiledByName(String name, BaseTag tag, String value) {
        try {
            Field field = tag.getClass().getDeclaredField(name);//获取字段
            field.set(tag, value);//为字段赋值
            return tag;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static String[] paserStrToLines(String data) {
        return data.split(MTConstants.MT_MESSAGE_LINE_BREAK_MARK);
    }

    public static Boolean checkCharset(String data, String charset) {
        Integer pointFlag = 0;
        for (byte b : data.getBytes()) {
            if (StringUtils.equalsIgnoreCase(charset, "n")) {
                if (byteIsNumber(b)) {
                    continue;
                } else {
                    return false;
                }
            } else if (StringUtils.equalsIgnoreCase(charset, "d")) {
                if (byteIsNumber(b)) {
                    continue;
                } else if (b == ',') {
                    pointFlag++;
                } else {
                    return false;
                }
            } else if (StringUtils.equalsIgnoreCase(charset, "a")) {
                if (byteIsAlphabet(b)) {
                    continue;
                } else {
                    return false;
                }
            } else if (StringUtils.equalsIgnoreCase(charset, "c")) {
                if (byteIsAlphabet(b) || byteIsNumber(b)) {
                    continue;
                } else {
                    return false;
                }
            } else if (StringUtils.equalsIgnoreCase(charset, "x")) {
                if (byteIsAlphabet(b) || byteIsNumber(b) || byteIsInSignalSet(b)) {
                    continue;
                } else {
                    return false;
                }
            }

            if (StringUtils.equalsIgnoreCase(charset, "d") && pointFlag != 1) {
                return false;
            }

            return true;
        }
        //其他字符集检查暂未实现，需要扩展
        return true;
    }

    public static Boolean checkIsCharsetChar(String charset) {
        HashSet<String> charsetSet = new HashSet<String>() {{
            add("n");
            add("a");
            add("x");
            add("y");
            add("z");
            add("c");
            add("h");
            add("s");
            add("e");
            add("A");
            add("B");
            add("d");
        }};
        if (charsetSet.contains(charset)) {
            return true;
        }
        return false;
    }

    public static Boolean byteIsNumber(Byte b) {
        if (b >= '0' && b <= '9')
            return true;
        else
            return false;
    }

    public static Boolean byteIsAlphabet(Byte b) {
        if (b >= 'a' && b <= 'z') {
            return true;
        } else if (b >= 'A' && b <= 'Z') {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean byteIsInSignalSet(Byte b) {
        if (signalSet.contains(b)) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isResultCodeSuccess(String resultCode) {
        if (StringUtils.isEmpty(resultCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验bic格式是否正确
     *
     * @param bicCode
     * @return
     * @author zhanghl
     */
    public static boolean checkValidBic(String bicCode) {
        if (StringUtils.isBlank(bicCode)) {
            return false;
        }
        return bicCode.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
    }

    /**
     * 币种校验格式
     */
    public static HashSet<String> currencySet = new HashSet<String>() {
        {
            add("AUD");//澳大利亚元
            add("CAD");//加拿大元
            add("HKD");//港元
            add("CNY");//人民币
            add("JPY");//日元
            add("USD");//美元
            add("JBP");//英镑
            add("EUR");//欧元
        }
    };

    public static boolean checkValidMtNum(String mtNum) {
        if (StringUtils.isBlank(mtNum)) {
            return false;
        }
        if (Integer.parseInt(mtNum) < 100 || Integer.parseInt(mtNum) > 999) {
            return false;
        }

        return true;
    }

    public static boolean checkValidDate(String date) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        if (!date.matches("[0-9]{2}[0-1][0-9][0-3][0-9]")) {
            return false;
        }
        int month = Integer.valueOf(date.substring(2, 4));
        int day = Integer.valueOf(date.substring(4));
        if (month < 0 || month > 12) {
            return false;
        }
        if (day < 0 || day > 31) {
            return false;
        }
        return true;
    }
    public static boolean checkValidEntryDate(String date) {
        if (StringUtils.isBlank(date)) {
            return false;
        }
        if (!date.matches("([0][1-9])|([1][0-2])([0-2][0-9])|[30,31]")) {
            return false;
        }
        int month = Integer.valueOf(date.substring(2, 4));
        int day = Integer.valueOf(date.substring(4));
        if (month < 0 || month > 12) {
            return false;
        }
        if (day < 0 || day > 31) {
            return false;
        }
        return true;
    }

    public boolean mt103CheckRuleC2(String str) {
        boolean flag = false;
        try {
            List<String> list = new ArrayList<String>();
            list.add("AD");
            list.add("AT");
            list.add("BE");
            list.add("BV");
            list.add("CH");
            list.add("DE");
            list.add("DK");
            list.add("ES");
            list.add("FI");
            list.add("FR");
            list.add("GB");
            list.add("GF");
            list.add("GI");
            list.add("GP");
            list.add("GR");
            list.add("IE");
            list.add("IS");
            list.add("IT");
            list.add("LI");
            list.add("LU");
            list.add("MC");
            list.add("MQ");
            list.add("NL");
            list.add("NO");
            list.add("PM");
            list.add("PT");
            list.add("RE");
            list.add("SE");
            list.add("SJ");
            list.add("SM");
            list.add("TF");
            list.add("VA");
            if (list.contains(str)) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static BaseMessage getInstanceOfBaseMessage(BaseMessage srcMessage, HashMap<String, Class> instanceMap) {
        String txCode = srcMessage.getTxCode();
        if (StringUtils.isNoneBlank(txCode)) {
            Class instanceClass = instanceMap.get(txCode);
            if (instanceClass != null) {
                try {
                    BaseMessage newMessage = (BaseMessage) instanceClass.newInstance();
                    newMessage.copyFromBaseMessage(srcMessage);
                    return newMessage;
                } catch (Exception e) {
                    e.printStackTrace();
                    //获取instance失败
                }
            }
        }
        return srcMessage;
    }

    /**
     * 去除不合法的字符：.,/;’[]\<>?:”“{}|`~!@#$%^&*()_+
     *
     * @param content
     * @return
     */
    public static String removeUnLegalCharacter(String content) {
        String result = content;
        if (StringUtils.isBlank(result)) {
            return result;
        }

        for (String unlegalChar : unLegalCharacterSet) {
            if (StringUtils.isBlank(result)) {
                break;
            }
            int index = result.indexOf(unlegalChar);
            if (-1 != index) {
                result = result.replaceAll(unlegalChar, "");
            }
        }

        result = result.replaceAll("\\.", "");
        result = result.replaceAll("\\+", "");
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("\\]", "");
        result = result.replaceAll("\\/", "");
        result = result.replaceAll("\\(", "");
        result = result.replaceAll("\\)", "");
        result = result.replaceAll("\\*", "");
        result = result.replaceAll("\\{", "");
        result = result.replaceAll("\\}", "");
        result = result.replaceAll("\\?", "");
        result = result.replaceAll("\\|", "");
        result = result.replaceAll("\\^", "");
        result = result.replaceAll("\\$", "");
        result = result.replaceAll("\\\\", "");

        return result;
    }

    /**
     * @param receiverAccount 收款人账户名称
     * @param myAccount       我方账户名称
     * @return
     */
    public static boolean matchReceiverAccountAndMyAccount(String receiverAccount, String myAccount) {
        if (StringUtils.isBlank(receiverAccount) || StringUtils.isBlank(myAccount)) {
            return false;
        }

        String trimReceiverAccount = removeUnLegalCharacter(receiverAccount);
        String trimMyAccount = removeUnLegalCharacter(myAccount);
        if (trimReceiverAccount.length() > 20) {
            trimReceiverAccount = trimReceiverAccount.substring(0, 20);
        }
        if (trimMyAccount.length() > 20) {
            trimMyAccount = trimMyAccount.substring(0, 20);
        }
        return trimReceiverAccount.equalsIgnoreCase(trimMyAccount);
    }

    public static ArrayList<Map.Entry<String, String>> parserGPAStrToTagList(String blockData) {
        ArrayList<Map.Entry<String, String>> localTagList = new ArrayList<Map.Entry<String, String>>();
        String[] datas = org.apache.commons.lang.StringUtils.split(blockData, ":");
        Boolean startFlag = true;
        String tagKey = "";
        String tagValue = "";
        for (String data : datas) {
            if (startFlag) {
                if (StringUtils.startsWith(data, "{")) {
                    tagKey = StringUtils.substring(data, 1);
                    startFlag = false;
                    continue;
                }
                KontException.throwBusinessException(MsgCdEnum.MT_PASER_FAILD);
            } else {
                String[] endDatas;
                String nextTagKey = "";
                String currTagValue = "";
                if (data.contains("{")) {
                    endDatas = StringUtils.split(data, "{");
                    if (endDatas == null || endDatas.length != 2) {
                        KontException.throwBusinessException(MsgCdEnum.MT_PASER_FAILD);
                    }
                    currTagValue = endDatas[0];
                    nextTagKey = endDatas[1];
                } else {
                    currTagValue = data;
                }

                if (org.apache.commons.lang.StringUtils.endsWith(currTagValue, "}")) {
                    tagValue = org.apache.commons.lang.StringUtils.substring(currTagValue, 0, currTagValue.length() - 1);
                    Map.Entry<String, String> tag = new AbstractMap.SimpleEntry<String, String>(tagKey, tagValue);
                    localTagList.add(tag);
                    tagKey = nextTagKey;
                    tagValue = "";
                    continue;
                }
                KontException.throwBusinessException(MsgCdEnum.MT_PASER_FAILD);
            }
        }
        return localTagList;
    }

    public static String deleteEndChangeLineFlag(String data) {
        if (StringUtils.endsWith(data, "\r\n")) {
            return StringUtils.substring(data, 0, data.length() - 2);
        } else if (StringUtils.endsWith(data, "\n") || StringUtils.endsWith(data, "\r")) {
            return StringUtils.substring(data, 0, data.length() - 1);
        } else {
            return data;
        }
    }

    public static String checkAppHeadType(String data) {
        if (StringUtils.startsWith(data, "I")) {
            return MTConstants.APP_HEAD_TYPE_SEND;
        } else if (StringUtils.startsWith(data, "O")) {
            return MTConstants.APP_HEAD_TYPE_RECV;
        } else {
            KontException.throwBusinessException(MsgCdEnum.MT_PARSER_USER_HEAD_FAILD);
            return null;
        }
    }

    /**
     * 650显示接收日期  格式yyMMdd为yyyy/MM/DD
     * @param date
     * @return
     */
    public static String strFormat(String date){
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        String acDate = localDate.toString();
        String recDate = acDate.replace("-", "/");
        return recDate;
    }


}
