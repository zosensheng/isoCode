package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Account to or from which a securities entry is made.
 * 
 * <p>SecuritiesAccount19 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SecuritiesAccount19">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Id" type="{}Max35Text"/>
 *         &lt;element name="Tp" type="{}GenericIdentification30" minOccurs="0"/>
 *         &lt;element name="Nm" type="{}Max70Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecuritiesAccount19", propOrder = {
    "id",
    "tp",
    "nm"
})
public class SecuritiesAccount19 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Tp")
    protected GenericIdentification30 tp;
    @XmlElement(name = "Nm")
    protected String nm;

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
     *     {@link GenericIdentification30 }
     *     
     */
    public GenericIdentification30 getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIdentification30 }
     *     
     */
    public void setTp(GenericIdentification30 value) {
        this.tp = value;
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

}
