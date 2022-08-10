package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>NotificationToReceiveV07 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="NotificationToReceiveV07">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="GrpHdr" type="{}GroupHeader77"/>
 *         &lt;element name="Ntfctn" type="{}AccountNotification18"/>
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
@XmlType(name = "NotificationToReceiveV07", propOrder = {
    "grpHdr",
    "ntfctn",
    "splmtryData"
})
public class NotificationToReceiveV07 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader77 grpHdr;
    @XmlElement(name = "Ntfctn", required = true)
    protected AccountNotification18 ntfctn;
    @XmlElement(name = "SplmtryData")
    protected List<SupplementaryData1> splmtryData;

    /**
     * ��ȡgrpHdr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader77 }
     *     
     */
    public GroupHeader77 getGrpHdr() {
        return grpHdr;
    }

    /**
     * ����grpHdr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader77 }
     *     
     */
    public void setGrpHdr(GroupHeader77 value) {
        this.grpHdr = value;
    }

    /**
     * ��ȡntfctn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link AccountNotification18 }
     *     
     */
    public AccountNotification18 getNtfctn() {
        return ntfctn;
    }

    /**
     * ����ntfctn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link AccountNotification18 }
     *     
     */
    public void setNtfctn(AccountNotification18 value) {
        this.ntfctn = value;
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
