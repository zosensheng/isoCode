package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>MandateRelatedData2Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MandateRelatedData2Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="DrctDbtMndt" type="{}MandateRelatedInformation15" minOccurs="0"/>
 *         &lt;element name="CdtTrfMndt" type="{}CreditTransferMandateData1" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateRelatedData2Choice", propOrder = {
    "drctDbtMndt",
    "cdtTrfMndt"
})
public class MandateRelatedData2Choice {

    @XmlElement(name = "DrctDbtMndt")
    protected MandateRelatedInformation15 drctDbtMndt;
    @XmlElement(name = "CdtTrfMndt")
    protected CreditTransferMandateData1 cdtTrfMndt;

    /**
     * ��ȡdrctDbtMndt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedInformation15 }
     *     
     */
    public MandateRelatedInformation15 getDrctDbtMndt() {
        return drctDbtMndt;
    }

    /**
     * ����drctDbtMndt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedInformation15 }
     *     
     */
    public void setDrctDbtMndt(MandateRelatedInformation15 value) {
        this.drctDbtMndt = value;
    }

    /**
     * ��ȡcdtTrfMndt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public CreditTransferMandateData1 getCdtTrfMndt() {
        return cdtTrfMndt;
    }

    /**
     * ����cdtTrfMndt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditTransferMandateData1 }
     *     
     */
    public void setCdtTrfMndt(CreditTransferMandateData1 value) {
        this.cdtTrfMndt = value;
    }

}
