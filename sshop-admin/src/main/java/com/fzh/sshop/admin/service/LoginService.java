package com.fzh.sshop.admin.service;


import com.fzh.sshop.admin.entity.net.SuperResponse;
import com.fzh.sshop.admin.entity.net.request.LoginRequest;

public interface LoginService {

    SuperResponse userLogin(LoginRequest request);

}
