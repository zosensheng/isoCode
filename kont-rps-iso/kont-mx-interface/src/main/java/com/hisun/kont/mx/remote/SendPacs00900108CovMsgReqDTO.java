package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.pacs.MXPacs00900108Cov;


public class SendPacs00900108CovMsgReqDTO {

    private MXPacs00900108Cov mxPacs00900108Cov;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendPacs00900108CovMsgReqDTO() {
    }

    public SendPacs00900108CovMsgReqDTO(MXPacs00900108Cov mxPacs00900108Cov, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxPacs00900108Cov = mxPacs00900108Cov;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXPacs00900108Cov getMxPacs00900108Cov() {
        return mxPacs00900108Cov;
    }

    public void setMxPacs00900108Cov(MXPacs00900108Cov mxPacs00900108Cov) {
        this.mxPacs00900108Cov = mxPacs00900108Cov;
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
        return "SendPacs00900108CovMsgReqDTO{" +
                "mxPacs00900108Cov=" + mxPacs00900108Cov +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
