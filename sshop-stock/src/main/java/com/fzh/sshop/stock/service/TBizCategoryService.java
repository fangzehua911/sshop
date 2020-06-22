package com.fzh.sshop.stock.service;

import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.stock.req.CategoryInfoRequest;
import com.fzh.sshop.stock.req.CategoryListRequest;
import com.fzh.sshop.stock.req.CategoryRequest;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
public interface TBizCategoryService extends IService<TBizCategory> {

    SuperResponse list(CategoryListRequest request);

    SuperResponse find(CategoryRequest request);

    SuperResponse insert(CategoryInfoRequest request);

    SuperResponse update(CategoryInfoRequest request);

    SuperResponse delete(CategoryRequest request);


}
