package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of elements used to provide summary information on entries.
 * 
 * <p>TotalTransactions6 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TotalTransactions6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="TtlNtries" type="{}NumberAndSumOfTransactions4" minOccurs="0"/>
 *         &lt;element name="TtlCdtNtries" type="{}NumberAndSumOfTransactions1" minOccurs="0"/>
 *         &lt;element name="TtlDbtNtries" type="{}NumberAndSumOfTransactions1" minOccurs="0"/>
 *         &lt;element name="TtlNtriesPerBkTxCd" type="{}TotalsPerBankTransactionCode5" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalTransactions6", propOrder = {
    "ttlNtries",
    "ttlCdtNtries",
    "ttlDbtNtries",
    "ttlNtriesPerBkTxCd"
})
public class TotalTransactions6 {

    @XmlElement(name = "TtlNtries")
    protected NumberAndSumOfTransactions4 ttlNtries;
    @XmlElement(name = "TtlCdtNtries")
    protected NumberAndSumOfTransactions1 ttlCdtNtries;
    @XmlElement(name = "TtlDbtNtries")
    protected NumberAndSumOfTransactions1 ttlDbtNtries;
    @XmlElement(name = "TtlNtriesPerBkTxCd")
    protected List<TotalsPerBankTransactionCode5> ttlNtriesPerBkTxCd;

    /**
     * ��ȡttlNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions4 }
     *     
     */
    public NumberAndSumOfTransactions4 getTtlNtries() {
        return ttlNtries;
    }

    /**
     * ����ttlNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions4 }
     *     
     */
    public void setTtlNtries(NumberAndSumOfTransactions4 value) {
        this.ttlNtries = value;
    }

    /**
     * ��ȡttlCdtNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getTtlCdtNtries() {
        return ttlCdtNtries;
    }

    /**
     * ����ttlCdtNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setTtlCdtNtries(NumberAndSumOfTransactions1 value) {
        this.ttlCdtNtries = value;
    }

    /**
     * ��ȡttlDbtNtries���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getTtlDbtNtries() {
        return ttlDbtNtries;
    }

    /**
     * ����ttlDbtNtries���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setTtlDbtNtries(NumberAndSumOfTransactions1 value) {
        this.ttlDbtNtries = value;
    }

    /**
     * Gets the value of the ttlNtriesPerBkTxCd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ttlNtriesPerBkTxCd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTtlNtriesPerBkTxCd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalsPerBankTransactionCode5 }
     * 
     * 
     */
    public List<TotalsPerBankTransactionCode5> getTtlNtriesPerBkTxCd() {
        if (ttlNtriesPerBkTxCd == null) {
            ttlNtriesPerBkTxCd = new ArrayList<TotalsPerBankTransactionCode5>();
        }
        return this.ttlNtriesPerBkTxCd;
    }

}
