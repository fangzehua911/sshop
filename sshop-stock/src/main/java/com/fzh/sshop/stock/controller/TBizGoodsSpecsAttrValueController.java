package com.fzh.sshop.stock.controller;


import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.req.*;
import com.fzh.sshop.stock.service.impl.TBizGoodsSpecsAttrValueServiceImpl;
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
 * 属性值 前端控制器
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@RestController
@RequestMapping("/stock/goodsSpecsAttrValue")
@Api(value = "后台管理",tags = {"admin-商品属性值管理"})
public class TBizGoodsSpecsAttrValueController {

    @Autowired
    private TBizGoodsSpecsAttrValueServiceImpl service;



    @PostMapping("/list")
    @ApiOperation(value = "属性值列表" ,notes = "")
    public SuperResponse list(@Valid @RequestBody GoodsSpecsAttrValueListRequest request ){
        return  service.list(request);
    }

    @PostMapping("/find")
    @ApiOperation(value = "属性值性详情" ,notes = "")
    public SuperResponse find(@Valid @RequestBody GoodsSpecsAttrValueRequest request ){
        return service.find(request);
    }

    @PostMapping("/insert")
    @ApiOperation(value = "属性值添加" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsSpecsAttrValueInfoRequest request){
        return service.insert(request);
    }

    @PostMapping("/update")
    @ApiOperation(value = "属性值修改" ,notes = "")
    public SuperResponse update(@Valid @RequestBody GoodsSpecsAttrValueInfoRequest request){
        return service.update(request);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "属性值删除" ,notes = "")
    public SuperResponse delete(@Valid @RequestBody GoodsSpecsAttrValueRequest request ){
        return service.delete(request);
    }
}
