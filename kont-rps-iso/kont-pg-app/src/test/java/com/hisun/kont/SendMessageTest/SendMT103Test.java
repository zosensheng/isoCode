//package com.hisun.kont.SendMessageTest;
//
//import com.alibaba.fastjson.JSONObject;
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.bocpays.remote.ReqHead;
//import com.hisun.kont.common.utils.JudgeUtils;
//import com.hisun.kont.framework.data.GenericDTO;
//import com.hisun.kont.framework.data.GenericRspDTO;
//import com.hisun.kont.pg.dao.PgstsDao;
//import com.hisun.kont.pg.entity.PgstsDO;
//import com.hisun.kont.pg.mt.remote.*;
//import com.hisun.kont.pg.service.AssembleCheckService;
//import com.hisun.kont.pg.service.AssembleService;
//import com.hisun.kont.pg.service.MessageMaintainService;
//import com.hisun.kont.pg.service.impl.CommonAssembleImpl;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author yupeifeng
// * @ClassName: sendMtTest
// * @Date 2022/6/22 14:56
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT103Test extends ApplicationTest {
//    private static final Logger logger = LoggerFactory.getLogger(SendMT103Test.class);
//    @Resource
//    private AssembleCheckService assembleCheckService;
//
//    @Resource
//    private AssembleService assembleService;
//
//    @Resource
//    private PgstsDao pgstsDao;
//
//    @Resource
//    private MessageMaintainService messageMaintainService;
//
//    @Resource
//    private CommonAssembleImpl commonAssemble;
//
//    @Test
//    public void TestSendMT103(){
//        Fmt103 fmt103 = new Fmt103();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt103.setF20(f20);
//        //F23
//        F23B f23B = new F23B();
//        f23B.setBkOperCd("CRED");
//        fmt103.setF23B(f23B);
//        //F32A
//        F32A f32A = new F32A();
//        f32A.setCur("HKD");
//        f32A.setValDate("230407");
//        f32A.setIntbkSetAmt("100,");
//        fmt103.setF32A(f32A);
//        F33B f33B = new F33B();
//        f33B.setInstAmt("2,");
//        f33B.setInstCur("HKD");
//        fmt103.setF33B(f33B);
//        //F50
//        F50K f50K = new F50K();
//        f50K.setOrdCustAc("525200123456");
//        List<String> ordList = new ArrayList<>();
//        ordList.add("中国银行");
//        ordList.add("深圳高阳");
//        ordList.add("香港中国银行");
//        f50K.setOrdCustAddrList(ordList);
//        fmt103.setF50K(f50K);
//        //F59
//        F59 f59 = new F59();
//        f59.setBenfCustAc("11234");
//        List<String> benList = new ArrayList<>();
//        benList.add("余沛锋");
//        benList.add("深圳");
//        benList.add("高阳金信");
//        f59.setBenfCustAddrList(benList);
//        fmt103.setF59(f59);
//        //F71A
//        F71A f71A = new F71A();
//        f71A.setDetlChg("OUR");
//        fmt103.setF71A(f71A);
//        //F71G
//        F71G f71G = new F71G();
//        f71G.setRcvChgAmt("1,");
//        f71G.setRcvChgCur("HKD");
//        fmt103.setF71G(f71G);
//
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("103");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt103.setSwHeader(swHeader);
//        GenericDTO<Fmt103> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt103);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT103(genericDTO);
//        if (JudgeUtils.isSuccess(genericRspDTO.getMsgCd())){
//            MtDto mtDto = genericRspDTO.getBody();
//            logger.info("##### check103 success #####");
//            System.out.println(mtDto);
//        }else {
//            logger.info("##### check103 error #####");
//        }
//
//        //下面是发报
//        RmcTrx01 rmcTrx01 = new RmcTrx01();
//        rmcTrx01.setFunCode("7");
//        rmcTrx01.setSrcAppl("RPS");
//        rmcTrx01.setToSys("FTM");
//        //reqHead
//        ReqHead reqHead = new ReqHead();
//        reqHead.setTxnCode("23918");
//        reqHead.setBankCode("052");
//        reqHead.setBranchCode("120");
//        reqHead.setAcDate("20230307");
//
//        GenericDTO<SendRemit103ReqDTO> sendRemit103ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit103ReqDTO sendRemit103ReqDTO = new SendRemit103ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y","052"));
//        fmt103.setSwHeader(swHeader);
//        sendRemit103ReqDTO.setFmt103(fmt103);
//        sendRemit103ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit103ReqDTO.setReqHead(reqHead);
//        sendRemit103ReqDTOGenericDTO.setBody(sendRemit103ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT103(sendRemit103ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())){
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//
//    }
//
//    @Test
//    public void getMtMessage(){
//        PgstsDO byMsgNo = pgstsDao.getByMsgNo("052202206295000102");
//        String mtBean = byMsgNo.getMtBean();
//        RmcTrx01 rmcTrx01 = JSONObject.parseObject(mtBean, RmcTrx01.class);
//        System.out.println(rmcTrx01);
//    }
//
//    @Test
//    public void testCnToTele(){
//        GenericDTO<CnToTeleNumFrontReqDTO> genericDTO = new GenericDTO<>();
//        CnToTeleNumFrontReqDTO cnToTeleNumFrontReqDTO = new CnToTeleNumFrontReqDTO();
//        cnToTeleNumFrontReqDTO.setInputData("ABABAA中国香港银(高AAA");
//        cnToTeleNumFrontReqDTO.setTraditionalFlag("Y");
//        genericDTO.setBody(cnToTeleNumFrontReqDTO);
//        GenericRspDTO<CnToTeleNumFrontRspDTO> genericRspDTO = messageMaintainService.cnToTeleNumFront(genericDTO);
//        CnToTeleNumFrontRspDTO body = genericRspDTO.getBody();
//        System.out.println(body);
//    }
//}
