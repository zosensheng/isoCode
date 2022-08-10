package com.hisun.kont.mx.msg.camt.dic;


import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Product purchased to be paid.
 * 
 * <p>Product2 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="Product2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="PdctCd" type="{}Max70Text"/>
 *         &lt;element name="UnitOfMeasr" type="{}UnitOfMeasure1Code" minOccurs="0"/>
 *         &lt;element name="PdctQty" type="{}DecimalNumber" minOccurs="0"/>
 *         &lt;element name="UnitPric" type="{}ImpliedCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="PdctAmt" type="{}ImpliedCurrencyAndAmount" minOccurs="0"/>
 *         &lt;element name="TaxTp" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="AddtlPdctInf" type="{}Max35Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product2", propOrder = {
    "pdctCd",
    "unitOfMeasr",
    "pdctQty",
    "unitPric",
    "pdctAmt",
    "taxTp",
    "addtlPdctInf"
})
public class Product2 {

    @XmlElement(name = "PdctCd", required = true)
    protected String pdctCd;
    @XmlElement(name = "UnitOfMeasr")
    @XmlSchemaType(name = "string")
    protected UnitOfMeasure1Code unitOfMeasr;
    @XmlElement(name = "PdctQty")
    protected BigDecimal pdctQty;
    @XmlElement(name = "UnitPric")
    protected BigDecimal unitPric;
    @XmlElement(name = "PdctAmt")
    protected BigDecimal pdctAmt;
    @XmlElement(name = "TaxTp")
    protected String taxTp;
    @XmlElement(name = "AddtlPdctInf")
    protected String addtlPdctInf;

    /**
     * ��ȡpdctCd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdctCd() {
        return pdctCd;
    }

    /**
     * ����pdctCd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdctCd(String value) {
        this.pdctCd = value;
    }

    /**
     * ��ȡunitOfMeasr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasure1Code }
     *     
     */
    public UnitOfMeasure1Code getUnitOfMeasr() {
        return unitOfMeasr;
    }

    /**
     * ����unitOfMeasr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasure1Code }
     *     
     */
    public void setUnitOfMeasr(UnitOfMeasure1Code value) {
        this.unitOfMeasr = value;
    }

    /**
     * ��ȡpdctQty���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPdctQty() {
        return pdctQty;
    }

    /**
     * ����pdctQty���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPdctQty(BigDecimal value) {
        this.pdctQty = value;
    }

    /**
     * ��ȡunitPric���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPric() {
        return unitPric;
    }

    /**
     * ����unitPric���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPric(BigDecimal value) {
        this.unitPric = value;
    }

    /**
     * ��ȡpdctAmt���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPdctAmt() {
        return pdctAmt;
    }

    /**
     * ����pdctAmt���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPdctAmt(BigDecimal value) {
        this.pdctAmt = value;
    }

    /**
     * ��ȡtaxTp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxTp() {
        return taxTp;
    }

    /**
     * ����taxTp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxTp(String value) {
        this.taxTp = value;
    }

    /**
     * ��ȡaddtlPdctInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddtlPdctInf() {
        return addtlPdctInf;
    }

    /**
     * ����addtlPdctInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddtlPdctInf(String value) {
        this.addtlPdctInf = value;
    }

}
