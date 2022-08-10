package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00400109;


public class SendPacs00400109MsgReqDTO {

    private MXPacs00400109 mxPacs00400109;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00400109MsgReqDTO() {
    }

    public SendPacs00400109MsgReqDTO(MXPacs00400109 mxPacs00400109, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00400109 = mxPacs00400109;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00400109 getMxPacs00400109() {
        return mxPacs00400109;
    }

    public void setMxPacs00400109(MXPacs00400109 mxPacs00400109) {
        this.mxPacs00400109 = mxPacs00400109;
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
        return "SendPacs00400109MsgReqDTO{" +
                "mxPacs00400109=" + mxPacs00400109 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
