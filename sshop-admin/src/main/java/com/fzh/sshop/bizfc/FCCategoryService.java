package com.fzh.sshop.bizfc;
import com.fzh.sshop.biz.stock.req.CategoryInfoRequest;
import com.fzh.sshop.biz.stock.req.CategoryListRequest;
import com.fzh.sshop.biz.stock.req.CategoryRequest;
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
    SuperResponse list(CategoryListRequest request);

    @RequestMapping(value = "/stock/category/find",method = RequestMethod.POST)
    SuperResponse find(CategoryRequest request);

    @RequestMapping(value = "/stock/category/insert",method = RequestMethod.POST)
    SuperResponse insert(CategoryInfoRequest request);

    @RequestMapping(value = "/stock/category/update",method = RequestMethod.POST)
    SuperResponse update(CategoryInfoRequest request);

    @RequestMapping(value = "/stock/category/delete",method = RequestMethod.POST)
    SuperResponse delete(CategoryRequest request);




}
