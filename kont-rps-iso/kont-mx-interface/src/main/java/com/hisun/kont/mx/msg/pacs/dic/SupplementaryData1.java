package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Additional information that can not be captured in the structured fields and/or any other specific block.
 * 
 * <p>SupplementaryData1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SupplementaryData1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="PlcAndNm" type="{}Max350Text" minOccurs="0"/>
 *         &lt;element name="Envlp" type="{}SupplementaryDataEnvelope1"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SupplementaryData1", propOrder = {
    "plcAndNm",
    "envlp"
})
public class SupplementaryData1 {

    @XmlElement(name = "PlcAndNm")
    protected String plcAndNm;
    @XmlElement(name = "Envlp", required = true)
    protected SupplementaryDataEnvelope1 envlp;

    /**
     * ��ȡplcAndNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlcAndNm() {
        return plcAndNm;
    }

    /**
     * ����plcAndNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlcAndNm(String value) {
        this.plcAndNm = value;
    }

    /**
     * ��ȡenvlp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SupplementaryDataEnvelope1 }
     *     
     */
    public SupplementaryDataEnvelope1 getEnvlp() {
        return envlp;
    }

    /**
     * ����envlp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SupplementaryDataEnvelope1 }
     *     
     */
    public void setEnvlp(SupplementaryDataEnvelope1 value) {
        this.envlp = value;
    }

}
