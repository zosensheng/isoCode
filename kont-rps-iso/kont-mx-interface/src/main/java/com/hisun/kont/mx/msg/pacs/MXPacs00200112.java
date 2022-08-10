package com.hisun.kont.mx.msg.pacs;

import com.hisun.kont.mx.msg.model.AbstractMX;

public class MXPacs00200112 extends AbstractMX {

    public final static transient String BUSINESS_PROCESS = "pacs";
    public final static transient int FUNCTIONALITY = 2;
    public final static transient int VARIANT = 1;
    public final static transient int VERSION = 12;
    public final static transient String NAMESPACE = "urn:iso:std:iso:20022:tech:xsd:pacs.002.001.12";
    public final static transient Class[] _classes = new Class[]{Pacs00200112.class};

    public Pacs00200112 pacs00200112;

    public Pacs00200112 getPacs00200112() {
        return pacs00200112;
    }

    public void setPacs00200112(Pacs00200112 pacs00200112) {
        this.pacs00200112 = pacs00200112;
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
        return this.pacs00200112;
    }


}
