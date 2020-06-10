package com.fzh.sshop.web.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.web.stock.entity.TBizCategory;
import com.fzh.sshop.web.stock.entity.net.SuperResponse;
import com.fzh.sshop.web.stock.entity.net.request.CategoryDeleteRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryInfoRequest;
import com.fzh.sshop.web.stock.entity.net.request.CategoryListRequest;
import com.fzh.sshop.web.stock.mapper.TBizCategoryMapper;
import com.fzh.sshop.web.stock.service.TBizCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.exception.ErrorCodes;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 分类表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-10
 */
@Service
public class TBizCategoryServiceImpl extends ServiceImpl<TBizCategoryMapper, TBizCategory> implements TBizCategoryService {


    @Override
    public SuperResponse getCategorys(CategoryListRequest request) {
        SuperResponse response = new SuperResponse();

        QueryWrapper<TBizCategory> wrapper = new QueryWrapper();

        Page<TBizCategory> page = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<Map<String, Object>> mapIPage = baseMapper.selectMapsPage(page, wrapper);

        response.setItems(page.getRecords());
        response.setTotals(mapIPage.getTotal());
        return response;
    }

    @Override
    public SuperResponse createCategory(CategoryInfoRequest request) {
        SuperResponse response = new SuperResponse();
        TBizCategory tBizCategory = new TBizCategory();
        tBizCategory.setCategoryName(request.getCategory_name());
        tBizCategory.setCategoryImg("img");
        tBizCategory.setParentId(request.getParent_id());
        tBizCategory.setFlag(request.getFlag());
        int rs = baseMapper.insert(tBizCategory);
        if(rs!=1){
            response.setCode(ErrorCodes.DELETE_ERROR.getErrorCode());
            response.setMessage(ErrorCodes.DELETE_ERROR.getErrorMessage());
            return  response;
        }
        return response;
    }

    @Override
    public SuperResponse deleteCategory(CategoryDeleteRequest request) {
        SuperResponse response = new SuperResponse();
        int rs = baseMapper.deleteById(request.getCategory_id());
        if(rs!=1){
            response.setCode(ErrorCodes.DELETE_ERROR.getErrorCode());
            response.setMessage(ErrorCodes.DELETE_ERROR.getErrorMessage());
            return  response;
        }
        return response;
    }
}
