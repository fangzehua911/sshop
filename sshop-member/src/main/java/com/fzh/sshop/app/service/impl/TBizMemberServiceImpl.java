package com.fzh.sshop.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fzh.sshop.app.entity.TBizMember;
import com.fzh.sshop.app.entity.net.request.WeiXinLoginRequest;
import com.fzh.sshop.app.ifeign.IFOrderServcie;
import com.fzh.sshop.app.mapper.TBizMemberMapper;
import com.fzh.sshop.app.service.TBizMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-09
 */
@Service
public class TBizMemberServiceImpl extends ServiceImpl<TBizMemberMapper, TBizMember> implements TBizMemberService {

    @Autowired
    private IFOrderServcie ifOrderServcie;

    @Autowired
    private TBizMemberMapper tBizMemberMapper;

    @Override
    public List<TBizMember> list() {
        QueryWrapper<TBizMember> wrapper = new QueryWrapper();

        Page<TBizMember> page = new Page<>(1,2);
        IPage<Map<String, Object>> mapIPage = baseMapper.selectMapsPage(page, wrapper);
        System.out.println("总页数"+mapIPage.getPages());
        System.out.println("总记录数"+mapIPage.getTotal());
        List<Map<String, Object>> records = mapIPage.getRecords();
        records.forEach(System.out::println);

        List<TBizMember> list = baseMapper.selectList(wrapper);

        return page.getRecords();
    }


    @Override
    public int create(TBizMember member) {

        member = new TBizMember();
        member.setNickName("dddd");


        return baseMapper.insert(member);
    }


    @Override
    public String test(String name) {
        return ifOrderServcie.test(name);
    }


    @Override
    public String test2(WeiXinLoginRequest request) {
        return ifOrderServcie.test2(request);
    }

    @Override
    public String test3() {
        return tBizMemberMapper.getMembers(4);
    }
}
