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
//import com.hisun.kont.swf.mt.message.MT202;
//import com.hisun.kont.swf.mt.message.MT210;
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
// * @ClassName: SendMT210Test
// * @Date 2022/7/8 10:39
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT210Test extends ApplicationTest {
//    private static final Logger logger = LoggerFactory.getLogger(SendMT202Test.class);
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
//    public void TestSendMT210(){
//        Fmt210 fmt210 = new Fmt210();
//        MT210 mt210 = new MT210();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt210.setF20(f20);
//
//        //F30
//        F30 f30 = new F30();
//        f30.setDate("230407");
//        fmt210.setF30(f30);
//
//        //循环部分
//        List<MTBlock> mTBlockList = new ArrayList<>();
//        MTBlock mtBlock = new MTBlock();
//        //F21
//        F21 f21 = new F21();
//        f21.setRtrn("RPS");
//        mtBlock.setF21(f21);
//        //F32
//        F32B f32B = new F32B();
//        f32B.setCur("HKD");
//        f32B.setIntbkSetAmt("100,");
//        mtBlock.setF32B(f32B);
//        //F50
////        F50 f50 = new F50();
////        List<String> ordCustList = new ArrayList<>();
////        ordCustList.add("余沛锋");
////        ordCustList.add("深圳");
////        ordCustList.add("高阳金信");
////        f50.setOrdCustAddrList(ordCustList);
////        mtBlock.setF50(f50);
//        //F52
////        F52D f52D = new F52D();
////        List<String>ordInstList = new ArrayList<>();
////        ordInstList.add("余沛锋");
////        ordInstList.add("深圳");
////        ordInstList.add("高阳金信");
////        f52D.setOrdInstAddrList(ordInstList);
////        mtBlock.setF52D(f52D);
//        F52A f52A = new F52A();
//        f52A.setOrdInstBic("HKHHHKC0XXX");
//        mtBlock.setF52A(f52A);
//
//        //F56
////        F56D f56D = new F56D();
////        List<String>OrdInst2List = new ArrayList<>();
////        OrdInst2List.add("余沛锋");
////        OrdInst2List.add("深圳");
////        OrdInst2List.add("高阳金信");
////        f56D.setMedInstAddrList(OrdInst2List);
////        mtBlock.setF56D(f56D);
//
//        mTBlockList.add(mtBlock);
//        mTBlockList.add(mtBlock);
//        mTBlockList.add(mtBlock);
//
//        fmt210.setmTBlockList(mTBlockList);
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("210");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt210.setSwHeader(swHeader);
//        GenericDTO<Fmt210> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt210);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT210(genericDTO);
//        if (JudgeUtils.isSuccess(genericRspDTO.getMsgCd())){
//            MtDto mtDto = genericRspDTO.getBody();
//            logger.info("##### check202 success #####");
//            System.out.println(mtDto);
//        }else {
//            logger.info("##### check202 error #####");
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
//        GenericDTO<SendRemit210ReqDTO> sendRemit210ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit210ReqDTO sendRemit210ReqDTO = new SendRemit210ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y","052"));
//        fmt210.setSwHeader(swHeader);
//        sendRemit210ReqDTO.setFmt210(fmt210);
//        sendRemit210ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit210ReqDTO.setReqHead(reqHead);
//        sendRemit210ReqDTOGenericDTO.setBody(sendRemit210ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT210(sendRemit210ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())){
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//
//    }
//}
