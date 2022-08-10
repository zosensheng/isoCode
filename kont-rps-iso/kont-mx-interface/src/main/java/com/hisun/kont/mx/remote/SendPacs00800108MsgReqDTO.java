package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00800108;


public class SendPacs00800108MsgReqDTO {

    private MXPacs00800108 mxPacs00800108;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00800108MsgReqDTO() {
    }

    public SendPacs00800108MsgReqDTO(MXPacs00800108 mxPacs00800108, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00800108 = mxPacs00800108;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00800108 getMxPacs00800108() {
        return mxPacs00800108;
    }

    public void setMxPacs00800108(MXPacs00800108 mxPacs00800108) {
        this.mxPacs00800108 = mxPacs00800108;
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
        return "SendPacs00800108MsgReqDTO{" +
                "mxPacs00800108=" + mxPacs00800108 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
