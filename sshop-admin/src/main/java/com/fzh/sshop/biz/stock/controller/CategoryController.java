package com.fzh.sshop.biz.stock.controller;

import com.fzh.sshop.biz.stock.req.CategoryInfoRequest;
import com.fzh.sshop.biz.stock.req.CategoryListRequest;
import com.fzh.sshop.biz.stock.req.CategoryRequest;
import com.fzh.sshop.biz.stock.service.CategoryServiceImpl;
import com.fzh.sshop.request.SuperResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/category")
@Api(value = "商品管理",tags = {"admin-商品分类"})
public class CategoryController {


    @Autowired
    private CategoryServiceImpl service;

    @PostMapping("/list")
    @ApiOperation(value = "分类列表" ,notes = "")
    public SuperResponse categoryList(@Valid @RequestBody CategoryListRequest request ){
        return service.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "分类详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody CategoryRequest request ){
        return service.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "分类添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody CategoryInfoRequest request){
        return service.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "分类修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody CategoryInfoRequest request){
        return service.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "分类删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody CategoryRequest request ){
        return service.delete(request);
    }
}

