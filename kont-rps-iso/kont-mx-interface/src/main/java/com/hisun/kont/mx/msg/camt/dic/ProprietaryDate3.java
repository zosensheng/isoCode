package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to identify a proprietary date.
 * 
 * <p>ProprietaryDate3 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ProprietaryDate3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}Max35Text"/>
 *         &lt;element name="Dt" type="{}DateAndDateTime2Choice"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProprietaryDate3", propOrder = {
    "tp",
    "dt"
})
public class ProprietaryDate3 {

    @XmlElement(name = "Tp", required = true)
    protected String tp;
    @XmlElement(name = "Dt", required = true)
    protected DateAndDateTime2Choice dt;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTp(String value) {
        this.tp = value;
    }

    /**
     * ��ȡdt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public DateAndDateTime2Choice getDt() {
        return dt;
    }

    /**
     * ����dt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DateAndDateTime2Choice }
     *     
     */
    public void setDt(DateAndDateTime2Choice value) {
        this.dt = value;
    }

}
