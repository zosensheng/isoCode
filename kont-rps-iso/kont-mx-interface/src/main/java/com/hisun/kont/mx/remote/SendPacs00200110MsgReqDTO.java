package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00200110;


public class SendPacs00200110MsgReqDTO {
    private MXPacs00200110 mxPacs00200110;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00200110MsgReqDTO() {
    }

    public SendPacs00200110MsgReqDTO(MXPacs00200110 mxPacs00200110, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00200110 = mxPacs00200110;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00200110 getMxPacs00200110() {
        return mxPacs00200110;
    }

    public void setMxPacs00200110(MXPacs00200110 mxPacs00200110) {
        this.mxPacs00200110 = mxPacs00200110;
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
        return "SendPacs00200110MsgReqDTO{" +
                "mxPacs00200110=" + mxPacs00200110 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
