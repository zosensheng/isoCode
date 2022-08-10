package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>CategoryPurpose1Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CategoryPurpose1Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Cd" type="{}ExternalCategoryPurpose1Code"/>
 *         &lt;element name="Prtry" type="{}Max35Text"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CategoryPurpose1Choice", propOrder = {
    "cd",
    "prtry"
})
public class CategoryPurpose1Choice {

    @XmlElement(name = "Cd")
    protected String cd;
    @XmlElement(name = "Prtry")
    protected String prtry;

    /**
     * ��ȡcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCd(String value) {
        this.cd = value;
    }

    /**
     * ��ȡprtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtry() {
        return prtry;
    }

    /**
     * ����prtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtry(String value) {
        this.prtry = value;
    }

}
