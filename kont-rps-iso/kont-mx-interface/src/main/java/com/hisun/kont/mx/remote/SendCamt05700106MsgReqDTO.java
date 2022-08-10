package com.hisun.kont.mx.remote;


import com.hisun.kont.mx.msg.camt.MXCamt05700106;

public class SendCamt05700106MsgReqDTO {

    private MXCamt05700106 mxCamt05700106;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendCamt05700106MsgReqDTO() {
    }

    public SendCamt05700106MsgReqDTO(MXCamt05700106 mxCamt05700106, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxCamt05700106 = mxCamt05700106;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXCamt05700106 getMxCamt05700106() {
        return mxCamt05700106;
    }

    public void setMxCamt05700106(MXCamt05700106 mxCamt05700106) {
        this.mxCamt05700106 = mxCamt05700106;
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
        return "SendCamt05700106MsgReqDTO{" +
                "mxCamt05700106=" + mxCamt05700106 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
