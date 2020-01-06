package com.test.aycap.exception;

public class BaseException extends Exception{

    private ErrorCode errorCode;

    public BaseException(ErrorCode errorCode){
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode(){
        return errorCode;
    }

}