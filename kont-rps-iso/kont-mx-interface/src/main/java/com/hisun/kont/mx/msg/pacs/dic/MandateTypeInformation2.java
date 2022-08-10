package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to further detail the information related to the type of payment.
 * 
 * <p>MandateTypeInformation2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MandateTypeInformation2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="SvcLvl" type="{}ServiceLevel8Choice" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{}CategoryPurpose1Choice" minOccurs="0"/>
 *         &lt;element name="Clssfctn" type="{}MandateClassification1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MandateTypeInformation2", propOrder = {
    "svcLvl",
    "lclInstrm",
    "ctgyPurp",
    "clssfctn"
})
public class MandateTypeInformation2 {

    @XmlElement(name = "SvcLvl")
    protected ServiceLevel8Choice svcLvl;
    @XmlElement(name = "LclInstrm")
    protected LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "CtgyPurp")
    protected CategoryPurpose1Choice ctgyPurp;
    @XmlElement(name = "Clssfctn")
    protected MandateClassification1Choice clssfctn;

    /**
     * ��ȡsvcLvl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ServiceLevel8Choice }
     *     
     */
    public ServiceLevel8Choice getSvcLvl() {
        return svcLvl;
    }

    /**
     * ����svcLvl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceLevel8Choice }
     *     
     */
    public void setSvcLvl(ServiceLevel8Choice value) {
        this.svcLvl = value;
    }

    /**
     * ��ȡlclInstrm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public LocalInstrument2Choice getLclInstrm() {
        return lclInstrm;
    }

    /**
     * ����lclInstrm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link LocalInstrument2Choice }
     *     
     */
    public void setLclInstrm(LocalInstrument2Choice value) {
        this.lclInstrm = value;
    }

    /**
     * ��ȡctgyPurp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CategoryPurpose1Choice }
     *     
     */
    public CategoryPurpose1Choice getCtgyPurp() {
        return ctgyPurp;
    }

    /**
     * ����ctgyPurp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryPurpose1Choice }
     *     
     */
    public void setCtgyPurp(CategoryPurpose1Choice value) {
        this.ctgyPurp = value;
    }

    /**
     * ��ȡclssfctn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MandateClassification1Choice }
     *     
     */
    public MandateClassification1Choice getClssfctn() {
        return clssfctn;
    }

    /**
     * ����clssfctn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MandateClassification1Choice }
     *     
     */
    public void setClssfctn(MandateClassification1Choice value) {
        this.clssfctn = value;
    }

}
