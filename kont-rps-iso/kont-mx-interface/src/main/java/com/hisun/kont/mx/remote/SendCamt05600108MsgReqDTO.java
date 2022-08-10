package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.camt.MXCamt05600108;


public class SendCamt05600108MsgReqDTO {

    private MXCamt05600108 mxCamt05600108;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendCamt05600108MsgReqDTO() {
    }

    public SendCamt05600108MsgReqDTO(MXCamt05600108 mxCamt05600108, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxCamt05600108 = mxCamt05600108;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXCamt05600108 getMxCamt05600108() {
        return mxCamt05600108;
    }

    public void setMxCamt05600108(MXCamt05600108 mxCamt05600108) {
        this.mxCamt05600108 = mxCamt05600108;
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
        return "SendCamt05600108MsgReqDTO{" +
                "mxCamt05600108=" + mxCamt05600108 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
