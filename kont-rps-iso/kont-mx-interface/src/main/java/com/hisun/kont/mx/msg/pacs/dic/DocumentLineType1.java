package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the type of the document line identification.
 * 
 * <p>DocumentLineType1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DocumentLineType1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="CdOrPrtry" type="{}DocumentLineType1Choice"/>
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
@XmlType(name = "DocumentLineType1", propOrder = {
    "cdOrPrtry",
    "issr"
})
public class DocumentLineType1 {

    @XmlElement(name = "CdOrPrtry", required = true)
    protected DocumentLineType1Choice cdOrPrtry;
    @XmlElement(name = "Issr")
    protected String issr;

    /**
     * ��ȡcdOrPrtry���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DocumentLineType1Choice }
     *     
     */
    public DocumentLineType1Choice getCdOrPrtry() {
        return cdOrPrtry;
    }

    /**
     * ����cdOrPrtry���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentLineType1Choice }
     *     
     */
    public void setCdOrPrtry(DocumentLineType1Choice value) {
        this.cdOrPrtry = value;
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
