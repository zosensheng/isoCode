package com.hisun.kont.mx.bizdata;

import com.hisun.kont.mx.msg.javabean.head00100102.BusinessApplicationHeaderV02;

public class BizData {

    private BusinessApplicationHeaderV02 appHdr;
    private Object doc;

    public BizData() {
        this.appHdr = new BusinessApplicationHeaderV02();
        this.doc = new Object();
    }

    public static BizData getInstance(BusinessApplicationHeaderV02 appHdr, Object doc) {
        BizData bizData = new BizData();
        bizData.setAppHdr(appHdr);
        bizData.setDoc(doc);
        return bizData;
    }

    public BusinessApplicationHeaderV02 getAppHdr() {
        return appHdr;
    }

    public void setAppHdr(BusinessApplicationHeaderV02 appHdr) {
        this.appHdr = appHdr;
    }

    public Object getDoc() {
        return doc;
    }

    public void setDoc(Object doc) {
        this.doc = doc;
    }
}
