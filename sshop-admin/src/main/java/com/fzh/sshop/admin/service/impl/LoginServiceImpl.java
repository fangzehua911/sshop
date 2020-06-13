package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.UserMapper;
import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.admin.service.LoginService;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
        response.setToken("123");
        return response;
    }


}
