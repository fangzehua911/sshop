package com.fzh.sshop.stock.controller;


import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.req.*;
import com.fzh.sshop.stock.service.impl.TBizBrandServiceImpl;
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
 * 品牌表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
@RestController
@RequestMapping("/stock/brand")
@Api(value = "后台管理",tags = {"admin-品牌管理"})
public class TBizBrandController {

    @Autowired
    private TBizBrandServiceImpl service;

    @PostMapping("/list")
    @ApiOperation(value = "品牌列表" ,notes = "")
    public SuperResponse list(@Valid @RequestBody BrandListRequest request ){
        return  service.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "品牌详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody BrandRequest request ){
        return service.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "品牌添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody BrandInfoRequest request){
        return service.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "品牌修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody BrandInfoRequest request){
        return service.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "品牌删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody BrandRequest request ){
        return service.delete(request);
    }


}

