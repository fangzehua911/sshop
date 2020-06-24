package com.fzh.sshop.stock.controller;


import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.req.*;
import com.fzh.sshop.stock.service.TBizGoodsService;
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
 * 商品表 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@RestController
@RequestMapping("/stock/goods")
@Api(value = "后台管理",tags = {"admin-商品管理"})
public class TBizGoodsController {

    @Autowired
    private TBizGoodsService service;

    @PostMapping("/list")
    @ApiOperation(value = "商品列表" ,notes = "")
    public SuperResponse list(@Valid @RequestBody GoodsListRequest request ){
        return  service.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "商品详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody GoodsRequest request ){
        return service.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "商品添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsInfoRequest request){
        return service.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "商品修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody GoodsInfoRequest request){
        return service.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "商品删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsRequest request ){
        return service.delete(request);
    }
}

