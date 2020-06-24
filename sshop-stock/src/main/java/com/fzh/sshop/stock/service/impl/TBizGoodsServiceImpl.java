package com.fzh.sshop.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.stock.entity.TBizBrand;
import com.fzh.sshop.stock.entity.TBizGoods;
import com.fzh.sshop.stock.entity.TBizGoodsPicture;
import com.fzh.sshop.stock.mapper.TBizGoodsMapper;
import com.fzh.sshop.stock.req.GoodsInfoRequest;
import com.fzh.sshop.stock.req.GoodsListRequest;
import com.fzh.sshop.stock.req.GoodsRequest;
import com.fzh.sshop.stock.service.TBizGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fzh.sshop.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-23
 */
@Service
public class TBizGoodsServiceImpl extends ServiceImpl<TBizGoodsMapper, TBizGoods> implements TBizGoodsService {

    @Autowired
    private TBizGoodsPictureServiceImpl goodsPictureService;


    @Override
    public SuperResponse list(GoodsListRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizGoods> wrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(request.getGoodsNo())){
            wrapper.eq("goods_no",request.getGoodsNo());
        }
        if(StringUtils.isNotEmpty(request.getGoodsName())){
            wrapper.like("goods_name",request.getGoodsName());
        }

        if(StringUtils.isNotEmpty(request.getCategoryId())){
            wrapper.eq("category_id",request.getCategoryId());
        }

        if(StringUtils.isNotEmpty(request.getStatus())){
            wrapper.eq("status",request.getStatus());
        }

        if(StringUtils.isNotEmpty(request.getBrandId())){
            wrapper.eq("brand_id",request.getBrandId());
        }

        Page<TBizGoods> pages = new Page<>(request.getPageNo(),request.getPageSize());
        IPage<TBizGoods> mapIPage = baseMapper.selectPage(pages, wrapper);
        List<TBizGoods> goods = mapIPage.getRecords();
        response.setItems(goods);
        response.setTotals(pages.getTotal());
        return response;
    }


    @Override
    public SuperResponse find(GoodsRequest request) {
        SuperResponse response = new SuperResponse();
        TBizGoods goods = baseMapper.selectById(request.getGoodsId());
        if(null==goods){
            response.setMessage("信息不存在");
            response.setCode(-1000);
            return response;
        }
        return response;
    }

    @Override
    @Transactional
    public SuperResponse insert(GoodsInfoRequest request) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SuperResponse response = new SuperResponse();
            TBizGoods goods = new TBizGoods();
            //TODO 商品编号生成需要修改 可使用redis,snowflake 等多种方案 可以自由选择 具体根据你的业务选型
            //TODO 这里选用最简单的时间参数+随机数生成 本方法适合对并发要求不高的 并发超过10 不建议使用

            String goodsNo = UUIDUtils.getNum14();
            goods.setGoodsNo(goodsNo);
            goods.setGoodsName(request.getGoodsName());
            goods.setGoodsTitle(request.getGoodsName());
            goods.setCategoryId(request.getCategoryId());
            goods.setBrandId(request.getBrandId());
            goods.setGoodsImg(request.getGoodsImg());
            goods.setStatus(request.getStatus());
            goods.setSalesVol(0);
            goods.setStockVol(0);
            //TODO 使用百度图片识别功能 生成图片唯一标识
            goods.setGoodsImgCode("");

            goods.setMerchantNo(request.getMerchantNo());
            int rows = baseMapper.insert(goods);
            if(0==rows){
                response.setMessage("添加失败!");
                response.setCode(-1000);
                return response;
            }

            //TODO 如果有多图
            if(StringUtils.isNotEmpty(request.getGoodsImgs())){
                String imgs[] = request.getGoodsImgs().split(",");
                TBizGoodsPicture goodsPicture = null;
                int sort = 0;
                for(String img:imgs){
                    sort = sort+1;
                    //TODO 使用百度图片识别功能 生成图片唯一标识 然后保存
                    goodsPicture = new TBizGoodsPicture();
                    goodsPicture.setGoodsNo(goodsNo);
                    goodsPicture.setGoodsImg(img);
                    goodsPicture.setGoodsImgCode("");
                    goodsPicture.setSort(sort);
                    goodsPictureService.insert(goodsPicture);
                }
            }
            return response;
        }finally {
            lock.unlock();
        }

    }

    @Override
    public SuperResponse update(GoodsInfoRequest request) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SuperResponse response = new SuperResponse();
            TBizGoods goods = new TBizGoods();
            //TODO 商品编号生成需要修改 可使用redis,snowflake 等多种方案 可以自由选择 具体根据你的业务选型
            //TODO 这里选用最简单的时间参数+随机数生成 本方法适合对并发要求不高的 并发超过10 不建议使用
            goods.setGoodsId(request.getGoodsId());
            goods.setGoodsNo(request.getGoodsNo());
            goods.setGoodsName(request.getGoodsName());
            goods.setGoodsTitle(request.getGoodsName());
            goods.setCategoryId(request.getCategoryId());
            goods.setBrandId(request.getBrandId());
            goods.setGoodsImg(request.getGoodsImg());
            goods.setStatus(request.getStatus());
            goods.setSalesVol(0);
            goods.setStockVol(0);
            //TODO 使用百度图片识别功能 生成图片唯一标识
            goods.setGoodsImgCode("");

            goods.setMerchantNo(request.getMerchantNo());
            int rows = baseMapper.updateById(goods);
            if(0==rows){
                response.setMessage("添加失败!");
                response.setCode(-1000);
                return response;
            }

            //TODO 如果有多图
            if(StringUtils.isNotEmpty(request.getGoodsImgs())){
                goodsPictureService.deleteByGoodsNo(request.getGoodsNo());
                String imgs[] = request.getGoodsImgs().split(",");
                TBizGoodsPicture goodsPicture = null;
                int sort = 0;
                for(String img:imgs){
                    sort = sort+1;
                    //TODO 使用百度图片识别功能 生成图片唯一标识 然后保存
                    goodsPicture = new TBizGoodsPicture();
                    goodsPicture.setGoodsNo(request.getGoodsNo());
                    goodsPicture.setGoodsImg(img);
                    goodsPicture.setGoodsImgCode("");
                    goodsPicture.setSort(sort);
                    goodsPictureService.insert(goodsPicture);
                }
            }
            return response;
        }finally {
            lock.unlock();
        }
    }



    @Override
    public SuperResponse delete(GoodsRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<TBizGoods> wrapper = new QueryWrapper();
        wrapper.eq("goods_no",request.getGoodsNo());
        int rows = baseMapper.delete(wrapper);
        if(rows==0){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        goodsPictureService.deleteByGoodsNo(request.getGoodsNo());

        return response;
    }
}
