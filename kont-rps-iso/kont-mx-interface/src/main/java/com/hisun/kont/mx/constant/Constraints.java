package com.hisun.kont.mx.constant;

import java.util.Objects;

/**
 * @Author: Cc
 * @Date: 2022/7/5 16:05
 * @Description: Constraints
 **/
public class Constraints {
    private  String value;
    private  String errorSeverity;
    private  String errorCode;
    private  String errorText;



    public Constraints() {
    }

    public Constraints(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "Constraints{" +
                "value='" + value + '\'' +
                ", errorSeverity='" + errorSeverity + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }

    /**
     * @param errorSeverity
     * @param errorCode
     * @param errorText
     * @param value
     */
    public Constraints(String errorSeverity, String errorCode, String errorText, String value) {
        this.errorSeverity = errorSeverity;
        this.errorCode = errorCode;
        this.errorText = errorText;
        this.value = value;
    }

    public Constraints(String errorSeverity, String errorCode, String errorText) {
        this.errorSeverity = errorSeverity;
        this.errorCode = errorCode;
        this.errorText = errorText;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getErrorSeverity() {
        return errorSeverity;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getText() {
        return errorText;
    }

    public void setErrorSeverity(String errorSeverity) {
        this.errorSeverity = errorSeverity;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setText(String errortext) {
        this.errorText = errortext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Constraints)){
            return false;
        }
        Constraints that = (Constraints) o;
        return Objects.equals(value, that.value) &&
                Objects.equals(errorSeverity, that.errorSeverity) &&
                Objects.equals(errorCode, that.errorCode) &&
                Objects.equals(errorText, that.errorText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, errorSeverity, errorCode, errorText);
    }


}
