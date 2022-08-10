package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Information needed due to regulatory and statutory requirements.
 *
 * <p>StructuredRegulatoryReporting3 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="StructuredRegulatoryReporting3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Dt" type="{}ISODate" minOccurs="0"/>
 *         &lt;element name="Ctry" type="{}CountryCode" minOccurs="0"/>
 *         &lt;element name="Cd" type="{}Max10Text" minOccurs="0"/>
 *         &lt;element name="Amt" type="{}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="Inf" type="{}Max35Text" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRegulatoryReporting3", propOrder = {
        "tp",
        "dt",
        "ctry",
        "cd",
        "amt",
        "inf"
})
public class StructuredRegulatoryReporting3 {

    @XmlElement(name = "Tp")
    protected String tp;
    @XmlElement(name = "Dt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dt;
    @XmlElement(name = "Ctry")
    protected String ctry;
    @XmlElement(name = "Cd")
    protected String cd;
    @XmlElement(name = "Amt")
    protected ActiveOrHistoricCurrencyAndAmount amt;
    @XmlElement(name = "Inf")
    protected List<String> inf;

    /**
     * ��ȡtp���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTp(String value) {
        this.tp = value;
    }

    /**
     * ��ȡdt���Ե�ֵ��
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDt() {
        return dt;
    }

    /**
     * ����dt���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDt(XMLGregorianCalendar value) {
        this.dt = value;
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
     * ��ȡcd���Ե�ֵ��
     *
     * @return possible object is
     * {@link String }
     */
    public String getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCd(String value) {
        this.cd = value;
    }

    /**
     * ��ȡamt���Ե�ֵ��
     *
     * @return possible object is
     * {@link ActiveOrHistoricCurrencyAndAmount }
     */
    public ActiveOrHistoricCurrencyAndAmount getAmt() {
        return amt;
    }

    /**
     * ����amt���Ե�ֵ��
     *
     * @param value allowed object is
     *              {@link ActiveOrHistoricCurrencyAndAmount }
     */
    public void setAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.amt = value;
    }

    /**
     * Gets the value of the inf property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inf property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInf().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getInf() {
        if (inf == null) {
            inf = new ArrayList<String>();
        }
        return this.inf;
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
