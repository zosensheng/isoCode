package com.hisun.kont.pg.utils;

import com.hisun.kont.common.utils.JudgeUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParseCodeUtils {

    /**
     * 72域codeword拆解
     *
     * @param F72list
     * @return
     */
    public static LinkedHashMap<String, String> Parse72(List<String> F72list) {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();


        StringBuffer sourceStrbuff = new StringBuffer();
        for (String lenStr : F72list) {
            boolean isFolwFalg = lenStr.startsWith("//");
            if (isFolwFalg) {
                lenStr = lenStr.substring(2, lenStr.length());
            }
            lenStr = lenStr.replaceAll("\\/\\/+", "//");
            sourceStrbuff.append(lenStr);
        }

        String prtSourceStr = sourceStrbuff.toString();
        strToLinkedHashMap(stringStringLinkedHashMap, prtSourceStr);
        return stringStringLinkedHashMap;
    }


    /**
     * 共用方法的抽取
     * @param stringStringLinkedHashMap
     * @param prtSourceStr
     */
    private static void strToLinkedHashMap(LinkedHashMap<String, String> stringStringLinkedHashMap, String prtSourceStr) {
        String[] sourceStrList = prtSourceStr.split("/", -1);
        int flagTip = 0;
        if (!"".equals(sourceStrList[0])) {
            flagTip = 1;
        }
        String codeWordKey = "";
        String codeWordValue = "";
        String lastWordKey = "";
        for (int i = 1; i < sourceStrList.length; i++) {
            String baseStr = sourceStrList[i];

            if (i % 2 != flagTip) {
                if (ChackCode(baseStr) && !"".equals(baseStr)) {
                    codeWordKey = codeWordKey + baseStr;
                    stringStringLinkedHashMap.put(codeWordKey, "");
                } else {
                    //取回上一次
                    String lastValue = stringStringLinkedHashMap.get(lastWordKey);
                    stringStringLinkedHashMap.put(lastWordKey, lastValue + "/" + baseStr);

                    //拨动指针。
                    flagTip = flagTip == 1 ? 0 : 1;

                }
            } else {
                codeWordValue = codeWordValue + baseStr;
                stringStringLinkedHashMap.put(codeWordKey, codeWordValue);
                //保存上一次 code
                lastWordKey = codeWordKey;
                //重置
                codeWordKey = "";
                codeWordValue = "";
            }
        }
    }

    /**
     * 校验code 是否合规，如果不为code则为word。
     *
     * @param str
     * @return
     */
    public static Boolean ChackCode(String str) {
        Boolean flag = true;
        if (str.length() == 0 || str.length() > 8)
            flag = false;
        if (str.indexOf(" ") != -1) {
            flag = false;
        }
        return flag;

    }

    /**
     * 组装72域的CodeWord,入参类型为LinkedHashMap
     *
     * @param codeListMap
     * @return
     */

    public static List<String> AssembleCodeWord(LinkedHashMap<String, String> codeListMap) {
        ArrayList<String> codeWordList = new ArrayList<>();
        //定义一行存储的元素用于判断一行元素是否已经存满
        int end = 35;
        //定义一个值用于计算当前存储的值是否超过一行元素所存储的值
        int index = 0;
        //定义字符的第一位初始化值，用于判断第一位是否为空格,只在循环中使用一次
        int firstChar = 0;
        //上一个字符是否为中文标志
        boolean preCNFlag = false;
        //上一个字符的尾部是否存在空格
        boolean tailCNFlag = false;
        //取出传入的CodeWord数据
        for (Map.Entry<String, String> entry : codeListMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            String key = entry.getKey();
            //获取key的大小
            int keyLength = key.length();
            String value = entry.getValue();
            char[] chars = value.toCharArray();
            //先将key拼接，生成Code并将加上Code的大小生成存储一行数据为35的word的初始值
            String codeKey = "/" + key + "/";
            stringBuilder.append(codeKey);
            index += codeKey.length();
            //判断当前Code所对应的Word的值是空的
            if(JudgeUtils.isBlank(value)){
                //如果为空将index的值还原为原始状态,
                index=0;
            }
            //循环遍历字符串
            for (int i = 0; i < value.length(); i++) {
                //判断StringBuilder中是否存储第一个元素的开始和结束都为/，并且行首存储的第一个字符是否为中文，如果为中文将前趋标志为true让行首中文存四位
                if ((stringBuilder.toString().endsWith("/")&&stringBuilder.toString().startsWith("/"))
                        &&ChineseWrapUtils.isChinese(chars[i])) {
                    stringBuilder.append(chars[i]);
                    //stringBuilder.append("yyyy");
                    index += 4;
                    preCNFlag = true;
                    continue;
                }
                //判断当前行是否已经满,如果一行数据已经存满，就先将这一行数据存储到list集合中，开始取第二行数据
                if (index < end) {
                    //判断一些特殊情况及末尾情况的处理
                    //例如每行存储35个字符，当前一位不为中文，当存储到26,27，28，29时会出现一些特殊情况应在字符前拼接空格
                    if (!preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 6) == index
                            || !preCNFlag && index == (end - 5) && ChineseWrapUtils.isChinese(chars[i])
                            || !preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 7) == index
                            || !preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 8) == index
                            || !preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 9) == index
                    ) {
                        //stringBuilder.append(" " + "yyyy");
                        stringBuilder.append(chars[i]);
                        index += 5;
                        preCNFlag = true;
                        continue;
                    }
                    //行尾，当前面的一位为中文且后面存在空格时，当前需要存的字符为中文，前后都不加空格，为四位。
                    if (preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 6) == index && tailCNFlag
                            || preCNFlag && index == (end - 5) && ChineseWrapUtils.isChinese(chars[i]) && tailCNFlag
                    ) {
                        //stringBuilder.append("yyyy");
                        stringBuilder.append(chars[i]);
                        index += 4;
                        preCNFlag = true;
                        tailCNFlag = false;
                        continue;
                    }
                    //前面的一位为中文字符且后面没有拼接空格，并且当前要记录为中文字符，需要在拼接前在字符前面添加一个空格，记录为5位
                    if (preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 6) == index && !tailCNFlag
                            || preCNFlag && index == (end - 5) && ChineseWrapUtils.isChinese(chars[i]) && !tailCNFlag
                    ) {
                        //stringBuilder.append(" " + "yyyy");
                        stringBuilder.append(chars[i]);
                        index += 5;
                        preCNFlag = true;
                        continue;
                    }
                    //如果前面的字符是中文并且要进行存储的是中文且上个字符尾部不为空格就必须保证要有5个字符的位置否则换行
                    if (preCNFlag && (end - index) >= 5 && ChineseWrapUtils.isChinese(chars[i]) && !tailCNFlag) {
                        //stringBuilder.append(" ").append("yyyy");
                        stringBuilder.append(chars[i]);
                        index += 5;
                        preCNFlag = true;
                        //如果前面的字符不是中文且当前要存储的是中文就要保留6位字符的位置，并设置该字符尾部的标志为true
                    } else if (!preCNFlag && end - index >= 6 && ChineseWrapUtils.isChinese(chars[i])) {
                        //stringBuilder.append(" ").append("yyyy").append(" ");
                        stringBuilder.append(chars[i]);
                        index += 6;
                        preCNFlag = true;
                        tailCNFlag = true;
                        //当前存储的为中文，并且其尾部存在空格，存储的位置必须保证要有四位字符的位置
                    } else if (preCNFlag && (end - index) >= 4 && ChineseWrapUtils.isChinese(chars[i]) && tailCNFlag) {
                        //stringBuilder.append("yyyy");
                        stringBuilder.append(chars[i]);
                        index += 4;
                        preCNFlag = true;
                        tailCNFlag = false;
                        //如果当前不为中文，且上一位也不为中文，直接拼接上字符串长度加一
                    } else if (!ChineseWrapUtils.isChinese(chars[i]) && !preCNFlag) {
                        //stringBuilder.append(chars[i]);
                        stringBuilder.append(chars[i]);
                        index++;
                        preCNFlag = false;
                        //当前存储的为非中文且前一位为中文后面不带空格，自己拼接的时候要添加上一个空格，记两个字符
                    } else if (!ChineseWrapUtils.isChinese(chars[i]) && (end - index) >= 2 && preCNFlag && !tailCNFlag) {
                        //stringBuilder.append(" " + chars[i]);
                        stringBuilder.append(chars[i]);
                        index += 2;
                        preCNFlag = false;
                        //当前存储的为中文且前一位中文中文字符后有空格，有位置直接添加
                    } else if (!ChineseWrapUtils.isChinese(chars[i]) && (end - index) >= 1 && preCNFlag && tailCNFlag) {
                        //stringBuilder.append(chars[i]);
                        stringBuilder.append(chars[i]);
                        index++;
                        preCNFlag = false;
                        tailCNFlag = false;
                    } else {
                        //此处表示要存储但是存储中文和非中文位置都已不足只能存储到下一行
                        codeWordList.add(stringBuilder.toString());
                        //一行数据已经存满改变为初始值，继续存储下一行数据。
                        stringBuilder = new StringBuilder();
                        //因为当前存储的是word的附加信息所以要以//开头
                        stringBuilder.append("//");
                        index = 2;
                        preCNFlag = false;
                        //判断第一个存储的字符是否为中文,如果为中文要把标记为true,表示转换后前面不带空格。
                        if (ChineseWrapUtils.isChinese(chars[i])) {
                            //stringBuilder.append("yyyy");
                            stringBuilder.append(chars[i]);
                            index += 4;
                            preCNFlag = true;
                        } else {
                            stringBuilder.append(chars[i]);
                            index++;
                        }
                    }
                } else {
                    codeWordList.add(stringBuilder.toString());
                    //一行数据已经存满改变为初始值，继续存储下一行数据。
                    stringBuilder = new StringBuilder();
                    //因为当前存储的是word的附加信息所以要以//开头
                    stringBuilder.append("//");
                    index = 2;
                    preCNFlag = false;
                    tailCNFlag=false;
                    //判断第一个存储的字符是否为中文,如果为中文要把标记为true,表示转换后前面不带空格。
                    if (ChineseWrapUtils.isChinese(chars[i])) {
                        //stringBuilder.append("yyyy");
                        stringBuilder.append(chars[i]);
                        index += 4;
                        preCNFlag = true;
                        tailCNFlag=false;
                    } else {
                        stringBuilder.append(chars[i]);
                        index++;
                    }
                }
            }
            //如果最后一行或者是只有一行且数据超不过35位,上面的不能走到存储，这里需要进行判断一下StringBuilder中是否存在值。
            if (JudgeUtils.isNotBlank(stringBuilder.toString())) {
                codeWordList.add(stringBuilder.toString());
                //把最后一行存取之后，由于是对map集合的循环遍历，一次之后还会继续循环，不会跳出，必须把index初始化
                index = 0;
            }

        }
        return codeWordList;
    }

    /**
     * 组装72域的CodeWord,入参类型为一整串字符
     * @param codeWordStr
     * @return
     */
    public static List<String> AssembleCodeWord(String codeWordStr) {
        LinkedHashMap<String, String> stringStringLinkedHashMap = new LinkedHashMap<>();
        strToLinkedHashMap(stringStringLinkedHashMap, codeWordStr);
        List<String> list = ParseCodeUtils.AssembleCodeWord(stringStringLinkedHashMap);
        return list;
    }
}
