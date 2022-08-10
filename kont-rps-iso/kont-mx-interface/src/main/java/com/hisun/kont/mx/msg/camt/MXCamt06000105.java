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
public class MXCamt06000105 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "camt";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:camt.060.001.05";
    public final static transient Class[] _classes = new Class[]{Camt06000105.class};

    public Camt06000105 camt06000105;

    public Camt06000105 getCamt06000105() {
        return camt06000105;
    }

    public void setCamt06000105(Camt06000105 camt06000105) {
        this.camt06000105 = camt06000105;
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
        return this.camt06000105;
    }



}
