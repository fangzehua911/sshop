package com.fzh.sshop.admin.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.admin.UserListRequest;
import com.fzh.sshop.admin.user.service.impl.UserServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-12
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/list")
    @ApiOperation(value = "用户列表" ,notes = "")
    public String userList(@Valid @RequestBody UserListRequest request ){
        SuperResponse response = userService.userList(request);
        return JSONObject.toJSONString(response);
    }

}

