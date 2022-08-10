package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00900108Adv;


public class SendPacs00900108AdvMsgReqDTO {

    private MXPacs00900108Adv mxPacs00900108Adv;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00900108AdvMsgReqDTO() {
    }

    public SendPacs00900108AdvMsgReqDTO(MXPacs00900108Adv mxPacs00900108Adv, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00900108Adv = mxPacs00900108Adv;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00900108Adv getMxPacs00900108Adv() {
        return mxPacs00900108Adv;
    }

    public void setMxPacs00900108Adv(MXPacs00900108Adv mxPacs00900108Adv) {
        this.mxPacs00900108Adv = mxPacs00900108Adv;
    }

    public RmcMxg01 getRmcMxg01() {
        return rmcMxg01;
    }

    public void setRmcMxg01(RmcMxg01 rmcMxg01) {
        this.rmcMxg01 = rmcMxg01;
    }

    public ReqHead getReqHead() {
        return reqHead;
    }

    public void setReqHead(ReqHead reqHead) {
        this.reqHead = reqHead;
    }

    @Override
    public String toString() {
        return "SendPacs00900108AdvMsgReqDTO{" +
                "mxPacs00900108Adv=" + mxPacs00900108Adv +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
