package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An event determined by a corporation's board of directors, that changes the existing corporate capital structure or financial condition.
 * 
 * <p>CorporateAction9 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="CorporateAction9">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="EvtTp" type="{}Max35Text"/>
 *         &lt;element name="EvtId" type="{}Max35Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorporateAction9", propOrder = {
    "evtTp",
    "evtId"
})
public class CorporateAction9 {

    @XmlElement(name = "EvtTp", required = true)
    protected String evtTp;
    @XmlElement(name = "EvtId", required = true)
    protected String evtId;

    /**
     * ��ȡevtTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtTp() {
        return evtTp;
    }

    /**
     * ����evtTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtTp(String value) {
        this.evtTp = value;
    }

    /**
     * ��ȡevtId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvtId() {
        return evtId;
    }

    /**
     * ����evtId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvtId(String value) {
        this.evtId = value;
    }

}
