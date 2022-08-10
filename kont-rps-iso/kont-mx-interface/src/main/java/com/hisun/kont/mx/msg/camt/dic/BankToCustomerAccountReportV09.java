package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Scope

 * The BankToCustomerAccountReport message is sent by the account servicer to an account owner or to a party authorised by the account owner to receive the message. It can be used to inform the account owner, or authorised party, of the entries reported to the account, and/or to provide the owner with balance information on the account at a given point in time.

 * Usage

 * The BankToCustomerAccountReport message can contain reports for more than one account. It provides information for cash management and/or reconciliation. It can be used to:

 * - report pending and booked items;

 * - provide balance information.

 * It can include underlying details of transactions that have been included in the entry.

 * It is possible that the receiver of the message is not the account owner, but a party entitled by the account owner to receive the account information (also known as recipient).

 * For a statement, the Bank-to-Customer Account Statement message should be used.
 * 
 * <p>BankToCustomerAccountReportV09 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="BankToCustomerAccountReportV09">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{}GroupHeader81"/>
 *         &lt;element name="Rpt" type="{}AccountReport30" maxOccurs="unbounded"/>
 *         &lt;element name="SplmtryData" type="{}SupplementaryData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankToCustomerAccountReportV09", propOrder = {
    "grpHdr",
    "rpt",
    "splmtryData"
})
public class BankToCustomerAccountReportV09 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader81 grpHdr;
    @XmlElement(name = "Rpt", required = true)
    protected List<AccountReport30> rpt;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡgrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader81 }
     *     
     */
    public GroupHeader81 getGrpHdr() {
        return grpHdr;
    }

    /**
     * ����grpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader81 }
     *     
     */
    public void setGrpHdr(GroupHeader81 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the rpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountReport30 }
     * 
     * 
     */
    public List<AccountReport30> getRpt() {
        if (rpt == null) {
            rpt = new ArrayList<AccountReport30>();
        }
        return this.rpt;
    }

    /**
     * Gets the value of the splmtryData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the splmtryData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSplmtryData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SupplementaryData1 }
     * 
     * 
     */
    public List<SupplementaryData1> getSplmtryData() {
        if (splmtryData == null) {
            splmtryData = new ArrayList<SupplementaryData1>();
        }
        return this.splmtryData;
    }

}
