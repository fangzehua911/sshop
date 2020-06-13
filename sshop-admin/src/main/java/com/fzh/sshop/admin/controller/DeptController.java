package com.fzh.sshop.admin.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.admin.req.*;
import com.fzh.sshop.admin.service.impl.DeptServiceImpl;
import com.fzh.sshop.admin.service.impl.RoleServiceImpl;
import com.fzh.sshop.request.SuperRequest;
import com.fzh.sshop.request.SuperResponse;
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
public class DeptController {
    @Autowired
    private DeptServiceImpl deptService;

    @PostMapping("/list")
    @ApiOperation(value = "部门列表" ,notes = "")
    public String userList(@Valid @RequestBody DeptListRequest request ){
        SuperResponse response = deptService.list(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping ("/find")
    @ApiOperation(value = "部门详情" ,notes = "")
    public String find(@Valid @RequestBody DeptRequest request ){
        SuperResponse response = deptService.find(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "部门添加" ,notes = "")
    public String delete(@Valid @RequestBody DeptInfoRequest request){
        SuperResponse response = deptService.insert(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/update")
    @ApiOperation(value = "部门修改" ,notes = "")
    public String update(@Valid @RequestBody DeptInfoRequest request){
        SuperResponse response = deptService.update(request);
        return JSONObject.toJSONString(response);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "部门删除" ,notes = "")
    public String delete(@Valid @RequestBody  DeptRequest request ){
        SuperResponse response = deptService.delete(request);
        return JSONObject.toJSONString(response);
    }

}

