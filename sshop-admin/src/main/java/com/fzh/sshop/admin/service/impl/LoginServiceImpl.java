package com.fzh.sshop.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fzh.sshop.admin.entity.User;
import com.fzh.sshop.admin.mapper.DeptMapper;
import com.fzh.sshop.admin.mapper.UserMapper;
import com.fzh.sshop.admin.req.LoginRequest;
import com.fzh.sshop.admin.service.LoginService;
import com.fzh.sshop.config.jwt.JWTUtil;
import com.fzh.sshop.request.SuperResponse;
import com.fzh.sshop.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private DeptMapper deptMapper;
    private static Long expireMillis = 60*60*1000L;

    @Override
    public SuperResponse userLogin(LoginRequest request) {
        SuperResponse response = new SuperResponse();

        //TODO 应为后台系统基本是内部使用, 简单的做了一个 验证码校验
        if(!redisUtil.hasKey("VCode:"+request.getVerifyCode().toUpperCase())){
            response.setCode(-2000);
            response.setMessage("验证码有误!");
            return response;
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", request.getAccount());
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
        //TODO 待优化
        response.setToken(JWTUtil.createJWT(expireMillis,user.getAccount()));
        user.setPassword(null);
        user.setDeptName(deptMapper.selectById(user.getDeptId()).getDeptName());
        response.setItem(user);
        return response;
    }


}
