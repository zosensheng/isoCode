package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.MXPacs00900108Constant;
import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.dic.InstructionForCreditorAgent3;
import com.hisun.kont.mx.msg.pacs.pacs00900108.*;
import org.springframework.beans.BeanUtils;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * <p>Document053 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document053">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{}FIToFICustomerCreditTransferV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class MXPacs00900108 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08";
    public final static transient Class[] _classes = new Class[]{Pacs00900108.class};

    public Pacs00900108 pacs00900108;

    public Pacs00900108 getPacs00900108() {
        return pacs00900108;
    }

    public void setPacs00900108(Pacs00900108 pacs00900108) {
        this.pacs00900108 = pacs00900108;
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
        return this.pacs00900108;
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String prty = businessApplicationHeaderV02.getPrty();
            if (JudgeUtils.isNotNull(prty)) {
                if (JudgeUtils.isNotNull(Pacs00900108)) {
                    FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                        CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                            PaymentTypeInformation281 pmtTpInf = cdtTrfTxInf.getPmtTpInf();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
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
                                if (JudgeUtils.isNotNull(Pacs00900108)) {
                                    FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                        boolean result = false;
                                        CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();

                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            BranchAndFinancialInstitutionIdentification62 instgAgt = cdtTrfTxInf.getInstgAgt();
                                            if (JudgeUtils.isNotNull(instgAgt)) {
                                                FinancialInstitutionIdentification182 finInstnId1 = instgAgt.getFinInstnId();
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
                            if (JudgeUtils.isNotNull(Pacs00900108)) {
                                FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    boolean result = false;
                                    CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();

                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        BranchAndFinancialInstitutionIdentification62 instdAgt = cdtTrfTxInf.getInstdAgt();
                                        if (JudgeUtils.isNotNull(instdAgt)) {
                                            FinancialInstitutionIdentification182 finInstnId1 = instdAgt.getFinInstnId();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
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
                            if (JudgeUtils.isNotNull(Pacs00900108)) {
                                FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        BranchAndFinancialInstitutionIdentification62 instgAgt = cdtTrfTxInf.getInstgAgt();
                                        if (JudgeUtils.isNotNull(instgAgt)) {
                                            FinancialInstitutionIdentification182 finInstnId1 = instgAgt.getFinInstnId();
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
                if (JudgeUtils.isNotNull(to)) {
                    com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6 fiId = to.getFIId();
                    if (JudgeUtils.isNotNull(fiId)) {
                        com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            String toBicfi = finInstnId.getBICFI();
                            if (JudgeUtils.isNotNull(Pacs00900108)) {
                                FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        BranchAndFinancialInstitutionIdentification62 instdAgt = cdtTrfTxInf.getInstdAgt();
                                        if (JudgeUtils.isNotNull(instdAgt)) {
                                            FinancialInstitutionIdentification182 finInstnId1 = instdAgt.getFinInstnId();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizMsgIdr = businessApplicationHeaderV02.getBizMsgIdr();
            if (JudgeUtils.isNotNull(Pacs00900108)) {
                FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                    GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
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
                if (MXPacs00900108Constant.PACS_009_001_08.equals(msgDefIdr)) {
                    return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R6_ERROR_CODE, MXPacs00900108Constant.R6_ERROR_TEXT, msgDefIdr);
                }
            }
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd) {
                    String msgDefIdr1 = businessApplicationHeader5.getMsgDefIdr();
                    if (JudgeUtils.isNotNull(msgDefIdr1)) {
                        if (MXPacs00900108Constant.PACS_009_001_08.equals(msgDefIdr1)) {
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
     * The value "swift.cbprplus.stp.02" must be used.
     *
     * @return 返回R8检查结果
     */
    public Constraints checkR8() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            if (JudgeUtils.isNotNull(bizSvc)) {
                if (!MXPacs00900108Constant.BIZSVC_COV.equals(bizSvc)){
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    List<InstructionForCreditorAgent21> instrForCdtrAgt = cdtTrfTxInf.getInstrForCdtrAgt();
                    if (JudgeUtils.isNotNull(instrForCdtrAgt)) {
                        int sum = 0;
                        for (InstructionForCreditorAgent21 instructionForCreditorAgent3 : instrForCdtrAgt) {
                            Instruction5Code cd = instructionForCreditorAgent3.getCd();
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
        return null;
    }

    /**
     * This field must not start or end with a slash '/' and must not contain two consecutive slashes '//'.
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/PmtId/InstrId
     *
     * @return 返回R13检查结果
     */
    public Constraints checkR13() {
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
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
        return null;
    }

    /**
     * In the pacs.009 CORE, the E2E identification is provided by the Debtor (Agent).
     * todo
     *
     * @return 返回R14检查结果
     */
    public Constraints checkR14() {
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
                    if (JudgeUtils.isNotNull(pmtId)) {
                        String endToEndId = pmtId.getEndToEndId();

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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    PaymentIdentification71 pmtId = cdtTrfTxInf.getPmtId();
                    if (JudgeUtils.isNotNull(pmtId)) {
                        String uetr = pmtId.getUETR();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                }
            }
        }
        return null;
    }

    /**
     * The codes XAU, XAG, XPD and XPT are not allowed, as these are codes are only used for commodities.
     *
     * @return 返回R20检查结果
     */
    public Constraints checkR20() {
        Pacs00900108 pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    CBPRAmount ttlIntrBkSttlmAmt = cdtTrfTxInf.getIntrBkSttlmAmt();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    HashSet<String> ctrySet = new HashSet<>();
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                    BranchAndFinancialInstitutionIdentification61 cdtr = cdtTrfTxInf.getCdtr();
                    BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                    BranchAndFinancialInstitutionIdentification61 dbtr = cdtTrfTxInf.getDbtr();
                    BranchAndFinancialInstitutionIdentification61 dbtrAgt = cdtTrfTxInf.getDbtrAgt();
                    if (JudgeUtils.isNotNull(cdtr)) {
                        FinancialInstitutionIdentification181 finInstnId = cdtr.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtr)) {
                        FinancialInstitutionIdentification181 finInstnId = dbtr.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(cdtrAgt)) {
                        FinancialInstitutionIdentification181 finInstnId = cdtrAgt.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(dbtrAgt)) {
                        FinancialInstitutionIdentification181 finInstnId = dbtrAgt.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt1)) {
                        FinancialInstitutionIdentification181 finInstnId = prvsInstgAgt1.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt2)) {
                        FinancialInstitutionIdentification181 finInstnId = prvsInstgAgt2.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(prvsInstgAgt3)) {
                        FinancialInstitutionIdentification181 finInstnId = prvsInstgAgt3.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt1)) {
                        FinancialInstitutionIdentification181 finInstnId = intrmyAgt1.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt2)) {
                        FinancialInstitutionIdentification181 finInstnId = intrmyAgt2.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                ctrySet.add(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(intrmyAgt3)) {
                        FinancialInstitutionIdentification181 finInstnId = intrmyAgt3.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR26(prvsInstgAgt1).getErrorCode())) {
                        return ruleR26(prvsInstgAgt1);
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
    private Constraints ruleR26(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR27(prvsInstgAgt1).getErrorCode())) {
                        return ruleR27(prvsInstgAgt1);
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
    private Constraints ruleR27(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt1 = cdtTrfTxInf.getPrvsInstgAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR28(prvsInstgAgt1).getErrorCode())) {
                        return ruleR28(prvsInstgAgt1);
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
    private Constraints ruleR28(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR29(prvsInstgAgt2).getErrorCode())) {
                        return ruleR29(prvsInstgAgt2);
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
    private Constraints ruleR29(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR30(prvsInstgAgt2).getErrorCode())) {
                        return ruleR30(prvsInstgAgt2);
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
    private Constraints ruleR30(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt2 = cdtTrfTxInf.getPrvsInstgAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR31(prvsInstgAgt2).getErrorCode())) {
                        return ruleR31(prvsInstgAgt2);
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
    private Constraints ruleR31(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR32(prvsInstgAgt3).getErrorCode())) {
                        return ruleR32(prvsInstgAgt3);
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
    private Constraints ruleR32(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR33(prvsInstgAgt3).getErrorCode())) {
                        return ruleR33(prvsInstgAgt3);
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
    private Constraints ruleR33(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 prvsInstgAgt3 = cdtTrfTxInf.getPrvsInstgAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR34(prvsInstgAgt3).getErrorCode())) {
                        return ruleR34(prvsInstgAgt3);
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
    private Constraints ruleR34(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR35(intrmyAgt1).getErrorCode())) {
                        return ruleR35(intrmyAgt1);
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
    private Constraints ruleR35(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR36(intrmyAgt1).getErrorCode())) {
                        return ruleR36(intrmyAgt1);
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
    private Constraints ruleR36(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt1 = cdtTrfTxInf.getIntrmyAgt1();
                    if (JudgeUtils.isNotSuccess(ruleR37(intrmyAgt1).getErrorCode())) {
                        return ruleR37(intrmyAgt1);
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
    private Constraints ruleR37(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR38(intrmyAgt2).getErrorCode())) {
                        return ruleR38(intrmyAgt2);
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
    private Constraints ruleR38(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR39(intrmyAgt2).getErrorCode())) {
                        return ruleR39(intrmyAgt2);
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
    private Constraints ruleR39(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt2 = cdtTrfTxInf.getIntrmyAgt2();
                    if (JudgeUtils.isNotSuccess(ruleR40(intrmyAgt2).getErrorCode())) {
                        return ruleR40(intrmyAgt2);
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
    private Constraints ruleR40(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {

                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR41(intrmyAgt3).getErrorCode())) {
                        return ruleR41(intrmyAgt3);
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
    private Constraints ruleR41(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNull(pstlAdr)) {
                    if (JudgeUtils.isNotNull(nm)) {
                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R41_ERROR_CODE, MXPacs00900108Constant.R41_ERROR_TEXT);
                    } else if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                        return new Constraints(MXPacs00900108Constant.ERROR_SEVERITY, MXPacs00900108Constant.R41_ERROR_CODE, MXPacs00900108Constant.R41_ERROR_TEXT);
                    }
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR42(intrmyAgt3).getErrorCode())) {
                        return ruleR42(intrmyAgt3);
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
    private Constraints ruleR42(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 intrmyAgt3 = cdtTrfTxInf.getIntrmyAgt3();
                    if (JudgeUtils.isNotSuccess(ruleR43(intrmyAgt3).getErrorCode())) {
                        return ruleR43(intrmyAgt3);
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
    private Constraints ruleR43(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtr = cdtTrfTxInf.getDbtr();
                    if (JudgeUtils.isNotSuccess(ruleR45(dbtr).getErrorCode())) {
                        return ruleR45(dbtr);
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
    private Constraints ruleR45(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {

                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtr = cdtTrfTxInf.getDbtr();
                    if (JudgeUtils.isNotSuccess(ruleR46(dbtr).getErrorCode())) {
                        return ruleR46(dbtr);
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
    private Constraints ruleR46(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtr = cdtTrfTxInf.getDbtr();
                    if (JudgeUtils.isNotSuccess(ruleR47(dbtr).getErrorCode())) {
                        return ruleR47(dbtr);
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
    private Constraints ruleR47(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtrAgt = cdtTrfTxInf.getDbtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR49(dbtrAgt).getErrorCode())) {
                        return ruleR49(dbtrAgt);
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
    private Constraints ruleR49(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtrAgt = cdtTrfTxInf.getDbtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR50(dbtrAgt).getErrorCode())) {
                        return ruleR50(dbtrAgt);
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
    private Constraints ruleR50(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 dbtrAgt = cdtTrfTxInf.getDbtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR51(dbtrAgt).getErrorCode())) {
                        return ruleR51(dbtrAgt);
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
    private Constraints ruleR51(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR52(cdtrAgt).getErrorCode())) {
                        return ruleR52(cdtrAgt);
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
    private Constraints ruleR52(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR53(cdtrAgt).getErrorCode())) {
                        return ruleR53(cdtrAgt);
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
    private Constraints ruleR53(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtrAgt = cdtTrfTxInf.getCdtrAgt();
                    if (JudgeUtils.isNotSuccess(ruleR54(cdtrAgt).getErrorCode())) {
                        return ruleR54(cdtrAgt);
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
    private Constraints ruleR54(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtr = cdtTrfTxInf.getCdtr();
                    if (JudgeUtils.isNotSuccess(ruleR55(cdtr).getErrorCode())) {
                        return ruleR55(cdtr);
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
    private Constraints ruleR55(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                String nm = finInstnId.getNm();
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {

                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtr = cdtTrfTxInf.getCdtr();
                    if (JudgeUtils.isNotSuccess(ruleR56(cdtr).getErrorCode())) {
                        return ruleR56(cdtr);
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
    private Constraints ruleR56(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                if (JudgeUtils.isNotNull(pstlAdr)) {
                    List<String> adrLine = pstlAdr.getAdrLine();
                    String ctry = pstlAdr.getCtry();
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
                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb)
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

        Pacs00900108 Pacs00900108 = this.getPacs00900108();
        if (JudgeUtils.isNotNull(Pacs00900108)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = Pacs00900108.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    BranchAndFinancialInstitutionIdentification61 cdtr = cdtTrfTxInf.getCdtr();
                    if (JudgeUtils.isNotSuccess(ruleR57(cdtr).getErrorCode())) {
                        return ruleR57(cdtr);
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
    private Constraints ruleR57(BranchAndFinancialInstitutionIdentification61 branchAndFinancialInstitutionIdentification6) {
        if (JudgeUtils.isNotNull(branchAndFinancialInstitutionIdentification6)) {
            FinancialInstitutionIdentification181 finInstnId = branchAndFinancialInstitutionIdentification6.getFinInstnId();
            if (JudgeUtils.isNotNull(finInstnId)) {
                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
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
