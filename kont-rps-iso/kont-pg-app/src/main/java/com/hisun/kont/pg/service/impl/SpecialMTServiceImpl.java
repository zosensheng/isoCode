package com.hisun.kont.pg.service.impl;

import com.hisun.kont.bocpays.remote.ReqHead;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.framework.data.GenericDTO;
import com.hisun.kont.framework.data.GenericRspDTO;
import com.hisun.kont.pg.constants.MTConstants;
import com.hisun.kont.pg.constants.MTInStatusConstants;
import com.hisun.kont.pg.dao.PgstsDao;
import com.hisun.kont.pg.entity.PgMatchDO;
import com.hisun.kont.pg.entity.PgstsDO;
import com.hisun.kont.pg.mt.remote.*;
import com.hisun.kont.pg.service.PgstsService;
import com.hisun.kont.pg.utils.AssembleUtils;
import com.hisun.kont.pg.utils.GpiF79DTO;
import com.hisun.kont.pg.utils.TeleCh650Util;
import com.hisun.kont.swf.mt.message.*;
import com.hisun.kont.swf.mt.message.subItem.BlockMt;
import com.hisun.kont.swf.mt.tag.*;
import com.hisun.kont.swf.mt.tag.subItem.BaseTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author yupeifeng
 * @ClassName: SpecialMTServiceImpl
 * @Date 2021/12/11 9:59
 * @Description 处理特殊类报文 202COV 210 199
 * @Version 1.0
 **/
@Service
@Transactional
public class SpecialMTServiceImpl {

    @Resource
    private PgstsDao pgstsDao;

    @Resource
    private MTAssemblyServiceImpl mtAssemblyServiceImpl;

    @Resource
    CommonAssembleImpl commonAssemble;

    @Resource
    private PgMatchServiceImpl pgMatchService;

    @Resource
    private PgstsService pgstsService;

    private static final Logger logger = LoggerFactory.getLogger(SpecialMTServiceImpl.class);

    /**
     * 202COV报文手动映射
     *
     * @param mt202Cov
     * @param fmt202
     * @param fmt103
     * @return
     */
    public MT202Cov mappingForMt202COV(MT202Cov mt202Cov, Fmt202 fmt202, Fmt103 fmt103) {
        //手动映射202
        if (JudgeUtils.isNotNull(fmt202.getF13CList())) {
            List<Tag13C> tag13CList = new ArrayList<>();
            int size = fmt202.getF13CList().size();
            for (int i = 0; i < size; i++) {
                Tag13C tag13C = new Tag13C();
                F13C f13C = fmt202.getF13CList().get(i);
                tag13C.setTimeIndC(f13C.getTimeIndC());
                tag13CList.add(tag13C);
                mt202Cov.putTagDataList(tag13C, "A");
            }
        }
        if (JudgeUtils.isNotNull(fmt202.getF20())) {
            Tag20 tag20 = new Tag20();
            tag20.setTrn(fmt202.getF20().getTrn());
            mt202Cov.putTagDataList(tag20, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF21())) {
            Tag21 tag21 = new Tag21();
            tag21.setRtrn(fmt202.getF21().getRtrn());
            mt202Cov.putTagDataList(tag21, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF32A())) {
            Tag32A tag32A = new Tag32A();
            tag32A.setCur(fmt202.getF32A().getCur());
            tag32A.setIntbkSetAmt(fmt202.getF32A().getIntbkSetAmt());
            tag32A.setValDate(fmt202.getF32A().getValDate());
            mt202Cov.putTagDataList(tag32A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF52A())) {
            Tag52A tag52A = new Tag52A();
            tag52A.setOrdInstAc(fmt202.getF52A().getOrdInstAc());
            tag52A.setOrdInstType(fmt202.getF52A().getOrdInstType());
            tag52A.setOrdInstBic(fmt202.getF52A().getOrdInstBic());
            mt202Cov.putTagDataList(tag52A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF52D())) {
            Tag52D tag52D = new Tag52D();
            tag52D.setOrdInstAc(fmt202.getF52D().getOrdInstAc());
            tag52D.setOrdInstType(fmt202.getF52D().getOrdInstType());
            tag52D.setOrdInstAddrList(fmt202.getF52D().getOrdInstAddrList());
            mt202Cov.putTagDataList(tag52D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF53A())) {
            Tag53A tag53A = new Tag53A();
            tag53A.setSndCorrBic(fmt202.getF53A().getSndCorrBic());
            tag53A.setSndCorrAc(fmt202.getF53A().getSndCorrAc());
            tag53A.setSndInstType(fmt202.getF53A().getSndInstType());
            mt202Cov.putTagDataList(tag53A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF53B())) {
            Tag53B tag53B = new Tag53B();
            tag53B.setSndCorrAc(fmt202.getF53B().getSndCorrAc());
            tag53B.setSndInstType(fmt202.getF53B().getSndInstType());
            tag53B.setSndCorrAddr(fmt202.getF53B().getSndCorrAddr());
            mt202Cov.putTagDataList(tag53B, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF53D())) {
            Tag53D tag53D = new Tag53D();
            tag53D.setSndCorrAc(fmt202.getF53D().getSndCorrAc());
            tag53D.setSndInstType(fmt202.getF53D().getSndInstType());
            tag53D.setSndCorrAddrList(fmt202.getF53D().getSndCorrAddrList());
            mt202Cov.putTagDataList(tag53D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF54A())) {
            Tag54A tag54A = new Tag54A();
            tag54A.setRcvCorrAc(fmt202.getF54A().getRcvCorrAc());
            tag54A.setRcvCorrBic(fmt202.getF54A().getRcvCorrBic());
            tag54A.setRcvCorrType(fmt202.getF54A().getRcvCorrType());
            mt202Cov.putTagDataList(tag54A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF54B())) {
            Tag54B tag54B = new Tag54B();
            tag54B.setRcvCorrAc(fmt202.getF54B().getRcvCorrAc());
            tag54B.setRcvCorrAddr(fmt202.getF54B().getRcvCorrAddr());
            tag54B.setRcvCorrType(fmt202.getF54B().getRcvCorrType());
            mt202Cov.putTagDataList(tag54B, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF54D())) {
            Tag54D tag54D = new Tag54D();
            tag54D.setRcvCorrAc(fmt202.getF54D().getRcvCorrAc());
            tag54D.setRcvCorrType(fmt202.getF54D().getRcvCorrType());
            tag54D.setRcvCorrAddrList(fmt202.getF54D().getRcvCorrAddrList());
            mt202Cov.putTagDataList(tag54D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF56A())) {
            Tag56A tag56A = new Tag56A();
            tag56A.setMedInstAc(fmt202.getF56A().getMedInstAc());
            tag56A.setMedInstBic(fmt202.getF56A().getMedInstBic());
            tag56A.setMedInstType(fmt202.getF56A().getMedInstType());
            mt202Cov.putTagDataList(tag56A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF56D())) {
            Tag56D tag56D = new Tag56D();
            tag56D.setMedInstAc(fmt202.getF56D().getMedInstAc());
            tag56D.setMedInstType(fmt202.getF56D().getMedInstType());
            tag56D.setMedInstAddrList(fmt202.getF56D().getMedInstAddrList());
            mt202Cov.putTagDataList(tag56D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF57A())) {
            Tag57A tag57A = new Tag57A();
            tag57A.setActInstBic(fmt202.getF57A().getActInstBic());
            tag57A.setActInstAc(fmt202.getF57A().getActInstAc());
            tag57A.setActInstType(fmt202.getF57A().getActInstType());
            mt202Cov.putTagDataList(tag57A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF57B())) {
            Tag57B tag57B = new Tag57B();
            tag57B.setActInstAddr(fmt202.getF57B().getActInstAddr());
            tag57B.setActInstAc(fmt202.getF57B().getActInstAc());
            tag57B.setActInstType(fmt202.getF57B().getActInstType());
            mt202Cov.putTagDataList(tag57B, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF57D())) {
            Tag57D tag57D = new Tag57D();
            tag57D.setActInstAc(fmt202.getF57D().getActInstAc());
            tag57D.setActInstAddrList(fmt202.getF57D().getActInstAddrList());
            tag57D.setActInstType(fmt202.getF57D().getActInstType());
            mt202Cov.putTagDataList(tag57D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF58A())) {
            Tag58A tag58A = new Tag58A();
            tag58A.setBenfInstAc(fmt202.getF58A().getBenfInstAc());
            tag58A.setBenfInstBic(fmt202.getF58A().getBenfInstBic());
            tag58A.setBenfInstType(fmt202.getF58A().getBenfInstType());
            mt202Cov.putTagDataList(tag58A, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF58D())) {
            Tag58D tag58D = new Tag58D();
            tag58D.setBenfInstAc(fmt202.getF58D().getBenfInstAc());
            tag58D.setBenfInstType(fmt202.getF58D().getBenfInstType());
            tag58D.setBenfInstAddrList(fmt202.getF58D().getBenfInstAddrList());
            mt202Cov.putTagDataList(tag58D, "A");
        }
        if (JudgeUtils.isNotNull(fmt202.getF72())) {
            Tag72 tag72 = new Tag72();
            tag72.setSrInfoList(fmt202.getF72().getSrInfoList());
            mt202Cov.putTagDataList(tag72, "A");
        }

        //手动映射103
        if (JudgeUtils.isNotNull(fmt103.getF50A())) {
            Tag50A tag50A = new Tag50A();
            tag50A.setOrdCustBic(fmt103.getF50A().getOrdCustBic());
            tag50A.setOrdCustAc(fmt103.getF50A().getOrdCustAc());
            mt202Cov.putTagDataList(tag50A, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF50F())) {
            Tag50F tag50F = new Tag50F();
            tag50F.setOrdCustAc(fmt103.getF50F().getOrdCustAc());
            tag50F.setOrdCustBic(fmt103.getF50F().getOrdCustBic());
            tag50F.setCtryCode(fmt103.getF50F().getCtryCode());
            tag50F.setInstrCd(fmt103.getF50F().getInstrCd());
            tag50F.setOrdCustAddrList(fmt103.getF50F().getOrdCustAddrList());
            mt202Cov.putTagDataList(tag50F, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF50K())) {
            Tag50K tag50K = new Tag50K();
            tag50K.setOrdCustAc(fmt103.getF50K().getOrdCustAc());
            tag50K.setOrdCustAddrList(fmt103.getF50K().getOrdCustAddrList());
            mt202Cov.putTagDataList(tag50K, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF52A())) {
            Tag52A tag52A = new Tag52A();
            tag52A.setOrdInstAc(fmt103.getF52A().getOrdInstAc());
            tag52A.setOrdInstType(fmt103.getF52A().getOrdInstType());
            tag52A.setOrdInstBic(fmt103.getF52A().getOrdInstBic());
            mt202Cov.putTagDataList(tag52A, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF52D())) {
            Tag52D tag52D = new Tag52D();
            tag52D.setOrdInstAc(fmt103.getF52D().getOrdInstAc());
            tag52D.setOrdInstType(fmt103.getF52D().getOrdInstType());
            tag52D.setOrdInstAddrList(fmt103.getF52D().getOrdInstAddrList());
            mt202Cov.putTagDataList(tag52D, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF56A())) {
            Tag56A tag56A = new Tag56A();
            tag56A.setMedInstBic(fmt103.getF56A().getMedInstBic());
            tag56A.setMedInstAc(fmt103.getF56A().getMedInstAc());
            tag56A.setMedInstType(fmt103.getF56A().getMedInstType());
            mt202Cov.putTagDataList(tag56A, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF56C())) {
            Tag56C tag56C = new Tag56C();
            tag56C.setMedInstAc(fmt103.getF56C().getMedInstAc());
            mt202Cov.putTagDataList(tag56C, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF56D())) {
            Tag56D tag56D = new Tag56D();
            tag56D.setMedInstAc(fmt103.getF56D().getMedInstAc());
            tag56D.setMedInstType(fmt103.getF56D().getMedInstType());
            tag56D.setMedInstAddrList(fmt103.getF56D().getMedInstAddrList());
            mt202Cov.putTagDataList(tag56D, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF57A())) {
            Tag57A tag57A = new Tag57A();
            tag57A.setActInstBic(fmt103.getF57A().getActInstBic());
            tag57A.setActInstAc(fmt103.getF57A().getActInstAc());
            tag57A.setActInstType(fmt103.getF57A().getActInstType());
            mt202Cov.putTagDataList(tag57A, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF57B())) {
            Tag57B tag57B = new Tag57B();
            tag57B.setActInstAddr(fmt103.getF57B().getActInstAddr());
            tag57B.setActInstAc(fmt103.getF57B().getActInstAc());
            tag57B.setActInstType(fmt103.getF57B().getActInstType());
            mt202Cov.putTagDataList(tag57B, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF57C())) {
            Tag57C tag57C = new Tag57C();
            tag57C.setActInstAc(fmt103.getF57C().getActInstAc());
            mt202Cov.putTagDataList(tag57C, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF57D())) {
            Tag57D tag57D = new Tag57D();
            tag57D.setActInstAc(fmt103.getF57D().getActInstAc());
            tag57D.setActInstAddrList(fmt103.getF57D().getActInstAddrList());
            tag57D.setActInstType(fmt103.getF57D().getActInstType());
            mt202Cov.putTagDataList(tag57D, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF59())) {
            Tag59 tag59 = new Tag59();
            tag59.setBenfCustAc(fmt103.getF59().getBenfCustAc());
            tag59.setBenfCustAddrList(fmt103.getF59().getBenfCustAddrList());
            mt202Cov.putTagDataList(tag59, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF59A())) {
            Tag59A tag59A = new Tag59A();
            tag59A.setBenfCustAc(fmt103.getF59A().getBenfCustAc());
            tag59A.setBenfCustBic(fmt103.getF59A().getBenfCustBic());
            mt202Cov.putTagDataList(tag59A, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF59F())) {
            Tag59F tag59F = new Tag59F();
            tag59F.setBenfCustAc(fmt103.getF59F().getBenfCustAc());
            tag59F.setBenfCustAddrList(fmt103.getF59F().getBenfCustAddrList());
            mt202Cov.putTagDataList(tag59F, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF70())) {
            Tag70 tag70 = new Tag70();
            tag70.setRemitInfoList(fmt103.getF70().getRemitInfoList());
            mt202Cov.putTagDataList(tag70, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF72())) {
            Tag72 tag72 = new Tag72();
            tag72.setSrInfoList(fmt103.getF72().getSrInfoList());
            mt202Cov.putTagDataList(tag72, "B");
        }
        if (JudgeUtils.isNotNull(fmt103.getF33B())) {
            Tag33B tag33B = new Tag33B();
            tag33B.setInstAmt(fmt103.getF33B().getInstAmt());
            tag33B.setInstCur(fmt103.getF33B().getInstCur());
            mt202Cov.putTagDataList(tag33B, "B");
        }
        return mt202Cov;
    }

    /**
     * 210报文手动映射
     *
     * @param mt210
     * @param fmt210
     * @return
     */
    public MT210 mappingForMT210(MT210 mt210, Fmt210 fmt210) {
        List<BlockMt> blockMts = new ArrayList<>();
        for (int i = 0; i < fmt210.getmTBlockList().size(); i++) {
            MT210Bolck mt210Bolck = new MT210Bolck();
            BlockMt blockMt = new BlockMt();
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF21())) {
                Tag21 tag21 = new Tag21();
                tag21.setRtrn(fmt210.getmTBlockList().get(i).getF21().getRtrn());
                mt210Bolck.putTagDataList(tag21);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF32B())) {
                Tag32B tag32B = new Tag32B();
                tag32B.setCur(fmt210.getmTBlockList().get(i).getF32B().getCur());
                tag32B.setIntbkSetAmt(fmt210.getmTBlockList().get(i).getF32B().getIntbkSetAmt());
                mt210Bolck.putTagDataList(tag32B);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50())) {
                Tag50 tag50 = new Tag50();
                tag50.setOrdCustAddrList(fmt210.getmTBlockList().get(i).getF50().getOrdCustAddrList());
                mt210Bolck.putTagDataList(tag50);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50C())) {
                Tag50C tag50C = new Tag50C();
                tag50C.setOrdCustBic(fmt210.getmTBlockList().get(i).getF50C().getOrdCustBic());
                mt210Bolck.putTagDataList(tag50C);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF50F())) {
                Tag50F tag50F = new Tag50F();
                tag50F.setInstrCd(fmt210.getmTBlockList().get(i).getF50F().getInstrCd());
                tag50F.setCtryCode(fmt210.getmTBlockList().get(i).getF50F().getCtryCode());
                tag50F.setOrdCustBic(fmt210.getmTBlockList().get(i).getF50F().getOrdCustBic());
                tag50F.setOrdCustAc(fmt210.getmTBlockList().get(i).getF50F().getOrdCustAc());
                tag50F.setOrdCustAddrList(fmt210.getmTBlockList().get(i).getF50F().getOrdCustAddrList());
                mt210Bolck.putTagDataList(tag50F);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF52A())) {
                Tag52A tag52A = new Tag52A();
                tag52A.setOrdInstBic(fmt210.getmTBlockList().get(i).getF52A().getOrdInstBic());
                tag52A.setOrdInstType(fmt210.getmTBlockList().get(i).getF52A().getOrdInstType());
                tag52A.setOrdInstAc(fmt210.getmTBlockList().get(i).getF52A().getOrdInstAc());
                mt210Bolck.putTagDataList(tag52A);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF52D())) {
                Tag52D tag52D = new Tag52D();
                tag52D.setOrdInstAddrList(fmt210.getmTBlockList().get(i).getF52D().getOrdInstAddrList());
                tag52D.setOrdInstType(fmt210.getmTBlockList().get(i).getF52D().getOrdInstType());
                tag52D.setOrdInstAc(fmt210.getmTBlockList().get(i).getF52D().getOrdInstAc());
                mt210Bolck.putTagDataList(tag52D);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF56A())) {
                Tag56A tag56A = new Tag56A();
                tag56A.setMedInstType(fmt210.getmTBlockList().get(i).getF56A().getMedInstType());
                tag56A.setMedInstBic(fmt210.getmTBlockList().get(i).getF56A().getMedInstBic());
                tag56A.setMedInstAc(fmt210.getmTBlockList().get(i).getF56A().getMedInstAc());
                mt210Bolck.putTagDataList(tag56A);
            }
            if (JudgeUtils.isNotNull(fmt210.getmTBlockList().get(i).getF56D())) {
                Tag56D tag56D = new Tag56D();
                tag56D.setMedInstAddrList(fmt210.getmTBlockList().get(i).getF56D().getMedInstAddrList());
                tag56D.setMedInstType(fmt210.getmTBlockList().get(i).getF56D().getMedInstType());
                tag56D.setMedInstAc(fmt210.getmTBlockList().get(i).getF56D().getMedInstAc());
                mt210Bolck.putTagDataList(tag56D);
            }
            blockMt.setBlockbaseMessage(mt210Bolck);
            blockMts.add(blockMt);
        }

        for (BlockMt blockMt : blockMts) {
            BaseTag baseTag = new BaseTag();
            baseTag.setName("210Bolck");
            baseTag.setBlockMt(blockMt.getBlockbaseMessage());
            mt210.putTagDataList(baseTag);
        }
        return mt210;
    }

    /**
     * gpi199报文 特殊处理  截取79入库
     *
     * @param pgstsDO
     * @param fmt199
     * @return
     */
    public PgstsDO mappingForGpi199(PgstsDO pgstsDO, Fmt199 fmt199) {
        //获取gpi199 79list数据
        List<String> narratList = fmt199.getF79().getNarratList();
        pgstsDO.setMtNarrat(narratList.toString());
        //调用79域拆解工具
        GpiF79DTO gpiF79DTO = AssembleUtils.getF79Value(narratList);
        pgstsDO.setGpiDate(gpiF79DTO.getGpiDate());
        pgstsDO.setGpiTime(gpiF79DTO.getGpiTime());
        pgstsDO.setGpiTimezone(gpiF79DTO.getGpiZone());
        pgstsDO.setGpiStatus(gpiF79DTO.getGpiStatus());
        pgstsDO.setGpiReasonCode(gpiF79DTO.getGpiReasonCode());
        return pgstsDO;
    }

    /**
     * gpi299报文 特殊处理  截取79入库
     *
     * @param pgstsDO
     * @param fmt299
     * @return
     */
    public PgstsDO mappingForGpi299(PgstsDO pgstsDO, Fmt299 fmt299) {
        //获取gpi199 79list数据
        List<String> narratList = fmt299.getF79().getNarratList();
        pgstsDO.setMtNarrat(narratList.toString());
        //调用79域拆解工具
        GpiF79DTO gpiF79DTO = AssembleUtils.getF79Value(narratList);
        pgstsDO.setGpiDate(gpiF79DTO.getGpiDate());
        pgstsDO.setGpiTime(gpiF79DTO.getGpiTime());
        pgstsDO.setGpiTimezone(gpiF79DTO.getGpiZone());
        pgstsDO.setGpiStatus(gpiF79DTO.getGpiStatus());
        pgstsDO.setGpiReasonCode(gpiF79DTO.getGpiReasonCode());
        return pgstsDO;
    }

    /**
     * MT202转汇
     * @param reqDto
     * @return
     */
    public GenericRspDTO<MtDto> transMT202COV(GenericDTO<SendRemit202ReqDTO> reqDto,String flag) {
        logger.info("##### START TO TRANS MT202COV #####");
        GenericRspDTO<MtDto> rspDto = new GenericRspDTO<>();
        PgstsDO pgstsDO = new PgstsDO();
        SendRemit202ReqDTO sendRemit202ReqDTO = reqDto.getBody();
        Fmt202 fmt202 = reqDto.getBody().getFmt202();
        MT202 mt202 = new MT202();
        ReqHead reqHead = reqDto.getBody().getReqHead();
        SwHeader swHeader = sendRemit202ReqDTO.getFmt202().getSwHeader();
        //网关帮应用设置COV标识 他们传用他们 不传自己来
        if (JudgeUtils.isNull(fmt202.getSwHeader().getUserHeaderDO())){
            UserHeaderDO userHeaderDO = new UserHeaderDO();
            userHeaderDO.setOhCov("COV");
            fmt202.getSwHeader().setUserHeaderDO(userHeaderDO);
        }else {
            fmt202.getSwHeader().getUserHeaderDO().setOhCov("COV");
        }

        if (JudgeUtils.isNull(reqDto.getBody().getFmt202().getSwHeader().getBussInfoDTO().getTransferMsgNo())) {
            //获取转汇的电文编号为空
            rspDto.setMsgCd(MTConstants.MT_TRANSFER_MSGNO_ERRPR);
            return rspDto;
        } else {
            PgstsDO pgstsDo202Cov = pgstsDao.getByMsgNo(reqDto.getBody().getFmt202().getSwHeader().getBussInfoDTO().getTransferMsgNo());
            if (JudgeUtils.isNull(pgstsDo202Cov)){
                rspDto.setMsgCd(MTConstants.MT_TRANSFER_MSGNO_ERRPR);
                return rspDto;
            }

            //应用传报文编号 判断如果外发成功还继续重发的话  停止重发
            if (JudgeUtils.isNotNull(fmt202.getSwHeader().getMsgNo())){
                rspDto = commonAssemble.repeatKeyCheck(fmt202.getSwHeader().getMsgNo());
                if (JudgeUtils.isNotNull(rspDto.getBody())){
                    return rspDto;
                }
                //20域 21域
                String trn = fmt202.getF20().getTrn();
                String rtrn = fmt202.getF21().getRtrn();
                commonAssemble.savePreMessage(trn,rtrn,pgstsDO,swHeader,reqHead,reqDto);
            }

            //获取转汇的202COV的103部分报文
            String mtStr103 = dis202CovSeqBStr(pgstsDo202Cov.getMtStr());
            logger.info("##### RETURN PARAMETER:{}",mtStr103);

            //判断报文是否含有中文
            String cnFlag = AssembleUtils.getCnFlag(fmt202);
            //中文转电码
            fmt202 = commonAssemble.cnToTeleFor202(fmt202);
            //检查转汇到此返回 不继续发出
            if ("N".equals(flag)){
                String recBankName = null;
                MtDto mtDto = commonAssemble.comAssembleMessageForTrans(fmt202, mt202, flag, reqHead,recBankName,mtStr103);
                mtDto.setCnFlag(cnFlag);
                rspDto.setBody(mtDto);
                return rspDto;
            }
            //调用cor接口 检查bankCode是否有swiftkey
            String recBankName = mtAssemblyServiceImpl.checkBicForCor(swHeader, reqHead);
            MtDto mtDto = commonAssemble.comAssembleMessageForTrans(fmt202, mt202, flag, reqHead,recBankName,mtStr103);
            mtDto.setCnFlag(cnFlag);
            rspDto.setBody(mtDto);
            //外发报文到rmc  根据返回状态更新pgsts表
            //报文数据入库
            commonAssemble.updateMessageForPgsts(pgstsDO,mtDto);
            String returnCode = commonAssemble.comSendMessage(reqDto.getBody().getRmcTrx01(), reqHead, reqDto.getBody().getEaiHeaderDTO(), mtDto, pgstsDO);
            rspDto.setMsgCd(returnCode);
            logger.info("##### END TO TRANS MT202COV #####");
            return rspDto;
        }
    }

    /**
     * GPI199 GPI299自动关联103 202
     * @param pgstsDO
     */
    public void autoMatchGpiN99(PgstsDO pgstsDO,GpiF79DTO f79Value,String ohGpiRef,String rtrn,ReqHead reqHead){
        logger.info("##### AUTO MATCH AND 121 IS:{}",ohGpiRef);
        PgstsDO pgGpiRef = new PgstsDO();
        pgGpiRef.setOhGpiRef(ohGpiRef);
        List<PgstsDO> pgstsDOList = pgstsService.findListByPgstsDo(pgGpiRef);
        List<PgstsDO> pgstsDOS = new ArrayList<>();
        //先用121查 查不出用21查
        if (pgstsDOList.size()>0 && JudgeUtils.isNotNull(ohGpiRef)){
            //去除非103 202报文  先查103  在查202
            for (PgstsDO aDo : pgstsDOList) {
                if ("103".equals(aDo.getAhMt()) && "I".equals(aDo.getAhioFlag()) && "or".equals(aDo.getFrModule())){
                    pgstsDOS.add(aDo);
                }
            }
            //在判断是否有103报文 没有查202
            if (pgstsDOS.size()<1){
                for (PgstsDO aDo : pgstsDOList) {
                    if ("202".equals(aDo.getAhMt()) && "I".equals(aDo.getAhioFlag()) && "or".equals(aDo.getFrModule())){
                        pgstsDOS.add(aDo);
                    }
                }
            }
            logger.info("##### THE MESSAGE RECODE NUM BY 121:{}",pgstsDOS.size());
            //取其中一条 假若都没有关联到121 这里需要查21去找103 202关联
            if (pgstsDOS.size()>0){
                String msgNo = pgstsDOS.get(0).getMsgNo();
                PgMatchDO pgMatchDO = new PgMatchDO();
                pgMatchDO.setMsgNo(msgNo);
                List<PgMatchDO> listByPgMatchDo = pgMatchService.findListByPgMatchDo(pgMatchDO);
                logger.info("##### MATCH MESSAGE NUM:{}",listByPgMatchDo.size());
                if (listByPgMatchDo.size()>0){
                    if ("199".equals(pgstsDO.getAhMt()) || "299".equals(pgstsDO.getAhMt())){
                        //关联成功  通知汇出
                        String pagmchOurRef = listByPgMatchDo.get(0).getPagmchOurRef();
                        pgstsDO.setPagmchOurRef(pagmchOurRef);
                        String msgCode = mtAssemblyServiceImpl.pushF79ToExport(pgstsDO, f79Value,reqHead);
                        //推送GPI报文汇出标识
                        pgstsDO.setGpiFlag("Y");
                        if (JudgeUtils.isSuccess(msgCode)){
                            PgMatchDO pgMatchDoN99 = new PgMatchDO();
                            pgMatchDoN99.setMsgNo(pgstsDO.getMsgNo());
                            pgMatchDoN99.setPagmchOurRef(pagmchOurRef);
                            pgMatchDoN99 = commonAssemble.setLastUpdateParams(reqHead, pgMatchDoN99);
                            int result = pgMatchService.insertPgMatch(pgMatchDoN99);
                            if (result<1){
                                logger.error("##### MATCH FAIL :{}",pgMatchDoN99.getMsgNo());
                            }else {
                                logger.info("##### INSERT MATCH SUCCESS #####");
                                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
                            }
                        }
                    }else {
                        //关联失败
                        logger.error("##### NO MATCH FOR THE GPI N99,MSGNO:{}",msgNo);
                    }
                }
            }else {
                //用21去查
                PgMatchDO pgMatchDO = new PgMatchDO();
                pgMatchDO.setPagmchOurRef(rtrn);
                List<PgMatchDO> listByPgMatchDo = pgMatchService.findListByPgMatchDo(pgMatchDO);
                Boolean matchFlag = false;
                if (listByPgMatchDo.size()>0){
                    //需要判断查出来的21关联的报文类型是否为103  202
                    for (PgMatchDO matchDO : listByPgMatchDo) {
                        String msgNo = matchDO.getMsgNo();
                        PgstsDO pgDo = pgstsService.getByMsgNo(msgNo);
                        if (JudgeUtils.isNotNull(pgDo)){
                            if (("103".equals(pgDo.getAhMt()) || "202".equals(pgDo.getAhMt())) && "I".equals(pgDo.getAhioFlag()) && "or".equals(pgDo.getFrModule())){
                                matchFlag = true;
                            }
                        }
                    }
                    //用21查到103 202 将21关联到GPI199或GPI299  查不到直接走汇入23390 他们落otherQ
                    if (matchFlag){
                        if ("199".equals(pgstsDO.getAhMt()) || "299".equals(pgstsDO.getAhMt())){
                            //关联GPI199成功  通知汇
                            pgstsDO.setPagmchOurRef(rtrn);
                            String msgCd = mtAssemblyServiceImpl.pushF79ToExport(pgstsDO, f79Value,reqHead);
                            //推送GPI报文汇出标识
                            pgstsDO.setGpiFlag("Y");
                            if (JudgeUtils.isSuccess(msgCd)){
                                PgMatchDO pgMatchDoN99 = new PgMatchDO();
                                pgMatchDoN99.setMsgNo(pgstsDO.getMsgNo());
                                pgMatchDoN99.setPagmchOurRef(rtrn);
                                pgMatchDoN99 = commonAssemble.setLastUpdateParams(reqHead, pgMatchDoN99);
                                int result = pgMatchService.insertPgMatch(pgMatchDoN99);
                                if (result<1){
                                    logger.error("##### MATCH FAIL :{}",pgMatchDoN99.getMsgNo());
                                }else {
                                    logger.info("##### INSERT MATCH SUCCESS #####");
                                    pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
                                }
                            }
                        }else {
                            //网关记表失败 但关联成功
                            logger.error("##### NO MATCH FOR THE GPI N99,RTRN:{}",rtrn);
                        }
                    }
                }
            }
        }else {
            //用21去查
            PgMatchDO pgMatchDO = new PgMatchDO();
            pgMatchDO.setPagmchOurRef(rtrn);
            List<PgMatchDO> listByPgMatchDo = pgMatchService.findListByPgMatchDo(pgMatchDO);
            Boolean matchFlag = false;
            if (listByPgMatchDo.size()>0){
                //需要判断查出来的21关联的报文类型是否为103  202
                for (PgMatchDO matchDO : listByPgMatchDo) {
                    String msgNo = matchDO.getMsgNo();
                    PgstsDO pgDo = pgstsService.getByMsgNo(msgNo);
                    if (JudgeUtils.isNotNull(pgDo)){
                        if (("103".equals(pgDo.getAhMt()) || "202".equals(pgDo.getAhMt())) && "I".equals(pgDo.getAhioFlag()) && "or".equals(pgDo.getFrModule())){
                            matchFlag = true;
                        }
                    }
                }
                //用21查到103 202 将21关联到GPI199或GPI299  查不到直接走汇入23390 他们落otherQ
                if (matchFlag){
                    pgstsDO.setPagmchOurRef(rtrn);
                    if ("199".equals(pgstsDO.getAhMt()) || "299".equals(pgstsDO.getAhMt())){
                        //关联GPI199成功  通知汇出
                        String msgCd = mtAssemblyServiceImpl.pushF79ToExport(pgstsDO, f79Value,reqHead);
                        //推送GPI报文汇出标识
                        pgstsDO.setGpiFlag("Y");
                        if (JudgeUtils.isSuccess(msgCd)){
                            PgMatchDO pgMatchDoN99 = new PgMatchDO();
                            pgMatchDoN99.setMsgNo(pgstsDO.getMsgNo());
                            pgMatchDoN99.setPagmchOurRef(rtrn);
                            pgMatchDoN99 = commonAssemble.setLastUpdateParams(reqHead, pgMatchDoN99);
                            int result = pgMatchService.insertPgMatch(pgMatchDoN99);
                            if (result<1){
                                logger.error("##### MATCH FAIL :{}",pgMatchDoN99.getMsgNo());
                            }else {
                                logger.info("##### INSERT MATCH SUCCESS #####");
                                pgstsDO.setGwMsgStatus(MTInStatusConstants.MT_STATUS_DTED);
                            }
                        }

                    }else {
                        //网关记表失败
                        logger.error("##### NO MATCH FOR THE GPI N99,RTRN:{}",rtrn);
                    }
                }
            }
        }
    }

    /**
     * 拆解202COV的seqB方法
     * @param mtMsg
     * @return
     */
    public String dis202CovSeqBStr(String mtMsg){
        String substring = mtMsg.substring(mtMsg.indexOf("{4:") + 3);
        String messageBody = substring.substring(0, substring.indexOf("-}"));
        ArrayList<Map.Entry<String, String>> tagList = TeleCh650Util.parserDataToKeyList(messageBody);
        StringBuffer tagStr = new StringBuffer();
        int openSub = 0;
        for (int i = 0; i < tagList.size(); i++) {
            String k = tagList.get(i).getKey();
            //103部分拼成str
            if (openSub==1){
                String value = tagList.get(i).getValue();
                tagStr.append(":").append(k).append(":").append(value);
            }
            //找出103特有必传的域50A
            if (k.equals("50A") || k.equals("50K") || k.equals("50F")) {
                String value = tagList.get(i).getValue();
                tagStr.append(":").append(k).append(":").append(value);
                openSub = 1;
            }
        }
        String mtStr103 = tagStr.toString();
        return mtStr103;
    }
}
