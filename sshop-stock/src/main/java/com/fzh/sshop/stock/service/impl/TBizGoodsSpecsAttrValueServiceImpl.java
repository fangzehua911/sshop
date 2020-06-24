package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizGoodsSpecsAttr;
import com.fzh.sshop.stock.entity.TBizGoodsSpecsAttrValue;
import com.fzh.sshop.stock.mapper.TBizGoodsSpecsAttrValueMapper;
import com.fzh.sshop.stock.req.GoodsSpecsAttrValueInfoRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrValueListRequest;
import com.fzh.sshop.stock.req.GoodsSpecsAttrValueRequest;
import com.fzh.sshop.stock.service.TBizGoodsSpecsAttrValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性值 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Service
public class TBizGoodsSpecsAttrValueServiceImpl extends ServiceImpl<TBizGoodsSpecsAttrValueMapper, TBizGoodsSpecsAttrValue> implements TBizGoodsSpecsAttrValueService {

    @Override
    public SuperResponse list(GoodsSpecsAttrValueListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizGoodsSpecsAttrValue> wrapper = new QueryWrapper();
        if(request.getAttrId()!=0){
            wrapper.eq("attr_id",request.getAttrId());
        }
        Page<TBizGoodsSpecsAttrValue> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<TBizGoodsSpecsAttrValue> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<TBizGoodsSpecsAttrValue> specsAttrValues = mapIPage.getRecords();
        response.setItems(specsAttrValues);
        response.setTotals(pages.getTotal());
        return response;
    }


    @Override
    public SuperResponse find(GoodsSpecsAttrValueRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttrValue specsAttrValue = baseMapper.selectById(request.getAttrId());
        if(null == specsAttrValue){
            response.setMessage("信息不存在!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse insert(GoodsSpecsAttrValueInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttrValue specsAttrValue  = new TBizGoodsSpecsAttrValue();
        specsAttrValue.setAttrId(request.getAttrId());
        specsAttrValue.setAttrValue(request.getAttrValue());
        specsAttrValue.setSort(request.getSort());
        int rows = baseMapper.insert(specsAttrValue);
        if(rows!=0){
            response.setMessage("添加失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse update(GoodsSpecsAttrValueInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoodsSpecsAttrValue specsAttrValue  = new TBizGoodsSpecsAttrValue();
        specsAttrValue.setId(request.getId());
        specsAttrValue.setAttrId(request.getAttrId());
        specsAttrValue.setAttrValue(request.getAttrValue());
        specsAttrValue.setSort(request.getSort());
        int rows = baseMapper.updateById(specsAttrValue);
        if(rows!=0){
            response.setMessage("修改失败!");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse delete(GoodsSpecsAttrValueRequest request) {
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
