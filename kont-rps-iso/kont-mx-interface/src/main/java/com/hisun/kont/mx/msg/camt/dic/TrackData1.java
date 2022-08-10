package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Magnetic track or equivalent payment card data.
 * 
 * <p>TrackData1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TrackData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="TrckNb" type="{}Exact1NumericText" minOccurs="0"/>
 *         &lt;element name="TrckVal" type="{}Max140Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackData1", propOrder = {
    "trckNb",
    "trckVal"
})
public class TrackData1 {

    @XmlElement(name = "TrckNb")
    protected String trckNb;
    @XmlElement(name = "TrckVal", required = true)
    protected String trckVal;

    /**
     * ��ȡtrckNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckNb() {
        return trckNb;
    }

    /**
     * ����trckNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckNb(String value) {
        this.trckNb = value;
    }

    /**
     * ��ȡtrckVal���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrckVal() {
        return trckVal;
    }

    /**
     * ����trckVal���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrckVal(String value) {
        this.trckVal = value;
    }

}
