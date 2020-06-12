package com.fzh.sshop.admin.user.service.impl;

import com.alibaba.nacos.common.utils.Md5Utils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.fzh.sshop.admin.req.admin.UserInfoRequest;
import com.fzh.sshop.admin.req.admin.UserListRequest;
import com.fzh.sshop.admin.user.entity.User;
import com.fzh.sshop.admin.user.mapper.UserMapper;
import com.fzh.sshop.admin.user.service.UserService;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.utils.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.LocalDate;
import java.time.LocalDateTime;
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


    @Override
    public SuperResponse find(String userId) {
        SuperResponse response = new SuperResponse();

        QueryWrapper<User> wrapper = new QueryWrapper();

        User user  = baseMapper.selectOne(wrapper.eq("user_id",userId));
        if(null==user){
            response.setMessage("用户不存在!");
            response.setCode(-1000);
            return response;
        }
        response.setItem(user);
        return response;
    }


    @Override
    @Transactional
    public SuperResponse insert(UserInfoRequest request) {
        SuperResponse response = new SuperResponse();

        try {
            String user_id = IdUtils.getUUID();
            User user = new User();
            user.setUserId(user_id);
            user.setUsername(request.getUsername());
            user.setPassword(Md5Utils.getMD5(request.getPassword(),"utf-8"));
            user.setDepId(request.getDepId());
            user.setMail(request.getMail());
            user.setStatus(request.getStatus());
            user.setTelephone(request.getTelephone());
            user.setRemark(request.getRemark());
            user.setCreateTime(LocalDateTime.now());
            user.setUpdateTime(LocalDateTime.now());
            String roles[] = request.getRoles().split(",");
            for(String role_id:roles){
                //TODO 角色赋权
            }

            baseMapper.insert(user);

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return response;
    }


    @Override
    public SuperResponse update(UserInfoRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("user_id",request.getUserId());
        try {
            User user = new User();
            user.setUserId(request.getUserId());
            user.setUsername(request.getUsername());
            //user.setPassword(Md5Utils.getMD5(request.getPassword(),"utf-8"));
            user.setDepId(request.getDepId());
            user.setMail(request.getMail());
            user.setStatus(request.getStatus());
            user.setTelephone(request.getTelephone());
            user.setRemark(request.getRemark());
            user.setUpdateTime(LocalDateTime.now());
            String roles[] = request.getRoles().split(",");
            for(String role_id:roles){
                //TODO 角色赋权
            }

            baseMapper.update(user,wrapper);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return response;
    }


    @Override
    public SuperResponse delete(String userId) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> wrapper = new QueryWrapper();
        int  rows = baseMapper.delete(wrapper.eq("user_id",userId));
        if(rows==0){
            response.setMessage("删除失败");
            response.setCode(-1000);
            return response;
        }
        return response;
    }


}
