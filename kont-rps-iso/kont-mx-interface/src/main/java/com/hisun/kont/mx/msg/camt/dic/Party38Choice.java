package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nature or use of the account.
 * 
 * <p>Party38Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Party38Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="OrgId" type="{}OrganisationIdentification29"/>
 *         &lt;element name="PrvtId" type="{}PersonIdentification13"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party38Choice", propOrder = {
    "orgId",
    "prvtId"
})
public class Party38Choice {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentification29 orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification13 prvtId;

    /**
     * ��ȡorgId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentification29 }
     *     
     */
    public OrganisationIdentification29 getOrgId() {
        return orgId;
    }

    /**
     * ����orgId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentification29 }
     *     
     */
    public void setOrgId(OrganisationIdentification29 value) {
        this.orgId = value;
    }

    /**
     * ��ȡprvtId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification13 }
     *     
     */
    public PersonIdentification13 getPrvtId() {
        return prvtId;
    }

    /**
     * ����prvtId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification13 }
     *     
     */
    public void setPrvtId(PersonIdentification13 value) {
        this.prvtId = value;
    }

}
