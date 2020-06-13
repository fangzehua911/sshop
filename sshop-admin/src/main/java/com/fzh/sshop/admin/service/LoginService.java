package com.fzh.sshop.admin.service;


import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.request.SuperResponse;

public interface LoginService {

    SuperResponse userLogin(LoginRequest request);

}
