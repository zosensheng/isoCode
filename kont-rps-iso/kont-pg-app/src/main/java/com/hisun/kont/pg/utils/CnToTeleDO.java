package com.hisun.kont.pg.utils;

/**
 * @Author yupeifeng
 * @ClassName: CnToTeleDO
 * @Date 2022/7/5 15:33
 * @Description TODO
 * @Version 1.0
 **/
public class CnToTeleDO {
    //内容
    private String outputData;
    //超长内容
    private String overLengthData;
    //当前长度
    private Integer currentLength;
    //错误
    private String returnError;

    public String getOutputData() {
        return outputData;
    }

    public void setOutputData(String outputData) {
        this.outputData = outputData;
    }

    public String getOverLengthData() {
        return overLengthData;
    }

    public void setOverLengthData(String overLengthData) {
        this.overLengthData = overLengthData;
    }

    public Integer getCurrentLength() {
        return currentLength;
    }

    public void setCurrentLength(Integer currentLength) {
        this.currentLength = currentLength;
    }

    public String getReturnError() {
        return returnError;
    }

    public void setReturnError(String returnError) {
        this.returnError = returnError;
    }
}
