package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.*;
import com.fzh.sshop.admin.service.impl.DeptServiceImpl;
import com.fzh.sshop.admin.service.impl.RoleServiceImpl;
import com.fzh.sshop.request.SuperRequest;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-13
 */
@RestController
@RequestMapping("/admin/dept")
@Api(value = "后台管理",tags = {"admin-部门"})
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @PostMapping("/list")
    @ApiOperation(value = "部门列表" ,notes = "")
    public SuperResponse userList(@Valid @RequestBody DeptListRequest request ){
        return deptService.list(request);
    }

    @PostMapping ("/find")
    @ApiOperation(value = "部门详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody DeptRequest request ){
        return deptService.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "部门添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody DeptInfoRequest request){
        return deptService.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "部门修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody DeptInfoRequest request){
        return deptService.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "部门删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody  DeptRequest request ){
        return deptService.delete(request);
    }

}

