package com.hisun.kont.mx.msg.pacs.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides information on the remittance advice.
 * 
 * <p>RemittanceLocation7 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="RemittanceLocation7">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="RmtId" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="RmtLctnDtls" type="{}RemittanceLocationData1" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemittanceLocation7", propOrder = {
    "rmtId",
    "rmtLctnDtls"
})
public class RemittanceLocation7 {

    @XmlElement(name = "RmtId")
    protected String rmtId;
    @XmlElement(name = "RmtLctnDtls")
    protected List<RemittanceLocationData1> rmtLctnDtls;

    /**
     * ��ȡrmtId���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRmtId() {
        return rmtId;
    }

    /**
     * ����rmtId���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRmtId(String value) {
        this.rmtId = value;
    }

    /**
     * Gets the value of the rmtLctnDtls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rmtLctnDtls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRmtLctnDtls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemittanceLocationData1 }
     * 
     * 
     */
    public List<RemittanceLocationData1> getRmtLctnDtls() {
        if (rmtLctnDtls == null) {
            rmtLctnDtls = new ArrayList<RemittanceLocationData1>();
        }
        return this.rmtLctnDtls;
    }

}
