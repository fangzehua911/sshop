package com.fzh.sshop.stock.controller;


import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.req.CategoryInfoRequest;
import com.fzh.sshop.stock.req.CategoryListRequest;
import com.fzh.sshop.stock.req.CategoryRequest;
import com.fzh.sshop.stock.service.impl.TBizCategoryServiceImpl;
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
 * 分类表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/stock/category")
@Api(value = "后台管理",tags = {"admin-商品分类"})
public class TBizCategoryController {

    @Autowired
    private TBizCategoryServiceImpl tBizCategoryService;

    @PostMapping("/list")
    @ApiOperation(value = "分类列表" ,notes = "")
    public SuperResponse list(@Valid @RequestBody CategoryListRequest request ){
        return  tBizCategoryService.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "分类详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody CategoryRequest request ){
        return tBizCategoryService.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "分类添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody CategoryInfoRequest request){
        return tBizCategoryService.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "分类修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody CategoryInfoRequest request){
        return tBizCategoryService.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "分类删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody CategoryRequest request ){
        return tBizCategoryService.delete(request);
    }
}

