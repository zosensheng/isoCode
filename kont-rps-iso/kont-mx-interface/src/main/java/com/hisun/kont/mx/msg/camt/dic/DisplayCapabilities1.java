package com.hisun.kont.mx.msg.camt.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * The capabilities of the display components performing the transaction.
 * 
 * <p>DisplayCapabilities1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DisplayCapabilities1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="DispTp" type="{}UserInterface2Code"/>
 *         &lt;element name="NbOfLines" type="{}Max3NumericText"/>
 *         &lt;element name="LineWidth" type="{}Max3NumericText"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayCapabilities1", propOrder = {
    "dispTp",
    "nbOfLines",
    "lineWidth"
})
public class DisplayCapabilities1 {

    @XmlElement(name = "DispTp", required = true)
    @XmlSchemaType(name = "string")
    protected UserInterface2Code dispTp;
    @XmlElement(name = "NbOfLines", required = true)
    protected String nbOfLines;
    @XmlElement(name = "LineWidth", required = true)
    protected String lineWidth;

    /**
     * ��ȡdispTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UserInterface2Code }
     *     
     */
    public UserInterface2Code getDispTp() {
        return dispTp;
    }

    /**
     * ����dispTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UserInterface2Code }
     *     
     */
    public void setDispTp(UserInterface2Code value) {
        this.dispTp = value;
    }

    /**
     * ��ȡnbOfLines���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfLines() {
        return nbOfLines;
    }

    /**
     * ����nbOfLines���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfLines(String value) {
        this.nbOfLines = value;
    }

    /**
     * ��ȡlineWidth���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineWidth() {
        return lineWidth;
    }

    /**
     * ����lineWidth���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineWidth(String value) {
        this.lineWidth = value;
    }

}
