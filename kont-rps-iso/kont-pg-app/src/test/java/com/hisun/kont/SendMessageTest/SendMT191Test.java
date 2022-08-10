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
//import com.hisun.kont.swf.mt.message.MT191;
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
// * @ClassName: SendMT191Test
// * @Date 2022/7/8 15:53
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT191Test extends ApplicationTest {
//
//    private static final Logger logger = LoggerFactory.getLogger(SendMT191Test.class);
//
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
//    public void TestSendMT191() {
//        Fmt191 fmt191 = new Fmt191();
//        MT191 mt191 = new MT191();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt191.setF20(f20);
//        //F21
//        F21 f21 = new F21();
//        f21.setRtrn("RPS123");
//        fmt191.setF21(f21);
//        //F32B
//        F32B f32B = new F32B();
//        f32B.setIntbkSetAmt("100,");
//        f32B.setCur("HKD");
//        fmt191.setF32B(f32B);
//        //F32C
//
//        //F52
//        F52D f52D = new F52D();
//        List<String> ordList = new ArrayList<>();
//        ordList.add("1");
//        ordList.add("2");
//        ordList.add("3");
//        f52D.setOrdInstAddrList(ordList);
//        fmt191.setF52D(f52D);
//
//        //F71B
//        F71B f71B = new F71B();
//        List<String> chgList = new ArrayList<>();
//        chgList.add("1");
//        chgList.add("2");
//        chgList.add("3");
//        f71B.setChgDetlList(chgList);
//        fmt191.setF71B(f71B);
//        //F71G
//        F72 f72 = new F72();
//        List<String> srInfoList = new ArrayList<>();
//        srInfoList.add("/ACC/中国香港");
//        srInfoList.add("/庆祝回归");
//        srInfoList.add("/25周年");
//        f72.setSrInfoList(srInfoList);
//        fmt191.setF72(f72);
//
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("191");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt191.setSwHeader(swHeader);
//        GenericDTO<Fmt191> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt191);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT191(genericDTO);
//        if (JudgeUtils.isSuccess(genericRspDTO.getMsgCd())) {
//            MtDto mtDto = genericRspDTO.getBody();
//            logger.info("##### check103 success #####");
//            System.out.println(mtDto);
//        } else {
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
//        GenericDTO<SendRemit191ReqDTO> sendRemit191ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit191ReqDTO sendRemit191ReqDTO = new SendRemit191ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y", "052"));
//        fmt191.setSwHeader(swHeader);
//        sendRemit191ReqDTO.setFmt191(fmt191);
//        sendRemit191ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit191ReqDTO.setReqHead(reqHead);
//        sendRemit191ReqDTOGenericDTO.setBody(sendRemit191ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT191(sendRemit191ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())) {
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//    }
//    }
