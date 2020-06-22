package com.fzh.sshop.stock.service;

import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizBrand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.stock.req.*;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
public interface TBizBrandService extends IService<TBizBrand> {

    SuperResponse list(BrandListRequest request);

    SuperResponse find(BrandRequest request);

    SuperResponse insert(BrandInfoRequest request);

    SuperResponse update(BrandInfoRequest request);

    SuperResponse delete(BrandRequest request);
}
