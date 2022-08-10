//package com.hisun.kont.MT;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.hisun.kont.ApplicationTest;
//import com.hisun.kont.framework.data.GenericDTO;
//import com.hisun.kont.framework.data.GenericRspDTO;
//import com.hisun.kont.framework.utils.IdGenUtils;
//import com.hisun.kont.pg.dao.PgstsDao;
//import com.hisun.kont.pg.entity.PgstsDO;
//import com.hisun.kont.pg.mt.remote.*;
//import com.hisun.kont.pg.service.AssembleCheckService;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class MTCheckTest extends ApplicationTest {
//
//    @Autowired
//    private PgstsDao pgstsDao;
//
//    @Autowired
//    private AssembleCheckService checkService;
//
//    @Test
//    public void testCheckMT103() throws Exception {
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106169001415");
//
//        String json = pgstsDO.getMtBean();
//        json = "{\"msgNo\":null,\"trailersBlockDOs\":{\"mtRetryFlag\":null,\"mtPdmNm\":null,\"mtPdeNm\":\"1348120811BANKFRPPA2222123456\"},\"" +
//                "f20\":{\"trn\":\"353ALT17081910\"},\"f13CList\":[{\"timeIndC\":\"/CLSTIME/1201+0620\"}],\"f23B\":{\"bkOperCd\":\"CRED\"},\"" +
//                "f23EList\":[{\"instrCd\":\"PHOB\",\"instrDetl\":\"this is attachInfo\"}],\"f26T\":{\"tranTypeCd\":\"ABC\"},\"f32A\":{\"valDate\"" +
//                ":\"200731\",\"cur\":\"HKD\",\"intbkSetAmt\":\"850,00\"},\"f33B\":{\"instCur\":\"HKD\",\"instAmt\":\"1000,00\"},\"f36\":{\"exRate" +
//                "\":\"7,7552\"},\"f50A\":{\"ordCustAc\":\"LINZHONG\",\"ordCustBic\":\"CMACMOMXXXX\"},\"f50K\":null,\"f50F\":null,\"f51A\":{\"sndInstType\"" +
//                ":\"D\",\"sndInstAc\":\"linzhong\",\"sndInstBic\":\"CMACMOMXXXX\"},\"f52A\":null,\"f52D\":{\"ordInstType\":\"E\",\"ordInstAc\":\"" +
//                "linzhong\",\"ordInstAddrList\":[\"beijing\",\"shanghai\"]},\"f53A\":null,\"f53B\":null,\"f53D\":{\"sndInstType\":\"E\",\"sndCorrAc\"" +
//                ":\"linzhong\",\"sndCorrAddrList\":[\"beijing\",\"shanghai\"]},\"f54A\":null,\"f54B\":{\"rcvCorrType\":\"E\",\"rcvCorrAc\":\"linzhong\"" +
//                ",\"rcvCorrBic\":\"tianjin\"},\"f54D\":null,\"f55A\":null,\"f55B\":null,\"f55D\":{\"reimInstType\":\"A\",\"reimInstAc\":\"zmm\"," +
//                "\"reimInstAddrList\":[\"beijing\"]},\"f56A\":null,\"f56C\":null,\"f56D\":{\"medInstType\":\"B\",\"medInstAc\":\"LINZHONG\"," +
//                "\"medInstAddrList\":[\"DSBAHKH0XXX\"]},\"f57A\":null,\"f57B\":null,\"f57C\":null,\"f57D\":{\"actInstType\":\"A\",\"actInstAc\":" +
//                "\"zmm\",\"actInstAddrList\":[\"beijing\"]},\"f59\":null,\"f59A\":{\"benfCustAc\":\"linzhong\",\"benfCustBic\":\"CMACMOMXXXX\"}," +
//                "\"f59F\":null,\"f70\":{\"remitInfoList\":[\"TEST CHATS FOR OR 103\"]},\"f71A\":{\"detlChg\":\"SHA\"},\"f71FList\":[{\"sndChgCur\"" +
//                ":\"HKD\",\"sndChgAmt\":\"1000,00\"}],\"f71G\":{\"rcvChgCur\":\"HKD\",\"rcvChgAmt\":\"1000,00\"},\"f72\":{\"srInfoList\":" +
//                "[\"//SPRO/01/DEPN/06\"]},\"f77B\":{\"rglCode\":\"SPRO\",\"rglCtyCode\":\"ab\",\"rglRptNa\":\"/DEPN 06\",\"rglRptList\":" +
//                "[\"SPROab/DEPN 06\"]},\"basicHeaderDOs\":{\"bhAppFlag\":null,\"bhApdu\":null,\"bhSndlt\":\"BKOJOUMNA300\",\"bhSessNo\":\"0001\"," +
//                "\"bhIsn\":\"000002\"},\"appHeaderSenderDOs\":{\"ahioFlag\":\"O\",\"ahMt\":\"103\",\"ahMpro\":\"N\",\"ahRcvlt\":\"PONCHKH0XXX\"," +
//                "\"ahWhFlag\":null,\"ahFailTime\":null},\"appHeaderReciverDOs\":null,\"userHeaderDOs\":{\"ohMuref\":\"353ALT17081910\",\"ohHkl\":" +
//                "null,\"ohCov\":null,\"ohGpcFlg\":\"001\",\"ohGpiRef\":\"de070c69-c43d-4b66-b1f3-808ef1b27d01\",\"chatsFlag\":null}}";
//
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT103ReqDTO mt103ReqDTO = JSONObject.toJavaObject(json1,MT103ReqDTO.class);
//        GenericDTO<MT103ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt103ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT103(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT192() throws Exception {
//        //需要自己设
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106169001415");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT192ReqDTO mt192ReqDTO = JSONObject.toJavaObject(json1,MT192ReqDTO.class);
//        GenericDTO<MT192ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt192ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT192(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT292() throws Exception {
//        //需要自己设
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106169001415");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT292ReqDTO mt292ReqDTO = JSONObject.toJavaObject(json1,MT292ReqDTO.class);
//        GenericDTO<MT292ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt292ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT292(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT190() throws Exception {
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106179001667");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT190ReqDTO mt190ReqDTO = JSONObject.toJavaObject(json1,MT190ReqDTO.class);
//        GenericDTO<MT190ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt190ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT190(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT191() throws Exception {
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106179001688");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT191ReqDTO mt191ReqDTO = JSONObject.toJavaObject(json1,MT191ReqDTO.class);
//        GenericDTO<MT191ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt191ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT191(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT290() throws Exception {
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106179001683");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT290ReqDTO mt290ReqDTO = JSONObject.toJavaObject(json1,MT290ReqDTO.class);
//        GenericDTO<MT290ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt290ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT290(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT291() throws Exception {
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106179001689");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT291ReqDTO mt291ReqDTO = JSONObject.toJavaObject(json1,MT291ReqDTO.class);
//        GenericDTO<MT291ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt291ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT291(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testCheckMT950() throws Exception {
//        //需要自己设
//        PgstsDO pgstsDO = pgstsDao.getByMsgNo("052202106169001415");
//
//        String json = pgstsDO.getMtBean();
//        JSON json1 = (JSON) JSONObject.parse(json);
//        MT950ReqDTO mt950ReqDTO = JSONObject.toJavaObject(json1,MT950ReqDTO.class);
//        GenericDTO<MT950ReqDTO> reqDto = new GenericDTO<>();
//        reqDto.setBody(mt950ReqDTO);
//        GenericRspDTO<MtDto> rspDTO =  checkService.assembleCheckMT950(reqDto);
//        System.out.println("break point");
//    }
//
//    @Test
//    public void testSendMT(){
//        for (int i = 0; i <100; i++) {
//            String haha = IdGenUtils.generateId("haha", 2);
//            Integer num = Integer.valueOf(haha);
//            System.out.println(num-1);
//
//        }
//    }
//
//}
