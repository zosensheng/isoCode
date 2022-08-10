package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information related to an identification of an organisation.
 * 
 * <p>GenericOrganisationIdentification1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GenericOrganisationIdentification1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="SchmeNm" type="{}OrganisationIdentificationSchemeName1Choice" minOccurs="0"/>
 *         &lt;element name="Issr" type="{}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericOrganisationIdentification1", propOrder = {
    "id",
    "schmeNm",
    "issr"
})
public class GenericOrganisationIdentification1 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "SchmeNm")
    protected OrganisationIdentificationSchemeName1Choice schmeNm;
    @XmlElement(name = "Issr")
    protected String issr;

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * ��ȡschmeNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentificationSchemeName1Choice }
     *     
     */
    public OrganisationIdentificationSchemeName1Choice getSchmeNm() {
        return schmeNm;
    }

    /**
     * ����schmeNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentificationSchemeName1Choice }
     *     
     */
    public void setSchmeNm(OrganisationIdentificationSchemeName1Choice value) {
        this.schmeNm = value;
    }

    /**
     * ��ȡissr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssr() {
        return issr;
    }

    /**
     * ����issr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssr(String value) {
        this.issr = value;
    }

}
