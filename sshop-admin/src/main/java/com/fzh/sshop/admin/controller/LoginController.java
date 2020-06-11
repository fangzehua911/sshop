package com.fzh.sshop.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.entity.net.SuperResponse;
import com.fzh.sshop.admin.entity.net.request.LoginRequest;
import com.fzh.sshop.admin.service.LoginService;
import com.fzh.sshop.admin.service.impl.LoginServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**

 * @author fang
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @PostMapping("")
    @ApiOperation(value = "用户登录" ,notes = "")
    public String userLogin(@Valid @RequestBody LoginRequest request ){
        SuperResponse response = loginService.userLogin(request);
        return JSONObject.toJSONString(response);
    }



}
