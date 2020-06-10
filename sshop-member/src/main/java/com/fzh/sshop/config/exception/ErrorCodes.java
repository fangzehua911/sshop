package com.fzh.sshop.config.exception;

/**
 * @author  fzh
 */
public enum ErrorCodes {

    TIME_OUT(405, "参数异常"),
    SERVER_ERROR(500, "服务器异常");

    private final Integer errorCode;
    private final String errorMessage;

     ErrorCodes(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
