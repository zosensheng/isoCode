package com.hisun.kont.mx.service.impl;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.igw.igw.remote.SendMXSwiftMsgRspDTO;
import com.hisun.kont.mx.constant.SendMxConstant;
import com.hisun.kont.mx.msg.camt.*;
import com.hisun.kont.mx.msg.model.MxWriteParams;
import com.hisun.kont.mx.msg.pacs.*;
import com.hisun.kont.mx.remote.*;
import com.hisun.kont.mx.service.CallOuterService;
import com.hisun.kont.mx.service.SendMxMsgService;
import com.hisun.kont.mx.util.MxWriteImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SendMxMsgServiceImpl implements SendMxMsgService {

    private static final Logger logger = LoggerFactory.getLogger(SendMxMsgServiceImpl.class);

    @Resource
    private CallOuterService callOuterService;

    @Override
    public GenericRspDTO<MxDto> sendPacs00800108Msg(GenericDTO<SendPacs00800108MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND PASC 00800108 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00800108MsgReqDTO sendPacs00800108MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00800108MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00800108MsgReqDTO.getMxPacs00800108())){
            String xml = "";
            MXPacs00800108 mxPacs00800108 = sendPacs00800108MsgReqDTO.getMxPacs00800108();
            Pacs00800108 mx = new Pacs00800108();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08", mx, mxPacs00800108.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXPacs00800108 XML:{}",xml);
            mxPacs00800108.setPacs00800108(mx);
            String message = mxPacs00800108.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXPacs00800108 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00800108MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00800108MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.008.001.08");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXPacs00800108 IS NULL #####");
        }
        logger.info("##### END TO SEND PASC 00800108 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00800108StpMsg(GenericDTO<SendPacs00800108StpMsgReqDTO> reqDto) {
        logger.info("##### START TO SEND PASC 00800108Stp MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00800108StpMsgReqDTO sendPacs00800108StpMsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00800108StpMsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00800108StpMsgReqDTO.getMxPacs00800108Stp())){
            String xml = "";
            MXPacs00800108Stp mxPacs00800108Stp = sendPacs00800108StpMsgReqDTO.getMxPacs00800108Stp();
            Pacs00800108Stp mx = new Pacs00800108Stp();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.008.001.08stp", mx, mxPacs00800108Stp.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXPacs00800108Stp XML:{}",xml);
            mxPacs00800108Stp.setPacs00800108Stp(mx);
            String message = mxPacs00800108Stp.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXPacs00800108Stp MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00800108StpMsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00800108StpMsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.008.001.08stp");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXPacs00800108Stp IS NULL #####");
        }
        logger.info("##### END TO SEND PASC 00800108stp MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00900108Msg(GenericDTO<SendPacs00900108MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND PASC 00900108 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00900108MsgReqDTO sendPacs00900108MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00900108MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00900108MsgReqDTO.getMxPacs00900108())){
            String xml = "";
            MXPacs00900108 mxPacs00900108 = sendPacs00900108MsgReqDTO.getMxPacs00900108();
            Pacs00900108 mx = new Pacs00900108();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08", mx, mxPacs00900108.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXPacs00900108 XML:{}",xml);
            mxPacs00900108.setPacs00900108(mx);
            String message = mxPacs00900108.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXPacs00900108 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00900108MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00900108MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.009.001.08");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXPacs00900108 IS NULL #####");
        }
        logger.info("##### END TO SEND PASC 00900108 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00900108AdvMsg(GenericDTO<SendPacs00900108AdvMsgReqDTO> reqDto) {
        logger.info("##### START TO SEND PASC 00900108 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00900108AdvMsgReqDTO sendPacs00900108AdvMsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00900108AdvMsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00900108AdvMsgReqDTO.getMxPacs00900108Adv())){
            String xml = "";
            MXPacs00900108Adv mxPacs00900108Adv = sendPacs00900108AdvMsgReqDTO.getMxPacs00900108Adv();
            Pacs00900108Adv mx = new Pacs00900108Adv();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08Adv", mx, mxPacs00900108Adv.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXPacs00900108Adv XML:{}",xml);
            mxPacs00900108Adv.setPacs00900108Adv(mx);
            String message = mxPacs00900108Adv.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXPacs00900108Adv MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00900108AdvMsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00900108AdvMsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.009.001.08Adv");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXPacs00900108Adv IS NULL #####");
        }
        logger.info("##### END TO SEND PASC 00900108Adv MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00900108CovMsg(GenericDTO<SendPacs00900108CovMsgReqDTO> reqDto) {
        logger.info("##### START TO SEND PASC 00900108Cov MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00900108CovMsgReqDTO sendPacs00900108CovMsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00900108CovMsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00900108CovMsgReqDTO.getMxPacs00900108Cov())){
            String xml = "";
            MXPacs00900108Cov mxPacs00900108Cov = sendPacs00900108CovMsgReqDTO.getMxPacs00900108Cov();
            Pacs00900108Cov mx = new Pacs00900108Cov();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08Cov", mx, mxPacs00900108Cov.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXPacs00900108Cov XML:{}",xml);
            mxPacs00900108Cov.setPacs00900108Cov(mx);
            String message = mxPacs00900108Cov.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXPacs00900108Cov MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00900108CovMsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00900108CovMsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.009.001.08Cov");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXPacs00900108Cov IS NULL #####");
        }
        logger.info("##### END TO SEND PASC 00900108Cov MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendCamt05600108Msg(GenericDTO<SendCamt05600108MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND MXCamt05600108 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendCamt05600108MsgReqDTO sendCamt05600108MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendCamt05600108MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendCamt05600108MsgReqDTO.getMxCamt05600108())){
            String xml = "";
            MXCamt05600108 mxCamt05600108 = sendCamt05600108MsgReqDTO.getMxCamt05600108();
            Camt05600108 mx = new Camt05600108();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:camt.056.001.08", mx, mxCamt05600108.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### MXCamt05600108 XML:{}",xml);
            mxCamt05600108.setCamt05600108(mx);
            String message = mxCamt05600108.message();
            System.out.println("\r\n"+message);
            logger.info("##### MXCamt05600108 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendCamt05600108MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendCamt05600108MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("camt.056.001.08");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### MXCamt05600108 IS NULL #####");
        }
        logger.info("##### END TO SEND MXCamt05600108 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendCamt02900109Msg(GenericDTO<SendCamt02900109MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND Camt02900109 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendCamt02900109MsgReqDTO sendCamt02900109MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendCamt02900109MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendCamt02900109MsgReqDTO.getMxCamt02900109())){
            String xml = "";
            MXCamt02900109 mxCamt02900109 = sendCamt02900109MsgReqDTO.getMxCamt02900109();
            Camt02900109 mx = new Camt02900109();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:camt.029.001.09", mx, mxCamt02900109.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### Camt02900109 XML:{}",xml);
            mxCamt02900109.setCamt02900109(mx);
            String message = mxCamt02900109.message();
            System.out.println("\r\n"+message);
            logger.info("##### Camt02900109 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendCamt02900109MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendCamt02900109MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("camt.029.001.09");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### Camt02900109 IS NULL #####");
        }
        logger.info("##### END TO SEND Camt02900109 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendCamt05700106Msg(GenericDTO<SendCamt05700106MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND Camt05700106 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendCamt05700106MsgReqDTO sendCamt05700106MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendCamt05700106MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendCamt05700106MsgReqDTO.getMxCamt05700106())){
            String xml = "";
            MXCamt05700106 mxCamt05700106 = sendCamt05700106MsgReqDTO.getMxCamt05700106();
            Camt05700106 mx = new Camt05700106();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:camt.057.001.06", mx, mxCamt05700106.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### Camt05700106 XML:{}",xml);
            mxCamt05700106.setCamt05700106(mx);
            String message = mxCamt05700106.message();
            System.out.println("\r\n"+message);
            logger.info("##### Camt05700106 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendCamt05700106MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendCamt05700106MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("camt.057.001.06");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### Camt05700106 IS NULL #####");
        }
        logger.info("##### END TO SEND Camt05700106 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendCamt05400108Msg(GenericDTO<SendCamt05400108MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND Camt05400108 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendCamt05400108MsgReqDTO sendCamt05400108MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendCamt05400108MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendCamt05400108MsgReqDTO.getMxCamt05400108())){
            String xml = "";
            MXCamt05400108 mxCamt05400108 = sendCamt05400108MsgReqDTO.getMxCamt05400108();
            Camt05400108 mx = new Camt05400108();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:camt.054.001.08", mx, mxCamt05400108.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### Camt05400108 XML:{}",xml);
            mxCamt05400108.setCamt05400108(mx);
            String message = mxCamt05400108.message();
            System.out.println("\r\n"+message);
            logger.info("##### Camt05400108 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendCamt05400108MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendCamt05400108MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("camt.054.001.08");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### Camt05400108 IS NULL #####");
        }
        logger.info("##### END TO SEND Camt05400108 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00400109Msg(GenericDTO<SendPacs00400109MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND Pacs00400109 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00400109MsgReqDTO sendPacs00400109MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00400109MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00400109MsgReqDTO.getMxPacs00400109())){
            String xml = "";
            MXPacs00400109 mxPacs00400109 = sendPacs00400109MsgReqDTO.getMxPacs00400109();
            Pacs00400109 mx = new Pacs00400109();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.004.001.09", mx, mxPacs00400109.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### Pacs00400109 XML:{}",xml);
            mxPacs00400109.setPacs00400109(mx);
            String message = mxPacs00400109.message();
            System.out.println("\r\n"+message);
            logger.info("##### Pacs00400109 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00400109MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00400109MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.004.001.09");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### Pacs00400109 IS NULL #####");
        }
        logger.info("##### END TO SEND Pacs00400109 MSG #####");
        return genericRspDTO;
    }

    @Override
    public GenericRspDTO<MxDto> sendPacs00200110Msg(GenericDTO<SendPacs00200110MsgReqDTO> reqDto) {
        logger.info("##### START TO SEND Pacs00200110 MSG #####");
        GenericRspDTO<MxDto> genericRspDTO = new GenericRspDTO<>();
        MxDto mxDto = new MxDto();
        SendPacs00200110MsgReqDTO sendPacs00200110MsgReqDTO = reqDto.getBody();
        ReqHead reqHead = sendPacs00200110MsgReqDTO.getReqHead();
        if (JudgeUtils.isNotNull(sendPacs00200110MsgReqDTO.getMxPacs00200110())){
            String xml = "";
            MXPacs00200110 mxPacs00200110 = sendPacs00200110MsgReqDTO.getMxPacs00200110();
            Pacs00200110 mx = new Pacs00200110();
            xml = MxWriteImpl.write("urn:iso:std:iso:20022:tech:xsd:pacs.002.001.10", mx, mxPacs00200110.getClasses(), new MxWriteParams());
            System.out.println("\r\n"+xml);
            logger.info("##### Pacs00200110 XML:{}",xml);
            mxPacs00200110.setPacs00200110(mx);
            String message = mxPacs00200110.message();
            System.out.println("\r\n"+message);
            logger.info("##### Pacs00200110 MESSAGE:{}",message);
            //RMC参数组装
            RmcMxg01 rmcMxg01 = sendPacs00200110MsgReqDTO.getRmcMxg01();
            rmcMxg01.setSwiftInformation(message);
            rmcMxg01.setMsgLen(message.length());
            sendPacs00200110MsgReqDTO.setRmcMxg01(rmcMxg01);
            mxDto.setMxStr(message);
            mxDto.setMxType("pacs.004.001.09");
            mxDto.setMsgNo(rmcMxg01.getSrcBk()+rmcMxg01.getSrcDate()+rmcMxg01.getSrcSeq());
            genericRspDTO.setBody(mxDto);
            //CALL IGW TO RMC
            GenericRspDTO<SendMXSwiftMsgRspDTO> sendMXSwiftMsgRspDTOGenericRspDTO = callOuterService.callIgwSendMxMsg(rmcMxg01, reqHead);
            if (JudgeUtils.isSuccess(sendMXSwiftMsgRspDTOGenericRspDTO.getMsgCd())){
                logger.info("##### SEND MX MESSAGE SUCCESS #####");
            }else {
                genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
                logger.error("##### SEND MX MESSAGE ERROR ,MSG NO:{}",mxDto.getMsgNo());
            }
        }else {
            genericRspDTO.setMsgCd(SendMxConstant.SEND_MX_FAIL);
            logger.error("##### Pacs00200110 IS NULL #####");
        }
        logger.info("##### END TO SEND Pacs00200110 MSG #####");
        return genericRspDTO;
    }

}
