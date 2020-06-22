package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizCategory;
import com.fzh.sshop.stock.mapper.TBizCategoryMapper;
import com.fzh.sshop.stock.req.CategoryInfoRequest;
import com.fzh.sshop.stock.req.CategoryListRequest;
import com.fzh.sshop.stock.req.CategoryRequest;
import com.fzh.sshop.stock.service.TBizCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-22
 */
@Service
public class TBizCategoryServiceImpl extends ServiceImpl<TBizCategoryMapper, TBizCategory> implements TBizCategoryService {

    @Override
    public SuperResponse list(CategoryListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizCategory> wrapper = new QueryWrapper();
        Page<TBizCategory> pages = new Page<>(request.getPageNo(),request.getPageSize());
        wrapper.eq("parent_id",0);
        IPage<TBizCategory> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<TBizCategory> categoryList = mapIPage.getRecords();
        for(TBizCategory category:categoryList){
            wrapper = new QueryWrapper();
            category.setChildren(baseMapper.selectList(wrapper.eq("parent_id",category.getCategoryId()).orderByAsc("level")));
        }
        response.setItems(categoryList);
        return response;
    }

    @Override
    public SuperResponse find(CategoryRequest request) {
        SuperResponse response = new SuperResponse();
        TBizCategory category = baseMapper.selectById(request.getCategoryId());
        if(null == category){
            response.setMessage("信息不存在");
            response.setCode(-1000);
            return response;
        }
        response.setItem(category);
        return response;
    }

    @Override
    public SuperResponse insert(CategoryInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizCategory category  = new TBizCategory();
        category.setCategoryName(request.getCategoryName());
        category.setCategoryImg(request.getCategoryImg());
        category.setParentId(request.getParentId());
        category.setFlag(request.getFlag());
        category.setLevel(request.getLevel());
        int rows =  baseMapper.updateById(category);
        if(rows==0){
            response.setMessage("添加失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse update(CategoryInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizCategory category  = new TBizCategory();
        category.setCategoryId(request.getCategoryId());
        category.setCategoryName(request.getCategoryName());
        category.setCategoryImg(request.getCategoryImg());
        category.setParentId(request.getParentId());
        category.setFlag(request.getFlag());
        category.setLevel(request.getLevel());
        int rows =  baseMapper.updateById(category);
        if(rows==0){
            response.setMessage("修改失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    public SuperResponse delete(CategoryRequest request) {
        SuperResponse response = new SuperResponse();

        //TODO 判断是否被使用



        int rows = baseMapper.deleteById(request.getCategoryId());
        if(rows==0){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }
}
