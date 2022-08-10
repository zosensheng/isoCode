package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to identify the transactions to be reported.
 * 
 * <p>TransactionType2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TransactionType2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Sts" type="{}EntryStatus1Choice"/>
 *         &lt;element name="CdtDbtInd" type="{}CreditDebitCode"/>
 *         &lt;element name="FlrLmt" type="{}Limit2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionType2", propOrder = {
    "sts",
    "cdtDbtInd",
    "flrLmt"
})
public class TransactionType2 {

    @XmlElement(name = "Sts", required = true)
    protected EntryStatus1Choice sts;
    @XmlElement(name = "CdtDbtInd", required = true)
    @XmlSchemaType(name = "string")
    protected CreditDebitCode cdtDbtInd;
    @XmlElement(name = "FlrLmt")
    protected List<Limit2> flrLmt;

    /**
     * ��ȡsts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link EntryStatus1Choice }
     *     
     */
    public EntryStatus1Choice getSts() {
        return sts;
    }

    /**
     * ����sts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link EntryStatus1Choice }
     *     
     */
    public void setSts(EntryStatus1Choice value) {
        this.sts = value;
    }

    /**
     * ��ȡcdtDbtInd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CreditDebitCode }
     *     
     */
    public CreditDebitCode getCdtDbtInd() {
        return cdtDbtInd;
    }

    /**
     * ����cdtDbtInd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CreditDebitCode }
     *     
     */
    public void setCdtDbtInd(CreditDebitCode value) {
        this.cdtDbtInd = value;
    }

    /**
     * Gets the value of the flrLmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flrLmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlrLmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Limit2 }
     * 
     * 
     */
    public List<Limit2> getFlrLmt() {
        if (flrLmt == null) {
            flrLmt = new ArrayList<Limit2>();
        }
        return this.flrLmt;
    }

}
