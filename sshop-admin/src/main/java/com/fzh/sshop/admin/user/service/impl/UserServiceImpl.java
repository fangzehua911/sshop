package com.fzh.sshop.admin.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.fzh.sshop.admin.req.admin.UserListRequest;
import com.fzh.sshop.admin.user.entity.User;
import com.fzh.sshop.admin.user.mapper.UserMapper;
import com.fzh.sshop.admin.user.service.UserService;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fang
 * @since 2020-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public SuperResponse userList(UserListRequest request) {
        SuperResponse response = new SuperResponse();

        QueryWrapper<User> wrapper = new QueryWrapper();

        Page<User> pages = new Page<>(request.getPageNo(),request.getPageSize());

        IPage<User> mapIPage = baseMapper.selectPage(pages, wrapper);

        response.setItems(mapIPage.getRecords());
        response.setTotals(mapIPage.getTotal());
        return response;
    }
}
