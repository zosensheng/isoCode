//package com.hisun.kont.SendMessageTest;
//
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.bocpays.remote.ReqHead;
//import com.hisun.kont.common.utils.JudgeUtils;
//import com.hisun.kont.framework.data.GenericDTO;
//import com.hisun.kont.framework.data.GenericRspDTO;
//import com.hisun.kont.pg.dao.PgstsDao;
//import com.hisun.kont.pg.mt.remote.*;
//import com.hisun.kont.pg.service.AssembleCheckService;
//import com.hisun.kont.pg.service.AssembleService;
//import com.hisun.kont.pg.service.MessageMaintainService;
//import com.hisun.kont.pg.service.impl.CommonAssembleImpl;
//import com.hisun.kont.swf.mt.message.MT202;
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
// * @ClassName: SendMT202Test
// * @Date 2022/7/7 16:21
// * @Description TODO
// * @Version 1.0
// **/
//public class SendMT202Test extends ApplicationTest {
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
//    public void TestSendMT202(){
//        Fmt202 fmt202 = new Fmt202();
//        MT202 mt202 = new MT202();
//        //F20
//        F20 f20 = new F20();
//        f20.setTrn("RPS20220622");
//        fmt202.setF20(f20);
//        //F21
//        F21 f21 = new F21();
//        f21.setRtrn("RPS123");
//        fmt202.setF21(f21);
//        //F32A
//        F32A f32A = new F32A();
//        f32A.setCur("HKD");
//        f32A.setValDate("230407");
//        f32A.setIntbkSetAmt("100,");
//        fmt202.setF32A(f32A);
//
//        //F58
//        F58D f58D = new F58D();
//        List<String> benList = new ArrayList<>();
//        benList.add("余沛锋");
//        benList.add("深圳");
//        benList.add("高阳金信");
//        f58D.setBenfInstAddrList(benList);
//        fmt202.setF58D(f58D);
//        //F72
//        F72 f72 = new F72();
//        List<String> srInfoList = new ArrayList<>();
//        srInfoList.add("/ACC/余沛锋");
//        srInfoList.add("/深圳");
//        srInfoList.add("/高阳金信");
//        f72.setSrInfoList(srInfoList);
//        fmt202.setF72(f72);
//
//        //头部拼接
//        SwHeader swHeader = new SwHeader();
//        BasicHeaderDO basicHeaderDO = new BasicHeaderDO();
//        UserHeaderDO userHeaderDO = new UserHeaderDO();
//        AppHeaderSenderDO appHeaderSenderDO = new AppHeaderSenderDO();
//        basicHeaderDO.setBhSndlt("BKCHHKH0AXXX");
//        appHeaderSenderDO.setAhRcvlt("BKCHBNB0XXXX");
//        appHeaderSenderDO.setAhMpro("N");
//        appHeaderSenderDO.setAhMt("202");
//        appHeaderSenderDO.setAhioFlag("I");
//        userHeaderDO.setOhGpcFlg("001");
//        swHeader.setBasicHeaderDO(basicHeaderDO);
//        swHeader.setAppHeaderSenderDO(appHeaderSenderDO);
//        swHeader.setUserHeaderDO(userHeaderDO);
//        swHeader.setTraditionalFlag("Y");
//        swHeader.setFrModule("or");
//        fmt202.setSwHeader(swHeader);
//        GenericDTO<Fmt202> genericDTO = new GenericDTO<>();
//        genericDTO.setBody(fmt202);
//        GenericRspDTO<MtDto> genericRspDTO = assembleCheckService.assembleCheckMT202(genericDTO);
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
//        GenericDTO<SendRemit202ReqDTO> sendRemit202ReqDTOGenericDTO = new GenericDTO<>();
//        SendRemit202ReqDTO sendRemit202ReqDTO = new SendRemit202ReqDTO();
//        //发出时才生成  报文编号
//        swHeader.setMsgNo(commonAssemble.getMsgNo("Y","052"));
//        fmt202.setSwHeader(swHeader);
//        sendRemit202ReqDTO.setFmt202(fmt202);
//        sendRemit202ReqDTO.setRmcTrx01(rmcTrx01);
//        sendRemit202ReqDTO.setReqHead(reqHead);
//        sendRemit202ReqDTOGenericDTO.setBody(sendRemit202ReqDTO);
//        GenericRspDTO<MtDto> rspDTO = assembleService.assembleMT202(sendRemit202ReqDTOGenericDTO);
//        if (JudgeUtils.isSuccess(rspDTO.getMsgCd())){
//            System.out.println(rspDTO.getBody().getMessage());
//        }
//
//    }
//}
