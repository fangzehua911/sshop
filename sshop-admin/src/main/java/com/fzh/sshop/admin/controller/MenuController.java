package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.*;
import com.fzh.sshop.admin.service.impl.MenuServiceImpl;
import com.fzh.sshop.admin.service.impl.RoleServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.Api;
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
 * @since 2020-06-13
 */
@RestController
@RequestMapping("/admin/menu")
@Api(value = "后台管理",tags = {"admin-菜单"})
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @PostMapping("/list")
    @ApiOperation(value = "菜单列表" ,notes = "")
    public String userList(@Valid @RequestBody MenuListRequest request ){
        SuperResponse response = menuService.list(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/find")
    @ApiOperation(value = "菜单详情" ,notes = "")
    public String find(@Valid @RequestBody MenuRequest request ){
        SuperResponse response = menuService.find(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "菜单添加" ,notes = "")
    public String delete(@Valid @RequestBody MenuInfoRequest request){
        SuperResponse response = menuService.insert(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/update")
    @ApiOperation(value = "菜单修改" ,notes = "")
    public String update(@Valid @RequestBody MenuInfoRequest request){
        SuperResponse response = menuService.update(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "菜单删除" ,notes = "")
    public String delete(@Valid @RequestBody MenuRequest request ){
        SuperResponse response = menuService.delete(request);
        return JSONObject.toJSONString(response);
    }

}

