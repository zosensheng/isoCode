package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Unique and unambiguous way to identify an organisation.
 *
 * <p>OrganisationIdentification29 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="OrganisationIdentification29">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="AnyBIC" type="{}AnyBICDec2014Identifier" minOccurs="0"/>
 *         &lt;element name="LEI" type="{}LEIIdentifier" minOccurs="0"/>
 *         &lt;element name="Othr" type="{}GenericOrganisationIdentification1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationIdentification29", propOrder = {
        "anyBIC",
        "lei",
        "othr"
})
public class OrganisationIdentification29 {

    @XmlElement(name = "AnyBIC")
    protected String anyBIC;
    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "Othr")
    protected List<GenericOrganisationIdentification1> othr;

    /**
     * ��ȡanyBIC���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnyBIC() {
        return anyBIC;
    }

    /**
     * ����anyBIC���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnyBIC(String value) {
        this.anyBIC = value;
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
     * Gets the value of the othr property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthr().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericOrganisationIdentification1 }
     */
    public List<GenericOrganisationIdentification1> getOthr() {
        if (othr == null) {
            othr = new ArrayList<GenericOrganisationIdentification1>();
        }
        return this.othr;
    }

    /**
     * Only a valid Business identifier code is allowed. Business identifier codes for financial or nonfinancial institutions are registered and published by the ISO 9362 Registration Authority in the
     * ISO directory of BICs, and consists of eight (8) or eleven (11) contiguous
     * characters. (Algorithm)
     *
     * @return C3规则检查
     */
    public String checkC3() {
        String resultC3 = "";
        if (JudgeUtils.isNotNull(this.getAnyBIC())){
            if (!ruleC3(this.anyBIC)) {
                resultC3 = resultC3 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C3_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C3_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C3_ERROR_TEXT;
                return resultC3;
            }
        }

        return resultC3;
    }

    /**
     * Format
     * pattern [A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}
     *
     * @return 判断C3规则 符合返回true 不符合返回false
     */
    private static boolean ruleC3(String str) {

        //通过正则表达式进行匹配
        return str.matches("^[a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?$");
    }


}
