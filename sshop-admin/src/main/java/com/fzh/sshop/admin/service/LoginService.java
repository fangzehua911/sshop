package com.fzh.sshop.admin.service;


import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.request.SuperResponse;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {

    SuperResponse userLogin(LoginRequest request );

}
