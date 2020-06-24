package com.fzh.sshop.stock.service;

import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.stock.req.*;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
public interface TBizGoodsService extends IService<TBizGoods> {

    SuperResponse list(GoodsListRequest request);

    SuperResponse find(GoodsRequest request);

    SuperResponse insert(GoodsInfoRequest request);

    SuperResponse update(GoodsInfoRequest request);

    SuperResponse delete(GoodsRequest request);

}
