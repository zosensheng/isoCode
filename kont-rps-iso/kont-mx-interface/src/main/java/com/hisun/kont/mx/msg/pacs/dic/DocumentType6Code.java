package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DocumentType6Code�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentType6Code">
 *   &lt;restriction base="{http:
 *     &lt;enumeration value="MSIN"/>
 *     &lt;enumeration value="CNFA"/>
 *     &lt;enumeration value="DNFA"/>
 *     &lt;enumeration value="CINV"/>
 *     &lt;enumeration value="CREN"/>
 *     &lt;enumeration value="DEBN"/>
 *     &lt;enumeration value="HIRI"/>
 *     &lt;enumeration value="SBIN"/>
 *     &lt;enumeration value="CMCN"/>
 *     &lt;enumeration value="SOAC"/>
 *     &lt;enumeration value="DISP"/>
 *     &lt;enumeration value="BOLD"/>
 *     &lt;enumeration value="VCHR"/>
 *     &lt;enumeration value="AROI"/>
 *     &lt;enumeration value="TSUT"/>
 *     &lt;enumeration value="PUOR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocumentType6Code")
@XmlEnum
public enum DocumentType6Code {


    /**
     * Document is an invoice claiming payment for the supply of metered services, for example gas or electricity supplied to a fixed meter.
     * 
     */
    MSIN,

    /**
     * Document is a credit note for the final amount settled for a commercial transaction.
     * 
     */
    CNFA,

    /**
     * Document is a debit note for the final amount settled for a commercial transaction.
     * 
     */
    DNFA,

    /**
     * Document is an invoice.
     * 
     */
    CINV,

    /**
     * Document is a credit note.
     * 
     */
    CREN,

    /**
     * Document is a debit note.
     * 
     */
    DEBN,

    /**
     * Document is an invoice for the hiring of human resources or renting goods or equipment.
     * 
     */
    HIRI,

    /**
     * Document is an invoice issued by the debtor.
     * 
     */
    SBIN,

    /**
     * Document is an agreement between the parties, stipulating the terms and conditions of the delivery of goods or services.
     * 
     */
    CMCN,

    /**
     * Document is a statement of the transactions posted to the debtor's account at the supplier.
     * 
     */
    SOAC,

    /**
     * Document is a dispatch advice.
     * 
     */
    DISP,

    /**
     * Document is a shipping notice.
     * 
     */
    BOLD,

    /**
     * Document is an electronic payment document.
     * 
     */
    VCHR,

    /**
     * Document is a payment that applies to a specific source document.
     * 
     */
    AROI,

    /**
     * Document is a transaction identifier as assigned by the Trade Services Utility.
     * 
     */
    TSUT,

    /**
     * Document is a purchase order.
     * 
     */
    PUOR;

    public String value() {
        return name();
    }

    public static DocumentType6Code fromValue(String v) {
        return valueOf(v);
    }

}
