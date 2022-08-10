package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Identifies the underlying transaction(s) and/or batched entries.
 * 
 * <p>EntryDetails10 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="EntryDetails10">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Btch" type="{}BatchInformation2" minOccurs="0"/>
 *         &lt;element name="TxDtls" type="{}EntryTransaction11" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntryDetails10", propOrder = {
    "btch",
    "txDtls"
})
public class EntryDetails10 {

    @XmlElement(name = "Btch")
    protected BatchInformation2 btch;
    @XmlElement(name = "TxDtls")
    protected List<EntryTransaction11> txDtls;

    /**
     * ��ȡbtch���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BatchInformation2 }
     *     
     */
    public BatchInformation2 getBtch() {
        return btch;
    }

    /**
     * ����btch���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BatchInformation2 }
     *     
     */
    public void setBtch(BatchInformation2 value) {
        this.btch = value;
    }

    /**
     * Gets the value of the txDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntryTransaction11 }
     * 
     * 
     */
    public List<EntryTransaction11> getTxDtls() {
        if (txDtls == null) {
            txDtls = new ArrayList<EntryTransaction11>();
        }
        return this.txDtls;
    }

}
