package com.fzh.sshop.stock.service;

import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizGoodsSpecsAttr;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fzh.sshop.stock.req.GoodsSpecsAttrInfoRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrListRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrRequest;

import java.util.List;

/**
 * <p>
 * 属性表 服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
public interface TBizGoodsSpecsAttrService extends IService<TBizGoodsSpecsAttr> {

    SuperResponse list(GoodsSpecsAttrListRequest request);

    SuperResponse find(GoodsSpecsAttrRequest request);

    SuperResponse insert(GoodsSpecsAttrInfoRequest request);

    SuperResponse update(GoodsSpecsAttrInfoRequest request);

    SuperResponse delete(GoodsSpecsAttrRequest request);


}
