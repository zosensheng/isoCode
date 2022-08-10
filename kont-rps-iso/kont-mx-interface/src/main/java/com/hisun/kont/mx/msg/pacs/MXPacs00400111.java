package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.mx.msg.model.AbstractMX;

public class MXPacs00400111 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 4;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 11;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.004.001.11";
    public final static transient Class[] _classes = new Class[]{Pacs00400111.class};

    public Pacs00400111 pacs00400111;

    public Pacs00400111 getPacs00400111() {
        return pacs00400111;
    }

    public void setPacs00400111(Pacs00400111 pacs00400111) {
        this.pacs00400111 = pacs00400111;
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
        return this.pacs00400111;
    }


}
