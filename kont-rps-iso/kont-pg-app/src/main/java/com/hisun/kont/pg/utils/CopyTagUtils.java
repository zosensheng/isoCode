package com.hisun.kont.pg.utils;

import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.impl.PgstpswfServiceImpl;
import com.hisun.kont.swf.mt.message.MT103;
import com.hisun.kont.swf.mt.message.header.*;
import com.hisun.kont.swf.mt.message.subItem.BaseMessage;
import com.hisun.kont.swf.mt.message.subItem.TreeTag;
import com.hisun.kont.swf.mt.tag.*;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.*;

@Component
public class CopyTagUtils {

    private static final Logger logger = LoggerFactory.getLogger(CopyTagUtils.class);

    public static final ThreadLocal<String> threadLocal = new ThreadLocal();

    //先获取转码映射集合
    private static final Map<String, Map> MT_MAP = MTParseCodeConfig.getMap();

    private static HashMap<String, Class> instanceTagMap = new HashMap<String, Class>() {{
        put("Tag11R", Tag11R.class);
        put("Tag11S", Tag11S.class);
        put("Tag13C", Tag13C.class);
        put("Tag13D", Tag13D.class);
        put("Tag19", Tag19.class);
        put("Tag20", Tag20.class);
        put("Tag21", Tag21.class);
        put("Tag21A", Tag21A.class);
        put("Tag21C", Tag21C.class);
        put("Tag23B", Tag23B.class);
        put("Tag23E", Tag23E.class);
        put("Tag25", Tag25.class);
        put("Tag25P", Tag25P.class);
        put("Tag26T", Tag26T.class);
        put("Tag27", Tag27.class);
        put("Tag28C", Tag28C.class);
        put("Tag30", Tag30.class);
        put("Tag32A", Tag32A.class);
        put("Tag32B", Tag32B.class);
        put("Tag32C", Tag32C.class);
        put("Tag32D", Tag32D.class);
        put("Tag32K", Tag32K.class);
        put("Tag33A", Tag33A.class);
        put("Tag33B", Tag33B.class);
        put("Tag33C", Tag33C.class);
        put("Tag33D", Tag33D.class);
        put("Tag33K", Tag33K.class);
        put("Tag36", Tag36.class);
        put("Tag45A", Tag45A.class);
        put("Tag46A", Tag46A.class);
        put("Tag47A", Tag47A.class);
        put("Tag49G", Tag49G.class);
        put("Tag49H", Tag49H.class);
        put("Tag50", Tag50.class);
        put("Tag50A", Tag50A.class);
        put("Tag50C", Tag50C.class);
        put("Tag50D", Tag50D.class);
        put("Tag50F", Tag50F.class);
        put("Tag50K", Tag50K.class);
        put("Tag51A", Tag51A.class);
        put("Tag52A", Tag52A.class);
        put("Tag52B", Tag52B.class);
        put("Tag52D", Tag52D.class);
        put("Tag53A", Tag53A.class);
        put("Tag53B", Tag53B.class);
        put("Tag53D", Tag53D.class);
        put("Tag54A", Tag54A.class);
        put("Tag54B", Tag54B.class);
        put("Tag54D", Tag54D.class);
        put("Tag55A", Tag55A.class);
        put("Tag55B", Tag55B.class);
        put("Tag55D", Tag55D.class);
        put("Tag56A", Tag56A.class);
        put("Tag56C", Tag56C.class);
        put("Tag56D", Tag56D.class);
        put("Tag57A", Tag57A.class);
        put("Tag57B", Tag57B.class);
        put("Tag57C", Tag57C.class);
        put("Tag57D", Tag57D.class);
        put("Tag58A", Tag58A.class);
        put("Tag58B", Tag58B.class);
        put("Tag58D", Tag58D.class);
        put("Tag59", Tag59.class);
        put("Tag59A", Tag59A.class);
        put("Tag59F", Tag59F.class);
        put("Tag60F", Tag60F.class);
        put("Tag60M", Tag60M.class);
        put("Tag61", Tag61.class);
        put("Tag62F", Tag62F.class);
        put("Tag62M", Tag62M.class);
        put("Tag64", Tag64.class);
        put("Tag65", Tag65.class);
        put("Tag70", Tag70.class);
        put("Tag71A", Tag71A.class);
        put("Tag71B", Tag71B.class);
        put("Tag71F", Tag71F.class);
        put("Tag71G", Tag71G.class);
        put("Tag72", Tag72.class);
        put("Tag73", Tag73.class);
        put("Tag74", Tag74.class);
        put("Tag75", Tag75.class);
        put("Tag76", Tag76.class);
        put("Tag77A", Tag77A.class);
        put("Tag77B", Tag77B.class);
        put("Tag77D", Tag77D.class);
        put("Tag79", Tag79.class);
        put("Tag86", Tag86.class);
        put("Test71F", Test71F.class);
    }};

    private static HashMap<String, Class> instanceFtagMap = new HashMap<String, Class>() {{

        put("F11R", F11R.class);
        put("F11S", F11S.class);
        put("F13C", F13C.class);
        put("F13D", F13D.class);
        put("F20", F20.class);
        put("F21", F21.class);
        put("F23B", F23B.class);
        put("F23E", F23E.class);
        put("F25", F25.class);
        put("F25P", F25P.class);
        put("F26T", F26T.class);
        put("F28C", F28C.class);
        put("F30", F30.class);
        put("F32A", F32A.class);
        put("F32B", F32B.class);
        put("F32C", F32C.class);
        put("F32D", F32D.class);
        put("F33B", F33B.class);
        put("F36", F36.class);
        put("F50A", F50A.class);
        put("F50F", F50F.class);
        put("F50K", F50K.class);
        put("F51A", F51A.class);
        put("F52A", F52A.class);
        put("F52D", F52D.class);
        put("F53A", F53A.class);
        put("F53B", F53B.class);
        put("F53D", F53D.class);
        put("F54A", F54A.class);
        put("F54B", F54B.class);
        put("F54D", F54D.class);
        put("F55A", F55A.class);
        put("F55B", F55B.class);
        put("F55D", F55D.class);
        put("F56A", F56A.class);
        put("F56C", F56C.class);
        put("F56D", F56D.class);
        put("F57A", F57A.class);
        put("F57B", F57B.class);
        put("F57C", F57C.class);
        put("F57D", F57D.class);
        put("F58A", F58A.class);
        put("F58D", F58D.class);
        put("F59", F59.class);
        put("F59A", F59A.class);
        put("F59F", F59F.class);
        put("F60F", F60F.class);
        put("F60M", F60M.class);
        put("F61", F61.class);
        put("F62F", F62F.class);
        put("F62M", F62M.class);
        put("F64", F64.class);
        put("F70", F70.class);
        put("F71A", F71A.class);
        put("F71B", F71B.class);
        put("F71F", F71F.class);
        put("F71G", F71G.class);
        put("F72", F72.class);
        put("F76", F76.class);
        put("F77A", F77A.class);
        put("F77B", F77B.class);
        put("F79", F79.class);
    }};

    //记录需要进行电码转译的报文类型，先定为文档里面的几个
    private static final Map<String, String> checkMTList = new HashMap<String, String>() {{
        //59可能会出错
        put("MT103", "50A;50K;50F;51A;52A;52D;53A;53B;53D;54A;54B;54D;55A;55B;55D;56A;56C;56D;57A;57B;57C;57D;59;59A;70;72");
        put("MT200", "53A;53D;56A;56D;57A;57B;57D;72");
        put("MT202", "52A;52D;53A;53B;53D;54A;54B;54D;56A;56D;57A;57B;57D;58A;58D;72");
    }};

    private static final Map<String, Map<String, Field>> checkMTListv2 = new HashMap<String, Map<String, Field>>() {{
        //存入需要中文转码的属性
        try {
            put("MT103", new HashMap<String, Field>() {{
                put("50A", Tag50A.class.getDeclaredField("ordCustAc"));
                put("51A", Tag51A.class.getDeclaredField("sndInstAc"));
            }});
        } catch (Exception e) {
            System.out.println("go wrong");
            e.printStackTrace();
        }
    }};

    @Autowired
    private static PgstpswfServiceImpl pgstpswfServiceImpl = new PgstpswfServiceImpl();


    //包含了以下命名的字符串不做电转中
    private static String noCheckAttr = "ordCustAc;sndInstAc;ordInstAc;sndCorrAc";


    /**
     * 将tag  put进去mt报文。
     *
     * @param mt
     * @param tag
     */
    public static void putObjectIntoMt(Object mt, Object tag) {
        if (null == tag)
            return;
        BaseMessage mt1 = (BaseMessage) mt;
        mt1.putTagDataList((BaseTag) tag);
        logger.info("Put :{} Into :{} Suss", tag.toString(), mt1.getTxCode());
    }


    /**
     * @param filedName
     * @param source
     * @param <T>
     * @return
     */
    private static <T> T cpOneFied(String filedName, Object source, String typeFlag) {
        if (null == source) {
            return null;
        }
        //需要判断是否为tag属性 如果不为tag属性要返回null（因为可能会有头部属性）；
        String firstStr = filedName.substring(0, 1);
        if (!"f".equals(firstStr)) {
            return null;
        }
        String substring = "";
        if ("List".equals(typeFlag)) {
            substring = filedName.substring(1, filedName.length() - 4);
        } else if ("Object".equals(typeFlag)) {
            substring = filedName.substring(1, filedName.length());
        }
        String UpperStr = substring.toUpperCase();
        String tagStr = "Tag" + UpperStr;
        Class tagClass = instanceTagMap.get(tagStr);
        T tar = null;
        try {
            tar = (T) tagClass.newInstance();
        } catch (Exception e) {
            logger.error("CP:{} Into :{} faild", filedName, tagStr);
            KontException.throwKontException(MTConstants.COPY_ONE_FAIL);
        }

        try {
            boolean allFieldNull = isAllFieldNull(source);
            if (allFieldNull) {
                logger.info("Ftag:{} is empty :{} ", filedName, tagStr);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        BeanUtils.copyProperties(source, tar);
//        T tar = (T) BeanUtils.copyPropertiesNewObjectIgnoreCase(source, tagClass);
        logger.info("CP:{} Into :{}", filedName, tagStr);

        return tar;
    }

    /**
     * 校验对象属性是否都为null
     *
     * @param obj 对象
     * @return
     * @throws Exception
     */
    public static boolean isAllFieldNull(Object obj) throws Exception {
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        for (Field f : fs) {//遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值
            if (val != null) {//只要有1个属性不为空,那么就不是所有的属性值都为空
                flag = false;
                break;
            }
        }
        return flag;
    }


    /**
     * 将mt接收对象 映射进mt内置对象
     */
    public static void mappingDtoToMt(Object sourceDto, Object tarDto) {

        //通过反射获取所有的属性 遍历
        ReflectUtils reflectUtils = new ReflectUtils();

        /*Object[] filedValues = reflectUtils.getFiledValues(sourceDto);
        List filedsInfo = reflectUtils.getFiledsInfo(sourceDto);*/
        String[] filedNames = reflectUtils.getFiledName(sourceDto);
        Object[] value = new Object[filedNames.length];
        for (int i = 0; i < filedNames.length; i++) {
            String filedName = filedNames[i];
            value[i] = reflectUtils.getFieldValueByName(filedName, sourceDto);

            if (value[i] == null) {
                continue;
            }
            if (value[i] instanceof List) {
                List<Object> objects = (List<Object>) value[i];
                objects.stream().filter(r -> null != r).forEach(p -> putObjectIntoMt(tarDto, cpOneFied(filedName, p, "List")));
                logger.info("Put{}  Suss", filedName);

            } else {
                Object o = cpOneFied(filedName, value[i], "Object");
                putObjectIntoMt(tarDto, o);
                logger.info("Put{}  Suss", filedName);
            }
        }

    }


    public static void main(String[] args) throws Exception {
        Object obj = checkMTListv2.get("MT103");
        System.out.println(obj);
        MT103 mt103 = new MT103();
        Tag20 tag20 = new Tag20();
        tag20.setTrn("123456");
        mt103.putTagDataList(tag20);
        Tag50A tag50A = new Tag50A();
        tag50A.setOrdCustAc("qowejwqoejowqeowq");
        tag50A.setOrdCustBic("0425  name dsada ok!   0426 0428 0431 (0435 0440)");
        mt103.putTagDataList(tag50A);

        Tag52D tag52D = new Tag52D();
        List<String> list = new ArrayList<>();
        list.add("阿猫");
        list.add("阿狗");
        list.add("cat");
        list.add("dog");
        tag52D.setOrdInstAddrList(list);
        mt103.putTagDataList(tag52D);


        Tag13C tag13C = new Tag13C();
        tag13C.setTimeCode("11111111");
        tag13C.setTimeIndC("111111111111111111");

        Tag13C tag13C2 = new Tag13C();
        tag13C2.setTimeCode("22222222");
        tag13C2.setTimeIndC("222222222222222222");
        mt103.putTagDataList(tag13C);
        mt103.putTagDataList(tag13C2);
//        MT103ReqDTO mt103ReqDTO = new MT103ReqDTO();
//        mappingMtToDto(mt103, mt103ReqDTO);

    }


    /**
     * 将mt对象复制到传输对象
     *
     * @param sourceDto
     * @param tarDto
     */
    public static void mappingMtToDto(Object sourceDto, Object tarDto) throws Exception {
        //true 为390收报自动派分 默认将电码转中文  为false为不转中文
        Boolean toCnFlag = true;
        mappingMtToDtoByCnFlag(sourceDto,tarDto,toCnFlag);
    }

    /**
     * 检验某报文中的某标签是否需要做电码转中文(似乎可以合并同一个方法)
     *
     * @param baseTagName 报文类型 如MT103,MT200,MT202
     * @param tagStr      报文业务tag属性，如MT103 中的20,50A，72等等
     * @param baseTags    tag属性对应的属性值
     * @return
     */
    private static ArrayList<BaseTag> checkNeedParseForList(String baseTagName, String tagStr, ArrayList<BaseTag> baseTags) throws IllegalAccessException, InstantiationException {
        //如果报文不支持中文的，直接跳过
        if (!MT_MAP.containsKey(baseTagName)) {
            return baseTags;
        }
        //获取报文种类的map 如MT103_MAP
        Map<String, Map> map = MT_MAP.get(baseTagName);
        //获取tag，如50A，51A等等
        Map<String, MTParseCodeConfig.MapRule> tagMap = map.get(tagStr);
        //准备复制一个新的BaseTag,不需要改动的tag，引用和sourceDto一样，需要改动的tag，生成新的Tag实例替换
        ArrayList<BaseTag> returnBaseTags = new ArrayList();
        if (null != tagMap) {
            //无论是单条还是多条，传进来的都是baseTags
            for (BaseTag tag : baseTags) {
                //获取所有field，开始遍历属性
                Field[] fields = tag.getClass().getDeclaredFields();
                //创建新的baseTag，以防引用改动sourceDto  eg.  50A 52D 实例
                BaseTag cloneTag = tag.getClass().newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    //获取字段的MapRule，记录了字段信息
                    MTParseCodeConfig.MapRule attrMapRule = tagMap.get(field.getName());
                    if (null == field.get(tag)){
                        continue;
                    }
                    //没在Config类中添加的属性value为空，attrMapRule 为空说明该属性不可转,直接将属性值存入新对象
                    if (null == attrMapRule ) {
                        //目前mt字段類型數據都使用的Sting 如果不是說明不是報文字段 跳過
                        boolean isStrFalg = field.get(tag) instanceof String;
                        if(!isStrFalg){
                            continue;
                        }
//                        System.out.println("shouldnt parse : " + tagStr + " " + field.getName() + " " + field.get(tag));
                        field.set(cloneTag, field.get(tag));
                    } else {//如果可以进行转换，则需要作进一步判断
                        //如果是列表，根据MapRule看看是否需要转
                        if (field.get(tag) instanceof List) {
                            //获取隔离行evitLine，暂时设定0为全部转，1为第一行不为转
                            Integer evitLine = attrMapRule.getEvitLine();
                            //先把list属性取出来
                            List dataList = (List) field.get(tag);
                            //由于用的是浅复制，所以这里需要用新的列表，否则会影响原对象
                            List parseDataList = new ArrayList(dataList.size());
                            //遍历列表，将转换后的值存会list中
                            for (int i = 0; i < ((List) field.get(tag)).size(); i++) {


                                //这个判断后面可以根据报文内容确定转还是不准
                                /*if ((evitLine == 1 && i == 0) && true) { //符合这个条件的直接存入list中
                                    System.out.println("shouldn't parse : " + tagStr + " " + field.getName() + " " + field.get(tag) + " " + dataList.get(i));
                                    parseDataList.add(dataList.get(i));
                                    System.out.println(parseDataList);
                                    //System.out.println("should parse : " + field.getName()+" "+field.get(tag)+" "+parseDataList.get(i));
                                    *//*String CN_word =PgstpswfUtil.teleToChinese((String)dataList.get(i));
                                    field.set(tag,CN_word);
                                    dataList.set(i,CN_word);*//*
                                } else { */ //其余的要转换

//                                System.out.println("should parse : " + tagStr + " " + field.getName() + " " + field.get(tag) + " " + dataList.get(i));
                                String CN_word = PgstpswfUtil.teleToChinese((String) dataList.get(i), tagStr);
                                parseDataList.add(CN_word);
//                                System.out.println("CN_word " + CN_word);
//                                System.out.println(parseDataList);
                                /*}*/
                            }
                            //替换原来的属性
                            field.set(cloneTag, parseDataList);
                            //如果是字符串，直接转即可
                        } else if (field.get(tag) instanceof String) {
//                            System.out.println("should parse : " + field.getName() + " " + field.get(tag));
                            /*String CN_word =PgstpswfUtil.teleToChinese((String) field.get(tag));
                            System.out.println("CN_word ："+CN_word);
                            field.set(tag,CN_word);*/
                            //转完之后，将字符串传入cloneTag中
                            String CN_word = PgstpswfUtil.teleToChinese((String) field.get(tag), field.getName());
                            field.set(cloneTag, CN_word);
                        }
                    }
                }
                //克隆后的标签直接存入，不确定是否会导致乱序，待测试
                returnBaseTags.add(cloneTag);

            }
            return returnBaseTags;
        } else {
            //return returnBaseTags;
            return baseTags;
        }
    }

    /**
     * 检验某报文中的某标签是否需要做电码转中文
     *
     * @param baseTagName 报文类型 如MT103,MT200,MT202
     * @param tagStr      报文业务tag属性，如MT103 中的20,50A，72等等
     * @param baseTags    tag属性对应的属性值
     * @return
     */

    private static boolean checkNeedParseForObject(String baseTagName, String tagStr, ArrayList<BaseTag> baseTags) throws IllegalAccessException {

        //获取对应的报文类型的Tags列表，暂为自己定义的列表，后续最好放入数据库中
        String tags = checkMTList.get(baseTagName);
        //判断tags列表是否包含了目标标签，如果tag在集合中则需要做转化
        if (tags.contains(tagStr)) {
            for (BaseTag tag : baseTags) {
                //获取所有field，开始遍历属性
                Field[] fields = tag.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);

                    //Map map =MTParseCodeConfig.MT_MAP.get(baseTagName);

                    //如果不包含accountinfo并且value不为空，则需要转换
                    if ((field.getName().endsWith("Ac")) || null == field.get(tag)) {
                        System.out.println("shouldnt parse : " + field.getName() + " " + field.get(tag));
                    } else {
                        //如果是List需要遍历
                        if (field.get(tag) instanceof List) {
                            for (Object data : (List) field.get(tag)) {
                                String CN_word = PgstpswfUtil.teleToChinese((String) data, field.getName());
                                field.set(tag, CN_word);
                            }
                        } else if (field.get(tag) instanceof String) {
                            String CN_word = PgstpswfUtil.teleToChinese((String) field.get(tag), field.getName());
                            System.out.println("CN_word ：" + CN_word);
                            field.set(tag, CN_word);
                        }
                    }
                }
            }
        }
        return false;
    }


    private static <T> List<T> cpListFtagDto(List<BaseTag> baseTags, Class<T> ftagClass) {
        List<T> ftagList = new ArrayList<>();
        for (BaseTag tag : baseTags) {
            try {
                T ftag = ftagClass.newInstance();
                //
                BeanUtils.copyProperties(tag, ftag);
                ftagList.add(ftag);
            } catch (Exception e) {
                logger.error("CP:{}  err", ftagClass.getName());
            }
//            T ftag = BeanUtils.copyPropertiesNewObjectIgnoreCase(tag, ftagClass);
        }

        return ftagList;

    }


    /**
     * 拼接set/get方法
     *
     * @param fiedName
     * @param preStr
     * @param endStr
     * @return
     */
    static String methodString(String flag, String fiedName, String preStr, String endStr) {
//        char[] cs=preStr.toCharArray();
//        cs[0]-=32;
//        String firstUpNameStr = String.valueOf(cs);
//        String methodStr = flag + preStr + firstUpNameStr + endStr;
        String methodStr = flag + preStr + fiedName + endStr;

        return methodStr;

    }


    /**
     * 头部映射  此处的I 指汇入拆解，O指汇出报文,和报文2方向标志不同
     *
     * @param flag
     * @param swHeader
     * @param baseMessage
     */
    public static void CphaderInfo(String flag, SwHeader swHeader, BaseMessage baseMessage) {
        logger.info("##### START TO COPY SWHEADER TO BASSMESSAGE #####");
        //所有逻辑开始于swHeader 的属性值获取，是否需要加判断
        if ("I".equals(flag)) {


            BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
            AppHeaderReciverDO appHeaderReciverDO = new AppHeaderReciverDO();
            AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
            UserHeaderDO userHeaderDO = new UserHeaderDO();

            BasicHeaderBlock basicHeaderBlock = baseMessage.getBasicHeaderBlock();
            AppHeaderBlock appHeaderBlock = baseMessage.getAppHeaderBlock();

            //basic 头部映射
            basicHeaderDO.setBhApdu(basicHeaderBlock.getBhApdu());
            basicHeaderDO.setBhAppFlag(basicHeaderBlock.getBhAppFlag());
            basicHeaderDO.setBhIsn(basicHeaderBlock.getBhIsn());
            basicHeaderDO.setBhSndlt(basicHeaderBlock.getBhSndlt());
            basicHeaderDO.setBhSessNo(basicHeaderBlock.getBhSessNo());
            //赋值
            swHeader.setBasicHeaderDO(basicHeaderDO);

            //接收 app头
            if (appHeaderBlock instanceof AppHeaderReciverBlock) {
                AppHeaderReciverBlock appHeaderReciverBlock = (AppHeaderReciverBlock) appHeaderBlock;
                appHeaderReciverDO.setAhioFlag(appHeaderReciverBlock.getAhioFlag());
                appHeaderReciverDO.setAhMpro(appHeaderReciverBlock.getAhMpro());
                appHeaderReciverDO.setAhMt(appHeaderReciverBlock.getAhMt());
                appHeaderReciverDO.setAhRefNo(appHeaderReciverBlock.getAhRefNo());
                appHeaderReciverDO.setAhst(appHeaderReciverBlock.getAhst());
                appHeaderReciverDO.setAhRecDate(appHeaderReciverBlock.getAhRecDate());
                appHeaderReciverDO.setAhRecTime(appHeaderReciverBlock.getAhRecTime());
                //赋值
                swHeader.setAppHeaderReciverDO(appHeaderReciverDO);
            } else if (appHeaderBlock instanceof AppHeaderSenderBlock) {
                AppHeaderSenderBlock appHeaderSenderBlock = (AppHeaderSenderBlock) appHeaderBlock;
                appHeaderSenderDO.setAhioFlag(appHeaderSenderBlock.getAhioFlag());
                appHeaderSenderDO.setAhMpro(appHeaderSenderBlock.getAhMpro());
                appHeaderSenderDO.setAhMt(appHeaderSenderBlock.getAhMt());
                appHeaderSenderDO.setAhFailTime(appHeaderSenderBlock.getAhFailTime());
                appHeaderSenderDO.setAhRcvlt(appHeaderSenderBlock.getAhRcvlt());
                appHeaderSenderDO.setAhWhFlag(appHeaderSenderBlock.getAhWhFlag());
                //赋值
                swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
            }

            //user 头
            if (JudgeUtils.isNotNull(baseMessage.getUserHeaderBlock())){
                UserHeaderBlock userHeaderBlock = baseMessage.getUserHeaderBlock();
                userHeaderDO.setOhCov(userHeaderBlock.getOhCov());
                userHeaderDO.setOhGpcFlg(userHeaderBlock.getOhGpcFlg());
                userHeaderDO.setOhGpiRef(userHeaderBlock.getOhGpiRef());
                userHeaderDO.setOhCov(userHeaderBlock.getOhCov());
                userHeaderDO.setOhHkl(userHeaderBlock.getOhHkl());

                //赋值
                swHeader.setUserHeaderDO(userHeaderDO);
            }

            //報尾 賦值
            if (JudgeUtils.isNotNull(baseMessage.getTrailersBlock())){
                TrailersBlockDO trailersBlockDO = new TrailersBlockDO();
                TrailersBlock trailersBlock = baseMessage.getTrailersBlock();
                String mtRetryFlag = trailersBlock.getMtRetryFlag();
                if ("PDE".equals(mtRetryFlag)){
                    trailersBlockDO.setMtRetryFlag(mtRetryFlag);
                    trailersBlockDO.setMtPdeNm(trailersBlock.getMtPdeNm());
                }else{
                    trailersBlockDO.setMtRetryFlag(mtRetryFlag);
                    trailersBlockDO.setMtPdmNm(trailersBlock.getMtPdmNm());
                }
                swHeader.setTrailersBlockDO(trailersBlockDO);
            }
            //電碼一對多，或者找不到電碼對應漢字時
            String msgTeleStatus = threadLocal.get();
            if (JudgeUtils.isNotNull(msgTeleStatus)) {
                //是否存在電碼一對多，一對多或者找不到時不轉換，但是要給標誌
                swHeader.setMsgTeleStatus(msgTeleStatus);
            }
            threadLocal.remove();

        } else if ("O".equals(flag)) {

            //这四个参数加个校验
            AppHeaderReciverDO appHeaderReciverDOs = swHeader.getAppHeaderReciverDO();
            AppHeaderSenderDO appHeaderSenderDOs = swHeader.getAppHeaderSenderDO();
            BasicHeaderDO basicHeaderDOs = swHeader.getBasicHeaderDO();
            UserHeaderDO userHeaderDOs = swHeader.getUserHeaderDO();
            //1.receiver和sender有且只能有一个
            //2.其余的不能为空
            if (JudgeUtils.isNotNull(appHeaderReciverDOs)) {
                if (JudgeUtils.isNotNull(appHeaderSenderDOs)) {
                    //两个都有也不行
                    KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS__NOT_EMPTY);
                }
                AppHeaderReciverBlock appHeaderReciverBlock = new AppHeaderReciverBlock();
                appHeaderReciverBlock.setAhRecTime(appHeaderReciverDOs.getAhRecTime());
                appHeaderReciverBlock.setAhRecDate(appHeaderReciverDOs.getAhRecDate());
                appHeaderReciverBlock.setAhst(appHeaderReciverDOs.getAhst());
                appHeaderReciverBlock.setAhRefNo(appHeaderReciverDOs.getAhRefNo());
                //电文优先级 不传默认为N  传 用应用的
                if (JudgeUtils.isNotNull(appHeaderReciverDOs.getAhMpro())){
                    appHeaderReciverBlock.setAhMpro(appHeaderReciverDOs.getAhMpro());
                }else {
                    appHeaderReciverDOs.setAhMpro("N");
                    appHeaderReciverBlock.setAhMpro("N");
                }
                appHeaderReciverBlock.setAhMt(appHeaderReciverDOs.getAhMt());
                appHeaderReciverBlock.setAhioFlag(appHeaderReciverDOs.getAhioFlag());
                baseMessage.setAppHeaderBlock(appHeaderReciverBlock);
            } else if (JudgeUtils.isNotNull(appHeaderSenderDOs)) {
                AppHeaderSenderBlock appHeaderSender = new AppHeaderSenderBlock();
                appHeaderSender.setAhMt(appHeaderSenderDOs.getAhMt());
                //检查报文传11位bic  需要网关补足一位
                if (appHeaderSenderDOs.getAhRcvlt().length() == 11) {
                    String ahRcvlt = appHeaderSenderDOs.getAhRcvlt();
                    appHeaderSender.setAhRcvlt(StringUtils.join(StringUtils.substring(ahRcvlt, 0, 8), "X", StringUtils.substring(ahRcvlt, 8, 11)));
                } else {
                    appHeaderSender.setAhRcvlt(appHeaderSenderDOs.getAhRcvlt());
                }
                //电文优先级 不传默认为N  传 用应用的
                if (JudgeUtils.isNotNull(appHeaderSenderDOs.getAhMpro())){
                    appHeaderSender.setAhMpro(appHeaderSenderDOs.getAhMpro());
                }else {
                    appHeaderSenderDOs.setAhMpro("N");
                    appHeaderSender.setAhMpro("N");
                }
                appHeaderSender.setAhFailTime(appHeaderSenderDOs.getAhFailTime());
                appHeaderSender.setAhWhFlag(appHeaderSenderDOs.getAhWhFlag());
                appHeaderSender.setAhioFlag(appHeaderSenderDOs.getAhioFlag());
                baseMessage.setAppHeaderBlock(appHeaderSender);
            } else {
                //这个是两个都为空的情况，要抛出错误
                KontException.throwBusinessException(MTConstants.MT_GEN_APP_HEADER_SENDER_AND_RECEVIE_IS_EMPTY);
            }

            //报尾，可以为空
            TrailersBlock trailersBlock = new TrailersBlock();
            if (JudgeUtils.isNotNull(swHeader.getTrailersBlockDO())) {
                TrailersBlockDO trailersBlockDOs = swHeader.getTrailersBlockDO();
                if (JudgeUtils.isNotEmpty(trailersBlockDOs.getMtPdeNm())) {
                    trailersBlock.setMtPdeNm(trailersBlockDOs.getMtPdeNm());
                    trailersBlock.setMtRetryFlag("PDE");
                    baseMessage.setTrailersBlock(trailersBlock);
                }
                if (JudgeUtils.isNotEmpty(trailersBlockDOs.getMtPdmNm())) {
                    trailersBlock.setMtPdmNm(trailersBlockDOs.getMtPdmNm());
                    trailersBlock.setMtRetryFlag("PDM");
                    baseMessage.setTrailersBlock(trailersBlock);
                }

            }

            if (JudgeUtils.isNotNull(basicHeaderDOs)) {
                BasicHeaderBlock basicHeader = new BasicHeaderBlock();
                if (JudgeUtils.isNotNull(basicHeaderDOs.getBhIsn())) {
                    basicHeader.setBhIsn(basicHeaderDOs.getBhIsn());
                }
                if (JudgeUtils.isNotNull(basicHeaderDOs.getBhSessNo())) {
                    basicHeader.setBhSessNo(basicHeaderDOs.getBhSessNo());
                }
                if (basicHeaderDOs.getBhSndlt().length() == 11) {
                    basicHeader.setBhSndlt(StringUtils.join(StringUtils.substring(basicHeaderDOs.getBhSndlt(), 0, 8), "A", StringUtils.substring(basicHeaderDOs.getBhSndlt(), 8, 11)));
                }else {
                    basicHeader.setBhSndlt(basicHeaderDOs.getBhSndlt());
                }
                baseMessage.setBasicHeaderBlock(basicHeader);
            } else {
                KontException.throwBusinessException(MTConstants.MT_GEN_BASIC_HEADER_IS_EMPTY);
            }


            if (JudgeUtils.isNotNull(userHeaderDOs)) {
                UserHeaderBlock userHeader = new UserHeaderBlock();
                String ohGpcFlg = userHeaderDOs.getOhGpcFlg();
                String ohGpiRef = userHeaderDOs.getOhGpiRef();
                if (JudgeUtils.isNull(ohGpcFlg)){
                    //应用没传 网关负责生成103的111域
                    if ("103".equals(baseMessage.getTxCode())){
                        userHeader.setOhGpcFlg("001");
                        userHeaderDOs.setOhGpcFlg("001");
                    }
                }else {
                    userHeader.setOhGpcFlg(ohGpcFlg);
                }
                //判断121域里面的值是否有值 没有网关自动生成103 202 GPI199 的 121
                if (JudgeUtils.isNull(ohGpiRef)) {
                    if ("103".equals(baseMessage.getTxCode())||"202".equals(baseMessage.getTxCode()) ||("199".equals(baseMessage.getTxCode())&&
                            ("001".equals(swHeader.getUserHeaderDO().getOhGpcFlg())||"002".equals(swHeader.getUserHeaderDO().getOhGpcFlg())))){
                        userHeader.setOhGpiRef(GenF121Utils.GenF121Id());
                        userHeaderDOs.setOhGpiRef(userHeader.getOhGpiRef());
                    }
                } else {
                    userHeader.setOhGpiRef(ohGpiRef);
                }
                //chats电文标识 传1标识chats电文
                if ("1".equals(userHeaderDOs.getChatsFlag())) {
                    userHeader.setChatsFlag(true);
                } else {
                    userHeader.setChatsFlag(false);
                }
                userHeader.setOhMuref(userHeaderDOs.getOhMuref());
                userHeader.setOhCov(userHeaderDOs.getOhCov());
                userHeader.setOhHkl(userHeaderDOs.getOhHkl());
                baseMessage.setUserHeaderBlock(userHeader);
            }else {
                //没有userHeader  网关负责帮忙生成121
                UserHeaderBlock userHeader = new UserHeaderBlock();
                userHeaderDOs = new UserHeaderDO();
                if ("103".equals(baseMessage.getTxCode())||"202".equals(baseMessage.getTxCode())){
                    userHeader.setOhGpiRef(GenF121Utils.GenF121Id());
                    userHeaderDOs.setOhGpiRef(userHeader.getOhGpiRef());
                }
                //应用没传 网关负责生成103的111域
                if ("103".equals(baseMessage.getTxCode())){
                    userHeader.setOhGpcFlg("001");
                    userHeaderDOs.setOhGpcFlg("001");
                }
                swHeader.setUserHeaderDO(userHeaderDOs);
                baseMessage.setUserHeaderBlock(userHeader);
            }
        }
        logger.info("##### END TO COPY SWHEADER TO BASSMESSAGE #####");

    }

    /**
     * 将mt对象复制到传输对象
     *
     * @param sourceDto
     * @param tarDto
     */
    public static void mappingMtToDtoByCnFlag(Object sourceDto, Object tarDto, Boolean toCnFlag) throws Exception {
        //sourceDto：mt报文原型
        BaseMessage baseMessageObj = (BaseMessage) sourceDto;

        //因为不能对原对象做更改，所以用sourceDto做深克隆，用生成的对象来生成tarDto
        BaseMessage cloneObj = new BaseMessage();
        BeanUtils.copyProperties(sourceDto, cloneObj);
        //baseMessageObj = SerializationUtils.clone(baseMessageObj);

        //TreeTag 为一个描述报文field信息的类，如描述20，50这些； ArrayList 中记录的为 field对应的值
        //BaseTag 为Tag数据的父类，有一些与TreeTag一样的属性，属性value为对应的值
        //所以此处的TreeMap 为键值对：（field 信息 - field的值），记录了某个报文所有的Tag信息与对应数据
        TreeMap<TreeTag, ArrayList<BaseTag>> messageTagTree = baseMessageObj.getMessageTagTree();
        //取出报文中所有的tag信息
        Set<TreeTag> treeTags = messageTagTree.keySet();
        //遍历
        for (TreeTag key : treeTags) {
            //根据tag从List中拿到对应的数据，因为有些tag可以有多个值
            ArrayList<BaseTag> baseTags = messageTagTree.get(key);
            //如果tag允许有多个值，并且数据不为空
            if (key.getLoopFlag() && null != baseTags) {
                //支持循环结构 单个tag循环
                //List new ArrayList<>()
                //获取标签名字，即表格中Tag一列的值，如20,21R，50A...
                String tagStr = baseTags.get(0).getName();
                //String substring = tagStr.substring(3,tagStr.length());
                //拼接Tag名字
                String ftagStr = "F" + tagStr;
                //先把baseTags中的电码转成中文
                if (toCnFlag){
                    //判断是否需要转码，传入报文类型以及对应得到Tag标签
                    String classPath = sourceDto.getClass().getName();
                    //拼接出MT类型
                    String MTType = classPath.substring(classPath.lastIndexOf(".") + 1, classPath.length());

                    baseTags = checkNeedParseForList(MTType, tagStr, baseTags);
                }
                //instanceFtagMap是一个记录了所有标签的属性
                //将数据拷贝进一个list中
                List list = cpListFtagDto(baseTags, instanceFtagMap.get(ftagStr));

                //拼接方法名
                String setMethodString = methodString("set", ftagStr, "", "List");
                //利用反射把List中的数据设置进tarDto里面，tarDto为最终转换的实例
                BeanUtils.setValueFromClass(tarDto, setMethodString, List.class, list);

            } else if (null != baseTags) {
                //不支持循环结构
                String tagStr = baseTags.get(0).getName();
//                    String substring = tagStr.substring(3,tagStr.length());
                String ftagStr = "F" + tagStr;

                Class tagClass = instanceFtagMap.get(ftagStr);
                //先把baseTags中的电码转成中文
                if (toCnFlag){
                    //判断是否需要转码，传入报文类型以及对应得到Tag标签
                    String classPath = sourceDto.getClass().getName();
                    //拼接出MT类型
                    String MTType = classPath.substring(classPath.lastIndexOf(".") + 1, classPath.length());

                    baseTags = checkNeedParseForList(MTType, tagStr, baseTags);
                }
                /*if（）{

                    Object ftag = BeanUtils.copyPropertiesNewObjectIgnoreCase(xxxxx, tagClass);
                    tagClass
                }*/
                //浅复制一个标签数据 ， 如52A，50A等等
                Object ftag = BeanUtils.copyPropertiesNewObjectIgnoreCase(baseTags.get(0), tagClass);

                //拼接方法名
                String setMethodString = methodString("set", ftagStr, "", "");
                //利用反射把List中的数据设置进tarDto里面，tarDto为最终转换的实例
                BeanUtils.setValueFromClass(tarDto, setMethodString, tagClass, ftag);
//                System.out.println();
            }
        }
    }
}
