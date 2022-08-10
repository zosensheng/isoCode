package com.hisun.kont.pg.utils;

import com.alibaba.fastjson.JSONObject;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author yupeifeng
 * @ClassName: AssembleUtils
 * @Date 2021/11/29
 **/
public class AssembleUtils {
    private static final Logger logger = LoggerFactory.getLogger(AssembleUtils.class);

    /**
     * 功能描述： 获取一个json格式的string
     * 一个个字符扫描，判断是否含有中文，返回中文标识
     *
     * @param fmt
     * @return
     */
    public static <T> String getCnFlag(T fmt) {
        logger.info("##### START TO JUDGE WHETHER THE MESSAGE CONTAINS CHINESE #####");
        Object json = JSONObject.toJSON(fmt);
        String jsonString = json.toString();
        //中文标识 预设string不含中文
        String cnFlag = "N";
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        String str = null;
        try {
            str = new String(jsonString.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("##### JSON GET BYTES ERROR:{}",str);
            KontException.throwKontException(MTConstants.STRING_TOJSON_IS_ERROR);
        }
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            //中文字节长度大于三
            int length = String.valueOf(c).getBytes().length;
            if (length > 1) {
                cnFlag = "Y";
                break;
            } else {
                //正则匹配特殊字(一个汉字对应两个utf-8编码)
                if (i != str.length() - 1) {
                    if (Pattern.matches(pattern, String.valueOf(c))) {
                        if (Pattern.matches(pattern2, String.valueOf(str.charAt(i + 1)))) {
                            cnFlag = "Y";
                            break;
                        }
                    }
                }
            }
        }
        logger.info("##### END TO JUDGE WHETHER THE MESSAGE CONTAINS CHINESE #####");
        return cnFlag;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("//3111100723+0000");
        list.add("//ACSP/G002");
        list.add("//BKCHHKH0XXX/BKCHHKH0XXX/INDA");
        list.add("//USD77011,01/SHA");
        list.add("//:71F:USD0,");
        list.add("//:71F:USD50,");
        GpiF79DTO f79Value = getF79Value(list);
        System.out.println(f79Value);
    }
    /**
     * gpi199的79域拆解
     *
     * @param list
     * @return
     */
    public static GpiF79DTO getF79Value(List<String> list) {
        GpiF79DTO gpiF79DTO = new GpiF79DTO();
        if (list.size()>=4){
            logger.info("##### START TO DISASSEMBLY GPI N99 F79 FIELD FIRST LINE #####");
            String lineOne = list.get(0);
            if (lineOne.length() >= 12) {
                String gpiDate = lineOne.substring(2, 8);
                String gpiTime = lineOne.substring(8, 12);
                gpiF79DTO.setGpiDate(gpiDate);
                gpiF79DTO.setGpiTime(gpiTime);
                if (lineOne.length() == 17){
                    String gpiZone = lineOne.substring(12, 17);
                    gpiF79DTO.setGpiZone(gpiZone);
                }
            }

            logger.info("##### START TO DISASSEMBLY GPI N99 F79 FIELD SECOND LINE #####");
            String lineTwo = list.get(1);
            String gpiStatus = null;
            String gpiReasonCode = null;
            if (lineTwo.length() == 6) {
                gpiStatus = lineTwo.substring(2, 6);
            } else if (lineTwo.length() == 11) {
                gpiStatus = lineTwo.substring(2, 6);
                gpiReasonCode = lineTwo.substring(7, 11);
            }
            gpiF79DTO.setGpiStatus(gpiStatus);
            gpiF79DTO.setGpiReasonCode(gpiReasonCode);

            logger.info("##### START TO DISASSEMBLY GPI N99 F79 FIELD THIRD LINE #####");
            String lineThree = list.get(2);
            if (lineThree.length() >= 13) {
                String oriBic = null;
                oriBic = lineThree.substring(2, 13);
                gpiF79DTO.setStatusOriBic(oriBic);
            }

            logger.info("##### START TO DISASSEMBLY GPI N99 F79 FIELD FORTH LINE #####");
            String lineFour = list.get(3);
            if (lineFour.length() > 5) {
                String f32ACur = null;
                String f32AAmt = null;
                String f32AChargeFlag = null;
                f32ACur = lineFour.substring(2, 5);
                if ("/".equals(lineFour.substring(lineFour.length() - 4, lineFour.length() - 3))) {
                    f32AAmt = lineFour.substring(5, lineFour.length() - 4);
                    f32AChargeFlag = lineFour.substring(lineFour.length() - 3, lineFour.length());
                } else {
                    f32AAmt = lineFour.substring(5, lineFour.length());
                }
                //金额格式长度不超过15
                if (f32AAmt.length() > 15) {
                    logger.error("##### GPIN99 F79 f32AAmt is more than 15 #####");
                }
                gpiF79DTO.setF32ACur(f32ACur);
                gpiF79DTO.setF32Amount(f32AAmt);
                gpiF79DTO.setF32AChargeFlag(f32AChargeFlag);
            }
        }

        logger.info("##### END TO DISASSEMBLY GPI N99 F79 FIELD FIRST LINE #####");
        //第五行 第六行 不固定 没有顺序 可能不存在  需要判断
        if (list.size() > 4) {
            String exType = null;
            String oriCYY = null;
            String tarCYY = null;
            String exRate = null;
            String f71fChargeCur = null;
            String f71fChargeAmt = null;
            List<GpiF71fDo> gpiF71fDos = new ArrayList<>();
            //判断含有 EXCH 开头的为第五行   :71F:可能出现不止一次
            logger.info("##### START TO DISASSEMBLY GPI N99 F79 FIELD FIFTH LINE #####");
            for (String line : list) {
                if (line.length() > 8) {
                    String subStrFifth = line.substring(2, 6);
                    String subStrSixth = line.substring(2, 7);
                    if ("EXCH".equals(subStrFifth)) {
                        exType = subStrFifth;
                        oriCYY = line.substring(8, 11);
                        tarCYY = line.substring(12, 15);
                        exRate = line.substring(16, line.length());
                        if (exRate.length() > 12) {
                            logger.error("##### GPIN99 F79 exRate is more than 12 #####");
                        }
                    } else if (":71F:".equals(subStrSixth)) {
                        GpiF71fDo gpiF71fDo = new GpiF71fDo();
                        f71fChargeCur = line.substring(7, 10);
                        f71fChargeAmt = line.substring(10, line.length());
                        //金额格式长度不超过15
                        if (f71fChargeAmt.length() > 15) {
                            logger.error("##### GPIN99 F79 f71fChargeAmt is more than 15 #####");
                        }
                        gpiF71fDo.setF71fChargeAmt(f71fChargeAmt);
                        gpiF71fDo.setF71fChargeCur(f71fChargeCur);
                        gpiF71fDos.add(gpiF71fDo);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            gpiF79DTO.setExType(exType);
            gpiF79DTO.setOriCYY(oriCYY);
            gpiF79DTO.setTarCYY(tarCYY);
            gpiF79DTO.setExRate(exRate);
            gpiF79DTO.setF71fList(gpiF71fDos);
            logger.info("##### END TO DISASSEMBLY GPI N99 F79 FIELD FIFTH AND SIXTH LINE #####");
            return gpiF79DTO;
        } else {
            logger.info("##### END TO DISASSEMBLY GPI N99 F79 FIELD #####");
            return gpiF79DTO;
        }
    }

    /**
     * 650格式(暂不入库)补充
     *
     * @param mtStatus 报文状态
     * @return
     */
    public static String assembleStr650(String mtStatus, String rejectedReason) {
        String status = null;
        StringBuilder str650 = new StringBuilder();
        BaseMessage baseMessage = new BaseMessage();
        if ("ACK".equals(mtStatus)) {
            status = "AK";
        } else if ("NAK".equals(mtStatus)) {
            status = "NK";
        }
        if ("AK".equals(status) || "NK".equals(status)) {
            str650.append(baseMessage.printFormatDefine("STATUS", status));
        }
        if ("NK".equals(status)) {
            if (JudgeUtils.isNotNull(rejectedReason)){
                str650.append(baseMessage.printFormatDefine("REASON", rejectedReason));
            }else {
                str650.append(baseMessage.printFormatDefine("REASON", ""));
            }
        }
        return str650.toString();
    }

    /**
     * 汇入接收的报文类型
     */
    public static HashMap<String, String> incomeSupportType = new HashMap<String, String>() {{
        put("MT103","SINGLE CUSTOMER CREDIT TRANSFER");
//        put("MT110","Advice of Cheque(s)");
//        put("MT111","Request for Stop Payment of a Cheque");
//        put("MT112","Status of a Request for Stop Payment of a Chequ");
        put("MT190","Advice of Charges, Interest and Other Adjustments");
        put("MT191","Request for Payment of Charges, Interest and Other Expenses");
        put("MT192","Request for Cancellation");
//        put("MT195","Queries");
//        put("MT196","Answers");
        put("MT199","Free Format Message");
        put("MT200","Financial Institution Transfer for its Own Account");
//        put("MT201","Multiple Financial Institution Transfer for its Own Account");
        put("MT202","General Financial Institution Transfer");
//        put("MT203","Multiple General Financial Institution Transfer");
//        put("MT205","Financial Institution Transfer Execution");
        put("MT210","Notice to Receive");
        put("MT290","Advice of Charges, Interest and Other Adjustments");
        put("MT291","Request for Payment of Charges, Interest and Other Expenses");
        put("MT292","Request for Cancellation");
//        put("MT295","Queries");
//        put("MT296","Answers");
        put("MT299","Free Format Message");
//        put("MT395","Queries");
//        put("MT396","Answers");
//        put("MT399","Free Format Message");
//        put("MT400","Advice of Payment");
//        put("MT410","Acknowledgement");
//        put("MT412","Advice of Acceptance");
//        put("MT416","Advice of Non-Payment/Non-Acceptance");
//        put("MT420","Tracer");
//        put("MT422","Advice of Fate and Request for Instructions");
//        put("MT430","Amendment of Instructions");
//        put("MT450","Cash Letter Credit Advice");
//        put("MT455","Cash Letter Credit Adjustment Advice");
//        put("MT456","Advice of Dishonour");
//        put("MT491","Request for Payment of Charges, Interest and Other Expenses");
//        put("MT492","Request for Cancellatio");
//        put("MT495","Queries");
//        put("MT496","Answers");
//        put("MT499","Free Format Message");
//        put("MT595","Queries");
//        put("MT596","Answers");
//        put("MT599","Free Format Message");
//        put("MT695","Queries");
//        put("MT696","Answers");
//        put("MT699","Free Format Message");
//        put("MT701","Issue of a Documentary Credit");
//        put("MT795","Queries");
//        put("MT796","Answers");
//        put("MT895","Queries");
//        put("MT896","Answers");
//        put("MT899","Free Format Message");
        put("MT900","Confirmation of Debit");
        put("MT910","Confirmation of Credit");
//        put("MT940","Customer Statement Message");
//        put("MT950","Statement Message");
//        put("MT995","Queries");
//        put("MT996","Answers");
//        put("MT999","Free Format Message");
//        put("MTN99","  ");
    }};

    /**
     *  找出str中存在的中文
     * @param cnData
     * @return
     */
    public static List<String> findCnData(String cnData) {
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        StringBuilder sb = null;
        List<String> list = new ArrayList<>();
        try {
            cnData = new String(cnData.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            KontException.throwKontException(MTConstants.STRING_TOJSON_IS_ERROR);
        }
        char c;
        for (int i = 0; i < cnData.length(); i++) {
            c = cnData.charAt(i);
            int byteLength = String.valueOf(c).getBytes().length;
            //中文字符字节长度大于1  非中文字符字节长度等于1
            if (byteLength > 1) {
                list.add(String.valueOf(c));
            } else {
                String str = String.valueOf(c);
                if (Pattern.matches(pattern, str)) {
                    //前导代理 [\uD800-\uDBFF]
                    sb = new StringBuilder();
                    sb.append(str);
                } else if (Pattern.matches(pattern2, str)) {
                    //后导代理 [\uDC00-\uDFFF]
                    sb.append(str);
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}
