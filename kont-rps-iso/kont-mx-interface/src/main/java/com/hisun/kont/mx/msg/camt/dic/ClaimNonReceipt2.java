package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ClaimNonReceipt2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClaimNonReceipt2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="DtPrcd" type="{}ISODate"/>
 *         &lt;element name="OrgnlNxtAgt" type="{}BranchAndFinancialInstitutionIdentification6" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimNonReceipt2", propOrder = {
    "dtPrcd",
    "orgnlNxtAgt"
})
public class ClaimNonReceipt2 {

    @XmlElement(name = "DtPrcd", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dtPrcd;
    @XmlElement(name = "OrgnlNxtAgt")
    protected BranchAndFinancialInstitutionIdentification6 orgnlNxtAgt;

    /**
     * ��ȡdtPrcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtPrcd() {
        return dtPrcd;
    }

    /**
     * ����dtPrcd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtPrcd(XMLGregorianCalendar value) {
        this.dtPrcd = value;
    }

    /**
     * ��ȡorgnlNxtAgt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification6 getOrgnlNxtAgt() {
        return orgnlNxtAgt;
    }

    /**
     * ����orgnlNxtAgt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification6 }
     *     
     */
    public void setOrgnlNxtAgt(BranchAndFinancialInstitutionIdentification6 value) {
        this.orgnlNxtAgt = value;
    }

}
