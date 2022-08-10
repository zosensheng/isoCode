package com.hisun.kont.mx.msg.pacs.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the details of the contact person.
 * 
 * <p>Contact4 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Contact4">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="NmPrfx" type="{}NamePrefix2Code" minOccurs="0"/>
 *         &lt;element name="Nm" type="{}Max140Text" minOccurs="0"/>
 *         &lt;element name="PhneNb" type="{}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="MobNb" type="{}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="FaxNb" type="{}PhoneNumber" minOccurs="0"/>
 *         &lt;element name="EmailAdr" type="{}Max2048Text" minOccurs="0"/>
 *         &lt;element name="EmailPurp" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="JobTitl" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Rspnsblty" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Dept" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="Othr" type="{}OtherContact1" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PrefrdMtd" type="{}PreferredContactMethod1Code" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contact4", propOrder = {
    "nmPrfx",
    "nm",
    "phneNb",
    "mobNb",
    "faxNb",
    "emailAdr",
    "emailPurp",
    "jobTitl",
    "rspnsblty",
    "dept",
    "othr",
    "prefrdMtd"
})
public class Contact4 {

    @XmlElement(name = "NmPrfx")
    @XmlSchemaType(name = "string")
    protected NamePrefix2Code nmPrfx;
    @XmlElement(name = "Nm")
    protected String nm;
    @XmlElement(name = "PhneNb")
    protected String phneNb;
    @XmlElement(name = "MobNb")
    protected String mobNb;
    @XmlElement(name = "FaxNb")
    protected String faxNb;
    @XmlElement(name = "EmailAdr")
    protected String emailAdr;
    @XmlElement(name = "EmailPurp")
    protected String emailPurp;
    @XmlElement(name = "JobTitl")
    protected String jobTitl;
    @XmlElement(name = "Rspnsblty")
    protected String rspnsblty;
    @XmlElement(name = "Dept")
    protected String dept;
    @XmlElement(name = "Othr")
    protected List<OtherContact1> othr;
    @XmlElement(name = "PrefrdMtd")
    @XmlSchemaType(name = "string")
    protected PreferredContactMethod1Code prefrdMtd;

    /**
     * ��ȡnmPrfx���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NamePrefix2Code }
     *     
     */
    public NamePrefix2Code getNmPrfx() {
        return nmPrfx;
    }

    /**
     * ����nmPrfx���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NamePrefix2Code }
     *     
     */
    public void setNmPrfx(NamePrefix2Code value) {
        this.nmPrfx = value;
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
     * ��ȡphneNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhneNb() {
        return phneNb;
    }

    /**
     * ����phneNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhneNb(String value) {
        this.phneNb = value;
    }

    /**
     * ��ȡmobNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobNb() {
        return mobNb;
    }

    /**
     * ����mobNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobNb(String value) {
        this.mobNb = value;
    }

    /**
     * ��ȡfaxNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNb() {
        return faxNb;
    }

    /**
     * ����faxNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNb(String value) {
        this.faxNb = value;
    }

    /**
     * ��ȡemailAdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAdr() {
        return emailAdr;
    }

    /**
     * ����emailAdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAdr(String value) {
        this.emailAdr = value;
    }

    /**
     * ��ȡemailPurp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailPurp() {
        return emailPurp;
    }

    /**
     * ����emailPurp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailPurp(String value) {
        this.emailPurp = value;
    }

    /**
     * ��ȡjobTitl���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobTitl() {
        return jobTitl;
    }

    /**
     * ����jobTitl���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobTitl(String value) {
        this.jobTitl = value;
    }

    /**
     * ��ȡrspnsblty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRspnsblty() {
        return rspnsblty;
    }

    /**
     * ����rspnsblty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRspnsblty(String value) {
        this.rspnsblty = value;
    }

    /**
     * ��ȡdept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDept() {
        return dept;
    }

    /**
     * ����dept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDept(String value) {
        this.dept = value;
    }

    /**
     * Gets the value of the othr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the othr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOthr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OtherContact1 }
     * 
     * 
     */
    public List<OtherContact1> getOthr() {
        if (othr == null) {
            othr = new ArrayList<OtherContact1>();
        }
        return this.othr;
    }

    /**
     * ��ȡprefrdMtd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public PreferredContactMethod1Code getPrefrdMtd() {
        return prefrdMtd;
    }

    /**
     * ����prefrdMtd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PreferredContactMethod1Code }
     *     
     */
    public void setPrefrdMtd(PreferredContactMethod1Code value) {
        this.prefrdMtd = value;
    }

}
