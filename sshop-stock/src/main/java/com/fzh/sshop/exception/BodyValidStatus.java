package com.fzh.sshop.exception;

import org.apache.commons.lang.builder.ToStringBuilder;

public class BodyValidStatus {
    // 错误代码
    private String code;
    // 错误代码解释
    private String message;
    // 错误字段
    private String field;

    public BodyValidStatus() {
    }

    public BodyValidStatus(String code, String message, String field) {
        this.code = code;
        this.message = message;
        this.field = field;
    }

    private BodyValidStatus(Builder builder) {
        setCode(builder.code);
        setMessage(builder.message);
        setField(builder.field);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static final class Builder {
        private String code;
        private String message;
        private String field;

        public Builder() {
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder field(String val) {
            field = val;
            return this;
        }

        public BodyValidStatus build() {
            return new BodyValidStatus(this);
        }
    }
}