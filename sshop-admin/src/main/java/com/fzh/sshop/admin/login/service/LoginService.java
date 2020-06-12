package com.fzh.sshop.admin.login.service;


import com.fzh.sshop.admin.req.admin.LoginRequest;
import com.fzh.sshop.request.SuperResponse;

public interface LoginService {

    SuperResponse userLogin(LoginRequest request);

}
