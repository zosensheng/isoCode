package com.hisun.kont.mx.enums;

/**
 * @author ljs
 * @version 1.0
 * @date 2022/7/18 16:21
 */
public enum BusAppHeadToBusSerEnum {

    //pain.001.001.09 swift.cbprplus.02
    BUS1("pain.001.001.09","swift.cbprplus.02"),

    //pain.002.001.10 swift.cbprplus.02
    BUS2("pain.002.001.10","swift.cbprplus.02"),

    //pacs.002.001.10 swift.cbprplus.02
    BUS3("pacs.002.001.10","swift.cbprplus.02"),

    //pacs.004.001.09 swift.cbprplus.02
    BUS4("pacs.004.001.09","swift.cbprplus.02"),

    //pacs.008.001.08 swift.cbprplus.02
    BUS5("pacs.008.001.08","swift.cbprplus.02"),

    //pacs.008.001.08 (STP/STP EU) swift.cbprplus.stp.02
    BUS6("pacs.008.001.08","swift.cbprplus.stp.02"),

    //pacs.009.001.08 (advice) swift.cbprplus.adv.02
    BUS7("pacs.009.001.08","swift.cbprplus.adv.02"),

    //pacs.009.001.08 (core) swift.cbprplus.02
    BUS8("pacs.009.001.08","swift.cbprplus.02"),

    //pacs.009.001.08 (cov) swift.cbprplus.cov.02
    BUS9("pacs.009.001.08","swift.cbprplus.cov.02"),

    //pacs.010.001.03 swift.cbprplus.02
    BUS10("pacs.010.001.03","swift.cbprplus.02"),

    //camt.029.001.09 swift.cbprplus.02
    BUS11("camt.029.001.09","swift.cbprplus.02"),

    //camt.052.001.08 swift.cbprplus.02
    BUS12("camt.052.001.08","swift.cbprplus.02"),

    //camt.053.001.08 swift.cbprplus.02
    BUS13("camt.053.001.08","swift.cbprplus.02"),

    //camt.054.001.08 swift.cbprplus.02
    BUS14("camt.054.001.08","swift.cbprplus.02"),

    //camt.056.001.08 swift.cbprplus.02
    BUS15("camt.056.001.08","swift.cbprplus.02"),

    //camt.057.001.06 swift.cbprplus.02
    BUS16("camt.057.001.06","swift.cbprplus.02"),

    //camt.060.001.05 swift.cbprplus.02
    BUS17("camt.060.001.05","swift.cbprplus.02"),

    ;
    private String msgDefIdr;
    private String bizSvc;

    BusAppHeadToBusSerEnum(String msgDefIdr, String bizSvc) {
        this.msgDefIdr = msgDefIdr;
        this.bizSvc = bizSvc;
    }

    public String getMsgDefIdr() {
        return msgDefIdr;
    }

    public void setMsgDefIdr(String msgDefIdr) {
        this.msgDefIdr = msgDefIdr;
    }

    public String getBizSvc() {
        return bizSvc;
    }

    public void setBizSvc(String bizSvc) {
        this.bizSvc = bizSvc;
    }
}
