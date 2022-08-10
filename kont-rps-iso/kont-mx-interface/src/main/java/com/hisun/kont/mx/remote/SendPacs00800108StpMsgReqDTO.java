package com.hisun.kont.mx.remote;


import com.hisun.kont.mx.msg.pacs.MXPacs00800108Stp;

public class SendPacs00800108StpMsgReqDTO {

    private MXPacs00800108Stp mxPacs00800108Stp;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00800108StpMsgReqDTO() {
    }

    public SendPacs00800108StpMsgReqDTO(MXPacs00800108Stp mxPacs00800108Stp, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00800108Stp = mxPacs00800108Stp;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00800108Stp getMxPacs00800108Stp() {
        return mxPacs00800108Stp;
    }

    public void setMxPacs00800108Stp(MXPacs00800108Stp mxPacs00800108Stp) {
        this.mxPacs00800108Stp = mxPacs00800108Stp;
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
        return "SendPacs00800108StpMsgReqDTO{" +
                "mxPacs00800108Stp=" + mxPacs00800108Stp +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
