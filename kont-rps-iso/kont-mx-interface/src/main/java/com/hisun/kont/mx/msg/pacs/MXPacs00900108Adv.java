package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.MXPacs00900108AdvConstant;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.pacs00900108adv.*;

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
public class MXPacs00900108Adv extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08";
    public final static transient Class[] _classes = new Class[]{Pacs00900108Adv.class};

    public Pacs00900108Adv pacs00900108Adv;

    public Pacs00900108Adv getPacs00900108Adv() {
        return pacs00900108Adv;
    }

    public void setPacs00900108Adv(Pacs00900108Adv pacs00900108Adv) {
        this.pacs00900108Adv = pacs00900108Adv;
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
        return this.pacs00900108Adv;
    }

    /**
     * If "Priority” is used in the BAH for pacs messages,
     * the value should be identical to the one in the “Payment Type Information/InstructionPriority” if present.
     *
     * @return 返回R1检查结果
     */
    public Constraints checkR1() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String prty = businessApplicationHeaderV02.getPrty();
            if (JudgeUtils.isNotNull(prty)) {
                if (JudgeUtils.isNotNull(pacs00900108Adv)) {
                    FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                        CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                            PaymentTypeInformation281 pmtTpInf = cdtTrfTxInf.getPmtTpInf();
                            if (JudgeUtils.isNotNull(pmtTpInf)) {
                                Priority2Code instrPrty = pmtTpInf.getInstrPrty();
                                if (JudgeUtils.isNotNull(instrPrty)) {
                                    String value = instrPrty.value();
                                    if (!prty.equals(value)) {
                                        return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY,MXPacs00900108AdvConstant.R1_ERROR_CODE,MXPacs00900108AdvConstant.R1_ERROR_TEXT);
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
     * "BAH ""From"" BIC must match ""Instructing Agent"" BIC, except where BAH CopyDuplicate = COPY or = CODU
     *
     * BAH ""To"" BIC must match ""Instructed Agent"" BIC, except where BAH CopyDuplicate = COPY or = CODU"
     *
     * @return  返回R2检查结果
     */
    public Constraints checkR2() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            if (JudgeUtils.isNotNull(cpyDplct)) {
                String value = cpyDplct.value();
                if (!"COPY".equals(value) && !"CODU".equals(value)) {
                    if (JudgeUtils.isNotNull(fr)) {
                        BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                        if (JudgeUtils.isNotNull(fiId)) {
                            FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String frBicfi = finInstnId.getBICFI();
                                if (JudgeUtils.isNotNull(pacs00900108Adv)) {
                                    FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
                                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                                        CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            BranchAndFinancialInstitutionIdentification62 instdAgt = cdtTrfTxInf.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                FinancialInstitutionIdentification182 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!frBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R2_ERROR_CODE, MXPacs00900108AdvConstant.R2_ERROR_TEXT);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(to)) {
                        BranchAndFinancialInstitutionIdentification6 fiId = to.getFIId();
                        if (JudgeUtils.isNotNull(fiId)) {
                            FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String toBicfi = finInstnId.getBICFI();
                                if (JudgeUtils.isNotNull(pacs00900108Adv)) {
                                    FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
                                    if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                                        CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            BranchAndFinancialInstitutionIdentification62 instdAgt = cdtTrfTxInf.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                FinancialInstitutionIdentification182 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!toBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R2_ERROR_CODE, MXPacs00900108AdvConstant.R2_ERROR_TEXT);
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
     *  "BAH ""From"" BIC must match ""Instructing Agent"" BIC if CopyDuplicate is absent.
     *  BAH ""To"" BIC must match ""Instructed Agent"" BIC  if CopyDuplicate is absent."
     *
     * @return  返回R3检查结果
     */
    public Constraints checkR3() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            if (JudgeUtils.isNull(cpyDplct)) {
                if (JudgeUtils.isNotNull(fr)) {
                    BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                    if (JudgeUtils.isNotNull(fiId)) {
                        FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            String frBicfi = finInstnId.getBICFI();
                            if (JudgeUtils.isNotNull(pacs00900108Adv)) {
                                FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                                    CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        BranchAndFinancialInstitutionIdentification62 instgAgt = cdtTrfTxInf.getInstgAgt();
                                        if (JudgeUtils.isNotNull(instgAgt)) {
                                            FinancialInstitutionIdentification182 finInstnId1 = instgAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!frBicfi.equals(bicfi)) {
                                                    result = true;
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R3_ERROR_CODE, MXPacs00900108AdvConstant.R3_ERROR_TEXT);
                                    }
                                }
                            }
                        }
                    }
                }
                if (JudgeUtils.isNotNull(to)) {
                    BranchAndFinancialInstitutionIdentification6 fiId = to.getFIId();
                    if (JudgeUtils.isNotNull(fiId)) {
                        FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                        if (JudgeUtils.isNotNull(finInstnId)) {
                            String toBicfi = finInstnId.getBICFI();
                            if (JudgeUtils.isNotNull(pacs00900108Adv)) {
                                FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
                                if (JudgeUtils.isNotNull(fiCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                                    CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        BranchAndFinancialInstitutionIdentification62 instdAgt = cdtTrfTxInf.getInstdAgt();
                                        if (JudgeUtils.isNotNull(instdAgt)) {
                                            FinancialInstitutionIdentification182 finInstnId1 = instdAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!toBicfi.equals(bicfi)) {
                                                    result = true;
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R3_ERROR_CODE, MXPacs00900108AdvConstant.R3_ERROR_TEXT);
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
     *  For further description on the usage of the field, pls refer to the CBPR Plus UHB.
     *
     * todo
     * @return  返回R4检查结果
     */
    public Constraints checkR4() {

        return null;
    }

    /**
     *  "The Business Message Identifier is the unique identifier of the Business Message instance that is being transported with this header, as defined by the sending application or system.
     *
     * Must contain the Message Identification element from the Group Header of the underlying message, where available (as is typically the case with pacs, pain, and camt messages, for example). If Message Identification is not available in the underlying message, then this field must contain the unique identifier of the Business Message instance.
     *
     * "
     * todo
     * @return  返回R5检查结果
     */
    public Constraints checkR5() {

        return null;
    }

    /**
     *  The Message Definition Identifier of the Business Message instance that is being transported with this header. In general,
     *  it must be formatted exactly as it appears in the namespace of the Business Message instance.
     * todo
     * @return  返回R6检查结果
     */
    public Constraints checkR6() {

        return null;
    }

    /**
     *  "This field may be used by SWIFT to support differentiated processing on SWIFT-administered services such as FINplus. For a description of reserved values, please refer to the Service Description for your service.
     *
     * To support differentiated processing on CBPRPlus, for example, SWIFT reserves a set of values that conform to a specific format.
     * todo
     * A user-specific value may be used, but please contact your Service Administrator before doing so to ensure alignment with general practice on your service.
     * "
     *
     * @return  返回R7检查结果
     */
    public Constraints checkR7() {

        return null;
    }

    /**
     *  The value "swift.cbprplus.adv.02" must be used.
     *
     * @return  返回R8检查结果
     */
    public Constraints checkR8() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            if (JudgeUtils.isNotNull(bizSvc)) {
                if (!"swift.cbprplus.adv.02".equals(bizSvc)) {
                    return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R8_ERROR_CODE, MXPacs00900108AdvConstant.R8_ERROR_TEXT);
                }
            } else{
                return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R8_ERROR_CODE, MXPacs00900108AdvConstant.R8_ERROR_TEXT);
            }
        }
        return null;
    }

    /**
     *  "This field may be used by SWIFT on SWIFT-administered services. For a description of reserved values, please refer to the Service Description for your service. Contact your Service Administrator for further clarification, if necessary.
     *
     * A user-specific value may be used, but please contact your Service Administrator before doing so to ensure alignment with general practice on your service.
     * "
     * todo
     * @return  返回9检查结果
     */
    public Constraints checkR9() {

        return null;
    }

    /**
     *  If used, the Related BAH must transport the exact same information as in the BAH of the related message.
     * todo
     * @return  返回R10检查结果
     */
    public Constraints checkR10() {

        return null;
    }

    /**
     *  "This field may be used by SWIFT to support differentiated processing on SWIFT-administered services such as FINplus. For a description of reserved values, please refer to the Service Description for your service.
     *
     * To support differentiated processing on CBPRPlus, for example, SWIFT reserves a set of values that conform to a specific format.
     *
     * A user-specific value may be used, but please contact your Service Administrator before doing so to ensure alignment with general practice on your service.
     * "
     * todo
     * /AppHdr/Rltd/BizSvc
     * @return  返回R11检查结果
     */
    public Constraints checkR11() {

        return null;
    }

    /**
     *  If related BAH is present, it should transport the element Business Service.
     *
     * /AppHdr/Rltd/BizSvc
     * @return  返回R12检查结果
     */
    public Constraints checkR12() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd){
                    String bizSvc = businessApplicationHeader5.getBizSvc();
                    if (JudgeUtils.isNull(bizSvc)) {
                        return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R12_ERROR_CODE, MXPacs00900108AdvConstant.R12_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * Whenever Debtor Agent, Creditor Agent and all agents in between are located within the same country, the clearing code only may be used.
     * todo
     * @return  返回R13检查结果
     */
    public Constraints checkR13() {

        return null;
    }

    /**
     *"BICFI, complemented optionally with a LEI (preferred option)
     * "
     * todo
     * @return  返回R14检查结果
     */
    public Constraints checkR14() {

        return null;
    }

    /**
     *"(Clearing Code OR LEI)  AND (Name AND (Unstructured postal address OR [Structured postal address with minimum Town Name and Country]). It is recommended to also add the post code when available.
     * "
     * todo
     * @return  返回R15检查结果
     */
    public Constraints checkR15() {

        return null;
    }

    /**
     *"Name AND (Unstructured OR [Structured postal address with minimum Town Name and Country]). It is recommended to also add the post code when available.
     * "
     * todo
     * @return  返回R16检查结果
     */
    public Constraints checkR16() {

        return null;
    }

    /**
     *Address Line (Unstructured Address) remains available only for cases when the payment is initiated in FIN, or by an MI, during coexistence only. The Structured PostalAddress remains the prefered option.
     *
     * Therefore:
     *
     * - If a payment is initiated on FIN, or by an MI, and the postal address is unstructured, the outgoing ISO 20022 message will transport unstructured postal address, up to the Creditor Agent.
     *
     * - If a payment is initiated in ISO 20022, postal address must be structured.
     * todo
     * @return  返回R17检查结果
     */
    public Constraints checkR17() {

        return null;
    }

    /**
     * Name and Address must always be present together.
     * /Document/FICdtTrf/GrpHdr/SttlmInf/InstgRmbrsmntAgt/FinInstnId/PstlAdr
     * @return  返回R18检查结果
     */
    public Constraints checkR18() {
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instgRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instgRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String finInstnIdNm = finInstnId.getNm();
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNull(finInstnIdNm) || JudgeUtils.isNull(pstlAdr)){
                                    return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R18_ERROR_CODE, MXPacs00900108AdvConstant.R18_ERROR_TEXT);
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
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     * /Document/FICdtTrf/GrpHdr/SttlmInf/InstgRmbrsmntAgt/FinInstnId/PstlAdr
     * @return  返回R19检查结果
     */
    public Constraints checkR19() {
        Pacs00900108Adv pacs00900108Adv = this.pacs00900108Adv;
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instgRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instgRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    List<String> adrLine = pstlAdr.getAdrLine();
                                    String dept = pstlAdr.getDept();
                                    String subDept = pstlAdr.getSubDept();
                                    String strtNm = pstlAdr.getStrtNm();
                                    String bldgNb = pstlAdr.getBldgNb();
                                    String bldgNm = pstlAdr.getBldgNm();
                                    String flr = pstlAdr.getFlr();
                                    String pstBx = pstlAdr.getPstBx();
                                    String room = pstlAdr.getRoom();
                                    String pstCd = pstlAdr.getPstCd();
                                    String twnNm = pstlAdr.getTwnNm();
                                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                                    String dstrctNm = pstlAdr.getDstrctNm();
                                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                                    String ctry = pstlAdr.getCtry();
                                    if (JudgeUtils.isNotNull(adrLine)) {
                                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb) || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn)
                                                || JudgeUtils.isNotNull(dept) || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr)
                                                || JudgeUtils.isNotNull(pstBx) || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room)
                                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(subDept) || JudgeUtils.isNotNull(twnLctnNm)
                                                || JudgeUtils.isNotNull(twnNm)) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R19_ERROR_CODE, MXPacs00900108AdvConstant.R19_ERROR_TEXT);
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
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R20检查结果
     */
    public Constraints checkR20() {
        Pacs00900108Adv pacs00900108Adv = this.pacs00900108Adv;
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instgRmbrsmntAgt = sttlmInf.getInstgRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instgRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instgRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    List<String> adrLine = pstlAdr.getAdrLine();
                                    String twnNm = pstlAdr.getTwnNm();
                                    String ctry = pstlAdr.getCtry();
                                    if (JudgeUtils.isNull(adrLine)) {
                                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R20_ERROR_CODE, MXPacs00900108AdvConstant.R20_ERROR_TEXT);
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
     * Name and Address must always be present together.
     * /Document/FICdtTrf/GrpHdr/SttlmInf/InstdRmbrsmntAgt/FinInstnId/PstlAdr
     * @return  返回R21检查结果
     */
    public Constraints checkR21() {
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instdRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instdRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String finInstnIdNm = finInstnId.getNm();
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNull(finInstnIdNm) || JudgeUtils.isNull(pstlAdr)){
                                    return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R18_ERROR_CODE, MXPacs00900108AdvConstant.R18_ERROR_TEXT);
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
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     * /Document/FICdtTrf/GrpHdr/SttlmInf/InstdRmbrsmntAgt/FinInstnId/PstlAdr
     * @return  返回R22检查结果
     */
    public Constraints checkR22() {
        Pacs00900108Adv pacs00900108Adv = this.getPacs00900108Adv();
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instdRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instdRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    List<String> adrLine = pstlAdr.getAdrLine();
                                    String dept = pstlAdr.getDept();
                                    String subDept = pstlAdr.getSubDept();
                                    String strtNm = pstlAdr.getStrtNm();
                                    String bldgNb = pstlAdr.getBldgNb();
                                    String bldgNm = pstlAdr.getBldgNm();
                                    String flr = pstlAdr.getFlr();
                                    String pstBx = pstlAdr.getPstBx();
                                    String room = pstlAdr.getRoom();
                                    String pstCd = pstlAdr.getPstCd();
                                    String twnNm = pstlAdr.getTwnNm();
                                    String twnLctnNm = pstlAdr.getTwnLctnNm();
                                    String dstrctNm = pstlAdr.getDstrctNm();
                                    String ctrySubDvsn = pstlAdr.getCtrySubDvsn();
                                    String ctry = pstlAdr.getCtry();
                                    if (JudgeUtils.isNotNull(adrLine)) {
                                        if (JudgeUtils.isNotNull(ctry) || JudgeUtils.isNotNull(bldgNb) || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn)
                                                || JudgeUtils.isNotNull(dept) || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr)
                                                || JudgeUtils.isNotNull(pstBx) || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room)
                                                || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(subDept) || JudgeUtils.isNotNull(twnLctnNm)
                                                || JudgeUtils.isNotNull(twnNm)) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R22_ERROR_CODE, MXPacs00900108AdvConstant.R22_ERROR_TEXT);
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
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * /Document/FICdtTrf/GrpHdr/SttlmInf/InstdRmbrsmntAgt/FinInstnId/PstlAdr
     * @return  返回R23检查结果
     */
    public Constraints checkR23() {
        Pacs00900108Adv pacs00900108Adv = this.pacs00900108Adv;
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                GroupHeader931 grpHdr = fiCdtTrf.getGrpHdr();
                if (JudgeUtils.isNotNull(grpHdr)) {
                    SettlementInstruction71 sttlmInf = grpHdr.getSttlmInf();
                    if (JudgeUtils.isNotNull(sttlmInf)) {
                        BranchAndFinancialInstitutionIdentification61 instdRmbrsmntAgt = sttlmInf.getInstdRmbrsmntAgt();
                        if (JudgeUtils.isNotNull(instdRmbrsmntAgt)) {
                            FinancialInstitutionIdentification181 finInstnId = instdRmbrsmntAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                PostalAddress241 pstlAdr = finInstnId.getPstlAdr();
                                if (JudgeUtils.isNotNull(pstlAdr)) {
                                    List<String> adrLine = pstlAdr.getAdrLine();
                                    String twnNm = pstlAdr.getTwnNm();
                                    String ctry = pstlAdr.getCtry();
                                    if (JudgeUtils.isNull(adrLine)) {
                                        if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R20_ERROR_CODE, MXPacs00900108AdvConstant.R20_ERROR_TEXT);
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
     * This field must not start or end with a slash '/' and must not contain two consecutive slashes '//'.
     * /Document/FICdtTrf/CdtTrfTxInf/PmtId/InstrId
     * @return  返回R24检查结果
     */
    public Constraints checkR24() {
        Pacs00900108Adv pacs00900108Adv = this.pacs00900108Adv;
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
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
                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R24_ERROR_CODE, MXPacs00900108AdvConstant.R24_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * In the pacs.009 ADV, the E2E identification is provided by the Debtor (Agent).
     *
     * /Document/FICdtTrf/CdtTrfTxInf/PmtId/EndToEndId
     * @return  返回R25检查结果
     */
    public Constraints checkR25() {

        return null;
    }

    /**
     * In the E2E identification, the below restrictions apply to the first 16 characters:
     *
     * - The first one and the 16th one cannot be “/” and
     * - The string of 16 characters cannot contain “//”
     *
     * /Document/FICdtTrf/CdtTrfTxInf/PmtId/EndToEndId
     * @return  返回R26检查结果
     */
    public Constraints checkR26() {

        return null;
    }

    /**
     * The preferred option is coded information.
     *
     * /Document/FICdtTrf/CdtTrfTxInf/PmtTpInf/LclInstrm
     * @return  返回R27检查结果
     */
    public Constraints checkR27() {

        return null;
    }

    /**
     * The preferred option is coded information.
     * @return  返回R28检查结果
     */
    public Constraints checkR28() {

        return null;
    }

    /**
     * The codes XAU, XAG, XPD and XPT are not allowed, as these are codes are only used for commodities.
     *
     * /Document/FICdtTrf/CdtTrfTxInf/IntrBkSttlmAmt/@Ccy
     * @return  返回R29检查结果
     */
    public Constraints checkR29() {
        Pacs00900108Adv pacs00900108Adv = this.pacs00900108Adv;
        if (JudgeUtils.isNotNull(pacs00900108Adv)) {
            FinancialInstitutionCreditTransferV08 fiCdtTrf = pacs00900108Adv.getFICdtTrf();
            if (JudgeUtils.isNotNull(fiCdtTrf)) {
                CreditTransferTransaction361 cdtTrfTxInf = fiCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    CBPRAmount intrBkSttlmAmt = cdtTrfTxInf.getIntrBkSttlmAmt();
                    if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                        String ccy = intrBkSttlmAmt.getCcy();
                        if ("XAU".equals(ccy) || "XAG".equals(ccy) || "XPD".equals(ccy) || "XPT".equals(ccy)) {
                            return new Constraints(MXPacs00900108AdvConstant.ERROR_SEVERITY, MXPacs00900108AdvConstant.R29_ERROR_CODE, MXPacs00900108AdvConstant.R29_ERROR_TEXT, ccy);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R30检查结果
     */
    public Constraints checkR30() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R31检查结果
     */
    public Constraints checkR31() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R32检查结果
     */
    public Constraints checkR32() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R33检查结果
     */
    public Constraints checkR33() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R34检查结果
     */
    public Constraints checkR34() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R35检查结果
     */
    public Constraints checkR35() {

        return null;
    }

    /**
     * If “PostalAddress” is used, and if AddressLine is absent, then Country and Town name must be present.
     * @return  返回R36检查结果
     */
    public Constraints checkR36() {

        return null;
    }
}
