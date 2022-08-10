package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details to identify a financial institution.
 *
 * <p>FinancialInstitutionIdentification18 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification18">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="BICFI" type="{}BICFIDec2014Identifier" minOccurs="0"/>
 *         &lt;element name="ClrSysMmbId" type="{}ClearingSystemMemberIdentification2" minOccurs="0"/>
 *         &lt;element name="LEI" type="{}LEIIdentifier" minOccurs="0"/>
 *         &lt;element name="Nm" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{}PostalAddress24" minOccurs="0"/>
 *         &lt;element name="Othr" type="{}GenericFinancialIdentification1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification18", propOrder = {
        "bicfi",
        "clrSysMmbId",
        "lei",
        "nm",
        "pstlAdr",
        "othr"
})
public class FinancialInstitutionIdentification18 {

    @XmlElement(name = "BICFI")
    protected String bicfi;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification2 clrSysMmbId;
    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress24 pstlAdr;
    @XmlElement(name = "Othr")
    protected GenericFinancialIdentification1 othr;

    /**
     * ��ȡbicfi���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getBICFI() {
        return bicfi;
    }

    /**
     * ����bicfi���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBICFI(String value) {
        this.bicfi = value;
    }

    /**
     * ��ȡclrSysMmbId���Ե�ֵ��
     *
     * @return possible object is
     * {@link ClearingSystemMemberIdentification2 }
     */
    public ClearingSystemMemberIdentification2 getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * ����clrSysMmbId���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link ClearingSystemMemberIdentification2 }
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification2 value) {
        this.clrSysMmbId = value;
    }

    /**
     * ��ȡlei���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getLEI() {
        return lei;
    }

    /**
     * ����lei���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLEI(String value) {
        this.lei = value;
    }

    /**
     * ��ȡnm���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getNm() {
        return nm;
    }

    /**
     * ����nm���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * ��ȡpstlAdr���Ե�ֵ��
     *
     * @return possible object is
     * {@link PostalAddress24 }
     */
    public PostalAddress24 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * ����pstlAdr���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link PostalAddress24 }
     */
    public void setPstlAdr(PostalAddress24 value) {
        this.pstlAdr = value;
    }

    /**
     * ��ȡothr���Ե�ֵ��
     *
     * @return possible object is
     * {@link GenericFinancialIdentification1 }
     */
    public GenericFinancialIdentification1 getOthr() {
        return othr;
    }

    /**
     * ����othr���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link GenericFinancialIdentification1 }
     */
    public void setOthr(GenericFinancialIdentification1 value) {
        this.othr = value;
    }

    /**
     * Valid BICs for financial institutions are registered and published by the ISO 9362 Registration
     * Authority in the ISO directory of BICs, and consist of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     *
     * @return C4规则检查
     */
    public String checkC4() {
        String resultC4 = "";
        if (JudgeUtils.isNotNull(this.getBICFI())) {
            if (!ruleC4(bicfi)) {
                resultC4 = resultC4 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C4_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C4_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C4_ERROR_TEXT;
                return resultC4;
            }
        }
        return resultC4;
    }

    /**
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断C4规则 符合返回true 不符合返回false
     */
    private static boolean ruleC4(String str) {

        //通过正则表达式进行匹配
        return str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
    }

}
