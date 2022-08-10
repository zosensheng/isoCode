package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * A number of monetary units specified in an active currency where the unit of currency is explicit and compliant with ISO 4217.
 *
 * <p>ActiveCurrencyAndAmount complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="ActiveCurrencyAndAmount">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>ActiveCurrencyAndAmount_SimpleType">
 *       &lt;attribute name="Ccy" use="required" type="{}ActiveCurrencyCode" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveCurrencyAndAmount", propOrder = {
        "value"
})
public class ActiveCurrencyAndAmount {

    @XmlValue
    protected BigDecimal value;
    @XmlAttribute(name = "Ccy", required = true)
    protected String ccy;

    /**
     * ��ȡvalue���Ե�ֵ��
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * ����value���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /**
     * ��ȡccy���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getCcy() {
        return ccy;
    }

    /**
     * ����ccy���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCcy(String value) {
        this.ccy = value;
    }

    /**
     * The currency code must be a valid active currency code, not yet withdrawn on the day the
     * message containing the currency is exchanged. Valid active currency codes are registered with
     * the ISO 4217 Maintenance Agency, consist of three (3) contiguous letters, and are not yet
     * withdrawn on the day the message containing the Currency is exchanged. (Algorithm)
     *
     * @return C1规则检查
     */
    public String checkC1() {
        String resultC1 = "";
        if (JudgeUtils.isNotNull(this.getCcy())){
            if (!ruleC1(this.ccy)) {
                resultC1 = resultC1 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C1_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C1_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C1_ERROR_TEXT;
                return resultC1;
            }
        }

        return resultC1;
    }

    /**
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回C1检查结果
     */
    private static boolean ruleC1(String str) {
        //通过正则表达式判断
        boolean c1 = str.matches("^[a-zA-Z]{3}$");
        return c1;
    }

    /**
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     *
     * @return C10规则检查
     */
    public String checkC10() {
        String resultC10 = "";

        if (JudgeUtils.isNotNull(this.getValue())){
            boolean ruleC10 = ruleC10(this.value);
            if (!ruleC10) {
                resultC10 = resultC10 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C10_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C10_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C10_ERROR_TEXT;
                return resultC10;
            }

        }
        return resultC10;
    }

    /**
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回C10检查结果
     */
    private static boolean ruleC10(BigDecimal bigDecimal) {
        int big = bigDecimal.intValue();
        String bigS = String.valueOf(big);
        int totalDigits = bigS.length();
        int fractionDigits = 0;
        if (bigS.contains(",")) {
            String[] split = bigS.split(",");

            fractionDigits = Integer.parseInt(split[1]);
        }
        if (totalDigits <= 18 && fractionDigits <= 5) {
            return true;
        }
        return false;
    }

}
