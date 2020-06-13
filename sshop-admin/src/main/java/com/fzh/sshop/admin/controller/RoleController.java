package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.RoleInfoRequest;
import com.fzh.sshop.admin.req.RoleListRequest;
import com.fzh.sshop.admin.req.UserInfoRequest;
import com.fzh.sshop.admin.req.UserListRequest;
import com.fzh.sshop.admin.service.impl.RoleServiceImpl;
import com.fzh.sshop.request.SuperResponse;
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
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @PostMapping("/list")
    @ApiOperation(value = "角色列表" ,notes = "")
    public String userList(@Valid @RequestBody RoleListRequest request ){
        SuperResponse response = roleService.roleList(request);
        return JSONObject.toJSONString(response);
    }

    @GetMapping("/find/{roleId}")
    @ApiOperation(value = "角色详情" ,notes = "")
    public String find(@Valid @PathVariable("roleId") String  roleId ){
        SuperResponse response = roleService.find(roleId);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "角色添加" ,notes = "")
    public String delete(@Valid @RequestBody RoleInfoRequest request){
        SuperResponse response = roleService.insert(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/update")
    @ApiOperation(value = "角色修改" ,notes = "")
    public String update(@Valid @RequestBody RoleInfoRequest request){
        SuperResponse response = roleService.update(request);
        return JSONObject.toJSONString(response);
    }

    @GetMapping("/delete/{roleId}")
    @ApiOperation(value = "角色删除" ,notes = "")
    public String delete(@Valid @PathVariable("roleId") String roleId ){
        SuperResponse response = roleService.delete(roleId);
        return JSONObject.toJSONString(response);
    }
}

