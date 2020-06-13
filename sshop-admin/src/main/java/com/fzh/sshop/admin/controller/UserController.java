package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.UserInfoRequest;
import com.fzh.sshop.admin.req.UserListRequest;
import com.fzh.sshop.admin.req.UserRequest;
import com.fzh.sshop.admin.service.impl.UserServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(value = "后台管理",tags = {"admin-用户"})
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/list")
    @ApiOperation(value = "用户列表" ,notes = "")
    public String userList(@Valid @RequestBody UserListRequest request ){
        SuperResponse response = userService.list(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/find")
    @ApiOperation(value = "用户详情" ,notes = "")
    public String find(@Valid @RequestBody UserRequest request ){
        SuperResponse response = userService.find(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "用户添加" ,notes = "")
    public String delete(@Valid @RequestBody UserInfoRequest request){
        SuperResponse response = userService.insert(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/update")
    @ApiOperation(value = "用户修改" ,notes = "")
    public String update(@Valid @RequestBody UserInfoRequest request){
        SuperResponse response = userService.update(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "用户删除" ,notes = "")
    public String delete(@Valid @RequestBody UserRequest request ){
        SuperResponse response = userService.delete(request);
        return JSONObject.toJSONString(response);
    }

}

