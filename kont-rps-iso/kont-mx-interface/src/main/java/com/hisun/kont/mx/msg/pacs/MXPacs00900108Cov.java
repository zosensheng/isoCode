package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.common.exception.KontException;
import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Constraints;
import com.hisun.kont.mx.constant.MXPacs00900108COVConstant;
import com.hisun.kont.mx.constant.MXPacs00900108Constant;
import com.hisun.kont.mx.enums.BusAppHeadToBusSerEnum;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeader5;
import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;
import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.pacs00900108cov.*;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
public class MXPacs00900108Cov extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.009.001.08";
    public final static transient Class[] _classes = new Class[]{Pacs00900108Cov.class};

    public Pacs00900108Cov pacs00900108Cov;

    public Pacs00900108Cov getPacs00900108Cov() {
        return Optional.ofNullable(this.getPacs00900108Cov()).orElseThrow(() -> new KontException(MXPacs00900108COVConstant.FICDTTRF_COV_ERROR_CODE));
    }

    public void setPacs00900108Cov(Pacs00900108Cov pacs00900108Cov) {
        this.pacs00900108Cov = pacs00900108Cov;
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
        return this.pacs00900108Cov;
    }


    @Override
    public BusinessApplicationHeaderV02 getBusinessApplicationHeaderV02() {
        return Optional.ofNullable(this.getBusinessApplicationHeaderV02()).orElseThrow(() -> new KontException(MXPacs00900108COVConstant.BAH_COV_ERROR_CODE));
    }

    /**
     * If "Priority” is used in the BAH for pacs messages, the value should be identical to the one in the “Payment Type Information/InstructionPriority” if present.
     *
     * @return 返回R1检查结果
     */
    public Constraints checkR1() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        //消息体不能为空
        Pacs00900108Cov pacs00900108Cov = this.getPacs00900108Cov();
            if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getPrty())&&JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf())) {
                if (JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf())){
                    if (JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getPmtTpInf())){
                        if (JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getPmtTpInf().getInstrPrty())){
                            if (!businessApplicationHeaderV02.getPrty().equals(pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getPmtTpInf().getInstrPrty().value())) {
                                return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R1_COV_ERROR_CODE, MXPacs00900108COVConstant.R1_COV_ERROR_TEXT);
                            }
                        }

                    }

                }
            }
        return null;
    }

    /**
     * BAH "From" BIC must match "Instructing Agent" BIC, except where BAH CopyDuplicate = COPY or = CODU
     *
     * BAH "To" BIC must match "Instructed Agent" BIC, except where BAH CopyDuplicate = COPY or = CODU
     *
     * @return 返回R2检查结果
     */
    public Constraints checkR2() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        //消息体不能为空
        Pacs00900108Cov pacs00900108Cov = this.getPacs00900108Cov();
       if (JudgeUtils.notEquals(MXPacs00900108COVConstant.COPYDUPLICATE_CODE_COPY,businessApplicationHeaderV02.getCpyDplct().value())
           || JudgeUtils.notEquals(MXPacs00900108COVConstant.COPYDUPLICATE_CODE_CODU,businessApplicationHeaderV02.getCpyDplct().value())){
           if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr())
                   &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo())){
               if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr().getFIId())
                       &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo().getFIId())){
                   if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr().getFIId().getFinInstnId())
                           &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo().getFIId().getFinInstnId())){
                       if (JudgeUtils.notEquals(businessApplicationHeaderV02.getFr().getFIId().getFinInstnId().getBICFI(),pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getInstgAgt())
                               ||JudgeUtils.notEquals(businessApplicationHeaderV02.getTo().getFIId().getFinInstnId().getBICFI(),pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getInstdAgt())){
                           return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R2_COV_ERROR_CODE, MXPacs00900108COVConstant.R2_COV_ERROR_TEXT);
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
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        //消息体不能为空
        Pacs00900108Cov pacs00900108Cov = this.getPacs00900108Cov();
        if (JudgeUtils.isNull(businessApplicationHeaderV02.getCpyDplct())){
            if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr())
                    &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo())){
                if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr().getFIId())
                        &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo().getFIId())){
                    if (JudgeUtils.isNotNull(businessApplicationHeaderV02.getFr().getFIId().getFinInstnId())
                            &&JudgeUtils.isNotNull(businessApplicationHeaderV02.getTo().getFIId().getFinInstnId())){
                        if (JudgeUtils.notEquals(businessApplicationHeaderV02.getFr().getFIId().getFinInstnId().getBICFI(),pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getInstgAgt())
                                ||JudgeUtils.notEquals(businessApplicationHeaderV02.getTo().getFIId().getFinInstnId().getBICFI(),pacs00900108Cov.getFICdtTrf().getCdtTrfTxInf().getInstdAgt())){
                            return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R3_COV_ERROR_CODE, MXPacs00900108COVConstant.R3_COV_ERROR_TEXT);
                        }
                    }

                }

            }
        }
        return null;
    }
    /**
     * For further description on the usage of the field, pls refer to the CBPR Plus UHB.
     *
     * @return 返回R4检查结果
     */
    public Constraints checkR4() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        //消息体不能为空
        Pacs00900108Cov pacs00900108Cov = this.getPacs00900108Cov();

        return null;
    }
    /**
     * The Business Message Identifier is the unique identifier of the Business Message instance that is being transported with this header, as defined by the sending application or system.
     *
     * Must contain the Message Identification element from the Group Header of the underlying message, where available (as is typically the case with pacs, pain, and camt messages, for example). If Message Identification is not available in the underlying message, then this field must contain the unique identifier of the Business Message instance.
     *
     * @return 返回R5检查结果
     */
    public Constraints checkR5() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        //消息体不能为空
        Pacs00900108Cov pacs00900108Cov = this.getPacs00900108Cov();
        if (JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf())){
            if (JudgeUtils.isNotNull(pacs00900108Cov.getFICdtTrf().getGrpHdr()) &&JudgeUtils.notEquals(businessApplicationHeaderV02.getBizMsgIdr(),pacs00900108Cov.getFICdtTrf().getGrpHdr().getMsgId())){
                return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R5_COV_ERROR_CODE, MXPacs00900108COVConstant.R5_COV_ERROR_TEXT);
            }

        }

        return null;
    }
    /**
     * The Message Definition Identifier of the Business Message instance that is being transported with this header. In general, it must be formatted exactly as it appears in the namespace of the Business Message instance.
     * @return 返回R6检查结果
     */
    public Constraints checkR6() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        businessApplicationHeaderV02.getMsgDefIdr();
        businessApplicationHeaderV02.getRltd().get(0).getMsgDefIdr();
        if (JudgeUtils.notEquals(MXPacs00900108COVConstant.PACS_009_001_08,businessApplicationHeaderV02.getMsgDefIdr())
                ||JudgeUtils.isNotNull(businessApplicationHeaderV02.getRltd())&&JudgeUtils.notEquals(MXPacs00900108COVConstant.PACS_009_001_08,businessApplicationHeaderV02.getRltd().get(0).getMsgDefIdr())){
            return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R6_COV_ERROR_CODE, MXPacs00900108COVConstant.R6_COV_ERROR_TEXT);

        }

        return null;
    }
    /**
     This field may be used by SWIFT to support differentiated processing on SWIFT-administered services such as FINplus. For a description of reserved values, please refer to the Service Description for your service.

     To support differentiated processing on CBPRPlus, for example, SWIFT reserves a set of values that conform to a specific format.

     A user-specific value may be used, but please contact your Service Administrator before doing so to ensure alignment with general practice on your service.

     * @return 返回R7检查结果
     */
    public Constraints checkR7() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();

      List<String> list =  getBusSerEnum(businessApplicationHeaderV02.getBizSvc());
        if (!list.contains(businessApplicationHeaderV02.getBizMsgIdr())) {
            return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R7_COV_ERROR_CODE, MXPacs00900108COVConstant.R7_COV_ERROR_TEXT);
        }
      List<String>  stringList;
        for(BusinessApplicationHeader5 businessApplicationHeader5 :businessApplicationHeaderV02.getRltd()){
            stringList =  getBusSerEnum(businessApplicationHeader5.getBizSvc());
            if (!stringList.contains(businessApplicationHeader5.getBizMsgIdr())) {
                return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R7_COV_ERROR_CODE, MXPacs00900108COVConstant.R7_COV_ERROR_TEXT);
            }
        }

        return null;
    }

    private  List<String> getBusSerEnum(String bizSvc){
        List<String> list = new ArrayList<>();
        for (BusAppHeadToBusSerEnum busSerEnum:BusAppHeadToBusSerEnum.values()){
            String bizSvcEum = busSerEnum.getBizSvc();
            if (bizSvcEum.equals(bizSvc)) {
                String msgDefIdrEnum = busSerEnum.getMsgDefIdr();
                list.add(msgDefIdrEnum);
            }
        }
        return list;

    }
    /**
     The value "swift.cbprplus.cov.02" must be used.
     * @return 返回R8检查结果
     */
    public Constraints checkR8() {
        //消息头部不能为空
        BusinessApplicationHeaderV02 businessApplicationHeaderV02 = this.getBusinessApplicationHeaderV02();
        if (JudgeUtils.notEquals(MXPacs00900108COVConstant.BIZSVC_COV,businessApplicationHeaderV02.getBizSvc())){
            return new Constraints(MXPacs00900108COVConstant.COV_ERROR_SEVERITY, MXPacs00900108COVConstant.R8_COV_ERROR_CODE, MXPacs00900108COVConstant.R8_COV_ERROR_TEXT);

        }

        return null;
    }

}
