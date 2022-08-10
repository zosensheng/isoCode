package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.constant.MXPacs00900108Constant;
import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.msg.pacs.dic.AddressType3Choice;
import com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.pacs.dic.PostalAddress24;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MXPacs00900110 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 9;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.10";
    public final static transient Class[] _classes = new Class[]{Pacs00900110.class};

    public Pacs00900110 pacs00900110;

    public Pacs00900110 getPacs00900110() {
        return pacs00900110;
    }

    public void setPacs00900110(Pacs00900110 pacs00900110) {
        this.pacs00900110 = pacs00900110;
    }
/*
   报文版本
    */

    public String getNamespace() {
        return NAMESPACE;
    }

    public String getBusinessProcess() {
        return BUSINESS_PROCESS;
    }

    public int getFunctionality() {
        return FUNCTIONALITY;
    }

    public int getVariant() {
        return VARIANT;
    }

    public int getVersion() {
        return VERSION;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class[] getClasses() {
        return _classes;
    }

    @Override
    public Object getDocumentObj() {
        return this.pacs00900110;
    }

    /**
     * If "Priority” is used in the BAH for pacs messages,
     * the value should be identical to the one in the “Payment Type Information/InstructionPriority” if present.
     * <PmtTpInf> <InstrPrty>
     *
     * @return 返回R1检查结果
     */
    public Constraints checkR1() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String prty = businessApplicationHeaderV02.getPrty();
            if (JudgeUtils.isNotNull(prty)) {
                if (JudgeUtils.isNotNull(pacs00900110)) {
                    FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                        List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                            for (CreditTransferTransaction56 CreditTransferTransaction56 : cdtTrfTxInf) {
                                PaymentTypeInformation28 pmtTpInf = CreditTransferTransaction56.getPmtTpInf();
                                if (JudgeUtils.isNotNull(pmtTpInf)) {
                                    Priority2Code instrPrty = pmtTpInf.getInstrPrty();
                                    if (JudgeUtils.isNotNull(instrPrty)) {
                                        String value = instrPrty.value();
                                        if (!prty.equals(value)) {
                                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R1_ERROR_CODE, MXPacs00900108Constant.R1_ERROR_TEXT);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * BAH "From" BIC must match "Instructing Agent" BIC, except where BAH CopyDuplicate = COPY or = CODU
     * BAH "To" BIC must match "Instructed Agent" BIC, except where BAH CopyDuplicate = COPY or = CODU
     * /Document/fiCdtTrf/CdtTrfTxInf/InstgAgt
     *
     * @return 返回R2检查结果
     */
    public Constraints checkR2() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900110 Pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            if (JudgeUtils.isNotNull(cpyDplct)) {
                String valueCpyDplct = cpyDplct.value();
                if (!"COPY".equals(valueCpyDplct) && !"CODU".equals(valueCpyDplct)) {
                    if (JudgeUtils.isNotNull(fr)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                        if (JudgeUtils.isNotNull(fiId)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String frBicfi = finInstnId.getBICFI();
                                if (JudgeUtils.isNotNull(Pacs00900110)) {
                                    FinancialInstitutionCreditTransferV10 fiCdtTrf = Pacs00900110.getFICdtTrf();
                                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                                        List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(grpHdr)) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                                            if (JudgeUtils.isNotNull(instgAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!frBicfi.equals(bicfi)) {
                                                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R2_ERROR_CODE, MXPacs00900108Constant.R2_ERROR_TEXT, "AppHdr:  " + frBicfi + "  Document:  " + bicfi);
                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            for (CreditTransferTransaction56 CreditTransferTransaction56 : cdtTrfTxInf) {
                                                com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = CreditTransferTransaction56.getInstgAgt();
                                                if (JudgeUtils.isNotNull(instgAgt)) {
                                                    com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                                    if (JudgeUtils.isNotNull(finInstnId1)) {
                                                        String bicfi = finInstnId1.getBICFI();
                                                        if (!frBicfi.equals(bicfi)) {
                                                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R2_ERROR_CODE, MXPacs00900108Constant.R2_ERROR_TEXT, "AppHdr:  " + frBicfi + "  Document:  " + bicfi);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(to)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId = to.getFIId();
                        if (JudgeUtils.isNotNull(fiId)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String toBicfi = finInstnId.getBICFI();
                                if (JudgeUtils.isNotNull(Pacs00900110)) {
                                    FinancialInstitutionCreditTransferV10 fiCdtTrf = Pacs00900110.getFICdtTrf();
                                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                                        List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(grpHdr)) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!toBicfi.equals(bicfi)) {
                                                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R2_ERROR_CODE, MXPacs00900108Constant.R2_ERROR_TEXT, "AppHdr:  " + toBicfi + "  Document:  " + bicfi);

                                                    }
                                                }
                                            }
                                        }
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            for (CreditTransferTransaction56 CreditTransferTransaction56 : cdtTrfTxInf) {
                                                com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = CreditTransferTransaction56.getInstdAgt();
                                                if (JudgeUtils.isNotNull(instdAgt)) {
                                                    com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                    if (JudgeUtils.isNotNull(finInstnId1)) {
                                                        String bicfi = finInstnId1.getBICFI();
                                                        if (!toBicfi.equals(bicfi)) {
                                                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R2_ERROR_CODE, MXPacs00900108Constant.R2_ERROR_TEXT, "AppHdr:  " + toBicfi + "  Document:  " + bicfi);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * BAH "From" BIC must match "Instructing Agent" BIC if CopyDuplicate is absent.
     * BAH "To" BIC must match "Instructed Agent" BIC  if CopyDuplicate is absent.
     *
     * @return 返回R3检查结果
     */
    public Constraints checkR3() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900110 Pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            if (JudgeUtils.isNull(cpyDplct)) {
                if (JudgeUtils.isNotNull(fr)) {
                    com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                    if (JudgeUtils.isNotNull(fiId)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            String frBicfi = finInstnId.getBICFI();
                            if (JudgeUtils.isNotNull(Pacs00900110)) {
                                FinancialInstitutionCreditTransferV10 fiCdtTrf = Pacs00900110.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                                    List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(grpHdr)) {
                                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                                        if (JudgeUtils.isNotNull(instgAgt)) {
                                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!frBicfi.equals(bicfi)) {
                                                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R3_ERROR_CODE, MXPacs00900108Constant.R3_ERROR_TEXT, "AppHdr:  " + frBicfi + "  Document:  " + bicfi);
                                                }
                                            }
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        for (CreditTransferTransaction56 CreditTransferTransaction56 : cdtTrfTxInf) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = CreditTransferTransaction56.getInstgAgt();
                                            if (JudgeUtils.isNotNull(instgAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!frBicfi.equals(bicfi)) {
                                                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R3_ERROR_CODE, MXPacs00900108Constant.R3_ERROR_TEXT, "AppHdr:  " + frBicfi + "  Document:  " + bicfi);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (JudgeUtils.isNotNull(to)) {
                    com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId = to.getFIId();
                    if (JudgeUtils.isNotNull(fiId)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            String toBicfi = finInstnId.getBICFI();
                            if (JudgeUtils.isNotNull(Pacs00900110)) {
                                FinancialInstitutionCreditTransferV10 fiCdtTrf = Pacs00900110.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                                    List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(grpHdr)) {
                                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                                        if (JudgeUtils.isNotNull(instdAgt)) {
                                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!toBicfi.equals(bicfi)) {
                                                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R3_ERROR_CODE, MXPacs00900108Constant.R3_ERROR_TEXT, "AppHdr:  " + toBicfi + "  Document:  " + bicfi);
                                                }
                                            }
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        for (CreditTransferTransaction56 CreditTransferTransaction56 : cdtTrfTxInf) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = CreditTransferTransaction56.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!toBicfi.equals(bicfi)) {
                                                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R3_ERROR_CODE, MXPacs00900108Constant.R3_ERROR_TEXT, "AppHdr:  " + toBicfi + "  Document:  " + bicfi);

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * For further description on the usage of the field, pls refer to the CBPR Plus UHB.
     * todo 不知道怎么写
     *
     * @return 返回R4检查结果
     */
    public Constraints checkR4() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String charSet = businessApplicationHeaderV02.getCharSet();

        }
        return null;
    }

    /**
     * The Business Message Identifier is the unique identifier of the Business Message instance that is being transported with this header,
     * as defined by the sending application or system.
     * Must contain the Message Identification element from the Group Header of the underlying message,
     * where available (as is typically the case with pacs, pain, and camt messages, for example).
     * If Message Identification is not available in the underlying message,
     * then this field must contain the unique identifier of the Business Message instance.
     *
     * @return 返回R5检查结果
     */
    public Constraints checkR5() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900110 Pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizMsgIdr = businessApplicationHeaderV02.getBizMsgIdr();
            if (JudgeUtils.isNotNull(Pacs00900110)) {
                FinancialInstitutionCreditTransferV10 fiCdtTrf = Pacs00900110.getFICdtTrf();
                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                    GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                    if (JudgeUtils.isNotNull(grpHdr)) {
                        String msgId = grpHdr.getMsgId();
                        if (JudgeUtils.isNotNull(bizMsgIdr) && JudgeUtils.isNotNull(msgId)) {
                            if (!bizMsgIdr.equals(msgId)) {
                                return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R5_ERROR_CODE, MXPacs00900108Constant.R5_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * The Message Definition Identifier of the Business Message instance that is being transported with this header.
     * In general, it must be formatted exactly as it appears in the namespace of the Business Message instance.
     *
     * @return 返回R6检查结果
     */
    public Constraints checkR6() {
        String namespace = BUSINESS_PROCESS + ".00" + FUNCTIONALITY + ".00" + VARIANT;
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String msgDefIdr = businessApplicationHeaderV02.getMsgDefIdr();
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(msgDefIdr)) {
                if (!msgDefIdr.contains(namespace)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R6_ERROR_CODE, MXPacs00900108Constant.R6_ERROR_TEXT, msgDefIdr);
                }
            }
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd) {
                    String msgDefIdr1 = businessApplicationHeader5.getMsgDefIdr();
                    if (JudgeUtils.isNotNull(msgDefIdr1)) {
                        if (!msgDefIdr.contains(namespace)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R6_ERROR_CODE, MXPacs00900108Constant.R6_ERROR_TEXT, msgDefIdr);
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * This field may be used by SWIFT to support differentiated processing on SWIFT-administered services such as FINplus.
     * For a description of reserved values, please refer to the Service Description for your service.
     * To support differentiated processing on CBPRPlus, for example, SWIFT reserves a set of values that conform to a specific format.
     * A user-specific value may be used, but please contact your Service Administrator before doing
     * so to ensure alignment with general practice on your service.
     *
     * @return 返回R7检查结果
     */
    public Constraints checkR7() {

        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            String msgDefIdr = businessApplicationHeaderV02.getMsgDefIdr();
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(bizSvc)) {
                BusAppHeadToBusSerEnum[] values = BusAppHeadToBusSerEnum.values();
                ArrayList<String> msgDefIdrList = new ArrayList<>();
                for (BusAppHeadToBusSerEnum value : values) {
                    String bizSvcEum = value.getBizSvc();
                    if (bizSvcEum.equals(bizSvc)) {
                        String msgDefIdrEnum = value.getMsgDefIdr();
                        msgDefIdrList.add(msgDefIdrEnum);
                    }
                }
                if (!msgDefIdrList.contains(msgDefIdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R7_ERROR_CODE, MXPacs00900108Constant.R7_ERROR_TEXT);
                }
            }
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd) {
                    String bizSvc1 = businessApplicationHeader5.getBizSvc();
                    String msgDefIdr1 = businessApplicationHeader5.getMsgDefIdr();
                    if (JudgeUtils.isNotNull(bizSvc1)) {
                        BusAppHeadToBusSerEnum[] values = BusAppHeadToBusSerEnum.values();
                        ArrayList<String> msgDefIdrList = new ArrayList<>();
                        for (BusAppHeadToBusSerEnum value : values) {
                            String bizSvcEum = value.getBizSvc();
                            if (bizSvcEum.equals(bizSvc)) {
                                String msgDefIdrEnum = value.getMsgDefIdr();
                                msgDefIdrList.add(msgDefIdrEnum);
                            }
                        }
                        if (!msgDefIdrList.contains(msgDefIdr1)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R7_ERROR_CODE, MXPacs00900108Constant.R7_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * text{1,35}
     *
     * @return R7规则匹配
     */
    private Constraints ruleR7(String str) {
        boolean r7 = str.matches("^[a-zA-Z]{1,35}$");
        if (!r7) {
            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R7_ERROR_CODE, MXPacs00900108Constant.R7_ERROR_TEXT);
        }
        return null;
    }

    /**
     * The value "swift.cbprplus.stp.02" must be used.
     *
     * @return 返回R8检查结果
     */
    public Constraints checkR8() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            if (JudgeUtils.isNotNull(bizSvc)) {
                if (!"swift.cbprplus.02".equals(bizSvc)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R8_ERROR_CODE, MXPacs00900108Constant.R8_ERROR_TEXT, bizSvc);
                }
            } else {
                return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R8_ERROR_CODE, MXPacs00900108Constant.R8_ERROR_TEXT, bizSvc);
            }
        }
        return null;
    }


    /**
     * This field may be used by SWIFT on SWIFT-administered services. For a description of reserved values,
     * please refer to the Service Description for your service. Contact your Service Administrator for further clarification, if necessary.
     * A user-specific value may be used, but please contact your Service Administrator before doing so to ensure alignment with general
     * practice on your service.
     * todo 同R4不知道怎么写
     *
     * @return 返回R9检查结果
     */
    public Constraints checkR9() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            ImplementationSpecification1 mktPrctc = businessApplicationHeaderV02.getMktPrctc();
        }
        return null;
    }

    /**
     * If used, the Related BAH must transport the exact same information as in the BAH of the related message.
     * todo 代码过长，需要进一步优化
     *
     * @return 返回R10检查结果
     */
    public Constraints checkR10() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String prty = businessApplicationHeaderV02.getPrty();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            XMLGregorianCalendar creDt = businessApplicationHeaderV02.getCreDt();
            String bizMsgIdr = businessApplicationHeaderV02.getBizMsgIdr();
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            String charSet = businessApplicationHeaderV02.getCharSet();
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            String msgDefIdr = businessApplicationHeaderV02.getMsgDefIdr();
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(rltd)) {
                BusinessApplicationHeader5 businessApplicationHeader5 = new BusinessApplicationHeader5();
                BeanUtils.copyProperties(businessApplicationHeaderV02, businessApplicationHeader5);
                for (BusinessApplicationHeader5 applicationHeader5 : rltd) {
                    String prty1 = applicationHeader5.getPrty();
                    Party44Choice to1 = applicationHeader5.getTo();
                    Party44Choice fr1 = applicationHeader5.getFr();
                    XMLGregorianCalendar creDt1 = applicationHeader5.getCreDt();
                    String bizMsgIdr1 = applicationHeader5.getBizMsgIdr();
                    String bizSvc1 = applicationHeader5.getBizSvc();
                    String charSet1 = applicationHeader5.getCharSet();
                    CopyDuplicate1Code cpyDplct1 = applicationHeader5.getCpyDplct();
                    String msgDefIdr1 = applicationHeader5.getMsgDefIdr();
                    ArrayList<Boolean> arrayList = new ArrayList<>();
                    arrayList.add(ruleR10(prty, prty1));
                    arrayList.add(ruleR10(bizMsgIdr, bizMsgIdr1));
                    arrayList.add(ruleR10(bizSvc, bizSvc1));
                    arrayList.add(ruleR10(charSet, charSet1));
                    arrayList.add(ruleR10(msgDefIdr, msgDefIdr1));
                    if (JudgeUtils.isNotNull(to) && JudgeUtils.isNotNull(to1)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId1 = to.getOrgId();
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId1 = to.getFIId();
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId2 = to1.getOrgId();
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId2 = to1.getFIId();
                        if (JudgeUtils.isNotNull(orgId1) && JudgeUtils.isNotNull(orgId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id1 = orgId1.getId();
                            com.hisun.kont.mx.msg.javabean.head00100102.Contact4 ctctDtls1 = orgId1.getCtctDtls();
                            String ctryOfRes1 = orgId1.getCtryOfRes();
                            String nm1 = orgId1.getNm();
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = orgId1.getPstlAdr();
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id2 = orgId1.getId();
                            com.hisun.kont.mx.msg.javabean.head00100102.Contact4 ctctDtls2 = orgId1.getCtctDtls();
                            String ctryOfRes2 = orgId1.getCtryOfRes();
                            String nm2 = orgId1.getNm();
                            arrayList.add(ruleR10(ctryOfRes1, ctryOfRes2));
                            arrayList.add(ruleR10(nm1, nm2));
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = orgId1.getPstlAdr();
                            if (JudgeUtils.isNotNull(id1) && JudgeUtils.isNotNull(id2)) {
                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentification29 orgId3 = id1.getOrgId();
                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentification13 prvtId1 = id1.getPrvtId();
                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentification13 prvtId2 = id2.getPrvtId();
                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentification29 orgId4 = id2.getOrgId();
                                if (JudgeUtils.isNotNull(orgId3) && JudgeUtils.isNotNull(orgId4)) {
                                    String anyBIC2 = orgId3.getAnyBIC();
                                    String anyBIC1 = orgId4.getAnyBIC();
                                    arrayList.add(ruleR10(anyBIC2, anyBIC1));
                                    String lei1 = orgId3.getLEI();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1> othr1 = orgId3.getOthr();
                                    String lei2 = orgId4.getLEI();
                                    arrayList.add(ruleR10(lei1, lei2));
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1> othr2 = orgId4.getOthr();
                                    if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                        for (com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1 genericOrganisationIdentification1 : othr1) {
                                            for (com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1 organisationIdentification1 : othr2) {
                                                String id3 = genericOrganisationIdentification1.getId();
                                                String id4 = organisationIdentification1.getId();
                                                String issr1 = genericOrganisationIdentification1.getIssr();
                                                String issr2 = organisationIdentification1.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice schmeNm1 = genericOrganisationIdentification1.getSchmeNm();
                                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice schmeNm2 = organisationIdentification1.getSchmeNm();
                                                if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                                    String cd1 = schmeNm1.getCd();
                                                    String cd2 = schmeNm2.getCd();
                                                    String prtry1 = schmeNm1.getPrtry();
                                                    String prtry2 = schmeNm2.getPrtry();
                                                    arrayList.add(ruleR10(cd1, cd2));
                                                    arrayList.add(ruleR10(prtry1, prtry2));
                                                }
                                            }
                                        }
                                    }
                                }
                                if (JudgeUtils.isNotNull(prvtId1) && JudgeUtils.isNotNull(prvtId2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1 dtAndPlcOfBirth1 = prvtId1.getDtAndPlcOfBirth();
                                    com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1 dtAndPlcOfBirth2 = prvtId2.getDtAndPlcOfBirth();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1> othr1 = prvtId1.getOthr();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1> othr2 = prvtId2.getOthr();
                                    if (JudgeUtils.isNotNull(dtAndPlcOfBirth1) && JudgeUtils.isNotNull(dtAndPlcOfBirth2)) {
                                        XMLGregorianCalendar birthDt1 = dtAndPlcOfBirth1.getBirthDt();
                                        XMLGregorianCalendar birthDt2 = dtAndPlcOfBirth2.getBirthDt();
                                        String cityOfBirth1 = dtAndPlcOfBirth1.getCityOfBirth();
                                        String cityOfBirth2 = dtAndPlcOfBirth2.getCityOfBirth();
                                        String ctryOfBirth1 = dtAndPlcOfBirth1.getCtryOfBirth();
                                        String ctryOfBirth2 = dtAndPlcOfBirth2.getCtryOfBirth();
                                        String prvcOfBirth1 = dtAndPlcOfBirth1.getPrvcOfBirth();
                                        String prvcOfBirth2 = dtAndPlcOfBirth2.getPrvcOfBirth();
                                        arrayList.add(ruleR10(cityOfBirth1, cityOfBirth2));
                                        arrayList.add(ruleR10(ctryOfBirth1, ctryOfBirth2));
                                        arrayList.add(ruleR10(prvcOfBirth1, prvcOfBirth2));
                                        if (JudgeUtils.isNotNull(birthDt1) && JudgeUtils.isNotNull(birthDt2)) {
                                            String b1 = birthDt1.toXMLFormat();
                                            String b2 = birthDt2.toXMLFormat();
                                            arrayList.add(ruleR10(b1, b2));
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                        for (int i = 0; i < othr1.size(); i++) {
                                            com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1 genericPersonIdentification11 = othr1.get(i);
                                            com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1 genericPersonIdentification12 = othr2.get(i);
                                            if (JudgeUtils.isNotNull(genericPersonIdentification11) && JudgeUtils.isNotNull(genericPersonIdentification12)) {
                                                String id3 = genericPersonIdentification11.getId();
                                                String id4 = genericPersonIdentification12.getId();
                                                String issr1 = genericPersonIdentification11.getIssr();
                                                String issr2 = genericPersonIdentification12.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice schmeNm1 = genericPersonIdentification11.getSchmeNm();
                                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice schmeNm2 = genericPersonIdentification12.getSchmeNm();
                                                if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                                    String cd1 = schmeNm1.getCd();
                                                    String cd2 = schmeNm2.getCd();
                                                    String prtry1 = schmeNm1.getPrtry();
                                                    String prtry2 = schmeNm2.getPrtry();
                                                    arrayList.add(ruleR10(cd1, cd2));
                                                    arrayList.add(ruleR10(prtry1, prtry2));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (JudgeUtils.isNotNull(ctctDtls1) && JudgeUtils.isNotNull(ctctDtls2)) {
                                String dept1 = ctctDtls1.getDept();
                                String emailAdr1 = ctctDtls1.getEmailAdr();
                                String emailPurp1 = ctctDtls1.getEmailPurp();
                                String faxNb1 = ctctDtls1.getFaxNb();
                                String jobTitl1 = ctctDtls1.getJobTitl();
                                String mobNb1 = ctctDtls1.getMobNb();
                                String nm3 = ctctDtls1.getNm();
                                com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code nmPrfx1 = ctctDtls1.getNmPrfx();
                                List<com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1> othr1 = ctctDtls1.getOthr();
                                String phneNb1 = ctctDtls1.getPhneNb();
                                com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code prefrdMtd1 = ctctDtls1.getPrefrdMtd();
                                String rspnsblty1 = ctctDtls1.getRspnsblty();
                                String dept2 = ctctDtls2.getDept();
                                String emailAdr2 = ctctDtls2.getEmailAdr();
                                String emailPurp2 = ctctDtls2.getEmailPurp();
                                String faxNb2 = ctctDtls2.getFaxNb();
                                String jobTitl2 = ctctDtls2.getJobTitl();
                                String mobNb2 = ctctDtls2.getMobNb();
                                String nm4 = ctctDtls2.getNm();
                                com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code nmPrfx2 = ctctDtls2.getNmPrfx();
                                List<com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1> othr2 = ctctDtls2.getOthr();
                                String phneNb2 = ctctDtls2.getPhneNb();
                                com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code prefrdMtd2 = ctctDtls2.getPrefrdMtd();
                                String rspnsblty2 = ctctDtls2.getRspnsblty();
                                arrayList.add(ruleR10(dept1, dept2));
                                arrayList.add(ruleR10(emailAdr1, emailAdr2));
                                arrayList.add(ruleR10(emailPurp1, emailPurp2));
                                arrayList.add(ruleR10(faxNb1, faxNb2));
                                arrayList.add(ruleR10(jobTitl1, jobTitl2));
                                arrayList.add(ruleR10(mobNb1, mobNb2));
                                arrayList.add(ruleR10(nm3, nm4));
                                arrayList.add(ruleR10(phneNb1, phneNb2));
                                arrayList.add(ruleR10(rspnsblty1, rspnsblty2));
                                if (JudgeUtils.isNotNull(nmPrfx1) && JudgeUtils.isNotNull(nmPrfx2)) {
                                    String value1 = nmPrfx1.value();
                                    String value2 = nmPrfx2.value();
                                    arrayList.add(ruleR10(value1, value2));
                                }
                                if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                    for (int i = 0; i < othr1.size(); i++) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1 otherContact11 = othr1.get(i);
                                        com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1 otherContact12 = othr2.get(i);
                                        if (JudgeUtils.isNotNull(otherContact11) && JudgeUtils.isNotNull(otherContact12)) {
                                            String id3 = otherContact11.getId();
                                            String id4 = otherContact12.getId();
                                            String chanlTp1 = otherContact11.getChanlTp();
                                            String chanlTp2 = otherContact12.getChanlTp();
                                            arrayList.add(ruleR10(id3, id4));
                                            arrayList.add(ruleR10(chanlTp1, chanlTp2));
                                        }
                                    }
                                }
                                if (JudgeUtils.isNotNull(prefrdMtd1) && JudgeUtils.isNotNull(prefrdMtd2)) {
                                    String value1 = prefrdMtd1.value();
                                    String value2 = prefrdMtd2.value();
                                    arrayList.add(ruleR10(value1, value2));
                                }
                            }
                            if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                List<String> adrLine1 = pstlAdr1.getAdrLine();
                                List<String> adrLine2 = pstlAdr2.getAdrLine();
                                if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                    for (int i = 0; i < adrLine1.size(); i++) {
                                        String s1 = adrLine1.get(i);
                                        String s2 = adrLine2.get(i);
                                        arrayList.add(ruleR10(s1, s2));
                                    }
                                }
                                com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                    com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                    com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                    if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                        String value1 = cd1.value();
                                        String value2 = cd2.value();
                                        arrayList.add(ruleR10(value1, value2));
                                    }
                                    if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                        String id3 = prtry1.getId();
                                        String id4 = prtry2.getId();
                                        String issr1 = prtry1.getIssr();
                                        String issr2 = prtry2.getIssr();
                                        String schmeNm1 = prtry1.getSchmeNm();
                                        String schmeNm2 = prtry2.getSchmeNm();
                                        arrayList.add(ruleR10(id3, id4));
                                        arrayList.add(ruleR10(issr1, issr2));
                                        arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                    }
                                }
                                String bldgNb1 = pstlAdr1.getBldgNb();
                                String bldgNb2 = pstlAdr2.getBldgNb();
                                String bldgNm1 = pstlAdr1.getBldgNm();
                                String bldgNm2 = pstlAdr2.getBldgNm();
                                String ctry1 = pstlAdr1.getCtry();
                                String ctry2 = pstlAdr2.getCtry();
                                String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                String dept1 = pstlAdr1.getDept();
                                String dept2 = pstlAdr2.getDept();
                                String dstrctNm1 = pstlAdr1.getDstrctNm();
                                String dstrctNm2 = pstlAdr1.getDstrctNm();
                                String flr1 = pstlAdr1.getFlr();
                                String flr2 = pstlAdr2.getFlr();
                                String pstBx1 = pstlAdr1.getPstBx();
                                String pstBx2 = pstlAdr2.getPstBx();
                                String pstCd1 = pstlAdr1.getPstCd();
                                String pstCd2 = pstlAdr2.getPstCd();
                                String room1 = pstlAdr1.getRoom();
                                String room2 = pstlAdr2.getRoom();
                                String strtNm1 = pstlAdr1.getStrtNm();
                                String strtNm2 = pstlAdr2.getStrtNm();
                                String subDept1 = pstlAdr1.getSubDept();
                                String subDept2 = pstlAdr2.getSubDept();
                                String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                String twnNm1 = pstlAdr1.getTwnNm();
                                String twnNm2 = pstlAdr2.getTwnNm();
                                arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                arrayList.add(ruleR10(ctry1, ctry2));
                                arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                arrayList.add(ruleR10(dept1, dept2));
                                arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                arrayList.add(ruleR10(flr1, flr2));
                                arrayList.add(ruleR10(pstBx1, pstBx2));
                                arrayList.add(ruleR10(pstCd1, pstCd2));
                                arrayList.add(ruleR10(room1, room2));
                                arrayList.add(ruleR10(strtNm1, strtNm2));
                                arrayList.add(ruleR10(subDept1, subDept2));
                                arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                arrayList.add(ruleR10(twnNm1, twnNm2));

                            }
                        }
                        if (JudgeUtils.isNotNull(fiId1) && JudgeUtils.isNotNull(fiId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId1 = fiId1.getFinInstnId();
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId2 = fiId2.getFinInstnId();
                            com.hisun.kont.mx.msg.javabean.head00100102.BranchData3 brnchId1 = fiId1.getBrnchId();
                            com.hisun.kont.mx.msg.javabean.head00100102.BranchData3 brnchId2 = fiId2.getBrnchId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String bicfi1 = finInstnId1.getBICFI();
                                String bicfi2 = finInstnId2.getBICFI();
                                String lei1 = finInstnId1.getLEI();
                                String lei2 = finInstnId2.getLEI();
                                String nm1 = finInstnId1.getNm();
                                String nm2 = finInstnId2.getNm();
                                arrayList.add(ruleR10(bicfi1, bicfi2));
                                arrayList.add(ruleR10(lei1, lei2));
                                arrayList.add(ruleR10(nm1, nm2));
                                com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2 clrSysMmbId1 = finInstnId1.getClrSysMmbId();
                                com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2 clrSysMmbId2 = finInstnId2.getClrSysMmbId();
                                com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1 othr1 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1 othr2 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = finInstnId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = finInstnId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(clrSysMmbId1) && JudgeUtils.isNotNull(clrSysMmbId2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice clrSysId1 = clrSysMmbId1.getClrSysId();
                                    com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice clrSysId2 = clrSysMmbId2.getClrSysId();
                                    String mmbId1 = clrSysMmbId1.getMmbId();
                                    String mmbId2 = clrSysMmbId2.getMmbId();
                                    arrayList.add(ruleR10(mmbId1, mmbId2));
                                    if (JudgeUtils.isNotNull(clrSysId1) && JudgeUtils.isNotNull(clrSysId2)) {
                                        String cd1 = clrSysId1.getCd();
                                        String cd2 = clrSysId2.getCd();
                                        String prtry1 = clrSysId1.getPrtry();
                                        String prtry2 = clrSysId2.getPrtry();
                                        arrayList.add(ruleR10(cd1, cd2));
                                        arrayList.add(ruleR10(prtry1, prtry2));
                                    }
                                }
                                if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                    String id1 = othr1.getId();
                                    String id2 = othr2.getId();
                                    String issr1 = othr1.getIssr();
                                    String issr2 = othr2.getIssr();
                                    arrayList.add(ruleR10(id1, id2));
                                    arrayList.add(ruleR10(issr1, issr2));
                                    com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice schmeNm1 = othr1.getSchmeNm();
                                    com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice schmeNm2 = othr2.getSchmeNm();
                                    if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                        String cd1 = schmeNm1.getCd();
                                        String cd2 = schmeNm2.getCd();
                                        String prtry1 = schmeNm1.getPrtry();
                                        String prtry2 = schmeNm2.getPrtry();
                                        arrayList.add(ruleR10(cd1, cd2));
                                        arrayList.add(ruleR10(prtry1, prtry2));

                                    }
                                }
                                if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                    List<String> adrLine1 = pstlAdr1.getAdrLine();
                                    List<String> adrLine2 = pstlAdr2.getAdrLine();
                                    if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                        for (int i = 0; i < adrLine1.size(); i++) {
                                            String s1 = adrLine1.get(i);
                                            String s2 = adrLine2.get(i);
                                            arrayList.add(ruleR10(s1, s2));
                                        }
                                    }
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                    if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                        if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                            String value1 = cd1.value();
                                            String value2 = cd2.value();
                                            arrayList.add(ruleR10(value1, value2));
                                        }
                                        if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                            String id1 = prtry1.getId();
                                            String id2 = prtry2.getId();
                                            String issr1 = prtry1.getIssr();
                                            String issr2 = prtry2.getIssr();
                                            String schmeNm1 = prtry1.getSchmeNm();
                                            String schmeNm2 = prtry2.getSchmeNm();
                                            arrayList.add(ruleR10(id1, id2));
                                            arrayList.add(ruleR10(issr1, issr2));
                                            arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                        }
                                    }
                                    String bldgNb1 = pstlAdr1.getBldgNb();
                                    String bldgNb2 = pstlAdr2.getBldgNb();
                                    String bldgNm1 = pstlAdr1.getBldgNm();
                                    String bldgNm2 = pstlAdr2.getBldgNm();
                                    String ctry1 = pstlAdr1.getCtry();
                                    String ctry2 = pstlAdr2.getCtry();
                                    String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                    String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                    String dept1 = pstlAdr1.getDept();
                                    String dept2 = pstlAdr2.getDept();
                                    String dstrctNm1 = pstlAdr1.getDstrctNm();
                                    String dstrctNm2 = pstlAdr2.getDstrctNm();
                                    String flr1 = pstlAdr1.getFlr();
                                    String flr2 = pstlAdr2.getFlr();
                                    String pstBx1 = pstlAdr1.getPstBx();
                                    String pstBx2 = pstlAdr2.getPstBx();
                                    String pstCd1 = pstlAdr1.getPstCd();
                                    String pstCd2 = pstlAdr2.getPstCd();
                                    String room1 = pstlAdr1.getRoom();
                                    String room2 = pstlAdr2.getRoom();
                                    String strtNm1 = pstlAdr1.getStrtNm();
                                    String strtNm2 = pstlAdr2.getStrtNm();
                                    String subDept1 = pstlAdr1.getSubDept();
                                    String subDept2 = pstlAdr2.getSubDept();
                                    String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                    String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                    String twnNm1 = pstlAdr1.getTwnNm();
                                    String twnNm2 = pstlAdr2.getTwnNm();
                                    arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                    arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                    arrayList.add(ruleR10(ctry1, ctry2));
                                    arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                    arrayList.add(ruleR10(dept1, dept2));
                                    arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                    arrayList.add(ruleR10(flr1, flr2));
                                    arrayList.add(ruleR10(pstBx1, pstBx2));
                                    arrayList.add(ruleR10(pstCd1, pstCd2));
                                    arrayList.add(ruleR10(room1, room2));
                                    arrayList.add(ruleR10(strtNm1, strtNm2));
                                    arrayList.add(ruleR10(subDept1, subDept2));
                                    arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                    arrayList.add(ruleR10(twnNm1, twnNm2));
                                }
                            }
                            if (JudgeUtils.isNotNull(brnchId1) && JudgeUtils.isNotNull(brnchId2)) {
                                String id1 = brnchId1.getId();
                                String id2 = brnchId2.getId();
                                String lei1 = brnchId1.getLEI();
                                String lei2 = brnchId2.getLEI();
                                String nm1 = brnchId1.getNm();
                                String nm2 = brnchId2.getNm();
                                arrayList.add(ruleR10(lei1, lei2));
                                arrayList.add(ruleR10(id1, id2));
                                arrayList.add(ruleR10(nm1, nm2));
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = brnchId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = brnchId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                    List<String> adrLine1 = pstlAdr1.getAdrLine();
                                    List<String> adrLine2 = pstlAdr2.getAdrLine();
                                    if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                        for (int i = 0; i < adrLine1.size(); i++) {
                                            String s1 = adrLine1.get(i);
                                            String s2 = adrLine2.get(i);
                                            arrayList.add(ruleR10(s1, s2));
                                        }
                                    }
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                    if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                        if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                            String value1 = cd1.value();
                                            String value2 = cd2.value();
                                            arrayList.add(ruleR10(value1, value2));
                                        }
                                        if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                            String id3 = prtry1.getId();
                                            String id4 = prtry2.getId();
                                            String issr1 = prtry1.getIssr();
                                            String issr2 = prtry2.getIssr();
                                            String schmeNm1 = prtry1.getSchmeNm();
                                            String schmeNm2 = prtry2.getSchmeNm();
                                            arrayList.add(ruleR10(id3, id4));
                                            arrayList.add(ruleR10(issr1, issr2));
                                            arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                        }
                                    }
                                    String bldgNb1 = pstlAdr1.getBldgNb();
                                    String bldgNb2 = pstlAdr2.getBldgNb();
                                    String bldgNm1 = pstlAdr1.getBldgNm();
                                    String bldgNm2 = pstlAdr2.getBldgNm();
                                    String ctry1 = pstlAdr1.getCtry();
                                    String ctry2 = pstlAdr2.getCtry();
                                    String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                    String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                    String dept1 = pstlAdr1.getDept();
                                    String dept2 = pstlAdr2.getDept();
                                    String dstrctNm1 = pstlAdr1.getDstrctNm();
                                    String dstrctNm2 = pstlAdr2.getDstrctNm();
                                    String flr1 = pstlAdr1.getFlr();
                                    String flr2 = pstlAdr2.getFlr();
                                    String pstBx1 = pstlAdr1.getPstBx();
                                    String pstBx2 = pstlAdr2.getPstBx();
                                    String pstCd1 = pstlAdr1.getPstCd();
                                    String pstCd2 = pstlAdr2.getPstCd();
                                    String room1 = pstlAdr1.getRoom();
                                    String room2 = pstlAdr2.getRoom();
                                    String strtNm1 = pstlAdr1.getStrtNm();
                                    String strtNm2 = pstlAdr2.getStrtNm();
                                    String subDept1 = pstlAdr1.getSubDept();
                                    String subDept2 = pstlAdr2.getSubDept();
                                    String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                    String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                    String twnNm1 = pstlAdr1.getTwnNm();
                                    String twnNm2 = pstlAdr2.getTwnNm();
                                    arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                    arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                    arrayList.add(ruleR10(ctry1, ctry2));
                                    arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                    arrayList.add(ruleR10(dept1, dept2));
                                    arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                    arrayList.add(ruleR10(flr1, flr2));
                                    arrayList.add(ruleR10(pstBx1, pstBx2));
                                    arrayList.add(ruleR10(pstCd1, pstCd2));
                                    arrayList.add(ruleR10(room1, room2));
                                    arrayList.add(ruleR10(strtNm1, strtNm2));
                                    arrayList.add(ruleR10(subDept1, subDept2));
                                    arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                    arrayList.add(ruleR10(twnNm1, twnNm2));
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(fr) && JudgeUtils.isNotNull(fr1)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId1 = fr.getOrgId();
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId1 = fr.getFIId();
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId2 = fr1.getOrgId();
                        com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId2 = fr1.getFIId();
                        if (JudgeUtils.isNotNull(orgId1) && JudgeUtils.isNotNull(orgId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id1 = orgId1.getId();
                            com.hisun.kont.mx.msg.javabean.head00100102.Contact4 ctctDtls1 = orgId1.getCtctDtls();
                            String ctryOfRes1 = orgId1.getCtryOfRes();
                            String nm1 = orgId1.getNm();
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = orgId1.getPstlAdr();
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id2 = orgId1.getId();
                            com.hisun.kont.mx.msg.javabean.head00100102.Contact4 ctctDtls2 = orgId1.getCtctDtls();
                            String ctryOfRes2 = orgId1.getCtryOfRes();
                            String nm2 = orgId1.getNm();
                            arrayList.add(ruleR10(ctryOfRes1, ctryOfRes2));
                            arrayList.add(ruleR10(nm1, nm2));
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = orgId1.getPstlAdr();
                            if (JudgeUtils.isNotNull(id1) && JudgeUtils.isNotNull(id2)) {
                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentification29 orgId3 = id1.getOrgId();
                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentification13 prvtId1 = id1.getPrvtId();
                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentification13 prvtId2 = id2.getPrvtId();
                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentification29 orgId4 = id2.getOrgId();
                                if (JudgeUtils.isNotNull(orgId3) && JudgeUtils.isNotNull(orgId4)) {
                                    String anyBIC2 = orgId3.getAnyBIC();
                                    String anyBIC1 = orgId4.getAnyBIC();
                                    arrayList.add(ruleR10(anyBIC2, anyBIC1));
                                    String lei1 = orgId3.getLEI();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1> othr1 = orgId3.getOthr();
                                    String lei2 = orgId4.getLEI();
                                    arrayList.add(ruleR10(lei1, lei2));
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1> othr2 = orgId4.getOthr();
                                    if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                        for (com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1 genericOrganisationIdentification1 : othr1) {
                                            for (com.hisun.kont.mx.msg.javabean.head00100102.GenericOrganisationIdentification1 organisationIdentification1 : othr2) {
                                                String id3 = genericOrganisationIdentification1.getId();
                                                String id4 = organisationIdentification1.getId();
                                                String issr1 = genericOrganisationIdentification1.getIssr();
                                                String issr2 = organisationIdentification1.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice schmeNm1 = genericOrganisationIdentification1.getSchmeNm();
                                                com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice schmeNm2 = organisationIdentification1.getSchmeNm();
                                                if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                                    String cd1 = schmeNm1.getCd();
                                                    String cd2 = schmeNm2.getCd();
                                                    String prtry1 = schmeNm1.getPrtry();
                                                    String prtry2 = schmeNm2.getPrtry();
                                                    arrayList.add(ruleR10(cd1, cd2));
                                                    arrayList.add(ruleR10(prtry1, prtry2));
                                                }
                                            }
                                        }
                                    }
                                }
                                if (JudgeUtils.isNotNull(prvtId1) && JudgeUtils.isNotNull(prvtId2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1 dtAndPlcOfBirth1 = prvtId1.getDtAndPlcOfBirth();
                                    com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1 dtAndPlcOfBirth2 = prvtId2.getDtAndPlcOfBirth();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1> othr1 = prvtId1.getOthr();
                                    List<com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1> othr2 = prvtId2.getOthr();
                                    if (JudgeUtils.isNotNull(dtAndPlcOfBirth1) && JudgeUtils.isNotNull(dtAndPlcOfBirth2)) {
                                        XMLGregorianCalendar birthDt1 = dtAndPlcOfBirth1.getBirthDt();
                                        XMLGregorianCalendar birthDt2 = dtAndPlcOfBirth2.getBirthDt();
                                        String cityOfBirth1 = dtAndPlcOfBirth1.getCityOfBirth();
                                        String cityOfBirth2 = dtAndPlcOfBirth2.getCityOfBirth();
                                        String ctryOfBirth1 = dtAndPlcOfBirth1.getCtryOfBirth();
                                        String ctryOfBirth2 = dtAndPlcOfBirth2.getCtryOfBirth();
                                        String prvcOfBirth1 = dtAndPlcOfBirth1.getPrvcOfBirth();
                                        String prvcOfBirth2 = dtAndPlcOfBirth2.getPrvcOfBirth();
                                        arrayList.add(ruleR10(cityOfBirth1, cityOfBirth2));
                                        arrayList.add(ruleR10(ctryOfBirth1, ctryOfBirth2));
                                        arrayList.add(ruleR10(prvcOfBirth1, prvcOfBirth2));
                                        if (JudgeUtils.isNotNull(birthDt1) && JudgeUtils.isNotNull(birthDt2)) {
                                            String b1 = birthDt1.toXMLFormat();
                                            String b2 = birthDt2.toXMLFormat();
                                            arrayList.add(ruleR10(b1, b2));
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                        for (int i = 0; i < othr1.size(); i++) {
                                            com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1 genericPersonIdentification11 = othr1.get(i);
                                            com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1 genericPersonIdentification12 = othr2.get(i);
                                            if (JudgeUtils.isNotNull(genericPersonIdentification11) && JudgeUtils.isNotNull(genericPersonIdentification12)) {
                                                String id3 = genericPersonIdentification11.getId();
                                                String id4 = genericPersonIdentification12.getId();
                                                String issr1 = genericPersonIdentification11.getIssr();
                                                String issr2 = genericPersonIdentification12.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice schmeNm1 = genericPersonIdentification11.getSchmeNm();
                                                com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice schmeNm2 = genericPersonIdentification12.getSchmeNm();
                                                if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                                    String cd1 = schmeNm1.getCd();
                                                    String cd2 = schmeNm2.getCd();
                                                    String prtry1 = schmeNm1.getPrtry();
                                                    String prtry2 = schmeNm2.getPrtry();
                                                    arrayList.add(ruleR10(cd1, cd2));
                                                    arrayList.add(ruleR10(prtry1, prtry2));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (JudgeUtils.isNotNull(ctctDtls1) && JudgeUtils.isNotNull(ctctDtls2)) {
                                String dept1 = ctctDtls1.getDept();
                                String emailAdr1 = ctctDtls1.getEmailAdr();
                                String emailPurp1 = ctctDtls1.getEmailPurp();
                                String faxNb1 = ctctDtls1.getFaxNb();
                                String jobTitl1 = ctctDtls1.getJobTitl();
                                String mobNb1 = ctctDtls1.getMobNb();
                                String nm3 = ctctDtls1.getNm();
                                com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code nmPrfx1 = ctctDtls1.getNmPrfx();
                                List<com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1> othr1 = ctctDtls1.getOthr();
                                String phneNb1 = ctctDtls1.getPhneNb();
                                com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code prefrdMtd1 = ctctDtls1.getPrefrdMtd();
                                String rspnsblty1 = ctctDtls1.getRspnsblty();
                                String dept2 = ctctDtls2.getDept();
                                String emailAdr2 = ctctDtls2.getEmailAdr();
                                String emailPurp2 = ctctDtls2.getEmailPurp();
                                String faxNb2 = ctctDtls2.getFaxNb();
                                String jobTitl2 = ctctDtls2.getJobTitl();
                                String mobNb2 = ctctDtls2.getMobNb();
                                String nm4 = ctctDtls2.getNm();
                                com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code nmPrfx2 = ctctDtls2.getNmPrfx();
                                List<com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1> othr2 = ctctDtls2.getOthr();
                                String phneNb2 = ctctDtls2.getPhneNb();
                                com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code prefrdMtd2 = ctctDtls2.getPrefrdMtd();
                                String rspnsblty2 = ctctDtls2.getRspnsblty();
                                arrayList.add(ruleR10(dept1, dept2));
                                arrayList.add(ruleR10(emailAdr1, emailAdr2));
                                arrayList.add(ruleR10(emailPurp1, emailPurp2));
                                arrayList.add(ruleR10(faxNb1, faxNb2));
                                arrayList.add(ruleR10(jobTitl1, jobTitl2));
                                arrayList.add(ruleR10(mobNb1, mobNb2));
                                arrayList.add(ruleR10(nm3, nm4));
                                arrayList.add(ruleR10(phneNb1, phneNb2));
                                arrayList.add(ruleR10(rspnsblty1, rspnsblty2));
                                if (JudgeUtils.isNotNull(nmPrfx1) && JudgeUtils.isNotNull(nmPrfx2)) {
                                    String value1 = nmPrfx1.value();
                                    String value2 = nmPrfx2.value();
                                    arrayList.add(ruleR10(value1, value2));
                                }
                                if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                    for (int i = 0; i < othr1.size(); i++) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1 otherContact11 = othr1.get(i);
                                        com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1 otherContact12 = othr2.get(i);
                                        if (JudgeUtils.isNotNull(otherContact11) && JudgeUtils.isNotNull(otherContact12)) {
                                            String id3 = otherContact11.getId();
                                            String id4 = otherContact12.getId();
                                            String chanlTp1 = otherContact11.getChanlTp();
                                            String chanlTp2 = otherContact12.getChanlTp();
                                            arrayList.add(ruleR10(id3, id4));
                                            arrayList.add(ruleR10(chanlTp1, chanlTp2));
                                        }
                                    }
                                }
                                if (JudgeUtils.isNotNull(prefrdMtd1) && JudgeUtils.isNotNull(prefrdMtd2)) {
                                    String value1 = prefrdMtd1.value();
                                    String value2 = prefrdMtd2.value();
                                    arrayList.add(ruleR10(value1, value2));
                                }
                            }
                            if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                List<String> adrLine1 = pstlAdr1.getAdrLine();
                                List<String> adrLine2 = pstlAdr2.getAdrLine();
                                if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                    for (int i = 0; i < adrLine1.size(); i++) {
                                        String s1 = adrLine1.get(i);
                                        String s2 = adrLine2.get(i);
                                        arrayList.add(ruleR10(s1, s2));
                                    }
                                }
                                com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                    com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                    com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                    if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                        String value1 = cd1.value();
                                        String value2 = cd2.value();
                                        arrayList.add(ruleR10(value1, value2));
                                    }
                                    if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                        String id3 = prtry1.getId();
                                        String id4 = prtry2.getId();
                                        String issr1 = prtry1.getIssr();
                                        String issr2 = prtry2.getIssr();
                                        String schmeNm1 = prtry1.getSchmeNm();
                                        String schmeNm2 = prtry2.getSchmeNm();
                                        arrayList.add(ruleR10(id3, id4));
                                        arrayList.add(ruleR10(issr1, issr2));
                                        arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                    }
                                }
                                String bldgNb1 = pstlAdr1.getBldgNb();
                                String bldgNb2 = pstlAdr2.getBldgNb();
                                String bldgNm1 = pstlAdr1.getBldgNm();
                                String bldgNm2 = pstlAdr2.getBldgNm();
                                String ctry1 = pstlAdr1.getCtry();
                                String ctry2 = pstlAdr2.getCtry();
                                String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                String dept1 = pstlAdr1.getDept();
                                String dept2 = pstlAdr2.getDept();
                                String dstrctNm1 = pstlAdr1.getDstrctNm();
                                String dstrctNm2 = pstlAdr1.getDstrctNm();
                                String flr1 = pstlAdr1.getFlr();
                                String flr2 = pstlAdr2.getFlr();
                                String pstBx1 = pstlAdr1.getPstBx();
                                String pstBx2 = pstlAdr2.getPstBx();
                                String pstCd1 = pstlAdr1.getPstCd();
                                String pstCd2 = pstlAdr2.getPstCd();
                                String room1 = pstlAdr1.getRoom();
                                String room2 = pstlAdr2.getRoom();
                                String strtNm1 = pstlAdr1.getStrtNm();
                                String strtNm2 = pstlAdr2.getStrtNm();
                                String subDept1 = pstlAdr1.getSubDept();
                                String subDept2 = pstlAdr2.getSubDept();
                                String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                String twnNm1 = pstlAdr1.getTwnNm();
                                String twnNm2 = pstlAdr2.getTwnNm();
                                arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                arrayList.add(ruleR10(ctry1, ctry2));
                                arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                arrayList.add(ruleR10(dept1, dept2));
                                arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                arrayList.add(ruleR10(flr1, flr2));
                                arrayList.add(ruleR10(pstBx1, pstBx2));
                                arrayList.add(ruleR10(pstCd1, pstCd2));
                                arrayList.add(ruleR10(room1, room2));
                                arrayList.add(ruleR10(strtNm1, strtNm2));
                                arrayList.add(ruleR10(subDept1, subDept2));
                                arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                arrayList.add(ruleR10(twnNm1, twnNm2));

                            }
                        }
                        if (JudgeUtils.isNotNull(fiId1) && JudgeUtils.isNotNull(fiId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId1 = fiId1.getFinInstnId();
                            com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId2 = fiId2.getFinInstnId();
                            com.hisun.kont.mx.msg.javabean.head00100102.BranchData3 brnchId1 = fiId1.getBrnchId();
                            com.hisun.kont.mx.msg.javabean.head00100102.BranchData3 brnchId2 = fiId2.getBrnchId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String bicfi1 = finInstnId1.getBICFI();
                                String bicfi2 = finInstnId2.getBICFI();
                                String lei1 = finInstnId1.getLEI();
                                String lei2 = finInstnId2.getLEI();
                                String nm1 = finInstnId1.getNm();
                                String nm2 = finInstnId2.getNm();
                                arrayList.add(ruleR10(bicfi1, bicfi2));
                                arrayList.add(ruleR10(lei1, lei2));
                                arrayList.add(ruleR10(nm1, nm2));
                                com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2 clrSysMmbId1 = finInstnId1.getClrSysMmbId();
                                com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2 clrSysMmbId2 = finInstnId2.getClrSysMmbId();
                                com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1 othr1 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1 othr2 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = finInstnId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = finInstnId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(clrSysMmbId1) && JudgeUtils.isNotNull(clrSysMmbId2)) {
                                    com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice clrSysId1 = clrSysMmbId1.getClrSysId();
                                    com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice clrSysId2 = clrSysMmbId2.getClrSysId();
                                    String mmbId1 = clrSysMmbId1.getMmbId();
                                    String mmbId2 = clrSysMmbId2.getMmbId();
                                    arrayList.add(ruleR10(mmbId1, mmbId2));
                                    if (JudgeUtils.isNotNull(clrSysId1) && JudgeUtils.isNotNull(clrSysId2)) {
                                        String cd1 = clrSysId1.getCd();
                                        String cd2 = clrSysId2.getCd();
                                        String prtry1 = clrSysId1.getPrtry();
                                        String prtry2 = clrSysId2.getPrtry();
                                        arrayList.add(ruleR10(cd1, cd2));
                                        arrayList.add(ruleR10(prtry1, prtry2));
                                    }
                                }
                                if (JudgeUtils.isNotNull(othr1) && JudgeUtils.isNotNull(othr2)) {
                                    String id1 = othr1.getId();
                                    String id2 = othr2.getId();
                                    String issr1 = othr1.getIssr();
                                    String issr2 = othr2.getIssr();
                                    arrayList.add(ruleR10(id1, id2));
                                    arrayList.add(ruleR10(issr1, issr2));
                                    com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice schmeNm1 = othr1.getSchmeNm();
                                    com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice schmeNm2 = othr2.getSchmeNm();
                                    if (JudgeUtils.isNotNull(schmeNm1) && JudgeUtils.isNotNull(schmeNm2)) {
                                        String cd1 = schmeNm1.getCd();
                                        String cd2 = schmeNm2.getCd();
                                        String prtry1 = schmeNm1.getPrtry();
                                        String prtry2 = schmeNm2.getPrtry();
                                        arrayList.add(ruleR10(cd1, cd2));
                                        arrayList.add(ruleR10(prtry1, prtry2));

                                    }
                                }
                                if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                    List<String> adrLine1 = pstlAdr1.getAdrLine();
                                    List<String> adrLine2 = pstlAdr2.getAdrLine();
                                    if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                        for (int i = 0; i < adrLine1.size(); i++) {
                                            String s1 = adrLine1.get(i);
                                            String s2 = adrLine2.get(i);
                                            arrayList.add(ruleR10(s1, s2));
                                        }
                                    }
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                    if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                        if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                            String value1 = cd1.value();
                                            String value2 = cd2.value();
                                            arrayList.add(ruleR10(value1, value2));
                                        }
                                        if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                            String id1 = prtry1.getId();
                                            String id2 = prtry2.getId();
                                            String issr1 = prtry1.getIssr();
                                            String issr2 = prtry2.getIssr();
                                            String schmeNm1 = prtry1.getSchmeNm();
                                            String schmeNm2 = prtry2.getSchmeNm();
                                            arrayList.add(ruleR10(id1, id2));
                                            arrayList.add(ruleR10(issr1, issr2));
                                            arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                        }
                                    }
                                    String bldgNb1 = pstlAdr1.getBldgNb();
                                    String bldgNb2 = pstlAdr2.getBldgNb();
                                    String bldgNm1 = pstlAdr1.getBldgNm();
                                    String bldgNm2 = pstlAdr2.getBldgNm();
                                    String ctry1 = pstlAdr1.getCtry();
                                    String ctry2 = pstlAdr2.getCtry();
                                    String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                    String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                    String dept1 = pstlAdr1.getDept();
                                    String dept2 = pstlAdr2.getDept();
                                    String dstrctNm1 = pstlAdr1.getDstrctNm();
                                    String dstrctNm2 = pstlAdr2.getDstrctNm();
                                    String flr1 = pstlAdr1.getFlr();
                                    String flr2 = pstlAdr2.getFlr();
                                    String pstBx1 = pstlAdr1.getPstBx();
                                    String pstBx2 = pstlAdr2.getPstBx();
                                    String pstCd1 = pstlAdr1.getPstCd();
                                    String pstCd2 = pstlAdr2.getPstCd();
                                    String room1 = pstlAdr1.getRoom();
                                    String room2 = pstlAdr2.getRoom();
                                    String strtNm1 = pstlAdr1.getStrtNm();
                                    String strtNm2 = pstlAdr2.getStrtNm();
                                    String subDept1 = pstlAdr1.getSubDept();
                                    String subDept2 = pstlAdr2.getSubDept();
                                    String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                    String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                    String twnNm1 = pstlAdr1.getTwnNm();
                                    String twnNm2 = pstlAdr2.getTwnNm();
                                    arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                    arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                    arrayList.add(ruleR10(ctry1, ctry2));
                                    arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                    arrayList.add(ruleR10(dept1, dept2));
                                    arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                    arrayList.add(ruleR10(flr1, flr2));
                                    arrayList.add(ruleR10(pstBx1, pstBx2));
                                    arrayList.add(ruleR10(pstCd1, pstCd2));
                                    arrayList.add(ruleR10(room1, room2));
                                    arrayList.add(ruleR10(strtNm1, strtNm2));
                                    arrayList.add(ruleR10(subDept1, subDept2));
                                    arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                    arrayList.add(ruleR10(twnNm1, twnNm2));
                                }
                            }
                            if (JudgeUtils.isNotNull(brnchId1) && JudgeUtils.isNotNull(brnchId2)) {
                                String id1 = brnchId1.getId();
                                String id2 = brnchId2.getId();
                                String lei1 = brnchId1.getLEI();
                                String lei2 = brnchId2.getLEI();
                                String nm1 = brnchId1.getNm();
                                String nm2 = brnchId2.getNm();
                                arrayList.add(ruleR10(lei1, lei2));
                                arrayList.add(ruleR10(id1, id2));
                                arrayList.add(ruleR10(nm1, nm2));
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = brnchId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = brnchId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr1) && JudgeUtils.isNotNull(pstlAdr2)) {
                                    List<String> adrLine1 = pstlAdr1.getAdrLine();
                                    List<String> adrLine2 = pstlAdr2.getAdrLine();
                                    if (JudgeUtils.isNotNull(adrLine1) && JudgeUtils.isNotNull(adrLine2)) {
                                        for (int i = 0; i < adrLine1.size(); i++) {
                                            String s1 = adrLine1.get(i);
                                            String s2 = adrLine2.get(i);
                                            arrayList.add(ruleR10(s1, s2));
                                        }
                                    }
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp1 = pstlAdr1.getAdrTp();
                                    com.hisun.kont.mx.msg.javabean.head00100102.AddressType3Choice adrTp2 = pstlAdr2.getAdrTp();
                                    if (JudgeUtils.isNotNull(adrTp1) && JudgeUtils.isNotNull(adrTp2)) {
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd1 = adrTp1.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code cd2 = adrTp2.getCd();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30 prtry2 = adrTp2.getPrtry();
                                        if (JudgeUtils.isNotNull(cd1) && JudgeUtils.isNotNull(cd2)) {
                                            String value1 = cd1.value();
                                            String value2 = cd2.value();
                                            arrayList.add(ruleR10(value1, value2));
                                        }
                                        if (JudgeUtils.isNotNull(prtry1) && JudgeUtils.isNotNull(prtry2)) {
                                            String id3 = prtry1.getId();
                                            String id4 = prtry2.getId();
                                            String issr1 = prtry1.getIssr();
                                            String issr2 = prtry2.getIssr();
                                            String schmeNm1 = prtry1.getSchmeNm();
                                            String schmeNm2 = prtry2.getSchmeNm();
                                            arrayList.add(ruleR10(id3, id4));
                                            arrayList.add(ruleR10(issr1, issr2));
                                            arrayList.add(ruleR10(schmeNm1, schmeNm2));
                                        }
                                    }
                                    String bldgNb1 = pstlAdr1.getBldgNb();
                                    String bldgNb2 = pstlAdr2.getBldgNb();
                                    String bldgNm1 = pstlAdr1.getBldgNm();
                                    String bldgNm2 = pstlAdr2.getBldgNm();
                                    String ctry1 = pstlAdr1.getCtry();
                                    String ctry2 = pstlAdr2.getCtry();
                                    String ctrySubDvsn1 = pstlAdr1.getCtrySubDvsn();
                                    String ctrySubDvsn2 = pstlAdr2.getCtrySubDvsn();
                                    String dept1 = pstlAdr1.getDept();
                                    String dept2 = pstlAdr2.getDept();
                                    String dstrctNm1 = pstlAdr1.getDstrctNm();
                                    String dstrctNm2 = pstlAdr2.getDstrctNm();
                                    String flr1 = pstlAdr1.getFlr();
                                    String flr2 = pstlAdr2.getFlr();
                                    String pstBx1 = pstlAdr1.getPstBx();
                                    String pstBx2 = pstlAdr2.getPstBx();
                                    String pstCd1 = pstlAdr1.getPstCd();
                                    String pstCd2 = pstlAdr2.getPstCd();
                                    String room1 = pstlAdr1.getRoom();
                                    String room2 = pstlAdr2.getRoom();
                                    String strtNm1 = pstlAdr1.getStrtNm();
                                    String strtNm2 = pstlAdr2.getStrtNm();
                                    String subDept1 = pstlAdr1.getSubDept();
                                    String subDept2 = pstlAdr2.getSubDept();
                                    String twnLctnNm1 = pstlAdr1.getTwnLctnNm();
                                    String twnLctnNm2 = pstlAdr2.getTwnLctnNm();
                                    String twnNm1 = pstlAdr1.getTwnNm();
                                    String twnNm2 = pstlAdr2.getTwnNm();
                                    arrayList.add(ruleR10(bldgNb1, bldgNb2));
                                    arrayList.add(ruleR10(bldgNm1, bldgNm2));
                                    arrayList.add(ruleR10(ctry1, ctry2));
                                    arrayList.add(ruleR10(ctrySubDvsn1, ctrySubDvsn2));
                                    arrayList.add(ruleR10(dept1, dept2));
                                    arrayList.add(ruleR10(dstrctNm1, dstrctNm2));
                                    arrayList.add(ruleR10(flr1, flr2));
                                    arrayList.add(ruleR10(pstBx1, pstBx2));
                                    arrayList.add(ruleR10(pstCd1, pstCd2));
                                    arrayList.add(ruleR10(room1, room2));
                                    arrayList.add(ruleR10(strtNm1, strtNm2));
                                    arrayList.add(ruleR10(subDept1, subDept2));
                                    arrayList.add(ruleR10(twnLctnNm1, twnLctnNm2));
                                    arrayList.add(ruleR10(twnNm1, twnNm2));
                                }
                            }
                        }
                    }

                    if (JudgeUtils.isNotNull(creDt) && JudgeUtils.isNotNull(creDt1)) {
                        String s1 = creDt.toXMLFormat();
                        String s2 = creDt1.toXMLFormat();
                        arrayList.add(ruleR10(s1, s2));
                    }
                    if (JudgeUtils.isNotNull(cpyDplct) && JudgeUtils.isNotNull(cpyDplct1)) {
                        String value1 = cpyDplct.value();
                        String value2 = cpyDplct1.value();
                        arrayList.add(ruleR10(value1, value2));
                    }
                    if (arrayList.contains(false)) {
                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R10_ERROR_CODE, MXPacs00900108Constant.R10_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    private boolean ruleR10(String str1, String str2) {
        boolean isEqual = true;
        if (JudgeUtils.isNotNull(str1) && JudgeUtils.isNotNull(str2)) {
            if (!str1.equals(str2)) {
                isEqual = false;
                return isEqual;
            }
        }
        return isEqual;
    }

    /**
     * If related BAH is present, it should transport the element Business Service.
     *
     * @return 返回R11检查结果
     */
    public Constraints checkR11() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 applicationHeader5 : rltd) {
                    String bizSvc = applicationHeader5.getBizSvc();
                    if (JudgeUtils.isNull(bizSvc)) {
                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R11_ERROR_CODE, MXPacs00900108Constant.R11_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }


    /**
     * Each code can only be used once for element "Instruction For Creditor Agent".
     * todo 不太清楚啥意思
     *
     * @return 返回R12检查结果
     */
    public Constraints checkR12() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        List<InstructionForCreditorAgent3> instrForCdtrAgt = creditTransferTransaction56.getInstrForCdtrAgt();
                        if (JudgeUtils.isNotNull(instrForCdtrAgt)) {
                            int sum = 0;
                            for (InstructionForCreditorAgent3 instructionForCreditorAgent3 : instrForCdtrAgt) {
                                String cd = instructionForCreditorAgent3.getCd();
                                if (JudgeUtils.isNotNull(cd)) {
                                    sum++;
                                }
                            }
                            if (sum > 1) {
                                return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R12_ERROR_CODE, MXPacs00900108Constant.R12_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * This field must not start or end with a slash '/' and must not contain two consecutive slashes '//'.
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/InstrId
     *
     * @return 返回R13检查结果
     */
    public Constraints checkR13() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction50 : cdtTrfTxInf) {
                        PaymentIdentification13 pmtId = creditTransferTransaction50.getPmtId();
                        if (JudgeUtils.isNotNull(pmtId)) {
                            String instrId = pmtId.getInstrId();
                            boolean startsWith = instrId.startsWith("/");
                            boolean endsWith = instrId.endsWith("/");
                            boolean contains = instrId.contains("//");
                            if (startsWith || endsWith || contains) {
                                return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R13_ERROR_CODE, MXPacs00900108Constant.R13_ERROR_TEXT, instrId);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * In the pacs.009 CORE, the E2E identification is provided by the Debtor (Agent).
     * todo
     *
     * @return 返回R14检查结果
     */
    public Constraints checkR14() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)){
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)){
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)){
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        PaymentIdentification13 pmtId = creditTransferTransaction56.getPmtId();
                        if (JudgeUtils.isNotNull(pmtId)){
                            String endToEndId = pmtId.getEndToEndId();

                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * For the E2E identification, the below restrictions apply to the first 16 characters:
     * - The first one and the 16th one cannot be “/” and
     * - The string of 16 characters cannot contain “//”
     * /Document/FICdtTrf/CdtTrfTxInf/PmtId/EndToEndId
     *
     * @return 返回R15检查结果
     */
    public Constraints checkR15() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        PaymentIdentification13 pmtId = creditTransferTransaction56.getPmtId();
                        if (JudgeUtils.isNotNull(pmtId)) {
                            String endToEndId = pmtId.getEndToEndId();
                            if (JudgeUtils.isNotNull(endToEndId)) {
                                String substring = endToEndId.substring(0, 16);
                                String first_String = substring.substring(0, 1);
                                String the_16String = substring.substring(15, 16);
                                if ("/".equals(first_String) || "/".equals(the_16String)) {
                                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R15_ERROR_CODE, MXPacs00900108Constant.R15_ERROR_TEXT, endToEndId);
                                } else if (substring.contains("//")) {
                                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R15_ERROR_CODE, MXPacs00900108Constant.R15_ERROR_TEXT, endToEndId);
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If pacs.009CORE is used to cover pacs.009ADV, the E2E identification should transport the instruction identification of
     * the underlying pacs.009 ADV.
     * todo
     *
     * @return 返回R16检查结果
     */
    public Constraints checkR16() {

        return null;
    }

    /**
     * If the pacs.009 is used to settle a pacs.009 Advice, the UETR should transport the UETR of the underlying pacs.009 Advice.
     * /Document/FICdtTrf/CdtTrfTxInf/PmtId/UETR
     * todo
     *
     * @return 返回R17检查结果
     */
    public Constraints checkR17() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        PaymentIdentification13 pmtId = creditTransferTransaction56.getPmtId();
                        if (JudgeUtils.isNotNull(pmtId)) {
                            String uetr = pmtId.getUETR();
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * The preferred option is coded information.
     * /Document/FICdtTrf/GrpHdr/PmtTpInf/LclInstrm
     * todo
     *
     * @return 返回R18检查结果
     */
    public Constraints checkR18() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    PaymentTypeInformation28 pmtTpInf = grpHdr.getPmtTpInf();
                    if (JudgeUtils.isNotNull(pmtTpInf)) {
                        LocalInstrument2Choice lclInstrm = pmtTpInf.getLclInstrm();

                    }
                }
            }
        }
        return null;
    }

    /**
     * The preferred option is coded information.
     * /Document/FICdtTrf/GrpHdr/PmtTpInf/CtgyPurp
     * todo
     *
     * @return 返回R19检查结果
     */
    public Constraints checkR19() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    PaymentTypeInformation28 pmtTpInf = grpHdr.getPmtTpInf();
                    if (JudgeUtils.isNotNull(pmtTpInf)) {
                        CategoryPurpose1Choice ctgyPurp = pmtTpInf.getCtgyPurp();

                    }
                }
            }
        }
        return null;
    }

    /**
     * The codes XAU, XAG, XPD and XPT are not allowed, as these are codes are only used for commodities.
     * /Document/FICdtTrf/GrpHdr/TtlIntrBkSttlmAmt
     *
     * @return 返回R20检查结果
     */
    public Constraints checkR20() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader96 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    ActiveCurrencyAndAmount ttlIntrBkSttlmAmt = grpHdr.getTtlIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(ttlIntrBkSttlmAmt)) {
                        String ccy = ttlIntrBkSttlmAmt.getCcy();
                        if (JudgeUtils.isNotNull(ccy)) {
                            if ("XAU".equals(ccy) || "XAG".equals(ccy) || "XPD".equals(ccy) || "XPT".equals(ccy)) {
                                return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R20_ERROR_CODE, MXPacs00900108Constant.R20_ERROR_TEXT, ccy);
                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Whenever Debtor Agent, Creditor Agent and all agents in between are located within the same country, the clearing code only may be used.
     * PrvsInstgAgt1    /Document/FICdtTrf/CdtTrfTxInf/PrvsInstgAgt1
     * PrvsInstgAgt2
     * PrvsInstgAgt3
     * IntrmyAgt1   /Document/FICdtTrf/CdtTrfTxInf/IntrmyAgt1
     * IntrmyAgt2
     * IntrmyAgt3
     * Dbtr /Document/FICdtTrf/CdtTrfTxInf/Dbtr
     * DbtrAgt  /Document/FICdtTrf/CdtTrfTxInf/DbtrAgt
     * CdtrAgt
     * Cdtr
     * todo
     *
     * @return 返回R21检查结果
     */
    public Constraints checkR21() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        HashSet<String> ctrySet = new HashSet<>();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                        BranchAndFinancialInstitutionIdentification6 cdtr = creditTransferTransaction56.getCdtr();
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                        BranchAndFinancialInstitutionIdentification6 dbtr = creditTransferTransaction56.getDbtr();
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            FinancialInstitutionIdentification18 finInstnId = cdtr.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtr)) {
                            FinancialInstitutionIdentification18 finInstnId = dbtr.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(cdtrAgt)) {
                            FinancialInstitutionIdentification18 finInstnId = cdtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(dbtrAgt)) {
                            FinancialInstitutionIdentification18 finInstnId = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt1)) {
                            FinancialInstitutionIdentification18 finInstnId = prvsInstgAgt1.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt2)) {
                            FinancialInstitutionIdentification18 finInstnId = prvsInstgAgt2.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(prvsInstgAgt3)) {
                            FinancialInstitutionIdentification18 finInstnId = prvsInstgAgt3.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt1)) {
                            FinancialInstitutionIdentification18 finInstnId = intrmyAgt1.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt2)) {
                            FinancialInstitutionIdentification18 finInstnId = intrmyAgt2.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (JudgeUtils.isNotNull(intrmyAgt3)) {
                            FinancialInstitutionIdentification18 finInstnId = intrmyAgt3.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    String ctry = pstlAdr.getCtry();
                                    ctrySet.add(ctry);
                                }
                            }
                        }
                        if (ctrySet.size() > 1) {

                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * BICFI, complemented optionally with a LEI (preferred option)
     * todo
     *
     * @return 返回R22检查结果
     */
    public Constraints checkR22() {

        return null;
    }

    /**
     * (Clearing Code OR LEI)  AND (Name AND (Unstructured postal address OR [Structured postal address with minimum Town Name and Country]).
     * It is recommended to also add the post code when available.
     * todo
     *
     * @return 返回R23检查结果
     */
    public Constraints checkR23() {

        return null;
    }

    /**
     * Name AND (Unstructured OR [Structured postal address with minimum Town Name and Country]).
     * It is recommended to also add the post code when available.
     * todo
     *
     * @return 返回R24检查结果
     */
    public Constraints checkR24() {

        return null;
    }

    /**
     * Address Line (Unstructured Address) remains available only for cases when the payment is initiated in FIN, or by an MI, during coexistence only. The Structured PostalAddress remains the prefered option.
     * <p>
     * Therefore:
     * <p>
     * - If a payment is initiated on FIN, or by an MI, and the postal address is unstructured, the outgoing ISO 20022 message will transport unstructured postal address, up to the Creditor Agent.
     * <p>
     * - If a payment is initiated in ISO 20022, postal address must be structured.
     * todo
     *
     * @return 返回R25检查结果
     */
    public Constraints checkR25() {

        return null;
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R26检查结果
     */
    public Constraints checkR26() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR26(prvsInstgAgt1).getErrorCode())) {
                            return ruleR26(prvsInstgAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR26(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R26_ERROR_CODE, MXPacs00900108Constant.R26_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R26_ERROR_CODE, MXPacs00900108Constant.R26_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R27检查结果
     */
    public Constraints checkR27() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR27(prvsInstgAgt1).getErrorCode())) {
                            return ruleR27(prvsInstgAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR27(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R27_ERROR_CODE, MXPacs00900108Constant.R27_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R28检查结果
     */
    public Constraints checkR28() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt1 = creditTransferTransaction56.getPrvsInstgAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR28(prvsInstgAgt1).getErrorCode())) {
                            return ruleR28(prvsInstgAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR28(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R28_ERROR_CODE, MXPacs00900108Constant.R28_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R29检查结果
     */
    public Constraints checkR29() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR29(prvsInstgAgt2).getErrorCode())) {
                            return ruleR29(prvsInstgAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }


    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR29(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R29_ERROR_CODE, MXPacs00900108Constant.R29_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R29_ERROR_CODE, MXPacs00900108Constant.R29_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R30检查结果
     */
    public Constraints checkR30() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR30(prvsInstgAgt2).getErrorCode())) {
                            return ruleR30(prvsInstgAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR30(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R30_ERROR_CODE, MXPacs00900108Constant.R30_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R31检查结果
     */
    public Constraints checkR31() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt2 = creditTransferTransaction56.getPrvsInstgAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR31(prvsInstgAgt2).getErrorCode())) {
                            return ruleR31(prvsInstgAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR31(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R31_ERROR_CODE, MXPacs00900108Constant.R31_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R32检查结果
     */
    public Constraints checkR32() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR32(prvsInstgAgt3).getErrorCode())) {
                            return ruleR32(prvsInstgAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR32(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R32_ERROR_CODE, MXPacs00900108Constant.R32_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R32_ERROR_CODE, MXPacs00900108Constant.R32_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R33检查结果
     */
    public Constraints checkR33() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR33(prvsInstgAgt3).getErrorCode())) {
                            return ruleR33(prvsInstgAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR33(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R33_ERROR_CODE, MXPacs00900108Constant.R33_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R34检查结果
     */
    public Constraints checkR34() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 prvsInstgAgt3 = creditTransferTransaction56.getPrvsInstgAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR34(prvsInstgAgt3).getErrorCode())) {
                            return ruleR34(prvsInstgAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR34(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine) && (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm))) {
                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R34_ERROR_CODE, MXPacs00900108Constant.R34_ERROR_TEXT);
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R35检查结果
     */
    public Constraints checkR35() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR35(intrmyAgt1).getErrorCode())) {
                            return ruleR35(intrmyAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR35(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R35_ERROR_CODE, MXPacs00900108Constant.R35_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R35_ERROR_CODE, MXPacs00900108Constant.R35_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R36检查结果
     */
    public Constraints checkR36() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR36(intrmyAgt1).getErrorCode())) {
                            return ruleR36(intrmyAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR36(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R36_ERROR_CODE, MXPacs00900108Constant.R36_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R37检查结果
     */
    public Constraints checkR37() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt1 = creditTransferTransaction56.getIntrmyAgt1();
                        if (JudgeUtils.isNotSuccess(ruleR37(intrmyAgt1).getErrorCode())) {
                            return ruleR37(intrmyAgt1);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR37(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R37_ERROR_CODE, MXPacs00900108Constant.R37_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R38检查结果
     */
    public Constraints checkR38() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR38(intrmyAgt2).getErrorCode())) {
                            return ruleR38(intrmyAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR38(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R38_ERROR_CODE, MXPacs00900108Constant.R38_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R38_ERROR_CODE, MXPacs00900108Constant.R38_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R39检查结果
     */
    public Constraints checkR39() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR39(intrmyAgt2).getErrorCode())) {
                            return ruleR39(intrmyAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR39(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R39_ERROR_CODE, MXPacs00900108Constant.R39_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R40检查结果
     */
    public Constraints checkR40() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt2 = creditTransferTransaction56.getIntrmyAgt2();
                        if (JudgeUtils.isNotSuccess(ruleR40(intrmyAgt2).getErrorCode())) {
                            return ruleR40(intrmyAgt2);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR40(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R40_ERROR_CODE, MXPacs00900108Constant.R40_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * Name and Address must always be present together.
     *
     * @return 返回R41检查结果
     */
    public Constraints checkR41() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR41(intrmyAgt3).getErrorCode())) {
                            return ruleR41(intrmyAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR41(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R41_ERROR_CODE, MXPacs00900108Constant.R41_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R41_ERROR_CODE, MXPacs00900108Constant.R41_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R42检查结果
     */
    public Constraints checkR42() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR42(intrmyAgt3).getErrorCode())) {
                            return ruleR42(intrmyAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR42(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R42_ERROR_CODE, MXPacs00900108Constant.R42_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R43检查结果
     */
    public Constraints checkR43() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 intrmyAgt3 = creditTransferTransaction56.getIntrmyAgt3();
                        if (JudgeUtils.isNotSuccess(ruleR43(intrmyAgt3).getErrorCode())) {
                            return ruleR43(intrmyAgt3);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR43(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R43_ERROR_CODE, MXPacs00900108Constant.R43_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Address Line (Unstructured Address) remains available only for cases when the payment is initiated in FIN, or by an MI, during coexistence only. The Structured PostalAddress remains the prefered option.
     * <p>
     * Therefore:
     * <p>
     * - If a payment is initiated on FIN, or by an MI, and the postal address is unstructured, the outgoing ISO 20022 message will transport unstructured postal address, up to the Creditor Agent.
     * <p>
     * - If a payment is initiated in ISO 20022, postal address must be structured.
     * todo
     *
     * @return 返回R44检查结果
     */
    public Constraints checkR44() {

        return null;
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R45检查结果
     */
    public Constraints checkR45() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtr = creditTransferTransaction56.getDbtr();
                        if (JudgeUtils.isNotSuccess(ruleR45(dbtr).getErrorCode())) {
                            return ruleR45(dbtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR45(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R45_ERROR_CODE, MXPacs00900108Constant.R45_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R45_ERROR_CODE, MXPacs00900108Constant.R45_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R46检查结果
     */
    public Constraints checkR46() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtr = creditTransferTransaction56.getDbtr();
                        if (JudgeUtils.isNotSuccess(ruleR46(dbtr).getErrorCode())) {
                            return ruleR46(dbtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR46(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R46_ERROR_CODE, MXPacs00900108Constant.R46_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R47检查结果
     */
    public Constraints checkR47() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtr = creditTransferTransaction56.getDbtr();
                        if (JudgeUtils.isNotSuccess(ruleR47(dbtr).getErrorCode())) {
                            return ruleR47(dbtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR47(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R47_ERROR_CODE, MXPacs00900108Constant.R47_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name AND (Unstructured OR [Structured postal address with minimum Town Name and Country]). It is recommended to also add the post code when available.
     * todo
     *
     * @return 返回R48检查结果
     */
    public Constraints checkR48() {

        return null;
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R49检查结果
     */
    public Constraints checkR49() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR49(dbtrAgt).getErrorCode())) {
                            return ruleR49(dbtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR49(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R49_ERROR_CODE, MXPacs00900108Constant.R49_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R49_ERROR_CODE, MXPacs00900108Constant.R49_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R检查结果50
     */
    public Constraints checkR50() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR50(dbtrAgt).getErrorCode())) {
                            return ruleR50(dbtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR50(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R50_ERROR_CODE, MXPacs00900108Constant.R50_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R51检查结果
     */
    public Constraints checkR51() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction56.getDbtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR51(dbtrAgt).getErrorCode())) {
                            return ruleR51(dbtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR51(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R51_ERROR_CODE, MXPacs00900108Constant.R51_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * Name and Address must always be present together.
     *
     * @return 返回R52检查结果
     */
    public Constraints checkR52() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR52(cdtrAgt).getErrorCode())) {
                            return ruleR52(cdtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR52(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R52_ERROR_CODE, MXPacs00900108Constant.R52_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R52_ERROR_CODE, MXPacs00900108Constant.R52_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R53检查结果
     */
    public Constraints checkR53() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR53(cdtrAgt).getErrorCode())) {
                            return ruleR53(cdtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR53(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R53_ERROR_CODE, MXPacs00900108Constant.R53_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R54检查结果
     */
    public Constraints checkR54() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction56.getCdtrAgt();
                        if (JudgeUtils.isNotSuccess(ruleR54(cdtrAgt).getErrorCode())) {
                            return ruleR54(cdtrAgt);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR54(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R54_ERROR_CODE, MXPacs00900108Constant.R54_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * Name and Address must always be present together.
     *
     * @return 返回R55检查结果
     */
    public Constraints checkR55() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtr = creditTransferTransaction56.getCdtr();
                        if (JudgeUtils.isNotSuccess(ruleR55(cdtr).getErrorCode())) {
                            return ruleR55(cdtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return Name and Address must always be present together.
     */
    private Constraints ruleR55(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(nm) && JudgeUtils.isNull(pstlAdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R55_ERROR_CODE, MXPacs00900108Constant.R55_ERROR_TEXT);
                } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R55_ERROR_CODE, MXPacs00900108Constant.R55_ERROR_TEXT);
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R56检查结果
     */
    public Constraints checkR56() {
        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtr = creditTransferTransaction56.getCdtr();
                        if (JudgeUtils.isNotSuccess(ruleR56(cdtr).getErrorCode())) {
                            return ruleR56(cdtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     */
    private Constraints ruleR56(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    AddressType3Choice adrTp = pstlAdr.getAdrTp();
                    String bldgNb = pstlAdr.getBldgNb();
                    String bldgNm = pstlAdr.getBldgNm();
                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                    String dept = pstlAdr.getDept();
                    String dstrctNm = pstlAdr.getDstrctNm();
                    String flr = pstlAdr.getFlr();
                    String pstBx = pstlAdr.getPstBx();
                    String pstCd = pstlAdr.getPstCd();
                    String room = pstlAdr.getRoom();
                    String subDept = pstlAdr.getSubDept();
                    String strtNm = pstlAdr.getStrtNm();
                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNotNull(adrLine)) {
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(bldgNb)
                                || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn) || JudgeUtils.isNotNull(dept)
                                || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr) || JudgeUtils.isNotNull(pstBx)
                                || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room) || JudgeUtils.isNotNull(subDept)
                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(twnLctnNm) || JudgeUtils.isNotNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R56_ERROR_CODE, MXPacs00900108Constant.R56_ERROR_TEXT);
                        }
                    }
                }
            }
        }

        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     *
     * @return 返回R57检查结果
     */
    public Constraints checkR57() {

        Pacs00900110 pacs00900110 = this.getPacs00900110();
        if (JudgeUtils.isNotNull(pacs00900110)) {
            FinancialInstitutionCreditTransferV10 fiCdtTrf = pacs00900110.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                List<CreditTransferTransaction56> cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction56 creditTransferTransaction56 : cdtTrfTxInf) {
                        BranchAndFinancialInstitutionIdentification6 cdtr = creditTransferTransaction56.getCdtr();
                        if (JudgeUtils.isNotSuccess(ruleR57(cdtr).getErrorCode())) {
                            return ruleR57(cdtr);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * @param branchAndFinancialInstitutionIdentification6 参数拆解
     * @return If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     */
    private Constraints ruleR57(BranchAndFinancialInstitutionIdentification6 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification18 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
                    String twnNm = pstlAdr.getTwnNm();
                    if (JudgeUtils.isNull(adrLine)) {
                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                            return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R57_ERROR_CODE, MXPacs00900108Constant.R57_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return new Constraints(MXPacs00900108Constant.SUCCESS_CODE);
    }


    /**
     * If the pacs.009 is used to settle a pacs.009 Advice, the last available occurrence (of the element Instruction For
     * Creditor Agent/Instruction Information) preceded by /UDLC/ must be used to capture the /UDLC/ (Underlying Creditor)
     * provided in the pacs.009 Advice.
     * todo
     *
     * @return 返回R58检查结果
     */
    public Constraints checkR58() {

        return null;
    }

    /**
     * The preferred option is coded information.
     * todo
     *
     * @return 返回R59检查结果
     */
    public Constraints checkR59() {

        return null;
    }

    public String checkR() {

        return "未更改调用";
    }
}
