package com.hisun.kont.pg.batch;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.service.impl.ListenRmcServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Li ZhiJian
 * @ClassName: BatchACK
 * @Date 2021/7/23 17:21
 * @Description:
 * @Version 1.0
 **/
@Component
public class BatchACK {

    @Resource
    private PgstsService pgstsService;

    @Resource
    private PgstsDao pgstsDao;

    private static final Logger logger = LoggerFactory.getLogger(ListenRmcServiceImpl.class);

    /**
     * 处理发送报文处理结果的批量文件
     */
    public void batchReceiveMsgAck() {
        /** 读取文件内容 */
        File file = new File("D:\\支付项目工作\\批量\\发送ACK\\HKRMC10001_1.txt");
        ArrayList<String> recordList = readBatchFile(file);
        /** 检查文件记录数 */
        if (!checkFileCount(recordList)) {
            logger.error("文件尾部记录数不等于文件内容记录条数！");
            return;
        }
        /** 处理文件 */
        /**
         * record:
         * String mtBatDtStr = str.substring(1, 11);
         * String toSys = str.substring(12, 15);
         * String mtKey = str.substring(15, 37);
         * String mtType = str.substring(37, 40);
         * String status = str.substring(40, 42);
         * trail:
         * String batchDateStr = str.substring(11, 21);
         * String acDateStr = str.substring(21, 31);
         * String acTimeStr = str.substring(31, 37);
         */
        ArrayList<String> ackMtKeyList = new ArrayList<>();
        ArrayList<String> nakMtKeyList = new ArrayList<>();
        for (String record : recordList) {
            if (record.charAt(0) == '1' && "00".equals(record.substring(40, 42))) {
                ackMtKeyList.add(record.substring(15, 37).trim());
            }
            if (record.charAt(0) == '1' && !"00".equals(record.substring(40, 42))) {
                nakMtKeyList.add(record.substring(15, 37).trim());
            }
        }
        if (ackMtKeyList.size() > 0) {
            pgstsService.batchUpdateStatus(ackMtKeyList, "ACK", LocalDateTime.now());
        }
        if (nakMtKeyList.size() > 0) {
            pgstsService.batchUpdateStatus(nakMtKeyList, "NAK", LocalDateTime.now());
        }
    }

    /**
     * 检查批量文件记录数
     * @param records
     * @return
     */
    private boolean checkFileCount(ArrayList<String> records) {
        int count = 0;
        int checkCount = 0;
        for (String record : records) {
            if (record.charAt(0) == '1') {
                count++;
            }
            if (record.charAt(0) == '2') {
                checkCount = Integer.parseInt(record.substring(37, 46));
            }
        }
        return count == checkCount;
    }

    /**
     * 读取批量文件
     * @param file
     * @return
     */
    private ArrayList<String> readBatchFile(File file) {
        ArrayList<String> list = new ArrayList<>();
        FileReader fr = null;
        BufferedReader bfr = null;
        try {
            fr = new FileReader(file);
            bfr = new BufferedReader(fr);
            String record = bfr.readLine();
            while (record != null) {
                list.add(record);
                record = bfr.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfr != null) {
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 生成批量打印格式
     */
    public void generateBatchToTxt(){
        String fileName = "650";
        String filePath = "D:\\temp\\txt";
//        PgstsDO dao = pgstsDao.getByMsgNo("052202107109003034");
        List<PgstsDO> pgstsDOList = pgstsDao.findAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        List<String> result = new ArrayList<>();
        //        拼文件头
        result.add("003260HKPAS80059PASMSG1X");
//        统计脏数据
        int j = 0;
        for (PgstsDO pgstsDO : pgstsDOList) {
            if (JudgeUtils.isEmpty(pgstsDO.getMtMessage())){
                j++;
            }else {
                StringBuilder content= new StringBuilder();
                StringBuffer sb = new StringBuffer();
//        获取打印格式  根据\r\n进行拆分
                String[] split = pgstsDO.getMtMessage().split("\r\n");
                String lineMessage = null;
                String[] mess = new String[split.length];
//        每个字符数组的长度大小为80长度  不满足长度要求  右边用空格补齐
                for (int i = 0; i < split.length; i++) {
                    if (split[i].length() < 80) {
                        lineMessage = StringUtils.rightPad(split[i], 80, " ");
                    }
                    mess[i] = lineMessage;
                }
//        将数组内容拼接
                for (int i = 0; i < mess.length; i++) {
                    sb.append(mess[i]);
                }
                content.append("1")
                        .append("2023/02/07")
                        .append("N")
                        .append("53230207BKR00253")
                        .append(pgstsDO.getMsgNo())
                        .append("S")
                        .append(dateFormat.format(date))
                        .append(pgstsDO.getAhMt())
                        .append(sb.toString());
                result.add(content.toString());
            }

        }
//        拼文件尾
        SimpleDateFormat sbf = new SimpleDateFormat("yyyy/MM/ddHHmmss");
        String dateTime = sbf.format(date);
//        文件数量
        String num = StringUtils.leftPad(String.valueOf(pgstsDOList.size()-j), 9, "0");
        result.add("2HKPAS800592023/02/07" + dateTime + num);
        long start = System.currentTimeMillis();
        BufferedWriter out = null;
        try {
            if (result != null && !result.isEmpty() && JudgeUtils.isNotEmpty(fileName)) {
                fileName += "_" + System.currentTimeMillis() + ".txt";
                File pathFile = new File(filePath);
                if (!pathFile.exists()) {
                    pathFile.mkdirs();
                }
                String relFilePath = filePath + File.separator + fileName;
                File file = new File(relFilePath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
//                //标题头
//                out.write("curr_time,link_id,travel_time,speed,reliabilitycode,link_len,adcode,time_stamp,state,public_rec_time,ds");
//                out.newLine();
                for (String info : result) {
                    out.write(info);
                    out.newLine();
                }
//                logger.info("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
                System.out.println("写入文件耗时：*********************************" + (System.currentTimeMillis() - start) + "毫秒");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
