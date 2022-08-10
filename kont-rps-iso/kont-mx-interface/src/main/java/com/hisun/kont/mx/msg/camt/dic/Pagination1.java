package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Number used to sequence pages when it is not possible for data to be conveyed in a single message and the data has to be split across several pages (messages).
 * 
 * <p>Pagination1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Pagination1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="PgNb" type="{}Max5NumericText"/>
 *         &lt;element name="LastPgInd" type="{}YesNoIndicator"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pagination1", propOrder = {
    "pgNb",
    "lastPgInd"
})
public class Pagination1 {

    @XmlElement(name = "PgNb", required = true)
    protected String pgNb;
    @XmlElement(name = "LastPgInd")
    protected boolean lastPgInd;

    /**
     * ��ȡpgNb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPgNb() {
        return pgNb;
    }

    /**
     * ����pgNb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPgNb(String value) {
        this.pgNb = value;
    }

    /**
     * ��ȡlastPgInd���Ե�ֵ��
     * 
     */
    public boolean isLastPgInd() {
        return lastPgInd;
    }

    /**
     * ����lastPgInd���Ե�ֵ��
     * 
     */
    public void setLastPgInd(boolean value) {
        this.lastPgInd = value;
    }

}
