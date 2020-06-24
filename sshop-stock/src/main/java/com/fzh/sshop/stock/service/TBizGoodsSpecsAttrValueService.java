package com.fzh.sshop.stock.service;

import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizGoodsSpecsAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.stock.req.*;

/**
 * <p>
 * 属性值 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
public interface TBizGoodsSpecsAttrValueService extends IService<TBizGoodsSpecsAttrValue> {

    SuperResponse list(GoodsSpecsAttrValueListRequest request);

    SuperResponse find(GoodsSpecsAttrValueRequest request);

    SuperResponse insert(GoodsSpecsAttrValueInfoRequest request);

    SuperResponse update(GoodsSpecsAttrValueInfoRequest request);

    SuperResponse delete(GoodsSpecsAttrValueRequest request);
}
