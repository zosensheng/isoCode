package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information related to a proxy  identification of the account.
 * 
 * <p>ProxyAccountIdentification1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ProxyAccountIdentification1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Tp" type="{}ProxyAccountType1Choice" minOccurs="0"/>
 *         &lt;element name="Id" type="{}Max2048Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProxyAccountIdentification1", propOrder = {
    "tp",
    "id"
})
public class ProxyAccountIdentification1 {

    @XmlElement(name = "Tp")
    protected ProxyAccountType1Choice tp;
    @XmlElement(name = "Id", required = true)
    protected String id;

    /**
     * ��ȡtp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ProxyAccountType1Choice }
     *     
     */
    public ProxyAccountType1Choice getTp() {
        return tp;
    }

    /**
     * ����tp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ProxyAccountType1Choice }
     *     
     */
    public void setTp(ProxyAccountType1Choice value) {
        this.tp = value;
    }

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

}
