package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Entity requiring the regulatory reporting information.
 *
 * <p>RegulatoryAuthority2 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="RegulatoryAuthority2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Nm" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="Ctry" type="{}CountryCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegulatoryAuthority2", propOrder = {
        "nm",
        "ctry"
})
public class RegulatoryAuthority2 {

    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "Ctry")
    protected String ctry;

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
     * ��ȡctry���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getCtry() {
        return ctry;
    }

    /**
     * ����ctry���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCtry(String value) {
        this.ctry = value;
    }

    /**
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     *
     * @return C9规则检查
     */
    public String checkC9() {
        String resultC9 = "";
        if (JudgeUtils.isNotNull(this.getCtry())) {
            if (!ruleC9(this.ctry)) {
                resultC9 = resultC9 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_TEXT;
                return resultC9;
            }
        }
        return resultC9;
    }

    /**
     * @return 判断C9规则
     */
    private static boolean ruleC9(String str) {
        //通过正则表达式判断
        boolean c9 = str.matches("^[a-zA-Z]{2}$");
        return c9;
    }
}
