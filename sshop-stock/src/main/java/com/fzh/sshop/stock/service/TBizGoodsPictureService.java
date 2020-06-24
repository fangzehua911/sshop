package com.fzh.sshop.stock.service;

import com.fzh.sshop.stock.entity.TBizGoodsPicture;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
public interface TBizGoodsPictureService extends IService<TBizGoodsPicture> {

    int insert(TBizGoodsPicture picture);

    /**
     * 根据商品编号删除商品图
     * @param goodsNo
     * @return
     */
    int deleteByGoodsNo(String goodsNo);


    /**
     * 根据商品编号获取商品图
     * @param goodsNo
     * @return
     */
    List<TBizGoodsPicture> selectGoodsPicByGoodsNo(String goodsNo);

}
