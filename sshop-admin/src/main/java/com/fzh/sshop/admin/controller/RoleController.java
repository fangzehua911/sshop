package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.RoleInfoRequest;
import com.fzh.sshop.admin.req.RoleListRequest;
import com.fzh.sshop.admin.req.RoleRequest;
import com.fzh.sshop.admin.service.impl.RoleServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/admin/role")
@Api(value = "后台管理",tags = {"admin-角色"})
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/list")
    @ApiOperation(value = "角色列表" ,notes = "")
    public SuperResponse userList(@Valid @RequestBody RoleListRequest request ){
        return roleService.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "角色详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody RoleRequest request ){
        return roleService.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "角色添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody RoleInfoRequest request){
        return roleService.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "角色修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody RoleInfoRequest request){
        return roleService.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "角色删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody RoleRequest request ){
        return roleService.delete(request);
    }


}

