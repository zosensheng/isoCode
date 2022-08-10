package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.camt.MXCamt02900109;


public class SendCamt02900109MsgReqDTO {

    private MXCamt02900109 mxCamt02900109;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendCamt02900109MsgReqDTO() {
    }

    public SendCamt02900109MsgReqDTO(MXCamt02900109 mxCamt02900109, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxCamt02900109 = mxCamt02900109;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXCamt02900109 getMxCamt02900109() {
        return mxCamt02900109;
    }

    public void setMxCamt02900109(MXCamt02900109 mxCamt02900109) {
        this.mxCamt02900109 = mxCamt02900109;
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
        return "SendCamt02900108MsgReqDTO{" +
                "mxCamt02900109=" + mxCamt02900109 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
