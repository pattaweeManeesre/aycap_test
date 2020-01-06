package com.test.aycap.exception;

import lombok.Data;

@Data
public class ErrorCode {
    private String errorCode;
    private String errorMessage;

    public ErrorCode(final String errorCode, final String errorMessage)
    {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}