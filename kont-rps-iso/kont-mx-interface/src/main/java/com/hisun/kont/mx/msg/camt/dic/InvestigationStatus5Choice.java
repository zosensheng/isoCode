package com.hisun.kont.mx.msg.camt.dic;


import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>InvestigationStatus5Choice complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="InvestigationStatus5Choice">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;choice>
 *         &lt;element name="Conf" type="{}ExternalInvestigationExecutionConfirmation1Code"/>
 *         &lt;element name="RjctdMod" type="{}ModificationStatusReason1Choice" maxOccurs="unbounded"/>
 *         &lt;element name="DplctOf" type="{}Case5"/>
 *         &lt;element name="AssgnmtCxlConf" type="{}YesNoIndicator"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvestigationStatus5Choice", propOrder = {
    "conf",
    "rjctdMod",
    "dplctOf",
    "assgnmtCxlConf"
})
public class InvestigationStatus5Choice {

    @XmlElement(name = "Conf")
    protected String conf;
    @XmlElement(name = "RjctdMod")
    protected List<ModificationStatusReason1Choice> rjctdMod;
    @XmlElement(name = "DplctOf")
    protected Case5 dplctOf;
    @XmlElement(name = "AssgnmtCxlConf")
    protected Boolean assgnmtCxlConf;

    /**
     * ��ȡconf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConf() {
        return conf;
    }

    /**
     * ����conf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConf(String value) {
        this.conf = value;
    }

    /**
     * Gets the value of the rjctdMod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rjctdMod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRjctdMod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ModificationStatusReason1Choice }
     * 
     * 
     */
    public List<ModificationStatusReason1Choice> getRjctdMod() {
        if (rjctdMod == null) {
            rjctdMod = new ArrayList<ModificationStatusReason1Choice>();
        }
        return this.rjctdMod;
    }

    /**
     * ��ȡdplctOf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Case5 }
     *     
     */
    public Case5 getDplctOf() {
        return dplctOf;
    }

    /**
     * ����dplctOf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Case5 }
     *     
     */
    public void setDplctOf(Case5 value) {
        this.dplctOf = value;
    }

    /**
     * ��ȡassgnmtCxlConf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAssgnmtCxlConf() {
        return assgnmtCxlConf;
    }

    /**
     * ����assgnmtCxlConf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAssgnmtCxlConf(Boolean value) {
        this.assgnmtCxlConf = value;
    }

}
