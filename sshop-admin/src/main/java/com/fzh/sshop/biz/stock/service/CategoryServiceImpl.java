package com.fzh.sshop.biz.stock.service;

import com.fzh.sshop.biz.stock.req.CategoryInfoRequest;
import com.fzh.sshop.biz.stock.req.CategoryListRequest;
import com.fzh.sshop.biz.stock.req.CategoryRequest;
import com.fzh.sshop.bizfc.FCStockService;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author  fzh
 *
 */

@Service
public class CategoryServiceImpl {

    @Autowired
    private FCStockService fcCategoryService;

    public SuperResponse list(CategoryListRequest request){
       return fcCategoryService.category_list(request);
    }

    public SuperResponse find(CategoryRequest request) {
        return fcCategoryService.category_find(request);
    }

    public SuperResponse insert(CategoryInfoRequest request) {
        return fcCategoryService.category_insert(request);
    }

    public SuperResponse update(CategoryInfoRequest request) {
        return fcCategoryService.category_update(request);
    }

    public SuperResponse delete(CategoryRequest request) {
        return fcCategoryService.category_delete(request);
    }


}
