package com.masterlee.entity;

public class responseResult<T> {
    private  String errorCode =null;
    private  String errorMessage =null;
    private  T responseData;
    private  boolean responseStatus = true;
    public  responseResult(String errorCode,String errorMessage,boolean responseStatus){
        this.errorCode = errorCode;
        this.errorMessage =errorMessage;
        this.responseStatus =responseStatus;
    }
    public  responseResult(T responseData,boolean responseStatus){
        this.responseData = responseData;
        this.responseStatus =responseStatus;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseStatus(Boolean responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Boolean getResponseStatus() {
        return responseStatus;
    }
}
