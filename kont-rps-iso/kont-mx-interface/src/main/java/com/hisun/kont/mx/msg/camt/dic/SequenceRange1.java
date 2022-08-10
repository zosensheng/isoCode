package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies a range of sequences from a start sequence to an end sequence.
 * 
 * <p>SequenceRange1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="SequenceRange1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FrSeq" type="{}Max35Text"/>
 *         &lt;element name="ToSeq" type="{}Max35Text"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SequenceRange1", propOrder = {
    "frSeq",
    "toSeq"
})
public class SequenceRange1 {

    @XmlElement(name = "FrSeq", required = true)
    protected String frSeq;
    @XmlElement(name = "ToSeq", required = true)
    protected String toSeq;

    /**
     * ��ȡfrSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrSeq() {
        return frSeq;
    }

    /**
     * ����frSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrSeq(String value) {
        this.frSeq = value;
    }

    /**
     * ��ȡtoSeq���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSeq() {
        return toSeq;
    }

    /**
     * ����toSeq���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSeq(String value) {
        this.toSeq = value;
    }

}
