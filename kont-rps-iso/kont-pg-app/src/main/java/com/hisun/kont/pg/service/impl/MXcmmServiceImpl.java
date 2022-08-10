package com.hisun.kont.pg.service.impl;


import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.common.utils.StringUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.BankLimitQuotaDao;
import com.hisun.kont.pg.dao.ClientLimitQuotaDao;
import com.hisun.kont.pg.dao.PgtctlDao;
import com.hisun.kont.pg.entity.BankLimitQuotaDO;
import com.hisun.kont.pg.entity.ClientLimitQuotaDO;
import com.hisun.kont.pg.entity.PgtctlDO;
import com.hisun.kont.pg.mx.remote.*;
import com.hisun.kont.pg.service.MXcmmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Service
@Transactional
public class MXcmmServiceImpl implements MXcmmService {

    private static final Logger logger = LoggerFactory.getLogger(MXcmmServiceImpl.class);

    @Resource
    PgtctlDao pgtctlDao;

    @Resource
    ClientLimitQuotaDao clientLimitQuotaDao;

    @Resource
    BankLimitQuotaDao  bankLimitQuotaDao;

    @Override
    public GenericRspDTO<QueryButtenPgtctlRspDTO> queryButtenPgtctl (GenericDTO<QueryButtenPgtctlReqDTO> reqDto){

        //返回
        QueryButtenPgtctlRspDTO queryButtenPgtctlRspDTO = new QueryButtenPgtctlRspDTO();
        //获取
        QueryButtenPgtctlReqDTO queryButtenPgtctlReqDTO =reqDto.getBody();
        PgtctlDO pgtctlDO=new PgtctlDO();
        BeanUtils.copyProperties(queryButtenPgtctlReqDTO,pgtctlDO);
        PgtctlDO  resultPgtctlDO=new PgtctlDO();
        try {
            resultPgtctlDO =pgtctlDao.getListPgtctl(pgtctlDO);
            //查询数据为空则给初始值
            if (JudgeUtils.isNull(resultPgtctlDO)) {
                pgtctlDO.setCtlId("1");
                pgtctlDO.setChannel("swift");
                pgtctlDO.setCtlIStatus("O");
                pgtctlDO.setCtlOStatus("O");
                pgtctlDO.setCtlIAutoSts("N");
                pgtctlDO.setCtlOAutoSts("N");
                pgtctlDO.setCtlAmlSts("O");
                int num = pgtctlDao.insertPgtctDto(pgtctlDO);
                resultPgtctlDO =pgtctlDao.getListPgtctl(pgtctlDO);
            }
            BeanUtils.copyProperties(resultPgtctlDO,queryButtenPgtctlRspDTO);

        } catch (Exception e) {
            KontException.throwKontException(MTConstants.SYS_ERROR);
        }
        logger.info(reqDto.getBody().toString());
        return GenericRspDTO.newSuccessInstance(queryButtenPgtctlRspDTO);
    }


    @Override
    public GenericRspDTO<UpdateListPgtctlRspDTO> updateListPgtctl (GenericDTO<UpdateListPgtctlReqDTO> reqDto){
        UpdateListPgtctlRspDTO updateListPgtctlRspDTO = new UpdateListPgtctlRspDTO();
        UpdateListPgtctlReqDTO updateListPgtctlReqDTO=reqDto.getBody();
        try{
            updateListPgtctlRspDTO.setCtlIStatus(MTInStatusConstants.SWIFT_O.equals(updateListPgtctlReqDTO.getCtlIStatus())?MTInStatusConstants.SWIFT_O:MTInStatusConstants.SWIFT_C);
            updateListPgtctlRspDTO.setCtlOStatus(MTInStatusConstants.SWIFT_O.equals(updateListPgtctlReqDTO.getCtlOStatus())?MTInStatusConstants.SWIFT_O:MTInStatusConstants.SWIFT_C);
            updateListPgtctlRspDTO.setCtlAmlSts(MTInStatusConstants.SWIFT_O.equals(updateListPgtctlReqDTO.getCtlAmlSts())?MTInStatusConstants.SWIFT_O:MTInStatusConstants.SWIFT_C);
            updateListPgtctlRspDTO.setCtlIAutoSts(MTInStatusConstants.SWIFT_N.equals(updateListPgtctlReqDTO.getCtlIAutoSts())?MTInStatusConstants.SWIFT_N:MTInStatusConstants.SWIFT_Y);
            updateListPgtctlRspDTO.setCtlOAutoSts(MTInStatusConstants.SWIFT_N.equals(updateListPgtctlReqDTO.getCtlOAutoSts())?MTInStatusConstants.SWIFT_N:MTInStatusConstants.SWIFT_Y);
            PgtctlDO pgtctlDO=new PgtctlDO();
            BeanUtils.copyProperties(updateListPgtctlRspDTO,pgtctlDO);
            int num=pgtctlDao.updateListPgtctlDto(pgtctlDO);
        }catch (Exception e){
            KontException.throwKontException(MTConstants.SYS_ERROR);
        }
        logger.info(reqDto.getBody().toString());
        return GenericRspDTO.newSuccessInstance(updateListPgtctlRspDTO);
    }

    @Override
    public GenericRspDTO<CheckTransferLimitRspDTO> checkTransferLimit (GenericDTO<CheckTransferLimitReqDTO> reqDto){
        CheckTransferLimitRspDTO rspDTO = new CheckTransferLimitRspDTO();
        CheckTransferLimitReqDTO reqDTO = reqDto.getBody();
        //找寻数据库内相匹配的 PaymentLimitDO
        BankLimitQuotaDO paymentLimitDO = new BankLimitQuotaDO();
        //获取当日支付金额总额
        ClientLimitQuotaDO clientLimitQuotaDO = new ClientLimitQuotaDO();
        paymentLimitDO.setChannel(reqDTO.getChannel());
        paymentLimitDO.setLimitCcy(reqDTO.getTxCcy());
        paymentLimitDO.setBizSvc(reqDTO.getBizSvc());
        BankLimitQuotaDO bankLimitQuotaDO = bankLimitQuotaDao.select(paymentLimitDO);
        BeanUtils.copyProperties(reqDTO,clientLimitQuotaDO);
        //如果额度表的额度金额大于等于传入的金额
        if (bankLimitQuotaDO.getSingleLimitAmount().compareTo(reqDTO.getTxAmount()) > -1) {
            ClientLimitQuotaDO listCumulative = clientLimitQuotaDao.sumTxAmount(clientLimitQuotaDO);
            if (JudgeUtils.isNotNull(listCumulative)){
                reqDTO.getTxAmount().add(listCumulative.getTxAmount());
            }
            //如果额度表的额度金额大于等于 传入金额+记录内当日金额总额
            if (bankLimitQuotaDO.getDailyLimitAmount().compareTo(reqDTO.getTxAmount()) > -1) {
                rspDTO.setCheckLimit("true");
            } else {
                rspDTO.setCheckLimit("false");
            }
        } else {
            rspDTO.setCheckLimit("false");
        }
        if (!Boolean.parseBoolean(rspDTO.getCheckLimit())) {
            clientLimitQuotaDO.setTxStatus(MTInStatusConstants.LIMIT_STATU_FAILED);
        }else {
            clientLimitQuotaDO.setTxStatus(MTInStatusConstants.LIMIT_STATU_INIT);
        }
        clientLimitQuotaDO.setCreateTeller(reqDto.getUserId());
        clientLimitQuotaDO.setModifyTeller(reqDto.getUserId());
        clientLimitQuotaDao.insert(clientLimitQuotaDO);
        BeanUtils.copyProperties(reqDTO,rspDTO);
        return GenericRspDTO.newSuccessInstance(rspDTO);
    }



}