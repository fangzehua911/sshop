package com.fzh.sshop.admin.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.admin.UserInfoRequest;
import com.fzh.sshop.admin.req.admin.UserListRequest;
import com.fzh.sshop.admin.user.service.impl.UserServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
public class UserController {


    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/list")
    @ApiOperation(value = "用户列表" ,notes = "")
    public String userList(@Valid @RequestBody UserListRequest request ){
        SuperResponse response = userService.userList(request);
        return JSONObject.toJSONString(response);
    }

    @GetMapping("/find/{userId}")
    @ApiOperation(value = "用户详情" ,notes = "")
    public String find(@Valid @PathVariable("userId") String  userId ){
        SuperResponse response = userService.find(userId);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "添加用户" ,notes = "")
    public String delete(@Valid @RequestBody UserInfoRequest request){
        SuperResponse response = userService.insert(request);
        return JSONObject.toJSONString(response);
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改用户" ,notes = "")
    public String update(@Valid @RequestBody UserInfoRequest request){
        SuperResponse response = userService.update(request);
        return JSONObject.toJSONString(response);
    }

    @GetMapping("/delete/{userId}")
    @ApiOperation(value = "删除用户" ,notes = "")
    public String delete(@Valid @PathVariable("userId") String userId ){
        SuperResponse response = userService.delete(userId);
        return JSONObject.toJSONString(response);
    }

}

