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
 * A number of monetary units specified in an active or a historic currency where the unit of currency is explicit and compliant with ISO 4217.
 *
 * <p>ActiveOrHistoricCurrencyAndAmount complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="ActiveOrHistoricCurrencyAndAmount">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>ActiveOrHistoricCurrencyAndAmount_SimpleType">
 *       &lt;attribute name="Ccy" use="required" type="{}ActiveOrHistoricCurrencyCode" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActiveOrHistoricCurrencyAndAmount", propOrder = {
        "value"
})
public class ActiveOrHistoricCurrencyAndAmount {

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
    public static boolean ruleC1(String str) {
        //通过正则表达式判断
        boolean c1 = str.matches("^[a-zA-Z]{3}$");
        return c1;
    }


    /**
     * The Currency Code must be registered, or have already been registered. Valid active or historic
     * currency codes are registered with the ISO 4217 Maintenance Agency, consist of three (3)
     * contiguous letters, and may be or not be withdrawn on the day the message containing the
     * Currency is exchanged. (Algorithm)
     *
     * @return C2规则检查
     */
    public String checkC2() {
        String resultC2 = "";
        if (JudgeUtils.isNotNull(this.getCcy())){
            if (!ruleC2(this.ccy)) {
                resultC2 = resultC2 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C2_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C2_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C2_ERROR_TEXT;
                return resultC2;
            }
        }
        return resultC2;
    }

    /**
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回C2检查结果
     */
    public static boolean ruleC2(String str) {
        //通过正则表达式判断
        boolean c2 = str.matches("^[a-zA-Z]{3}$");
        return c2;
    }


    /**
     * The number of fractional digits (or minor unit of currency) must comply with ISO 4217.
     * Note: The decimal separator is a dot. (Algorithm)
     *
     * @return C11规则检查
     */
    public String checkC11() {
        String resultC11 = "";

        if (JudgeUtils.isNotNull(this.getValue())) {
            boolean ruleC11 = ruleC11(this.value);
            if (!ruleC11) {
                resultC11 = resultC11 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C11_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C11_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C11_ERROR_TEXT;
                return resultC11;
            }
        }


        return resultC11;
    }

    /**
     * Format
     * minInclusive 0
     * totalDigits 18
     * fractionDigits 5
     *
     * @return 返回C11检查结果
     */
    private static boolean ruleC11(BigDecimal bigDecimal) {
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
