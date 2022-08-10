package com.hisun.kont.mx.remote;

import com.hisun.kont.mx.msg.camt.MXCamt05400108;


public class SendCamt05400108MsgReqDTO {

    private MXCamt05400108 mxCamt05400108;

    private RmcMxg01 rmcMxg01;

    private ReqHead reqHead;

    public SendCamt05400108MsgReqDTO() {
    }

    public SendCamt05400108MsgReqDTO(MXCamt05400108 mxCamt05400108, RmcMxg01 rmcMxg01, ReqHead reqHead) {
        this.mxCamt05400108 = mxCamt05400108;
        this.rmcMxg01 = rmcMxg01;
        this.reqHead = reqHead;
    }

    public MXCamt05400108 getMxCamt05400108() {
        return mxCamt05400108;
    }

    public void setMxCamt05400108(MXCamt05400108 mxCamt05400108) {
        this.mxCamt05400108 = mxCamt05400108;
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
        return "SendCamt05400108MsgReqDTO{" +
                "mxCamt05400108=" + mxCamt05400108 +
                ", rmcMxg01=" + rmcMxg01 +
                ", reqHead=" + reqHead +
                '}';
    }
}
