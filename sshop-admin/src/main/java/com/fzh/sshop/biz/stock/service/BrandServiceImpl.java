package com.fzh.sshop.biz.stock.service;

import com.fzh.sshop.biz.stock.req.*;
import com.fzh.sshop.bizfc.FCStockService;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl {

    @Autowired
    private FCStockService fcStockService;

    public SuperResponse list(BrandListRequest request){
        return fcStockService.brand_list(request);
    }

    public SuperResponse find(BrandRequest request) {
        return fcStockService.brand_find(request);
    }

    public SuperResponse insert(BrandInfoRequest request) {
        return fcStockService.brand_insert(request);
    }

    public SuperResponse update(BrandInfoRequest request) {
        return fcStockService.brand_update(request);
    }

    public SuperResponse delete(BrandRequest request) {
        return fcStockService.brand_delete(request);
    }


}
