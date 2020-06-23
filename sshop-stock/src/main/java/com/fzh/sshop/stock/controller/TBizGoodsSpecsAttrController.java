package com.fzh.sshop.stock.controller;


import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.req.*;
import com.fzh.sshop.stock.service.impl.TBizBrandServiceImpl;
import com.fzh.sshop.stock.service.impl.TBizGoodsServiceImpl;
import com.fzh.sshop.stock.service.impl.TBizGoodsSpecsAttrServiceImpl;
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
 * 属性表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@RestController
@RequestMapping("/stock/goodsSpecsAttr")
@Api(value = "后台管理",tags = {"admin-商品属性管理"})
public class TBizGoodsSpecsAttrController {
    @Autowired
    private TBizGoodsSpecsAttrServiceImpl service;

    @PostMapping("/list")
    @ApiOperation(value = "商品属性列表" ,notes = "")
    public SuperResponse list(@Valid @RequestBody GoodsSpecsAttrListRequest request ){
        return  service.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "商品属性详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody GoodsSpecsAttrRequest request ){
        return service.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "商品属性添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsSpecsAttrInfoRequest  request){
        return service.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "商品属性修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody GoodsSpecsAttrInfoRequest request){
        return service.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "商品属性删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsSpecsAttrRequest request ){
        return service.delete(request);
    }
}

