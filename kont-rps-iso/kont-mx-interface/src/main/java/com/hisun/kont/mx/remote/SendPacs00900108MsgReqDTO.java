package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00900108;

public class SendPacs00900108MsgReqDTO {

    private MXPacs00900108 mxPacs00900108;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00900108MsgReqDTO() {
    }

    public SendPacs00900108MsgReqDTO(MXPacs00900108 mxPacs00900108, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00900108 = mxPacs00900108;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00900108 getMxPacs00900108() {
        return mxPacs00900108;
    }

    public void setMxPacs00900108(MXPacs00900108 mxPacs00900108) {
        this.mxPacs00900108 = mxPacs00900108;
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
        return "SendPacs00900108MsgReqDTO{" +
                "mxPacs00900108=" + mxPacs00900108 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
