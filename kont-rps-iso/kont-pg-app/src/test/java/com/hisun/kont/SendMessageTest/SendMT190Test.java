//package com.hisun.kont.SendMessageTest;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.bocpays.remote.ReqHead;
//import com.hisun.kont.common.utils.JudgeUtils;
//import com.hisun.kont.framework.data.GenericDTO;
//import com.hisun.kont.framework.data.GenericRspDTO;
//import com.hisun.kont.pg.mt.remote.*;
//import com.hisun.kont.pg.service.AssembleCheckService;
//import com.hisun.kont.pg.service.AssembleService;
//import com.hisun.kont.pg.service.impl.CommonAssembleImpl;
//import com.hisun.kont.swf.mt.message.MT190;
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
// * @ClassName: SendMT190Test
// * @Date 2022/7/7 15:47
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT190Test extends ApplicationTest {
//
//    private static final Logger logger = LoggerFactory.getLogger(SendMT190Test.class);
//    @Resource
//    private AssembleCheckService assembleCheckService;
//
//    @Resource
//    private AssembleService assembleService;
//
//    @Resource
//    private CommonAssembleImpl commonAssemble;
//
//    @Test
//    public void TestSendMT190(){
//        Fmt190 fmt190 = new Fmt190();
//        MT190 mt190 = new MT190();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt190.setF20(f20);
//        //F21
//        F21 f21 = new F21();
//        f21.setRtrn("RPS123");
//        fmt190.setF21(f21);
//        //F25
//        F25 f25 = new F25();
//        f25.setActIndAc("0526666");
//        fmt190.setF25(f25);
//        //F32C
//        F32C f32C = new F32C();
//        f32C.setCur("HKD");
//        f32C.setValDate("230407");
//        f32C.setIntbkSetAmt("100,");
//        fmt190.setF32C(f32C);
//        //F52
//        F52D f52D = new F52D();
//        List<String> ordList = new ArrayList<>();
//        ordList.add("1");
//        ordList.add("2");
//        ordList.add("3");
//        f52D.setOrdInstAddrList(ordList);
//        fmt190.setF52D(f52D);
//
//        //F71B
//        F71B f71B = new F71B();
//        List<String> chgList = new ArrayList<>();
//        chgList.add("中国强大");
//        chgList.add("中国强大");
//        chgList.add("中国强大");
//        f71B.setChgDetlList(chgList);
//        fmt190.setF71B(f71B);
//        //F71G
//        F72 f72 = new F72();
//        List<String> srInfoList = new ArrayList<>();
//        srInfoList.add("/ACC/中国香港");
//        srInfoList.add("/庆祝回归");
//        srInfoList.add("/25周年");
//        f72.setSrInfoList(srInfoList);
//        fmt190.setF72(f72);
//
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("190");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt190.setSwHeader(swHeader);
//        GenericDTO<Fmt190> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt190);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT190(genericDTO);
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
//        GenericDTO<SendRemit190ReqDTO> sendRemit190ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit190ReqDTO sendRemit190ReqDTO = new SendRemit190ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y","052"));
//        fmt190.setSwHeader(swHeader);
//        sendRemit190ReqDTO.setFmt190(fmt190);
//        sendRemit190ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit190ReqDTO.setReqHead(reqHead);
//        sendRemit190ReqDTOGenericDTO.setBody(sendRemit190ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT190(sendRemit190ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())){
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//
//    }
//}
