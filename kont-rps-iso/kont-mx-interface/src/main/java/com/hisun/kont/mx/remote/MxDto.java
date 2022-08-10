package com.hisun.kont.mx.remote;


public class MxDto {

    private String mxStr;

    private String mxMessage;

    private String msgNo;

    private String mxType;

    public MxDto() {
    }

    public MxDto(String mxStr, String mxMessage, String msgNo, String mxType) {
        this.mxStr = mxStr;
        this.mxMessage = mxMessage;
        this.msgNo = msgNo;
        this.mxType = mxType;
    }

    public String getMxStr() {
        return mxStr;
    }

    public void setMxStr(String mxStr) {
        this.mxStr = mxStr;
    }

    public String getMxMessage() {
        return mxMessage;
    }

    public void setMxMessage(String mxMessage) {
        this.mxMessage = mxMessage;
    }

    public String getMsgNo() {
        return msgNo;
    }

    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }

    public String getMxType() {
        return mxType;
    }

    public void setMxType(String mxType) {
        this.mxType = mxType;
    }

    @Override
    public String toString() {
        return "MxDto{" +
                "mxStr='" + mxStr + '\'' +
                ", mxMessage='" + mxMessage + '\'' +
                ", msgNo='" + msgNo + '\'' +
                ", mxType='" + mxType + '\'' +
                '}';
    }
}
