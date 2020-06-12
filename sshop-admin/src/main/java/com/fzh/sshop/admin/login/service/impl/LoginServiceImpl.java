package com.fzh.sshop.admin.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fzh.sshop.admin.login.service.LoginService;
import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.admin.user.entity.User;
import com.fzh.sshop.admin.user.mapper.UserMapper;
import com.fzh.sshop.request.SuperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SuperResponse userLogin(LoginRequest request) {
        SuperResponse response = new SuperResponse();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", request.getAccount());
        User user = userMapper.selectOne(queryWrapper);
        if(null==user){
            response.setCode(-1001);
            response.setMessage("账号或密码错误");
            return response;
        }
        if(!request.getPassword().equals(user.getPassword())){
            response.setCode(-1002);
            response.setMessage("登录密码有误");
            return response;
        }
        response.setItem(user);
        return response;
    }


}
