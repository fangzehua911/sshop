package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.stock.entity.TBizCategory;
import com.fzh.sshop.stock.entity.TBizGoodsPicture;
import com.fzh.sshop.stock.mapper.TBizGoodsPictureMapper;
import com.fzh.sshop.stock.service.TBizGoodsPictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Service
public class TBizGoodsPictureServiceImpl extends ServiceImpl<TBizGoodsPictureMapper, TBizGoodsPicture> implements TBizGoodsPictureService {

    @Override
    public int insert(TBizGoodsPicture picture) {
        return baseMapper.insert(picture);
    }

    @Override
    public int deleteByGoodsNo(String goodsNo) {
        QueryWrapper<TBizGoodsPicture> wrapper = new QueryWrapper();
        wrapper.eq("goods_no",goodsNo);
        return baseMapper.delete(wrapper);
    }

    @Override
    public List<TBizGoodsPicture> selectGoodsPicByGoodsNo(String goodsNo) {
        QueryWrapper<TBizGoodsPicture> wrapper = new QueryWrapper();
        wrapper.eq("goods_no",goodsNo);
        return baseMapper.selectList(wrapper);
    }
}
