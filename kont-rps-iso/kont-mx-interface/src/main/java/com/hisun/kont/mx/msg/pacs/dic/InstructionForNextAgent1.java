package com.hisun.kont.mx.msg.pacs.dic;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Further information related to the processing of the payment instruction that may need to be acted upon by an other agent. The instruction may relate to a level of service, or may be an instruction that has to be executed by the creditor's agent, or may be information required by the other agent.
 * 
 * <p>InstructionForNextAgent1 complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="InstructionForNextAgent1">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="Cd" type="{}Instruction4Code" minOccurs="0"/>
 *         &lt;element name="InstrInf" type="{}Max140Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstructionForNextAgent1", propOrder = {
    "cd",
    "instrInf"
})
public class InstructionForNextAgent1 {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected Instruction4Code cd;
    @XmlElement(name = "InstrInf")
    protected String instrInf;

    /**
     * ��ȡcd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link Instruction4Code }
     *     
     */
    public Instruction4Code getCd() {
        return cd;
    }

    /**
     * ����cd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link Instruction4Code }
     *     
     */
    public void setCd(Instruction4Code value) {
        this.cd = value;
    }

    /**
     * ��ȡinstrInf���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstrInf() {
        return instrInf;
    }

    /**
     * ����instrInf���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstrInf(String value) {
        this.instrInf = value;
    }

}
