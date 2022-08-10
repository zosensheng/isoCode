package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.mx.msg.pacs.dic.FinancialInstitutionDirectDebitV05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Document complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIDrctDbt" type="{}FinancialInstitutionDirectDebitV05"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document002", propOrder = {
    "fiDrctDbt"
})
public class Document010 {

    @XmlElement(name = "FIDrctDbt", required = true)
    protected FinancialInstitutionDirectDebitV05 fiDrctDbt;

    /**
     * ��ȡfiDrctDbt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionDirectDebitV05 }
     *     
     */
    public FinancialInstitutionDirectDebitV05 getFIDrctDbt() {
        return fiDrctDbt;
    }

    /**
     * ����fiDrctDbt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionDirectDebitV05 }
     *     
     */
    public void setFIDrctDbt(FinancialInstitutionDirectDebitV05 value) {
        this.fiDrctDbt = value;
    }

}
