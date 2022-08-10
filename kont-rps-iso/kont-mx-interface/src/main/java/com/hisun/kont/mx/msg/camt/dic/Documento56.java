package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Document053 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Document053">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFIPmtCxlReq" type="{}FIToFIPaymentCancellationRequestV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document053", propOrder = {
    "fiToFIPmtCxlReq"
})
public class Documento56 {

    @XmlElement(name = "FIToFIPmtCxlReq", required = true)
    protected FIToFIPaymentCancellationRequestV10 fiToFIPmtCxlReq;

    /**
     * ��ȡfiToFIPmtCxlReq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link FIToFIPaymentCancellationRequestV10 }
     *     
     */
    public FIToFIPaymentCancellationRequestV10 getFIToFIPmtCxlReq() {
        return fiToFIPmtCxlReq;
    }

    /**
     * ����fiToFIPmtCxlReq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link FIToFIPaymentCancellationRequestV10 }
     *     
     */
    public void setFIToFIPmtCxlReq(FIToFIPaymentCancellationRequestV10 value) {
        this.fiToFIPmtCxlReq = value;
    }

}
