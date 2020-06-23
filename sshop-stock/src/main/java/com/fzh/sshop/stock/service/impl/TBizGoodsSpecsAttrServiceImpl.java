package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizGoodsSpecsAttr;
import com.fzh.sshop.stock.mapper.TBizGoodsSpecsAttrMapper;
import com.fzh.sshop.stock.req.GoodsSpecsAttrInfoRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrListRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrRequest;
import com.fzh.sshop.stock.service.TBizGoodsSpecsAttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Service
public class TBizGoodsSpecsAttrServiceImpl extends ServiceImpl<TBizGoodsSpecsAttrMapper, TBizGoodsSpecsAttr> implements TBizGoodsSpecsAttrService {

    @Override
    public SuperResponse list(GoodsSpecsAttrListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizGoodsSpecsAttr> wrapper = new QueryWrapper();
        if(request.getCategoryId()!=0){
            wrapper.eq("category_id",request.getCategoryId());
        }
        Page<TBizGoodsSpecsAttr> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<TBizGoodsSpecsAttr> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<TBizGoodsSpecsAttr> specsAttrs = mapIPage.getRecords();
        response.setItems(specsAttrs);
        response.setTotals(pages.getTotal());
        return response;
    }


    @Override
    public SuperResponse find(GoodsSpecsAttrRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttr specsAttr = baseMapper.selectById(request.getAttrId());
        if(null == specsAttr){
            response.setMessage("信息不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(specsAttr);
        return response;
    }


    @Override
    public SuperResponse insert(GoodsSpecsAttrInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttr specsAttr  = new TBizGoodsSpecsAttr();
        specsAttr.setAttrName(request.getAttrName());
        specsAttr.setAttrCode(request.getAttrCode());
        specsAttr.setCategoryId(request.getCategoryId());
        specsAttr.setFlag(request.getFlag());
        int rows = baseMapper.insert(specsAttr);
        if(rows!=0){
            response.setMessage("添加失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse update(GoodsSpecsAttrInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttr specsAttr  = new TBizGoodsSpecsAttr();
        specsAttr.setAttrId(request.getAttrId());
        specsAttr.setAttrName(request.getAttrName());
        specsAttr.setAttrCode(request.getAttrCode());
        specsAttr.setCategoryId(request.getCategoryId());
        specsAttr.setFlag(request.getFlag());
        int rows = baseMapper.updateById(specsAttr);
        if(rows!=0){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }


    @Override
    public SuperResponse delete(GoodsSpecsAttrRequest request) {
        SuperResponse response = new SuperResponse();
        int rows = baseMapper.deleteById(request.getAttrId());
        if(rows!=0){
            response.setMessage("删除失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

}
