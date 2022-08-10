//
// 此文件由 JavaTM Architecture for XML Binding (JAXB) Reference Implementation V2.2.8-b130911.1802 生成
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 重新编译源模式时，对此文件的任何修改都将丢失。
// 生成日期：2022.05.09 时间 10:49:45 AM CST
//


package com.hisun.kont.mx.msg.javabean.head00100102;

import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.*;
import com.hisun.kont.mx.enums.CountryEnum;
import com.hisun.kont.mx.msg.model.AppHdr;
import com.hisun.kont.mx.msg.model.EscapeHandler;
import com.hisun.kont.mx.msg.model.MxWriteParams;
import com.hisun.kont.mx.util.XmlEventWriter;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <p>BusinessApplicationHeaderV02 complex type 的 Java 类。
 *
 * <p>以下模式片段指定此类中包含的期望内容。
 *
 * <pre>
 * &lt;complexType name="BusinessApplicationHeaderV02">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CharSet" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}UnicodeChartsCode" minOccurs="0"/>
 *         &lt;element name="Fr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Party44Choice"/>
 *         &lt;element name="To" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Party44Choice"/>
 *         &lt;element name="BizMsgIdr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text"/>
 *         &lt;element name="MsgDefIdr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text"/>
 *         &lt;element name="BizSvc" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}Max35Text" minOccurs="0"/>
 *         &lt;element name="MktPrctc" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}ImplementationSpecification1" minOccurs="0"/>
 *         &lt;element name="CreDt" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}ISODateTime"/>
 *         &lt;element name="BizPrcgDt" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}ISODateTime" minOccurs="0"/>
 *         &lt;element name="CpyDplct" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}CopyDuplicate1Code" minOccurs="0"/>
 *         &lt;element name="PssblDplct" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}YesNoIndicator" minOccurs="0"/>
 *         &lt;element name="Prty" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}BusinessMessagePriorityCode" minOccurs="0"/>
 *         &lt;element name="Sgntr" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}SignatureEnvelope" minOccurs="0"/>
 *         &lt;element name="Rltd" type="{urn:iso:std:iso:20022:tech:xsd:head.001.001.02}BusinessApplicationHeader5" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BusinessApplicationHeaderV02", propOrder = {
        "charSet",
        "fr",
        "to",
        "bizMsgIdr",
        "msgDefIdr",
        "bizSvc",
        "mktPrctc",
        "creDt",
        "bizPrcgDt",
        "cpyDplct",
        "pssblDplct",
        "prty",
        "sgntr",
        "rltd"
})
@XmlRootElement(name = "AppHdr", namespace = "urn:iso:std:iso:20022:tech:xsd:head.001.001.02")
public class BusinessApplicationHeaderV02 implements AppHdr {
    public static final transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:head.001.001.02";
    private static final transient Logger log = Logger.getLogger(BusinessApplicationHeaderV02.class.getName());
    public final static transient Class[] _classes = new Class[]{BusinessApplicationHeaderV02.class};
    @XmlElement(name = "CharSet")
    protected String charSet;
    @XmlElement(name = "Fr", required = true)
    protected Party44Choice fr;
    @XmlElement(name = "To", required = true)
    protected Party44Choice to;
    @XmlElement(name = "BizMsgIdr", required = true)
    protected String bizMsgIdr;
    @XmlElement(name = "MsgDefIdr", required = true)
    protected String msgDefIdr;
    @XmlElement(name = "BizSvc")
    protected String bizSvc;
    @XmlElement(name = "MktPrctc")
    protected ImplementationSpecification1 mktPrctc;
    @XmlElement(name = "CreDt", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creDt;
    @XmlElement(name = "BizPrcgDt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar bizPrcgDt;
    @XmlElement(name = "CpyDplct")
    @XmlSchemaType(name = "string")
    protected CopyDuplicate1Code cpyDplct;
    @XmlElement(name = "PssblDplct")
    protected Boolean pssblDplct;
    @XmlElement(name = "Prty")
    protected String prty;
    @XmlElement(name = "Sgntr")
    protected SignatureEnvelope sgntr;
    @XmlElement(name = "Rltd")
    protected List<BusinessApplicationHeader5> rltd;


    /**
     * 获取属性 charSet 的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getCharSet() {
        return charSet;
    }

    /**
     * 设置属性 charSet 的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCharSet(String value) {
        this.charSet = value;
    }

    /**
     * 获取属性 fr 的值。
     *
     * @return possible object is
     * {@link Party44Choice }
     */
    public Party44Choice getFr() {
        return fr;
    }

    /**
     * 设置属性 fr 的值。
     *
     * @param value allowed object is
     *              {@link Party44Choice }
     */
    public void setFr(Party44Choice value) {
        this.fr = value;
    }

    /**
     * 获取属性 to 的值。
     *
     * @return possible object is
     * {@link Party44Choice }
     */
    public Party44Choice getTo() {
        return to;
    }

    /**
     * 设置属性 to 的值。
     *
     * @param value allowed object is
     *              {@link Party44Choice }
     */
    public void setTo(Party44Choice value) {
        this.to = value;
    }

    /**
     * 获取属性 bizMsgIdr 的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getBizMsgIdr() {
        return bizMsgIdr;
    }

    /**
     * 设置属性 bizMsgIdr 的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBizMsgIdr(String value) {
        this.bizMsgIdr = value;
    }

    /**
     * 获取属性 msgDefIdr 的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getMsgDefIdr() {
        return msgDefIdr;
    }

    /**
     * 设置属性 msgDefIdr 的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMsgDefIdr(String value) {
        this.msgDefIdr = value;
    }

    /**
     * 获取属性 bizSvc 的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getBizSvc() {
        return bizSvc;
    }

    /**
     * 设置属性 bizSvc 的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBizSvc(String value) {
        this.bizSvc = value;
    }

    /**
     * 获取属性 mktPrctc 的值。
     *
     * @return possible object is
     * {@link ImplementationSpecification1 }
     */
    public ImplementationSpecification1 getMktPrctc() {
        return mktPrctc;
    }

    /**
     * 设置属性 mktPrctc 的值。
     *
     * @param value allowed object is
     *              {@link ImplementationSpecification1 }
     */
    public void setMktPrctc(ImplementationSpecification1 value) {
        this.mktPrctc = value;
    }

    /**
     * 获取属性 creDt 的值。
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getCreDt() {
        return creDt;
    }

    /**
     * 设置属性 creDt 的值。
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setCreDt(XMLGregorianCalendar value) {
        this.creDt = value;
    }

    /**
     * 获取属性 bizPrcgDt 的值。
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBizPrcgDt() {
        return bizPrcgDt;
    }

    /**
     * 设置属性 bizPrcgDt 的值。
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBizPrcgDt(XMLGregorianCalendar value) {
        this.bizPrcgDt = value;
    }

    /**
     * 获取属性 cpyDplct 的值。
     *
     * @return possible object is
     * {@link CopyDuplicate1Code }
     */
    public CopyDuplicate1Code getCpyDplct() {
        return cpyDplct;
    }

    /**
     * 设置属性 cpyDplct 的值。
     *
     * @param value allowed object is
     *              {@link CopyDuplicate1Code }
     */
    public void setCpyDplct(CopyDuplicate1Code value) {
        this.cpyDplct = value;
    }

    /**
     * 获取属性 pssblDplct 的值。
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isPssblDplct() {
        return pssblDplct;
    }

    /**
     * 设置属性 pssblDplct 的值。
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setPssblDplct(Boolean value) {
        this.pssblDplct = value;
    }

    /**
     * 获取属性 prty 的值。
     *
     * @return possible object is
     * {@link String }
     */
    public String getPrty() {
        return prty;
    }

    /**
     * 设置属性 prty 的值。
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPrty(String value) {
        this.prty = value;
    }

    /**
     * 获取属性 sgntr 的值。
     *
     * @return possible object is
     * {@link SignatureEnvelope }
     */
    public SignatureEnvelope getSgntr() {
        return sgntr;
    }

    /**
     * 设置属性 sgntr 的值。
     *
     * @param value allowed object is
     *              {@link SignatureEnvelope }
     */
    public void setSgntr(SignatureEnvelope value) {
        this.sgntr = value;
    }

    /**
     * Gets the value of the rltd property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rltd property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRltd().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusinessApplicationHeader5 }
     */
    public List<BusinessApplicationHeader5> getRltd() {
        if (rltd == null) {
            rltd = new ArrayList<BusinessApplicationHeader5>();
        }
        return this.rltd;
    }

    @Override
    public String from() {
        return null;
    }

    @Override
    public String to() {
        return null;
    }

    @Override
    public String reference() {
        return null;
    }

    @Override
    public String messageName() {
        return null;
    }

    @Override
    public String serviceName() {
        return null;
    }

    @Override
    public boolean duplicate() {
        return false;
    }

    @Override
    public XMLGregorianCalendar creationDate() {
        return null;
    }

    @Override
    public void setCreationDate(boolean overwrite) {

    }

    @Override
    public String xml() {
        return null;
    }

    @Override
    public String xml(String prefix, boolean includeXMLDeclaration) {
        return xml(prefix, includeXMLDeclaration, null);
    }

    @Override
    public String xml(String prefix, boolean includeXMLDeclaration, EscapeHandler escapeHandler) {
        try {
            JAXBContext context = JAXBContext.newInstance(BusinessApplicationHeaderV02.class);
            final Marshaller marshaller = context.createMarshaller();

            final StringWriter sw = new StringWriter();
            JAXBElement<BusinessApplicationHeaderV02> element = new JAXBElement(new QName(NAMESPACE, AppHdr.HEADER_LOCALNAME), BusinessApplicationHeaderV02.class, null, this);
            XmlEventWriter eventWriter = new XmlEventWriter(sw, prefix, includeXMLDeclaration, AppHdr.HEADER_LOCALNAME, escapeHandler);
            marshaller.marshal(element, eventWriter);
            return sw.getBuffer().toString();

        } catch (JAXBException e) {
            log.log(Level.SEVERE, "Error writing head.001.001.02 XML:" + e.getMessage());
        }
        return null;
    }

    @Override
    public String xml(MxWriteParams params) {
        return null;
    }

    @Override
    public Element element() {
        return null;
    }

    @Override
    public String namespace() {
        return null;
    }

    @Override
    public String checkAll() {
        String result = "";
        result = result + checkC1();
        result = result + checkC2();
        result = result + checkC3();
        result = result + checkC5();
        return result;
    }


    /**
     * If CopyDuplicate is present, then Related MUST be present.
     *
     * @return
     */
    public Constraints checkC5() {

        CopyDuplicate1Code cpyDplct = this.getCpyDplct();
        List<BusinessApplicationHeader5> rltd = this.getRltd();
        if (JudgeUtils.isNotNull(cpyDplct) && JudgeUtils.isNull(rltd)) {
            //resultC5 = resultC5+"<AppHdr>"+":"+"H00001"+":"+"Warning"+":"+"Element Related is missing";
            //resultC5 = resultC5 + "<AppHdr>" + ":" + BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_CODE + ":" + BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_SEVERITY + ":" + BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_TEXT;
            return new Constraints(BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_SEVERITY, BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_CODE, BusinessApplicationHeaderV02ErrorConstant.C5_ERROR_TEXT);

        }
        // 属性名：标签名：错误码：错误信息： 级别
        return null;
    }

    /**
     * Only a valid Business identifier code is allowed.
     *
     * @return C1检查
     */
    public Constraints checkC1() {
        String resultC1 = "";

        Optional<BusinessApplicationHeaderV02> businessApplicationHeaderV02 = Optional.of(this);

        //获取 AnyBIC   判断获取的值是否为空，如果为空则则置为 ""
        String frnyBic = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getFr)
                .map(Party44Choice::getOrgId)
                .map(PartyIdentification135::getId)
                .map(Party38Choice::getOrgId)
                .map(OrganisationIdentification29::getAnyBIC)
                .orElse("");
        String toAnyBic = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getTo)
                .map(Party44Choice::getOrgId)
                .map(PartyIdentification135::getId)
                .map(Party38Choice::getOrgId)
                .map(OrganisationIdentification29::getAnyBIC)
                .orElse("");


        if (!"".equals(frnyBic)) {
            if (JudgeUtils.isNotSuccess(ruleC1(frnyBic).getErrorCode())) {
                return ruleC1(frnyBic);
            }
        }
        if (!"".equals(toAnyBic)) {
            if (JudgeUtils.isNotSuccess(ruleC1(frnyBic).getErrorCode())) {
                return ruleC1(frnyBic);
            }
        }

        // 属性名：标签名：错误码：错误信息： 级别
        return null;
    }


    /**
     * Valid BICs for financial institutions are registered
     *
     * @return C2检查
     */
    public Constraints checkC2() {
        String resultC2 = "";

        Optional<BusinessApplicationHeaderV02> businessApplicationHeaderV02 = Optional.of(this);

        //获取 BIFIC   判断获取的值是否为空，如果为空则则置为 ""
        Optional<String> s = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getFr)
                .map(Party44Choice::getFIId)
                .map(BranchAndFinancialInstitutionIdentification6::getFinInstnId)
                .map(FinancialInstitutionIdentification18::getBICFI);
        //获取 BIFIC   判断获取的值是否为空，如果为空则则置为 ""
        Optional<String> s1 = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getTo)
                .map(Party44Choice::getFIId)
                .map(BranchAndFinancialInstitutionIdentification6::getFinInstnId)
                .map(FinancialInstitutionIdentification18::getBICFI);
        if (s.isPresent()){
            String frBicfi = this.getFr().getFIId().getFinInstnId().getBICFI();
            if (JudgeUtils.isNotSuccess(ruleC2(frBicfi).getErrorCode())) {
                return ruleC2(frBicfi);
            }
        }
        if (s1.isPresent()){
            String toBicfi = this.getTo().getFIId().getFinInstnId().getBICFI();
            if (JudgeUtils.isNotSuccess(ruleC2(toBicfi).getErrorCode())) {
                return ruleC2(toBicfi);
            }
        }

        // 属性名：标签名：错误码：错误信息： 级别
        return null;
    }

    /**
     * The code is checked against the list of country names obtained from the United Nations
     *
     * @return C3检查
     */
    public Constraints checkC3() {
        String resultC3 = "";

        Optional<BusinessApplicationHeaderV02> businessApplicationHeaderV02 = Optional.of(this);

        Optional<String> s = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getFr)
                .map(Party44Choice::getOrgId)
                .map(PartyIdentification135::getCtryOfRes);
        Optional<String> s1 = businessApplicationHeaderV02.map(BusinessApplicationHeaderV02::getTo)
                .map(Party44Choice::getOrgId)
                .map(PartyIdentification135::getCtryOfRes);
        if (s.isPresent()){
            String ctryOfRes = this.getFr().getOrgId().getCtryOfRes();
            if (JudgeUtils.isNotSuccess(ruleC3(ctryOfRes).getErrorCode())) {
                return ruleC3(ctryOfRes);
            }
        }
        if (s1.isPresent()){
            String ctryOfRes = this.getTo().getOrgId().getCtryOfRes();
            if (JudgeUtils.isNotSuccess(ruleC3(ctryOfRes).getErrorCode())) {
                return ruleC3(ctryOfRes);
            }
        }
        if (JudgeUtils.isNotNull(this.getRltd())){
            List<BusinessApplicationHeader5> rltd = this.getRltd();
            for (BusinessApplicationHeader5 businessApplicationHeader5 : rltd) {
                Party44Choice fr = businessApplicationHeader5.getFr();
                Party44Choice to = businessApplicationHeader5.getTo();
                if (JudgeUtils.isNotNull(fr)){
                    PartyIdentification135 orgId = fr.getOrgId();
                    if (JudgeUtils.isNotNull(orgId)){
                        String ctryOfRes = orgId.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC3(ctryOfRes).getErrorCode())) {
                            return ruleC3(ctryOfRes);
                        }
                    }
                }
                if (JudgeUtils.isNotNull(to)){
                    PartyIdentification135 orgId = to.getOrgId();
                    if (JudgeUtils.isNotNull(orgId)){
                        String ctryOfRes = orgId.getCtryOfRes();
                        if (JudgeUtils.isNotSuccess(ruleC3(ctryOfRes).getErrorCode())) {
                            return ruleC3(ctryOfRes);
                        }
                    }
                }
            }
        }
        if (JudgeUtils.isNotNull(this.getFr())){
            Party44Choice fr = this.getFr();
            if (JudgeUtils.isNotNull(fr)){
                BranchAndFinancialInstitutionIdentification6 fiId = fr.getFIId();
                if (JudgeUtils.isNotNull(fiId)){
                    FinancialInstitutionIdentification18 finInstnId = fiId.getFinInstnId();
                    BranchData3 brnchId = fiId.getBrnchId();
                    if (JudgeUtils.isNotNull(finInstnId)){
                        PostalAddress24 pstlAdr = finInstnId.getPstlAdr();
                        if (JudgeUtils.isNotNull(pstlAdr)){
                            String ctry = pstlAdr.getCtry();
                            if (JudgeUtils.isNotSuccess(ruleC3(ctry).getErrorCode())) {
                                return ruleC3(ctry);
                            }
                        }
                    }
                    if (JudgeUtils.isNotNull(brnchId)){
                        PostalAddress24 pstlAdr = brnchId.getPstlAdr();
                        if (JudgeUtils.isNotNull(pstlAdr)){
                            String ctry = pstlAdr.getCtry();
                            if (JudgeUtils.isNotSuccess(ruleC3(ctry).getErrorCode())) {
                                return ruleC3(ctry);
                            }
                        }
                    }
                }
            }
        }


        // 属性名：标签名：错误码：错误信息： 级别
        return null;
    }

    /**
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     * @return 判断C1规则 符合返回true 不符合返回false
     */
    private static Constraints ruleC1(String str) {

        //通过正则表达式进行匹配
        boolean c1 = str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");

        if (!c1) {
            return new Constraints(BusinessApplicationHeaderV02ErrorConstant.C1_ERROR_SEVERITY, BusinessApplicationHeaderV02ErrorConstant.C1_ERROR_CODE, BusinessApplicationHeaderV02ErrorConstant.C1_ERROR_TEXT, str);
        }
        return new Constraints(BusinessApplicationHeaderV02ErrorConstant.SUCCESS_CODE);
    }

    /**
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     * @return 判断C2规则
     */
    private static Constraints ruleC2(String str) {

        //通过正则表达式判断
        boolean c2 = str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
        if (!c2) {
            return new Constraints(BusinessApplicationHeaderV02ErrorConstant.C2_ERROR_SEVERITY, BusinessApplicationHeaderV02ErrorConstant.C2_ERROR_CODE, BusinessApplicationHeaderV02ErrorConstant.C2_ERROR_TEXT, str);
        }
        return new Constraints(BusinessApplicationHeaderV02ErrorConstant.SUCCESS_CODE);
    }

    /**
     * @return 判断C3规则
     */
    private static Constraints ruleC3(String str) {
        //通过正则表达式判断
        boolean c9 = str.matches("^[a-zA-Z]{2}$");
        if (!c9) {
            return new Constraints(BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_SEVERITY, BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_CODE, BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_TEXT, str);
        }
        CountryEnum[] values = CountryEnum.values();
        ArrayList<String> ctryLists = new ArrayList<>();
        for (CountryEnum value : values) {
            ctryLists.add(value.getCountryCode());
        }
        if (!ctryLists.contains(str)) {
            return new Constraints(BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_SEVERITY, BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_CODE, BusinessApplicationHeaderV02ErrorConstant.C3_ERROR_TEXT, str);
        }

        return new Constraints(BusinessApplicationHeaderV02ErrorConstant.SUCCESS_CODE);
    }


    @SuppressWarnings("rawtypes")
    Class[] getClasses() {
        return _classes;
    }
}
