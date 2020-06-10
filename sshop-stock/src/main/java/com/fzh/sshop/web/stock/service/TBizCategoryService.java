package com.fzh.sshop.web.stock.service;

import com.fzh.sshop.web.stock.entity.TBizCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.web.stock.entity.net.SuperResponse;
import com.fzh.sshop.web.stock.entity.net.request.CategoryDeleteRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryInfoRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryListRequest;

/**
 * <p>
 * 分类表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-10
 */
public interface TBizCategoryService extends IService<TBizCategory> {

    SuperResponse getCategorys(CategoryListRequest request);

    SuperResponse createCategory(CategoryInfoRequest request);

    SuperResponse deleteCategory(CategoryDeleteRequest request);

}
