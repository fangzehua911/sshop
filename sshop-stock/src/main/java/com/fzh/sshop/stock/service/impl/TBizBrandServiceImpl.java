package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizBrand;
import com.fzh.sshop.stock.entity.TBizCategory;
import com.fzh.sshop.stock.mapper.TBizBrandMapper;
import com.fzh.sshop.stock.req.BrandInfoRequest;
import com.fzh.sshop.stock.req.BrandListRequest;
import com.fzh.sshop.stock.req.BrandRequest;
import com.fzh.sshop.stock.service.TBizBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
@Service
public class TBizBrandServiceImpl extends ServiceImpl<TBizBrandMapper, TBizBrand> implements TBizBrandService {

    @Override
    public SuperResponse list(BrandListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizBrand> wrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(request.getBrandName())){
            wrapper.like("create_time",request.getBrandName());
        }
        wrapper.orderByDesc("create_time");
        Page<TBizBrand> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<TBizBrand> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<TBizBrand> bizBrands = mapIPage.getRecords();
        response.setItems(bizBrands);
        response.setTotals(pages.getTotal());
        return response;
    }


    @Override
    public SuperResponse find(BrandRequest request) {
        SuperResponse response = new SuperResponse();
        TBizBrand bizBrand = baseMapper.selectById(request.getBrandId());
        if(null == bizBrand){
            response.setCode(-1000);
            response.setMessage("信息不存在");
            return response;
        }
        response.setItem(bizBrand);
        return response;
    }

    @Override
    public SuperResponse insert(BrandInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizBrand tBizBrand = new TBizBrand();
        tBizBrand.setBrandName(request.getBrandName());
        tBizBrand.setBrandLogo(request.getBrandLogo());
        tBizBrand.setBrandDesc(request.getBrandDesc());
        tBizBrand.setStatus(request.getStatus());
        int rows = baseMapper.insert(tBizBrand);
        if(rows==0){
            response.setMessage("添加失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }


    @Override
    public SuperResponse update(BrandInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizBrand tBizBrand = new TBizBrand();
        tBizBrand.setBrandId(request.getBrandId());
        tBizBrand.setBrandName(request.getBrandName());
        tBizBrand.setBrandLogo(request.getBrandLogo());
        tBizBrand.setBrandDesc(request.getBrandDesc());
        tBizBrand.setStatus(request.getStatus());
        int rows = baseMapper.insert(tBizBrand);
        if(rows==0){
            response.setMessage("修改失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse delete(BrandRequest request) {
        SuperResponse response = new SuperResponse();
        int rows = baseMapper.deleteById(request.getBrandId());
        if(rows==0){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }
}
