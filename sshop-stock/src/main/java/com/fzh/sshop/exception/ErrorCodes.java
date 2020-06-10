package com.fzh.sshop.exception;

/**
 * @author  fzh
 */
public enum ErrorCodes {

    TIME_OUT(405, "参数异常",""),

    SERVER_ERROR(500, "服务器异常",""),

    CAREATE_ERROR( -1009, "添加数据错误",""),

    DELETE_ERROR( -1009, "删错失败","");

    private final int errorCode;
    private final String errorMessage;

    ErrorCodes(Integer errorCode, String errorMessage,String msg) {
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
