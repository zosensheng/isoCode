package com.hisun.kont.mx.msg.pacs;


import com.hisun.kont.mx.msg.pacs.dic.FIToFIPaymentStatusReportV12;

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
 *         &lt;element name="FIToFIPmtStsRpt" type="{}FIToFIPaymentStatusReportV12"/>
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
    "fiToFIPmtStsRpt"
})
public class Document {

    @XmlElement(name = "FIToFIPmtStsRpt", required = true)
    protected FIToFIPaymentStatusReportV12 fiToFIPmtStsRpt;

    /**
     * ��ȡfiToFIPmtStsRpt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FIToFIPaymentStatusReportV12 }
     *     
     */
    public FIToFIPaymentStatusReportV12 getFIToFIPmtStsRpt() {
        return fiToFIPmtStsRpt;
    }

    /**
     * ����fiToFIPmtStsRpt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFIPaymentStatusReportV12 }
     *     
     */
    public void setFIToFIPmtStsRpt(FIToFIPaymentStatusReportV12 value) {
        this.fiToFIPmtStsRpt = value;
    }

}
