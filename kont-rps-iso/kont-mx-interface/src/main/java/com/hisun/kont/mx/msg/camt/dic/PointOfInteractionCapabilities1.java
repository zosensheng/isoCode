package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Capabilities of the POI performing the transaction.
 * 
 * <p>PointOfInteractionCapabilities1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="PointOfInteractionCapabilities1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="CardRdngCpblties" type="{}CardDataReading1Code" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CrdhldrVrfctnCpblties" type="{}CardholderVerificationCapability1Code" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OnLineCpblties" type="{}OnLineCapability1Code" minOccurs="0"/>
 *         &lt;element name="DispCpblties" type="{}DisplayCapabilities1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PrtLineWidth" type="{}Max3NumericText" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointOfInteractionCapabilities1", propOrder = {
    "cardRdngCpblties",
    "crdhldrVrfctnCpblties",
    "onLineCpblties",
    "dispCpblties",
    "prtLineWidth"
})
public class PointOfInteractionCapabilities1 {

    @XmlElement(name = "CardRdngCpblties")
    @XmlSchemaType(name = "string")
    protected List<CardDataReading1Code> cardRdngCpblties;
    @XmlElement(name = "CrdhldrVrfctnCpblties")
    @XmlSchemaType(name = "string")
    protected List<CardholderVerificationCapability1Code> crdhldrVrfctnCpblties;
    @XmlElement(name = "OnLineCpblties")
    @XmlSchemaType(name = "string")
    protected OnLineCapability1Code onLineCpblties;
    @XmlElement(name = "DispCpblties")
    protected List<DisplayCapabilities1> dispCpblties;
    @XmlElement(name = "PrtLineWidth")
    protected String prtLineWidth;

    /**
     * Gets the value of the cardRdngCpblties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cardRdngCpblties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCardRdngCpblties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardDataReading1Code }
     * 
     * 
     */
    public List<CardDataReading1Code> getCardRdngCpblties() {
        if (cardRdngCpblties == null) {
            cardRdngCpblties = new ArrayList<CardDataReading1Code>();
        }
        return this.cardRdngCpblties;
    }

    /**
     * Gets the value of the crdhldrVrfctnCpblties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crdhldrVrfctnCpblties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrdhldrVrfctnCpblties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CardholderVerificationCapability1Code }
     * 
     * 
     */
    public List<CardholderVerificationCapability1Code> getCrdhldrVrfctnCpblties() {
        if (crdhldrVrfctnCpblties == null) {
            crdhldrVrfctnCpblties = new ArrayList<CardholderVerificationCapability1Code>();
        }
        return this.crdhldrVrfctnCpblties;
    }

    /**
     * ��ȡonLineCpblties���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OnLineCapability1Code }
     *     
     */
    public OnLineCapability1Code getOnLineCpblties() {
        return onLineCpblties;
    }

    /**
     * ����onLineCpblties���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OnLineCapability1Code }
     *     
     */
    public void setOnLineCpblties(OnLineCapability1Code value) {
        this.onLineCpblties = value;
    }

    /**
     * Gets the value of the dispCpblties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dispCpblties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDispCpblties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DisplayCapabilities1 }
     * 
     * 
     */
    public List<DisplayCapabilities1> getDispCpblties() {
        if (dispCpblties == null) {
            dispCpblties = new ArrayList<DisplayCapabilities1>();
        }
        return this.dispCpblties;
    }

    /**
     * ��ȡprtLineWidth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtLineWidth() {
        return prtLineWidth;
    }

    /**
     * ����prtLineWidth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtLineWidth(String value) {
        this.prtLineWidth = value;
    }

}
