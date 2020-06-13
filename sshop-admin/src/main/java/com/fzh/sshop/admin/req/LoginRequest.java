package com.fzh.sshop.admin.req;


import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "请输入用户名")
    private String account;
    @NotBlank(message = "请输入密码")
    private String password;
    @NotBlank
    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
