package com.fzh.sshop.bizfc;
import com.fzh.sshop.biz.stock.req.*;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @@author fzh
 * 库存服务接口
 */
@FeignClient(value = "sshop-stock")
public interface FCCategoryService {

    //TODO 如果 开发直接协调与约束能统一，严格指定规范 服务直接可以无转换调用, 如果无法做到规范 建议使用String接收

    @RequestMapping(value = "/stock/category/list",method = RequestMethod.POST)
    SuperResponse category_list(CategoryListRequest request);

    @RequestMapping(value = "/stock/category/find",method = RequestMethod.POST)
    SuperResponse category_find(CategoryRequest request);

    @RequestMapping(value = "/stock/category/insert",method = RequestMethod.POST)
    SuperResponse category_insert(CategoryInfoRequest request);

    @RequestMapping(value = "/stock/category/update",method = RequestMethod.POST)
    SuperResponse category_update(CategoryInfoRequest request);

    @RequestMapping(value = "/stock/category/delete",method = RequestMethod.POST)
    SuperResponse category_delete(CategoryRequest request);


    @RequestMapping(value = "/stock/brand/list",method = RequestMethod.POST)
    SuperResponse brand_list(BrandListRequest request);

    @RequestMapping(value = "/stock/brand/find",method = RequestMethod.POST)
    SuperResponse brand_find(BrandRequest request);

    @RequestMapping(value = "/stock/brand/insert",method = RequestMethod.POST)
    SuperResponse brand_insert(BrandInfoRequest request);

    @RequestMapping(value = "/stock/brand/update",method = RequestMethod.POST)
    SuperResponse brand_update(BrandInfoRequest request);

    @RequestMapping(value = "/stock/brand/delete",method = RequestMethod.POST)
    SuperResponse brand_delete(BrandRequest request);

}
