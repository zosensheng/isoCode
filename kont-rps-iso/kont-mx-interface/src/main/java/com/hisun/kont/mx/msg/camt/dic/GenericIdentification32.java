package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Identification of an entity.
 * 
 * <p>GenericIdentification32 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="GenericIdentification32">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="Tp" type="{}PartyType3Code" minOccurs="0"/>
 *         &lt;element name="Issr" type="{}PartyType4Code" minOccurs="0"/>
 *         &lt;element name="ShrtNm" type="{}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericIdentification32", propOrder = {
    "id",
    "tp",
    "issr",
    "shrtNm"
})
public class GenericIdentification32 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Tp")
    @XmlSchemaType(name = "string")
    protected PartyType3Code tp;
    @XmlElement(name = "Issr")
    @XmlSchemaType(name = "string")
    protected PartyType4Code issr;
    @XmlElement(name = "ShrtNm")
    protected String shrtNm;

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
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PartyType3Code }
     *     
     */
    public PartyType3Code getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType3Code }
     *     
     */
    public void setTp(PartyType3Code value) {
        this.tp = value;
    }

    /**
     * ��ȡissr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link PartyType4Code }
     *     
     */
    public PartyType4Code getIssr() {
        return issr;
    }

    /**
     * ����issr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType4Code }
     *     
     */
    public void setIssr(PartyType4Code value) {
        this.issr = value;
    }

    /**
     * ��ȡshrtNm���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShrtNm() {
        return shrtNm;
    }

    /**
     * ����shrtNm���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShrtNm(String value) {
        this.shrtNm = value;
    }

}
