package com.hisun.kont.pg.service.impl;

import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.dao.PgSinteleDao;
import com.hisun.kont.pg.dao.PgSintrateleDao;
import com.hisun.kont.pg.entity.PgSinteleDO;
import com.hisun.kont.pg.entity.PgSintrateleDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.MessageMaintainService;
import com.hisun.kont.pg.service.PgstpswftoteleService;
import com.hisun.kont.pg.utils.CnToTeleDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * (组装报文)中文转电码
 */
@Service
@Transactional
public class PgstpswftoteleServiceImpl implements PgstpswftoteleService {

    private static final Logger log = LoggerFactory.getLogger(MessageMaintainServiceImpl.class);

    @Resource
    private MessageMaintainService messageMaintainService;

    @Resource
    private PgSintrateleDao pgSintrateleDao;

    @Resource
    private PgSinteleDao pgSinteleDao;

    /**
     * 根据简繁体标识 将中文转成相应的电码
     *
     * @param mt103Json
     * @param traditionalFlag
     * @return
     * @throws Exception
     */
    @Override
    public String getStringCnToTele(String mt103Json, String traditionalFlag){
        StringBuilder stringBuilder = new StringBuilder();
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        StringBuilder sb = null;
        //分组
        try {
            mt103Json = new String(mt103Json.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("##### ERROR:{}",e.getMessage());
            log.error("##### EXCEPTION FORMAT STRING TO JSON :{}",mt103Json);
            KontException.throwKontException(MTConstants.STRING_TOJSON_IS_ERROR);
        }
        char c;
        for (int i = 0; i < mt103Json.length(); i++) {
            c = mt103Json.charAt(i);
            int byteLength = String.valueOf(c).getBytes().length;
            //中文字符字节长度大于1  非中文字符字节长度等于1
            if (byteLength > 1) {
                String error = findTeleCodeByCn(c, mt103Json, traditionalFlag, i, stringBuilder);
                if ("00419".equals(error)){
                    return error;
                }
            } else {
                String str = String.valueOf(c);
                if (Pattern.matches(pattern,str)){
                    //前导代理 [\uD800-\uDBFF]
                    log.info("##### LEADING DOUBLE BYTE CHARACTER:{}",str);
                    sb = new StringBuilder();
                    sb.append(str);
                }else if (Pattern.matches(pattern2,str)){
                    //后导代理 [\uDC00-\uDFFF]
                    log.info("##### AFTER DOUBLE BYTE CHARACTER:{}",str);
                    sb.append(str);
                    log.info("##### CONCATENATE DOUBLE BYTE CHARACTER:{}",sb.toString());
                    String error = findTeleCodeByDouCn(sb.toString(), mt103Json, traditionalFlag, i, stringBuilder);
                    if ("00419".equals(error)){
                        return error;
                    }
                }else {
                    //排除双字节情况  即为非中文字符
                    log.info("##### NON CHINESE CHARACTER:{}",str);
                    if(i!=mt103Json.length()-1){
                        if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1){
                            if ("(".equals(String.valueOf(c)) || " ".equals(String.valueOf(c))){
                                stringBuilder.append(c);
                            }else {
                                stringBuilder.append(c + " ");
                            }
                        }else {
                            if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                                stringBuilder.append(c+ " ");
                            }else {
                                stringBuilder.append(c);
                            }
                        }
                    }else {
                        stringBuilder.append(c);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 根据中文和简繁体标识查电码
     * @return
     */
    public String findTeleCodeByCn(char c,String mt103Json,String traditionalFlag,int i,StringBuilder stringBuilder){
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        if ("Y".equals(traditionalFlag)) {
            //繁体查繁体电码 根据汉字去查询电码
            PgSintrateleDO pgSintrateleDO = new PgSintrateleDO();
            pgSintrateleDO.setGlyph(String.valueOf(c));
            List<PgSintrateleDO> pgSintrateleDOList = pgSintrateleDao.findList(pgSintrateleDO);
            List<PgSintrateleDO> pgSintrateleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSintrateleDO sintrateleDO : pgSintrateleDOList) {
                if (!"delete".equals(sintrateleDO.getTeleAction())){
                    pgSintrateleDOS.add(sintrateleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSintrateleDOS.size() > 1 || pgSintrateleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSintrateleDO.getGlyph());
                return "00419";
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1))) || " ".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            }
        } else if ("N".equals(traditionalFlag)) {
            //简体中文查简体电码  根据汉字去查询电码
            PgSinteleDO pgSinteleDO = new PgSinteleDO();
            pgSinteleDO.setGlyph(String.valueOf(c));
            List<PgSinteleDO> pgSinteleDaoList = pgSinteleDao.findList(pgSinteleDO);
            List<PgSinteleDO> pgSinteleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSinteleDO sinteleDO : pgSinteleDaoList) {
                if (!"delete".equals(sinteleDO.getTeleAction())){
                    pgSinteleDOS.add(sinteleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSinteleDOS.size() > 1 || pgSinteleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSinteleDO.getGlyph());
                return "00419";
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode() + " ");
                }else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1))) || " ".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            }
        }
        return null;
    }

    /**
     * 根据中文和简繁体标识查电码(双字节汉字)
     * @return
     */
    public String findTeleCodeByDouCn(String douStr,String mt103Json,String traditionalFlag,int i,StringBuilder stringBuilder){
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        if ("Y".equals(traditionalFlag)) {
            //繁体查繁体电码 根据汉字去查询电码
            PgSintrateleDO pgSintrateleDO = new PgSintrateleDO();
            log.info("##### DOUBLE BYTE CHINESE CHARACTER:{}",douStr);
            pgSintrateleDO.setGlyph(douStr);
            List<PgSintrateleDO> pgSintrateleDOList = pgSintrateleDao.findList(pgSintrateleDO);
            List<PgSintrateleDO> pgSintrateleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSintrateleDO sintrateleDO : pgSintrateleDOList) {
                if (!"delete".equals(sintrateleDO.getTeleAction())){
                    pgSintrateleDOS.add(sintrateleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSintrateleDOS.size() > 1 || pgSintrateleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSintrateleDO.getGlyph());
                return "00419";
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            }
        } else if ("N".equals(traditionalFlag)) {
            //简体中文查简体电码  根据汉字去查询电码
            PgSinteleDO pgSinteleDO = new PgSinteleDO();
            log.info("##### DOUBLE BYTE CHINESE CHARACTER:{}",douStr);
            pgSinteleDO.setGlyph(douStr);
            List<PgSinteleDO> pgSinteleDaoList = pgSinteleDao.findList(pgSinteleDO);
            List<PgSinteleDO> pgSinteleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSinteleDO sinteleDO : pgSinteleDaoList) {
                if (!"delete".equals(sinteleDO.getTeleAction())){
                    pgSinteleDOS.add(sinteleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSinteleDOS.size() > 1 || pgSinteleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSinteleDO.getGlyph());
                return "00419";
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            }
        }
        return null;
    }

    /**
     * 对Fmt103的域进行中文转电码
     *
     * @param fmt103
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt103 getTagCnToTeleFor103(Fmt103 fmt103, String traditionalFlag) {
        //F50
        if (JudgeUtils.isNotNull(fmt103.getF50K())) {
            List<String> ordCustAddrList = fmt103.getF50K().getOrdCustAddrList();
            List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
            fmt103.getF50K().setOrdCustAddrList(newList);
        }
        if (JudgeUtils.isNotNull(fmt103.getF50F())) {
            List<String> ordCustAddrList = fmt103.getF50F().getOrdCustAddrList();
            List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
            fmt103.getF50F().setOrdCustAddrList(newList);
        }
        //F52
        if (JudgeUtils.isNotNull(fmt103.getF52D())){
            List<String> ordInstAddrList = fmt103.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt103.getF52D().setOrdInstAddrList(newList);
        }
        //F53
        if (JudgeUtils.isNotNull(fmt103.getF53D())){
            List<String> sndCorrAddrList = fmt103.getF53D().getSndCorrAddrList();
            List<String> newList = cnListToCnTele(sndCorrAddrList, traditionalFlag);
            fmt103.getF53D().setSndCorrAddrList(newList);
        }
        //F54
        if (JudgeUtils.isNotNull(fmt103.getF54D())){
            List<String> rcvCorrAddrList = fmt103.getF54D().getRcvCorrAddrList();
            List<String> newList = cnListToCnTele(rcvCorrAddrList, traditionalFlag);
            fmt103.getF54D().setRcvCorrAddrList(newList);
        }
        //F55
        if (JudgeUtils.isNotNull(fmt103.getF55D())){
            List<String> reimInstAddrList = fmt103.getF55D().getReimInstAddrList();
            List<String> newList = cnListToCnTele(reimInstAddrList, traditionalFlag);
            fmt103.getF55D().setReimInstAddrList(newList);
        }
        //F56
        if (JudgeUtils.isNotNull(fmt103.getF56D())){
            List<String> medInstAddrList = fmt103.getF56D().getMedInstAddrList();
            List<String> newList = cnListToCnTele(medInstAddrList, traditionalFlag);
            fmt103.getF56D().setMedInstAddrList(newList);
        }
        //F57
        if (JudgeUtils.isNotNull(fmt103.getF57D())){
            List<String> actInstAddrList = fmt103.getF57D().getActInstAddrList();
            List<String> newList = cnListToCnTele(actInstAddrList, traditionalFlag);
            fmt103.getF57D().setActInstAddrList(newList);
        }
        //F59
        if (JudgeUtils.isNotNull(fmt103.getF59())){
            List<String> benfCustAddrList = fmt103.getF59().getBenfCustAddrList();
            List<String> newList = cnListToCnTele(benfCustAddrList, traditionalFlag);
            fmt103.getF59().setBenfCustAddrList(newList);
        }
        if (JudgeUtils.isNotNull(fmt103.getF59F())){
            List<String> benfCustAddrList = fmt103.getF59F().getBenfCustAddrList();
            List<String> newList = cnListToCnTele(benfCustAddrList, traditionalFlag);
            fmt103.getF59F().setBenfCustAddrList(newList);
        }
        //F70
        if (JudgeUtils.isNotNull(fmt103.getF70())){
            List<String> remitInfoList = fmt103.getF70().getRemitInfoList();
            List<String> newList = cnListToCnTele(remitInfoList, traditionalFlag);
            fmt103.getF70().setRemitInfoList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt103.getF72())){
            List<String> srInfoList = fmt103.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt103.getF72().setSrInfoList(newList);
        }
        return fmt103;
    }

    /**
     * 对Fmt200的域进行中文转电码
     * @param fmt200
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt200 getTagCnToTeleFor200(Fmt200 fmt200, String traditionalFlag) {
        //F53
//        if (JudgeUtils.isNotNull(fmt200.getF53D())){
//            List<String> sndCorrAddrList = fmt200.getF53D().getSndCorrAddrList();
//            List<String> newList = cnListToCnTele(sndCorrAddrList, traditionalFlag);
//            fmt200.getF53D().setSndCorrAddrList(newList);
//        }
        //F56
        if (JudgeUtils.isNotNull(fmt200.getF56D())){
            List<String> medInstAddrList = fmt200.getF56D().getMedInstAddrList();
            List<String> newList = cnListToCnTele(medInstAddrList, traditionalFlag);
            fmt200.getF56D().setMedInstAddrList(newList);
        }
        //F57
        if (JudgeUtils.isNotNull(fmt200.getF57D())){
            List<String> actInstAddrList = fmt200.getF57D().getActInstAddrList();
            List<String> newList = cnListToCnTele(actInstAddrList, traditionalFlag);
            fmt200.getF57D().setActInstAddrList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt200.getF72())){
            List<String> srInfoList = fmt200.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt200.getF72().setSrInfoList(newList);
        }
        return fmt200;
    }

    /**
     * 对202报文特定的域中文转电码
     * @param fmt202
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt202 getTagCnToTeleFor202(Fmt202 fmt202, String traditionalFlag) {
        //F52
        if (JudgeUtils.isNotNull(fmt202.getF52D())){
            List<String> ordInstAddrList = fmt202.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt202.getF52D().setOrdInstAddrList(newList);
        }
        //F53
        if (JudgeUtils.isNotNull(fmt202.getF53D())){
            List<String> sndCorrAddrList = fmt202.getF53D().getSndCorrAddrList();
            List<String> newList = cnListToCnTele(sndCorrAddrList, traditionalFlag);
            fmt202.getF53D().setSndCorrAddrList(newList);
        }
        //F54
        if (JudgeUtils.isNotNull(fmt202.getF54D())){
            List<String> rcvCorrAddrList = fmt202.getF54D().getRcvCorrAddrList();
            List<String> newList = cnListToCnTele(rcvCorrAddrList, traditionalFlag);
            fmt202.getF54D().setRcvCorrAddrList(newList);
        }
        //F56
        if (JudgeUtils.isNotNull(fmt202.getF56D())){
            List<String> medInstAddrList = fmt202.getF56D().getMedInstAddrList();
            List<String> newList = cnListToCnTele(medInstAddrList, traditionalFlag);
            fmt202.getF56D().setMedInstAddrList(newList);
        }
        //F57
        if (JudgeUtils.isNotNull(fmt202.getF57D())){
            List<String> actInstAddrList = fmt202.getF57D().getActInstAddrList();
            List<String> newList = cnListToCnTele(actInstAddrList, traditionalFlag);
            fmt202.getF57D().setActInstAddrList(newList);
        }
        //F58
        if (JudgeUtils.isNotNull(fmt202.getF58D())){
            List<String> benfInstAddrList = fmt202.getF58D().getBenfInstAddrList();
            List<String> newList = cnListToCnTele(benfInstAddrList, traditionalFlag);
            fmt202.getF58D().setBenfInstAddrList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt202.getF72())){
            List<String> srInfoList = fmt202.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt202.getF72().setSrInfoList(newList);
        }
        return fmt202;
    }

    /**
     * MTN99报文的F79 中文转电码
     * @param f79
     * @param traditionalFlag
     * @return
     */
    @Override
    public F79 cnToTeleForN99(F79 f79,String traditionalFlag){
        List<String> narratList = f79.getNarratList();
        List<String> newList = cnListToCnTele(narratList, traditionalFlag);
        f79.setNarratList(newList);
        return f79;
    }

    /**
     * 含F72域的报文
     * @param f72
     * @param traditionalFlag
     * @return
     */
    @Override
    public F72 CnToTeleForF72(F72 f72, String traditionalFlag) {
        List<String> srInfoList = f72.getSrInfoList();
        List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
        f72.setSrInfoList(newList);
        return f72;
    }

    /**
     * 对210特定的域进行中文转电码
     * @param fmt210
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt210 getTagCnToTeleFor210(Fmt210 fmt210, String traditionalFlag) {
        List<MTBlock> mtBlocks = fmt210.getmTBlockList();
        for (MTBlock mtBlock : mtBlocks) {
            //F50
            if (JudgeUtils.isNotNull(mtBlock.getF50())){
                List<String> ordCustAddrList = mtBlock.getF50().getOrdCustAddrList();
                List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
                mtBlock.getF50().setOrdCustAddrList(newList);
            }
            //F50F
            if (JudgeUtils.isNotNull(mtBlock.getF50F())){
                List<String> ordCustAddrList = mtBlock.getF50F().getOrdCustAddrList();
                List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
                mtBlock.getF50F().setOrdCustAddrList(newList);
            }
            //F52D
            if (JudgeUtils.isNotNull(mtBlock.getF52D())){
                List<String> ordInstAddrList = mtBlock.getF52D().getOrdInstAddrList();
                List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
                mtBlock.getF52D().setOrdInstAddrList(newList);
            }
            //F56D
            if (JudgeUtils.isNotNull(mtBlock.getF56D())){
                List<String> medInstAddrList = mtBlock.getF56D().getMedInstAddrList();
                List<String> newList = cnListToCnTele(medInstAddrList, traditionalFlag);
                mtBlock.getF56D().setMedInstAddrList(newList);
            }
        }
        return fmt210;
    }

    /**
     * 对FMT190含中文的域转电码
     * @param fmt190
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt190 getTagCnToTeleFor190(Fmt190 fmt190, String traditionalFlag) {
        //F52D
        if (JudgeUtils.isNotNull(fmt190.getF52D())){
            List<String> ordInstAddrList = fmt190.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt190.getF52D().setOrdInstAddrList(newList);
        }
        //F71B
        if (JudgeUtils.isNotNull(fmt190.getF71B())){
            List<String> chgDetlList = fmt190.getF71B().getChgDetlList();
            List<String> newList = cnListToCnTele(chgDetlList, traditionalFlag);
            fmt190.getF71B().setChgDetlList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt190.getF72())){
            List<String> srInfoList = fmt190.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt190.getF72().setSrInfoList(newList);
        }
        return fmt190;
    }

    /**
     * 对FMT290含中文的域转电码
     * @param fmt290
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt290 getTagCnToTeleFor290(Fmt290 fmt290, String traditionalFlag) {
        //F52D
        if (JudgeUtils.isNotNull(fmt290.getF52D())){
            List<String> ordInstAddrList = fmt290.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt290.getF52D().setOrdInstAddrList(newList);
        }
        //F71B
        if (JudgeUtils.isNotNull(fmt290.getF71B())){
            List<String> chgDetlList = fmt290.getF71B().getChgDetlList();
            List<String> newList = cnListToCnTele(chgDetlList, traditionalFlag);
            fmt290.getF71B().setChgDetlList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt290.getF72())){
            List<String> srInfoList = fmt290.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt290.getF72().setSrInfoList(newList);
        }
        return fmt290;
    }

    /**
     * 对FMT191含中文的域转电码
     * @param fmt191
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt191 getTagCnToTeleFor191(Fmt191 fmt191, String traditionalFlag) {
        //F52D
        if (JudgeUtils.isNotNull(fmt191.getF52D())){
            List<String> ordInstAddrList = fmt191.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt191.getF52D().setOrdInstAddrList(newList);
        }
        //F57D
        if (JudgeUtils.isNotNull(fmt191.getF57D())){
            List<String> actInstAddrList = fmt191.getF57D().getActInstAddrList();
            List<String> newList = cnListToCnTele(actInstAddrList, traditionalFlag);
            fmt191.getF57D().setActInstAddrList(newList);
        }
        //F71B
        if (JudgeUtils.isNotNull(fmt191.getF71B())){
            List<String> chgDetlList = fmt191.getF71B().getChgDetlList();
            List<String> newList = cnListToCnTele(chgDetlList, traditionalFlag);
            fmt191.getF71B().setChgDetlList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt191.getF72())){
            List<String> srInfoList = fmt191.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt191.getF72().setSrInfoList(newList);
        }
        return fmt191;
    }

    /**
     * 对FMT291含中文的域转电码
     * @param fmt291
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt291 getTagCnToTeleFor291(Fmt291 fmt291, String traditionalFlag) {
        //F52D
        if (JudgeUtils.isNotNull(fmt291.getF52D())){
            List<String> ordInstAddrList = fmt291.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt291.getF52D().setOrdInstAddrList(newList);
        }
        //F57D
        if (JudgeUtils.isNotNull(fmt291.getF57D())){
            List<String> actInstAddrList = fmt291.getF57D().getActInstAddrList();
            List<String> newList = cnListToCnTele(actInstAddrList, traditionalFlag);
            fmt291.getF57D().setActInstAddrList(newList);
        }
        //F71B
        if (JudgeUtils.isNotNull(fmt291.getF71B())){
            List<String> chgDetlList = fmt291.getF71B().getChgDetlList();
            List<String> newList = cnListToCnTele(chgDetlList, traditionalFlag);
            fmt291.getF71B().setChgDetlList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt291.getF72())){
            List<String> srInfoList = fmt291.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt291.getF72().setSrInfoList(newList);
        }
        return fmt291;
    }

    /**
     * 对FMT196含中文的域转电码
     * @param fmt196
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt196 getTagCnToTeleFor196(Fmt196 fmt196, String traditionalFlag) {
        //F76
        if (JudgeUtils.isNotNull(fmt196.getF76())){
            List<String> answLineList = fmt196.getF76().getAnswLineList();
            List<String> newList = cnListToCnTele(answLineList, traditionalFlag);
            fmt196.getF76().setAnswLineList(newList);
        }
        //F77A
        if (JudgeUtils.isNotNull(fmt196.getF77A())){
            List<String> narrateLineList = fmt196.getF77A().getNarrateLineList();
            List<String> newList = cnListToCnTele(narrateLineList, traditionalFlag);
            fmt196.getF77A().setNarrateLineList(newList);
        }
        //F79
        if (JudgeUtils.isNotNull(fmt196.getF79())){
            List<String> narratList = fmt196.getF79().getNarratList();
            List<String> newList = cnListToCnTele(narratList, traditionalFlag);
            fmt196.getF79().setNarratList(newList);
        }
        return fmt196;
    }

    /**
     * 对FMT296含中文的域转电码
     * @param fmt296
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt296 getTagCnToTeleFor296(Fmt296 fmt296, String traditionalFlag) {
        //F76
        if (JudgeUtils.isNotNull(fmt296.getF76())){
            List<String> answLineList = fmt296.getF76().getAnswLineList();
            List<String> newList = cnListToCnTele(answLineList, traditionalFlag);
            fmt296.getF76().setAnswLineList(newList);
        }
        //F77A
        if (JudgeUtils.isNotNull(fmt296.getF77A())){
            List<String> narrateLineList = fmt296.getF77A().getNarrateLineList();
            List<String> newList = cnListToCnTele(narrateLineList, traditionalFlag);
            fmt296.getF77A().setNarrateLineList(newList);
        }
        //F79
        if (JudgeUtils.isNotNull(fmt296.getF79())){
            List<String> narratList = fmt296.getF79().getNarratList();
            List<String> newList = cnListToCnTele(narratList, traditionalFlag);
            fmt296.getF79().setNarratList(newList);
        }
        return fmt296;
    }

    /**
     * 对FMT900含中文的域转电码
     * @param fmt900
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt900 getTagCnToTeleFor900(Fmt900 fmt900, String traditionalFlag) {
        //F52D
        if (JudgeUtils.isNotNull(fmt900.getF52D())){
            List<String> ordInstAddrList = fmt900.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt900.getF52D().setOrdInstAddrList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt900.getF72())){
            List<String> srInfoList = fmt900.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt900.getF72().setSrInfoList(newList);
        }
        return fmt900;
    }

    /**
     * 对FMT910含中文的域转电码
     * @param fmt910
     * @param traditionalFlag
     * @return
     */
    @Override
    public Fmt910 getTagCnToTeleFor910(Fmt910 fmt910, String traditionalFlag) {
        //F50K
        if (JudgeUtils.isNotNull(fmt910.getF50K())) {
            List<String> ordCustAddrList = fmt910.getF50K().getOrdCustAddrList();
            List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
            fmt910.getF50K().setOrdCustAddrList(newList);
        }
        //F50F
        if (JudgeUtils.isNotNull(fmt910.getF50F())) {
            List<String> ordCustAddrList = fmt910.getF50F().getOrdCustAddrList();
            List<String> newList = cnListToCnTele(ordCustAddrList, traditionalFlag);
            fmt910.getF50F().setOrdCustAddrList(newList);
        }
        //F52D
        if (JudgeUtils.isNotNull(fmt910.getF52D())){
            List<String> ordInstAddrList = fmt910.getF52D().getOrdInstAddrList();
            List<String> newList = cnListToCnTele(ordInstAddrList, traditionalFlag);
            fmt910.getF52D().setOrdInstAddrList(newList);
        }
        //F56D
        if (JudgeUtils.isNotNull(fmt910.getF56D())){
            List<String> medInstAddrList = fmt910.getF56D().getMedInstAddrList();
            List<String> newList = cnListToCnTele(medInstAddrList, traditionalFlag);
            fmt910.getF56D().setMedInstAddrList(newList);
        }
        //F72
        if (JudgeUtils.isNotNull(fmt910.getF72())){
            List<String> srInfoList = fmt910.getF72().getSrInfoList();
            List<String> newList = cnListToCnTele(srInfoList, traditionalFlag);
            fmt910.getF72().setSrInfoList(newList);
        }
        return fmt910;
    }

    /**
     * 去掉AC栏位的斜杠
     * @param fmt191
     * @return
     */
    @Override
    public Fmt191 removeAcFor191(Fmt191 fmt191) {
        //F52A
        if (JudgeUtils.isNotNull(fmt191.getF52A())){
            F52A f52A = fmt191.getF52A();
            if (JudgeUtils.isNotNull(f52A.getOrdInstAc())){
                String ordInstAc = f52A.getOrdInstAc();
                String newAc = setAc(ordInstAc);
                f52A.setOrdInstAc(newAc);
                fmt191.setF52A(f52A);
            }
        }
        //F52D
        if (JudgeUtils.isNotNull(fmt191.getF52D())){
            F52D f52D = fmt191.getF52D();
            if (JudgeUtils.isNotNull(f52D.getOrdInstAc())){
                String ordInstAc = f52D.getOrdInstAc();
                String newAc = setAc(ordInstAc);
                f52D.setOrdInstAc(newAc);
                fmt191.setF52D(f52D);
            }
        }
        //F57A
        if (JudgeUtils.isNotNull(fmt191.getF57A())){
            F57A f57A = fmt191.getF57A();
            if (JudgeUtils.isNotNull(f57A.getActInstAc())){
                String actInstAc = f57A.getActInstAc();
                String newAc = setAc(actInstAc);
                f57A.setActInstAc(newAc);
                fmt191.setF57A(f57A);
            }
        }
        //F57B
        if (JudgeUtils.isNotNull(fmt191.getF57B())){
            F57B f57B = fmt191.getF57B();
            if (JudgeUtils.isNotNull(f57B.getActInstAc())){
                String actInstAc = f57B.getActInstAc();
                String newAc = setAc(actInstAc);
                f57B.setActInstAc(newAc);
                fmt191.setF57B(f57B);
            }
        }
        //F57D
        if (JudgeUtils.isNotNull(fmt191.getF57D())){
            F57D f57D = fmt191.getF57D();
            if (JudgeUtils.isNotNull(f57D.getActInstAc())){
                String actInstAc = f57D.getActInstAc();
                String newAc = setAc(actInstAc);
                f57D.setActInstAc(newAc);
                fmt191.setF57D(f57D);
            }
        }
        return fmt191;
    }

    /**
     * 去掉AC栏位的斜杠
     * @param fmt291
     * @return
     */
    @Override
    public Fmt291 removeAcFor291(Fmt291 fmt291) {
        //F52A
        if (JudgeUtils.isNotNull(fmt291.getF52A())){
            F52A f52A = fmt291.getF52A();
            if (JudgeUtils.isNotNull(f52A.getOrdInstAc())){
                String ordInstAc = f52A.getOrdInstAc();
                String newAc = setAc(ordInstAc);
                f52A.setOrdInstAc(newAc);
                fmt291.setF52A(f52A);
            }
        }
        //F52D
        if (JudgeUtils.isNotNull(fmt291.getF52D())){
            F52D f52D = fmt291.getF52D();
            if (JudgeUtils.isNotNull(f52D.getOrdInstAc())){
                String ordInstAc = f52D.getOrdInstAc();
                String newAc = setAc(ordInstAc);
                f52D.setOrdInstAc(newAc);
                fmt291.setF52D(f52D);
            }
        }
        //F57A
        if (JudgeUtils.isNotNull(fmt291.getF57A())){
            F57A f57A = fmt291.getF57A();
            if (JudgeUtils.isNotNull(f57A.getActInstAc())){
                String actInstAc = f57A.getActInstAc();
                String newAc = setAc(actInstAc);
                f57A.setActInstAc(newAc);
                fmt291.setF57A(f57A);
            }
        }
        //F57B
        if (JudgeUtils.isNotNull(fmt291.getF57B())){
            F57B f57B = fmt291.getF57B();
            if (JudgeUtils.isNotNull(f57B.getActInstAc())){
                String actInstAc = f57B.getActInstAc();
                String newAc = setAc(actInstAc);
                f57B.setActInstAc(newAc);
                fmt291.setF57B(f57B);
            }
        }
        //F57D
        if (JudgeUtils.isNotNull(fmt291.getF57D())){
            F57D f57D = fmt291.getF57D();
            if (JudgeUtils.isNotNull(f57D.getActInstAc())){
                String actInstAc = f57D.getActInstAc();
                String newAc = setAc(actInstAc);
                f57D.setActInstAc(newAc);
                fmt291.setF57D(f57D);
            }
        }
        return fmt291;
    }

    /**
     * 将AC栏位第一位斜杠去除
     * @param oldAc
     * @return
     */
    public String setAc(String oldAc){
        String newAc = null;
        if (oldAc.length()>0){
            String slash = oldAc.substring(0, 1);
            if ("/".equals(slash)){
                newAc = oldAc.substring(1);
            }else {
                newAc = oldAc;
            }
        }
        return newAc;
    }


    /**
     *  list中含有中文转换成电码
     * @param oldList
     * @param traditionalFlag
     * @return
     */
    public List<String> cnListToCnTele(List<String> oldList,String traditionalFlag) {
        List<String> newList = new ArrayList<>();
        if (JudgeUtils.isNotNull(oldList)){
            for (String name : oldList) {
                GenericDTO<CnToTeleNumReqDTO> reqDTOGenericDTO = new GenericDTO<>();
                CnToTeleNumReqDTO cnToTeleNumReqDTO = new CnToTeleNumReqDTO();
                cnToTeleNumReqDTO.setInputData(name);
                cnToTeleNumReqDTO.setTraditionalFlag(traditionalFlag);
                reqDTOGenericDTO.setBody(cnToTeleNumReqDTO);
                GenericRspDTO<CnToTeleNumRspDTO> genericRspDTO = messageMaintainService.cnToTeleNum(reqDTOGenericDTO);
                if ("00000".equals(genericRspDTO.getBody().getReturnCode())) {
                    String outputData = genericRspDTO.getBody().getOutputData();
                    newList.add(outputData);
                } else {
                    /*‘00418’- 輸入字符串為空 ‘00419’- 找不到電碼 ‘00421’- 輸出超長*/
                    log.error(genericRspDTO.getBody().getReturnCode());
                    KontException.throwBusinessException(genericRspDTO.getBody().getReturnCode());
                }
            }
            return newList;
        }else {
            return oldList;
        }
    }

    /**
     * 提供给前端栏位中文转电码(主要逻辑)
     * @param mt103Json
     * @param traditionalFlag
     * @return
     */
    @Override
    public CnToTeleDO getStringCnToTele2(String mt103Json, String traditionalFlag) {
        StringBuilder stringBuilder = new StringBuilder();
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        StringBuilder sb = null;
        //记下当前长度
        Integer current = 0;
        StringBuilder overData = new StringBuilder();
        CnToTeleDO cnToTeleDO = new CnToTeleDO();
        //控制输出当前长度条件
        Boolean firCn = false;
        Boolean firCn2 = true;
        Boolean firCn3 = false;
        Boolean firCn4 = false;

        //分组
        try {
            mt103Json = new String(mt103Json.getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            log.error("##### ERROR:{}",e.getMessage());
            log.error("##### EXCEPTION FORMAT STRING TO JSON :{}",mt103Json);
            KontException.throwKontException(MTConstants.STRING_TOJSON_IS_ERROR);
        }
        char c;
        for (int i = 0; i < mt103Json.length(); i++) {

            c = mt103Json.charAt(i);
            int byteLength = String.valueOf(c).getBytes().length;
            //中文字符字节长度大于1  非中文字符字节长度等于1
            if (byteLength > 1) {
                if (i!=mt103Json.length()-1){
                    if (")".equals(String.valueOf(mt103Json.charAt(i+1)))){
                        current = current + 4;
                    }else if(firCn && firCn2){
                        if (firCn3){
                            current = current + 5;
                            firCn = false;
                            firCn2 = false;
                            firCn3 = false;
                            firCn4 = true;
                        }else {
                            current = current + 6;
                            firCn = false;
                            firCn2 = false;
                            firCn4 = true;
                        }
                    }else if (firCn3){
                        current = current + 5;
                        firCn = false;
                        firCn3 = false;
                    }else if (firCn && firCn4){
                        current = current + 6;
                        firCn4 =false;
                    } else {
                        current = current + 5;
                    }
                }else {
                    current = current + 4;
                }

                if (current>35){
                    overData.append(String.valueOf(c));
                }
                String error = findTeleCodeByCn2(c, mt103Json, traditionalFlag, i, stringBuilder);
            } else {
                String str = String.valueOf(c);
                if (Pattern.matches(pattern,str)){
                    //前导代理 [\uD800-\uDBFF]
                    log.info("##### LEADING DOUBLE BYTE CHARACTER:{}",str);
                    sb = new StringBuilder();
                    sb.append(str);
                }else if (Pattern.matches(pattern2,str)){
                    //特殊中文
                    current = current + 5;
                    if (current>35){
                        overData.append(str);
                    }
                    //后导代理 [\uDC00-\uDFFF]
                    log.info("##### AFTER DOUBLE BYTE CHARACTER:{}",str);
                    sb.append(str);
                    log.info("##### CONCATENATE DOUBLE BYTE CHARACTER:{}",sb.toString());
                    String error = findTeleCodeByDouCn2(sb.toString(), mt103Json, traditionalFlag, i, stringBuilder);
                    if (JudgeUtils.isNotNull(error) && error.getBytes().length>1){
                        cnToTeleDO.setReturnError(error);
                        return cnToTeleDO;
                    }
                }else {
                    //非中文+1
                    firCn = true;
                    current = current + 1;
                    if (current>35){
                        overData.append(str);
                    }
                    //排除双字节情况  即为非中文字符
                    log.info("##### NON CHINESE CHARACTER:{}",str);
                    if(i!=mt103Json.length()-1){
                        if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1){
                            if ("(".equals(String.valueOf(c)) || " ".equals(String.valueOf(c))){
                                firCn3 = true;
                                stringBuilder.append(c);
                            }else {
                                stringBuilder.append(c + " ");
                            }
                        }else {
                            if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                                stringBuilder.append(c+ " ");
                            }else {
                                stringBuilder.append(c);
                            }
                        }
                    }else {
                        stringBuilder.append(c);
                    }
                }
            }
        }

        cnToTeleDO.setOutputData(stringBuilder.toString());
        cnToTeleDO.setOverLengthData(overData.toString());
        cnToTeleDO.setCurrentLength(current);
        return cnToTeleDO;
    }

    /**
     * 根据中文和简繁体标识查电码
     * @return
     */
    public String findTeleCodeByCn2(char c,String mt103Json,String traditionalFlag,int i,StringBuilder stringBuilder){
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        if ("Y".equals(traditionalFlag)) {
            //繁体查繁体电码 根据汉字去查询电码
            PgSintrateleDO pgSintrateleDO = new PgSintrateleDO();
            pgSintrateleDO.setGlyph(String.valueOf(c));
            List<PgSintrateleDO> pgSintrateleDOList = pgSintrateleDao.findList(pgSintrateleDO);
            List<PgSintrateleDO> pgSintrateleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSintrateleDO sintrateleDO : pgSintrateleDOList) {
                if (!"delete".equals(sintrateleDO.getTeleAction())){
                    pgSintrateleDOS.add(sintrateleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSintrateleDOS.size() > 1 || pgSintrateleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSintrateleDO.getGlyph());
                stringBuilder.append(String.valueOf(c));
                return null;
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            }
        } else if ("N".equals(traditionalFlag)) {
            //简体中文查简体电码  根据汉字去查询电码
            PgSinteleDO pgSinteleDO = new PgSinteleDO();
            pgSinteleDO.setGlyph(String.valueOf(c));
            List<PgSinteleDO> pgSinteleDaoList = pgSinteleDao.findList(pgSinteleDO);
            List<PgSinteleDO> pgSinteleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSinteleDO sinteleDO : pgSinteleDaoList) {
                if (!"delete".equals(sinteleDO.getTeleAction())){
                    pgSinteleDOS.add(sinteleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSinteleDOS.size() > 1 || pgSinteleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSinteleDO.getGlyph());
                stringBuilder.append(String.valueOf(c));
                return null;
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode() + " ");
                }else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",String.valueOf(c));
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            }
        }
        return null;
    }

    /**
     * 根据中文和简繁体标识查电码(双字节汉字)
     * @return
     */
    public String findTeleCodeByDouCn2(String douStr,String mt103Json,String traditionalFlag,int i,StringBuilder stringBuilder){
        //正则 匹配双字节前导代理
        String pattern = "[\\uD800-\\uDBFF]+";
        //正则 匹配双字节后导代理
        String pattern2 = "[\\uDC00-\\uDFFF]+";
        if ("Y".equals(traditionalFlag)) {
            //繁体查繁体电码 根据汉字去查询电码
            PgSintrateleDO pgSintrateleDO = new PgSintrateleDO();
            log.info("##### DOUBLE BYTE CHINESE CHARACTER:{}",douStr);
            pgSintrateleDO.setGlyph(douStr);
            List<PgSintrateleDO> pgSintrateleDOList = pgSintrateleDao.findList(pgSintrateleDO);
            List<PgSintrateleDO> pgSintrateleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSintrateleDO sintrateleDO : pgSintrateleDOList) {
                if (!"delete".equals(sintrateleDO.getTeleAction())){
                    pgSintrateleDOS.add(sintrateleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSintrateleDOS.size() > 1 || pgSintrateleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSintrateleDO.getGlyph());
                stringBuilder.append(douStr);
                return null;
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1))) || " ".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSintrateleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSintrateleDOS.get(0).getTelexCode());
            }
        } else if ("N".equals(traditionalFlag)) {
            //简体中文查简体电码  根据汉字去查询电码
            PgSinteleDO pgSinteleDO = new PgSinteleDO();
            log.info("##### DOUBLE BYTE CHINESE CHARACTER:{}",douStr);
            pgSinteleDO.setGlyph(douStr);
            List<PgSinteleDO> pgSinteleDaoList = pgSinteleDao.findList(pgSinteleDO);
            List<PgSinteleDO> pgSinteleDOS = new ArrayList<>();
            //查询汉字状态不为delete的电码
            for (PgSinteleDO sinteleDO : pgSinteleDaoList) {
                if (!"delete".equals(sinteleDO.getTeleAction())){
                    pgSinteleDOS.add(sinteleDO);
                }
            }
            //查询汉字对应电码多个或者没有返回错误码
            if (pgSinteleDOS.size() > 1 || pgSinteleDOS.size() < 1) {
                log.error("##### THE CHARACTER CONTAINS MORE THAR ONE CODE OR NO CODE :{}",pgSinteleDO.getGlyph());
                stringBuilder.append(douStr);
                return null;
            }
            //判断最后一个字是否为汉字 为汉字则拼空格  不为汉字则不拼
            if (i != mt103Json.length() - 1) {
                if (String.valueOf(mt103Json.charAt(i + 1)).getBytes().length > 1) {
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode() + " ");
                } else if (Pattern.matches(pattern,String.valueOf(mt103Json.charAt(i + 1)))){
                    stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                }else {
                    if (")".equals(String.valueOf(mt103Json.charAt(i + 1))) || " ".equals(String.valueOf(mt103Json.charAt(i + 1)))){
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                    }else {
                        stringBuilder.append(pgSinteleDOS.get(0).getTelexCode()+" ");
                    }
                }
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            } else {
                stringBuilder.append(pgSinteleDOS.get(0).getTelexCode());
                log.info("##### CHINESE CHARACTER:{}",douStr);
                log.info("##### TELE CODE:{}",pgSinteleDOS.get(0).getTelexCode());
            }
        }
        return null;
    }
}
