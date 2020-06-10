package com.fzh.sshop.web.stock.controller;


import com.alibaba.fastjson.JSONObject;
import com.fzh.sshop.web.stock.entity.net.SuperResponse;
import com.fzh.sshop.web.stock.entity.net.request.CategoryDeleteRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryInfoRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryListRequest;
import com.fzh.sshop.web.stock.service.impl.TBizCategoryServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 分类表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-10
 */
@RestController
@RequestMapping("/stock/category")
public class TBizCategoryController {


    @Autowired
    private TBizCategoryServiceImpl tBizCategoryService;

    @PostMapping("/getCategorys")
    @ApiOperation(value = "分类列表" ,notes = "默认传分页参数")
    public String getCategorys(@Valid @RequestBody CategoryListRequest request){
        SuperResponse response = tBizCategoryService.getCategorys(request);
        return JSONObject.toJSONString(response);
    }


    @PostMapping("/createCategory")
    @ApiOperation(value = "分类添加" ,notes = "")
    public String createCategory(@Valid @RequestBody CategoryInfoRequest request){
        SuperResponse response = tBizCategoryService.createCategory(request);
        return JSONObject.toJSONString(response);
    }


    @PostMapping("/updateategory")
    @ApiOperation(value = "分类修改" ,notes = "")
    public String updateategory(@Valid @RequestBody CategoryInfoRequest request){
        SuperResponse response = tBizCategoryService.createCategory(request);
        return JSONObject.toJSONString(response);
    }


    @PostMapping("/delCategory")
    @ApiOperation(value = "分类删除" ,notes = "")
    public String delCategory(@Valid @RequestBody CategoryDeleteRequest request){
        SuperResponse response = tBizCategoryService.deleteCategory(request);
        return JSONObject.toJSONString(response);
    }



}

