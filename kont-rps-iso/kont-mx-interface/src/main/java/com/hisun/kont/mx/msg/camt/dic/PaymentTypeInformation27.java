package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>PaymentTypeInformation27 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PaymentTypeInformation27">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="InstrPrty" type="{}Priority2Code" minOccurs="0"/>
 *         &lt;element name="ClrChanl" type="{}ClearingChannel2Code" minOccurs="0"/>
 *         &lt;element name="SvcLvl" type="{}ServiceLevel8Choice" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LclInstrm" type="{}LocalInstrument2Choice" minOccurs="0"/>
 *         &lt;element name="SeqTp" type="{}SequenceType3Code" minOccurs="0"/>
 *         &lt;element name="CtgyPurp" type="{}CategoryPurpose1Choice" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTypeInformation27", propOrder = {
    "instrPrty",
    "clrChanl",
    "svcLvl",
    "lclInstrm",
    "seqTp",
    "ctgyPurp"
})
public class PaymentTypeInformation27 {

    @XmlElement(name = "InstrPrty")
    @XmlSchemaType(name = "string")
    protected Priority2Code instrPrty;
    @XmlElement(name = "ClrChanl")
    @XmlSchemaType(name = "string")
    protected ClearingChannel2Code clrChanl;
    @XmlElement(name = "SvcLvl")
    protected List<ServiceLevel8Choice> svcLvl;
    @XmlElement(name = "LclInstrm")
    protected LocalInstrument2Choice lclInstrm;
    @XmlElement(name = "SeqTp")
    @XmlSchemaType(name = "string")
    protected SequenceType3Code seqTp;
    @XmlElement(name = "CtgyPurp")
    protected CategoryPurpose1Choice ctgyPurp;

    /**
     * ��ȡinstrPrty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Priority2Code }
     *     
     */
    public Priority2Code getInstrPrty() {
        return instrPrty;
    }

    /**
     * ����instrPrty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Priority2Code }
     *     
     */
    public void setInstrPrty(Priority2Code value) {
        this.instrPrty = value;
    }

    /**
     * ��ȡclrChanl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public ClearingChannel2Code getClrChanl() {
        return clrChanl;
    }

    /**
     * ����clrChanl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingChannel2Code }
     *     
     */
    public void setClrChanl(ClearingChannel2Code value) {
        this.clrChanl = value;
    }

    /**
     * Gets the value of the svcLvl property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the svcLvl property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSvcLvl().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceLevel8Choice }
     * 
     * 
     */
    public List<ServiceLevel8Choice> getSvcLvl() {
        if (svcLvl == null) {
            svcLvl = new ArrayList<ServiceLevel8Choice>();
        }
        return this.svcLvl;
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
     * ��ȡseqTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link SequenceType3Code }
     *     
     */
    public SequenceType3Code getSeqTp() {
        return seqTp;
    }

    /**
     * ����seqTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceType3Code }
     *     
     */
    public void setSeqTp(SequenceType3Code value) {
        this.seqTp = value;
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

}
