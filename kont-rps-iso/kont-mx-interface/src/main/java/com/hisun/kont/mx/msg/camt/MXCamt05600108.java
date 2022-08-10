package com.hisun.kont.mx.msg.camt;


import com.hisun.kont.mx.msg.model.AbstractMX;


/**
 * <p>Document056 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document056">
 *   &lt;complexContent>
 *     &lt;restriction base="{http:
 *       &lt;sequence>
 *         &lt;element name="FIToFICstmrCdtTrf" type="{}FIToFICustomerCreditTransferV10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class MXCamt05600108 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "camt";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:camt.056.001.08";
    public final static transient Class[] _classes = new Class[]{Camt05600108.class};

    public Camt05600108 camt05600108;

    public Camt05600108 getCamt05600108() {
        return camt05600108;
    }

    public void setCamt05600108(Camt05600108 camt05600108) {
        this.camt05600108 = camt05600108;
    }

    /*
   报文版本
    */

    public String getNamespace() {
        return NAMESPACE;
    }

    public String getBusinessProcess() {
        return BUSINESS_PROCESS;
    }

    public int getFunctionality() {
        return FUNCTIONALITY;
    }

    public int getVariant() {
        return VARIANT;
    }

    public int getVersion() {
        return VERSION;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public Class[] getClasses() {
        return _classes;
    }

    @Override
    public Object getDocumentObj() {
        return this.camt05600108;
    }



}
