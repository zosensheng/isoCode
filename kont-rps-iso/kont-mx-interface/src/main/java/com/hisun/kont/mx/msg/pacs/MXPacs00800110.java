package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.utils.BeanUtils;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.enums.Stp08R18CredAndDebtCountryEnum;
import com.hisun.kont.mx.enums.StpCountryJurEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.*;
import com.hisun.kont.mx.msg.javabean.head00100102.AddressType2Code;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchAndFinancialInstitutionIdentification6;
import com.hisun.kont.mx.msg.javabean.head00100102.BranchData3;
import com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemIdentification2Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.ClearingSystemMemberIdentification2;
import com.hisun.kont.mx.msg.javabean.head00100102.Contact4;
import com.hisun.kont.mx.msg.javabean.head00100102.DateAndPlaceOfBirth1;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.FinancialInstitutionIdentification18;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericFinancialIdentification1;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericIdentification30;
import com.hisun.kont.mx.msg.javabean.head00100102.GenericPersonIdentification1;
import com.hisun.kont.mx.msg.javabean.head00100102.NamePrefix2Code;
import com.hisun.kont.mx.msg.javabean.head00100102.OrganisationIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.OtherContact1;
import com.hisun.kont.mx.msg.javabean.head00100102.PersonIdentificationSchemeName1Choice;
import com.hisun.kont.mx.msg.javabean.head00100102.PreferredContactMethod1Code;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.dic.*;
import com.hisun.kont.mx.msg.pacs.dic.AddressType3Choice;
import com.hisun.kont.mx.msg.pacs.dic.GenericOrganisationIdentification1;
import com.hisun.kont.mx.msg.pacs.dic.OrganisationIdentification29;
import com.hisun.kont.mx.msg.pacs.dic.Party38Choice;
import com.hisun.kont.mx.msg.pacs.dic.PartyIdentification135;
import com.hisun.kont.mx.msg.pacs.dic.PersonIdentification13;
import com.hisun.kont.mx.msg.pacs.dic.PostalAddress24;


import javax.xml.datatype.XMLGregorianCalendar;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class MXPacs00800110 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10";
    public final static transient Class[] _classes = new Class[]{Pacs00800110.class};

    public Pacs00800110 pacs00800110;

    public Pacs00800110 getPacs00800110() {
        return pacs00800110;
    }

    public void setPacs00800110(Pacs00800110 pacs00800110) {
        this.pacs00800110 = pacs00800110;
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
        return this.pacs00800110;
    }

    /**
     * If "Priority” is used in the BAH for pacs messages,
     * the value should be identical to the one in the “Payment Type Information/InstructionPriority” if present.
     * <PmtTpInf> <InstrPrty>
     *
     * @return 返回R1检查结果
     */
    public Constraints checkStpR1() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String prty = businessApplicationHeaderV02.getPrty();
            if (JudgeUtils.isNotNull(prty)) {
                if (JudgeUtils.isNotNull(pacs00800110)) {
                    FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                    if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                        List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                            for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                PaymentTypeInformation28 pmtTpInf = creditTransferTransaction50.getPmtTpInf();
                                if (JudgeUtils.isNotNull(pmtTpInf)) {
                                    Priority2Code instrPrty = pmtTpInf.getInstrPrty();
                                    if (JudgeUtils.isNotNull(instrPrty)) {
                                        String value = instrPrty.value();
                                        if (!prty.equals(value)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R1_ERROR_CODE, MXPacs00800108StpConstant.R1_ERROR_TEXT);
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
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/InstgAgt
     *
     * @return 返回R2检查结果
     */
    public Constraints checkStpR2() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            CopyDuplicate1Code cpyDplct = businessApplicationHeaderV02.getCpyDplct();
            Party44Choice fr = businessApplicationHeaderV02.getFr();
            Party44Choice to = businessApplicationHeaderV02.getTo();
            if (JudgeUtils.isNotNull(cpyDplct)) {
                String valueCpyDplct = cpyDplct.value();
                if (!"COPY".equals(valueCpyDplct) && !"CODU".equals(valueCpyDplct)) {
                    if (JudgeUtils.isNotNull(fr)) {
                        BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                        if (JudgeUtils.isNotNull(fiId)) {
                            FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId)) {
                                String frBicfi = finInstnId.getBICFI();
                                if (JudgeUtils.isNotNull(pacs00800110)) {
                                    FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                                    if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                                        List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(grpHdr)) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!frBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R2_ERROR_CODE, MXPacs00800108StpConstant.R2_ERROR_TEXT);
                                        }
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                                com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = creditTransferTransaction50.getInstgAgt();
                                                if (JudgeUtils.isNotNull(instgAgt)) {
                                                    com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                                    if (JudgeUtils.isNotNull(finInstnId1)) {
                                                        String bicfi = finInstnId1.getBICFI();
                                                        if (!frBicfi.equals(bicfi)) {
                                                            result = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R2_ERROR_CODE, MXPacs00800108StpConstant.R2_ERROR_TEXT);
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
                                if (JudgeUtils.isNotNull(pacs00800110)) {
                                    FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                                    if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                                        boolean result = false;
                                        GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                                        List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                                        if (JudgeUtils.isNotNull(grpHdr)) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!toBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R2_ERROR_CODE, MXPacs00800108StpConstant.R2_ERROR_TEXT);
                                        }
                                        if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                            for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                                com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = creditTransferTransaction50.getInstdAgt();
                                                if (JudgeUtils.isNotNull(instdAgt)) {
                                                    com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                    if (JudgeUtils.isNotNull(finInstnId1)) {
                                                        String bicfi = finInstnId1.getBICFI();
                                                        if (!toBicfi.equals(bicfi)) {
                                                            result = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (result) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R2_ERROR_CODE, MXPacs00800108StpConstant.R2_ERROR_TEXT);
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
    public Constraints checkStpR3() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00800110 pacs00800110 = this.getPacs00800110();
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
                            if (JudgeUtils.isNotNull(pacs00800110)) {
                                FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                                    List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(grpHdr)) {
                                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = grpHdr.getInstgAgt();
                                        if (JudgeUtils.isNotNull(instgAgt)) {
                                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!frBicfi.equals(bicfi)) {
                                                    result = true;
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R3_ERROR_CODE, MXPacs00800108StpConstant.R3_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instgAgt = creditTransferTransaction50.getInstgAgt();
                                            if (JudgeUtils.isNotNull(instgAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instgAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!frBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R3_ERROR_CODE, MXPacs00800108StpConstant.R3_ERROR_TEXT);
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
                            if (JudgeUtils.isNotNull(pacs00800110)) {
                                FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                                    boolean result = false;
                                    GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                                    List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                                    if (JudgeUtils.isNotNull(grpHdr)) {
                                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = grpHdr.getInstdAgt();
                                        if (JudgeUtils.isNotNull(instdAgt)) {
                                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                            if (JudgeUtils.isNotNull(finInstnId1)) {
                                                String bicfi = finInstnId1.getBICFI();
                                                if (!toBicfi.equals(bicfi)) {
                                                    result = true;
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R3_ERROR_CODE, MXPacs00800108StpConstant.R3_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                        for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                            com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 instdAgt = creditTransferTransaction50.getInstdAgt();
                                            if (JudgeUtils.isNotNull(instdAgt)) {
                                                com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = instdAgt.getFinInstnId();
                                                if (JudgeUtils.isNotNull(finInstnId1)) {
                                                    String bicfi = finInstnId1.getBICFI();
                                                    if (!toBicfi.equals(bicfi)) {
                                                        result = true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (result) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R3_ERROR_CODE, MXPacs00800108StpConstant.R3_ERROR_TEXT);
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
    public Constraints checkStpR4() {
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
     * todo 存在疑问
     *
     * @return 返回R5检查结果
     */
    public Constraints checkStpR5() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizMsgIdr = businessApplicationHeaderV02.getBizMsgIdr();
            if (JudgeUtils.isNotNull(pacs00800110)) {
                FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                    GroupHeader96 grpHdr = fiToFICstmrCdtTrf.getGrpHdr();
                    if (JudgeUtils.isNotNull(grpHdr)) {
                        String msgId = grpHdr.getMsgId();
                        if (JudgeUtils.isNotNull(bizMsgIdr) && JudgeUtils.isNotNull(msgId)) {
                            if (!bizMsgIdr.equals(msgId)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R5_ERROR_CODE, MXPacs00800108StpConstant.R5_ERROR_TEXT);
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
     * todo 不会写 使用此头传输的业务消息实例的消息定义标识符。通常，它必须按照它在Business Message实例的名称空间中出现的方式进行格式化。
     *
     * @return 返回R6检查结果
     */
    public Constraints checkStpR6() {
        //public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.008.001.10";
        //    public final static transient String BUSINESS_PROCESS = "pacs";
        //    public final static transient int FUNCTIONALITY = 8;
        //    public final static transient int VARIANT = 1;
        //String namespace = this.getNamespace();
        String namespace = BUSINESS_PROCESS + ".00" + FUNCTIONALITY + ".00" + VARIANT;
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String msgDefIdr = businessApplicationHeaderV02.getMsgDefIdr();
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(msgDefIdr)) {
                if (!msgDefIdr.contains(namespace)) {
                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R6_ERROR_CODE, MXPacs00800108StpConstant.R6_ERROR_TEXT,msgDefIdr);
                }
            }
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd) {
                    String msgDefIdr1 = businessApplicationHeader5.getMsgDefIdr();
                    if (JudgeUtils.isNotNull(msgDefIdr1)) {
                        if (!msgDefIdr.contains(namespace)) {
                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R6_ERROR_CODE, MXPacs00800108StpConstant.R6_ERROR_TEXT,msgDefIdr);
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
     * @return R6规则匹配
     */
//    private Constraints ruleR6(String str) {
//        boolean r6 = str.matches("^[a-zA-Z]{1,35}$");
//        if (!r6) {
//            return new Constraints(MXPacs00800110Constant.ERROR_SEVERITY, MXPacs00800110Constant.R6_ERROR_CODE, MXPacs00800110Constant.R6_ERROR_TEXT);
//        }
//        return null;
//    }
    // Business Application Header – Business Service
    //BusAppHeadToBusSer

    /**
     * This field may be used by SWIFT to support differentiated processing on SWIFT-administered services such as FINplus.
     * For a description of reserved values, please refer to the Service Description for your service.
     * To support differentiated processing on CBPRPlus, for example, SWIFT reserves a set of values that conform to a specific format.
     * A user-specific value may be used, but please contact your Service Administrator before doing
     * so to ensure alignment with general practice on your service.
     * todo 不会写 究竟是需要进行字段格式匹配，还是需要判断字段是否存在
     *
     * @return 返回R7检查结果
     */
    public Constraints checkStpR7() {

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
                if (!msgDefIdrList.contains(msgDefIdr)){
                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R7_ERROR_CODE, MXPacs00800108StpConstant.R7_ERROR_TEXT);
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
                        if (!msgDefIdrList.contains(msgDefIdr1)){
                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R7_ERROR_CODE, MXPacs00800108StpConstant.R7_ERROR_TEXT);
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
            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R7_ERROR_CODE, MXPacs00800108StpConstant.R7_ERROR_TEXT);
        }
        return null;
    }

    /**
     * The value "swift.cbprplus.stp.02" must be used.
     *
     * @return 返回R8检查结果
     */
    public Constraints checkStpR8() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            String bizSvc = businessApplicationHeaderV02.getBizSvc();
            if (JudgeUtils.isNotNull(bizSvc)) {
                if (!"swift.cbprplus.stp.02".equals(bizSvc)) {
                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R8_ERROR_CODE, MXPacs00800108StpConstant.R8_ERROR_TEXT);
                }
            } else {
                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R8_ERROR_CODE, MXPacs00800108StpConstant.R8_ERROR_TEXT);
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
    public Constraints checkStpR9() {
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
    public Constraints checkStpR10() {
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
                        BranchAndFinancialInstitutionIdentification6 fiId1 = to.getFIId();
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId2 = to1.getOrgId();
                        BranchAndFinancialInstitutionIdentification6 fiId2 = to1.getFIId();
                        if (JudgeUtils.isNotNull(orgId1) && JudgeUtils.isNotNull(orgId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id1 = orgId1.getId();
                            Contact4 ctctDtls1 = orgId1.getCtctDtls();
                            String ctryOfRes1 = orgId1.getCtryOfRes();
                            String nm1 = orgId1.getNm();
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = orgId1.getPstlAdr();
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id2 = orgId1.getId();
                            Contact4 ctctDtls2 = orgId1.getCtctDtls();
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
                                                OrganisationIdentificationSchemeName1Choice schmeNm1 = genericOrganisationIdentification1.getSchmeNm();
                                                OrganisationIdentificationSchemeName1Choice schmeNm2 = organisationIdentification1.getSchmeNm();
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
                                    DateAndPlaceOfBirth1 dtAndPlcOfBirth1 = prvtId1.getDtAndPlcOfBirth();
                                    DateAndPlaceOfBirth1 dtAndPlcOfBirth2 = prvtId2.getDtAndPlcOfBirth();
                                    List<GenericPersonIdentification1> othr1 = prvtId1.getOthr();
                                    List<GenericPersonIdentification1> othr2 = prvtId2.getOthr();
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
                                            GenericPersonIdentification1 genericPersonIdentification11 = othr1.get(i);
                                            GenericPersonIdentification1 genericPersonIdentification12 = othr2.get(i);
                                            if (JudgeUtils.isNotNull(genericPersonIdentification11) && JudgeUtils.isNotNull(genericPersonIdentification12)) {
                                                String id3 = genericPersonIdentification11.getId();
                                                String id4 = genericPersonIdentification12.getId();
                                                String issr1 = genericPersonIdentification11.getIssr();
                                                String issr2 = genericPersonIdentification12.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                PersonIdentificationSchemeName1Choice schmeNm1 = genericPersonIdentification11.getSchmeNm();
                                                PersonIdentificationSchemeName1Choice schmeNm2 = genericPersonIdentification12.getSchmeNm();
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
                                NamePrefix2Code nmPrfx1 = ctctDtls1.getNmPrfx();
                                List<OtherContact1> othr1 = ctctDtls1.getOthr();
                                String phneNb1 = ctctDtls1.getPhneNb();
                                PreferredContactMethod1Code prefrdMtd1 = ctctDtls1.getPrefrdMtd();
                                String rspnsblty1 = ctctDtls1.getRspnsblty();
                                String dept2 = ctctDtls2.getDept();
                                String emailAdr2 = ctctDtls2.getEmailAdr();
                                String emailPurp2 = ctctDtls2.getEmailPurp();
                                String faxNb2 = ctctDtls2.getFaxNb();
                                String jobTitl2 = ctctDtls2.getJobTitl();
                                String mobNb2 = ctctDtls2.getMobNb();
                                String nm4 = ctctDtls2.getNm();
                                NamePrefix2Code nmPrfx2 = ctctDtls2.getNmPrfx();
                                List<OtherContact1> othr2 = ctctDtls2.getOthr();
                                String phneNb2 = ctctDtls2.getPhneNb();
                                PreferredContactMethod1Code prefrdMtd2 = ctctDtls2.getPrefrdMtd();
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
                                        OtherContact1 otherContact11 = othr1.get(i);
                                        OtherContact1 otherContact12 = othr2.get(i);
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
                                    AddressType2Code cd1 = adrTp1.getCd();
                                    AddressType2Code cd2 = adrTp2.getCd();
                                    GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                    GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                            FinancialInstitutionIdentification18 finInstnId1 = fiId1.getFinInstnId();
                            FinancialInstitutionIdentification18 finInstnId2 = fiId2.getFinInstnId();
                            BranchData3 brnchId1 = fiId1.getBrnchId();
                            BranchData3 brnchId2 = fiId2.getBrnchId();
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
                                ClearingSystemMemberIdentification2 clrSysMmbId1 = finInstnId1.getClrSysMmbId();
                                ClearingSystemMemberIdentification2 clrSysMmbId2 = finInstnId2.getClrSysMmbId();
                                GenericFinancialIdentification1 othr1 = finInstnId1.getOthr();
                                GenericFinancialIdentification1 othr2 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = finInstnId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = finInstnId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(clrSysMmbId1) && JudgeUtils.isNotNull(clrSysMmbId2)) {
                                    ClearingSystemIdentification2Choice clrSysId1 = clrSysMmbId1.getClrSysId();
                                    ClearingSystemIdentification2Choice clrSysId2 = clrSysMmbId2.getClrSysId();
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
                                    FinancialIdentificationSchemeName1Choice schmeNm1 = othr1.getSchmeNm();
                                    FinancialIdentificationSchemeName1Choice schmeNm2 = othr2.getSchmeNm();
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
                                        AddressType2Code cd1 = adrTp1.getCd();
                                        AddressType2Code cd2 = adrTp2.getCd();
                                        GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                                        AddressType2Code cd1 = adrTp1.getCd();
                                        AddressType2Code cd2 = adrTp2.getCd();
                                        GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                        BranchAndFinancialInstitutionIdentification6 fiId1 = fr.getFIId();
                        com.hisun.kont.mx.msg.javabean.head00100102.PartyIdentification135 orgId2 = fr1.getOrgId();
                        BranchAndFinancialInstitutionIdentification6 fiId2 = fr1.getFIId();
                        if (JudgeUtils.isNotNull(orgId1) && JudgeUtils.isNotNull(orgId2)) {
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id1 = orgId1.getId();
                            Contact4 ctctDtls1 = orgId1.getCtctDtls();
                            String ctryOfRes1 = orgId1.getCtryOfRes();
                            String nm1 = orgId1.getNm();
                            com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = orgId1.getPstlAdr();
                            com.hisun.kont.mx.msg.javabean.head00100102.Party38Choice id2 = orgId1.getId();
                            Contact4 ctctDtls2 = orgId1.getCtctDtls();
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
                                                OrganisationIdentificationSchemeName1Choice schmeNm1 = genericOrganisationIdentification1.getSchmeNm();
                                                OrganisationIdentificationSchemeName1Choice schmeNm2 = organisationIdentification1.getSchmeNm();
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
                                    DateAndPlaceOfBirth1 dtAndPlcOfBirth1 = prvtId1.getDtAndPlcOfBirth();
                                    DateAndPlaceOfBirth1 dtAndPlcOfBirth2 = prvtId2.getDtAndPlcOfBirth();
                                    List<GenericPersonIdentification1> othr1 = prvtId1.getOthr();
                                    List<GenericPersonIdentification1> othr2 = prvtId2.getOthr();
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
                                            GenericPersonIdentification1 genericPersonIdentification11 = othr1.get(i);
                                            GenericPersonIdentification1 genericPersonIdentification12 = othr2.get(i);
                                            if (JudgeUtils.isNotNull(genericPersonIdentification11) && JudgeUtils.isNotNull(genericPersonIdentification12)) {
                                                String id3 = genericPersonIdentification11.getId();
                                                String id4 = genericPersonIdentification12.getId();
                                                String issr1 = genericPersonIdentification11.getIssr();
                                                String issr2 = genericPersonIdentification12.getIssr();
                                                arrayList.add(ruleR10(id3, id4));
                                                arrayList.add(ruleR10(issr1, issr2));
                                                PersonIdentificationSchemeName1Choice schmeNm1 = genericPersonIdentification11.getSchmeNm();
                                                PersonIdentificationSchemeName1Choice schmeNm2 = genericPersonIdentification12.getSchmeNm();
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
                                NamePrefix2Code nmPrfx1 = ctctDtls1.getNmPrfx();
                                List<OtherContact1> othr1 = ctctDtls1.getOthr();
                                String phneNb1 = ctctDtls1.getPhneNb();
                                PreferredContactMethod1Code prefrdMtd1 = ctctDtls1.getPrefrdMtd();
                                String rspnsblty1 = ctctDtls1.getRspnsblty();
                                String dept2 = ctctDtls2.getDept();
                                String emailAdr2 = ctctDtls2.getEmailAdr();
                                String emailPurp2 = ctctDtls2.getEmailPurp();
                                String faxNb2 = ctctDtls2.getFaxNb();
                                String jobTitl2 = ctctDtls2.getJobTitl();
                                String mobNb2 = ctctDtls2.getMobNb();
                                String nm4 = ctctDtls2.getNm();
                                NamePrefix2Code nmPrfx2 = ctctDtls2.getNmPrfx();
                                List<OtherContact1> othr2 = ctctDtls2.getOthr();
                                String phneNb2 = ctctDtls2.getPhneNb();
                                PreferredContactMethod1Code prefrdMtd2 = ctctDtls2.getPrefrdMtd();
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
                                        OtherContact1 otherContact11 = othr1.get(i);
                                        OtherContact1 otherContact12 = othr2.get(i);
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
                                    AddressType2Code cd1 = adrTp1.getCd();
                                    AddressType2Code cd2 = adrTp2.getCd();
                                    GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                    GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                            FinancialInstitutionIdentification18 finInstnId1 = fiId1.getFinInstnId();
                            FinancialInstitutionIdentification18 finInstnId2 = fiId2.getFinInstnId();
                            BranchData3 brnchId1 = fiId1.getBrnchId();
                            BranchData3 brnchId2 = fiId2.getBrnchId();
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
                                ClearingSystemMemberIdentification2 clrSysMmbId1 = finInstnId1.getClrSysMmbId();
                                ClearingSystemMemberIdentification2 clrSysMmbId2 = finInstnId2.getClrSysMmbId();
                                GenericFinancialIdentification1 othr1 = finInstnId1.getOthr();
                                GenericFinancialIdentification1 othr2 = finInstnId1.getOthr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr1 = finInstnId1.getPstlAdr();
                                com.hisun.kont.mx.msg.javabean.head00100102.PostalAddress24 pstlAdr2 = finInstnId2.getPstlAdr();
                                if (JudgeUtils.isNotNull(clrSysMmbId1) && JudgeUtils.isNotNull(clrSysMmbId2)) {
                                    ClearingSystemIdentification2Choice clrSysId1 = clrSysMmbId1.getClrSysId();
                                    ClearingSystemIdentification2Choice clrSysId2 = clrSysMmbId2.getClrSysId();
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
                                    FinancialIdentificationSchemeName1Choice schmeNm1 = othr1.getSchmeNm();
                                    FinancialIdentificationSchemeName1Choice schmeNm2 = othr2.getSchmeNm();
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
                                        AddressType2Code cd1 = adrTp1.getCd();
                                        AddressType2Code cd2 = adrTp2.getCd();
                                        GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                                        AddressType2Code cd1 = adrTp1.getCd();
                                        AddressType2Code cd2 = adrTp2.getCd();
                                        GenericIdentification30 prtry1 = adrTp1.getPrtry();
                                        GenericIdentification30 prtry2 = adrTp2.getPrtry();
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
                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R10_ERROR_CODE, MXPacs00800108StpConstant.R10_ERROR_TEXT);
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

    //无法实现递归调用
    private static boolean contrasObject(Object obj1, Object obj2) {
        boolean isEquals = false;
        if (obj1 instanceof BusinessApplicationHeader5 && obj2 instanceof BusinessApplicationHeader5) {
            BusinessApplicationHeader5 bus1 = (BusinessApplicationHeader5) obj1;
            BusinessApplicationHeader5 bus2 = (BusinessApplicationHeader5) obj2;
            List textList = new ArrayList();
            try {
                Class<? extends BusinessApplicationHeader5> aClass = bus1.getClass();
                Field[] fields = bus1.getClass().getDeclaredFields();
                for (Field field : fields) {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), aClass);
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Object invoke1 = readMethod.invoke(bus1);
                    Object invoke2 = readMethod.invoke(bus2);
                    String typeName = field.getGenericType().getTypeName();
                    if (JudgeUtils.isNotNull(invoke1) && JudgeUtils.isNotNull(invoke2)) {
                        if (invoke1.toString().equals(invoke2.toString())) {
                            isEquals = true;
                            textList.add(readMethod.getName() + "." + false);
                        } else {
                            isEquals = false;
                            textList.add(readMethod.getName() + "." + true);
                            return isEquals;
                        }
                    } else if ((JudgeUtils.isNotNull(invoke1) && JudgeUtils.isNull(invoke2)) || JudgeUtils.isNull(invoke1) && JudgeUtils.isNotNull(invoke2)) {
                        isEquals = false;
                        return isEquals;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Object o : textList) {
                System.out.println(o);
            }
        }
        return isEquals;
    }

    /**
     * If related BAH is present, it should transport the element Business Service.
     *
     * @return 返回R11检查结果
     */
    public Constraints checkStpR11() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            List<BusinessApplicationHeader5> rltd = businessApplicationHeaderV02.getRltd();
            if (JudgeUtils.isNotNull(rltd)) {
                for (BusinessApplicationHeader5 applicationHeader5 : rltd) {
                    String bizSvc = applicationHeader5.getBizSvc();
                    if (JudgeUtils.isNull(bizSvc)) {
                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R11_ERROR_CODE, MXPacs00800108StpConstant.R11_ERROR_TEXT);
                    }
                }
            }
        }
        return null;
    }

    /**
     * In the interbank space, Related Remittance Information and Remittance Information are mutually exclusive and all may be absent.
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/RltdRmtInf
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/RmtInf
     *
     * @return 返回R12检查结果
     */
    public Constraints checkStpR12() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        List<RemittanceLocation7> rltdRmtInf = creditTransferTransaction50.getRltdRmtInf();
                        RemittanceInformation21 rmtInf = creditTransferTransaction50.getRmtInf();
                        if (JudgeUtils.isNotNull(rltdRmtInf) && JudgeUtils.isNotNull(rmtInf)) {
                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R12_ERROR_CODE, MXPacs00800108StpConstant.R12_ERROR_TEXT);
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Charge information is mandatory if CRED is present – if no charges are taken,
     * Zero must be used in "Amount" (any agent in the payment chain).
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/RgltryRptg/DbtCdtRptgInd
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgsInf
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/chrgBr
     * todo  if no charges are taken,Zero must be used in "Amount" (any agent in the payment chain).
     *
     * @return 返回R13检查结果
     */
    public Constraints checkStpR13() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                        ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                        if (JudgeUtils.isNotNull(chrgBr)) {
                            String value = chrgBr.value();
                            if ("CRED".equals(value) && JudgeUtils.isNull(chrgsInf)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R13_ERROR_CODE, MXPacs00800108StpConstant.R13_ERROR_TEXT);
                            } else if ("SHAR".equals(value) && JudgeUtils.isNotNull(chrgsInf)) {
                                for (Charges7 charges7 : chrgsInf) {
                                    ActiveOrHistoricCurrencyAndAmount amt = charges7.getAmt();
                                    if (JudgeUtils.isNotNull(amt)) {
                                        BigDecimal value1 = amt.getValue();
                                        int i = value1.compareTo(BigDecimal.ZERO);
                                        if (i != 0) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R13_ERROR_CODE, MXPacs00800108StpConstant.R13_ERROR_TEXT);
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
     * Transactions exchanged within these country couples are considered as domestic ones.
     * IF Creditor Agent and Debtor Agent BICs are part of following countries: ES, AD
     * Then:
     * Debtor and Creditor must be identified using a Name and the Account/IBAN.
     * todo 需要重新写 ==》Debtor Agent BICs are part of following countries
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/CdtrAgt
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/DbtrAgt
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/CdtrAcct
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/DbtrAcct
     *
     * @return 返回R14检查结果
     */
    public Constraints checkStpR14() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                        CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAgt) && JudgeUtils.isNotNull(dbtrAgt)) {
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = cdtrAgt.getFinInstnId();
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId2 = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String cdtrBicfi = finInstnId1.getBICFI();
                                String dbtrBicfi = finInstnId1.getBICFI();
                                if (getCtryByBICFIR14(cdtrBicfi) && getCtryByBICFIR14(dbtrBicfi)) {
                                    if (JudgeUtils.isNotNull(cdtr) && JudgeUtils.isNotNull(dbtr)) {
                                        String cdtrNm = cdtr.getNm();
                                        String dbtrNm = dbtr.getNm();
                                        if (JudgeUtils.isNull(cdtrNm) || JudgeUtils.isNull(dbtrNm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R14_ERROR_CODE, MXPacs00800108StpConstant.R14_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R14_ERROR_CODE, MXPacs00800108StpConstant.R14_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtrAcct) && JudgeUtils.isNotNull(dbtrAcct)) {
                                        AccountIdentification4Choice cdtrId = cdtrAcct.getId();
                                        AccountIdentification4Choice dbtrId = dbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(cdtrId) && JudgeUtils.isNotNull(dbtrId)) {
                                            String cdtrIBAN = cdtrId.getIBAN();
                                            String dbtrIBAN = dbtrId.getIBAN();
                                            if (JudgeUtils.isNull(cdtrIBAN) || JudgeUtils.isNull(dbtrIBAN)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R14_ERROR_CODE, MXPacs00800108StpConstant.R14_ERROR_TEXT);
                                            }
                                        } else {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R14_ERROR_CODE, MXPacs00800108StpConstant.R14_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R14_ERROR_CODE, MXPacs00800108StpConstant.R14_ERROR_TEXT);
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
     * 通过BICIFI获取国家
     *
     * @param bicfi
     * @return 匹配返回true
     */
    private static boolean getCtryByBICFIR14(String bicfi) {
        String ctry = bicfi.substring(4, 6);

        if ("ES".equals(ctry) || "AD".equals(ctry)) {
            return true;
        }
        return false;
    }


    /**
     * Transactions exchanged within these country couples are considered as domestic ones.
     * IF Creditor Agent and Debtor Agent BICs are part of following countries: FR, MC
     * Then:
     * Debtor and Creditor must be identified using a Name and the Account/IBAN.
     *
     * @return 返回R15检查结果
     */
    public Constraints checkStpR15() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                        CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAgt) && JudgeUtils.isNotNull(dbtrAgt)) {
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = cdtrAgt.getFinInstnId();
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId2 = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String cdtrBicfi = finInstnId1.getBICFI();
                                String dbtrBicfi = finInstnId1.getBICFI();
                                if (getCtryByBICFIR15(cdtrBicfi) && getCtryByBICFIR15(dbtrBicfi)) {
                                    if (JudgeUtils.isNotNull(cdtr) && JudgeUtils.isNotNull(dbtr)) {
                                        String cdtrNm = cdtr.getNm();
                                        String dbtrNm = dbtr.getNm();
                                        if (JudgeUtils.isNull(cdtrNm) || JudgeUtils.isNull(dbtrNm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R15_ERROR_CODE, MXPacs00800108StpConstant.R15_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R15_ERROR_CODE, MXPacs00800108StpConstant.R15_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtrAcct) && JudgeUtils.isNotNull(dbtrAcct)) {
                                        AccountIdentification4Choice cdtrId = cdtrAcct.getId();
                                        AccountIdentification4Choice dbtrId = dbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(cdtrId) && JudgeUtils.isNotNull(dbtrId)) {
                                            String cdtrIBAN = cdtrId.getIBAN();
                                            String dbtrIBAN = dbtrId.getIBAN();
                                            if (JudgeUtils.isNull(cdtrIBAN) || JudgeUtils.isNull(dbtrIBAN)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R15_ERROR_CODE, MXPacs00800108StpConstant.R15_ERROR_TEXT);
                                            }
                                        } else {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R15_ERROR_CODE, MXPacs00800108StpConstant.R15_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R15_ERROR_CODE, MXPacs00800108StpConstant.R15_ERROR_TEXT);
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
     * 通过BICIFI获取国家
     *
     * @param bicfi
     * @return 匹配返回true
     */
    private static boolean getCtryByBICFIR15(String bicfi) {
        String ctry = bicfi.substring(4, 6);

        if ("FR".equals(ctry) || "MC".equals(ctry)) {
            return true;
        }
        return false;
    }

    /**
     * Transactions exchanged within these country couples are considered as domestic ones.
     * IF Creditor Agent and Debtor Agent BICs are part of following countries: IT, SM
     * Then:
     * Debtor and Creditor must be identified using a Name and the Account/IBAN.
     *
     * @return 返回R16检查结果
     */
    public Constraints checkStpR16() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                        CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAgt) && JudgeUtils.isNotNull(dbtrAgt)) {
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = cdtrAgt.getFinInstnId();
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId2 = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String cdtrBicfi = finInstnId1.getBICFI();
                                String dbtrBicfi = finInstnId1.getBICFI();
                                if (getCtryByBICFIR16(cdtrBicfi) && getCtryByBICFIR16(dbtrBicfi)) {
                                    if (JudgeUtils.isNotNull(cdtr) && JudgeUtils.isNotNull(dbtr)) {
                                        String cdtrNm = cdtr.getNm();
                                        String dbtrNm = dbtr.getNm();
                                        if (JudgeUtils.isNull(cdtrNm) || JudgeUtils.isNull(dbtrNm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R16_ERROR_CODE, MXPacs00800108StpConstant.R16_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R16_ERROR_CODE, MXPacs00800108StpConstant.R16_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtrAcct) && JudgeUtils.isNotNull(dbtrAcct)) {
                                        AccountIdentification4Choice cdtrId = cdtrAcct.getId();
                                        AccountIdentification4Choice dbtrId = dbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(cdtrId) && JudgeUtils.isNotNull(dbtrId)) {
                                            String cdtrIBAN = cdtrId.getIBAN();
                                            String dbtrIBAN = dbtrId.getIBAN();
                                            if (JudgeUtils.isNull(cdtrIBAN) || JudgeUtils.isNull(dbtrIBAN)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R16_ERROR_CODE, MXPacs00800108StpConstant.R16_ERROR_TEXT);
                                            }
                                        } else {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R16_ERROR_CODE, MXPacs00800108StpConstant.R16_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R16_ERROR_CODE, MXPacs00800108StpConstant.R16_ERROR_TEXT);
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
     * 通过BICIFI获取国家
     *
     * @param bicfi
     * @return 匹配返回true
     */
    private static boolean getCtryByBICFIR16(String bicfi) {
        String ctry = bicfi.substring(4, 6);

        if ("IT".equals(ctry) || "SM".equals(ctry)) {
            return true;
        }
        return false;
    }

    /**
     * Transactions exchanged within these country couples are considered as domestic ones.
     * IF Creditor Agent and Debtor Agent BICs are part of following countries: IT, VA
     * Then:
     * Debtor and Creditor must be identified using a Name and the Account/IBAN.
     *
     * @return 返沪R17检查结果
     */
    public Constraints checkStpR17() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                        CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAgt) && JudgeUtils.isNotNull(dbtrAgt)) {
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = cdtrAgt.getFinInstnId();
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId2 = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String cdtrBicfi = finInstnId1.getBICFI();
                                String dbtrBicfi = finInstnId1.getBICFI();
                                if (getCtryByBICFIR17(cdtrBicfi) && getCtryByBICFIR17(dbtrBicfi)) {
                                    if (JudgeUtils.isNotNull(cdtr) && JudgeUtils.isNotNull(dbtr)) {
                                        String cdtrNm = cdtr.getNm();
                                        String dbtrNm = dbtr.getNm();
                                        if (JudgeUtils.isNull(cdtrNm) || JudgeUtils.isNull(dbtrNm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R17_ERROR_CODE, MXPacs00800108StpConstant.R17_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R17_ERROR_CODE, MXPacs00800108StpConstant.R17_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtrAcct) && JudgeUtils.isNotNull(dbtrAcct)) {
                                        AccountIdentification4Choice cdtrId = cdtrAcct.getId();
                                        AccountIdentification4Choice dbtrId = dbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(cdtrId) && JudgeUtils.isNotNull(dbtrId)) {
                                            String cdtrIBAN = cdtrId.getIBAN();
                                            String dbtrIBAN = dbtrId.getIBAN();
                                            if (JudgeUtils.isNull(cdtrIBAN) || JudgeUtils.isNull(dbtrIBAN)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R17_ERROR_CODE, MXPacs00800108StpConstant.R17_ERROR_TEXT);
                                            }
                                        } else {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R17_ERROR_CODE, MXPacs00800108StpConstant.R17_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R17_ERROR_CODE, MXPacs00800108StpConstant.R17_ERROR_TEXT);
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
     * 通过BICIFI获取国家
     *
     * @param bicfi
     * @return 匹配返回true
     */
    private static boolean getCtryByBICFIR17(String bicfi) {
        String ctry = bicfi.substring(4, 6);

        if ("IT".equals(ctry) || "VA".equals(ctry)) {
            return true;
        }
        return false;
    }


    /**
     * IF Creditor Agent and Debtor Agent BICs are part of following countries:
     * AT, BE, BG, BV, CY, CZ, DE, DK, EE, ES, FI, FR, GB, GF, GI, GP, GR, HR, HU, IE, IS, IT, LI, LT, LU,
     * LV, MQ (FR), MT, NL, NO, PL, PM (FR), PT, RE (FR), RO, SE, SI, SJ, SK
     * Then:
     * Debtor and Creditor must be identified using a Name and the Account/IBAN.
     *
     * @return 返回R18检查结果
     */
    public Constraints checkStpR18() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 cdtrAgt = creditTransferTransaction50.getCdtrAgt();
                        com.hisun.kont.mx.msg.pacs.dic.BranchAndFinancialInstitutionIdentification6 dbtrAgt = creditTransferTransaction50.getDbtrAgt();
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        CashAccount40 cdtrAcct = creditTransferTransaction50.getCdtrAcct();
                        CashAccount40 dbtrAcct = creditTransferTransaction50.getDbtrAcct();
                        if (JudgeUtils.isNotNull(cdtrAgt) && JudgeUtils.isNotNull(dbtrAgt)) {
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId1 = cdtrAgt.getFinInstnId();
                            com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionIdentification18 finInstnId2 = dbtrAgt.getFinInstnId();
                            if (JudgeUtils.isNotNull(finInstnId1) && JudgeUtils.isNotNull(finInstnId2)) {
                                String cdtrBicfi = finInstnId1.getBICFI();
                                String dbtrBicfi = finInstnId1.getBICFI();
                                if (getCtryByBICFIR18(cdtrBicfi) && getCtryByBICFIR18(dbtrBicfi)) {
                                    if (JudgeUtils.isNotNull(cdtr) && JudgeUtils.isNotNull(dbtr)) {
                                        String cdtrNm = cdtr.getNm();
                                        String dbtrNm = dbtr.getNm();
                                        if (JudgeUtils.isNull(cdtrNm) || JudgeUtils.isNull(dbtrNm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R18_ERROR_CODE, MXPacs00800108StpConstant.R18_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R18_ERROR_CODE, MXPacs00800108StpConstant.R18_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(cdtrAcct) && JudgeUtils.isNotNull(dbtrAcct)) {
                                        AccountIdentification4Choice cdtrId = cdtrAcct.getId();
                                        AccountIdentification4Choice dbtrId = dbtrAcct.getId();
                                        if (JudgeUtils.isNotNull(cdtrId) && JudgeUtils.isNotNull(dbtrId)) {
                                            String cdtrIBAN = cdtrId.getIBAN();
                                            String dbtrIBAN = dbtrId.getIBAN();
                                            if (JudgeUtils.isNull(cdtrIBAN) || JudgeUtils.isNull(dbtrIBAN)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R18_ERROR_CODE, MXPacs00800108StpConstant.R18_ERROR_TEXT);
                                            }
                                        } else {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R18_ERROR_CODE, MXPacs00800108StpConstant.R18_ERROR_TEXT);
                                        }
                                    } else {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R18_ERROR_CODE, MXPacs00800108StpConstant.R18_ERROR_TEXT);
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
     * 通过BICIFI获取国家
     *
     * @param bicfi
     * @return 匹配返回true
     */
    private static boolean getCtryByBICFIR18(String bicfi) {
        String ctry = bicfi.substring(4, 6);
        Stp08R18CredAndDebtCountryEnum[] values = Stp08R18CredAndDebtCountryEnum.values();
        ArrayList<String> allCtry = new ArrayList<>();
        for (Stp08R18CredAndDebtCountryEnum value : values) {
            allCtry.add(value.getCountryCode());
        }
        if (allCtry.contains(ctry)) {
            return true;
        }
        return false;
    }

    /**
     * If "Charge Bearer/DEBT" is present, then only one occurrence of "Charge Information" is allowed
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgBr
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgsInf
     *
     * @return 返回R19检查结果
     */
    public Constraints checkStpR19() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                        List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                        int sum;
                        sum = chrgsInf.size();
                        if (JudgeUtils.isNotNull(chrgBr)) {
                            String value = chrgBr.value();
                            if ("DEBT".equals(value) && sum > 1) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R19_ERROR_CODE, MXPacs00800108StpConstant.R19_ERROR_TEXT);
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
     * @return 返回R20检查结果
     */
    public Constraints checkStpR20() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PaymentIdentification13 pmtId = creditTransferTransaction50.getPmtId();
                        if (JudgeUtils.isNotNull(pmtId)) {
                            String instrId = pmtId.getInstrId();
                            boolean startsWith = instrId.startsWith("/");
                            boolean endsWith = instrId.endsWith("/");
                            boolean contains = instrId.contains("//");
                            if (startsWith || endsWith || contains) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R20_ERROR_CODE, MXPacs00800108StpConstant.R20_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * The codes XAU, XAG, XPD and XPT are not allowed, as these are codes are only used for commodities.
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/IntrBkSttlmAmt/@Ccy
     *
     * @return 返回R21检查结果
     */
    public Constraints checkStpR21() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                        if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            String ccy = intrBkSttlmAmt.getCcy();
                            if ("XAU".equals(ccy) || "XAG".equals(ccy) || "XPD".equals(ccy) || "XPT".equals(ccy)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R21_ERROR_CODE, MXPacs00800108StpConstant.R21_ERROR_TEXT, ccy);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * If Instructed amount and Interbank Settlement Amount are expressed in the same currency:
     * If Charge Bearer/DEBT is used then Charge Information is only mandatory in case of
     * prepaid charges (that is if Interbank Settlement Amount is higher than Instructed Amount)
     * and in that case zero amount is not allowed. Otherwise Charge information is
     * optional (both Agent and currency always need to be provided).
     * This rule only applies when Interbank Settlement Amount and Instructed Amount are expressed in the same currency.
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/InstdAmt
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgBr
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/IntrBkSttlmAmt
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/InstdAmt
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgsInf
     *
     * @return 返回R22检查结果
     */
    public Constraints checkStpR22() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                        ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                        List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                        ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                        if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                            String ccyInstdAmt = instdAmt.getCcy();
                            String ccyTtlIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                            BigDecimal valueInstdAmt = instdAmt.getValue();
                            BigDecimal valueIntrBkSttlmAmt = intrBkSttlmAmt.getValue();
                            if (ccyTtlIntrBkSttlmAmt.equals(ccyInstdAmt)) {
                                if (JudgeUtils.isNotNull(chrgBr)) {
                                    String chrgBrValue = chrgBr.value();
                                    if ("DEBT".equals(chrgBrValue)) {
                                        int i = valueIntrBkSttlmAmt.compareTo(valueInstdAmt);
                                        int resultInstdAmt = valueInstdAmt.compareTo(BigDecimal.ZERO);
                                        int resultIntrBkSttlmAmt = valueIntrBkSttlmAmt.compareTo(BigDecimal.ZERO);
                                        if (i > 0 && resultInstdAmt != 0 && resultIntrBkSttlmAmt != 0) {
                                            if (JudgeUtils.isNull(chrgsInf)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R22_ERROR_CODE, MXPacs00800108StpConstant.R22_ERROR_TEXT);
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
     * If Instructed amount and Interbank Settlement Amount are not expressed in the same currency:
     * <p>
     * If Charge Bearer/DEBT is used then Charge Information is only mandatory in case of prepaid charges
     * (that is if Interbank Settlement Amount is higher than Instructed Amount WHEN converted in the same currency)
     * and in that case zero amount is not allowed.
     * <p>
     * Otherwise Charge information is optional (both Agent and currency always need to be provided).
     * todo 银行间不同的指示金额，需要折算成相同金额进行比较    valueIntrBkSttlmAmt.multiply(xchgRate)
     *
     * @return 返回R23检查结果
     */
    public Constraints checkStpR23() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ActiveCurrencyAndAmount intrBkSttlmAmt = creditTransferTransaction50.getIntrBkSttlmAmt();
                        ActiveOrHistoricCurrencyAndAmount instdAmt = creditTransferTransaction50.getInstdAmt();
                        List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                        ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                        BigDecimal xchgRate = creditTransferTransaction50.getXchgRate();
                        if (JudgeUtils.isNotNull(instdAmt) && JudgeUtils.isNotNull(intrBkSttlmAmt) && JudgeUtils.isNotNull(xchgRate)) {
                            String ccyInstdAmt = instdAmt.getCcy();
                            String ccyTtlIntrBkSttlmAmt = intrBkSttlmAmt.getCcy();
                            BigDecimal valueInstdAmt = new BigDecimal(0);
                            if (JudgeUtils.isNotNull(instdAmt)) {
                                valueInstdAmt = instdAmt.getValue();
                            }
                            BigDecimal valueIntrBkSttlmAmt = new BigDecimal(0);
                            if (JudgeUtils.isNotNull(intrBkSttlmAmt)) {
                                valueIntrBkSttlmAmt = intrBkSttlmAmt.getValue();
                            }
                            valueIntrBkSttlmAmt = valueIntrBkSttlmAmt.multiply(xchgRate);
                            if (!ccyTtlIntrBkSttlmAmt.equals(ccyInstdAmt)) {
                                if (JudgeUtils.isNotNull(chrgBr)) {
                                    String chrgBrValue = chrgBr.value();
                                    if ("DEBT".equals(chrgBrValue)) {
                                        int i = valueIntrBkSttlmAmt.compareTo(valueInstdAmt);
                                        int resultInstdAmt = valueInstdAmt.compareTo(BigDecimal.ZERO);
                                        int resultIntrBkSttlmAmt = valueIntrBkSttlmAmt.compareTo(BigDecimal.ZERO);
                                        if (i > 0 && resultInstdAmt != 0 && resultIntrBkSttlmAmt != 0) {
                                            if (JudgeUtils.isNull(chrgsInf)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R23_ERROR_CODE, MXPacs00800108StpConstant.R23_ERROR_TEXT);
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
     * If deduct taken then charge information is mandatory. It is optional for initiator (not taking deduct).
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgBr
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/ChrgsInf
     *
     * @return 返回R24检查结果
     */
    public Constraints checkStpR24() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        ChargeBearerType1Code chrgBr = creditTransferTransaction50.getChrgBr();
                        List<Charges7> chrgsInf = creditTransferTransaction50.getChrgsInf();
                        if (JudgeUtils.isNotNull(chrgBr)) {
                            String value = chrgBr.value();
                            if ("SHAR".equals(value)) {
                                if (JudgeUtils.isNull(chrgsInf)) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R24_ERROR_CODE, MXPacs00800108StpConstant.R24_ERROR_TEXT);
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
     * Name AND Structured Address with minimum Town Name & Country (+ recommended to add Postal Code when available)
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/UltmtDbtr
     *
     * @return 返回R25检查结果
     */
    public Constraints checkStpR25() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                        if (JudgeUtils.isNotNull(ultmtDbtr)) {
                            String nm = ultmtDbtr.getNm();
                            PostalAddress24 pstlAdr = ultmtDbtr.getPstlAdr();
                            if (JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R25_ERROR_CODE, MXPacs00800108StpConstant.R25_ERROR_TEXT);
                            }
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String twnNm = pstlAdr.getTwnNm();
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNull(twnNm) || JudgeUtils.isNull(ctry)) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R25_ERROR_CODE, MXPacs00800108StpConstant.R25_ERROR_TEXT);
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
     * Name AND Structured Address with minimum Town Name & Country (+ recommended to add Postal code when available)
     * AND Identification: Private or Organisation)
     *
     * @return 返回R26检查结果
     */
    public Constraints checkStpR26() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                        if (JudgeUtils.isNotNull(ultmtDbtr)) {
                            String nm = ultmtDbtr.getNm();
                            Party38Choice id = ultmtDbtr.getId();
                            PostalAddress24 pstlAdr = ultmtDbtr.getPstlAdr();
                            if (JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R26_ERROR_CODE, MXPacs00800108StpConstant.R26_ERROR_TEXT);
                            }
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNotNull(id)) {
                                PersonIdentification13 prvtId = id.getPrvtId();
                                OrganisationIdentification29 orgId = id.getOrgId();
                                String twnNm = pstlAdr.getTwnNm();
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNull(twnNm) || JudgeUtils.isNull(ctry) || (JudgeUtils.isNull(prvtId) && JudgeUtils.isNull(orgId))) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R26_ERROR_CODE, MXPacs00800108StpConstant.R26_ERROR_TEXT);
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
     * For Jurisdictional transactions,  Name and/or Identification (Private or Organisation) (that is within a country
     * or for regions under same legislations – eg EEA)
     * <p>
     * Countries impacted by the Jurisdictional rule:
     * Belgium, Bulgaria, Czechia, Denmark, Germany, Estonia, Ireland, Greece, Spain, France, Croatia, Italy, Cyprus, Latvia,
     * Lithuania, Luxembourg, Hungary, Malta, Netherlands, Austria, Poland, Portugal, Romania, Slovenia, Slovakia, Finland,
     * Sweden - Iceland, Liechtenstein, Norway.
     * <p>
     * Note: The jurisdictional rules apply only when all agents in the payment chain underly the same jurisdiction.
     * todo 不会写
     *
     * @return 返回R27检查结果
     */
    public Constraints checkStpR27() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                        if (JudgeUtils.isNotNull(ultmtDbtr)) {
                            PostalAddress24 pstlAdr = ultmtDbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                StpCountryJurEnum[] values = StpCountryJurEnum.values();
                                ArrayList<String> strings = new ArrayList<>();
                                for (StpCountryJurEnum value : values) {
                                    strings.add(value.getCountryCode());
                                }
                                if (strings.contains(ctry)) {
                                    String nm = ultmtDbtr.getNm();
                                    Party38Choice id = ultmtDbtr.getId();
                                    if (JudgeUtils.isNull(nm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R27_ERROR_CODE, MXPacs00800108StpConstant.R27_ERROR_TEXT);
                                    }
                                    if (JudgeUtils.isNotNull(id)) {
                                        PersonIdentification13 prvtId = id.getPrvtId();
                                        OrganisationIdentification29 orgId = id.getOrgId();
                                        if (JudgeUtils.isNull(prvtId) && JudgeUtils.isNull(orgId)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R27_ERROR_CODE, MXPacs00800108StpConstant.R27_ERROR_TEXT);
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
     * If Postal Address is present then Name is mandatory.
     *
     * @return 返回R28检查结果
     */
    public Constraints checkStpR28() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtDbtr = creditTransferTransaction50.getUltmtDbtr();
                        if (JudgeUtils.isNotNull(ultmtDbtr)) {
                            String nm = ultmtDbtr.getNm();
                            PostalAddress24 pstlAdr = ultmtDbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R28_ERROR_CODE, MXPacs00800108StpConstant.R28_ERROR_TEXT);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }

    /**
     * If Postal Address is present then Name is mandatory.
     *
     * @return 返回R29检查结果
     */
    public Constraints checkStpR29() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 initgPty = creditTransferTransaction50.getInitgPty();
                        if (JudgeUtils.isNotNull(initgPty)) {
                            String nm = initgPty.getNm();
                            PostalAddress24 pstlAdr = initgPty.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R29_ERROR_CODE, MXPacs00800108StpConstant.R29_ERROR_TEXT);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }

    /**
     * 1)    If a payment is initiated by the Debtor’s Agent in ISO 20022, effective with the start of the
     * co-existence phase in November 2022, it is highly recommended to use a structured address of the Debtor and Creditor.
     * Please note some MIs may reject an unstructured address from 2023.
     * <p>
     * 2)    If a payment is initiated on FIN or by an MI not on ISO20022 yet , and the postal address is unstructured,
     * the outgoing ISO 20022 message will transport unstructured postal address, up to the Creditor Agent. End of 2023
     * is still highly recommended as a target by all communities as  for the end-date for unstructured party information
     * for any payment format, legacy, FIN and ISO 20022.
     * <p>
     * 3)    From November 2023 until November 2025, the same strong recommendation as stated under 1) above, applies.
     * <p>
     * 4)    Structured address will become mandatory from November 2025 (the unstructured Address Line element will be removed).
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/Dbtr
     * todo 不会写 Structured address will become mandatory from November 2025 (the unstructured Address Line element will be removed).
     *
     * @return 返回R30检查结果
     */
    public Constraints checkStpR30() {
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.isNotNull(businessApplicationHeaderV02)) {
            XMLGregorianCalendar creDt = businessApplicationHeaderV02.getCreDt();
            if (JudgeUtils.isNotNull(creDt)) {
                int year = creDt.getYear();
                int month = creDt.getMonth();
                if ((year == 2025 && month >= 11) || year > 2025) {
                    Pacs00800110 pacs00800110 = this.getPacs00800110();
                    if (JudgeUtils.isNotNull(pacs00800110)) {
                        FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
                        if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                            List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                            if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                                for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                                    PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                                    PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                                    if (JudgeUtils.isNotNull(cdtr)) {
                                        PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                                        if (JudgeUtils.isNotNull(pstlAdr)) {
                                            List<String> adrLine = pstlAdr.getAdrLine();
                                            String twnNm = pstlAdr.getTwnNm();
                                            String ctry = pstlAdr.getCtry();
                                            if (JudgeUtils.isNotNull(adrLine) || JudgeUtils.isNull(twnNm) || JudgeUtils.isNull(ctry)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R30_ERROR_CODE, MXPacs00800108StpConstant.R30_ERROR_TEXT);
                                            }
                                        }
                                    }
                                    if (JudgeUtils.isNotNull(dbtr)) {
                                        PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                                        if (JudgeUtils.isNotNull(pstlAdr)) {
                                            List<String> adrLine = pstlAdr.getAdrLine();
                                            String twnNm = pstlAdr.getTwnNm();
                                            String ctry = pstlAdr.getCtry();
                                            if (JudgeUtils.isNotNull(adrLine) || JudgeUtils.isNull(twnNm) || JudgeUtils.isNull(ctry)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R30_ERROR_CODE, MXPacs00800108StpConstant.R30_ERROR_TEXT);
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
     * Organisation Identification/AnyBIC AND (Account Number OR Organisation Identification/Other)
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/Dbtr
     * todo  Account Number
     *
     * @return 返回R31检查结果
     */
    public Constraints checkStpR31() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            Party38Choice id = dbtr.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBIC = orgId.getAnyBIC();
                                    List<GenericOrganisationIdentification1> othr = orgId.getOthr();
                                    if (JudgeUtils.isNull(anyBIC) || JudgeUtils.isNull(othr)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R31_ERROR_CODE, MXPacs00800108StpConstant.R31_ERROR_TEXT);
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
     * Name AND (Unstructured OR [Structured Address with minimumTown Name & Country
     * (+ recommended to add Postal code when available)])  AND  (Account Number OR Identification: Private or Organisation)
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/Dbtr
     * todo 不会写
     *
     * @return 返回R32检查结果
     */
    public Constraints checkStpR32() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            String nm = dbtr.getNm();
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            Party38Choice id = dbtr.getId();
                            if (JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R32_ERROR_CODE, MXPacs00800108StpConstant.R32_ERROR_TEXT);
                            } else if (JudgeUtils.isNull(pstlAdr)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R32_ERROR_CODE, MXPacs00800108StpConstant.R32_ERROR_TEXT);
                            }
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                PersonIdentification13 prvtId = id.getPrvtId();
                                if (JudgeUtils.isNull(orgId) && JudgeUtils.isNull(prvtId)) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R32_ERROR_CODE, MXPacs00800108StpConstant.R32_ERROR_TEXT);
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
     * For Jurisdictional transactions,  Debtor/ Name is mandatory with either Debtor Account OR Debtor Identification
     * (that is within a country or for regions under same legislations – eg EEA)
     * <p>
     * Countries impacted by the Jurisdictional rule:
     * Belgium, Bulgaria, Czechia, Denmark, Germany, Estonia, Ireland, Greece, Spain, France, Croatia, Italy, Cyprus,
     * Latvia, Lithuania, Luxembourg, Hungary, Malta, Netherlands, Austria, Poland, Portugal, Romania, Slovenia, Slovakia,
     * Finland, Sweden - Iceland, Liechtenstein, Norway.
     * <p>
     * Note: The jurisdictional rules apply only when all agents in the payment chain underly the same jurisdiction.
     * todo 需要进行国家匹配
     *
     * @return 返回R33检查结果
     */
    public Constraints checkStpR33() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            String nm = dbtr.getNm();
                            Party38Choice id = dbtr.getId();
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                StpCountryJurEnum[] values = StpCountryJurEnum.values();
                                ArrayList<String> strings = new ArrayList<>();
                                for (StpCountryJurEnum value : values) {
                                    strings.add(value.getCountryCode());
                                }
                                if (strings.contains(ctry)) {
                                    if (JudgeUtils.isNull(nm) || JudgeUtils.isNull(id)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R33_ERROR_CODE, MXPacs00800108StpConstant.R33_ERROR_TEXT);
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
     * If Postal Address is present then Name is mandatory.
     *
     * @return 返回R34检查结果
     */
    public Constraints checkStpR34() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            String nm = dbtr.getNm();
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R34_ERROR_CODE, MXPacs00800108StpConstant.R34_ERROR_TEXT);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }

    /**
     * If AnyBIC is absent then Name is mandatory and it is recommended to also provide the Postal Address.
     *
     * @return 返回R35检查结果
     */
    public Constraints checkStpR35() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            Party38Choice id = dbtr.getId();
                            String nm = dbtr.getNm();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBIC = orgId.getAnyBIC();
                                    if (JudgeUtils.isNull(anyBIC) && JudgeUtils.isNull(nm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R35_ERROR_CODE, MXPacs00800108StpConstant.R35_ERROR_TEXT);
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
     * If Any BIC is present, then (Name and Postal Address) is NOT allowed (other elements remain optional) - However,
     * in case of conflicting information, AnyBIC will always take precedence.
     *
     * @return 返回R36检查结果
     */
    public Constraints checkStpR36() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            Party38Choice id = dbtr.getId();
                            String nm = dbtr.getNm();
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBIC = orgId.getAnyBIC();
                                    if (JudgeUtils.isNotNull(anyBIC) && (JudgeUtils.isNotNull(nm) || JudgeUtils.isNotNull(pstlAdr))) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R36_ERROR_CODE, MXPacs00800108StpConstant.R36_ERROR_TEXT);
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
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R37检查结果
     */
    public Constraints checkStpR37() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                List<String> adrLine = pstlAdr.getAdrLine();
                                AddressType3Choice adrTp = pstlAdr.getAdrTp();
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
                                String strtNm = pstlAdr.getStrtNm();
                                String subDept = pstlAdr.getSubDept();
                                String twnLctnNm = pstlAdr.getTwnLctnNm();
                                String twnNm = pstlAdr.getTwnNm();
                                if (JudgeUtils.isNotNull(adrLine)) {
                                    if (JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(ctry)
                                            || JudgeUtils.isNotNull(bldgNb) || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn)
                                            || JudgeUtils.isNotNull(dept) || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr)
                                            || JudgeUtils.isNotNull(pstBx) || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room)
                                            || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(subDept) || JudgeUtils.isNotNull(twnLctnNm)
                                            || JudgeUtils.isNotNull(twnNm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R37_ERROR_CODE, MXPacs00800108StpConstant.R37_ERROR_TEXT);
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
     *
     * @return 返回R38检查结果
     */
    public Constraints checkStpR38() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 dbtr = creditTransferTransaction50.getDbtr();
                        if (JudgeUtils.isNotNull(dbtr)) {
                            PostalAddress24 pstlAdr = dbtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                List<String> adrLine = pstlAdr.getAdrLine();
                                String ctry = pstlAdr.getCtry();
                                String twnNm = pstlAdr.getTwnNm();
                                if (JudgeUtils.isNull(adrLine)) {
                                    if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R38_ERROR_CODE, MXPacs00800108StpConstant.R38_ERROR_TEXT);
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
     * If Postal Address is present then Name is mandatory.
     *
     * @return 返回R39检查结果
     */
    public Constraints checkStpR39() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            String nm = cdtr.getNm();
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R39_ERROR_CODE, MXPacs00800108StpConstant.R39_ERROR_TEXT);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * Organisation Identification/AnyBIC AND (Account Number OR Organisation Identification/Other)
     * /Document/FIToFICstmrCdtTrf/CdtTrfTxInf/Cdtr
     * todo Account Number
     *
     * @return 返回R40检查结果
     */
    public Constraints checkStpR40() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            Party38Choice id = cdtr.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBic = orgId.getAnyBIC();
                                    List<GenericOrganisationIdentification1> othr = orgId.getOthr();
                                    if (JudgeUtils.isNull(anyBic) || JudgeUtils.isNull(othr)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R40_ERROR_CODE, MXPacs00800108StpConstant.R40_ERROR_TEXT);
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
     * Name AND (Unstructured OR [Structured Address with minimumTown Name & Country (+ recommended to add Postal
     * code when available)])  AND  (Account Number OR Identification: Private or Organisation)
     * todo  Structured Address
     *
     * @return 返回R41检查结果
     */
    public Constraints checkStpR41() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            String nm = cdtr.getNm();
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            Party38Choice id = cdtr.getId();
                            if (JudgeUtils.isNull(nm) || JudgeUtils.isNull(pstlAdr)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R41_ERROR_CODE, MXPacs00800108StpConstant.R41_ERROR_TEXT);
                            }
                            if (JudgeUtils.isNotNull(id)) {
                                PersonIdentification13 prvtId = id.getPrvtId();
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNull(prvtId) && JudgeUtils.isNull(orgId)) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R41_ERROR_CODE, MXPacs00800108StpConstant.R41_ERROR_TEXT);
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
     * For Jurisdictional transactions,  Creditor/Name is mandatory with either Creditor Account OR Creditor Identification
     * (that is within a country or for regions under same legislations – eg EEA)
     * <p>
     * Countries impacted by the Jurisdictional rule:
     * Belgium, Bulgaria, Czechia, Denmark, Germany, Estonia, Ireland, Greece, Spain, France, Croatia, Italy, Cyprus, Latvia,
     * Lithuania, Luxembourg, Hungary, Malta, Netherlands, Austria, Poland, Portugal, Romania, Slovenia, Slovakia, Finland,
     * Sweden - Iceland, Liechtenstein, Norway.
     * <p>
     * Note: The jurisdictional rules apply only when all agents in the payment chain underly the same jurisdiction.
     * todo 不会写
     *
     * @return 返回R42检查结果
     */
    public Constraints checkStpR42() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            String nm = cdtr.getNm();
                            Party38Choice id = cdtr.getId();
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                StpCountryJurEnum[] values = StpCountryJurEnum.values();
                                ArrayList<String> strings = new ArrayList<>();
                                for (StpCountryJurEnum value : values) {
                                    strings.add(value.getCountryCode());
                                }
                                if (strings.contains(ctry)) {
                                    if (JudgeUtils.isNull(nm) || JudgeUtils.isNull(id)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R42_ERROR_CODE, MXPacs00800108StpConstant.R42_ERROR_TEXT);
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
     * If AnyBIC is absent then Name is mandatory and it is recommended to also provide the Postal Address.
     *
     * @return 返回R43检查结果
     */
    public Constraints checkStpR43() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            String nm = cdtr.getNm();
                            Party38Choice id = cdtr.getId();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBIC = orgId.getAnyBIC();
                                    if (JudgeUtils.isNull(anyBIC) && JudgeUtils.isNull(nm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R43_ERROR_CODE, MXPacs00800108StpConstant.R43_ERROR_TEXT);
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
     * If Any BIC is present, then (Name and Postal Address) is NOT allowed (other elements remain optional) - However,
     * in case of conflicting information, AnyBIC will always take precedence.
     *
     * @return 返回R44检查结果
     */
    public Constraints checkStpR44() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            String nm = cdtr.getNm();
                            Party38Choice id = cdtr.getId();
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(id)) {
                                OrganisationIdentification29 orgId = id.getOrgId();
                                if (JudgeUtils.isNotNull(orgId)) {
                                    String anyBIC = orgId.getAnyBIC();
                                    if (JudgeUtils.isNotNull(anyBIC)) {
                                        if (JudgeUtils.isNotNull(nm) || JudgeUtils.isNotNull(pstlAdr)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R44_ERROR_CODE, MXPacs00800108StpConstant.R44_ERROR_TEXT);
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
     * If PostalAddress is used and if AddressLine is present, then all other optional elements in PostalAddress must be absent.
     *
     * @return 返回R45检查结果
     */
    public Constraints checkStpR45() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                List<String> adrLine = pstlAdr.getAdrLine();
                                AddressType3Choice adrTp = pstlAdr.getAdrTp();
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
                                String strtNm = pstlAdr.getStrtNm();
                                String subDept = pstlAdr.getSubDept();
                                String twnLctnNm = pstlAdr.getTwnLctnNm();
                                String twnNm = pstlAdr.getTwnNm();
                                if (JudgeUtils.isNotNull(adrLine)) {
                                    if (JudgeUtils.isNotNull(adrTp) || JudgeUtils.isNotNull(ctry)
                                            || JudgeUtils.isNotNull(bldgNb) || JudgeUtils.isNotNull(bldgNm) || JudgeUtils.isNotNull(ctrySubDvsn)
                                            || JudgeUtils.isNotNull(dept) || JudgeUtils.isNotNull(dstrctNm) || JudgeUtils.isNotNull(flr)
                                            || JudgeUtils.isNotNull(pstBx) || JudgeUtils.isNotNull(pstCd) || JudgeUtils.isNotNull(room)
                                            || JudgeUtils.isNotNull(strtNm) || JudgeUtils.isNotNull(subDept) || JudgeUtils.isNotNull(twnLctnNm)
                                            || JudgeUtils.isNotNull(twnNm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R45_ERROR_CODE, MXPacs00800108StpConstant.R45_ERROR_TEXT);
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
     *
     * @return 返回R46检查结果
     */
    public Constraints checkStpR46() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 cdtr = creditTransferTransaction50.getCdtr();
                        if (JudgeUtils.isNotNull(cdtr)) {
                            PostalAddress24 pstlAdr = cdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                List<String> adrLine = pstlAdr.getAdrLine();
                                String ctry = pstlAdr.getCtry();
                                String twnNm = pstlAdr.getTwnNm();
                                if (JudgeUtils.isNull(adrLine)) {
                                    if (JudgeUtils.isNull(ctry) || JudgeUtils.isNull(twnNm)) {
                                        return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R46_ERROR_CODE, MXPacs00800108StpConstant.R46_ERROR_TEXT);
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
     * Name AND Structured Address, with minimum Country (other elements are optional, eg Identification: Private or Organisation)
     * todo 不会写 Structured Address
     *
     * @return 返回R47检查结果
     */
    public Constraints checkStpR47() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtCdtrr = creditTransferTransaction50.getUltmtCdtr();
                        if (JudgeUtils.isNotNull(ultmtCdtrr)) {
                            String nm = ultmtCdtrr.getNm();
                            PostalAddress24 pstlAdr = ultmtCdtrr.getPstlAdr();
                            if (JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R47_ERROR_CODE, MXPacs00800108StpConstant.R47_ERROR_TEXT);
                            }
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNull(ctry)) {
                                    return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R47_ERROR_CODE, MXPacs00800108StpConstant.R47_ERROR_TEXT);
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
     * For Jurisdictional transactions,  Name and/or Identification (Private or Organisation) (that is within a country or
     * for regions under same legislations – eg EEA)
     * <p>
     * Countries impacted by the Jurisdictional rule:
     * Belgium, Bulgaria, Czechia, Denmark, Germany, Estonia, Ireland, Greece, Spain, France, Croatia, Italy, Cyprus, Latvia,
     * Lithuania, Luxembourg, Hungary, Malta, Netherlands, Austria, Poland, Portugal, Romania, Slovenia, Slovakia, Finland,
     * Sweden - Iceland, Liechtenstein, Norway.
     * <p>
     * Note: The jurisdictional rules apply only when all agents in the payment chain underly the same jurisdiction.
     * todo 不会写
     *
     * @return 返回R48检查结果
     */
    public Constraints checkStpR48() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtCdtr = creditTransferTransaction50.getUltmtCdtr();
                        if (JudgeUtils.isNotNull(ultmtCdtr)) {
                            String nm = ultmtCdtr.getNm();
                            Party38Choice id = ultmtCdtr.getId();
                            PostalAddress24 pstlAdr = ultmtCdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr)) {
                                String ctry = pstlAdr.getCtry();
                                if (JudgeUtils.isNotNull(ctry)) {
                                    StpCountryJurEnum[] values = StpCountryJurEnum.values();
                                    ArrayList<String> strings = new ArrayList<>();
                                    for (StpCountryJurEnum value : values) {
                                        strings.add(value.getCountryCode());
                                    }
                                    if (strings.contains(ctry)) {
                                        if (JudgeUtils.isNull(nm)) {
                                            return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R48_ERROR_CODE, MXPacs00800108StpConstant.R48_ERROR_TEXT);
                                        }
                                        if (JudgeUtils.isNotNull(id)) {
                                            PersonIdentification13 prvtId = id.getPrvtId();
                                            OrganisationIdentification29 orgId = id.getOrgId();
                                            if (JudgeUtils.isNull(prvtId) && JudgeUtils.isNull(orgId)) {
                                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R48_ERROR_CODE, MXPacs00800108StpConstant.R48_ERROR_TEXT);
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
     * If Postal Address is present then Name is mandatory.
     *
     * @return 返回R49检查结果
     */
    public Constraints checkStpR49() {
        Pacs00800110 pacs00800110 = this.getPacs00800110();
        if (JudgeUtils.isNotNull(pacs00800110)) {
            FIToFICustomerCreditTransferV10 fiToFICstmrCdtTrf = pacs00800110.getFIToFICstmrCdtTrf();
            if (JudgeUtils.isNotNull(fiToFICstmrCdtTrf)) {
                List<CreditTransferTransaction50> cdtTrfTxInf = fiToFICstmrCdtTrf.getCdtTrfTxInf();
                if (JudgeUtils.isNotNull(cdtTrfTxInf)) {
                    for (CreditTransferTransaction50 creditTransferTransaction50 : cdtTrfTxInf) {
                        PartyIdentification135 ultmtCdtr = creditTransferTransaction50.getUltmtCdtr();
                        if (JudgeUtils.isNotNull(ultmtCdtr)) {
                            String nm = ultmtCdtr.getNm();
                            PostalAddress24 pstlAdr = ultmtCdtr.getPstlAdr();
                            if (JudgeUtils.isNotNull(pstlAdr) && JudgeUtils.isNull(nm)) {
                                return new Constraints(MXPacs00800108StpConstant.ERROR_SEVERITY, MXPacs00800108StpConstant.R49_ERROR_CODE, MXPacs00800108StpConstant.R49_ERROR_TEXT);
                            }
                        }
                    }

                }
            }
        }
        return null;
    }

    public String checkStpR() {
        return "未修改调用的方法名";
    }

}
