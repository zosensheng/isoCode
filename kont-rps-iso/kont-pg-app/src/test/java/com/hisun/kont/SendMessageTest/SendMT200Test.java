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
//import com.hisun.kont.swf.mt.message.MT200;
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
// * @ClassName: SendMT200Test
// * @Date 2022/7/7 16:39
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT200Test extends ApplicationTest{
//
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
//
//    @Test
//    public void TestSendMT200(){
//        Fmt200 fmt200 = new Fmt200();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt200.setF20(f20);
//
//        //F32A
//        F32A f32A = new F32A();
//        f32A.setCur("HKD");
//        f32A.setValDate("230407");
//        f32A.setIntbkSetAmt("100,");
//        fmt200.setF32A(f32A);
//
//        //F58
//        F57D f57D = new F57D();
//        List<String> benList = new ArrayList<>();
//        benList.add("余沛锋");
//        benList.add("深圳");
//        benList.add("高阳金信");
//        f57D.setActInstAddrList(benList);
//        fmt200.setF57D(f57D);
//        //F72
//        F72 f72 = new F72();
//        List<String> srInfoList = new ArrayList<>();
//        srInfoList.add("/ACC/余沛锋");
//        srInfoList.add("/深圳");
//        srInfoList.add("/高阳金信");
//        f72.setSrInfoList(srInfoList);
//        fmt200.setF72(f72);
//
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("200");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt200.setSwHeader(swHeader);
//        GenericDTO<Fmt200> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt200);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT200(genericDTO);
//        if (JudgeUtils.isSuccess(genericRspDTO.getMsgCd())){
//            MtDto mtDto = genericRspDTO.getBody();
//            logger.info("##### check200 success #####");
//            System.out.println(mtDto);
//        }else {
//            logger.info("##### check200 error #####");
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
//        GenericDTO<SendRemit200ReqDTO> sendRemit200ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit200ReqDTO sendRemit200ReqDTO = new SendRemit200ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y","052"));
//        fmt200.setSwHeader(swHeader);
//        sendRemit200ReqDTO.setFmt200(fmt200);
//        sendRemit200ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit200ReqDTO.setReqHead(reqHead);
//        sendRemit200ReqDTOGenericDTO.setBody(sendRemit200ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT200(sendRemit200ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())){
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//
//    }
//}
