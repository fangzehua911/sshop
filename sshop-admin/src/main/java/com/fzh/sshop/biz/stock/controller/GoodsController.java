package com.fzh.sshop.biz.stock.controller;

import com.fzh.sshop.biz.stock.req.GoodsInfoRequest;
import com.fzh.sshop.biz.stock.req.GoodsListRequest;
import com.fzh.sshop.biz.stock.req.GoodsRequest;
import com.fzh.sshop.biz.stock.service.GoodsServiceImpl;
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
@RequestMapping("/admin/stock/goods")
@Api(value = "后台管理",tags = {"admin-商品管理"})
public class GoodsController {

    @Autowired
    private GoodsServiceImpl service;

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
