package com.masterlee.entity;

public class responseResult<T> {
    private  String errorCode =null;
    private  String errorMessage =null;
    private  T responseData;
    private  Boolean responseStatus = true;

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
