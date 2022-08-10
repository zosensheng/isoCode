package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details to identify a financial institution.
 * 
 * <p>FinancialInstitutionIdentification18 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification18">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="BICFI" type="{}BICFIDec2014Identifier" minOccurs="0"/>
 *         &lt;element name="ClrSysMmbId" type="{}ClearingSystemMemberIdentification2" minOccurs="0"/>
 *         &lt;element name="LEI" type="{}LEIIdentifier" minOccurs="0"/>
 *         &lt;element name="Nm" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="PstlAdr" type="{}PostalAddress24" minOccurs="0"/>
 *         &lt;element name="Othr" type="{}GenericFinancialIdentification1" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification18", propOrder = {
    "bicfi",
    "clrSysMmbId",
    "lei",
    "nm",
    "pstlAdr",
    "othr"
})
public class FinancialInstitutionIdentification18 {

    @XmlElement(name = "BICFI")
    protected String bicfi;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification2 clrSysMmbId;
    @XmlElement(name = "LEI")
    protected String lei;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PstlAdr")
    protected PostalAddress24 pstlAdr;
    @XmlElement(name = "Othr")
    protected GenericFinancialIdentification1 othr;

    /**
     * ��ȡbicfi���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICFI() {
        return bicfi;
    }

    /**
     * ����bicfi���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICFI(String value) {
        this.bicfi = value;
    }

    /**
     * ��ȡclrSysMmbId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemMemberIdentification2 }
     *     
     */
    public ClearingSystemMemberIdentification2 getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * ����clrSysMmbId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemMemberIdentification2 }
     *     
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification2 value) {
        this.clrSysMmbId = value;
    }

    /**
     * ��ȡlei���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLEI() {
        return lei;
    }

    /**
     * ����lei���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLEI(String value) {
        this.lei = value;
    }

    /**
     * ��ȡnm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNm() {
        return nm;
    }

    /**
     * ����nm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNm(String value) {
        this.nm = value;
    }

    /**
     * ��ȡpstlAdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PostalAddress24 }
     *     
     */
    public PostalAddress24 getPstlAdr() {
        return pstlAdr;
    }

    /**
     * ����pstlAdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PostalAddress24 }
     *     
     */
    public void setPstlAdr(PostalAddress24 value) {
        this.pstlAdr = value;
    }

    /**
     * ��ȡothr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GenericFinancialIdentification1 }
     *     
     */
    public GenericFinancialIdentification1 getOthr() {
        return othr;
    }

    /**
     * ����othr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GenericFinancialIdentification1 }
     *     
     */
    public void setOthr(GenericFinancialIdentification1 value) {
        this.othr = value;
    }

}
