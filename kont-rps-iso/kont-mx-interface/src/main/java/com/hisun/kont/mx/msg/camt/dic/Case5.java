package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Case5 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Case5">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="Cretr" type="{}Party40Choice"/>
 *         &lt;element name="ReopCaseIndctn" type="{}YesNoIndicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Case5", propOrder = {
    "id",
    "cretr",
    "reopCaseIndctn"
})
public class Case5 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Cretr", required = true)
    protected Party40Choice cretr;
    @XmlElement(name = "ReopCaseIndctn")
    protected Boolean reopCaseIndctn;

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ��ȡcretr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Party40Choice }
     *     
     */
    public Party40Choice getCretr() {
        return cretr;
    }

    /**
     * ����cretr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Party40Choice }
     *     
     */
    public void setCretr(Party40Choice value) {
        this.cretr = value;
    }

    /**
     * ��ȡreopCaseIndctn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReopCaseIndctn() {
        return reopCaseIndctn;
    }

    /**
     * ����reopCaseIndctn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReopCaseIndctn(Boolean value) {
        this.reopCaseIndctn = value;
    }

}
