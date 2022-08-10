package com.hisun.kont.mx.msg.pacs.dic;


import com.hisun.kont.common.utils.JudgeUtils;
import com.hisun.kont.mx.constant.Pacs00800110ErrorConstant;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information that locates and identifies a specific address, as defined by postal services.
 *
 * <p>PostalAddress24 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="PostalAddress24">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="AdrTp" type="{}AddressType3Choice" minOccurs="0"/>
 *         &lt;element name="Dept" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="SubDept" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="StrtNm" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="BldgNb" type="{}Max16Text" minOccurs="0"/>
 *         &lt;element name="BldgNm" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Flr" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="PstBx" type="{}Max16Text" minOccurs="0"/>
 *         &lt;element name="Room" type="{}Max70Text" minOccurs="0"/>
 *         &lt;element name="PstCd" type="{}Max16Text" minOccurs="0"/>
 *         &lt;element name="TwnNm" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="TwnLctnNm" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="DstrctNm" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="CtrySubDvsn" type="{}Max35Text" minOccurs="0"/>
 *         &lt;element name="Ctry" type="{}CountryCode" minOccurs="0"/>
 *         &lt;element name="AdrLine" type="{}Max70Text" maxOccurs="7" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostalAddress24", propOrder = {
    "adrTp",
    "dept",
    "subDept",
    "strtNm",
    "bldgNb",
    "bldgNm",
    "flr",
    "pstBx",
    "room",
    "pstCd",
    "twnNm",
    "twnLctnNm",
    "dstrctNm",
    "ctrySubDvsn",
    "ctry",
    "adrLine"
})
public class PostalAddress24 {

    @XmlElement(name = "AdrTp")
    protected AddressType3Choice adrTp;
    @XmlElement(name = "Dept")
    protected String dept;
    @XmlElement(name = "SubDept")
    protected String subDept;
    @XmlElement(name = "StrtNm")
    protected String strtNm;
    @XmlElement(name = "BldgNb")
    protected String bldgNb;
    @XmlElement(name = "BldgNm")
    protected String bldgNm;
    @XmlElement(name = "Flr")
    protected String flr;
    @XmlElement(name = "PstBx")
    protected String pstBx;
    @XmlElement(name = "Room")
    protected String room;
    @XmlElement(name = "PstCd")
    protected String pstCd;
    @XmlElement(name = "TwnNm")
    protected String twnNm;
    @XmlElement(name = "TwnLctnNm")
    protected String twnLctnNm;
    @XmlElement(name = "DstrctNm")
    protected String dstrctNm;
    @XmlElement(name = "CtrySubDvsn")
    protected String ctrySubDvsn;
    @XmlElement(name = "Ctry")
    protected String ctry;
    @XmlElement(name = "AdrLine")
    protected List<String> adrLine;

    /**
     * ��ȡadrTp���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link AddressType3Choice }
     *
     */
    public AddressType3Choice getAdrTp() {
        return adrTp;
    }

    /**
     * ����adrTp���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link AddressType3Choice }
     *
     */
    public void setAdrTp(AddressType3Choice value) {
        this.adrTp = value;
    }

    /**
     * ��ȡdept���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDept() {
        return dept;
    }

    /**
     * ����dept���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDept(String value) {
        this.dept = value;
    }

    /**
     * ��ȡsubDept���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSubDept() {
        return subDept;
    }

    /**
     * ����subDept���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSubDept(String value) {
        this.subDept = value;
    }

    /**
     * ��ȡstrtNm���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStrtNm() {
        return strtNm;
    }

    /**
     * ����strtNm���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStrtNm(String value) {
        this.strtNm = value;
    }

    /**
     * ��ȡbldgNb���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBldgNb() {
        return bldgNb;
    }

    /**
     * ����bldgNb���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBldgNb(String value) {
        this.bldgNb = value;
    }

    /**
     * ��ȡbldgNm���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBldgNm() {
        return bldgNm;
    }

    /**
     * ����bldgNm���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBldgNm(String value) {
        this.bldgNm = value;
    }

    /**
     * ��ȡflr���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlr() {
        return flr;
    }

    /**
     * ����flr���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlr(String value) {
        this.flr = value;
    }

    /**
     * ��ȡpstBx���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPstBx() {
        return pstBx;
    }

    /**
     * ����pstBx���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPstBx(String value) {
        this.pstBx = value;
    }

    /**
     * ��ȡroom���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRoom() {
        return room;
    }

    /**
     * ����room���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRoom(String value) {
        this.room = value;
    }

    /**
     * ��ȡpstCd���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPstCd() {
        return pstCd;
    }

    /**
     * ����pstCd���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPstCd(String value) {
        this.pstCd = value;
    }

    /**
     * ��ȡtwnNm���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTwnNm() {
        return twnNm;
    }

    /**
     * ����twnNm���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTwnNm(String value) {
        this.twnNm = value;
    }

    /**
     * ��ȡtwnLctnNm���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTwnLctnNm() {
        return twnLctnNm;
    }

    /**
     * ����twnLctnNm���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTwnLctnNm(String value) {
        this.twnLctnNm = value;
    }

    /**
     * ��ȡdstrctNm���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDstrctNm() {
        return dstrctNm;
    }

    /**
     * ����dstrctNm���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDstrctNm(String value) {
        this.dstrctNm = value;
    }

    /**
     * ��ȡctrySubDvsn���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCtrySubDvsn() {
        return ctrySubDvsn;
    }

    /**
     * ����ctrySubDvsn���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCtrySubDvsn(String value) {
        this.ctrySubDvsn = value;
    }

    /**
     * ��ȡctry���Ե�ֵ��
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCtry() {
        return ctry;
    }

    /**
     * ����ctry���Ե�ֵ��
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCtry(String value) {
        this.ctry = value;
    }

    /**
     * Gets the value of the adrLine property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adrLine property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdrLine().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getAdrLine() {
        if (adrLine == null) {
            adrLine = new ArrayList<String>();
        }
        return this.adrLine;
    }

    /**
     * The code is checked against the list of country names obtained from the United Nations (ISO
     * 3166, Alpha-2 code). (Algorithm)
     *
     * @return C9规则检查
     */
    public String checkC9() {
        String resultC9 = "";
        if (JudgeUtils.isNotNull(this.getCtry())){
            if (!ruleC9(this.ctry)) {
                resultC9 = resultC9 + "<AppHdr>"
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_CODE
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_SEVERITY
                        + ":" + Pacs00800110ErrorConstant.C9_ERROR_TEXT;
                return resultC9;
            }
        }
        return resultC9;
    }

    /**
     * @return 判断C9规则
     */
    private static boolean ruleC9(String str) {
        //通过正则表达式判断
        boolean c9 = str.matches("^[a-zA-Z]{2}$");
        return c9;
    }

}
