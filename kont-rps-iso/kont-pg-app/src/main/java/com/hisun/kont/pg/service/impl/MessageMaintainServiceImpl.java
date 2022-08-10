package com.hisun.kont.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.framework.utils.PageUtils;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.DismantleMTService;
import com.hisun.kont.pg.service.MessageMaintainService;
import com.hisun.kont.pg.service.PgstpswftoteleService;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.utils.*;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.tag.*;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class MessageMaintainServiceImpl implements MessageMaintainService {
    private static final Logger log = LoggerFactory.getLogger(MessageMaintainServiceImpl.class);

    @Resource
    private PgstsDao pgstsDao;

    @Resource
    private MTAssemblyServiceImpl mtAssemblyService;

    @Resource
    private DismantleMTService dismantleMTService;

    @Resource
    private PgstpswftoteleService pgstpswftoteleService;

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    PgstsService pgstsService;

    @Resource
    private PgMatchServiceImpl pgMatchService;

    /**
     * 根据报文编号和组装内容生成报文打印格式
     *
     * @param reqDto 报文编号和组装内容
     * @return 报文打印格式
     */
    @Override
    public GenericRspDTO<PrintMessageRspDTO> printMTMessage(GenericDTO<PrintMessageReqDTO> reqDto) {
        GenericRspDTO<PrintMessageRspDTO> rspDto = new GenericRspDTO<>();
        PrintMessageRspDTO printMessageRspDTO = new PrintMessageRspDTO();
        PrintMessageReqDTO reqDtoBOdy = reqDto.getBody();
        PgstsDO pgstsDO = pgstsDao.getByMsgNo(reqDtoBOdy.getMsgNo());
        //拆解报文 获得头部信息  todo 这里需要优化
        String mtStr = pgstsDO.getMtStr();
        BaseMessage baseMessage = dismantleMTService.dismantleMT(mtStr);
        String ohGpcFlg = null;
        if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())) {
            //111域
            ohGpcFlg = baseMessage.getUserHeaderBlock().getOhGpcFlg();
        }
        String appHeaderMessage = null;
        if (JudgeUtils.isNotNull(baseMessage.getAppHeaderBlock())) {
            //2头信息
            appHeaderMessage = baseMessage.getAppHeaderBlock().toMTMessage();
        }
        ReqHead reqIgwHead = reqDto.getBody().getReqHead();
        ReqHead reqHead = new ReqHead();
        reqHead.setTxnCode("23650");
        reqHead.setBranchCode(reqIgwHead.getBranchCode());
        reqHead.setBankCode(reqIgwHead.getBankCode());
        reqHead.setAcDate(reqIgwHead.getAcDate());
        String receiveName = mtAssemblyService.getBankName(pgstsDO.getAhRcvlt(),reqHead);
        String senderName = mtAssemblyService.getBankName(pgstsDO.getBhSndlt(),reqHead);
        Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
        String message = TeleCh650Util.orgMessageTo650(reqDtoBOdy.getMessage(), reqDtoBOdy.getMsgNo(),
                pgstsDO.getAhMt(), pgstsDO.getBhSndlt(), senderName, receiveName,
                pgstsDO.getAhRcvlt(), map, pgstsDO.getMtStatus(), pgstsDO.getOhGpiRef(), ohGpcFlg, appHeaderMessage);
        log.info("Swift message print format: \n" + message);
        printMessageRspDTO.setMessage(message);
        rspDto.setBody(printMessageRspDTO);
        return rspDto;
    }

    /**
     * 根据报文编号生成报文打印格式
     *
     * @param reqDto 报文编号
     * @return 报文打印格式
     */
    @Override
    public GenericRspDTO<GetPrintMessageByNoRspDTO> getPrintMessageByNo(GenericDTO<GetPrintMessageByNoReqDTO> reqDto) {
        log.info("##### START TO GET 23650 FROM PG #####");
        GenericRspDTO<GetPrintMessageByNoRspDTO> rspDto = new GenericRspDTO<>();
        GetPrintMessageByNoRspDTO printMessageByNoRspDTO = new GetPrintMessageByNoRspDTO();
        String msgNo = reqDto.getBody().getMsgNo();
        PgstsDO pgstsDO = pgstsDao.get(msgNo);
        if (JudgeUtils.isNull(pgstsDO)) {
            log.error("##### NO RECORD FROM PG,MSGNO:{}",msgNo);
            KontException.throwBusinessException(MTConstants.MT_PRINT_MSGNO_IS_EMPTY);
        } else {
            if(JudgeUtils.isNull(pgstsDO.getMtMessage())){
                printMessageByNoRspDTO.setOrgMessage(pgstsDO.getMtMessage());
                printMessageByNoRspDTO.setMessage(pgstsDO.getMtMessage());
                printMessageByNoRspDTO.setMtStr(pgstsDO.getMtStr());
                printMessageByNoRspDTO.setMsgSrc(pgstsDO.getMsgSrc());
                rspDto.setBody(printMessageByNoRspDTO);
                return rspDto;
            }
            String orgMessage = pgstsDO.getMtMessage();
            Map<String, String> map = mtAssemblyService.getTagDescribe(pgstsDO);
            StringBuilder str650 = new StringBuilder();
            //查询此电文是否带账  是否有止付报文 回复报文  关联报文
            String matchMessage650 = commonAssemble.getMatchMessage(pgstsDO.getMsgNo());
            str650.append(matchMessage650);
            //报文状态为ACK更改为AK  NCK为NK  NK需要打印NK原因
            String ack650 = AssembleUtils.assembleStr650(pgstsDO.getMtStatus(), pgstsDO.getRejectedReason());
            str650.append(ack650);
            str650.append(orgMessage);
            //获取电码转中文的打印格式
            String message = TeleCh650Util.newMessageTo650(str650.toString(),pgstsDO.getMtStr(),pgstsDO.getAhMt(),map);
            log.info("##### SWIFT ORIGINAL MESSAGE PRINTING FORMAT ##### \n" + str650.toString());
            log.info("##### SWIFT MESSAGE PRINTING FORMAT ##### \n" + message);
            //650页面显示还是电码
            printMessageByNoRspDTO.setOrgMessage(str650.toString());
            printMessageByNoRspDTO.setMessage(message);
            printMessageByNoRspDTO.setMtStr(pgstsDO.getMtStr());
            printMessageByNoRspDTO.setMsgSrc(pgstsDO.getMsgSrc());
            rspDto.setBody(printMessageByNoRspDTO);
        }
        return rspDto;
    }

    /**
     * 查询报文历史记录
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<QueryMsgHisRecdRspDTO> queryMsgHisRecd(GenericDTO<QueryMsgHisRecdReqDTO> reqDto) {
        log.info("##### START TO GET MESSAGE HISTORY #####");
        GenericRspDTO<QueryMsgHisRecdRspDTO> rspDTO = new GenericRspDTO<>();
        QueryMsgHisRecdReqDTO msgHisRecdRepDTO = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        BeanUtils.copyProperties(msgHisRecdRepDTO, pgstsDO);
        //startDateTime开始日期 endDateTime 结束日期 根据时间范围查询
        if (JudgeUtils.isNotNull(msgHisRecdRepDTO.getStartDateTime())&&JudgeUtils.isNotNull(msgHisRecdRepDTO.getEndDateTime())){
            pgstsDO.setCreatedTime(msgHisRecdRepDTO.getStartDateTime());
            pgstsDO.setUpdateLastTime(msgHisRecdRepDTO.getEndDateTime());
        }
        //分页查询 加时间 筛选
        QueryMsgHisRecdRspDTO rspDtoBody = PageUtils.queryPage(msgHisRecdRepDTO, QueryMsgHisRecdRspDTO.class, MsgHisRecdDO.class,
                true, () -> this.pgstsDao.findListByDate(pgstsDO));
        rspDTO.setBody(rspDtoBody);
        log.info("##### END TO GET MESSAGE HISTORY #####");
        return rspDTO;
    }

    /**
     * 根据报文编号返回报文的具体详情
     *
     * @param reqDto 报文编号
     * @return 报文详情
     */
    @Override
    public GenericRspDTO<QueryMsgHisRecdByNoRspDTO> queryMsgHisRecdByNo(GenericDTO<QueryMsgHisRecdByNoReqDTO> reqDto) {
        GenericRspDTO<QueryMsgHisRecdByNoRspDTO> rspDTO = new GenericRspDTO<>();
        PgstsDO pgstsDO = pgstsDao.get(reqDto.getBody().getMsgNo());
        QueryMsgHisRecdByNoRspDTO msgHisRecdByNoRspDTO = new QueryMsgHisRecdByNoRspDTO();
        BeanUtils.copyProperties(pgstsDO, msgHisRecdByNoRspDTO);
        rspDTO.setBody(msgHisRecdByNoRspDTO);
        return rspDTO;
    }

    /**
     * 根据20域查询关联的gpi报文
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<QueryGpiMsgRspDTO> queryGpiMsg(GenericDTO<F20> reqDto) {
        GenericRspDTO<QueryGpiMsgRspDTO> rspDTO = new GenericRspDTO<>();
        String trn = reqDto.getBody().getTrn();
        List<PgstsDO> pgstsDOs = new ArrayList<>();
        List<GpiMsgRspDTO> msgRspDTOList = new ArrayList<>();
        //查询所有报文
        List<PgstsDO> pgstsDOList = pgstsDao.findAll();
        for (PgstsDO aDo : pgstsDOList) {
            if (JudgeUtils.isNotNull(aDo.getRtrn())) {
                //判断报文的21域与输入的业务编号是否相同
                if (aDo.getRtrn().equals(trn)) {
                    GpiMsgRspDTO gpiMsgRspDTO = new GpiMsgRspDTO();
                    BeanUtils.copyProperties(aDo, gpiMsgRspDTO);
                    LocalDateTime createdTime = aDo.getCreatedTime();
                    gpiMsgRspDTO.setCreateTime(createdTime);
                    msgRspDTOList.add(gpiMsgRspDTO);
                    pgstsDOs.add(aDo);
                }
            }
        }
        //按时间排序
        Collections.sort(msgRspDTOList, new Comparator<GpiMsgRspDTO>() {
            @Override
            public int compare(GpiMsgRspDTO o1, GpiMsgRspDTO o2) {
                if (o1.getCreateTime().isAfter(o2.getCreateTime())) {
                    return 1;
                }
                return -1;
            }
        });
        QueryGpiMsgRspDTO queryGpiMsgRspDTO = new QueryGpiMsgRspDTO();
        queryGpiMsgRspDTO.setGpiMsgRspDTOs(msgRspDTOList);
        rspDTO.setBody(queryGpiMsgRspDTO);
        return rspDTO;
    }

    /**
     * 中文转电码
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<CnToTeleNumRspDTO> cnToTeleNum(GenericDTO<CnToTeleNumReqDTO> reqDto) {
        GenericRspDTO<CnToTeleNumRspDTO> rspDTO = new GenericRspDTO<>();
        CnToTeleNumRspDTO cn = new CnToTeleNumRspDTO();
        String inputData = reqDto.getBody().getInputData();
        String traditionalFlag = reqDto.getBody().getTraditionalFlag();
        log.info("##### START TO CHINESE TO TELE,INPUT DATA:{}",inputData);
        log.info("##### TRADITIONAL FLAG:{}",traditionalFlag);
        if (JudgeUtils.isNull(traditionalFlag)){
            log.error("##### TRADITIONAL FLAG IS NULL #####");
            rspDTO.setMsgCd(MTConstants.TRADITONAL_FLAG_IS_NULL);
            return rspDTO;
        }
        //输入的字符为空
        if (JudgeUtils.isNull(inputData)) {
            cn.setReturnCode("00418");
            rspDTO.setBody(cn);
            return rspDTO;
        }
        String tagChToTele = null;
        try {
            tagChToTele = pgstpswftoteleService.getStringCnToTele(inputData, traditionalFlag);
        } catch (Exception e) {
            log.error("##### CHINESE WITH CONVERSION EXCEPTION #####");
            rspDTO.setMsgCd(MTConstants.CN_TO_TELENUM_ERROR);
            return rspDTO;
        }
        log.info("##### OUTPUT DATA:{}",tagChToTele);
        //找不到电码
        if ("00419".equals(tagChToTele)) {
            cn.setReturnCode(tagChToTele);
            rspDTO.setBody(cn);
            return rspDTO;
        }
        //输出长度超过300
        if (tagChToTele.length()>300){
            cn.setReturnCode("00421");
            rspDTO.setBody(cn);
            return rspDTO;
        }
        cn.setOutputData(tagChToTele);
        cn.setOutputLength(tagChToTele.length());
        cn.setReturnCode("00000");
        rspDTO.setBody(cn);
        log.info("##### END TO CHINESE TO TELE #####");
        return rspDTO;
    }

    /**
     * 根据业务编号去查询103报文
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<QueryMsgByOurRefRspDTO> queryMsgByOurRef(GenericDTO<QueryMsgByOurRefReqDTO> reqDto) {
        String ourRef = reqDto.getBody().getOurRef();
        PgstsDO pgDo = new PgstsDO();
        pgDo.setTrn(ourRef);
        pgDo.setAhMt("103");
        List<PgstsDO> pgstsDOList = pgstsDao.findList(pgDo);
        List<PgstsDO> pgList = new ArrayList<>();
        //按时间排序
        Collections.sort(pgstsDOList, new Comparator<PgstsDO>() {
            @Override
            public int compare(PgstsDO o1, PgstsDO o2) {
                if (o1.getCreatedTime().isBefore(o2.getCreatedTime())) {
                    return 1;
                }
                return -1;
            }
        });
        GenericRspDTO<QueryMsgByOurRefRspDTO> rspDTO = new GenericRspDTO<>();
        QueryMsgByOurRefRspDTO queryMsgByOurRefRspDTO = new QueryMsgByOurRefRspDTO();
        List<MsgBlock> msgBlockList = new ArrayList<>();
        if (pgstsDOList.size() > 0) {
            queryMsgByOurRefRspDTO.setReturnCode("000");
            for (PgstsDO pgstsDO : pgstsDOList) {
                if (pgList.size() >= 99) {
                    break;
                }
                pgList.add(pgstsDO);
                MsgBlock msgBlock = new MsgBlock();
                msgBlock.setMsgNo(pgstsDO.getMsgNo());
                msgBlock.setMsgType(pgstsDO.getAhMt());
                msgBlockList.add(msgBlock);
            }
            queryMsgByOurRefRspDTO.setMsgCount(pgList.size());
            queryMsgByOurRefRspDTO.setMsgBlockList(msgBlockList);
        } else {
            queryMsgByOurRefRspDTO.setReturnCode("010");
        }
        rspDTO.setBody(queryMsgByOurRefRspDTO);
        return rspDTO;
    }

    /**
     * 字符串的中文折行
     *
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<CnLineWrapRspDTO> cnLineWrap(GenericDTO<CnLineWrapReqDTO> reqDto) {
        log.info("***{}***{}","cnLineWrap","***start***");
        //定义返回对象
        GenericRspDTO<CnLineWrapRspDTO> rspDTO = new GenericRspDTO<>();
        CnLineWrapRspDTO cnLineWrapRspDTO = new CnLineWrapRspDTO();
        //获取请求的数据
        CnLineWrapReqDTO cnLineWrapReqDTO = reqDto.getBody();
        //获取需要中文折行的数据
        String cnLineWrapStr = cnLineWrapReqDTO.getInputData();

        //如果输入数据为空，则设置检查结束标记
        if (JudgeUtils.isBlank(cnLineWrapStr)) {
            cnLineWrapRspDTO.setReturnCode("00851");
            rspDTO.setBody(cnLineWrapRspDTO);
            return rspDTO;
        }
        //获取检查类型
        String checkType = cnLineWrapReqDTO.getCheckType();

        //将字符串中的连续空格进行压缩
        String cnLineData = cnLineWrapStr.replaceAll("\\s+", " ");
        char[] chars = cnLineData.toCharArray();


        //上一个字符是否为中文标志
        boolean preCNFlag = false;


        //上一个字符的尾部是否存在空格
        boolean tailSpaceFlag = false;


        //定义字符的第一位初始化值，用于判断第一位是否为空格
        int firstChar = 0;

        //用于拼接一行字符串
        StringBuilder stringBuilder = new StringBuilder();

        //存储折行后的字符串集合
        ArrayList<String> list = new ArrayList<>();

        //定义一个index,用于记录这一行数据的数量
        int index = 0;
        int end;
        //定义一个end，用于记录一行要存储的数量，根据检查类型来确定一行字符串的大小
        if ("F".compareTo(checkType) == 0) {
            end = 35;
        } else if ("A".compareTo(checkType) == 0) {
            end = 33;
        } else {
            cnLineWrapRspDTO.setReturnCode("00851");
            rspDTO.setBody(cnLineWrapRspDTO);
            return rspDTO;
        }
        log.info("###{}###{}","Traversal string","---start---");
        //循环遍历字符串
        for (int i = 0; i < cnLineData.length(); i++) {
            //判断当前整体字符串的第一位是否为空格，如果为空格跳过这一次循环
            if (JudgeUtils.isBlank(Character.toString(chars[firstChar]))) {
                firstChar++;
                continue;
            }
            //判断StringBuilder中是否存储数据，并且行首存储的第一个字符是否为中文，如果为中文将前趋标志为true让行首中文存四位（执行一次）
            if (JudgeUtils.isBlank(stringBuilder.toString()) && ChineseWrapUtils.isChinese(chars[i])) {
                stringBuilder.append(chars[i]);
                //stringBuilder.append("yyyy");
                index += 4;
                preCNFlag = true;
                continue;
            }

            //判断当前行是否已经满,如果一行数据已经存满，就先将这一行数据存储到list集合中，开始取下一行数据
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
                if (preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 6) == index && tailSpaceFlag
                        || preCNFlag && index == (end - 5) && ChineseWrapUtils.isChinese(chars[i]) && tailSpaceFlag
                        ) {
                    //stringBuilder.append("yyyy");
                    stringBuilder.append(chars[i]);
                    index += 4;
                    preCNFlag = true;
                    tailSpaceFlag = false;
                    continue;
                }
                //前面的一位为中文字符且后面没有拼接空格，并且当前要记录为中文字符，需要在拼接前在字符前面添加一个空格，记录为5位
                if (preCNFlag && ChineseWrapUtils.isChinese(chars[i]) && (end - 6) == index && !tailSpaceFlag
                        || preCNFlag && index == (end - 5) && ChineseWrapUtils.isChinese(chars[i]) && !tailSpaceFlag
                        ) {
                    //stringBuilder.append(" " + "yyyy");
                    stringBuilder.append(chars[i]);
                    index += 5;
                    preCNFlag = true;
                    continue;
                }
                //如果前面的字符是中文并且要进行存储的是中文且上个字符尾部不为空格就必须保证要有5个字符的位置否则换行
                if (preCNFlag && (end - index) >= 5 && ChineseWrapUtils.isChinese(chars[i]) && !tailSpaceFlag) {
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
                    tailSpaceFlag = true;
                    //当前存储的为中文，并且其尾部存在空格，存储的位置必须保证要有四位字符的位置
                } else if (preCNFlag && (end - index) >= 4 && ChineseWrapUtils.isChinese(chars[i]) && tailSpaceFlag) {
                    //stringBuilder.append("yyyy");
                    stringBuilder.append(chars[i]);
                    index += 4;
                    preCNFlag = true;
                    tailSpaceFlag = false;
                    //如果当前不为中文，且上一位也不为中文，直接拼接上字符串长度加一
                } else if (!ChineseWrapUtils.isChinese(chars[i]) && !preCNFlag) {
                    //stringBuilder.append(chars[i]);
                    stringBuilder.append(chars[i]);
                    index++;
                    preCNFlag = false;
                    //当前存储的为非中文且前一位为中文后面不带空格，自己拼接的时候要添加上一个空格，记两个字符
                } else if (!ChineseWrapUtils.isChinese(chars[i]) && (end - index) >= 2 && preCNFlag && !tailSpaceFlag) {
                    //stringBuilder.append(" " + chars[i]);
                    stringBuilder.append(chars[i]);
                    index += 2;
                    preCNFlag = false;
                     //tailSpaceFlag = false;
                    //当前存储的为中文且前一位中文字符后有空格，有位置直接添加
                } else if (!ChineseWrapUtils.isChinese(chars[i]) && (end - index) >= 1 && preCNFlag && tailSpaceFlag) {
                    //stringBuilder.append(chars[i]);
                    stringBuilder.append(chars[i]);
                    index++;
                    preCNFlag = false;
                    tailSpaceFlag = false;
                } else {
                    //此处表示要存储但是存储中文和非中文位置都已不足只能存储到下一行
                    list.add(stringBuilder.toString());
                    //一行数据已经存满改变为初始值，继续存储下一行数据。
                    stringBuilder = new StringBuilder();
                    index = 0;
                    preCNFlag = false;
                    tailSpaceFlag=false;
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
                list.add(stringBuilder.toString());
                //一行数据已经存满改变为初始值，继续存储下一行数据。
                stringBuilder = new StringBuilder();
                index = 0;
                preCNFlag = false;
                tailSpaceFlag=false;
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
        }
        //如果最后一行或者是只有一行且数据超不过35位,上面的不能走到存储，这里需要进行判断一下StringBuilder中是否存在值。
        if (JudgeUtils.isNotBlank(stringBuilder.toString())) {
            list.add(stringBuilder.toString());
        }
        log.info("###{}###{}","Traversal string","---end---");
        //如果折行后的电文行数超过6行但输入数据仍未处理完毕，则设置超长标志
        log.info("###{}###{}","Determine if the number of rows is exceeded","---start---");
        if (list.size() > 6) {
            log.info("###{}###","Set long flag");
            cnLineWrapRspDTO.setOverFlag("L");
            cnLineWrapRspDTO.setReturnCode("00851");
            rspDTO.setBody(cnLineWrapRspDTO);
            return rspDTO;
        }
        log.info("###{}###{}","Determine if the number of rows is exceeded","---end---");
        //循环遍历list集合将数据存储到返回对象中
        for (int i = 1; i <= list.size(); i++) {
            switch (i) {
                case 1:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line1(list.get(0));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line1(list.get(0));
                    }
                    break;
                case 2:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line2(list.get(1));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line2(list.get(1));
                    }
                    break;
                case 3:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line3(list.get(2));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line3(list.get(2));
                    }
                    break;
                case 4:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line4(list.get(3));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line4(list.get(3));
                    }
                    break;
                case 5:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line5(list.get(4));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line5(list.get(4));
                    }
                    break;
                case 6:
                    if ("A".compareTo(checkType) == 0) {
                        cnLineWrapRspDTO.setOutputF72Line6(list.get(5));
                    } else {
                        cnLineWrapRspDTO.setOutputF75Line6(list.get(5));
                    }
                    break;
            }
        }
        cnLineWrapRspDTO.setReturnCode("00000");
        rspDTO.setBody(cnLineWrapRspDTO);
        log.info("###{}###{}","cnLineWrap","---end---");
        return rspDTO;
    }

    /**
     * 一般金额转报文格式金额
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<AmountToSwiftAmountRspDTO> amountToSwiftAmount(GenericDTO<AmountToSwiftAmountReqDTO> reqDto) {
        BigDecimal amount = reqDto.getBody().getAmount();
        String swiftAmount = ConversionUtil.checkAmountRule(amount);
        GenericRspDTO<AmountToSwiftAmountRspDTO> genericRspDTO = new GenericRspDTO<>();
        AmountToSwiftAmountRspDTO amountRspDTO = new AmountToSwiftAmountRspDTO();
        amountRspDTO.setSwiftAmount(swiftAmount);
        genericRspDTO.setBody(amountRspDTO);
        return genericRspDTO;
    }

    /**
     * 關聯或取消關聯業務記錄請求
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MatchOurRefByMsgNoRspDTO> matchOurRefByMsgNo(GenericDTO<MatchOurRefByMsgNoReqDTO> reqDto) {
        MatchOurRefByMsgNoReqDTO reqDTO = reqDto.getBody();
        //LAST信息入库 需要从公共请求头获取部分信息
        ReqHead reqHead = null;
        if (JudgeUtils.isNotNull(reqDTO.getReqHead())){
            reqHead = reqDTO.getReqHead();
        }else {
            reqHead = new ReqHead();
        }
        GenericRspDTO<MatchOurRefByMsgNoRspDTO> rspDTO = new GenericRspDTO<>();
        MatchOurRefByMsgNoRspDTO msgNoRspDTO = new MatchOurRefByMsgNoRspDTO();
        String msgNo = reqDTO.getMsgNo();
        String matchingFlag = reqDTO.getMatchingFlag();
        String ourRef = reqDTO.getOurRef();
        PgMatchDO pgMatchDO = new PgMatchDO();
        pgMatchDO.setMsgNo(msgNo);
        log.info("##### START TO ASSOCIATED BUSINESS #####");
        //關聯業務記錄  M关联业务编号 没有则新增  U 取消关联  删除记录
        if ("M".equals(matchingFlag)){
            if (JudgeUtils.isNull(ourRef)){
                log.error("##### NO MATCH OUR REF #####");
                KontException.throwBusinessException(MTConstants.MATCH_OURREF_IS_NULL);
            }
            pgMatchDO.setPagmchOurRef(ourRef);
            //LAST信息入库
            pgMatchDO = commonAssemble.setLastUpdateParams(reqHead, pgMatchDO);
            int result = pgMatchService.updateMatchOurRefByMsgNo(pgMatchDO);
            if (result>0){
                log.info("##### MATCH SUCCESS #####");
                msgNoRspDTO.setReturnCode("00000");
            }else {
                log.info("##### NO FIND MATCH,MSGNO:{}",msgNo);
                //没有查询到该报文编号  往表插入一条该关联信息
                LocalDateTime createTime = mtAssemblyService.getSysLocalDate();
                pgMatchDO.setCreatedTime(createTime);
                int resultNum = pgMatchService.insertPgMatch(pgMatchDO);
                if (resultNum>0){
                    log.info("##### MATCH SUCCESS #####");
                    msgNoRspDTO.setReturnCode("00000");
                }else {
                    log.error("##### MATCH FAILED #####");
                    msgNoRspDTO.setReturnCode("00999");
                }
            }
        }else if ("U".equals(matchingFlag)){
            if (JudgeUtils.isNull(msgNo)){
                log.error("#### MSGNO IS NULL #####");
                KontException.throwBusinessException(MTConstants.MATCH_MSGNO_IS_NULL);
            }
            //根据MactchDo删除 且 报文编号必输  也可根据联合主键删除
            int result = pgMatchService.deletePgMatch(pgMatchDO);
            if (result>0){
                log.info("##### DELETE MATCH SUCCESS #####");
                msgNoRspDTO.setReturnCode("00000");
            }else {
                log.error("##### DELETE MATCH FAILED #####");
                msgNoRspDTO.setReturnCode("00999");
            }
        }else {
            //没有关联标识 无法关联
            log.error("##### MATCH FLAG IS NULL #####");
            KontException.throwBusinessException(MTConstants.MATCH_FLAG_IS_NULL);
        }
        rspDTO.setBody(msgNoRspDTO);
        log.info("##### END TO ASSOCIATED BUSINESS #####");
        return rspDTO;
    }

    /**
     * 一般汇率转报文汇率
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<RateToSwiftRateRspDTO> rateToSwiftRate(GenericDTO<RateToSwiftRateReqDTO> reqDto) {
        RateToSwiftRateReqDTO body = reqDto.getBody();
        BigDecimal amountRate = body.getAmountRate();
        String swiftRate = ConversionUtil.checkExchange(amountRate);
        GenericRspDTO<RateToSwiftRateRspDTO> genericRspDTO = new GenericRspDTO<>();
        RateToSwiftRateRspDTO rateRspDTO = new RateToSwiftRateRspDTO();
        rateRspDTO.setMtRate(swiftRate);
        genericRspDTO.setBody(rateRspDTO);
        return genericRspDTO;
    }

    /**
     * 报文汇率转一般汇率
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<SwiftRateToRateRspDTO> swiftRateToRate(GenericDTO<SwiftRateToRateReqDTO> reqDto) {
        SwiftRateToRateReqDTO body = reqDto.getBody();
        String mtRate = body.getMtRate();
        BigDecimal bigDecimal = ConversionUtil.strRateToDouRate(mtRate);
        GenericRspDTO<SwiftRateToRateRspDTO> genericRspDTO = new GenericRspDTO<>();
        SwiftRateToRateRspDTO rspDTO = new SwiftRateToRateRspDTO();
        rspDTO.setAmountRate(bigDecimal);
        genericRspDTO.setBody(rspDTO);
        return genericRspDTO;
    }

    /**
     * 报文格式金额转一般金额
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<SwiftAmountToAmountRspDTO> swiftAmountToAmount(GenericDTO<SwiftAmountToAmountReqDTO> reqDto) {
        SwiftAmountToAmountReqDTO body = reqDto.getBody();
        String swiftAmount = body.getSwiftAmount();
        BigDecimal bigAmount = ConversionUtil.strAmountToBigAmount(swiftAmount);
        GenericRspDTO<SwiftAmountToAmountRspDTO> genericRspDTO = new GenericRspDTO<>();
        SwiftAmountToAmountRspDTO rspDTO = new SwiftAmountToAmountRspDTO();
        rspDTO.setAmount(bigAmount);
        genericRspDTO.setBody(rspDTO);
        return genericRspDTO;
    }

    /**
     * 查詢關聯報文請求
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<QueryMatchMessageRspDTO> queryMatchMessage(GenericDTO<QueryMatchMessageReqDTO> reqDto) {
        GenericRspDTO<QueryMatchMessageRspDTO> rspDTO = new GenericRspDTO<>();
        QueryMatchMessageRspDTO queryMatchMessageRspDTO = new QueryMatchMessageRspDTO();
        QueryMatchMessageReqDTO matchMessageReqDTO = reqDto.getBody();
        String ourRef = matchMessageReqDTO.getOurRef();
        String ohGpiRef = matchMessageReqDTO.getOhGpiRef();
        log.info("##### START TO QUERY ASSOCIATED MESSAGE #####");
        PgstsDO pgstsDO = new PgstsDO();
        //ourRef和ohGpiRef不可同時輸入且必須輸入其一  否則出錯00321
        if ((JudgeUtils.isNotNull(ourRef)&&JudgeUtils.isNotNull(ohGpiRef))){
            queryMatchMessageRspDTO.setReturnCode("00321");
        }else if (JudgeUtils.isNotNull(ourRef)&&JudgeUtils.isNull(ohGpiRef)){
        //ourRef不為空  ohGpiRef為空
            log.info("##### OUR REF :{}",ourRef);
            //根據关联業務編號查询match表
            List<PgstsDO> pgstsDaoList = new ArrayList<>();
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setPagmchOurRef(ourRef);
            List<PgMatchDO> pgMatchDOList = pgMatchService.findListByPgMatchDo(pgMatchDO);
            //拿到match表的报文编号查主档信息
            for (PgMatchDO matchDO : pgMatchDOList) {
                PgstsDO dao = pgstsDao.getByMsgNo(matchDO.getMsgNo());
                if (JudgeUtils.isNotNull(dao)){
                    pgstsDaoList.add(dao);
                }
            }
            if (pgstsDaoList.size()>0){
                //按时间排序
                Collections.sort(pgstsDaoList, new Comparator<PgstsDO>() {
                    @Override
                    public int compare(PgstsDO o1, PgstsDO o2) {
                        if (o1.getCreatedTime().isAfter(o2.getCreatedTime())){
                            return 1;
                        }
                        return -1;
                    }
                });
                //獲取最新的gpi 狀態 原因 日期 時間 時區
                PgstsDO pgDo = pgstsDaoList.get(0);
                queryMatchMessageRspDTO.setLastGpiStatus(pgDo.getGpiStatus());
                queryMatchMessageRspDTO.setLastGpiReason(pgDo.getGpiReasonCode());
                queryMatchMessageRspDTO.setLastGpiDate(pgDo.getIncomeDate());
                queryMatchMessageRspDTO.setLastGpiTime(pgDo.getIncomeTime());
                queryMatchMessageRspDTO.setLastTimeZone(pgDo.getIncomeTimeZone());
                List<MatchDto> matchDtos = new ArrayList<>();
                for (PgstsDO aDo : pgstsDaoList) {
                    MatchDto matchDo = new MatchDto();
                    matchDo.setGpiStatus(aDo.getGpiStatus());
                    matchDo.setGpiReason(aDo.getGpiReasonCode());
                    matchDo.setGpiDate(aDo.getGpiDate());
                    matchDo.setGpiTime(aDo.getGpiTime());
                    matchDo.setGpiTimeZone(aDo.getGpiTimezone());
                    matchDo.setMsgNo(aDo.getMsgNo());
                    matchDo.setMsgType(aDo.getAhMt());
                    //关联渠道 如果为CHATS电文 取CHT  如果不是一律取 SWF
                    if ("CHT".equals(aDo.getOhHkl())){
                        matchDo.setMsgChnl(aDo.getOhHkl());
                    }else {
                        matchDo.setMsgChnl("SWF");
                    }
                    matchDo.setMsgMethod(aDo.getMsgMethod());
                    matchDo.setOhCov(aDo.getOhCov());
                    matchDo.setCreatedTime(aDo.getCreatedTime());
                    matchDo.setUpdateLastTime(aDo.getUpdateLastTime());
                    matchDtos.add(matchDo);
                }
                queryMatchMessageRspDTO.setReturnCode("00000");
                queryMatchMessageRspDTO.setMatchDtos(matchDtos);
            }else {
                //ourRef gpiRef都为空
                queryMatchMessageRspDTO.setReturnCode("00000");
            }
        }else if (JudgeUtils.isNotNull(ohGpiRef)&&JudgeUtils.isNull(ourRef)){
         //ourRef為空  ohGpiRef不為空
            log.info("##### 121 GPI REF :{}",ohGpiRef);
            //根據業務編號
            pgstsDO.setOhGpiRef(ohGpiRef);
            List<PgstsDO> pgstsDaoList = pgstsDao.findList(pgstsDO);
            if (pgstsDaoList.size()>0){
                //按时间排序
                Collections.sort(pgstsDaoList, new Comparator<PgstsDO>() {
                    @Override
                    public int compare(PgstsDO o1, PgstsDO o2) {
                        if (o1.getCreatedTime().isAfter(o2.getCreatedTime())){
                            return 1;
                        }
                        return -1;
                    }
                });
                //獲取最新的gpi 狀態 原因 日期 時間 時區
                PgstsDO pgDo = pgstsDaoList.get(0);
                queryMatchMessageRspDTO.setLastGpiStatus(pgDo.getGpiStatus());
                queryMatchMessageRspDTO.setLastGpiReason(pgDo.getGpiReasonCode());
                queryMatchMessageRspDTO.setLastGpiDate(pgDo.getGpiDate());
                queryMatchMessageRspDTO.setLastGpiTime(pgDo.getGpiTime());
                queryMatchMessageRspDTO.setLastTimeZone(pgDo.getGpiTimezone());
                List<MatchDto> matchDtos = new ArrayList<>();
                for (PgstsDO aDo : pgstsDaoList) {
                    MatchDto matchDo = new MatchDto();
                    matchDo.setGpiStatus(aDo.getGpiStatus());
                    matchDo.setGpiReason(aDo.getGpiReasonCode());
                    matchDo.setGpiDate(aDo.getGpiDate());
                    matchDo.setGpiTime(aDo.getGpiTime());
                    matchDo.setGpiTimeZone(aDo.getGpiTimezone());
                    matchDo.setMsgNo(aDo.getMsgNo());
                    matchDo.setMsgType(aDo.getAhMt());
                    //关联渠道 如果为CHATS电文 取CHT  如果不是一律取 SWF
                    if ("CHT".equals(aDo.getOhHkl())){
                        matchDo.setMsgChnl(aDo.getOhHkl());
                    }else {
                        matchDo.setMsgChnl("SWF");
                    }
                    matchDo.setMsgMethod(aDo.getMsgMethod());
                    matchDo.setOhCov(aDo.getOhCov());
                    matchDo.setCreatedTime(aDo.getCreatedTime());
                    matchDo.setUpdateLastTime(aDo.getUpdateLastTime());
                    matchDtos.add(matchDo);
                }
                queryMatchMessageRspDTO.setReturnCode("00000");
                queryMatchMessageRspDTO.setMatchDtos(matchDtos);
            }else {
                queryMatchMessageRspDTO.setReturnCode("00000");
            }

        }else {
            //ourRef 121都为空  返回00321
            queryMatchMessageRspDTO.setReturnCode("00321");
        }
        rspDTO.setBody(queryMatchMessageRspDTO);
        log.info("##### END TO QUERY ASSOCIATED MESSAGE #####");
        return rspDTO;
    }

    /**
     * 查询止付关联报文
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<StopPaymentMsgRspDTO> stopPaymentMsg(GenericDTO<StopPaymentMsgReqDTO> reqDto) {
        log.info("##### START TO GET STOP PAYMENT ASSOCIATION #####");
        GenericRspDTO<StopPaymentMsgRspDTO> genericRspDTO = new GenericRspDTO<>();
        StopPaymentMsgReqDTO body = reqDto.getBody();
        PgstsDO pgstsDO = new PgstsDO();
        //gpi编号 和 21 可传可不传
        if (JudgeUtils.isNotNull(body.getOhGpiRef())){
            pgstsDO.setOhGpiRef(body.getOhGpiRef());
        }
        if (JudgeUtils.isNotNull(body.getRtrn())){
            pgstsDO.setRtrn(body.getRtrn());
        }
        //20一定会传 报文类型
        if (JudgeUtils.isNotNull(body.getAhMt())){
            pgstsDO.setAhMt(body.getAhMt());
        }
        if (JudgeUtils.isNotNull(body.getTrn())){
            pgstsDO.setTrn(body.getTrn());
        }else {
            //20没传错误码 RPSG1004
            genericRspDTO.setMsgCd(MTConstants.MT_GEN_F20_IS_NULL);
            return genericRspDTO;
        }
        //对手行
        if (JudgeUtils.isNotNull(body.getBhSndlt())){
            pgstsDO.setBhSndlt(body.getBhSndlt());
        }else {
            genericRspDTO.setMsgCd(MTConstants.SOPT_SENDER_IS_NULL);
            return genericRspDTO;
        }
        //取收入的止付报文
        pgstsDO.setAhioFlag("O");
        List<PgstsDO> listByPgstsDo = pgstsService.findListByPgstsDo(pgstsDO);
        StopPaymentMsgRspDTO stopPaymentMsgRspDTO = new StopPaymentMsgRspDTO();
        List<StopPayRspDTO> stopPayRspDTOS = new ArrayList<>();
        for (PgstsDO aDo : listByPgstsDo) {
            StopPayRspDTO stopPayRspDTO = new StopPayRspDTO();
            stopPayRspDTO.setAhRcvlt(aDo.getAhRcvlt());
            stopPayRspDTO.setBhIsn(aDo.getBhIsn());
            stopPayRspDTO.setBhSessNo(aDo.getBhSessNo());
            stopPayRspDTO.setMsgNo(aDo.getMsgNo());
            stopPayRspDTO.setRtrn(aDo.getRtrn());
            stopPayRspDTO.setTrn(aDo.getTrn());
            stopPayRspDTO.setAhMt(aDo.getAhMt());
            stopPayRspDTO.setMsgIncomeDate(aDo.getIncomeDate());
            stopPayRspDTO.setBhSndlt(aDo.getBhSndlt());
            stopPayRspDTOS.add(stopPayRspDTO);
        }
        stopPaymentMsgRspDTO.setStopPayRspDTOs(stopPayRspDTOS);
        genericRspDTO.setBody(stopPaymentMsgRspDTO);
        log.info("##### END TO GET STOP PAYMENT ASSOCIATION #####");
        return genericRspDTO;
    }

    /**
     * 发送暂存报文 应用送rmc参数 公共请求头信息  报文编号
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<MtDto> SendTemporaryMt(GenericDTO<SendTemporaryMtReqDTO> reqDto) {
        log.info("##### START TO SEND TEMPORARY MESSAGE #####");
        GenericRspDTO<MtDto> genericRspDTO = new GenericRspDTO<>();
        SendTemporaryMtReqDTO body = reqDto.getBody();
        String msgNo = body.getMsgNo();
        RmcTrx01 rmcTrx01 = body.getRmcTrx01();
        ReqHead reqHead = body.getReqHead();
        EaiHeaderDTO eaiHeaderDTO = new EaiHeaderDTO();
        MtDto mtDto = new MtDto();
        PgstsDO pgstsDO = pgstsDao.getByMsgNo(msgNo);
        //没有暂存信息
        if (JudgeUtils.isNull(pgstsDO)){
            log.error("##### NO TEMPORARY MESSAGE,MSGNO:{}",msgNo);
            genericRspDTO.setMsgCd(MTConstants.TEMPORARY_MSGNO_IS_NULL);
            return genericRspDTO;
        }
        //报文不处于暂存状态，已发出
        if (!"Y".equals(pgstsDO.getMtTemporary())){
            log.error("##### THE TEMPORARY MESSAGE IS ALREADY SEND #####");
            genericRspDTO.setMsgCd(MTConstants.TEMPORARY_MESSAGE_SEND_SUCCESS);
            return genericRspDTO;
        }
        //mtDto赋值
        mtDto.setMsgNo(msgNo);
        mtDto.setMtStr(pgstsDO.getMtStr());
        mtDto.setAhMt(pgstsDO.getAhMt());
        mtDto.setMessage(pgstsDO.getMtMessage());
        mtDto.setOhGpiRef(pgstsDO.getOhGpiRef());
        //暂存标识修改
        pgstsDO.setMtTemporary("N");
        //发送报文
        String msgCd = commonAssemble.comSendMessage(rmcTrx01, reqHead, eaiHeaderDTO, mtDto, pgstsDO);
        genericRspDTO.setBody(mtDto);
        genericRspDTO.setMsgCd(msgCd);
        log.info("##### END TO SEND TEMPORARY MESSAGE #####");
        return genericRspDTO;
    }

    /**
     * 根据报文编号获取报文做拆解成fmt103
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<GetFmt103MessageByMsgNoRspDTO> getFmt103MessageByMsgNo(GenericDTO<GetFmt103MessageByMsgNoReqDTO> reqDto){
        GetFmt103MessageByMsgNoReqDTO messageByMsgNoReqDTO = reqDto.getBody();
        GenericRspDTO<GetFmt103MessageByMsgNoRspDTO> rspDTO = new GenericRspDTO<>();
        GetFmt103MessageByMsgNoRspDTO messageByMsgNoRspDTO = new GetFmt103MessageByMsgNoRspDTO();
        log.info("##### START TO GET FMT103 #####");
        if (JudgeUtils.isNull(messageByMsgNoReqDTO.getMsgNo())){
            rspDTO.setMsgCd(MTConstants.MT_MSGNO_IS_N0T_NULL);
            return rspDTO;
        }else {
            String msgNo = messageByMsgNoReqDTO.getMsgNo();
            log.info("##### START TO GET FMT103 BY MSGNO:{}",msgNo);
            PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
            if (JudgeUtils.isNull(pgstsDO) || !("103".equals(pgstsDO.getAhMt()))){
                log.error("##### NO RECORD FROM PG OR THE MT TYPE IS NOT 103 :{}",pgstsDO.getAhMt());
                rspDTO.setMsgCd(MTConstants.MT_DATA_ERROR);
                return rspDTO;
            }else {
                log.info("##### START TO DISMANTLE MT103 MESSAGE #####");
                String mtStr = pgstsDO.getMtStr();
                BaseMessage baseMessage = dismantleMTService.dismantleMT(mtStr);
                Fmt103 fmt103 = new Fmt103();
                //swHeader参数赋值
                SwHeader swHeader = new SwHeader();
                swHeader.setFrModule(pgstsDO.getFrModule());
                swHeader.setLogNumber(pgstsDO.getLogNumber());
                swHeader.setGpiFlag(pgstsDO.getGpiFlag());
                swHeader.setManualFg(pgstsDO.getManualFg());
                swHeader.setMsgMethod(pgstsDO.getMsgMethod());
                swHeader.setPagmchOurRef(pgstsDO.getPagmchOurRef());
                swHeader.setTraditionalFlag(pgstsDO.getTraditionalFlag());
                swHeader.setYourChl(pgstsDO.getYourChl());
                swHeader.setTxnCode(pgstsDO.getTxncode());
                swHeader.setMtTemporary(pgstsDO.getMtTemporary());
                swHeader.setMsgNo(pgstsDO.getMsgNo());
                fmt103.setSwHeader(swHeader);
                //false 查询出来的电文按不转中文返回给汇出
                Boolean toCnFlag = false;
                try {
                    CopyTagUtils.mappingMtToDtoByCnFlag(baseMessage,fmt103,toCnFlag);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    log.error("##### MAPPING ERROR #####");
                    e.printStackTrace();
                }
                CopyTagUtils.CphaderInfo("I", fmt103.getSwHeader(),baseMessage);
                messageByMsgNoRspDTO.setFmt103(fmt103);
                messageByMsgNoRspDTO.setMtStatus(pgstsDO.getMtStatus());
                messageByMsgNoRspDTO.setRejectedReason(pgstsDO.getRejectedReason());
                rspDTO.setBody(messageByMsgNoRspDTO);
                log.info("##### END TO DISMANTLE MT103 MESSAGE #####");
            }
        }
        log.info("##### END TO GET FMT103 #####");
        return rspDTO;
    }

    /**
     * 根据报文编号获取报文做拆解成fmt202
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<GetFmt202MessageByMsgNoRspDTO> getFmt202MessageByMsgNo(GenericDTO<GetFmt202MessageByMsgNoReqDTO> reqDto){
        GetFmt202MessageByMsgNoReqDTO messageByMsgNoReqDTO = reqDto.getBody();
        GenericRspDTO<GetFmt202MessageByMsgNoRspDTO> rspDTO = new GenericRspDTO<>();
        GetFmt202MessageByMsgNoRspDTO messageByMsgNoRspDTO = new GetFmt202MessageByMsgNoRspDTO();
        log.info("##### START TO GET FMT202 #####");
        if (JudgeUtils.isNull(messageByMsgNoReqDTO.getMsgNo())){
            rspDTO.setMsgCd(MTConstants.MT_MSGNO_IS_N0T_NULL);
            return rspDTO;
        }else {
            String msgNo = messageByMsgNoReqDTO.getMsgNo();
            PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
            log.info("##### START TO GET FMT202 BY MSGNO:{}",msgNo);
            if (JudgeUtils.isNull(pgstsDO) || !("202".equals(pgstsDO.getAhMt()))){
                log.error("##### NO RECORD FROM PG OR THE MT TYPE IS NOT 202 :{}",pgstsDO.getAhMt());
                rspDTO.setMsgCd(MTConstants.MT_DATA_ERROR);
                return rspDTO;
            }else {
                log.info("##### START TO DISMANTLE MT202 MESSAGE #####");
                String mtStr = pgstsDO.getMtStr();
                BaseMessage baseMessage = dismantleMTService.dismantleMT(mtStr);
                Fmt202 fmt202 = new Fmt202();
                //swHeader参数赋值
                SwHeader swHeader202 = new SwHeader();
                swHeader202.setFrModule(pgstsDO.getFrModule());
                swHeader202.setLogNumber(pgstsDO.getLogNumber());
                swHeader202.setGpiFlag(pgstsDO.getGpiFlag());
                swHeader202.setManualFg(pgstsDO.getManualFg());
                swHeader202.setMsgMethod(pgstsDO.getMsgMethod());
                swHeader202.setPagmchOurRef(pgstsDO.getPagmchOurRef());
                swHeader202.setTraditionalFlag(pgstsDO.getTraditionalFlag());
                swHeader202.setYourChl(pgstsDO.getYourChl());
                swHeader202.setTxnCode(pgstsDO.getTxncode());
                swHeader202.setMtTemporary(pgstsDO.getMtTemporary());
                swHeader202.setMsgNo(pgstsDO.getMsgNo());
                fmt202.setSwHeader(swHeader202);
                //false 查询出来的电文按不转中文返回给汇出
                Boolean toCnFlag = false;
                try {
                    CopyTagUtils.mappingMtToDtoByCnFlag(baseMessage,fmt202,toCnFlag);
                } catch (Exception e) {
                    log.error(e.getMessage());
                    log.error("##### MAPPING ERROR #####");
                    e.printStackTrace();
                }
                CopyTagUtils.CphaderInfo("I", fmt202.getSwHeader(),baseMessage);
                messageByMsgNoRspDTO.setFmt202(fmt202);
                messageByMsgNoRspDTO.setMtStatus(pgstsDO.getMtStatus());
                messageByMsgNoRspDTO.setRejectedReason(pgstsDO.getRejectedReason());
                rspDTO.setBody(messageByMsgNoRspDTO);
                log.info("##### END TO DISMANTLE MT202 MESSAGE #####");
            }
        }
        log.info("##### END TO GET FMT202 #####");
        return rspDTO;
    }

    /**
     * 根据报文编号获取202COV的seqB的资料
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<Get202COVSeqbByMsgNoRspDTO> get202COVSeqbByMsgNo(GenericDTO<Get202COVSeqbByMsgNoReqDTO> reqDto) {
        log.info("##### START TO GET 202COV SEQB RECORD #####");
        Get202COVSeqbByMsgNoReqDTO seqbByMsgNoReqDTO = reqDto.getBody();
        GenericRspDTO<Get202COVSeqbByMsgNoRspDTO> rspDTO = new GenericRspDTO<>();
        Get202COVSeqbByMsgNoRspDTO msgNoRspDTO = new Get202COVSeqbByMsgNoRspDTO();
        if (JudgeUtils.isNull(seqbByMsgNoReqDTO.getMsgNo())){
            log.info("##### MSGNO IS NULL #####");
            rspDTO.setMsgCd(MTConstants.MT_MSGNO_IS_N0T_NULL);
            return rspDTO;
        }else {
            String msgNo = seqbByMsgNoReqDTO.getMsgNo();
            log.info("##### MSGNO:{}",msgNo);
            PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
            if (JudgeUtils.isNull(pgstsDO)){
                rspDTO.setMsgCd(MTConstants.MT_DATA_ERROR);
                return rspDTO;
            }else {
                log.info("##### START TO DISMANTLE MT202COV AND HANDLE MAPPING #####");
                String mtStr = pgstsDO.getMtStr();
                BaseMessage baseMessage = dismantleMTService.dismantleMT(mtStr);
                //手动映射 52a 56a 57a
                ArrayList<BaseTag> tag52ADataList = baseMessage.getTagDataList("52A", "B");
                if (JudgeUtils.isNotNull(tag52ADataList)){
                    Tag52A tag52A = (Tag52A)tag52ADataList.get(0);
                    F52A f52A = new F52A();
                    BeanUtils.copyProperties(tag52A,f52A);
                    msgNoRspDTO.setF52A(f52A);
                }
                ArrayList<BaseTag> tag52DDataList = baseMessage.getTagDataList("52D", "B");
                if (JudgeUtils.isNotNull(tag52DDataList)){
                    Tag52D tag52D = (Tag52D) tag52DDataList.get(0);
                    F52D f52D = new F52D();
                    BeanUtils.copyProperties(tag52D,f52D);
                    List<String> ordInstAddrList = f52D.getOrdInstAddrList();
                    List<String> newList = new ArrayList<>();
                    for (String str : ordInstAddrList) {
                        log.info("##### BEFORE CONBERSION STRING:{}",str);
                        String chinese = PgstpswfUtil.teleToChinese(str, "52D");
                        log.info("##### AFTER CONBERSION STRING:{}",chinese);
                        newList.add(chinese);
                    }
                    f52D.setOrdInstAddrList(newList);
                    msgNoRspDTO.setF52D(f52D);
                }
                ArrayList<BaseTag> tag56ADataList = baseMessage.getTagDataList("56A", "B");
                if (JudgeUtils.isNotNull(tag56ADataList)){
                    Tag56A tag56A = (Tag56A) tag56ADataList.get(0);
                    F56A f56A = new F56A();
                    BeanUtils.copyProperties(tag56A,f56A);
                    msgNoRspDTO.setF56A(f56A);
                }
                ArrayList<BaseTag> tag56CDataList = baseMessage.getTagDataList("56C", "B");
                if (JudgeUtils.isNotNull(tag56CDataList)){
                    Tag56C tag56C = (Tag56C) tag56CDataList.get(0);
                    F56C f56C = new F56C();
                    BeanUtils.copyProperties(tag56C,f56C);
                    msgNoRspDTO.setF56C(f56C);
                }
                ArrayList<BaseTag> tag56DDataList = baseMessage.getTagDataList("56D", "B");
                if (JudgeUtils.isNotNull(tag56DDataList)){
                    Tag56D tag56D = (Tag56D) tag56DDataList.get(0);
                    F56D f56D = new F56D();
                    BeanUtils.copyProperties(tag56D,f56D);
                    List<String> medInstAddrList = f56D.getMedInstAddrList();
                    List<String> newList = new ArrayList<>();
                    for (String str : medInstAddrList) {
                        log.info("##### BEFORE CONBERSION STRING:{}",str);
                        String chinese = PgstpswfUtil.teleToChinese(str, "56D");
                        log.info("##### AFTER CONBERSION STRING:{}",chinese);
                        newList.add(chinese);
                    }
                    f56D.setMedInstAddrList(newList);
                    msgNoRspDTO.setF56D(f56D);
                }
                ArrayList<BaseTag> tag57ADataList = baseMessage.getTagDataList("57A", "B");
                if (JudgeUtils.isNotNull(tag57ADataList)){
                    Tag57A tag57A = (Tag57A) tag57ADataList.get(0);
                    F57A f57A = new F57A();
                    BeanUtils.copyProperties(tag57A,f57A);
                    msgNoRspDTO.setF57A(f57A);
                }
                ArrayList<BaseTag> tag57BDataList = baseMessage.getTagDataList("57B", "B");
                if (JudgeUtils.isNotNull(tag57BDataList)){
                    Tag57B tag57B = (Tag57B) tag57BDataList.get(0);
                    F57B f57B = new F57B();
                    BeanUtils.copyProperties(tag57B,f57B);
                    msgNoRspDTO.setF57B(f57B);
                }
                ArrayList<BaseTag> tag57CDataList = baseMessage.getTagDataList("57C", "B");
                if (JudgeUtils.isNotNull(tag57CDataList)){
                    Tag57C tag57C = (Tag57C) tag57CDataList.get(0);
                    F57C f57C = new F57C();
                    BeanUtils.copyProperties(tag57C,f57C);
                    msgNoRspDTO.setF57C(f57C);
                }
                ArrayList<BaseTag> tag57DDataList = baseMessage.getTagDataList("57D", "B");
                if (JudgeUtils.isNotNull(tag57DDataList)){
                    Tag57D tag57D = (Tag57D) tag57DDataList.get(0);
                    F57D f57D = new F57D();
                    BeanUtils.copyProperties(tag57D,f57D);
                    List<String> actInstAddrList = f57D.getActInstAddrList();
                    List<String> newList = new ArrayList<>();
                    for (String str : actInstAddrList) {
                        log.info("##### BEFORE CONBERSION STRING:{}",str);
                        String chinese = PgstpswfUtil.teleToChinese(str, "57D");
                        log.info("##### AFTER CONBERSION STRING:{}",chinese);
                        newList.add(chinese);
                    }
                    f57D.setActInstAddrList(newList);
                    msgNoRspDTO.setF57D(f57D);
                }
                rspDTO.setBody(msgNoRspDTO);
                log.info("##### END TO DISMANTLE MT202COV AND HANDLE MAPPING #####");
            }
        }
        log.info("##### END TO GET 202COV SEQB RECORD #####");
        return rspDTO;
    }

    /**
     * 中文转电码2 (提供给前端使用)
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<CnToTeleNumFrontRspDTO> cnToTeleNumFront(GenericDTO<CnToTeleNumFrontReqDTO> reqDto) {
        log.info("##### START TO GET TELE CODE #####");
        CnToTeleNumFrontReqDTO body = reqDto.getBody();
        String inputData = null;
        String traditionalFlag = null;
        if (JudgeUtils.isNotNull(body.getInputData())){
            inputData = body.getInputData();
        }
        if (JudgeUtils.isNotNull(body.getTraditionalFlag())){
            traditionalFlag = body.getTraditionalFlag();
        }else {
            //不传默认繁体
            traditionalFlag = "Y";
        }
        log.info("##### INPUT DATA :{}",inputData);
        CnToTeleDO cnToTeleDO = pgstpswftoteleService.getStringCnToTele2(inputData, traditionalFlag);
        String outData = cnToTeleDO.getOutputData();
        String overLengthData = cnToTeleDO.getOverLengthData();
        log.info("##### OUTPUT DATA DATA :{}",outData);
        log.info("##### OVER LENGTH DATA :{}",overLengthData);
        GenericRspDTO<CnToTeleNumFrontRspDTO> genericRspDTO = new GenericRspDTO<>();
        CnToTeleNumFrontRspDTO cnToTeleNumFrontRspDTO = new CnToTeleNumFrontRspDTO();
        cnToTeleNumFrontRspDTO.setOutputData(outData);
        cnToTeleNumFrontRspDTO.setOutputLength(outData.length());
        cnToTeleNumFrontRspDTO.setOverLengthData(overLengthData);
        List<String> cnDataList = AssembleUtils.findCnData(outData);
        cnToTeleNumFrontRspDTO.setCnDataList(cnDataList);
        genericRspDTO.setBody(cnToTeleNumFrontRspDTO);
        log.info("##### END TO GET TELE CODE #####");
        return genericRspDTO;
    }

    /**
     * 23972 23973重发，更改报文状态为DELE  作废标识
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<UpdateGwMsgStatusToDeleRspDTO> updateGwMsgStatusToDele(GenericDTO<UpdateGwMsgStatusToDeleReqDTO> reqDto) {
        UpdateGwMsgStatusToDeleReqDTO body = reqDto.getBody();
        String msgNo = body.getMsgNo();
        GenericRspDTO<UpdateGwMsgStatusToDeleRspDTO> genericRspDTO = new GenericRspDTO<>();
        UpdateGwMsgStatusToDeleRspDTO updateGwMsgStatusToDeleRspDTO = new UpdateGwMsgStatusToDeleRspDTO();
        log.info("##### START TO UPDATE PGSTS #####");
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
        if (JudgeUtils.isNull(pgstsDO)){
            log.error("##### RETURN NULL,THE MSGNO QUERY NO RECORE:{}",msgNo);
            KontException.throwBusinessException("RPSG09999","THE MSGNO QUERY NO RECORE");
        }
        //修改状态 添加作废标识
        pgstsDO.setGwMsgStatus("DELE");
        pgstsDO.setVoidFlag("Y");
        int result = pgstsService.updateMtStatus(pgstsDO);
        if (result>0){
            updateGwMsgStatusToDeleRspDTO.setReturnCode("00000");
            log.info("##### UPDATE SUCCESS #####");
        }else {
            updateGwMsgStatusToDeleRspDTO.setReturnCode("09999");
            log.info("##### UPDATE FAILED #####");
        }
        genericRspDTO.setBody(updateGwMsgStatusToDeleRspDTO);
        log.info("##### END TO UPDATE PGSTS #####");
        return genericRspDTO;
    }

    /**
     * 获取RMCTRX01参数
     * @param reqDto
     * @return
     */
    @Override
    public GenericRspDTO<GetRmcTrx01ByMsgNoRspDTO> getRmcTrx01ByMsgNo(GenericDTO<GetRmcTrx01ByMsgNoReqDTO> reqDto) {
        GenericRspDTO<GetRmcTrx01ByMsgNoRspDTO> genericRspDTO = new GenericRspDTO<>();
        GetRmcTrx01ByMsgNoRspDTO getRmcTrx01ByMsgNoRspDTO = new GetRmcTrx01ByMsgNoRspDTO();
        GetRmcTrx01ByMsgNoReqDTO reqDtoBody = reqDto.getBody();
        String msgNo = reqDtoBody.getMsgNo();
        log.info("##### START TO GET RMCTRX01 FORM PG ,MSGNO:{}",msgNo);
        PgstsDO pgstsDO = pgstsService.getByMsgNo(msgNo);
        if (JudgeUtils.isNull(pgstsDO)){
            KontException.throwBusinessException("RPSG09999","GET RMCTRX01 IS NULL BY MSGNO");
        }
        String mtBean = pgstsDO.getMtBean();
        RmcTrx01 rmcTrx01 = new RmcTrx01();
        if (JudgeUtils.isNotNull(mtBean)){
            rmcTrx01 = JSONObject.parseObject(mtBean, RmcTrx01.class);
        }
        getRmcTrx01ByMsgNoRspDTO.setRmcTrx01(rmcTrx01);
        genericRspDTO.setBody(getRmcTrx01ByMsgNoRspDTO);
        log.info("##### END TO GET RMCTRX01 FORM PG ######");
        return genericRspDTO;
    }

}