package com.hisun.kont.mx.msg.javabean;


import com.hisun.kont.mx.msg.model.AbstractMX;
import com.hisun.kont.mx.msg.pacs.Pacs00400109;


/**
 * <p>Document053 complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="Document053">
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
public class MXPain00100210 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pain";
    public final static transient int FUNCTIONALITY = 8;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 10;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pain.002.001.10";
    public final static transient Class[] _classes = new Class[]{Pain00200110.class};

    public Pain00200110 pain00200110;

    public Pain00200110 getPain00200110() {
        return pain00200110;
    }

    public void setPain00200110(Pain00200110 pain00200110) {
        this.pain00200110 = pain00200110;
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
        return this.pain00200110;
    }



}
