package com.fzh.sshop.biz.stock.service;

import com.fzh.sshop.biz.stock.req.*;
import com.fzh.sshop.bizfc.FCStockService;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl {

    @Autowired
    private FCStockService fcCategoryService;

    public SuperResponse list(GoodsListRequest request){
        return fcCategoryService.goods_list(request);
    }

    public SuperResponse find(GoodsRequest request) {
        return fcCategoryService.goods_find(request);
    }

    public SuperResponse insert(GoodsInfoRequest request) {
        return fcCategoryService.goods_insert(request);
    }

    public SuperResponse update(GoodsInfoRequest request) {
        return fcCategoryService.goods_update(request);
    }

    public SuperResponse delete(GoodsRequest request) {
        return fcCategoryService.goods_delete(request);
    }

}
